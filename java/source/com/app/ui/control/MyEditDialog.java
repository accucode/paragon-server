package com.app.ui.control;

import java.util.function.Consumer;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScFlexbox;

public abstract class MyEditDialog<T>
    extends MyDialog
{
    //##################################################
    //# variables
    //##################################################

    private KmList<Consumer<T>> _saveListeners;

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
        footer.addSubmitButton("Save");
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

    public void addSaveListener(Consumer<T> e)
    {
        _saveListeners.add(e);
    }

    private void fireSaveListeners(T model)
    {
        for ( Consumer<T> e : _saveListeners )
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
        fireSaveListeners(e);
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
