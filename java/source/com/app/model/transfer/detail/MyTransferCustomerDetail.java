package com.app.model.transfer.detail;

import com.app.model.MyCustomer;

public class MyTransferCustomerDetail
    extends MyTransferAbstractDetail<MyCustomer>
{
    //##################################################
    //# constructor
    //##################################################

    public MyTransferCustomerDetail(MyCustomer source)
    {
        super(source);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyCustomer findTargetFor(MyCustomer from)
    {
        return findCustomerFor(from);
    }

    //##################################################
    //# transfer
    //##################################################

    @Override
    protected MyCustomer transferAdd(MyCustomer from)
    {
        MyCustomer to;
        to = new MyCustomer();
        to.setProject(getTargetProject());

        map(from, to);
        apply(from, to);
        return to;
    }

    @Override
    protected void transferUpdate(MyCustomer from, MyCustomer to)
    {
        apply(from, to);
    }

    //##################################################
    //# apply
    //##################################################

    private void apply(MyCustomer from, MyCustomer to)
    {
        to.applyEditableFieldsFrom(from);
        applyBasicTimestamps(from, to);
        to.daoAttach();

        postAttach(from, to);
    }

    //##################################################
    //# post attach
    //##################################################

    protected void postAttach(MyCustomer from, MyCustomer to)
    {
        flush();

        transferAll(from.getContacts());
        to.setApprovalContact(transfer(from.getApprovalContact()));
        to.setBillingContact(transfer(from.getBillingContact()));
    }
}
