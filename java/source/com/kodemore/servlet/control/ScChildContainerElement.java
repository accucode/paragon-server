/*
  Copyright (c) 2005-2016 www.kodemore.com

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
import com.kodemore.utility.KmCompressMemoryIF;

public abstract class ScChildContainerElement
    extends ScContainerElement
{
    //##################################################
    //# variables
    //##################################################

    private KmList<ScControl> _children;

    //##################################################
    //# constructor
    //##################################################

    public ScChildContainerElement()
    {
        _children = new KmList<>();
    }

    //##################################################
    //# children
    //##################################################

    @Override
    public KmList<ScControl> getChildren()
    {
        return _children;
    }

    public final ScControl getChildAt(int i)
    {
        return getChildren().getAt(i);
    }

    public final int getChildIndexFor(ScControl e)
    {
        if ( e == null )
            return -1;

        int n = getChildren().size();
        for ( int i = 0; i < n; i++ )
            if ( e == getChildAt(i) )
                return i;

        return -1;
    }

    public final boolean hasChildren()
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

    public <T extends ScControl> T prepend(T e)
    {
        e.setParent(this);
        _children.add(0, e);
        return e;
    }

    @Override
    public final void clear()
    {
        _children.clear();
    }

    @Override
    public final boolean isEmpty()
    {
        return getChildren().isEmpty();
    }

    //##################################################
    //# render
    //##################################################

    protected final void renderSimpleElementOn(KmHtmlBuilder out, String tag)
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

    //##################################################
    //# compress
    //##################################################

    /**
     * @see KmCompressMemoryIF#compressMemory
     */
    @Override
    public void compressMemory()
    {
        super.compressMemory();

        _children.compressMemory();
    }
}
