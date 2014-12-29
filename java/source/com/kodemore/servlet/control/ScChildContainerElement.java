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
import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;

public abstract class ScChildContainerElement
    extends ScContainerElement
{
    //##################################################
    //# variables
    //##################################################

    private KmList<ScControl> _children;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _children = new KmList<>();
    }

    //##################################################
    //# children
    //##################################################

    public KmList<ScControl> getChildren()
    {
        return _children;
    }

    public ScControl getChildAt(int i)
    {
        return getChildren().getAt(i);
    }

    public boolean hasChildren()
    {
        return getChildren().isNotEmpty();
    }

    @Override
    public <T extends ScControl> T add(T e)
    {
        e.setParent(this);

        _children.add(e);

        return e;
    }

    @Override
    public void clear()
    {
        _children.clear();
    }

    @Override
    public boolean isEmpty()
    {
        return getChildren().isEmpty();
    }

    //##################################################
    //# components
    //##################################################

    @Override
    public Iterator<ScControlIF> getComponents()
    {
        KmCompositeIterator<ScControlIF> i;
        i = new KmCompositeIterator<>();
        i.addAll(super.getComponents());
        i.addAll(getChildren());
        return i;
    }

    //##################################################
    //# render
    //##################################################

    protected void renderSimpleElementOn(KmHtmlBuilder out, String tag)
    {
        out.open(tag);
        renderAttributesOn(out);
        out.close();

        renderChildrenOn(out);

        out.end(tag);
    }

    protected void renderChildrenOn(KmHtmlBuilder out)
    {
        for ( ScControl e : getChildren() )
            renderChildOn(out, e);
    }

    protected void renderChildOn(KmHtmlBuilder out, ScControl e)
    {
        out.render(e);
    }

}
