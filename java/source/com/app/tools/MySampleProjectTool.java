package com.app.tools;

import com.kodemore.collection.KmCollection;
import com.kodemore.collection.KmList;
import com.kodemore.log.KmLog;

import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyDepot;
import com.app.model.MyMember;
import com.app.model.MyProject;
import com.app.model.MyRegion;
import com.app.model.MySkill;
import com.app.model.MyUser;
import com.app.model.MyVendor;
import com.app.utility.MyGlobals;

/**
 * I am used to install a sample project similar to Fitness Rollouts
 */
@SuppressWarnings("unused")
public class MySampleProjectTool
{
    //##################################################
    //# static
    //##################################################

    public static void run(int num)
    {
        new MySampleProjectTool().install(num);
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

    private MyVendor _vendorAccucode;
    private MyVendor _vendorNetpulse;
    private MyVendor _vendorMeraki;
    private MyVendor _vendorFieldNation;

    private MyUser _userRoot;
    private MyUser _userMandy;
    private MyUser _userMason;
    private MyUser _userPatrick;
    private MyUser _userPenny;
    private MyUser _userShelly;
    private MyUser _userAlan;
    private MyUser _userAgnus;

    //##################################################
    //# constructor
    //##################################################

    private MySampleProjectTool()
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
        installRegions();
        installVendors();
    }

    //##################################################
    //# install project
    //##################################################

    private void installProject(int num)
    {
        String name = "Project " + num;
        String prefix = "PR" + num;

        MyProject e;
        e = new MyProject();
        e.setName(name);
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

        _userRoot = findUserName("Root");

        _userMandy = lazyFindUserName("Mandy Manager");
        _userMason = lazyFindUserName("Mason Manager");

        _userPatrick = lazyFindUserName("Patrick Picker");
        _userPenny = lazyFindUserName("Penny Picker");

        _userShelly = lazyFindUserName("Shelly Shipper");

        _userAlan = lazyFindUserName("Alan Accounting");
        _userAgnus = lazyFindUserName("Agnus Accounting");
    }

    private MyUser findUserName(String name)
    {
        return getAccess().getUserDao().findName(name).getFirst();
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

        KmCollection<MySkill> allSkills = _project.getSkills();

        // root
        MyMember m;
        m = _project.addMember();
        m.setUser(_userRoot);
        m.setRoleManager();
        for ( MySkill skill : allSkills )
            m.addSkill(skill);
        m.attachDao();

        // mandy
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
