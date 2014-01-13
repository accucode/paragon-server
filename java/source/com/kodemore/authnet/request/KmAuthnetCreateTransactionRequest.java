package com.kodemore.authnet.request;

import com.kodemore.authnet.model.KmAuthnetTransaction;
import com.kodemore.xml.utility.KmXmlBuilder;

public class KmAuthnetCreateTransactionRequest
    extends KmAuthnetAbstractRequest
{
    //##################################################
    //# variables
    //##################################################

    private KmAuthnetTransaction _transaction;

    //##################################################
    //# transaction
    //##################################################

    public KmAuthnetTransaction getTransaction()
    {
        return _transaction;
    }

    public void setTransaction(KmAuthnetTransaction e)
    {
        _transaction = e;
    }

    public boolean hasTransaction()
    {
        return _transaction != null;
    }

    public KmAuthnetTransaction setCreditCardTransaction()
    {
        KmAuthnetTransaction e;
        e = new KmAuthnetTransaction();
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
    public KmAuthnetCreateTransactionResponse post()
    {
        return post(new KmAuthnetCreateTransactionResponse());
    }

}
