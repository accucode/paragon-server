package com.app.ui.page.crud.holiday;

import com.app.model.MyHoliday;
import com.app.model.MyProject;
import com.app.ui.page.crud.abstractBase.MyCrudFrame;

public class MyHolidayFrame
    extends MyCrudFrame<MyProject,MyHoliday>
{
    //##################################################
    //# constructor
    //##################################################

    public MyHolidayFrame()
    {
        this(new MyHolidayBuilder());
    }

    public MyHolidayFrame(MyHolidayBuilder e)
    {
        super(e);
    }
}
