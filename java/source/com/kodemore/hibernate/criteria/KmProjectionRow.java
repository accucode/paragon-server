package com.kodemore.hibernate.criteria;

import com.kodemore.time.KmDate;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.Kmu;

public class KmProjectionRow
{
    //##################################################
    //# variables
    //##################################################

    private KmProjectionResult _parent;
    private int                _row;
    private int                _column;

    //##################################################
    //# constructor
    //##################################################

    public KmProjectionRow(KmProjectionResult e, int row)
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

    public KmDate nextDate()
    {
        return (KmDate)nextColumn();
    }

    //##################################################
    //# support
    //##################################################

    private Object nextColumn()
    {
        return _parent.getValueAt(_row, _column++);
    }
}
