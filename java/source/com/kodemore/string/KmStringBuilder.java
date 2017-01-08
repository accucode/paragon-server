/*
  Copyright (c) 2005-2016 www.kodemore.com

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

package com.kodemore.string;

import com.kodemore.utility.KmConstantsIF;
import com.kodemore.utility.Kmu;

/**
 * An alternative to StringBuilder with a variety of convenience methods.
 */
public class KmStringBuilder
    implements CharSequence, KmConstantsIF
{
    //##################################################
    //# constants
    //##################################################

    private static final String LINE_END = CRLF;

    //##################################################
    //# variables
    //##################################################

    private StringBuilder       _buffer;

    //##################################################
    //# constructor
    //##################################################

    public KmStringBuilder()
    {
        _buffer = new StringBuilder();
    }

    public KmStringBuilder(String s)
    {
        _buffer = new StringBuilder(s);
    }

    //##################################################
    //# print
    //##################################################

    public void printf(String format, Object... args)
    {
        String s = Kmu.format(format, args);
        _buffer.append(s);
    }

    public void printfln(String format, Object... args)
    {
        printf(format, args);
        newLine();
    }

    public void print(Object e)
    {
        _buffer.append(e);
    }

    public void println(Object e)
    {
        print(e);
        newLine();
    }

    public void println()
    {
        newLine();
    }

    public void printRepeat(Object e, int n)
    {
        for ( int i = 0; i < n; i++ )
            print(e);
    }

    public void printSpaces(int n)
    {
        printRepeat(SPACE, n);
    }

    public void printTabs(int n)
    {
        printRepeat(TAB, n);
    }

    public void newLine()
    {
        _buffer.append(LINE_END);
    }

    //##################################################
    //# misc
    //##################################################

    public void clear()
    {
        _buffer.setLength(0);
    }

    public int getLength()
    {
        return _buffer.length();
    }

    public boolean isEmpty()
    {
        return getLength() == 0;
    }

    public boolean isNotEmpty()
    {
        return !isEmpty();
    }

    //##################################################
    //# equals
    //##################################################

    @Override
    public boolean equals(Object e)
    {
        return e instanceof KmStringBuilder
            && ((KmStringBuilder)e)._buffer.toString().equals(_buffer.toString());
    }

    @Override
    public int hashCode()
    {
        return _buffer.toString().hashCode();
    }

    //##################################################
    //# display
    //##################################################

    /**
     * Return this contents of the buffer.
     */
    @Override
    public String toString()
    {
        return _buffer.toString();
    }

    //##################################################
    //# delegation
    //##################################################

    public StringBuilder append(boolean b)
    {
        return _buffer.append(b);
    }

    public StringBuilder append(char c)
    {
        return _buffer.append(c);
    }

    public StringBuilder append(char[] str, int offset, int len)
    {
        return _buffer.append(str, offset, len);
    }

    public StringBuilder append(char[] str)
    {
        return _buffer.append(str);
    }

    public StringBuilder append(CharSequence s, int start, int end)
    {
        return _buffer.append(s, start, end);
    }

    public StringBuilder append(CharSequence s)
    {
        return _buffer.append(s);
    }

    public StringBuilder append(double d)
    {
        return _buffer.append(d);
    }

    public StringBuilder append(float f)
    {
        return _buffer.append(f);
    }

    public StringBuilder append(int i)
    {
        return _buffer.append(i);
    }

    public StringBuilder append(long lng)
    {
        return _buffer.append(lng);
    }

    public StringBuilder append(Object obj)
    {
        return _buffer.append(obj);
    }

    public StringBuilder append(String str)
    {
        return _buffer.append(str);
    }

    public StringBuilder append(StringBuffer sb)
    {
        return _buffer.append(sb);
    }

    public StringBuilder appendCodePoint(int codePoint)
    {
        return _buffer.appendCodePoint(codePoint);
    }

    public int capacity()
    {
        return _buffer.capacity();
    }

    @Override
    public char charAt(int index)
    {
        return _buffer.charAt(index);
    }

    public int codePointAt(int index)
    {
        return _buffer.codePointAt(index);
    }

    public int codePointBefore(int index)
    {
        return _buffer.codePointBefore(index);
    }

    public int codePointCount(int beginIndex, int endIndex)
    {
        return _buffer.codePointCount(beginIndex, endIndex);
    }

    public StringBuilder delete(int start, int end)
    {
        return _buffer.delete(start, end);
    }

    public StringBuilder deleteCharAt(int index)
    {
        return _buffer.deleteCharAt(index);
    }

    public void ensureCapacity(int minimumCapacity)
    {
        _buffer.ensureCapacity(minimumCapacity);
    }

    public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)
    {
        _buffer.getChars(srcBegin, srcEnd, dst, dstBegin);
    }

    public int indexOf(String str, int fromIndex)
    {
        return _buffer.indexOf(str, fromIndex);
    }

    public int indexOf(String str)
    {
        return _buffer.indexOf(str);
    }

    public StringBuilder insert(int offset, boolean b)
    {
        return _buffer.insert(offset, b);
    }

    public StringBuilder insert(int offset, char c)
    {
        return _buffer.insert(offset, c);
    }

    public StringBuilder insert(int index, char[] str, int offset, int len)
    {
        return _buffer.insert(index, str, offset, len);
    }

    public StringBuilder insert(int offset, char[] str)
    {
        return _buffer.insert(offset, str);
    }

    public StringBuilder insert(int dstOffset, CharSequence s, int start, int end)
    {
        return _buffer.insert(dstOffset, s, start, end);
    }

    public StringBuilder insert(int dstOffset, CharSequence s)
    {
        return _buffer.insert(dstOffset, s);
    }

    public StringBuilder insert(int offset, double d)
    {
        return _buffer.insert(offset, d);
    }

    public StringBuilder insert(int offset, float f)
    {
        return _buffer.insert(offset, f);
    }

    public StringBuilder insert(int offset, int i)
    {
        return _buffer.insert(offset, i);
    }

    public StringBuilder insert(int offset, long l)
    {
        return _buffer.insert(offset, l);
    }

    public StringBuilder insert(int offset, Object obj)
    {
        return _buffer.insert(offset, obj);
    }

    public StringBuilder insert(int offset, String str)
    {
        return _buffer.insert(offset, str);
    }

    public int lastIndexOf(String str, int fromIndex)
    {
        return _buffer.lastIndexOf(str, fromIndex);
    }

    public int lastIndexOf(String str)
    {
        return _buffer.lastIndexOf(str);
    }

    @Override
    public int length()
    {
        return _buffer.length();
    }

    public int offsetByCodePoints(int index, int codePointOffset)
    {
        return _buffer.offsetByCodePoints(index, codePointOffset);
    }

    public StringBuilder replace(int start, int end, String str)
    {
        return _buffer.replace(start, end, str);
    }

    public StringBuilder reverse()
    {
        return _buffer.reverse();
    }

    public void setCharAt(int index, char ch)
    {
        _buffer.setCharAt(index, ch);
    }

    public void setLength(int newLength)
    {
        _buffer.setLength(newLength);
    }

    @Override
    public CharSequence subSequence(int start, int end)
    {
        return _buffer.subSequence(start, end);
    }

    public String substring(int start, int end)
    {
        return _buffer.substring(start, end);
    }

    public String substring(int start)
    {
        return _buffer.substring(start);
    }

    public void trimToSize()
    {
        _buffer.trimToSize();
    }

    //##################################################
    //# testing
    //##################################################

    public boolean startsWith(CharSequence s)
    {
        return toString().startsWith(s.toString());
    }

    public boolean endsWith(CharSequence s)
    {
        return toString().endsWith(s.toString());
    }

    //##################################################
    //# remove
    //##################################################

    public boolean removePrefix(CharSequence prefix)
    {
        if ( !startsWith(prefix) )
            return false;

        delete(0, prefix.length());
        return true;
    }

    public boolean removeSuffix(CharSequence suffix)
    {
        if ( !endsWith(suffix) )
            return false;

        int n = length();
        delete(n - suffix.length(), n);
        return true;
    }

    //##################################################
    //# pad
    //##################################################

    /**
     * Use spaces to pad the buffer to a specified length.
     */
    public void padToLength(int n)
    {
        while ( length() < n )
            append(" ");
    }

    /**
     * Use spaces to pad the buffer to the next increment.
     * For example, padToIncrement(4) will increase the
     * length to 4, 8, 12, 16.
     */
    public void padToIncrement(int n)
    {
        while ( length() % n != 0 )
            append(" ");
    }

    //##################################################
    //# convenience
    //##################################################

    public void space()
    {
        print(SPACE);
    }

    public void trim()
    {
        String value = toString().trim();
        setLength(0);
        append(value);
    }

}
