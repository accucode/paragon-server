package com.app.ui.page.manageUsers;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;
import com.kodemore.utility.Kmu;

import com.app.model.MyUser;
import com.app.model.meta.MyMetaUser;
import com.app.ui.control.MyAddDialog;

public class MyAddUserDialog
    extends MyAddDialog<MyUser>
{
    //##################################################
    //# install
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        setLabel("ADD User");
        setWidth(400);
        installFields();
    }

    private void installFields()
    {
        MyMetaUser x = MyUser.Meta;

        ScDiv body;
        body = getBody();
        body.css().pad();

        ScFieldLayout fields;
        fields = body.addFieldLayout();
        fields.addField(x.Name);
        fields.addField(x.Email);
        fields.addField(x.Phone);
    }

    //##################################################
    //# prepare
    //##################################################

    @Override
    protected void prepare()
    {
        // none
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected MyUser save()
    {
        validate();

        MyUser e;
        e = new MyUser();
        e.applyFrom(this);
        validateEmail(e);
        e.attachDao();
        return e;
    }

    private void validateEmail(MyUser e)
    {
        MyMetaUser x = MyUser.Meta;

        if ( !e.hasEmail() )
            return;

        String email = e.getEmail();

        boolean valid = Kmu.isValidEmailAddress(email);
        boolean exists = getAccess().getUserDao().emailExists(email);

        if ( !valid )
        {
            addErrorTo(x.Email, "Invalid email.");
            return;
        }

        if ( exists )
            addErrorTo(x.Email, "Duplicate email used by another user.");
    }

}
