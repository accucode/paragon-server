package com.app.ui.page.manage.crud;

import java.util.function.Consumer;
import java.util.function.Function;

import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPopupMenu;
import com.kodemore.servlet.control.ScPopupMenuItem;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.variable.ScLocalString;

import com.app.dao.base.MyDaoAccess;
import com.app.model.core.MyUidDomainIF;
import com.app.ui.control.MyConfirmDialog;
import com.app.ui.control.MyNotifyDialog;
import com.app.ui.layout.MyPageLayout;
import com.app.ui.page.test.MySummaryView;
import com.app.utility.MyGlobals;

/**
 * I provide common functionality for VIEWING a single domain.
 *
 * The domain PARENT is NOT specified, since it is not needed for editing.
 * @param <C> The domain CHILD.
 */
public abstract class MyCrudViewCard<C extends MyUidDomainIF>
    extends ScGroup
{
    //##################################################
    //# variables
    //##################################################

    private MyCrudBuilder<?,C> _crudBuilder;

    private ScLocalString      _domainChildUid;

    private Consumer<C>        _editListener;
    private Consumer<C>        _deleteListener;
    private Consumer<C>        _auditLogListener;

    private Consumer<C>        _childChangedListener;
    private Consumer<C>        _childListChangedListener;

    private MySummaryView<C>   _summaryView;
    private ScDiv              _detailView;

    //==================================================
    //= nav buttons
    //==================================================

    /**
     * When clicked, display the edit view.
     * This is hidden by default, and only displayed if editing is allowed.
     */
    private ScActionButton     _editButton;

    /**
     * When clicked, display the Delete Card.
     * This is hidden by default, and only displayed if deletion is allowed.
     */
    private ScActionButton     _deleteButton;

    public ScGroup             _group;

    private ScPopupMenuItem    _editItem;
    private ScPopupMenuItem    _deleteItem;

    //##################################################
    //# constructor
    //##################################################

    public MyCrudViewCard(MyCrudBuilder<?,C> e)
    {
        _crudBuilder = e;

        installUids();
        installGroup();
    }

    protected final MyCrudBuilder<?,C> getCrudBuilder()
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
        group.setFlavorTertiary();
        group.css().flexColumn();
        _group = group;

        installBannerOn(group);
        installHeaderOn(group);
        installBodyOn(group);
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
        installDeleteButtonOn(buttons);
        installEditButtonOn(buttons);
    }

    private void installEditButtonOn(ScDiv root)
    {
        ScActionButton e;
        e = root.addEditButton(this::handleEdit);
        e.hide();
        _editButton = e;
    }

    private void installDeleteButtonOn(ScDiv root)
    {
        ScActionButton e;
        e = root.addDeleteMaybeButton(this::handleDelete);
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

        _editItem = menu.addItem("Edit", this::handleEdit);
        _editItem.hide();

        menu.addItem("Audit Log", this::handleAuditLog);

        _deleteItem = menu.addItem("Delete", this::handleDelete);
        _deleteItem.hide();
    }

    //==================================================
    //= install :: body
    //==================================================

    private void installBodyOn(ScGroup group)
    {
        ScDiv view;
        view = group.getBody();
        view.css().relative().flexChildFiller();

        switch ( getDetailLayout() )
        {
            case fill:
                group.setDetachedBody();
                view.css().flexColumn();
                break;

            case scroll:
                group.setAttachedBody();
                view.css().auto().pad20();
                break;
        }

        installDetailsOn(view);
        _detailView = view;
    }

    /**
     * Determines the type of container layout required by the detail view.
     * Often the details are simply a scrollable list of fields.
     * Sometimes a notebook or other control may need to fill the detail view.
     *
     * @see MyCrudLayout
     */
    protected abstract MyCrudLayout getDetailLayout();

    /**
     * Add the editable content to the details view.
     * The container's layout is determined by getFieldLayout().
     * The container does NOT have a form; subclasses MAY add a form if needed.
     */
    protected abstract void installDetailsOn(ScDiv root);

    //==================================================
    //= install :: detail footer
    //==================================================

    private void installFooterOn(ScGroup group)
    {
        ScDiv footer;
        footer = group.getFooter();
        footer.css().flexRow().flexAlignEnd().buttonBox();

        installDetailButtonsOn(footer);

        if ( footer.isNotEmpty() )
            footer.show();
    }

    /**
     * Allow subclasses to add custom buttons to the card layout.
     * By default, do nothing.
     * Subclasses are NOT required to call super.
     *
     * @param root The container to which the buttons should be added.
     */
    protected void installDetailButtonsOn(ScDiv root)
    {
        // none
    }

    //##################################################
    //# summary
    //##################################################

    public MySummaryView<C> getSummaryView()
    {
        return _summaryView;
    }

    //##################################################
    //# listener :: saved
    //##################################################

    public final void onChildChanged(Consumer<C> e)
    {
        _childChangedListener = e;
    }

    protected void fireChildChanged(C e)
    {
        fire(_childChangedListener, e);
    }

    public final void onChildListChanged(Consumer<C> e)
    {
        _childListChangedListener = e;
    }

    protected void fireChildListChanged(C e)
    {
        fire(_childListChangedListener, e);
    }

    //##################################################
    //# hierarchy
    //##################################################

    @SuppressWarnings("unchecked")
    protected MyCrudManageView<?,C> findCrudManager()
    {
        ScControl c = this;
        while ( true )
        {
            c = c.getParent();

            if ( c == null )
                return null;

            if ( c instanceof MyCrudManageView )
                if ( ((MyCrudManageView<?,C>)c).hasViewCard(this) )
                    return (MyCrudManageView<?,C>)c;
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
        _domainChildUid.setValue(MyUidDomainIF.getUidFor(e));
    }

    //##################################################
    //# control
    //##################################################

    @Override
    protected final boolean applyFromModel_here(Object model, boolean skipFields)
    {
        @SuppressWarnings("unchecked")
        C c = (C)model;

        setDomainChild(c);
        return false;
    }

    @Override
    public ScHtmlIdIF getFocusTarget()
    {
        return _detailView;
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
        preRenderButtons(child);
        preRenderDetails(child);
    }

    private void preRenderSummary(C child)
    {
        _summaryView.applyFromModel(child);
    }

    private void preRenderButtons(C child)
    {
        MyCrudBuilder<?,C> b = getCrudBuilder();
        boolean allowed;

        allowed = b.allowsEditFor(child);
        _editButton.setVisible(allowed);
        _editItem.setVisible(allowed);

        allowed = b.allowsDeleteFor(child);
        _deleteButton.setVisible(allowed);
        _deleteItem.setVisible(allowed);
    }

    /**
     * Subclasses may override this to perform speciallized prerendering.
     * The default implementation does detailView.applyFromModel(child).
     * Subclasses are NOT required to call super.
     */
    protected void preRenderDetails(C child)
    {
        _detailView.applyFromModel(child);
    }

    //##################################################
    //# handle
    //##################################################

    private void handleEdit()
    {
        fireEdit(getDomainChild());
    }

    private void handleDelete()
    {
        fireDelete(getDomainChild());
    }

    private void handleAuditLog()
    {
        fireAuditLog(getDomainChild());
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

    //##################################################
    //# ajax
    //##################################################

    protected final void ajaxRefresh()
    {
        _htmlIdAjax().replace();
    }

    /**
     * Refresh those buttons that depend on the state of the
     * enclosing crud manager.
     */
    public void ajaxRefreshCrudManagerButtons()
    {
        // none
    }

    //##################################################
    //# support
    //##################################################

    protected MyNotifyDialog getGlobalNotifyDialog()
    {
        return MyPageLayout.getInstance().getNotifyDialog();
    }

    protected MyConfirmDialog getGlobalConfirmDialog()
    {
        return MyPageLayout.getInstance().getConfirmDialog();
    }

}
