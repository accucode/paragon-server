package com.app.ui.page.admin.accountUsers;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScArray;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScBoxRendererIF;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScLink;
import com.kodemore.servlet.control.ScModelList;
import com.kodemore.servlet.control.ScNotebook;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScTable;
import com.kodemore.servlet.control.ScTableCell;
import com.kodemore.servlet.control.ScTableRow;
import com.kodemore.servlet.control.ScTextSpan;
import com.kodemore.servlet.control.ScTransientContainer;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.utility.Kmu;

import com.app.dao.MyInvitationDao;
import com.app.model.MyAccount;
import com.app.model.MyInvitation;
import com.app.model.MyUserAccount;
import com.app.ui.page.admin.MyAbstractAdminEntryPage;

public class MyAccountUsersPage
extends MyAbstractAdminEntryPage
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

    private ScGroup                   _summaryGroup;
    private ScTextSpan                _ownerText;

    private ScNotebook                _notebook;

    private ScModelList<MyInvitation> _invitationList;

    private ScTransientContainer      _usersContainer;
    private ScActionIF                _selectUserAction;

    private ScTextField               _invitationField;
    private ScActionIF                _cancelInvitationAction;
    private ScActionIF                _resendInvitationAction;

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
        _notebook.style().width(600).height(400);

        installUserTab();
        installInvitationTab();
    }

    //==================================================
    //= install :: user tab
    //==================================================

    private void installUserTab()
    {
        ScBox tab;
        tab = _notebook.addBox();
        tab.setLabel("Users");

        ScArray row;
        row = tab.addRow();

        installUserList(row);
        installUserFrame(row);
    }

    private void installUserList(ScContainer root)
    {
        _usersContainer = root.addTransientContainer();
        _selectUserAction = newSelectUserAction();
    }

    @SuppressWarnings("unused")
    private void installUserFrame(ScArray row)
    {
        // todo_wyatt: account users
    }

    //==================================================
    //= install :: invitation tab
    //==================================================

    private void installInvitationTab()
    {
        ScBox tab;
        tab = _notebook.addBox();
        tab.setLabel("Invitations");

        installInvitationForm(tab);
        installInvitationList(tab);
    }

    private void installInvitationForm(ScBox tab)
    {
        _invitationField = new ScTextField();
        _invitationField.setWidthFull();

        ScForm form;
        form = tab.addForm();
        form.setSubmitAction(newCreateInvitationAction());

        ScTable table;
        ScTableRow row;
        ScTableCell cell;

        table = form.addTable();
        table.css().widthFull();

        row = table.addRow();
        cell = row.addCell();
        cell.setColumnSpan(2);
        cell.addLabel("Send invitation to email");

        row = table.addRow();
        cell = row.addCell();
        cell.css().widthFull().padRight();
        cell.addErrorBox().add(_invitationField);

        cell = row.addCell();
        cell.css().middle();
        cell.addSubmitButton("Send");
    }

    private void installInvitationList(ScBox tab)
    {
        tab.addBreak();
        tab.addLabel("Pending Invitations");

        _invitationList = tab.addModelList();
        _invitationList.css().borderGray().overflowAuto();
        _invitationList.style().height(230);
        _invitationList.setKeyAdapter(MyInvitation.Meta.Uid);
        _invitationList.setRenderer(newInvitationRenderer());

        _cancelInvitationAction = newCancelInvitationAction();
        _resendInvitationAction = newResendInvitationAction();
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        preRenderSummary();
        preRenderUsers();
        preRenderInvitations();
    }

    private void preRenderSummary()
    {
        MyAccount acct = getCurrentAccount();
        String title = acct.getName() + " Users";

        _summaryGroup.setTitle(title);
        _ownerText.setValue(acct.getOwner().getName());
    }

    private void preRenderUsers()
    {
        KmList<MyUserAccount> users = getNonOwnerUsers();
        if ( users.isEmpty() )
        {
            preRenderEmptyUsers();
            return;
        }

        ScDiv scroll;
        scroll = _usersContainer.addDiv();
        scroll.style().width(200).height(300);
        scroll.css().overflowAuto().border();

        for ( MyUserAccount ua : users )
        {
            ScBox box;
            box = scroll.addBox();
            box.css().margin1().pad().borderBlue().backgroundGrayDDD();

            String uid = ua.getUid();
            String name = ua.getUserName();

            ScLink link;
            link = box.addLink();
            link.setAction(_selectUserAction, uid);
            link.setText(name);
        }
    }

    private void preRenderEmptyUsers()
    {
        _usersContainer.addText(""
                        + "This account does not have any additional users yet. "
                        + "You can invite users via the 'Invitations' tab.");
    }

    private void preRenderInvitations()
    {
        MyAccount acct = getCurrentAccount();
        MyInvitationDao dao = getAccess().getInvitationDao();

        KmList<MyInvitation> v;
        v = dao.findJoinInvitationsFor(acct);
        v.sortReverseOn(MyInvitation.Meta.CreatedUtcTs);

        _invitationList.setValues(v);
    }

    //##################################################
    //# render :: invitations
    //##################################################

    private ScBoxRendererIF<MyInvitation> newInvitationRenderer()
    {
        return new ScBoxRendererIF<MyInvitation>()
                        {
            @Override
            public void renderOn(ScBox root, MyInvitation value)
            {
                renderInvitation(root, value);
            }
                        };
    }

    private void renderInvitation(ScBox root, MyInvitation value)
    {
        root.css().margin1().pad().border().backgroundGrayEEE();

        ScDiv left;
        left = root.addDiv();
        left.css().displayCell().middle().widthFull();
        left.addTextSpan(value.getToEmail()).css().bold();
        left.addBreak();
        left.addTimeAgo(value.getCreatedUtcTs()).css().smallText().italic();

        ScDiv right;
        right = root.addDiv();
        right.css().displayCell().middle().padLeftChildren();
        right.addLink("Resend", _resendInvitationAction, value.getUid());
        right.addLink("Cancel", _cancelInvitationAction, value.getUid());
    }

    //##################################################
    //# actions
    //##################################################

    private ScActionIF newSelectUserAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleSelectUser();
            }
        };
    }

    private ScActionIF newCreateInvitationAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleCreateInvitation();
            }
        };
    }

    private ScActionIF newCancelInvitationAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleCancelInvitation();
            }
        };
    }

    private ScActionIF newResendInvitationAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleResendInvitation();
            }
        };
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSelectUser()
    {
        String uid = getStringArgument();
        ajax().toast(uid);
    }

    private void handleCreateInvitation()
    {
        ajax().hideAllErrors();

        String email = _invitationField.getValue();

        if ( Kmu.isEmpty(email) )
            _invitationField.error("Required.");

        if ( !Kmu.isValidEmailAddress(email) )
            _invitationField.error("Invalid email.");

        MyInvitation e;
        e = new MyInvitation();
        e.setFromUser(getCurrentUser());
        e.setToEmail(email);
        e.setTypeJoinAccount();
        e.setAccount(getCurrentAccount());
        e.saveDao();
        e.sendEmail();

        ajax().toast("Invitation sent to: " + email);

        _invitationList.ajaxPrependValue(e);
        _invitationField.ajax().clearValue();
    }

    private void handleResendInvitation()
    {
        String uid = getStringArgument();
        MyInvitation inv = getAccess().findInvitationUid(uid);

        if ( inv == null )
        {
            ajax().toast("Cannot resend invitation.").error();
            return;
        }

        inv.sendEmail();
        ajax().toast("The invitation to %s has been resent.", inv.getToEmail());

        _invitationList.ajaxFor(inv).glow();
    }

    private void handleCancelInvitation()
    {
        String uid = getStringArgument();
        MyInvitation inv = getAccess().findInvitationUid(uid);

        if ( inv == null )
        {
            ajax().toast("Cannot cancel invitation.").error();
            return;
        }

        inv.deleteDao();

        _invitationList.ajaxRemoveValue(inv);

        ajax().toast("The invitation to %s has been cancelled.", inv.getToEmail());
    }

    //##################################################
    //# support
    //##################################################

    private KmList<MyUserAccount> getNonOwnerUsers()
    {
        MyAccount acct = getCurrentAccount();
        KmList<MyUserAccount> all = getAccess().getUserAccountDao().findAccount(acct);

        KmList<MyUserAccount> v = new KmList<MyUserAccount>();

        for ( MyUserAccount e : all )
            if ( e.isNotRoleOwner() )
                v.add(e);

        return v;
    }
}
