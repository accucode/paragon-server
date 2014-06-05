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
import com.kodemore.servlet.utility.ScJquery;

/**
 * A fake html id; useful for debugging.
 */
public class ScFakeHtmlId
    implements ScHtmlIdIF
{
    //##################################################
    //# variables
    //##################################################

    private String        _id;
    private ScBlockScript _script;

    //##################################################
    //# constructor
    //##################################################

    public ScFakeHtmlId()
    {
        setId("fake");
        setScript(ScBlockScript.create());
    }

    public ScFakeHtmlId(String id)
    {
        setId(id);
        setScript(ScBlockScript.create());
    }

    public ScFakeHtmlId(String id, ScBlockScript script)
    {
        setId(id);
        setScript(script);
    }

    //##################################################
    //# accessing
    //##################################################

    public String getId()
    {
        return _id;
    }

    public void setId(String e)
    {
        _id = e;
    }

    public ScBlockScript getScript()
    {
        return _script;
    }

    public void setScript(ScBlockScript e)
    {
        _script = e;
    }

    //##################################################
    //# html id
    //##################################################

    @Override
    public String getHtmlId()
    {
        return _id;
    }

    @Override
    public String getJquerySelector()
    {
        return ScJquery.formatIdSelector(getId());
    }

    @Override
    public String getJqueryReference()
    {
        return ScJquery.formatIdReference(getId());
    }

    @Override
    public ScHtmlIdAjax ajax()
    {
        return new ScHtmlIdAjax(getScript(), this);
    }
}
