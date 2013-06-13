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

package com.kodemore.servlet.control;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.ScMenuItem;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.script.ScActionScript;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.utility.ScJquery;

public class ScTopMenu
    extends ScControl
    implements ScHtmlIdIF
{
    //##################################################
    //# html id
    //##################################################

    @Override
    public String getHtmlId()
    {
        return getKey();
    }

    @Override
    public String formatJquerySelector()
    {
        return ScJquery.formatSelector(this);
    }

    @Override
    public String formatJqueryReference()
    {
        return ScJquery.formatReference(this);
    }

    @Override
    public ScHtmlIdAjax ajax()
    {
        return new ScHtmlIdAjax(this);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.open("ul");
        out.printAttribute("id", getHtmlId());
        out.printAttribute("class", "topMenu");
        out.close();

        out.end("ul");
    }

    //##################################################
    //# render (ajax)
    //##################################################

    /**
     * Render the menu via ajax.  Assumes that the top level UL
     * is already attached to the dom.  Any existing menu elements
     * are cleared before the new menu is rendered.
     */
    public void ajaxRender(ScMenuItem root)
    {
        KmHtmlBuilder out = renderContents(root);
        ajax().setContents(out);
    }

    private KmHtmlBuilder renderContents(ScMenuItem root)
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();

        renderContentsOn(out, root);

        return out;
    }

    private void renderContentsOn(KmHtmlBuilder out, ScMenuItem root)
    {
        if ( root == null )
            return;

        KmList<ScMenuItem> children = root.getChildren();
        for ( ScMenuItem child : children )
            renderItemOn(out, child);
    }

    private void renderItemOn(KmHtmlBuilder out, ScMenuItem item)
    {
        out.begin("li");

        out.open("a");
        out.printAttribute("href", "#");
        out.printAttribute("onclick", formatOnClick(item));
        out.close();
        out.print(item.getText());
        out.end("a");

        renderSubMenusOn(out, item);

        out.end("li");
    }

    private void renderSubMenusOn(KmHtmlBuilder out, ScMenuItem item)
    {
        if ( !item.hasChildren() )
            return;

        out.begin("ul");

        KmList<ScMenuItem> children = item.getChildren();
        for ( ScMenuItem child : children )
            renderItemOn(out, child);

        out.end("ul");
    }

    private String formatOnClick(ScMenuItem item)
    {
        String suffix = "return false";

        ScActionIF a = item.getAction();
        if ( a == null )
            return suffix;

        ScActionScript s;
        s = new ScActionScript();
        s.setAction(a);

        return s.formatScript() + suffix;
    }
}
