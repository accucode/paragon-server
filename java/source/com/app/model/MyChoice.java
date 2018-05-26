package com.app.model;

import com.kodemore.utility.Kmu;

import com.app.model.base.MyChoiceBase;
import com.app.model.core.MyProjectDomainIF;
import com.app.model.transfer.MyTransferrableIF;
import com.app.model.transfer.detail.MyTransferAbstractDetail;
import com.app.model.transfer.detail.MyTransferChoiceDetail;

public class MyChoice
    extends MyChoiceBase
    implements MyProjectDomainIF, MyTransferrableIF<MyChoice>
{
    //##################################################
    //# constructor
    //##################################################

    public MyChoice()
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
    public MyTransferAbstractDetail<MyChoice> newTransferDetail()
    {
        return new MyTransferChoiceDetail(this);
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
