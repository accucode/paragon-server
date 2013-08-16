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
import com.kodemore.servlet.control.ScContainer;
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
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.KmEmailParser;

import com.app.dao.MyAccountDao;
import com.app.dao.MyAccountUserDao;
import com.app.filter.MyAccountUserFilter;
import com.app.filter.MyUserFilter;
import com.app.model.MyAccount;
import com.app.model.MyAccountType;
import com.app.model.MyAccountUser;
import com.app.model.MyAccountUserRole;
import com.app.model.MyUser;
import com.app.model.meta.MyMetaAccountUser;
import com.app.model.meta.MyMetaUser;
import com.app.ui.activity.login.MyJoinAccountUtility;
import com.app.ui.activity.login.MyTransferAccountUtility;
import com.app.ui.layout.MyPageLayout;
import com.app.utility.MyButtonUrls;
import com.app.utility.MyGlobals;

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
    private ScDropdown            _addRoleDropdown;

    private ScTextField           _viewAccountName;
    private ScTextField           _viewAccountType;
    private ScTextField           _editAccountName;
    private ScTextField           _addAccountName;
    private ScTextField           _viewUserName;
    private ScTextField           _viewUserEmail;
    private ScTextField           _viewUserRole;
    private ScTextField           _editUserName;
    private ScTextField           _editUserEmail;
    private ScTextField           _addUserEmail;
    private ScTextField           _deleteAccountName;
    private ScTextField           _deleteAccountType;

    private ScAutoCompleteField   _transferEmailAutoComplete;

    private ScFrameChild          _viewAccountChild;
    private ScFrameChild          _editAccountChild;
    private ScFrameChild          _addAccountChild;
    private ScFrameChild          _viewUserChild;
    private ScFrameChild          _editUserChild;
    private ScFrameChild          _inviteUserChild;
    private ScFrameChild          _transferChild;
    private ScFrameChild          _deleteAccountChild;

    private ScFrame               _accountFrame;
    private ScFrame               _userFrame;

    private ScDialog              _deleteUserDialog;

    private ScGrid<MyAccountUser> _userGrid;

    private ScActionButton        _transferButton;
    private ScActionButton        _deleteButton;
    private ScActionButton        _editButton;

    private ScLocalString         _accountName;

    private ScGroup               _inviteGroup;
    private ScGroup               _deleteGroup;
    private ScGroup               _transferGroup;

    private ScDiv                 _viewAccountFooter;
    private ScDiv                 _viewUserFooter;

    //##################################################
    //# install
    //##################################################

    @Override
    protected ScPageRoot installRoot()
    {
        _accountName = new ScLocalString();
        _accountName.setAutoSave();

        ScPageRoot root;
        root = newPageRoot();
        root.css().padSpaced();

        ScArray row;
        row = root.addRow();

        ScContainer left;
        left = row.addColumn();
        installAccountsDropdownOn(left);
        installUserGrid(left);

        ScContainer right;
        right = row.addColumn();
        installAccountFrameOn(right);
        installUserFrameOn(right);

        installDeleteUserDialog(root);

        return root;
    }

    private void installDeleteUserDialog(ScPageRoot root)
    {
        _deleteUserDialog = root.addDialog();
        _deleteUserDialog.getHeaderBox().addPad().addText(
            "Are you sure you want to \n remove this user?");
        _deleteUserDialog.getBodyBox().hide();
        _deleteUserDialog.setBodyHeight(125);

        ScBox footer;
        footer = _deleteUserDialog.getFooterBox().addPad();

        ScBox buttonBox;
        buttonBox = footer.addButtonBoxRight();

        ScActionButton cancelButton;
        cancelButton = buttonBox.addButton("Cancel", newCloseAction());
        cancelButton.setImage(MyButtonUrls.cancel());
        cancelButton.setFlavorNegative();

        ScActionButton deleteButton;
        deleteButton = buttonBox.addButton("Delete", newDeleteUserAction());
        deleteButton.setImage(MyButtonUrls.primary());
        deleteButton.setFlavorPositive();
    }

    private void installAccountsDropdownOn(ScContainer root)
    {
        _accountDropdown = new ScDropdown();
        _accountDropdown.setAction(newUpdateValuesAction());

        ScForm form;
        form = root.addForm();

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

    //==================================================
    //= install : account frame
    //==================================================//

    private void installAccountFrameOn(ScContainer root)
    {
        _accountFrame = root.addFrame();
        _accountFrame.setHideFlip();
        _accountFrame.setShowFlip();

        installViewAccountFrame();
        installEditAccountFrame();
        installAddAccountFrame();
        installInviteUserFrame();
        installDeleteAccountFrame();
        installTransferAccountFrame();

        _accountFrame.setDefaultChild(_viewAccountChild);
    }

    private void installViewAccountFrame()
    {
        ScFrameChild frameChild;
        frameChild = _accountFrame.createChild();

        ScForm form;
        form = frameChild.addForm();

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

        _viewAccountFooter = group.addButtonBoxRight();

        _viewAccountFooter.addButton("Edit", newShowEditAccountBoxAction());
        _transferButton = _viewAccountFooter.addButton("Transfer", newShowTransferBoxAction());
        _viewAccountFooter.addButton("Invite", newShowInviteUserBoxAction());
        _deleteButton = _viewAccountFooter.addButton("Delete", newShowDeleteAccountBoxAction());

        _transferButton.hide();

        _viewAccountChild = frameChild;
    }

    private void installEditAccountFrame()
    {
        ScActionIF saveAction = newEditAccountSaveAction();
        ScActionIF cancelAction = newEditAccountCancelAction();

        ScFrameChild child;
        child = _accountFrame.createChild();

        ScForm form;
        form = child.addForm();
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

        _editAccountChild = child;
    }

    private void installAddAccountFrame()
    {
        ScActionIF saveAction = newAddAccountSaveAction();
        ScActionIF cancelAction = newAddAccountCancelAction();

        ScFrameChild frameChild;
        frameChild = _accountFrame.createChild();

        ScForm form;
        form = frameChild.addForm();
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

        _addAccountChild = frameChild;
    }

    private void installInviteUserFrame()
    {
        ScActionIF sendAction = newSendJoinRequestAction();
        ScActionIF cancelAction = newInviteUserCancelAction();

        ScFrameChild frameChild;
        frameChild = _accountFrame.createChild();

        ScForm form;
        form = frameChild.addForm();
        form.setDefaultAction(sendAction);
        form.onEscape().run(cancelAction);

        _inviteGroup = form.addGroup();

        ScBox body;
        body = _inviteGroup.addBox();
        body.css().pad();

        _addUserEmail = new ScTextField();
        _addUserEmail.setLabel("Email ");

        populateAddRoleDropdown();

        ScFieldTable fields;
        fields = body.addFields();
        fields.add(_addUserEmail);
        fields.add(_addRoleDropdown);

        _inviteGroup.addDivider();

        ScDiv footer;
        footer = _inviteGroup.addButtonBoxRight();
        footer.addCancelButton(cancelAction);
        footer.addSubmitButton("Send Request");

        _inviteUserChild = frameChild;
    }

    private void installDeleteAccountFrame()
    {
        ScActionIF saveAction = newDeleteAccountAction();
        ScActionIF cancelAction = newDeleteAccountCancelAction();

        ScFrameChild frameChild;
        frameChild = _accountFrame.createChild();

        ScForm form;
        form = frameChild.addForm();
        form.setDefaultAction(saveAction);
        form.onEscape().run(cancelAction);
        form.css().colorRed();

        _deleteGroup = form.addGroup();

        ScBox body;
        body = _deleteGroup.addBox();
        body.css().pad();

        _deleteAccountName = new ScTextField();
        _deleteAccountName.setLabel("Account name is ");
        _deleteAccountName.setReadOnly();

        _deleteAccountType = new ScTextField();
        _deleteAccountType.setLabel("Account type is ");
        _deleteAccountType.setReadOnly();

        ScFieldTable fields;
        fields = body.addFields();
        fields.add(_deleteAccountName);
        fields.addSpace();
        fields.add(_deleteAccountType);

        _deleteGroup.addDivider();

        ScDiv footer;
        footer = _deleteGroup.addButtonBoxRight();
        footer.addCancelButton(cancelAction);
        footer.addSubmitButton("Delete");

        _deleteAccountChild = frameChild;
    }

    private void installTransferAccountFrame()
    {
        ScActionIF sendAction = newSendTransferRequestAction();
        ScActionIF cancelAction = newCancelTransferRequestAction();

        ScFrameChild frameChild;
        frameChild = _accountFrame.createChild();

        ScForm form;
        form = frameChild.addForm();
        form.setDefaultAction(sendAction);
        form.onEscape().run(cancelAction);

        _transferGroup = form.addGroup();

        ScBox body;
        body = _transferGroup.addBox();
        body.css().pad();

        _transferEmailAutoComplete = new ScAutoCompleteField();
        _transferEmailAutoComplete.setLabel("Email ");
        _transferEmailAutoComplete.setCallback(newTransferEmailCallback());
        _transferEmailAutoComplete.track(getPageSession().getAccountUidHolder());

        ScFieldTable fields;
        fields = body.addFields();
        fields.add(_transferEmailAutoComplete);

        _transferGroup.addDivider();

        ScDiv footer;
        footer = _transferGroup.addButtonBoxRight();
        footer.addCancelButton(cancelAction);
        footer.addSubmitButton("Send Request");

        _transferChild = frameChild;
    }

    private void populateAddRoleDropdown()
    {
        ScOption user = new ScOption();
        user.setText("User");
        user.setValue(MyAccountUserRole.User.getCode());

        ScOption manager = new ScOption();
        manager.setText("Manager");
        manager.setValue(MyAccountUserRole.Manager.getCode());

        _addRoleDropdown = new ScDropdown();
        _addRoleDropdown.addOption(user);
        _addRoleDropdown.addOption(manager);
        _addRoleDropdown.setLabel("Role ");
    }

    //==================================================
    //= install : transfer account
    //==================================================//

    private ScAutoCompleteCallbackIF newTransferEmailCallback()
    {
        return new ScAutoCompleteCallbackIF()
        {
            @Override
            public KmList<String> getOptionsFor(String term)
            {
                return getAutoCompleteTransferEmailOptions(term);
            }
        };
    }

    private KmList<String> getAutoCompleteTransferEmailOptions(String term)
    {
        MyMetaUser x = MyUser.Meta;
        MyAccount account = getPageSession().getAccount();

        MyUserFilter f;
        f = new MyUserFilter();
        f.setEmailSubstring(term);
        f.setAccount(account);
        f.sortOnEmail();

        return f.findFirst(10).collect(x.Email);
    }

    //==================================================
    //= install : grid
    //==================================================//

    private void installUserGrid(ScContainer root)
    {
        MyMetaAccountUser x = MyAccountUser.Meta;

        ScGroup group;
        group = root.addGroup();
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
        grid.track(getPageSession().getAccountUidHolder());
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
        accountUid = getPageSession().getAccountUidHolder().getValue();

        if ( accountUid == null )
            accountUid = getServerSession().getAccount().getUid();

        f.setAccountUid(accountUid);

        return f;
    }

    //==================================================
    //= install : user frame
    //==================================================//

    private void installUserFrameOn(ScContainer root)
    {
        _userFrame = root.addFrame();
        _userFrame.setHideFlip();
        _userFrame.setShowFlip();

        installViewUserFrame();
        installEditUserFrame();
    }

    private void installViewUserFrame()
    {
        ScActionIF sendAction = newShowDeleteAccountUserDialogAction();
        ScActionIF cancelAction = newViewUserCancelAction();

        ScFrameChild frameChild;
        frameChild = _userFrame.createChild();

        ScForm form;
        form = frameChild.addForm();
        form.setDefaultAction(sendAction);
        form.onEscape().run(cancelAction);

        ScGroup group;
        group = form.addGroup("View User");

        ScDiv header;
        header = group.getHeader().addFloatRight();
        header.css().pad5();

        _editButton = header.addButton("Edit", newShowEditUserBoxAction());
        _editButton.setImage(MyButtonUrls.edit());

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

        _viewUserFooter = group.addButtonBoxRight();
        _viewUserFooter.addCancelButton(cancelAction);
        _viewUserFooter.addSubmitButton("Remove from Account");

        _viewUserChild = frameChild;
    }

    private void installEditUserFrame()
    {
        ScActionIF saveAction = newEditUserSaveAction();
        ScActionIF cancelAction = newEditUserCancelAction();

        ScFrameChild frameChild;
        frameChild = _userFrame.createChild();

        ScForm form;
        form = frameChild.addForm();
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

        populateEditRoleDropdown();

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

        _editUserChild = frameChild;
    }

    private void populateEditRoleDropdown()
    {
        ScOption user = new ScOption();
        user.setText("User");
        user.setValue(MyAccountUserRole.User.getCode());

        ScOption manager = new ScOption();
        manager.setText("Manager");
        manager.setValue(MyAccountUserRole.Manager.getCode());

        _editRoleDropdown = new ScDropdown();
        _editRoleDropdown.addOption(user);
        _editRoleDropdown.addOption(manager);
        _editRoleDropdown.setLabel("Role ");
    }

    //##################################################
    //# action
    //##################################################

    private ScActionIF newShowDeleteAccountBoxAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleShowDeleteAccountBox();
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

    private ScActionIF newDeleteAccountCancelAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleDeleteAccountCancel();
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

    private ScActionIF newShowInviteUserBoxAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleShowInviteUserBox();
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

    private ScActionIF newInviteUserCancelAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleInviteUserCancel();
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

    private ScActionIF newViewUserCancelAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleViewUserCancel();
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

    /**
     * review_valerie (wyatt) discuss start
     * review_steve   (wyatt) discuss start
     */
    @Override
    public void start()
    {
        super.start();

        setDropdownOptions();
        refreshAll(true);
    }

    //##################################################
    //# handle
    //##################################################

    private void handleShowDeleteAccountBox()
    {
        String name;
        name = _viewAccountName.getValue();

        _deleteGroup.setTitle("Delete %s Account", name);

        MyAccount a;
        a = getPageSession().getAccount();

        if ( a != null )
        {
            _deleteAccountName.setValue(a.getName());
            _deleteAccountType.setValue(a.getType().getName());
        }

        _accountFrame.ajaxPrint(_deleteAccountChild);
    }

    private void handleDeleteAccount()
    {
        MyAccount a;
        a = getPageSession().getAccount();

        MyAccountUser au;
        au = getAccountUserDao().findAccountUserFor(getCurrentUser(), a);

        a.deleteDao();
        au.deleteDao();

        MyPageLayout.getInstance().refreshDropdown();

        ajax().toast("Deleted account %s", a.getName());

        setDropdownOptions();
        refreshFlipViewAccount();
        _userGrid.ajaxReload();
    }

    private void handleDeleteAccountCancel()
    {
        refreshFlipViewAccount();
    }

    private void handleDeleteUser()
    {
        MyAccountUser au;
        au = getPageSession().getAccountUser();
        au.deleteDao();

        _deleteUserDialog.ajaxClose();

        ajax().toast("Deleted user %s from %s", au.getUserName(), au.getAccountName());

        _userFrame.ajaxClear();
        _userGrid.ajaxReload();
    }

    private void handleClose()
    {
        _deleteUserDialog.ajaxClose();
    }

    private void handleUpdateValues()
    {
        refreshAll(false);
    }

    private void handleShowAddAccountBox()
    {
        _accountFrame.ajaxPrint(_addAccountChild);
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

        _accountFrame.ajaxPrint(_editAccountChild);
    }

    private void handleShowTransferBox()
    {
        String name;
        name = _viewAccountName.getValue();

        _transferGroup.setTitle("Transfer Ownership \n of %s", name);

        _accountFrame.ajaxPrint(_transferChild);
        _transferChild.ajax().focus();
    }

    private void handleSendTransferRequest()
    {
        MyAccount account;
        account = getPageSession().getAccount();

        String email = _transferEmailAutoComplete.getValue();

        boolean isValid = KmEmailParser.validate(email);

        if ( !isValid )
            _transferEmailAutoComplete.error("Invalid");

        MyTransferAccountUtility utility;
        utility = new MyTransferAccountUtility();
        utility.start(account, email);

        showSentMessage(email);
    }

    private void handleCancelTransferRequest()
    {
        refreshFlipViewAccount();
    }

    private void handleEditAccountSave()
    {
        _editAccountChild.validate();

        if ( !_editAccountName.hasValue() )
        {
            ajax().toast("Please enter an account name");
            return;
        }

        MyAccount a;
        a = getPageSession().getAccount();
        a.setName(_editAccountName.getValue());
        a.setTypeCode(_editTypeDropdown.getStringValue());
        a.saveDao();

        setDropdownOptions();
        _accountDropdown.ajaxSetValue(a.getUid());
        refreshFlipViewAccount();
        _userGrid.ajaxReload();
    }

    private void handleEditAccountCancel()
    {
        setDropdownOptions();
        refreshFlipViewAccount();
    }

    private void handleAddAccountSave()
    {
        _addAccountChild.validate();

        if ( !_addAccountName.hasValue() )
        {
            ajax().toast("Please enter an account name");
            return;
        }

        String name = _addAccountName.getValue();
        String typeCode = _addAccountType.getStringValue();
        MyAccountType type = MyAccountType.findCode(typeCode);
        MyUser user = getCurrentUser();

        MyAccount a;
        a = getAccountDao().createNewAccount(name, type, user);
        getPageSession().setAccount(a);

        setDropdownOptions();
        _accountDropdown.ajaxSetValue(a.getUid());
        refreshFlipViewAccount();
        _userGrid.ajaxReload();
    }

    private void handleAddAccountCancel()
    {
        refreshFlipViewAccount();
    }

    private void handleShowInviteUserBox()
    {
        _inviteGroup.setTitle("Invite User to %s", _viewAccountName.getValue());

        _accountFrame.ajaxPrint(_inviteUserChild);
        _inviteUserChild.ajax().focus();
    }

    private void handleViewUser()
    {
        MyAccountUser au;
        au = getAccountUserDao().findUid(getStringArgument());

        if ( au == null )
            au = getPageSession().getAccountUser();

        MyUser u;
        u = au.getUser();

        getPageSession().setUser(u);
        getPageSession().setAccountUser(au);

        _viewUserName.setValue(u.getName());
        _viewUserEmail.setValue(u.getEmail());
        _viewUserRole.setValue(au.getRoleName());

        if ( au.isRoleOwner() )
        {
            _editButton.hide();
            _viewUserFooter.hide();
            _viewUserChild.ajax().replace();
        }

        _userFrame.ajaxPrint(_viewUserChild);
    }

    private void handleEditUserSave()
    {
        _editUserChild.validate();

        MyAccountUser pageSessionAU;
        pageSessionAU = getPageSession().getAccountUser();

        String roleCode = _editRoleDropdown.getStringValue();

        MyAccountUser owner;
        owner = getAccountUserDao().findCurrentOwner(pageSessionAU.getAccount());

        boolean hasOwner = owner != null;
        boolean settingOwner = roleCode.equals(MyAccountUserRole.Owner.getCode());

        if ( hasOwner && settingOwner )
            ajax().alert("Looks like this account already has an owner.");
        else
            pageSessionAU.setRoleCode(roleCode);

        pageSessionAU.saveDao();

        MyUser u;
        u = pageSessionAU.getUser();

        _viewUserName.setValue(u.getName());
        _viewUserEmail.setValue(u.getEmail());
        _viewUserRole.setValue(pageSessionAU.getRoleName());

        _userFrame.ajaxPrint(_viewUserChild);

        _userGrid.ajaxReload();
    }

    private void handleEditUserCancel()
    {
        handleViewUser();
    }

    private void handleSendJoinRequest()
    {
        MyAccount account = getPageSession().getAccount();
        String email = _addUserEmail.getValue();
        String roleCode = _addRoleDropdown.getStringValue();

        boolean isValid = KmEmailParser.validate(email);

        if ( !isValid )
            _addUserEmail.error("Invalid");

        MyJoinAccountUtility utility;
        utility = new MyJoinAccountUtility();
        utility.start(account, email, roleCode);

        showSentMessage(email);
    }

    private void handleInviteUserCancel()
    {
        refreshFlipViewAccount();
    }

    private void handleShowEditUserBox()
    {
        MyAccountUser au;
        au = getPageSession().getAccountUser();

        MyUser u;
        u = au.getUser();

        if ( u != null )
        {
            _editUserName.setValue(u.getName());
            _editUserEmail.setValue(u.getEmail());
        }

        _editRoleDropdown.setValue(au.getRole());
        _userFrame.ajaxPrint(_editUserChild);
    }

    private void handleViewUserCancel()
    {
        _userFrame.ajaxClear();
    }

    private void handleShowDeleteAccountUserDialog()
    {
        _deleteUserDialog.ajaxOpen();
    }

    private void showSentMessage(String e)
    {
        ajax().toast("Your request has been sent to: " + e);

        refreshFlipViewAccount();
    }

    //##################################################
    //# convenience
    //##################################################

    private void refreshViewAccount()
    {
        MyAccount a;
        a = getPageSession().getAccount();

        MyAccountUser owner;
        owner = getAccountUserDao().findCurrentOwner(a);

        MyUser u;
        u = MyGlobals.getServerSession().getUser();

        if ( a == null )
        {
            a = getDropdownAccount();
            getPageSession().setAccount(a);
        }

        _viewAccountName.setValue(a.getName());
        _viewAccountType.setValue(a.getType().getName());

        boolean isPersonalAccount = a.getName().equalsIgnoreCase("Personal");
        boolean hasOwner = owner != null;
        boolean isOwner = isOwner(owner, u);

        if ( isPersonalAccount )
            _deleteButton.hide();

        /**
         * review_steve (wyatt) discuss name
         */

        if ( hasOwner && isOwner )
            _transferButton.show();

        _viewAccountFooter.ajax().replace();
        _viewAccountChild.ajaxUpdateValues();
    }

    private void refreshFlipViewAccount()
    {
        refreshViewAccount();
        _accountFrame.ajaxPrint(_viewAccountChild);
    }

    private void refreshAll(boolean isStart)
    {
        MyAccount da;
        da = getDropdownAccount();
        getPageSession().setAccount(da);

        if ( isStart )
            refreshViewAccount();
        else
            refreshFlipViewAccount();

        _userGrid.ajaxReload();
    }

    /**
     * review_steve (wyatt) discuss
     */
    private MyAccount getDropdownAccount()
    {
        return getAccountDao().findUid(_accountDropdown.getStringValue());
    }

    private KmList<ScOption> getDropdownList()
    {
        MyUser u = MyGlobals.getServerSession().getUser();

        if ( u == null )
            return null;

        KmList<ScOption> v;
        v = new KmList<ScOption>();

        KmList<MyAccountUser> accountUsers;
        accountUsers = getAccountUserDao().findAccountUsersFor(u);

        for ( MyAccountUser au : accountUsers )
        {
            ScOption e = new ScOption();
            e.setText(au.getAccount().getName());
            e.setValue(au.getAccount().getUid());
            v.add(e);
        }

        return v;
    }

    /**
     * this method sets the account dropdown to the value of the serversession account, 
     * which in turn is set by the MyPageLayout dropdown.
     */
    private void setDropdownOptions()
    {
        _accountDropdown.ajaxClearOptions();

        KmList<ScOption> list = getDropdownList();

        for ( ScOption e : list )
            _accountDropdown.addOption(e.getValue(), e.getText());

        if ( list.isNotEmpty() && getServerSession().hasAccount() )
        {
            String e = getServerSession().getAccount().getUid();
            _accountDropdown.setValue(e);
            _accountDropdown.ajaxUpdateValue();
        }

        //fixme_steve remove this when we have garunteed that the accounts list will never be empty.
        if ( list.isEmpty() )
        {
            _accountDropdown.ajaxAddOption("None", null);
            getServerSession().setAccount(null);
            MyPageLayout.getInstance().refreshDropdown();
            return;
        }

        _accountDropdown.ajax().replace();
    }

    //##################################################
    //# convenience
    //##################################################

    private MyAccountDao getAccountDao()
    {
        return getAccess().getAccountDao();
    }

    private MyAccountUserDao getAccountUserDao()
    {
        return getAccess().getAccountUserDao();
    }

    private boolean isOwner(MyAccountUser owner, MyUser u)
    {
        return owner.getUser().isSame(u);
    }
}
