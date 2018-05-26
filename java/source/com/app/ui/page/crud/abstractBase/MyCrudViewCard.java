package com.app.ui.page.crud.abstractBase;

import java.util.function.Consumer;
import java.util.function.Function;

import com.kodemore.domain.KmUidDomainIF;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPopupMenu;
import com.kodemore.servlet.control.ScPopupMenuItem;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.KmSimpleResult;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoAccess;
import com.app.model.MyUser;
import com.app.ui.control.MySummaryView;
import com.app.utility.MyGlobals;

/**
 * I provide common functionality for VIEWING a single domain.
 *
 * The domain PARENT is NOT specified, since it is not needed for editing.
 * @param <C> The domain CHILD.
 */
// todo_wyatt: z refactor view cards
public abstract class MyCrudViewCard<C extends KmUidDomainIF>
    extends ScGroup
{
    //##################################################
    //# variables
    //##################################################

    private MyCrudBuilder<?,C> _crudBuilder;

    private ScLocalString _domainChildUid;

    private Consumer<C> _editListener;
    private Consumer<C> _deleteListener;
    private Consumer<C> _auditLogListener;

    private Consumer<C> _childChangedListener;
    private Consumer<C> _childListChangedListener;

    //==================================================
    //= layout
    //==================================================

    /**
     * The group that surrounds the entire content.
     */
    public ScGroup _group;

    private MySummaryView<C> _summaryView;

    //==================================================
    //= nav buttons
    //==================================================

    /**
     * When clicked, display the edit view.
     * This is hidden by default, and only displayed if editing is allowed.
     */
    private ScActionButton _editButton;

    /**
     * When clicked, display the Delete Card.
     * This is hidden by default, and only displayed if deletion is allowed.
     */
    private ScActionButton _deleteButton;

    //==================================================
    //= popout
    //==================================================

    /**
     * When clicked, open the child in a new browser tab.
     * This is only displayed if the builder defines getChildPopoutUrl().
     */
    private ScActionButton _popoutButton;

    //==================================================
    //= menu
    //==================================================

    private ScPopupMenuItem _editMenuItem;
    private ScPopupMenuItem _deleteMenuItem;

    //##################################################
    //# constructor
    //##################################################

    public MyCrudViewCard(MyCrudBuilder<?,C> e)
    {
        _crudBuilder = e;

        installUids();
        installGroup();
    }

    protected MyCrudBuilder<?,C> getCrudBuilder()
    {
        return _crudBuilder;
    }

    //##################################################
    //# install
    //##################################################

    private void installUids()
    {
        _domainChildUid = new ScLocalString();
        _domainChildUid.setAutoSave();
    }

    private void installGroup()
    {
        ScGroup group;
        group = this;
        group.setFlavorSummary();
        group.css().flexColumn();
        _group = group;

        installBannerOn(group);
        installHeaderOn(group);
        installBodyOn(group.getBody());
        installFooterOn(group);
    }

    //==================================================
    //= install :: banner
    //==================================================

    private void installBannerOn(ScGroup group)
    {
        group.setTitle(getCrudBuilder().getChildLabel());
    }

    private void installHeaderOn(ScGroup group)
    {
        MyCrudBuilder<?,C> b = getCrudBuilder();
        Function<C,String> title = b.getChildTitleFunction();
        Function<C,String> subtitle = b.getChildSubtitleFunction();

        ScDiv header;
        header = group.showHeader();

        MySummaryView<C> view;
        view = header.add(new MySummaryView<>());
        view.css().flexChildStatic();
        view.setTitle(title);
        view.setSubtitle1(subtitle);
        _summaryView = view;

        installButtonsOn(view);
        installMenuOn(view);
    }

    //==================================================
    //= install :: buttons
    //==================================================

    private void installButtonsOn(MySummaryView<C> view)
    {
        ScDiv buttons;
        buttons = view.getButtonBox();
        installPopoutButtonOn(buttons);
        installDeleteButtonOn(buttons);
        installEditButtonOn(buttons);
    }

    private void installPopoutButtonOn(ScDiv root)
    {
        ScActionButton e;
        e = root.addButton("", newCheckedAction(this::handlePopout));
        e.setFlavorIcon();
        e.setIcon().nameOpenInNew();
        e.setHoverText("Popout");
        e.hide();
        _popoutButton = e;
    }

    private void installEditButtonOn(ScDiv root)
    {
        ScActionButton e;
        e = root.addEditButton(newCheckedAction(this::handleEdit));
        e.hide();
        _editButton = e;
    }

    private void installDeleteButtonOn(ScDiv root)
    {
        ScActionButton e;
        e = root.addDeleteMaybeButton(newCheckedAction(this::handleDelete));
        e.hide();
        _deleteButton = e;
    }

    //==================================================
    //= install :: menu
    //==================================================

    private void installMenuOn(MySummaryView<C> view)
    {
        ScPopupMenu menu;
        menu = view.getMenu();

        installEditOn(menu);
        installAuditLogOn(menu);
        installDeleteOn(menu);
    }

    private void installEditOn(ScPopupMenu menu)
    {
        ScPopupMenuItem e;
        e = menu.addItem("Edit", newCheckedAction(this::handleEdit));
        e.hide();
        _editMenuItem = e;
    }

    private void installAuditLogOn(ScPopupMenu menu)
    {
        menu.addItem("Audit Log", newCheckedAction(this::handleAuditLog));
    }

    private void installDeleteOn(ScPopupMenu menu)
    {
        ScPopupMenuItem e;
        e = menu.addItem("Delete", newCheckedAction(this::handleDelete));
        e.hide();
        _deleteMenuItem = e;
    }

    //==================================================
    //= install :: body
    //==================================================

    /**
     * Install the body of the group. The body has no
     * extra styling by default. It fills the groups center
     * area and has a position:relative as with all group bodies.
     * However, the subclass is responsible for any additional
     * styling such as padding or scrolling.
     */
    protected abstract void installBodyOn(ScDiv body);

    /**
     * Change the group's style so that the body section
     * appears to be detached from the header and footer.
     */
    protected void detachBody()
    {
        getGroup().setDetachedBody();
    }

    //==================================================
    //= install :: detail footer
    //==================================================

    private void installFooterOn(ScGroup group)
    {
        ScDiv footer;
        footer = group.getFooter();

        installFooterOn(footer);

        if ( footer.isNotEmpty() )
            footer.show();
    }

    /**
     * Allow subclasses to customize the footer.
     * By default, do nothing.
     * Subclasses are NOT required to call super.
     *
     * The footer will automatically be displayed if the footer
     * contains any children (is not empty).
     *
     * @param root The container to which the buttons should be added.
     */
    protected void installFooterOn(ScDiv root)
    {
        // subclass
    }

    //##################################################
    //# summary
    //##################################################

    public MySummaryView<C> getSummaryView()
    {
        return _summaryView;
    }

    //##################################################
    //# listener :: child
    //##################################################

    public final void onChildChanged(Consumer<C> e)
    {
        _childChangedListener = e;
    }

    protected void fireChildChanged()
    {
        fireChildChanged(getDomainChild());
    }

    protected void fireChildChanged(C e)
    {
        if ( e != null )
            ajaxUpdateSummaryView(e);

        fire(_childChangedListener, e);
    }

    //##################################################
    //# listener :: child list
    //##################################################

    public final void onChildListChanged(Consumer<C> e)
    {
        _childListChangedListener = e;
    }

    protected void fireChildListChanged()
    {
        fireChildListChanged(getDomainChild());
    }

    protected void fireChildListChanged(C e)
    {
        if ( e != null )
            ajaxUpdateSummaryView(e);

        fire(_childListChangedListener, e);
    }

    //##################################################
    //# hierarchy
    //##################################################

    @SuppressWarnings("unchecked")
    protected MyCrudListView<?,C> findCrudManager()
    {
        ScControl c = this;
        while ( true )
        {
            c = c.getParent();

            if ( c == null )
                return null;

            if ( c instanceof MyCrudListView )
                if ( ((MyCrudListView<?,C>)c).hasViewCard(this) )
                    return (MyCrudListView<?,C>)c;
        }
    }

    //##################################################
    //# listener :: edit
    //##################################################

    public void onEdit(Consumer<C> e)
    {
        _editListener = e;
    }

    private void fireEdit(C e)
    {
        fire(_editListener, e);
    }

    //==================================================
    //= listener :: audit log
    //==================================================

    public void onAuditLog(Consumer<C> e)
    {
        _auditLogListener = e;
    }

    private void fireAuditLog(C e)
    {
        fire(_auditLogListener, e);
    }

    //==================================================
    //= listener :: delete
    //==================================================

    public void onDelete(Consumer<C> e)
    {
        _deleteListener = e;
    }

    private void fireDelete(C e)
    {
        fire(_deleteListener, e);
    }

    //##################################################
    //# domain
    //##################################################

    protected final C getDomainChild()
    {
        return getCrudBuilder().findChild(_domainChildUid);
    }

    protected void setDomainChild(C e)
    {
        _domainChildUid.setValue(KmUidDomainIF.getUidFor(e));
    }

    //##################################################
    //# control
    //##################################################

    @Override
    protected final boolean applyFromModel_here(Object model)
    {
        @SuppressWarnings("unchecked")
        C c = (C)model;

        setDomainChild(c);
        return false;
    }

    @Override
    public ScHtmlIdIF getFocusTarget()
    {
        return getGroup().getBody();
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected final void preRender()
    {
        super.preRender();

        C child = getDomainChild();

        preRenderSummary(child);
        preRenderDetails(child);
    }

    private void preRenderSummary(C child)
    {
        _summaryView.applyFromModel(child);

        preRenderEdit(child);
        preRenderDelete(child);
        preRenderPopout();
    }

    private void preRenderEdit(C child)
    {
        MyCrudBuilder<?,C> b = getCrudBuilder();
        boolean show = b.showsEditFor(child);

        _editButton.setVisible(show);
        _editMenuItem.setVisible(show);
    }

    private void preRenderDelete(C child)
    {
        MyCrudBuilder<?,C> b = getCrudBuilder();
        boolean allowed = b.showsDeleteFor(child);

        _deleteButton.setVisible(allowed);
        _deleteMenuItem.setVisible(allowed);
    }

    private void preRenderPopout()
    {
        String url = getCrudBuilder().getChildPopoutUrlFor(getDomainChild());
        if ( Kmu.hasValue(url) )
            _popoutButton.show();
    }

    /**
     * Subclasses may override this to perform speciallized prerendering.
     * The default implementation does detailView.applyFromModel(child).
     * Subclasses are NOT required to call super.
     */
    protected void preRenderDetails(C child)
    {
        getGroup().getBody().applyFromModel(child);
    }

    //##################################################
    //# handle
    //##################################################

    private void handleEdit()
    {
        C child = getDomainChild();
        MyCrudBuilder<?,C> b = getCrudBuilder();
        KmSimpleResult r = b.allowsEditFor(child);

        if ( r.hasError() )
        {
            b.showCannotEditDialog(r);
            return;
        }

        fireEdit(getDomainChild());
    }

    private void handleDelete()
    {
        C child = getDomainChild();
        MyCrudBuilder<?,C> b = getCrudBuilder();
        KmSimpleResult r = b.allowsDeleteFor(child);

        if ( r.hasError() )
        {
            b.showCannotDeleteDialog(r);
            return;
        }

        fireDelete(getDomainChild());
    }

    private void handleAuditLog()
    {
        fireAuditLog(getDomainChild());
    }

    private void handlePopout()
    {
        C c = getDomainChild();
        if ( c == null )
        {
            ajaxToast("No popout child.").error();
            return;
        }

        String url = getCrudBuilder().getChildPopoutUrlFor(c);
        if ( Kmu.isEmpty(url) )
        {
            ajaxToast("No popout url.").error();
            return;
        }

        getData().ajax().openWindowUrl(url);
    }

    //##################################################
    //# convenience
    //##################################################

    protected final MyGlobals getGlobals()
    {
        return MyGlobals.instance;
    }

    protected final MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

    protected final ScGroup getGroup()
    {
        return _group;
    }

    private void ajaxUpdateSummaryView(C e)
    {
        preRenderSummary(e);
        _summaryView.ajaxReplace();
    }

    //##################################################
    //# support
    //##################################################

    protected MyUser getCurrentUser()
    {
        return MyGlobals.getCurrentUser();
    }

}
