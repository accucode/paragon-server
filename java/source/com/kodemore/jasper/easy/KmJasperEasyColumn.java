/*
  Copyright (c) 2010-2010 www.kodemore.com

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

package com.kodemore.jasper.easy;

import java.util.HashMap;
import java.util.Map;

import com.kodemore.jasper.KmJasperExpression;
import com.kodemore.jasper.KmJasperGroup;
import com.kodemore.jasper.KmJasperReportBuilder;
import com.kodemore.jasper.field.KmJasperField;
import com.kodemore.jasper.field.KmJasperVariable;

public class KmJasperEasyColumn
{
    //##################################################
    //# enum
    //##################################################

    protected enum WidthMode
    {
        Auto,
        Fixed,
        Percent,
        Overlay;
    }

    //##################################################
    //# variables
    //##################################################

    private KmJasperEasyBuilder                   _builder;
    private KmJasperField                         _field;

    private String                                _title;

    private WidthMode                             _widthMode;
    private int                                   _fixedWidth;
    private double                                _percentWidth;

    private int                                   _x;
    private int                                   _width;

    private Map<KmJasperGroup,KmJasperExpression> _groupExpressions;

    //##################################################
    //# constructor
    //##################################################

    public KmJasperEasyColumn(KmJasperEasyBuilder builder, KmJasperField field)
    {
        _builder = builder;
        _field = field;
        _widthMode = WidthMode.Auto;
        _groupExpressions = new HashMap<KmJasperGroup,KmJasperExpression>();
    }

    //##################################################
    //# field 
    //##################################################

    public KmJasperField getField()
    {
        return _field;
    }

    public KmJasperReportBuilder getReport()
    {
        return _builder.getReport();
    }

    //##################################################
    //# title
    //##################################################

    public String getTitle()
    {
        return _title;
    }

    public void setTitle(String e)
    {
        _title = e;
    }

    //##################################################
    //# width 
    //##################################################

    public WidthMode getWidthMode()
    {
        return _widthMode;
    }

    public void setAutoWidth()
    {
        _widthMode = WidthMode.Auto;
    }

    public int getFixedWidth()
    {
        return _fixedWidth;
    }

    public void setFixedWidth(int i)
    {
        _widthMode = WidthMode.Fixed;
        _fixedWidth = i;
    }

    public double getPercentWidth()
    {
        return _percentWidth;
    }

    public void setPercentWidth(double percent)
    {
        _widthMode = WidthMode.Percent;
        _percentWidth = percent;
    }

    //##################################################
    //# position
    //##################################################

    public int getX()
    {
        return _x;
    }

    public void setX(int e)
    {
        _x = e;
    }

    //##################################################
    //# width
    //##################################################

    public int getWidth()
    {
        return _width;
    }

    public void _setWidth(int e)
    {
        _width = e;
    }

    //##################################################
    //# group total
    //##################################################

    public Map<KmJasperGroup,KmJasperExpression> getGroupExpressions()
    {
        return _groupExpressions;
    }

    public void addGroupTotal()
    {
        addGroupTotal(getReport().getGroups().get(0));
    }

    public void addGroupTotal(KmJasperGroup group)
    {
        KmJasperField field;
        field = getField();

        KmJasperExpression init;
        init = new KmJasperExpression();
        init.setRawValue("0");

        KmJasperVariable var;
        var = getReport().addVariable();
        var.setType(field.getType());
        var.setCalculationSum();
        var.setResetTypeGroup(group);
        var.setInitialExpression(init);
        var.setVariableExpression(field.getExpression());

        _groupExpressions.put(group, var.getExpression());
    }

}
