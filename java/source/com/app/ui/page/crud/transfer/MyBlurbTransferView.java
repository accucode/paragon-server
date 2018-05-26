package com.app.ui.page.crud.transfer;

import com.kodemore.collection.KmList;

import com.app.criteria.MyBlurbCriteria;
import com.app.model.MyBlurb;
import com.app.model.MyProject;
import com.app.model.base.MyBlurbOwnerType;
import com.app.model.transfer.MyTransferRoot;
import com.app.model.transfer.MyTransfers;
import com.app.utility.MyUserProxy;

public class MyBlurbTransferView
    extends MyAbstractTransferView<MyBlurb>
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
    protected KmList<MyBlurb> getSourceValues()
    {
        return getSourceBlurbs();
    }

    @Override
    protected boolean isNewSourceValue(MyBlurb sourceValue)
    {
        KmList<MyBlurb> values = getTargetBlurbs();
        String name = sourceValue.getName();
        MyBlurbOwnerType type = sourceValue.getOwnerType();

        return !values.containsIf(e -> e.hasName(name) && e.hasOwnerType(type));
    }

    private KmList<MyBlurb> getSourceBlurbs()
    {
        MyBlurbCriteria c;
        c = getAccess().getBlurbDao().createCriteria();
        c.whereProjectIs(getSourceProject());
        c.whereEnabled().isTrue();
        c.sortOnName();
        return c.findAll();
    }

    private KmList<MyBlurb> getTargetBlurbs()
    {
        MyBlurbCriteria c;
        c = getAccess().getBlurbDao().createCriteria();
        c.whereProjectIs(getTargetProject());
        c.whereEnabled().isTrue();
        c.sortOnName();
        return c.findAll();
    }

    @Override
    protected KmList<MyBlurb> findValues(KmList<String> uids)
    {
        return getAccess().getBlurbDao().findOrderedUids(uids);
    }

    @Override
    protected String formatValue(MyBlurb e)
    {
        return e.getName();
    }

    //##################################################
    //# import
    //##################################################

    @Override
    protected void importAll(KmList<MyBlurb> sourceValues)
    {
        MyTransferRoot root;
        root = MyTransfers.create(getTargetProject());
        root.transferAll(sourceValues);
    }
}
