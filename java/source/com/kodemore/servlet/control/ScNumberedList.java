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
import com.kodemore.servlet.variable.ScLocalString;

public class ScNumberedList
    extends ScChildContainerElement
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalString _type;

    //##################################################
    //# constructor
    //##################################################

    public ScNumberedList()
    {
        // none
    }

    //##################################################
    //# type
    //##################################################

    public String getType()
    {
        return _type.getValue();
    }

    public void setType(String e)
    {
        _type.setValue(e);
    }

    public void setTypeNumber()
    {
        setType("1");
    }

    public void setTypeLetterUpper()
    {
        setType("A");
    }

    public void setTypeLetterLower()
    {
        setType("a");
    }

    public void setTypeRomanUpper()
    {
        setType("I");
    }

    public void setTypeRomanLower()
    {
        setType("i");
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.open("ol");
        renderAttributesOn(out);
        out.close();

        KmList<ScControl> v = getChildren();
        for ( ScControl e : v )
        {
            out.begin("li");
            out.render(e);
            out.end("li");
        }

        out.end("ol");
    }
}
