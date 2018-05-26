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

import com.kodemore.servlet.ScServletData;
import com.kodemore.thread.KmThreadLocalManager;

public class ScThreadLocal<T>
{
    //##################################################
    //# variables
    //##################################################

    private T                    _default;
    private ThreadLocal<T>       _local;
    private ThreadLocal<Boolean> _set;

    //##################################################
    //# constructor
    //##################################################

    public ScThreadLocal()
    {
        _local = newLocal();
        _set = newLocal();
    }

    //##################################################
    //# accessing
    //##################################################

    public T getValue()
    {
        return isSet()
            ? _local.get()
            : _default;
    }

    public void setValue(T e)
    {
        if ( hasData() )
        {
            _local.set(e);
            _set.set(true);
        }
        else
            _default = e;
    }

    public void reset()
    {
        _local.remove();
        _set.remove();
    }

    public boolean isSet()
    {
        return _set.get() != null;
    }

    //##################################################
    //# support
    //##################################################

    private boolean hasData()
    {
        return getData() != null;
    }

    private ScServletData getData()
    {
        return ScServletData.getLocal();
    }

    private <E> ThreadLocal<E> newLocal()
    {
        return KmThreadLocalManager.newLocal();
    }
}
