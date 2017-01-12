package com.app.model.core;

import java.io.Serializable;

import com.kodemore.servlet.ScModelApplicatorIF;
import com.kodemore.servlet.utility.ScFormatter;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.KmCopyIF;
import com.kodemore.utility.KmDisplayStringIF;
import com.kodemore.utility.Kmu;

import com.app.property.MyProperties;
import com.app.utility.MyGlobals;

public abstract class MyAbstractDomain
    implements KmDisplayStringIF, KmCopyIF, Serializable, Cloneable
{
    //##################################################
    //# abstract
    //##################################################

    public abstract void validate();

    public abstract void validateWarn();

    //##################################################
    //# support
    //##################################################

    protected final KmTimestamp nowUtc()
    {
        return MyGlobals.getNowUtc();
    }

    protected final void unsupported()
    {
        throw new UnsupportedOperationException();
    }

    protected final MyProperties getProperties()
    {
        return MyGlobals.getProperties();
    }

    protected final ScFormatter getFormatter()
    {
        return ScFormatter.getInstance();
    }

    protected final String newUid()
    {
        return Kmu.newUid();
    }

    //##################################################
    //# copy
    //##################################################

    /**
     * Return a 'deep' copy of the model, via shallowCopy => postCopy.
     * The primary key is reset to its default value (typically a new UID) or null.
     * The parent reference, if any, is set to null.
     */
    @Override
    public MyAbstractDomain getCopy()
    {
        MyAbstractDomain e = getShallowCopy();
        e.postCopy();
        return e;
    }

    protected final MyAbstractDomain getShallowCopy()
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
     * that is independent of the original.
     *
     * Immutables and primitives do NOT need to be copied.
     * References to other models do NOT need to be copied.
     * The primary key is reset to its default value (typically null, or a new UID).
     * Child collections are copied.
     */
    protected void postCopy()
    {
        // none
    }

    /**
     * Copy an instance of KmCopyIF, checking for null.
     */
    protected final <T extends KmCopyIF> T copy(T e)
    {
        return Kmu.copy(e);
    }

    //##################################################
    //# model updater
    //##################################################

    public final void applyFrom(ScModelApplicatorIF e)
    {
        e.applyToModel(this);
    }

    public final void applyTo(ScModelApplicatorIF e)
    {
        boolean skipFields = MyGlobals.getData().hasErrors();
        e.applyFromModel(this, skipFields);
    }

    public final void applyTo(ScModelApplicatorIF e, boolean skipFields)
    {
        e.applyFromModel(this, skipFields);
    }

    //##################################################
    //# convenience
    //##################################################

    public abstract String getMetaName();
}
