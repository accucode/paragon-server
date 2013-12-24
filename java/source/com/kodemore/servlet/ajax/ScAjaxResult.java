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

package com.kodemore.servlet.ajax;

import com.kodemore.json.KmJsonMap;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.result.ScAbstractResult;
import com.kodemore.servlet.script.ScRootScript;

public class ScAjaxResult
    extends ScAbstractResult
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The script to execute.
     */
    private ScRootScript _script;

    /**
     * The length of the http output.  This is not set until
     * I am applied to the response.
     */
    private int          _length;

    /**
     * If true (the default) then the page session is automatically
     * updated as part of applying the script to the http response.
     */
    private boolean      _autoUpdatePageSession;

    //##################################################
    //# constructor
    //##################################################

    public ScAjaxResult()
    {
        _script = new ScRootScript();
        _autoUpdatePageSession = true;
    }

    //##################################################
    //# accessing
    //##################################################

    public boolean getAutoUpdatePageSession()
    {
        return _autoUpdatePageSession;
    }

    public void setAutoUpdatePageSession(boolean e)
    {
        _autoUpdatePageSession = e;
    }

    //##################################################
    //# apply
    //##################################################

    @Override
    public void applyTo(ScServletData data)
    {
        if ( getAutoUpdatePageSession() )
            getScript().updatePageSession();

        byte[] bytes = formatJson().getBytes();
        _length = bytes.length;

        setContentTypeJson();

        data.writeBytes(bytes);
        data.logResults(getScript().formatMultilineScript());
    }

    @Override
    public int getLength()
    {
        return _length;
    }

    //##################################################
    //# accessing
    //##################################################

    public ScRootScript getScript()
    {
        return _script;
    }

    public String formatJson()
    {
        KmJsonMap map;
        map = new KmJsonMap();
        map.setString("script", getScript().formatScript());
        return map.toString();
    }
}
