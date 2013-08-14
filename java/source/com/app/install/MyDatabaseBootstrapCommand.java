package com.app.install;

import com.kodemore.collection.KmList;
import com.kodemore.command.KmDaoCommand;
import com.kodemore.patch.KmPatch;
import com.kodemore.patch.KmPatchBridge;

import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyPatch;
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
        getAccess().getUserDao().createNewRootUser();
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
