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
import com.kodemore.servlet.variable.ScLocalList;

/**
 * I provide a convenient way to add elements to add dynamic elements to a page.  The
 * intent is to provide a more intuitive alternative to the ScLiteral element for dynamically
 * generated content.
 *
 * The children are always transient; that is, they are not stored in the application
 * nor in the page session.  Any number of children can be added, and they will be
 * rendered onto the page, but the children are discarded as soon as the http request
 * is complete.
 *
 * Also, I do not provide any html structure, style, or layout myself.  If I have no children,
 * then I will not render any html.
 */
public class ScTransientContainer
    extends ScContainer
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalList<ScControl> _children;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _children = new ScLocalList<>();
    }

    //##################################################
    //# children
    //##################################################

    public KmList<ScControl> getChildren()
    {
        return _children.getValue();
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

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        for ( ScControl e : getChildren() )
            e.renderOn(out);
    }

}
