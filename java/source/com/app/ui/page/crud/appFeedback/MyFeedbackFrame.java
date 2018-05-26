package com.app.ui.page.crud.appFeedback;

import com.app.model.MyFeedback;
import com.app.model.core.MyNullDomain;
import com.app.ui.page.crud.abstractBase.MyCrudFrame;

public class MyFeedbackFrame
    extends MyCrudFrame<MyNullDomain,MyFeedback>
{
    //##################################################
    //# constructor
    //##################################################

    public MyFeedbackFrame()
    {
        this(new MyFeedbackBuilder());
    }

    public MyFeedbackFrame(MyFeedbackBuilder e)
    {
        super(e);
    }
}
