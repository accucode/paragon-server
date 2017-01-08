package com.app.model.core;

import java.io.Serializable;

import com.kodemore.hibernate.KmhDaoDomainIF;
import com.kodemore.servlet.ScModelApplicatorIF;
import com.kodemore.servlet.utility.ScFormatter;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.KmCopyIF;
import com.kodemore.utility.KmDisplayStringIF;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoAccess;
import com.app.dao.core.MyDaoSession;
import com.app.dao.core.MyDaoSessionCache;
import com.app.property.MyProperties;
import com.app.utility.MyGlobals;

public abstract class MyAbstractDomain
    implements KmhDaoDomainIF, KmDisplayStringIF, KmCopyIF, Serializable, Cloneable
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
    //# session
    //##################################################

    protected final MyDaoSession getDaoSession()
    {
        return MyGlobals.getDaoSession();
    }

    protected final MyDaoSessionCache getDaoCache()
    {
        return getDaoSession().getCache();
    }

    protected final MyDaoAccess getDaoRegistry()
    {
        return MyDaoAccess.getInstance();
    }

    //==================================================
    //= session :: attach
    //==================================================

    /**
     * Attach the object to hibernate for subsequent persistence.
     * Once attached, hibernate will take care of automatically saving
     * the object to the database when necessary.
     *
     * If the object is already attached, do nothing.
     *
     * This only needs to be called once for any given object.  Thereafter,
     * hibernate will persist any changes automatically.  You should not need to
     * call this every time you modify the object, and doing do is misleading.
     *
     * Calling attach will automatically check any model validation, so make
     * sure the object is configured correctly BEFORE you attach it to hibernate.
     *
     * When adding an element to a hibernate managed collection, calling attach
     * is not strictly necessary.  HOWEVER, certain hibernate functions, such
     * as fetching an object by its key, do not work correctly until the object
     * has either been explicitly attached, or until until the session has been
     * flushed/committed.
     */
    @Override
    public final void daoAttach()
    {
        boolean attached = daoIsAttached();
        if ( attached )
            return;

        validate();
        daoPreAttach();
        getDaoSession()._attach(this);
        daoPostAttach();
    }

    public final boolean daoIsAttached()
    {
        return getDaoSession().isAttached(this);
    }

    /**
     * Called immediately before the first attach.
     *
     * Subclasses may override this to perform special operations
     * before the object is attached to hibernate. This will only
     * be called once, even if the daoAttach method is called multiple
     * times.
     *
     * By default, this method does NOTHING.
     * Overriding subclasses do NOT need to call super.
     */
    protected void daoPreAttach()
    {
        // subclass
    }

    /**
     * Called immediately after the first attach.
     *
     * Subclasses may override this to perform special operations
     * before the object is attached to hibernate. This will only
     * be called once, even if the daoAttach method is called multiple
     * times.
     *
     * By default, this method does NOTHING.
     * Overriding subclasses do NOT need to call super.
     */
    protected void daoPostAttach()
    {
        // subclass
    }

    //==================================================
    //= session :: other
    //==================================================

    /**
     * Mark this object for deletion.  Note, when dealing with a one-to-many
     * relationship that is managed as a collection of children attached to
     * a parent, it is usually better to remove the child from the parent
     * rather than simply deleting the child.
     */
    @Override
    public final void daoDelete()
    {
        getDaoSession().delete(this);
    }

    /**
     * Used to force hibernate to populate a proxy from the database.
     * This typically on needed if you intend to continue referencing
     * the object _outside_ of the hibernate session/transaction.
     */
    @Override
    public final void daoFetch()
    {
        getDaoSession().fetch(this);
    }

    /**
     * Used to evict this object from hibernate's cache.
     * Once evicted, the object can be safely used outside of a session,
     * but will no longer lazy fetch information from the database.
     * This does NOT delete the object from the database.
     */
    @Override
    public final void daoEvict()
    {
        getDaoSession().evict(this);
    }

    @Override
    public final void daoDetach()
    {
        if ( !daoIsAttached() )
            return;

        daoFetch();
        daoEvict();
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

    protected final MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

    public abstract String getMetaName();

    public abstract String formatPrimaryKey();

}
