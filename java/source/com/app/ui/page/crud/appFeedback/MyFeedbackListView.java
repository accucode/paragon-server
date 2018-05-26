package com.app.ui.page.crud.appFeedback;

import com.app.model.MyFeedback;
import com.app.model.core.MyNullDomain;
import com.app.ui.page.crud.abstractBase.MyCrudListView;

public final class MyFeedbackListView
    extends MyCrudListView<MyNullDomain,MyFeedback>
{
    //##################################################
    //# constructor
    //##################################################

    public MyFeedbackListView()
    {
        this(new MyFeedbackBuilder());
    }

    public MyFeedbackListView(MyFeedbackBuilder e)
    {
        super(e);
    }
}
