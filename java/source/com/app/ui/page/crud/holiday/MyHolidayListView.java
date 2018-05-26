package com.app.ui.page.crud.holiday;

import com.app.model.MyHoliday;
import com.app.model.MyProject;
import com.app.ui.page.crud.abstractBase.MyCrudListView;

public final class MyHolidayListView
    extends MyCrudListView<MyProject,MyHoliday>
{
    //##################################################
    //# constructor
    //##################################################

    public MyHolidayListView()
    {
        this(new MyHolidayBuilder());
    }

    public MyHolidayListView(MyHolidayBuilder e)
    {
        super(e);
    }
}
