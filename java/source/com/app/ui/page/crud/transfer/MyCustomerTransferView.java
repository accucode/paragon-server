package com.app.ui.page.crud.transfer;

import com.kodemore.collection.KmList;

import com.app.model.MyCustomer;
import com.app.model.MyProject;
import com.app.model.transfer.MyTransferRoot;
import com.app.model.transfer.MyTransfers;
import com.app.utility.MyUserProxy;

public class MyCustomerTransferView
    extends MyAbstractTransferView<MyCustomer>
{
    //##################################################
    //# projects
    //##################################################

    @Override
    protected boolean allowsSourceProject(MyProject from)
    {
        return MyUserProxy.createProxy(from).allowsProjectManager();
    }

    //##################################################
    //# values
    //##################################################

    @Override
    protected KmList<MyCustomer> getSourceValues()
    {
        return getSourceProject().getCustomersByName();
    }

    @Override
    protected boolean isNewSourceValue(MyCustomer sourceValue)
    {
        KmList<MyCustomer> values = getTargetProject().getCustomersByName();
        String name = sourceValue.getName();

        return !values.containsIf(e -> e.hasName(name));
    }

    @Override
    protected KmList<MyCustomer> findValues(KmList<String> uids)
    {
        return getAccess().getCustomerDao().findOrderedUids(uids);
    }

    @Override
    protected String formatValue(MyCustomer e)
    {
        return e.getName();
    }

    //##################################################
    //# import
    //##################################################

    @Override
    protected void importAll(KmList<MyCustomer> sourceValues)
    {
        MyTransferRoot root;
        root = MyTransfers.create(getTargetProject());
        root.transferAll(sourceValues);
    }
}
