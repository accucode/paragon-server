package com.app.ui.page.importer.base;

import com.kodemore.utility.Kmu;

/**
 * A tool to import charges from CSV.
 */
public class MyImporterError
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The Record index corresponds to the row in the spreadsheet.
     * This may be different from the line number in the csv text file
     * if the spreadsheet contains multiline text values.
     */
    private int _recordIndex;

    /**
     * The pertinent column. If the column is not known, this
     * may display some other indicator such as "header" or "unknkown".
     */
    private String _columnName;

    /**
     * A short message describing the problem.
     */
    private String _message;

    //##################################################
    //# constructor
    //##################################################

    public MyImporterError()
    {
        // none
    }

    //##################################################
    //# record
    //##################################################

    public int getRecordIndex()
    {
        return _recordIndex;
    }

    public void setRecordIndex(int i)
    {
        _recordIndex = i;
    }

    public int getRecordNumber()
    {
        return _recordIndex + 1;
    }

    //##################################################
    //# column
    //##################################################

    public String getColumnName()
    {
        return _columnName;
    }

    public void setColumnName(String e)
    {
        _columnName = e;
    }

    //##################################################
    //# message
    //##################################################

    public String getMessage()
    {
        return _message;
    }

    public void setMessage(String e)
    {
        _message = e;
    }

    public void setMessage(String msg, Object... args)
    {
        String s = Kmu.format(msg, args);
        setMessage(s);
    }

}
