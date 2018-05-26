package com.app.ui.selector;

import com.kodemore.collection.KmList;

import com.app.model.MyCustomer;
import com.app.model.MyProject;
import com.app.ui.selector.core.MyAbstractProjectSelector;

public class MyCustomerSelector
    extends MyAbstractProjectSelector<MyCustomer>
{
    //##################################################
    //# constructor
    //##################################################

    public MyCustomerSelector()
    {
        setLabel("Customer");
    }

    //##################################################
    //# security
    //##################################################

    @Override
    protected boolean allowsAddDefault()
    {
        return getProxy().allowsManageCustomers();
    }

    //##################################################
    //# find
    //##################################################

    @Override
    protected MyCustomer findDomainChild(String uid)
    {
        return getAccess().findCustomerUid(uid);
    }

    @Override
    protected KmList<MyCustomer> findAllDomainChildrenFor(MyProject project)
    {
        return project.getCustomersByName();
    }

    //##################################################
    //# dialog
    //##################################################

    @Override
    protected MyCustomerSelectorDialog getDialog()
    {
        return MyCustomerSelectorDialog.getInstance();
    }

}
