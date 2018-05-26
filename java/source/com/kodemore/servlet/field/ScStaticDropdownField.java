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

package com.kodemore.servlet.field;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmOrderedMap;
import com.kodemore.servlet.variable.ScLocalOptionList;
import com.kodemore.types.KmTuple;
import com.kodemore.utility.Kmu;

public class ScStaticDropdownField<T>
    extends ScDropdownField<T>
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalOptionList<T> _options;

    //##################################################
    //# constructor
    //##################################################

    public ScStaticDropdownField()
    {
        _options = new ScLocalOptionList<>();
    }

    //##################################################
    //# options
    //##################################################

    @Override
    public KmList<ScOption<T>> getOptions()
    {
        return _options.getValue();
    }

    public void addOption(T value, String label)
    {
        _options.add(value, label);
    }

    public void addOption(T value)
    {
        String label = Kmu.toDisplayString(value);
        addOption(value, label);
    }

    public void clearOptions()
    {
        _options.clear();
    }

    public void setOptions(KmList<T> v)
    {
        clearOptions();
        addOptions(v);
    }

    public void addOptions(KmList<T> v)
    {
        if ( v == null )
            return;

        for ( T e : v )
            addOption(e);
    }

    public <E extends Object> void setOptions(KmOrderedMap<T,E> map)
    {
        clearOptions();

        KmList<KmTuple<T,E>> v = map.getTuples();
        for ( KmTuple<T,E> e : v )
        {
            T key = e.getKey();
            String value = Kmu.toDisplayString(e.getValue());
            addOption(key, value);
        }
    }
}
