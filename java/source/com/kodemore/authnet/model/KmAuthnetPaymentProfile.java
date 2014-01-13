package com.kodemore.authnet.model;

import java.io.PrintWriter;

import com.kodemore.xml.utility.KmXmlBuilder;

public class KmAuthnetPaymentProfile
{
    //##################################################
    //# constants
    //##################################################

    private static final String    CUSTOMER_TYPE_INDIVIDUAL = "individual";
    private static final String    CUSTOMER_TYPE_BUSINESS   = "business";

    //##################################################
    //# variables
    //##################################################

    private Integer                _customerPaymentProfileId;
    private String                 _customerType;
    private KmAuthnetBillToAddress _billTo;
    private KmAuthnetPayment       _payment;

    private boolean                _isSingular;

    //##################################################
    //# constructor
    //##################################################

    public KmAuthnetPaymentProfile()
    {
        setMultiple();
    }

    //##################################################
    //# customer type
    //##################################################

    public void setCustomerPaymentProfileId(Integer e)
    {
        _customerPaymentProfileId = e;
    }

    public Integer getCustomerPaymentProfileId()
    {
        return _customerPaymentProfileId;
    }

    public boolean hasCustomerPaymentProfileId()
    {
        return _customerPaymentProfileId != null;
    }

    //##################################################
    //# customer type
    //##################################################

    public void setCustomerTypeIndividual()
    {
        _customerType = CUSTOMER_TYPE_INDIVIDUAL;
    }

    public void setCustomerTypeBusiness()
    {
        _customerType = CUSTOMER_TYPE_BUSINESS;
    }

    public String getCustomerType()
    {
        return _customerType;
    }

    public boolean hasCustomerType()
    {
        return _customerType != null;
    }

    public void setCustomerType(String type)
    {
        _customerType = type;
    }

    //##################################################
    //# bill to
    //##################################################

    public KmAuthnetAddress addBillTo()
    {
        _billTo = new KmAuthnetBillToAddress();
        return _billTo;
    }

    public KmAuthnetAddress getBillTo()
    {
        return _billTo;
    }

    public void setBillTo(KmAuthnetBillToAddress e)
    {
        _billTo = e;
    }

    public boolean hasBillTo()
    {
        return _billTo != null;
    }

    //##################################################
    //# payment
    //##################################################

    public KmAuthnetPaymentBankAccount addBankAccount()
    {
        _payment = new KmAuthnetPaymentBankAccount();
        return (KmAuthnetPaymentBankAccount)_payment;
    }

    public KmAuthnetCreditCard addCreditCard()
    {
        _payment = new KmAuthnetCreditCard();
        return (KmAuthnetCreditCard)_payment;
    }

    public void setPayment(KmAuthnetPayment e)
    {
        _payment = e;
    }

    public KmAuthnetPayment getPayment()
    {
        return _payment;
    }

    public KmAuthnetCreditCard getCreditCard()
    {
        return (KmAuthnetCreditCard)_payment;
    }

    public boolean hasPayment()
    {
        return _payment != null;
    }

    //##################################################
    //# singular
    //##################################################

    public void setSingular()
    {
        _isSingular = true;
    }

    public void setMultiple()
    {
        _isSingular = false;
    }

    public boolean isSingular()
    {
        return _isSingular;
    }

    //##################################################
    //# validation
    //##################################################

    public boolean isValid()
    {
        return true;
    }

    //##################################################
    //# xml
    //##################################################

    public void printXmlOn(KmXmlBuilder out)
    {
        if ( isSingular() )
            out.begin("paymentProfile");
        else
            out.begin("paymentProfiles");

        if ( hasCustomerType() )
            out.value("customerType", getCustomerType());

        if ( hasBillTo() )
            _billTo.printXmlOn(out);

        if ( hasPayment() )
            _payment.printXmlOn(out);

        if ( hasCustomerPaymentProfileId() )
            out.value("customerPaymentProfileId", getCustomerPaymentProfileId());

        out.end();
    }

    //##################################################
    //# print
    //##################################################

    public void printFields()
    {
        PrintWriter out = new PrintWriter(System.out);
        printFieldsOn(out);
        out.flush();
    }

    public void printFieldsOn(PrintWriter out)
    {
        out.println("======= Payment Profile =======");
        out.println("customerPayentProfileId: " + getCustomerPaymentProfileId());
        out.println("customerType:            " + getCustomerType());

        if ( hasBillTo() )
            _billTo.printFieldsOn(out);

        if ( hasPayment() )
            _payment.printFieldsOn(out);
    }

}
