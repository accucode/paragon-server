package com.app.convert;

import com.kodemore.utility.Kmu;

public class MyLabelBarcode
    implements MyLabelElementIF
{
    //##################################################
    //# variables
    //##################################################

    private Double                            _x;
    private Double                            _y;
    private Double                            _height;
    private MyLabelBarcodeType                _type;
    private MyLabelOrientation                _orientation;
    private MyLabelInterpretationLinePosition _interpretationLinePosition;
    private Boolean                           _printCheckDigit;
    private String                            _value;

    //##################################################
    //# constructor
    //##################################################

    public MyLabelBarcode()
    {
        _x = 0.0;
        _y = 0.0;
        _height = 36.0;
        _type = MyLabelBarcodeType.UPC_A;
        _orientation = MyLabelOrientation.Normal;
        _interpretationLinePosition = MyLabelInterpretationLinePosition.Bottom;
        _printCheckDigit = true;
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

    public MyLabelBarcodeType getType()
    {
        return _type;
    }

    public void setType(MyLabelBarcodeType e)
    {
        _type = e;
    }

    public MyLabelInterpretationLinePosition getInterpretationLinePosition()
    {
        return _interpretationLinePosition;
    }

    public void setInterpretationLinePosition(MyLabelInterpretationLinePosition e)
    {
        _interpretationLinePosition = e;
    }

    public Boolean getPrintCheckDigit()
    {
        return _printCheckDigit;
    }

    public void setPrintCheckDigit(Boolean e)
    {
        _printCheckDigit = e;
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
        return MyLabelElementType.Barcode;
    }

}
