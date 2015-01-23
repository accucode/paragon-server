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

package com.kodemore.servlet.control;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.script.ScActionScript;

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
    extends ScChildContainerElement
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
    //# variables
    //##################################################

    /**
     * This is the optional tab changed action,
     * appropriate getters/setters are below.
     */
    private ScActionIF _tabChangedAction;

    //##################################################
    //# accessing
    //##################################################

    public ScActionIF getTabChangedAction()
    {
        return _tabChangedAction;
    }

    @Deprecated
    public void setTabChangedAction(ScActionIF e)
    {
        _tabChangedAction = e;
    }

    public void setTabChangedAction(Runnable e)
    {
        _tabChangedAction = ScAction.create(this, e);
    }

    public boolean hasTabChangedAction()
    {
        return getTabChangedAction() != null;
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
        String ref = getJqueryReference();

        out.getPostDom().run("%s.tabs();", ref);

        if ( hasTabChangedAction() )
            out.getPostDom().run(
                "%s.on('tabsactivate', function( event, ui ) { %s });",
                ref,
                getTabChangeActionScript().formatScript());
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

    private ScActionScript getTabChangeActionScript()
    {
        return ScActionScript.create(getTabChangedAction());
    }
}
