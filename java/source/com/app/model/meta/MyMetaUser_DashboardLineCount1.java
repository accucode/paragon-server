//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import java.util.*;

import com.kodemore.adaptor.*;
import com.kodemore.collection.*;
import com.kodemore.exception.*;
import com.kodemore.meta.*;
import com.kodemore.servlet.encoder.*;
import com.kodemore.servlet.field.*;
import com.kodemore.time.*;
import com.kodemore.types.*;
import com.kodemore.utility.*;
import com.kodemore.validator.*;

import com.app.dao.*;
import com.app.dao.base.*;
import com.app.model.*;
import com.app.model.base.*;
import com.app.model.core.*;
import com.app.utility.*;

public class MyMetaUser_DashboardLineCount1
    extends KmMetaIntegerProperty<MyUser>
    implements KmMetaDaoPropertyIF<MyUser,Integer>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "dashboardLineCount1";
    }

    @Override
    public String getLabel()
    {
        return "Dashboard Line Count1";
    }

    @Override
    public String getHelp()
    {
        return "The number of panels to display on the first line, 0-3.";
    }

    @Override
    public int getColumnWidth()
    {
        return 10;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmIntegerValidator getValidator()
    {
        return MyUserValidator.instance.getDashboardLineCount1Validator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "dashboardLineCount1";
    }

    @Override
    public MyUserDao getDao()
    {
        return getAccess().getUserDao();
    }

    private MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public Integer getValueFor(MyUser model)
    {
        return model.getDashboardLineCount1();
    }

    @Override
    public void setValueFor(MyUser model, Integer value)
    {
        model.setDashboardLineCount1(value);
    }

    @Override
    public boolean hasValueFor(MyUser model, Integer value)
    {
        return model.hasDashboardLineCount1(value);
    }

}
