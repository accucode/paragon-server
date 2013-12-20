package com.app.ui.page.admin.accounts;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScLinkList;
import com.kodemore.servlet.field.ScTextField;

import com.app.model.MyAccount;
import com.app.model.MyUser;
import com.app.model.meta.MyMetaAccount;
import com.app.ui.page.admin.MyAbstractAdminPage;
import com.app.utility.MyNavigator;

public class MyManageAccountsPage
    extends MyAbstractAdminPage
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
    //# constants
    //##################################################

    private static final int GROUP_WIDTH = 250;

    //##################################################
    //# variables
    //##################################################

    private ScForm           _form;
    private ScTextField      _nameField;

    private ScLinkList       _ownedAccountList;
    private ScLinkList       _sharedAccountList;

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().gap();
        root.getPostDomScript().equalizeGroups();

        installCreateGroup(root);
        installOwnedAccounts(root);
        installSharedAccounts(root);
    }

    private void installCreateGroup(ScPageRoot root)
    {
        MyMetaAccount x = MyAccount.Meta;

        _nameField = x.Name.newField();

        _form = root.addForm();
        _form = root.addForm();
        _form.setDefaultAction(newCreateAccountAction());
        _form.css().floatLeft();

        ScGroup group;
        group = _form.addGroup();
        group.style().width(GROUP_WIDTH);
        group.setTitle("New Account");

        ScBox body;
        body = group.addPad().addBox();

        ScFieldTable fields;
        fields = body.addFields();
        fields.add(_nameField);

        group.addDivider();

        ScBox buttons;
        buttons = group.addButtonBoxRight();
        buttons.addSubmitButton("Create");
    }

    private void installOwnedAccounts(ScPageRoot root)
    {
        MyMetaAccount x = MyAccount.Meta;

        _ownedAccountList = new ScLinkList();
        _ownedAccountList.setOptionValueAdaptor(x.Uid);
        _ownedAccountList.setOptionTextAdaptor(x.Name);
        _ownedAccountList.setAction(newSelectAccountAction());

        ScGroup group;
        group = root.addGroup();
        group.css().floatLeft();
        group.style().width(GROUP_WIDTH);
        group.setTitle("My Accounts");
        group.addPad().add(_ownedAccountList);
    }

    private void installSharedAccounts(ScPageRoot root)
    {
        MyMetaAccount x = MyAccount.Meta;

        _sharedAccountList = new ScLinkList();
        _sharedAccountList.setOptionValueAdaptor(x.Uid);
        _sharedAccountList.setOptionTextAdaptor(x.Name);
        _sharedAccountList.setAction(newSelectAccountAction());

        ScGroup group;
        group = root.addGroup();
        group.css().floatLeft();
        group.style().width(GROUP_WIDTH);
        group.setTitle("Shared Accounts");
        group.addPad().add(_sharedAccountList);
    }

    //##################################################
    //# actions
    //##################################################

    private ScActionIF newCreateAccountAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleCreate();
            }
        };
    }

    private ScActionIF newSelectAccountAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleSelect();
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

        MyUser user = getCurrentUser();
        KmList<MyAccount> ownedAccts = user.getOwnedAccountsByName();
        KmList<MyAccount> sharedAccts = user.getSharedAccountsByName();

        _ownedAccountList.setOptions(ownedAccts);
        _sharedAccountList.setOptions(sharedAccts);
    }

    //##################################################
    //# handle
    //##################################################

    private void handleCreate()
    {
        ajax().hideAllErrors();
        _form.validate();

        String name = _nameField.getValue();
        getCurrentUser().addPersonalAccount(name);

        _nameField.clearText();
        print();
    }

    private void handleSelect()
    {
        String uid = getStringArgument();
        MyNavigator.selectAccount(uid);
    }
}
