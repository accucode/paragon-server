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

import com.app.dao.MyEmailDao;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyEmail;
import com.app.model.MyEmailValidator;
import com.app.utility.MyGlobals;

public class MyMetaEmail_Subject
    extends KmMetaStringProperty<MyEmail>
    implements KmMetaDaoPropertyIF<MyEmail,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "subject";
    }

    @Override
    public String getLabel()
    {
        return "Subject";
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
        return MyEmailValidator.instance.getSubjectValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "subject";
    }

    @Override
    public MyEmailDao getDao()
    {
        return getAccess().getEmailDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyEmail model)
    {
        return model.getSubject();
    }
    
    @Override
    public void setValueFor(MyEmail model, String value)
    {
        model.setSubject(value);
    }
    
    @Override
    public boolean hasValueFor(MyEmail model, String value)
    {
        return model.hasSubject(value);
    }
    
    @Override
    public int compareValues(MyEmail o1, MyEmail o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
