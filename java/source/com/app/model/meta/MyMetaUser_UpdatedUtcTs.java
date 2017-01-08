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

public class MyMetaUser_UpdatedUtcTs
    extends KmMetaTimestampProperty<MyUser>
    implements KmMetaDaoPropertyIF<MyUser,KmTimestamp>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "updatedUtcTs";
    }

    @Override
    public String getLabel()
    {
        return "Updated Utc Ts";
    }

    @Override
    public String getHelp()
    {
        return "The time this record was last updated.";
    }

    @Override
    public int getColumnWidth()
    {
        return 16;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmTimestampValidator getValidator()
    {
        return MyUserValidator.instance.getUpdatedUtcTsValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "updatedUtcTs";
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
    public KmTimestamp getValueFor(MyUser model)
    {
        return model.getUpdatedUtcTs();
    }

    @Override
    public void setValueFor(MyUser model, KmTimestamp value)
    {
        model.setUpdatedUtcTs(value);
    }

    @Override
    public boolean hasValueFor(MyUser model, KmTimestamp value)
    {
        return model.hasUpdatedUtcTs(value);
    }

}
