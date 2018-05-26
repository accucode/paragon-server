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

package com.kodemore.html;

import java.nio.charset.Charset;
import java.util.List;

import com.kodemore.collection.KmList;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.servlet.ScConstantsIF;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScControlIF;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.servlet.script.ScScriptIF;
import com.kodemore.servlet.script.ScSimpleBlockScript;
import com.kodemore.servlet.utility.ScUrlBridge;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.KmConstantsIF;
import com.kodemore.utility.KmHtmlLineEnding;
import com.kodemore.utility.Kmu;

/**
 * I supply some convenience methods for building simple html.
 */
public class KmHtmlBuilder
    implements CharSequence
{
    //##################################################
    //# static
    //##################################################

    private static final char CHAR_CR = '\r';
    private static final char CHAR_LF = '\n';

    private static final String CR   = "" + CHAR_CR;
    private static final String LF   = "" + CHAR_LF;
    private static final String CRLF = CR + LF;

    private static final String DATA_ATTRIBUTE_PREFIX = "data-";

    //##################################################
    //# variables
    //##################################################

    /**
     * The buffer onto which the content is rendered.
     */
    private KmStringBuilder _buffer;

    /**
     * Scripts that are NOT rendered directly onto the html.
     * These scripts are intended to be executed after the
     * DOM has been updated.  The DOM may have been composed
     * offscreen, or hidden. This allows us to render and
     * initialize complex html before its made visible.
     */
    private ScBlockScript _postDom;

    /**
     * Scripts that are NOT rendered directly onto the html.
     * These scripts are not rendered until both the DOM
     * is composed AND the elements are made VISIBLE. Most
     * scripts are handled in postDom rather than postRender.
     * But a some scripts must be delayed until after the
     * html is visible; such as setFocus.
     */
    private ScBlockScript _postRender;

    //##################################################
    //# constructor
    //##################################################

    public KmHtmlBuilder()
    {
        _buffer = new KmStringBuilder();
        _postDom = new ScSimpleBlockScript();
        _postRender = new ScSimpleBlockScript();
    }

    public KmHtmlBuilder(String html)
    {
        this();
        printLiteral(html);
    }

    //##################################################
    //# accessing
    //##################################################

    /**
     * Get the contents of the buffer.
     */
    @Override
    public String toString()
    {
        return formatHtml();
    }

    public String formatHtml()
    {
        return _buffer.toString();
    }

    public int getLength()
    {
        return _buffer.length();
    }

    public void clear()
    {
        _buffer.setLength(0);
        _postDom.clearScript();
        _postRender.clearScript();
    }

    //##################################################
    //# doc type
    //##################################################

    /**
     * This is the doc type for html5.
     * We are attempting to standardize on this.
     */
    public void printDocType()
    {
        printLiteralLine("<!DOCTYPE html>");
    }

    //    public void printDocType401Strict()
    //    {
    //        printLiteralLine("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\"");
    //        printLiteralLine("\"http://www.w3.org/TR/html4/strict.dtd\">");
    //    }

    //    public void printDocType401Transitional()
    //    {
    //        printLiteralLine("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"");
    //        printLiteralLine("\"http://www.w3.org/TR/html4/loose.dtd\">");
    //    }

    //##################################################
    //# begin & end
    //##################################################

    public void begin(String tag)
    {
        open(tag);
        close();
    }

    public void beginCss(String tag, String css)
    {
        open(tag);
        printAttribute("class", css);
        close();
    }

    public void beginStyle(String tag, String style)
    {
        open(tag);
        printAttribute("style", style);
        close();
    }

    public void open(String tag)
    {
        _buffer.append("<");
        _buffer.append(tag);
    }

    public void close()
    {
        _buffer.append(">");
    }

    public void end(String tag)
    {
        _buffer.append("</");
        _buffer.append(tag);
        _buffer.append(">");
    }

    //##################################################
    //# attributes
    //##################################################

    public void printAttribute(String key)
    {
        _buffer.append(" ");
        _buffer.append(key);
    }

    public void printAttribute(String key, String value)
    {
        printAttribute(key, value, KmHtmlLineEnding.EncodedLineFeed);
    }

    public void printAttribute(String key, String value, KmHtmlLineEnding lineEnding)
    {
        if ( value == null )
            return;

        _buffer.append(" ");
        _buffer.append(key);
        _buffer.append("=");
        _buffer.append(KmConstantsIF.TICK);
        _buffer.append(Kmu.escapeHtml(value, lineEnding));
        _buffer.append(KmConstantsIF.TICK);
    }

    public void printAttribute(String key, Integer i)
    {
        if ( i == null )
            return;

        printAttribute(key, i + "");
    }

    public void printAttribute(String key, Boolean value)
    {
        if ( value == null )
            return;

        printAttribute(key, value + "");
    }

    public void printAttribute(KmStyleBuilder out)
    {
        if ( out == null )
            return;

        if ( !out.hasValue() )
            return;

        printAttribute("style", out.getValue());
    }

    public void printAttribute(KmCssBuilder out)
    {
        if ( out == null )
            return;

        printAttribute("class", out.getValue());
    }

    //##################################################
    //# data attribute
    //##################################################

    /**
     * Print an attribute with the html5 'data-' prefix.
     * The key should be all lower-case with dashes between the words.
     * This help ensure consistency when accessing the values from
     * javascript and jquery.
     *
     * Unlike other attributes, null DATA attributes are converted to
     * empty/false values.
     *
     * E.g.: 'some-interesting-value'.
     */
    public void printDataAttribute(String key, String value)
    {
        if ( value == null )
            value = "";

        printAttribute(DATA_ATTRIBUTE_PREFIX + key, value);
    }

    public void printDataAttribute(String key, Boolean value)
    {
        if ( value == null )
            value = false;

        printAttribute(DATA_ATTRIBUTE_PREFIX + key, value);
    }

    public void printDataAttribute(String key, Integer value)
    {
        if ( value == null )
            value = 0;

        printAttribute(DATA_ATTRIBUTE_PREFIX + key, value);
    }

    //##################################################
    //# div
    //##################################################

    public void openDiv()
    {
        open("div");
    }

    public void beginDiv()
    {
        openDiv();
        close();
    }

    public void beginDivCss(String css)
    {
        openDiv();
        printAttribute("class", css);
        close();
    }

    public void beginDivIdCss(String id, String css)
    {
        openDiv();
        printAttribute("id", id);
        printAttribute("class", css);
        close();
    }

    public void beginDivIdCss(String id, String css, String style)
    {
        openDiv();
        printAttribute("id", id);
        printAttribute("class", css);
        printAttribute("style", style);
        close();
    }

    public void beginDiv(KmCssBuilder css)
    {
        openDiv();
        printAttribute(css);
        close();
    }

    public void beginDivId(String id)
    {
        openDiv();
        printAttribute("id", id);
        close();
    }

    public void printDivId(String id)
    {
        beginDivId(id);
        endDiv();
    }

    public void printDivCss(String css)
    {
        beginDivCss(css);
        endDiv();
    }

    public void endDiv()
    {
        end("div");
    }

    //##################################################
    //# span
    //##################################################

    public void beginSpan()
    {
        begin("span");
    }

    public void openSpan()
    {
        open("span");
    }

    public void beginSpanId(String htmlId)
    {
        open("span");
        printAttribute("id", htmlId);
        close();
    }

    public void beginSpanCss(String css)
    {
        beginCss("span", css);
    }

    public void endSpan()
    {
        end("span");
    }

    //##################################################
    //# html
    //##################################################

    public void beginHtml()
    {
        beginHtml("en");
    }

    public void beginHtml(String lang)
    {
        open("html");
        printAttribute("lang", lang);
        close();
    }

    public void endHtml()
    {
        end("html");
    }

    //##################################################
    //# head
    //##################################################

    public void beginHead()
    {
        begin("head");
    }

    public void endHead()
    {
        end("head");
    }

    public void printTitle(String e)
    {
        beginTitle();
        print(e);
        endTitle();

        printLiteralLine();
    }

    public void beginTitle()
    {
        begin("title");
    }

    public void endTitle()
    {
        end("title");
    }

    /**
     * Print the meta refresh tag.
     * This will cause the page to refresh every n seconds.
     * This tag should be used inside the <head>.
     */
    public void printMetaRefresh(int seconds)
    {
        printMetaTag("refresh", seconds);
    }

    public void printMetaNoCache()
    {
        printMetaTag("cache-control", "no-cache");
        printMetaTag("pragma", "no-cache");
        printMetaTag("expires", -1);
    }

    public void printMetaTag(String httpEquiv, int content)
    {
        printMetaTag(httpEquiv, content + "");
    }

    public void printMetaTag(String httpEquiv, String content)
    {
        open("meta");
        printAttribute("http-equiv", httpEquiv);
        printAttribute("content", content);
        close();

        printLiteralLine();
    }

    public void printMetaCharset(String charset)
    {
        String content = "text/html; charset=" + charset;

        open("meta");
        printAttribute("http-equiv", "content-type");
        printAttribute("content", content);
        close();

        printLiteralLine();
    }

    public void printMetaContentTypeHtml()
    {
        String type = "text/html";
        printMetaContentType(type);
    }

    public void printMetaContentType(String type)
    {
        Charset charset = ScConstantsIF.WEB_CHARSET;
        printMetaContentType(type, charset);
    }

    public void printMetaContentType(String type, Charset charset)
    {
        String content = Kmu.format("%s; %s", type, charset.name());

        open("meta");
        printAttribute("http-equiv", "content-type");
        printAttribute("content", content);
        close();

        printLiteralLine();
    }

    //##################################################
    //# body
    //##################################################

    public void openBody()
    {
        open("body");
    }

    public void beginBody()
    {
        begin("body");
    }

    public void endBody()
    {
        end("body");
    }

    //##################################################
    //# form
    //##################################################

    public void openForm()
    {
        open("form");
    }

    public void beginForm()
    {
        begin("form");
    }

    public void endForm()
    {
        end("form");
    }

    //##################################################
    //# header
    //##################################################

    public void printHeader(int level, String s)
    {
        String tag = "h" + level;
        begin(tag);
        print(s);
        end(tag);
    }

    public void printHeader1(String s)
    {
        printHeader(1, s);
    }

    public void printHeader2(String s)
    {
        printHeader(2, s);
    }

    public void printHeader3(String s)
    {
        printHeader(3, s);
    }

    //##################################################
    //# tables
    //##################################################

    public void beginTable()
    {
        begin("table");
    }

    public void openTable()
    {
        open("table");
    }

    public void endTable()
    {
        end("table");
    }

    public void beginTableRow()
    {
        begin("tr");
    }

    public void openTableRow()
    {
        open("tr");
    }

    public void endTableRow()
    {
        end("tr");
    }

    public void beginTableHeader()
    {
        begin("th");
    }

    public void openTableHeader()
    {
        open("th");
    }

    public void endTableHeader()
    {
        end("th");
    }

    public void printTableHeader(Object e)
    {
        beginTableHeader();
        print(e);
        endTableHeader();
    }

    public void beginTableData()
    {
        begin("td");
    }

    public void beginTableDataCss(String css)
    {
        css = "sqlResultBlock " + css;

        openTableData();
        printAttribute("class", css);
        close();
    }

    public void openTableData()
    {
        open("td");
    }

    public void endTableData()
    {
        end("td");
    }

    public void printTableData(Object e)
    {
        beginTableData();
        print(e);
        endTableData();
    }

    //##################################################
    //# print
    //##################################################

    public void print(Object e)
    {
        String s = format(e, KmHtmlLineEnding.BreakElement);
        _buffer.append(s);
    }

    public void printNoBreaks(Object e)
    {
        String s = format(e, KmHtmlLineEnding.LineFeed);
        _buffer.append(s);
    }

    public void println()
    {
        printBreak();
    }

    public void println(Object e)
    {
        print(e);
        printBreak();
    }

    public void printf(String msg, Object... args)
    {
        String s = Kmu.format(msg, args);
        print(s);
    }

    public void printfln()
    {
        println();
    }

    public void printfln(String msg, Object... args)
    {
        String s = Kmu.format(msg, args);
        println(s);
    }

    public void printNonBreaking(Object e)
    {
        String s = format(e, KmHtmlLineEnding.BreakElement);
        s = Kmu.replaceAll(s, " ", "&nbsp;");
        _buffer.append(s);
    }

    public void printBold(Object e)
    {
        begin("b");
        print(e);
        end("b");
    }

    public void printlnBold(Object e)
    {
        printBold(e);
        println();
    }

    public void printTextCss(Object e, String css)
    {
        beginSpanCss(css);
        print(e);
        endSpan();
    }

    public void printWithoutBreaks(Object e)
    {
        if ( e == null )
            return;

        String s;
        s = e.toString();
        s = Kmu.replaceAll(s, "&", "&amp;");
        s = Kmu.replaceAll(s, "<", "&lt;");
        s = Kmu.replaceAll(s, ">", "&gt;");
        s = Kmu.replaceAll(s, "\"", "&quot;");

        _buffer.append(s);
    }

    public void printTagValue(String tag, String value)
    {
        begin(tag);
        print(value);
        end(tag);
    }

    public void printNonBreakingSpaces(int n)
    {
        for ( int i = 0; i < n; i++ )
            printNonBreakingSpace();
    }

    public void printNonBreakingSpace()
    {
        printLiteral("&nbsp;");
    }

    public void printCopyright()
    {
        printLiteral("&copy;");
    }

    public void printBreak()
    {
        begin("br");
    }

    public void printBreaks(int n)
    {
        for ( int i = 0; i < n; i++ )
            printBreak();
    }

    public void printPageBreak()
    {
        openDiv();
        printAttribute("style", "page-break-after:always;");
        close();
        endDiv();
    }

    public void printSpace()
    {
        printLiteral(" ");
    }

    public void printRule()
    {
        begin("hr");
    }

    public void printPreformatted(String s)
    {
        begin("pre");
        print(s);
        end("pre");
    }

    //##################################################
    //# format
    //##################################################

    public void beginBold()
    {
        begin("b");
    }

    public void endBold()
    {
        end("b");
    }

    public void beginBulletList()
    {
        begin("ul");
    }

    public void endBulletList()
    {
        end("ul");
    }

    public void beginBullet()
    {
        begin("li");
    }

    public void endBullet()
    {
        end("li");
    }

    public void printBullet(String s)
    {
        beginBullet();
        print(s);
        endBullet();
    }

    //##################################################
    //# justified
    //##################################################

    public void printLeftRight(ScControl left, ScControl right)
    {
        printLeftRight(left, right, 0);
    }

    public void printLeftRight(ScControl left, ScControl right, Integer gap)
    {
        open("table");
        printAttribute("cellspacing", 0);
        printAttribute("cellpadding", 0);
        printAttribute("width", "100%");
        close();

        begin("tr");

        open("td");
        printAttribute("align", "left");
        close();
        render(left);
        end("td");

        if ( gap != null && gap > 0 )
        {
            open("td");
            printAttribute("width", gap);
            close();
            end("td");
        }

        open("td");
        printAttribute("align", "right");
        close();
        render(right);
        end("td");

        end("tr");
        end("table");
    }

    //##################################################
    //# convenience
    //##################################################

    public void render(KmHtmlBuilder out)
    {
        printLiteral(out.formatHtml());
    }

    public void render(ScControlIF e)
    {
        if ( e != null )
            e.renderOn(this);
    }

    //##################################################
    //# hidden field
    //##################################################

    public void printHiddenField(String name, String value)
    {
        open("input");
        printAttribute("type", "hidden");
        printAttribute("name", name);
        printAttribute("value", value);
        close();
    }

    //##################################################
    //# image
    //##################################################

    public void printImage(String url)
    {
        printImage(url, null, null);
    }

    public void printImage(String url, Integer width, Integer height)
    {
        if ( url == null )
            return;

        open("img");
        printAttribute("src", url);
        printAttribute("border", "0");
        printAttribute("width", width);
        printAttribute("height", height);
        printAttribute("alt", "");
        close();
    }

    public void printHelpImage(String msg)
    {
        printHelpImage(msg, null, null, null);
    }

    /**
     * Print the help triangle in the upper right corner of the container.
     * This uses absolute position; the container must have a non-static position.
     *
     * @param msg The plain text message to display. Do nothing if this is empty.
     * @param x If non-null, adjust the x position; positive moves right.
     * @param y If non-null, adjust the y position; positive moves up.
     * @param z If non-null, override the z-index.
     */
    public void printHelpImage(String msg, Integer x, Integer y, Integer z)
    {
        if ( Kmu.isEmpty(msg) )
            return;

        String url = ScUrlBridge.getInstance().getHelpTriangleUrl();

        KmCssDefaultBuilder css;
        css = new KmCssDefaultBuilder();
        css.helpTriangle().helpTooltip();

        KmStyleBuilder style = new KmStyleBuilder();

        if ( x != null )
            style.right(-x);

        if ( y != null )
            style.top(-y);

        if ( z != null )
            style.zIndex(z);

        open("img");
        printAttribute("src", url);
        printAttribute("border", "0");
        printAttribute("alt", "");
        printAttribute(css);
        printAttribute("title", msg);
        printAttribute(style);

        close();
    }

    //##################################################
    //# link
    //##################################################

    public void printLink(String href)
    {
        String text = href;
        printLink(text, href);
    }

    public void printLink(String text, String href)
    {
        open("a");
        printAttribute("href", href);
        close();
        _buffer.append(text);
        end("a");
    }

    //##################################################
    //# cdata
    //##################################################

    public void printCdata(String s)
    {
        beginCdata();
        printLiteral(s);
        endCdata();
    }

    public void beginCdata()
    {
        printLiteral("<![CDATA[");
    }

    public void endCdata()
    {
        printLiteral("]]>");
    }

    //##################################################
    //# literals
    //##################################################

    public void printLiteral(char c)
    {
        _buffer.append(c);
    }

    public void printLiteral(String s)
    {
        if ( s != null )
            _buffer.append(s);
    }

    public void printLiteral(StringBuilder e)
    {
        printLiteral(e.toString());
    }

    public void printLiteral(KmHtmlBuilder body)
    {
        printLiteral(body.toString());
    }

    public void printLiteralLine(String msg, Object... args)
    {
        String s = Kmu.format(msg, args);
        printLiteral(s);
        printLiteralLine();
    }

    public void printLiteralLine()
    {
        printLiteral(CRLF);
    }

    public boolean atLiteralLineStart()
    {
        int n = _buffer.length();
        if ( n == 0 )
            return true;

        return _buffer.charAt(n - 1) == CHAR_LF;
    }

    public void ensureLiteralLine()
    {
        if ( !atLiteralLineStart() )
            printLiteralLine();
    }

    //##################################################
    //# comment
    //##################################################

    public void beginComment()
    {
        _buffer.append("<!--");
    }

    public void endComment()
    {
        _buffer.append("-->");
    }

    public void printComment(String s)
    {
        beginComment();
        printLiteral(s);
        endComment();
    }

    //##################################################
    //# java script
    //##################################################

    public void printScriptLink(String path)
    {
        printScriptLink(path, null);
    }

    public void printScriptLink(String path, String comment)
    {
        open("script");
        printAttribute("type", "text/javascript");
        printAttribute("src", path);
        close();

        if ( Kmu.hasValue(comment) )
        {
            printLiteralLine();
            printLiteralLine("/*");
            KmList<String> v = Kmu.parseLines(comment);
            for ( String e : v )
                printLiteralLine(" *" + e);
            printLiteralLine(" */");
        }

        end("script");
        printLiteralLine();
    }

    public void printScriptInline(String e)
    {
        if ( e == null )
            return;

        printScriptsInline(KmList.createWith(e));
    }

    public void printScriptsInline(List<String> v)
    {
        if ( v == null )
            return;

        Kmu.trimValues(v);
        Kmu.removeEmptyValues(v);

        if ( v.isEmpty() )
            return;

        printLiteralLine();
        open("script");
        printAttribute("type", "text/javascript");
        close();

        printLiteralLine();

        for ( String e : v )
            printLiteralLine(e);

        end("script");
        printLiteralLine();
    }

    //##################################################
    //# style sheet
    //##################################################

    public void printStyleLink(String path)
    {
        printStyleLink(path, null);
    }

    public void printStyleLink(String path, String media)
    {
        open("link");
        printAttribute("rel", "stylesheet");
        printAttribute("type", "text/css");
        printAttribute("href", path);
        printAttribute("media", media);
        close();
        printLiteralLine();
    }

    public void printScreenStyleLink(String path)
    {
        printStyleLink(path, "screen");
    }

    public void printPrintStyleLink(String path)
    {
        printStyleLink(path, "print");
    }

    //##################################################
    //# scripts
    //##################################################

    public void printScripts(KmList<ScScriptIF> v)
    {
        printScriptInline(formatScripts(v));
    }

    public String formatScripts(KmList<ScScriptIF> v)
    {
        if ( v.isEmpty() )
            return null;

        String gap = CRLF + CRLF;
        StringBuilder out = new StringBuilder();
        for ( ScScriptIF s : v )
        {
            out.append(s.formatScript().trim());
            out.append(gap);
        }

        return out.toString();
    }

    //##################################################
    //# scripts
    //##################################################

    /**
     * see comment above: _postDom
     */
    public ScBlockScript getPostDom()
    {
        return _postDom;
    }

    /**
     * see comment above: _postRenderScripts
     */
    public ScBlockScript getPostRender()
    {
        return _postRender;
    }

    //##################################################
    //# support
    //##################################################

    /**
     * Convert e to a string.
     * Encode the string as html.
     */
    private String format(Object e, KmHtmlLineEnding lineEnding)
    {
        if ( e == null )
            return "";

        return Kmu.escapeHtml(e.toString(), lineEnding);
    }

    //##################################################
    //# char sequence
    //##################################################

    public boolean isEmpty()
    {
        return _buffer.isEmpty();
    }

    @Override
    public int length()
    {
        return toString().length();
    }

    @Override
    public char charAt(int index)
    {
        return toString().charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end)
    {
        return toString().subSequence(start, end);
    }

}
