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

public class MyMetaDownload_FileName
    extends KmMetaStringProperty<MyDownload>
    implements KmMetaDaoPropertyIF<MyDownload,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "fileName";
    }

    @Override
    public String getLabel()
    {
        return "File Name";
    }

    @Override
    public String getHelp()
    {
        return "The name of the file to be downloaded. This is only used if the type is File.";
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
        return MyDownloadValidator.instance.getFileNameValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "fileName";
    }

    @Override
    public MyDownloadDao getDao()
    {
        return getAccess().getDownloadDao();
    }

    private MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyDownload model)
    {
        return model.getFileName();
    }

    @Override
    public void setValueFor(MyDownload model, String value)
    {
        model.setFileName(value);
    }

    @Override
    public boolean hasValueFor(MyDownload model, String value)
    {
        return model.hasFileName(value);
    }

}
