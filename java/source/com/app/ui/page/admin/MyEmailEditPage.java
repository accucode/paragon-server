package com.app.ui.page.admin;

import com.kodemore.collection.KmList;
import com.kodemore.filter.KmFilter;
import com.kodemore.filter.KmFilterFactoryIF;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScArray;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGrid;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScGroupArray;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScDropdown;
import com.kodemore.servlet.field.ScTextField;

import com.app.model.MyEmail;
import com.app.model.MyEmailRecipient;
import com.app.model.MyEmailRecipientType;
import com.app.model.meta.MyMetaEmail;
import com.app.model.meta.MyMetaEmailRecipient;

public class MyEmailEditPage
    extends MyAdminPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyEmailEditPage instance = new MyEmailEditPage();

    private MyEmailEditPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    @SuppressWarnings("unused")
    private ScGroup                  _summaryGroup;

    private ScDropdown               _recipientTypeField;
    private ScTextField              _recipientAddressField;
    private ScGrid<MyEmailRecipient> _recipientGrid;

    //##################################################
    //# navigation
    //##################################################

    @Override
    public ScParameterList composeUrlParameters()
    {
        return null;
    }

    @Override
    public void applyUrlParameters(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        ScGroupArray row;
        row = root.addGroupArray();

        addSummaryGroup(row);
        addRecipientGroup(row);
    }

    private void addSummaryGroup(ScGroupArray arr)
    {
        MyMetaEmail x = MyEmail.Meta;

        ScGroup group;
        group = arr.addGroup("Summary");

        ScForm form;
        form = group.addForm();

        ScFieldTable fields;
        fields = form.addFields();
        fields.addText(x.Uid);
        fields.addText(x.CreatedLocalTs);
        fields.addSpace();
        fields.addField(x.Subject);
        fields.addField(x.FromAddress);

        form.addButton("Update", newUpdateAction());

        _summaryGroup = group;
    }

    private void addRecipientGroup(ScGroupArray arr)
    {
        MyMetaEmailRecipient x = MyEmailRecipient.Meta;

        _recipientTypeField = new ScDropdown();
        _recipientTypeField.addOption(MyEmailRecipientType.To);
        _recipientTypeField.addOption(MyEmailRecipientType.Cc);
        _recipientTypeField.setValue(MyEmailRecipientType.To);

        _recipientAddressField = new ScTextField();

        _recipientGrid = new ScGrid<MyEmailRecipient>();
        _recipientGrid.setHeight(50);
        _recipientGrid.setFilterFactory(getRecipientFilter());
        _recipientGrid.track(getPageSession().getEmailUidHolder());

        _recipientGrid.addColumn(x.TypeCode, "Type").setWidth(100);
        _recipientGrid.addColumn(x.Address).setWidth(200);
        _recipientGrid.addLinkColumn("Remove", newRemoveRecipientAction(), x.Uid);

        ScContainer group;
        group = arr.addGroup("Recipients");

        ScArray row;
        row = group.addForm().addRow();
        row.add(_recipientTypeField);
        row.add(_recipientAddressField);
        row.addButton("Add", newAddRecipientAction());

        group.add(_recipientGrid);
    }

    private KmFilterFactoryIF<MyEmailRecipient> getRecipientFilter()
    {
        return new KmFilterFactoryIF<MyEmailRecipient>()
        {
            @Override
            public KmFilter<MyEmailRecipient> createFilter()
            {
                KmList<MyEmailRecipient> v;
                v = getEmail().getRecipients().toList();
                v.sortOn(MyEmailRecipient.Meta.Address);
                return v.toFilter();
            }
        };
    }

    //##################################################
    //# actions
    //##################################################

    private ScActionIF newUpdateAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleUpdate();
            }
        };
    }

    private ScActionIF newAddRecipientAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleAddRecipient();
            }
        };
    }

    private ScActionIF newRemoveRecipientAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleRemoveRecipient();
            }
        };
    }

    //##################################################
    //# handle
    //##################################################

    private void handleUpdate()
    {
        // MyEmail e;
        // e = getEmail();
        // e.applyFrom(_summaryGroup);
    }

    private void handleAddRecipient()
    {
        MyEmailRecipient e;
        e = new MyEmailRecipient();
        e.setTypeCode(_recipientTypeField.getStringValue());
        e.setAddress(_recipientAddressField.getValue());
        e.validate();

        getEmail().addRecipient(e);
        // print();
    }

    private void handleRemoveRecipient()
    {
        getEmail().removeRecipientUid(getStringArgument());
        // print();
    }

    //##################################################
    //# support
    //##################################################

    public MyEmail getEmail()
    {
        String uid = getPageSession().getEmailUid();
        return getAccess().getEmailDao().findUid(uid);
    }
}
