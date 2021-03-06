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

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyDevSystemPropertiesPage
    extends MyPage
{
    //##################################################
    //# variables
    //##################################################

    private ScTransientContainer _container;

    //##################################################
    //# singleton
    //##################################################

    private static MyDevSystemPropertiesPage _instance;

    public static void installInstance()
    {
        _instance = new MyDevSystemPropertiesPage();
    }

    public static MyDevSystemPropertiesPage getInstance()
    {
        return _instance;
    }

    private MyDevSystemPropertiesPage()
    {
        // singleton
    }

    //##################################################
    //# settings
    //##################################################

    @Override
    public final MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.developer;
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().fill().auto().columnSpacer10();

        _container = root.addTransientContainer();
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        KmList<String> prefixes;
        prefixes = KmSystemProperties.getAllPrefixes();
        prefixes.sort(e -> e.toLowerCase());

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
