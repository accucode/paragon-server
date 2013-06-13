package com.kodemore.authnet.model;

import com.kodemore.collection.KmList;
import com.kodemore.types.KmMoney;
import com.kodemore.utility.Kmu;
import com.kodemore.xml.utility.KmXmlBuilder;

public class AuthnetTransaction
{
    //##################################################
    //# constants
    //##################################################

    private static final String                TYPE_CAPTURE_ONLY = "profileTransCaptureOnly";
    private static final String                TYPE_AUTH_CAPTURE = "profileTransAuthCapture";
    private static final String                TYPE_AUTH_ONLY    = "profileTransAuthOnly";

    private static final String                TRUE              = "TRUE";
    private static final String                FALSE             = "FALSE";

    //##################################################
    //# variables
    //##################################################

    private String                             _type;
    private KmMoney                            _amount;
    private AuthnetTransactionTax              _tax;
    private AuthnetTransactionShipping         _shipping;
    private AuthnetTransactionDuty             _duty;
    private KmList<AuthnetTransactionLineItem> _lineItems;
    private Integer                            _customerProfileId;
    private Integer                            _paymentProfileId;
    private Integer                            _customerAddressId;
    private AuthnetTransactionOrder            _order;
    private String                             _taxExempt;
    private String                             _recurringBilling;
    private String                             _cardCcvCode;
    private String                             _approvalCode;

    //##################################################
    //# constructor
    //##################################################

    public AuthnetTransaction()
    {
        _lineItems = new KmList<AuthnetTransactionLineItem>();
    }

    //##################################################
    //# transaction type
    //##################################################

    public String getType()
    {
        return _type;
    }

    public void setTypeCaptureOnly()
    {
        _type = TYPE_CAPTURE_ONLY;
    }

    public boolean hasTypeCaptureOnly()
    {
        if ( !hasType() )
            return false;

        return _type.equals(TYPE_CAPTURE_ONLY);
    }

    public void setTypeAuthCapture()
    {
        _type = TYPE_AUTH_CAPTURE;
    }

    public void setTypeAuthOnly()
    {
        _type = TYPE_AUTH_ONLY;
    }

    public boolean hasType()
    {
        return _type != null;
    }

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
    //# tax
    //##################################################

    public AuthnetTransactionTax getTax()
    {
        return _tax;
    }

    public void setTax(AuthnetTransactionTax e)
    {
        _tax = e;
    }

    public AuthnetTransactionTax addTax()
    {
        _tax = new AuthnetTransactionTax();

        return _tax;
    }

    public boolean hasTax()
    {
        return _tax != null;
    }

    //##################################################
    //# shipping
    //##################################################

    public AuthnetTransactionShipping getShipping()
    {
        return _shipping;
    }

    public void setShipping(AuthnetTransactionShipping e)
    {
        _shipping = e;
    }

    public AuthnetTransactionShipping addShipping()
    {
        _shipping = new AuthnetTransactionShipping();

        return _shipping;
    }

    public boolean hasShipping()
    {
        return _shipping != null;
    }

    //##################################################
    //# duty
    //##################################################

    public AuthnetTransactionDuty getDuty()
    {
        return _duty;
    }

    public void setDuty(AuthnetTransactionDuty e)
    {
        _duty = e;
    }

    public AuthnetTransactionDuty addDuty()
    {
        _duty = new AuthnetTransactionDuty();

        return _duty;
    }

    public boolean hasDuty()
    {
        return _duty != null;
    }

    //##################################################
    //# line items
    //##################################################

    public KmList<AuthnetTransactionLineItem> getLineItems()
    {
        return _lineItems;
    }

    public void setLineItems(KmList<AuthnetTransactionLineItem> v)
    {
        _lineItems = v;
    }

    public AuthnetTransactionLineItem addLineItem()
    {
        AuthnetTransactionLineItem li = new AuthnetTransactionLineItem();
        _lineItems.add(li);
        return li;
    }

    public boolean hasLineItems()
    {
        return !Kmu.isListEmpty(_lineItems);
    }

    //##################################################
    //# customer profile id
    //##################################################

    public Integer getCustomerProfileId()
    {
        return _customerProfileId;
    }

    public void setCustomerProfileId(Integer e)
    {
        _customerProfileId = e;
    }

    public boolean hasCustomerProfileId()
    {
        return _customerProfileId != null;
    }

    //##################################################
    //# payment profile id
    //##################################################

    public Integer getPaymentProfileId()
    {
        return _paymentProfileId;
    }

    public void setPaymentProfileId(Integer e)
    {
        _paymentProfileId = e;
    }

    public boolean hasPaymentProfileId()
    {
        return _paymentProfileId != null;
    }

    //##################################################
    //# customer address id
    //##################################################

    public Integer getCustomerAddressId()
    {
        return _customerAddressId;
    }

    public void setCustomerAddressId(Integer e)
    {
        _customerAddressId = e;
    }

    public boolean hasCustomerAddressId()
    {
        return _customerAddressId != null;
    }

    //##################################################
    //# order
    //##################################################

    public AuthnetTransactionOrder getOrder()
    {
        return _order;
    }

    public void setOrder(AuthnetTransactionOrder e)
    {
        _order = e;
    }

    public AuthnetTransactionOrder addOrder()
    {
        _order = new AuthnetTransactionOrder();
        return _order;
    }

    public boolean hasOrder()
    {
        return _order != null;
    }

    //##################################################
    //# tax exempt
    //##################################################

    public String getTaxExempt()
    {
        return _taxExempt;
    }

    public void setTaxExempt()
    {
        _taxExempt = TRUE;
    }

    public void setNotTaxExempt()
    {
        _taxExempt = FALSE;
    }

    public boolean hasTaxExempt()
    {
        return _taxExempt != null;
    }

    //##################################################
    //# recurring billing
    //##################################################

    public String getRecurringBilling()
    {
        return _recurringBilling;
    }

    public void setRecurringBilling()
    {
        _recurringBilling = TRUE;
    }

    public void setNotRecurringBilling()
    {
        _recurringBilling = FALSE;
    }

    public boolean hasRecurringBilling()
    {
        return _recurringBilling != null;
    }

    //##################################################
    //# ccv
    //##################################################

    public String getCardCcvCode()
    {
        return _cardCcvCode;
    }

    public void setCardCcvCode(String e)
    {
        _cardCcvCode = e;
    }

    public boolean hasCardCcvCode()
    {
        return _cardCcvCode != null;
    }

    //##################################################
    //# approval code
    //##################################################

    public String getApprovalCode()
    {
        return _approvalCode;
    }

    public void setApprovalCode(String e)
    {
        _approvalCode = e;
    }

    public boolean hasApprovalCode()
    {
        return _approvalCode != null;
    }

    //##################################################
    //# validation - take from the authnet xml guide
    //##################################################

    public boolean isValid()
    {
        if ( !hasType() )
            return false;

        if ( !hasAmount() )
            return false;

        if ( !hasCustomerProfileId() )
            return false;

        if ( !hasPaymentProfileId() )
            return false;

        if ( hasTypeCaptureOnly() && !hasApprovalCode() )
            return false;

        return true;
    }

    //##################################################
    //# print xml
    //##################################################

    public String printXml()
    {
        KmXmlBuilder out = new KmXmlBuilder();
        printXmlOn(out);
        return out.toString();
    }

    public void printXmlOn(KmXmlBuilder out)
    {
        out.begin("transaction");
        out.begin(getType());

        out.value("amount", getAmount().format(2, false));

        if ( hasTax() )
            _tax.printXmlOn(out);

        if ( hasShipping() )
            _shipping.printXmlOn(out);

        if ( hasDuty() )
            _duty.printXmlOn(out);

        if ( hasLineItems() )
            for ( AuthnetTransactionLineItem li : _lineItems )
                li.printXmlOn(out);

        out.value("customerProfileId", getCustomerProfileId());
        out.value("customerPaymentProfileId", getPaymentProfileId());

        if ( hasCustomerAddressId() )
            out.value("customerAddressId", getCustomerAddressId());

        if ( hasOrder() )
            _order.printXmlOn(out);

        if ( hasTaxExempt() )
            out.value("taxExempt", getTaxExempt());

        if ( hasRecurringBilling() )
            out.value("recurringBilling", getRecurringBilling());

        if ( hasCardCcvCode() )
            out.value("cardCode", getCardCcvCode());

        if ( hasApprovalCode() )
            out.value("approvalCode", getApprovalCode());

        out.end();
        out.end();
    }

}
