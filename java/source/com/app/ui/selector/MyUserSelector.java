package com.app.ui.selector;

import com.kodemore.collection.KmList;

import com.app.model.MyTenant;
import com.app.model.MyUser;
import com.app.ui.selector.core.MyAbstractSelectorDialog;
import com.app.ui.selector.core.MyAbstractTenantSelector;

public class MyUserSelector
    extends MyAbstractTenantSelector<MyUser>
{
    //##################################################
    //# constructor
    //##################################################

    public MyUserSelector()
    {
        setLabel("User");
    }

    //##################################################
    //# security
    //##################################################

    @Override
    protected boolean allowsAddDefault()
    {
        return false;
    }

    //##################################################
    //# find
    //##################################################

    @Override
    protected MyUser findDomainChild(String uid)
    {
        return getAccess().findUserUid(uid);
    }

    @Override
    protected KmList<MyUser> findAllDomainChildrenFor(MyTenant tenant)
    {
        return tenant.getUsersByFullName();
    }

    //##################################################
    //# dialog
    //##################################################

    @Override
    protected MyAbstractSelectorDialog<MyTenant,MyUser> getDialog()
    {
        return null;
    }
}
