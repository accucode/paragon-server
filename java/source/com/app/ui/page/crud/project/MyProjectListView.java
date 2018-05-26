package com.app.ui.page.crud.project;

import com.app.model.MyProject;
import com.app.model.MyTenant;
import com.app.ui.page.crud.abstractBase.MyCrudListView;
import com.app.ui.page.guide.MyAddProjectDialog;

public final class MyProjectListView
    extends MyCrudListView<MyTenant,MyProject>
{
    //##################################################
    //# constructor
    //##################################################

    public MyProjectListView()
    {
        this(new MyProjectBuilder());
    }

    public MyProjectListView(MyProjectBuilder e)
    {
        super(e);
    }

    //##################################################
    //# handle add
    //##################################################

    /**
     * Projects are a special case and use a dialog for adding
     * rather than the standard crud card.
     */
    @Override
    protected void handleAdd()
    {
        ajaxPrintMessage();
        MyAddProjectDialog.getInstance().ajaxOpen();
    }
}
