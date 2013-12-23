package com.app.ui.page.admin.accounts;

import com.kodemore.adaptor.KmAdaptorIF;
import com.kodemore.collection.KmCollection;
import com.kodemore.collection.KmList;
import com.kodemore.filter.KmFilter;
import com.kodemore.filter.KmFilterFactoryIF;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScArray;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScCard;
import com.kodemore.servlet.control.ScCardFrame;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScDialog;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGrid;
import com.kodemore.servlet.control.ScGridColumn;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
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
import com.app.ui.core.MyPageSession;
import com.app.ui.layout.MyPageLayout;
import com.app.ui.page.admin.MyAdminPage;
import com.app.ui.page.login.MyJoinAccountUtility;
import com.app.ui.page.login.MyTransferAccountUtility;
import com.app.utility.MyButtonUrls;

public class MyAccountsPage
    extends MyAdminPage
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
    private ScDropdown            _addAccountTypeDropdown;
    private ScDropdown            _editRoleDropdown;
    private ScDropdown            _inviteRoleDropdown;

    private ScTextField           _viewAccountNameField;
    private ScTextField           _viewAccountTypeField;
    private ScTextField           _editAccountNameField;
    private ScTextField           _addAccountNameField;
    private ScTextField           _viewUserNameField;
    private ScTextField           _viewUserEmailField;
    private ScTextField           _viewUserRoleField;
    private ScTextField           _editUserNameField;
    private ScTextField           _editUserEmailField;
    private ScTextField           _inviteUserEmailField;
    private ScTextField           _deleteAccountNameField;
    private ScTextField           _deleteAccountTypeField;

    private ScAutoCompleteField   _transferEmailAutoComplete;

    private ScCardFrame           _accountFrame;
    private ScCard                _viewAccountCard;
    private ScCard                _editAccountCard;
    private ScCard                _addAccountCard;
    private ScCard                _inviteUserCard;
    private ScCard                _deleteAccountCard;
    private ScCard                _transferCard;

    private ScCardFrame           _userFrame;
    private ScCard                _viewUserCard;
    private ScCard                _editUserCard;

    private ScDialog              _deleteUserDialog;
    private ScDialog              _editingDialog;

    private ScGrid<MyAccountUser> _userGrid;

    private ScActionButton        _transferButton;
    private ScActionButton        _deleteButton;
    private ScActionButton        _editButton;
    private ScActionButton        _closeButton;
    private ScActionButton        _removeButton;

    private ScDiv                 _viewAccountFooter;
    private ScDiv                 _viewUserFooter;

    private ScBox                 _dialogBody;

    private ScLocalBoolean        _isEditing;
    private ScLocalString         _accountUid;

    //##################################################
    //# setup
    //##################################################

    @Override
    protected boolean requiresAccountOwner()
    {
        return true;
    }

    //##################################################
    //# start
    //##################################################

    @Override
    public void applyParametersToUrl(ScParameterList v)
    {
        // none
    }

    @Override
    public void applyParametersFromUrl(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        _isEditing = new ScLocalBoolean();
        _isEditing.setAutoSave();

        _accountUid = new ScLocalString();
        _accountUid.setAutoSave();

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
    }

    private void installAccountsDropdownOn(ScContainer root)
    {
        _accountDropdown = new ScDropdown();
        _accountDropdown.setOnChangeAction(newUpdateValuesAction());

        ScForm form;
        form = root.addForm();

        ScGroup group;
        group = form.addGroup("My Accounts");

        ScBox body;
        body = group.addPadSpaced();

        body.add(_accountDropdown);
        body.style().padBottom(10);

        ScDiv right;
        right = group.getHeader().addFloatRight();
        right.css().pad5();

        ScActionButton button;
        button = right.addButton("Add Account", newShowAddAccountBoxAction());
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

        installViewAccountCard();
        installEditAccountCard();
        installAddAccountCard();
        installInviteUserCard();
        installTransferAccountCard();
        installDeleteAccountCard();
    }

    private void installViewAccountCard()
    {
        ScCard card;
        card = _accountFrame.addCard();
        card.beDefault();

        ScForm form;
        form = card.addForm();

        ScGroup group;
        group = form.addGroup("View Account");

        ScDiv header;
        header = group.getHeader().addFloatRight();
        header.css().pad5();

        ScActionButton editButton;
        editButton = header.addButton("Edit", newShowEditAccountBoxAction());
        editButton.setImage(MyButtonUrls.edit());

        _viewAccountNameField = new ScTextField();
        _viewAccountNameField.setLabel("Name  ");
        _viewAccountNameField.setReadOnly();

        _viewAccountTypeField = new ScTextField();
        _viewAccountTypeField.setLabel("Type ");
        _viewAccountTypeField.setReadOnly();

        ScFieldTable fields;
        fields = group.addPad().addFields();
        fields.add(_viewAccountNameField);
        fields.add(_viewAccountTypeField);

        group.addDivider();

        _viewAccountFooter = group.addButtonBoxRight();

        _viewAccountFooter.addButton("Invite", newShowInviteUserBoxAction());

        _transferButton = _viewAccountFooter.addButton("Transfer", newShowTransferBoxAction());
        _transferButton.hide();

        _deleteButton = _viewAccountFooter.addButton("Delete", newShowDeleteAccountBoxAction());

        _viewAccountCard = card;
    }

    private void installEditAccountCard()
    {
        _editAccountNameField = new ScTextField();
        _editAccountNameField.setLabel("Name ");

        _editTypeDropdown = MyAccount.Tools.newTypeDropdown();

        ScActionIF saveAction = newEditAccountSaveAction();
        ScActionIF cancelAction = newEditAccountCancelAction();

        ScCard card;
        card = _accountFrame.addCard();

        ScForm form;
        form = card.addForm();
        form.setDefaultAction(saveAction);
        form.onEscape().run(cancelAction);

        ScGroup group;
        group = form.addGroup("Edit Account");

        ScFieldTable fields;
        fields = group.addPad().addFields();
        fields.add(_editAccountNameField);
        fields.add(_editTypeDropdown);

        group.addDivider();

        ScDiv footer;
        footer = group.addButtonBoxRight();
        footer.addCancelButton(cancelAction);
        footer.addSubmitButton("Save");

        _editAccountCard = card;
    }

    private void installAddAccountCard()
    {
        ScActionIF saveAction = newAddAccountSaveAction();
        ScActionIF cancelAction = newAddAccountCancelAction();

        ScCard card;
        card = _accountFrame.addCard();

        ScForm form;
        form = card.addForm();
        form.setDefaultAction(saveAction);
        form.onEscape().run(cancelAction);

        ScGroup group;
        group = form.addGroup("Add Account");

        _addAccountNameField = new ScTextField();
        _addAccountNameField.setLabel("Name ");

        _addAccountTypeDropdown = MyAccount.Tools.newTypeDropdown();

        ScFieldTable fields;
        fields = group.addPad().addFields();
        fields.add(_addAccountNameField);
        fields.add(_addAccountTypeDropdown);

        group.addDivider();

        ScDiv footer;
        footer = group.addButtonBoxRight();
        footer.addCancelButton(cancelAction);
        footer.addSubmitButton("Save");

        _addAccountCard = card;
    }

    private void installInviteUserCard()
    {
        ScActionIF sendAction = newSendJoinRequestAction();
        ScActionIF cancelAction = newInviteUserCancelAction();

        ScCard card;
        card = _accountFrame.addCard();

        ScForm form;
        form = card.addForm();
        form.setDefaultAction(sendAction);
        form.onEscape().run(cancelAction);

        ScGroup group = form.addGroup();
        group.setTitle("Invite User");

        ScBox body;
        body = group.addBox();
        body.css().pad().width250();
        body.addText(getInviteText());

        _inviteUserEmailField = new ScTextField();
        _inviteUserEmailField.setLabel("Email ");

        populateAddRoleDropdown();

        ScFieldTable fields;
        fields = body.addFields();
        fields.addSpace();
        fields.add(_inviteUserEmailField);
        fields.add(_inviteRoleDropdown);

        group.addDivider();

        ScDiv footer;
        footer = group.addButtonBoxRight();
        footer.addCancelButton(cancelAction);
        footer.addSubmitButton("Send Request");

        _inviteUserCard = card;
    }

    private void installDeleteAccountCard()
    {
        ScActionIF saveAction = newDeleteAccountAction();
        ScActionIF cancelAction = newDeleteAccountCancelAction();

        ScCard card;
        card = _accountFrame.addCard();

        ScForm form;
        form = card.addForm();
        form.setDefaultAction(saveAction);
        form.onEscape().run(cancelAction);

        ScGroup group = form.addGroup();
        group.setTitle("Delete Account");
        group.setFlavorError();

        _deleteAccountNameField = new ScTextField();
        _deleteAccountNameField.setLabel("Name ");
        _deleteAccountNameField.setReadOnly();

        _deleteAccountTypeField = new ScTextField();
        _deleteAccountTypeField.setLabel("Type ");
        _deleteAccountTypeField.setReadOnly();

        ScFieldTable fields;
        fields = group.addPad().addFields();
        fields.add(_deleteAccountNameField);
        fields.add(_deleteAccountTypeField);

        group.addDivider();

        ScDiv footer;
        footer = group.addButtonBoxRight();
        footer.addCancelButton(cancelAction);
        footer.addSubmitButton("Delete");

        _deleteAccountCard = card;
    }

    private void installTransferAccountCard()
    {
        ScActionIF sendAction = newSendTransferRequestAction();
        ScActionIF cancelAction = newCancelTransferRequestAction();

        ScCard card;
        card = _accountFrame.addCard();

        ScForm form;
        form = card.addForm();
        form.setDefaultAction(sendAction);
        form.onEscape().run(cancelAction);

        ScGroup group = form.addGroup();
        group.setTitle("Transfer Ownership");

        ScBox body;
        body = group.addBox();
        body.css().pad().width250();
        body.addText(getTransferText());

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

        _transferCard = card;
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
            accountUid = getPageSession().getCurrentAccountUid();

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
        ScActionIF cancelAction = newViewUserCancelAction();
        ScActionIF removeAction = newShowDeleteAccountUserDialogAction();

        ScCard card;
        card = _userFrame.addCard();

        ScForm form;
        form = card.addForm();
        form.onEscape().run(cancelAction);

        ScGroup group;
        group = form.addGroup("View User");

        ScDiv header;
        header = group.getHeader().addFloatRight();
        header.css().pad5();

        _editButton = header.addButton("Edit", newShowEditUserBoxAction());
        _editButton.setImage(MyButtonUrls.edit());

        _viewUserNameField = new ScTextField();
        _viewUserNameField.setLabel("Name ");
        _viewUserNameField.setReadOnly();

        _viewUserEmailField = new ScTextField();
        _viewUserEmailField.setLabel("Email ");
        _viewUserEmailField.setReadOnly();

        _viewUserRoleField = new ScTextField();
        _viewUserRoleField.setLabel("Role ");
        _viewUserRoleField.setReadOnly();

        ScFieldTable fields;
        fields = group.addPad().addFields();
        fields.add(_viewUserNameField);
        fields.add(_viewUserEmailField);
        fields.add(_viewUserRoleField);

        group.addDivider();

        _viewUserFooter = group.addButtonBoxRight();

        _closeButton = _viewUserFooter.addButton("Close", cancelAction);
        _removeButton = _viewUserFooter.addButton("Remove", removeAction);

        _viewUserCard = card;
    }

    private void installEditUserFrame()
    {
        ScActionIF saveAction = newEditUserSaveAction();
        ScActionIF cancelAction = newEditUserCancelAction();

        ScCard card;
        card = _userFrame.addCard();

        ScForm form;
        form = card.addForm();
        form.setDefaultAction(saveAction);
        form.onEscape().run(cancelAction);

        ScGroup group;
        group = form.addGroup("Edit User Role");

        _editUserNameField = new ScTextField();
        _editUserNameField.setLabel("Name ");
        _editUserNameField.setReadOnly();

        _editUserEmailField = new ScTextField();
        _editUserEmailField.setLabel("Email ");
        _editUserEmailField.setReadOnly();

        populateEditRoleDropdown();

        ScFieldTable fields;
        fields = group.addPad().addFields();
        fields.add(_editUserNameField);
        fields.add(_editUserEmailField);
        fields.add(_editRoleDropdown);

        group.addDivider();

        ScDiv footer;
        footer = group.addButtonBoxRight();
        footer.addCancelButton(cancelAction);
        footer.addSubmitButton("Save");

        _editUserCard = card;
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
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        setDropdownOptions();
        refreshAll(true);
    }

    //##################################################
    //# handle
    //##################################################

    private void handleShowDeleteAccountBox()
    {
        setIsEditing();

        MyAccount a;
        a = getPageSession().getAccount();

        if ( a != null )
        {
            _deleteAccountNameField.setValue(a.getName());
            _deleteAccountTypeField.setValue(a.getType().getName());
        }

        _deleteAccountCard.print();
    }

    private void handleDeleteAccount()
    {
        MyAccount a;
        a = getPageSession().getAccount();

        MyUser u;
        u = getCurrentUser();

        if ( !a.validateDeletePermissions(u) )
            error("Sorry, you cannot delete this account.");

        a.deleteDao();

        MyPageLayout.getInstance().ajaxRefresh();

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
        _addAccountCard.print();
    }

    private void handleShowEditAccountBox()
    {
        setIsEditing();

        MyAccount a;
        a = getPageSession().getAccount();

        if ( a != null )
        {
            _editAccountNameField.setValue(a.getName());
            _editTypeDropdown.setValue(a.getType());
        }

        _editAccountCard.print();
    }

    private void handleShowTransferBox()
    {
        setIsEditing();
        _transferCard.print();
    }

    private void handleSendTransferRequest()
    {
        MyAccount a;
        a = getPageSession().getAccount();

        String email = _transferEmailAutoComplete.getValue();

        boolean isValid = KmEmailParser.validate(email);

        if ( !isValid )
            _transferEmailAutoComplete.error("Invalid");

        MyUser from = getCurrentUser();
        MyUser to = getAccess().getUserDao().findEmail(email);

        if ( !a.validateTransferOwnership(from, to) )
            error("You cannot transfer ownership of this account.");

        MyTransferAccountUtility utility;
        utility = new MyTransferAccountUtility();
        utility.start(a, email);

        showSentMessage(email);
    }

    private void handleCancelTransferRequest()
    {
        refreshFlipViewAccount();
    }

    private void handleEditAccountSave()
    {
        _editAccountCard.validate();

        if ( !_editAccountNameField.hasValue() )
            error("Please enter an account name");

        MyAccount a;
        a = getPageSession().getAccount();
        a.setName(_editAccountNameField.getValue());
        a.setTypeCode(_editTypeDropdown.getStringValue());
        a.saveDao();

        setDropdownOptions();
        _accountDropdown.ajaxSetValue(a.getUid());

        MyPageLayout pageLayout;
        pageLayout = MyPageLayout.getInstance();
        pageLayout.ajaxRefresh();

        refreshFlipViewAccount();
        _userGrid.ajaxReload();
    }

    private void handleEditAccountCancel()
    {
        refreshFlipViewAccount();
    }

    private void handleAddAccountSave()
    {
        _addAccountCard.validate();

        if ( _addAccountNameField.isEmpty() )
            error("Please enter an account name");

        String name = _addAccountNameField.getValue();
        String typeCode = _addAccountTypeDropdown.getStringValue();
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

        MyPageLayout pageLayout;
        pageLayout = MyPageLayout.getInstance();
        pageLayout.ajaxRefresh();

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
        _inviteUserCard.print();
    }

    private void handleViewUser()
    {
        MyAccountUser au;
        au = getAccountUserDao().findUid(getStringArgument());

        MyPageSession ps = getPageSession();
        if ( au == null )
            au = ps.getAccountUser();

        MyUser u;
        u = au.getUser();

        ps.setUser(u);
        ps.setAccountUser(au);

        _viewUserNameField.setValue(u.getName());
        _viewUserEmailField.setValue(u.getEmail());
        _viewUserRoleField.setValue(au.getRoleName());

        if ( au.isRoleOwner() )
        {
            _closeButton.show();
            _editButton.hide();
            _removeButton.hide();
            _viewUserCard.ajax().replace();
        }

        _viewUserCard.print();
    }

    private void handleEditUserSave()
    {
        _editUserCard.validate();

        MyAccountUser pageSessionAU;
        pageSessionAU = getPageSession().getAccountUser();

        String roleCode;
        roleCode = _editRoleDropdown.getStringValue();

        MyUser owner;
        owner = pageSessionAU.getAccount().getOwner();

        boolean hasOwner = owner != null;
        boolean settingOwner = roleCode.equals(MyAccountUserRole.Owner.getCode());

        if ( hasOwner && settingOwner )
            error("Looks like this account already has an owner.");
        else
            pageSessionAU.setRoleCode(roleCode);

        pageSessionAU.saveDao();

        MyUser u;
        u = pageSessionAU.getUser();

        _viewUserNameField.setValue(u.getName());
        _viewUserEmailField.setValue(u.getEmail());
        _viewUserRoleField.setValue(pageSessionAU.getRoleName());

        _viewUserCard.print();

        _userGrid.ajaxReload();
    }

    private void handleEditUserCancel()
    {
        setDoneEditing();
        handleViewUser();
    }

    private void handleSendJoinRequest()
    {
        MyAccount account = getPageSession().getAccount();
        String email = _inviteUserEmailField.getValue();
        String roleCode = _inviteRoleDropdown.getStringValue();

        boolean isValid = KmEmailParser.validate(email);

        if ( !isValid )
            _inviteUserEmailField.error("Invalid");

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
            _editUserNameField.setValue(u.getName());
            _editUserEmailField.setValue(u.getEmail());
        }

        _editRoleDropdown.setValue(au.getRole());
        _editUserCard.print();
    }

    private void handleViewUserCancel()
    {
        _userFrame.ajaxClear();
    }

    private void handleShowDeleteAccountUserDialog()
    {
        String userName = getPageSession().getUser().getName();
        String accountName = getPageSession().getAccount().getName();

        _dialogBody.addPad().addText(
            "Are you sure you want to remove %s from %s?",
            userName,
            accountName);

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
        u = getCurrentUser();

        if ( a == null )
        {
            a = getDropdownAccount();
            getPageSession().setAccount(a);
        }

        _viewAccountNameField.setValue(a.getName());
        _viewAccountTypeField.setValue(a.getType().getName());

        boolean isOwner = a.hasOwner(u);
        boolean isOnlyAccount = u.getAccountUserCount() == 1;

        if ( isOnlyAccount || !isOwner )
            _deleteButton.hide();

        if ( isOwner && !isOnlyAccount )
            _transferButton.show();

        _viewAccountFooter.ajax().replace();
        _viewAccountCard.ajaxUpdateValues();
    }

    private void refreshFlipViewAccount()
    {
        refreshViewAccount();
        _viewAccountCard.print();
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
        _accountDropdown.clearOptions();

        KmList<ScOption> list = getDropdownList();

        _accountDropdown.setOptions(list);

        if ( list.isNotEmpty() && getPageSession().hasCurrentAccount() )
        {
            String e = getPageSession().getCurrentAccountUid();
            _accountDropdown.setValue(e);
            _accountDropdown.ajaxUpdateValue();
        }

        _accountDropdown.ajaxUpdateOptions();
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
