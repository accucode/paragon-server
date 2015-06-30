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

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.utility.Kmu;

public class KmWikiTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        new KmWikiTest().runForever();
    }

    //##################################################
    //# run
    //##################################################

    /**
     * Run the test repeatedly.  Combined with the meta refresh
     * tag in the in html sample, this make an easy way to quickly
     * test changes to the wiki markup.
     */
    public void runForever()
    {
        while ( true )
        {
            runOnce();
            Kmu.sleepSeconds(1);
        }
    }

    /**
     * Read the sample file, convert the wiki to html and write it to a file.
     */
    public void runOnce()
    {
        KmWiki wiki;
        wiki = new KmWiki();
        wiki.enableLiterals();

        wiki.parse(getSource());
        wiki.printErrors();

        String html = wiki.getHtml();
        writeSampleFile(html);

        // wiki.getDocument().dumpTree();
    }

    /**
     * Read the sample wiki source from the text file
     * store in this same package.
     */
    private String getSource()
    {
        String file = "wikiSample.txt";
        String path = "com/kodemore/wiki/" + file;
        return Kmu.readResourceString(getClass(), path);
    }

    /**
     * Write a complete html file to the temp directory.
     * This includes the basic html/body wrappers.
     * Also a meta refresh tag for convenient testing.
     */
    private void writeSampleFile(String body)
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();

        out.beginHtml();
        out.beginHead();
        out.printMetaRefresh(1);
        out.endHead();

        out.beginBody();
        out.printLiteral(body);
        out.endBody();

        out.endHtml();

        Kmu.writeFile("/temp/test.html", out.toString());
    }
}
