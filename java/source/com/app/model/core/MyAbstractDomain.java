package com.app.model.core;

import java.io.Serializable;

import com.app.dao.base.MyDaoRegistry;
import com.app.dao.core.MyDaoSession;
import com.app.dao.core.MyDaoSessionCache;
import com.app.property.MyPropertyRegistry;
import com.app.utility.MyGlobals;

import com.kodemore.servlet.ScModelApplicatorIF;
import com.kodemore.servlet.utility.ScFormatter;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.KmCodedEnumIF;
import com.kodemore.utility.KmConstantsIF;
import com.kodemore.utility.KmCopyIF;
import com.kodemore.utility.KmReadOnlyException;
import com.kodemore.utility.KmReadOnlyIF;
import com.kodemore.utility.Kmu;

public abstract class MyAbstractDomain
    implements KmConstantsIF, KmReadOnlyIF, KmCopyIF, Serializable, Cloneable
{
    //##################################################
    //# variables
    //##################################################

    private boolean _readOnly;

    //##################################################
    //# read only
    //##################################################

    @Override
    public boolean isReadOnly()
    {
        return _readOnly;
    }

    @Override
    public void setReadOnly(boolean e)
    {
        _readOnly = e;
    }

    public void checkReadOnly()
    {
        if ( _readOnly )
            throw new KmReadOnlyException(this);
    }

    //##################################################
    //# abstract
    //##################################################

    public abstract void validate();

    public abstract void validateWarn();

    //##################################################
    //# support
    //##################################################

    protected KmTimestamp getNowUtc()
    {
        return MyGlobals.getNowUtc();
    }

    protected KmDate getTodayUtc()
    {
        return getNowUtc().getDate();
    }

    protected void error(String s, Object... args)
    {
        Kmu.error(s, args);
    }

    protected void unsupported()
    {
        throw new UnsupportedOperationException();
    }

    protected void fatal(String msg, Object... args)
    {
        Kmu.fatal(msg, args);
    }

    protected MyPropertyRegistry getProperties()
    {
        return MyGlobals.getProperties();
    }

    protected ScFormatter getFormatter()
    {
        return ScFormatter.getInstance();
    }

    protected String newUid()
    {
        return Kmu.newUid();
    }

    //##################################################
    //# copy
    //##################################################

    /**
     * This method should be overridden by subclasses, but only
     * to specialize the return type.
     */
    @Override
    public MyAbstractDomain getCopy()
    {
        MyAbstractDomain e = getShallowCopy();
        e.postCopy();
        return e;
    }

    public MyAbstractDomain getShallowCopy()
    {
        try
        {
            return (MyAbstractDomain)clone();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    /**
     * This method is responsible for any changes that need to be
     * made after the shallow copy, in order to guarantee a copy
     * that is independent of the original.  Typically, copies
     * of mutable instance variables will be made here.  All
     * subclasses should call super.postCopy().
     */
    protected void postCopy()
    {
        setReadOnly(false);
    }

    /**
     * Copy an instance of KmCopyIF, checking for null.
     */
    public <T extends KmCopyIF> T copy(T e)
    {
        return Kmu.copy(e);
    }

    //##################################################
    //# dao session
    //##################################################

    protected MyDaoSession getDaoSession()
    {
        return MyGlobals.getDaoSession();
    }

    protected MyDaoSessionCache getDaoCache()
    {
        return getDaoSession().getCache();
    }

    protected MyDaoRegistry getDaoRegistry()
    {
        return MyDaoRegistry.getInstance();
    }

    public void saveDao()
    {
        saveDao(true);
    }

    public void saveDao(boolean validate)
    {
        if ( validate )
            validate();

        getDaoSession().save(this);
    }

    public void deleteDao()
    {
        getDaoSession().delete(this);
    }

    //##################################################
    //# model updater
    //##################################################

    public void applyFrom(ScModelApplicatorIF e)
    {
        e.applyToModel(this);
    }

    public void applyTo(ScModelApplicatorIF e)
    {
        boolean skipFields = MyGlobals.getData().hasErrors();
        e.applyFromModel(this, skipFields);
    }

    public void applyTo(ScModelApplicatorIF e, boolean skipFields)
    {
        e.applyFromModel(this, skipFields);
    }

    //##################################################
    //# convenience
    //##################################################

    protected String getCodeFor(KmCodedEnumIF e)
    {
        return e == null
            ? null
            : e.getCode();
    }

    protected MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }

}
