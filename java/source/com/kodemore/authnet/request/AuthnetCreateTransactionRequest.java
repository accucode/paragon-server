package com.kodemore.authnet.request;

import com.kodemore.authnet.model.AuthnetTransaction;
import com.kodemore.xml.utility.KmXmlBuilder;

public class AuthnetCreateTransactionRequest
    extends AuthnetAbstractRequest
{
    //##################################################
    //# variables
    //##################################################

    private AuthnetTransaction _transaction;

    //##################################################
    //# transaction
    //##################################################

    public AuthnetTransaction getTransaction()
    {
        return _transaction;
    }

    public void setTransaction(AuthnetTransaction e)
    {
        _transaction = e;
    }

    public boolean hasTransaction()
    {
        return _transaction != null;
    }

    public AuthnetTransaction setCreditCardTransaction()
    {
        AuthnetTransaction e;
        e = new AuthnetTransaction();
        e.setTypeAuthCapture();

        setTransaction(e);
        return e;
    }

    //##################################################
    //# validation
    //##################################################

    @Override
    public boolean isValid()
    {
        if ( !super.isValid() )
            return false;

        if ( !hasTransaction() )
            return false;

        return _transaction.isValid();
    }

    //##################################################
    //# xml
    //##################################################

    @Override
    protected String getXmlTag()
    {
        return "createCustomerProfileTransactionRequest";
    }

    @Override
    protected void printXmlChildrenOn(KmXmlBuilder out)
    {
        _transaction.printXmlOn(out);
    }

    //##################################################
    //# post
    //##################################################

    @Override
    public AuthnetCreateTransactionResponse post()
    {
        return post(new AuthnetCreateTransactionResponse());
    }

}
