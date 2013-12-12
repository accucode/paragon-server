package com.app.ui.activity;

import com.kodemore.servlet.ScModelApplicatorIF;
import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.layout.MyPageLayout;

/**
 * Pages are specialized activities.  Pages print their contents when started.
 * 
 * Pages represent a unit of work within the browser's history.
 * Performing actions and updating the display within a page generally does NOT
 * move forward in the browser's history.  But moving from one page to the next
 * DOES generally add a page to the browser's history.
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
    public final void start()
    {
        reset();
        checkLayout();
        print();
    }

    /**
     * Used to optionally reset state when a page starts.
     */
    public void reset()
    {
        // subclass
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
     * Subclasses can use preRender and postRender to hook into
     * the print process.
     */
    protected final void print()
    {
        print(getAutoFocus());
    }

    protected boolean getAutoFocus()
    {
        return true;
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

        preRender();

        ajax().printMain(root);

        if ( focus )
            root.ajax().focus();

        postRender();
    }

    /**
     * I am called immediately BEFORE the page is printed.
     * I provide a hook for subclasses.
     */
    protected void preRender()
    {
        // subclass
    }

    /**
     * I am called immediately AFTER the page is printed.
     * I provide a hook for subclasses.
     */
    protected void postRender()
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

    @Override
    public void applyFromModel(Object model, boolean skipFields)
    {
        if ( hasRoot() )
            getRoot().applyFromModel(model, skipFields);
    }

    @Override
    public void applyToModel(Object model)
    {
        if ( hasRoot() )
            getRoot().applyToModel(model);
    }

    //##################################################
    //# layout
    //##################################################

    private void checkLayout()
    {
        checkLeftMenu();
    }

    private void checkLeftMenu()
    {
        boolean shows = showsLeftMenu();
        boolean visible = getData().isTopVisible();

        if ( shows != visible )
            MyPageLayout.getInstance().showLeftMenu(shows);
    }

    protected boolean showsLeftMenu()
    {
        return true;
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
