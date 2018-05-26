package com.app.ui.page.crud.emailTemplate;

import com.app.model.MyEmailTemplate;
import com.app.model.MyProject;
import com.app.ui.page.crud.abstractBase.MyCrudListView;

public final class MyEmailTemplateListView
    extends MyCrudListView<MyProject,MyEmailTemplate>
{
    //##################################################
    //# constructor
    //##################################################

    public MyEmailTemplateListView()
    {
        this(new MyEmailTemplateBuilder());
    }

    public MyEmailTemplateListView(MyEmailTemplateBuilder e)
    {
        super(e);
    }
}
