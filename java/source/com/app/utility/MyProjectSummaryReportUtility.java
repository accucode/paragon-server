package com.app.utility;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

import com.app.model.MyBlurb;
import com.app.model.MyEmailTemplate;
import com.app.model.MyProject;

public class MyProjectSummaryReportUtility
{
    //##################################################
    //# constants
    //##################################################

    public static final int CHARS_PER_WORD = 6;
    public static final int WORDS_PER_PAGE = 250;

    //##################################################
    //# variables
    //##################################################

    private MyProject _project;

    private int _documentCount;
    private int _totalWordCount;
    private int _totalPageCount;

    private int _blurbCount;
    private int _blurbWordCount;
    private int _blurbPageCount;

    private int _emailTemplateCount;
    private int _emailTemplateWordCount;
    private int _emailTemplatePageCount;

    //##################################################
    //# accessing
    //##################################################

    private MyProject getProject()
    {
        return _project;
    }

    public void setProject(MyProject e)
    {
        _project = e;
    }

    //==================================================
    //= accessing :: totals
    //==================================================

    public int getDocumentCount()
    {
        return _documentCount;
    }

    private void increaseDocumentCountBy(int i)
    {
        _documentCount += i;
    }

    public int getTotalWordCount()
    {
        return _totalWordCount;
    }

    private void increaseTotalWordCountBy(int i)
    {
        _totalWordCount += i;
    }

    public int getTotalPageCount()
    {
        return _totalPageCount;
    }

    private void increaseTotalPageCountBy(int i)
    {
        _totalPageCount += i;
    }

    //==================================================
    //= accessing :: blurbs
    //==================================================

    public int getBlurbCount()
    {
        return _blurbCount;
    }

    private void incrementBlurbCount(int i)
    {
        _blurbCount += i;
        increaseDocumentCountBy(i);
    }

    public int getBlurbWordCount()
    {
        return _blurbWordCount;
    }

    private void incrementBlurbWordCount(int i)
    {
        _blurbWordCount += i;
        increaseTotalWordCountBy(i);
    }

    public int getBlurbPageCount()
    {
        return _blurbPageCount;
    }

    private void incrementBlurbPageCount(int i)
    {
        _blurbPageCount += i;
        increaseTotalPageCountBy(i);
    }

    //==================================================
    //= accessing :: email templates
    //==================================================

    public int getEmailTemplateCount()
    {
        return _emailTemplateCount;
    }

    private void incrementEmailTemplateCount(int i)
    {
        _emailTemplateCount += i;
        increaseDocumentCountBy(i);
    }

    public int getEmailTemplateWordCount()
    {
        return _emailTemplateWordCount;
    }

    private void incrementEmailTemplateWordCount(int i)
    {
        _emailTemplateWordCount += i;
        increaseTotalWordCountBy(i);
    }

    public int getEmailTemplatePageCount()
    {
        return _emailTemplatePageCount;
    }

    private void incrementEmailTemplatePageCount(int i)
    {
        _emailTemplatePageCount += i;
        increaseTotalPageCountBy(i);
    }

    //##################################################
    //# run
    //##################################################

    public void run()
    {
        computeEmailTemplateSummary();
        computeBlurbSummary();
    }

    private void computeEmailTemplateSummary()
    {
        KmList<MyEmailTemplate> v = getProjectEmailTemplates();

        int emailCount = v.size();
        int charCount = getEmailCharacterCountFrom(v);
        int wordCount = computeWordCountFor(charCount);
        int pageCount = computePageCountFor(wordCount);

        incrementEmailTemplateCount(emailCount);
        incrementEmailTemplateWordCount(wordCount);
        incrementEmailTemplatePageCount(pageCount);
    }

    private void computeBlurbSummary()
    {
        KmList<MyBlurb> v = getProjectBlurbs();

        int blurbCount = v.size();
        int charCount = getBlurbCharacterCountFrom(v);
        int wordCount = computeWordCountFor(charCount);
        int pageCount = computePageCountFor(wordCount);

        incrementBlurbCount(blurbCount);
        incrementBlurbWordCount(wordCount);
        incrementBlurbPageCount(pageCount);
    }

    //##################################################
    //# computations
    //##################################################

    private int computeWordCountFor(int charCount)
    {
        double d = charCount;
        double words = d / CHARS_PER_WORD;

        return (int)Kmu.roundUpToInteger(words);
    }

    private int computePageCountFor(int wordCount)
    {
        double d = wordCount;
        double words = d / WORDS_PER_PAGE;

        return (int)Kmu.roundUpToInteger(words);
    }

    //==================================================
    //= computations :: blurbs
    //==================================================

    private KmList<MyBlurb> getProjectBlurbs()
    {
        KmList<MyBlurb> v;
        v = getProject().getBlurbs().toList();
        v.retainIf(e -> e.isEnabled());
        return v;
    }

    private int getBlurbCharacterCountFrom(KmList<MyBlurb> v)
    {
        int i = 0;

        for ( MyBlurb e : v )
            if ( e.hasMessageHtml() )
                i += e.getMessageHtml().length();

        return i;
    }

    //==================================================
    //= computations :: email templates
    //==================================================

    private KmList<MyEmailTemplate> getProjectEmailTemplates()
    {
        KmList<MyEmailTemplate> v;
        v = getProject().getEmailTemplates().toList();
        v.retainIf(e -> e.isEnabled());
        return v;
    }

    private int getEmailCharacterCountFrom(KmList<MyEmailTemplate> v)
    {
        int i = 0;

        for ( MyEmailTemplate e : v )
            if ( e.hasBodyHtml() )
                i += e.getBodyHtml().length();

        return i;
    }
}
