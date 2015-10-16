package com.app.tools;

import com.kodemore.collection.KmList;
import com.kodemore.command.KmDaoRunnableCommand;
import com.kodemore.log.KmLog;

import com.app.dao.base.MyDaoRegistry;
import com.app.install.MyResetDatabaseTool;
import com.app.model.MyAttentionGroup;
import com.app.model.MyDepot;
import com.app.model.MyMasterProduct;
import com.app.model.MyMember;
import com.app.model.MyPowerType;
import com.app.model.MyProduct;
import com.app.model.MyProductCategory;
import com.app.model.MyProject;
import com.app.model.MyRegion;
import com.app.model.MyShipCarrier;
import com.app.model.MyShipMethod;
import com.app.model.MySkill;
import com.app.model.MyUser;
import com.app.model.MyUserRole;
import com.app.model.MyVendor;
import com.app.model.MyVisitType;
import com.app.utility.MyGlobals;
import com.app.utility.MyInstaller;

/**
 * I am used to install sample data for development and testing.
 *
 * This data should only be installed on top of an empty database,
 * and should only be run once.
 *
 * Many of theh samples use specific hardcoded values in order to make
 * the data more realistic and/or familiar.  However, values are NOT
 * compared against existing data which means that attempting to install
 * this sample data on top of an existing database can result in duplicate
 * keys or other problems.
 *
 * This tool is NOT intended to generate bulk data for performance/load testing.
 * If you need large volumes of bulk data...
 * @see MyBulkDataTool
 */
@SuppressWarnings("unused")
public class MySampleDataTool
{
    //##################################################
    //# static
    //##################################################

    public static void run()
    {
        KmDaoRunnableCommand cmd;
        cmd = new KmDaoRunnableCommand();
        cmd.setRunnable(new MySampleDataTool()::install);
        cmd.disableWarningThresholdMs();
        cmd.run();
    }

    //##################################################
    //# variables
    //##################################################

    /**
     * The sample data may include multiple projects, but each project
     * is independent of the others.  The projects are installed separately
     * and this is the project currently being installed.
     */
    private MyProject _project;

    private MyDepot _depotDenver;
    private MyDepot _depotLouisville;

    private MyRegion _regionDomestic;
    private MyRegion _regionInternational;

    private MySkill _skillAccounting;
    private MySkill _skillShipping;
    private MySkill _skillPicking;
    private MySkill _skillScheduling;
    private MySkill _skillReview;

    private MyAttentionGroup _attentionManager;
    private MyAttentionGroup _attentionEngineer;

    private MyPowerType _powerUs;
    private MyPowerType _powerEu;
    private MyPowerType _powerUk;
    private MyPowerType _powerAu;

    private MyVendor _vendorAccucode;
    private MyVendor _vendorNetpulse;
    private MyVendor _vendorMeraki;
    private MyVendor _vendorFieldNation;

    private MyVisitType _visitTypeSurvey;
    private MyVisitType _visitTypeInstall;

    private MyProductCategory _categoryAccessPoint;
    private MyProductCategory _categoryCable;
    private MyProductCategory _categoryInstallation;
    private MyProductCategory _categorySurvey;

    private MyShipCarrier _carrierFedEx;
    private MyShipCarrier _carrierUsps;

    //##################################################
    //# handle
    //##################################################

    private void install()
    {
        log("Install sample data...");

        installUsers();
        installProjects();

        log("Install sample data, ok.");
    }

    private void installUsers()
    {
        log("install users...");

        // sample people
        installUser("AJ Love", "alove@accucode.com", MyUserRole.Admin);
        installUser("Wyatt Love", "wlove@accucode.com", MyUserRole.Developer);
        installUser("Ryan Waxler", "rwaxler@accucode.com", MyUserRole.Developer);
        installUser("Kevin Reynolds", "kreynolds@accucode.com", MyUserRole.Admin);

        // sample roles
        installUser("Developer", "developer", MyUserRole.Developer);
        installUser("Admin", "admin", MyUserRole.Admin);
        installUser("Manager", "manager", MyUserRole.Other);
        installUser("Member", "member", MyUserRole.Other);
        installUser("User", "user", MyUserRole.Other);
    }

    private MyUser installUser(String name, String email, MyUserRole role)
    {
        MyUser e;
        e = getAccess().getUserDao().createUser(name, email);
        e.clearPassword();
        e.setRole(role);
        e.setVerified(true);
        return e;
    }

    private void installProjects()
    {
        log("install projects...");

        installProject("Fitness Rollouts");
        installProject("Discount Tire");
    }

    //##################################################
    //# install project
    //##################################################

    private MyProject installProject(String name)
    {
        String orderPrefix = name.substring(0, 2).toUpperCase();

        MyProject e;
        e = new MyProject();
        e.setName(name);
        e.setOrderNumberPrefix(orderPrefix);
        e.attachDao();

        _project = e;

        installMembers();
        installDepots();
        installPowerTypes();
        installRegions();
        installVendors();
        installSkills();
        installVisitTypes();
        installAttentionGroups();
        installShipCarriers();
        installProductCategories();
        installProducts();

        return e;
    }

    private void installMembers()
    {
        log("install members...");

        KmList<MyUser> users = getAccess().findAllUsers();
        for ( MyUser user : users )
        {
            if ( user.hasName("User") )
                continue;

            MyMember e;
            e = _project.addMember();
            e.setUser(user);
            e.setRoleWorker();

            if ( e.hasUserName("Manager") )
                e.setRoleManager();
        }
    }

    //##################################################
    //# misc
    //##################################################

    private void installDepots()
    {
        log("install depots...");

        MyDepot e;
        e = _project.addDepot();
        e.setName("Denver");
        e.attachDao();
        _depotDenver = e;

        e = _project.addDepot();
        e.setName("Louisville");
        e.attachDao();
        _depotLouisville = e;
    }

    private void installRegions()
    {
        log("install regions...");

        MyRegion e;
        e = _project.addRegion();
        e.setName("Domestic");
        e.attachDao();
        _regionDomestic = e;

        e = _project.addRegion();
        e.setName("International");
        e.attachDao();
        _regionInternational = e;
    }

    private void installSkills()
    {
        log("install skills...");

        MySkill e;
        e = _project.addSkill();
        e.setName("Accounting");
        e.attachDao();
        _skillAccounting = e;

        e = _project.addSkill();
        e.setName("Shipping");
        e.attachDao();
        _skillShipping = e;

        e = _project.addSkill();
        e.setName("Picking");
        e.attachDao();
        _skillPicking = e;

        e = _project.addSkill();
        e.setName("Scheduling");
        e.attachDao();
        _skillScheduling = e;

        e = _project.addSkill();
        e.setName("Review");
        e.attachDao();
        _skillReview = e;
    }

    private void installAttentionGroups()
    {
        log("install attention groups...");

        MyAttentionGroup e;
        e = _project.addAttentionGroup();
        e.setName("Manager");
        _attentionManager = e;

        e = _project.addAttentionGroup();
        e.setName("Engineer");
        _attentionEngineer = e;
    }

    private void installPowerTypes()
    {
        log("install power types...");

        MyPowerType e;
        e = _project.addPowerType();
        e.setName("US 120V 60Hz Type-A/B");
        e.attachDao();
        _powerUs = e;

        e = _project.addPowerType();
        e.setName("EU 220V 50Hz Type-F");
        e.attachDao();
        _powerEu = e;

        e = _project.addPowerType();
        e.setName("UK 220V 50Hz Type-G");
        e.attachDao();
        _powerUk = e;

        e = _project.addPowerType();
        e.setName("AU 220V 50Hz Type-I");
        e.attachDao();
        _powerAu = e;
    }

    private void installVendors()
    {
        log("install vendors...");

        MyVendor e;
        e = _project.addVendor();
        e.setName("Accucode");
        e.attachDao();
        _vendorAccucode = e;

        e = _project.addVendor();
        e.setName("Netpulse");
        e.attachDao();
        _vendorNetpulse = e;

        e = _project.addVendor();
        e.setName("Meraki");
        e.attachDao();
        _vendorMeraki = e;

        e = _project.addVendor();
        e.setName("Field Nation");
        e.attachDao();
        _vendorFieldNation = e;
    }

    private void installVisitTypes()
    {
        log("install visit types...");

        MyVisitType e;
        e = _project.addVisitType();
        e.setName("Survey");
        e.attachDao();
        _visitTypeSurvey = e;

        e = _project.addVisitType();
        e.setName("Install");
        e.attachDao();
        _visitTypeInstall = e;
    }
    //==================================================
    //= shipping
    //==================================================

    private void installShipCarriers()
    {
        log("install ship carriers...");

        installShipCarrierUsps();
        installShipCarrierFedEx();
    }

    private void installShipCarrierUsps()
    {
        MyShipCarrier c;
        c = _project.addShipCarrier();
        c.setName("USPS");
        c.attachDao();
        _carrierUsps = c;

        MyShipMethod m;
        m = c.addShipMethod();
        m.setName("Priority");
        m.attachDao();

        m = c.addShipMethod();
        m.setName("Standard");
        m.attachDao();
    }

    private void installShipCarrierFedEx()
    {
        MyShipCarrier c;
        c = _project.addShipCarrier();
        c.setName("FedEx");
        c.attachDao();
        _carrierFedEx = c;

        MyShipMethod m;
        m = c.addShipMethod();
        m.setName("Red Label");
        m.attachDao();

        m = c.addShipMethod();
        m.setName("Next Day");
        m.attachDao();

        m = c.addShipMethod();
        m.setName("Ground");
        m.attachDao();
    }

    //##################################################
    //# products
    //##################################################

    private void installProductCategories()
    {
        log("install product categories...");

        MyProductCategory e;
        e = _project.addProductCategory();
        e.setName("Access Point");
        e.attachDao();
        _categoryAccessPoint = e;

        e = _project.addProductCategory();
        e.setName("Cable");
        e.attachDao();
        _categoryCable = e;

        e = _project.addProductCategory();
        e.setName("Survey");
        e.attachDao();
        _categorySurvey = e;

        e = _project.addProductCategory();
        e.setName("Installation");
        e.attachDao();
        _categoryInstallation = e;
    }

    private void installProducts()
    {
        log("install products...");

        installProductMr12();
        installProductMr24();

        installProductCable10ft();
        installProductCable300ft();

        installProductAP1();
        installProductAP2();
        installProductGateway();

        installProductBasicSurvey();
        installProductAdvancedSurvey();
    }

    private void installProductMr12()
    {
        log("install product MR12...");

        MyMasterProduct m;
        m = _project.addMasterProduct();
        m.setPartNumber("MER-MR12");
        m.attachDao();

        MyProduct d;
        d = m.addDraft();
        d.setName("Meraki MR12");
        d.setCategory(_categoryAccessPoint);
        d.attachDao();
        d.publish();
    }

    private void installProductMr24()
    {
        log("install product MR24...");

        MyMasterProduct m;
        m = _project.addMasterProduct();
        m.setPartNumber("MER-MR24");
        m.attachDao();

        MyProduct d;
        d = m.addDraft();
        d.setName("Meraki MR24");
        d.setCategory(_categoryAccessPoint);
        d.attachDao();
        d.publish();
    }

    private void installProductCable10ft()
    {
        log("install product cable 10ft...");

        MyMasterProduct m;
        m = _project.addMasterProduct();
        m.setPartNumber("CAB-CAT5E-10");
        m.attachDao();

        MyProduct d;
        d = m.addDraft();
        d.setName("10 foot CAT5e patch cable");
        d.setCategory(_categoryCable);
        d.attachDao();
        d.publish();
    }

    private void installProductCable300ft()
    {
        log("install product cable 300ft...");

        MyMasterProduct m;
        m = _project.addMasterProduct();
        m.setPartNumber("CAB-CAT5E-300");
        m.attachDao();

        MyProduct d;
        d = m.addDraft();
        d.setName("300 foot CAT5e patch cable");
        d.setCategory(_categoryCable);
        d.attachDao();
        d.publish();
    }

    private void installProductAP1()
    {
        log("install product, AP1 installation...");

        MyMasterProduct m;
        m = _project.addMasterProduct();
        m.setPartNumber("INST-FAP");
        m.attachDao();

        MyProduct d;
        d = m.addDraft();
        d.setName("Access Point Installation - First AP");
        d.setCategory(_categoryInstallation);
        d.attachDao();
        d.publish();
    }

    private void installProductAP2()
    {
        log("install product, AP2 installation...");

        MyMasterProduct m;
        m = _project.addMasterProduct();
        m.setPartNumber("INST-AAP");
        m.attachDao();

        MyProduct d;
        d = m.addDraft();
        d.setName("Access Point Installation - Additional AP");
        d.setCategory(_categoryInstallation);
        d.attachDao();
        d.publish();
    }

    private void installProductGateway()
    {
        log("install product gateway installation...");

        MyMasterProduct m;
        m = _project.addMasterProduct();
        m.setPartNumber("INST-GW");
        m.attachDao();

        MyProduct d;
        d = m.addDraft();
        d.setName("Gateway Installation");
        d.setCategory(_categoryInstallation);
        d.attachDao();
        d.publish();
    }

    private void installProductBasicSurvey()
    {
        log("install product basic survey...");

        MyMasterProduct m;
        m = _project.addMasterProduct();
        m.setPartNumber("SUR-BASIC");
        m.attachDao();

        MyProduct d;
        d = m.addDraft();
        d.setName("Basic Site Survey");
        d.setCategory(_categorySurvey);
        d.attachDao();
        d.publish();
    }

    private void installProductAdvancedSurvey()
    {
        log("install product advanced survey...");

        MyMasterProduct m;
        m = _project.addMasterProduct();
        m.setPartNumber("SUR-ADV");
        m.attachDao();

        MyProduct d;
        d = m.addDraft();
        d.setName("Advanced Site Survey");
        d.setCategory(_categorySurvey);
        d.attachDao();
        d.publish();
    }

    //##################################################
    //# support
    //##################################################

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }

    private void log(String msg, Object... args)
    {
        KmLog.printfln(msg, args);
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        printHeader("Install Database...");
        MyInstaller.installDatabase();

        printHeader("Reset Database...");
        MyResetDatabaseTool.run();

        printHeader("Sample Data...");
        MySampleDataTool.run();

        printHeader("Done.");
    }

    public static void printHeader(String s)
    {
        System.out.println();
        System.out.printf("=====  %s  ===============================================%n", s);
    }
}
