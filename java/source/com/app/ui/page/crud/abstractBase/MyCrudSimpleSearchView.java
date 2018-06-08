package com.app.ui.page.crud.abstractBase;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import com.kodemore.collection.KmList;
import com.kodemore.domain.KmUidDomainIF;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScSimpleModelList;
import com.kodemore.servlet.control.ScTextSpan;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.types.KmTuple;
import com.kodemore.utility.KmSimpleResult;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoAccess;
import com.app.utility.MyGlobals;

/**
 * I display a list of child models with basic client side filtering.
 * This search view is suitable for situations where we expect a reasonable
 * short list of models.  100s of childre are likely fine, but 1000s will
 * result is slow response times or may crash the client browser.
 *
 * @param <P> The PARENT, used to get the list.
 * @param <C> The CHILD, the selected list item.
 */
public abstract class MyCrudSimpleSearchView<P extends KmUidDomainIF, C extends KmUidDomainIF>
    extends ScGroup
    implements MyCrudSearchViewIF<P,C>
{
    //##################################################
    //# variables
    //##################################################

    private MyCrudBuilder<P,C> _crudBuilder;

    private ScLocalString _domainParentUid;
    private ScLocalString _domainChildUid;

    private ScTextField          _filterField;
    private ScSimpleModelList<C> _list;

    private ScActionButton _addButton;
    private Runnable       _addListener;
    private Runnable       _refreshListener;
    private Consumer<C>    _selectListener;

    //##################################################
    //# constructor
    //##################################################

    public MyCrudSimpleSearchView(MyCrudBuilder<P,C> e)
    {
        _crudBuilder = e;

        installUids();

        ScGroup group;
        group = this;
        group.setFlavorDetail();

        installBannerOn(group);
        installFilterOn(group);
        installListOn(group);

    }

    protected final MyCrudBuilder<P,C> getCrudBuilder()
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

    //==================================================
    //= install :: banner
    //==================================================

    private void installBannerOn(ScGroup group)
    {
        group.setTitle(getPluralDomainName());
    }

    //==================================================
    //= install :: list filter
    //==================================================

    private void installFilterOn(ScGroup group)
    {
        ScDiv header;
        header = group.showHeader();

        ScForm form;
        form = header.addForm();

        ScDiv div;
        div = form.addDiv();
        div.css().flexRow().flexAlignSpaced();
        div.css().flexChildStatic();

        installFilterLeftOn(div);
        installFilterRightOn(div);
    }

    private void installFilterLeftOn(ScDiv root)
    {
        ScDiv row;
        row = root.addDiv();
        row.css().flexRow().flexCrossAlignCenter();
        row.css().flexChildFiller();
        row.css().pad().overflowHidden();

        ScTextSpan span;
        span = row.addTextSpan("Find");
        span.css().bold().flexChildStatic();

        row.addSpace();

        _filterField = row.addTextField();
        _filterField.disableChangeTracking();
        _filterField.layoutInline(175);

        row.addSpace();
    }

    private void installFilterRightOn(ScDiv root)
    {
        ScDiv right;
        right = root.addButtonBox();
        right.css().flexChildStatic();
        right.addRefreshButton(newCheckedAction(this::handleRefresh));

        _addButton = right.addAddButton(newCheckedAction(this::handleAdd));
        _addButton.setFlavorIcon();
        _addButton.hide();
    }

    //==================================================
    //= install :: list
    //==================================================

    private void installListOn(ScGroup group)
    {
        ScDiv body;
        body = group.getBody();
        body.add(createList());
    }

    private ScSimpleModelList<C> createList()
    {
        ScAction selectAction = newCheckedAction(this::handleSelect);

        MyCrudBuilder<P,C> b = getCrudBuilder();
        Function<C,String> title = b.getChildTitleFunction();
        Predicate<C> active = b.getChildEnabled();
        Function<C,String> subtitle = b.getChildSubtitleFunction();
        Function<C,String> errorFn = b.getChildErrorFunction();

        ScSimpleModelList<C> list;
        list = new ScSimpleModelList<>();
        list.css().fill();
        list.setKeyFunction(KmUidDomainIF.getUidAdaptor());
        list.setTitleFunction(title);
        list.setEnabled(active);
        list.setSubtitleFunction(subtitle);
        list.setErrorFunction(errorFn);
        list.setItemAction(selectAction);
        list.installFilterOn(_filterField);
        _list = list;
        return list;
    }

    //##################################################
    //# refresh listener
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

    //##################################################
    //# add listener
    //##################################################

    @Override
    public final void onAdd(Runnable e)
    {
        _addListener = e;
    }

    private void fireAdd()
    {
        fire(_addListener);
    }

    //##################################################
    //# select listener
    //##################################################

    @Override
    public final void onSelect(Consumer<C> e)
    {
        _selectListener = e;
    }

    private void fireSelect(C e)
    {
        fire(_selectListener, e);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected final void preRender()
    {
        super.preRender();

        _list.setValues(getDomainChildren());
        _list.setInitialSelection(getDomainChild());
        _list.setInitialFilter(_filterField.getValue());

        P parent = getDomainParent();
        boolean allowsAdd = getCrudBuilder().showsAddFor(parent);
        if ( allowsAdd )
            _addButton.show();
    }

    //##################################################
    //# handle :: internal
    //##################################################

    private void handleRefresh()
    {
        ajaxRefresh();
        fireRefresh();
    }

    private void handleSelect()
    {
        String uid = getData().getStringArgument();

        C e = getCrudBuilder().findChild(uid);
        if ( e == null )
        {
            ajaxToast("Invalid Uid: " + uid);
            return;
        }

        _filterField.saveValue();
        ajaxSelectDomain(e);
        fireSelect(e);
    }

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

        _filterField.saveValue();
        _list.ajaxClearSelection();
        fireAdd();
    }

    //==================================================
    //= handle :: external
    //==================================================

    @Override
    public void handleAddSaved(MyCrudSaveEvent<C> e)
    {
        C c = e.getChild();
        boolean more = e.getAddMore();
        boolean updateList = e.getUpdateList();

        if ( updateList )
            ajaxRefresh();
        else
            ajaxInsertIntoList(c);

        if ( !more )
            ajaxUpdateListSelection(c);
    }

    @Override
    public void handleEditSaved(C c)
    {
        ajaxRefreshDomain(c);
        ajaxUpdateListSelection(c);
    }

    @Override
    public void handleDeleted(C c)
    {
        ajaxRemoveFromList(c);
    }

    @Override
    public void handleChildChanged(C c)
    {
        ajaxRefreshDomain(c);
        ajaxUpdateListSelection(c);
    }

    @Override
    public void handleChildListChanged(C c)
    {
        ajaxRefresh();
        ajaxUpdateListSelection(c);
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

    /**
     * Get the list of childred, sorted with the strikeouts at the bottom.
     */
    private KmList<C> getDomainChildren()
    {
        MyCrudBuilder<P,C> builder = getCrudBuilder();
        KmList<C> unsorted = getChildrenFor(getDomainParent());
        Predicate<C> active = builder.getChildEnabled();

        if ( active == null )
            return unsorted;

        KmList<C> sorted;
        sorted = new KmList<>();
        sorted.addAll(unsorted.select(active));
        sorted.addAll(unsorted.select(active.negate()));
        return sorted;
    }

    protected abstract KmList<C> getChildrenFor(P parent);

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
        super.applyFromModel_here(model);

        @SuppressWarnings("unchecked")
        P parent = (P)model;

        setDomainParent(parent);
        return false;
    }

    //##################################################
    //# ajax
    //##################################################

    private void ajaxSelectDomain(C e)
    {
        _domainChildUid.setValue(e.getUid());
        ajaxUpdateListSelection(e);
    }

    public void ajaxUpdateListSelection(C e)
    {
        _list.ajaxScrollTo(e);
        _list.ajaxSelect(e);
    }

    private void ajaxRefresh()
    {
        _filterField.clearValue();
        _filterField.saveValue();
        _filterField.ajaxClearFieldValue();
        _filterField.ajaxReplace();

        _list.ajaxSetValues(getDomainChildren());
        _list.ajaxClearSelection();
        _list.ajaxScrollToTop();
    }

    @Override
    public void ajaxRefreshList()
    {
        ajaxRefresh();
    }

    @Override
    public void ajaxRefreshListItems()
    {
        _list.ajaxRefreshAll(getDomainChildren());
    }

    private void ajaxRefreshDomain(C e)
    {
        _list.ajaxRefresh(e);
    }

    private void ajaxInsertIntoList(C e)
    {
        KmList<C> v = getDomainChildren();
        C prev = v.getPreviousSafe(e);

        if ( prev == null )
            _list.ajaxPrependValue(e);
        else
            _list.ajaxInsertAfter(e, prev);
    }

    private void ajaxRemoveFromList(C e)
    {
        _list.ajaxRemoveValue(e);
    }

    //##################################################
    //# convenience
    //##################################################

    protected final MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

    //##################################################
    //# support
    //##################################################

    private String getPluralDomainName()
    {
        String name = getCrudBuilder().getChildLabel();
        return Kmu.pluralize(name);
    }
}
