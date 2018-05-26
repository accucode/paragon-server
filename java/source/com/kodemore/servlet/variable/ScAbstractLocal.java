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

package com.kodemore.servlet.variable;

import com.kodemore.servlet.ScPageSession;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.utility.ScLocalRegistry;
import com.kodemore.utility.KmValueHolderIF;
import com.kodemore.utility.Kmu;

/**
 * See comments in ScLocalIF
 */
public abstract class ScAbstractLocal<T>
    implements ScLocalIF, KmValueHolderIF<T>
{
    //##################################################
    //# variables
    //##################################################

    private int     _key;
    private boolean _autoSave;
    private T       _default;

    //##################################################
    //# constructor
    //##################################################

    public ScAbstractLocal()
    {
        this(null);
    }

    public ScAbstractLocal(T def)
    {
        ScLocalRegistry.getInstance().register(this);
        _autoSave = false;
        setDefault(def);
    }

    //##################################################
    //# key
    //##################################################

    @Override
    public int getKey()
    {
        return _key;
    }

    @Override
    public void registerKey(int e)
    {
        _key = e;
    }

    public boolean hasKey(int e)
    {
        return _key == e;
    }

    //##################################################
    //# default
    //##################################################

    private void setDefault(T e)
    {
        _default = normalizeDefault(e);
    }

    /**
     * Can be overridden by subclasses to normalize the default value.
     * For example, default strings may be interned.
     */
    protected T normalizeDefault(T e)
    {
        return e;
    }

    //##################################################
    //# global
    //##################################################

    public void setGlobal()
    {
        ScPageSession.addGlobalKey(getKey());
    }

    public boolean isGlobal()
    {
        return ScPageSession.hasGlobalKey(getKey());
    }

    //##################################################
    //# auto save
    //##################################################

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
    //# value
    //##################################################

    @Override
    public T getValue()
    {
        return getSessionValue();
    }

    private T getSessionValue()
    {
        ScServletData data = getData();

        return data == null
            ? _default
            : data.getPageSession().getValueFor(_key, _default);
    }

    //==================================================
    //= set value
    //==================================================

    @Override
    public void setValue(T e)
    {
        setSessionValue(e);
    }

    private void setSessionValue(T e)
    {
        ScServletData data = getData();

        if ( data == null )
        {
            setDefault(e);
            return;
        }

        if ( Kmu.isEqual(e, _default) )
            data.getPageSession().removeKey(_key);
        else
            data.getPageSession().setValueFor(_key, e);

        checkAutoSave();
    }

    //==================================================
    //= value :: convenience
    //==================================================

    public final boolean isNull()
    {
        return getObjectValue() == null;
    }

    public final boolean isNotNull()
    {
        return !isNull();
    }

    public boolean hasValue()
    {
        return isNotNull();
    }

    public final boolean hasValue(T e)
    {
        return Kmu.isEqual(getObjectValue(), e);
    }

    public final boolean is(T e)
    {
        return hasValue(e);
    }

    public final boolean isNot(T e)
    {
        return !is(e);
    }

    public void clearValue()
    {
        setValue(null);
    }

    //##################################################
    //# session
    //##################################################

    @Override
    public final void saveValue()
    {
        ScServletData data = getData();
        if ( data == null )
            return;

        data.getPageSession().saveKey(_key);
    }

    @Override
    public final void resetValue()
    {
        ScServletData data = getData();
        if ( data == null )
            return;

        data.getPageSession().removeKey(_key);
        checkAutoSave();
    }

    //##################################################
    //# data
    //##################################################

    private ScServletData getData()
    {
        return ScServletData.getLocal();
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public final String toString()
    {
        String s = Kmu.format("%s(%s)", getClass().getSimpleName(), getKey());

        if ( hasValue() )
            s += " = " + getValue();

        return s;
    }

    //##################################################
    //# ObjectValueIF
    //##################################################

    @Override
    public final Object getObjectValue()
    {
        return getValue();
    }

    @Override
    @SuppressWarnings("unchecked")
    public final void setObjectValue(Object e)
    {
        setValue((T)e);
    }

    //##################################################
    //# EncodedValueIF
    //##################################################

    /**
     * Get the value in an encoded form.
     */
    @Override
    public Object getEncodableValue()
    {
        return getObjectValue();
    }

    /**
     * Set the value from an encoded form.
     */
    @Override
    public void setEncodableValue(Object e)
    {
        setObjectValue(e);
    }

    //##################################################
    //# support
    //##################################################

    private void checkAutoSave()
    {
        if ( getAutoSave() )
            saveValue();
    }
}
