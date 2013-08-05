package com.app.ui.activity.test;

import com.app.model.MyAccount;
import com.app.model.MyAccountUser;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScArray;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDialog;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScFrame;
import com.kodemore.servlet.control.ScFrameChild;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.field.ScDropdown;
import com.kodemore.servlet.field.ScTextField;

public class MyManageAccountsPage
    extends MyAbstractTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyManageAccountsPage instance = new MyManageAccountsPage();

    private MyManageAccountsPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScDropdown   _dropdown;

    private ScFrame      _accountFrame;

    private ScTextField  _viewAccountName;
    private ScTextField  _viewAccountType;

    private ScTextField  _editAccountName;
    private ScTextField  _editAccountType;

    private ScTextField  _transferEmail;

    private ScFrameChild _viewAccountChild;
    private ScFrameChild _editAccountChild;

    private ScDropdown   _editTypeDropdown;

    private ScFrame      _transferFrame;

    private ScDialog     _deleteDialog;

    //##################################################
    //# install
    //##################################################

    @Override
    protected ScControl installRoot()
    {
        ScBox root;
        root = new ScBox();
        root.css().padSpaced();

        installDialog(root);
        installAccountsDropdown(root);

        ScArray row;
        row = root.addRow();

        installAccountFrame(row);
        installTransferBox(row);

        return root;
    }

    private void installDialog(ScBox root)
    {
        _deleteDialog = root.addDialog();
        _deleteDialog.getHeaderBox().hide();
        _deleteDialog.getFooterBox().hide();

        ScBox body = _deleteDialog.getBodyBox();

        ScGroup group;
        group = body.addGroup("Are you sure you want to delete this account user?");

        ScArray row;
        row = group.addRow();
        row.addPad().addButton("Yes", newDeleteAction());
        row.addPad().addButton("No", newCloseAction());
    }

    private void installAccountsDropdown(ScBox root)
    {
        // remove_valerie: 
        _dropdown = new ScDropdown();
        //        _dropdown = MyAccount.Tools.newTypeDropdown();

        ScGroup group;
        group = root.addGroup("Manage Accounts");

        ScBox body;
        body = group.addPadSpaced();
        body.add(_dropdown);
        body.addButton("Test", showView());
    }

    private void installAccountFrame(ScArray row)
    {
        _accountFrame = row.addFrame();

        installViewAccountFrame();
        installEditAccountFrame();
    }

    private void installViewAccountFrame()
    {
        ScFrameChild frame;
        frame = _accountFrame.createChild();

        ScGroup group;
        group = frame.addGroup("View");

        ScBox body;
        body = group.addBox();
        body.css().pad();

        _viewAccountName = new ScTextField();
        _viewAccountName.setLabel("Account name is ");
        _viewAccountName.setReadOnly();

        _viewAccountType = new ScTextField();
        _viewAccountType.setLabel("Account type is ");
        _viewAccountType.setReadOnly();

        ScFieldTable fields;
        fields = body.addFields();
        fields.add(_viewAccountName);
        fields.addSpace();
        fields.add(_viewAccountType);

        group.addDivider();

        ScDiv footer;
        footer = group.addButtonBox();
        footer.addButton("Edit", newShowEditAccountBoxAction());
        footer.addButton("Transfer", newShowTransferBoxAction());
        footer.addButton("Delete", newShowDeleteDialogAction());

        _viewAccountChild = frame;

    }

    private void installTransferBox(ScArray row)
    {
        _transferFrame = row.addFrame();

        ScFrameChild frame;
        frame = _transferFrame.createChild();

        ScGroup group;
        group = frame.addGroup("Transfer Account");

        ScBox body;
        body = group.addBox();
        body.css().pad();

        _transferEmail = new ScTextField();
        _transferEmail.setLabel("Email ");

        ScFieldTable fields;
        fields = body.addFields();
        fields.add(_transferEmail);

        group.addDivider();

        @SuppressWarnings("unused")
        ScDiv footer;
        footer = group.addButtonBox();
        // fixme_valerie: 
        //        footer.addButton("Send Request", newSendTransferRequestAction());
    }

    private void installEditAccountFrame()
    {
        ScActionIF saveAction = newEditAccountSaveAction();
        ScActionIF cancelAction = newEditAccountCancelAction();

        ScFrameChild frame;
        frame = _accountFrame.createChild();

        ScForm form;
        form = frame.addForm();
        form.setDefaultAction(saveAction);
        form.onEscape().run(cancelAction);

        ScGroup group;
        group = frame.addGroup("Edit");

        ScBox body;
        body = group.addBox();
        body.css().pad();

        _editAccountName = new ScTextField();
        _editAccountName.setLabel("Account name is ");

        _editAccountType = new ScTextField();
        _editAccountType.setLabel("Account type is ");

        ScFieldTable fields;
        fields = body.addFields();
        fields.add(_editAccountName);
        fields.addSpace();
        fields.add(_editAccountType);

        group.addDivider();

        ScDiv footer;
        footer = group.addButtonBoxRight();
        footer.addCancelButton(cancelAction);
        footer.addSubmitButton("Save");

        _editAccountChild = frame;
    }

    //##################################################
    //# action
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

    private ScActionIF showView()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleShowView();
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

    private ScActionIF newShowTransferBoxAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleShowTransferBox();
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
    //# start
    //##################################################

    @Override
    public void start()
    {
        KmList<String> accountNames;
        accountNames = new KmList<String>();

        KmList<MyAccount> accounts;
        accounts = getAccess().getAccountDao().findAll();

        for ( MyAccount account : accounts )
            accountNames.add(account.getName());

        // fixme_valerie: 
        _dropdown.ajaxUpdateValues();

        super.start();
    }

    //##################################################
    //# handle
    //##################################################

    private void handleShowDeleteDialog()
    {
        MyAccountUser e;
        e = getAccess().findAccountUserUid(getStringArgument());
        getPageSession().setAccountUser(e);

        _deleteDialog.ajaxOpen();
    }

    private void handleDelete()
    {
        MyAccountUser e;
        e = getPageSession().getAccountUser();
        e.deleteDao();

        _deleteDialog.ajaxClose();

        ajax().toast("Deleted account user %s", e.getUid());

        _dropdown.ajaxUpdateValues();
    }

    private void handleClose()
    {
        _deleteDialog.ajaxClose();
    }

    private void handleShowView()
    {
        String accountName;
        accountName = _dropdown.getStringValue();

        MyAccount account;
        account = getAccess().getAccountDao().findWithName(accountName);
        //remove_valerie: println
        System.out.println("    accountName: " + accountName);
        getPageSession().setAccount(account);

        _viewAccountName.setValue(account.getName());
        _viewAccountType.setValue(account.getType().getName());

        _viewAccountChild.ajaxPrint();
        _viewAccountChild.ajax().focus();
    }

    private void handleShowEditAccountBox()
    {
        MyAccount a;
        a = getPageSession().getAccount();

        if ( a != null )
            _editAccountName.setValue(a.getName());

        if ( a != null )
            _editTypeDropdown.setValue(a.getType());

        _editAccountChild.applyFromModel(a);
        _editAccountChild.ajaxPrint();
    }

    private void handleShowTransferBox()
    {
        _transferFrame.ajaxPrint();
    }

    private void handleEditAccountSave()
    {
        _editAccountChild.validate();

        if ( !_editAccountName.hasValue() )
        {
            ajax().toast("Please enter an account name");
            return;
        }

        MyAccount account;
        account = getPageSession().getAccount();

        if ( account == null )
            account = new MyAccount();

        account.setName(_editAccountName.getValue());

        MyAccountUser accountUser;
        accountUser = getPageSession().getAccountUser();
        accountUser.setAccount(account);

        if ( _editTypeDropdown.hasValue() )
            account.setTypeCode(_editTypeDropdown.getStringValue());

        account.saveDao();
        accountUser.saveDao();

        _dropdown.ajaxUpdateValues();
    }

    private void handleEditAccountCancel()
    {
        _accountFrame.ajaxClear();
    }
}
