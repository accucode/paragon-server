package com.app.ui.page.manage.crud;

import java.util.function.Consumer;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.types.KmTuple;

import com.app.dao.base.MyDaoAccess;
import com.app.model.core.MyUidDomainIF;
import com.app.utility.MyGlobals;

/**
 * I display a list of children, and coordinate the ability to
 * ADD, EDIT, and VIEW those children.
 *
 * I am intended for cases where screen space is more limited.
 * When a child is selected from the list, the list view is replaced
 * by the child view.  Thus resulting in the appearance of a double (2)
 * panel to the user.
 *
 * @param <P> The PARENT, used to get the list.
 * @param <C> The CHILD, the selected list item.
 */
public class MyCrudManageView<P extends MyUidDomainIF, C extends MyUidDomainIF>
    extends ScDiv
{
    //##################################################
    //# variables
    //##################################################

    private MyCrudBuilder<P,C>      _crudBuilder;

    private ScLocalString           _domainParentUid;
    private ScLocalString           _domainChildUid;

    /**
     * A collapsed group with no content that is displayed
     * when the search view is collapsed. This contains
     * a button to show the full search view.
     */
    private ScGroup                 _collapsedView;

    private MyCrudSearchViewIF<P,C> _searchView;
    private MyCrudFrame<P,C>        _frame;

    private Consumer<C>             _selectListener;

    //##################################################
    //# constructor
    //##################################################

    public MyCrudManageView(MyCrudBuilder<P,C> e)
    {
        _crudBuilder = e;

        installVariables();

        ScDiv root;
        root = this;
        root.css().flexRow();
        root.add(createCollapsedView());
        root.add(createSearchView());
        root.add(createFrame());
    }

    protected final MyCrudBuilder<P,C> getCrudBuilder()
    {
        return _crudBuilder;
    }

    //##################################################
    //# install
    //##################################################

    private void installVariables()
    {
        _domainParentUid = new ScLocalString();
        _domainParentUid.setAutoSave();

        _domainChildUid = new ScLocalString();
        _domainChildUid.setAutoSave();
    }

    private ScControl createCollapsedView()
    {
        ScGroup group;
        group = new ScGroup();
        group.setFlavorSecondary();
        group.css().marginRight20();
        group.installExpandButton(this::handleExpand);
        group.hide();
        _collapsedView = group;

        return group;
    }

    private ScControl createSearchView()
    {
        MyCrudSearchViewIF<P,C> e;
        e = getCrudBuilder().getSearchView();
        e.onRefresh(this::handleRefresh);
        e.onAdd(this::handleAdd);
        e.onSelect(this::handleSelect);
        e.css().flexChildBasis0().flexChildPhiSmall().marginRight20();
        e.installShrinkButton(this::handleShrink);

        _searchView = e;
        return e.asControl();
    }

    private ScControl createFrame()
    {
        MyCrudFrame<P,C> e;
        e = getCrudBuilder().getFrame();
        e.setShowsViewOnEditSaved(false);
        e.setShowsMessageOnDeleted(false);
        e.onAddSaved(this::handleAddSaved);
        e.onEditSaved(this::handleEditSaved);
        e.onDeleted(this::handleDeleted);
        e.onAddCancelled(this::handleAddCancelled);
        e.onChildChanged(this::handleChildChanged);
        e.onChildListChanged(this::handleChildListChanged);
        e.onListRefresh(this::handleListRefresh);
        e.css().flexChildBasis0().flexChildPhiLarge();
        _frame = e;
        return e;
    }

    //##################################################
    //# listener :: selected
    //##################################################

    public final void onSelected(Consumer<C> e)
    {
        _selectListener = e;
    }

    private void fireSelected(C e)
    {
        fire(_selectListener, e);
    }

    //##################################################
    //# domain
    //##################################################

    /**
     * A convenience method to set the domain parent and/or child.
     * At least one of the parameters must be non-null.
     * If both are provided, they must match.
     */
    public final void setDomain(P parent, C child)
    {
        KmTuple<P,C> result = getCrudBuilder().reconcileParentChild(parent, child);
        String parentUid = MyUidDomainIF.getUidFor(result.getKey());
        String childUid = MyUidDomainIF.getUidFor(result.getValue());

        _domainParentUid.setValue(parentUid);
        _domainChildUid.setValue(childUid);

        _searchView.setDomain(parent, child);
        _frame.setDomainChild(child);
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
    public final void setDomainParent(P parent)
    {
        setDomain(parent, null);
    }

    public boolean hasDomainParent(P e)
    {
        return getDomainParent() == e;
    }

    //==================================================
    //= domain :: child
    //==================================================

    public final C getDomainChild()
    {
        return getCrudBuilder().findChild(_domainChildUid);
    }

    public final String getDomainChildUid()
    {
        return hasDomainChild()
            ? getDomainChild().getUid()
            : null;
    }

    /**
     * Set the list to a specific child selection.
     * The child must be non-NULL, and is used to infer the parent.
     * If you don't a specific child, use setDomainParent instead.
     * You should NOT call both setDomainParent and setDomainChild.
     */
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
    protected boolean applyFromModel_here(Object model, boolean skipFields)
    {
        super.applyFromModel_here(model, skipFields);

        @SuppressWarnings("unchecked")
        P parent = (P)model;

        if ( !hasDomainParent(parent) )
            setDomainParent(parent);

        return false;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected final void preRender()
    {
        super.preRender();

        if ( hasDomainChild() )
            _frame.setDefaultViewCard(getDomainChild());
        else
            _frame.setDefaultMessageCard();
    }

    //##################################################
    //# handle :: select
    //##################################################

    private void handleSelect(C child)
    {
        if ( child == null )
        {
            _domainChildUid.clearValue();
            _frame.ajaxPrintMessage();
        }
        else
        {
            _domainChildUid.setValue(child.getUid());
            _frame.ajaxPrintView(child);
        }

        fireSelected(child);
    }

    //==================================================
    //= handle :: refresh
    //==================================================

    private void handleRefresh()
    {
        _frame.ajaxPrintMessage();
    }

    //==================================================
    //= handle :: add
    //==================================================

    private void handleAdd()
    {
        _frame.ajaxPrintAdd(getDomainParent());
    }

    private void handleAddSaved(C c, boolean more)
    {
        _searchView.handleAddSaved(c, more);

        if ( !more )
            fireSelected(c);
    }

    private void handleEditSaved(C c)
    {
        P p = getCrudBuilder().getParentFor(c);
        if ( p == getDomainParent() )
        {
            _frame.ajaxPrintView(c);
            _searchView.handleEditSaved(c);
            return;
        }

        handleDeleted(c);
    }

    private void handleDeleted(C c)
    {
        _searchView.handleDeleted(c);
        _frame.ajaxPrintMessage();
    }

    private void handleAddCancelled()
    {
        _frame.ajaxPrintMessage();
    }

    //==================================================
    //= handle :: child changed
    //==================================================

    private void handleChildChanged(C c)
    {
        _searchView.handleChildChanged(c);
    }

    private void handleChildListChanged(C c)
    {
        _searchView.handleChildListChanged(c);
    }

    //==================================================
    //= handle :: list refresh
    //==================================================

    public void handleListRefresh()
    {
        _searchView.ajaxRefreshList();
    }

    //==================================================
    //= handle :: collapse
    //==================================================

    private void handleExpand()
    {
        _collapsedView.ajaxHide();
        _searchView.ajaxShow();
    }

    private void handleShrink()
    {
        _searchView.ajaxHide();
        _collapsedView.ajaxShow();
    }

    //##################################################
    //# testing
    //##################################################

    public boolean hasViewCard(Object e)
    {
        return _frame.getViewCard() == e;
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

    protected int getDepth()
    {
        int i = 1;
        ScControl c = this;

        while ( true )
        {
            c = c.getParent();

            if ( c == null )
                return i;

            if ( c instanceof MyCrudManageView )
                i++;
        }
    }
}
