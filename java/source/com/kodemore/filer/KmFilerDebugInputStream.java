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

import java.io.InputStream;

import com.kodemore.collection.KmList;

/**
 * This subclass reads extra data from the input stream to
 * detect if anything gets out of synch.  Usually synchronization
 * problems occur when the read method of some KmFilerIF does not
 * match its corresponding write method.  As soon as a sync problem
 * is detected a KmFilerSynchronizationException is throw; this
 * should make it fairly easy to track down the place where things
 * went wrong.
 *
 * NOTE: this subclass is for debugging only!  It seriously bloats
 * the resultant data streams.
 */
public class KmFilerDebugInputStream
    extends KmFilerInputStream
{
    //##################################################
    //# constructor
    //##################################################

    public KmFilerDebugInputStream(InputStream in)
    {
        super(in);
    }

    //##################################################
    //# read (primitives)
    //##################################################

    @Override
    public byte readByte()
    {
        int x = _readChecksum();
        byte e = super.readByte();
        _checkChecksum(x);
        return e;
    }

    @Override
    public char readCharacter()
    {
        int x = _readChecksum();
        char e = super.readCharacter();
        _checkChecksum(x);
        return e;
    }

    @Override
    public int readInteger()
    {
        int x = _readChecksum();
        int e = super.readInteger();
        _checkChecksum(x);
        return e;
    }

    @Override
    public long readLong()
    {
        int x = _readChecksum();
        long e = super.readLong();
        _checkChecksum(x);
        return e;
    }

    @Override
    public double readDouble()
    {
        int x = _readChecksum();
        double e = super.readDouble();
        _checkChecksum(x);
        return e;
    }

    @Override
    public boolean readBoolean()
    {
        int x = _readChecksum();
        boolean e = super.readBoolean();
        _checkChecksum(x);
        return e;
    }

    @Override
    public String readString()
    {
        int x = _readChecksum();
        String e = super.readString();
        _checkChecksum(x);
        return e;
    }

    //##################################################
    //# read (objects)
    //##################################################

    @Override
    public KmFilerIF readObject(Class<?> c)
    {
        int x = _readChecksum();
        KmFilerIF e = super.readObject(c);
        _checkChecksum(x);
        return e;
    }

    @Override
    public KmFilerIF readRuntimeObject()
    {
        int x = _readChecksum();
        KmFilerIF e = super.readRuntimeObject();
        _checkChecksum(x);
        return e;
    }

    //##################################################
    //# read (lists)
    //##################################################

    @Override
    public KmList<?> readList(Class<?> c)
    {
        int x = _readChecksum();
        KmList<?> e = super.readList(c);
        _checkChecksum(x);
        return e;
    }

    @Override
    public KmList<?> readKmList(Class<?> c)
    {
        int x = _readChecksum();
        KmList<?> e = super.readKmList(c);
        _checkChecksum(x);
        return e;
    }

    @Override
    public KmList<?> readRuntimeList()
    {
        int x = _readChecksum();
        KmList<?> e = super.readRuntimeList();
        _checkChecksum(x);
        return e;
    }

    @Override
    public KmList<String> readStringList()
    {
        int x = _readChecksum();
        KmList<String> e = super.readStringList();
        _checkChecksum(x);
        return e;
    }

    @Override
    public byte[] readByteArray()
    {
        int x = _readChecksum();
        byte[] e = super.readByteArray();
        _checkChecksum(x);
        return e;
    }

    //##################################################
    //# private
    //##################################################

    private int _readChecksum()
    {
        return super.readInteger();
    }

    private void _checkChecksum(int x)
    {
        if ( x != _readChecksum() )
            throw new KmFilerChecksumException();
    }
}
