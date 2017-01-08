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

public class MyMetaProject_Code
    extends KmMetaStringProperty<MyProject>
    implements KmMetaDaoPropertyIF<MyProject,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "code";
    }

    @Override
    public String getLabel()
    {
        return "Code";
    }

    @Override
    public String getHelp()
    {
        return "The unique code that identifies this project.\n Also, this code is used as a prefix for various numbers within the project. For example: sales orders and tickets.\n The code can be modified, but this is generally not recommended. Preexisting numbers are NOT updated when the code is updated and this can result in long confusion long term.";
    }

    @Override
    public int getColumnWidth()
    {
        return 5;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmStringValidator getValidator()
    {
        return MyProjectValidator.instance.getCodeValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "code";
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
        return model.getCode();
    }

    @Override
    public void setValueFor(MyProject model, String value)
    {
        model.setCode(value);
    }

    @Override
    public boolean hasValueFor(MyProject model, String value)
    {
        return model.hasCode(value);
    }

}
