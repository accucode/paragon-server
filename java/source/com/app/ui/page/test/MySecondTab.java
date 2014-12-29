package com.app.ui.page.test;

import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScGroup;

import com.app.ui.control.MyBox;

public class MySecondTab
    extends MyBox
{
    //##################################################
    //# install
    //##################################################

    @Override
    public void install()
    {
        super.install();

        ScBox root;
        root = this;
        root.css().pad10();
        root.setLabel("Two");

        installGroup(root);
    }

    private void installGroup(ScBox root)
    {
        ScGroup group;
        group = root.addGroup();
        group.setTitle("aaa");
        group.getBody().addPad().addText("second test group");
    }
}
