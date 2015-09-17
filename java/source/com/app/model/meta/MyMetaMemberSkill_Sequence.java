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

public class MyMetaMemberSkill_Sequence
    extends KmMetaIntegerProperty<MyMemberSkill>
    implements KmMetaDaoPropertyIF<MyMemberSkill,Integer>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "sequence";
    }

    @Override
    public String getLabel()
    {
        return "Sequence";
    }

    @Override
    public String getHelp()
    {
        return "The relative priority of the skills.";
    }
    
    @Override
    public int getColumnWidth()
    {
        return 3;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmIntegerValidator getValidator()
    {
        return MyMemberSkillValidator.instance.getSequenceValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "sequence";
    }

    @Override
    public MyMemberSkillDao getDao()
    {
        return getAccess().getMemberSkillDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public Integer getValueFor(MyMemberSkill model)
    {
        return model.getSequence();
    }
    
    @Override
    public void setValueFor(MyMemberSkill model, Integer value)
    {
        model.setSequence(value);
    }
    
    @Override
    public boolean hasValueFor(MyMemberSkill model, Integer value)
    {
        return model.hasSequence(value);
    }
    
}
