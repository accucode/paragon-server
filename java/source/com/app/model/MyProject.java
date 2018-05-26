package com.app.model;

import com.kodemore.collection.KmCollection;
import com.kodemore.collection.KmList;
import com.kodemore.time.KmBusinessHourPolicy;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmTimeZone;
import com.kodemore.utility.Kmu;

import com.app.criteria.MyAttachmentCriteria;
import com.app.criteria.MyNoteCriteria;
import com.app.criteria.MyProjectCriteria;
import com.app.criteria.MySiteCriteria;
import com.app.model.base.MyAttachmentOwnerType;
import com.app.model.base.MyBlurbOwnerType;
import com.app.model.base.MyEmailTemplateContextType;
import com.app.model.base.MyNoteOwnerType;
import com.app.model.base.MyProjectBase;
import com.app.model.support.MyPageDomainIF;
import com.app.model.support.MyPrioritySequence;
import com.app.ui.page.crud.project.MyProjectListPage;

public class MyProject
    extends MyProjectBase
    implements MyPageDomainIF, MyNoteOwnerIF, MyAttachmentOwnerIF, MyBlurbOwnerIF,
    MyEmailTemplateContextIF
{
    //##################################################
    //# constants
    //##################################################

    public static final String INITIAL_UNIT_NAME = "Each";

    //##################################################
    //# constructor
    //##################################################

    public MyProject()
    {
        super();
    }

    //##################################################
    //# context
    //##################################################

    @Override
    public MyProject getProject()
    {
        return this;
    }

    //##################################################
    //# tenant
    //##################################################

    public void applyTenantDefaults()
    {
        MyTenant e = getTenant();
        if ( e == null )
            return;

        setTimeZone(e.getTimeZone());
        setBusinessStartTime(e.getBusinessStartTime());
        setBusinessEndTime(e.getBusinessEndTime());
        setBusinessDays(e.getBusinessDays());
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
    //# time zone
    //##################################################

    public KmTimeZone getTimeZone()
    {
        return KmTimeZone.findCode(getTimeZoneCode());
    }

    public void setTimeZone(KmTimeZone e)
    {
        setTimeZoneCode(KmTimeZone.getCodeFor(e));
    }

    public boolean hasTimeZone()
    {
        return getTimeZone() != null;
    }

    public boolean hasTimeZone(KmTimeZone e)
    {
        return Kmu.isEqual(getTimeZone(), e);
    }

    @Override
    public String getTimeZoneName()
    {
        return hasTimeZone()
            ? getTimeZone().getName()
            : null;
    }

    //##################################################
    //# business hours
    //##################################################

    public KmBusinessHourPolicy getBusinessHourPolicy()
    {
        KmBusinessHourPolicy p;
        p = KmBusinessHourPolicy.DEFAULT;

        if ( hasBusinessDays() )
            p.setDays(getBusinessDays());

        if ( hasBusinessStartTime() )
            p.setStartTime(getBusinessStartTime());

        if ( hasBusinessEndTime() )
            p.setEndTime(getBusinessEndTime());

        p.setHolidays(getHolidayDates());
        return p;
    }

    public KmList<KmDate> getHolidayDates()
    {
        return getHolidays().toList().collect(e -> e.getDay());
    }

    //##################################################
    //# duplicate checks
    //##################################################

    public boolean hasDifferentProjectWithSameName(String name)
    {
        MyProjectCriteria c;
        c = getAccess().getProjectDao().createCriteria();
        c.whereTenantIs(getTenant());
        c.whereName().is(name);
        c.whereUid().isNot(getUid());
        return c.exists();
    }

    //##################################################
    //# members
    //##################################################

    public MyMember findMember(MyUser e)
    {
        return getAccess().getMemberDao().findMember(this, e);
    }

    public MyMember getMemberFor(MyUser user)
    {
        return getMembers().detect(e -> e.hasUser(user));
    }

    public boolean hasMember(MyUser u)
    {
        return getMemberFor(u) != null;
    }

    public KmList<MyMember> getMembersByName()
    {
        return getMembers().toList(e -> e.getUserFullName());
    }

    public KmList<MyMember> getEnabledMembersByName()
    {
        return getMembersByName().select(e -> e.isEnabled());
    }

    public KmList<MyUser> getMemberUsersByName()
    {
        return getMembersByName().collect(e -> e.getUser());
    }

    public KmList<MyUser> getEnabledMemberUsersByName()
    {
        return getEnabledMembersByName().collect(e -> e.getUser());
    }

    /**
     * Determines if the user is allowed member-level access to this project.
     */
    public boolean allowsMember(MyUser u)
    {
        return hasMember(u) || u.allowsTenantAdmin();
    }

    public boolean hasManager(MyUser u)
    {
        MyMember e = getMemberFor(u);
        return e == null
            ? false
            : e.isRoleManager();
    }

    public KmList<MyMember> getManagersByName()
    {
        return getMembersByName().select(e -> e.isRoleManager());
    }

    public KmCollection<MyMember> getWorkers()
    {
        return getMembers().select(e -> e.isRoleWorker());
    }

    public KmCollection<MyUser> getWorkerUsers()
    {
        return getWorkers().collect(e -> e.getUser());
    }

    public KmList<MyUser> getWorkerUsersByFullName()
    {
        return getWorkerUsers().toList(e -> Kmu.toLowerCase(e.getFullName()));
    }

    public boolean hasWorker(MyUser u)
    {
        MyMember e = getMemberFor(u);
        if ( e == null )
            return false;

        return e.isRoleWorker();
    }

    //==================================================
    //= members :: add
    //==================================================

    /**
     * Make the user a manager of the project.
     */
    public void addManager(MyUser user)
    {
        MyMember member = findMember(user);
        if ( member == null )
        {
            member = addMember();
            member.setUser(user);
            member.setRoleManager();
            member.daoAttach();
            return;
        }

        member.setRoleManager();
    }

    //##################################################
    //# sites
    //##################################################

    public KmList<MySite> getSitesByName()
    {
        MySiteCriteria c;
        c = getAccess().getSiteDao().createCriteria();
        c.joinToCustomer().whereProjectIs(this);
        c.sortOnFullName();
        return c.findAll();
    }

    //##################################################
    //# customer
    //##################################################

    public KmList<MyCustomer> getCustomersByName()
    {
        return getCustomers().toList(e -> Kmu.toLowerCase(e.getName()));
    }

    public KmList<MyCustomer> getEnabledCustomersByName()
    {
        return getCustomersByName().select(e -> e.isEnabled());
    }

    //##################################################
    //# vendors
    //##################################################

    public KmList<MyVendor> getVendorsByName()
    {
        return getVendors().toList(e -> e.getName().toLowerCase());
    }

    public KmList<MyVendor> getEnabledVendorsByName()
    {
        return getVendorsByName().select(e -> e.isEnabled());
    }

    //##################################################
    //# email templates
    //##################################################

    public KmList<MyEmailTemplate> getEmailTemplatesByName()
    {
        return getEmailTemplates().toList(e -> Kmu.toLowerCase(e.getName()));
    }

    public KmList<MyEmailTemplate> getEnabledEmailTemplatesByNameFor(
        MyEmailTemplateContextType type)
    {
        KmList<MyEmailTemplate> v;
        v = getEmailTemplatesByName();
        v.retainIf(e -> e.hasContextType(type));
        v.retainIf(e -> e.isEnabled());
        return v;
    }

    //##################################################
    //# contact
    //##################################################

    public KmList<MyProjectContact> getContactsByFullName()
    {
        return getContacts().toList(e -> Kmu.toLowerCase(e.getFullName()));
    }

    //##################################################
    //# priorities
    //##################################################

    public void createDefaultPriorities()
    {
        createPriority("High", MyPrioritySequence.High2);
        createPriority("Low", MyPrioritySequence.Low2);

        MyPriority e = createPriority("Normal", MyPrioritySequence.Normal2);
        setDefaultPriority(e);
    }

    private MyPriority createPriority(String name, MyPrioritySequence seq)
    {
        MyPriority e;
        e = new MyPriority();
        e.setName(name);
        e.setSequence(seq);
        e.setProject(this);
        e.daoAttach();
        return e;
    }

    public KmList<MyPriority> getPriorityListBySequence()
    {
        KmList<MyPriority> v;
        v = getAccess().getPriorityDao().findAllFor(this);
        v.sortOn(e -> e.getSequenceCode());
        return v;
    }

    //##################################################
    //# automatic site number
    //##################################################

    public String allocateNextAutoSiteNumber()
    {
        int i = getNextAutoSiteNumber();
        Integer pad = getAutoSiteNumberPadding();
        String s = Kmu.leftPad(i, pad);

        if ( hasAutoSiteNumberPrefix() )
            s = getAutoSiteNumberPrefix() + s;

        i++;
        setNextAutoSiteNumber(i);

        return s;
    }

    //##################################################
    //# page
    //##################################################

    @Override
    public void ajaxEnterPage()
    {
        MyProjectListPage.getInstance().ajaxEnterChild(this);
    }

    @Override
    public String formatEntryUrl()
    {
        return MyProjectListPage.getInstance().formatEntryUrlFor(this);
    }

    //##################################################
    //# blubs
    //##################################################

    @Override
    public MyBlurbOwnerType getBlurbOwnerType()
    {
        return MyBlurbOwnerType.Project;
    }

    //##################################################
    //# email
    //##################################################

    @Override
    public MyEmailTemplateContextType getEmailTemplateContextType()
    {
        return MyEmailTemplateContextType.Project;
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getAuditLogTitle()
    {
        return getName();
    }

    @Override
    public String getDomainTitle()
    {
        return Kmu.format("%s (%s)", getName(), getCode());
    }

    @Override
    public String getDomainSubtitle()
    {
        return null;
    }

    //##################################################
    //# notes
    //##################################################

    @Override
    public MyNoteOwnerType getNoteOwnerType()
    {
        return MyNoteOwnerType.Project;
    }

    @Override
    public void applyNoteOwnerTo(MyNote e)
    {
        e.setOwner(this);
    }

    @Override
    public void applyNoteOwnerTo(MyNoteCriteria e)
    {
        e.whereOwnerTypeIs(getNoteOwnerType());
        e.whereProjectIs(this);
    }

    //##################################################
    //# attachment
    //##################################################

    @Override
    public MyAttachmentOwnerType getAttachmentOwnerType()
    {
        return MyAttachmentOwnerType.Project;
    }

    @Override
    public void applyAttachmentOwnerTo(MyAttachment e)
    {
        e.setOwner(this);
    }

    @Override
    public void applyAttachmentOwnerTo(MyAttachmentCriteria c)
    {
        c.whereOwnerTypeIsProject();
        c.whereProjectIs(this);
    }

}
