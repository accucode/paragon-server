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

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.control.ScControlIF;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;

/**
 * Add some (html) content to the dom.  
 * 
 * Animations are NOT supported.  If you need to
 * animate the new content, simply add it as a hidden
 * element, then use the ScShowScript to animate the
 * display.
 */
public class ScAddContentScript
    extends ScAbstractScript
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The jquery selector that identifies where the content
     * should be added.  This is typically an id selector
     * like "#someId", but any selector will generally work. 
     */
    private String _selector;

    /**
     * The method used to add new content.
     * Supported values are: append, prepend, before, after.
     * The default is: append.  
     */
    private String _mode;

    /**
     * The html content to be added.
     */
    private KmHtmlBuilder _content;

    //##################################################
    //# constructor
    //##################################################

    public ScAddContentScript()
    {
        setModeAppend();
    }

    //##################################################
    //# selector
    //##################################################

    public String getSelector()
    {
        return _selector;
    }

    public void setSelector(String e)
    {
        _selector = e;
    }

    public void setSelector(ScHtmlIdIF e)
    {
        setSelector(e.getJquerySelector());
    }

    public boolean hasSelector()
    {
        return Kmu.hasValue(getSelector());
    }

    //##################################################
    //# content
    //##################################################

    public KmHtmlBuilder getContent()
    {
        return _content;
    }

    public void setContent(String e)
    {
        _content = new KmHtmlBuilder();
        _content.printLiteral(e);
    }

    public void setContent(KmHtmlBuilder e)
    {
        _content = e;
    }

    public void setContent(ScControlIF e)
    {
        _content = e == null
            ? null
            : e.render();
    }

    public boolean hasContent()
    {
        return _content != null;
    }

    //##################################################
    //# mode
    //##################################################

    public String getMode()
    {
        return _mode;
    }

    private void setMode(String e)
    {
        _mode = e;
    }

    public void setModeAppend()
    {
        setMode("append");
    }

    public void setModePrepend()
    {
        setMode("prepend");
    }

    public void setModeBefore()
    {
        setMode("before");
    }

    public void setModeAfter()
    {
        setMode("after");
    }

    //##################################################
    //# format
    //##################################################

    @Override
    public void formatScriptOn(KmStringBuilder out)
    {
        if ( !hasSelector() )
            return;

        KmHtmlBuilder c = getContent();
        if ( c == null )
            return;

        String fn = getMode();
        String sel = json(getSelector());
        String html = json(c.formatHtml());

        ScBlockScript s;
        s = ScBlockScript.create();
        s.run("$(%s).%s(%s);", sel, fn, html);
        s.run(c.getPostDom());
        s.run(c.getPostRender());
        s.formatScriptOn(out);
    }
}
