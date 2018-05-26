package com.app.ui.page.crud.abstractBase;

import java.util.function.Consumer;

import com.kodemore.domain.KmUidDomainIF;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.types.KmTuple;

import com.app.dao.base.MyDaoAccess;
import com.app.utility.MyGlobals;

/**
 * I display the list of children, and coordinate the ability to
 * SEARCH, VIEW, ADD, and EDIT those children.
 *
 * The list/search panel is displayed on the left, and the selected
 * child is displayed on the right. To modify a child, the view panel
 * is swapped with and add/edit panel.
 *
 * @param <P> The PARENT, used to get the list.
 * @param <C> The CHILD, the selected list item.
 */
public class MyCrudListView<P extends KmUidDomainIF, C extends KmUidDomainIF>
    extends ScDiv
{
    //##################################################
    //# variables
    //##################################################

    private MyCrudBuilder<P,C> _crudBuilder;

    private ScLocalString _domainParentUid;
    private ScLocalString _domainChildUid;

    /**
     * A collapsed group with no content that is displayed
     * when the search view is collapsed. This contains
     * a button to show the full search view.
     */
    private ScGroup _collapsedView;

    /**
     * The view used to search the list of children within
     * the single parent.
     */
    private MyCrudSearchViewIF<P,C> _searchView;

    /**
     * The frame that swaps between the various child panels for:
     * view, add, edit, audit, etc.
     */
    private MyCrudFrame<P,C> _frame;

    /**
     * Allows a client to take action when the child selection
     * is changed.
     */
    private Consumer<C> _selectListener;

    /**
     * Allows a client to take action when the child or the child
     * list has changed.
     */
    private Consumer<C> _childChangedListener;

    /**
     * Allows a client to take action when the search view
     * is expanded or collapsed.
     */
    private Consumer<Boolean> _expandedListener;

    //##################################################
    //# constructor
    //##################################################

    public MyCrudListView(MyCrudBuilder<P,C> e)
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

    protected MyCrudBuilder<P,C> getCrudBuilder()
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
        group.setFlavorList();
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
        e.css().crud_search();
        e.onRefresh(this::handleRefresh);
        e.onAdd(this::handleAdd);
        e.onSelect(this::handleSelect);
        e.installCollapseButton(this::handleCollapse);
        _searchView = e;
        return e.asControl();
    }

    private ScControl createFrame()
    {
        MyCrudFrame<P,C> e;
        e = getCrudBuilder().getFrame();
        e.css().crud_frame();
        e.setShowsViewOnEditSaved(false);
        e.setShowsMessageOnDeleted(false);
        e.onAddSaved(this::handleAddSaved);
        e.onEditSaved(this::handleEditSaved);
        e.onDeleted(this::handleDeleted);
        e.onAddCancelled(this::handleAddCancelled);
        e.onChildChanged(this::handleChildChanged);
        e.onChildListChanged(this::handleChildListChanged);
        e.onListRefresh(this::handleListRefresh);
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
    //# listener :: expand
    //##################################################

    public final void onExpanded(Consumer<Boolean> e)
    {
        _expandedListener = e;
    }

    private void fireExpanded(boolean e)
    {
        fire(_expandedListener, e);
    }

    //##################################################
    //# listener :: child changed
    //##################################################

    public void onChildChanged(Consumer<C> e)
    {
        _childChangedListener = e;
    }

    private void fireChildChanged(C e)
    {
        fire(_childChangedListener, e);
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
        String parentUid = KmUidDomainIF.getUidFor(result.getKey());
        String childUid = KmUidDomainIF.getUidFor(result.getValue());

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

    public final void setSingleDomainChild(C child)
    {
        setDomainChild(child);
        _collapsedView.show();
        _searchView.hide();
        _frame.setDefaultViewCard(child);
    }

    //##################################################
    //# ui downcast
    //##################################################

    @Override
    protected boolean applyFromModel_here(Object model)
    {
        super.applyFromModel_here(model);

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

        if ( !_frame.hasDefaultCard() )
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
            ajaxPrintMessage();
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
        ajaxPrintMessage();
    }

    //==================================================
    //= handle :: add
    //==================================================

    protected void handleAdd()
    {
        _frame.ajaxPrintAdd(getDomainParent());
    }

    private void handleAddSaved(MyCrudSaveEvent<C> ev)
    {
        C c = ev.getChild();
        boolean more = ev.getAddMore();

        _searchView.handleAddSaved(ev);

        if ( !more )
            fireSelected(c);

        fireChildChanged(c);
    }

    private void handleAddCancelled()
    {
        ajaxPrintMessage();
    }

    /**
     * A hook to insert and select an child that was added outside of
     * the crud add view.
     */
    public void handleExternalAdd(C c)
    {
        MyCrudSaveEvent<C> ev;
        ev = new MyCrudSaveEvent<>(c);

        handleAddSaved(ev);
        handleSelect(c);
    }

    //==================================================
    //= handle :: edit
    //==================================================

    private void handleEditSaved(C c)
    {
        P p = getCrudBuilder().getParentFor(c);
        if ( p == getDomainParent() )
        {
            _frame.ajaxPrintView(c);
            _searchView.handleEditSaved(c);
            fireChildChanged(c);
            return;
        }

        handleDeleted(c);
    }

    //==================================================
    //= handle :: delete
    //==================================================

    private void handleDeleted(C c)
    {
        _searchView.handleDeleted(c);
        ajaxPrintMessage();
    }

    //==================================================
    //= handle :: child changed
    //==================================================

    private void handleChildChanged(C c)
    {
        _searchView.handleChildChanged(c);
        fireChildChanged(c);
    }

    private void handleChildListChanged(C c)
    {
        _searchView.handleChildListChanged(c);
        fireChildChanged(c);
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

        fireExpanded(true);
    }

    private void handleCollapse()
    {
        _searchView.ajaxHide();
        _collapsedView.ajaxShow();

        fireExpanded(false);
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

            if ( c instanceof MyCrudListView )
                i++;
        }
    }

    protected void ajaxPrintMessage()
    {
        _frame.ajaxPrintMessage();
    }
}
