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
    //# all
    //##################################################

    public KmList<KmAbstractDao<?,?>> getAllDaos()
    {
        KmList<KmAbstractDao<?,?>> v;
        v = new KmList<>();
        v.add(getApplicationLogDao());
        v.add(getAttentionGroupDao());
        v.add(getAttributeFieldDao());
        v.add(getAttributeValueDao());
        v.add(getAuditLogDao());
        v.add(getAutoSignInDao());
        v.add(getCustomerDao());
        v.add(getCustomerContactDao());
        v.add(getCustomerSiteDao());
        v.add(getCustomerTierDao());
        v.add(getDepotDao());
        v.add(getDownloadDao());
        v.add(getEmailDao());
        v.add(getEmailPartDao());
        v.add(getEmailRecipientDao());
        v.add(getEndUserDao());
        v.add(getEndUserSiteDao());
        v.add(getFieldTestDao());
        v.add(getFileDao());
        v.add(getHibernateCacheTestDao());
        v.add(getInvitationDao());
        v.add(getMasterProductDao());
        v.add(getMemberDao());
        v.add(getMemberSkillDao());
        v.add(getOrderNumberDao());
        v.add(getPasswordResetDao());
        v.add(getPatchDao());
        v.add(getPerformanceLogDetailDao());
        v.add(getPerformanceLogSummaryDao());
        v.add(getPowerTypeDao());
        v.add(getProductDao());
        v.add(getProductCategoryDao());
        v.add(getProjectDao());
        v.add(getRegionDao());
        v.add(getSalesOrderDao());
        v.add(getSalesOrderContactDao());
        v.add(getSalesOrderLineDao());
        v.add(getServerSessionDao());
        v.add(getSettingsDao());
        v.add(getShipAccountDao());
        v.add(getShipCarrierDao());
        v.add(getShipMethodDao());
        v.add(getShipmentDao());
        v.add(getSkillDao());
        v.add(getThreadTopicDao());
        v.add(getUserDao());
        v.add(getUserActivationDao());
        v.add(getVendorDao());
        v.add(getVisitTypeDao());
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
    //# attentionGroup
    //##################################################

    public MyAttentionGroupDao getAttentionGroupDao()
    {
        return new MyAttentionGroupDao();
    }

    public KmList<MyAttentionGroup> findAllAttentionGroups()
    {
        return getAttentionGroupDao().findAll();
    }

    public MyAttentionGroup findAttentionGroupUid(String e)
    {
        return getAttentionGroupDao().findUid(e);
    }

    //##################################################
    //# attributeField
    //##################################################

    public MyAttributeFieldDao getAttributeFieldDao()
    {
        return new MyAttributeFieldDao();
    }

    public KmList<MyAttributeField> findAllAttributeFields()
    {
        return getAttributeFieldDao().findAll();
    }

    public MyAttributeField findAttributeFieldUid(String e)
    {
        return getAttributeFieldDao().findUid(e);
    }

    //##################################################
    //# attributeValue
    //##################################################

    public MyAttributeValueDao getAttributeValueDao()
    {
        return new MyAttributeValueDao();
    }

    public KmList<MyAttributeValue> findAllAttributeValues()
    {
        return getAttributeValueDao().findAll();
    }

    public MyAttributeValue findAttributeValueUid(String e)
    {
        return getAttributeValueDao().findUid(e);
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
    //# customerSite
    //##################################################

    public MyCustomerSiteDao getCustomerSiteDao()
    {
        return new MyCustomerSiteDao();
    }

    public KmList<MyCustomerSite> findAllCustomerSites()
    {
        return getCustomerSiteDao().findAll();
    }

    public MyCustomerSite findCustomerSiteUid(String e)
    {
        return getCustomerSiteDao().findUid(e);
    }

    //##################################################
    //# customerTier
    //##################################################

    public MyCustomerTierDao getCustomerTierDao()
    {
        return new MyCustomerTierDao();
    }

    public KmList<MyCustomerTier> findAllCustomerTiers()
    {
        return getCustomerTierDao().findAll();
    }

    public MyCustomerTier findCustomerTierUid(String e)
    {
        return getCustomerTierDao().findUid(e);
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
    //# endUser
    //##################################################

    public MyEndUserDao getEndUserDao()
    {
        return new MyEndUserDao();
    }

    public KmList<MyEndUser> findAllEndUsers()
    {
        return getEndUserDao().findAll();
    }

    public MyEndUser findEndUserUid(String e)
    {
        return getEndUserDao().findUid(e);
    }

    //##################################################
    //# endUserSite
    //##################################################

    public MyEndUserSiteDao getEndUserSiteDao()
    {
        return new MyEndUserSiteDao();
    }

    public KmList<MyEndUserSite> findAllEndUserSites()
    {
        return getEndUserSiteDao().findAll();
    }

    public MyEndUserSite findEndUserSiteUid(String e)
    {
        return getEndUserSiteDao().findUid(e);
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
    //# masterProduct
    //##################################################

    public MyMasterProductDao getMasterProductDao()
    {
        return new MyMasterProductDao();
    }

    public KmList<MyMasterProduct> findAllMasterProducts()
    {
        return getMasterProductDao().findAll();
    }

    public MyMasterProduct findMasterProductUid(String e)
    {
        return getMasterProductDao().findUid(e);
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
    //# orderNumber
    //##################################################

    public MyOrderNumberDao getOrderNumberDao()
    {
        return new MyOrderNumberDao();
    }

    public KmList<MyOrderNumber> findAllOrderNumbers()
    {
        return getOrderNumberDao().findAll();
    }

    public MyOrderNumber findOrderNumberUid(String e)
    {
        return getOrderNumberDao().findUid(e);
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
    //# productCategory
    //##################################################

    public MyProductCategoryDao getProductCategoryDao()
    {
        return new MyProductCategoryDao();
    }

    public KmList<MyProductCategory> findAllProductCategories()
    {
        return getProductCategoryDao().findAll();
    }

    public MyProductCategory findProductCategoryUid(String e)
    {
        return getProductCategoryDao().findUid(e);
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
    //# salesOrder
    //##################################################

    public MySalesOrderDao getSalesOrderDao()
    {
        return new MySalesOrderDao();
    }

    public KmList<MySalesOrder> findAllSalesOrders()
    {
        return getSalesOrderDao().findAll();
    }

    public MySalesOrder findSalesOrderUid(String e)
    {
        return getSalesOrderDao().findUid(e);
    }

    //##################################################
    //# salesOrderContact
    //##################################################

    public MySalesOrderContactDao getSalesOrderContactDao()
    {
        return new MySalesOrderContactDao();
    }

    public KmList<MySalesOrderContact> findAllSalesOrderContacts()
    {
        return getSalesOrderContactDao().findAll();
    }

    public MySalesOrderContact findSalesOrderContactUid(String e)
    {
        return getSalesOrderContactDao().findUid(e);
    }

    //##################################################
    //# salesOrderLine
    //##################################################

    public MySalesOrderLineDao getSalesOrderLineDao()
    {
        return new MySalesOrderLineDao();
    }

    public KmList<MySalesOrderLine> findAllSalesOrderLines()
    {
        return getSalesOrderLineDao().findAll();
    }

    public MySalesOrderLine findSalesOrderLineUid(String e)
    {
        return getSalesOrderLineDao().findUid(e);
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
    //# shipAccount
    //##################################################

    public MyShipAccountDao getShipAccountDao()
    {
        return new MyShipAccountDao();
    }

    public KmList<MyShipAccount> findAllShipAccounts()
    {
        return getShipAccountDao().findAll();
    }

    public MyShipAccount findShipAccountUid(String e)
    {
        return getShipAccountDao().findUid(e);
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
    //# shipment
    //##################################################

    public MyShipmentDao getShipmentDao()
    {
        return new MyShipmentDao();
    }

    public KmList<MyShipment> findAllShipments()
    {
        return getShipmentDao().findAll();
    }

    public MyShipment findShipmentUid(String e)
    {
        return getShipmentDao().findUid(e);
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
