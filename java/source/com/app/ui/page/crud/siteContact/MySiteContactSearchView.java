package com.app.ui.page.crud.siteContact;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScDiv;

import com.app.criteria.MySiteContactCriteria;
import com.app.model.MySite;
import com.app.model.MySiteContact;
import com.app.ui.page.crud.abstractBase.MyCrudBuilder;
import com.app.ui.page.crud.abstractBase.MyCrudGeneralCriteriaSearchView;

public class MySiteContactSearchView
    extends MyCrudGeneralCriteriaSearchView<MySite,MySiteContact,MySiteContactCriteria>
{
    //##################################################
    //# constructor
    //##################################################

    public MySiteContactSearchView(MyCrudBuilder<MySite,MySiteContact> e)
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
    protected MySiteContactCriteria createCriteria()
    {
        return getAccess().getSiteContactDao().createCriteria();
    }

    @Override
    protected void filter(MySiteContactCriteria c)
    {
        MySite site = getDomainParent();
        c.whereSiteIs(site);
    }

    @Override
    protected void sort(MySiteContactCriteria c)
    {
        c.sortOnFullName();
    }
}
