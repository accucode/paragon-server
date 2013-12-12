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

import com.app.dao.MyPatchDao;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyPatch;
import com.app.model.MyPatchValidator;
import com.app.utility.MyGlobals;

public class MyMetaPatch_Source
    extends KmMetaStringProperty<MyPatch>
    implements KmMetaDaoPropertyIF<MyPatch,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "source";
    }

    @Override
    public String getLabel()
    {
        return "Source";
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
        return MyPatchValidator.instance.getSourceValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "source";
    }

    @Override
    public MyPatchDao getDao()
    {
        return getAccess().getPatchDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyPatch model)
    {
        return model.getSource();
    }
    
    @Override
    public void setValueFor(MyPatch model, String value)
    {
        model.setSource(value);
    }
    
    @Override
    public boolean hasValueFor(MyPatch model, String value)
    {
        return model.hasSource(value);
    }
    
    @Override
    public int compareValues(MyPatch o1, MyPatch o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
