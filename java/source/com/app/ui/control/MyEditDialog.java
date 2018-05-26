package com.app.ui.control;

import java.util.function.Consumer;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScDiv;

public abstract class MyEditDialog<T>
    extends MyFormDialog
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The consumers are notified after the value has been
     * updated/saved.
     */
    private KmList<Consumer<T>> _savedListeners;

    //##################################################
    //# constructor
    //##################################################

    public MyEditDialog()
    {
        _savedListeners = new KmList<>();

        onSubmit(newUncheckedAction(this::handleSave));
        installButtons();
        installBody();
    }

    //##################################################
    //# install
    //##################################################

    /**
     * Install the body of the form.
     * This is the only part that subclasses should generally configure.
     */
    protected abstract void installBody();

    private void installButtons()
    {
        ScDiv footer;
        footer = showFooter();
        footer.css().flexRow().flexAlignStart();
        footer.css().buttonBox();
        footer.addSaveButton();
        footer.addCancelButton(newUncheckedAction(this::ajaxClose));
    }

    //##################################################
    //# show
    //##################################################

    public void ajaxOpen(T e)
    {
        prepare(e);
        ajaxOpen();
    }

    /**
     * Update all ui components in preparation for opening
     * the dialog.
     */
    protected abstract void prepare(T e);

    @Override
    protected final void preRender()
    {
        // final, so clients will not override it.
        super.preRender();
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
    //# save
    //##################################################

    /**
     * Save the value to the database.  Return the saved
     * instance, or null if the value could not be saved.
     * This method may generate ui errors and throw and
     * application exception.
     */
    protected abstract T save();
}
