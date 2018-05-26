package com.app.ui.page.crud.projectVendor;

import com.app.model.MyProject;
import com.app.model.MyVendor;
import com.app.ui.page.crud.abstractBase.MyCrudListView;

public final class MyVendorListView
    extends MyCrudListView<MyProject,MyVendor>
{
    //##################################################
    //# constructor
    //##################################################

    public MyVendorListView()
    {
        this(new MyVendorBuilder());
    }

    public MyVendorListView(MyVendorBuilder e)
    {
        super(e);
    }
}
