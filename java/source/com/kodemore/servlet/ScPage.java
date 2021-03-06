package com.kodemore.servlet;

import java.util.function.Consumer;

import com.kodemore.exception.KmApplicationException;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScErrorManagerIF;
import com.kodemore.servlet.action.ScSecurityManagerIF;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScNonRenderedContainer;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.servlet.script.ScEnterPageScript;
import com.kodemore.servlet.script.ScToastScript;
import com.kodemore.servlet.utility.ScBridge;
import com.kodemore.servlet.utility.ScFormatter;
import com.kodemore.servlet.utility.ScUrls;
import com.kodemore.utility.KmCompressMemoryIF;
import com.kodemore.utility.Kmu;

/**
 * Pages represent a unit of work within the browser's history.
 * Performing actions and updating the display within a page generally does NOT
 * move forward in the browser's history.  But moving from one page to the next
 * DOES generally add a page to the browser's history.
 */
public abstract class ScPage
    implements ScPageIF, ScSecurityManagerIF, ScErrorManagerIF, KmCompressMemoryIF
{
    //##################################################
    //# variables
    //##################################################

    private String _key;

    /**
     * Each page is assumed to have a single root.
     * The root may be null, which will result in a blank page.
     */
    private ScPageRoot _root;

    /**
     * This is a container for controls that need to be added to
     * the page's heirarch, but not rendered in html.
     */
    private ScNonRenderedContainer _nonRenderedContainer;

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

        _nonRenderedContainer = new ScNonRenderedContainer();
        _root.add(_nonRenderedContainer);

        installRoot(_root);
    }

    protected abstract void installRoot(ScPageRoot root);

    /**
     * This is called...
     * DURING the servlet container setup (MyInstaller),
     * AFTER all pages have finished their install,
     * BEFORE the control registry has been locked.
     *
     * This provides controls the opportunity to perform some
     * finalization once the entire hierarchy has been created.
     */
    protected void postInstall()
    {
        _root.postInstall();
    }

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

    //##################################################
    //# non rendered container
    //##################################################

    protected ScNonRenderedContainer getNonRenderedContainer()
    {
        return _nonRenderedContainer;
    }

    protected void attach(ScControl e)
    {
        getNonRenderedContainer().add(e);
    }

    //##################################################
    //# layout
    //##################################################

    /**
     * Check if the layout is correct, and run any necessary ajax to correct
     * the layout as needed.  This is called near the beginning of print().
     */
    protected void checkLayout()
    {
        // subclass
    }

    //##################################################
    //# bookmark
    //##################################################

    public abstract ScBookmark newBookmark();

    //==================================================
    //= bookmark :: protected
    //==================================================

    /**
     * Read my state from the bookmark.
     * This should be symmetric with writeStateTo.
     * Subclasses should call super in case additional state is added here.
     *
     * @param e
     */
    protected void readStateFrom(ScBookmark e)
    {
        // subclass override
    }

    /**
     * Write my state to the bookmark.
     * This should be symmetric with readStateFrom.
     * Subclasses should call super in case additional state is added here.
     *
     * @param e
     */
    protected void writeStateTo(ScBookmark e)
    {
        // subclass override
    }

    //==================================================
    //= bookmark :: public final
    //==================================================

    public final ScBookmark getBookmark(boolean withState)
    {
        ScBookmark e = newBookmark();

        if ( withState )
            writeStateTo(e);

        return e;
    }

    public final ScBookmark getBookmark()
    {
        return getBookmark(true);
    }

    public final void setBookmark(ScBookmark e)
    {
        readStateFrom(e);
    }

    //==================================================
    //= bookmark :: format
    //==================================================

    public final String formatQueryString()
    {
        return getBookmark().formatQueryString();
    }

    public String formatQueryString(boolean withState)
    {
        return getBookmark(withState).formatQueryString();
    }

    //##################################################
    //# enter
    //##################################################

    /**
     * Run ajax that adds this page onto the navigation stack.
     * The client-side push will subsequently trigger the client
     * to sent a request for the next page's content.
     *
     * Whereas print can generally be called repeatedly without
     * adverse side effects, you should generally avoid calling
     * enter unless you really want to ADD this page to the browser
     * history.  Calling this multiple times for a single page will
     * then require that the user press the browser-back button
     * multiple times in order to leave the page.
     *
     * @see #ajaxPrint
     */
    @Override
    public void ajaxEnter()
    {
        _ajaxEnter(false);
    }

    public void ajaxEnterFresh()
    {
        _ajaxEnter(true);
    }

    private void _ajaxEnter(boolean clearSession)
    {
        ScServletData data;
        data = getData();
        data.getAjaxResult().disablePageSessionUpdate();

        ScBlockScript ajax;
        ajax = ajax();
        ajax.updatePageSession();

        ScEnterPageScript enterScript = ajax.enterPage(this);

        if ( clearSession )
        {
            data.getPageSession().reset();
            enterScript.setPageSessionOverride();
        }
    }

    //##################################################
    //# print
    //##################################################

    /**
     * @see ScPageIF#ajaxPrint
     */
    @Override
    public final void ajaxPrint()
    {
        checkSecurity();
        checkLayout();

        ajax().updateCurrentPageKey(this);
        ajax().unregisterCharts();

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
     * I am called during the ajaxPrint process, after the security
     * and layout has been checked, but before the html is rendered.
     */
    protected abstract void preRender();

    /**
     * I am called immediately AFTER the page content is rendered.
     * I provide a hook for subclasses.
     */
    protected void postRender()
    {
        // subclass
    }

    //##################################################
    //# model
    //##################################################

    @Override
    public void applyFromModel(Object model)
    {
        getRoot().applyFromModel(model);
    }

    @Override
    public void applyToModel(Object model)
    {
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
        s = Kmu.formatAsCapitalizedNames(s);
        return s;
    }

    @Override
    public String getBrowserTabTitle()
    {
        return getBridge().getBrowserTabPrefix() + getTitle();
    }

    public boolean hasTitle(String e)
    {
        return Kmu.isEqual(getTitle(), e);
    }

    public boolean hasTitleIgnoreCase(String e)
    {
        return Kmu.isEqualIgnoreCase(getTitle(), e);
    }

    @Override
    public String toString()
    {
        return getKey();
    }

    //##################################################
    //# jump to
    //##################################################

    /**
     * Return true if this page can be used in the Jump To menu.
     */
    public boolean allowsJumpTo()
    {
        return true;
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

    protected final void validateAndCheck()
    {
        validate();
        checkErrors();
    }

    protected void validate()
    {
        getRoot().validate();
    }

    protected final void checkErrors()
    {
        getRoot().checkErrors();
    }

    protected boolean hasErrors()
    {
        return getRoot().hasErrors();
    }

    //##################################################
    //# context
    //##################################################

    @Override
    public ScSecurityManagerIF getSecurityManager()
    {
        return this;
    }

    @Override
    public ScErrorManagerIF getErrorManager()
    {
        return this;
    }

    //==================================================
    //= context :: security manager
    //==================================================

    @Override
    public abstract void checkSecurity();

    @Override
    public abstract boolean requiresUser();

    //==================================================
    //= context :: error manager
    //==================================================

    @Override
    public void handleError(KmApplicationException ex)
    {
        ajax().toast(ex.formatMultiLineMessage()).error();
        throw Kmu.newRollbackException();
    }

    //##################################################
    //# convenience
    //##################################################

    protected ScBlockScript ajax()
    {
        return getData().ajax();
    }

    protected ScToastScript ajaxToast(String msg, Object... args)
    {
        return ajax().toast(msg, args);
    }

    protected void ajaxHideAllErrors()
    {
        ajax().hideAllErrors();
    }

    protected ScFormatter getFormatter()
    {
        return ScFormatter.getInstance();
    }

    protected ScBridge getBridge()
    {
        return ScBridge.getInstance();
    }

    //==================================================
    //= convenience :: actions
    //==================================================

    protected ScAction newCheckedAction(Runnable r)
    {
        if ( r == null )
            return null;

        return new ScAction(this, r);
    }

    protected <T> ScAction newCheckedAction(Consumer<T> c, T with)
    {
        Runnable r = Kmu.newRunnable(c, with);
        return newCheckedAction(r);
    }

    protected ScAction newUncheckedAction(Runnable r)
    {
        if ( r == null )
            return null;

        ScAction e;
        e = new ScAction(this, r);
        e.setChangeTracking(false);
        return e;
    }

    protected <T> ScAction newUncheckedAction(Consumer<T> c, T with)
    {
        Runnable r = Kmu.newRunnable(c, with);
        return newUncheckedAction(r);
    }

    //##################################################
    //# compress
    //##################################################

    /**
     * @see KmCompressMemoryIF#compressMemory()
     */
    @Override
    public void compressMemory()
    {
        getRoot().compressMemory();

        _nonRenderedContainer.compressMemory();
    }

}
