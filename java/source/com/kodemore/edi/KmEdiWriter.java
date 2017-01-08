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

package com.kodemore.edi;

import static com.kodemore.edi.KmEdiConstantsIF.CHAR_ELEMENT_SEPARATOR;
import static com.kodemore.edi.KmEdiConstantsIF.CHAR_ESCAPE;
import static com.kodemore.edi.KmEdiConstantsIF.CHAR_SEGMENT_END;
import static com.kodemore.edi.KmEdiConstantsIF.CHAR_VALUE_SEPARATOR;

import java.io.IOException;
import java.io.Writer;

/**
 * I am used to parse an edi interchange.
 */
public class KmEdiWriter
{
    //##################################################
    //# variables
    //##################################################

    private Writer _out;

    //##################################################
    //# constructor
    //##################################################

    public KmEdiWriter(Writer out)
    {
        _out = out;
    }

    //##################################################
    //# write
    //##################################################

    public void writeInterchange(KmEdiInterchange i) throws IOException
    {
        for ( KmEdiSegment s : i.getSegments() )
            writeSegment(s);
    }

    public void writeMessage(KmEdiMessage message) throws IOException
    {
        for ( KmEdiSegment s : message.getSegments() )
            writeSegment(s);
    }

    public void writeSegment(KmEdiSegment s) throws IOException
    {
        _out.write(s.getTag());
        for ( KmEdiElement e : s.getElements() )
        {
            _out.write(CHAR_ELEMENT_SEPARATOR);
            writeElement(e);
        }
        _out.write(CHAR_SEGMENT_END);
    }

    public void writeElement(KmEdiElement e) throws IOException
    {
        String[] arr = e.getValues();

        int n = arr.length;
        if ( n == 0 )
            return;

        writeValue(arr[0]);

        for ( int i = 1; i < n; i++ )
        {
            _out.write(CHAR_VALUE_SEPARATOR);
            writeValue(arr[i]);
        }
    }

    public void writeValue(String s) throws IOException
    {
        for ( char c : s.toCharArray() )
        {
            if ( needsEscape(c) )
                _out.write(CHAR_ESCAPE);

            _out.write(c);
        }
    }

    public boolean needsEscape(char c)
    {
        return c == CHAR_VALUE_SEPARATOR
            || c == CHAR_ELEMENT_SEPARATOR
            || c == CHAR_SEGMENT_END
            || c == CHAR_ESCAPE;
    }

    public void flush() throws IOException
    {
        _out.flush();
    }

}
