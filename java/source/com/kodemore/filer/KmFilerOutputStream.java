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

package com.kodemore.filer;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import com.kodemore.utility.Kmu;

public class KmFilerOutputStream
{
    //##################################################
    //# variables
    //##################################################

    private DataOutputStream _outputStream;

    //##################################################
    //# constructor
    //##################################################

    public KmFilerOutputStream(OutputStream out)
    {
        _outputStream = new DataOutputStream(out);
    }

    //##################################################
    //# stream
    //##################################################

    public void flush()
    {
        try
        {
            _outputStream.flush();
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void close()
    {
        try
        {
            _outputStream.close();
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void closeSafely()
    {
        Kmu.closeSafely(_outputStream);
    }

    //##################################################
    //# write (primitives)
    //##################################################

    public void writeByte(byte e)
    {
        try
        {
            _outputStream.writeByte(e);
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void writeCharacter(char e)
    {
        try
        {
            _outputStream.writeChar(e);
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void writeInteger(int e)
    {
        try
        {
            _outputStream.writeInt(e);
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void writeLong(long e)
    {
        try
        {
            _outputStream.writeLong(e);
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void writeDouble(double e)
    {
        try
        {
            _outputStream.writeDouble(e);
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void writeBoolean(boolean e)
    {
        try
        {
            _outputStream.writeBoolean(e);
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void writeString(String e)
    {
        try
        {
            if ( !_writeExists(e) )
                return;
            _outputStream.writeUTF(e);
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    //##################################################
    //# write (objects)
    //##################################################

    public void writeObject(KmFilerIF e)
    {
        if ( !_writeExists(e) )
            return;

        e.writeTo(this);
    }

    public void writeRuntimeObject(KmFilerIF e)
    {
        try
        {
            if ( !_writeExists(e) )
                return;

            _outputStream.writeUTF(e.getClass().getName());
            e.writeTo(this);
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    //##################################################
    //# write (lists)
    //##################################################

    /**
     * Write a homogenous list.
     */
    public void writeList(List<KmFilerIF> v)
    {
        try
        {
            if ( !_writeExists(v) )
                return;

            int n = v.size();
            _outputStream.writeInt(n);
            for ( int i = 0; i < n; i++ )
            {
                KmFilerIF f = v.get(i);
                writeObject(f);
            }
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    /**
     * Write a heterogeneous list.
     * When possible, use writeList instead.
     */
    public void writeRuntimeList(List<KmFilerIF> v)
    {
        try
        {
            if ( !_writeExists(v) )
                return;

            int n = v.size();
            _outputStream.writeInt(n);
            for ( int i = 0; i < n; i++ )
            {
                KmFilerIF f = v.get(i);
                writeRuntimeObject(f);
            }
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void writeStringList(List<String> v)
    {
        try
        {
            if ( !_writeExists(v) )
                return;

            int n = v.size();
            _outputStream.writeInt(n);
            for ( int i = 0; i < n; i++ )
            {
                String s = v.get(i);
                writeString(s);
            }
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void writeDoubleList(List<Double> v)
    {
        try
        {
            if ( !_writeExists(v) )
                return;

            int n = v.size();
            _outputStream.writeInt(n);
            for ( int i = 0; i < n; i++ )
            {
                Double dd = v.get(i);
                writeDouble(dd.doubleValue());
            }
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void writeIntegerList(List<Integer> v)
    {
        try
        {
            if ( !_writeExists(v) )
                return;

            int n = v.size();
            _outputStream.writeInt(n);
            for ( int i = 0; i < n; i++ )
            {
                Integer ii = v.get(i);
                writeInteger(ii.intValue());
            }
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void writeArray(KmFilerIF[] arr)
    {
        try
        {
            if ( !_writeExists(arr) )
                return;

            int n = arr.length;
            _outputStream.writeInt(arr.length);
            for ( int i = 0; i < n; i++ )
                writeObject(arr[i]);
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void writeByteArray(byte[] arr)
    {
        try
        {
            if ( !_writeExists(arr) )
                return;

            _outputStream.writeInt(arr.length);
            _outputStream.write(arr);
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    //##################################################
    //# private
    //##################################################

    private boolean _writeExists(Object e)
    {
        try
        {
            boolean exists = e != null;
            _outputStream.writeBoolean(exists);
            return exists;
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }
}
