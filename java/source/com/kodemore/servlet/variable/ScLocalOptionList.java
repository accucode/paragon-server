/*
  Copyright (c) 2005-2011 www.kodemore.com

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

import java.util.Collection;

import com.kodemore.adaptor.KmAdaptorIF;
import com.kodemore.servlet.field.ScOption;
import com.kodemore.servlet.utility.ScFormatter;

public class ScLocalOptionList
    extends ScLocalList<ScOption>
{
    //##################################################
    //# constructor
    //##################################################

    public ScLocalOptionList()
    {
        super();
    }

    //##################################################
    //# convenience
    //##################################################

    public void add(Object value, String label)
    {
        ScOption e;
        e = new ScOption();
        e.setValue(value);
        e.setText(label);
        add(e);
    }

    /**
     * Add an option for each value in the list.
     * The valueAdaptor must be configured.
     * The labelAdaptor is optional.
     */
    @SuppressWarnings(
    {
        "unchecked",
        "rawtypes"
    })
    public void add(Collection<?> v, KmAdaptorIF valueAdaptor, KmAdaptorIF labelAdaptor)
    {
        ScFormatter c = ScFormatter.getInstance();
        for ( Object e : v )
        {
            Object value;
            if ( valueAdaptor == null )
                value = e;
            else
                value = valueAdaptor.getValue(e);

            if ( labelAdaptor == null )
            {
                String label = c.formatAny(value);
                add(value, label);
            }
            else
            {
                Object labelValue = labelAdaptor.getValue(e);
                String label = c.formatAny(labelValue);
                add(value, label);
            }
        }
    }

    @SuppressWarnings("rawtypes")
    public <T> void set(Collection<T> v, KmAdaptorIF valueAdaptor, KmAdaptorIF labelAdaptor)
    {
        resetValue();
        add(v, valueAdaptor, labelAdaptor);
    }

}
