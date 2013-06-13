package com.kodemore.hibernate.criteria;

import java.util.Iterator;
import java.util.List;

public class KmProjectionResult
    implements Iterable<KmProjectionRow>
{
    //##################################################
    //# variables
    //##################################################

    private List<Object[]> _data;

    //##################################################
    //# constructor
    //##################################################

    public KmProjectionResult(List<Object[]> e)
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

    public KmProjectionRow getRowAt(int index)
    {
        return new KmProjectionRow(this, index);
    }

    public KmProjectionRow getFirstRow()
    {
        return getRowAt(0);
    }

    //##################################################
    //# iterable
    //##################################################

    @Override
    public Iterator<KmProjectionRow> iterator()
    {
        return new Iterator<KmProjectionRow>()
        {
            private int _next = 0;

            @Override
            public boolean hasNext()
            {
                return _next < _data.size();
            }

            @Override
            public KmProjectionRow next()
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
