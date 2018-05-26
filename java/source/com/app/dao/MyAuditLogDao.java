package com.app.dao;

import com.kodemore.collection.KmList;

import com.app.criteria.MyAuditLogCriteria;
import com.app.dao.base.MyAuditLogDaoBase;
import com.app.model.MyAuditLog;

public class MyAuditLogDao
    extends MyAuditLogDaoBase
{
    //##################################################
    //# find
    //##################################################

    public KmList<MyAuditLog> findDomainUid(String uid)
    {
        MyAuditLogCriteria c;
        c = createCriteria();
        c.whereDomainUid().is(uid);
        c.sortOnUidDescending();
        return c.findAll();
    }

    //##################################################
    //# domain types
    //##################################################

    public KmList<String> getDomainTypes()
    {
        MyAuditLogCriteria c;
        c = createCriteria();
        c.selectDistinctDomainType();
        return c.findStrings();
    }
}
