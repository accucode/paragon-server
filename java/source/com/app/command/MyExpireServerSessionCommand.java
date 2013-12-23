package com.app.command;

import com.kodemore.command.KmDaoCommand;

import com.app.dao.base.MyDaoRegistry;
import com.app.utility.MyGlobals;

public class MyExpireServerSessionCommand
    extends KmDaoCommand
{
    //##################################################
    //# variables (input)
    //##################################################

    private String _uid;

    //##################################################
    //# accessing (input)
    //##################################################

    public String getUid()
    {
        return _uid;
    }

    public void setUid(String e)
    {
        _uid = e;
    }

    //##################################################
    //# run
    //##################################################

    @Override
    public void handle()
    {
        getAccess().getServerSessionDao().deleteUid(_uid);
    }

    //##################################################
    //# support
    //##################################################

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }

}
