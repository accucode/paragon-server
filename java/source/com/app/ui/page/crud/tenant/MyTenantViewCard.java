package com.app.ui.page.crud.tenant;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScDomainNotebook;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldText;
import com.kodemore.servlet.control.layout.ScLayout;

import com.app.model.MyTenant;
import com.app.model.meta.MyMetaTenant;
import com.app.ui.page.crud.abstractBase.MyCrudViewCard;
import com.app.ui.page.crud.user.MyUserListView;

public class MyTenantViewCard
    extends MyCrudViewCard<MyTenant>
{
    //##################################################
    //# constructor
    //##################################################

    public MyTenantViewCard()
    {
        super(new MyTenantBuilder());
    }

    public MyTenantViewCard(MyTenantBuilder e)
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

    private ScControl createNotebook()
    {
        ScDomainNotebook<MyTenant> e;
        e = new ScDomainNotebook<>();
        e.css().fill();
        e.setFinder(MyTenant.Finder);
        e.add(createDetailsTab());
        e.add(createUsersTab());
        return e;
    }

    //==================================================
    //= notebook :: details tab
    //==================================================

    private ScControl createDetailsTab()
    {
        ScLayout e;
        e = new ScLayout();
        e.setTypeFieldset();
        e.css().fill().auto();
        e.add(createGeneralSection());
        e.add(createBusinessHoursSection());
        e.add(createMemoSection());
        return e.inNotebookTab("Tenant", "Details");
    }

    private ScControl createGeneralSection()
    {
        MyMetaTenant x = MyTenant.Meta;

        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("General");
        e.addFieldText(x.Name);
        e.addFieldText(x.Hostname);
        e.addFieldText(x.ThemeName);
        return e;
    }

    private ScControl createBusinessHoursSection()
    {
        MyMetaTenant x = MyTenant.Meta;

        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("Business Hours");
        e.addFieldText(x.TimeZoneName);
        e.addSpace();
        e.addFieldText(x.BusinessDays, "Days");
        e.addFieldText(x.BusinessStartTime, "Start Time");
        e.addFieldText(x.BusinessEndTime, "End Time");
        return e;
    }

    private ScControl createMemoSection()
    {
        MyMetaTenant x = MyTenant.Meta;

        ScFieldText e;
        e = x.Memo.newFieldText();
        e.setEmptyTextNone();
        return e;
    }

    //==================================================
    //= notebook :: users
    //==================================================

    private ScControl createUsersTab()
    {
        MyUserListView e;
        e = new MyUserListView();
        e.setLabel("Users");
        e.css().fill();
        return e;
    }
}
