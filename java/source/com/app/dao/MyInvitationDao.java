package com.app.dao;

import com.kodemore.collection.KmList;

import com.app.criteria.MyInvitationCriteria;
import com.app.dao.base.MyInvitationDaoBase;
import com.app.model.MyInvitation;
import com.app.model.MyProject;

public class MyInvitationDao
    extends MyInvitationDaoBase
{
    public KmList<MyInvitation> findJoinInvitationsFor(MyProject e)
    {
        MyInvitationCriteria c;
        c = createCriteria();
        c.whereProjectIs(e);
        c.whereTypeIsJoinAccount();
        return c.findAll();
    }
}
