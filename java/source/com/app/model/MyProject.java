package com.app.model;

import com.kodemore.time.KmTime;
import com.kodemore.types.KmDayFrequency;

import com.app.criteria.MyProjectCriteria;
import com.app.model.base.MyProjectBase;
import com.app.model.core.MyProjectDomainIF;

public class MyProject
    extends MyProjectBase
    implements MyProjectDomainIF
{
    //##################################################
    //# constants
    //##################################################

    public static final KmDayFrequency DEFAULT_BUSINESS_DAYS       = KmDayFrequency.MONDAY_THROUGH_FRIDAY;
    public static final KmTime         DEFAULT_BUSINESS_START_TIME = KmTime.fromHour(9);
    public static final KmTime         DEFAULT_BUSINESS_END_TIME   = KmTime.fromHour(17);

    //##################################################
    //# constructor
    //##################################################

    public MyProject()
    {
        super();
    }

    //##################################################
    //# convenience
    //##################################################

    @Override
    public final MyProject getProject()
    {
        return this;
    }

    //##################################################
    //# duplicate checks
    //##################################################

    public boolean hasDifferentProjectWithSameName(String name)
    {
        MyProjectCriteria c;
        c = getAccess().getProjectDao().createCriteria();
        c.whereTenantIs(getTenant());
        c.whereName().is(name);
        c.whereUid().isNot(getUid());
        return c.exists();
    }

    //##################################################
    //# members
    //##################################################

    //##################################################
    //# display
    //##################################################

    @Override
    public String getDisplayString()
    {
        return getName();
    }

}
