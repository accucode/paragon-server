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

package com.kodemore.servlet.control;

import com.kodemore.servlet.utility.ScJquery;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.utility.Kmu;

/**
 * I am a single tab item within a tabBook.
 */
public class ScTabBookItem
{
    //##################################################
    //# variables
    //##################################################

    private ScControl      _control;
    private ScLocalBoolean _secondary;

    //##################################################
    //# constructor
    //##################################################

    public ScTabBookItem(ScControl e)
    {
        _control = e;
        _secondary = new ScLocalBoolean(false);
    }

    //##################################################
    //# control
    //##################################################

    public ScControl getControl()
    {
        return _control;
    }

    public String getKey()
    {
        return getControl().getKey();
    }

    public boolean hasKey(String e)
    {
        return Kmu.isEqual(getKey(), e);
    }

    public String getLabel()
    {
        return getControl().getLabel();
    }

    public String getTabHtmlId()
    {
        return getControl().getKey() + "-tab";
    }

    public String getTabJquerySelector()
    {
        return ScJquery.formatIdSelector(getTabHtmlId());
    }

    //##################################################
    //# is secondary
    //##################################################

    public boolean isSecondary()
    {
        return _secondary.isTrue();
    }

    public void setSecondary(boolean e)
    {
        _secondary.setValue(e);
    }

    public void setSecondary()
    {
        setSecondary(true);
    }
}
