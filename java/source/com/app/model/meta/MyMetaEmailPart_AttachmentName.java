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
    public String getHelp()
    {
        return null;
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

    private MyDaoAccess getAccess()
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

}
