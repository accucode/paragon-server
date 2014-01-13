package com.kodemore.authnet;

import com.kodemore.authnet.model.KmAuthnetRetryableError;
import com.kodemore.authnet.model.KmAuthnetTransaction;
import com.kodemore.authnet.model.KmAuthnetTransactionOrder;
import com.kodemore.authnet.request.KmAuthnetCreateTransactionRequest;
import com.kodemore.authnet.request.KmAuthnetCreateTransactionResponse;
import com.kodemore.types.KmMoney;

public class KmAuthnetPaymentUtility
{
    //##################################################
    //# variables (setup)
    //##################################################

    private String                           _apiLogin;
    private String                           _transactionKey;

    private int                              _profileId;
    private int                              _paymentProfileId;

    // optional
    private String                           _invoiceNumber;

    private KmMoney                          _amount;

    //##################################################
    //# variables (results)
    //##################################################

    private KmAuthnetCreateTransactionRequest  _request;
    private KmAuthnetCreateTransactionResponse _response;

    //##################################################
    //# accessing (setup)
    //##################################################

    public String getApiLogin()
    {
        return _apiLogin;
    }

    public void setApiLogin(String e)
    {
        _apiLogin = e;
    }

    public String getTransactionKey()
    {
        return _transactionKey;
    }

    public void setTransactionKey(String e)
    {
        _transactionKey = e;
    }

    public int getProfileId()
    {
        return _profileId;
    }

    public void setProfileId(int e)
    {
        _profileId = e;
    }

    public int getPaymentProfileId()
    {
        return _paymentProfileId;
    }

    public void setPaymentProfileId(int e)
    {
        _paymentProfileId = e;
    }

    public String getInvoiceNumber()
    {
        return _invoiceNumber;
    }

    public void setInvoiceNumber(String e)
    {
        _invoiceNumber = e;
    }

    public boolean hasInvoiceNumber()
    {
        return _invoiceNumber != null;
    }

    public KmMoney getAmount()
    {
        return _amount;
    }

    public void setAmount(KmMoney e)
    {
        _amount = e;
    }

    //##################################################
    //# accessing (results)
    //##################################################

    public KmAuthnetCreateTransactionRequest getRequest()
    {
        return _request;
    }

    public void setRequest(KmAuthnetCreateTransactionRequest e)
    {
        _request = e;
    }

    public KmAuthnetCreateTransactionResponse getResponse()
    {
        return _response;
    }

    //##################################################
    //# run
    //##################################################

    public void pay()
    {
        composeRequest();
        _response = _request.post();
    }

    private void composeRequest()
    {
        try
        {
            KmAuthnetTransaction txn;
            txn = new KmAuthnetTransaction();
            txn.setTypeAuthCapture();
            txn.setAmount(_amount);
            txn.setCustomerProfileId(_profileId);
            txn.setPaymentProfileId(_paymentProfileId);

            if ( hasInvoiceNumber() )
            {
                KmAuthnetTransactionOrder order;
                order = txn.addOrder();
                order.setInvoiceNumber(getInvoiceNumber());
            }

            _request = new KmAuthnetCreateTransactionRequest();
            _request.setAuthorization(_apiLogin, _transactionKey);
            _request.setTransaction(txn);
        }
        catch ( RuntimeException ex )
        {
            throw new KmAuthnetRetryableError(ex);
        }
    }

}
