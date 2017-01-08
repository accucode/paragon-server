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

package com.kodemore.servlet.field;

import com.kodemore.collection.KmList;
import com.kodemore.utility.KmEnumIF;

/**
 * A choice field specialized for strings.
 * This includes convenience methods that only apply to string values.
 */
public class ScEnumChoiceField
    extends ScChoiceField<String>
{
    //##################################################
    //# coded enums
    //##################################################

    public void setValue(KmEnumIF e)
    {
        setValue(e.getCode());
    }

    public void addOption(KmEnumIF e)
    {
        addOption(e.getCode(), e.getLabel());
    }

    public void addOptions(KmEnumIF[] v)
    {
        for ( KmEnumIF e : v )
            addOption(e);
    }

    public void addCodedOptions(KmList<? extends KmEnumIF> v)
    {
        for ( KmEnumIF e : v )
            addOption(e);
    }

}
