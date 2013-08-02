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

package com.kodemore.servlet.script;

import com.kodemore.json.KmJsonObject;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;

/**
 * I am used to open a new browser window (tab) with various options.
 */
public class ScOpenWindowScript
    extends ScAbstractScript
{
    //##################################################
    //# variables
    //##################################################

    /**
     * If set, the new window will load its contents from this url.
     * Clients should usually set either the url or the html, but not both.
     */
    private String _url;

    /**
     * If set, the new window will load its contents from this html.
     * Clients should usually set either the url or the html, but not both.
     */

    private String _html;

    /**
     * The internal window name.  If left null, the window will not have a 
     * name and a new window will be opened.  Specifying a window name will
     * reuse an existing window if one with the same name is available.
     */
    private String _name;

    /**
     * The parameter string used by javascript window.open(...).
     * For example: "width=480,height=300,toolbar=0,location=0,...";
     * This is usually left null.
     */
    private String _parameters;

    //##################################################
    //# constructor
    //##################################################

    public ScOpenWindowScript()
    {
        // none
    }

    //##################################################
    //# content (url)
    //##################################################

    public String getUrl()
    {
        return _url;
    }

    public void setUrl(String e)
    {
        _url = e;
    }

    public boolean hasUrl()
    {
        return Kmu.hasValue(getUrl());
    }

    //##################################################
    //# content (html)
    //##################################################

    public String getHtml()
    {
        return _html;
    }

    public void setHtml(String e)
    {
        _html = e;
    }

    public boolean hasHtml()
    {
        return Kmu.hasValue(getHtml());
    }

    //##################################################
    //# name
    //##################################################

    public String getName()
    {
        return _name;
    }

    public void setName(String e)
    {
        _name = e;
    }

    public boolean hasName()
    {
        return Kmu.hasValue(getName());
    }

    //##################################################
    //# parameters
    //##################################################

    public String getParameters()
    {
        return _parameters;
    }

    public void setParameters(String e)
    {
        _parameters = e;
    }

    public boolean hasParameters()
    {
        return Kmu.hasValue(getParameters());
    }

    //##################################################
    //# scriptIF 
    //##################################################

    @Override
    public void formatScriptOn(KmStringBuilder out)
    {
        KmJsonObject args;
        args = new KmJsonObject();

        if ( hasUrl() )
            args.setString("url", getUrl());

        if ( hasHtml() )
            args.setString("html", getHtml());

        if ( hasName() )
            args.setString("name", getName());

        if ( hasParameters() )
            args.setString("params", getParameters());

        out.printf("Kmu.openWindow(%s);", args);
    }
}
