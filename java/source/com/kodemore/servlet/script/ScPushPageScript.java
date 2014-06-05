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

package com.kodemore.servlet.script;

import com.kodemore.json.KmJsonMap;
import com.kodemore.servlet.ScPage;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.KmApplicationBridge;
import com.kodemore.utility.Kmu;

/**
 * Push a url onto the browser history.
 * This is the interface to the KmNavigator.js.
 */
public class ScPushPageScript
    extends ScAbstractScript
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The url to push.
     * This is the only required attribute, and is pushed 'as is'.
     * The urls must be within the existing domain, and generally take 
     * one of the following forms:
     *      
     *      /rootPath
     *      relativePath/
     *      ?queryString
     */
    private String  _url;

    /**
     * The title to be displayed in the browser's title and/or tab.
     * This is not well supported by browsers yet.
     * The default is null.
     */
    private String  _title;

    /**
     * If true, do a replaceState instead of a pushState.  This replaces
     * the current state on the history stack.  Note: unless you also set
     * handleStateChange=false, this will still trigger a navigation.
     */
    private boolean _replace;

    /**
     * If false, the statechange listener will be temporarily disconnected
     * during the push in order to avoid trigging a an event.  This is 
     * normally true, and is primarily used when you want to replace the 
     * current state without triggering a navigation. 
     */
    private boolean _handleStateChange;

    //##################################################
    //# constructor
    //##################################################

    public ScPushPageScript()
    {
        String appName = KmApplicationBridge.getInstance().getName();
        setTitle(appName);
        setHandleStateChange(true);
    }

    //##################################################
    //# url
    //##################################################

    public String getUrl()
    {
        return _url;
    }

    public void setUrl(String e)
    {
        _url = e;
    }

    public void setUrl(ScPage page)
    {
        String url = page._formatQueryString();
        setUrl(url);
    }

    public boolean hasUrl()
    {
        return Kmu.hasValue(getUrl());
    }

    //##################################################
    //# title
    //##################################################

    public String getTitle()
    {
        return _title;
    }

    public void setTitle(String e)
    {
        _title = e;
    }

    public boolean hasTitle()
    {
        return Kmu.hasValue(getTitle());
    }

    //##################################################
    //# replace
    //##################################################

    public boolean getReplace()
    {
        return _replace;
    }

    public void setReplace(boolean e)
    {
        _replace = e;
    }

    public void setReplace()
    {
        setReplace(true);
    }

    //##################################################
    //# handleStateChange
    //##################################################

    public boolean getHandleStateChange()
    {
        return _handleStateChange;
    }

    public void setHandleStateChange(boolean e)
    {
        _handleStateChange = e;
    }

    //##################################################
    //# format
    //##################################################

    @Override
    public void formatScriptOn(KmStringBuilder out)
    {
        KmJsonMap json;
        json = new KmJsonMap();
        json.setString("url", getUrl());

        if ( hasTitle() )
            json.setString("title", getTitle());

        if ( getReplace() )
            json.setBoolean("replace", true);

        if ( !getHandleStateChange() )
            json.setBoolean("handleStateChange", false);

        ScBlockScript s;
        s = ScBlockScript.create();
        s.run("KmNavigator.pushPage(%s);", json);
        s.formatScriptOn(out);
    }

}
