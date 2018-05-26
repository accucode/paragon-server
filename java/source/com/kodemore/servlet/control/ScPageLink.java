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

package com.kodemore.servlet.control;

import com.kodemore.servlet.ScPage;
import com.kodemore.servlet.script.ScBlockScript;

/**
 * A link to start an page.
 *
 * The is automatically hidden if the current user does not have permission to view it.
 */
public class ScPageLink
    extends ScAbstractLink
{
    //##################################################
    //# variables
    //##################################################

    private ScPage _page;

    //##################################################
    //# constructor
    //##################################################

    public ScPageLink()
    {
        // none
    }

    //##################################################
    //# accessing
    //##################################################

    public ScPage getPage()
    {
        return _page;
    }

    public void setPage(ScPage e)
    {
        _page = e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        boolean allowed = getPage().getSecurityManager().checkSecuritySilently();
        setVisible(allowed);
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected String formatTarget()
    {
        return null;
    }

    @Override
    protected String formatEnabledHref()
    {
        ScBlockScript s;
        s = ScBlockScript.create();
        s.enterPage(getPage());

        return "javascript:" + s.formatScript();
    }

    @Override
    protected String formatEnabledOnClick()
    {
        return null;
    }

}
