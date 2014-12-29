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
package com.kodemore.servlet.field;

import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.script.ScSimpleBlockScript;
import com.kodemore.servlet.utility.ScJquery;

public class ScHtmlId
    implements ScHtmlIdIF
{
    //##################################################
    //# variables
    //##################################################

    private String        _htmlId;
    private ScBlockScript _innerScript;

    //##################################################
    //# constructor
    //##################################################

    public ScHtmlId(String htmlId)
    {
        this(htmlId, new ScSimpleBlockScript());
    }

    public ScHtmlId(String htmlId, ScBlockScript inner)
    {
        _htmlId = htmlId;
        _innerScript = inner;
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getHtmlId()
    {
        return _htmlId;
    }

    @Override
    public String getJquerySelector()
    {
        return ScJquery.formatIdSelector(getHtmlId());
    }

    @Override
    public ScHtmlIdAjax ajax()
    {
        return new ScHtmlIdAjax(this, _innerScript);
    }

    //##################################################
    //# focus
    //##################################################

    @Override
    public ScHtmlIdIF getFocusTarget()
    {
        return this;
    }
}
