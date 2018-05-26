package com.kodemore.google;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmSparseArray2;
import com.kodemore.csv.KmCellReaderIF;
import com.kodemore.utility.Kmu;

/**
 * I provide a row-wise reader for cell data.
 *
 * We typically fetch a sparse list of cells from Google, and
 * do NOT fetch the empty cells.  This can have a significant
 * impact on network and memory, but makes processing the
 * results much more complicated.
 *
 * This reader provides a way to process that sparse result
 * as normalized rows and columns.
 */
public class KmSpreadsheetCellReader
    implements KmCellReaderIF
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The sparse list of cells.
     */
    private KmSparseArray2<KmSpreadsheetCell> _cells;

    /**
     * The index of the NEXT value.
     */
    private int _rowIndex;

    /**
     * The index of the NEXT value.
     */
    private int _columnIndex;

    /**
     * The number of rows detected.
     */
    private int _rowCount;

    /**
     * The maximum number of columns detected for any row.
     */
    private int _columnCount;

    //##################################################
    //# constructor
    //##################################################

    public KmSpreadsheetCellReader(KmList<KmSpreadsheetCell> v)
    {
        installCells(v);

        _rowIndex = -1;
        _columnIndex = -1;
    }

    //##################################################
    //# accessing
    //##################################################

    public int getRowIndex()
    {
        return _rowIndex;
    }

    /**
     * This is only used if the client is using getString (rather than getStringAt).
     */
    public int getColumnIndex()
    {
        return _columnIndex;
    }

    public int getRowCount()
    {
        return _rowCount;
    }

    public int getColumnCount()
    {
        return _columnCount;
    }

    //==================================================
    //= accessing :: record
    //==================================================

    /**
     * Read the next record (row); this must be called before the first
     * record is accessed.  Return true if a record is read, false
     * if end of file.
     */
    @Override
    public boolean nextRecord()
    {
        if ( _rowCount == 0 )
            return false;

        if ( _rowIndex < 0 )
        {
            _rowIndex = 0;
            _columnIndex = 0;
            return true;
        }

        if ( _rowIndex >= _rowCount )
            return false;

        _rowIndex++;
        _columnIndex = 0;
        return true;
    }

    //==================================================
    //= accessing :: cell
    //==================================================

    @Override
    public String getString()
    {
        return getString(_columnIndex++);
    }

    @Override
    public String getString(int col)
    {
        KmSpreadsheetCell e = _cells.getValueAt(_rowIndex, col);

        return e == null
            ? ""
            : e.getValue();
    }

    @Override
    public int getInteger(int col, int def)
    {
        String s = getString(col);
        return Kmu.parse_int(s, def);
    }

    @Override
    public Boolean getBooleanObject(int col)
    {
        String s = getString(col);
        return Kmu.parseBoolean(s, null);
    }

    //##################################################
    //# support
    //##################################################

    private void installCells(KmList<KmSpreadsheetCell> v)
    {
        KmSparseArray2<KmSpreadsheetCell> arr = new KmSparseArray2<>();
        int maxRow = -1;
        int maxCol = -1;

        for ( KmSpreadsheetCell e : v )
        {
            int row = e.getRowIndex();
            int col = e.getColumnIndex();

            arr.setValueAt(row, col, e);

            if ( row > maxRow )
                maxRow = row;

            if ( col > maxCol )
                maxCol = col;
        }

        _cells = arr;
        _rowCount = maxRow + 1;
        _columnCount = maxCol + 1;
    }

}
