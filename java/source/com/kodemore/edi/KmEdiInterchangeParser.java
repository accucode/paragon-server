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

package com.kodemore.edi;

import static com.kodemore.edi.KmEdiConstantsIF.CHAR_ELEMENT_SEPARATOR;
import static com.kodemore.edi.KmEdiConstantsIF.CHAR_ESCAPE;
import static com.kodemore.edi.KmEdiConstantsIF.CHAR_SEGMENT_END;
import static com.kodemore.edi.KmEdiConstantsIF.CHAR_VALUE_SEPARATOR;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import com.kodemore.collection.KmList;
import com.kodemore.utility.KmReaderProcessorIF;
import com.kodemore.utility.Kmu;

/**
 * I am used to parse an edi interchange.
 */
public class KmEdiInterchangeParser
{
    //##################################################
    //# constants
    //##################################################

    private static final int TAG_LENGTH = 3;

    //##################################################
    //# public (static)
    //##################################################

    public static Object parseSource(String name, String source)
    {
        StringReader r = new StringReader(source);
        return parseReader(name, r);
    }

    public static Object parseReader(String name, Reader r)
    {
        return new KmEdiInterchangeParser().process(name, r);
    }

    public static Object parseFile(String name, File f)
    {
        return parseFile(name, f.getPath());
    }

    public static KmEdiInterchange parseFile(String path)
    {
        String name = path;
        return parseFile(name, path);
    }

    public static KmEdiInterchange parseFile(String name, String path)
    {
        KmReaderProcessorIF p = new KmReaderProcessorIF()
        {
            @Override
            public Object process(Reader r, Object... args)
            {
                String s = (String)args[0];
                return parseReader(s, r);
            }
        };
        return (KmEdiInterchange)Kmu.process(path, p, name);
    }

    //##################################################
    //# constructor
    //##################################################

    private KmEdiInterchangeParser()
    {
        // enfore singleton pattern.
    }

    //##################################################
    //# variables
    //##################################################

    private String              _name;
    private Reader              _reader;
    private KmEdiInterchange    _interchange;

    public char                 _next;
    public boolean              _escape;

    public KmList<KmEdiElement> _elements;
    public KmList<String>       _values;
    public StringBuilder        _valueBuffer;

    //##################################################
    //# process
    //##################################################

    public Object process(String name, Reader r)
    {
        _name = name;
        _reader = r;
        _interchange = new KmEdiInterchange();
        _elements = new KmList<>();
        _values = new KmList<>();
        _valueBuffer = new StringBuilder();

        read();
        readSegments();
        validate();

        return _interchange;
    }

    private void readSegments()
    {
        while ( true )
        {
            skipWhitespace();

            if ( atEnd() )
                break;

            KmEdiSegment e = readSegment();
            _interchange.addSegment(e);
        }
    }

    private KmEdiSegment readSegment()
    {
        String tag = readElementTag();
        validate(tag);
        _elements.clear();

        while ( !atSegmentEnd() && !atEnd() )
        {
            KmEdiElement e = readElement();

            if ( e == null )
                throw newFatal("Cannot read element.");

            _elements.add(e);
        }

        if ( !atEnd() )
            skipSegmentEnd();

        return new KmEdiSegment(tag, _elements);
    }

    private void validate(String tag)
    {
        if ( tag.length() != TAG_LENGTH )
            throw newFatal("Segment tag has incorrect length");
    }

    private String readElementTag()
    {
        KmEdiElement e = readElement();

        if ( e == null )
            throw newFatal("Cannot read tag element.");

        if ( !e.isSimple() )
            throw newFatal("Segment tag must be simple.");

        return e.getValue();
    }

    private KmEdiElement readElement()
    {
        _values.clear();

        while ( true )
        {
            while ( !atValueEnd() )
            {
                _valueBuffer.append(_next);
                read();
            }

            String s = _valueBuffer.toString().intern();
            _valueBuffer.setLength(0);
            _values.add(s);

            if ( atValueSeparator() )
            {
                skipValueSeparator();
                continue;
            }

            if ( atElementSeparator() )
            {
                skipElementSeparator();
                break;
            }

            if ( atSegmentEnd() )
                break;

            if ( atEnd() )
                break;
        }

        return composeElement();
    }

    private KmEdiElement composeElement()
    {
        KmList<String> v = _values;

        int n = v.size();
        if ( n == 0 )
            throw newFatal("Element must have at least 1 value.");

        return new KmEdiElement(v);
    }

    //##################################################
    //# accessing
    //##################################################

    public String getName()
    {
        return _name;
    }

    //##################################################
    //# read
    //##################################################

    private void read()
    {
        _escape = false;

        int i = _read();
        if ( i < 0 )
        {
            _next = 0;
            return;
        }

        _next = (char)i;

        if ( _next == CHAR_ESCAPE )
        {
            _escape = true;

            i = _read();
            if ( i < 0 )
                throw newFatal("File cannot end with escape character.");

            _next = (char)i;
        }
    }

    private int _read()
    {
        try
        {
            return _reader.read();
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    //##################################################
    //# testing
    //##################################################

    private boolean atSegmentEnd()
    {
        return at(CHAR_SEGMENT_END);
    }

    private boolean atElementSeparator()
    {
        return at(CHAR_ELEMENT_SEPARATOR);
    }

    private boolean atValueSeparator()
    {
        return at(CHAR_VALUE_SEPARATOR);
    }

    private boolean atValueEnd()
    {
        return atElementSeparator() || atValueSeparator() || atSegmentEnd() || atEnd();
    }

    private boolean atEnd()
    {
        return _next == 0;
    }

    private boolean at(char c)
    {
        return _escape
            ? false
            : _next == c;
    }

    //##################################################
    //# skip
    //##################################################

    private void skipSegmentEnd()
    {
        skip(CHAR_SEGMENT_END);
    }

    private void skipElementSeparator()
    {
        skip(CHAR_ELEMENT_SEPARATOR);
    }

    private void skipValueSeparator()
    {
        skip(CHAR_VALUE_SEPARATOR);
    }

    private void skip(char c)
    {
        if ( _next != c )
            throw newFatal("Cannot skip %1, found %2 instead.", c, _next);

        read();
    }

    private void skipWhitespace()
    {
        skipAny(" \n\r");
    }

    private void skipAny(String s)
    {
        while ( true )
        {
            if ( atEnd() )
                return;

            if ( s.indexOf(_next) < 0 )
                return;

            read();
        }
    }

    //##################################################
    //# validate
    //##################################################

    private void validate()
    {
        // make sure the header and trailer exist...
    }

    //##################################################
    //# utility
    //##################################################

    private RuntimeException newFatal(String msg, Object... args)
    {
        return Kmu.newFatal(msg, args);
    }
}
