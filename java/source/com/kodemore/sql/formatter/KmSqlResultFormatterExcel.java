package com.kodemore.sql.formatter;

public abstract class KmSqlResultFormatterExcel
    extends KmSqlResultFormatter
{
    @Override
    public final String end()
    {
        // String results not supported in excel formatters.
        return null;
    }

    public abstract byte[] endBytes();
}
