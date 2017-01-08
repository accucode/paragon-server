/*
  Copyright (c) 2005-2016 www.kodemore.com

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

import com.kodemore.utility.Kmu;

public class ScLocalString
    extends ScAbstractLocal<String>
{
    //##################################################
    //# constructor
    //##################################################

    public ScLocalString()
    {
        super();
    }

    public ScLocalString(String def)
    {
        super(def);
    }

    //##################################################
    //# compress
    //##################################################

    /**
     * @see ScAbstractLocal#compressMemory
     */
    @Override
    public void compressMemory()
    {
        super.compressMemory();

        String s = getValue();
        if ( s != null )
            setValue(s.intern());
    }

    //##################################################
    //# convenience
    //##################################################

    @Override
    public boolean hasValue()
    {
        return Kmu.hasValue(getValue());
    }

    public void append(String e)
    {
        append(e, null);
    }

    public void append(String e, String separator)
    {
        setValue(Kmu.joinText(getValue(), e, separator));
    }

    public boolean isEmpty()
    {
        return Kmu.isEmpty(getValue());
    }

}
