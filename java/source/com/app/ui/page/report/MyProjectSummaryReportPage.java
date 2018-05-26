package com.app.ui.page.report;

import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldText;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.utility.Kmu;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;
import com.app.ui.servlet.MyFormatter;
import com.app.utility.MyProjectSummaryReportUtility;

public final class MyProjectSummaryReportPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyProjectSummaryReportPage _instance;

    public static void installInstance()
    {
        _instance = new MyProjectSummaryReportPage();
    }

    public static MyProjectSummaryReportPage getInstance()
    {
        return _instance;
    }

    private MyProjectSummaryReportPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScFieldText _documentCountText;
    private ScFieldText _totalWordCountText;
    private ScFieldText _totalPageCountText;

    private ScFieldText _blurbCountText;
    private ScFieldText _blurbWordCountText;
    private ScFieldText _blurbPageCountText;

    private ScFieldText _emailCountText;
    private ScFieldText _emailWordCountText;
    private ScFieldText _emailPageCountText;

    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.projectWorker;
    }

    @Override
    public String getHelpMessage()
    {
        int charsPerWord = MyProjectSummaryReportUtility.CHARS_PER_WORD;
        int wordsPerPage = MyProjectSummaryReportUtility.WORDS_PER_PAGE;

        String msg = ""
            + "This is a brief summary of the project configuration. "
            + "The page counts are estimated based on the approximation "
            + "of %s characters per word and  %s words per page.";

        return Kmu.format(msg, charsPerWord, wordsPerPage);
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().flexColumn().columnSpacer20();

        installRowOn(root);
    }

    private void installRowOn(ScContainer root)
    {
        ScDiv row;
        row = root.addDiv();
        row.css().flexRow().rowSpacer20();

        installTotalGroupOn(row);
        installBlurbsGroupOn(row);
        installEmailsGroupOn(row);
    }

    private void installTotalGroupOn(ScContainer root)
    {
        ScGroup group;
        group = root.addGroup("Total");
        group.setFlavorAccent();
        group.css().flexChildBasis0();

        ScDiv body = group.getBody();
        body.css().pad10();

        ScFieldTable fields;
        fields = body.addFullWidthFieldTable();
        _documentCountText = fields.add(createFieldText("Documents"));
        fields.addSpace();
        _totalWordCountText = fields.add(createFieldText("Words"));
        _totalPageCountText = fields.add(createFieldText("Pages"));
    }

    private void installBlurbsGroupOn(ScContainer root)
    {
        ScGroup group;
        group = root.addGroup("Blurbs");
        group.css().flexChildBasis0();

        ScDiv body;
        body = group.getBody();
        body.css().pad10();

        ScFieldTable fields;
        fields = body.addFullWidthFieldTable();
        _blurbCountText = fields.add(createFieldText("Blurbs"));
        fields.addSpace();
        _blurbWordCountText = fields.add(createFieldText("Words"));
        _blurbPageCountText = fields.add(createFieldText("Pages"));
    }

    private void installEmailsGroupOn(ScContainer root)
    {
        ScGroup group;
        group = root.addGroup("Email Templates");
        group.css().flexChildBasis0();

        ScDiv body;
        body = group.getBody();
        body.css().pad10();

        ScFieldTable fields;
        fields = body.addFullWidthFieldTable();
        _emailCountText = fields.add(createFieldText("Templates"));
        fields.addSpace();
        _emailWordCountText = fields.add(createFieldText("Words"));
        _emailPageCountText = fields.add(createFieldText("Pages"));
    }

    //==================================================
    //= install :: fields
    //==================================================

    private ScFieldText createFieldText(String label)
    {
        ScFieldText e;
        e = new ScFieldText();
        e.setLabel(label);
        return e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        MyProjectSummaryReportUtility u;
        u = new MyProjectSummaryReportUtility();
        u.setProject(getCurrentProject());
        u.run();

        preRenderTotal(u);
        preRenderBlurs(u);
        preRenderEmails(u);
    }

    private void preRenderTotal(MyProjectSummaryReportUtility u)
    {
        int docCount = u.getDocumentCount();
        int wordCount = u.getTotalWordCount();
        int pageCount = u.getTotalPageCount();

        MyFormatter f = MyFormatter.getInstance();
        _documentCountText.setValue(f.formatInteger(docCount));
        _totalWordCountText.setValue(f.formatInteger(wordCount));
        _totalPageCountText.setValue(f.formatInteger(pageCount));
    }

    private void preRenderBlurs(MyProjectSummaryReportUtility u)
    {
        int blurbCount = u.getBlurbCount();
        int wordCount = u.getBlurbWordCount();
        int pageCount = u.getBlurbPageCount();

        MyFormatter f = MyFormatter.getInstance();
        _blurbCountText.setValue(f.formatInteger(blurbCount));
        _blurbWordCountText.setValue(f.formatInteger(wordCount));
        _blurbPageCountText.setValue(f.formatInteger(pageCount));
    }

    private void preRenderEmails(MyProjectSummaryReportUtility u)
    {
        int emailCount = u.getEmailTemplateCount();
        int wordCount = u.getEmailTemplateWordCount();
        int pageCount = u.getEmailTemplatePageCount();

        MyFormatter f = MyFormatter.getInstance();
        _emailCountText.setValue(f.formatInteger(emailCount));
        _emailWordCountText.setValue(f.formatInteger(wordCount));
        _emailPageCountText.setValue(f.formatInteger(pageCount));
    }
}
