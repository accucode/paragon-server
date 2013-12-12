//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaDaoPropertyIF;
import com.kodemore.meta.KmMetaIntegerProperty;
import com.kodemore.validator.KmIntegerValidator;

import com.app.dao.MyFileDao;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyFile;
import com.app.model.MyFileValidator;
import com.app.utility.MyGlobals;

public class MyMetaFile_PartialSize
    extends KmMetaIntegerProperty<MyFile>
    implements KmMetaDaoPropertyIF<MyFile,Integer>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "partialSize";
    }

    @Override
    public String getLabel()
    {
        return "Partial Size";
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
        return MyFileValidator.instance.getPartialSizeValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "partialSize";
    }

    @Override
    public MyFileDao getDao()
    {
        return getAccess().getFileDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public Integer getValueFor(MyFile model)
    {
        return model.getPartialSize();
    }
    
    @Override
    public void setValueFor(MyFile model, Integer value)
    {
        model.setPartialSize(value);
    }
    
    @Override
    public boolean hasValueFor(MyFile model, Integer value)
    {
        return model.hasPartialSize(value);
    }
    
    @Override
    public int compareValues(MyFile o1, MyFile o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
