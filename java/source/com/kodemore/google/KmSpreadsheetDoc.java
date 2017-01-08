package com.kodemore.google;

import java.net.URL;
import java.util.List;

import com.google.gdata.client.spreadsheet.WorksheetQuery;
import com.google.gdata.data.spreadsheet.SpreadsheetEntry;
import com.google.gdata.data.spreadsheet.WorksheetEntry;
import com.google.gdata.data.spreadsheet.WorksheetFeed;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

/**
 * I represent a spreadsheet document.
 * I wrap the SpreadsheetEntry.
 * I am immutable.
 */
public class KmSpreadsheetDoc
{
    //##################################################
    //# instance creation
    //##################################################

    public static KmSpreadsheetDoc wrap(SpreadsheetEntry e)
    {
        return new KmSpreadsheetDoc(e);
    }

    public static KmList<KmSpreadsheetDoc> wrap(List<SpreadsheetEntry> v)
    {
        return KmList.wrap(v).collect(x -> wrap(x));
    }

    //##################################################
    //# variables
    //##################################################

    private SpreadsheetEntry _inner;

    //##################################################
    //# constructor
    //##################################################

    private KmSpreadsheetDoc(SpreadsheetEntry e)
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

    public String getKey()
    {
        return _inner.getKey();
    }

    /**
     * This url can be used to open the spreadsheet directly in a web browser.
     */
    public String getBrowserUrl()
    {
        return "http://spreadsheets.google.com/ccc?key=" + getKey();
    }

    //##################################################
    //# find
    //##################################################

    /**
     * Find all tabs.
     */
    public KmList<KmSpreadsheetTab> findTabs()
    {
        try
        {
            URL url = _inner.getWorksheetFeedUrl();
            Class<WorksheetFeed> clazz = WorksheetFeed.class;
            WorksheetFeed feed = _inner.getService().getFeed(url, clazz);
            List<WorksheetEntry> entries = feed.getEntries();
            return KmSpreadsheetTab.wrap(entries);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    /**
     * Find all tabs that match the title.
     */
    public KmList<KmSpreadsheetTab> findTabs(String title)
    {
        try
        {
            URL url = _inner.getWorksheetFeedUrl();

            WorksheetQuery q;
            q = new WorksheetQuery(url);
            q.setTitleQuery(title);
            q.setTitleExact(true);

            Class<WorksheetFeed> clazz = WorksheetFeed.class;
            WorksheetFeed feed = _inner.getService().getFeed(q, clazz);
            List<WorksheetEntry> entries = feed.getEntries();
            return KmSpreadsheetTab.wrap(entries);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    /**
     * Find the single tab that matches the title.
     * Return null if no match is found.
     * Throw an exception if multiple matches are found.
     */
    public KmSpreadsheetTab findUniqueTab(String title)
    {
        KmList<KmSpreadsheetTab> v = findTabs(title);

        if ( v.isEmpty() )
            return null;

        if ( v.isMultiple() )
            throw Kmu.newFatal("Spreadsheet tab is ambiguous: %s.", title);

        return v.getFirst();
    }

}
