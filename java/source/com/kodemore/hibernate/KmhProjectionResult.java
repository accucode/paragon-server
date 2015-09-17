package com.kodemore.hibernate;

import java.util.Iterator;
import java.util.List;

public class KmhProjectionResult
    implements Iterable<KmhProjectionRow>
{
    //##################################################
    //# variables
    //##################################################

    private List<Object[]> _data;

    //##################################################
    //# constructor
    //##################################################

    public KmhProjectionResult(List<Object[]> e)
    {
        _data = e;
    }

    //##################################################
    //# accessing 
    //##################################################

    public int getRowCount()
    {
        return _data.size();
    }

    public int getColumnCount()
    {
        return getRowCount() == 0
            ? 0
            : _data.get(0).length;
    }

    public Object getValueAt(int row, int col)
    {
        return _data.get(row)[col];
    }

    //##################################################
    //# row access
    //##################################################

    public KmhProjectionRow getRowAt(int index)
    {
        return new KmhProjectionRow(this, index);
    }

    public KmhProjectionRow getFirstRow()
    {
        return getRowAt(0);
    }

    //##################################################
    //# iterable
    //##################################################

    @Override
    public Iterator<KmhProjectionRow> iterator()
    {
        return new Iterator<KmhProjectionRow>()
        {
            private int _next = 0;

            @Override
            public boolean hasNext()
            {
                return _next < _data.size();
            }

            @Override
            public KmhProjectionRow next()
            {
                return getRowAt(_next++);
            }

            @Override
            public void remove()
            {
                throw new UnsupportedOperationException();
            }
        };
    }
}
