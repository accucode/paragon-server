package com.kodemore.sql.formatter;

import com.kodemore.collection.KmList;
import com.kodemore.database.KmDatabaseConnectionFactory;
import com.kodemore.sql.KmSqlConnection;
import com.kodemore.sql.KmSqlResultSet;
import com.kodemore.sql.KmSqlStatementWrapper;
import com.kodemore.utility.KmTimer;
import com.kodemore.utility.Kmu;

public class KmSqlResultComposer
{
    //##################################################
    //# variables
    //##################################################

    /**
     * When false, all changes will be rolled back instead of committed.
     */
    private boolean _allowsCommit;

    private boolean _useBlanksForNull;
    private boolean _hideSqlData;

    private KmList<String>       _schemas;
    private KmList<String>       _sqlStatements;
    private KmSqlConnection      _connection;
    private KmSqlResultFormatter _formatter;

    //##################################################
    //# constructor
    //##################################################

    public KmSqlResultComposer()
    {
        _allowsCommit = true;
        _schemas = new KmList<>();
        _sqlStatements = new KmList<>();
        formatCsvNormal();
    }

    //##################################################
    //# allow updates
    //##################################################

    public boolean allowsCommit()
    {
        return _allowsCommit;
    }

    private boolean isRollback()
    {
        return !allowsCommit();
    }

    public void setAllowCommit(boolean e)
    {
        _allowsCommit = e;
    }

    //##################################################
    //# format nulls
    //##################################################

    public void useBlanksForNull(boolean e)
    {
        _useBlanksForNull = e;
    }

    public void useBlanksForNull()
    {
        useBlanksForNull(true);
    }

    private boolean usesBlanksForNull()
    {
        return _useBlanksForNull;
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

    //##################################################
    //# schemas
    //##################################################

    public void setSchema(String e)
    {
        _schemas.clear();
        addSchema(e);
    }

    public void setSchemas(KmList<String> e)
    {
        _schemas = e;
    }

    public void addSchema(String e)
    {
        _schemas.add(e);
    }

    //##################################################
    //# sql
    //##################################################

    public void setSqlStatements(KmList<String> e)
    {
        _sqlStatements = e;
    }

    public void setSqlSource(String e)
    {
        KmList<String> v = Kmu.tokenize(e, ';');
        Kmu.trimValues(v);
        Kmu.removeEmptyValues(v);
        setSqlStatements(v);
    }

    //##################################################
    //# formatter
    //##################################################

    public KmSqlResultFormatter getFormatter()
    {
        return _formatter;
    }

    public void setFormatter(KmSqlResultFormatter e)
    {
        _formatter = e;
    }

    public void formatHtmlNormal()
    {
        setFormatter(new KmSqlResultFormatterHtmlNormal());
    }

    public void formatHtmlSimple()
    {
        setFormatter(new KmSqlResultFormatterHtmlSimple());
    }

    public void formatCsvNormal()
    {
        setFormatter(new KmSqlResultFormatterCsvNormal());
    }

    public void formatCsvSimple()
    {
        setFormatter(new KmSqlResultFormatterCsvSimple());
    }

    public void formatExcelNormal()
    {
        setFormatter(new KmSqlResultFormatterExcelNormal());
    }

    public void formatExcelSimple()
    {
        setFormatter(new KmSqlResultFormatterExcelSimple());
    }

    //##################################################
    //# run
    //##################################################

    public String run()
    {
        _formatter.useBlanksForNull(usesBlanksForNull());
        _formatter.hideSqlData(isSqlDataHidden());
        _formatter.begin(this);
        processSchemas();
        return _formatter.end();
    }

    //##################################################
    //# process
    //##################################################

    private void processSchemas()
    {
        for ( String e : _schemas )
            processSchema(e);
    }

    protected void processSchema(String schema)
    {
        _connection = null;
        try
        {
            _connection = openConnection(schema);
            processStatements(schema);

            if ( allowsCommit() )
                _connection.commit();
        }
        finally
        {
            if ( _connection != null )
                _connection.close();
        }
    }

    protected void processStatements(String schema)
    {
        for ( String sql : _sqlStatements )
            if ( !processStatement(schema, sql) )
                break;
    }

    private boolean processStatement(String schema, String sql)
    {
        KmSqlStatementWrapper st = null;
        try
        {
            KmTimer t = KmTimer.run();
            st = _connection.createSqlStatement();
            boolean isResult = st._execute(sql);
            while ( true )
            {
                if ( isResult )
                {
                    KmSqlResultSet rs = st._getResultSet();
                    _formatter.formatResultSet(schema, sql, rs, t);
                }
                else
                {
                    int count = st._getUpdateCount();
                    if ( count < 0 )
                        return true;

                    _formatter.formatUpdate(schema, sql, count, t, isRollback());
                }
                isResult = st._getMoreResults();
            }
        }
        catch ( Exception ex )
        {
            _formatter.formatException(schema, sql, ex);
            return false;
        }
        finally
        {
            if ( st != null )
                st.close();
        }
    }

    //##################################################
    //# connection
    //##################################################

    private KmSqlConnection openConnection(String schema)
    {
        KmSqlConnection c;
        c = KmDatabaseConnectionFactory.getInstance().open();
        c.useSchema(schema);
        return c;
    }

}
