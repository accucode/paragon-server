package com.app.ui.page.test;

import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScOldGroup;

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
        ScOldGroup group;
        group = root.addOldGroup();
        group.setTitle("aaa");
        group.addPad().addText("second test group");
    }
}
