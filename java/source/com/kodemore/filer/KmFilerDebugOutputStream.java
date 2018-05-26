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

import java.io.OutputStream;
import java.util.List;

import com.kodemore.utility.KmRandom;

/**
 * This subclass writes extra data to the output stream to
 * detect if anything gets out of synch.  Usually synchronization
 * problems occur when the read method of some KmFilerIF does not
 * match its corresponding write method.  You must use the
 * KmFilerDebugInputStream to read a data stream created by this
 * class.
 *
 * NOTE: this subclass is for debugging only!  It significantly bloats
 * the resultant data streams.
 */
public class KmFilerDebugOutputStream
    extends KmFilerOutputStream
{
    //##################################################
    //# constructor
    //##################################################

    public KmFilerDebugOutputStream(OutputStream out)
    {
        super(out);
    }

    //##################################################
    //# write (primitives)
    //##################################################

    @Override
    public void writeByte(byte e)
    {
        int x = _createChecksum();
        _writeChecksum(x);
        super.writeByte(e);
        _writeChecksum(x);
    }

    @Override
    public void writeCharacter(char e)
    {
        int x = _createChecksum();
        _writeChecksum(x);
        super.writeCharacter(e);
        _writeChecksum(x);
    }

    @Override
    public void writeInteger(int e)
    {
        int x = _createChecksum();
        _writeChecksum(x);
        super.writeInteger(e);
        _writeChecksum(x);
    }

    @Override
    public void writeLong(long e)
    {
        int x = _createChecksum();
        _writeChecksum(x);
        super.writeLong(e);
        _writeChecksum(x);
    }

    @Override
    public void writeDouble(double e)
    {
        int x = _createChecksum();
        _writeChecksum(x);
        super.writeDouble(e);
        _writeChecksum(x);
    }

    @Override
    public void writeBoolean(boolean e)
    {
        int x = _createChecksum();
        _writeChecksum(x);
        super.writeBoolean(e);
        _writeChecksum(x);
    }

    @Override
    public void writeString(String e)
    {
        int x = _createChecksum();
        _writeChecksum(x);
        super.writeString(e);
        _writeChecksum(x);
    }

    //##################################################
    //# write (objects)
    //##################################################

    @Override
    public void writeObject(KmFilerIF e)
    {
        int x = _createChecksum();
        _writeChecksum(x);
        super.writeObject(e);
        _writeChecksum(x);
    }

    @Override
    public void writeRuntimeObject(KmFilerIF e)
    {
        int x = _createChecksum();
        _writeChecksum(x);
        super.writeRuntimeObject(e);
        _writeChecksum(x);
    }

    //##################################################
    //# write (lists)
    //##################################################

    @Override
    public void writeList(List<KmFilerIF> v)
    {
        int x = _createChecksum();
        _writeChecksum(x);
        super.writeList(v);
        _writeChecksum(x);
    }

    @Override
    public void writeRuntimeList(List<KmFilerIF> v)
    {
        int x = _createChecksum();
        _writeChecksum(x);
        super.writeRuntimeList(v);
        _writeChecksum(x);
    }

    @Override
    public void writeStringList(List<String> v)
    {
        int x = _createChecksum();
        _writeChecksum(x);
        super.writeStringList(v);
        _writeChecksum(x);
    }

    @Override
    public void writeByteArray(byte[] arr)
    {
        int x = _createChecksum();
        _writeChecksum(x);
        super.writeByteArray(arr);
        _writeChecksum(x);
    }

    //##################################################
    //# private
    //##################################################

    private int _createChecksum()
    {
        return KmRandom.getInstance().getInteger();
    }

    private void _writeChecksum(int x)
    {
        super.writeInteger(x);
    }
}
