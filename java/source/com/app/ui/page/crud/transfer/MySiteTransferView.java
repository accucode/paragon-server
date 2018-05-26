package com.app.ui.page.crud.transfer;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.field.ScDomainDropdownField;

import com.app.model.MyCustomer;
import com.app.model.MyProject;
import com.app.model.MySite;
import com.app.model.transfer.MyTransferRoot;
import com.app.model.transfer.MyTransfers;
import com.app.utility.MyUserProxy;

public class MySiteTransferView
    extends MyAbstractTransferView<MySite>
{
    //##################################################
    //# variables
    //##################################################

    private ScDomainDropdownField<MyCustomer,String> _customerField;

    //##################################################
    //# projects
    //##################################################

    @Override
    protected boolean allowsSourceProject(MyProject from)
    {
        return MyUserProxy.createProxy(from).allowsProjectManager();
    }

    //##################################################
    //# fields
    //##################################################

    @Override
    protected void installAdditionalFieldsOn(ScDiv e)
    {
        e.addFieldLayout().add(createCustomerField());
    }

    private ScControl createCustomerField()
    {
        ScDomainDropdownField<MyCustomer,String> e;
        e = MyCustomer.Tools.newDomainDropdown();
        e.onChange(newCheckedAction(this::ajaxUpdateLists));
        e.setRequired();
        e.setNullSelectPrefix();
        e.setOptionSupplier(this::findSourceCustomers);
        e.disableChangeTracking();
        _customerField = e;
        return e;
    }

    private KmList<MyCustomer> findSourceCustomers()
    {
        MyProject project = getSourceProject();

        if ( project == null )
            return new KmList<>();

        return project.getCustomersByName();
    }

    @Override
    protected void handleSelectProject()
    {
        _customerField.ensureValidValue();
        _customerField.ajaxReplace();
    }

    //##################################################
    //# values
    //##################################################

    @Override
    protected KmList<MySite> getSourceValues()
    {
        MyCustomer customer = _customerField.getValue();

        if ( customer == null )
            return new KmList<>();

        return customer.getSitesByFullName();
    }

    @Override
    protected boolean isNewSourceValue(MySite sourceValue)
    {
        KmList<MySite> values = getTargetProject().getSitesByName();
        String name = sourceValue.getName();
        String customerName = sourceValue.getCustomerName();

        return !values.containsIf(e -> e.hasName(name) && e.hasCustomerName(customerName));
    }

    @Override
    protected KmList<MySite> findValues(KmList<String> uids)
    {
        return getAccess().getSiteDao().findOrderedUids(uids);
    }

    @Override
    protected String formatValue(MySite e)
    {
        return e.getFullName();
    }

    //##################################################
    //# import
    //##################################################

    @Override
    protected void importAll(KmList<MySite> sourceValues)
    {
        MyTransferRoot root;
        root = MyTransfers.create(getTargetProject());
        root.transferAll(sourceValues);
    }
}
