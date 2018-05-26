package com.app.ui.selector;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.field.ScTextField;

import com.app.model.MyProject;
import com.app.model.MyVendor;
import com.app.model.meta.MyMetaVendor;
import com.app.ui.selector.core.MyAbstractProjectSelectorDialog;
import com.app.utility.MyInstaller;

public class MyVendorSelectorDialog
    extends MyAbstractProjectSelectorDialog<MyVendor>
{
    //##################################################
    //# instance
    //##################################################

    private static MyVendorSelectorDialog _instance;

    public static MyVendorSelectorDialog getInstance()
    {
        return _instance;
    }

    /**
     * @see MyInstaller#_installSelectorDialogs
     */
    public static void installInstance()
    {
        _instance = new MyVendorSelectorDialog();
    }

    //##################################################
    //# variables
    //##################################################

    private ScTextField _nameField;

    //##################################################
    //# settings
    //##################################################

    @Override
    protected String getDomainChildTitle()
    {
        return MyVendor.Meta.getLabel();
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installFieldsOn(ScDiv root)
    {
        ScFieldTable e;
        e = root.addFieldTable();
        e.add(createNameField());
    }

    private ScTextField createNameField()
    {
        MyMetaVendor x = MyVendor.Meta;

        ScTextField e;
        e = x.Name.newField();
        _nameField = e;
        return e;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        super.validate();
        validateName();
    }

    private void validateName()
    {
        ScTextField field = _nameField;
        if ( field.hasErrors() )
            return;

        MyProject project = getDomainParent();
        String name = field.getValue();
        boolean dup = getAccess().getCustomerDao().isDuplicateName(project, name);
        if ( dup )
            field.addError("Duplicate.");
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected MyVendor saveDomainChildFor(MyProject project)
    {
        MyVendor e;
        e = project.addVendor();
        e.applyFrom(this);
        e.daoAttach();
        return e;
    }

}
