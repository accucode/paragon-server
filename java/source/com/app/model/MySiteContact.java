package com.app.model;

import com.kodemore.collection.KmList;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;

import com.app.model.base.MySiteContactBase;
import com.app.model.core.MyProjectDomainIF;
import com.app.model.support.MyPersonNameUtility;
import com.app.model.transfer.MyTransferrableIF;
import com.app.model.transfer.detail.MyTransferSiteContactDetail;

public class MySiteContact
    extends MySiteContactBase
    implements MyProjectDomainIF, MyContactIF, MyTransferrableIF<MySiteContact>
{
    //##################################################
    //# constructor
    //##################################################

    public MySiteContact()
    {
        super();
    }

    //##################################################
    //# domain
    //##################################################

    @Override
    public MyTenant getTenant()
    {
        return getProject().getTenant();
    }

    @Override
    public MyProject getProject()
    {
        return getSite().getProject();
    }

    //##################################################
    //# enabled
    //##################################################

    @Override
    public boolean isDomainEnabled()
    {
        return isEnabled();
    }

    @Override
    public String getEnabledStatus()
    {
        return Kmu.formatEnabled(getEnabled());
    }

    //##################################################
    //# role
    //##################################################

    @Override
    public Boolean getMainContact()
    {
        return getSite().hasMainContact(this);
    }

    @Override
    public Boolean getInstallContact()
    {
        return getSite().hasInstallContact(this);
    }

    @Override
    public Boolean getEffectiveInstallContact()
    {
        return getSite().hasEffectiveInstallContact(this);
    }

    @Override
    public Boolean getTechnicalContact()
    {
        return getSite().hasTechnicalContact(this);
    }

    @Override
    public Boolean getEffectiveTechnicalContact()
    {
        return getSite().hasEffectiveTechnicalContact(this);
    }

    @Override
    public Boolean getSchedulingContact()
    {
        return getSite().hasSchedulingContact(this);
    }

    @Override
    public Boolean getEffectiveSchedulingContact()
    {
        return getSite().hasEffectiveSchedulingContact(this);
    }

    @Override
    public Boolean getSalesContact()
    {
        return getSite().hasSalesContact(this);
    }

    @Override
    public Boolean getEffectiveSalesContact()
    {
        return getSite().hasEffectiveSalesContact(this);
    }

    @Override
    public Boolean getRequesterContact()
    {
        return getSite().hasRequesterContact(this);
    }

    @Override
    public Boolean getEffectiveRequesterContact()
    {
        return getSite().hasEffectiveRequesterContact(this);
    }

    //##################################################
    //# name
    //##################################################

    @Override
    public void updateFullName()
    {
        String s = MyPersonNameUtility.getFullName(this);
        setFullName(s);
        truncateFullName();
    }

    @Override
    public String getFormalName()
    {
        return MyPersonNameUtility.getFormalName(this);
    }

    @Override
    public String getShortName()
    {
        return MyPersonNameUtility.getShortName(this);
    }

    @Override
    public String getLongName()
    {
        return MyPersonNameUtility.getLongName(this);
    }

    //##################################################
    //# format
    //##################################################

    private String formatRoles()
    {
        MySite site;
        site = getSite();

        KmList<String> v;
        v = new KmList<>();

        if ( site.hasMainContact(this) )
            v.add("Main");

        if ( site.hasEffectiveInstallContact(this) )
            v.add("Install");

        if ( site.hasEffectiveTechnicalContact(this) )
            v.add("Technical");

        if ( site.hasEffectiveSchedulingContact(this) )
            v.add("Scheduling");

        if ( site.hasEffectiveSalesContact(this) )
            v.add("Sales");

        if ( site.hasEffectiveRequesterContact(this) )
            v.add("Requester");

        return v.join();
    }

    //##################################################
    //# transfer
    //##################################################

    @Override
    public MyTransferSiteContactDetail newTransferDetail()
    {
        return new MyTransferSiteContactDetail(this);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getAuditLogTitle()
    {
        return getFullName();
    }

    @Override
    public String getDomainTitle()
    {
        return getFullName();
    }

    @Override
    public String getDomainSubtitle()
    {
        return formatRoles();
    }

    //==================================================
    //= display :: other
    //==================================================

    @Override
    public String getSummaryMultiline()
    {
        KmStringBuilder out;
        out = new KmStringBuilder();
        out.print(getFullName());

        if ( hasPhone() )
        {
            out.println();
            out.print(getPhone());
        }

        if ( hasEmail() )
        {
            out.println();
            out.print(getEmail());
        }

        return out.toString();
    }

}
