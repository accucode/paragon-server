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

    /**
     * The list of values to be displayed.
     */
    private ScLocalList<Object> _values;

    /**
     * The control to be displayed for each values.  The attributes
     * of each value is applied to the body via applyFromModel.
     */
    private ScLocalControl      _body;

    /**
     * The split is rendered between each occurence of the body.
     */
    private ScLocalControl      _split;

    //##################################################
    //# constructor
    //##################################################

    public ScRepeater()
    {
        _values = new ScLocalList<>();
        _body = new ScLocalControl();
        _split = new ScLocalControl();
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        KmList<?> v = _values.getValue();
        ScControl body = _body.getValue();
        ScControl split = _split.getValue();

        if ( body == null )
            return;

        Iterator<?> i = v.iterator();
        while ( i.hasNext() )
        {
            Object e = i.next();
            body.applyFromModel(e);
            body.renderOn(out);

            if ( i.hasNext() )
                out.render(split);
        }
    }

    //##################################################
    //# accessing
    //##################################################

    public void setValues(KmList<Object> e)
    {
        _values.setValue(e);
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
