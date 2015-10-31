package com.kodemore.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

import com.kodemore.collection.KmList;
import com.kodemore.hibernate.KmhModelCriteria;
import com.kodemore.hibernate.basic.KmhBasicCriteria;
import com.kodemore.hibernate.basic.KmhCriteria;
import com.kodemore.hibernate.basic.KmhRootCriteria;
import com.kodemore.time.KmClock;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.Kmu;

public abstract class KmAbstractDao<T, K extends Serializable>
{
    //##################################################
    //# abstract
    //##################################################

    protected abstract Class<T> getPersistentClass();

    protected abstract String getTableName();

    //##################################################
    //# fetch
    //##################################################

    public KmList<T> findAll()
    {
        return createCriteria().findAll();
    }

    /**
     * Are there any records?
     */
    public boolean isEmpty()
    {
        return createCriteria().findFirst() == null;
    }

    /**
     * Are there any records?
     */
    public boolean isNotEmpty()
    {
        return !isEmpty();
    }

    /**
     * Count the number of records.  This can sometimes be slow for
     * large tables.  If you are only checking for count==0, then
     * use isEmpty, or isNotEmpty instead.
     */
    public int getCount()
    {
        return findUniqueLong("select count(*) from %s", getModelName()).intValue();
    }

    //##################################################
    //# save
    //##################################################

    public void save(T e)
    {
        getSession().saveOrUpdate(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void delete(T e)
    {
        getSession().delete(e);
    }

    public void deleteAll(List<T> v)
    {
        for ( T e : v )
            delete(e);
    }

    public void deleteAll(KmhModelCriteria<T> c)
    {
        deleteAll(c.findAll());
    }

    /**
     * Delete all objects.   This method respects the normal hibernate
     * modelling rules.  Thus is you delete an object that is on the "one"
     * side of a one-to-many relationship the "many" may also be deleted.
     * For example: deleting an order will likely also delete the associated
     * order lines.
     */
    public int deleteAll()
    {
        String template = "delete from %s";
        String hql = Kmu.format(template, getModelName());
        Query q = getSession().createQuery(hql);
        return q.executeUpdate();
    }

    /**
     * This method is NOT SAFE for normal business operations.
     * This method is very fast and immediately deletes all records
     * from the underlying table.  However, it bypasses hibernate.
     */
    public void _truncate()
    {
        String sql = "truncate " + getTableName();
        getSession().createSQLQuery(sql).executeUpdate();
    }

    //##################################################
    //# internal fetching
    //##################################################

    protected T getKey(K key)
    {
        return getImmediate(key, LockOptions.NONE);
    }

    /**
     * Fetch the model by primary key.  If the key does not exist return null.
     */
    private T getImmediate(K key, LockOptions lock)
    {
        if ( key == null )
            return null;

        Object o = getSession().get(getPersistentClass(), key, lock);
        return cast(o);
    }

    /**
     * getProxy is more effecient than getImmediate, but should only be
     * used when it is safe to assume that the key will exist.
     *
     * If the key does not exist a non-null proxy will be returned, but
     * subsequent attempts to access the proxy will result in an exception.
     */
    protected T getProxy(K key, LockOptions lock)
    {
        if ( key == null )
            return null;

        Object o = getSession().load(getPersistentClass(), key, lock);
        return cast(o);
    }

    /**
     * Tells hibernate to fetch the proxy.  Useful for detached data access.
     */
    protected void fetch(Object e)
    {
        getDaoSession().fetch(e);
    }

    //##################################################
    //# session
    //##################################################

    protected KmDaoSessionManager getDaoSessionManager()
    {
        return KmDaoSessionManager.getInstance();
    }

    protected KmDaoSession getDaoSession()
    {
        return getDaoSessionManager().getDaoSession();
    }

    public Session getSession()
    {
        return getDaoSession().getSession();
    }

    protected String getModelName()
    {
        return Kmu.getSimpleClassName(getPersistentClass());
    }

    //##################################################
    //# criteria
    //##################################################

    public KmhRootCriteria _createCriteria()
    {
        Criteria e = getSession().createCriteria(getPersistentClass());
        return new KmhRootCriteria(e);
    }

    public KmhCriteria _createDetachedCriteria(String alias)
    {
        DetachedCriteria e = DetachedCriteria.forClass(getPersistentClass(), alias);
        return new KmhBasicCriteria(e);
    }

    public abstract KmhModelCriteria<T> createCriteria();

    public abstract KmhModelCriteria<T> createDetachedCriteria(String alias);

    //##################################################
    //# private
    //##################################################

    @SuppressWarnings("unchecked")
    private T cast(Object o)
    {
        return (T)o;
    }

    //##################################################
    //# hql
    //##################################################

    /**
     * Ad hoc hql should generally be avoided.  This is primarily here for
     * debugging, or support of other methods.  If you feel you have a new
     * use for this, please ask.
     */
    @SuppressWarnings(
    {
        "unchecked",
        "rawtypes"
    })
    public KmList<Object> runHql(String s)
    {
        Query query = getSession().createQuery(s);
        List v = query.list();
        if ( v == null )
            return null;

        return new KmList<>(v);
    }

    private Long findUniqueLong(String hql, Object... args)
    {
        String s = Kmu.format(hql, args);
        Query query = getSession().createQuery(s);
        return findUniqueLong(query);
    }

    private Long findUniqueLong(Query query)
    {
        return (Long)query.uniqueResult();
    }

    //##################################################
    //# support
    //##################################################

    protected KmTimestamp getNowUtc()
    {
        return KmClock.getNowUtc();
    }
}
