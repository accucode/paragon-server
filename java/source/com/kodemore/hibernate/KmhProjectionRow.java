package com.kodemore.hibernate;

import java.sql.Date;

import com.kodemore.time.KmDate;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.Kmu;

public class KmhProjectionRow
{
    //##################################################
    //# variables
    //##################################################

    private KmhProjectionResult _parent;
    private int                 _row;
    private int                 _column;

    //##################################################
    //# constructor
    //##################################################

    public KmhProjectionRow(KmhProjectionResult e, int row)
    {
        _parent = e;
        _row = row;
        _column = 0;
    }

    //##################################################
    //# columns
    //##################################################

    public String nextString()
    {
        return (String)nextColumn();
    }

    public Integer nextInteger()
    {
        return Kmu.toInteger(nextColumn());
    }

    public Long nextLong()
    {
        return (Long)nextColumn();
    }

    public Double nextDouble()
    {
        return (Double)nextColumn();
    }

    public KmTimestamp nextTimestamp()
    {
        return (KmTimestamp)nextColumn();
    }

    public Date nextSqlDate()
    {
        return (Date)nextColumn();
    }

    public KmDate nextDate()
    {
        return (KmDate)nextColumn();
    }

    public Boolean nextBoolean()
    {
        return (Boolean)nextColumn();
    }

    //##################################################
    //# support
    //##################################################

    public Object nextColumn()
    {
        return _parent.getValueAt(_row, _column++);
    }
}
