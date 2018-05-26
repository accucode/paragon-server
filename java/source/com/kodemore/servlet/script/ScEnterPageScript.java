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

package com.kodemore.servlet.script;

import com.kodemore.json.KmJsonMap;
import com.kodemore.servlet.ScBookmark;
import com.kodemore.servlet.ScPageSession;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;

/**
 * Push a url onto the browser history.
 * This is the interface to the KmNavigator.js.
 */
public class ScEnterPageScript
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
     *      /rootPath
     *      relativePath/
     *      ?queryString
     *
     * Most often, when simply navigating between pages we just update
     * the queryString which indicates the appropriate page like so:
     *      ?page=somePage
     */
    private String _url;

    /**
     * The title to be displayed in the browser's title and/or tab.
     * This may not be supported by all browsers yet.
     * The default is null.
     */
    private String _title;

    /**
     * If true, do a replaceState instead of a pushState.  This replaces
     * the current state on the history stack.  Note: unless you also set
     * handleStateChange=false, this will still trigger a navigation.
     */
    private boolean _replace;

    /**
     * If false, the statechange listener will be temporarily disconnected
     * during the push in order to avoid trigging an event notification.
     * This is normally enabled (true), and is primarily disabled when
     * you want to replace the current state without triggering a navigation.
     */
    private boolean _handleStateChange;

    /**
     * If true (the default) the client browser warn the user if there
     * are any dirty fields before updating the browser navigation.
     */
    private boolean _changeTracking;

    /**
     * By default, the page session is preserved as-is when navigating
     * to a new page. If this is set to true, the page session on the
     * NEW page will be set to the current session.
     */
    private boolean _pageSessionOverride;

    //##################################################
    //# constructor
    //##################################################

    public ScEnterPageScript()
    {
        setHandleStateChange(true);
        setChangeTracking(true);
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

    public void setUrl(ScBookmark b)
    {
        setUrl(b.formatQueryString());
        setTitle(b.getBrowserTabTitle());
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
    //# change tracking
    //##################################################

    public boolean getChangeTracking()
    {
        return _changeTracking;
    }

    public void setChangeTracking(boolean e)
    {
        _changeTracking = e;
    }

    public void disableChangeTracking()
    {
        setChangeTracking(false);
    }

    //##################################################
    //# page session override
    //##################################################

    public boolean getPageSessionOverride()
    {
        return _pageSessionOverride;
    }

    public void setPageSessionOverride(boolean e)
    {
        _pageSessionOverride = e;
    }

    public void setPageSessionOverride()
    {
        setPageSessionOverride(true);
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

        if ( !getChangeTracking() )
            json.setBoolean("changeTracking", false);

        if ( getPageSessionOverride() )
        {
            ScPageSession ps = getData().getPageSession();
            json.setString("pageSession", ps.formatSessionValues());
        }

        ScBlockScript s;
        s = ScBlockScript.create();
        s.run("KmNavigator.pushPage(%s);", json);
        s.formatScriptOn(out);
    }

}
