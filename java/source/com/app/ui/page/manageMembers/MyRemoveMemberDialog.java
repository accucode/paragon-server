package com.app.ui.page.manageMembers;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.field.ScHiddenField;

import com.app.model.MyMember;
import com.app.model.meta.MyMetaMember;
import com.app.ui.control.MyRemoveDialog;

public class MyRemoveMemberDialog
    extends MyRemoveDialog<MyMember>
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

        setLabel("REMOVE Member");
        setFlavorWarning();
        setWidth(400);
        installFields();
    }

    private void installFields()
    {
        MyMetaMember x = MyMember.Meta;

        ScDiv body;
        body = getBody();
        body.css().pad();
        body.addText(""
            + "This will remove the user's access to this project, "
            + "but does NOT remove the user from the system. "
            + "The user will still be allowed to log in and may have "
            + "access to other projects. Also, if the user has administrative "
            + "access, this must be removed separately.");

        _uidField = body.addHiddenField(x.Uid);
    }

    //##################################################
    //# prepare
    //##################################################

    @Override
    protected void prepare(MyMember e)
    {
        applyFromModel(e);
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected MyMember remove()
    {
        String uid = _uidField.getValue();
        MyMember e = getAccess().findMemberUid(uid);

        if ( e == null )
            return null;

        e.getProject().removeMember(e);
        flushDao();

        return e;
    }
}
