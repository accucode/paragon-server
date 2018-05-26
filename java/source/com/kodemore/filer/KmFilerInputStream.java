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

package com.kodemore.filer;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

public class KmFilerInputStream
{
    //##################################################
    //# variables
    //##################################################

    private DataInputStream _inputStream;

    //##################################################
    //# constructor
    //##################################################

    public KmFilerInputStream(InputStream in)
    {
        _inputStream = new DataInputStream(in);
    }

    public void close()
    {
        try
        {
            _inputStream.close();
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void closeSafely()
    {
        Kmu.closeSafely(_inputStream);
    }

    //##################################################
    //# read (primitives)
    //##################################################

    public byte readByte()
    {
        try
        {
            return _inputStream.readByte();
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public char readCharacter()
    {
        try
        {
            return _inputStream.readChar();
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public int readInteger()
    {
        try
        {
            return _inputStream.readInt();
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public long readLong()
    {
        try
        {
            return _inputStream.readLong();
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public double readDouble()
    {
        try
        {
            return _inputStream.readDouble();
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public boolean readBoolean()
    {
        try
        {
            return _inputStream.readBoolean();
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public String readString()
    {
        try
        {
            if ( !_readExists() )
                return null;
            return _inputStream.readUTF();
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    //##################################################
    //# read (objects)
    //##################################################

    /**
     * Read an object of a known class type.
     */
    public KmFilerIF readObject(Class<?> c)
    {
        try
        {
            if ( !_readExists() )
                return null;

            KmFilerIF f;
            f = (KmFilerIF)c.newInstance();
            f.readFrom(this);
            return f;
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    /**
     * Read a class of unknown type.
     * When possible use readObject(class) instead.
     */
    public KmFilerIF readRuntimeObject()
    {
        try
        {
            if ( !_readExists() )
                return null;

            String s = _inputStream.readUTF();
            Class<?> c = Class.forName(s);
            return readObject(c);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    //##################################################
    //# read (lists)
    //##################################################

    /**
     * Read a homogeneous list.
     * The list may be null.
     * All list elements must be either null or class.
     */
    public KmList<?> readList(Class<?> c)
    {
        try
        {
            if ( !_readExists() )
                return null;
            int n = _inputStream.readInt();
            KmList<Object> v = new KmList<>(n);
            for ( int i = 0; i < n; i++ )
                v.add(readObject(c));
            return v;
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    /**
     * Read a homogeneous list.
     * The list may be null.
     * All list elements must be either null or class.
     */
    public KmList<?> readKmList(Class<?> c)
    {
        try
        {
            if ( !_readExists() )
                return null;

            int n = _inputStream.readInt();
            KmList<Object> v = new KmList<>(n);
            for ( int i = 0; i < n; i++ )
                v.add(readObject(c));

            return v;
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    /**
     * Read a heterogeneous list.
     * The list may be null.
     * The list elements may be null or any instance of KmFilerIF.
     * When possible, use readList(class) instead.
     */
    public KmList<?> readRuntimeList()
    {
        try
        {
            if ( !_readExists() )
                return null;
            int n = _inputStream.readInt();
            KmList<Object> v = new KmList<>(n);
            for ( int i = 0; i < n; i++ )
                v.add(readRuntimeObject());
            return v;
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public KmList<String> readStringList()
    {
        try
        {
            if ( !_readExists() )
                return null;

            int n = _inputStream.readInt();
            KmList<String> v = new KmList<>(n);
            for ( int i = 0; i < n; i++ )
                v.add(readString());

            return v;
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public Object[] readArray(Class<?> c)
    {
        try
        {
            if ( !_readExists() )
                return null;

            int n = _inputStream.readInt();
            Object[] arr = (Object[])Array.newInstance(c, n);
            for ( int i = 0; i < n; i++ )
                arr[i] = readObject(c);

            return arr;
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public byte[] readByteArray()
    {
        try
        {
            if ( !_readExists() )
                return null;

            int expected = _inputStream.readInt();
            byte[] arr = new byte[expected];
            int actual = _inputStream.read(arr);
            if ( actual != expected )
                throw new RuntimeException("Cannot read byte array.");

            return arr;
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public KmList<Double> readDoubleList()
    {
        try
        {
            if ( !_readExists() )
                return null;

            int n = _inputStream.readInt();
            KmList<Double> v = new KmList<>(n);
            for ( int i = 0; i < n; i++ )
                v.add(_inputStream.readDouble());

            return v;
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public KmList<Integer> readIntegerList()
    {
        try
        {
            if ( !_readExists() )
                return null;

            int n = _inputStream.readInt();
            KmList<Integer> v = new KmList<>(n);
            for ( int i = 0; i < n; i++ )
                v.add(_inputStream.readInt());

            return v;
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    //##################################################
    //# private
    //##################################################

    private boolean _readExists()
    {
        try
        {
            return _inputStream.readBoolean();
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

}
