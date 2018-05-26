package com.app.ui.info;

import java.util.function.Function;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.control.ScFieldsetWrapper;

import com.app.model.MyCustomer;
import com.app.model.MySite;
import com.app.model.MyUser;
import com.app.model.MyVendor;

public class MyRelatedInfoFieldset
    extends ScFieldsetWrapper
{
    //##################################################
    //# variables
    //##################################################

    private ScFieldTable _fieldTable;

    //##################################################
    //# constructor
    //##################################################

    public MyRelatedInfoFieldset()
    {
        String s = "Related Info";

        setLabel(s);

        ScFieldset set;
        set = getInner();
        set.setLabel(s);
        set.add(createFieldTable());
    }

    private ScControl createFieldTable()
    {
        ScFieldTable e;
        e = new ScFieldTable();
        _fieldTable = e;
        return e;
    }

    //##################################################
    //# convenience
    //##################################################

    public MyUserInfo addUserInfo(Function<?,MyUser> fn)
    {
        MyUserInfo e;
        e = new MyUserInfo();
        e.setTargetFunction(fn);
        return _addInfo(e);
    }

    public MyCustomerInfo addCustomerInfo(Function<?,MyCustomer> fn)
    {
        MyCustomerInfo e;
        e = new MyCustomerInfo();
        e.setTargetFunction(fn);
        return _addInfo(e);
    }

    public MyVendorInfo addVendorInfo(Function<?,MyVendor> fn)
    {
        MyVendorInfo e;
        e = new MyVendorInfo();
        e.setTargetFunction(fn);
        return _addInfo(e);
    }

    public MySiteInfo addSiteInfo(Function<?,MySite> fn)
    {
        MySiteInfo e;
        e = new MySiteInfo();
        e.setTargetFunction(fn);
        return _addInfo(e);
    }

    //##################################################
    //# support
    //##################################################

    public <T extends ScControl> T _addInfo(T e)
    {
        return _fieldTable.add(e);
    }

}
