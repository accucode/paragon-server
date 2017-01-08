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

public class MyMetaThreadTopic_Code
    extends KmMetaStringProperty<MyThreadTopic>
    implements KmMetaDaoPropertyIF<MyThreadTopic,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "code";
    }

    @Override
    public String getLabel()
    {
        return "Code";
    }

    @Override
    public String getHelp()
    {
        return "The unique key. In practice, this is often the (simple) name of the java class that is being run.  The names generally do not matter, as long as they are consistent across all JVMs.";
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
        return MyThreadTopicValidator.instance.getCodeValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "code";
    }

    @Override
    public MyThreadTopicDao getDao()
    {
        return getAccess().getThreadTopicDao();
    }

    private MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyThreadTopic model)
    {
        return model.getCode();
    }

    @Override
    public void setValueFor(MyThreadTopic model, String value)
    {
        model.setCode(value);
    }

    @Override
    public boolean hasValueFor(MyThreadTopic model, String value)
    {
        return model.hasCode(value);
    }

}
