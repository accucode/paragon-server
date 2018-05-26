package com.app.ui.page.crud.projectOption;

import com.app.ui.page.crud.projectOption.core.MyChoiceListPage;

public final class MySiteTypeListPage
    extends MyChoiceListPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MySiteTypeListPage _instance;

    public static void installInstance()
    {
        _instance = new MySiteTypeListPage();
    }

    public static MySiteTypeListPage getInstance()
    {
        return _instance;
    }

    //##################################################
    //# constructor
    //##################################################

    private MySiteTypeListPage()
    {
        super(new MySiteTypeBuilder());
    }
}
