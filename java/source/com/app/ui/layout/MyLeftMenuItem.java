package com.app.ui.layout;

import com.kodemore.collection.KmList;

import com.app.model.MyAccount;
import com.app.ui.activity.MySubPage;
import com.app.ui.activity.general.MyHomePage;
import com.app.ui.activity.test.MyTestMenuPage;
import com.app.ui.activity.tools.MyToolsMenuPage;
import com.app.ui.core.MyPageSession;
import com.app.utility.MyGlobals;

public enum MyLeftMenuItem
{
    //##################################################
    //# values
    //##################################################

    home,
    currentAccount,
    allAccounts,
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
            case allAccounts:
                return "All Accounts";

            case currentAccount:
                MyAccount a = getPageSession().getCurrentAccount();
                if ( a == null )
                    return "None";
                return a.getName();

            case home:
                return "Home";

            case tests:
                return "Tests";

            case tools:
                return "Tools";
        }

        return name();
    }

    // todo menu pages: 
    public MySubPage getPage()
    {
        MyLeftMenuItem item = this;
        switch ( item )
        {
            case allAccounts:
                return MyHomePage.instance;

            case currentAccount:
                return MyHomePage.instance;

            case home:
                return MyHomePage.instance;

            case tests:
                return MyTestMenuPage.instance;

            case tools:
                return MyToolsMenuPage.instance;
        }

        return null;
    }

    //##################################################
    //# support
    //##################################################

    private MyPageSession getPageSession()
    {
        return MyGlobals.getPageSession();
    }

}
