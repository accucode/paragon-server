package com.app.ui.servlet;

import java.nio.charset.Charset;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.KmStyleBuilder;
import com.kodemore.time.KmClock;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.Kmu;

import com.app.utility.MyConstantsIF;

public class MyCharsetTestServlet
    extends HttpServlet
{
    //##################################################
    //# constants
    //##################################################

    private static final String  CONTENT_TYPE  = "text/html";
    /**
     * The charset we are testing.
     * This should match the charsetFilter set in web.xml.
     */
    private static final Charset CHARACTER_SET = Charset.forName("UTF-8");

    private static final String PARAMETER_NAME = "name";

    //##################################################
    //# get / post
    //##################################################

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
    {
        handle(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
    {
        handle(req, res);
    }

    //##################################################
    //# handle
    //##################################################

    protected void handle(HttpServletRequest req, HttpServletResponse res)
    {
        printResult(req, res);
    }

    //##################################################
    //# print
    //##################################################

    private void printResult(HttpServletRequest req, HttpServletResponse res)
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.printDocType();
        out.beginHtml();

        printHeadOn(out);
        printBodyOn(out, req);

        out.endHtml();
        write(res, out.toString());
    }

    private void printHeadOn(KmHtmlBuilder out)
    {
        out.beginHead();
        out.printMetaContentType("text/html", CHARACTER_SET);
        out.printTitle("Charset Test");
        out.endHead();
    }

    private void printBodyOn(KmHtmlBuilder out, HttpServletRequest req)
    {
        out.beginBody();
        out.printlnBold("Charset Test");
        printApplicationInfoOn(out);
        printRequestInfoOn(out, req);
        printFormOn(out, req);
        out.endBody();
    }

    private void printApplicationInfoOn(KmHtmlBuilder out)
    {
        KmTimestamp nowUtc = KmClock.getUtcTimestamp();

        beginValueTableOn(out, "Application");
        printTableValueOn(out, "Name", MyConstantsIF.APPLICATION_NAME);
        printTableValueOn(out, "Version", MyConstantsIF.APPLICATION_VERSION);
        printTableValueOn(out, "UTC Time", nowUtc.format_m_d_yyyy_h_mm_am());
        printTableValueOn(out, "Local Time", nowUtc.toLocal().format_m_d_yyyy_h_mm_am());
        endValueTableOn(out);
    }

    private void printRequestInfoOn(KmHtmlBuilder out, HttpServletRequest req)
    {
        beginValueTableOn(out, "Request");
        printTableValueOn(out, "Method", req.getMethod());
        printTableValueOn(out, "Encoding", req.getCharacterEncoding());
        endValueTableOn(out);
    }

    private void printFormOn(KmHtmlBuilder out, HttpServletRequest req)
    {
        KmStyleBuilder style;
        style = new KmStyleBuilder();
        style.setValue("border", "1px solid black");
        style.pad();

        out.println();
        out.println();
        out.printlnBold("Form");

        out.openForm();
        out.printAttribute("method", "post");
        out.printAttribute(style);
        out.close();

        printFieldOn(out, req);
        printSubmitOn(out);
        out.printBreak();
        printTextOn(out, req);

        out.endForm();
    }

    private void printFieldOn(KmHtmlBuilder out, HttpServletRequest req)
    {
        String name = req.getParameter(PARAMETER_NAME);
        boolean hasName = Kmu.hasValue(name);

        out.open("input");
        out.printAttribute("type", "text");
        out.printAttribute("name", PARAMETER_NAME);

        if ( hasName )
            out.printAttribute("value", name);

        out.close();
    }

    private void printTextOn(KmHtmlBuilder out, HttpServletRequest req)
    {
        String name = req.getParameter("name");

        boolean hasName = Kmu.hasValue(name);
        if ( !hasName )
            return;

        out.println(name);
        out.println("Length:  " + name.length());
        out.println("Unicode: " + Kmu.formatUnicodeValues(name));
    }

    private void printSubmitOn(KmHtmlBuilder out)
    {
        out.open("input");
        out.printAttribute("type", "submit");
        out.printAttribute("value", "submit");
        out.close();
    }

    //==================================================
    //= table values
    //==================================================

    private void beginValueTableOn(KmHtmlBuilder out, String title)
    {
        KmStyleBuilder style;
        style = new KmStyleBuilder();
        style.setValue("border-collapse", "collapse");

        out.println();
        out.println();
        out.printlnBold(title);

        out.openTable();
        out.printAttribute("border", 1);
        out.printAttribute("cellpadding", 5);
        out.printAttribute(style);
        out.close();
    }

    private void endValueTableOn(KmHtmlBuilder out)
    {
        out.endTable();
    }

    private void printTableValueOn(KmHtmlBuilder out, String key, String value)
    {
        out.beginTableRow();
        out.printTableData(key);
        out.printTableData(value);
        out.endTableRow();
    }

    //==================================================
    //= write
    //==================================================

    private void write(HttpServletResponse res, String html)
    {
        try
        {
            res.setContentType(CONTENT_TYPE);
            res.setCharacterEncoding(CHARACTER_SET.name());
            res.getWriter().write(html);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

}
