package com.app.ui.page.crud.member;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScDomainNotebook;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.layout.ScLayout;

import com.app.model.MyMember;
import com.app.model.meta.MyMetaMember;
import com.app.ui.page.crud.abstractBase.MyCrudViewCard;

public class MyMemberViewCard
    extends MyCrudViewCard<MyMember>
{
    //##################################################
    //# constructor
    //##################################################

    public MyMemberViewCard()
    {
        super(new MyMemberBuilder());
    }

    public MyMemberViewCard(MyMemberBuilder e)
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
        ScDomainNotebook<MyMember> e;
        e = new ScDomainNotebook<>();
        e.setFinder(MyMember.Finder);
        e.css().fill();
        e.add(createDetailTab());
        return e;
    }

    private ScControl createDetailTab()
    {
        ScGroup e;
        e = new ScGroup();
        e.setNotebookTab("General", "Details");
        e.getBody().add(createDetailLayout());
        return e;
    }

    private ScControl createDetailLayout()
    {
        ScLayout e;
        e = new ScLayout();
        e.setTypeFieldset();
        e.css().fill().auto();
        e.add(createUserSection());
        return e;
    }

    private ScControl createUserSection()
    {
        MyMetaMember x = MyMember.Meta;

        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("User");
        e.addFieldText(x.UserFullName);
        e.addFieldText(x.UserEmail);
        e.add(createEnabledRow());
        return e;
    }

    private ScControl createEnabledRow()
    {
        MyMetaMember x = MyMember.Meta;

        ScDiv e;
        e = new ScDiv();
        e.css().flexRow().rowSpacer5();
        e.setLabel("Enabled");
        e.addFieldText(x.EnabledStatus);
        e.addLink("toggle", newCheckedAction(this::handleToggleEnabled));
        return e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRenderDetails(MyMember child)
    {
        super.preRenderDetails(child);
    }

    //##################################################
    //# handle
    //##################################################

    private void handleToggleEnabled()
    {
        MyMember e;
        e = getDomainChild();
        e.toggleEnabled();
        e.validateAndCheck();

        ajaxReplace();
        fireChildChanged();
    }

}
