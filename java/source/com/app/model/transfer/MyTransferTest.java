package com.app.model.transfer;

import com.app.model.MyCustomer;
import com.app.model.MyProject;

public class MyTransferTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        new MyTransferTest().test();
    }

    //##################################################
    //# test
    //##################################################

    private void test()
    {
        MyTransferRoot root;
        root = MyTransfers.create(getTargetProject());
        root.transfer(getCustomer());
        root.debug();
        root.print();
    }

    private MyProject getTargetProject()
    {
        return null;
    }

    protected MyCustomer getCustomer()
    {
        return null;
    }
}
