package com.app.ui.control;

import com.kodemore.collection.KmList;

import com.app.model.MyCustomer;
import com.app.model.MySite;
import com.app.ui.selector.MySiteSelectorDialog;
import com.app.ui.selector.core.MyAbstractCustomerSelector;

public class MySiteSelector
    extends MyAbstractCustomerSelector<MySite>
{
    //##################################################
    //# constructor
    //##################################################

    public MySiteSelector()
    {
        setLabel("Site");
    }

    //##################################################
    //# security
    //##################################################

    @Override
    protected boolean allowsAddDefault()
    {
        return getProxy().allowsManageSites();
    }

    //##################################################
    //# find
    //##################################################

    @Override
    protected MySite findDomainChild(String uid)
    {
        return getAccess().findSiteUid(uid);
    }

    @Override
    protected KmList<MySite> findAllDomainChildrenFor(MyCustomer customer)
    {
        return customer.getSitesByFullName();
    }

    //##################################################
    //# dialog
    //##################################################

    @Override
    protected MySiteSelectorDialog getDialog()
    {
        return MySiteSelectorDialog.getInstance();
    }
}
