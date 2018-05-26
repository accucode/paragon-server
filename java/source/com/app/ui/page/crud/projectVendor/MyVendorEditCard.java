package com.app.ui.page.crud.projectVendor;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.field.ScTextField;

import com.app.model.MyVendor;
import com.app.model.meta.MyMetaVendor;
import com.app.ui.page.crud.abstractBase.MyCrudEditCard;
import com.app.ui.page.crud.abstractBase.MyCrudLayout;

public class MyVendorEditCard
    extends MyCrudEditCard<MyVendor>
{
    //##################################################
    //# variables
    //##################################################

    private ScTextField _nameField;

    //##################################################
    //# constructor
    //##################################################

    public MyVendorEditCard()
    {
        super(new MyVendorBuilder());
    }

    public MyVendorEditCard(MyVendorBuilder e)
    {
        super(e);
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected MyCrudLayout getDetailLayout()
    {
        return MyCrudLayout.scroll;
    }

    @Override
    protected void installDetailsOn(ScDiv root)
    {
        MyMetaVendor x = MyVendor.Meta;

        ScFieldset set;
        set = root.addFieldset("General");

        ScFieldTable fields;
        fields = set.addFieldTable();
        fields.add(createNameField());
        fields.addField(x.Enabled);
    }

    private ScControl createNameField()
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

        MyVendor vendor = getDomainChild();
        String name = field.getValue();

        boolean dup = getAccess().getVendorDao().isDuplicateName(vendor, name);
        if ( dup )
            field.addError("Duplicate.");
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected void saveDomainChild(MyVendor e)
    {
        e.applyFrom(this);
    }

}
