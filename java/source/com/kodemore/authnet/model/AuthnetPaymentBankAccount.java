package com.kodemore.authnet.model;

import java.io.PrintWriter;

import com.kodemore.xml.utility.KmXmlBuilder;

public class AuthnetPaymentBankAccount
    extends AuthnetPayment
{
    //##################################################
    //# constants
    //##################################################

    private static final String ACCOUNT_TYPE_CHECKING          = "checking";
    private static final String ACCOUNT_TYPE_SAVINGS           = "savings";
    private static final String ACCOUNT_TYPE_BUSINESS_CHECKING = "businessChecking";

    private static final String ECHECK_TYPE_CCD                = "CCD";
    private static final String ECHECK_TYPE_PPD                = "PPD";
    private static final String ECHECK_TYPE_TEL                = "TEL";
    private static final String ECHECK_TYPE_WEB                = "WEB";

    //##################################################
    //# variables
    //##################################################

    private String              _accountType;
    private String              _routingNumber;
    private String              _accountNumber;
    private String              _nameOnAccount;
    private String              _echeckType;
    private String              _bankName;

    //##################################################
    //# routing number
    //##################################################

    public String getRoutingNumber()
    {
        return _routingNumber;
    }

    public void setRoutingNumber(String e)
    {
        _routingNumber = e;
    }

    public boolean hasRoutingNumber()
    {
        return _routingNumber != null;
    }

    //##################################################
    //# account number
    //##################################################

    public String getAccountNumber()
    {
        return _accountNumber;
    }

    public void setAccountNumber(String e)
    {
        _accountNumber = e;
    }

    public boolean hasAccountNumber()
    {
        return _accountNumber != null;
    }

    //##################################################
    //# name on account
    //##################################################

    public String getNameOnAccount()
    {
        return _nameOnAccount;
    }

    public void setNameOnAccount(String e)
    {
        _nameOnAccount = e;
    }

    public boolean hasNameOnAccount()
    {
        return _nameOnAccount != null;
    }

    //##################################################
    //# bank name
    //##################################################

    public String getBankName()
    {
        return _bankName;
    }

    public void setBankName(String e)
    {
        _bankName = e;
    }

    public boolean hasBankName()
    {
        return _bankName != null;
    }

    //##################################################
    //# account type
    //##################################################

    public String getAccountType()
    {
        return _accountType;
    }

    public void setAccountTypeChecking()
    {
        _accountType = ACCOUNT_TYPE_CHECKING;
    }

    public void setAccountTypeSavings()
    {
        _accountType = ACCOUNT_TYPE_SAVINGS;
    }

    public void setAccountTypeBusinessChecking()
    {
        _accountType = ACCOUNT_TYPE_BUSINESS_CHECKING;
    }

    public boolean hasAccountType()
    {
        return _accountType != null;
    }

    //##################################################
    //# echeck type
    //##################################################

    public String getEcheckType()
    {
        return _echeckType;
    }

    public void setEcheckTypeCcd()
    {
        _echeckType = ECHECK_TYPE_CCD;
    }

    public void setEcheckTypePpd()
    {
        _echeckType = ECHECK_TYPE_PPD;
    }

    public void setEcheckTypeTel()
    {
        _echeckType = ECHECK_TYPE_TEL;
    }

    public void setEcheckTypeWeb()
    {
        _echeckType = ECHECK_TYPE_WEB;
    }

    public boolean hasEcheckType()
    {
        return _echeckType != null;
    }

    //##################################################
    //# validation - taken from the authnet xml guide
    //##################################################

    @Override
    public boolean isValid()
    {
        if ( !super.isValid() )
            return false;

        if ( !hasRoutingNumber() )
            return false;

        if ( getRoutingNumber().length() > 9 )
            return false;

        if ( !hasAccountNumber() )
            return false;

        if ( getAccountNumber().length() < 5 )
            return false;

        if ( getAccountNumber().length() > 17 )
            return false;

        if ( !hasNameOnAccount() )
            return false;

        return true;
    }

    //##################################################
    //# type
    //##################################################

    @Override
    protected Integer getType()
    {
        return PAYMENT_TYPE_BANK_ACCOUNT;
    }

    //##################################################
    //# xml
    //##################################################

    @Override
    protected void printInternalXmlOn(KmXmlBuilder out)
    {
        out.begin("bankAccount");

        out.value("routingNumber", getRoutingNumber());
        out.value("accountNumber", getAccountNumber());
        out.value("nameOnAccount", getNameOnAccount());

        if ( hasAccountType() )
            out.value("accountType", getAccountType());

        if ( hasEcheckType() )
            out.value("echeckType", getEcheckType());

        if ( hasBankName() )
            out.value("bankName", getBankName());

        out.end();
    }

    //##################################################
    //# print
    //##################################################

    @Override
    public void printFieldsOn(PrintWriter out)
    {
        out.println("======= Bank Account =======");
        out.println("routingNumber: " + getRoutingNumber());
        out.println("accountNumber: " + getAccountNumber());
        out.println("nameOnAccount: " + getNameOnAccount());
        out.println("accountType: " + getAccountType());
        out.println("bankName: " + getBankName());
    }

}
