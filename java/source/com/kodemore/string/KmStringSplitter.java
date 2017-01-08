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

import java.awt.FontMetrics;
import java.io.PushbackReader;
import java.io.StringReader;
import java.util.Iterator;

import com.kodemore.collection.KmList;

/**
 * I am used to split a long string into multiple lines
 * while preserving whole words.  I can split lines
 * either by the number of characters per line or by the
 * number of pixels per line.
 */
public class KmStringSplitter
{
    //##################################################
    //# constants
    //##################################################

    public static final int CHARACTER = 0;
    public static final int PIXEL     = 1;

    //##################################################
    //# variables
    //##################################################

    private int             _width;
    private int             _firstWidth;
    private int             _mode;
    private FontMetrics     _fontMetrics;
    private boolean         _collapseWordBreaks;
    private String          _wordBreakCharacters;
    private String          _lineBreakCharacters;
    private boolean         _convertWordBreaksToSpace;
    private boolean         _allowTrailingWhiteSpace;

    //##################################################
    //# constructor
    //##################################################

    public KmStringSplitter()
    {
        _width = 50;
        _firstWidth = -1;
        _collapseWordBreaks = true;
        _wordBreakCharacters = " \t";
        _lineBreakCharacters = "\n";
        _mode = CHARACTER;
        _convertWordBreaksToSpace = false;
        _allowTrailingWhiteSpace = false;
    }

    //##################################################
    //# static
    //##################################################

    public static String splitByPixel(String s, int w, FontMetrics fm)
    {
        KmStringSplitter sp;
        sp = new KmStringSplitter();
        sp.setMode(PIXEL);
        sp.setWidth(w);
        sp.setFontMetrics(fm);
        return sp.getString(s);
    }

    public static String splitByCharacter(String s, int w)
    {
        KmStringSplitter sp;
        sp = new KmStringSplitter();
        sp.setMode(CHARACTER);
        sp.setWidth(w);
        return sp.getString(s);
    }

    //##################################################
    //# string splitting
    //##################################################

    public KmList<String> getList(String s)
    {
        return splitString(s);
    }

    public String getString(String s)
    {
        StringBuilder sb = new StringBuilder();
        Iterator<String> i = getList(s).iterator();
        if ( i.hasNext() )
            sb.append(i.next());
        while ( i.hasNext() )
        {
            sb.append('\n');
            sb.append(i.next());
        }
        return sb.toString();
    }

    //##################################################
    //# accessing
    //##################################################

    public int getWidth()
    {
        return _width;
    }

    public void setWidth(int e)
    {
        _width = e;
    }

    public int getFirstWidth()
    {
        return _firstWidth;
    }

    public void setFirstWidth(int e)
    {
        _firstWidth = e;
    }

    public void clearFirstWidth()
    {
        _firstWidth = -1;
    }

    public boolean hasFirstWidth()
    {
        return getFirstWidth() > 0;
    }

    public int getMode()
    {
        return _mode;
    }

    public void setMode(int e)
    {
        _mode = e;
    }

    public boolean getConvertWordBreaksToSpace()
    {
        return _convertWordBreaksToSpace;
    }

    public void setConvertWordBreaksToSpace(boolean e)
    {
        _convertWordBreaksToSpace = e;
    }

    public FontMetrics getFontMetrics()
    {
        return _fontMetrics;
    }

    public void setFontMetrics(FontMetrics e)
    {
        _fontMetrics = e;
    }

    public boolean getCollapseWordBreaks()
    {
        return _collapseWordBreaks;
    }

    public void setCollapseWordBreaks(boolean e)
    {
        _collapseWordBreaks = e;
    }

    public String getWordBreakCharacters()
    {
        return _wordBreakCharacters;
    }

    public void setWordBreakCharacters(String e)
    {
        _wordBreakCharacters = e;
    }

    public String getLineBreakCharacters()
    {
        return _lineBreakCharacters;
    }

    public void setLineBreakCharacters(String e)
    {
        _lineBreakCharacters = e;
    }

    public boolean getAllowTrailingWhiteSpace()
    {
        return _allowTrailingWhiteSpace;
    }

    public void setAllowTrailingWhiteSpace(boolean e)
    {
        _allowTrailingWhiteSpace = e;
    }

    //##################################################
    //# private
    //##################################################

    private TokenReader    _tokenReader;
    private Token          _token;
    private KmList<String> _lines;
    private StringBuilder  _line;
    private int            _lineWidth;

    private KmList<String> splitString(String s)
    {
        _tokenReader = new TokenReader(s);
        _lines = new KmList<>();
        _line = new StringBuilder();
        _lineWidth = 0;
        while ( true )
            if ( !handle() )
                break;
        return _lines;
    }

    private boolean handle()
    {
        _token = _tokenReader.readToken();

        if ( _token.isEnd() )
            return handleEnd();

        if ( _token.isWordBreak() )
            return handleWordBreak();

        if ( _token.isLineBreak() )
            return handleLineBreak();

        return handleWord();
    }

    private boolean handleEnd()
    {
        moveLineToList();
        return false;
    }

    private boolean handleWordBreak()
    {
        String wb = _token.getValue();
        if ( _convertWordBreaksToSpace )
            wb = " ";
        Token nextToken = _tokenReader.readToken();
        if ( nextToken.isWord() )
        {
            String w = nextToken.getValue();
            if ( fitsOnLine(wb + w) )
            {
                addToLine(wb + w);
                return true;
            }
            moveLineToList();
            addToLine(w);
            return true;
        }
        if ( nextToken.isEnd() && _allowTrailingWhiteSpace )
            addToLine(wb);
        moveLineToList();
        return !nextToken.isEnd();
    }

    private boolean handleLineBreak()
    {
        moveLineToList();
        return true;
    }

    private boolean handleWord()
    {
        String s = _token.getValue();
        if ( !fitsOnLine(s) )
            moveLineToList();
        addToLine(s);
        return true;
    }

    private boolean fitsOnLine(String s)
    {
        return _lineWidth + getWidth(s) <= getCurrentWidth();
    }

    private int getCurrentWidth()
    {
        if ( isFirstLine() && hasFirstWidth() )
            return getFirstWidth();
        return getWidth();
    }

    private boolean isFirstLine()
    {
        return _lines.isEmpty();
    }

    private int getWidth(String s)
    {
        if ( getMode() == CHARACTER )
            return s.length();
        return getFontMetrics().stringWidth(s);
    }

    private void moveLineToList()
    {
        _lines.add(_line.toString());
        _line.setLength(0);
        _lineWidth = 0;
    }

    private void addToLine(String s)
    {
        _line.append(s);
        _lineWidth += getWidth(s);
    }

    //##################################################
    //# token
    //##################################################

    private class Token
    {
        public String _value;

        public Token()
        {
            _value = null;
        }

        public Token(char c)
        {
            _value = c + "";
        }

        public Token(StringBuilder sb)
        {
            _value = sb.toString();
        }

        public String getValue()
        {
            return _value;
        }

        public char getFirst()
        {
            if ( isEmpty() )
                return 0;
            return getValue().charAt(0);
        }

        public boolean isEnd()
        {
            return _value == null;
        }

        public boolean isEmpty()
        {
            return _value == null || _value.length() == 0;
        }

        public boolean isWordBreak()
        {
            if ( isEnd() )
                return false;
            return getWordBreakCharacters().indexOf(getFirst()) != -1;
        }

        public boolean isLineBreak()
        {
            if ( isEnd() )
                return false;
            return getLineBreakCharacters().indexOf(getFirst()) != -1;
        }

        public boolean isWhitespace()
        {
            return isLineBreak() || isWordBreak();
        }

        public boolean isWord()
        {
            return !(isEnd() || isWhitespace());
        }

        @Override
        public String toString()
        {
            if ( isEnd() )
                return "END";
            if ( isWordBreak() )
                return "WordBreak: " + _value.length();
            if ( isLineBreak() )
                return "LineBreak";
            return "Word: " + quote(_value);
        }

        public String quote(String s)
        {
            return "'" + s + "'";
        }
    }

    //##################################################
    //# token reader
    //##################################################

    private class TokenReader
    {
        public PushbackReader _reader;
        public Token          _buffer;

        public TokenReader(String s)
        {
            StringReader sr = new StringReader(s);
            _reader = new PushbackReader(sr);
        }

        public Token readToken()
        {
            if ( hasBuffer() )
                return popBuffer();
            return parseNextToken();
        }

        public Token parseNextToken()
        {
            char c = read();
            if ( c == 0 )
                return new Token();
            StringBuilder sb = new StringBuilder();
            if ( isWord(c) )
            {
                while ( isWord(c) )
                {
                    sb.append(c);
                    c = read();
                }
                unread(c);
                return new Token(sb);
            }
            if ( isWordBreak(c) )
            {
                while ( isWordBreak(c) )
                {
                    sb.append(c);
                    c = read();
                }
                unread(c);
                return new Token(sb);

            }
            if ( isLineBreak(c) )
                return new Token(c);
            return null;
        }

        public boolean isWord(char c)
        {
            return !(isEof(c) || isWordBreak(c) || isLineBreak(c));
        }

        public boolean isEof(char c)
        {
            return c == 0;
        }

        public boolean isWordBreak(char c)
        {
            return getWordBreakCharacters().indexOf(c) != -1;
        }

        public boolean isLineBreak(char c)
        {
            return getLineBreakCharacters().indexOf(c) != -1;
        }

        public char read()
        {
            try
            {
                int i = _reader.read();
                if ( i <= 0 )
                    return 0;
                return (char)i;
            }
            catch ( Exception ex )
            {
                ex.printStackTrace();
                return 0;
            }
        }

        public void unread(char c)
        {
            try
            {
                if ( c == 0 )
                    return;
                _reader.unread(c);
            }
            catch ( Exception ex )
            {
                ex.printStackTrace();
            }
        }

        public boolean hasBuffer()
        {
            return _buffer != null;
        }

        public Token popBuffer()
        {
            if ( !hasBuffer() )
                return null;
            Token t = _buffer;
            _buffer = null;
            return t;
        }
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String args[])
    {
        String s = "abc def  a b";

        KmStringSplitter sp;
        sp = new KmStringSplitter();
        sp.setConvertWordBreaksToSpace(false);
        sp.setWidth(10);
        sp.setFirstWidth(-1);

        System.out.println();
        Iterator<String> i = sp.getList(s).iterator();
        System.out.println();
        System.out.println("12345678901234567890");
        System.out.println("---");
        while ( i.hasNext() )
            System.out.println(i.next());
        System.out.println("---");
    }

}
