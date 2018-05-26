package com.app.ui.selector;

import com.kodemore.collection.KmList;

import com.app.model.MyProject;
import com.app.model.MyUser;
import com.app.ui.selector.core.MyAbstractProjectSelector;
import com.app.ui.selector.core.MyAbstractSelectorDialog;

public class MyMemberSelector
    extends MyAbstractProjectSelector<MyUser>
{
    //##################################################
    //# constructor
    //##################################################

    public MyMemberSelector()
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
    protected KmList<MyUser> findAllDomainChildrenFor(MyProject project)
    {
        return project.getMemberUsersByName();
    }

    //##################################################
    //# dialog
    //##################################################

    @Override
    protected MyAbstractSelectorDialog<MyProject,MyUser> getDialog()
    {
        return null;
    }
}
