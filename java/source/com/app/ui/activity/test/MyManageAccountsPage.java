package com.app.ui.activity.test;

import com.app.filter.MyUserFilter;
import com.app.model.MyAccount;
import com.app.model.MyAccountUser;
import com.app.model.MyUser;
import com.app.model.meta.MyMetaUser;
import com.app.utility.MyButtonUrls;

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

    private ScDropdown     _accountDropdown;
    private ScDropdown     _editTypeDropdown;
    private ScDropdown     _addAccountType;
    private ScDropdown     _editRoleDropdown;

    private ScFrame        _accountFrame;

    private ScTextField    _viewAccountName;
    private ScTextField    _viewAccountType;
    private ScTextField    _editAccountName;
    private ScTextField    _editAccountType;
    private ScTextField    _addAccountName;
    private ScTextField    _transferEmail;
    private ScTextField    _editUserName;
    private ScTextField    _editUserEmail;

    private ScFrameChild   _viewAccountChild;
    private ScFrameChild   _editAccountChild;
    private ScFrameChild   _addAccountChild;
    private ScFrameChild   _viewUserChild;
    private ScFrameChild   _editUserChild;
    private ScFrameChild   _addUserChild;

    private ScFrame        _transferFrame;
    private ScFrame        _userFrame;

    private ScDialog       _deleteDialog;

    private ScGrid<MyUser> _userGrid;

    //##################################################
    //# install
    //##################################################

    @Override
    protected ScPageRoot installRoot()
    {
        ScPageRoot root;
        root = newPageRoot();
        root.css().padSpaced();

        installDialog(root);
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
        _accountDropdown = new ScDropdown();

        ScGroup group;
        group = root.addGroup("Manage Accounts");

        ScBox body;
        body = group.addPadSpaced();
        body.add(_accountDropdown);
        body.addButton("Test", showView());
        body.addButton("Add", newShowAddAccountBoxAction());
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
        MyMetaUser x = MyUser.Meta;

        ScActionIF addAction;
        addAction = newAddUserAction();

        ScGroup group;
        group = root.addGroup();
        group.setTitle("Users");

        ScDiv right;
        right = group.getHeader().addFloatRight();
        right.css().pad5();

        ScActionButton button;
        button = right.addButton("Add", addAction);
        button.setImage(MyButtonUrls.add());

        ScGrid<MyUser> grid;
        grid = group.addGrid();
        grid.setFilterFactory(newFetcher());
        grid.addLinkColumn(x.Name, newViewUserAction(), x.Uid);
        grid.addColumn(x.Email);

        _userGrid = grid;
    }

    private KmFilterFactoryIF<MyUser> newFetcher()
    {
        return new KmFilterFactoryIF<MyUser>()
        {
            @Override
            public KmFilter<MyUser> createFilter()
            {
                return newUserFilter();
            }
        };
    }

    private KmFilter<MyUser> newUserFilter()
    {
        MyUserFilter f;
        f = new MyUserFilter();
        f.sortOnName();

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
        MyMetaUser x = MyUser.Meta;

        ScFrameChild frame;
        frame = _userFrame.createChild();

        ScGroup group;
        group = frame.addGroup("View");

        ScDiv header;
        header = group.getHeader().addFloatRight();
        header.css().pad5();

        ScActionButton button;
        button = header.addButton("Edit", newShowEditUserBoxAction());
        button.setImage(MyButtonUrls.edit());

        ScBox body;
        body = group.addBox();
        body.css().pad();

        ScFieldTable fields;
        fields = body.addFields();
        fields.addText(x.Name);
        fields.addText(x.Email);
        fields.addText(x.RoleName);

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

        _editUserEmail = new ScTextField();
        _editUserEmail.setLabel("User's email is ");

        _editRoleDropdown = MyAccountUser.Tools.newRoleDropdown();
        _editRoleDropdown.setLabel("User role is ");

        ScFieldTable fields;
        fields = body.addFields();
        fields.add(_editUserName);
        fields.add(_editUserEmail);
        fields.add(_editAccountName);
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

        //        ScActionIF saveAction = newAddSaveAction();
        //        ScActionIF cancelAction = newAddCancelAction();

        ScFrameChild frame;
        frame = _userFrame.createChild();

        ScForm form;
        form = frame.addForm();
        //        form.setDefaultAction(saveAction);
        //        form.onEscape().run(cancelAction);

        ScGroup group;
        group = form.addGroup("Add");

        ScBox body;
        body = group.addBox();
        body.css().pad();

        ScFieldTable fields;
        fields = body.addFields();
        fields.addField(x.Email);
        fields.addField(x.Name);

        group.addDivider();

        ScDiv footer;
        footer = group.addButtonBoxRight();
        //        footer.addCancelButton(cancelAction);
        footer.addSubmitButton("Save");

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

        // fixme_valerie: 
        _accountDropdown.setOptions(accountNames);
        //        _dropdown.ajaxUpdateValues();

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

        _accountDropdown.ajaxUpdateValues();
    }

    private void handleClose()
    {
        _deleteDialog.ajaxClose();
    }

    private void handleShowView()
    {
        String accountName;
        accountName = _accountDropdown.getStringValue();

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
        _transferFrame.ajaxPrint();
    }

    private void handleSendTransferRequest()
    {
        // fixme_valerie: send email
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
        _accountFrame.ajaxClear();
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
        _addUserChild.ajaxPrint();
        _addUserChild.ajax().focus();
    }

    private void handleViewUser()
    {
        String uid;
        uid = getStringArgument();

        MyUser user;
        user = getAccess().findUserUid(uid);

        getPageSession().setUser(user);

        _viewUserChild.applyFromModel(user);
        _viewUserChild.ajaxPrint();
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

        if ( !_editUserName.hasValue() )
        {
            ajax().toast("Please enter a user name");
            return;
        }

        if ( !_editUserEmail.hasValue() )
        {
            ajax().toast("Please enter the user's email");
            return;
        }

        MyUser user;
        user = getPageSession().getUser();

        if ( user == null )
            user = new MyUser();

        user.setName(_editUserName.getValue());
        user.setEmail(_editUserEmail.getValue());

        MyAccount account;
        account = getPageSession().getAccount();

        if ( account == null )
            account = new MyAccount();

        account.setName(_editAccountName.getValue());

        MyAccountUser accountUser;
        accountUser = getPageSession().getAccountUser();
        accountUser.setAccount(account);
        accountUser.setUser(user);

        if ( _editTypeDropdown.hasValue() )
            account.setTypeCode(_editTypeDropdown.getStringValue());

        if ( _editRoleDropdown.hasValue() )
            accountUser.setRoleCode(_editRoleDropdown.getStringValue());

        user.saveDao();
        account.saveDao();
        accountUser.saveDao();

        _userGrid.ajaxReload();
    }

    private void handleEditUserCancel()
    {
        _userFrame.ajaxClear();
    }
}
