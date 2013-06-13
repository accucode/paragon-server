/*
  Copyright (c) 2010-2010 www.kodemore.com

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

package com.kodemore.jasper;

/**
 * I am used for simple tests.
 * I provide a data source that returns generic data for all fields.
 */
public class KmJasperEchoDataSource
    extends KmJasperAbstractDataSource
{
    //##################################################
    //# variables
    //##################################################

    private int _rowCount;
    private int _index;

    //##################################################
    //# constructor 
    //##################################################

    public KmJasperEchoDataSource(int rowCount)
    {
        _rowCount = rowCount;
        _index = 0;
    }

    //##################################################
    //# accessing
    //##################################################

    public int getRowCount()
    {
        return _rowCount;
    }

    public int getIndex()
    {
        return _index;
    }

    //##################################################
    //# override
    //##################################################

    @Override
    public void moveFirst()
    {
        _index = 0;
    }

    @Override
    public boolean next()
    {
        if ( _index == _rowCount )
            return false;

        _index++;
        return true;
    }

    @Override
    public Object getFieldValue(KmJasperFieldWrapper f)
    {
        if ( f.hasValueClassName("java.lang.String") )
            return f.getName() + "-" + _index;

        if ( f.hasValueClassName("java.lang.Integer") )
            return _index;

        throw new RuntimeException("Unsupported Type");
    }

}
