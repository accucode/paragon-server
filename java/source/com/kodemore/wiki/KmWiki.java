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

package com.kodemore.wiki;

import com.kodemore.collection.KmList;
import com.kodemore.wiki.parsers.KmWikiDocument;

/**
 * The basic entry point for the wiki tool.
 * For basic usage just see the main method.
 */
public class KmWiki
{
    //##################################################
    //# main
    //##################################################

    /**
     * This main method is provided to demonstrate basic usage.
     * See also KmWikiTest.
     */
    public static void main(String[] args)
    {
        String wiki = "Some **bold** text.";
        String html = KmWiki.quickParse(wiki);
        System.out.println(html);
    }

    //##################################################
    //# static
    //##################################################

    /**
     * A convenience method to quickly parse wiki markup.
     * This method does not provide access to options
     * settings, or error information.
     */
    public static String quickParse(String wiki)
    {
        KmWiki e;
        e = new KmWiki();
        e.parse(wiki);
        return e.getHtml();
    }

    //##################################################
    //# variables
    //##################################################

    private KmWikiReader _reader;

    //##################################################
    //# constructor
    //##################################################

    public KmWiki()
    {
        _reader = new KmWikiReader();
    }

    //##################################################
    //# accessing
    //##################################################

    /**
     * Convert wiki markup to html.
     */
    public void parse(String wiki)
    {
        _reader.read(wiki);
    }

    public KmWikiDocument getDocument()
    {
        return _reader.getDocument();
    }

    /**
     * The html result, created by parse().
     */
    public String getHtml()
    {
        return getDocument().printHtml();
    }

    /**
     * Literals are disabled by default, but you can
     * turn them on if desired.
     */
    public void enableLiterals()
    {
        _reader.setEnabledLiterals(true);
    }

    /**
     * Any errors that occurred during the parse.
     */
    public KmList<KmWikiError> getErrors()
    {
        return _reader.getErrors();
    }

    public boolean hasErrors()
    {
        return getErrors().isNotEmpty();
    }

    public boolean isOk()
    {
        return !hasErrors();
    }

    /**
     * A convenience method to print any errors to standard out.
     */
    public void printErrors()
    {
        KmList<KmWikiError> errors = getErrors();
        for ( KmWikiError error : errors )
        {
            KmWikiSource source = error.getSource();

            System.out.println("ERROR");
            System.out.printf(
                "%s Location(%s,%s).%n",
                error.getMessage(),
                source.getRow(),
                source.getColumn());
            System.out.println(source.getLine());
            System.out.println(source.getLinePointer());
            System.out.println();
        }
    }
}
