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

package com.kodemore.servlet.ajax;

import com.kodemore.json.KmJsonMap;
import com.kodemore.servlet.ScContentType;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.result.ScAbstractResult;
import com.kodemore.servlet.script.ScBlockScript;

public class ScAjaxResult
    extends ScAbstractResult
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The script to execute.
     */
    private ScBlockScript _script;

    /**
     * The length of the http output.  This is not set until
     * I am applied to the response.
     */
    private int _length;

    /**
     * By default, the page session is automatically updated.
     * The script to update the session is added to the end of any
     * existing script.
     */
    private boolean _pageSessionUpdate;

    //##################################################
    //# constructor
    //##################################################

    public ScAjaxResult()
    {
        setContentType(ScContentType.Json);
        _script = ScBlockScript.create();
        _pageSessionUpdate = true;
    }

    //##################################################
    //# setup
    //##################################################

    public void disablePageSessionUpdate()
    {
        _pageSessionUpdate = false;
    }

    //##################################################
    //# apply
    //##################################################

    @Override
    public void applyContentTo(ScServletData data)
    {
        if ( _pageSessionUpdate )
            getScript().updatePageSession();

        applyToHttpResponse(data);
        applyToLogFile(data);
    }

    private void applyToHttpResponse(ScServletData data)
    {
        KmJsonMap json;
        json = new KmJsonMap();
        json.setString("script", getScript().formatScript());

        String result = json.formatJson();
        _length = result.length();

        data.writeString(result);
    }

    private void applyToLogFile(ScServletData data)
    {
        String s = getScript().formatMultilineScript();
        data.logResults(s);
    }

    //##################################################
    //# accessing
    //##################################################

    public ScBlockScript getScript()
    {
        return _script;
    }

    @Override
    public int getLength()
    {
        return _length;
    }

}
