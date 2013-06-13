package com.kodemore.javaParser;

import java.io.File;

import com.kodemore.file.KmFile;
import com.kodemore.utility.Kmu;

public class KmParser
{
    //##################################################
    //# constants
    //##################################################

    public static final char   QUOTE     = '"';
    public static final char   TICK      = '\'';
    public static final char   BACKSPACE = '\\';

    public static final String CR        = "\r";
    public static final String LF        = "\n";
    public static final String CRLF      = CR + LF;

    //##################################################
    //# variables
    //##################################################

    private String             _source;
    private char[]             _array;
    private int                _index;

    //##################################################
    //# accessing
    //##################################################

    public String getSource()
    {
        return _source;
    }

    public void setSource(String s)
    {
        _source = s;
        _array = s.toCharArray();
        _index = 0;
    }

    public void setSourceFile(String path)
    {
        String s = Kmu.readTextFile(path);
        setSource(s);
    }

    public void setSourceFile(File f)
    {
        String s = Kmu.readTextFile(f);
        setSource(s);
    }

    public void setSourceFile(KmFile f)
    {
        String s = f.readString();
        setSource(s);
    }

    public void resetIndex()
    {
        _index = 0;
    }

    public char getCharacter(int i)
    {
        return _array[i];
    }

    public int getSize()
    {
        return _array.length;
    }

    public int getIndex()
    {
        return _index;
    }

    public String getSubstring(int begin, int end)
    {
        return _source.substring(begin, end);
    }

    //##################################################
    //# testing
    //##################################################

    public char getCharacter()
    {
        return getCharacter(_index);
    }

    public boolean isWhitespace()
    {
        return isAny(" \t\n\r");
    }

    public boolean is(char c)
    {
        if ( isEnd() )
            return false;
        return getCharacter(_index) == c;
    }

    public boolean is(String s)
    {
        int n = s.length();
        for ( int i = 0; i < n; i++ )
        {
            int x = _index + i;
            if ( !checkIndex(x) )
                return false;

            if ( x >= getSize() )
                return false;

            if ( getCharacter(x) != s.charAt(i) )
                return false;
        }
        return true;
    }

    public boolean isAny(String s)
    {
        if ( isEnd() )
            return false;
        char c = getCharacter();
        return s.indexOf(c) >= 0;
    }

    public boolean isEnd()
    {
        return _index == getSize();
    }

    public boolean isQuote()
    {
        return is(QUOTE);
    }

    public boolean isTick()
    {
        return is(TICK);
    }

    public boolean isBackslash()
    {
        return is(BACKSPACE);
    }

    //##################################################
    //# check
    //##################################################

    private boolean checkIndex(int x)
    {
        return x >= 0 && x < getSize();
    }

    //##################################################
    //# read
    //##################################################

    public String readUntilEol()
    {
        return readUntilAny(CRLF);
    }

    public String readUntilAny(String s)
    {
        StringBuilder sb = new StringBuilder();
        while ( true )
        {
            if ( isEnd() || isAny(s) )
                break;
            sb.append(getCharacter());
            _index++;
        }
        return sb.toString();
    }

    public String readUntil(char c)
    {
        StringBuilder sb = new StringBuilder();
        while ( true )
        {
            if ( isEnd() || is(c) )
                break;
            sb.append(getCharacter());
            _index++;
        }
        return sb.toString();
    }

    //##################################################
    //# skip
    //##################################################

    public void skipThrough(char c)
    {
        skipUntil(c);
        skip();
    }

    public boolean skipThrough(String s)
    {
        if ( skipUntil(s) )
        {
            skip(s.length());
            return true;
        }
        return false;
    }

    public void skipUntil(char c)
    {
        while ( true )
        {
            if ( isEnd() || is(c) )
                break;
            _index++;
        }
    }

    public boolean skipUntil(String s)
    {
        while ( true )
        {
            if ( isEnd() )
                return false;

            if ( is(s) )
                return true;

            _index++;
        }
    }

    public void skipUntilAny(String s)
    {
        while ( true )
        {
            if ( isEnd() || isAny(s) )
                break;
            _index++;
        }
    }

    public void skip()
    {
        skip(1);
    }

    public void skip(int n)
    {
        _index += n;
        _index = Math.min(_index, getSize());
    }

    public void skipUntilEol()
    {
        skipUntilAny(CRLF);
    }

    public void skipThroughEol()
    {
        skipUntilEol();
        if ( is(CRLF) )
            skip(2);
        else
            skip(1);
    }

}
