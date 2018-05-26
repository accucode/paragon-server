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

package com.kodemore.servlet;

import java.nio.charset.Charset;

import com.kodemore.utility.Kmu;

/**
 * I consolidate most of the Charset specific rules for the application.
 * Changes to this file may need to be coordinated with external resources
 * and architural components including the database and web server.
 *
 * WEB BROWSERS
 * We currently support UTF-8 when exchanging data with the client web
 * browser. However, all user input should be converted to a safe format
 * that is compatible with the database charset. This conversion is usually
 * performed automatically as part of the servlet framework so the application
 * code does not need to handle it. But any data imported from CSV files or
 * other sources should also be checked and converted to safe strings.
 *
 * DATABASE
 * We use MySql's default Latin1 / ISO-8859-1 charset.
 *
 * OTHER RESOURCES
 * If you want to change the charsets, you need to carefully review all
 * of the methods in this class. Additionally, there are some other
 * resources that need to be reviewed as well:
 *
 *      All html files that include the <head> tags.
 *          <meta http-equiv='content-type' content='text/html;charset=UTF-8'>
 *          for example:
 *              index.html
 *              pageLayout.html
 *
 *      Html Fonts
 *          We primarily rely on Roboto, which supports the full Latin1 charset.
 *          If you use a broader charset, you need to confirm that our fonts
 *          support all of the characters.
 *
 *      web.xml
 *          The web.xml file includes a charset filter that need to be updated.
 *          <filter-name>CharsetFilter</filter-name>
 *          ... <param-value>UTF-8</param-value>
 */
public class ScCharsets
{
    //##################################################
    //# constants
    //##################################################

    /**
     * The charset we use for the web pages.
     *
     * This must match...
     * web.xml; the charsetFilter.
     * pageLayout.html; the head/meta tag.
     * index.html; the head/meta tag.
     */
    public static final Charset WEB_CHARSET = Charset.forName("UTF-8");

    /**
     * The charset we use in the database.
     * This is primarily here for reference, it may not be
     * reference directly by the application.
     * ISO-8859-1 == Latin1
     */
    public static final Charset DATABASE_CHARSET = Charset.forName("ISO-8859-1");

    /**
     * This is used for code that should be explicitly hardcoded to
     * the UTF-8 encoding, and should be not changed even if we later
     * change the web/database charsets. For example, we may use this
     * to manually encode text into a byte array. If that byte array
     * is subsequently written to a file or a database blob it is
     * important to ensure that we later decode it using the same charset,
     * even if the decoding may not take place for several years.
     *
     * THIS SHOULD NEVER CHANGE.
     */
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    /**
     * This is used for email encoding, e.g.: for encoding
     * strings for an attachment.
     */
    public static final Charset EMAIL_CHARSET = Charset.forName("UTF-8");

    //==================================================
    //= unicode characters
    //==================================================

    private static final char SPACE              = '\u0020';
    private static final char NON_BREAKING_SPACE = '\u00A0';

    private static final char CARRIAGE_RETURN = '\r';
    private static final char LINE_FEED       = '\n';
    private static final char TAB             = '\t';

    private static final String CRLF_STRING      = CARRIAGE_RETURN + "" + LINE_FEED;
    private static final String LINE_FEED_STRING = LINE_FEED + "";

    private static final char APOSTROPHE                  = '\'';
    private static final char GRAVE_ACCENT                = '\u0060';
    private static final char ACUTE_ACCENT                = '\u00B4';
    private static final char LEFT_SINGLE_QUOTATION_MARK  = '\u2018';
    private static final char RIGHT_SINGLE_QUOTATION_MARK = '\u2019';

    private static final char QUOTATION_MARK              = '\u0022';
    private static final char LEFT_DOUBLE_QUOTATION_MARK  = '\u201C';
    private static final char RIGHT_DOUBLE_QUOTATION_MARK = '\u201D';

    private static final char HYPHEN_MINUS        = '\u002D';
    private static final char SOFT_HYPHEN         = '\u00AD';
    private static final char HYPHEN              = '\u2010';
    private static final char NON_BREAKING_HYPHEN = '\u2011';
    private static final char FIGURE_DASH         = '\u2012';
    private static final char EN_DASH             = '\u2013';
    private static final char EM_DASH             = '\u2014';
    private static final char HORIZONTAL_BAR      = '\u2015';
    private static final char TWO_EM_DASH         = '\u2E3A';
    private static final char THREE_EM_DASH       = '\u2E3B';
    private static final char SMALL_EM_DASH       = '\uFE58';
    private static final char FULL_WIDTH_HYPHEN   = '\uFF0D';

    //##################################################
    //# testing
    //##################################################

    /**
     * Determine if the character is considered printable on a single line.
     * This includes the lower 7-bit ascii characters and the common latin letters.
     * This includes SPACE, but not CR, LF, and TAB.
     * Control characters are excluded.
     * The non-breaking-space(#160) is excluded.
     */
    public static boolean isSingleLinePrintable(char c)
    {
        return c >= 32 && c <= 126 || c >= 161 && c <= 255;
    }

    public static boolean isSingleLinePrintable(String s)
    {
        return s.chars().allMatch(c -> isSingleLinePrintable((char)c));
    }

    /**
     * Determine if the character is considered printable across multiple lines.
     * This includes all of the singleLinePrintable characters, and adds the
     * standard whitespace (CR, LF, TAB).
     */
    public static boolean isMultiLinePrintable(char c)
    {
        return isSingleLinePrintable(c) || isWhitespace(c);
    }

    public static boolean isMultiLinePrintable(String s)
    {
        return s.chars().allMatch(c -> isMultiLinePrintable((char)c));
    }

    /**
     * Determine if the character is standard whitespace.
     *
     * This does NOT include the formfeed(#12),
     * it is typically stripped from input.
     *
     * This does NOT include the non-breaking-space(#160),
     * it is typically replaced with a standard space(#32).
     */
    public static boolean isWhitespace(char c)
    {
        return c == SPACE || c == CARRIAGE_RETURN || c == LINE_FEED || c == TAB;
    }

    //##################################################
    //# normalize
    //##################################################

    /**
     * Convert the string to a 'safe' version that simplifies
     * application logic and is compatible with the database charset.
     */
    public static String normalizeSingleLineString(String s)
    {
        if ( s == null )
            return null;

        s = replaceLineEndings(s);
        s = replaceSingleQuotes(s);
        s = replaceDoubleQuotes(s);
        s = replaceDashes(s);
        s = replaceSpaces(s);
        s = stripNonSingleLinePrintable(s);
        s = s.trim();

        return s.isEmpty()
            ? null
            : s;
    }

    /**
     * Convert the string to a 'safe' version that simplifies
     * application logic and is compatible with the database charset.
     */
    public static String normalizeMultiLineString(String s)
    {
        if ( s == null )
            return null;

        s = replaceLineEndings(s);
        s = replaceSingleQuotes(s);
        s = replaceDoubleQuotes(s);
        s = replaceDashes(s);
        s = replaceSpaces(s);
        s = stripNonMultiLinePrintable(s);
        s = s.trim();

        return s.isEmpty()
            ? null
            : s;
    }

    private static String replaceLineEndings(String s)
    {
        s = Kmu.replaceAll(s, CRLF_STRING, LINE_FEED_STRING);
        s = Kmu.replaceAll(s, CARRIAGE_RETURN, LINE_FEED);
        return s;
    }

    private static String replaceSingleQuotes(String s)
    {
        s = Kmu.replaceAll(s, GRAVE_ACCENT, APOSTROPHE);
        s = Kmu.replaceAll(s, ACUTE_ACCENT, APOSTROPHE);
        s = Kmu.replaceAll(s, LEFT_SINGLE_QUOTATION_MARK, APOSTROPHE);
        s = Kmu.replaceAll(s, RIGHT_SINGLE_QUOTATION_MARK, APOSTROPHE);
        return s;
    }

    private static String replaceDoubleQuotes(String s)
    {
        s = Kmu.replaceAll(s, LEFT_DOUBLE_QUOTATION_MARK, QUOTATION_MARK);
        s = Kmu.replaceAll(s, RIGHT_DOUBLE_QUOTATION_MARK, QUOTATION_MARK);
        return s;
    }

    private static String replaceDashes(String s)
    {
        s = Kmu.replaceAll(s, SOFT_HYPHEN, HYPHEN_MINUS);
        s = Kmu.replaceAll(s, HYPHEN, HYPHEN_MINUS);
        s = Kmu.replaceAll(s, NON_BREAKING_HYPHEN, HYPHEN_MINUS);
        s = Kmu.replaceAll(s, FIGURE_DASH, HYPHEN_MINUS);
        s = Kmu.replaceAll(s, EN_DASH, HYPHEN_MINUS);
        s = Kmu.replaceAll(s, EM_DASH, HYPHEN_MINUS);
        s = Kmu.replaceAll(s, HORIZONTAL_BAR, HYPHEN_MINUS);
        s = Kmu.replaceAll(s, TWO_EM_DASH, HYPHEN_MINUS);
        s = Kmu.replaceAll(s, THREE_EM_DASH, HYPHEN_MINUS);
        s = Kmu.replaceAll(s, SMALL_EM_DASH, HYPHEN_MINUS);
        s = Kmu.replaceAll(s, FULL_WIDTH_HYPHEN, HYPHEN_MINUS);
        return s;
    }

    private static String replaceSpaces(String s)
    {
        s = Kmu.replaceAll(s, NON_BREAKING_SPACE, SPACE);
        return s;
    }

    //##################################################
    //# support
    //##################################################

    private static String stripNonSingleLinePrintable(String s)
    {
        if ( s == null )
            return null;

        StringBuilder out = new StringBuilder(s.length());

        for ( char c : s.toCharArray() )
            if ( isSingleLinePrintable(c) )
                out.append(c);

        return out.toString();
    }

    private static String stripNonMultiLinePrintable(String s)
    {
        if ( s == null )
            return null;

        StringBuilder out = new StringBuilder(s.length());

        for ( char c : s.toCharArray() )
            if ( isMultiLinePrintable(c) )
                out.append(c);

        return out.toString();
    }
}
