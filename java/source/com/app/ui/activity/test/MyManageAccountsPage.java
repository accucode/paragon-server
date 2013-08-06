package com.app.ui.activity.test;

import com.app.filter.MyAccountUserFilter;
import com.app.model.MyAccount;
import com.app.model.MyAccountUser;
import com.app.model.MyUser;
import com.app.model.meta.MyMetaAccountUser;
import com.app.model.meta.MyMetaUser;
import com.app.utility.MyButtonUrls;

import com.kodemore.adaptor.KmAdaptorIF;
import com.kodemore.collection.KmList;
import com.kodemore.filter.KmFilter;
import com.kodemore.filter.KmFilterFactoryIF;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScArray;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScDialog;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScFrame;
import com.kodemore.servlet.control.ScFrameChild;
import com.kodemore.servlet.control.ScGrid;
import com.kodemore.servlet.control.ScGridColumn;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
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

    private ScDropdown            _accountDropdown;
    private ScDropdown            _editTypeDropdown;
    private ScDropdown            _addAccountType;
    private ScDropdown            _editRoleDropdown;

    private ScFrame               _accountFrame;

    private ScTextField           _viewAccountName;
    private ScTextField           _viewAccountType;
    private ScTextField           _editAccountName;
    private ScTextField           _addAccountName;
    private ScTextField           _transferEmail;
    private ScTextField           _editUserName;
    private ScTextField           _editUserEmail;
    private ScTextField           _viewUserName;
    private ScTextField           _viewUserEmail;
    private ScTextField           _viewUserRole;

    private ScFrameChild          _viewAccountChild;
    private ScFrameChild          _editAccountChild;
    private ScFrameChild          _addAccountChild;
    private ScFrameChild          _viewUserChild;
    private ScFrameChild          _editUserChild;
    private ScFrameChild          _addUserChild;
    private ScFrameChild          _transferChild;

    private ScFrame               _transferFrame;
    private ScFrame               _userFrame;

    private ScDialog              _deleteAccountDialog;

    private ScGrid<MyAccountUser> _userGrid;

    private String                _inviteUserLabel;

    //##################################################
    //# install
    //##################################################

    @Override
    protected ScPageRoot installRoot()
    {
        ScPageRoot root;
        root = newPageRoot();
        root.css().padSpaced();

        installDeleteAccountDialog(root);
        installAccountsDropdown(root);

        ScArray row;
        row = root.addRow();

        installAccountFrame(row);
        installTransferBox(row);

        ScArray row2;
        row2 = root.addRow();

        installUserGrid(row2);
        installUserFrame(row2);

        return root;
    }

    private void installDeleteAccountDialog(ScBox root)
    {
        _deleteAccountDialog = root.addDialog();
        _deleteAccountDialog.getHeaderBox().hide();
        _deleteAccountDialog.getFooterBox().hide();

        ScBox body = _deleteAccountDialog.getBodyBox();

        ScGroup group;
        group = body.addGroup("Are you sure you want to delete this account?");

        ScArray row;
        row = group.addRow();
        row.addPad().addButton("Yes", newDeleteAccountAction());
        row.addPad().addButton("No", newCloseAction());
    }

    private void installAccountsDropdown(ScBox root)
    {
        _accountDropdown = new ScDropdown();

        ScGroup group;
        group = root.addGroup("Manage Accounts");

        ScForm form;
        form = group.addForm();

        ScBox body;
        body = form.addPadSpaced();
        body.add(_accountDropdown);
        body.addButton("Update", newUpdateValuesAction());
        body.addButton("Add Account", newShowAddAccountBoxAction());
    }

    private void installAccountFrame(ScArray row)
    {
        _accountFrame = row.addFrame();

        installViewAccountFrame();
        installEditAccountFrame();
        installAddAccountFrame();
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

        ScDiv footer;
        footer = group.addButtonBox();
        footer.addButton("Send Request", newSendTransferRequestAction());
        footer.addCancelButton(newCancelTransferRequestAction());

        _transferChild = frame;
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

        _editTypeDropdown = MyAccount.Tools.newTypeDropdown();
        _editTypeDropdown.setLabel("Account type is ");

        ScFieldTable fields;
        fields = body.addFields();
        fields.add(_editAccountName);
        fields.addSpace();
        fields.add(_editTypeDropdown);

        group.addDivider();

        ScDiv footer;
        footer = group.addButtonBoxRight();
        footer.addCancelButton(cancelAction);
        footer.addSubmitButton("Save");

        _editAccountChild = frame;
    }

    private void installAddAccountFrame()
    {
        ScActionIF saveAction = newAddAccountSaveAction();
        ScActionIF cancelAction = newAddAccountCancelAction();

        ScFrameChild frame;
        frame = _accountFrame.createChild();

        ScForm form;
        form = frame.addForm();
        form.setDefaultAction(saveAction);
        form.onEscape().run(cancelAction);

        ScGroup group;
        group = form.addGroup("Add");

        ScBox body;
        body = group.addBox();
        body.css().pad();

        _addAccountName = new ScTextField();
        _addAccountName.setLabel("Account name is ");

        _addAccountType = MyAccount.Tools.newTypeDropdown();
        _addAccountType.setLabel("Account type is ");

        ScFieldTable fields;
        fields = body.addFields();
        fields.add(_addAccountName);
        fields.add(_addAccountType);

        group.addDivider();

        ScDiv footer;
        footer = group.addButtonBoxRight();
        footer.addCancelButton(cancelAction);
        footer.addSubmitButton("Save");

        _addAccountChild = frame;
    }

    private void installUserGrid(ScArray root)
    {
        MyMetaAccountUser x = MyAccountUser.Meta;

        ScGroup group;
        group = root.addGroup();
        group.setTitle("Users");

        ScDiv right;
        right = group.getHeader().addFloatRight();
        right.css().pad5();

        ScActionButton button;
        button = right.addButton("Add", newAddUserAction());
        button.setImage(MyButtonUrls.add());

        ScGridColumn<MyAccountUser> userEmail;
        userEmail = new ScGridColumn<MyAccountUser>();
        userEmail.setDisplayAdaptor(newUserEmailDisplayAdaptor());
        userEmail.setHeader("User Email");

        ScGrid<MyAccountUser> grid;
        grid = group.addGrid();
        grid.trackAll(_accountDropdown);
        grid.setFilterFactory(newFetcher());
        grid.addLinkColumn(x.UserName, newViewUserAction(), x.Uid);
        grid.addColumn(userEmail);

        _userGrid = grid;
    }

    private KmAdaptorIF<MyAccountUser,String> newUserEmailDisplayAdaptor()
    {
        return new KmAdaptorIF<MyAccountUser,String>()
        {
            @Override
            public String getValue(MyAccountUser model)
            {
                if ( model.getUser() != null )
                    return model.getUser().getEmail();
                return "";
            }

            @Override
            public void setValue(MyAccountUser model, String value)
            {
                //none
            }
        };
    }

    private KmFilterFactoryIF<MyAccountUser> newFetcher()
    {
        return new KmFilterFactoryIF<MyAccountUser>()
        {
            @Override
            public KmFilter<MyAccountUser> createFilter()
            {
                return newUserFilter();
            }
        };
    }

    private KmFilter<MyAccountUser> newUserFilter()
    {
        MyAccountUserFilter f;
        f = new MyAccountUserFilter();
        f.sortAscending();

        /**ask_valerie 
         * why this is broken
         */
        //        String accountName = _accountDropdown.getStringValue();
        //        MyAccount a = getAccess().getAccountDao().findWithName(accountName);
        //        f.setAccountUid(a.getUid());

        return f;
    }

    private void installUserFrame(ScArray row)
    {
        _userFrame = row.addFrame();

        installViewUserFrame();
        installEditUserFrame();
        installAddUserFrame();
    }

    private void installViewUserFrame()
    {
        ScFrameChild frame;
        frame = _userFrame.createChild();

        ScGroup group;
        group = frame.addGroup("View User");

        ScDiv header;
        header = group.getHeader().addFloatRight();
        header.css().pad5();

        ScBox body;
        body = group.addBox();
        body.css().pad();

        _viewUserName = new ScTextField();
        _viewUserName.setLabel("Name ");
        _viewUserName.setReadOnly();

        _viewUserEmail = new ScTextField();
        _viewUserEmail.setLabel("Email ");
        _viewUserEmail.setReadOnly();

        _viewUserRole = new ScTextField();
        _viewUserRole.setLabel("Role ");
        _viewUserRole.setReadOnly();

        ScFieldTable fields;
        fields = body.addFields();
        fields.add(_viewUserName);
        fields.add(_viewUserEmail);
        fields.add(_viewUserRole);

        group.addDivider();

        ScDiv footer;
        footer = group.addButtonBoxRight();

        ScActionButton button;
        button = footer.addButton("Edit", newShowEditUserBoxAction());
        button.setImage(MyButtonUrls.edit());

        // fixme_valerie: add this dialog
        //        footer.addButton("Remove from Account", newShowDeleteAccountUserDialogAction());

        _viewUserChild = frame;
    }

    private void installEditUserFrame()
    {
        ScActionIF saveAction = newEditUserSaveAction();
        ScActionIF cancelAction = newEditUserCancelAction();

        ScFrameChild frame;
        frame = _userFrame.createChild();

        ScForm form;
        form = frame.addForm();
        form.setDefaultAction(saveAction);
        form.onEscape().run(cancelAction);

        ScGroup group;
        group = form.addGroup("Edit");

        ScBox body;
        body = group.addBox();
        body.css().pad();

        _editUserName = new ScTextField();
        _editUserName.setLabel("User name is ");
        _editUserName.setReadOnly();

        _editUserEmail = new ScTextField();
        _editUserEmail.setLabel("User's email is ");
        _editUserEmail.setReadOnly();

        _editRoleDropdown = MyAccountUser.Tools.newRoleDropdown();
        _editRoleDropdown.setLabel("User role is ");

        ScFieldTable fields;
        fields = body.addFields();
        fields.add(_editUserName);
        fields.add(_editUserEmail);
        fields.add(_editRoleDropdown);

        group.addDivider();

        ScDiv footer;
        footer = group.addButtonBoxRight();
        footer.addCancelButton(cancelAction);
        footer.addSubmitButton("Save");

        _editUserChild = frame;
    }

    private void installAddUserFrame()
    {
        MyMetaUser x = MyUser.Meta;
        MyMetaAccountUser y = MyAccountUser.Meta;

        ScActionIF sendAction = newAddUserSendEmailAction();
        ScActionIF cancelAction = newAddUserCancelAction();

        ScFrameChild frame;
        frame = _userFrame.createChild();

        ScForm form;
        form = frame.addForm();
        form.setDefaultAction(sendAction);
        form.onEscape().run(cancelAction);

        ScGroup group;
        group = form.addGroup(_inviteUserLabel);

        ScBox body;
        body = group.addBox();
        body.css().pad();

        ScFieldTable fields;
        fields = body.addFields();
        fields.addField(x.Email);
        fields.addField(y.RoleName);

        group.addDivider();

        ScDiv footer;
        footer = group.addButtonBoxRight();
        footer.addCancelButton(cancelAction);
        footer.addSubmitButton("Send Request");

        _addUserChild = frame;
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

    private ScActionIF newDeleteAccountAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleDeleteAccount();
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

    private ScActionIF newUpdateValuesAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleUpdateValues();
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

    private ScActionIF newSendTransferRequestAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleSendTransferRequest();
            }
        };
    }

    private ScActionIF newCancelTransferRequestAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleCancelTransferRequest();
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

    private ScActionIF newAddUserAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleAddUser();
            }
        };
    }

    private ScActionIF newViewUserAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleViewUser();
            }
        };
    }

    private ScActionIF newEditUserSaveAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleEditUserSave();
            }
        };
    }

    private ScActionIF newEditUserCancelAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleEditUserCancel();
            }
        };
    }

    private ScActionIF newAddUserSendEmailAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleAddUserSendEmail();
            }
        };
    }

    private ScActionIF newAddUserCancelAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleAddUserCancel();
            }
        };
    }

    private ScActionIF newShowEditUserBoxAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleShowEditUserBox();
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

        _accountDropdown.setOptions(accountNames);
        _accountDropdown.ajaxUpdateValues();

        String accountName;
        accountName = _accountDropdown.getStringValue();

        MyAccount account;
        account = getAccess().getAccountDao().findWithName(accountName);
        getPageSession().setAccount(account);

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

        _deleteAccountDialog.ajaxOpen();
    }

    private void handleDeleteAccount()
    {
        MyAccount e;
        e = getPageSession().getAccount();
        e.deleteDao();

        _deleteAccountDialog.ajaxClose();

        ajax().toast("Deleted account %s", e.getName());

        _accountDropdown.ajaxUpdateValues();
    }

    private void handleClose()
    {
        _deleteAccountDialog.ajaxClose();
    }

    private void handleUpdateValues()
    {
        String accountName;
        accountName = _accountDropdown.getStringValue();

        MyAccount account;
        account = getAccess().getAccountDao().findWithName(accountName);
        getPageSession().setAccount(account);

        _viewAccountName.setValue(account.getName());
        _viewAccountType.setValue(account.getType().getName());

        _viewAccountChild.ajaxPrint();
        _viewAccountChild.ajax().focus();

        _userGrid.ajaxReload();
    }

    private void handleShowAddAccountBox()
    {
        _addAccountChild.ajaxPrint();
        _addAccountChild.ajax().focus();
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
        _transferChild.ajaxPrint();
        _transferChild.ajax().focus();
    }

    private void handleSendTransferRequest()
    {
        // fixme_valerie: send email
    }

    private void handleCancelTransferRequest()
    {
        _transferFrame.ajaxClear();
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

        _accountDropdown.ajaxUpdateValues();
    }

    private void handleEditAccountCancel()
    {
        MyAccount a;
        a = getPageSession().getAccount();

        _viewAccountName.setValue(a.getName());
        _viewAccountType.setValue(a.getType().getName());

        _viewAccountChild.ajaxPrint();
        _viewAccountChild.ajax().focus();

        _userGrid.ajaxReload();
    }

    private void handleAddAccountSave()
    {
        _addAccountChild.validate();

        if ( !_addAccountName.hasValue() )
        {
            ajax().toast("Please enter an account name");
            return;
        }

        MyAccount account;
        account = new MyAccount();
        account.setName(_addAccountName.getValue());

        MyUser user;
        user = getCurrentUser();

        MyAccountUser accountUser;
        accountUser = new MyAccountUser();
        accountUser.setAccount(account);
        accountUser.setUser(user);

        if ( _addAccountType.hasValue() )
            account.setTypeCode(_addAccountType.getStringValue());

        user.saveDao();
        account.saveDao();
        accountUser.saveDao();

        _accountDropdown.ajaxUpdateValues();
    }

    private void handleAddAccountCancel()
    {
        _accountFrame.ajaxClear();
    }

    private void handleAddUser()
    {
        String accountName;
        accountName = _accountDropdown.getStringValue();

        MyAccount account;
        account = getAccess().getAccountDao().findWithName(accountName);
        getPageSession().setAccount(account);

        _inviteUserLabel = "Invite User to " + accountName;

        // fixme_valerie: placeholder
        _addUserChild.ajaxPrint();
        _addUserChild.ajax().focus();
    }

    private void handleViewUser()
    {
        String uid;
        uid = getStringArgument();

        MyUser user;
        user = getAccess().findUserUid(uid);

        MyAccountUser accountUser;
        accountUser = getAccess().findAccountUserUid(getStringArgument());
        getPageSession().setAccountUser(accountUser);

        getPageSession().setUser(user);

        _viewUserName.setValue(user.getName());
        _viewUserEmail.setValue(user.getEmail());
        _viewUserRole.setValue(accountUser.getRoleName());

        _viewUserChild.applyFromModel(user);
        _viewUserChild.ajaxPrint();
    }

    private void handleAddUserSendEmail()
    {
        /**
         * todo_valerie hook up email request
         */
    }

    private void handleAddUserCancel()
    {
        _userFrame.ajaxClear();
    }

    private void handleEditUserCancel()
    {
        _userFrame.ajaxClear();
    }

    private void handleShowEditUserBox()
    {
        MyAccountUser e;
        e = getPageSession().getAccountUser();

        MyUser u;
        u = getPageSession().getUser();

        if ( u != null )
            _editUserName.setValue(u.getName());

        if ( u != null )
            _editUserEmail.setValue(u.getEmail());

        _editRoleDropdown.setValue(e.getRole());

        _editUserChild.applyFromModel(e);
        _editUserChild.ajaxPrint();
    }

    private void handleEditUserSave()
    {
        _editUserChild.validate();

        MyUser user;
        user = getPageSession().getUser();

        MyAccount account;
        account = getPageSession().getAccount();

        if ( account == null )
            account = new MyAccount();

        account.setName(_editAccountName.getValue());

        MyAccountUser accountUser;
        accountUser = getPageSession().getAccountUser();
        accountUser.setAccount(account);
        accountUser.setUser(user);

        if ( _editRoleDropdown.hasValue() )
            accountUser.setRoleCode(_editRoleDropdown.getStringValue());

        user.saveDao();
        account.saveDao();
        accountUser.saveDao();

        _userGrid.ajaxReload();
    }

}
