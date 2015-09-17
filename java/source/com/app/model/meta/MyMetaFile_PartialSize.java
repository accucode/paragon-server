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
import com.app.model.core.*;
import com.app.utility.*;

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
    public String getHelp()
    {
        return "This is only used when coordinating an asynchronous file upload.  Once the file is fully uploaded (and available) this can be ignored.";
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
    
}
