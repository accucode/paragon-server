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

public class MyMetaDownload_Bytes
    extends KmMetaBlobProperty<MyDownload>
    implements KmMetaDaoPropertyIF<MyDownload,KmBlob>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "bytes";
    }

    @Override
    public String getLabel()
    {
        return "Bytes";
    }

    @Override
    public String getHelp()
    {
        return "The binary content stored directly in the database. Long-term this should be switched to Amazon s3.";
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
    public KmBlobValidator getValidator()
    {
        return MyDownloadValidator.instance.getBytesValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "bytes";
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
    public KmBlob getValueFor(MyDownload model)
    {
        return model.getBytes();
    }

    @Override
    public void setValueFor(MyDownload model, KmBlob value)
    {
        model.setBytes(value);
    }

    @Override
    public boolean hasValueFor(MyDownload model, KmBlob value)
    {
        return model.hasBytes(value);
    }

}
