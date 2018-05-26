package com.app.ui.page.crud.projectContact;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.layout.ScLayout;
import com.kodemore.servlet.field.ScTextField;

import com.app.model.MyProject;
import com.app.model.MyProjectContact;
import com.app.model.meta.MyMetaProjectContact;
import com.app.ui.page.crud.abstractBase.MyCrudAddCard;

public class MyProjectContactAddCard
    extends MyCrudAddCard<MyProject,MyProjectContact>
{
    //##################################################
    //# variables
    //##################################################

    private ScTextField _firstNameField;

    //##################################################
    //# constructor
    //##################################################

    public MyProjectContactAddCard()
    {
        super(new MyProjectContactBuilder());
    }

    public MyProjectContactAddCard(MyProjectContactBuilder e)
    {
        super(e);
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installBody(ScDiv body)
    {
        body.add(createLayout());
    }

    private ScControl createLayout()
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
        MyMetaProjectContact x = MyProjectContact.Meta;

        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("General");
        e.add(createNameField());
        e.addField(x.LastName);
        e.addField(x.Nickname);
        e.addSpace();
        e.addField(x.Title);
        e.addField(x.Phone);
        e.addField(x.Email);
        return e;
    }

    private ScControl createNameField()
    {
        MyMetaProjectContact x = MyProjectContact.Meta;

        ScTextField e;
        e = x.FirstName.newField();
        _firstNameField = e;
        return e;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        super.validate();
        validateName();
    }

    private void validateName()
    {
        MyProjectContact e;
        e = new MyProjectContact();
        e.applyFrom(this);

        if ( !e.hasName() )
            _firstNameField.addError("You must specify a name (first, last, or nickname).");
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected MyProjectContact saveNewChildOn(MyProject parent)
    {
        MyProjectContact e;
        e = parent.addContact();
        e.applyFrom(this);
        e.daoAttach();
        return e;
    }

}
