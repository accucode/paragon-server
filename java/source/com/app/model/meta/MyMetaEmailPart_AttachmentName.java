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

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaDaoPropertyIF;
import com.kodemore.meta.KmMetaStringProperty;
import com.kodemore.validator.KmStringValidator;

public class MyMetaEmailPart_AttachmentName
    extends KmMetaStringProperty<MyEmailPart>
    implements KmMetaDaoPropertyIF<MyEmailPart,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "attachmentName";
    }

    @Override
    public String getLabel()
    {
        return "Attachment Name";
    }

    @Override
    public int getColumnWidth()
    {
        return 15;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmStringValidator getValidator()
    {
        return MyEmailPartValidator.instance.getAttachmentNameValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "attachmentName";
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
    public String getValueFor(MyEmailPart model)
    {
        return model.getAttachmentName();
    }
    
    @Override
    public void setValueFor(MyEmailPart model, String value)
    {
        model.setAttachmentName(value);
    }
    
    @Override
    public boolean hasValueFor(MyEmailPart model, String value)
    {
        return model.hasAttachmentName(value);
    }
    
    @Override
    public int compareValues(MyEmailPart o1, MyEmailPart o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
