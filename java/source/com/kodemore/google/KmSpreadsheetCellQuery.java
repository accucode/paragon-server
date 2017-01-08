package com.kodemore.google;

import java.util.List;

import com.google.gdata.client.spreadsheet.CellQuery;
import com.google.gdata.data.spreadsheet.CellEntry;
import com.google.gdata.data.spreadsheet.CellFeed;
import com.google.gdata.data.spreadsheet.WorksheetEntry;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

/**
 * I am used to compose a cell query using various options.
 * By default, only non-empty cells are returned.
 * I wrap the WorksheetEntry and CellQuery classes.
 */
public class KmSpreadsheetCellQuery
{
    //##################################################
    //# instance creation
    //##################################################

    public static KmSpreadsheetCellQuery wrap(WorksheetEntry e)
    {
        return new KmSpreadsheetCellQuery(e);
    }

    //##################################################
    //# variables
    //##################################################

    private WorksheetEntry _worksheet;
    private CellQuery      _query;

    //##################################################
    //# constructor
    //##################################################

    private KmSpreadsheetCellQuery(WorksheetEntry e)
    {
        _worksheet = e;

        _query = new CellQuery(_worksheet.getCellFeedUrl());
        _query.setReturnEmpty(false);
    }

    //##################################################
    //# filter :: row
    //##################################################

    public void setRow(int i)
    {
        setMinimumRow(i);
        setMaximumRow(i);
    }

    public void setMinimumRow(int i)
    {
        _query.setMinimumRow(i);
    }

    public void setMaximumRow(int i)
    {
        _query.setMaximumRow(i);
    }

    //##################################################
    //# filter :: column
    //##################################################

    public void setColumn(int i)
    {
        setMinimumColumn(i);
        setMaximumColumn(i);
    }

    public void setMinimumColumn(int i)
    {
        _query.setMinimumCol(i);
    }

    public void setMaximumColumn(int i)
    {
        _query.setMaximumCol(i);
    }

    //##################################################
    //# filter :: empty cells
    //##################################################

    public void setIncludeEmptyCells(boolean e)
    {
        _query.setReturnEmpty(e);
    }

    //##################################################
    //# find
    //##################################################

    /**
     * Find all matching (non-empty) cells.
     */
    public KmList<KmSpreadsheetCell> getList()
    {
        try
        {
            CellFeed feed = _worksheet.getService().getFeed(_query, CellFeed.class);
            List<CellEntry> entries = feed.getEntries();
            return KmSpreadsheetCell.wrap(entries);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    /**
     * Find all matching (non-empty) cells.
     */
    public KmSpreadsheetCellReader getReader()
    {
        return new KmSpreadsheetCellReader(getList());
    }

}
