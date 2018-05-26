package com.app.model;

import com.app.model.base.MyHolidayBase;
import com.app.model.core.MyProjectDomainIF;
import com.app.model.support.MyPageDomainIF;
import com.app.ui.page.crud.holiday.MyHolidayListPage;

public class MyHoliday
    extends MyHolidayBase
    implements MyProjectDomainIF, MyPageDomainIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyHoliday()
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
    //# page
    //##################################################

    @Override
    public void ajaxEnterPage()
    {
        MyHolidayListPage.getInstance().ajaxEnterChild(this);
    }

    @Override
    public String formatEntryUrl()
    {
        return MyHolidayListPage.getInstance().formatEntryUrlFor(this);
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
        return getFormatter().formatDate(getDay());
    }

}
