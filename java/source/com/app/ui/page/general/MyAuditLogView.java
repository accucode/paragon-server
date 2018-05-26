package com.app.ui.page.general;

import com.kodemore.collection.KmList;
import com.kodemore.domain.KmUidDomainIF;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScLiteral;

import com.app.dao.MyAuditLogDao;
import com.app.model.MyAuditLog;
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
        css().auto();
        _literal = addLiteral();
    }

    //##################################################
    //# apply
    //##################################################

    @Override
    protected boolean applyFromModel_here(Object model)
    {
        KmUidDomainIF e = (KmUidDomainIF)model;
        String uid = e.getUid();
        KmHtmlBuilder html = formatAuditLog(uid);

        _literal.setValue(html);

        return super.applyFromModel_here(model);
    }

    //##################################################
    //# format
    //##################################################

    private KmHtmlBuilder formatAuditLog(String uid)
    {
        MyAuditLogDao dao = MyGlobals.getAccess().getAuditLogDao();
        KmList<MyAuditLog> v = dao.findDomainUid(uid);
        return MyAuditLogFormatter.format(v);
    }
}
