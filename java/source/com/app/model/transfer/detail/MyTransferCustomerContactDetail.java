package com.app.model.transfer.detail;

import com.app.model.MyCustomer;
import com.app.model.MyCustomerContact;

public class MyTransferCustomerContactDetail
    extends MyTransferAbstractDetail<MyCustomerContact>
{
    //##################################################
    //# constructor
    //##################################################

    public MyTransferCustomerContactDetail(MyCustomerContact source)
    {
        super(source);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyCustomerContact findTargetFor(MyCustomerContact from)
    {
        return findCustomerContactFor(from);
    }

    //##################################################
    //# transfer
    //##################################################

    @Override
    protected MyCustomerContact transferAdd(MyCustomerContact from)
    {
        MyCustomer fromCustomer = from.getCustomer();
        MyCustomer toCustomer = findCustomerFor(fromCustomer);

        if ( toCustomer == null )
            throw newError(
                "Cannot transfer contact (%s), you must first transfer customer (%s).",
                from.getFullName(),
                fromCustomer.getName());

        MyCustomerContact to;
        to = new MyCustomerContact();
        to.setCustomer(toCustomer);

        map(from, to);
        apply(from, to);
        return to;
    }

    @Override
    protected void transferUpdate(MyCustomerContact from, MyCustomerContact to)
    {
        apply(from, to);
    }

    //##################################################
    //# apply
    //##################################################

    private void apply(MyCustomerContact from, MyCustomerContact to)
    {
        to.applyEditableFieldsFrom(from);
        applyBasicTimestamps(from, to);
        to.daoAttach();
    }

}
