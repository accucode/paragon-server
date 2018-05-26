package com.app.ui.page.importer;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScTable;
import com.kodemore.servlet.control.ScTableRow;
import com.kodemore.servlet.control.ScTransientDiv;
import com.kodemore.servlet.utility.ScFormatter;

import com.app.model.MyCustomer;

public class MyCustomerImporterView
    extends MyImporterView<MyCustomerImporter>
{
    //##################################################
    //# domain
    //##################################################

    @Override
    protected String getDomainName()
    {
        return "customer";
    }

    //##################################################
    //# importer
    //##################################################

    @Override
    protected MyCustomerImporter createBaseImporter()
    {
        MyCustomerImporter e;
        e = new MyCustomerImporter();
        e.setProject(getCurrentProject());
        return e;
    }

    //==================================================
    //= print :: Customer summary
    //==================================================

    @Override
    protected void printSuccessSummaryOn(ScTransientDiv root, MyCustomerImporter importer)
    {
        ScTable table;
        table = root.addTable();
        table.css().dataTable();

        addSummaryHeaderTo(table);

        KmList<MyCustomer> v = importer.getNewCustomers();

        for ( MyCustomer Customer : v )
            addSummaryLineTo(table, Customer);

        addSummaryFooterTo(table, v.size());
    }

    private void addSummaryHeaderTo(ScTable table)
    {
        ScTableRow row;
        row = table.addRow();
        row.addHeader("Name");
        row.addHeader("Tier");
        row.addHeader("Billing Address");
    }

    private void addSummaryLineTo(ScTable table, MyCustomer customer)
    {
        String name = customer.getName();
        String billing = customer.getBillingAddressShortLine();

        ScTableRow row;
        row = table.addRow();
        row.addCell(name);
        row.addCell(billing);
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
