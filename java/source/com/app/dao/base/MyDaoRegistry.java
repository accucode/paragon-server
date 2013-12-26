//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.dao.base;

import com.kodemore.collection.*;

import com.app.dao.*;
import com.app.model.*;
import com.app.model.meta.*;

public class MyDaoRegistry
{
    //##################################################
    //# instance
    //##################################################

    private static final MyDaoRegistry _instance = new MyDaoRegistry();

    public static final MyDaoRegistry getInstance()
    {
        return _instance;
    }

    //##################################################
    //# account
    //##################################################

    public MyAccountDao getAccountDao()
    {
        return new MyAccountDao();
    }

    public KmList<MyAccount> findAllAccounts()
    {
        return getAccountDao().findAll();
    }

    public MyAccount findAccountUid(String e)
    {
        return getAccountDao().findUid(e);
    }

    //##################################################
    //# autoSignIn
    //##################################################

    public MyAutoSignInDao getAutoSignInDao()
    {
        return new MyAutoSignInDao();
    }

    public KmList<MyAutoSignIn> findAllAutoSignIns()
    {
        return getAutoSignInDao().findAll();
    }

    public MyAutoSignIn findAutoSignInUid(String e)
    {
        return getAutoSignInDao().findUid(e);
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

    public MyFile findFileId(Integer e)
    {
        return getFileDao().findId(e);
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
    //# performanceLog
    //##################################################

    public MyPerformanceLogDao getPerformanceLogDao()
    {
        return new MyPerformanceLogDao();
    }

    public KmList<MyPerformanceLog> findAllPerformanceLogs()
    {
        return getPerformanceLogDao().findAll();
    }

    public MyPerformanceLog findPerformanceLogId(Integer e)
    {
        return getPerformanceLogDao().findId(e);
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
    //# systemLog
    //##################################################

    public MySystemLogDao getSystemLogDao()
    {
        return new MySystemLogDao();
    }

    public KmList<MySystemLog> findAllSystemLogs()
    {
        return getSystemLogDao().findAll();
    }

    public MySystemLog findSystemLogId(Integer e)
    {
        return getSystemLogDao().findId(e);
    }

    //##################################################
    //# systemLogTrace
    //##################################################

    public MySystemLogTraceDao getSystemLogTraceDao()
    {
        return new MySystemLogTraceDao();
    }

    public KmList<MySystemLogTrace> findAllSystemLogTraces()
    {
        return getSystemLogTraceDao().findAll();
    }

    public MySystemLogTrace findSystemLogTraceId(Integer e)
    {
        return getSystemLogTraceDao().findId(e);
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
    //# userAccount
    //##################################################

    public MyUserAccountDao getUserAccountDao()
    {
        return new MyUserAccountDao();
    }

    public KmList<MyUserAccount> findAllUserAccounts()
    {
        return getUserAccountDao().findAll();
    }

    public MyUserAccount findUserAccountUid(String e)
    {
        return getUserAccountDao().findUid(e);
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

}
