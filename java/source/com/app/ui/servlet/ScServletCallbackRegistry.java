package com.app.ui.servlet;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScDropzone;
import com.kodemore.servlet.control.ScGrid;
import com.kodemore.servlet.field.ScAutoCompleteField;
import com.kodemore.utility.Kmu;

/**
 * I am used by various tools to coordinate dynamic 
 * server side responses to client side requests.
 * 
 * Tools register a url path suffix, and a callback
 * function.  When a url is receiced matching the 
 * path suffix, the request is passed to the 
 * callback function.
 * 
 * This is an experiment and is intended as an 
 * alternative to creating separate servlets and
 * web.xml entries for each new tool.
 */
public class ScServletCallbackRegistry
{
    //##################################################
    //# install
    //##################################################

    private static ScServletCallbackRegistry _instance;

    public static void install(String prefix)
    {
        if ( _instance != null )
            throw new RuntimeException("Already installed.");

        _instance = new ScServletCallbackRegistry();
        _instance._prefix = prefix;
    }

    public static ScServletCallbackRegistry getInstance()
    {
        if ( _instance == null )
            throw new RuntimeException("Not installed.");

        return _instance;
    }

    //##################################################
    //# constants
    //##################################################

    private static final String       KEY_AUTO_COMPLETE = "autoComplete";
    private static final String       KEY_FLEXIGRID     = "flexigrid";

    private static final String       KEY_DROPZONE      = "dropzone";

    //##################################################
    //# variables
    //##################################################

    /**
     * The path prefix.  Tools need this in order
     * to correctly compose the url. 
     */
    private String                    _prefix;

    /**
     * The list of registered paths and callbacks.
     */
    private KmList<ScServletCallback> _callbacks;

    //##################################################
    //# constructor
    //##################################################

    public ScServletCallbackRegistry()
    {
        _callbacks = new KmList<ScServletCallback>();

        registerControls();
    }

    //##################################################
    //# register
    //##################################################

    private void registerControls()
    {
        registerAutoComplete();
        registerFlexigrid();
        registerDropzone();
    }

    private void registerAutoComplete()
    {
        register(new ScServletCallback(KEY_AUTO_COMPLETE)
        {
            @Override
            public void handle(String suffix)
            {
                ScAutoCompleteField.handleServletCallback(suffix);
            }
        });
    }

    private void registerFlexigrid()
    {
        register(new ScServletCallback(KEY_FLEXIGRID)
        {
            @Override
            public void handle(String suffix)
            {
                ScGrid.handleServletCallback(suffix);
            }
        });
    }

    private void registerDropzone()
    {
        register(new ScServletCallback(KEY_DROPZONE)
        {
            @Override
            public void handle(String suffix)
            {
                ScDropzone.handleServletCallback(suffix);
            }
        });
    }

    private void register(ScServletCallback e)
    {
        String key = e.getKey();

        if ( Kmu.isEmpty(key) )
            Kmu.fatal("Callback key is required.");

        if ( hasCallbackKey(key) )
            Kmu.fatal("Callback key is already registered: %s.", key);

        _callbacks.add(e);
    }

    //##################################################
    //# accessing (callbacks)
    //##################################################

    public ScServletCallback getAutoCompleteCallback()
    {
        return getCallbackForKey(KEY_AUTO_COMPLETE);
    }

    public ScServletCallback getFlexigridCallback()
    {
        return getCallbackForKey(KEY_FLEXIGRID);
    }

    public ScServletCallback getDropzoneCallback()
    {
        return getCallbackForKey(KEY_DROPZONE);
    }

    //##################################################
    //# accessing (misc)
    //##################################################

    public String getPrefix()
    {
        return _prefix;
    }

    public void runPath(String path)
    {
        final String slash = "/";

        path = Kmu.removePrefix(path, getPrefix());
        path = Kmu.removePrefix(path, slash);

        KmList<ScServletCallback> v = _callbacks;
        for ( ScServletCallback e : v )
        {
            String key = e.getKey();
            if ( path.startsWith(key) )
            {
                path = Kmu.removePrefix(path, key);
                path = Kmu.removePrefix(path, slash);
                path = Kmu.removeSuffix(path, slash);

                e.handle(path);
                return;
            }
        }
    }

    //##################################################
    //# support
    //##################################################

    private boolean hasCallbackKey(String key)
    {
        return getCallbackForKey(key) != null;
    }

    private ScServletCallback getCallbackForKey(String key)
    {
        for ( ScServletCallback e : _callbacks )
            if ( e.hasKey(key) )
                return e;

        return null;
    }

}
