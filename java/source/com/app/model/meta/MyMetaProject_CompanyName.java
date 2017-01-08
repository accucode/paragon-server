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

public class MyMetaProject_CompanyName
    extends KmMetaStringProperty<MyProject>
    implements KmMetaDaoPropertyIF<MyProject,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "companyName";
    }

    @Override
    public String getLabel()
    {
        return "Company Name";
    }

    @Override
    public String getHelp()
    {
        return "The name of the company resposible for this project. This may be used on various documents such as emails and pick lists.";
    }

    @Override
    public int getColumnWidth()
    {
        return 15;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmStringValidator getValidator()
    {
        return MyProjectValidator.instance.getCompanyNameValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "companyName";
    }

    @Override
    public MyProjectDao getDao()
    {
        return getAccess().getProjectDao();
    }

    private MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyProject model)
    {
        return model.getCompanyName();
    }

    @Override
    public void setValueFor(MyProject model, String value)
    {
        model.setCompanyName(value);
    }

    @Override
    public boolean hasValueFor(MyProject model, String value)
    {
        return model.hasCompanyName(value);
    }

}
