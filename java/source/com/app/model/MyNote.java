package com.app.model;

import com.kodemore.utility.KmVirtualOptions;
import com.kodemore.utility.Kmu;

import com.app.model.base.MyNoteBase;
import com.app.model.base.MyNoteOwnerType;
import com.app.model.core.MyProjectDomainIF;

public class MyNote
    extends MyNoteBase
    implements MyProjectDomainIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyNote()
    {
        super();
    }

    //##################################################
    //# owner
    //##################################################

    public MyNoteOwnerIF getOwner()
    {
        MyNoteOwnerType type = getOwnerType();
        switch ( type )
        {
            case Project:
                return getProject();

            case Customer:
                return getCustomer();

            case Site:
                return getSite();
        }
        throw Kmu.newEnumError(type);
    }

    @Override
    public String getOwnerTitle()
    {
        MyNoteOwnerIF e = getOwner();
        return e == null
            ? KmVirtualOptions.NONE
            : e.getDomainTitle();
    }

    public void applyOwner(MyNoteOwnerIF e)
    {
        e.applyNoteOwnerTo(this);
    }

    public void setOwner(MyProject e)
    {
        setOwnerType(e.getNoteOwnerType());

        setTenant(e.getTenant());
        setProject(e);
        clearCustomer();
        clearSite();
    }

    public void setOwner(MyCustomer e)
    {
        setOwnerType(e.getNoteOwnerType());

        setTenant(e.getTenant());
        setProject(e.getProject());
        setCustomer(e);
        clearSite();
    }

    public void setOwner(MySite e)
    {
        setOwnerType(e.getNoteOwnerType());

        setTenant(e.getTenant());
        setProject(e.getProject());
        setCustomer(e.getCustomer());
        setSite(e);
    }

    //##################################################
    //# format
    //##################################################

    private String formatUserTime()
    {
        String user = hasCreatedBy()
            ? getCreatedByFullName()
            : MyUser.SYSTEM_NAME;

        String time = getCreatedLocalTsMessage();

        return Kmu.format("%s @ %s", user, time);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getAuditLogTitle()
    {
        return formatUserTime();
    }

    @Override
    public String getDomainTitle()
    {
        return Kmu.getFirstLine(getMessage(), 40);
    }

    @Override
    public String getDomainSubtitle()
    {
        return formatUserTime();
    }

}
