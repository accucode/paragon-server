package com.app.ui.page.crud.holiday;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScDomainNotebook;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.layout.ScLayout;

import com.app.model.MyHoliday;
import com.app.model.meta.MyMetaHoliday;
import com.app.ui.page.crud.abstractBase.MyCrudViewCard;

public class MyHolidayViewCard
    extends MyCrudViewCard<MyHoliday>
{
    //##################################################
    //# constructor
    //##################################################

    public MyHolidayViewCard()
    {
        super(new MyHolidayBuilder());
    }

    public MyHolidayViewCard(MyHolidayBuilder e)
    {
        super(e);
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installBodyOn(ScDiv body)
    {
        detachBody();
        body.add(createNotebook());
    }

    private ScDomainNotebook<MyHoliday> createNotebook()
    {
        ScDomainNotebook<MyHoliday> e;
        e = new ScDomainNotebook<>();
        e.css().fill();
        e.setFinder(MyHoliday.Finder);
        e.add(createDetailTab());
        return e;
    }

    //==================================================
    //= install :: holiday tab
    //==================================================

    private ScControl createDetailTab()
    {
        ScGroup e;
        e = new ScGroup();
        e.setNotebookTab("Holiday", "Details");
        e.getBody().add(createDetailLayout());
        return e;
    }

    private ScControl createDetailLayout()
    {
        ScLayout e;
        e = new ScLayout();
        e.setTypeFieldset();
        e.css().fill().auto();
        e.add(createGeneralSection());
        return e;
    }

    private ScControl createGeneralSection()
    {
        MyMetaHoliday x = MyHoliday.Meta;

        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("General");
        e.addFieldText(x.Name);
        e.addFieldText(x.Day);
        return e;
    }
}
