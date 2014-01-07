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

package com.kodemore.servlet.variable;

import com.kodemore.servlet.ScPageSessionAccess;
import com.kodemore.utility.KmValueHolderIF;

/*
 * I am intended to be used as a base class for immutable values
 * like String, Integer, KmDate, etc...  Values with internally
 * mutable state should be subclassed from ScComplexLocal.
 */
public class ScSimpleLocal<T>
    extends ScAbstractLocal
    implements KmValueHolderIF<T>
{
    //##################################################
    //# variables
    //##################################################

    private ScThreadLocal<T> _value;

    //##################################################
    //# constructor
    //##################################################

    public ScSimpleLocal()
    {
        this(null);
    }

    public ScSimpleLocal(T def)
    {
        _value = new ScThreadLocal<T>();
        setValue(def);
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public T getValue()
    {
        ensureLoaded();
        return _value.getValue();
    }

    @Override
    public void setValue(T e)
    {
        ensureLoaded();
        _value.setValue(e);
        checkAutoSave();
    }

    public void setNull()
    {
        setValue(null);
    }

    public void clearValue()
    {
        setNull();
    }

    //##################################################
    //# session (impl)
    //##################################################

    @Override
    @SuppressWarnings("unchecked")
    protected void loadLocal()
    {
        ScPageSessionAccess a = getSessionAccess();

        String key = getKey();
        if ( !a.containsKey(key) )
            return;

        Object o = a.get(key);
        _value.setValue((T)o);
    }

    @Override
    protected void saveLocal()
    {
        ScPageSessionAccess a = getSessionAccess();
        String key = getKey();
        T value = getValue();

        a.put(key, value);
    }

    @Override
    protected void resetLocal()
    {
        _value.reset();
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String formatValue()
    {
        return hasValue()
            ? getValue() + ""
            : null;
    }

    //##################################################
    //# ObjectValueIF
    //##################################################

    @Override
    public Object getObjectValue()
    {
        return getValue();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void setObjectValue(Object e)
    {
        setValue((T)e);
    }

}
