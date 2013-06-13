package com.kodemore.authnet;

import com.kodemore.authnet.model.AuthnetRetryableError;
import com.kodemore.authnet.model.AuthnetTransaction;
import com.kodemore.authnet.model.AuthnetTransactionOrder;
import com.kodemore.authnet.request.AuthnetCreateTransactionRequest;
import com.kodemore.authnet.request.AuthnetCreateTransactionResponse;
import com.kodemore.types.KmMoney;

public class AuthnetPaymentUtility
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

    private AuthnetCreateTransactionRequest  _request;
    private AuthnetCreateTransactionResponse _response;

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

    public AuthnetCreateTransactionRequest getRequest()
    {
        return _request;
    }

    public void setRequest(AuthnetCreateTransactionRequest e)
    {
        _request = e;
    }

    public AuthnetCreateTransactionResponse getResponse()
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
            AuthnetTransaction txn;
            txn = new AuthnetTransaction();
            txn.setTypeAuthCapture();
            txn.setAmount(_amount);
            txn.setCustomerProfileId(_profileId);
            txn.setPaymentProfileId(_paymentProfileId);

            if ( hasInvoiceNumber() )
            {
                AuthnetTransactionOrder order;
                order = txn.addOrder();
                order.setInvoiceNumber(getInvoiceNumber());
            }

            _request = new AuthnetCreateTransactionRequest();
            _request.setAuthorization(_apiLogin, _transactionKey);
            _request.setTransaction(txn);
        }
        catch ( RuntimeException ex )
        {
            throw new AuthnetRetryableError(ex);
        }
    }

}
