package com.kodemore.servlet;

import com.kodemore.exception.KmApplicationException;
import com.kodemore.exception.KmSecurityException;
import com.kodemore.log.KmLog;
import com.kodemore.servlet.action.ScContextIF;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.servlet.utility.ScBridge;
import com.kodemore.servlet.utility.ScFormatter;
import com.kodemore.servlet.utility.ScUrls;
import com.kodemore.utility.Kmu;

/**
 * Pages represent a unit of work within the browser's history.
 * Performing actions and updating the display within a page generally does NOT
 * move forward in the browser's history.  But moving from one page to the next
 * DOES generally add a page to the browser's history.
 */
public abstract class ScPage
    implements ScPageIF, ScContextIF
{
    //##################################################
    //# variables
    //##################################################

    private String     _key;

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
    public final void _ajaxPush()
    {
        ajax().pushPage(this);
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

    /*
     * Subclasses should genrally implement the following methods:
     *
     *      push(...)
     *      formatEntryUrl(...)
     *      formatQueryString(...)
     */

    //==================================================
    //= url :: abstract
    //==================================================

    /**
     * Set entry parameters needed to define the url queryString
     * that opens this page.  The "page" parameter is already populated
     * and should now be overwritten.  Many, perhaps most, subclasses
     * will implement this with an empty method.  Any parameters set here
     * will need a management in the getEntryParameters method.
     */
    @Override
    public abstract ScParameterList composeQueryParameters();

    /**
     * Get the entry parameters that were passed to the application as
     * part of the query string.
     */
    @Override
    public abstract void applyQueryParameters(ScParameterList params);

    //==================================================
    //= url :: protected
    //==================================================

    public final String _formatQueryString()
    {
        return _composeQueryParameters().formatUrl();
    }

    protected final ScParameterList _composeQueryParameters()
    {
        ScParameterList v;
        v = composeQueryParameters();

        if ( v == null )
            v = new ScParameterList();

        String pageKey = ScConstantsIF.PARAMETER_REQUESTED_PAGE_KEY;
        if ( v.hasKey(pageKey) )
            KmLog.warnTrace("Pages should NOT set a 'page' parameter; it is reserved.");

        v.setValue(pageKey, getKey());
        return v;
    }

    //##################################################
    //# print
    //##################################################

    /**
     * A convenience method that:
     *      - performs the generic security,
     *      - displays the root control in the layout's main area,
     *      - attempts to set focus on the root.
     *
     * Subclasses can use preRender and postRender to hook into
     * the print process.
     */
    @Override
    public final void print()
    {
        checkSecurity();
        checkLayout();

        ajax().updateCurrentPageKey(this);

        if ( !hasRoot() )
        {
            getBridge().clearMain();
            return;
        }

        ScPageRoot root = getRoot();
        boolean focus = getAutoFocus();

        preRender();
        getBridge().printMain(root, focus);
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
    @Override
    public String getTitle()
    {
        String s;
        s = getClass().getSimpleName();
        s = Kmu.removePrefix(s, "My");
        s = Kmu.removePrefix(s, "Dev");
        s = Kmu.removeSuffix(s, "Page");
        s = Kmu.removeSuffix(s, "Test");
        s = Kmu.formatAsCapitalizedNames(s);
        return s;
    }

    @Override
    public String toString()
    {
        return getKey();
    }

    public String getSimpleClassName()
    {
        return getClass().getSimpleName();
    }

    //##################################################
    //# help
    //##################################################

    public String getHelpMessage()
    {
        return null;
    }

    public boolean hasHelpMessage()
    {
        return getHelpMessage() != null;
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

    protected RuntimeException newCancel()
    {
        return Kmu.newRollback();
    }

    //##################################################
    //# context
    //##################################################

    @Override
    public abstract void checkSecurity();

    @Override
    public boolean checkSecuritySilently()
    {
        try
        {
            checkSecurity();
            return true;
        }
        catch ( KmSecurityException ex )
        {
            return false;
        }
    }

    @Override
    public abstract boolean requiresUser();

    @Override
    public void handleError(KmApplicationException ex)
    {
        ajax().toast(ex.formatMultiLineMessage()).error().sticky();
    }

    @Override
    public void handleFatal(RuntimeException ex)
    {
        KmLog.fatal(ex);
        ajax().openErrorDialog(ex);
    }

    @Override
    public ScContextIF getContext()
    {
        return this;
    }

    //##################################################
    //# convenience
    //##################################################

    protected ScBlockScript ajax()
    {
        return getData().ajax();
    }

    protected ScFormatter getFormatter()
    {
        return ScFormatter.getInstance();
    }

    protected ScBridge getBridge()
    {
        return ScBridge.getInstance();
    }

}
