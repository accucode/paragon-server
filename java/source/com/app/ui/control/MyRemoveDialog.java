package com.app.ui.control;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScFlexbox;

public abstract class MyRemoveDialog<T>
    extends MyDialog
{
    //##################################################
    //# variables
    //##################################################

    private KmList<MyModelListener<T>> _removeListeners;

    //##################################################
    //# install
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _removeListeners = new KmList<>();

        installButtons();
    }

    private void installButtons()
    {
        ScFlexbox footer;
        footer = showFooter();
        footer.alignEnd();
        footer.css().buttonBox();
        footer.addButton("Remove", newRemoveAction());
        footer.addCancelButton(newAjaxCloseAction());
    }

    //##################################################
    //# actions
    //##################################################

    private ScActionIF newRemoveAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleRemove();
            }
        };
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

    public void addRemoveListener(MyModelListener<T> e)
    {
        _removeListeners.add(e);
    }

    private void fireRemoveListeners(T e)
    {
        for ( MyModelListener<T> ve : _removeListeners )
            ve.run(e);
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
