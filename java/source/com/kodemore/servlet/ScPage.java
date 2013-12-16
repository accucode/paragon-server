package com.kodemore.servlet;

import com.kodemore.exception.KmApplicationException;
import com.kodemore.log.KmLog;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionContextIF;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.script.ScRootScript;
import com.kodemore.servlet.utility.ScFormatter;
import com.kodemore.servlet.utility.ScUrls;
import com.kodemore.utility.Kmu;

import com.app.utility.MyUrls;

/**
 * Pages represent a unit of work within the browser's history.
 * Performing actions and updating the display within a page generally does NOT
 * move forward in the browser's history.  But moving from one page to the next
 * DOES generally add a page to the browser's history.
 */
public abstract class ScPage
    implements ScActionContextIF, ScModelApplicatorIF
{
    //##################################################
    //# variables
    //##################################################

    private String     _key;
    private ScActionIF _pushAction;

    /**
     * Each page is assumed to have a single root.
     * The root may be null, which will result in a blank page.
     */
    private ScPageRoot _root;

    //##################################################
    //# constructor
    //##################################################

    protected ScPage()
    {
        _key = newKey();
        _pushAction = newPushAction();
    }

    //##################################################
    //# install
    //##################################################

    public final void install()
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
    //# key
    //##################################################

    public String getKey()
    {
        return _key;
    }

    public boolean hasKey(String s)
    {
        return Kmu.isEqual(getKey(), s);
    }

    protected String newKey()
    {
        // return ScControlRegistry.getInstance().getNextKey();
        String s;
        s = getClass().getSimpleName();
        s = Kmu.removePrefix(s, "My");
        s = Kmu.removeSuffix(s, "Page");
        s = Kmu.lowercaseFirstLetter(s);
        return s;
    }

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
    //# push
    //##################################################

    /**
     * By default, simply call print(), to display the root control.
     * Subclasses may freely override this method and do NOT need
     * to call super.start(). 
     */
    public final void push()
    {
        reset();
        ajax().pushPage(this);
    }

    /**
     * Allow subclasses to reset state when the page is started.
     */
    protected void reset()
    {
        // subclass
    }

    /**
     * Allow subclasses perform appropriate updates to the page layout when the
     * page starts.
     */
    protected void checkLayout()
    {
        // subclass
    }

    //##################################################
    //# url
    //##################################################

    public final String formatEntryUrl()
    {
        return MyUrls.getEntryUrl(composeQueryParameters());
    }

    public final String formatQueryString()
    {
        return composeQueryParameters().formatUrl();
    }

    private ScParameterList composeQueryParameters()
    {
        ScParameterList v;
        v = composeLocalQueryParameters();

        if ( v == null )
            v = new ScParameterList();

        // todo_wyatt: pageKey constant
        String pageKey = "page";
        if ( v.hasKey(pageKey) )
            KmLog.warnTrace("Pages should NOT set a 'page' parameter; it is reserved.");

        v.setValue(pageKey, getKey());
        return v;
    }

    /**
     * Set entry parameters needed to define the url queryString
     * that opens this page.  The "page" parameter is already populated
     * and should now be overwritten.  Many, perhaps most, subclasses
     * will implement this with an empty method.  Any parameters set here
     * will need a management in the getEntryParameters method.
     */
    public abstract ScParameterList composeLocalQueryParameters();

    /**
     * Get the entry parameters that were passed to the application as
     * part of the query string.
     */
    public abstract void applyLocalQueryParameters(ScParameterList params);

    //==================================================
    //= start :: actions
    //==================================================

    public ScActionIF getPushAction()
    {
        return _pushAction;
    }

    private ScActionIF newPushAction()
    {
        return new ScAction(this)
        {
            @Override
            protected void handle()
            {
                ScPage.this.push();
            }
        };
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
    public final void print()
    {
        checkLayout();
        print(getAutoFocus());
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
     * If true (the default), we will attempt to automatically set
     * focus on the first field on the page.
     */
    protected boolean getAutoFocus()
    {
        return true;
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
    //# web resources
    //##################################################

    protected static final String getThemeImageUrl(String file)
    {
        return ScUrls.getThemeImage(file);
    }

    protected static final String getCommonImageUrl(String file)
    {
        return ScUrls.getCommonImage(file);
    }

    protected static final String getBlankImageUrl()
    {
        return ScUrls.getBlankImage();
    }

    //##################################################
    //# servlet data (basics)
    //##################################################

    protected ScServletData getData()
    {
        return ScServletData.getLocal();
    }

    protected ScPageSession getPageSession()
    {
        return ScPageSession.getInstance();
    }

    protected boolean isOk()
    {
        return getData().isOk();
    }

    protected boolean isNotOk()
    {
        return !isOk();
    }

    protected boolean hasErrors()
    {
        return getData().hasErrors();
    }

    //##################################################
    //# servlet data (argument)
    //##################################################

    protected Object getArgument()
    {
        return getData().getArgument();
    }

    protected boolean hasArgument()
    {
        return getData().hasArgument();
    }

    protected String getStringArgument()
    {
        return getData().getStringArgument();
    }

    protected Integer getIntegerArgument()
    {
        return getData().getIntegerArgument();
    }

    protected Integer getIntegerArgument(Integer def)
    {
        return getData().getIntegerArgument(def);
    }

    protected Boolean getBooleanArgument()
    {
        return getData().getBooleanArgument();
    }

    protected Boolean getBooleanArgument(Boolean def)
    {
        return getData().getBooleanArgument(def);
    }

    //##################################################
    //# display
    //##################################################

    /**
     * A short string that may be used in the browser's title bar and/or tab.
     */
    public String getTitle()
    {
        String s;
        s = getClass().getSimpleName();
        s = Kmu.removePrefix(s, "My");
        s = Kmu.removeSuffix(s, "Page");
        s = Kmu.removeSuffix(s, "Menu");
        s = Kmu.formatAsCapitalizedNames(s);
        return s;
    }

    @Override
    public String toString()
    {
        return getTitle();
    }

    //##################################################
    //# validate
    //##################################################

    protected void validate()
    {
        if ( hasRoot() )
            getRoot().validate();
    }

    //##################################################
    //# errors
    //##################################################

    protected void cancel()
    {
        Kmu.cancel();
    }

    protected void error(String msg, Object... args)
    {
        Kmu.error(msg, args);
    }

    protected void fatal(String msg, Object... args)
    {
        Kmu.fatal(msg, args);
    }

    //##################################################
    //# action context
    //##################################################

    @Override
    public void checkSecurity()
    {
        // subclass
    }

    public boolean requiresUser()
    {
        return true;
    }

    @Override
    public void handleError(KmApplicationException ex)
    {
        ajax().toast(ex.formatMultiLineMessage()).error().sticky();
    }

    @Override
    public void handleFatal(RuntimeException ex)
    {
        KmLog.fatal(ex);
        ajax().openDialogError(ex);
    }

    protected void throwSecurityError(String msg, Object... args)
    {
        Kmu.throwSecurityError(msg, args);
    }

    //##################################################
    //# convenience
    //##################################################

    protected ScRootScript ajax()
    {
        return getData().ajax();
    }

    protected ScFormatter getFormatter()
    {
        return ScFormatter.getInstance();
    }

}
