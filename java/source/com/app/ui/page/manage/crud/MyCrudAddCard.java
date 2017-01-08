package com.app.ui.page.manage.crud;

import java.util.function.BiConsumer;

import com.kodemore.exception.KmApplicationException;
import com.kodemore.servlet.action.ScErrorManagerIF;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScContainerElement;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoAccess;
import com.app.model.core.MyUidDomainIF;
import com.app.utility.MyGlobals;

/**
 * I am used to ADD a child domain to a parent.
 *
 * Subclasses are required to implement a minimal number of abstract methods,
 * which are documented below.
 *
 * @param <P> The domain PARENT.
 * @param <C> The domain CHILD.
 */
public abstract class MyCrudAddCard<P extends MyUidDomainIF, C extends MyUidDomainIF>
    extends ScDiv
    implements ScErrorManagerIF
{
    //##################################################
    //# variables
    //##################################################

    private MyCrudBuilder<P,C>    _crudBuilder;

    private ScLocalString         _domainParentUid;

    private BiConsumer<C,Boolean> _savedListener;
    private Runnable              _cancelledListener;

    /**
     * I am used to tell a listener that the list *should* be changed.
     * For normal add operations, this is not needed since the newly
     * added domain will be added to the list when it is saved.
     */
    private Runnable              _listRefreshListener;

    private ScDiv                 _errorBox;

    //##################################################
    //# constructor
    //##################################################

    public MyCrudAddCard(MyCrudBuilder<P,C> e)
    {
        _crudBuilder = e;

        _domainParentUid = new ScLocalString();
        _domainParentUid.setAutoSave();

        ScContainerElement root;
        root = installRoot();
        root.css().flexColumn();

        installGroupOn(root);
    }

    private ScContainerElement installRoot()
    {
        if ( !allowsSave() )
            return this;

        css().relative();

        ScForm form;
        form = addForm();
        form.css().fill();
        form.setSubmitAction(this::handleSave);
        form.setEscapeAction(this::handleCancel);
        return form;
    }

    protected MyCrudBuilder<P,C> getCrudBuilder()
    {
        return _crudBuilder;
    }

    /**
     * Determine whether the addCard creates a form and allows the
     * form to be saved.
     *
     * When true (the default), the container automatically includes
     * a form, and displays "save" and "cancel" buttons.
     *
     * When false, the container will NOT include a form, and the
     * save/cancel buttons are replaced with single "close" button.
     * Clicking 'close' fires the onCancel listener.
     */
    protected boolean allowsSave()
    {
        return true;
    }

    //##################################################
    //# install
    //##################################################

    private void installGroupOn(ScContainer root)
    {
        String label = getCrudBuilder().getChildLabel();

        ScGroup group;
        group = root.addGroup("Add " + label);
        group.setFlavorTertiary();
        group.css().flexChildFiller();

        installDetailViewOn(group);
        installFooterOn(group);
    }

    private void installDetailViewOn(ScGroup group)
    {
        ScDiv box;
        box = group.getBody().addDiv();

        switch ( getDetailLayout() )
        {
            case fill:
                box.css().fillOffset20().flexColumn();
                break;

            case scroll:
                group.bodyCss().auto();
                box.css().pad20();
                break;
        }

        installDetailsOn(box);
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
     *
     * The form is usually provided/managed by the container,
     * and clients should generally NOT add their own form.
     * @see #allowsSave()
     */
    protected abstract void installDetailsOn(ScDiv root);

    private void installFooterOn(ScGroup root)
    {
        ScDiv footer = root.showFooter();

        ScDiv errorBox;
        errorBox = footer.addDiv();
        errorBox.css().error().crud_footerErrorBox();
        errorBox.hide();
        _errorBox = errorBox;

        ScDiv buttons = footer.addButtonBox();
        if ( allowsSave() )
        {
            buttons.addSaveButton();
            buttons.addButton("Save & Add More", newUncheckedAction(this::handleSaveAndMore));
            buttons.addCancelButton(this::handleCancel);
        }
        else
            buttons.addCloseButton(this::handleCancel);
    }

    //##################################################
    //# saved listener
    //##################################################

    public final void onSaved(BiConsumer<C,Boolean> e)
    {
        _savedListener = e;
    }

    private void fireSaved(C e, boolean more)
    {
        if ( _savedListener == null )
            return;

        _savedListener.accept(e, more);
    }

    //##################################################
    //# cancelled listener
    //##################################################

    public final void onCancelled(Runnable e)
    {
        _cancelledListener = e;
    }

    private void fireCancelled()
    {
        fire(_cancelledListener);
    }

    //##################################################
    //# refresh listener
    //##################################################

    public final void onListRefresh(Runnable e)
    {
        _listRefreshListener = e;
    }

    public void fireListRefresh()
    {
        fire(_listRefreshListener);
    }

    //##################################################
    //# domain
    //##################################################

    public final P getDomainParent()
    {
        return getCrudBuilder().findParent(_domainParentUid);
    }

    public final void setDomainParent(P e)
    {
        _domainParentUid.setValue(MyUidDomainIF.getUidFor(e));
        resetFieldValues();
    }

    //##################################################
    //# downcast
    //##################################################

    @Override
    protected final boolean applyFromModel_here(Object model, boolean skipFields)
    {
        @SuppressWarnings("unchecked")
        P parent = (P)model;
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

        preRenderDetails(getDomainParent());
    }

    /**
     * Handle any setup immediately before render().
     * This allows subclasses to handle preRender for their customized
     * 'details' without needing to manage the preRender for the entier
     * add view.
     *
     * By default, do nothing.
     * Subclasses are not required to call super.
     *
     * @param parent The parent being rendered.
     */
    protected void preRenderDetails(P parent)
    {
        // subclass
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSave()
    {
        C e = save();

        boolean more = false;
        fireSaved(e, more);
    }

    private void handleSaveAndMore()
    {
        C e = save();

        boolean more = true;
        fireSaved(e, more);
    }

    private void handleCancel()
    {
        fireCancelled();
    }

    //##################################################
    //# save
    //##################################################

    private C save()
    {
        ajaxHideAllErrors();
        validateDetails();

        C e = saveNewChildOn(getDomainParent());
        if ( e == null )
        {
            String name = getCrudBuilder().getChildLabel();
            throw Kmu.newError("Cannot add %s, unknown error.", name);
        }

        getAccess().flush();
        postSave(e);
        return e;
    }

    /**
     * Validate the details of this card.
     * By default, it simply calls validate() which validates
     * all elements on the entire card using the default field
     * validation mechanism.
     *
     * Subclasses do not usually need to override this, but may
     * do so to implement non-standard validation. For example,
     * to conditionally validate only part of the view.
     */
    protected void validateDetails()
    {
        validate();
    }

    @Override
    public final boolean validateQuietly()
    {
        return super.validateQuietly();
    }

    /**
     * Create and save a new child on the specified parent.
     * E.g.: add a depot to a project.
     * Error notifications should be thrown via KmApplicationException.
     * If null is returned a polite (but generic) error will be displayed.
     */
    protected abstract C saveNewChildOn(P parent);

    /**
     * Perform additional actions after the domain child has been
     * fully validated and flushed to the database, but before
     * the save listeners are called.  This provide subclasses
     * a hook to perform additional updates to other domain
     * objects after the child has been fully saved.
     *
     * By default, this method does NOTHING.
     * Subclasses are NOT required to call super.
     * @param e
     */
    protected void postSave(C e)
    {
        // none
    }

    //##################################################
    //# ScContextIF
    //##################################################

    @Override
    public void handleError(KmApplicationException ex)
    {
        String msg = ex.formatMultiLineMessage();

        _errorBox.ajaxSetText(msg);
        _errorBox.ajaxShow();

        throw newRollbackException();
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
        return MyGlobals.getAccess();
    }

}
