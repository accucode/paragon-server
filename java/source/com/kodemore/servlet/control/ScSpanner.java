package com.kodemore.servlet.control;

/**
 * Used to span/merge cells in headers.
 * See main() below for usage.
 */
public class ScSpanner
{
    //##################################################
    //# variables
    //##################################################

    private ScSpannerCell[][] _columnRows;

    //##################################################
    //# constructor
    //##################################################

    public ScSpanner()
    {
        _columnRows = null;
    }

    //##################################################
    //# accessing
    //##################################################

    public void setSize(int col, int row)
    {
        _columnRows = new ScSpannerCell[col][row];
    }

    public void put(int col, int row, Object value)
    {
        ScSpannerCell e;
        e = new ScSpannerCell();
        e.setValue(value);

        _columnRows[col][row] = e;
    }

    public void run()
    {
        fill();
        merge();
    }

    public ScSpannerCell get(int c, int r)
    {
        return _columnRows[c][r];
    }

    public int getRowCount()
    {
        return _columnRows[0].length;
    }

    public int getColumnCount()
    {
        return _columnRows.length;
    }

    //##################################################
    //# support
    //##################################################

    private void fill()
    {
        int colSize = getColumnCount();
        int rowSize = getRowCount();

        for ( int c = 0; c < colSize; c++ )
            for ( int r = 0; r < rowSize; r++ )
                if ( !hasCell(c, r) )
                    put(c, r, null);
    }

    private void merge()
    {
        mergeEast(true);
        mergeSouth(true);

        mergeEast(false);
        mergeSouth(false);
    }

    private void mergeSouth(boolean skipNulls)
    {
        int colSize = getColumnCount();
        int rowSize = getRowCount();

        for ( int c = 0; c < colSize; c++ )
            for ( int r = 0; r < rowSize; r++ )
            {
                ScSpannerCell e = get(c, r);
                mergeSouth(e, c, r, skipNulls);
            }
    }

    private void mergeEast(boolean skipNulls)
    {
        int colSize = getColumnCount();
        int rowSize = getRowCount();

        for ( int c = 0; c < colSize; c++ )
            for ( int r = 0; r < rowSize; r++ )
            {
                ScSpannerCell e = get(c, r);
                mergeEast(e, c, r, skipNulls);
            }
    }

    private boolean mergeSouth(ScSpannerCell e, int c, int r, boolean skipNulls)
    {
        if ( e.isColumnSpan() )
            return false;

        if ( e.isNull() && skipNulls )
            return false;

        ScSpannerCell next = getSouthCell(c, r);
        if ( next == null )
            return false;

        if ( next.isColumnSpan() )
            return false;

        if ( next.isNull() || next.hasCellValue(e) )
        {
            next.setValue(e.getValue());
            next.setRowSpan();

            if ( !e.isRowSpan() )
                e.setFirstRowSpan();

            return true;
        }

        return false;
    }

    private boolean mergeEast(ScSpannerCell e, int c, int r, boolean skipNulls)
    {
        if ( e.isRowSpan() )
            return false;

        if ( e.isNull() && skipNulls )
            return false;

        ScSpannerCell next = getEastCell(c, r);
        if ( next == null )
            return false;

        if ( next.isRowSpan() )
            return false;

        if ( next.isNull() || next.hasCellValue(e) )
        {
            next.setValue(e.getValue());
            next.setColumnSpan();

            if ( !e.isColumnSpan() )
                e.setFirstColumnSpan();

            return true;
        }

        return false;
    }

    private ScSpannerCell getSouthCell(int c, int r)
    {
        r++;
        if ( r >= getRowCount() )
            return null;

        return get(c, r);
    }

    private ScSpannerCell getEastCell(int c, int r)
    {
        c++;
        if ( c >= getColumnCount() )
            return null;

        return get(c, r);
    }

    private boolean hasCell(int c, int r)
    {
        return get(c, r) != null;
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        ScSpanner spanner;
        spanner = new ScSpanner();
        spanner.setSize(5, 2);

        spanner.put(0, 0, "A");
        spanner.put(0, 1, "A");

        spanner.put(1, 0, "B0");
        spanner.put(1, 1, "B1");

        spanner.put(2, 0, "B0");
        spanner.put(2, 1, "B2");

        spanner.put(3, 0, null);
        spanner.put(3, 1, "D");

        spanner.put(4, 0, "E");
        spanner.put(4, 1, null);

        spanner.run();

        int rows = spanner.getRowCount();
        int cols = spanner.getColumnCount();

        for ( int r = 0; r < rows; r++ )
        {
            for ( int c = 0; c < cols; c++ )
            {
                ScSpannerCell cell = spanner.get(c, r);

                String span = "";
                if ( cell.isRowSpan() )
                    span += "r";
                if ( cell.isColumnSpan() )
                    span += "c";
                if ( cell.isFirst() )
                    span += "*";

                System.out.printf("%6s-%-2s", cell.getValue(), span);
            }
            System.out.println();
        }
    }
}
