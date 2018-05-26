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

package com.kodemore.collection;

import java.io.Serializable;
import java.util.Arrays;

import com.kodemore.utility.KmCopyIF;
import com.kodemore.utility.Kmu;

/**
 * I am a simple wrapper for a primitive byte array.  I am used
 * to simplify code that needs to work with byte arrays but does
 * not want to handle explicit arrays.
 */
public class KmBlob
    implements KmCopyIF, Serializable, Comparable<KmBlob>
{
    //##################################################
    //# variables
    //##################################################

    private byte[] _bytes;

    //##################################################
    //# constructors
    //##################################################

    public KmBlob()
    {
        _bytes = new byte[0];
    }

    public KmBlob(byte[] data)
    {
        _bytes = data;
    }

    public KmBlob(String s)
    {
        this();
        setUtfValue(s);
    }

    //##################################################
    //# accessing
    //##################################################

    public byte[] getValue()
    {
        return _bytes;
    }

    public void setValue(byte[] data)
    {
        _bytes = data;
    }

    public boolean hasValue()
    {
        return _bytes != null && _bytes.length > 0;
    }

    //==================================================
    //= string value
    //==================================================

    public String getUtfValue()
    {
        return hasValue()
            ? Kmu.bytesToUtf(getValue())
            : null;
    }

    public void setUtfValue(String s)
    {
        if ( s == null )
            setValue(null);
        else
            setValue(Kmu.utfToBytes(s));
    }

    //##################################################
    //# abstract accessing
    //##################################################

    public byte get(int index)
    {
        return _bytes[index];
    }

    public void set(int index, byte value)
    {
        _bytes[index] = value;
    }

    public boolean isEmpty()
    {
        return _bytes.length == 0;
    }

    public boolean isNotEmpty()
    {
        return !isEmpty();
    }

    public int getSize()
    {
        return _bytes.length;
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object e)
    {
        if ( e instanceof KmBlob )
            return Arrays.equals(_bytes, ((KmBlob)e).getValue());

        return false;
    }

    @Override
    public int hashCode()
    {
        return Arrays.hashCode(_bytes);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        int max = 100;
        String s;

        if ( _bytes.length > max )
            s = formatHexDisplayString(max) + "...";
        else
            s = formatHexDisplayString();

        return Kmu.format("%s(%s)", Kmu.getSimpleClassName(this), s);
    }

    public String formatHexDisplayString(int maxBytes)
    {
        return Kmu.formatHexDisplayString(_bytes, maxBytes);
    }

    public String formatHexDisplayString()
    {
        return Kmu.formatHexDisplayString(_bytes);
    }

    public String formatString()
    {
        return new String(_bytes);
    }

    @Override
    public Object getCopy()
    {
        return Kmu.getSerializedCopy(this);
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public int compareTo(KmBlob blob)
    {
        // consider all blobs equal
        return 0;
    }
}
