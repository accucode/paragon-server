package com.app.dao;

import com.kodemore.collection.KmList;

import com.app.criteria.MyInvitationCriteria;
import com.app.dao.base.MyInvitationDaoBase;
import com.app.model.MyAccount;
import com.app.model.MyInvitation;

public class MyInvitationDao
    extends MyInvitationDaoBase
{
    public KmList<MyInvitation> findJoinInvitationsFor(MyAccount e)
    {
        MyInvitationCriteria c;
        c = createCriteria();
        c.whereAccountIs(e);
        c.whereTypeIsJoinAccount();
        return c.findAll();
    }
}
