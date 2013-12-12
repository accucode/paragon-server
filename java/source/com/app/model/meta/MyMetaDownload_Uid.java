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
import com.kodemore.meta.KmMetaStringProperty;
import com.kodemore.validator.KmStringValidator;

import com.app.dao.MyDownloadDao;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyDownload;
import com.app.model.MyDownloadValidator;
import com.app.utility.MyGlobals;

public class MyMetaDownload_Uid
    extends KmMetaStringProperty<MyDownload>
    implements KmMetaDaoPropertyIF<MyDownload,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "uid";
    }

    @Override
    public String getLabel()
    {
        return "Uid";
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
        return MyDownloadValidator.instance.getUidValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "uid";
    }

    @Override
    public MyDownloadDao getDao()
    {
        return getAccess().getDownloadDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyDownload model)
    {
        return model.getUid();
    }
    
    @Override
    public void setValueFor(MyDownload model, String value)
    {
        model.setUid(value);
    }
    
    @Override
    public boolean hasValueFor(MyDownload model, String value)
    {
        return model.hasUid(value);
    }
    
    @Override
    public int compareValues(MyDownload o1, MyDownload o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
