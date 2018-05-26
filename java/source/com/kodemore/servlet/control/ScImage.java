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

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.script.ScActionScript;
import com.kodemore.servlet.script.ScScriptIF;
import com.kodemore.servlet.variable.ScLocalString;

public class ScImage
    extends ScElement
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalString _source;
    private ScLocalString _alt;

    /**
     * A script to run when this control is clicked.
     */
    private ScLocalString _onClick;

    //##################################################
    //# constructor
    //##################################################

    public ScImage()
    {
        _source = new ScLocalString();
        _alt = new ScLocalString("");
        _onClick = new ScLocalString();
    }

    //##################################################
    //# source
    //##################################################

    public String getSource()
    {
        return _source.getValue();
    }

    public void setSource(String e)
    {
        _source.setValue(e);
    }

    //##################################################
    //# alt
    //##################################################

    public String getAlt()
    {
        return _alt.getValue();
    }

    public void setAlt(String e)
    {
        _alt.setValue(e);
    }

    //##################################################
    //# on click
    //##################################################

    public final String getOnClick()
    {
        return _onClick.getValue();
    }

    public final void onClick(String e)
    {
        _onClick.setValue(e);
    }

    public final void onClick(ScScriptIF e)
    {
        _onClick.setValue(e.formatScript());
    }

    public final void onClick(ScAction e)
    {
        onClick(e, null);
    }

    public final void onClick(ScAction e, Object arg)
    {
        ScActionScript script;
        script = ScActionScript.create(e);
        script.setArgument(arg);

        onClick(script);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.open("img");
        renderAttributesOn(out);
        out.close();

        // no end tag.
    }

    @Override
    protected void renderAttributesOn(KmHtmlBuilder out)
    {
        super.renderAttributesOn(out);

        out.printAttribute("src", getSource());
        out.printAttribute("alt", getAlt());
        out.printAttribute("onclick", getOnClick());
    }
}
