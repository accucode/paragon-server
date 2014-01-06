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

package com.kodemore.utility;

import java.util.zip.CRC32;

public class KmCrc
{
    public static int crc(int a)
    {
        CRC32 x = new CRC32();
        x.update(a);
        return (int)x.getValue();
    }

    public static int crc(byte[] a)
    {
        CRC32 x = new CRC32();
        x.update(a);
        return (int)x.getValue();
    }

    public static int crc(String a)
    {
        CRC32 x = new CRC32();
        x.update(a.getBytes());
        return (int)x.getValue();
    }

    public static int crc(int a, int b)
    {
        CRC32 x = new CRC32();
        x.update(a);
        x.update(b);
        return (int)x.getValue();
    }

    public static int crc(int a, int b, int c)
    {
        CRC32 x = new CRC32();
        x.update(a);
        x.update(b);
        x.update(c);
        return (int)x.getValue();
    }

    public static int crc(byte[] a, byte[] b, byte[] c, int d)
    {
        CRC32 x = new CRC32();
        x.update(a);
        x.update(b);
        x.update(c);
        x.update(d);
        return (int)x.getValue();
    }

    public static int crc(byte[] a, byte[] b, int c)
    {
        CRC32 x = new CRC32();
        x.update(a);
        x.update(b);
        x.update(c);
        return (int)x.getValue();
    }

}
