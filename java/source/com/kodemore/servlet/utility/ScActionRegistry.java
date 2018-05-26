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

import com.kodemore.servlet.ScConstantsIF;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.utility.Kmu;

public class ScActionRegistry
    implements ScConstantsIF
{
    //##################################################
    //# static
    //##################################################

    private static ScActionRegistry _instance;

    public static synchronized void install()
    {
        if ( _instance != null )
            throw Kmu.newFatal("Already installed.");

        _instance = new ScActionRegistry();
    }

    public static ScActionRegistry getInstance()
    {
        if ( _instance == null )
            throw Kmu.newFatal("Not installed.");

        return _instance;
    }

    //##################################################
    //# constants
    //##################################################

    /**
     * The maximum size of the initial action array.
     * This can be safely increased as needed.
     *
     * This only affects the size of the array during installation.
     * Once installation is complete, the array is adjusted to
     * minimize the amount of memory required.
     */
    private static final int MAXIMUM_ACTION_COUNT = 100000;

    /**
     * We start the key at 1 (instead of 0). This means that
     * action[0] will always be null. This isn't a problem since
     * no one will ever reference it. This avoid certain edge cases
     * in javascript related to the value 0.
     */
    private static final int FIRST_KEY = 1;

    //##################################################
    //# variables
    //##################################################

    /**
     * The list of actions.
     * The first element arr[0] is always null.
     * @see #FIRST_KEY
     */
    private ScAction[] _actions;

    /**
     * The effective size of the array. Once the registry is locked
     * the array is resized so that the array.length = _actionLength.
     */
    private int _actionsLength;

    /**
     * Once locked, no more actions can be registered. This is a
     * safeguard to catch mistakes where a developer accidentally
     * tries to register actions after the normal installation
     * process is complete.
     */
    private boolean _locked;

    //##################################################
    //# constructor
    //##################################################

    private ScActionRegistry()
    {
        _actions = new ScAction[MAXIMUM_ACTION_COUNT];
        _actionsLength = FIRST_KEY;
        _locked = false;
    }

    //##################################################
    //# setup
    //##################################################

    public void register(ScAction e)
    {
        if ( _locked )
            throw Kmu.newFatal("Actions can only be registered during install.");

        e.registerKey(_actionsLength);
        _actions[_actionsLength] = e;
        _actionsLength++;
    }

    public void lock()
    {
        _locked = true;
        _actions = Arrays.copyOf(_actions, _actionsLength);
    }

    //##################################################
    //# accessing
    //##################################################

    public ScAction findKey(int key)
    {
        return _actions[key];
    }

    public int getCount()
    {
        return _actionsLength;
    }
}
