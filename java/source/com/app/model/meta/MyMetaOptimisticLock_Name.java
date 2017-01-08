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

public class MyMetaOptimisticLock_Name
    extends KmMetaStringProperty<MyOptimisticLock>
    implements KmMetaDaoPropertyIF<MyOptimisticLock,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "name";
    }

    @Override
    public String getLabel()
    {
        return "Name";
    }

    @Override
    public String getHelp()
    {
        return "The unique 'natural' key.  This can be whatever the client wants. In theory, all clients could use a single record/key to coordinate ALL optimistic locks, but this is a poor design with limited scalability. Instead, clients should try to choose keys that minimize unnecessary collisions.";
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
        return MyOptimisticLockValidator.instance.getNameValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "name";
    }

    @Override
    public MyOptimisticLockDao getDao()
    {
        return getAccess().getOptimisticLockDao();
    }

    private MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyOptimisticLock model)
    {
        return model.getName();
    }

    @Override
    public void setValueFor(MyOptimisticLock model, String value)
    {
        model.setName(value);
    }

    @Override
    public boolean hasValueFor(MyOptimisticLock model, String value)
    {
        return model.hasName(value);
    }

}
