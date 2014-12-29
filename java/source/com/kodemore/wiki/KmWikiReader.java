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

package com.kodemore.wiki;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;
import com.kodemore.wiki.parsers.KmWikiBoldParser;
import com.kodemore.wiki.parsers.KmWikiContainer;
import com.kodemore.wiki.parsers.KmWikiDocument;
import com.kodemore.wiki.parsers.KmWikiDocumentParser;
import com.kodemore.wiki.parsers.KmWikiElement;
import com.kodemore.wiki.parsers.KmWikiHeaderParser;
import com.kodemore.wiki.parsers.KmWikiItalicParser;
import com.kodemore.wiki.parsers.KmWikiLiteralParser;
import com.kodemore.wiki.parsers.KmWikiNewLine;
import com.kodemore.wiki.parsers.KmWikiNoWikiParser;
import com.kodemore.wiki.parsers.KmWikiOrderedListParser;
import com.kodemore.wiki.parsers.KmWikiParser;
import com.kodemore.wiki.parsers.KmWikiQuoteParser;
import com.kodemore.wiki.parsers.KmWikiRuleParser;
import com.kodemore.wiki.parsers.KmWikiStrikeoutParser;
import com.kodemore.wiki.parsers.KmWikiText;
import com.kodemore.wiki.parsers.KmWikiUnderlineParser;
import com.kodemore.wiki.parsers.KmWikiUnorderedListParser;

public class KmWikiReader
    implements KmWikiConstantsIF
{
    //##################################################
    //# variables
    //##################################################

    private KmList<KmWikiParser> _parsers;
    private boolean              _enabledLiterals;

    private String               _sourceText;
    private char[]               _source;

    private int                  _index;
    private int                  _rowIndex;
    private int                  _columnIndex;

    private StringBuilder        _text;
    private KmWikiSource         _textSource;

    private KmList<StackElement> _stack;
    private KmList<KmWikiError>  _errors;

    private KmWikiDocument       _document;

    //##################################################
    //# constructor
    //##################################################

    public KmWikiReader()
    {
        installParsers();
    }

    //##################################################
    //# accesing
    //##################################################

    public void setEnabledLiterals(boolean e)
    {
        _enabledLiterals = e;
    }

    public boolean getEnabledLiterals()
    {
        return _enabledLiterals;
    }

    //##################################################
    //# read
    //##################################################

    public void read(String wiki)
    {
        _index = 0;
        _rowIndex = 0;
        _columnIndex = 0;

        _sourceText = normalize(wiki);
        _source = _sourceText.toCharArray();

        _text = new StringBuilder();
        _stack = new KmList<>();
        _errors = new KmList<>();

        KmWikiDocumentParser parser = new KmWikiDocumentParser(this);
        KmWikiDocument doc = new KmWikiDocument(getSource());
        push(parser, doc);

        parseAll();

        _document = doc;
    }

    public KmWikiDocument getDocument()
    {
        return _document;
    }

    public KmList<KmWikiError> getErrors()
    {
        return _errors;
    }

    //##################################################
    //# install
    //##################################################

    private void installParsers()
    {
        _parsers = new KmList<>();

        addParser(new KmWikiLiteralParser(this));
        addParser(new KmWikiNoWikiParser(this));

        addParser(new KmWikiOrderedListParser(this));
        addParser(new KmWikiUnorderedListParser(this));
        addParser(new KmWikiQuoteParser(this));

        addParser(new KmWikiRuleParser(this));
        addParser(new KmWikiHeaderParser(this));

        addParser(new KmWikiBoldParser(this));
        addParser(new KmWikiItalicParser(this));
        addParser(new KmWikiUnderlineParser(this));
        addParser(new KmWikiStrikeoutParser(this));
    }

    private void addParser(KmWikiParser e)
    {
        _parsers.add(e);
    }

    //##################################################
    //# parse
    //##################################################

    private void parseAll()
    {
        while ( notAtEnd() )
            parse();

        endDocument();
    }

    private void parse()
    {
        if ( checkParserStack() )
            return;

        if ( startParser() )
            return;

        appendText(_source[_index]);
        advance();
    }

    private boolean startParser()
    {
        KmWikiSource source = getSource();
        for ( KmWikiParser e : _parsers )
            if ( e.start(source) )
                return true;

        return false;
    }

    private boolean checkParserStack()
    {
        KmWikiSource source = getSource();

        KmList<StackElement> v;
        v = _stack.getShallowCopy();
        v.reverse();

        for ( StackElement e : v )
            if ( e.parser.parse(source, e.element) )
                return true;

        return false;
    }

    //##################################################
    //# advance
    //##################################################

    public void advance()
    {
        if ( _index >= _source.length )
            // warn
            return;

        char c = _source[_index];

        _index++;
        _columnIndex++;

        if ( c == LF )
        {
            _rowIndex++;
            _columnIndex = 0;
        }
    }

    public void advance(int n)
    {
        advanceTo(_index + n);
    }

    public void advanceTo(int i)
    {
        while ( _index < i )
            advance();
    }

    public KmWikiSource getSource()
    {
        KmWikiSource e;
        e = new KmWikiSource();
        e.setText(_sourceText);
        e.setIndex(_index);
        e.setRowIndex(_rowIndex);
        e.setColumnIndex(_columnIndex);
        return e;
    }

    //##################################################
    //# skip
    //##################################################

    public void skipWhitespace()
    {
        while ( notAtEnd() && atWhitespace() )
            advance();
    }

    public void skipToNextLine()
    {
        skipToNext(LF);
        advance();
    }

    public void skipToNext(char c)
    {
        int i = findNext(c);
        if ( i < 0 )
            advanceTo(_source.length);
        else
            advanceTo(i);
    }

    public String readTo(int j)
    {
        int count = j - _index;
        String s = new String(_source, _index, count);
        advanceTo(j);
        return s;
    }

    //##################################################
    //# find
    //##################################################

    /**
     * Find the next occurence, starting at the current position.
     */
    public int findNext(char c)
    {
        return findNext(c, 0);
    }

    public int findNext(char c, int offset)
    {
        int i = _index + offset;
        int j = _source.length - 1;
        while ( i <= j )
        {
            if ( _source[i] == c )
                return i;
            i++;
        }
        return -1;
    }

    /**
     * Find the next occurence, starting at the current position.
     */
    public int findNext(String s)
    {
        return findNext(s, 0);
    }

    /**
     * Find the next occurence, starting at the current position,
     * plus the offset.
     */
    public int findNext(String s, int offset)
    {
        char[] chars = s.toCharArray();
        int n = chars.length;

        int index = _index + offset;
        int max = _source.length - n;
        while ( true )
        {
            if ( index > max )
                return -1;

            if ( _at(index, chars) )
                return index;

            index++;
        }
    }

    /**
     * Get the text from the current position, to the end of line,
     * not including the trailing LF.  This does not move the index.
     */
    public String getLine()
    {
        int i = _index;
        int j = findNext(LF);
        int count = j - i;
        return new String(_source, i, count);
    }

    /**
     * Count how many times the current character is repeated.
     */
    public int getRunLength()
    {
        int n = 1;
        int i = _index;
        char c = _source[i];

        int max = _source.length - 1;
        while ( i < max )
        {
            i++;
            if ( _source[i] != c )
                break;
            n++;
        }
        return n;
    }

    //##################################################
    //# testing
    //##################################################

    public boolean at(char c)
    {
        return _source[_index] == c;
    }

    public boolean notAt(char c)
    {
        return !at(c);
    }

    public boolean at(String s)
    {
        char[] chars = s.toCharArray();
        int n = chars.length;

        if ( _index + n > _source.length )
            return false;

        return _at(_index, chars);
    }

    private boolean _at(int index, char[] chars)
    {
        for ( int i = 0; i < chars.length; i++ )
            if ( _source[index + i] != chars[i] )
                return false;

        return true;
    }

    public boolean notAt(String s)
    {
        return !at(s);
    }

    public boolean atWhitespace()
    {
        return isWhitespace(_source[_index]);
    }

    public boolean atLineStart()
    {
        return atStart() || _source[_index - 1] == LF;
    }

    public boolean notAtLineStart()
    {
        return !atLineStart();
    }

    public boolean atStart()
    {
        return _index == 0;
    }

    public boolean atEnd()
    {
        return _index >= _source.length;
    }

    public boolean notAtEnd()
    {
        return !atEnd();
    }

    //##################################################
    //# text
    //##################################################

    public void appendText(char c)
    {
        checkTextStart();
        _text.append(c);
    }

    public void appendText(String s)
    {
        checkTextStart();
        _text.append(s);
    }

    private void checkTextStart()
    {
        if ( _text.length() == 0 )
            _textSource = getSource();
    }

    public void newLine()
    {
        closeText();
        add(new KmWikiNewLine(getSource()));
    }

    public boolean trimTrailingLineEnd()
    {
        return trimTrailingChar(LF);
    }

    public boolean trimTrailingSpace()
    {
        return trimTrailingChar(SPACE);
    }

    public boolean trimTrailingSpaces()
    {
        return trimTrailingChars(SPACE);
    }

    private boolean trimTrailingChars(char c)
    {
        boolean changed = false;
        while ( true )
        {
            if ( !trimTrailingChar(c) )
                break;
            changed = true;
        }
        return changed;
    }

    private boolean trimTrailingChar(char c)
    {
        int i = _text.length() - 1;
        if ( i < 0 )
            return false;

        if ( _text.charAt(i) != c )
            return false;

        _text.setLength(i);
        return true;
    }

    public void closeText()
    {
        if ( _text.length() == 0 )
            return;

        String s = _text.toString();
        _text.setLength(0);

        KmWikiText text;
        text = new KmWikiText(_textSource);
        text.setValue(s);

        add(text);
    }

    //##################################################
    //# push / pop
    //##################################################

    public void push(KmWikiParser parser, KmWikiContainer element)
    {
        closeText();
        if ( element.isBlock() )
            autoPopNonBlocks();

        KmWikiContainer current = getTopElement();
        if ( current != null )
            current.addChild(element);

        StackElement e;
        e = new StackElement();
        e.parser = parser;
        e.element = element;
        _stack.add(e);
    }

    public void add(KmWikiElement e)
    {
        getTopElement().addChild(e);
    }

    public void pop()
    {
        closeText();
        _stack.removeLast();
    }

    public void autoPopTo(KmWikiElement parent)
    {
        closeText();
        while ( true )
        {
            KmWikiContainer e = getTopElement();
            if ( e == parent )
                break;

            autoPopError(e);
            pop();
        }
    }

    private void endDocument()
    {
        closeText();

        while ( _stack.isNotEmpty() )
        {
            StackElement top = _stack.getLastSafe();

            KmWikiParser p = top.parser;
            KmWikiContainer e = top.element;

            if ( p.endDocument() )
                continue;

            autoPopError(e);
            pop();
        }
    }

    public void autoPopNonBlocks()
    {
        closeText();

        while ( true )
        {
            KmWikiElement e = getTopElement();
            if ( e == null || e.isBlock() )
                break;

            autoPopError(e);
            pop();
        }
    }

    private void autoPopError(KmWikiElement e)
    {
        addError(e, "Element(%s) missing close.", e.getName());
    }

    public KmWikiContainer getTopElement()
    {
        StackElement e = _stack.getLastSafe();
        if ( e == null )
            return null;

        return e.element;
    }

    public KmWikiParser getTopParser()
    {
        StackElement e = _stack.getLastSafe();
        if ( e == null )
            return null;

        return e.parser;
    }

    //##################################################
    //# errors
    //##################################################

    public void addError(KmWikiElement e, String msg, Object... args)
    {
        String message = Kmu.format(msg, args);

        KmWikiSource source;
        source = e.getSource();

        KmWikiError error;
        error = new KmWikiError();
        error.setMessage(message);
        error.setSource(source);
        _errors.add(error);
    }

    //##################################################
    //# support
    //##################################################

    private boolean isWhitespace(char c)
    {
        // tabs and cr's are removed during normalize.
        return c == SPACE || c == LF;
    }

    /**
     * Deal with non-printable chars, line endings, and tabs up front.
     */
    private String normalize(String source)
    {
        try
        {
            if ( source == null )
                return "";

            StringBuilder out = new StringBuilder();

            StringReader sr = new StringReader(source);
            BufferedReader in = new BufferedReader(sr);
            while ( true )
            {
                String line = in.readLine();
                if ( line == null )
                    break;

                line = Kmu.replaceAll(line, TAB, SPACE);
                line = Kmu.stripNonSingleLinePrintable(line);
                line = Kmu.trimTrailing(line);

                out.append(line);
                out.append(LF);
            }
            return out.toString();
        }
        catch ( IOException ex )
        {
            throw new RuntimeException("Cannot normalize source.");
        }
    }

    //##################################################
    //# inner class
    //##################################################

    private static class StackElement
    {
        KmWikiParser    parser;
        KmWikiContainer element;
    }

}
