/*
  Copyright (c) 2005-2013 www.kodemore.com

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

package com.kodemore.servlet.variable;

import com.kodemore.servlet.ScPageSessionAccess;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.utility.ScControlRegistry;
import com.kodemore.thread.KmThreadLocalManager;
import com.kodemore.utility.Kmu;

/**
 * See comments in ScLocalIF
 */
public abstract class ScAbstractLocal
    implements ScLocalIF
{
    //##################################################
    //# variables
    //##################################################

    private String               _key;
    private boolean              _autoSave;
    private ThreadLocal<Boolean> _loaded;

    //##################################################
    //# constructor
    //##################################################

    public ScAbstractLocal()
    {
        _key = ScControlRegistry.getInstance().getNextKey();
        _autoSave = false;
        _loaded = newLocal();
    }

    //##################################################
    //# setup
    //##################################################

    public String getKey()
    {
        return _key;
    }

    @Override
    public void setAutoSave()
    {
        _autoSave = true;
    }

    @Override
    public boolean getAutoSave()
    {
        return _autoSave;
    }

    //##################################################
    //# testing
    //##################################################

    public boolean isNull()
    {
        return getObjectValue() == null;
    }

    public boolean isNotNull()
    {
        return !isNull();
    }

    public boolean hasValue()
    {
        return isNotNull();
    }

    public boolean hasValue(Object e)
    {
        return Kmu.isEqual(getObjectValue(), e);
    }

    public boolean is(Object e)
    {
        return hasValue(e);
    }

    public boolean isNot(Object e)
    {
        return !is(e);
    }

    //##################################################
    //# session
    //##################################################

    @Override
    public final void loadValue()
    {
        if ( !hasData() )
            return;

        resetLocal();
        loadLocal();
        markLoaded();
    }

    @Override
    public final void saveValue()
    {
        if ( !hasData() )
            return;

        ensureLoaded();
        saveLocal();
    }

    @Override
    public final void resetValue()
    {
        if ( !hasData() )
            return;

        resetLocal();
        markLoaded();
        checkAutoSave();
    }

    //##################################################
    //# session (local)
    //##################################################

    /**
     * Load the local state (from the session).
     */
    protected abstract void loadLocal();

    /**
     * Save the local state (to the session).
     */
    protected abstract void saveLocal();

    /**
     * Reset the local state to the non-thread defaults.
     */
    protected abstract void resetLocal();

    //##################################################
    //# loaded
    //##################################################

    protected final boolean isLoaded()
    {
        return _loaded.get() != null;
    }

    protected final void markLoaded()
    {
        _loaded.set(true);
    }

    protected void ensureLoaded()
    {
        if ( !isLoaded() )
            loadValue();
    }

    //##################################################
    //# data
    //##################################################

    protected ScServletData getData()
    {
        return ScServletData.getLocal();
    }

    protected boolean hasData()
    {
        return getData() != null;
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        String s = Kmu.format("%s(%s)", formatShortClassName(), getKey());

        String value = formatValue();
        if ( value != null )
            s += " = " + value;

        return s;
    }

    private String formatShortClassName()
    {
        return Kmu.getSimpleClassName(this);
    }

    public String formatValue()
    {
        return null;
    }

    //##################################################
    //# support
    //##################################################

    protected void checkAutoSave()
    {
        if ( getAutoSave() )
            saveValue();
    }

    protected ScPageSessionAccess getSessionAccess()
    {
        return getData().getPageSessionAccess();
    }

    protected void unsupported()
    {
        throw new UnsupportedOperationException();
    }

    /**
     * ThreadLocals should generally be created via the manager.
     * This allows us to proactively clean up (remove) the local
     * values at the end of the http request.
     */
    protected <E> ThreadLocal<E> newLocal()
    {
        return KmThreadLocalManager.newLocal();
    }

    //##################################################
    //# ObjectValueIF
    //##################################################

    @Override
    public abstract Object getObjectValue();

    @Override
    public abstract void setObjectValue(Object e);

    //##################################################
    //# EncodedValueIF
    //##################################################

    /**
     * Get the value in an encoded form.
     */
    @Override
    public Object getEncodedValue()
    {
        return getObjectValue();
    }

    /**
     * Set the value from an encoded form.
     */
    @Override
    public void setEncodedValue(Object e)
    {
        setObjectValue(e);
    }

}
