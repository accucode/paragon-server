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

import com.kodemore.time.KmDate;

public class KmDbaseRecord
{
    //##################################################
    //# variables
    //##################################################

    private KmDbaseFile _file;
    private KmDbaseData _data;

    //##################################################
    //# accessing
    //##################################################

    public KmDbaseFile getFile()
    {
        return _file;
    }

    public void setFile(KmDbaseFile e)
    {
        _file = e;
    }

    public KmDbaseData getData()
    {
        return _data;
    }

    public void setData(KmDbaseData e)
    {
        _data = e;
    }

    public void setData(byte[] arr)
    {
        KmDbaseData d;
        d = new KmDbaseData();
        d.setBytes(arr);
        setData(d);
    }

    public int getFieldCount()
    {
        return getFile().getHeader().getFieldCount();
    }

    public KmDbaseFieldDescriptor getFieldDescriptor(int col)
    {
        return getFile().getFieldDescriptor(col);
    }

    public int getFieldDescriptorIndex(String name)
    {
        return getFile().getFieldDescriptorIndex(name);
    }

    //##################################################
    //# fields (name)
    //##################################################

    public String getString(String col)
    {
        return getString(getFieldDescriptorIndex(col));
    }

    public KmDate getDate(String col)
    {
        return getDate(getFieldDescriptorIndex(col));
    }

    public byte getByte(String col)
    {
        return getByte(getFieldDescriptorIndex(col));
    }

    public int getInteger(String col)
    {
        return getInteger(getFieldDescriptorIndex(col));
    }

    public long getLong(String col)
    {
        return getLong(getFieldDescriptorIndex(col));
    }

    public double getDouble(String col)
    {
        return getDouble(getFieldDescriptorIndex(col));
    }

    public boolean getBoolean(String col)
    {
        return getBoolean(getFieldDescriptorIndex(col));
    }

    //##################################################
    //# fields (index)
    //##################################################

    public String getString(int col)
    {
        KmDbaseFieldDescriptor fd = getFieldDescriptor(col);
        int i = fd.getOffset();
        int n = fd.getLength();
        return _data.getString(i, n);
    }

    public KmDate getDate(int col)
    {
        KmDbaseFieldDescriptor fd = getFieldDescriptor(col);
        int i = fd.getOffset();
        return _data.getStringDate(i);
    }

    public byte getByte(int col)
    {
        return (byte)getDouble(col);
    }

    public int getInteger(int col)
    {
        return (int)getDouble(col);
    }

    public long getLong(int col)
    {
        return (long)getDouble(col);
    }

    public double getDouble(int col)
    {
        KmDbaseFieldDescriptor fd = getFieldDescriptor(col);
        int i = fd.getOffset();
        int n = fd.getLength();
        return _data.getNumeric(i, n);
    }

    public boolean getBoolean(int col)
    {
        KmDbaseFieldDescriptor fd = getFieldDescriptor(col);
        int i = fd.getOffset();
        return _data.getLogical(i);
    }

}
