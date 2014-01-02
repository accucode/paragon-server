package com.app.ui.page.admin.accountUsers;

import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScCard;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScNotebook;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScRepeater;
import com.kodemore.servlet.control.ScTextSpan;

import com.app.model.MyAccount;
import com.app.ui.page.admin.MyAbstractAdminPage;
import com.app.ui.page.admin.accountSettings.MyAccountSettingsFrame;

public class MyAccountUsersPage
    extends MyAbstractAdminPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyAccountUsersPage instance = new MyAccountUsersPage();

    private MyAccountUsersPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScGroup                _summaryGroup;
    private ScTextSpan             _ownerText;

    private ScNotebook             _notebook;

    private ScRepeater             _userRepeater;

    private MyAccountSettingsFrame _frame;

    private ScCard                 _viewUserCard;
    private ScCard                 _editUserCard;
    private ScCard                 _removeUserCard;

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().gap();

        installSummary(root);
        installNotebook(root);

        // installUserFrame(root);
    }

    private void installSummary(ScContainer root)
    {
        _ownerText = new ScTextSpan();
        _ownerText.setLabel("Owner");

        _summaryGroup = root.addGroup();

        ScBox body;
        body = _summaryGroup.addGap();

        ScFieldTable fields;
        fields = body.addFields();
        fields.add(_ownerText);
    }

    private void installNotebook(ScContainer root)
    {
        _notebook = root.addNotebook();
        _notebook.style().width(500).height(300);

        installUserTab(_notebook);
        installInvitationTab(_notebook);
    }

    //==================================================
    //= install :: users
    //==================================================

    private void installUserTab(ScNotebook book)
    {
        ScBox tab;
        tab = _notebook.addBox();
        tab.setLabel("Users");

    }

    private void installUserFrame(ScContainer root)
    {
        _frame = new MyAccountSettingsFrame();
        _frame.getViewCard().beDefault();
        _frame.css().pad().centerMargins();
        _frame.style().width(300);

        root.add(_frame);
    }

    private void installUserList(ScContainer root)
    {
        _userRepeater = new ScRepeater();

        ScGroup group;
        group = root.addGroup();
        group.css().floatLeft();
    }

    //==================================================
    //= install :: invitations
    //==================================================

    private void installInvitationTab(ScNotebook notebook)
    {
        ScBox tab;
        tab = _notebook.addBox();
        tab.setLabel("Invitations");
        tab.css().borderRed();
        tab.addText("invitations...");
    }

    //##################################################
    //# actions
    //##################################################

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        MyAccount acct = getCurrentAccount();
        String title = acct.getName() + " Users";

        _summaryGroup.setTitle(title);
        _ownerText.setValue(acct.getOwner().getName());
    }
}
