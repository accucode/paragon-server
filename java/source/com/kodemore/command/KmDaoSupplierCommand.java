package com.kodemore.command;

import java.util.function.Supplier;

public class KmDaoSupplierCommand<T>
    extends KmDaoCommand
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The supplier to be evaluated within a database transaction.
     */
    private Supplier<T> _supplier;

    /**
     * The result returned by the supplier.
     * This is only valid after the transaction completes successfully.
     */
    private T _result;

    //##################################################
    //# constructor
    //##################################################

    public KmDaoSupplierCommand()
    {
        // none
    }

    public KmDaoSupplierCommand(Supplier<T> e)
    {
        _supplier = e;
    }

    //##################################################
    //# accessing
    //##################################################

    public Supplier<T> getSupplier()
    {
        return _supplier;
    }

    public void setSupplier(Supplier<T> e)
    {
        _supplier = e;
    }

    public T getResult()
    {
        return _result;
    }

    //##################################################
    //# handle
    //##################################################

    @Override
    protected void handle()
    {
        _result = _supplier == null
            ? null
            : _supplier.get();
    }
}
