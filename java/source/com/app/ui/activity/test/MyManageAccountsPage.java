package com.app.ui.activity.test;

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
import com.kodemore.servlet.field.ScAutoCompleteCallbackIF;
import com.kodemore.servlet.field.ScAutoCompleteField;
import com.kodemore.servlet.field.ScDropdown;
import com.kodemore.servlet.field.ScOption;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.utility.KmEmailParser;

import com.app.filter.MyAccountUserFilter;
import com.app.model.MyAccount;
import com.app.model.MyAccountUser;
import com.app.model.MyUser;
import com.app.model.meta.MyMetaAccountUser;
import com.app.ui.activity.login.MyJoinAccountUtility;
import com.app.ui.activity.login.MyTransferAccountUtility;
import com.app.utility.MyButtonUrls;

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
    private ScTextField           _editUserName;
    private ScTextField           _editUserEmail;
    private ScTextField           _viewUserName;
    private ScTextField           _viewUserEmail;
    private ScTextField           _viewUserRole;

    private ScAutoCompleteField   _transferEmail;

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
    private ScDialog              _deleteUserDialog;

    private ScGrid<MyAccountUser> _userGrid;

    private ScTextField           _addUserEmail;
    private ScDropdown            _addRoleDropdown;

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
        installDeleteUserDialog(root);

        ScArray col;
        col = root.addColumn();

        installAccountsDropdown(col);

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

    private void installDeleteAccountDialog(ScPageRoot root)
    {
        _deleteAccountDialog = root.addDialog();
        _deleteAccountDialog.getHeaderBox().hide();
        _deleteAccountDialog.getFooterBox().hide();

        ScBox body = _deleteAccountDialog.getBodyBox();

        ScForm form;
        form = body.addForm();

        ScGroup group;
        group = form.addGroup("Are you sure you want to \n delete this account?");

        ScDiv footer;
        footer = group.addButtonBoxRight();

        ScActionButton button1;
        button1 = footer.addButton("Cancel", newCloseAction());
        button1.setImage(MyButtonUrls.cancel());

        ScActionButton button2;
        button2 = footer.addButton("Yes", newDeleteAccountAction());
        button2.setImage(MyButtonUrls.primary());
    }

    private void installDeleteUserDialog(ScPageRoot root)
    {
        _deleteUserDialog = root.addDialog();
        _deleteUserDialog.getHeaderBox().hide();
        _deleteUserDialog.getFooterBox().hide();

        ScBox body = _deleteUserDialog.getBodyBox();

        ScForm form;
        form = body.addForm();

        ScGroup group;
        group = form.addGroup("Are you sure you want to \n remove this user?");

        ScDiv footer;
        footer = group.addButtonBoxRight();

        ScActionButton button1;
        button1 = footer.addButton("Cancel", newCloseAction());
        button1.setImage(MyButtonUrls.cancel());

        ScActionButton button2;
        button2 = footer.addButton("Yes", newDeleteUserAction());
        button2.setImage(MyButtonUrls.primary());
    }

    private void installAccountsDropdown(ScArray col)
    {
        _accountDropdown = new ScDropdown();
        _accountDropdown.setAction(newUpdateValuesAction());

        ScForm form;
        form = col.addForm();

        ScGroup group;
        group = form.addGroup("Manage Accounts");

        ScBox body;
        body = group.addPadSpaced();
        body.add(_accountDropdown);
        body.addSpaces(3);

        ScActionButton button;
        button = body.addButton("Add Account", newShowAddAccountBoxAction());
        button.setImage(MyButtonUrls.add());
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

        ScForm form;
        form = frame.addForm();

        ScGroup group;
        group = form.addGroup("View Account");

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
        footer = group.addButtonBoxRight();
        footer.addButton("Edit", newShowEditAccountBoxAction());
        footer.addButton("Transfer", newShowTransferBoxAction());
        footer.addButton("Invite", newShowAddUserBoxAction());
        footer.addButton("Delete", newShowDeleteAccountDialogAction());

        _viewAccountChild = frame;
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
        group = form.addGroup("Edit Account");

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
        group = form.addGroup("Add Account");

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

    private void installTransferBox(ScArray row)
    {
        ScActionIF sendAction = newSendTransferRequestAction();
        ScActionIF cancelAction = newCancelTransferRequestAction();

        _transferFrame = row.addFrame();

        ScFrameChild frame;
        frame = _transferFrame.createChild();

        ScForm form;
        form = frame.addForm();
        form.setDefaultAction(sendAction);
        form.onEscape().run(cancelAction);

        ScGroup group;
        group = form.addGroup("Transfer Account");

        ScBox body;
        body = group.addBox();
        body.css().pad();

        // review_steve tracking junk
        _transferEmail = new ScAutoCompleteField();
        _transferEmail.setLabel("Email ");
        _transferEmail.setCallback(newTransferEmailCallback());
        _transferEmail.trackAll(_accountDropdown);
        _transferEmail.trackAll(_addAccountName);
        _transferEmail.trackAll(_editTypeDropdown);

        ScFieldTable fields;
        fields = body.addFields();
        fields.add(_transferEmail);

        group.addDivider();

        ScDiv footer;
        footer = group.addButtonBoxRight();
        footer.addCancelButton(cancelAction);
        footer.addSubmitButton("Send Request");

        _transferChild = frame;
    }

    private ScAutoCompleteCallbackIF newTransferEmailCallback()
    {
        return new ScAutoCompleteCallbackIF()
        {
            @Override
            public KmList<String> getOptionsFor(String term)
            {
                return getAutocompleteTransferEmailOptions(term);
            }
        };
    }

    private KmList<String> getAutocompleteTransferEmailOptions(String term)
    {
        // review_steve (valerie)

        KmList<String> v;
        v = new KmList<String>();

        //        MyAccount account;
        //        account = getPageSession().getAccount();
        //        account = getAccess().getAccountDao().findWithName(accountName);
        //        getPageSession().setAccount(account);

        KmList<MyAccountUser> accountUsers;
        accountUsers = getAccess().getAccountUserDao().findAll();

        System.out.println("    ============================ account uid: "
            + getPageSession().getAccountUid());

        //        for ( MyAccountUser e : accountUsers )
        //            if ( e.getUser().getEmail().toLowerCase().contains(term.toLowerCase()) )
        //                v.add(e.getUser().getEmail());

        for ( MyAccountUser e : accountUsers )
            v.add(e.getUser().getEmail());

        return v;
    }

    private void installUserGrid(ScArray root)
    {
        MyMetaAccountUser x = MyAccountUser.Meta;

        ScForm form;
        form = root.addForm();

        ScGroup group;
        group = form.addGroup();
        group.setTitle("Users on this Account");

        ScDiv right;
        right = group.getHeader().addFloatRight();
        right.css().pad5();

        ScGridColumn<MyAccountUser> userEmail;
        userEmail = new ScGridColumn<MyAccountUser>();
        userEmail.setDisplayAdaptor(newUserEmailDisplayAdaptor());
        userEmail.setHeader("User Email");

        ScGrid<MyAccountUser> grid;
        grid = group.addGrid();
        grid.track(_accountDropdown);
        grid.setFilterFactory(newFetcher());
        grid.addLinkColumn(x.UserName, newViewUserAction(), x.Uid);
        grid.addColumn(userEmail);
        grid.addColumn(x.RoleName).setCharacterWidth(8);

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

        String accountUid;
        accountUid = _accountDropdown.getStringValue();

        f.setAccountUid(accountUid);

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

        ScActionButton editButton;
        editButton = header.addButton("Edit", newShowEditUserBoxAction());
        editButton.setImage(MyButtonUrls.edit());

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

        //        ScActionButton editButton;
        //        editButton = footer.addButton("Edit", newShowEditUserBoxAction());
        //        editButton.setImage(MyButtonUrls.edit());
        // fixme_valerie: come back to this
        ScActionButton cancelButton;
        cancelButton = footer.addButton("Cancel", newEditUserCancelAction());
        cancelButton.setImage(MyButtonUrls.cancel());

        ScActionButton removeButton;
        removeButton = footer.addButton(
            "Remove from Account",
            newShowDeleteAccountUserDialogAction());
        removeButton.setImage(MyButtonUrls.primary());

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
        group = form.addGroup("Edit User Role");

        ScBox body;
        body = group.addBox();
        body.css().pad();

        _editUserName = new ScTextField();
        _editUserName.setLabel("Name ");
        _editUserName.setReadOnly();

        _editUserEmail = new ScTextField();
        _editUserEmail.setLabel("Email ");
        _editUserEmail.setReadOnly();

        _editRoleDropdown = MyAccountUser.Tools.newRoleDropdown();
        _editRoleDropdown.setLabel("Role ");

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
        ScActionIF sendAction = newSendJoinRequestAction();
        ScActionIF cancelAction = newAddUserCancelAction();

        ScFrameChild frame;
        frame = _userFrame.createChild();

        ScForm form;
        form = frame.addForm();
        form.setDefaultAction(sendAction);
        form.onEscape().run(cancelAction);

        ScGroup group;
        group = form.addGroup("Invite User to Account");

        ScBox body;
        body = group.addBox();
        body.css().pad();

        _addUserEmail = new ScTextField();
        _addUserEmail.setLabel("Email ");

        _addRoleDropdown = MyAccountUser.Tools.newRoleDropdown();
        _addRoleDropdown.setLabel("Role ");

        ScFieldTable fields;
        fields = body.addFields();
        fields.add(_addUserEmail);
        fields.add(_addRoleDropdown);

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

    private ScActionIF newShowDeleteAccountDialogAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleShowDeleteAccountDialog();
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

    private ScActionIF newDeleteUserAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleDeleteUser();
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

    private ScActionIF newShowAddUserBoxAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleShowAddUserBox();
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

    private ScActionIF newSendJoinRequestAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleSendJoinRequest();
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

    private ScActionIF newShowDeleteAccountUserDialogAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleShowDeleteAccountUserDialog();
            }
        };
    }

    //##################################################
    //# start
    //##################################################

    @Override
    public void start()
    {
        super.start();

        setDropdownOptions();
        loadViewAccount();
        handleUpdateValues();
    }

    //##################################################
    //# handle
    //##################################################

    private void handleShowDeleteAccountDialog()
    {
        String accountName;
        accountName = _viewAccountName.getValue();

        MyAccount account;
        account = getAccess().getAccountDao().findWithName(accountName);
        getPageSession().setAccount(account);

        _deleteAccountDialog.ajaxOpen();
    }

    // fixme_valerie: doesn't work, see handleDeleteUser()
    private void handleShowDeleteAccountUserDialog()
    {
        String accountName;
        accountName = _accountDropdown.getStringValue();

        MyAccount account;
        account = getAccess().getAccountDao().findWithName(accountName);
        getPageSession().setAccount(account);

        _deleteUserDialog.ajaxOpen();
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

    private void handleDeleteUser()
    {
        /**ask_valerie 
         * can't grab account from _userGrid. Therefore, can't remove user
         * from account
         */
        MyUser u;
        u = getPageSession().getUser();

        MyAccount a;
        a = getPageSession().getAccount();

        MyAccountUser accountUser;
        accountUser = getAccess().getAccountUserDao().findAccountUserFor(u, a);

        accountUser.deleteDao();

        _deleteUserDialog.ajaxClose();

        ajax().toast("Deleted user %s from account %s", u.getName(), a.getName());

        _userFrame.ajaxClear();
        _userGrid.ajaxReload();
    }

    private void handleClose()
    {
        _deleteAccountDialog.ajaxClose();
        _deleteUserDialog.ajaxClose();
    }

    private void handleUpdateValues()
    {
        updateViewAccount();
        _userGrid.ajaxReload();
    }

    private void updateViewAccount()
    {
        MyAccount account;
        account = getPageSession().getAccount();

        String accountUid;
        accountUid = _accountDropdown.getStringValue();

        MyAccount dropdownAccount;
        dropdownAccount = getAccess().getAccountDao().findUid(accountUid);

        /**
         * review_wyatt (steve) this is ugly and probably not too readable
         * 
         * review_valerie (steve)
         */
        if ( account == null || !dropdownAccount.equals(account) )
        {
            account = dropdownAccount;
            getPageSession().setAccount(account);
        }

        _viewAccountName.setValue(account.getName());
        _viewAccountType.setValue(account.getType().getName());

        _viewAccountChild.ajaxPrint();
        _viewAccountChild.ajax().focus();

        System.out.println("   ***************************** account uid: "
            + getPageSession().getAccountUid());
    }

    private void handleShowAddAccountBox()
    {
        String accountUid;
        accountUid = _accountDropdown.getStringValue();

        MyAccount account;
        account = getAccess().getAccountDao().findUid(accountUid);
        getPageSession().setAccount(account);

        _addAccountChild.ajaxPrint();
        _addAccountChild.ajax().focus();
    }

    private void handleAddAccountCancel()
    {
        MyAccount account;
        account = getPageSession().getAccount();

        if ( account != null )
        {
            _viewAccountName.setValue(account.getName());
            _viewAccountType.setValue(account.getType().getName());
        }

        _viewAccountChild.ajaxPrint();
    }

    private void handleShowEditAccountBox()
    {
        String accountName;
        accountName = _viewAccountName.getValue();

        MyAccount account;
        account = getAccess().getAccountDao().findWithName(accountName);
        getPageSession().setAccount(account);

        if ( account != null )
            _editAccountName.setValue(account.getName());

        if ( account != null )
            _editTypeDropdown.setValue(account.getType());

        _editAccountChild.ajaxPrint();
    }

    private void handleShowTransferBox()
    {
        //        String accountName;
        //        accountName = _viewAccountName.getValue();

        // remove_steve pretty sure we don't need this
        //        MyAccount account;
        //        account = getAccess().getAccountDao().findWithName(accountName);
        //        getPageSession().setAccount(account);

        //      remove_steve print 
        System.out.println("    ############################ account uid: "
            + getPageSession().getAccountUid());

        _transferChild.ajaxPrint();
        _transferChild.ajax().focus();
    }

    private void handleSendTransferRequest()
    {
        MyAccount account;
        account = getPageSession().getAccount();

        String email = _transferEmail.getValue();

        boolean isValid = KmEmailParser.validate(email);

        if ( !isValid )
            _transferEmail.error("Invalid");

        MyTransferAccountUtility utility;
        utility = new MyTransferAccountUtility();
        utility.start(account, email);

        showSentMessage(email);
    }

    private void showSentMessage(String email)
    {
        ajax().toast("Your request has been sent to: " + email);

        _transferFrame.ajaxClear();
    }

    private void handleCancelTransferRequest()
    {
        System.out.println("    xxxxxxxxxxxxxxxxxxxxxxxxxxxx account uid: "
            + getPageSession().getAccountUid());
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
        account.setName(_editAccountName.getValue());
        account.setTypeCode(_editTypeDropdown.getStringValue());
        account.saveDao();

        setDropdownOptions();

        String accountUid = account.getUid();

        loadViewAccount();

        /**ask_valerie 
         * not setting dropdown
         */
        _accountDropdown.ajaxSetValue(accountUid);

        _userGrid.ajaxReload();
    }

    private void handleEditAccountCancel()
    {
        MyAccount account;
        account = getPageSession().getAccount();

        if ( account != null )
        {
            _viewAccountName.setValue(account.getName());
            _viewAccountType.setValue(account.getType().getName());
        }

        _viewAccountChild.ajaxPrint();
    }

    private void loadViewAccount()
    {
        MyAccount account;
        account = getPageSession().getAccount();

        if ( account != null )
        {
            _viewAccountName.setValue(account.getName());
            _viewAccountType.setValue(account.getType().getName());
        }

        _viewAccountChild.ajaxPrint();
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
        account.setTypeCode(_addAccountType.getStringValue());
        account.saveDao();

        MyUser user;
        user = getCurrentUser();

        MyAccountUser accountUser;
        accountUser = new MyAccountUser();
        accountUser.setAccount(account);
        accountUser.setUser(user);
        accountUser.saveDao();

        String accountUid = account.getUid();
        _accountDropdown.setValue(accountUid);
        _accountDropdown.ajaxAddOption(account.getName(), accountUid);
        _accountDropdown.ajaxSetValue(accountUid);

        loadViewAccount();
    }

    private void handleShowAddUserBox()
    {
        String accountName;
        accountName = _viewAccountName.getValue();

        MyAccount account;
        account = getAccess().getAccountDao().findWithName(accountName);
        getPageSession().setAccount(account);

        _addUserChild.ajaxPrint();
        _addUserChild.ajax().focus();
    }

    private void handleViewUser()
    {
        String accountUserUid;
        accountUserUid = getStringArgument();

        MyAccountUser accountUser;
        accountUser = getAccess().getAccountUserDao().findWithUid(accountUserUid);

        getPageSession().setAccountUser(accountUser);

        MyUser user;
        user = accountUser.getUser();

        // fixme_valerie: use this account to hold in pageSession here
        //        MyAccount account = accountUser.getAccount();

        getPageSession().setUser(user);

        _viewUserName.setValue(user.getName());
        _viewUserEmail.setValue(user.getEmail());
        _viewUserRole.setValue(accountUser.getRoleName());

        _viewUserChild.applyFromModel(user);
        _viewUserChild.ajaxPrint();
    }

    private void handleSendJoinRequest()
    {
        MyAccount account;
        account = getPageSession().getAccount();

        String email = _addUserEmail.getValue();

        boolean isValid = KmEmailParser.validate(email);

        if ( !isValid )
            _addUserEmail.error("Invalid");

        MyJoinAccountUtility utility;
        utility = new MyJoinAccountUtility();
        utility.start(account, email);

        showSentMessage(email);
    }

    private void handleAddUserCancel()
    {
        _userFrame.ajaxClear();
    }

    private void handleEditUserCancel()
    {
        _userFrame.ajaxClear();

        MyAccountUser accountUser;
        accountUser = getPageSession().getAccountUser();

        MyUser user;
        user = accountUser.getUser();

        getPageSession().setUser(user);

        _viewUserName.setValue(user.getName());
        _viewUserEmail.setValue(user.getEmail());
        _viewUserRole.setValue(accountUser.getRoleName());

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

        MyAccountUser accountUser;
        accountUser = getPageSession().getAccountUser();
        accountUser.setRoleCode(_editRoleDropdown.getStringValue());
        accountUser.saveDao();

        _userGrid.ajaxReload();

        MyUser user;
        user = accountUser.getUser();

        getPageSession().setUser(user);

        _viewUserName.setValue(user.getName());
        _viewUserEmail.setValue(user.getEmail());
        _viewUserRole.setValue(accountUser.getRoleName());

        _viewUserChild.applyFromModel(user);
        _viewUserChild.ajaxPrint();
    }

    //##################################################
    //# convenience
    //##################################################

    private KmList<ScOption> getDropdownOptions()
    {
        KmList<ScOption> accountNames;
        accountNames = new KmList<ScOption>();

        KmList<MyAccount> accounts;
        accounts = getAccess().getAccountDao().findAll();

        for ( MyAccount account : accounts )
        {
            ScOption option = new ScOption();
            option.setText(account.getName());
            option.setValue(account.getUid());
            accountNames.add(option);
        }

        return accountNames;
    }

    private void setDropdownOptions()
    {
        KmList<ScOption> options = getDropdownOptions();

        for ( ScOption e : options )
            _accountDropdown.ajaxAddOption(e.getText(), e.getValue());

        if ( options.isNotEmpty() )
        {
            _accountDropdown.setValue(options.getFirst().getValue());
            _accountDropdown.ajaxUpdateValue();
        }
    }
}
