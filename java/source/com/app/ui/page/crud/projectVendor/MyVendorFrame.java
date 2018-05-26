package com.app.ui.page.crud.projectVendor;

import com.app.model.MyProject;
import com.app.model.MyVendor;
import com.app.ui.page.crud.abstractBase.MyCrudFrame;

public class MyVendorFrame
    extends MyCrudFrame<MyProject,MyVendor>
{
    //##################################################
    //# constructor
    //##################################################

    public MyVendorFrame()
    {
        this(new MyVendorBuilder());
    }

    public MyVendorFrame(MyVendorBuilder e)
    {
        super(e);
    }

}
