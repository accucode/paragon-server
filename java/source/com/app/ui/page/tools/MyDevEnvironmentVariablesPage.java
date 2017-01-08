package com.app.ui.page.tools;

import java.util.Set;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScTable;
import com.kodemore.servlet.control.ScTableCell;
import com.kodemore.servlet.control.ScTableRow;
import com.kodemore.servlet.control.ScTransientContainer;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyDevEnvironmentVariablesPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyDevEnvironmentVariablesPage _instance;

    public static void installInstance()
    {
        _instance = new MyDevEnvironmentVariablesPage();
    }

    public static MyDevEnvironmentVariablesPage getInstance()
    {
        return _instance;
    }

    private MyDevEnvironmentVariablesPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScTransientContainer _container;

    //##################################################
    //# settings
    //##################################################

    @Override
    public final MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.developer;
    }

    //##################################################
    //# bookmark
    //##################################################

    @Override
    public void composeBookmarkOn(ScParameterList v)
    {
        // none
    }

    @Override
    public void applyBookmark(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().fill();

        ScGroup group;
        group = root.addGroup("Environment Variables");
        group.css().fill();

        ScDiv body;
        body = group.getBody();
        body.css().pad().auto();

        _container = body.addTransientContainer();
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        composeProperties();
    }

    private void composeProperties()
    {
        ScTable table = _container.addTable();

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
    }

    private KmList<String> getKeys()
    {
        Set<String> names = System.getenv().keySet();

        KmList<String> v;
        v = new KmList<>();
        v.addAll(names);
        v.sort();
        return v;
    }

    private String getValueFor(String key)
    {
        return System.getenv(key);
    }

}
