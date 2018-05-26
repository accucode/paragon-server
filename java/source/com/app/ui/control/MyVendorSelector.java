package com.app.ui.control;

import com.kodemore.collection.KmList;

import com.app.model.MyProject;
import com.app.model.MyVendor;
import com.app.ui.selector.MyVendorSelectorDialog;
import com.app.ui.selector.core.MyAbstractProjectSelector;

public class MyVendorSelector
    extends MyAbstractProjectSelector<MyVendor>
{
    //##################################################
    //# constructor
    //##################################################

    public MyVendorSelector()
    {
        setLabel("Vendor");
    }

    //##################################################
    //# security
    //##################################################

    @Override
    protected boolean allowsAddDefault()
    {
        return getProxy().allowsManageVendors();
    }

    //##################################################
    //# find
    //##################################################

    @Override
    protected MyVendor findDomainChild(String uid)
    {
        return getAccess().findVendorUid(uid);
    }

    @Override
    protected KmList<MyVendor> findAllDomainChildrenFor(MyProject project)
    {
        return project.getVendorsByName();
    }

    //##################################################
    //# dialog
    //##################################################

    @Override
    protected MyVendorSelectorDialog getDialog()
    {
        return MyVendorSelectorDialog.getInstance();
    }
}
