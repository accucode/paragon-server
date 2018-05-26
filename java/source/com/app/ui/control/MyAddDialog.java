package com.app.ui.control;

import java.util.function.Consumer;

import com.kodemore.collection.KmList;
import com.kodemore.hibernate.KmhDaoDomainIF;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScSubmitButton;

public abstract class MyAddDialog<T>
    extends MyFormDialog
{
    //##################################################
    //# variables
    //##################################################

    private KmList<Consumer<T>> _saveListeners;

    private ScSubmitButton _saveButton;
    private ScActionButton _cancelButton;

    //##################################################
    //# constructor
    //##################################################

    public MyAddDialog()
    {
        _saveListeners = new KmList<>();

        onSubmit(newUncheckedAction(this::handleSave));

        ScDiv footer;
        footer = showFooter();
        footer.css().flexRow().flexAlignEnd();
        footer.css().buttonBox();

        _saveButton = footer.addSaveButton();
        _cancelButton = footer.addCancelButton(newUncheckedAction(this::ajaxClose));
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

    public void addSaveListener(Consumer<T> e)
    {
        _saveListeners.add(e);
    }

    protected void fireSaveListeners(T e)
    {
        for ( Consumer<T> ve : _saveListeners )
            ve.accept(e);
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

        if ( e instanceof KmhDaoDomainIF )
            ((KmhDaoDomainIF)e).daoAttach();

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
    protected void ajaxEnableSave(ScAction action)
    {
        getSaveButton().ajaxEnable();
        getDialogRoot().ajaxOnSubmit(action);
    }

    /**
     * Disable the submit button and set the form's onSubmit action.
     * This is primarily used when there is an alternate submit button
     * on the form.  You should ensure that there is a second submit button
     * on the form is you use this.
     */
    protected void ajaxDisableSave(ScAction action)
    {
        getSaveButton().ajaxDisable();
        getDialogRoot().ajaxOnSubmit(action);
    }
}
