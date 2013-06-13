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

import java.util.Iterator;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.variable.ScLocalControl;
import com.kodemore.servlet.variable.ScLocalList;

public class ScRepeater
    extends ScControl
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalControl      _body;
    private ScLocalControl      _split;
    private ScLocalList<Object> _list;

    //##################################################
    //# constructor
    //##################################################

    @Override
    protected void install()
    {
        super.install();
        _body = new ScLocalControl();
        _split = new ScLocalControl();
        _list = new ScLocalList<Object>();
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        KmList<?> v = _list.getValue();
        ScControl body = _body.getValue();
        ScControl split = _split.getValue();

        if ( v == null )
            return;

        if ( body == null )
            return;

        Iterator<?> i = v.iterator();
        while ( i.hasNext() )
        {
            Object e = i.next();
            body.applyFromModel(e);
            body.renderOn(out);
            if ( i.hasNext() && split != null )
                split.renderOn(out);
        }
    }

    //##################################################
    //# accessing
    //##################################################

    public void setList(KmList<Object> e)
    {
        _list.setValue(e);
    }

    public void setBody(ScControl e)
    {
        e.setParent(this);
        _body.setValue(e);
    }

    public void setSplit(ScControl e)
    {
        e.setParent(this);
        _split.setValue(e);
    }

    public void setSplitBreak()
    {
        setSplit(new ScBreak());
    }
}
