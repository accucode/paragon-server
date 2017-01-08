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

public class MyMetaFile_StatusCode
    extends KmMetaStringProperty<MyFile>
    implements KmMetaDaoPropertyIF<MyFile,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "statusCode";
    }

    @Override
    public String getLabel()
    {
        return "Status Code";
    }

    @Override
    public String getHelp()
    {
        return "The status of the file. New: being created, should not use yet. Ready: Available for use; should not not edit. Deleted: The file has been deleted from the file system.";
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
        return MyFileValidator.instance.getStatusCodeValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "statusCode";
    }

    @Override
    public MyFileDao getDao()
    {
        return getAccess().getFileDao();
    }

    private MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

    //##################################################
    //# enum
    //##################################################

    public ScEnumDropdownField newDropdown()
    {
        return newDropdown(getLabel());
    }

    public ScEnumDropdownField newDropdown(String label)
    {
        ScEnumDropdownField e;
        e = new ScEnumDropdownField();
        e.setLabel(label);
        e.setHelp(getHelp());
        e.setValidator(getValidator());
        e.setValueAdaptor(this);
        e.addOptions(MyFileStatus.values());
        return e;
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyFile model)
    {
        return model.getStatusCode();
    }

    @Override
    public void setValueFor(MyFile model, String value)
    {
        model.setStatusCode(value);
    }

    @Override
    public boolean hasValueFor(MyFile model, String value)
    {
        return model.hasStatusCode(value);
    }

}
