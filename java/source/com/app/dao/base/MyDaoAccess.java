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
        v.add(getAuditLogDao());
        v.add(getAutoLoginDao());
        v.add(getDownloadDao());
        v.add(getEmailDao());
        v.add(getEmailPartDao());
        v.add(getEmailRecipientDao());
        v.add(getFieldTestDao());
        v.add(getFileDao());
        v.add(getHibernateCacheTestDao());
        v.add(getInvitationDao());
        v.add(getOptimisticLockDao());
        v.add(getPasswordResetDao());
        v.add(getPatchDao());
        v.add(getPerformanceLogDetailDao());
        v.add(getPerformanceLogSummaryDao());
        v.add(getProjectDao());
        v.add(getServerSessionDao());
        v.add(getSettingsDao());
        v.add(getTenantDao());
        v.add(getThreadTopicDao());
        v.add(getUserDao());
        v.add(getUserActivationDao());
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
    //# file
    //##################################################

    public MyFileDao getFileDao()
    {
        return new MyFileDao();
    }

    public KmList<MyFile> findAllFiles()
    {
        return getFileDao().findAll();
    }

    public MyFile findFileUid(String e)
    {
        return getFileDao().findUid(e);
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
    //# invitation
    //##################################################

    public MyInvitationDao getInvitationDao()
    {
        return new MyInvitationDao();
    }

    public KmList<MyInvitation> findAllInvitations()
    {
        return getInvitationDao().findAll();
    }

    public MyInvitation findInvitationUid(String e)
    {
        return getInvitationDao().findUid(e);
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
    //# convenience
    //##################################################

    public void flush()
    {
        MyGlobals.getDaoSession().flush();
    }

    public boolean tryFlush()
    {
        return MyGlobals.getDaoSession().tryFlush();
    }

}
