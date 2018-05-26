package com.app.ui.page.crud.tenant;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScDiv;

import com.app.criteria.MyTenantCriteria;
import com.app.model.MyTenant;
import com.app.model.core.MyNullDomain;
import com.app.ui.page.crud.abstractBase.MyCrudBuilder;
import com.app.ui.page.crud.abstractBase.MyCrudGeneralCriteriaSearchView;

public class MyTenantSearchView
    extends MyCrudGeneralCriteriaSearchView<MyNullDomain,MyTenant,MyTenantCriteria>
{
    //##################################################
    //# constructor
    //##################################################

    public MyTenantSearchView(MyCrudBuilder<MyNullDomain,MyTenant> e)
    {
        super(e);
    }

    //##################################################
    //# fields
    //##################################################

    @Override
    protected void installBasicFieldsOn(ScDiv root)
    {
        // none
    }

    @Override
    protected void installExtendedFieldsOn(ScDiv root)
    {
        // none
    }

    @Override
    protected void addExtendedMessagesTo(KmList<String> v)
    {
        // none
    }

    //##################################################
    //# criteria
    //##################################################

    @Override
    protected MyTenantCriteria createCriteria()
    {
        return getAccess().getTenantDao().createCriteria();
    }

    @Override
    protected void filter(MyTenantCriteria c)
    {
        // none
    }

    @Override
    protected void sort(MyTenantCriteria c)
    {
        c.sortOnName();
    }
}
