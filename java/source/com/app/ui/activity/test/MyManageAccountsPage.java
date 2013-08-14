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
import com.app.model.MyAccount;
import com.app.model.MyAccountType;
import com.app.model.MyAccountUser;
import com.app.model.MyAccountUserRole;
import com.app.model.MyServerSession;
import com.app.model.MyUser;
import com.app.model.meta.MyMetaAccountUser;
import com.app.ui.activity.login.MyJoinAccountUtility;
import com.app.ui.activity.login.MyTransferAccountUtility;
import com.app.ui.layout.MyPageLayout;
import com.app.utility.MyButtonUrls;
import com.app.utility.MyGlobals;

public class MyManageAccountsPage
    extends MyAbstractTestPage
{
    /**
     *  (steve) Grid not loading users
     *  when you enter the app you click "admin", then click "manage accounts".
     *  when you enter this page the grid fails to display the users associated with the current account.
     *  if you click the refresh icon it will display. Please check it out.
     *  
     * review_steve (wyatt)
     *      Fix spacing in comments.
     *      I cannot reproduce the problem.
     */

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

    private ScLocalString         _accountName;

    private ScGroup               _inviteGroup;
    private ScGroup               _deleteGroup;

    private ScDiv                 _viewAccountFooter;
    private ScGroup               _transferGroup;

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

    /**
     * (valerie)
     * not sure this looks too much better
     * 
     * review_valerie (wyatt) discuss
     *      I don't know what you are referring to.
     *      Use better names for the two buttons.
     *      
     * (valerie)
     * not sure this the border around the form looks too much better
     * 
     * review_valerie (wyatt) discuss
     *      Use better names for the two buttons.
     */
    private void installDeleteUserDialog(ScPageRoot root)
    {
        _deleteUserDialog = root.addDialog();
        _deleteUserDialog.getHeaderBox().hide();
        _deleteUserDialog.getFooterBox().hide();
        _deleteUserDialog.setBodyHeight(125);

        ScBox body = _deleteUserDialog.getBodyBox();

        ScGroup group;
        group = body.addGroup("Are you sure you want to \n remove this user?");

        ScDiv footer;
        footer = group.addButtonBoxRight();

        ScActionButton button1;
        button1 = footer.addButton("Cancel", newCloseAction());
        button1.setImage(MyButtonUrls.cancel());

        ScActionButton button2;
        button2 = footer.addButton("Yes", newDeleteUserAction());
        button2.setImage(MyButtonUrls.primary());
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
        _transferButton.hide();

        _viewAccountFooter.addButton("Invite", newShowInviteUserBoxAction());

        _deleteButton = _viewAccountFooter.addButton("Delete", newShowDeleteAccountBoxAction());

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
        ScActionIF cancelAction = newCloseAction();

        ScFrameChild frameChild;
        frameChild = _accountFrame.createChild();

        ScForm form;
        form = frameChild.addForm();
        form.setDefaultAction(saveAction);
        form.onEscape().run(cancelAction);

        _deleteGroup = form.addGroup();
        /**
         * review_steve (valerie) trying to make this stand out more than the
         * others
         */
        // todo_valerie add red background somewhere in here

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

        // review_steve AUTO COMPLETE FIELD
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
        // review_steve AUTO COMPLETE FIELD
        /**
         * (steve) autoComplete field tracked values
         *  (steve) autoComplete field tracked values
         *  
         * review_steve (wyatt)
         *      Fix comment spacing above.
         *      Discuss method below.
         *      Use db.
         *      Limit.
         */

        KmList<String> v;
        v = new KmList<String>();

        MyAccount account = getPageSession().getAccount();

        KmList<MyAccountUser> accountUsers;
        accountUsers = getAccountUserDao().findAccountUsersFor(account);

        for ( MyAccountUser e : accountUsers )
            if ( e.getUser().getEmail().toLowerCase().contains(term.toLowerCase()) )
                v.add(e.getUser().getEmail());

        for ( MyAccountUser e : accountUsers )
            v.add(e.getUser().getEmail());

        return v;
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
        grid.trackAll(_accountDropdown);
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
        ScFrameChild frameChild;
        frameChild = _userFrame.createChild();

        ScGroup group;
        group = frameChild.addGroup("View User");

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

        ScActionButton cancelButton;
        cancelButton = footer.addButton("Cancel", newViewUserCancelAction());
        cancelButton.setImage(MyButtonUrls.cancel());

        ScActionButton removeButton;
        removeButton = footer.addButton(
            "Remove from Account",
            newShowDeleteAccountUserDialogAction());
        removeButton.setImage(MyButtonUrls.primary());

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
        handleUpdateValues();
    }

    //##################################################
    //# handle
    //##################################################

    private void handleShowDeleteAccountBox()
    {
        String accountName;
        accountName = _viewAccountName.getValue();

        _deleteGroup.setTitle("Delete %s Account", accountName);

        MyAccount account;
        account = getAccountDao().findName(accountName);

        if ( account != null )
            _deleteAccountName.setValue(account.getName());

        if ( account != null )
            _deleteAccountType.setValue(account.getType().getName());

        _accountFrame.ajaxPrint(_deleteAccountChild);
    }

    private void handleDeleteAccount()
    {
        MyAccount account;
        account = getPageSession().getAccount();

        MyAccountUser accountUser;
        accountUser = getAccountUserDao().findAccountUserFor(getCurrentUser(), account);

        account.deleteDao();
        accountUser.deleteDao();

        MyPageLayout.getInstance().refreshDropdown();

        ajax().toast("Deleted account %s", account.getName());

        setDropdownOptions();
        refreshAll(true);
    }

    private void handleDeleteUser()
    {
        MyAccountUser accountUser;
        accountUser = getPageSession().getAccountUser();

        String userName;
        userName = accountUser.getUserName();

        String accountName;
        accountName = accountUser.getAccountName();

        accountUser.deleteDao();

        _deleteUserDialog.ajaxClose();

        ajax().toast("Deleted user %s from %s", userName, accountName);

        _userFrame.ajaxClear();
        _userGrid.ajaxReload();
    }

    private void handleClose()
    {
        _deleteUserDialog.ajaxClose();

        refreshAll(false);
    }

    private void handleUpdateValues()
    {
        updateViewAccount();
    }

    private void handleShowAddAccountBox()
    {
        _accountFrame.ajaxPrint(_addAccountChild);
        _addAccountChild.ajax().focus();
    }

    private void handleShowEditAccountBox()
    {
        String accountName;
        accountName = _viewAccountName.getValue();

        MyAccount account;
        account = getAccountDao().findName(accountName);

        if ( account != null )
            _editAccountName.setValue(account.getName());

        if ( account != null )
            _editTypeDropdown.setValue(account.getType());

        _accountFrame.ajaxPrint(_editAccountChild);
    }

    private void handleShowTransferBox()
    {
        String accountName;
        accountName = _viewAccountName.getValue();

        _transferGroup.setTitle("Transfer Ownership \n of %s", accountName);

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
        refreshAll(true);
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
        refreshAll(true);
    }

    private void handleEditAccountCancel()
    {
        setDropdownOptions();
        refreshAll(true);
    }

    /**
     * review_steve review_valerie 
     * view account needs to show just added method after save
     */
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

        MyAccount account;
        account = getAccountDao().createNewAccount(name, type, user);

        setDropdownOptions();

        _accountDropdown.ajaxSetValue(account.getUid());
        MyPageLayout.getInstance().refreshDropdown();
        refreshAll(true);
    }

    private void handleAddAccountCancel()
    {
        refreshAll(true);
    }

    private void handleShowInviteUserBox()
    {
        String accountName;
        accountName = _viewAccountName.getValue();

        _inviteGroup.setTitle("Invite User to %s", accountName);

        _accountFrame.ajaxPrint(_inviteUserChild);
        _inviteUserChild.ajax().focus();
    }

    private void handleViewUser()
    {
        String accountUserUid;
        accountUserUid = getStringArgument();

        MyAccountUser accountUser;
        accountUser = getAccountUserDao().findWithUid(accountUserUid);

        if ( accountUser == null )
            accountUser = getPageSession().getAccountUser();

        MyUser user;
        user = accountUser.getUser();

        getPageSession().setUser(user);
        getPageSession().setAccountUser(accountUser);

        _viewUserName.setValue(user.getName());
        _viewUserEmail.setValue(user.getEmail());
        _viewUserRole.setValue(accountUser.getRoleName());

        _userFrame.ajaxPrint(_viewUserChild);
    }

    private void handleEditUserSave()
    {
        _editUserChild.validate();

        MyAccountUser accountUser;
        accountUser = getPageSession().getAccountUser();

        MyAccount account;
        account = accountUser.getAccount();

        String roleCode = _editRoleDropdown.getStringValue();

        MyAccountUser findOwner;
        findOwner = getAccountUserDao().findCurrentOwner(account);

        boolean hasOwner = findOwner != null;
        boolean setOwner = roleCode.equals(MyAccountUserRole.Owner.getCode());

        if ( hasOwner && setOwner )
            ajax().alert("Looks like this account already has an owner.");
        else
            accountUser.setRoleCode(roleCode);

        accountUser.saveDao();

        MyUser user;
        user = accountUser.getUser();

        _viewUserName.setValue(user.getName());
        _viewUserEmail.setValue(user.getEmail());
        _viewUserRole.setValue(accountUser.getRoleName());

        _userFrame.ajaxPrint(_viewUserChild);

        refreshAll(false);
    }

    private void handleEditUserCancel()
    {
        handleViewUser();
    }

    private void handleSendJoinRequest()
    {
        MyAccount account;
        account = getPageSession().getAccount();

        String email = _addUserEmail.getValue();
        String roleCode = (String)_addRoleDropdown.getValue();

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
        refreshAll(true);
    }

    private void handleShowEditUserBox()
    {
        MyAccountUser accountUser;
        accountUser = getPageSession().getAccountUser();

        MyUser u;
        u = accountUser.getUser();

        if ( u != null )
        {
            _editUserName.setValue(u.getName());
            _editUserEmail.setValue(u.getEmail());
        }

        _editRoleDropdown.setValue(accountUser.getRole());
        _userFrame.ajaxPrint(_editUserChild);
    }

    private void handleViewUserCancel()
    {
        _userFrame.ajaxClear();

        refreshAll(false);
    }

    private void handleShowDeleteAccountUserDialog()
    {
        _deleteUserDialog.ajaxOpen();
    }

    private void showSentMessage(String email)
    {
        ajax().toast("Your request has been sent to: " + email);

        refreshAll(true);
    }

    //##################################################
    //# convenience
    //##################################################

    private void refreshAll(boolean flipView)
    {
        MyAccount account;
        account = getPageSession().getAccount();

        MyServerSession ss = MyGlobals.getServerSession();
        MyUser user = ss.getUser();

        if ( account == null )
        {
            account = getDropdownAccount();
            getPageSession().setAccount(account);
        }

        _viewAccountName.setValue(account.getName());
        _viewAccountType.setValue(account.getType().getName());

        /**
         * review_steve (wyatt) discuss name
         */
        MyAccountUser findCurrentOwner;
        findCurrentOwner = getAccountUserDao().findCurrentOwner(account);

        if ( getDropdownList().isEmpty() )
            _viewAccountFooter.hide();

        /*
         * review_steve (wyatt) discuss
         *      if ( findCurrentOwner != null && findCurrentOwner.getUser() == user )
         *         
         * review_steve review_valerie finicky
         */
        if ( findCurrentOwner != null && findCurrentOwner.getUser().isSame(user) )
            _transferButton.show();

        /**
         * review_steve review_valerie this condition is not working as intended
         * 
         * review_steve (wyatt)
         */
        if ( account.getName().equalsIgnoreCase("Personal") )
            _deleteButton.hide();

        _viewAccountChild.ajaxUpdateValues();

        if ( flipView )
            _accountFrame.ajaxPrint(_viewAccountChild);

        _userGrid.ajaxReload();
    }

    private void updateViewAccount()
    {
        MyAccount account;
        account = getPageSession().getAccount();

        MyAccount dropdownAccount = getDropdownAccount();

        /**
         * (steve) this is ugly and probably not too readable
         * 
         * review_valerie (steve)
         * 
         * review_steve (wyatt) discuss
         */
        if ( account == null || !dropdownAccount.equals(account) )
        {
            account = dropdownAccount;
            getPageSession().setAccount(account);
        }

        refreshAll(false);
    }

    /**
     * review_steve (wyatt) discuss
     */
    private MyAccount getDropdownAccount()
    {
        String accountUid;
        accountUid = _accountDropdown.getStringValue();

        MyAccount dropdownAccount;
        dropdownAccount = getAccountDao().findUid(accountUid);

        return dropdownAccount;
    }

    private KmList<ScOption> getDropdownList()
    {
        MyServerSession ss = MyGlobals.getServerSession();
        MyUser u = ss.getUser();

        if ( u == null )
            return null;

        KmList<ScOption> list;
        list = new KmList<ScOption>();

        KmList<MyAccountUser> accountUsers;
        accountUsers = getAccountUserDao().findAccountUsersFor(u);

        for ( MyAccountUser accountUser : accountUsers )
        {
            ScOption option = new ScOption();
            option.setText(accountUser.getAccount().getName());
            option.setValue(accountUser.getAccount().getUid());
            list.add(option);
        }

        return list;
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
            _accountDropdown.ajaxAddOption(e.getText(), e.getValue());

        if ( list.isNotEmpty() && getServerSession().hasAccount() )
        {
            String accountUid = getServerSession().getAccount().getUid();
            _accountDropdown.setValue(accountUid);
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
}
