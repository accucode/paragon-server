//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.dao.base;

import com.app.dao.MyAccountDao;
import com.app.dao.MyAccountUserDao;
import com.app.dao.MyAutoSignInDao;
import com.app.dao.MyDownloadDao;
import com.app.dao.MyEmailDao;
import com.app.dao.MyEmailPartDao;
import com.app.dao.MyEmailRecipientDao;
import com.app.dao.MyFileDao;
import com.app.dao.MyInvitationDao;
import com.app.dao.MyPasswordResetDao;
import com.app.dao.MyPatchDao;
import com.app.dao.MyPerformanceLogDao;
import com.app.dao.MyServerSessionDao;
import com.app.dao.MySettingsDao;
import com.app.dao.MySystemLogDao;
import com.app.dao.MySystemLogTraceDao;
import com.app.dao.MyUserDao;
import com.app.model.MyAccount;
import com.app.model.MyAccountUser;
import com.app.model.MyAutoSignIn;
import com.app.model.MyDownload;
import com.app.model.MyEmail;
import com.app.model.MyEmailPart;
import com.app.model.MyEmailRecipient;
import com.app.model.MyFile;
import com.app.model.MyInvitation;
import com.app.model.MyPasswordReset;
import com.app.model.MyPatch;
import com.app.model.MyPerformanceLog;
import com.app.model.MyServerSession;
import com.app.model.MySettings;
import com.app.model.MySystemLog;
import com.app.model.MySystemLogTrace;
import com.app.model.MyUser;

import com.kodemore.collection.KmList;

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
    //# accountUser
    //##################################################

    public MyAccountUserDao getAccountUserDao()
    {
        return new MyAccountUserDao();
    }

    public KmList<MyAccountUser> findAllAccountUsers()
    {
        return getAccountUserDao().findAll();
    }

    public MyAccountUser findAccountUserUid(String e)
    {
        return getAccountUserDao().findUid(e);
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

}
