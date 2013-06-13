package com.app.convert;

import com.kodemore.utility.Kmu;

public class MyLabelText
    implements MyLabelElementIF
{
    //##################################################
    //# variables
    //##################################################

    private Double             _x;
    private Double             _y;
    private Double             _height;
    private MyLabelOrientation _orientation;
    private String             _value;

    //##################################################
    //# constructor
    //##################################################

    public MyLabelText()
    {
        _x = 0.0;
        _y = 0.0;
        _height = 12.0;
        _orientation = MyLabelOrientation.Normal;
    }

    //##################################################
    //# accessing
    //##################################################

    public Double getX()
    {
        return _x;
    }

    public void setX(Double e)
    {
        _x = e;
    }

    public Double getY()
    {
        return _y;
    }

    public void setY(Double e)
    {
        _y = e;
    }

    public Double getHeight()
    {
        return _height;
    }

    public void setHeight(Double e)
    {
        _height = e;
    }

    public MyLabelOrientation getOrientation()
    {
        return _orientation;
    }

    public void setOrientation(MyLabelOrientation e)
    {
        _orientation = e;
    }

    public String getValue()
    {
        return _value;
    }

    public void setValue(String e)
    {
        _value = e;
    }

    public boolean hasValue()
    {
        return Kmu.hasValue(getValue());
    }

    @Override
    public MyLabelElementType getLabelElementType()
    {
        return MyLabelElementType.Text;
    }
}
