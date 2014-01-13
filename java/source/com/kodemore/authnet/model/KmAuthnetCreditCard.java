package com.kodemore.authnet.model;

import java.io.PrintWriter;

import com.kodemore.utility.Kmu;
import com.kodemore.xml.utility.KmXmlBuilder;

public class KmAuthnetCreditCard
    extends KmAuthnetPayment
{
    //##################################################
    //# variables
    //##################################################

    private String _cardNumber;

    /**
     * The expiration "date" in the format YYYY-MM.
     */
    private String _expiry;

    //##################################################
    //# card number
    //##################################################

    public String getCardNumber()
    {
        return _cardNumber;
    }

    public void setCardNumber(String e)
    {
        _cardNumber = e;
    }

    public boolean hasCardNumber()
    {
        return _cardNumber != null;
    }

    //##################################################
    //# expiry
    //##################################################

    public String getExpiry()
    {
        return _expiry;
    }

    public void setExpiry(int year, int month)
    {
        String yy = Kmu.leftPad(year, 4);
        String mm = Kmu.leftPad(month, 2);
        String s = Kmu.format("%s-%s", yy, mm);
        setExpiry(s);
    }

    public void setExpiry(String e)
    {
        _expiry = e;
    }

    public boolean hasExpiry()
    {
        return _expiry != null;
    }

    //##################################################
    //# static
    //##################################################

    @Override
    public boolean isValid()
    {
        if ( !super.isValid() )
            return false;

        if ( !hasCardNumber() )
            return false;

        if ( !hasExpiry() )
            return false;

        return true;
    }

    //##################################################
    //# type
    //##################################################

    @Override
    public Integer getType()
    {
        return PAYMENT_TYPE_CREDIT_CARD;
    }

    //##################################################
    //# xml
    //##################################################

    @Override
    protected void printInternalXmlOn(KmXmlBuilder out)
    {
        out.begin("creditCard");

        if ( hasCardNumber() )
            out.value("cardNumber", getCardNumber());
        else
            out.emptyValue("cardNumber");

        if ( hasExpiry() )
            out.value("expirationDate", getExpiry());
        else
            out.value("expirationDate", "XXXX");

        out.end();
    }

    //##################################################
    //# print
    //##################################################

    @Override
    public void printFieldsOn(PrintWriter out)
    {
        out.println("======= Credit Card =======");
        out.println("cardNumber: " + getCardNumber());
        out.println("expiry:     " + getExpiry());
    }

}
