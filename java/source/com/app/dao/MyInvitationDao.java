package com.app.dao;

import com.app.criteria.MyInvitationCriteria;
import com.app.dao.base.MyInvitationDaoBase;
import com.app.model.MyInvitation;

public class MyInvitationDao
    extends MyInvitationDaoBase
{
    public MyInvitation findAccessKey(String key)
    {
        MyInvitationCriteria c;
        c = createCriteria();
        c.whereAccessKey().is(key);
        return c.findFirst();
    }
}
