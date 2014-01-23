package com.app.ui.page.test;

import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScOldGroup;

import com.app.ui.control.MyBox;

public class MyFirstTab
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
        root.setLabel("One");

        installGroup(root);
    }

    private void installGroup(ScBox root)
    {
        ScOldGroup group;
        group = root.addOldGroup();
        group.setTitle("bbb");
        group.addPad().addText("first test group");
    }
}
