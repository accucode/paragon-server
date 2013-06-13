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

package com.kodemore.jasper.field;

import com.kodemore.jasper.KmJasperElementIF;
import com.kodemore.jasper.KmJasperExpression;
import com.kodemore.jasper.KmJasperGroup;
import com.kodemore.jasper.KmJasperType;
import com.kodemore.jasper.xml.KmJasperXmlElement;

public class KmJasperVariable
    implements KmJasperElementIF
{
    //##################################################
    //# variables
    //##################################################

    private String             _name;
    private KmJasperType       _type;
    private String             _resetType;
    private KmJasperGroup      _resetGroup;
    private String             _calculation;

    private KmJasperExpression _variableExpression;
    private KmJasperExpression _initialExpression;

    //##################################################
    //# constructor
    //##################################################

    public KmJasperVariable(String name)
    {
        _name = name;
        setResetTypeReport();
        setCalculationNone();
    }

    //##################################################
    //# name
    //##################################################

    public String getName()
    {
        return _name;
    }

    public boolean hasName(String e)
    {
        return _name.equals(e);
    }

    //##################################################
    //# format
    //##################################################

    public String formatToken()
    {
        return "$V{" + getName() + "}";
    }

    //##################################################
    //# type
    //##################################################

    public KmJasperType getType()
    {
        return _type;
    }

    public void setType(KmJasperType e)
    {
        _type = e;
    }

    //##################################################
    //# reset type 
    //##################################################

    public String getResetType()
    {
        return _resetType;
    }

    public KmJasperGroup getResetGroup()
    {
        return _resetGroup;
    }

    public void setResetTypeNone()
    {
        _resetType = "None";
    }

    public void setResetTypeReport()
    {
        _resetType = "Report";
    }

    public void setResetTypePage()
    {
        _resetType = "Page";
    }

    public void setResetTypeColumn()
    {
        _resetType = "Column";
    }

    public void setResetTypeGroup(KmJasperGroup e)
    {
        _resetType = "Group";
        _resetGroup = e;
    }

    //##################################################
    //# calculation
    //##################################################

    public String getCalculation()
    {
        return _calculation;
    }

    public void setCalculationNone()
    {
        _calculation = "Nothing";
    }

    public void setCalculationCount()
    {
        _calculation = "Count";
    }

    public void setCalculationSum()
    {
        _calculation = "Sum";
    }

    public void setCalculationAverage()
    {
        _calculation = "Average";
    }

    public void setCalculationLowest()
    {
        _calculation = "Lowest";
    }

    public void setCalculationHighest()
    {
        _calculation = "Highest";
    }

    public void setCalculationStandardDeviation()
    {
        _calculation = "StandardDeviation";
    }

    public void setCalculationVariance()
    {
        _calculation = "Variance";
    }

    public void setCalculationSystem()
    {
        _calculation = "System";
    }

    //##################################################
    //# expressions
    //##################################################

    public KmJasperExpression getVariableExpression()
    {
        return _variableExpression;
    }

    public void setVariableExpression(KmJasperExpression e)
    {
        _variableExpression = e;
    }

    public KmJasperExpression getInitialExpression()
    {
        return _initialExpression;
    }

    public void setInitialExpression(KmJasperExpression e)
    {
        _initialExpression = e;
    }

    //##################################################
    //# compose 
    //##################################################

    @Override
    public void addTo(KmJasperXmlElement root)
    {
        KmJasperXmlElement var;
        var = root.addElement("variable");
        var.addAttribute("name", getName());
        var.addAttribute("class", getType().getName());
        var.addAttribute("resetType", getResetType());

        if ( getResetType().equals("Group") )
            var.addAttribute("resetGroup", getResetGroup().getName());

        var.addAttribute("calculation", getCalculation());

        if ( _variableExpression != null )
            _variableExpression.addToWithoutClass(var, "variableExpression");

        if ( _initialExpression != null )
            _initialExpression.addToWithoutClass(var, "initialValueExpression");
    }

    //##################################################
    //# expressions
    //##################################################

    public KmJasperExpression getExpression()
    {
        KmJasperExpression e;
        e = new KmJasperExpression();
        e.setValue(this);
        return e;
    }

}
