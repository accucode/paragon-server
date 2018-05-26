/*
  Copyright (c) 2005-2018 www.kodemore.com

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

import java.util.Arrays;
import java.util.Collection;

import com.kodemore.collection.KmMap;
import com.kodemore.servlet.ScConstantsIF;
import com.kodemore.servlet.ScSessionTimeoutException;
import com.kodemore.servlet.control.ScButton;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.thread.KmThreadLocalManager;
import com.kodemore.utility.KmRandom;
import com.kodemore.utility.Kmu;

public class ScControlRegistry
    implements ScConstantsIF
{
    //##################################################
    //# install
    //##################################################

    private static ScControlRegistry _instance;

    public static synchronized void install()
    {
        if ( _instance != null )
            throw Kmu.newFatal("Already installed.");

        _instance = new ScControlRegistry();
    }

    public static ScControlRegistry getInstance()
    {
        if ( _instance == null )
            throw Kmu.newFatal("Not installed.");

        return _instance;
    }

    //##################################################
    //# constants
    //##################################################

    /**
     * The maximum number of persistent controls that can be installed.
     * This affects the install/setup process. The value can be increased
     * as needed. Note that once the initial setup is complete, the array
     * is resized based on actual usage.
     */
    private static final int MAXIMUM_CONTROL_COUNT = 1000000;

    /**
     * We start the key at 1 (instead of 0). This means that
     * controls[0] will always be null. This isn't a problem since
     * no one will ever reference it. This avoid certain edge cases
     * in javascript related to the value 0.
     */
    private static final int FIRST_PERSISTENT_KEY = 1;

    //##################################################
    //# variables
    //##################################################

    private ScControl[] _persistentControls;
    private int         _persistentControlCount;

    /**
     * Transient keys are genereated as random negative integers.
     * This generally avoids collision between different http requests.
     */
    private ThreadLocal<KmMap<Integer,ScControl>> _transientControls;

    private boolean _locked;

    //##################################################
    //# constructor
    //##################################################

    private ScControlRegistry()
    {
        _persistentControls = new ScControl[MAXIMUM_CONTROL_COUNT];
        _persistentControlCount = FIRST_PERSISTENT_KEY;

        _locked = false;
        _transientControls = KmThreadLocalManager.newLocal();
    }

    //##################################################
    //# setup
    //##################################################

    public void register(ScControl e)
    {
        if ( _locked )
            registerTransient(e);
        else
            registerPersistent(e);
    }

    private void registerPersistent(ScControl e)
    {
        e.registerKey(_persistentControlCount);
        _persistentControls[_persistentControlCount] = e;
        _persistentControlCount++;
    }

    private void registerTransient(ScControl e)
    {
        int key = KmRandom.getInstance().getNegativeInteger();
        e.registerKey(key);

        KmMap<Integer,ScControl> map;
        map = getTransientControls();
        map.put(key, e);
    }

    public int getPersistentControlCount()
    {
        return _persistentControlCount;
    }

    public int getPersistentButtonCount()
    {
        int n = 0;

        for ( ScControl e : _persistentControls )
            if ( e instanceof ScButton )
                n++;

        return n;
    }

    //##################################################
    //# lock
    //##################################################

    public void lock()
    {
        _locked = true;
        _persistentControls = Arrays.copyOf(_persistentControls, _persistentControlCount);
    }

    //##################################################
    //# accessing
    //##################################################

    public ScControl findKey(int key)
    {
        return key >= 0
            ? _persistentControls[key]
            : getTransientControls().get(key);
    }

    public ScControl findToken(String token)
    {
        Integer key = ScControlKeys.tokenToKey(token);
        return findKey(key);
    }

    //##################################################
    //# find htmlm id
    //##################################################

    public ScHtmlIdIF findHtmlId(String id)
    {
        ScHtmlIdIF e;

        e = findPersistentHtmlId(id);
        if ( e != null )
            return e;

        e = findTransientHtmlId(id);
        if ( e != null )
            return e;

        throw new ScSessionTimeoutException("Unknown Html ID: " + id);
    }

    private ScHtmlIdIF findPersistentHtmlId(String id)
    {
        ScControl[] arr = _persistentControls;
        int start = FIRST_PERSISTENT_KEY;
        int n = arr.length;

        for ( int i = start; i < n; i++ )
        {
            ScControl e = arr[i];
            if ( e.isHtmlId(id) )
                return e.asHtmlId();
        }

        return null;
    }

    private ScHtmlIdIF findTransientHtmlId(String id)
    {
        KmMap<Integer,ScControl> map = _transientControls.get();
        if ( map == null )
            return null;

        Collection<ScControl> list = map.values();
        for ( ScControl e : list )
            if ( e.isHtmlId(id) )
                return e.asHtmlId();

        return null;
    }

    //##################################################
    //# support
    //##################################################

    private KmMap<Integer,ScControl> getTransientControls()
    {
        KmMap<Integer,ScControl> map = _transientControls.get();
        if ( map == null )
        {
            map = new KmMap<>();
            _transientControls.set(map);
        }
        return map;
    }

}
