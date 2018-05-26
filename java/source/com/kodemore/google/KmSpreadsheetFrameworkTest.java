package com.kodemore.google;

import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.KmFiles;
import com.kodemore.utility.Kmu;

/**
 * This demonstrates the simpler spreadsheet usage based
 * on the Km utility classes.  For additional detail...
 * @see KmSpreadsheetApiTest
 */
public class KmSpreadsheetFrameworkTest
{
    public static void main(String[] args)
    {
        String accountId = "732718102431-p6ssejt62n8pdf4appin6cd8rk0l8he9@developer.gserviceaccount.com";
        String p12Path = "/temp/LifeCycle-eaf2070c1aa2.p12";
        String docTitle = "PAL - Purchasing Activity Log 2015 (COPY)";
        String tabTitle = "Activity Log";

        System.out.println("KmSpreadsheetTest");
        System.out.println("    account: " + accountId);
        System.out.println("    p12:     " + p12Path);
        System.out.println("    doc:     " + docTitle);
        System.out.println("    tab:     " + tabTitle);

        KmSpreadsheetService svc;
        svc = new KmSpreadsheetService();
        svc.setAccountId(accountId);
        svc.setP12FromFile(p12Path);

        KmSpreadsheetDoc doc = svc.findUniqueDoc(docTitle);
        KmSpreadsheetTab tab = doc.findUniqueTab(tabTitle);

        KmSpreadsheetCellQuery query;
        query = tab.startQuery();
        query.setMaximumRow(5);
        // query.setMaximumColumn(26);

        //        KmList<KmSpreadsheetCell> cells = query.getList();
        //        for ( KmSpreadsheetCell cell : cells )
        //            System.out.println(cell.getTitle() + " => " + cell.getValue());

        KmStringBuilder out = new KmStringBuilder();
        KmSpreadsheetCellReader reader = query.getReader();

        while ( reader.nextRecord() )
        {
            out.println();
            out.printfln("--- record %,d ---", reader.getRowIndex());

            int n = reader.getColumnCount();
            for ( int i = 0; i < n; i++ )
            {
                String value = reader.getString(i);
                String line = Kmu.getFirstLine(value);
                out.print(line);
                out.print(",");
            }

            out.println();
        }

        KmFiles.writeString("/temp/out.txt", out.toString());
    }
}
