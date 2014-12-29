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

package com.kodemore.html;

import java.io.Reader;
import java.io.StringReader;

import org.w3c.css.sac.CSSException;
import org.w3c.css.sac.CSSParseException;
import org.w3c.css.sac.ErrorHandler;
import org.w3c.css.sac.InputSource;
import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSRuleList;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSStyleRule;
import org.w3c.dom.css.CSSStyleSheet;

import com.steadystate.css.parser.CSSOMParser;

import com.kodemore.collection.KmList;
import com.kodemore.file.KmFile;
import com.kodemore.log.KmLog;
import com.kodemore.string.KmStringTokenizer;
import com.kodemore.utility.Kmu;

/**
 * I am used to parse css files.
 *
 * Dependencies:
 *      http://cssparser.sourceforge.net/
 *      http://www.w3.org/Style/CSS/SAC/
 */
public class KmCssParser
{
    //##################################################
    //# constants
    //##################################################

    private static final char DOT   = '.';
    private static final char HASH  = '#';
    private static final char COLON = ':';
    private static final char SPACE = ' ';

    //##################################################
    //# variables
    //##################################################

    private String            _css;
    private CSSRuleList       _rules;

    //##################################################
    //# parse
    //##################################################

    public void parseFile(String path)
    {
        String css = Kmu.readFileString(path);

        if ( css == null )
            Kmu.fatal("Unable to read css file: " + path);

        parseCss(css);
    }

    public void parseFile(KmFile file) throws Exception
    {
        String css = file.readString();

        if ( css == null )
            Kmu.fatal("Unable to read css file: " + file);

        parseCss(css);
    }

    public void parseCss(String css)
    {
        try
        {
            _css = css;

            Reader reader = new StringReader(css);
            InputSource source = new InputSource(reader);

            CSSOMParser parser;
            parser = new CSSOMParser();
            parser.setErrorHandler(newErrorHandler());

            CSSStyleSheet sheet;
            sheet = parser.parseStyleSheet(source, null, null);

            _rules = sheet.getCssRules();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    private ErrorHandler newErrorHandler()
    {
        return new ErrorHandler()
        {
            @Override
            public void warning(CSSParseException ex) throws CSSException
            {
                KmLog.warn(ex.getMessage());
            }

            @Override
            public void error(CSSParseException ex) throws CSSException
            {
                KmLog.error(
                    "Css parse error at line %s, row %s. %s",
                    ex.getLineNumber(),
                    ex.getColumnNumber(),
                    ex.getMessage());
            }

            @Override
            public void fatalError(CSSParseException ex) throws CSSException
            {
                throw ex;
            }
        };
    }

    //##################################################
    //# accessing - common
    //##################################################

    /**
     * Get all selector names.
     */
    public KmList<String> getAllSelectors()
    {
        KmList<String> v;
        v = new KmList<>();

        int n = getRules().getLength();
        for ( int i = 0; i < n; i++ )
        {
            CSSRule item = getRules().item(i);

            if ( item instanceof CSSStyleRule )
            {
                CSSStyleRule rule = (CSSStyleRule)item;
                String s = rule.getSelectorText();
                v.addDistinct(s);
            }
        }

        return v;
    }

    /**
     * Get all class selectors.  Some examples...
     *      .footer         => footer
     *      td.highlight    => highlight
     *      a.big:hover     => big
     *      #some.small     => small
     *      div             => -- not a class selector --
     *      #someElement    => -- not a class selector --
     */
    public KmList<String> getClassSelectors()
    {
        KmList<String> v;
        v = new KmList<>();

        KmStringTokenizer t;
        t = new KmStringTokenizer();
        t.addCharDelimiters(" \t,>");

        for ( String sel : getAllSelectors() )
        {
            KmList<String> tokens = t.split(sel);
            for ( String s : tokens )
            {
                int i;
                i = s.lastIndexOf(DOT);
                if ( i < 0 )
                    continue;

                s = s.substring(i + 1);

                i = s.indexOf(HASH);
                if ( i >= 0 )
                    continue;

                i = s.indexOf(COLON);
                if ( i >= 0 )
                    s = s.substring(0, i);

                i = s.indexOf(SPACE);
                if ( i >= 0 )
                    s = s.substring(0, i);

                v.addDistinct(s);
            }
        }

        v.sort();
        return v;
    }

    //##################################################
    //# accessing - other
    //##################################################

    /**
     * Returns the css that was parsed.  This may be convenient when
     * the css was originally read from a file.
     */
    public String getCss()
    {
        return _css;
    }

    /**
     * Used to access the underlying css rules.  Clients should generally
     * NOT need to call this.  We may create helper methods and classes
     * to insulate the rest of the application from this third pary
     * dependency.
     */
    public CSSRuleList getRules()
    {
        return _rules;
    }

    //##################################################
    //# convenience - print
    //##################################################

    /**
     * This method is mostly here to demonstrate some of the additional
     * information that is available.
     */
    public void printRules()
    {
        println("Number of rules: " + _rules.getLength());

        for ( int i = 0; i < _rules.getLength(); i++ )
        {
            CSSRule rule = _rules.item(i);
            if ( rule instanceof CSSStyleRule )
            {
                CSSStyleRule styleRule = (CSSStyleRule)rule;
                String selector = styleRule.getSelectorText();

                println("selector [%s]: %s.", i, selector);
                println();

                CSSStyleDeclaration style = styleRule.getStyle();

                for ( int j = 0; j < style.getLength(); j++ )
                {
                    String prop = style.item(j);
                    String text = style.getPropertyCSSValue(prop).getCssText();
                    String priority = style.getPropertyPriority(prop);

                    println("    property: " + prop);
                    println("    value:    " + text);
                    println("    priority: " + priority);
                    println();
                }
            }
        }
    }

    private void println()
    {
        println("");
    }

    private void println(String msg, Object... args)
    {
        System.out.println(Kmu.format(msg, args));
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        _testCss();
    }

    @SuppressWarnings("unused")
    private static void _testFile()
    {
        String file = Kmu.joinFilePath(
            Kmu.getWorkingFolder(),
            "web/static/version/app/theme/default/css/theme.css");

        System.out.println();
        System.out.println("Parse css...");
        System.out.println(file);

        KmCssParser p;
        p = new KmCssParser();
        p.parseFile(file);

        System.out.println("parse successful.");
        System.out.println("class selectors...");

        KmList<String> v = p.getClassSelectors();
        for ( String e : v )
            System.out.println("  " + e);
    }

    private static void _testCss()
    {
        String css = ".aaa, .bbb .ccc > .ddd { color: red }";

        System.out.println();
        System.out.println("Parse css...");

        KmCssParser p;
        p = new KmCssParser();
        p.parseCss(css);
        p.printRules();

        System.out.println("parse successful.");
        System.out.println("class selectors...");

        KmList<String> v = p.getClassSelectors();
        for ( String e : v )
            System.out.println("  " + e);
    }

}
