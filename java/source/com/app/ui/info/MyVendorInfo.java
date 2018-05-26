package com.app.ui.info;

import com.app.model.MyVendor;
import com.app.ui.page.crud.projectVendor.MyVendorListPage;

public class MyVendorInfo
    extends MyDomainInfo<MyVendor>
{
    //##################################################
    //# text
    //##################################################

    @Override
    protected String getLabelFor(MyVendor e)
    {
        return "Project Vendor";
    }

    @Override
    protected String getNameFor(MyVendor e)
    {
        return e.getName();
    }

    @Override
    protected String getHelpFor(MyVendor e)
    {
        return null;
    }

    //##################################################
    //# find
    //##################################################

    @Override
    protected MyVendor findTargetFor(String uid)
    {
        return getAccess().findVendorUid(uid);
    }

    //##################################################
    //# open
    //##################################################

    @Override
    protected void openLinkFor(MyVendor e)
    {
        MyVendorListPage.getInstance().ajaxEnterChild(e);
    }

    @Override
    protected String formatPopoutUrlFor(MyVendor e)
    {
        return MyVendorListPage.getInstance().formatEntryUrlFor(e);
    }
}
