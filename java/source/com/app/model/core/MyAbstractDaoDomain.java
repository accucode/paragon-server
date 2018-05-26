package com.app.model.core;

import com.kodemore.hibernate.KmhDaoDomainIF;
import com.kodemore.servlet.field.ScOption;

import com.app.dao.base.MyDaoAccess;
import com.app.dao.core.MyDaoSession;
import com.app.dao.core.MyDaoSessionCache;
import com.app.utility.MyGlobals;

/**
 * I am the parent of the domain classes that are stored
 * in the database.
 *
 * I have a primaryKey and various convenience methods for
 * accessing the hibernate dao interface.
 */
public abstract class MyAbstractDaoDomain<T extends MyAbstractDomain<?>>
    extends MyAbstractDomain<T>
    implements KmhDaoDomainIF
{
    //##################################################
    //# key
    //##################################################

    public abstract String formatPrimaryKey();

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
        validateAndCheck();

        boolean attached = daoIsAttached();
        if ( attached )
            return;

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

    /**
     * This executes a fetch and then an evict.
     */
    @Override
    public final void daoDetach()
    {
        if ( !daoIsAttached() )
            return;

        daoFetch();
        daoEvict();
    }

    //##################################################
    //# display
    //##################################################

    public abstract String getAuditLogTitle();

    public abstract String getDomainTitle();

    //##################################################
    //# convenience
    //##################################################

    protected final MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

    protected ScOption<String> toOption()
    {
        ScOption<String> e;
        e = new ScOption<>();
        e.setValue(formatPrimaryKey());
        e.setText(getDomainTitle());
        return e;
    }
}
