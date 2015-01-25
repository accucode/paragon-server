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
import com.kodemore.comparator.*;
import com.kodemore.exception.*;
import com.kodemore.match.*;
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
import com.app.model.core.*;
import com.app.utility.*;

public class MyMetaEmailPart_Data
    extends KmMetaBlobProperty<MyEmailPart>
    implements KmMetaDaoPropertyIF<MyEmailPart,KmBlob>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "data";
    }

    @Override
    public String getLabel()
    {
        return "Data";
    }

    @Override
    public String getHelp()
    {
        return null;
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
    public KmBlobValidator getValidator()
    {
        return MyEmailPartValidator.instance.getDataValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "data";
    }

    @Override
    public MyEmailPartDao getDao()
    {
        return getAccess().getEmailPartDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public KmBlob getValueFor(MyEmailPart model)
    {
        return model.getData();
    }
    
    @Override
    public void setValueFor(MyEmailPart model, KmBlob value)
    {
        model.setData(value);
    }
    
    @Override
    public boolean hasValueFor(MyEmailPart model, KmBlob value)
    {
        return model.hasData(value);
    }
    
    @Override
    public int compareValues(MyEmailPart o1, MyEmailPart o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
