package com.app.ui.page.crud.priority;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScDomainNotebook;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.layout.ScLayout;

import com.app.model.MyPriority;
import com.app.model.meta.MyMetaPriority;
import com.app.ui.page.crud.abstractBase.MyCrudViewCard;

public class MyPriorityViewCard
    extends MyCrudViewCard<MyPriority>
{
    //##################################################
    //# constructor
    //##################################################

    public MyPriorityViewCard()
    {
        super(new MyPriorityBuilder());
    }

    public MyPriorityViewCard(MyPriorityBuilder e)
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

    private ScDomainNotebook<MyPriority> createNotebook()
    {
        ScDomainNotebook<MyPriority> e;
        e = new ScDomainNotebook<>();
        e.css().fill();
        e.setFinder(MyPriority.Finder);
        e.add(createDetailTab());
        return e;
    }

    //##################################################
    //# tabs
    //##################################################

    private ScControl createDetailTab()
    {
        ScGroup e;
        e = new ScGroup();
        e.setNotebookTab("Priority", "Details");
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
        MyMetaPriority x = MyPriority.Meta;

        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("General");
        e.addFieldText(x.Name);
        e.addFieldText(x.SequenceName, "Sequence");
        return e;
    }
}
