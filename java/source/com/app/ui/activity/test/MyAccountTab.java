package com.app.ui.activity.test;

import com.app.filter.MyAccountFilter;
import com.app.model.MyAccount;
import com.app.model.MyAccountType;
import com.app.model.meta.MyMetaAccount;
import com.app.ui.control.MyBox;

import com.kodemore.filter.KmFilterFactoryIF;
import com.kodemore.filter.KmFilterIF;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScArray;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScDialog;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFilterBox;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScFrame;
import com.kodemore.servlet.control.ScFrameChild;
import com.kodemore.servlet.control.ScGrid;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.field.ScDropdown;
import com.kodemore.servlet.field.ScTextField;

public class MyAccountTab
    extends MyBox
{
    //##################################################
    //# variables
    //##################################################

    private ScDialog          _deleteDialog;

    private ScTextField       _searchNameField;
    private ScTextField       _addNameField;
    private ScTextField       _editNameField;

    private ScDropdown        _searchTypeDropdown;
    private ScDropdown        _addTypeDropdown;
    private ScDropdown        _editTypeDropdown;

    private ScFilterBox       _accountSearchBox;

    private ScGrid<MyAccount> _accountGrid;

    private ScFrame           _accountFrame;

    private ScFrameChild      _addAccountChild;
    private ScFrameChild      _editAccountChild;

    //##################################################
    //# install
    //##################################################

    @Override
    public void install()
    {
        super.install();

        ScBox root = this;
        root.css().pad10();
        root.setLabel("Accounts");

        installDialog(root);

        ScArray col;
        col = root.addColumn();

        installAccountSearchBox(col);

        root.addBreak();

        ScArray row;
        row = col.addRow();

        installAccountGrid(row);
        installAccountTarget(row);
    }

    private void installDialog(ScBox root)
    {
        _deleteDialog = root.addDialog();
        _deleteDialog.getHeaderBox().hide();
        _deleteDialog.getFooterBox().hide();

        ScBox body = _deleteDialog.getBodyBox();

        ScGroup group;
        group = body.addGroup("Are you sure you want to delete this account?");

        ScArray row;
        row = group.addRow();
        row.addPad().addButton("Yes", newDeleteAction());
        row.addPad().addButton("No", newCloseAction());
    }

    private void installAccountSearchBox(ScArray root)
    {
        _searchNameField = new ScTextField();
        _searchNameField.setLabel("Name contains ");

        _searchTypeDropdown = MyAccount.Tools.newTypeDropdown();
        _searchTypeDropdown.setLabel("Type is ");
        _searchTypeDropdown.addNullAnyPrefix();

        ScFilterBox box;
        box = root.addFilterBox();
        box.setTitle("Filter Accounts ");

        ScFieldTable fields;
        fields = box.addFields();
        fields.add(_searchNameField);
        fields.add(_searchTypeDropdown);

        box.setAction(newSearchAccountAction());

        _accountSearchBox = box;
    }

    private void installAccountGrid(ScArray row)
    {
        MyMetaAccount x = MyAccount.Meta;

        ScGroup group;
        group = row.addGroup();
        group.setTitle("Accounts");

        ScDiv right;
        right = group.getHeader().addFloatRight();
        right.css().pad5();
        right.addButton("Add Samples", newAddAccountSamplesAction());
        right.addButton("Add", newShowAddAccountBoxAction());

        ScGrid<MyAccount> grid;
        grid = group.addGrid();
        grid.trackAll(_accountSearchBox);
        grid.setFilterFactory(newAccountFetcher());
        grid.addColumn(x.Name).setCharacterWidth(15);
        grid.addColumn(x.TypeName).setCharacterWidth(8);
        grid.addLinkColumn("Edit", newShowEditAccountBoxAction(), x.Uid).setCharacterWidth(5);
        grid.addLinkColumn("Delete", newShowDeleteDialogAction(), x.Uid).setCharacterWidth(5);

        _accountGrid = grid;
    }

    private KmFilterFactoryIF<MyAccount> newAccountFetcher()
    {
        return new KmFilterFactoryIF<MyAccount>()
        {
            @Override
            public KmFilterIF<MyAccount> createFilter()
            {
                return newAccountFilter();
            }
        };
    }

    private KmFilterIF<MyAccount> newAccountFilter()
    {
        boolean hasName = _searchNameField.hasValue();
        boolean hasType = _searchTypeDropdown.hasValue();

        String name = _searchNameField.getValue();
        String type = _searchTypeDropdown.getStringValue();

        MyAccountFilter f;
        f = new MyAccountFilter();
        f.sortAscending();

        if ( hasName )
            f.setNameSubstring(name);

        if ( hasType )
            f.setTypeCode(type);

        return f;
    }

    private void installAccountTarget(ScArray row)
    {
        _accountFrame = row.addFrame();

        installAddAccountFrame();
        installEditAccountFrame();
    }

    private void installAddAccountFrame()
    {
        ScActionIF saveAction = newAddAccountSaveAction();
        ScActionIF cancelAction = newAddAccountCancelAction();

        ScFrameChild frame;
        frame = _accountFrame.createChild();

        ScForm form;
        form = addFormToFrame(saveAction, cancelAction, frame);

        ScGroup group;
        group = form.addGroup("Add");

        ScBox body;
        body = group.addBox();
        body.css().pad();

        _addNameField = new ScTextField();
        _addNameField.setLabel("Name ");

        _addTypeDropdown = MyAccount.Tools.newTypeDropdown();
        _addTypeDropdown.setLabel("Is type ");

        ScFieldTable fields;
        fields = body.addFields();
        fields.add(_addNameField);
        fields.add(_addTypeDropdown);

        group.addDivider();

        addFooterToGroup(cancelAction, group);

        _addAccountChild = frame;
    }

    private void installEditAccountFrame()
    {
        ScActionIF saveAction = newEditAccountSaveAction();
        ScActionIF cancelAction = newEditAccountCancelAction();

        ScFrameChild frame;
        frame = _accountFrame.createChild();

        ScForm form;
        form = addFormToFrame(saveAction, cancelAction, frame);

        ScGroup group;
        group = form.addGroup("Edit");

        ScBox body;
        body = group.addBox();
        body.css().pad();

        _editNameField = new ScTextField();
        _editNameField.setLabel("Name ");

        _editTypeDropdown = MyAccount.Tools.newTypeDropdown();
        _editTypeDropdown.setLabel("Is type ");

        ScFieldTable fields;
        fields = body.addFields();
        fields.add(_editNameField);
        fields.add(_editTypeDropdown);

        group.addDivider();

        addFooterToGroup(cancelAction, group);

        _editAccountChild = frame;
    }

    //##################################################
    //# actions
    //##################################################

    private ScActionIF newShowDeleteDialogAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleShowDeleteDialog();
            }
        };
    }

    private ScActionIF newDeleteAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleDelete();
            }
        };
    }

    private ScActionIF newCloseAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleClose();
            }
        };
    }

    private ScActionIF newSearchAccountAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleSearchAccount();
            }
        };
    }

    private ScActionIF newAddAccountSamplesAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleAddAccountSamples();
            }
        };
    }

    private ScActionIF newShowAddAccountBoxAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleShowAddAccountBox();
            }
        };
    }

    private ScActionIF newShowEditAccountBoxAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleShowEditAccountBox();
            }
        };
    }

    private ScActionIF newAddAccountSaveAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleAddAccountSave();
            }
        };
    }

    private ScActionIF newAddAccountCancelAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleAddAccountCancel();
            }
        };
    }

    private ScActionIF newEditAccountSaveAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleEditAccountSave();
            }
        };
    }

    private ScActionIF newEditAccountCancelAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleEditAccountCancel();
            }
        };
    }

    //##################################################
    //# handles
    //##################################################

    private void handleShowDeleteDialog()
    {
        MyAccount e;
        e = getAccess().findAccountUid(getStringArgument());
        getPageSession().setAccount(e);

        _deleteDialog.ajaxOpen();
    }

    private void handleDelete()
    {
        MyAccount e;
        e = getPageSession().getAccount();
        e.deleteDao();

        _deleteDialog.ajaxClose();

        ajax().toast("Deleted %s", e.getName());

        _accountGrid.ajaxReload();
    }

    private void handleClose()
    {
        _deleteDialog.ajaxClose();
    }

    private void handleSearchAccount()
    {
        _accountGrid.ajaxReload();
    }

    private void handleAddAccountSamples()
    {
        installAccount("MyPersonalAccount", MyAccountType.Personal);
        installAccount("Acme", MyAccountType.Business);

        ajax().toast("Added Samples");

        _accountGrid.ajaxReload();
    }

    private void handleShowAddAccountBox()
    {
        _addAccountChild.ajaxPrint();
        _addAccountChild.ajax().focus();
    }

    private void handleShowEditAccountBox()
    {
        MyAccount e;
        e = getAccess().findAccountUid(getStringArgument());
        getPageSession().setAccount(e);

        String name = e.getName();
        MyAccountType type = e.getType();

        _editNameField.setValue(name);
        _editTypeDropdown.setValue(type);

        _editAccountChild.applyFromModel(e);
        _editAccountChild.ajaxPrint();
    }

    private void handleAddAccountSave()
    {
        _addAccountChild.validate();

        boolean hasName = _addNameField.hasValue();
        boolean hasType = _addTypeDropdown.hasValue();

        if ( !hasName )
        {
            ajax().toast("Please enter a name");
            return;
        }

        String name = _addNameField.getValue();

        MyAccount account;
        account = new MyAccount();
        account.applyFrom(_addAccountChild);
        account.setName(name);

        if ( hasType )
        {
            String type = _addTypeDropdown.getStringValue();
            account.setTypeCode(type);
        }

        account.saveDao();

        _accountGrid.ajaxReload();
    }

    private void handleAddAccountCancel()
    {
        _accountFrame.ajaxClear();
    }

    private void handleEditAccountSave()
    {
        _editAccountChild.validate();

        boolean hasName = _editNameField.hasValue();
        boolean hasType = _editTypeDropdown.hasValue();

        if ( !hasName )
        {
            ajax().toast("Please enter a name");
            return;
        }

        String name = _editNameField.getValue();

        MyAccount account;
        account = getPageSession().getAccount();
        account.setName(name);

        if ( hasType )
        {
            String code = _editTypeDropdown.getStringValue();
            account.setTypeCode(code);
        }

        account.saveDao();

        _accountGrid.ajaxReload();
    }

    private void handleEditAccountCancel()
    {
        _accountFrame.ajaxClear();
    }

    //##################################################
    //# convenience
    //##################################################

    private void installAccount(String name, MyAccountType type)
    {
        MyAccount d;
        d = getAccess().getAccountDao().findWithName(name);

        if ( d != null )
            return;

        MyAccount e;
        e = new MyAccount();
        e.setName(name);
        e.setType(type);
        e.saveDao();
    }

    private ScForm addFormToFrame(ScActionIF saveAction, ScActionIF cancelAction, ScFrameChild frame)
    {
        ScForm form;
        form = frame.addForm();
        form.setDefaultAction(saveAction);
        form.onEscape().run(cancelAction);
        return form;
    }

    private void addFooterToGroup(ScActionIF cancelAction, ScGroup group)
    {
        ScDiv footer;
        footer = group.addButtonBoxRight();
        footer.addCancelButton(cancelAction);
        footer.addSubmitButton("Save");
    }

}
