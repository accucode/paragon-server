package com.app.ui.page.general;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScLiteral;

import com.app.dao.MyAuditLogDao;
import com.app.model.MyAuditLog;
import com.app.model.core.MyUidDomainIF;
import com.app.model.support.MyAuditLogFormatter;
import com.app.utility.MyGlobals;

/**
 * I display the audit log for a single domain object.
 * I am intended to provide a generic view that can be used throughout the application.
 */
public class MyAuditLogView
    extends ScDiv
{
    //##################################################
    //# variables
    //##################################################

    private ScLiteral _literal;

    //##################################################
    //# constructor
    //##################################################

    public MyAuditLogView()
    {
        css().noWrap().auto();
        _literal = addLiteral();
    }

    //##################################################
    //# apply
    //##################################################

    @Override
    protected boolean applyFromModel_here(Object model, boolean skipFields)
    {
        MyUidDomainIF e = (MyUidDomainIF)model;
        String uid = e.getUid();
        String msg = formatAuditLog(uid);
        _literal.setValue(msg);

        return super.applyFromModel_here(model, skipFields);
    }

    //##################################################
    //# format
    //##################################################

    private String formatAuditLog(String uid)
    {
        MyAuditLogDao dao = MyGlobals.getAccess().getAuditLogDao();
        KmList<MyAuditLog> v = dao.findDomainUid(uid);

        return MyAuditLogFormatter.format(v);
    }
}
