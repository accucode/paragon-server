package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDateAgo;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScText;
import com.kodemore.servlet.control.ScTimeAgo;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmTimestamp;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyTimeAgoTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyTimeAgoTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyTimeAgoTestPage();
    }

    public static MyTimeAgoTestPage getInstance()
    {
        return _instance;
    }

    private MyTimeAgoTestPage()
    {
        // singleton
    }

    //##################################################
    //# settings
    //##################################################

    @Override
    public final MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.developer;
    }

    //##################################################
    //# bookmark
    //##################################################

    @Override
    public void composeBookmarkOn(ScParameterList v)
    {
        // none
    }

    @Override
    public void applyBookmark(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().gap();

        installTimeSamples(root);
        installDateSamples(root);
    }

    private void installTimeSamples(ScPageRoot root)
    {
        KmTimestamp origin = getNowUtc();

        ScGroup group;
        group = root.addGroup("Time Ago");
        group.css().floatLeft();
        group.style().width(200);

        ScFieldTable fields;
        fields = group.getBody().addPad().addFieldTable();

        ScText nowText;
        nowText = fields.addText(origin.format_m_d_yyyy_hh_mm_ss());
        nowText.setLabel("Origin");

        fields.addSpace();

        addTime(fields, "0", origin);
        addTime(fields, "+1s", origin.addSeconds(1));
        addTime(fields, "-1s", origin.addSeconds(-1));
        addTime(fields, "+1m", origin.addMinutes(1));
        addTime(fields, "-1m", origin.addMinutes(-1));
        addTime(fields, "+10m", origin.addMinutes(10));
        addTime(fields, "-10m", origin.addMinutes(-10));
        addTime(fields, "+1h", origin.addHours(1));
        addTime(fields, "-1h", origin.addHours(-1));
        addTime(fields, "+10h", origin.addHours(10));
        addTime(fields, "-10h", origin.addHours(-10));
        addTime(fields, "+24h", origin.addHours(24));
        addTime(fields, "-24h", origin.addHours(-24));
        addTime(fields, "+10d", origin.addDays(10));
        addTime(fields, "-10d", origin.addDays(-10));
        addTime(fields, "+20d", origin.addDays(20));
        addTime(fields, "-20d", origin.addDays(-20));
        addTime(fields, "+30d", origin.addDays(30));
        addTime(fields, "-30d", origin.addDays(-30));
        addTime(fields, "+31d", origin.addDays(31));
        addTime(fields, "-31d", origin.addDays(-31));
        addTime(fields, "+60d", origin.addDays(60));
        addTime(fields, "-60d", origin.addDays(-60));
        addTime(fields, "+200d", origin.addDays(200));
        addTime(fields, "-200d", origin.addDays(-200));
        addTime(fields, "+500d", origin.addDays(500));
        addTime(fields, "-500d", origin.addDays(-500));
        addTime(fields, "+5000d", origin.addDays(5000));
        addTime(fields, "-5000d", origin.addDays(-5000));
    }

    private void addTime(ScFieldTable fields, String label, KmTimestamp ts)
    {
        ScTimeAgo e;
        e = fields.addTimeAgo();
        e.setLabel(label);
        e.setUtcTs(ts);
    }

    private void installDateSamples(ScPageRoot root)
    {
        KmDate origin = getTodayUtc();

        ScGroup group;
        group = root.addGroup("Date Ago");
        group.css().floatLeft();
        group.style().width(200);

        ScFieldTable fields;
        fields = group.getBody().addPad().addFieldTable();

        ScText nowText;
        nowText = fields.addText(origin.format_mm_dd_yyyy());
        nowText.setLabel("Origin");

        fields.addSpace();

        addDate(fields, "0", origin);
        addDate(fields, "+1d", origin.addDays(1));
        addDate(fields, "-1d", origin.addDays(-1));
        addDate(fields, "+10d", origin.addDays(10));
        addDate(fields, "-10d", origin.addDays(-10));
        addDate(fields, "+20d", origin.addDays(20));
        addDate(fields, "-20d", origin.addDays(-20));
        addDate(fields, "+30d", origin.addDays(30));
        addDate(fields, "-30d", origin.addDays(-30));
        addDate(fields, "+31d", origin.addDays(31));
        addDate(fields, "-31d", origin.addDays(-31));
        addDate(fields, "+60d", origin.addDays(60));
        addDate(fields, "-60d", origin.addDays(-60));
        addDate(fields, "+200d", origin.addDays(200));
        addDate(fields, "-200d", origin.addDays(-200));
        addDate(fields, "+500d", origin.addDays(500));
        addDate(fields, "-500d", origin.addDays(-500));
        addDate(fields, "+5000d", origin.addDays(5000));
        addDate(fields, "-5000d", origin.addDays(-5000));
    }

    private void addDate(ScFieldTable fields, String label, KmDate date)
    {
        ScDateAgo e;
        e = fields.addDateAgo();
        e.setLabel(label);
        e.setDate(date);
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        // none
    }

}
