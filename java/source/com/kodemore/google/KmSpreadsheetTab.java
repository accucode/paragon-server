package com.kodemore.google;

import java.util.List;

import com.google.gdata.data.spreadsheet.WorksheetEntry;

import com.kodemore.collection.KmList;

/**
 * I represent a single tab/sheet within a spreadsheet document.
 * I wrap the WorksheetEntry.
 * I am immutable.
 */
public class KmSpreadsheetTab
{
    //##################################################
    //# instance creation
    //##################################################

    public static KmSpreadsheetTab wrap(WorksheetEntry e)
    {
        return new KmSpreadsheetTab(e);
    }

    public static KmList<KmSpreadsheetTab> wrap(List<WorksheetEntry> v)
    {
        return KmList.wrap(v).collect(x -> wrap(x));
    }

    //##################################################
    //# variables
    //##################################################

    private WorksheetEntry _inner;

    //##################################################
    //# constructor
    //##################################################

    private KmSpreadsheetTab(WorksheetEntry e)
    {
        _inner = e;
    }

    //##################################################
    //# accessing
    //##################################################

    public String getTitle()
    {
        return _inner.getTitle().getPlainText();
    }

    public int getRowCount()
    {
        return _inner.getRowCount();
    }

    public int getColumnCount()
    {
        return _inner.getColCount();
    }

    //##################################################
    //# find
    //##################################################

    /**
     * Start a query that allows criteria like min/max row.
     */
    public KmSpreadsheetCellQuery startQuery()
    {
        return KmSpreadsheetCellQuery.wrap(_inner);
    }

    /**
     * Find all non-empty cells in the worksheet tab.
     */
    public KmList<KmSpreadsheetCell> getCells()
    {
        return startQuery().getList();
    }

    /**
     * Find all non-empty cells in the worksheet tab.
     */
    public KmSpreadsheetCellReader getReader()
    {
        return startQuery().getReader();
    }
}
