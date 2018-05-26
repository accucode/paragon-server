package com.kodemore.sql.formatter;

import java.sql.ResultSetMetaData;

import com.kodemore.collection.KmList;
import com.kodemore.sql.KmSqlResultSet;
import com.kodemore.utility.KmTimer;
import com.kodemore.utility.Kmu;

public abstract class KmSqlResultFormatter
{
    //##################################################
    //# constants
    //##################################################

    protected static final String COLOR_SELECT = "#ff0";
    protected static final String COLOR_UPDATE = "#0ff";
    protected static final String COLOR_ERROR  = "#f00";

    //##################################################
    //# constructor
    //##################################################

    public KmSqlResultFormatter()
    {
        // none
    }

    //##################################################
    //# variables
    //##################################################

    /**
     * If true, null values will be formatted as a blank instead of "-null-"
     */
    private boolean _useBlanksForNull;

    /**
     * IF true, the header above the result set containing the statement will be hidden
     */
    private boolean _hideSqlData;

    //##################################################
    //# nulls
    //##################################################

    public void useBlanksForNull(boolean e)
    {
        _useBlanksForNull = e;
    }

    public void useBlanksForNull()
    {
        useBlanksForNull(true);
    }

    protected boolean usesBlanksForNulls()
    {
        return _useBlanksForNull;
    }

    protected String formatNull()
    {
        return usesBlanksForNulls()
            ? ""
            : "-null-";
    }

    //##################################################
    //# sql data
    //##################################################

    public void hideSqlData(boolean e)
    {
        _hideSqlData = e;
    }

    public void hideSqlData()
    {
        hideSqlData(true);
    }

    protected boolean isSqlDataHidden()
    {
        return _hideSqlData;
    }

    protected boolean showsSqlData()
    {
        return !isSqlDataHidden();
    }

    //##################################################
    //# begin / end
    //##################################################

    public abstract void begin(KmSqlResultComposer c);

    public abstract String end();

    //##################################################
    //# format
    //##################################################

    protected abstract void formatResultSet(
        String schema,
        String sql,
        KmSqlResultSet rs,
        KmTimer t);

    protected abstract void formatUpdate(
        String schema,
        String sql,
        int count,
        KmTimer t,
        boolean rollback);

    protected abstract void formatException(String schema, String sql, Exception ex);

    //##################################################
    //# support
    //##################################################

    protected KmList<String> getColumnNames(KmSqlResultSet rs)
    {
        try
        {
            KmList<String> v = new KmList<>();

            ResultSetMetaData m = rs.getMetaData();
            int n = m.getColumnCount();

            for ( int i = 1; i < n + 1; i++ )
                v.add(m.getColumnLabel(i));

            return v;
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    protected int getColumnCount(KmSqlResultSet rs)
    {
        try
        {
            return rs.getMetaData().getColumnCount();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    protected String formatSeconds(KmTimer timer)
    {
        if ( timer == null )
            return null;

        return Kmu.formatDouble(timer.getSeconds(), 3);
    }

}
