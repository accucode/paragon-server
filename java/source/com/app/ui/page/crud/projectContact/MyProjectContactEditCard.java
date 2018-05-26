package com.app.ui.page.crud.projectContact;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.utility.Kmu;

import com.app.model.MyProjectContact;
import com.app.model.meta.MyMetaProjectContact;
import com.app.ui.page.crud.abstractBase.MyCrudEditCard;
import com.app.ui.page.crud.abstractBase.MyCrudLayout;

public class MyProjectContactEditCard
    extends MyCrudEditCard<MyProjectContact>
{
    //##################################################
    //# variables
    //##################################################

    private ScTextField _firstNameField;
    private ScTextField _lastNameField;
    private ScTextField _nicknameField;

    //##################################################
    //# constructor
    //##################################################

    public MyProjectContactEditCard()
    {
        super(new MyProjectContactBuilder());
    }

    public MyProjectContactEditCard(MyProjectContactBuilder e)
    {
        super(e);
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected MyCrudLayout getDetailLayout()
    {
        return MyCrudLayout.scroll;
    }

    @Override
    protected void installDetailsOn(ScDiv root)
    {
        MyMetaProjectContact x = MyProjectContact.Meta;

        ScFieldset set;
        set = root.addFieldset("General");

        ScFieldTable fields;
        fields = set.addFieldTable();
        fields.add(createFirstNameField());
        fields.add(createLastNameField());
        fields.add(createNickNameField());
        fields.addSpace();
        fields.addField(x.Phone);
        fields.addField(x.Email);
        fields.addField(x.Title);
    }

    private ScTextField createFirstNameField()
    {
        MyMetaProjectContact x = MyProjectContact.Meta;

        ScTextField e;
        e = x.FirstName.newField();
        e.setWidthFull();
        _firstNameField = e;
        return e;
    }

    private ScTextField createLastNameField()
    {
        MyMetaProjectContact x = MyProjectContact.Meta;

        ScTextField e;
        e = x.LastName.newField();
        e.setWidthFull();
        _lastNameField = e;
        return e;
    }

    private ScTextField createNickNameField()
    {
        MyMetaProjectContact x = MyProjectContact.Meta;

        ScTextField e;
        e = x.Nickname.newField();
        e.setWidthFull();
        _nicknameField = e;
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
        if ( _firstNameField.hasErrors() )
            return;

        if ( _lastNameField.hasErrors() )
            return;

        if ( _nicknameField.hasErrors() )
            return;

        String first = _firstNameField.getValue();
        String last = _lastNameField.getValue();
        String nick = _nicknameField.getValue();

        boolean none = Kmu.allNulls(first, last, nick);
        if ( none )
            _firstNameField.addError("You must specify a name (first, last, or nickname).");
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected void saveDomainChild(MyProjectContact e)
    {
        e.applyFrom(this);
    }

}
