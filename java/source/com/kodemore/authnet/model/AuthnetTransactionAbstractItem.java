package com.kodemore.authnet.model;

import com.kodemore.types.KmMoney;
import com.kodemore.xml.utility.KmXmlBuilder;

public abstract class AuthnetTransactionAbstractItem
{
    //##################################################
    //# variables
    //##################################################

    private KmMoney _amount;
    private String  _name;
    private String  _description;

    //##################################################
    //# abstract methods
    //##################################################

    protected abstract String getXmlTag();

    //##################################################
    //# amount
    //##################################################

    public KmMoney getAmount()
    {
        return _amount;
    }

    public void setAmount(KmMoney e)
    {
        _amount = e;
    }

    public boolean hasAmount()
    {
        return _amount != null;
    }

    //##################################################
    //# name
    //##################################################

    public String getName()
    {
        return _name;
    }

    public void setName(String e)
    {
        _name = e;
    }

    public boolean hasName()
    {
        return _name != null;
    }

    //##################################################
    //# description
    //##################################################

    public String getDescription()
    {
        return _description;
    }

    public void setDescription(String e)
    {
        _description = e;
    }

    public boolean hasDescription()
    {
        return _description != null;
    }

    //##################################################
    //# xml
    //##################################################

    public void printXmlOn(KmXmlBuilder out)
    {
        out.begin(getXmlTag());

        if ( hasAmount() )
            out.value("amount", getAmount().format(2, false));

        if ( hasName() )
            out.value("name", getName());

        if ( hasDescription() )
            out.value("description", getDescription());

        out.end();
    }

}
