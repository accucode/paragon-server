package com.app.ui.activity;

import com.kodemore.servlet.ScModelApplicatorIF;
import com.kodemore.servlet.control.ScPageRoot;

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
    private ScPageRoot _root;

    //##################################################
    //# root
    //##################################################

    public ScPageRoot getRoot()
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
        _root = newPageRoot();
        installRoot(_root);
    }

    protected abstract void installRoot(ScPageRoot root);

    protected ScPageRoot newPageRoot()
    {
        return new ScPageRoot(this);
    }

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
     * A convenience method that:
     *      - peforms the generic security,
     *      - displays the root control in the layout's main area, 
     *      - attempts to set focus on the root.
     *      
     * Subclasses can use prePrint and postPrint to hook into
     * the print process.
     */
    protected final void print()
    {
        print(true);
    }

    protected final void print(boolean focus)
    {
        checkSecurity();

        if ( !hasRoot() )
        {
            ajax().clearMain();
            return;
        }

        ScPageRoot root = getRoot();

        prePrint();

        ajax().printMain(root);

        if ( focus )
            root.ajax().focus();

        postPrint();
    }

    /**
     * I am called immediately BEFORE the page is printed.
     * I provide a hook for subclasses.
     */
    protected void prePrint()
    {
        // subclass
    }

    /**
     * I am called immediately AFTER the page is printed.
     * I provide a hook for subclasses.
     */
    protected void postPrint()
    {
        // subclass
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

    protected void validate()
    {
        if ( hasRoot() )
            getRoot().validate();
    }

}
