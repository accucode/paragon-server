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

import com.kodemore.time.KmDate;
import com.kodemore.utility.Kmu;

public class KmDbaseHeader
{
    //##################################################
    //# variables
    //##################################################

    private KmDbaseData _data;

    //##################################################
    //# accessing
    //##################################################

    public int getVersion()
    {
        return _data.get1ByteInteger(0) & 7;
    }

    public boolean getMemoFlag()
    {
        return (_data.get1ByteInteger(0) & 64) != 0;
    }

    public KmDate getLastUpdate()
    {
        return _data.getBinaryDate(1);
    }

    public int getRecordCount()
    {
        return _data.get4ByteInteger(4);
    }

    public int getHeaderByteCount()
    {
        return _data.get2ByteInteger(8);
    }

    public int getRecordByteCount()
    {
        return _data.get2ByteInteger(10);
    }

    //##################################################
    //# abstract accessing
    //##################################################

    public int getFieldCount()
    {
        return (getHeaderByteCount() - 1) / 32 - 1;
    }

    //##################################################
    //# file
    //##################################################

    public void read(String path)
    {
        RandomAccessFile in = null;
        try
        {
            byte[] arr = new byte[32];
            in = new RandomAccessFile(path, "r");

            int n = in.read(arr);
            if ( n != arr.length )
                throw new RuntimeException("Unable to read header.");

            _data = new KmDbaseData();
            _data.setBytes(arr);
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
