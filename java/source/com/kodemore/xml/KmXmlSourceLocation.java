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

package com.kodemore.xml;

import java.io.Serializable;

import com.kodemore.utility.Kmu;

public class KmXmlSourceLocation
    implements Serializable
{
    //##################################################
    //# variables
    //##################################################

    private String _name;
    private String _source;
    private int    _row;
    private int    _column;

    //##################################################
    //# accessing
    //##################################################

    public String getName()
    {
        return _name;
    }

    public void setName(String e)
    {
        _name = e;
    }

    public String getSource()
    {
        return _source;
    }

    public void setSource(String e)
    {
        _source = e;
    }

    public int getRow()
    {
        return _row;
    }

    public void setRow(int e)
    {
        _row = e;
    }

    public int getColumn()
    {
        return _column;
    }

    public void setColumn(int e)
    {
        _column = e;
    }

    //##################################################
    //# abstract accessing
    //##################################################

    public String getSourceLine()
    {
        return Kmu.getLines(_source).get(_row - 1);
    }

    public String getMarkerLine()
    {
        return Kmu.repeat(' ', getColumn() - 1) + "^";
    }

    //##################################################
    //# copy
    //##################################################

    public KmXmlSourceLocation getCopy()
    {
        return Kmu.getSerializedCopy(this);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return Kmu.format("Location(%s)", _name);
    }

    public void print()
    {
        System.out.println("Name: " + _name);
        System.out.println("Row:  " + _row);
        System.out.println("Col:  " + _column);
        System.out.println(getSourceLine());
        System.out.println(getMarkerLine());
    }

}
