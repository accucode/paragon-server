package com.app.model.transfer;

import com.app.model.MyProject;

public class MyTransfers
{
    public static MyTransferRoot create(MyProject to)
    {
        MyTransferRoot root;
        root = new MyTransferRoot();
        root.setTargetProject(to);
        return root;
    }
}
