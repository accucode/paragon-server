package com.app.model;

import com.app.model.base.MyInvitationBase;

public class MyInvitation
    extends MyInvitationBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyInvitation()
    {
        super();

        setStatusNew();
    }

    //##################################################
    //# role
    //##################################################

    public MyAccountUserRole getRole()
    {
        return MyAccountUserRole.findCode(getRoleCode());
    }

    public void setRole(MyAccountUserRole e)
    {
        setRoleCode(getCodeFor(e));
    }
}
