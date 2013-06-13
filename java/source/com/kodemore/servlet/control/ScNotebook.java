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
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;

/**
 * I implement a tabbed notebook control using the jquery-ui toolkit.
 * 
 * Simple add controls as children.  The control's standard label
 * attribute is used as the tab's title.
 * 
 * Note that my theming is based on the jquery-ui theme, not the standard
 * application theme.css file.
 */
public class ScNotebook
    extends ScContainerElement
{
    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        renderHtml(out);
        renderScript(out);
    }

    private void renderHtml(KmHtmlBuilder out)
    {
        out.open("div");
        renderAttributesOn(out);
        out.close();

        renderChildrenOn(out);

        out.end("div");
    }

    @Override
    protected void renderChildrenOn(KmHtmlBuilder out)
    {
        KmList<ScControl> v = getChildren();

        renderTabLabels(out, v);
        renderTabContents(out, v);
    }

    private void renderTabLabels(KmHtmlBuilder out, KmList<ScControl> children)
    {
        out.begin("ul");

        for ( ScControl e : children )
            renderTabLabel(out, e);

        out.end("ul");
    }

    private void renderTabLabel(KmHtmlBuilder out, ScControl e)
    {
        out.begin("li");

        out.open("a");
        out.printAttribute("href", "#" + getTabId(e));
        out.close();
        out.print(e.getLabel());
        out.end("a");

        out.end("li");
    }

    private void renderTabContents(KmHtmlBuilder out, KmList<ScControl> children)
    {
        for ( ScControl e : children )
            renderTabContent(out, e);
    }

    private void renderTabContent(KmHtmlBuilder out, ScControl e)
    {
        out.openDiv();
        out.printAttribute("id", getTabId(e));
        out.printAttribute(formatContentCss());
        out.close();
        out.render(e);
        out.endDiv();
    }

    private void renderScript(KmHtmlBuilder out)
    {
        String ref = formatJqueryReference();

        out.getPostDom().run("%s.tabs();", ref);
    }

    //##################################################
    //# support
    //##################################################

    private String getTabId(ScControl child)
    {
        return child.getKey() + "-tab";
    }

    private KmCssDefaultBuilder formatContentCss()
    {
        return newCssBuilder().clearfix();
    }

}
