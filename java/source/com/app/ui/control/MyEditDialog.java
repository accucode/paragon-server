package com.app.ui.control;

import java.util.function.Consumer;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScDiv;

public abstract class MyEditDialog<T>
    extends MyDialog
{
    //##################################################
    //# variables
    //##################################################

    private KmList<Consumer<T>> _savedListeners;

    //##################################################
    //# constructor
    //##################################################

    public MyEditDialog()
    {
        _savedListeners = new KmList<>();

        setSubmitAction(this::handleSave);
        installButtons();
    }

    private void installButtons()
    {
        ScDiv footer;
        footer = showFooter();
        footer.css().flexRow().flexAlignEnd();
        footer.css().buttonBox();
        footer.addSaveButton();
        footer.addCancelButton(this::ajaxClose);
    }

    //##################################################
    //# show
    //##################################################

    public void ajaxOpen(T e)
    {
        prepare(e);
        ajaxOpen();
    }

    //##################################################
    //# save listener
    //##################################################

    public void addSavedListener(Consumer<T> e)
    {
        _savedListeners.add(e);
    }

    private void fireSavedListeners(T model)
    {
        for ( Consumer<T> e : _savedListeners )
            e.accept(model);
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
        fireSavedListeners(e);
    }

    //##################################################
    //# abstract
    //##################################################

    /**
     * Update all ui components in preparation for opening
     * the dialog.
     */
    protected abstract void prepare(T e);

    /**
     * Save the value to the database.  Return the saved
     * instance, or null if the value could not be saved.
     * This method may generate ui errors and throw and
     * application exception.
     */
    protected abstract T save();
}
