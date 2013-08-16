/*
  Copyright (c) 2005-2013 www.kodemore.com

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
import com.kodemore.utility.Kmu;

public class KmDbaseData
{
    //##################################################
    //# variables
    //##################################################

    private byte[] _bytes;

    //##################################################
    //# accessing
    //##################################################

    public byte[] getBytes()
    {
        return _bytes;
    }

    public void setBytes(byte[] e)
    {
        _bytes = e;
    }

    public int unsignedAt(int i)
    {
        return _bytes[i] & 0xFF;
    }

    //##################################################
    //# abstract accessing
    //##################################################

    public char getCharacter(int index)
    {
        return (char)unsignedAt(index);
    }

    /**
     * Read a string of up to n characters starting at index.
     * The string may be terminated early by a null (0) terminator.
     */
    public String getString(int index, int n)
    {
        StringBuilder sb;
        sb = new StringBuilder(n);
        for ( int i = 0; i < n; i++ )
        {
            char c = (char)_bytes[index + i];
            if ( c == 0 )
                break;
            sb.append(c);
        }
        return sb.toString();
    }

    /**
     * Assume 8-character format: YYYYMMDD.
     */
    public KmDate getStringDate(int index)
    {
        String y = getString(index, 4);
        String m = getString(index + 4, 2);
        String d = getString(index + 6, 2);

        int yy = Kmu.parse_int(y);
        int mm = Kmu.parse_int(m);
        int dd = Kmu.parse_int(d);

        return KmDate.create(yy, mm, dd);
    }

    /**
     * Assume three byte format: YMD.
     * Year is the offest from 1900.
     */
    public KmDate getBinaryDate(int index)
    {
        int yy = 1900 + get1ByteInteger(index);
        int mm = get1ByteInteger(index + 1);
        int dd = get1ByteInteger(index + 2);
        return KmDate.create(yy, mm, dd);
    }

    /**
     * Get the one byte integer at index.
     */
    public int get1ByteInteger(int index)
    {
        return unsignedAt(index);
    }

    /**
     * Get the two byte integer at index.
     * Assume least significant byte comes first.
     */
    public int get2ByteInteger(int index)
    {
        return unsignedAt(index) | unsignedAt(index + 1) << 8;
    }

    /**
     * Get the four byte integer at index.
     * Assume least significant byte comes first.
     */
    public int get4ByteInteger(int index)
    {
        return unsignedAt(index)
            | unsignedAt(index + 1) << 8
            | unsignedAt(index + 2) << 16
            | unsignedAt(index + 3) << 24;
    }

    /**
     * Assume string format; right justified; space filled.
     * Valid characters include: digits, minus, decimal.
     */
    public double getNumeric(int index, int length)
    {
        String s;
        s = getString(index, length);
        s = s.trim();
        return Kmu.parse_double(s);
    }

    /**
     * Assume 1-character format either t, or f.
     */
    public boolean getLogical(int index)
    {
        String s;
        s = getString(index, 1);
        s = s.toUpperCase();

        if ( s.equals("Y") )
            return true;

        if ( s.equals("T") )
            return true;

        return false;
    }

}
