package com.app.ui.layout;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.ScPage;
import com.kodemore.servlet.script.ScRootScript;
import com.kodemore.servlet.script.ScScriptIF;

import com.app.ui.page.admin.MyAdminPage;
import com.app.ui.page.general.MyHomePage;
import com.app.ui.page.test.MyTestPage;
import com.app.ui.page.tools.MyToolsPage;

public enum MyLeftMenuItem
{
    //##################################################
    //# values
    //##################################################

    home,
    admin,
    tools,
    tests;

    //##################################################
    //# static
    //##################################################

    public static MyLeftMenuItem getDefault()
    {
        return home;
    }

    public static MyLeftMenuItem findKey(String key)
    {
        for ( MyLeftMenuItem e : values() )
            if ( e.hasKey(key) )
                return e;

        return null;
    }

    public static KmList<MyLeftMenuItem> getValues()
    {
        return KmList.createWith(values());
    }

    //##################################################
    //# accessing 
    //##################################################

    public String getKey()
    {
        return name();
    }

    public boolean hasKey(String e)
    {
        return getKey().equals(e);
    }

    public String getTitle()
    {
        MyLeftMenuItem item = this;
        switch ( item )
        {
            case home:
                return "Home";

            case tests:
                return "Tests";

            case admin:
                return "Admin";

            case tools:
                return "Tools";
        }

        return name();
    }

    public ScScriptIF getAction()
    {
        MyLeftMenuItem item = this;
        switch ( item )
        {
            case home:
                return newPushScript(MyHomePage.instance);

            case tests:
                return newPushScript(MyTestPage.instance);

            case admin:
                return newPushScript(MyAdminPage.instance);

            case tools:
                return newPushScript(MyToolsPage.instance);
        }

        return null;
    }

    //##################################################
    //# support
    //##################################################

    private ScScriptIF newPushScript(ScPage e)
    {
        ScRootScript s;
        s = new ScRootScript();
        s.pushPage(e);
        return s;
    }
}
