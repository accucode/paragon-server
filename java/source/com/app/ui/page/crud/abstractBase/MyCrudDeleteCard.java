package com.app.ui.page.crud.abstractBase;

import java.util.function.Consumer;
import java.util.function.Function;

import com.kodemore.domain.KmUidDomainIF;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.variable.ScLocalString;

import com.app.dao.base.MyDaoAccess;
import com.app.ui.control.MySummaryView;
import com.app.utility.MyGlobals;

/**
 * I provide common functionality for DELETING a single domain.
 *
 * The domain PARENT is NOT specified, since it is not needed for editing.
 * @param <C> The domain CHILD.
 */
public abstract class MyCrudDeleteCard<C extends KmUidDomainIF>
    extends ScGroup
{
    //##################################################
    //# variables
    //##################################################

    private MyCrudBuilder<?,C> _crudBuilder;

    /**
     * The uid of the child being deleted.
     */
    private ScLocalString _domainChildUid;

    /**
     * This allows a client/parent to receive notification after
     * the domain child has been deleted.  The listener is notified
     * AFTER the domain has been deleted.
     */
    private Consumer<C> _deletedListener;

    /**
     * This allows a client/parent to receive notification if
     * the deletion is cancelled.  This is called after this
     * view has handled any local ui.
     */
    private Consumer<C> _cancelledListener;

    private MySummaryView<C> _summaryView;
    private ScDiv            _detailView;

    //##################################################
    //# constructor
    //##################################################

    public MyCrudDeleteCard(MyCrudBuilder<?,C> e)
    {
        _crudBuilder = e;

        _domainChildUid = new ScLocalString();
        _domainChildUid.setAutoSave();

        installGroup();
    }

    protected final MyCrudBuilder<?,C> getCrudBuilder()
    {
        return _crudBuilder;
    }

    //##################################################
    //# install
    //##################################################

    private void installGroup()
    {
        ScGroup group;
        group = this;
        group.setTitle("DELETE " + getCrudBuilder().getChildLabel());
        group.setFlavorAlert();
        group.showHeader().add(createSummary());

        ScDiv body;
        body = group.getBody();
        body.css().flexColumn();

        installDetailWrapperOn(body);
        installFooterOn(group);
    }

    private ScControl createSummary()
    {
        MyCrudBuilder<?,C> b = getCrudBuilder();
        Function<C,String> title = b.getChildTitleFunction();
        Function<C,String> subtitle = b.getChildSubtitleFunction();

        MySummaryView<C> e;
        e = new MySummaryView<>();
        e.css().flexChildStatic();
        e.setTitle(title);
        e.setSubtitle1(subtitle);
        _summaryView = e;
        return e;
    }

    private void installDetailWrapperOn(ScContainer root)
    {
        ScDiv view;
        view = root.addDiv();
        view.css().flexChildFiller().pad();

        switch ( getDetailLayout() )
        {
            case fill:
                view.css().flexColumn().relative();
                break;

            case scroll:
                view.css().auto();
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
     * Add the read-only content to the details view.
     * The container's layout is determined by getFieldLayout().
     * The container does NOT have a form; subclasses MAY add a form if needed.
     */
    protected abstract void installDetailsOn(ScDiv root);

    private void installFooterOn(ScGroup group)
    {
        ScDiv buttons;
        buttons = group.showFooter().addButtonBox();

        ScActionButton deleteButton;
        deleteButton = buttons.addDeleteButton(newCheckedAction(this::handleDelete));
        deleteButton.setConfirmationMessageText("DELETE IS PERMANENT\nContinue?");

        buttons.addCancelButton(newUncheckedAction(this::handleCancel));
    }

    //##################################################
    //# listener :: deleted
    //##################################################

    public void onDeleted(Consumer<C> e)
    {
        _deletedListener = e;
    }

    private void fireDeleted(C e)
    {
        fire(_deletedListener, e);
    }

    //##################################################
    //# listener :: cancelled
    //##################################################

    public void onCancelled(Consumer<C> e)
    {
        _cancelledListener = e;
    }

    private void fireCancelled(C e)
    {
        fire(_cancelledListener, e);
    }

    //##################################################
    //# domain
    //##################################################

    public final C getDomainChild()
    {
        return getCrudBuilder().findChild(_domainChildUid);
    }

    public final void setDomainChild(C e)
    {
        _domainChildUid.setValue(KmUidDomainIF.getUidFor(e));
    }

    //##################################################
    //# downcast
    //##################################################

    @Override
    protected final boolean applyFromModel_here(Object model)
    {
        @SuppressWarnings("unchecked")
        C child = (C)model;

        setDomainChild(child);
        return false;
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
    }

    /**
     * Subclasses may override this to perform speciallized prerendering.
     * The default implementation simply call applyFromModel(child).
     * Subclasses are NOT required to call super.
     */
    protected void preRenderDetails(C child)
    {
        _detailView.applyFromModel(child);
    }

    //##################################################
    //# handle
    //##################################################

    private void handleDelete()
    {
        C e = getDomainChild();
        deleteDomainChild(e);
        getAccess().flush();

        fireDeleted(e);
    }

    private void handleCancel()
    {
        fireCancelled(getDomainChild());
    }

    //##################################################
    //# abstract
    //##################################################

    /**
     * Delete the specified domain child.
     * Throw a KmApplicationException if the domain cannot be deleted.
     */
    protected abstract void deleteDomainChild(C child);

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
}
