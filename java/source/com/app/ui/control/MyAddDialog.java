package com.app.ui.control;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScFlexbox;
import com.kodemore.servlet.control.ScSubmitButton;

public abstract class MyAddDialog<T>
    extends MyDialog
{
    //##################################################
    //# variables
    //##################################################

    private KmList<MyModelListener<T>> _saveListeners;

    private ScSubmitButton             _saveButton;
    private ScActionButton             _cancelButton;

    //##################################################
    //# install
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _saveListeners = new KmList<>();

        setSubmitAction(this::handleSave);
        installButtons();
    }

    private void installButtons()
    {
        ScFlexbox footer;
        footer = showFooter();
        footer.alignEnd();
        footer.css().buttonBox();

        _saveButton = footer.addSubmitButton("Save");
        _cancelButton = footer.addCancelButton(this::ajaxClose);
    }

    //##################################################
    //# show
    //##################################################

    @Override
    public void ajaxOpen()
    {
        prepare();
        super.ajaxOpen();
    }

    //##################################################
    //# save listener
    //##################################################

    public void addSaveListener(MyModelListener<T> e)
    {
        _saveListeners.add(e);
    }

    private void fireSaveListeners(T e)
    {
        for ( MyModelListener<T> ve : _saveListeners )
            ve.run(e);
    }

    //##################################################
    //# accessing
    //##################################################

    public ScSubmitButton getSaveButton()
    {
        return _saveButton;
    }

    public ScActionButton getCancelButton()
    {
        return _cancelButton;
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSave()
    {
        T e = save();

        if ( e == null )
            return;

        ajaxClose();
        fireSaveListeners(e);
    }

    //##################################################
    //# abstract
    //##################################################

    /**
     * Update all ui components in preparation for opening
     * the dialog.  In many cases, clients will implement this
     * to do nothing.
     */
    protected abstract void prepare();

    /**
     * Save the value to the database.  Return the saved
     * instance, or null if the value could not be saved.
     * This method may generate ui errors and throw and
     * application exception.
     */
    protected abstract T save();

    //##################################################
    //# convenience
    //##################################################

    /**
     * Enable the save button and set the form's onSubmit action.
     */
    @Deprecated
    protected void ajaxEnableSave(ScActionIF action)
    {
        getSaveButton().ajaxEnable();
        getForm().ajaxOnSubmit(action);
    }

    /**
     * Enable the save button and set the form's onSubmit action.
     */
    protected void ajaxEnableSave(Runnable action)
    {
        getSaveButton().ajaxEnable();
        getForm().ajaxOnSubmit(action);
    }

    /**
     * Disable the submit button and set the form's onSubmit action.
     * This is primarily used when there is an alternate submit button
     * on the form.  You should ensure that there is a second submit button
     * on the form is you use this.
     */
    @Deprecated
    protected void ajaxDisableSave(ScActionIF action)
    {
        getSaveButton().ajaxDisable();
        getForm().ajaxOnSubmit(action);
    }

    /**
     * Disable the submit button and set the form's onSubmit action.
     * This is primarily used when there is an alternate submit button
     * on the form.  You should ensure that there is a second submit button
     * on the form is you use this.
     */
    protected void ajaxDisableSave(Runnable action)
    {
        getSaveButton().ajaxDisable();
        getForm().ajaxOnSubmit(action);
    }

}
