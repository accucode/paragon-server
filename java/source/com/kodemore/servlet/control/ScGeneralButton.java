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

package com.kodemore.servlet.control;

import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.Kmu;

/**
 * The typical button that we use to run an action.
 */
public class ScGeneralButton
    extends ScButton
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalString _onClick;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _onClick = new ScLocalString();
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
    //# click
    //##################################################

    public String getOnClick()
    {
        return _onClick.getValue();
    }

    public void setOnClick(String e)
    {
        _onClick.setValue(e);
    }

    public boolean hasOnClick()
    {
        return Kmu.hasValue(getOnClick());
    }

    //##################################################
    //# convenience
    //##################################################

    public void setHref(String href)
    {
        String js = Kmu.format("window.location='%s';", href);

        setOnClick(js);
    }

    public void setHrefHash(String hash)
    {
        String js = Kmu.format("window.location.hash='%s';", hash);

        setOnClick(js);
    }

    //##################################################
    //# on click
    //##################################################

    @Override
    protected String formatOnClick()
    {
        if ( !hasOnClick() )
            return null;

        return getOnClick();
    }

}
