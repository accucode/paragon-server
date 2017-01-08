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

public class MyMetaUser_DashboardPanelCodeF
    extends KmMetaStringProperty<MyUser>
    implements KmMetaDaoPropertyIF<MyUser,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "dashboardPanelCodeF";
    }

    @Override
    public String getLabel()
    {
        return "Dashboard Panel CodeF";
    }

    @Override
    public String getHelp()
    {
        return "The panel to display in position F.";
    }

    @Override
    public int getColumnWidth()
    {
        return 20;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmStringValidator getValidator()
    {
        return MyUserValidator.instance.getDashboardPanelCodeFValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "dashboardPanelCodeF";
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
    public String getValueFor(MyUser model)
    {
        return model.getDashboardPanelCodeF();
    }

    @Override
    public void setValueFor(MyUser model, String value)
    {
        model.setDashboardPanelCodeF(value);
    }

    @Override
    public boolean hasValueFor(MyUser model, String value)
    {
        return model.hasDashboardPanelCodeF(value);
    }

}
