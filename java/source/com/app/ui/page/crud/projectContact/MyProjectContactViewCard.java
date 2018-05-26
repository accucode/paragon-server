package com.app.ui.page.crud.projectContact;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.layout.ScLayout;

import com.app.model.MyProjectContact;
import com.app.model.meta.MyMetaProjectContact;
import com.app.ui.page.crud.abstractBase.MyCrudViewCard;

public class MyProjectContactViewCard
    extends MyCrudViewCard<MyProjectContact>
{
    //##################################################
    //# constructor
    //##################################################

    public MyProjectContactViewCard()
    {
        super(new MyProjectContactBuilder());
    }

    public MyProjectContactViewCard(MyProjectContactBuilder e)
    {
        super(e);
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installBodyOn(ScDiv body)
    {
        ScLayout e;
        e = body.addLayout();
        e.setTypeFieldset();
        e.css().fill().auto();
        e.add(createGeneralSection());
    }

    private ScFieldTable createGeneralSection()
    {
        MyMetaProjectContact x = MyProjectContact.Meta;

        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("General");
        e.addFieldText(x.FullName);
        e.addFieldText(x.Phone);
        e.addFieldText(x.Email);
        e.addFieldText(x.Title);
        return e;
    }

}
