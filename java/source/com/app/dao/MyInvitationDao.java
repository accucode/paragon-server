package com.app.dao;

import com.app.criteria.MyInvitationCriteria;
import com.app.dao.base.MyInvitationDaoBase;
import com.app.model.MyInvitation;

public class MyInvitationDao
    extends MyInvitationDaoBase
{
    public MyInvitation findToken(String s)
    {
        MyInvitationCriteria c;
        c = createCriteria();
        c.whereToken().is(s);
        return c.findFirst();
    }
}
