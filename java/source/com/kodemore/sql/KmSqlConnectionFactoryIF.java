package com.kodemore.sql;

public interface KmSqlConnectionFactoryIF
{
    String getName();

    KmSqlConnection open();
}
