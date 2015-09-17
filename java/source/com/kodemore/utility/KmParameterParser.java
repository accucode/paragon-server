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

import java.util.Iterator;

import com.kodemore.collection.KmList;

/**
 * Parse a string in the form "key1=value1 key2='value2' key3 key4=".
 * The parser is fairly tolerant; that is, spaces before and after the
 * equal sign are ignored.  The user may or may not assign a value to
 * a given argument; the equal sign is not even required.  If values
 * are not quoted then they terminate at the first whitespace.  If values
 * are quoted they may use either single or double quotes.  Within a
 * quoted value, the backslash (\) may be used to escape any character
 * included the quote used for the value's terminiation.  See the main
 * method for some concrete examples.
 */
public class KmParameterParser
{
    //##################################################
    //# public
    //##################################################

    /**
     * Parse the string and return the ordered list of KmParameter.
     * Values of null, and values of empty string are distinct.  There
     * are basically three cases:
     *
     *    1) key=value
     *    2) key=
     *    3) value
     *
     * The first case parses the key and associates the value.
     * The second case parses the key add sets the value to empty string.
     * The third case sets only the value, the key is null.
     */
    public static KmList<KmParameter> parse(String... args)
    {
        StringBuilder out = new StringBuilder();
        int n = args.length;
        for ( int i = 0; i < n; i++ )
        {
            out.append(args[i]);
            out.append(" ");
        }
        String s = out.toString().trim();
        return new KmParameterParser()._parse(s);
    }

    //##################################################
    //# constants
    //##################################################

    public static final char ESCAPE       = '\\';
    public static final char DOUBLE_QUOTE = '\"';
    public static final char SINGLE_QUOTE = '\'';

    //##################################################
    //# variables
    //##################################################

    private int                 _index;
    private char[]              _characters;
    private KmList<KmParameter> _parameters;

    private boolean _quoted;

    //##################################################
    //# private
    //##################################################

    private KmParameterParser()
    {
        // use static methods instead.
    }

    private KmList<KmParameter> _parse(String s)
    {
        _index = 0;
        _characters = s.toCharArray();
        _parameters = new KmList<>();
        while ( true )
        {
            String key = readKey();
            boolean keyQuoted = _quoted;
            if ( key.length() == 0 && !keyQuoted )
                break;
            String value = readValue();
            boolean valueQuoted = _quoted;
            if ( value == null )
                add(key, keyQuoted);
            else
                add(key, keyQuoted, value, valueQuoted);
        }
        return _parameters;
    }

    private void add(String key, boolean keyQuoted)
    {
        add(key, keyQuoted, null, false);
    }

    private void add(String key, boolean keyQuoted, String value, boolean valueQuoted)
    {
        KmParameter e;
        e = new KmParameter();
        e.setKey(key);
        e.setKeyQuoted(keyQuoted);
        e.setValue(value);
        e.setValueQuoted(valueQuoted);
        _parameters.add(e);
    }

    private String readKey()
    {
        return readWord();
    }

    private String readValue()
    {
        skipBlanks();
        if ( atEnd() )
            return null;
        if ( current() != '=' )
            return null;
        next();
        if ( isLetter() )
            return readWord();
        skipBlanks();
        if ( atEnd() )
            return "";
        if ( current() == SINGLE_QUOTE )
            return readQuotedValue();
        if ( current() == DOUBLE_QUOTE )
            return readQuotedValue();
        return "";
    }

    private String readWord()
    {
        _quoted = false;
        skipBlanks();
        if ( atEnd() )
            return "";
        if ( current() == SINGLE_QUOTE )
            return readQuotedValue();
        if ( current() == DOUBLE_QUOTE )
            return readQuotedValue();
        StringBuilder sb = new StringBuilder();
        while ( isLetter() )
        {
            sb.append(current());
            next();
        }
        return sb.toString();
    }

    private String readQuotedValue()
    {
        _quoted = true;
        char q = current();
        return readQuotedValue(q);
    }

    private String readQuotedValue(char q)
    {
        next();
        StringBuilder sb = new StringBuilder();
        while ( true )
        {
            if ( atEnd() )
                break;
            if ( isNotEscaped() && current() == q )
            {
                next();
                break;
            }
            sb.append(current());
            next();
        }
        return sb.toString();
    }

    private void skipBlanks()
    {
        while ( isBlank() )
            next();
    }

    private boolean isLetter()
    {
        if ( atEnd() )
            return false;
        char c = current();

        if ( Kmu.isLetter(c) )
            return true;

        if ( Kmu.isDigit(c) )
            return true;

        if ( "._:/@".indexOf(c) >= 0 )
            return true;
        return false;
    }

    private boolean isBlank()
    {
        if ( atEnd() )
            return false;

        char c = current();

        if ( c == ' ' )
            return true;

        if ( c == '\t' )
            return true;

        if ( c == '\r' )
            return true;

        if ( c == '\n' )
            return true;

        return false;
    }

    private void next()
    {
        _index += isEscaped()
            ? 2
            : 1;
    }

    private char current()
    {
        return isEscaped()
            ? _characters[_index + 1]
            : _characters[_index];
    }

    private boolean isNotEscaped()
    {
        return !isEscaped();
    }

    private boolean isEscaped()
    {
        return _characters[_index] == ESCAPE;
    }

    private boolean atEnd()
    {
        return _index >= _characters.length;
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String args[])
    {
        String s = " a b= c=\"double\" d='single' e = f =abc g = 'xyz' h='sing\\'le' 'v a l u e' z";
        Iterator<KmParameter> i = KmParameterParser.parse(s).iterator();
        while ( i.hasNext() )
            System.out.println(i.next());
    }
}
