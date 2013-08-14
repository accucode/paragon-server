package com.app.install;

import com.kodemore.collection.KmList;
import com.kodemore.command.KmDaoCommand;
import com.kodemore.patch.KmPatch;
import com.kodemore.patch.KmPatchBridge;

import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyAccount;
import com.app.model.MyAccountUser;
import com.app.model.MyPatch;
import com.app.model.MyUser;
import com.app.utility.MyGlobals;

public class MyDatabaseBootstrapCommand
    extends KmDaoCommand
{
    @Override
    public void handle()
    {
        installSettings();
        installRootUser();
        installExistingPatches();
    }

    private void installSettings()
    {
        getAccess().getSettingsDao().installSettings();
    }

    private void installRootUser()
    {
        MyUser u;
        u = new MyUser();
        u.setUid(MyUser.ROOT_UID);
        u.setRoleDeveloper();
        u.setEmail("root");
        u.setPassword(null);
        u.setName("Root");
        u.setVerified(true);
        u.saveDao();

        MyAccount a;
        a = new MyAccount();
        a.setUid(MyAccount.ROOT_UID);
        a.setName("Personal");
        a.setTypePersonal();
        a.saveDao();

        MyAccountUser au;
        au = a.addAccountUser();
        au.setUser(u);
        au.setRoleOwner();
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

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }

}
