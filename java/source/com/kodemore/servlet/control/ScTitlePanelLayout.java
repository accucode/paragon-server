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

import java.util.Iterator;

import com.kodemore.collection.KmCompositeIterator;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;

/**
 * I am used to fill a region, displaying a title line at the top and filling
 * the remainder with a content area.  Children are added (delegated) directly
 * to my body.
 * 
 * I do not create an element of my own, instead adding the title and body
 * directly to my parent.  Because I rely on the use of absolute 
 * positioning, my parent must have a non-static position.
 */
public class ScTitlePanelLayout
    extends ScContainer
{
    //##################################################
    //# variables
    //##################################################

    private ScDiv _header;
    private ScDiv _body;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _header = new ScDiv();
        _header.setParent(this);
        _header.css().titlePanelHeader();

        _body = new ScDiv();
        _body.setParent(this);
        _body.css().titlePanelBody();
    }

    //##################################################
    //# header/title
    //##################################################

    public ScDiv getHeader()
    {
        return _header;
    }

    public KmCssDefaultBuilder headerCss()
    {
        return getHeader().css();
    }

    public void setTitle(String s)
    {
        _header.clear();

        ScDiv div;
        div = _header.addDiv();
        div.css().titlePanelText();
        div.addText(s);
    }

    //##################################################
    //# body
    //##################################################

    public ScDiv getBody()
    {
        return _body;
    }

    public KmCssDefaultBuilder bodyCss()
    {
        return getBody().css();
    }

    @Override
    public <T extends ScControl> T add(T e)
    {
        return getBody().add(e);
    }

    @Override
    public boolean isEmpty()
    {
        return getBody().isEmpty();
    }

    @Override
    public void clear()
    {
        getBody().clear();
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.render(_header);
        out.render(_body);
    }

    //##################################################
    //# components
    //##################################################

    @Override
    public Iterator<ScControl> getComponents()
    {
        KmCompositeIterator<ScControl> i;
        i = new KmCompositeIterator<ScControl>();

        i.addAll(super.getComponents());
        i.add(getHeader());
        i.add(getBody());

        return i;
    }
}
