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

package com.kodemore.servlet.field;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.servlet.ScDropdownMenuItem;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScElement;
import com.kodemore.servlet.variable.ScLocalList;
import com.kodemore.servlet.variable.ScLocalString;

/**
 * I implement a dropdown menu using a list, css, and a little javascript.
 *
 * See
 *      kmDropdownMenu.js
 *      dropdownMenu.css.
 *      testDropdownMenu.html
 */
public class ScDropdownMenu
    extends ScElement
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalString                   _title;
    private ScLocalList<ScDropdownMenuItem> _items;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _title = new ScLocalString("Menu");
        _items = new ScLocalList<>();
    }

    //##################################################
    //# title
    //##################################################

    public String getTitle()
    {
        return _title.getValue();
    }

    public void setTitle(String e)
    {
        _title.setValue(e);
    }

    //##################################################
    //# items
    //##################################################

    public ScDropdownMenuItem addItem(String text, ScAction action)
    {
        return addItem(text, action, null);
    }

    public ScDropdownMenuItem addItem(String text, Runnable r)
    {
        return addItem(text, createAction(r), null);
    }

    public ScDropdownMenuItem addItem(String text, ScAction action, Object arg)
    {
        ScDropdownMenuItem e;
        e = new ScDropdownMenuItem();
        e.setText(text);
        e.setAction(action, arg);

        _items.add(e);

        return e;
    }

    public ScDropdownMenuItem addItem(String text, Runnable r, Object arg)
    {
        ScDropdownMenuItem e;
        e = new ScDropdownMenuItem();
        e.setText(text);
        e.setAction(createAction(r), arg);

        _items.add(e);

        return e;
    }

    public void clearItems()
    {
        _items.clear();
    }

    //##################################################
    //# css
    //##################################################

    @Override
    protected KmCssDefaultBuilder formatCss()
    {
        return super.formatCss().getCopy().add("dropdownMenu");
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        renderHtmlOn(out);
        renderScriptOn(out);
    }

    private void renderHtmlOn(KmHtmlBuilder out)
    {
        out.open("div");
        renderAttributesOn(out);
        out.close();

        renderTitleOn(out);
        renderListOn(out);

        out.end("div");
    }

    @Override
    protected void renderAttributesOn(KmHtmlBuilder out)
    {
        super.renderAttributesOn(out);
    }

    private void renderTitleOn(KmHtmlBuilder out)
    {
        out.print(getTitle());
    }

    private void renderListOn(KmHtmlBuilder out)
    {
        out.begin("ul");

        for ( ScDropdownMenuItem e : _items )
            renderItemOn(out, e);

        out.end("ul");
    }

    private void renderItemOn(KmHtmlBuilder out, ScDropdownMenuItem e)
    {
        out.open("li");
        out.printAttribute("onclick", e.formatScript());
        out.close();
        out.print(e.getText());
        out.end("li");
    }

    private void renderScriptOn(KmHtmlBuilder out)
    {
        out.getPostDom().run("KmDropdownMenu.installMenu('%s');", getJquerySelector());
    }

}
