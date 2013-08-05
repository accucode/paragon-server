package com.app.ui.activity;

import com.kodemore.servlet.ScModelApplicatorIF;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScHtmlIdIF;

/**
 * Pages are specialized activities intended to display
 * their contents upon start.
 */
public abstract class MyPage
    extends MyActivity
    implements ScModelApplicatorIF
{
    //##################################################
    //# variables
    //##################################################

    /**
     * Each page is assumed to have a single root.
     * The root may be null, which will result in a blank page.
     */
    private ScControl _root;

    //##################################################
    //# root
    //##################################################

    public ScControl getRoot()
    {
        return _root;
    }

    public boolean hasRoot()
    {
        return _root != null;
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected final void install()
    {
        _root = installRoot();
    }

    protected abstract ScControl installRoot();

    //##################################################
    //# start
    //##################################################

    /**
     * By default, simply call print(), to display the root control.
     * Subclasses may freely override this method and do NOT need
     * to call super.start(). 
     */
    @Override
    public void start()
    {
        print();
    }

    //##################################################
    //# print
    //##################################################

    /**
     * A convenience method that displays the root control
     * in the layout's main area, then attempts to set focus
     * on the root.
     * 
     * This method is most commonly called from start();
     */
    protected final void print()
    {
        print(true);
    }

    protected final void print(boolean focus)
    {
        if ( !hasRoot() )
        {
            ajax().clearMain();
            return;
        }

        ScControl root = getRoot();

        ajax().printMain(root);

        if ( focus )
            if ( root instanceof ScHtmlIdIF )
                ((ScHtmlIdIF)root).ajax().focus();
    }

    //##################################################
    //# model
    //##################################################

    protected void applyFromModel(Object model)
    {
        if ( hasRoot() )
            getRoot().applyFromModel(model);
    }

    /**
     * Copy some of the model's properties into myself.
     */
    @Override
    public void applyFromModel(Object model, boolean skipFields)
    {
        if ( hasRoot() )
            getRoot().applyFromModel(model, skipFields);
    }

    /**
     * Copy some of my properties into the model.
     */
    @Override
    public void applyToModel(Object model)
    {
        if ( hasRoot() )
            getRoot().applyToModel(model);
    }

    //##################################################
    //# convenience
    //##################################################

    protected ScPageRoot newPageRoot()
    {
        return new ScPageRoot(this);
    }

    protected void validate()
    {
        if ( hasRoot() )
            getRoot().validate();
    }

}
