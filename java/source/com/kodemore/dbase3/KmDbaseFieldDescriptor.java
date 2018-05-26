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

package com.kodemore.dbase3;

public class KmDbaseFieldDescriptor
{
    //##################################################
    //# constants
    //##################################################

    public static final char TYPE_CHARACTER = 'C';
    public static final char TYPE_DATE      = 'D';
    public static final char TYPE_NUMERIC   = 'N';
    public static final char TYPE_LOGICAL   = 'L';
    public static final char TYPE_MEMO      = 'M';

    //##################################################
    //# variables
    //##################################################

    private KmDbaseData _data;
    private int         _offset;

    //##################################################
    //# accessing
    //##################################################

    public void setData(byte[] arr)
    {
        _data = new KmDbaseData();
        _data.setBytes(arr);
    }

    public String getName()
    {
        return _data.getString(0, 11);
    }

    public boolean hasName(String s)
    {
        return getName().equalsIgnoreCase(s);
    }

    public char getType()
    {
        return _data.getCharacter(11);
    }

    public int getLength()
    {
        return _data.get1ByteInteger(16);
    }

    public int getDecimalCount()
    {
        return _data.get1ByteInteger(17);
    }

    public int getWorkAreaId()
    {
        return _data.get1ByteInteger(20);
    }

    public int getSetFieldsFlag()
    {
        return _data.get1ByteInteger(23);
    }

    public int getOffset()
    {
        return _offset;
    }

    public void setOffset(int e)
    {
        _offset = e;
    }

    //##################################################
    //# types
    //##################################################

    public boolean isCharacter()
    {
        return getType() == TYPE_CHARACTER;
    }

    public boolean isDate()
    {
        return getType() == TYPE_DATE;
    }

    public boolean isNumeric()
    {
        return getType() == TYPE_NUMERIC;
    }

    public boolean isLogical()
    {
        return getType() == TYPE_LOGICAL;
    }

    public boolean isMemo()
    {
        return getType() == TYPE_MEMO;
    }

}
