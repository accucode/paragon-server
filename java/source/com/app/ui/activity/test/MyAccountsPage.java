package com.app.ui.activity.test;

import com.kodemore.adaptor.KmAdaptorIF;
import com.kodemore.collection.KmCollection;
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
import com.kodemore.servlet.control.ScSubmitButton;
import com.kodemore.servlet.field.ScAutoCompleteCallbackIF;
import com.kodemore.servlet.field.ScAutoCompleteField;
import com.kodemore.servlet.field.ScDropdown;
import com.kodemore.servlet.field.ScOption;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.servlet.variable.ScLocalBoolean;
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

public class MyAccountsPage
    extends MyAbstractTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyAccountsPage instance = new MyAccountsPage();

    private MyAccountsPage()
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
    private ScDropdown            _inviteRoleDropdown;

    private ScTextField           _viewAccountName;
    private ScTextField           _viewAccountType;
    private ScTextField           _editAccountName;
    private ScTextField           _addAccountName;
    private ScTextField           _viewUserName;
    private ScTextField           _viewUserEmail;
    private ScTextField           _viewUserRole;
    private ScTextField           _editUserName;
    private ScTextField           _editUserEmail;
    private ScTextField           _inviteUserEmail;
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
    private ScDialog              _editingDialog;

    private ScGrid<MyAccountUser> _userGrid;

    private ScActionButton        _transferButton;
    private ScActionButton        _deleteButton;
    private ScActionButton        _editButton;
    private ScActionButton        _closeButton;
    private ScActionButton        _cancelButton;
    private ScSubmitButton        _removeButton;

    private ScGroup               _deleteGroup;

    private ScDiv                 _viewAccountFooter;
    private ScDiv                 _viewUserFooter;

    private ScBox                 _dialogBody;

    private ScLocalBoolean        _isEditing;
    private ScLocalString         _accountUid;

    //##################################################
    //# install
    //##################################################

    @Override
    protected ScPageRoot installRoot()
    {
        _isEditing = new ScLocalBoolean();
        _isEditing.setAutoSave();

        _accountUid = new ScLocalString();
        _accountUid.setAutoSave();

        ScPageRoot root;
        root = newPageRoot();
        root.css().gap();

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
        installEditingDialog(root);

        return root;
    }

    private void installAccountsDropdownOn(ScContainer root)
    {
        _accountDropdown = new ScDropdown();
        _accountDropdown.setAction(newUpdateValuesAction());

        ScForm form;
        form = root.addForm();

        ScGroup group;
        group = form.addGroup("My Accounts");

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
    //==================================================

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
        frameChild = _accountFrame.addChild();

        ScForm form;
        form = frameChild.addForm();

        ScGroup group;
        group = form.addGroup("View Account");

        ScDiv header;
        header = group.getHeader().addFloatRight();
        header.css().pad5();

        ScActionButton editButton;
        editButton = header.addButton("Edit", newShowEditAccountBoxAction());
        editButton.setImage(MyButtonUrls.edit());

        ScBox body;
        body = group.addBox();
        body.css().pad();

        _viewAccountName = new ScTextField();
        _viewAccountName.setLabel("Name  ");
        _viewAccountName.setReadOnly();

        _viewAccountType = new ScTextField();
        _viewAccountType.setLabel("Type ");
        _viewAccountType.setReadOnly();

        ScFieldTable fields;
        fields = body.addFields();
        fields.add(_viewAccountName);
        fields.add(_viewAccountType);

        group.addDivider();

        _viewAccountFooter = group.addButtonBoxRight();

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
        child = _accountFrame.addChild();

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
        _editAccountName.setLabel("Name ");

        _editTypeDropdown = MyAccount.Tools.newTypeDropdown();
        _editTypeDropdown.setLabel("Type ");

        ScFieldTable fields;
        fields = body.addFields();
        fields.add(_editAccountName);
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
        frameChild = _accountFrame.addChild();

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
        _addAccountName.setLabel("Name ");

        _addAccountType = MyAccount.Tools.newTypeDropdown();
        _addAccountType.setLabel("Type ");

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
        frameChild = _accountFrame.addChild();

        ScForm form;
        form = frameChild.addForm();
        form.setDefaultAction(sendAction);
        form.onEscape().run(cancelAction);

        ScGroup group = form.addGroup();
        group.setTitle("Invite User");

        ScBox body;
        body = group.addBox();
        body.css().pad();

        ScBox box;
        box = body.addBox();
        box.addText(getInviteText());
        box.css().centerText();

        /**
         * (valerie) 
         * Where can we add a new width constant to the css file?
         * 
         * review_valerie review_steve (wyatt)
         *      You can add generic (non-theme specific) styles to "tools.css".
         */
        box.css().width250();

        _inviteUserEmail = new ScTextField();
        _inviteUserEmail.setLabel("Email ");

        populateAddRoleDropdown();

        ScFieldTable fields;
        fields = body.addFields();
        fields.addSpace();
        fields.add(_inviteUserEmail);
        fields.add(_inviteRoleDropdown);

        group.addDivider();

        ScDiv footer;
        footer = group.addButtonBoxRight();
        footer.addCancelButton(cancelAction);
        footer.addSubmitButton("Send Request");

        _inviteUserChild = frameChild;
    }

    private void installDeleteAccountFrame()
    {
        ScActionIF saveAction = newDeleteAccountAction();
        ScActionIF cancelAction = newDeleteAccountCancelAction();

        ScFrameChild frameChild;
        frameChild = _accountFrame.addChild();

        ScForm form;
        form = frameChild.addForm();
        form.setDefaultAction(saveAction);
        form.onEscape().run(cancelAction);

        _deleteGroup = form.addGroup();
        _deleteGroup.setFlavorError();

        ScBox body;
        body = _deleteGroup.addBox();
        body.css().pad();

        _deleteAccountName = new ScTextField();
        _deleteAccountName.setLabel("Name ");
        _deleteAccountName.setReadOnly();

        _deleteAccountType = new ScTextField();
        _deleteAccountType.setLabel("Type ");
        _deleteAccountType.setReadOnly();

        ScFieldTable fields;
        fields = body.addFields();
        fields.add(_deleteAccountName);
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
        frameChild = _accountFrame.addChild();

        ScForm form;
        form = frameChild.addForm();
        form.setDefaultAction(sendAction);
        form.onEscape().run(cancelAction);

        ScGroup group = form.addGroup();
        group.setTitle("Transfer Ownership");

        ScBox body;
        body = group.addBox();
        body.css().pad();

        ScBox box;
        box = body.addBox();
        box.addText(getTransferText());
        box.css().centerText();
        box.css().width250();

        _transferEmailAutoComplete = new ScAutoCompleteField();
        _transferEmailAutoComplete.setLabel("Email ");
        _transferEmailAutoComplete.setCallback(newTransferEmailCallback());
        _transferEmailAutoComplete.track(getPageSession().getAccountUidHolder());

        ScFieldTable fields;
        fields = body.addFields();
        fields.addSpace();
        fields.add(_transferEmailAutoComplete);

        group.addDivider();

        ScDiv footer;
        footer = group.addButtonBoxRight();
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

        _inviteRoleDropdown = new ScDropdown();
        _inviteRoleDropdown.addOption(user);
        _inviteRoleDropdown.addOption(manager);
        _inviteRoleDropdown.setLabel("Role ");
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
    //==================================================

    private void installUserGrid(ScContainer root)
    {
        MyMetaAccountUser x = MyAccountUser.Meta;

        ScGroup group;
        group = root.addGroup();
        group.setTitle("Account Users");

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
    //==================================================

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
        frameChild = _userFrame.addChild();

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

        _closeButton = _viewUserFooter.addButton("Close", cancelAction);
        _cancelButton = _viewUserFooter.addCancelButton(cancelAction);
        _removeButton = _viewUserFooter.addSubmitButton("Remove from Account");

        _closeButton.hide();

        _viewUserChild = frameChild;
    }

    private void installEditUserFrame()
    {
        ScActionIF saveAction = newEditUserSaveAction();
        ScActionIF cancelAction = newEditUserCancelAction();

        ScFrameChild frameChild;
        frameChild = _userFrame.addChild();

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

    //==================================================
    //= install : delete user dialog
    //==================================================

    private void installDeleteUserDialog(ScPageRoot root)
    {
        _deleteUserDialog = root.addDialog();
        _deleteUserDialog.getHeaderBox().addPad().addText("Remove User?");
        _deleteUserDialog.setBodyHeight(125);

        _dialogBody = _deleteUserDialog.getBodyBox();
        _dialogBody.addPad().addText("Are you sure you want to remove this user from the account?");

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

    //==================================================
    //= install : editing dialog
    //==================================================

    private void installEditingDialog(ScPageRoot root)
    {
        _editingDialog = root.addDialog();
        _editingDialog.getHeaderBox().addPad().addText("Lose changes?");
        _editingDialog.setBodyHeight(125);

        ScBox box = _editingDialog.getBodyBox();
        box.addPad().addText(
            "You seem to be editing an account or user.  If you change"
                + " accounts now, you will lose your changes.");
        ScBox footer;
        footer = _editingDialog.getFooterBox().addPad();

        ScBox buttonBox;
        buttonBox = footer.addButtonBoxRight();

        ScActionButton cancelButton;
        cancelButton = buttonBox.addButton("Cancel", newCloseEditingDialogAction());
        cancelButton.setImage(MyButtonUrls.cancel());
        cancelButton.setFlavorNegative();

        ScActionButton deleteButton;
        deleteButton = buttonBox.addButton("Go Ahead", newChangeAccountAction());
        deleteButton.setImage(MyButtonUrls.primary());
        deleteButton.setFlavorPositive();
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

    private ScActionIF newCloseEditingDialogAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleCloseEditingDialog();
            }
        };
    }

    private ScActionIF newChangeAccountAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleChangeAccount();
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
        setIsEditing();

        _deleteGroup.setTitle("Delete Account");

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
        au = a.getAccountUserFor(getCurrentUser());

        /**
         * review_steve review_wyatt review_valerie (steve) 
         * this method was crashing the program and not actually deleting 
         * the account. I figure that it was because the relationship between 
         * the user and the accountUser was not removed
         * 
         * see the next comment: 
         */
        a.deleteDao();

        //        au.deleteDao();
        /**
         * the above line was removed and replaced with the two below.
         */
        MyUser u = getCurrentUser();
        u.removeAccountUser(au);

        MyPageLayout.getInstance().refreshDropdown();

        ajax().toast("Deleted account %s", a.getName());

        setDropdownOptions();

        MyAccount da;
        da = getDropdownAccount();
        getPageSession().setAccount(da);

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

        ajax().toast("Deleted user %s from account %s", au.getUserName(), au.getAccountName());

        _userFrame.ajaxClear();
        _userGrid.ajaxReload();
    }

    private void handleClose()
    {
        _deleteUserDialog.ajaxClose();
    }

    private void handleCloseEditingDialog()
    {
        _accountDropdown.setValue(getPageSession().getAccount().getUid());
        _accountDropdown.ajaxUpdateValue();
        _editingDialog.ajaxClose();
    }

    private void handleChangeAccount()
    {
        _accountDropdown.setValue(getAccountUid());
        _accountDropdown.ajaxUpdateValue();

        _userFrame.ajaxClear();
        refreshAll(false);
        _editingDialog.ajaxClose();
    }

    private void handleUpdateValues()
    {
        setAccountUid(getDropdownAccount().getUid());

        if ( isEditing() )
        {
            _editingDialog.ajaxOpen();
            return;
        }

        _userFrame.ajaxClear();
        refreshAll(false);
    }

    private void handleShowAddAccountBox()
    {
        setIsEditing();
        _accountFrame.ajaxPrint(_addAccountChild);
        _addAccountChild.ajax().focus();
    }

    private void handleShowEditAccountBox()
    {
        setIsEditing();

        MyAccount a;
        a = getPageSession().getAccount();

        if ( a != null )
        {
            _editAccountName.setValue(a.getName());
            _editTypeDropdown.setValue(a.getType());
        }

        _accountFrame.ajaxPrint(_editAccountChild);
    }

    private void handleShowTransferBox()
    {
        setIsEditing();
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

        MyUser from = getCurrentUser();
        MyUser to = getAccess().getUserDao().findEmail(email);

        if ( !account.validateTransferOwnership(from, to) )
            error("You cannot transfer ownership of this account.");

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
        refreshFlipViewAccount();
    }

    private void handleAddAccountSave()
    {
        _addAccountChild.validate();

        if ( _addAccountName.isEmpty() )
        {
            ajax().toast("Please enter an account name");
            return;
        }

        String name = _addAccountName.getValue();
        String typeCode = _addAccountType.getStringValue();
        MyAccountType type = MyAccountType.findCode(typeCode);
        MyUser user = getCurrentUser();

        MyAccount a;
        if ( type.isPersonal() )
            a = user.addPersonalAccount(name);
        else
            a = user.addBusinessAccount(name);

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
        setIsEditing();
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
            _closeButton.show();
            _editButton.hide();
            _cancelButton.hide();
            _removeButton.hide();
            _viewUserChild.ajax().replace();
        }

        _userFrame.ajaxPrint(_viewUserChild);
    }

    private void handleEditUserSave()
    {
        _editUserChild.validate();

        MyAccountUser pageSessionAU;
        pageSessionAU = getPageSession().getAccountUser();

        String roleCode;
        roleCode = _editRoleDropdown.getStringValue();

        MyUser owner;
        owner = pageSessionAU.getAccount().getOwner();

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
        setDoneEditing();
        handleViewUser();
    }

    private void handleSendJoinRequest()
    {
        //review_steve VALIDATE EMAIL FIELD

        MyAccount account = getPageSession().getAccount();
        String email = _inviteUserEmail.getValue();
        String roleCode = _inviteRoleDropdown.getStringValue();

        boolean isValid = KmEmailParser.validate(email);

        //(steve) error message is not displaying.

        /**
         * review_steve (wyatt)
         *      Use multiline comments for review tags.
         *      Fix spacing on comments.
         *      
         *      There was a problem with message propagation through Frame/FrameChildren.
         *      The problem should be fixed.
         */

        if ( !isValid )
            _inviteUserEmail.error("Invalid");

        if ( !checkAccountUserExists(email, account) )
        {
            MyJoinAccountUtility utility;
            utility = new MyJoinAccountUtility();
            utility.start(account, email, roleCode);

            showSentMessage(email);
        }
        else
            error("The email address "
                + email
                + " is already associated with the account "
                + account.getName()
                + ".");
    }

    private boolean checkAccountUserExists(String email, MyAccount account)
    {
        MyUser user;
        user = getAccess().getUserDao().findEmail(email);

        MyAccountUser accountUser = account.getAccountUserFor(user);

        return accountUser != null;

    }

    private void handleInviteUserCancel()
    {
        refreshFlipViewAccount();
    }

    private void handleShowEditUserBox()
    {
        setIsEditing();

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
        //        String userName = getPageSession().getUser().getName();
        //        String accountName = getPageSession().getAccount().getName();

        /**
         * (valerie) This method is not working as intended,
         * what am I missing?
         * 
         * review_valerie (wyatt)
         *      I don't know.
         *      What did you intend?
         *      What did you experience?
         */
        //        _dialogBody.addPad().addText(
        //            "Are you sure you want to remove %s from %s?",
        //            userName,
        //            accountName);

        _deleteUserDialog.ajax().replace();
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
        setDoneEditing();

        MyAccount a;
        a = getPageSession().getAccount();

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
        boolean hasOwner = a.getOwner() != null;
        boolean isOwner = isOwner(a.getOwner(), u);

        if ( isPersonalAccount || !isOwner )
            _deleteButton.hide();

        /**
         * review_steve (wyatt) discuss
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
        MyUser u = getCurrentUser();
        if ( u == null )
            return null;

        KmList<ScOption> v;
        v = new KmList<ScOption>();

        KmCollection<MyAccountUser> accountUsers;
        accountUsers = u.getAccountUsers();

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
        //        if ( list.isEmpty() )
        //        {
        //            _accountDropdown.ajaxAddOption("None", null);
        //            getServerSession().setAccount(null);
        //            MyPageLayout.getInstance().refreshDropdown();
        //            return;
        //        }

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

    private boolean isOwner(MyUser owner, MyUser u)
    {
        return owner.isSame(u);
    }

    private String getAccountUid()
    {
        return _accountUid.getValue();
    }

    private void setAccountUid(String accountUid)
    {
        _accountUid.setValue(accountUid);
    }

    //==================================================
    //= convenience :: editing
    //==================================================

    private boolean isEditing()
    {
        return getIsEditing() == true;
    }

    private boolean getIsEditing()
    {
        return _isEditing.getValue();
    }

    private void setIsEditing()
    {
        setIsEditing(true);
    }

    private void setDoneEditing()
    {
        setIsEditing(false);
    }

    private void setIsEditing(boolean isEditing)
    {
        _isEditing.setValue(isEditing);
    }

    //##################################################
    //# messages
    //##################################################

    //    review_steve(valerie) Wyatt moved these down here.
    private String getTransferText()
    {
        return ""
            + "Enter email address of user you with to transfer ownership to. "
            + "User must accept ownership.  There can be only one owner per account.";
    }

    private String getInviteText()
    {
        return ""
            + "Enter email address of user you wish to invite to this account. "
            + "User must accept invitation to be added.";
    }
}
