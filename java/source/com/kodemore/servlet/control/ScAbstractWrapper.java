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

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.meta.KmMetaProperty;
import com.kodemore.servlet.variable.ScLocalControl;

/**
 * I provide common implementation for simple wrappers.
 * Wrappers are typically used to 'wrap' a single control,
 * adding some type of decoration, or behavior.
 */
public abstract class ScAbstractWrapper
    extends ScControl
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalControl _child;

    //##################################################
    //# constructor
    //##################################################

    public ScAbstractWrapper()
    {
        _child = new ScLocalControl();
    }

    //##################################################
    //# child
    //##################################################

    public ScControl getChild()
    {
        return _child.getValue();
    }

    public void setChild(ScControl e)
    {
        if ( e != null )
            e.setParent(this);

        _child.setValue(e);
    }

    public <E> ScFieldIF<E> setChild(KmMetaProperty<?,E> e)
    {
        ScFieldIF<E> f = e.newField();
        ScControl c = f.asControl();
        setChild(c);
        return f;
    }

    public ScDiv setChildDiv()
    {
        ScDiv e;
        e = new ScDiv();
        setChild(e);
        return e;
    }

    public boolean hasChild()
    {
        return _child.hasValue();
    }

    //##################################################
    //# delegation
    //##################################################

    @Override
    public String getLabel()
    {
        return hasChild()
            ? getChild().getLabel()
            : null;
    }

    @Override
    public String getHelp()
    {
        return hasChild()
            ? getChild().getHelp()
            : null;
    }

    //##################################################
    //# children
    //##################################################

    @Override
    public final KmList<ScControl> getChildren()
    {
        return KmList.createWith(getChild());
    }

    //##################################################
    //# render
    //##################################################

    protected void renderChildOn(KmHtmlBuilder out)
    {
        out.render(getChild());
    }

}
