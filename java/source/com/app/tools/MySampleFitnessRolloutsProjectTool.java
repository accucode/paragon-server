package com.app.tools;

import com.kodemore.collection.KmList;
import com.kodemore.log.KmLog;

import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyAttentionGroup;
import com.app.model.MyCustomer;
import com.app.model.MyCustomerContact;
import com.app.model.MyCustomerSite;
import com.app.model.MyCustomerTier;
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
import com.app.model.MyVendor;
import com.app.model.MyVisitType;
import com.app.utility.MyGlobals;

/**
 * I am used to install a sample project similar to Fitness Rollouts
 */
// low_wyatt: fix unused
@SuppressWarnings("unused")
public class MySampleFitnessRolloutsProjectTool
{
    //##################################################
    //# static
    //##################################################

    public static void run(int num)
    {
        new MySampleFitnessRolloutsProjectTool().install(num);
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

    private MyAttentionGroup _attentionManager;
    private MyAttentionGroup _attentionAccounting;

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
    private MyProductCategory _categoryOther;

    private MyShipCarrier _carrierFedEx;
    private MyShipCarrier _carrierUsps;

    private MyCustomerTier _tierOem;
    private MyCustomerTier _tierReseller;
    private MyCustomerTier _tierEndUser;

    private MyCustomer _customerLifeFitness;
    private MyCustomer _customerFitMax;
    private MyCustomer _customerMainStreetGym;

    private MyUser _userMandy;
    private MyUser _userMason;
    private MyUser _userPatrick;
    private MyUser _userPenny;
    private MyUser _userShelly;
    private MyUser _userAlan;
    private MyUser _userAgnus;

    private MyProduct _productMeraki12;
    private MyProduct _productMeraki24;
    private MyProduct _productCable10;
    private MyProduct _productCable300;
    private MyProduct _productFirstApInstallation;
    private MyProduct _productAdditionalApInstallation;
    private MyProduct _productGateway;
    private MyProduct _productGatewayInstallation;
    private MyProduct _productBasicSurvey;
    private MyProduct _productAdvancedSurvey;

    //##################################################
    //# constructor
    //##################################################

    private MySampleFitnessRolloutsProjectTool()
    {
        // private
    }

    //##################################################
    //# handle
    //##################################################

    private void install(int num)
    {
        installProject(num);

        installDepots();
        installSkills();
        installUsers();
        installMembers();
        installPowerTypes();
        installRegions();
        installVendors();
        installVisitTypes();
        installShipCarriers();

        installProductCategories();
        installProducts();

        installCustomerTiers();
        installCustomers();
    }

    //##################################################
    //# install project
    //##################################################

    private void installProject(int num)
    {
        String name = "Fitness Rollouts" + " " + num;
        String prefix = "FR" + num;

        MyProject e;
        e = new MyProject();
        e.setName(name);
        e.setOrderNumberPrefix(prefix);
        e.attachDao();
        _project = e;
    }

    //##################################################
    //# users
    //##################################################

    private void installUsers()
    {
        // Users are global (NOT project specific) so care must be
        // taken to use a lazy fetch.

        _userMandy = lazyFindUserName("Mandy Manager");
        _userMason = lazyFindUserName("Mason Manager");

        _userPatrick = lazyFindUserName("Patrick Picker");
        _userPenny = lazyFindUserName("Penny Picker");

        _userShelly = lazyFindUserName("Shelly Shipper");

        _userAlan = lazyFindUserName("Alan Accounting");
        _userAgnus = lazyFindUserName("Agnus Accounting");
    }

    private MyUser lazyFindUserName(String name)
    {
        KmList<MyUser> v;
        v = getAccess().getUserDao().findName(name);
        v.sortOn(x -> x.getUid());

        if ( v.isNotEmpty() )
            return v.getFirst();

        return createUser(name);
    }

    private MyUser createUser(String name)
    {
        MyUser e;
        e = new MyUser();
        e.setName(name);
        e.setEmail(name + "@accucodeXXX.com");
        e.clearPassword();
        e.setRoleOther();
        e.setVerified(true);
        e.attachDao();
        return e;
    }

    //##################################################
    //# members
    //##################################################

    private void installMembers()
    {
        log("install members...");

        // mandy
        MyMember m;
        m = _project.addMember();
        m.setUser(_userMandy);
        m.setRoleManager();
        m.addSkill(_skillShipping);
        m.addSkill(_skillPicking);
        m.attachDao();

        // mason
        m = _project.addMember();
        m.setUser(_userMason);
        m.setRoleManager();
        m.addSkill(_skillShipping);
        m.addSkill(_skillPicking);
        m.attachDao();

        // patrick
        m = _project.addMember();
        m.setUser(_userPatrick);
        m.setRoleWorker();
        m.addSkill(_skillPicking);
        m.attachDao();

        m = _project.addMember();
        m.setUser(_userPenny);
        m.setRoleWorker();
        m.addSkill(_skillPicking);
        m.attachDao();

        m = _project.addMember();
        m.setUser(_userShelly);
        m.setRoleWorker();
        m.addSkill(_skillShipping);
        m.addSkill(_skillPicking);
        m.attachDao();

        m = _project.addMember();
        m.setUser(_userAlan);
        m.setRoleWorker();
        m.addSkill(_skillAccounting);
        m.attachDao();

        m = _project.addMember();
        m.setUser(_userAgnus);
        m.setRoleWorker();
        m.addSkill(_skillAccounting);
        m.attachDao();
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

    //##################################################
    //# shipping
    //##################################################

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

        e = _project.addProductCategory();
        e.setName("Other");
        e.attachDao();
        _categoryOther = e;
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
        installProductGatewayInstallation();

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

        MyProduct p;
        p = m.addDraft();
        p.setName("Meraki MR12");
        p.setCategory(_categoryAccessPoint);
        p.setListPrice(500.00);
        p.attachDao();
        p.publish();

        _productMeraki12 = p;
    }

    private void installProductMr24()
    {
        log("install product MR24...");

        MyMasterProduct m;
        m = _project.addMasterProduct();
        m.setPartNumber("MER-MR24");
        m.attachDao();

        MyProduct p;
        p = m.addDraft();
        p.setName("Meraki MR24");
        p.setCategory(_categoryAccessPoint);
        p.setListPrice(1200.00);
        p.attachDao();
        p.publish();

        _productMeraki24 = p;
    }

    private void installProductCable10ft()
    {
        log("install product cable 10ft...");

        MyMasterProduct m;
        m = _project.addMasterProduct();
        m.setPartNumber("CAB-CAT5E-10");
        m.attachDao();

        MyProduct p;
        p = m.addDraft();
        p.setName("10 foot CAT5e patch cable");
        p.setCategory(_categoryCable);
        p.setListPrice(20.00);
        p.attachDao();
        p.publish();

        _productCable10 = p;
    }

    private void installProductCable300ft()
    {
        log("install product cable 300ft...");

        MyMasterProduct m;
        m = _project.addMasterProduct();
        m.setPartNumber("CAB-CAT5E-300");
        m.attachDao();

        MyProduct p;
        p = m.addDraft();
        p.setName("300 foot CAT5e patch cable");
        p.setCategory(_categoryCable);
        p.setListPrice(100.00);
        p.attachDao();
        p.publish();

        _productCable300 = p;
    }

    private void installProductAP1()
    {
        log("install product, AP1 installation...");

        MyMasterProduct m;
        m = _project.addMasterProduct();
        m.setPartNumber("INST-FAP");
        m.attachDao();

        MyProduct p;
        p = m.addDraft();
        p.setName("Access Point Installation - First AP");
        p.setCategory(_categoryInstallation);
        p.setListPrice(400.00);
        p.attachDao();
        p.publish();

        _productFirstApInstallation = p;
    }

    private void installProductAP2()
    {
        log("install product, AP2 installation...");

        MyMasterProduct m;
        m = _project.addMasterProduct();
        m.setPartNumber("INST-AAP");
        m.attachDao();

        MyProduct p;
        p = m.addDraft();
        p.setName("Access Point Installation - Additional AP");
        p.setCategory(_categoryInstallation);
        p.setListPrice(250.00);
        p.attachDao();
        p.publish();

        _productAdditionalApInstallation = p;
    }

    private void installProductGateway()
    {
        log("install product Gateway...");

        MyMasterProduct m;
        m = _project.addMasterProduct();
        m.setPartNumber("GW");
        m.attachDao();

        MyProduct p;
        p = m.addDraft();
        p.setName("Gateway");
        p.setCategory(_categoryOther);
        p.setListPrice(800.00);
        p.attachDao();
        p.publish();

        _productGateway = p;
    }

    private void installProductGatewayInstallation()
    {
        log("install product gateway installation...");

        MyMasterProduct m;
        m = _project.addMasterProduct();
        m.setPartNumber("INST-GW");
        m.attachDao();

        MyProduct p;
        p = m.addDraft();
        p.setName("Gateway Installation");
        p.setCategory(_categoryInstallation);
        p.setListPrice(200.00);
        p.attachDao();
        p.publish();

        _productGatewayInstallation = p;
    }

    private void installProductBasicSurvey()
    {
        log("install product basic survey...");

        MyMasterProduct m;
        m = _project.addMasterProduct();
        m.setPartNumber("SUR-BASIC");
        m.attachDao();

        MyProduct p;
        p = m.addDraft();
        p.setName("Basic Site Survey");
        p.setCategory(_categorySurvey);
        p.setListPrice(350.00);
        p.attachDao();
        p.publish();

        _productBasicSurvey = p;
    }

    private void installProductAdvancedSurvey()
    {
        log("install product advanced survey...");

        MyMasterProduct m;
        m = _project.addMasterProduct();
        m.setPartNumber("SUR-ADV");
        m.attachDao();

        MyProduct p;
        p = m.addDraft();
        p.setName("Advanced Site Survey");
        p.setCategory(_categorySurvey);
        p.setListPrice(600.00);
        p.attachDao();
        p.publish();

        _productAdvancedSurvey = p;
    }

    //##################################################
    //# customer tiers
    //##################################################

    private void installCustomerTiers()
    {
        MyCustomerTier e;

        e = _project.addCustomerTier();
        e.setName("OEM");
        e.setDiscountRate(0.5);
        _tierOem = e;

        e = _project.addCustomerTier();
        e.setName("Reseller");
        e.setDiscountRate(0.25);
        _tierReseller = e;

        e = _project.addCustomerTier();
        e.setName("End User");
        e.setDiscountRate(0.0);
        _tierEndUser = e;
    }

    private void installCustomers()
    {
        installCustomerLifeFitness();
        installCustomerFitMax();
        installCustomerMainStreetGym();
    }

    private void installCustomerLifeFitness()
    {
        MyCustomer cust;
        cust = _project.addCustomer();
        cust.setName("Life Fitness");
        cust.setTier(_tierOem);
        cust.setDiscountRate(cust.getTier().getDiscountRate());
        cust.attachDao();
        _customerLifeFitness = cust;

        MyCustomerContact cc;
        cc = cust.addContact();
        cc.setName("Lucy");
        cc.setTitle("Director of Operations");
        cc.setEmail("lucy@lifeFitnessXXX.com");

        cc = cust.addContact();
        cc.setName("Larry");
        cc.setTitle("Sales Manager");
        cc.setEmail("larry@lifeFitnessXXX.com");

        MyCustomerSite site;
        site = cust.addSite();
        site.setAddressStreet1("123 Apple Tree Road");
        site.setAddressCity("Denver");
        site.setAddressRegion("CO");
        site.setAddressPostalCode("80123");
        site.setAddressCountry("USA");
        site.setName("Apple Core Gym");

        site = cust.addSite();
        site.setAddressStreet1("456 Grape Vine Street");
        site.setAddressCity("Denver");
        site.setAddressRegion("CO");
        site.setAddressPostalCode("80222");
        site.setAddressCountry("USA");
        site.setName("Grape Seed Gym");
    }

    private void installCustomerFitMax()
    {
        MyCustomer e;
        e = _project.addCustomer();
        e.setName("Fit Max");
        e.setTier(_tierReseller);
        e.setDiscountRate(e.getTier().getDiscountRate());
        e.attachDao();
        _customerFitMax = e;
    }

    private void installCustomerMainStreetGym()
    {
        MyCustomer e;
        e = _project.addCustomer();
        e.setName("Main Street Gym");
        e.setTier(_tierEndUser);
        e.setDiscountRate(e.getTier().getDiscountRate());
        e.attachDao();
        _customerMainStreetGym = e;
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
        MySampleDataTool.main(args);
    }
}
