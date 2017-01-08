package com.app.model;

import com.kodemore.utility.Kmu;

import com.app.model.base.MyAuditLogBundleVoBase;
import com.app.model.base.MyAuditLogBundleVoType;

public class MyAuditLogBundleVo
    extends MyAuditLogBundleVoBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyAuditLogBundleVo()
    {
        super();
    }

    @Override
    public String getDisplayString()
    {
        return Kmu.format(
            "%s, %s, %s, %s",
            getUserName(),
            getTypeName(),
            getDomainType(),
            getDomainName());
    }

    @Override
    public String formatPrimaryKey()
    {
        return null;
    }

    @Override
    public String getDisplayUserName()
    {
        if ( hasUser() )
            return getUser().getFullName();

        return "System";
    }

    @Override
    public String getDisplaySummary()
    {
        MyAuditLogBundleVoType type = getType();

        String s = "Changed";

        switch ( type )
        {
            case Add:
                s = "Added";
                break;

            case Delete:
                s = "Deleted";
                break;

            case Update:
                s = "Updated";
                break;
        }

        return Kmu.format("%s %s [%s]", s, getDomainTypeLabel(), getDomainName());
    }

    @Override
    public String getDomainTypeLabel()
    {
        return Kmu.formatCamelCaseAsCapitalizedWords(getDomainType());
    }
}
