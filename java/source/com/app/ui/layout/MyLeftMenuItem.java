package com.app.ui.layout;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.action.ScActionIF;

import com.app.ui.page.admin.MyAdminMenuPage;
import com.app.ui.page.general.MyHomePage;
import com.app.ui.page.test.MyTestMenuPage;
import com.app.ui.page.tools.MyToolsMenuPage;

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

    public ScActionIF getAction()
    {
        MyLeftMenuItem item = this;
        switch ( item )
        {
            case home:
                return MyHomePage.instance.getStartAction();

            case tests:
                return MyTestMenuPage.instance.getStartAction();

            case admin:
                return MyAdminMenuPage.instance.getStartAction();

            case tools:
                return MyToolsMenuPage.instance.getStartAction();
        }

        return null;
    }
}
