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

import java.io.PrintWriter;
import java.io.StringWriter;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmOrderedMap;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.utility.Kmu;

/**
 * I generate a complete html page that provides simple samples
 * of wiki formatting.
 */
public class KmWikiSample
{
    //##################################################
    //# public
    //##################################################

    public static void main(String... args)
    {
        Kmu.writeFile("/temp/test.html", getSample());
    }

    public static String getSample()
    {
        return new KmWikiSample().run();
    }

    //##################################################
    //# variables
    //##################################################

    private KmOrderedMap<String,String> _samples;

    private String       _name;
    private StringWriter _stringWriter;
    private PrintWriter  _printWriter;

    //##################################################
    //# run
    //##################################################

    private String run()
    {
        return formatHtml();
    }

    //##################################################
    //# private (format)
    //##################################################

    private String formatHtml()
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.beginHtml();

        out.beginHead();
        out.beginTitle();
        out.print("Wiki Sample");
        out.endTitle();
        out.endHead();

        out.beginBody();

        String tableStyle;
        tableStyle = null;
        tableStyle = Kmu.joinHtmlStyle(tableStyle, "border-collapse", "collapse");

        String cellStyle;
        cellStyle = null;
        cellStyle = Kmu.joinHtmlStyle(cellStyle, "border", "1px solid black");
        cellStyle = Kmu.joinHtmlStyle(cellStyle, "padding", "5px");
        cellStyle = Kmu.joinHtmlStyle(cellStyle, "text-align", "left");
        cellStyle = Kmu.joinHtmlStyle(cellStyle, "vertical-align", "top");

        out.open("table");
        out.printAttribute("style", tableStyle);
        out.close();

        KmOrderedMap<String,String> samples = getSamples();
        KmList<String> names = samples.getKeys();
        for ( String name : names )
        {
            String wiki = samples.get(name);
            String html = KmWiki.quickParse(wiki);

            out.begin("tr");

            out.open("td");
            out.printAttribute("style", cellStyle);
            out.close();
            out.print(name);
            out.end("td");

            out.open("td");
            out.printAttribute("style", cellStyle);
            out.close();
            out.printPreformatted(wiki);
            out.end("td");

            out.open("td");
            out.printAttribute("style", cellStyle);
            out.close();
            out.printLiteral(html);
            out.end("td");

            out.end("tr");
        }
        out.end("table");

        out.endBody();
        out.endHtml();
        return out.toString();
    }

    //##################################################
    //# private (samples)
    //##################################################

    private KmOrderedMap<String,String> getSamples()
    {
        if ( _samples == null )
            installSamples();

        return _samples;
    }

    private void installSamples()
    {
        _samples = new KmOrderedMap<>();

        addSimpleSample();
        addHeaderSample();
        addRuleSample();
        addBulletListSample();
        addNumberedListSample();
        addQuoteSample();
        addNoWikiSample();
    }

    private void addSimpleSample()
    {
        PrintWriter out;
        out = startSample("Simple");
        out.println("This is normal text.");
        out.println("This is **bold** text.");
        out.println("This is //italic// text.");
        out.println("This is __underlined__ text.");
        out.println("This is --strikeout-- text.");
        out.println();
        out.println("Simple formats can be nested...");
        out.println("**bold //italic// bold**.");
        endSample();
    }

    private void addHeaderSample()
    {
        PrintWriter out;
        out = startSample("Headers");
        out.println("= Header 1 =");
        out.println("== Header 2 ==");
        out.println("=== Header 3 ===");
        out.println("==== Header 4 ====");
        out.println("===== Header 5 =====");
        endSample();
    }

    private void addRuleSample()
    {
        PrintWriter out;
        out = startSample("Rule");
        out.println("before");
        out.println("---");
        out.println("after");
        endSample();
    }

    private void addQuoteSample()
    {
        PrintWriter out;
        out = startSample("Quote");
        out.println("before");
        out.println(">>>");
        out.println("This is a block quote.");
        out.println("All lines are indented.");
        out.println("* one");
        out.println("* two");
        out.println("* three");
        out.println("<<<");
        out.println("after");
        endSample();
    }

    private void addBulletListSample()
    {
        PrintWriter out;
        out = startSample("Bullet List");
        out.println("before");
        out.println("* apple");
        out.println("* bannana");
        out.println("** pear");
        out.println("** grape");
        out.println("* orange");
        out.println("after");
        endSample();
    }

    private void addNumberedListSample()
    {
        PrintWriter out;
        out = startSample("Numbered List");
        out.println("before");
        out.println("# apple");
        out.println("# bannana");
        out.println("## pear");
        out.println("## grape");
        out.println("# orange");
        out.println("after");
        endSample();
    }

    private void addNoWikiSample()
    {
        PrintWriter out;
        out = startSample("No Wiki");
        out.println("The 'no wiki' can be used to wrap text that");
        out.println("would otherwise be interpreted as a wiki format.");
        out.println("This is **bold**.");
        out.println("This is {{{**not bold**}}}.");
        endSample();
    }

    private PrintWriter startSample(String name)
    {
        _name = name;
        _stringWriter = new StringWriter();
        _printWriter = new PrintWriter(_stringWriter);
        return _printWriter;
    }

    private void endSample()
    {
        String wiki = _stringWriter.toString();

        _printWriter.close();
        _samples.put(_name, wiki);
    }

}
