/*
  Copyright (c) 2005-2016 www.kodemore.com

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in
  all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  THE SOFTWARE.
*/

package com.kodemore.awt;

import java.util.Comparator;
import java.util.Iterator;

import com.kodemore.collection.KmList;
import com.kodemore.comparator.KmCompositeComparator;
import com.kodemore.comparator.KmReversingComparator;

public abstract class KmaSortableTableModel
    extends KmaTableModel
{
    //##################################################
    //# variables
    //##################################################

    private KmList<KmaSortableTableColumn> _sortedColumns;

    //##################################################
    //# constructor
    //##################################################

    public KmaSortableTableModel()
    {
        _sortedColumns = new KmList<>();
    }

    //##################################################
    //# abstract
    //##################################################

    public abstract KmList<Object> getList();

    @Override
    public abstract String[] getColumnNames();

    public abstract String formatColumn(Object value, int column);

    public abstract Comparator<Object> getColumnComparator(int col);

    //##################################################
    //# accessing
    //##################################################

    public void clearSortedColumns()
    {
        _sortedColumns.clear();
    }

    public void addSortedColumn(int col, boolean asc)
    {
        KmaSortableTableColumn c;
        c = new KmaSortableTableColumn(col, asc);
        _sortedColumns.add(c);
    }

    public KmaSortableTableColumn getSortedColumn(int col)
    {
        Iterator<KmaSortableTableColumn> i = _sortedColumns.iterator();
        while ( i.hasNext() )
        {
            KmaSortableTableColumn sc = i.next();
            if ( col == sc.getColumn() )
                return sc;
        }

        return null;
    }

    public boolean isPrimarySortColumn(KmaSortableTableColumn c)
    {
        if ( _sortedColumns.isEmpty() )
            return false;

        return _sortedColumns.get(0) == c;
    }

    public boolean hasOneSortColumn(int i)
    {
        return _sortedColumns.size() == 1 && getSortedColumn(i) != null;
    }

    public void setSortColumn(int i)
    {
        clearSortedColumns();
        toggleSortColumn(i);
    }

    public void toggleSortColumn(int col)
    {
        KmaSortableTableColumn sc = getSortedColumn(col);
        if ( sc == null )
        {
            sc = new KmaSortableTableColumn(col, true);
            _sortedColumns.add(sc);
        }
        else
            sc.toggleAscending();

        resort();
    }

    public void resort()
    {
        KmCompositeComparator<Object> cc = new KmCompositeComparator<>();

        for ( KmaSortableTableColumn sc : _sortedColumns )
            cc.add(getComparator(sc));

        getList().sortOn(cc);
    }

    public Comparator<Object> getComparator(KmaSortableTableColumn tc)
    {
        int col = tc.getColumn();
        Comparator<Object> c = getColumnComparator(col);

        if ( !tc.getAscending() )
            c = new KmReversingComparator<>(c);

        return c;
    }

    public boolean isSortable(int col)
    {
        return getColumnComparator(col) != null;
    }

    @Override
    public int getRowCount()
    {
        return getList().size();
    }

    @Override
    public Object getValueAt(int row, int col)
    {
        Object e = getList().get(row);
        return formatColumn(e, col);
    }

}
