package com.kodemore.servlet;

import com.kodemore.exception.KmApplicationException;
import com.kodemore.log.KmLog;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionContextIF;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.script.ScRootScript;
import com.kodemore.servlet.utility.ScFormatter;
import com.kodemore.servlet.utility.ScUrls;
import com.kodemore.utility.Kmu;

public abstract class ScPage
    implements ScActionContextIF
{
    //##################################################
    //# variables
    //##################################################

    private String     _key;
    private ScActionIF _startAction;

    //##################################################
    //# constructor
    //##################################################

    protected ScPage()
    {
        _key = newKey();
        _startAction = newStartAction();
    }

    protected abstract void install();

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
        s = Kmu.lowercaseFirstLetter(s);
        return s;
    }

    //##################################################
    //# start action
    //##################################################

    public ScActionIF getStartAction()
    {
        return _startAction;
    }

    private ScActionIF newStartAction()
    {
        return new ScAction(this)
        {
            @Override
            protected void handle()
            {
                ScPage.this.start();
            }
        };
    }

    //##################################################
    //# navigation
    //##################################################

    /**
     * Return a hash that can be used as part of the application
     * url to control navigation with the browser's back button.
     */
    public String getNavigationHash()
    {
        return getKey();
    }

    public boolean hasNavigationHash(String e)
    {
        return Kmu.isEqual(getNavigationHash(), e);
    }

    /**
     * If true, various tools (e.g.: buttons and links)
     * will default to browser-url navigation rather than
     * direct ajax requests.
     */
    public boolean usesNavigation()
    {
        return true;
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
    //# start
    //##################################################

    /**
     * Start the activity.  This typically resets activity
     * state then displays the ui in an initial state.    
     */
    public abstract void start();

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

    //##################################################
    //# action context
    //##################################################

    @Override
    public void checkSecurity()
    {
        // subclass
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
    //# display
    //##################################################

    /**
     * The name is used for display purposes.  It is not 
     * requried to be unique, nor to conform to any specific
     * rules.  This is primarily used for tools
     */
    public String getName()
    {
        return getClass().getSimpleName();
    }

    @Override
    public String toString()
    {
        return getName();
    }

}
