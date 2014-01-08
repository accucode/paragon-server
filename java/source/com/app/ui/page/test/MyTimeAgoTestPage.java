package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScTimeAgo;
import com.kodemore.time.KmTimestamp;

public class MyTimeAgoTestPage
    extends MyAbstractTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyTimeAgoTestPage instance = new MyTimeAgoTestPage();

    private MyTimeAgoTestPage()
    {
        // singleton
    }

    //##################################################
    //# navigation
    //##################################################

    @Override
    public ScParameterList composeQueryParameters()
    {
        return null;
    }

    @Override
    public void applyQueryParameters(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        KmTimestamp now = getNowUtc();

        root.css().pad();

        ScFieldTable fields;
        fields = root.addFields();

        add(fields, "now", now);
        add(fields, "+1s", now.addSeconds(1));
        add(fields, "-1s", now.addSeconds(-1));
        add(fields, "+1m", now.addMinutes(1));
        add(fields, "-1m", now.addMinutes(-1));
        add(fields, "+10m", now.addMinutes(10));
        add(fields, "-10m", now.addMinutes(-10));
        add(fields, "+1h", now.addHours(1));
        add(fields, "-1h", now.addHours(-1));
        add(fields, "+10h", now.addHours(10));
        add(fields, "-10h", now.addHours(-10));
        add(fields, "+24h", now.addHours(24));
        add(fields, "-24h", now.addHours(-24));
        add(fields, "+10d", now.addDays(10));
        add(fields, "-10d", now.addDays(-10));
        add(fields, "+20d", now.addDays(20));
        add(fields, "-20d", now.addDays(-20));
        add(fields, "+30d", now.addDays(30));
        add(fields, "-30d", now.addDays(-30));
        add(fields, "+31d", now.addDays(31));
        add(fields, "-31d", now.addDays(-31));
        add(fields, "+60d", now.addDays(60));
        add(fields, "-60d", now.addDays(-60));
        add(fields, "+200d", now.addDays(200));
        add(fields, "-200d", now.addDays(-200));
        add(fields, "+500d", now.addDays(500));
        add(fields, "-500d", now.addDays(-500));
        add(fields, "+5000d", now.addDays(5000));
        add(fields, "-5000d", now.addDays(-5000));
    }

    private void add(ScFieldTable fields, String label, KmTimestamp ts)
    {
        ScTimeAgo e;
        e = fields.addTimeAgo();
        e.setLabel(label);
        e.setUtcTs(ts);
    }
}
