package com.app.ui.selector;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.field.ScHiddenField;
import com.kodemore.utility.KmEnumIF;

import com.app.model.MyChoice;
import com.app.model.MyProject;
import com.app.model.base.MyChoiceType;
import com.app.ui.selector.core.MyAbstractProjectSelector;
import com.app.ui.selector.core.MyAbstractSelectorDialog;

public class MyChoiceSelector
    extends MyAbstractProjectSelector<MyChoice>
{
    //##################################################
    //# variables
    //##################################################

    private ScHiddenField<String> _typeCodeField;

    //##################################################
    //# constructor
    //##################################################

    public MyChoiceSelector()
    {
        setLabel("Choice");
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installHiddenFieldsOn(ScDiv e)
    {
        e.add(createTypeCodeField());
    }

    private ScControl createTypeCodeField()
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

    //##################################################
    //# security
    //##################################################

    @Override
    protected boolean allowsAddDefault()
    {
        return getProxy().allowsManageChoiceType(getChoiceType());
    }

    //##################################################
    //# find
    //##################################################

    @Override
    protected MyChoice findDomainChild(String uid)
    {
        return getAccess().findChoiceUid(uid);
    }

    @Override
    protected KmList<MyChoice> findAllDomainChildrenFor(MyProject project)
    {
        return getAccess().getChoiceDao().findAllChoicesFor(project, getChoiceType());
    }

    //##################################################
    //# dialog
    //##################################################

    @Override
    protected MyAbstractSelectorDialog<MyProject,MyChoice> getDialog()
    {
        MyChoiceSelectorDialog e;
        e = MyChoiceSelectorDialog.getInstance();
        e.setChoiceType(getChoiceType());
        return e;
    }
}
