package com.app.hibernate;

import java.io.Serializable;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import com.kodemore.log.KmLog;

public class MyHibernateInterceptor
    extends EmptyInterceptor
{
    //##################################################
    //# events
    //##################################################

    @Override
    public boolean onSave(
        Object entity,
        Serializable id,
        Object[] values,
        String[] fields,
        Type[] types)
    {
        try
        {
            return newHandler().handleOnSave(entity, id, values, fields, types);
        }
        catch ( RuntimeException ex )
        {
            KmLog.fatal(ex);
            throw ex;
        }
    }

    @Override
    public boolean onFlushDirty(
        Object entity,
        Serializable id,
        Object[] currentValues,
        Object[] previousValues,
        String[] fields,
        Type[] types)
    {
        try
        {
            return newHandler().handleOnFlushDirty(
                entity,
                id,
                currentValues,
                previousValues,
                fields,
                types);
        }
        catch ( RuntimeException ex )
        {
            KmLog.fatal(ex);
            throw ex;
        }
    }

    @Override
    public void onDelete(
        Object entity,
        Serializable id,
        Object[] values,
        String[] fields,
        Type[] types)
    {
        try
        {
            newHandler().handleOnDelete(entity, id, values, fields, types);
        }
        catch ( RuntimeException ex )
        {
            KmLog.fatal(ex);
            throw ex;
        }
    }

    //##################################################
    //# support
    //##################################################

    private MyHibernateInterceptHandler newHandler()
    {
        return new MyHibernateInterceptHandler();
    }

}
