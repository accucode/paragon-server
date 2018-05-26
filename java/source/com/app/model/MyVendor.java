package com.app.model;

import com.kodemore.utility.Kmu;

import com.app.model.base.MyVendorBase;
import com.app.model.core.MyProjectDomainIF;
import com.app.model.support.MyPageDomainIF;
import com.app.model.transfer.MyTransferrableIF;
import com.app.model.transfer.detail.MyTransferVendorDetail;
import com.app.ui.page.crud.projectVendor.MyVendorListPage;

public class MyVendor
    extends MyVendorBase
    implements MyProjectDomainIF, MyPageDomainIF, MyTransferrableIF<MyVendor>
{
    //##################################################
    //# constructor
    //##################################################

    public MyVendor()
    {
        super();
    }

    //##################################################
    //# domain
    //##################################################

    @Override
    public MyTenant getTenant()
    {
        return getProject().getTenant();
    }

    //##################################################
    //# enabled
    //##################################################

    @Override
    public boolean isDomainEnabled()
    {
        return isEnabled();
    }

    @Override
    public String getEnabledStatus()
    {
        return Kmu.formatEnabled(getEnabled());
    }

    //##################################################
    //# transfer
    //##################################################

    @Override
    public MyTransferVendorDetail newTransferDetail()
    {
        return new MyTransferVendorDetail(this);
    }

    //##################################################
    //# page
    //##################################################

    @Override
    public void ajaxEnterPage()
    {
        MyVendorListPage.getInstance().ajaxEnterChild(this);
    }

    @Override
    public String formatEntryUrl()
    {
        return MyVendorListPage.getInstance().formatEntryUrlFor(this);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getAuditLogTitle()
    {
        return getName();
    }

    @Override
    public String getDomainTitle()
    {
        return getName();
    }

    @Override
    public String getDomainSubtitle()
    {
        return null;
    }

}
