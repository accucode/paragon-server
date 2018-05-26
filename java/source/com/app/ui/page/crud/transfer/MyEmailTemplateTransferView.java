package com.app.ui.page.crud.transfer;

import com.kodemore.collection.KmList;

import com.app.criteria.MyEmailTemplateCriteria;
import com.app.model.MyEmailTemplate;
import com.app.model.MyProject;
import com.app.model.base.MyEmailTemplateContextType;
import com.app.model.transfer.MyTransferRoot;
import com.app.model.transfer.MyTransfers;
import com.app.utility.MyUserProxy;

public class MyEmailTemplateTransferView
    extends MyAbstractTransferView<MyEmailTemplate>
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
    protected KmList<MyEmailTemplate> getSourceValues()
    {
        KmList<MyEmailTemplate> v;
        v = getSourceProject().getEmailTemplatesByName();
        v.retainIf(e -> e.isEnabled());
        return v;
    }

    @Override
    protected boolean isNewSourceValue(MyEmailTemplate sourceValue)
    {
        KmList<MyEmailTemplate> values = getTargetEmailTemplates();
        String name = sourceValue.getName();
        MyEmailTemplateContextType type = sourceValue.getContextType();

        return !values.containsIf(e -> e.hasName(name) && e.hasContextType(type));
    }

    private KmList<MyEmailTemplate> getTargetEmailTemplates()
    {
        MyEmailTemplateCriteria c;
        c = getAccess().getEmailTemplateDao().createCriteria();
        c.whereProjectIs(getTargetProject());
        c.whereEnabled().isTrue();
        c.sortOnName();
        return c.findAll();
    }

    @Override
    protected KmList<MyEmailTemplate> findValues(KmList<String> uids)
    {
        return getAccess().getEmailTemplateDao().findOrderedUids(uids);
    }

    @Override
    protected String formatValue(MyEmailTemplate e)
    {
        return e.getName();
    }

    //##################################################
    //# import
    //##################################################

    @Override
    protected void importAll(KmList<MyEmailTemplate> sourceValues)
    {
        MyTransferRoot root;
        root = MyTransfers.create(getTargetProject());
        root.transferAll(sourceValues);
    }
}
