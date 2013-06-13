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

package com.kodemore.servlet.control;

import com.kodemore.servlet.ScActivity;
import com.kodemore.servlet.utility.ScHashBridge;
import com.kodemore.utility.Kmu;

/**
 * A button to navigate to an activity.
 */
public class ScActivityButton
    extends ScButton
{
    //##################################################
    //# variables
    //##################################################

    private ScActivity _activity;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();
    }

    //##################################################
    //# type
    //##################################################

    @Override
    protected String formatHtmlType()
    {
        return "button";
    }

    //##################################################
    //# accessing
    //##################################################

    public ScActivity getActivity()
    {
        return _activity;
    }

    public void setActivity(ScActivity e)
    {
        _activity = e;
    }

    //##################################################
    //# on click
    //##################################################

    @Override
    protected String formatOnClick()
    {
        ScHashBridge b = ScHashBridge.getInstance();
        String hash = b.formatFullHash(getActivity());
        return Kmu.format("window.location.hash='%s';", hash);
    }

}
