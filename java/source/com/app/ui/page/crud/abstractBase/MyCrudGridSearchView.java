package com.app.ui.page.crud.abstractBase;

import java.util.function.Consumer;

import com.kodemore.collection.KmList;
import com.kodemore.domain.KmUidDomainIF;
import com.kodemore.filter.KmFilterIF;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGrid;
import com.kodemore.servlet.control.ScGridGroup;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScSpacedRow;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.types.KmTuple;
import com.kodemore.utility.KmSimpleResult;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoAccess;
import com.app.utility.MyGlobals;

/**
 * I display a list of child models with basic client side filtering.
 * This search view is suitable for situations where we expect a reasonable
 * short list of models.  100s of children are likely fine, but 1000s will
 * result is slow response times or may crash the client browser.
 *
 * @param <P> The PARENT, used to get the list.
 * @param <C> The CHILD, the selected list item.
 */
public abstract class MyCrudGridSearchView<P extends KmUidDomainIF, C extends KmUidDomainIF>
    extends ScDiv
    implements MyCrudSearchViewIF<P,C>
{
    //##################################################
    //# variables
    //##################################################

    private MyCrudBuilder<P,C> _crudBuilder;

    private ScLocalString _domainParentUid;
    private ScLocalString _domainChildUid;

    private ScGroup        _filterGroup;
    private ScForm         _filterForm;
    private ScDiv          _filterContainer;
    private ScActionButton _addButton;

    private ScGridGroup<C> _gridGroup;
    private ScGrid<C>      _grid;

    private Runnable    _addListener;
    private Runnable    _refreshListener;
    private Consumer<C> _selectListener;

    //##################################################
    //# constructor
    //##################################################

    public MyCrudGridSearchView(MyCrudBuilder<P,C> e)
    {
        _crudBuilder = e;

        installUids();
        installLayout();
    }

    protected MyCrudBuilder<P,C> getCrudBuilder()
    {
        return _crudBuilder;
    }

    //##################################################
    //# install
    //##################################################

    private void installUids()
    {
        _domainParentUid = new ScLocalString();
        _domainParentUid.setAutoSave();

        _domainChildUid = new ScLocalString();
        _domainChildUid.setAutoSave();
    }

    private void installLayout()
    {
        ScDiv root;
        root = this;
        root.css().flexColumn();

        installFilterOn(root);
        installGridOn(root);
    }

    //==================================================
    //= install :: filter
    //==================================================

    private void installFilterOn(ScDiv root)
    {
        String title = Kmu.pluralize(getCrudBuilder().getChildLabel());

        ScForm filterForm;
        filterForm = root.addForm();
        filterForm.onSubmit(newUncheckedAction(this::handleSearch));
        _filterForm = filterForm;

        ScGroup group;
        group = filterForm.addGroup(title);
        group.setFlavorList();
        group.css().marginBottom20();
        _filterGroup = group;

        installFilterButtonsOn(group);

        ScDiv body;
        body = group.getBody();
        body.css().auto();

        ScDiv content;
        content = body.addDiv();
        content.css().pad10();
        _filterContainer = content;

        installFilterFieldsOn(content);
    }

    private void installFilterButtonsOn(ScGroup group)
    {
        ScSpacedRow row;
        row = group.showHeader().addSpacedRow();
        row.css().pad();

        ScDiv left;
        left = row.getLeft();
        left.addSearchButton();
        left.addButton("Clear", newCheckedAction(this::handleClear)).css().marginLeft5();

        ScDiv right;
        right = row.getRight();
        _addButton = right.addAddButton(newCheckedAction(this::handleAdd));
        _addButton.hide();
    }

    protected abstract void installFilterFieldsOn(ScDiv root);

    /**
     * This contains the filter fields.
     * This provides a convenient way for subclasses to use grid.trackAll().
     */
    protected ScContainer getFilterContainer()
    {
        return _filterContainer;
    }

    //==================================================
    //= install :: grid
    //==================================================

    private void installGridOn(ScDiv col)
    {
        ScGrid<C> grid = createGrid();

        ScGridGroup<C> group;
        group = col.addGroup("Results", grid);
        group.css().flexChildFiller();
        _gridGroup = group;
    }

    private ScGrid<C> createGrid()
    {
        ScGrid<C> e;
        e = new ScGrid<>();
        e.layoutFill();
        e.track(_domainParentUid);
        e.track(_domainChildUid);
        e.setFilterFactory(this::getGridFilter);

        installGridOn(e);
        _grid = e;
        return e;
    }

    protected abstract void installGridOn(ScGrid<C> grid);

    protected abstract KmFilterIF<C> getGridFilter();

    //==================================================
    //= install :: collapse
    //==================================================

    @Override
    public void installCollapseButton(Runnable runnable)
    {
        _filterGroup.installCollapseButton(runnable);
    }

    //##################################################
    //# listeners :: refresh
    //##################################################

    @Override
    public final void onRefresh(Runnable e)
    {
        _refreshListener = e;
    }

    private void fireRefresh()
    {
        fire(_refreshListener);
    }

    //==================================================
    //= listeners :: add
    //==================================================

    @Override
    public final void onAdd(Runnable e)
    {
        _addListener = e;
    }

    private void fireAdd()
    {
        fire(_addListener);
    }

    //==================================================
    //= listeners :: select
    //==================================================

    @Override
    public final void onSelect(Consumer<C> e)
    {
        _selectListener = e;
    }

    protected void fireSelect(C e)
    {
        fire(_selectListener, e);
    }

    //==================================================
    //= listeners :: convenience
    //==================================================

    private void fireSelectOrRefresh()
    {
        KmList<C> v = getGridFilter().findFirst(2);
        if ( v.isSingleton() )
            fireSelect(v.getFirst());
        else
            fireRefresh();
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected final void preRender()
    {
        super.preRender();

        P parent = getDomainParent();
        boolean allowsAdd = getCrudBuilder().showsAddFor(parent);
        if ( allowsAdd )
            _addButton.show();
    }

    //##################################################
    //# handle :: internal
    //##################################################

    private void handleAdd()
    {
        P parent = getDomainParent();
        MyCrudBuilder<P,C> b = getCrudBuilder();
        KmSimpleResult r = b.allowsAddFor(parent);

        if ( r.hasError() )
        {
            b.showCannotAddDialog(r);
            return;
        }

        fireAdd();
    }

    private void handleSearch()
    {
        _filterForm.saveFieldValues();
        _filterForm.ajaxUpdateFieldValues();

        ajaxRefreshList();
        fireSelectOrRefresh();
    }

    private void handleClear()
    {
        _filterForm.resetFieldValues();
        _filterForm.saveFieldValues();
        _filterForm.ajaxUpdateFieldValues();

        ajaxRefreshList();
        fireSelectOrRefresh();
    }

    //==================================================
    //= handle :: external
    //==================================================

    @Override
    public void handleAddSaved(MyCrudSaveEvent<C> e)
    {
        ajaxRefreshList(false);
    }

    @Override
    public void handleEditSaved(C c)
    {
        ajaxRefreshList(false);
    }

    @Override
    public void handleDeleted(C c)
    {
        ajaxRefreshList(false);
    }

    @Override
    public void handleChildChanged(C child)
    {
        ajaxRefreshList(false);
    }

    @Override
    public void handleChildListChanged(C child)
    {
        ajaxRefreshList(false);
    }

    //##################################################
    //# domain
    //##################################################

    /**
     * A convenience method to set the domain parent and/or child.
     * At least one of the parameters must be non-null.
     * If both are provided, they must match.
     */
    @Override
    public final void setDomain(P parent, C child)
    {
        KmTuple<P,C> result = getCrudBuilder().reconcileParentChild(parent, child);
        String parentUid = KmUidDomainIF.getUidFor(result.getKey());
        String childUid = KmUidDomainIF.getUidFor(result.getValue());

        _domainParentUid.setValue(parentUid);
        _domainChildUid.setValue(childUid);
    }

    //==================================================
    //= domain :: parent
    //==================================================

    public final P getDomainParent()
    {
        return getCrudBuilder().findParent(_domainParentUid);
    }

    /**
     * Set the list to a specific parent.
     * The list of children are inferred from the parent.
     * If you want to select a specific child, use setDomainChild instead.
     * You should NOT call both setDomainParent and setDomainChild.
     */
    @Override
    public final void setDomainParent(P parent)
    {
        setDomain(parent, null);
    }

    //==================================================
    //= domain :: child
    //==================================================

    public final C getDomainChild()
    {
        return getCrudBuilder().findChild(_domainChildUid);
    }

    /**
     * Set the list to a specific child selection.
     * The child must be non-NULL, and is used to infer the parent.
     * If you don't a specific child, use setDomainParent instead.
     * You should NOT call both setDomainParent and setDomainChild.
     */
    @Override
    public final void setDomainChild(C child)
    {
        setDomain(null, child);
    }

    public final boolean hasDomainChild()
    {
        return getDomainChild() != null;
    }

    //##################################################
    //# ui downcast
    //##################################################

    @Override
    protected final boolean applyFromModel_here(Object model)
    {
        @SuppressWarnings("unchecked")
        P parent = (P)model;

        setDomainParent(parent);
        return false;
    }

    //##################################################
    //# ajax
    //##################################################

    @Override
    public void ajaxRefreshList()
    {
        ajaxRefreshList(true);
    }

    public void ajaxRefreshList(boolean gotoFirstPage)
    {
        _gridGroup.ajaxRefreshBanner();
        _grid.ajaxReload(gotoFirstPage);
    }

    //##################################################
    //# support
    //##################################################

    protected final MyGlobals getGlobals()
    {
        return MyGlobals.instance;
    }

    protected final MyDaoAccess getAccess()
    {
        return getGlobals().getAccess();
    }
}
