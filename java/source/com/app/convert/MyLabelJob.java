package com.app.convert;

import com.kodemore.collection.KmList;

public class MyLabelJob
{
    //##################################################
    //# variables
    //##################################################

    private Integer                  _quantity;
    private KmList<MyLabelElementIF> _elements;

    //##################################################
    //# constructor
    //##################################################

    public MyLabelJob()
    {
        _quantity = 1;
        _elements = new KmList<MyLabelElementIF>();
    }

    //##################################################
    //# accessing
    //##################################################

    public Integer getQuantity()
    {
        return _quantity;
    }

    public void setQuantity(Integer e)
    {
        _quantity = e;
    }

    //##################################################
    //# elements
    //##################################################

    public KmList<MyLabelElementIF> getElements()
    {
        return _elements;
    }

    public <E extends MyLabelElementIF> E addElement(E e)
    {
        _elements.add(e);
        return e;
    }

    public MyLabelText addText()
    {
        MyLabelText e;
        e = new MyLabelText();
        return addElement(e);
    }

    public MyLabelBarcode addBarcode()
    {
        MyLabelBarcode e;
        e = new MyLabelBarcode();
        return addElement(e);
    }
}
