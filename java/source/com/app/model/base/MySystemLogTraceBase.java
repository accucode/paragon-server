//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import com.app.model.MySystemLog;
import com.app.model.MySystemLogTrace;
import com.app.model.MySystemLogTraceTools;
import com.app.model.MySystemLogTraceValidator;
import com.app.model.core.MyAbstractDomain;
import com.app.model.meta.MyMetaSystemLogTrace;

import com.kodemore.collection.KmMap;
import com.kodemore.servlet.utility.ScFormatter;
import com.kodemore.utility.KmProperties;
import com.kodemore.utility.KmSequenceIF;
import com.kodemore.utility.Kmu;

public abstract class MySystemLogTraceBase
    extends MyAbstractDomain
    implements KmSequenceIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaSystemLogTrace Meta = MyMetaSystemLogTrace.instance;
    public static final MySystemLogTraceTools Tools = MySystemLogTraceTools.instance;
    public static final MySystemLogTraceValidator Validator = MySystemLogTraceValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private Integer id;
    private Integer sequence;
    private String value;
    private MySystemLog log;

    //##################################################
    //# constructor
    //##################################################

    public MySystemLogTraceBase()
    {
        super();
    }

    //##################################################
    //# field (id)
    //##################################################

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer e)
    {
        checkReadOnly();
        e = Validator.getIdValidator().convertOnly(e);
        id = e;
    }

    public void clearId()
    {
        setId(null);
    }

    public boolean hasId()
    {
        return getId() != null;
    }

    public boolean hasId(Integer e)
    {
        return Kmu.isEqual(getId(), e);
    }

    //##################################################
    //# field (sequence)
    //##################################################

    @Override
    public Integer getSequence()
    {
        return sequence;
    }

    @Override
    public void setSequence(Integer e)
    {
        checkReadOnly();
        e = Validator.getSequenceValidator().convertOnly(e);
        sequence = e;
    }

    public void clearSequence()
    {
        setSequence(null);
    }

    public boolean hasSequence()
    {
        return getSequence() != null;
    }

    public boolean hasSequence(Integer e)
    {
        return Kmu.isEqual(getSequence(), e);
    }

    //##################################################
    //# field (value)
    //##################################################

    public String getValue()
    {
        return value;
    }

    public void setValue(String e)
    {
        checkReadOnly();
        e = Validator.getValueValidator().convertOnly(e);
        value = e;
    }

    public void clearValue()
    {
        setValue(null);
    }

    public boolean hasValue()
    {
        return Kmu.hasValue(getValue());
    }

    public boolean hasValue(String e)
    {
        return Kmu.isEqualIgnoreCase(getValue(), e);
    }

    public void truncateValue()
    {
        truncateValue(false);
    }

    public void truncateValue(boolean ellipses)
    {
        value = Kmu.truncate(value, 1000, ellipses);
    }

    //##################################################
    //# log
    //##################################################

    public MySystemLog getLog()
    {
        return log;
    }

    public void setLog(MySystemLog e)
    {
        checkReadOnly();
        log = e;
    }

    public void _setLog(MySystemLog e)
    {
        checkReadOnly();
        log = e;
    }

    public void clearLog()
    {
        setLog(null);
    }

    public boolean hasLog()
    {
        return getLog() != null;
    }

    public boolean hasLog(MySystemLog e)
    {
        return Kmu.isEqual(getLog(), e);
    }


    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MySystemLogTrace)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MySystemLogTrace)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MySystemLogTrace)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MySystemLogTrace getCopy()
    {
        return (MySystemLogTrace)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        id = null;
        log = null;
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MySystemLogTraceBase) )
            return false;

        MySystemLogTraceBase e = (MySystemLogTraceBase)o;
        return Kmu.isEqual(getId(), e.getId());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getId());
    }

    public boolean isSame(MySystemLogTrace e)
    {
        if ( !Kmu.isEqual(getId(), e.getId()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MySystemLogTrace e)
    {
        if ( !Kmu.isEqual(getSequence(), e.getSequence()) ) return false;
        if ( !Kmu.isEqual(getValue(), e.getValue()) ) return false;
        return true;
    }

    public boolean isDifferent(MySystemLogTrace e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MySystemLogTrace e)
    {
        return !isSameIgnoringKey(e);
    }

    //##################################################
    //# property
    //##################################################

    public void importPropertyMap(KmMap<String,String> map)
    {
        KmProperties p;
        p = new KmProperties();
        p.setMap(map);

        if ( p.hasKey("id") )
            setId(p.getInteger("id"));

        if ( p.hasKey("sequence") )
            setSequence(p.getInteger("sequence"));

        if ( p.hasKey("value") )
            setValue(p.getString("value"));
    }

    public KmMap<String,String> exportPropertyMap()
    {
        KmProperties p;
        p = new KmProperties();

        if ( hasId() )
            p.setInteger("id", getId());

        if ( hasSequence() )
            p.setInteger("sequence", getSequence());

        if ( hasValue() )
            p.setString("value", getValue());

        return p.getMap();
    }


    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MySystemLogTrace");
        sb.append("(");
        sb.append("Id=");
        sb.append(id);
        sb.append(")");
        return sb.toString();
    }

    public void printFields()
    {
        System.out.println(this);
        System.out.println("    Id = " + id);
        System.out.println("    Sequence = " + sequence);
        System.out.println("    Value = " + value);
    }

    /**
     * Format the primary key fields in a comma separated list.  The format
     * is intended to be suitable for display to users.
     */
    public String formatPrimaryKey()
    {
        StringBuilder sb = new StringBuilder();
        ScFormatter f = getFormatter();
        sb.append(f.formatAny(id));
        return sb.toString();
    }

}
