package com.app.ui.page.manageMembers;

import com.kodemore.collection.KmList;
import com.kodemore.meta.KmMetaStringProperty;
import com.kodemore.servlet.control.ScCardFrame;
import com.kodemore.servlet.control.ScContainer;

import com.app.model.MyMember;
import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.support.MyManageDomainPage;

public class MyManageMembersPage
    extends MyManageDomainPage<MyMember>
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyManageMembersPage instance = new MyManageMembersPage();

    private MyManageMembersPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private MyAddMemberDialog _addDialog;
    private MyViewMemberCard  _viewCard;

    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.manager;
    }

    @Override
    public String getHelpMessage()
    {
        return MyMember.Meta.getHelp();
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installDialogsOn(ScContainer root)
    {
        _addDialog = root.add(new MyAddMemberDialog());
        _addDialog.addSaveListener(this::handleAdded);
    }

    @Override
    protected void installCardsOn(ScCardFrame frame)
    {
        _viewCard = frame.addCard(new MyViewMemberCard());
        _viewCard.addSaveListener(this::handleEdited);
        _viewCard.addRemoveListener(this::handleRemoved);
    }

    //##################################################
    //# page navigation
    //##################################################

    @Override
    protected void ajaxOpenAddDialog()
    {
        _addDialog.ajaxOpen();
    }

    @Override
    protected void ajaxOpenViewCard()
    {
        _viewCard.setMember(getDomain());
        _viewCard.ajaxPrint();
    }

    //##################################################
    //# properties
    //##################################################

    @Override
    protected String getDomainName()
    {
        return MyMember.Meta.getLabel();
    }

    @Override
    protected KmMetaStringProperty<MyMember> getDomainUidProperty()
    {
        return MyMember.Meta.Uid;
    }

    @Override
    protected KmMetaStringProperty<MyMember> getDomainTitleProperty()
    {
        return MyMember.Meta.UserName;
    }

    @Override
    protected KmMetaStringProperty<MyMember> getDomainSubtitleProperty()
    {
        return MyMember.Meta.Subtitle;
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    protected KmList<MyMember> findSortedDomains()
    {
        return getCurrentProject().getMembersByName();
    }

    @Override
    protected MyMember findDomain(String uid)
    {
        return getAccess().findMemberUid(uid);
    }
}
