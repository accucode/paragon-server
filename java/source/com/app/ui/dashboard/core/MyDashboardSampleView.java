package com.app.ui.dashboard.core;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScTransientDiv;
import com.kodemore.servlet.variable.ScLocalInteger;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.KmEnumIF;

public class MyDashboardSampleView
    extends ScTransientDiv
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalString  _orientationTypeCode;
    private ScLocalInteger _lineCount1;
    private ScLocalInteger _lineCount2;

    //##################################################
    //# constructor
    //##################################################

    public MyDashboardSampleView()
    {
        _orientationTypeCode = new ScLocalString();
        _lineCount1 = new ScLocalInteger();
        _lineCount2 = new ScLocalInteger();

        css().dashboard_sample();
    }

    //##################################################
    //# accessing :: orientation
    //##################################################

    public MyDashboardOrientationType getOrientationType()
    {
        String code = _orientationTypeCode.getValue();
        return MyDashboardOrientationType.findCode(code);
    }

    public void setOrientationType(MyDashboardOrientationType e)
    {
        _orientationTypeCode.setValue(KmEnumIF.getCodeFor(e));
    }

    //==================================================
    //= accessing :: line counts
    //==================================================

    public int getLineCount1()
    {
        return _lineCount1.getValue();
    }

    public void setLineCount1(int i)
    {
        _lineCount1.setValue(i);
    }

    public int getLineCount2()
    {
        return _lineCount2.getValue();
    }

    public void setLineCount2(int i)
    {
        _lineCount2.setValue(i);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    public void preRender()
    {
        super.preRender();

        preRenderContainer();
        preRenderLines();
    }

    private void preRenderContainer()
    {
        MyDashboardOrientationType type = getOrientationType();
        switch ( type )
        {
            case Auto:
            case Landsapce:
                css().dashboard_sampleLandscape();
                break;

            case Portrait:
                css().dashboard_samplePortrait();
                break;
        }
    }

    private void preRenderLines()
    {
        char c;
        c = 'A';
        c += preRenderLine(c, getLineCount1());
        c += preRenderLine(c, getLineCount2());
    }

    private int preRenderLine(char letter, int n)
    {
        if ( n == 0 )
            return n;

        ScDiv line;
        line = addDiv();
        line.css().dashboard_sampleLine();

        for ( int i = 0; i < n; i++ )
        {

            ScDiv panel;
            panel = line.addDiv();
            panel.css().dashboard_samplePanel();
            panel.addText(letter + "");

            letter++;
        }

        return n;
    }
}
