//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.dao.MyFileDao;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyFile;
import com.app.model.MyFileValidator;
import com.app.utility.MyGlobals;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaDaoPropertyIF;
import com.kodemore.meta.KmMetaStringProperty;
import com.kodemore.validator.KmStringValidator;

public class MyMetaFile_Path
    extends KmMetaStringProperty<MyFile>
    implements KmMetaDaoPropertyIF<MyFile,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "path";
    }

    @Override
    public String getLabel()
    {
        return "Path";
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
        return MyFileValidator.instance.getPathValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "path";
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
    public String getValueFor(MyFile model)
    {
        return model.getPath();
    }
    
    @Override
    public void setValueFor(MyFile model, String value)
    {
        model.setPath(value);
    }
    
    @Override
    public boolean hasValueFor(MyFile model, String value)
    {
        return model.hasPath(value);
    }
    
    @Override
    public int compareValues(MyFile o1, MyFile o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
