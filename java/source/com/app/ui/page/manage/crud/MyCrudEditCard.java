package com.app.ui.page.manage.crud;

import java.util.function.Consumer;
import java.util.function.Function;

import com.kodemore.exception.KmApplicationException;
import com.kodemore.servlet.action.ScErrorManagerIF;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.variable.ScLocalString;

import com.app.dao.base.MyDaoAccess;
import com.app.model.core.MyUidDomainIF;
import com.app.ui.page.test.MySummaryView;
import com.app.utility.MyGlobals;

/**
 * I am used to EDIT a (child) domain.
 *
 * Subclasses are required to implement a minimal number of abstract methods,
 * which are documented below.
 *
 * The PARENT type is NOT specified since the parent is not needed for editing.
 * @param <C> The domain CHILD.
 */
public abstract class MyCrudEditCard<C extends MyUidDomainIF>
    extends ScForm
    implements ScErrorManagerIF
{
    //##################################################
    //# variables
    //##################################################

    private MyCrudBuilder<?,C> _crudBuilder;

    private ScLocalString      _domainChildUid;

    private Consumer<C>        _cancelledListener;
    private Consumer<C>        _savedListener;

    private Consumer<C>        _childListChangedListener;

    private MySummaryView<C>   _summaryView;
    private ScDiv              _detailView;

    private ScDiv              _errorBox;

    //##################################################
    //# constructor
    //##################################################

    public MyCrudEditCard(MyCrudBuilder<?,C> e)
    {
        _crudBuilder = e;

        _domainChildUid = new ScLocalString();
        _domainChildUid.setAutoSave();

        ScForm form;
        form = this;
        form.setSubmitAction(this::handleSave);
        form.setEscapeAction(this::handleCancel);
        form.css().relative();

        installGroupOn(form);
    }

    protected final MyCrudBuilder<?,C> getCrudBuilder()
    {
        return _crudBuilder;
    }

    //##################################################
    //# install
    //##################################################

    private void installGroupOn(ScForm root)
    {
        ScGroup group;
        group = root.addGroup();
        group.setTitle("Edit " + getCrudBuilder().getChildLabel());
        group.setFlavorTertiary();
        group.css().fill();

        ScDiv body;
        body = group.getBody();
        body.css().flexColumn();

        installSummaryOn(body);
        installDetailViewOn(body);
        installDetailFooterOn(group);
    }

    private void installSummaryOn(ScDiv root)
    {
        MyCrudBuilder<?,C> b = getCrudBuilder();
        Function<C,String> title = b.getChildTitleFunction();
        Function<C,String> subtitle = b.getChildSubtitleFunction();

        MySummaryView<C> view;
        view = root.add(new MySummaryView<>());
        view.css().flexChildStatic();
        view.setTitle(title);
        view.setSubtitle1(subtitle);
        _summaryView = view;
    }

    private void installDetailViewOn(ScDiv root)
    {
        ScDiv view;
        view = root.addDiv();
        view.css().flexChildFiller().pad20();

        switch ( getDetailLayout() )
        {
            case fill:
                view.css().relative().flexColumn();
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
     * Add the editable content to the details view.
     * The container's layout is determined by getFieldLayout().
     * The form is managed by the container; subclasses must NOT add a form.
     */
    protected abstract void installDetailsOn(ScDiv root);

    private void installDetailFooterOn(ScGroup group)
    {
        ScDiv footer = group.showFooter();

        ScDiv errorBox;
        errorBox = footer.addDiv();
        errorBox.css().error().crud_footerErrorBox();
        errorBox.hide();
        _errorBox = errorBox;

        ScDiv buttons;
        buttons = footer.addButtonBox();
        buttons.addSaveButton();
        buttons.addCancelButton(this::handleCancel);
    }

    //##################################################
    //# listener :: saved
    //##################################################

    public final void onSaved(Consumer<C> e)
    {
        _savedListener = e;
    }

    private void fireSaved()
    {
        fire(_savedListener, getDomainChild());
    }

    //==================================================
    //= listener :: cancelled
    //==================================================

    public final void onCancelled(Consumer<C> e)
    {
        _cancelledListener = e;
    }

    private void fireCancelled()
    {
        fire(_cancelledListener, getDomainChild());
    }

    //==================================================
    //= lisetner :: child list changed
    //==================================================

    public final void onChildListChanged(Consumer<C> e)
    {
        _childListChangedListener = e;
    }

    protected void fireChildListChanged()
    {
        fire(_childListChangedListener, getDomainChild());
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
        _domainChildUid.setValue(MyUidDomainIF.getUidFor(e));
    }

    //##################################################
    //# downcast
    //##################################################

    @Override
    protected final boolean applyFromModel_here(Object model, boolean skipFields)
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

    private void handleSave()
    {
        ajaxHideAllErrors();
        validateDetails();

        C e;
        e = getDomainChild();
        updateDomainChild(e);

        e.validate();
        getAccess().flush();

        postSave(e);
        fireSaved();
    }

    private void handleCancel()
    {
        fireCancelled();
    }

    //##################################################
    //# extentions
    //##################################################

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
     * Update the child using based on ui created via installFieldOn.
     *
     * Validation.
     * In most cases, the client does not need to implement validation.
     * Standard ui validation is checked BEFORE this method starts.
     * Standard domain validation is called AFTER this method finishes.
     */
    protected abstract void updateDomainChild(C e);

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
