package com.app.model;

import com.kodemore.utility.KmEnumIF;
import com.kodemore.utility.KmVirtualOptions;
import com.kodemore.utility.Kmu;

import com.app.model.base.MyMemberBase;
import com.app.model.core.MyProjectDomainIF;
import com.app.model.support.MyPageDomainIF;
import com.app.ui.dashboard.core.MyDashboardOrientationType;
import com.app.ui.dashboard.core.MyDashboardPanelType;
import com.app.ui.page.crud.member.MyMemberListPage;

public class MyMember
    extends MyMemberBase
    implements MyProjectDomainIF, MyPageDomainIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyMember()
    {
        super();
    }

    //##################################################
    //# context
    //##################################################

    @Override
    public MyTenant getTenant()
    {
        return getProject().getTenant();
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
    //# dashboard orientation
    //##################################################

    public MyDashboardOrientationType getDashboardOrientationType()
    {
        String code = getDashboardOrientationTypeCode();
        return MyDashboardOrientationType.findCode(code);
    }

    public void setDashboardOrientationType(MyDashboardOrientationType e)
    {
        setDashboardOrientationTypeCode(KmEnumIF.getCodeFor(e));
    }

    //##################################################
    //# dashboard panels
    //##################################################

    public MyDashboardPanelType getDashboardPanelTypeA()
    {
        return MyDashboardPanelType.findCode(getDashboardPanelCodeA());
    }

    public MyDashboardPanelType getDashboardPanelTypeB()
    {
        return MyDashboardPanelType.findCode(getDashboardPanelCodeB());
    }

    public MyDashboardPanelType getDashboardPanelTypeC()
    {
        return MyDashboardPanelType.findCode(getDashboardPanelCodeC());
    }

    public MyDashboardPanelType getDashboardPanelTypeD()
    {
        return MyDashboardPanelType.findCode(getDashboardPanelCodeD());
    }

    public MyDashboardPanelType getDashboardPanelTypeE()
    {
        return MyDashboardPanelType.findCode(getDashboardPanelCodeE());
    }

    public MyDashboardPanelType getDashboardPanelTypeF()
    {
        return MyDashboardPanelType.findCode(getDashboardPanelCodeF());
    }

    public MyDashboardPanelType getDashboardPanelTypeG()
    {
        return MyDashboardPanelType.findCode(getDashboardPanelCodeG());
    }

    //##################################################
    //# role
    //##################################################

    @Override
    public String getRoleDescription()
    {
        return hasRole()
            ? getRoleName()
            : KmVirtualOptions.NONE;
    }

    //##################################################
    //# permissions
    //##################################################

    public boolean allowsManager()
    {
        return isRoleManager() || getUser().allowsTenantAdmin();
    }

    public boolean allowsCopyProject()
    {
        return allowsManager();
    }

    //##################################################
    //# page
    //##################################################

    @Override
    public void ajaxEnterPage()
    {
        MyMemberListPage.getInstance().ajaxEnterChild(this);
    }

    @Override
    public String formatEntryUrl()
    {
        return MyMemberListPage.getInstance().formatEntryUrlFor(this);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getAuditLogTitle()
    {
        return Kmu.format("%s => %s", getProjectName(), getUserFullName());
    }

    @Override
    public String getDomainTitle()
    {
        return getUserFullName();
    }

    @Override
    public String getDomainSubtitle()
    {
        return Kmu.format("%s (%s)", getUserEmail(), getRoleName());
    }

}
