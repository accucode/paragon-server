package com.app.ui.control;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScFlexbox;

public abstract class MyEditDialog<T>
    extends MyDialog
{
    //##################################################
    //# variables
    //##################################################

    private KmList<MyModelListener<T>> _saveListeners;

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
