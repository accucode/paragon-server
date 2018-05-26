package com.app.ui.page.crud.emailTemplate;

import com.app.model.MyEmailTemplate;
import com.app.model.MyProject;
import com.app.ui.page.crud.abstractBase.MyCrudFrame;

public class MyEmailTemplateFrame
    extends MyCrudFrame<MyProject,MyEmailTemplate>
{
    //##################################################
    //# constructor
    //##################################################

    public MyEmailTemplateFrame()
    {
        this(new MyEmailTemplateBuilder());
    }

    public MyEmailTemplateFrame(MyEmailTemplateBuilder e)
    {
        super(e);
    }
}
