package com.app.dao;

import com.app.criteria.MyHolidayCriteria;
import com.app.dao.base.MyHolidayDaoBase;
import com.app.model.MyProject;
import com.app.model.MyHoliday;

public class MyHolidayDao
    extends MyHolidayDaoBase
{
    //##################################################
    //# duplicate name
    //##################################################

    public boolean isDuplicateName(MyProject project, String name)
    {
        MyHolidayCriteria c;
        c = createCriteria();
        c.whereProjectIs(project);
        c.whereName().is(name);
        return c.exists();
    }

    public boolean isDuplicateName(MyHoliday holiday, String name)
    {
        MyHolidayCriteria c;
        c = createCriteria();
        c.whereProjectIs(holiday.getProject());
        c.whereName().is(name);
        c.whereUidIsNot(holiday);
        return c.exists();
    }

}
