package com.app.ui.page.crud.holiday;

import com.kodemore.meta.KmMetaModel;

import com.app.finder.MyHolidayFinder;
import com.app.model.MyHoliday;
import com.app.model.MyProject;
import com.app.ui.page.crud.abstractBase.MyCrudAddCard;
import com.app.ui.page.crud.abstractBase.MyCrudBuilder;
import com.app.ui.page.crud.abstractBase.MyCrudEditCard;
import com.app.ui.page.crud.abstractBase.MyCrudFrame;
import com.app.ui.page.crud.abstractBase.MyCrudListView;
import com.app.ui.page.crud.abstractBase.MyCrudSearchViewIF;
import com.app.ui.page.crud.abstractBase.MyCrudViewCard;

public class MyHolidayBuilder
    extends MyCrudBuilder<MyProject,MyHoliday>
{
    //##################################################
    //# find
    //##################################################

    @Override
    public MyProject findParent(String uid)
    {
        return getAccess().findProjectUid(uid);
    }

    //##################################################
    //# child
    //##################################################

    @Override
    public KmMetaModel getChildMeta()
    {
        return MyHoliday.Meta;
    }

    @Override
    public MyHolidayFinder getChildFinder()
    {
        return MyHoliday.Finder;
    }

    //##################################################
    //# tree
    //##################################################

    @Override
    public MyProject getParentFor(MyHoliday holiday)
    {
        return holiday.getProject();
    }

    //##################################################
    //# ui
    //##################################################

    @Override
    public MyCrudListView<MyProject,MyHoliday> newListView()
    {
        return new MyHolidayListView(this);
    }

    @Override
    public MyCrudFrame<MyProject,MyHoliday> newFrame()
    {
        return new MyHolidayFrame(this);
    }

    @Override
    public MyCrudViewCard<MyHoliday> newViewCard()
    {
        return new MyHolidayViewCard(this);
    }

    @Override
    public MyCrudEditCard<MyHoliday> newEditCard()
    {
        return new MyHolidayEditCard(this);
    }

    @Override
    public MyCrudAddCard<MyProject,MyHoliday> newAddCard()
    {
        return new MyHolidayAddCard(this);
    }

    @Override
    protected MyCrudSearchViewIF<MyProject,MyHoliday> newSearchView()
    {
        return new MyHolidaySearchView(this);
    }
}
