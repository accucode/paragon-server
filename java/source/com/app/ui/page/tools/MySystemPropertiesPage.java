package com.app.ui.page.tools;

import java.util.Set;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScLiteral;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScTable;
import com.kodemore.servlet.control.ScTableCell;
import com.kodemore.servlet.control.ScTableRow;

import com.app.ui.page.MyPage;

public class MySystemPropertiesPage
    extends MyToolsPage
{
    //##################################################
    //# variables
    //##################################################

    private ScLiteral              _literal;

    //##################################################
    //# singleton
    //##################################################

    public static final MyPage instance = new MySystemPropertiesPage();

    private MySystemPropertiesPage()
    {
        // singleton
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().gap();

        ScGroup group;
        group = root.addGroup("System Properties");

        _literal = group.addPad().addLiteral();
    }

    //##################################################
    //# prePrint
    //##################################################

    @Override
    protected void preRender()
    {
        String html = composeProperties();
        _literal.setValue(html);
    }

    private String composeProperties()
    {
        ScTable table = new ScTable();

        for ( String key : getKeys() )
        {
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
            cell.addText(getValueFor(key));
        }

        return table.renderHtml();
    }

    private KmList<String> getKeys()
    {
        Set<String> names = System.getProperties().stringPropertyNames();

        KmList<String> v;
        v = new KmList<String>();
        v.addAll(names);
        v.sort();
        return v;
    }

    private String getValueFor(String key)
    {
        return System.getProperty(key);
    }

}
