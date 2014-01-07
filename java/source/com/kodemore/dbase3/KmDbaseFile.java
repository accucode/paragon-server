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

package com.kodemore.dbase3;

import java.io.RandomAccessFile;
import java.util.List;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

public class KmDbaseFile
{
    //##################################################
    //# variables
    //##################################################

    private String                         _path;
    private KmDbaseHeader                  _header;
    private KmList<KmDbaseFieldDescriptor> _fieldDescriptors;

    //##################################################
    //# accessing
    //##################################################

    public String getPath()
    {
        return _path;
    }

    public void setPath(String e)
    {
        _path = e;
    }

    public KmDbaseHeader getHeader()
    {
        if ( _header == null )
            readHeader();

        return _header;
    }

    public int getFieldDescriptorCount()
    {
        return getFieldDescriptors().size();
    }

    public List<KmDbaseFieldDescriptor> getFieldDescriptors()
    {
        if ( _fieldDescriptors == null )
            readFieldDescriptors();

        return _fieldDescriptors;
    }

    public KmDbaseFieldDescriptor getFieldDescriptor(int col)
    {
        return getFieldDescriptors().get(col);
    }

    public int getFieldDescriptorIndex(String name)
    {
        int n = getFieldDescriptorCount();
        for ( int i = 0; i < n; i++ )
            if ( getFieldDescriptor(i).hasName(name) )
                return i;

        return -1;
    }

    //##################################################
    //# io
    //##################################################

    public void readHeader()
    {
        _header = new KmDbaseHeader();
        _header.read(_path);
    }

    public void readFieldDescriptors()
    {
        _fieldDescriptors = new KmList<KmDbaseFieldDescriptor>();
        int fieldOffset = 0;
        int n = getHeader().getFieldCount();
        for ( int i = 0; i < n; i++ )
        {
            int offset = (i + 1) * 32;
            int length = 32;
            byte[] b = _readByteArray(offset, length);

            KmDbaseFieldDescriptor fd;
            fd = new KmDbaseFieldDescriptor();
            fd.setData(b);
            fd.setOffset(fieldOffset);
            _fieldDescriptors.add(fd);

            fieldOffset += fd.getLength();
        }
    }

    public int getRecordCount()
    {
        return getHeader().getRecordCount();
    }

    public KmDbaseRecord getRecord(int index)
    {
        KmDbaseHeader h = getHeader();
        int length = h.getRecordByteCount();
        int offset = h.getHeaderByteCount() + length * index + 1;
        byte[] arr = _readByteArray(offset, length);

        KmDbaseRecord r;
        r = new KmDbaseRecord();
        r.setFile(this);
        r.setData(arr);
        return r;
    }

    public KmDbaseRecordReader getRecordReader()
    {
        return new KmDbaseRecordReader(this);
    }

    //##################################################
    //# utility
    //##################################################

    public byte[] _readByteArray(int offset, int length)
    {
        String path = getPath();
        RandomAccessFile in = null;
        try
        {
            byte[] arr;
            arr = new byte[length];

            in = new RandomAccessFile(path, "r");
            in.seek(offset);

            int n = in.read(arr);
            if ( n != length )
                Kmu.fatal("Cannot read offset(%s) length(%s).", offset, length);

            return arr;
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
        finally
        {
            Kmu.closeSafely(in);
        }
    }

}
