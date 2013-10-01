//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.dao.MyEmailDao;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyEmail;
import com.app.model.MyEmailValidator;
import com.app.utility.MyGlobals;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaDaoPropertyIF;
import com.kodemore.meta.KmMetaStringProperty;
import com.kodemore.validator.KmStringValidator;

public class MyMetaEmail_ErrorNotes
    extends KmMetaStringProperty<MyEmail>
    implements KmMetaDaoPropertyIF<MyEmail,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "errorNotes";
    }

    @Override
    public String getLabel()
    {
        return "Error Notes";
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
        return MyEmailValidator.instance.getErrorNotesValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "errorNotes";
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
        return model.getErrorNotes();
    }
    
    @Override
    public void setValueFor(MyEmail model, String value)
    {
        model.setErrorNotes(value);
    }
    
    @Override
    public boolean hasValueFor(MyEmail model, String value)
    {
        return model.hasErrorNotes(value);
    }
    
    @Override
    public int compareValues(MyEmail o1, MyEmail o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
