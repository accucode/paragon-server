//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.dao.base;

import com.kodemore.collection.*;
import com.kodemore.dao.*;

import com.app.dao.*;
import com.app.dao.core.*;
import com.app.model.*;
import com.app.model.meta.*;
import com.app.utility.*;

public class MyDaoAccess
{
    //##################################################
    //# instance
    //##################################################

    private static final MyDaoAccess _instance = new MyDaoAccess();

    public static final MyDaoAccess getInstance()
    {
        return _instance;
    }

    //##################################################
    //# all
    //##################################################

    public KmList<KmAbstractDao<?,?>> getAllDaos()
    {
        KmList<KmAbstractDao<?,?>> v;
        v = new KmList<>();
        v.add(getApplicationLogDao());
        v.add(getAttachmentDao());
        v.add(getAuditBundleDao());
        v.add(getAuditLogDao());
        v.add(getAutoLoginDao());
        v.add(getBlurbDao());
        v.add(getChoiceDao());
        v.add(getCustomerDao());
        v.add(getCustomerContactDao());
        v.add(getDefaultRecipientDao());
        v.add(getDownloadDao());
        v.add(getEmailDao());
        v.add(getEmailPartDao());
        v.add(getEmailRecipientDao());
        v.add(getEmailTemplateDao());
        v.add(getFeedbackDao());
        v.add(getFieldTestDao());
        v.add(getFilterTemplateDao());
        v.add(getFilterTemplateItemDao());
        v.add(getHibernateCacheTestDao());
        v.add(getHolidayDao());
        v.add(getMemberDao());
        v.add(getNoteDao());
        v.add(getOptimisticLockDao());
        v.add(getPasswordResetDao());
        v.add(getPatchDao());
        v.add(getPerformanceLogDetailDao());
        v.add(getPerformanceLogSummaryDao());
        v.add(getPriorityDao());
        v.add(getProjectDao());
        v.add(getProjectContactDao());
        v.add(getServerSessionDao());
        v.add(getSettingsDao());
        v.add(getSiteDao());
        v.add(getSiteContactDao());
        v.add(getTenantDao());
        v.add(getThreadTopicDao());
        v.add(getUserDao());
        v.add(getUserActivationDao());
        v.add(getUserRecentProjectDao());
        v.add(getVendorDao());
        return v;
    }

    //##################################################
    //# applicationLog
    //##################################################

    public MyApplicationLogDao getApplicationLogDao()
    {
        return new MyApplicationLogDao();
    }

    public KmList<MyApplicationLog> findAllApplicationLogs()
    {
        return getApplicationLogDao().findAll();
    }

    public MyApplicationLog findApplicationLogUid(String e)
    {
        return getApplicationLogDao().findUid(e);
    }

    //##################################################
    //# attachment
    //##################################################

    public MyAttachmentDao getAttachmentDao()
    {
        return new MyAttachmentDao();
    }

    public KmList<MyAttachment> findAllAttachments()
    {
        return getAttachmentDao().findAll();
    }

    public MyAttachment findAttachmentUid(String e)
    {
        return getAttachmentDao().findUid(e);
    }

    //##################################################
    //# auditBundle
    //##################################################

    public MyAuditBundleDao getAuditBundleDao()
    {
        return new MyAuditBundleDao();
    }

    public KmList<MyAuditBundle> findAllAuditBundles()
    {
        return getAuditBundleDao().findAll();
    }

    public MyAuditBundle findAuditBundleUid(String e)
    {
        return getAuditBundleDao().findUid(e);
    }

    //##################################################
    //# auditLog
    //##################################################

    public MyAuditLogDao getAuditLogDao()
    {
        return new MyAuditLogDao();
    }

    public KmList<MyAuditLog> findAllAuditLogs()
    {
        return getAuditLogDao().findAll();
    }

    public MyAuditLog findAuditLogUid(String e)
    {
        return getAuditLogDao().findUid(e);
    }

    //##################################################
    //# autoLogin
    //##################################################

    public MyAutoLoginDao getAutoLoginDao()
    {
        return new MyAutoLoginDao();
    }

    public KmList<MyAutoLogin> findAllAutoLogins()
    {
        return getAutoLoginDao().findAll();
    }

    public MyAutoLogin findAutoLoginUid(String e)
    {
        return getAutoLoginDao().findUid(e);
    }

    //##################################################
    //# blurb
    //##################################################

    public MyBlurbDao getBlurbDao()
    {
        return new MyBlurbDao();
    }

    public KmList<MyBlurb> findAllBlurbs()
    {
        return getBlurbDao().findAll();
    }

    public MyBlurb findBlurbUid(String e)
    {
        return getBlurbDao().findUid(e);
    }

    //##################################################
    //# choice
    //##################################################

    public MyChoiceDao getChoiceDao()
    {
        return new MyChoiceDao();
    }

    public KmList<MyChoice> findAllChoices()
    {
        return getChoiceDao().findAll();
    }

    public MyChoice findChoiceUid(String e)
    {
        return getChoiceDao().findUid(e);
    }

    //##################################################
    //# customer
    //##################################################

    public MyCustomerDao getCustomerDao()
    {
        return new MyCustomerDao();
    }

    public KmList<MyCustomer> findAllCustomers()
    {
        return getCustomerDao().findAll();
    }

    public MyCustomer findCustomerUid(String e)
    {
        return getCustomerDao().findUid(e);
    }

    //##################################################
    //# customerContact
    //##################################################

    public MyCustomerContactDao getCustomerContactDao()
    {
        return new MyCustomerContactDao();
    }

    public KmList<MyCustomerContact> findAllCustomerContacts()
    {
        return getCustomerContactDao().findAll();
    }

    public MyCustomerContact findCustomerContactUid(String e)
    {
        return getCustomerContactDao().findUid(e);
    }

    //##################################################
    //# defaultRecipient
    //##################################################

    public MyDefaultRecipientDao getDefaultRecipientDao()
    {
        return new MyDefaultRecipientDao();
    }

    public KmList<MyDefaultRecipient> findAllDefaultRecipients()
    {
        return getDefaultRecipientDao().findAll();
    }

    public MyDefaultRecipient findDefaultRecipientUid(String e)
    {
        return getDefaultRecipientDao().findUid(e);
    }

    //##################################################
    //# download
    //##################################################

    public MyDownloadDao getDownloadDao()
    {
        return new MyDownloadDao();
    }

    public KmList<MyDownload> findAllDownloads()
    {
        return getDownloadDao().findAll();
    }

    public MyDownload findDownloadUid(String e)
    {
        return getDownloadDao().findUid(e);
    }

    //##################################################
    //# email
    //##################################################

    public MyEmailDao getEmailDao()
    {
        return new MyEmailDao();
    }

    public KmList<MyEmail> findAllEmails()
    {
        return getEmailDao().findAll();
    }

    public MyEmail findEmailUid(String e)
    {
        return getEmailDao().findUid(e);
    }

    //##################################################
    //# emailPart
    //##################################################

    public MyEmailPartDao getEmailPartDao()
    {
        return new MyEmailPartDao();
    }

    public KmList<MyEmailPart> findAllEmailParts()
    {
        return getEmailPartDao().findAll();
    }

    public MyEmailPart findEmailPartUid(String e)
    {
        return getEmailPartDao().findUid(e);
    }

    //##################################################
    //# emailRecipient
    //##################################################

    public MyEmailRecipientDao getEmailRecipientDao()
    {
        return new MyEmailRecipientDao();
    }

    public KmList<MyEmailRecipient> findAllEmailRecipients()
    {
        return getEmailRecipientDao().findAll();
    }

    public MyEmailRecipient findEmailRecipientUid(String e)
    {
        return getEmailRecipientDao().findUid(e);
    }

    //##################################################
    //# emailTemplate
    //##################################################

    public MyEmailTemplateDao getEmailTemplateDao()
    {
        return new MyEmailTemplateDao();
    }

    public KmList<MyEmailTemplate> findAllEmailTemplates()
    {
        return getEmailTemplateDao().findAll();
    }

    public MyEmailTemplate findEmailTemplateUid(String e)
    {
        return getEmailTemplateDao().findUid(e);
    }

    //##################################################
    //# feedback
    //##################################################

    public MyFeedbackDao getFeedbackDao()
    {
        return new MyFeedbackDao();
    }

    public KmList<MyFeedback> findAllFeedbacks()
    {
        return getFeedbackDao().findAll();
    }

    public MyFeedback findFeedbackUid(String e)
    {
        return getFeedbackDao().findUid(e);
    }

    //##################################################
    //# fieldTest
    //##################################################

    public MyFieldTestDao getFieldTestDao()
    {
        return new MyFieldTestDao();
    }

    public KmList<MyFieldTest> findAllFieldTests()
    {
        return getFieldTestDao().findAll();
    }

    public MyFieldTest findFieldTestUid(String e)
    {
        return getFieldTestDao().findUid(e);
    }

    //##################################################
    //# filterTemplate
    //##################################################

    public MyFilterTemplateDao getFilterTemplateDao()
    {
        return new MyFilterTemplateDao();
    }

    public KmList<MyFilterTemplate> findAllFilterTemplates()
    {
        return getFilterTemplateDao().findAll();
    }

    public MyFilterTemplate findFilterTemplateUid(String e)
    {
        return getFilterTemplateDao().findUid(e);
    }

    //##################################################
    //# filterTemplateItem
    //##################################################

    public MyFilterTemplateItemDao getFilterTemplateItemDao()
    {
        return new MyFilterTemplateItemDao();
    }

    public KmList<MyFilterTemplateItem> findAllFilterTemplateItems()
    {
        return getFilterTemplateItemDao().findAll();
    }

    public MyFilterTemplateItem findFilterTemplateItemUid(String e)
    {
        return getFilterTemplateItemDao().findUid(e);
    }

    //##################################################
    //# hibernateCacheTest
    //##################################################

    public MyHibernateCacheTestDao getHibernateCacheTestDao()
    {
        return new MyHibernateCacheTestDao();
    }

    public KmList<MyHibernateCacheTest> findAllHibernateCacheTests()
    {
        return getHibernateCacheTestDao().findAll();
    }

    public MyHibernateCacheTest findHibernateCacheTestUid(String e)
    {
        return getHibernateCacheTestDao().findUid(e);
    }

    //##################################################
    //# holiday
    //##################################################

    public MyHolidayDao getHolidayDao()
    {
        return new MyHolidayDao();
    }

    public KmList<MyHoliday> findAllHolidays()
    {
        return getHolidayDao().findAll();
    }

    public MyHoliday findHolidayUid(String e)
    {
        return getHolidayDao().findUid(e);
    }

    //##################################################
    //# member
    //##################################################

    public MyMemberDao getMemberDao()
    {
        return new MyMemberDao();
    }

    public KmList<MyMember> findAllMembers()
    {
        return getMemberDao().findAll();
    }

    public MyMember findMemberUid(String e)
    {
        return getMemberDao().findUid(e);
    }

    //##################################################
    //# note
    //##################################################

    public MyNoteDao getNoteDao()
    {
        return new MyNoteDao();
    }

    public KmList<MyNote> findAllNotes()
    {
        return getNoteDao().findAll();
    }

    public MyNote findNoteUid(String e)
    {
        return getNoteDao().findUid(e);
    }

    //##################################################
    //# optimisticLock
    //##################################################

    public MyOptimisticLockDao getOptimisticLockDao()
    {
        return new MyOptimisticLockDao();
    }

    public KmList<MyOptimisticLock> findAllOptimisticLocks()
    {
        return getOptimisticLockDao().findAll();
    }

    public MyOptimisticLock findOptimisticLockName(String e)
    {
        return getOptimisticLockDao().findName(e);
    }

    //##################################################
    //# passwordReset
    //##################################################

    public MyPasswordResetDao getPasswordResetDao()
    {
        return new MyPasswordResetDao();
    }

    public KmList<MyPasswordReset> findAllPasswordResets()
    {
        return getPasswordResetDao().findAll();
    }

    public MyPasswordReset findPasswordResetUid(String e)
    {
        return getPasswordResetDao().findUid(e);
    }

    //##################################################
    //# patch
    //##################################################

    public MyPatchDao getPatchDao()
    {
        return new MyPatchDao();
    }

    public KmList<MyPatch> findAllPatchs()
    {
        return getPatchDao().findAll();
    }

    public MyPatch findPatchName(String e)
    {
        return getPatchDao().findName(e);
    }

    //##################################################
    //# performanceLogDetail
    //##################################################

    public MyPerformanceLogDetailDao getPerformanceLogDetailDao()
    {
        return new MyPerformanceLogDetailDao();
    }

    public KmList<MyPerformanceLogDetail> findAllPerformanceLogDetails()
    {
        return getPerformanceLogDetailDao().findAll();
    }

    public MyPerformanceLogDetail findPerformanceLogDetailUid(String e)
    {
        return getPerformanceLogDetailDao().findUid(e);
    }

    //##################################################
    //# performanceLogSummary
    //##################################################

    public MyPerformanceLogSummaryDao getPerformanceLogSummaryDao()
    {
        return new MyPerformanceLogSummaryDao();
    }

    public KmList<MyPerformanceLogSummary> findAllPerformanceLogSummaries()
    {
        return getPerformanceLogSummaryDao().findAll();
    }

    public MyPerformanceLogSummary findPerformanceLogSummaryUid(String e)
    {
        return getPerformanceLogSummaryDao().findUid(e);
    }

    //##################################################
    //# priority
    //##################################################

    public MyPriorityDao getPriorityDao()
    {
        return new MyPriorityDao();
    }

    public KmList<MyPriority> findAllPriorities()
    {
        return getPriorityDao().findAll();
    }

    public MyPriority findPriorityUid(String e)
    {
        return getPriorityDao().findUid(e);
    }

    //##################################################
    //# project
    //##################################################

    public MyProjectDao getProjectDao()
    {
        return new MyProjectDao();
    }

    public KmList<MyProject> findAllProjects()
    {
        return getProjectDao().findAll();
    }

    public MyProject findProjectUid(String e)
    {
        return getProjectDao().findUid(e);
    }

    //##################################################
    //# projectContact
    //##################################################

    public MyProjectContactDao getProjectContactDao()
    {
        return new MyProjectContactDao();
    }

    public KmList<MyProjectContact> findAllProjectContacts()
    {
        return getProjectContactDao().findAll();
    }

    public MyProjectContact findProjectContactUid(String e)
    {
        return getProjectContactDao().findUid(e);
    }

    //##################################################
    //# serverSession
    //##################################################

    public MyServerSessionDao getServerSessionDao()
    {
        return new MyServerSessionDao();
    }

    public KmList<MyServerSession> findAllServerSessions()
    {
        return getServerSessionDao().findAll();
    }

    public MyServerSession findServerSessionUid(String e)
    {
        return getServerSessionDao().findUid(e);
    }

    //##################################################
    //# settings
    //##################################################

    public MySettingsDao getSettingsDao()
    {
        return new MySettingsDao();
    }

    public KmList<MySettings> findAllSettingses()
    {
        return getSettingsDao().findAll();
    }

    public MySettings findSettingsCode(Integer e)
    {
        return getSettingsDao().findCode(e);
    }

    //##################################################
    //# site
    //##################################################

    public MySiteDao getSiteDao()
    {
        return new MySiteDao();
    }

    public KmList<MySite> findAllSites()
    {
        return getSiteDao().findAll();
    }

    public MySite findSiteUid(String e)
    {
        return getSiteDao().findUid(e);
    }

    //##################################################
    //# siteContact
    //##################################################

    public MySiteContactDao getSiteContactDao()
    {
        return new MySiteContactDao();
    }

    public KmList<MySiteContact> findAllSiteContacts()
    {
        return getSiteContactDao().findAll();
    }

    public MySiteContact findSiteContactUid(String e)
    {
        return getSiteContactDao().findUid(e);
    }

    //##################################################
    //# tenant
    //##################################################

    public MyTenantDao getTenantDao()
    {
        return new MyTenantDao();
    }

    public KmList<MyTenant> findAllTenants()
    {
        return getTenantDao().findAll();
    }

    public MyTenant findTenantUid(String e)
    {
        return getTenantDao().findUid(e);
    }

    //##################################################
    //# threadTopic
    //##################################################

    public MyThreadTopicDao getThreadTopicDao()
    {
        return new MyThreadTopicDao();
    }

    public KmList<MyThreadTopic> findAllThreadTopics()
    {
        return getThreadTopicDao().findAll();
    }

    public MyThreadTopic findThreadTopicCode(String e)
    {
        return getThreadTopicDao().findCode(e);
    }

    //##################################################
    //# user
    //##################################################

    public MyUserDao getUserDao()
    {
        return new MyUserDao();
    }

    public KmList<MyUser> findAllUsers()
    {
        return getUserDao().findAll();
    }

    public MyUser findUserUid(String e)
    {
        return getUserDao().findUid(e);
    }

    //##################################################
    //# userActivation
    //##################################################

    public MyUserActivationDao getUserActivationDao()
    {
        return new MyUserActivationDao();
    }

    public KmList<MyUserActivation> findAllUserActivations()
    {
        return getUserActivationDao().findAll();
    }

    public MyUserActivation findUserActivationUid(String e)
    {
        return getUserActivationDao().findUid(e);
    }

    //##################################################
    //# userRecentProject
    //##################################################

    public MyUserRecentProjectDao getUserRecentProjectDao()
    {
        return new MyUserRecentProjectDao();
    }

    public KmList<MyUserRecentProject> findAllUserRecentProjects()
    {
        return getUserRecentProjectDao().findAll();
    }

    public MyUserRecentProject findUserRecentProjectUid(String e)
    {
        return getUserRecentProjectDao().findUid(e);
    }

    //##################################################
    //# vendor
    //##################################################

    public MyVendorDao getVendorDao()
    {
        return new MyVendorDao();
    }

    public KmList<MyVendor> findAllVendors()
    {
        return getVendorDao().findAll();
    }

    public MyVendor findVendorUid(String e)
    {
        return getVendorDao().findUid(e);
    }


    //##################################################
    //# convenience
    //##################################################

    public void flush()
    {
        getSession().flush();
    }

    public boolean tryFlush()
    {
        return getSession().tryFlush();
    }

    public void disableBasicTimestampsFor(MyBasicTimestampsIF e)
    {
        getSession().disableBasicTimestampsFor(e);
    }

    private MyDaoSession getSession()
    {
        return MyGlobals.getDaoSession();
    }
}
