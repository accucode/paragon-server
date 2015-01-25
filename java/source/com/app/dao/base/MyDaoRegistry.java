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

    public MyApplicationLog findApplicationLogId(Integer e)
    {
        return getApplicationLogDao().findId(e);
    }

    //##################################################
    //# applicationLogTrace
    //##################################################

    public MyApplicationLogTraceDao getApplicationLogTraceDao()
    {
        return new MyApplicationLogTraceDao();
    }

    public KmList<MyApplicationLogTrace> findAllApplicationLogTraces()
    {
        return getApplicationLogTraceDao().findAll();
    }

    public MyApplicationLogTrace findApplicationLogTraceId(Integer e)
    {
        return getApplicationLogTraceDao().findId(e);
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
    //# category
    //##################################################

    public MyCategoryDao getCategoryDao()
    {
        return new MyCategoryDao();
    }

    public KmList<MyCategory> findAllCategories()
    {
        return getCategoryDao().findAll();
    }

    public MyCategory findCategoryUid(String e)
    {
        return getCategoryDao().findUid(e);
    }

    //##################################################
    //# depot
    //##################################################

    public MyDepotDao getDepotDao()
    {
        return new MyDepotDao();
    }

    public KmList<MyDepot> findAllDepots()
    {
        return getDepotDao().findAll();
    }

    public MyDepot findDepotUid(String e)
    {
        return getDepotDao().findUid(e);
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
    //# memberSkill
    //##################################################

    public MyMemberSkillDao getMemberSkillDao()
    {
        return new MyMemberSkillDao();
    }

    public KmList<MyMemberSkill> findAllMemberSkills()
    {
        return getMemberSkillDao().findAll();
    }

    public MyMemberSkill findMemberSkillUid(String e)
    {
        return getMemberSkillDao().findUid(e);
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
    //# powerType
    //##################################################

    public MyPowerTypeDao getPowerTypeDao()
    {
        return new MyPowerTypeDao();
    }

    public KmList<MyPowerType> findAllPowerTypes()
    {
        return getPowerTypeDao().findAll();
    }

    public MyPowerType findPowerTypeUid(String e)
    {
        return getPowerTypeDao().findUid(e);
    }

    //##################################################
    //# product
    //##################################################

    public MyProductDao getProductDao()
    {
        return new MyProductDao();
    }

    public KmList<MyProduct> findAllProducts()
    {
        return getProductDao().findAll();
    }

    public MyProduct findProductUid(String e)
    {
        return getProductDao().findUid(e);
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
    //# region
    //##################################################

    public MyRegionDao getRegionDao()
    {
        return new MyRegionDao();
    }

    public KmList<MyRegion> findAllRegions()
    {
        return getRegionDao().findAll();
    }

    public MyRegion findRegionUid(String e)
    {
        return getRegionDao().findUid(e);
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
    //# shipCarrier
    //##################################################

    public MyShipCarrierDao getShipCarrierDao()
    {
        return new MyShipCarrierDao();
    }

    public KmList<MyShipCarrier> findAllShipCarriers()
    {
        return getShipCarrierDao().findAll();
    }

    public MyShipCarrier findShipCarrierUid(String e)
    {
        return getShipCarrierDao().findUid(e);
    }

    //##################################################
    //# shipMethod
    //##################################################

    public MyShipMethodDao getShipMethodDao()
    {
        return new MyShipMethodDao();
    }

    public KmList<MyShipMethod> findAllShipMethods()
    {
        return getShipMethodDao().findAll();
    }

    public MyShipMethod findShipMethodUid(String e)
    {
        return getShipMethodDao().findUid(e);
    }

    //##################################################
    //# skill
    //##################################################

    public MySkillDao getSkillDao()
    {
        return new MySkillDao();
    }

    public KmList<MySkill> findAllSkills()
    {
        return getSkillDao().findAll();
    }

    public MySkill findSkillUid(String e)
    {
        return getSkillDao().findUid(e);
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
    //# visitType
    //##################################################

    public MyVisitTypeDao getVisitTypeDao()
    {
        return new MyVisitTypeDao();
    }

    public KmList<MyVisitType> findAllVisitTypes()
    {
        return getVisitTypeDao().findAll();
    }

    public MyVisitType findVisitTypeUid(String e)
    {
        return getVisitTypeDao().findUid(e);
    }

}
