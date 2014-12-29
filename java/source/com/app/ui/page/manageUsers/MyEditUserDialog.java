package com.app.ui.page.manageUsers;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;
import com.kodemore.servlet.field.ScHiddenField;
import com.kodemore.utility.Kmu;

import com.app.model.MyUser;
import com.app.model.meta.MyMetaUser;
import com.app.ui.control.MyEditDialog;

public class MyEditUserDialog
    extends MyEditDialog<MyUser>
{
    //##################################################
    //# variables
    //##################################################

    private ScHiddenField<String> _uidField;

    //##################################################
    //# install
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        setLabel("EDIT User");
        setWidth(400);
        installFields();
    }

    private void installFields()
    {
        MyMetaUser x = MyUser.Meta;

        ScDiv body;
        body = getBody();
        body.css().pad();

        _uidField = body.addHiddenField(x.Uid);

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
    protected void prepare(MyUser e)
    {
        applyFromModel(e);
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected MyUser save()
    {
        validate();

        String uid;
        uid = _uidField.getValue();

        MyUser newUser;
        newUser = new MyUser();
        newUser.applyFrom(this);

        MyUser oldUser;
        oldUser = getAccess().findUserUid(uid);

        validateEmail(oldUser, newUser);

        oldUser.applyFrom(this);
        oldUser.validate();

        flushDao();

        return oldUser;
    }

    private void validateEmail(MyUser oldUser, MyUser newUser)
    {
        MyMetaUser x = MyUser.Meta;

        if ( !newUser.hasEmail() )
            return;

        String newEmail = newUser.getEmail();
        String oldEmail = oldUser.getEmail();
        boolean same = Kmu.isEqual(newEmail, oldEmail);
        if ( same )
            return;

        boolean valid = Kmu.isValidEmailAddress(newEmail);
        if ( !valid )
        {
            addErrorTo(x.Email, "Invalid email.");
            return;
        }

        boolean exists = getAccess().getUserDao().emailExists(newEmail);
        if ( exists )
            addErrorTo(x.Email, "Duplicate email used by another user.");
    }

}
