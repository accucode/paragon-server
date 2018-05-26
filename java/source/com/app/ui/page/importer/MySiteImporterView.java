package com.app.ui.page.importer;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScTable;
import com.kodemore.servlet.control.ScTableRow;
import com.kodemore.servlet.control.ScTransientDiv;
import com.kodemore.servlet.utility.ScFormatter;

import com.app.model.MySite;

public class MySiteImporterView
    extends MyImporterView<MySiteImporter>
{
    //##################################################
    //# domain
    //##################################################

    @Override
    protected String getDomainName()
    {
        return "site";
    }

    //##################################################
    //# importer
    //##################################################

    @Override
    protected MySiteImporter createBaseImporter()
    {
        MySiteImporter e;
        e = new MySiteImporter();
        e.setProject(getCurrentProject());
        return e;
    }

    //==================================================
    //= print :: Site summary
    //==================================================

    @Override
    protected void printSuccessSummaryOn(ScTransientDiv root, MySiteImporter importer)
    {
        ScTable table;
        table = root.addTable();
        table.css().dataTable();

        addSummaryHeaderTo(table);

        KmList<MySite> v = importer.getNewSites();

        for ( MySite site : v )
            addSummaryLineTo(table, site);

        addSummaryFooterTo(table, v.size());
    }

    private void addSummaryHeaderTo(ScTable table)
    {
        ScTableRow row;
        row = table.addRow();
        row.addHeader("Customer");
        row.addHeader("Number");
        row.addHeader("Name");
        row.addHeader("Type");
        row.addHeader("Time Zone");
        row.addHeader("Ceiling Height");
        row.addHeader("Cable Run");
        row.addHeader("Address");
    }

    private void addSummaryLineTo(ScTable table, MySite site)
    {
        String customer = site.getCustomerName();
        String number = site.getNumber();
        String name = site.getName();
        String type = site.getTypeName();
        String timeZone = site.getTimeZoneName();
        String address = site.getAddressShortLine();

        ScTableRow row;
        row = table.addRow();
        row.addCell(customer);
        row.addCell(number);
        row.addCell(name);
        row.addCell(type);
        row.addCell(timeZone);
        row.addCell(address);
    }

    private void addSummaryFooterTo(ScTable table, int count)
    {
        ScFormatter f = getFormatter();

        ScTableRow row;
        row = table.addRow();

        row.addCell("Total").css().bold();
        row.addCell(f.formatInteger(count)).css().textAlignRight().bold();
    }
}
