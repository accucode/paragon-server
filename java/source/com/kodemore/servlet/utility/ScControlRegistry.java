/*
  Copyright (c) 2005-2014 www.kodemore.com

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in
  all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  THE SOFTWARE.
*/

package com.kodemore.servlet.utility;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.log.KmLog;
import com.kodemore.servlet.ScConstantsIF;
import com.kodemore.servlet.ScSessionTimeoutException;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.thread.KmThreadLocalManager;
import com.kodemore.utility.Kmu;

public class ScControlRegistry
    implements ScConstantsIF
{
    //##################################################
    //# static
    //##################################################

    private static ScControlRegistry _instance;

    public static synchronized void install()
    {
        if ( _instance != null )
            Kmu.fatal("Already installed.");

        _instance = new ScControlRegistry();
    }

    public static ScControlRegistry getInstance()
    {
        if ( _instance == null )
            Kmu.fatal("Not installed.");

        return _instance;
    }

    //##################################################
    //# variables
    //##################################################

    private int                                _nextPersistentId;
    private KmMap<String,ScKeyIF>              _persistentValues;

    private boolean                            _locked;
    private ThreadLocal<KmMap<String,ScKeyIF>> _transientValues;

    //##################################################
    //# constructor
    //##################################################

    private ScControlRegistry()
    {
        // singleton
        _nextPersistentId = 0;
        _persistentValues = new KmMap<String,ScKeyIF>();

        _locked = false;
        _transientValues = KmThreadLocalManager.newLocal();
    }

    //##################################################
    //# setup
    //##################################################

    public void register(ScKeyIF e)
    {
        if ( _locked )
            register(getTransientValues(), e);
        else
            register(getPersistentValues(), e);
    }

    public void unregister(ScKeyIF e)
    {
        if ( _locked )
            unregister(getTransientValues(), e);
        else
            unregister(getPersistentValues(), e);
    }

    public String getNextKey()
    {
        if ( _locked )
            return getNextTransientKey();

        return getNextPersistentKey();
    }

    public void setLocked()
    {
        _locked = true;
    }

    //##################################################
    //# accessing
    //##################################################

    public ScActionIF getAction(String key)
    {
        Object e = findKey(key);

        if ( e instanceof ScActionIF )
            return (ScActionIF)e;

        throw newTimeout("Unknown Action: %s.", key);
    }

    public ScControl getControl(String key)
    {
        Object e = findKey(key);
        if ( e instanceof ScControl )
            return (ScControl)e;

        throw newTimeout("Unknown Control: %s.", key);
    }

    public ScHtmlIdIF findHtmlId(String id)
    {
        KmList<ScKeyIF> v;

        v = _persistentValues.getValues();
        for ( ScKeyIF e : v )
            if ( e instanceof ScHtmlIdIF )
                if ( ((ScHtmlIdIF)e).getHtmlId().equals(id) )
                    return (ScHtmlIdIF)e;

        v = _transientValues.get().getValues();
        for ( ScKeyIF e : v )
            if ( e instanceof ScHtmlIdIF )
                if ( ((ScHtmlIdIF)e).getHtmlId().equals(id) )
                    return (ScHtmlIdIF)e;

        throw newTimeout("Unknown Html ID: %s.", id);
    }

    //##################################################
    //# private (persistent)
    //##################################################

    private String getNextPersistentKey()
    {
        return PERSISTENT_KEY_PREFIX + getNextPersistentId();
    }

    private String getNextPersistentId()
    {
        return formatId(_nextPersistentId++);
    }

    private KmMap<String,ScKeyIF> getPersistentValues()
    {
        return _persistentValues;
    }

    //##################################################
    //# private (transient)
    //##################################################

    private String getNextTransientKey()
    {
        return TRANSIENT_KEY_PREFIX + getNextTransientId();
    }

    private String getNextTransientId()
    {
        return Kmu.newUid();
    }

    private KmMap<String,ScKeyIF> getTransientValues()
    {
        KmMap<String,ScKeyIF> m = _transientValues.get();
        if ( m == null )
        {
            m = new KmMap<String,ScKeyIF>();
            _transientValues.set(m);
        }
        return m;
    }

    //##################################################
    //# private (support)
    //##################################################

    private <E extends ScKeyIF> void register(KmMap<String,E> m, E e)
    {
        String key = e.getKey();
        if ( key == null )
        {
            KmLog.errorTrace("Attempt to register control with null key.");
            return;
        }

        if ( m.containsKey(key) )
        {
            KmLog.errorTrace("Attempt to register control with duplicate key (%s).", key);
            return;
        }

        m.put(key, e);
    }

    private void unregister(KmMap<String,ScKeyIF> m, ScKeyIF e)
    {
        String key = e.getKey();
        if ( key == null )
        {
            KmLog.errorTrace("Attempt to unregister control with null key.");
            return;
        }

        if ( !m.containsKey(key) )
        {
            KmLog.errorTrace("Attempt to unregister control with unknown key (%s).", key);
            return;
        }

        m.remove(key);
    }

    private ScKeyIF findKey(String key)
    {
        ScKeyIF e = getPersistentValues().get(key);
        if ( e != null )
            return e;

        return getTransientValues().get(key);
    }

    private String formatId(Integer id)
    {
        // Cannot use base62 since html "names" are sometimes
        // NOT case-sensitive.
        return Kmu.formatBase36(id);
    }

    private ScSessionTimeoutException newTimeout(String msg, Object... args)
    {
        String s = Kmu.format(msg, args);
        return new ScSessionTimeoutException(s);
    }

}
