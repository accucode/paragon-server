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
    //# begin / end
    //##################################################

    public abstract void begin(KmSqlResultComposer c);

    public abstract String end();

    //##################################################
    //# format
    //##################################################

    protected abstract void formatResultSet(String schema, String sql, KmSqlResultSet rs, KmTimer t);

    protected abstract void formatUpdate(String schema, String sql, int count, KmTimer t);

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
                v.add(m.getColumnName(i));
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
