package com.app.ui.selector;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.field.ScHiddenField;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.utility.KmEnumIF;
import com.kodemore.utility.KmVirtualOptions;

import com.app.model.MyChoice;
import com.app.model.MyProject;
import com.app.model.base.MyChoiceType;
import com.app.model.meta.MyMetaChoice;
import com.app.ui.selector.core.MyAbstractProjectSelectorDialog;
import com.app.utility.MyInstaller;

public class MyChoiceSelectorDialog
    extends MyAbstractProjectSelectorDialog<MyChoice>
{
    //##################################################
    //# instance
    //##################################################

    private static MyChoiceSelectorDialog _instance;

    public static MyChoiceSelectorDialog getInstance()
    {
        return _instance;
    }

    /**
     * @see MyInstaller#_installSelectorDialogs
     */
    public static void installInstance()
    {
        _instance = new MyChoiceSelectorDialog();
    }

    //##################################################
    //# variables
    //##################################################

    private ScHiddenField<String> _typeCodeField;
    private ScTextField           _nameField;

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
        MyMetaChoice x = MyChoice.Meta;

        ScTextField e;
        e = x.Name.newField();
        _nameField = e;
        return e;
    }

    //==================================================
    //= install :: hidden fields
    //==================================================

    @Override
    protected void installHiddenFieldsOn(ScDiv root)
    {
        root.add(createTypeCodeField());
    }

    private ScHiddenField<String> createTypeCodeField()
    {
        ScHiddenField<String> e;
        e = new ScHiddenField<>();
        _typeCodeField = e;
        return e;
    }

    //##################################################
    //# type
    //##################################################

    public MyChoiceType getChoiceType()
    {
        String code = _typeCodeField.getValue();
        return MyChoiceType.findCode(code);
    }

    public void setChoiceType(MyChoiceType e)
    {
        String code = KmEnumIF.getCodeFor(e);
        _typeCodeField.setValue(code);
    }

    public boolean hasChoiceType()
    {
        return getChoiceType() != null;
    }

    //##################################################
    //# title
    //##################################################

    @Override
    protected String getDomainChildTitle()
    {
        return hasChoiceType()
            ? getChoiceType().getLabel()
            : KmVirtualOptions.UNKNOWN;
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
        MyChoiceType type = getChoiceType();
        String name = field.getValue();

        boolean dup = getAccess().getChoiceDao().isDuplicateName(project, type, name);
        if ( dup )
            field.addError("Duplicate.");
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected MyChoice saveDomainChildFor(MyProject project)
    {
        MyChoice e;
        e = new MyChoice();
        e.setProject(project);
        e.setType(getChoiceType());
        e.applyFrom(this);
        e.daoAttach();
        return e;
    }

}
