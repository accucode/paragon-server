//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.ui.servlet.base;

import com.kodemore.servlet.*;
import com.kodemore.servlet.variable.*;
import com.kodemore.time.*;

import com.app.dao.base.*;
import com.app.model.*;
import com.app.ui.core.*;
import com.app.utility.*;

public class MyPageSessionBase
    extends ScPageSession
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalString _accountUid;
    private ScLocalString _accountUserUid;
    private ScLocalString _autoSignInUid;
    private ScLocalString _downloadUid;
    private ScLocalString _emailUid;
    private ScLocalString _emailPartUid;
    private ScLocalString _emailRecipientUid;
    private ScLocalInteger _fileId;
    private ScLocalString _invitationUid;
    private ScLocalString _passwordResetUid;
    private ScLocalString _patchName;
    private ScLocalInteger _performanceLogId;
    private ScLocalString _serverSessionUid;
    private ScLocalInteger _settingsCode;
    private ScLocalInteger _systemLogId;
    private ScLocalInteger _systemLogTraceId;
    private ScLocalString _userUid;

    //##################################################
    //# constructor
    //##################################################

    protected MyPageSessionBase()
    {
        _accountUid = new ScLocalString();
        _accountUid.setAutoSave();

        _accountUserUid = new ScLocalString();
        _accountUserUid.setAutoSave();

        _autoSignInUid = new ScLocalString();
        _autoSignInUid.setAutoSave();

        _downloadUid = new ScLocalString();
        _downloadUid.setAutoSave();

        _emailUid = new ScLocalString();
        _emailUid.setAutoSave();

        _emailPartUid = new ScLocalString();
        _emailPartUid.setAutoSave();

        _emailRecipientUid = new ScLocalString();
        _emailRecipientUid.setAutoSave();

        _fileId = new ScLocalInteger();
        _fileId.setAutoSave();

        _invitationUid = new ScLocalString();
        _invitationUid.setAutoSave();

        _passwordResetUid = new ScLocalString();
        _passwordResetUid.setAutoSave();

        _patchName = new ScLocalString();
        _patchName.setAutoSave();

        _performanceLogId = new ScLocalInteger();
        _performanceLogId.setAutoSave();

        _serverSessionUid = new ScLocalString();
        _serverSessionUid.setAutoSave();

        _settingsCode = new ScLocalInteger();
        _settingsCode.setAutoSave();

        _systemLogId = new ScLocalInteger();
        _systemLogId.setAutoSave();

        _systemLogTraceId = new ScLocalInteger();
        _systemLogTraceId.setAutoSave();

        _userUid = new ScLocalString();
        _userUid.setAutoSave();

    }

    //##################################################
    //# Account
    //##################################################

    public String getAccountUid()
    {
        return getAccountUidHolder().getValue();
    }

    public void setAccountUid(String e)
    {
        getAccountUidHolder().setValue(e);
    }

    public ScLocalString getAccountUidHolder()
    {
        return _accountUid;
    }

    public MyAccount getAccount()
    {
        return getDaoRegistry().getAccountDao().findUid(getAccountUid());
    }

    public void setAccount(MyAccount e)
    {
        if ( e == null )
            setAccountUid(null);
        else
            setAccountUid(e.getUid());
    }

    public void resetAccount()
    {
        getAccountUidHolder().resetValue();
    }

    //##################################################
    //# AccountUser
    //##################################################

    public String getAccountUserUid()
    {
        return getAccountUserUidHolder().getValue();
    }

    public void setAccountUserUid(String e)
    {
        getAccountUserUidHolder().setValue(e);
    }

    public ScLocalString getAccountUserUidHolder()
    {
        return _accountUserUid;
    }

    public MyAccountUser getAccountUser()
    {
        return getDaoRegistry().getAccountUserDao().findUid(getAccountUserUid());
    }

    public void setAccountUser(MyAccountUser e)
    {
        if ( e == null )
            setAccountUserUid(null);
        else
            setAccountUserUid(e.getUid());
    }

    public void resetAccountUser()
    {
        getAccountUserUidHolder().resetValue();
    }

    //##################################################
    //# AutoSignIn
    //##################################################

    public String getAutoSignInUid()
    {
        return getAutoSignInUidHolder().getValue();
    }

    public void setAutoSignInUid(String e)
    {
        getAutoSignInUidHolder().setValue(e);
    }

    public ScLocalString getAutoSignInUidHolder()
    {
        return _autoSignInUid;
    }

    public MyAutoSignIn getAutoSignIn()
    {
        return getDaoRegistry().getAutoSignInDao().findUid(getAutoSignInUid());
    }

    public void setAutoSignIn(MyAutoSignIn e)
    {
        if ( e == null )
            setAutoSignInUid(null);
        else
            setAutoSignInUid(e.getUid());
    }

    public void resetAutoSignIn()
    {
        getAutoSignInUidHolder().resetValue();
    }

    //##################################################
    //# Download
    //##################################################

    public String getDownloadUid()
    {
        return getDownloadUidHolder().getValue();
    }

    public void setDownloadUid(String e)
    {
        getDownloadUidHolder().setValue(e);
    }

    public ScLocalString getDownloadUidHolder()
    {
        return _downloadUid;
    }

    public MyDownload getDownload()
    {
        return getDaoRegistry().getDownloadDao().findUid(getDownloadUid());
    }

    public void setDownload(MyDownload e)
    {
        if ( e == null )
            setDownloadUid(null);
        else
            setDownloadUid(e.getUid());
    }

    public void resetDownload()
    {
        getDownloadUidHolder().resetValue();
    }

    //##################################################
    //# Email
    //##################################################

    public String getEmailUid()
    {
        return getEmailUidHolder().getValue();
    }

    public void setEmailUid(String e)
    {
        getEmailUidHolder().setValue(e);
    }

    public ScLocalString getEmailUidHolder()
    {
        return _emailUid;
    }

    public MyEmail getEmail()
    {
        return getDaoRegistry().getEmailDao().findUid(getEmailUid());
    }

    public void setEmail(MyEmail e)
    {
        if ( e == null )
            setEmailUid(null);
        else
            setEmailUid(e.getUid());
    }

    public void resetEmail()
    {
        getEmailUidHolder().resetValue();
    }

    //##################################################
    //# EmailPart
    //##################################################

    public String getEmailPartUid()
    {
        return getEmailPartUidHolder().getValue();
    }

    public void setEmailPartUid(String e)
    {
        getEmailPartUidHolder().setValue(e);
    }

    public ScLocalString getEmailPartUidHolder()
    {
        return _emailPartUid;
    }

    public MyEmailPart getEmailPart()
    {
        return getDaoRegistry().getEmailPartDao().findUid(getEmailPartUid());
    }

    public void setEmailPart(MyEmailPart e)
    {
        if ( e == null )
            setEmailPartUid(null);
        else
            setEmailPartUid(e.getUid());
    }

    public void resetEmailPart()
    {
        getEmailPartUidHolder().resetValue();
    }

    //##################################################
    //# EmailRecipient
    //##################################################

    public String getEmailRecipientUid()
    {
        return getEmailRecipientUidHolder().getValue();
    }

    public void setEmailRecipientUid(String e)
    {
        getEmailRecipientUidHolder().setValue(e);
    }

    public ScLocalString getEmailRecipientUidHolder()
    {
        return _emailRecipientUid;
    }

    public MyEmailRecipient getEmailRecipient()
    {
        return getDaoRegistry().getEmailRecipientDao().findUid(getEmailRecipientUid());
    }

    public void setEmailRecipient(MyEmailRecipient e)
    {
        if ( e == null )
            setEmailRecipientUid(null);
        else
            setEmailRecipientUid(e.getUid());
    }

    public void resetEmailRecipient()
    {
        getEmailRecipientUidHolder().resetValue();
    }

    //##################################################
    //# File
    //##################################################

    public Integer getFileId()
    {
        return getFileIdHolder().getValue();
    }

    public void setFileId(Integer e)
    {
        getFileIdHolder().setValue(e);
    }

    public ScLocalInteger getFileIdHolder()
    {
        return _fileId;
    }

    public MyFile getFile()
    {
        return getDaoRegistry().getFileDao().findId(getFileId());
    }

    public void setFile(MyFile e)
    {
        if ( e == null )
            setFileId(null);
        else
            setFileId(e.getId());
    }

    public void resetFile()
    {
        getFileIdHolder().resetValue();
    }

    //##################################################
    //# Invitation
    //##################################################

    public String getInvitationUid()
    {
        return getInvitationUidHolder().getValue();
    }

    public void setInvitationUid(String e)
    {
        getInvitationUidHolder().setValue(e);
    }

    public ScLocalString getInvitationUidHolder()
    {
        return _invitationUid;
    }

    public MyInvitation getInvitation()
    {
        return getDaoRegistry().getInvitationDao().findUid(getInvitationUid());
    }

    public void setInvitation(MyInvitation e)
    {
        if ( e == null )
            setInvitationUid(null);
        else
            setInvitationUid(e.getUid());
    }

    public void resetInvitation()
    {
        getInvitationUidHolder().resetValue();
    }

    //##################################################
    //# PasswordReset
    //##################################################

    public String getPasswordResetUid()
    {
        return getPasswordResetUidHolder().getValue();
    }

    public void setPasswordResetUid(String e)
    {
        getPasswordResetUidHolder().setValue(e);
    }

    public ScLocalString getPasswordResetUidHolder()
    {
        return _passwordResetUid;
    }

    public MyPasswordReset getPasswordReset()
    {
        return getDaoRegistry().getPasswordResetDao().findUid(getPasswordResetUid());
    }

    public void setPasswordReset(MyPasswordReset e)
    {
        if ( e == null )
            setPasswordResetUid(null);
        else
            setPasswordResetUid(e.getUid());
    }

    public void resetPasswordReset()
    {
        getPasswordResetUidHolder().resetValue();
    }

    //##################################################
    //# Patch
    //##################################################

    public String getPatchName()
    {
        return getPatchNameHolder().getValue();
    }

    public void setPatchName(String e)
    {
        getPatchNameHolder().setValue(e);
    }

    public ScLocalString getPatchNameHolder()
    {
        return _patchName;
    }

    public MyPatch getPatch()
    {
        return getDaoRegistry().getPatchDao().findName(getPatchName());
    }

    public void setPatch(MyPatch e)
    {
        if ( e == null )
            setPatchName(null);
        else
            setPatchName(e.getName());
    }

    public void resetPatch()
    {
        getPatchNameHolder().resetValue();
    }

    //##################################################
    //# PerformanceLog
    //##################################################

    public Integer getPerformanceLogId()
    {
        return getPerformanceLogIdHolder().getValue();
    }

    public void setPerformanceLogId(Integer e)
    {
        getPerformanceLogIdHolder().setValue(e);
    }

    public ScLocalInteger getPerformanceLogIdHolder()
    {
        return _performanceLogId;
    }

    public MyPerformanceLog getPerformanceLog()
    {
        return getDaoRegistry().getPerformanceLogDao().findId(getPerformanceLogId());
    }

    public void setPerformanceLog(MyPerformanceLog e)
    {
        if ( e == null )
            setPerformanceLogId(null);
        else
            setPerformanceLogId(e.getId());
    }

    public void resetPerformanceLog()
    {
        getPerformanceLogIdHolder().resetValue();
    }

    //##################################################
    //# ServerSession
    //##################################################

    public String getServerSessionUid()
    {
        return getServerSessionUidHolder().getValue();
    }

    public void setServerSessionUid(String e)
    {
        getServerSessionUidHolder().setValue(e);
    }

    public ScLocalString getServerSessionUidHolder()
    {
        return _serverSessionUid;
    }

    public MyServerSession getServerSession()
    {
        return getDaoRegistry().getServerSessionDao().findUid(getServerSessionUid());
    }

    public void setServerSession(MyServerSession e)
    {
        if ( e == null )
            setServerSessionUid(null);
        else
            setServerSessionUid(e.getUid());
    }

    public void resetServerSession()
    {
        getServerSessionUidHolder().resetValue();
    }

    //##################################################
    //# Settings
    //##################################################

    public Integer getSettingsCode()
    {
        return getSettingsCodeHolder().getValue();
    }

    public void setSettingsCode(Integer e)
    {
        getSettingsCodeHolder().setValue(e);
    }

    public ScLocalInteger getSettingsCodeHolder()
    {
        return _settingsCode;
    }

    public MySettings getSettings()
    {
        return getDaoRegistry().getSettingsDao().findCode(getSettingsCode());
    }

    public void setSettings(MySettings e)
    {
        if ( e == null )
            setSettingsCode(null);
        else
            setSettingsCode(e.getCode());
    }

    public void resetSettings()
    {
        getSettingsCodeHolder().resetValue();
    }

    //##################################################
    //# SystemLog
    //##################################################

    public Integer getSystemLogId()
    {
        return getSystemLogIdHolder().getValue();
    }

    public void setSystemLogId(Integer e)
    {
        getSystemLogIdHolder().setValue(e);
    }

    public ScLocalInteger getSystemLogIdHolder()
    {
        return _systemLogId;
    }

    public MySystemLog getSystemLog()
    {
        return getDaoRegistry().getSystemLogDao().findId(getSystemLogId());
    }

    public void setSystemLog(MySystemLog e)
    {
        if ( e == null )
            setSystemLogId(null);
        else
            setSystemLogId(e.getId());
    }

    public void resetSystemLog()
    {
        getSystemLogIdHolder().resetValue();
    }

    //##################################################
    //# SystemLogTrace
    //##################################################

    public Integer getSystemLogTraceId()
    {
        return getSystemLogTraceIdHolder().getValue();
    }

    public void setSystemLogTraceId(Integer e)
    {
        getSystemLogTraceIdHolder().setValue(e);
    }

    public ScLocalInteger getSystemLogTraceIdHolder()
    {
        return _systemLogTraceId;
    }

    public MySystemLogTrace getSystemLogTrace()
    {
        return getDaoRegistry().getSystemLogTraceDao().findId(getSystemLogTraceId());
    }

    public void setSystemLogTrace(MySystemLogTrace e)
    {
        if ( e == null )
            setSystemLogTraceId(null);
        else
            setSystemLogTraceId(e.getId());
    }

    public void resetSystemLogTrace()
    {
        getSystemLogTraceIdHolder().resetValue();
    }

    //##################################################
    //# User
    //##################################################

    public String getUserUid()
    {
        return getUserUidHolder().getValue();
    }

    public void setUserUid(String e)
    {
        getUserUidHolder().setValue(e);
    }

    public ScLocalString getUserUidHolder()
    {
        return _userUid;
    }

    public MyUser getUser()
    {
        return getDaoRegistry().getUserDao().findUid(getUserUid());
    }

    public void setUser(MyUser e)
    {
        if ( e == null )
            setUserUid(null);
        else
            setUserUid(e.getUid());
    }

    public void resetUser()
    {
        getUserUidHolder().resetValue();
    }

    //##################################################
    //# convenience
    //##################################################

    protected MyServletData getData()
    {
        return MyGlobals.getData();
    }

    protected MyDaoRegistry getDaoRegistry()
    {
        return new MyDaoRegistry();
    }

}
