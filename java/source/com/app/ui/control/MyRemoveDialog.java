package com.app.ui.control;

import java.util.function.Consumer;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScDiv;

public abstract class MyRemoveDialog<T>
    extends MyDialog
{
    //##################################################
    //# variables
    //##################################################

    private KmList<Consumer<T>> _removeListeners;

    //##################################################
    //# constructor
    //##################################################

    public MyRemoveDialog()
    {
        _removeListeners = new KmList<>();

        installButtons();
    }

    private void installButtons()
    {
        ScDiv footer;
        footer = showFooter();
        footer.css().flexRow().flexAlignEnd();
        footer.css().buttonBox();
        footer.addButton("Remove", this::handleRemove);
        footer.addCancelButton(this::ajaxClose);
    }

    //##################################################
    //# show
    //##################################################

    public void ajaxOpen(T e)
    {
        prepare(e);
        super.ajaxOpen();
    }

    //##################################################
    //# save listener
    //##################################################

    public void addRemoveListener(Consumer<T> e)
    {
        _removeListeners.add(e);
    }

    private void fireRemoveListeners(T e)
    {
        for ( Consumer<T> ve : _removeListeners )
            ve.accept(e);
    }

    //##################################################
    //# handle
    //##################################################

    private void handleRemove()
    {
        T e = remove();
        if ( e == null )
            return;

        ajaxClose();
        fireRemoveListeners(e);
    }

    //##################################################
    //# abstract
    //##################################################

    /**
     * Update all ui components in preparation for opening
     * the dialog.  In many cases, clients will implement this
     * to do nothing.
     */
    protected abstract void prepare(T e);

    /**
     * Save the value to the database.  Return the saved
     * instance, or null if the value could not be saved.
     * This method may generate ui errors and throw and
     * application exception.
     */
    protected abstract T remove();
}
