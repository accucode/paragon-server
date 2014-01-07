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

package com.kodemore.servlet.control;

import com.kodemore.servlet.variable.ScLocalString;

/**
 * The typical link that we use to run an action.
 */
public class ScUrlLink
    extends ScAbstractLink
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalString _href;
    private ScLocalString _target;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _href = new ScLocalString();
        _target = new ScLocalString();
    }

    //##################################################
    //# url
    //##################################################

    public String getHref()
    {
        return _href.getValue();
    }

    public void setHref(String e)
    {
        _href.setValue(e);
    }

    /**
     * Used to navigate within the current page using the #tag
     * notation.  With an ajax application this is used to 
     * manage the use of the browser back button.  The parameter
     * should be provided WITHOUT the leading hash.
     */
    public void setHrefHash(String e)
    {
        setHref("#" + e);
    }

    //##################################################
    //# target
    //##################################################

    public String getTarget()
    {
        return _target.getValue();
    }

    public void setTarget(String e)
    {
        _target.setValue(e);
    }

    /**
     * Open the result in a new window (or tab).
     */
    public void setTargetBlank()
    {
        setTarget("_blank");
    }

    /**
     * Open the linked document in the same frame as it was clicked (this is default).
     */
    public void setTargetSelf()
    {
        setTarget("_self");
    }

    /**
     * Open the linked document in the parent frameset
     */
    public void setTargetParent()
    {
        setTarget("_parent");
    }

    /**
     * Open the linked document in the full body of the window
     */
    public void setTargetTop()
    {
        setTarget("_top");
    }

    public boolean hasTarget()
    {
        return _target.hasValue();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected String formatTarget()
    {
        return getTarget();
    }

    @Override
    protected String formatHref()
    {
        return getHref();
    }

    @Override
    protected String formatOnClick()
    {
        return null;
    }

}
