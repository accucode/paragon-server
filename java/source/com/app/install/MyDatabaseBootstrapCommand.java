package com.app.install;

import com.kodemore.collection.KmList;
import com.kodemore.command.KmDaoCommand;
import com.kodemore.patch.KmPatch;
import com.kodemore.patch.KmPatchBridge;

import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyAttentionGroup;
import com.app.model.MyCategory;
import com.app.model.MyDepot;
import com.app.model.MyMember;
import com.app.model.MyPatch;
import com.app.model.MyPowerType;
import com.app.model.MyProduct;
import com.app.model.MyProject;
import com.app.model.MyRegion;
import com.app.model.MyShipCarrier;
import com.app.model.MySkill;
import com.app.model.MyUser;
import com.app.model.MyUserRole;
import com.app.model.MyVendor;
import com.app.model.MyVisitType;
import com.app.utility.MyGlobals;

public class MyDatabaseBootstrapCommand
    extends KmDaoCommand
{
    //##################################################
    //# handle
    //##################################################

    @Override
    public void handle()
    {
        installSettings();
        installRootUser();
        installExistingPatches();

        installFakeData();
    }

    private void installSettings()
    {
        getAccess().getSettingsDao().installSettings();
    }

    private void installRootUser()
    {
        getAccess().getUserDao().createRootUser();
    }

    private void installExistingPatches()
    {
        KmList<KmPatch> v = KmPatchBridge.getInstance().getLocalPatches();
        for ( KmPatch e : v )
        {
            MyPatch p;
            p = new MyPatch();
            p.setName(e.getName());
            p.setSource(e.getSource());
            p.saveDao();
        }
    }

    //##################################################
    //# fake data
    //##################################################

    private void installFakeData()
    {
        installFakeUsers();
        installFakeProjects();
    }

    protected void installFakeUsers()
    {
        // sample people
        installFakeUser("AJ Love", "alove@accucode.com", MyUserRole.Admin);
        installFakeUser("Wyatt Love", "wlove@accucode.com", MyUserRole.Developer);
        installFakeUser("Ryan Waxler", "rwaxler@accucode.com", MyUserRole.Developer);
        installFakeUser("Kevin Reynolds", "kreynolds@accucode.com", MyUserRole.Admin);

        // sample roles
        installFakeUser("Developer", "developer", MyUserRole.Developer);
        installFakeUser("Admin", "admin", MyUserRole.Admin);
        installFakeUser("Manager", "manager", MyUserRole.Other);
        installFakeUser("Member", "member", MyUserRole.Other);
        installFakeUser("User", "user", MyUserRole.Other);

        //        int n = 1000;
        //        for ( int i = 0; i < n; i++ )
        //        {
        //            String name = "fake" + i;
        //            installFakeUser(name, name + "@accucode.com", MyUserRole.Admin);
        //        }
    }

    private MyUser installFakeUser(String name, String email, MyUserRole role)
    {
        MyUser e;
        e = getAccess().getUserDao().createUser(name, email);
        e.clearPassword();
        e.setRole(role);
        e.setVerified(true);
        return e;
    }

    private void installFakeProjects()
    {
        installFakeProject("Acme Inc");
    }

    private MyProject installFakeProject(String name)
    {
        MyProject e;
        e = new MyProject();
        e.setName(name);
        e.saveDao();

        installFakeDepotsOn(e);
        installFakePowerTypesOn(e);
        installFakeRegionsOn(e);
        installFakeVendorsOn(e);
        installFakeSkillsOn(e);
        installFakeVisitTypesOn(e);
        installFakeAttentionGroupsOn(e);
        installFakeCategoriesOn(e);
        installFakeCarriersOn(e);
        installFakeMembersOn(e);

        return e;
    }

    private void installFakeDepotsOn(MyProject e)
    {
        installFakeDepotOn(e, "Denver");
        installFakeDepotOn(e, "Louisville");
    }

    private MyDepot installFakeDepotOn(MyProject project, String name)
    {
        MyDepot e;
        e = project.addDepot();
        e.setName(name);
        e.validate();
        return e;
    }

    private void installFakeRegionsOn(MyProject e)
    {
        installFakeRegionOn(e, "Domestic");
        installFakeRegionOn(e, "International");
    }

    private MyRegion installFakeRegionOn(MyProject project, String name)
    {
        MyRegion e;
        e = project.addRegion();
        e.setName(name);
        e.validate();
        return e;
    }

    private void installFakeSkillsOn(MyProject e)
    {
        installFakeSkillOn(e, "Accounting");
        installFakeSkillOn(e, "Shipping");
        installFakeSkillOn(e, "Picking");
        installFakeSkillOn(e, "Scheduling");
        installFakeSkillOn(e, "Review");
    }

    private MySkill installFakeSkillOn(MyProject project, String name)
    {
        MySkill e;
        e = project.addSkill();
        e.setName(name);
        e.validate();
        return e;
    }

    private void installFakeAttentionGroupsOn(MyProject e)
    {
        installFakeAttentionGroupOn(e, "Manager");
        installFakeAttentionGroupOn(e, "Engineer");
    }

    private MyAttentionGroup installFakeAttentionGroupOn(MyProject project, String name)
    {
        MyAttentionGroup e;
        e = project.addAttentionGroup();
        e.setName(name);
        e.validate();
        return e;
    }

    private void installFakePowerTypesOn(MyProject e)
    {
        installFakePowerTypeOn(e, "US 120V 60Hz Type-A/B");
        installFakePowerTypeOn(e, "EU 220V 50Hz Type-F");
        installFakePowerTypeOn(e, "UK 220V 50Hz Type-G");
        installFakePowerTypeOn(e, "AU 220V 50Hz Type-I");
    }

    private MyPowerType installFakePowerTypeOn(MyProject project, String name)
    {
        MyPowerType e;
        e = project.addPowerType();
        e.setName(name);
        e.validate();
        return e;
    }

    private void installFakeVendorsOn(MyProject e)
    {
        installFakeVendorOn(e, "Accucode");
        installFakeVendorOn(e, "Netpulse");
        installFakeVendorOn(e, "Meraki");
        installFakeVendorOn(e, "Field Nation");
    }

    private MyVendor installFakeVendorOn(MyProject project, String name)
    {
        MyVendor e;
        e = project.addVendor();
        e.setName(name);
        e.validate();
        return e;
    }

    private void installFakeVisitTypesOn(MyProject e)
    {
        installFakeVisitTypeOn(e, "Survey");
        installFakeVisitTypeOn(e, "Install");
        installFakeVisitTypeOn(e, "Troubleshoot");
    }

    private MyVisitType installFakeVisitTypeOn(MyProject project, String name)
    {
        MyVisitType e;
        e = project.addVisitType();
        e.setName(name);
        e.validate();
        return e;
    }

    private void installFakeCategoriesOn(MyProject e)
    {
        MyCategory category;
        category = installFakeCategoryOn(e, "Access Point");
        installFakeProductOn(category, "Meraki MR12");
        installFakeProductOn(category, "Meraki MR24");

        category = installFakeCategoryOn(e, "Cable");
        installFakeProductOn(category, "10 foot CAT5e patch cable");
        installFakeProductOn(category, "300 foot CAT5e cable");

        category = installFakeCategoryOn(e, "Installation");
        installFakeProductOn(category, "Access Point Installation - First AP");
        installFakeProductOn(category, "Access Point Installation - Additional AP");
        installFakeProductOn(category, "Gateway Installation");

        category = installFakeCategoryOn(e, "Survey");
        installFakeProductOn(category, "Basic Site Survey");
        installFakeProductOn(category, "Advanced Site Survey");
    }

    private MyCategory installFakeCategoryOn(MyProject project, String name)
    {
        MyCategory e;
        e = project.addCategory();
        e.setName(name);
        e.validate();
        return e;
    }

    private MyProduct installFakeProductOn(MyCategory category, String name)
    {
        MyProject project;
        project = category.getProject();

        MyProduct e;
        e = project.addProduct();
        e.setName(name);
        e.setCategory(category);
        e.validate();
        return e;
    }

    private void installFakeCarriersOn(MyProject e)
    {
        installFakeCarrierOn(e, "UPS");
        installFakeCarrierOn(e, "FedEx");
        installFakeCarrierOn(e, "DHL");
    }

    private MyShipCarrier installFakeCarrierOn(MyProject project, String name)
    {
        MyShipCarrier e;
        e = project.addShipCarrier();
        e.setName(name);
        e.validate();

        e.addShipMethod("Red Label");
        e.addShipMethod("2-Day");
        e.addShipMethod("Ground");

        return e;
    }

    private void installFakeMembersOn(MyProject project)
    {
        KmList<MyUser> users = getAccess().findAllUsers();
        for ( MyUser user : users )
        {
            if ( user.hasName("User") )
                continue;

            MyMember e;
            e = project.addMember();
            e.setUser(user);
            e.setRoleWorker();

            if ( e.hasUserName("Manager") )
                e.setRoleManager();
        }
    }

    //##################################################
    //# support
    //##################################################

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
}
