package com.app.ui.page.crud.projectOption;

import com.app.model.MyChoice;
import com.app.model.base.MyChoiceType;
import com.app.ui.page.crud.projectOption.core.MyChoiceBuilder;

public class MySiteTypeBuilder
    extends MyChoiceBuilder
{
    //##################################################
    //# topic
    //##################################################

    @Override
    public MyChoiceType getType()
    {
        return MyChoiceType.SiteType;
    }

    //##################################################
    //# child
    //##################################################

    @Override
    public String getChildPopoutUrlFor(MyChoice c)
    {
        return MySiteTypeListPage.getInstance().formatEntryUrlFor(c);
    }
}
