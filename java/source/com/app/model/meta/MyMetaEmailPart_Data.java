//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.dao.MyEmailPartDao;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyEmailPart;
import com.app.model.MyEmailPartValidator;
import com.app.utility.MyGlobals;

import com.kodemore.collection.KmBlob;
import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaBlobProperty;
import com.kodemore.meta.KmMetaDaoPropertyIF;
import com.kodemore.validator.KmBlobValidator;

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
