package com.app.ui.page.tools;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScTable;
import com.kodemore.servlet.control.ScTableCell;
import com.kodemore.servlet.control.ScTableRow;
import com.kodemore.servlet.control.ScTransientContainer;
import com.kodemore.utility.KmSystemProperties;

public class MyDevSystemPropertiesPage
    extends MyDevAbstractPage
{
    //##################################################
    //# variables
    //##################################################

    private ScTransientContainer                  _container;

    //##################################################
    //# singleton
    //##################################################

    public static final MyDevSystemPropertiesPage instance = new MyDevSystemPropertiesPage();

    private MyDevSystemPropertiesPage()
    {
        // singleton
    }

    //##################################################
    //# navigation
    //##################################################

    @Override
    public ScParameterList composeQueryParameters()
    {
        return null;
    }

    @Override
    public void applyQueryParameters(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().gap();

        _container = root.addTransientContainer();
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        KmList<String> prefixes = KmSystemProperties.getAllPrefixes();
        for ( String e : prefixes )
            preRenderPrefix(e);
    }

    private void preRenderPrefix(String prefix)
    {
        ScGroup group;
        group = _container.addGroup(prefix);
        group.bodyCss().pad();

        ScTable table;
        table = group.getBody().addTable();

        KmList<String> keys = KmSystemProperties.getAllKeysForPrefix(prefix);
        for ( String key : keys )
        {
            String value = KmSystemProperties.getValue(key);

            ScTableRow row = table.addRow();

            ScTableCell cell;
            cell = row.addCell();
            cell.css().pad3().noWrap();
            cell.addText(key);

            cell = row.addCell();
            cell.css().pad3();
            cell.addText("=");

            cell = row.addCell();
            cell.css().pad3().wordBreakAll();
            cell.addText(value);
        }
    }
}
