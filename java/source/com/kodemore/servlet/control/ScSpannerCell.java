package com.kodemore.servlet.control;

import com.kodemore.utility.Kmu;

public class ScSpannerCell
{
    //##################################################
    //# variables
    //##################################################

    private Object  _value;
    private boolean _rowSpan;
    private boolean _columnSpan;
    private boolean _first;

    //##################################################
    //# value
    //##################################################

    public Object getValue()
    {
        return _value;
    }

    public void setValue(Object e)
    {
        _value = e;
    }

    public boolean isNull()
    {
        return _value == null;
    }

    public boolean hasCellValue(ScSpannerCell e)
    {
        return hasValue(e._value);
    }

    public boolean hasValue(Object e)
    {
        return Kmu.isEqual(_value, e);
    }

    //##################################################
    //# span
    //##################################################

    public boolean isRowSpan()
    {
        return _rowSpan;
    }

    public void setRowSpan()
    {
        _rowSpan = true;
    }

    public void setFirstRowSpan()
    {
        _first = true;
        _rowSpan = true;
    }

    public boolean isColumnSpan()
    {
        return _columnSpan;
    }

    public void setColumnSpan()
    {
        _columnSpan = true;
    }

    public void setFirstColumnSpan()
    {
        _first = true;
        _columnSpan = true;
    }

    public boolean isFirst()
    {
        return _first;
    }

    public boolean isSpan()
    {
        return isRowSpan() || isColumnSpan();
    }

    public boolean isNotSpan()
    {
        return !isSpan();
    }
}
