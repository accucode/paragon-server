package com.app.ui.page.manageUsers;

import com.kodemore.collection.KmList;
import com.kodemore.meta.KmMetaStringProperty;
import com.kodemore.servlet.control.ScCardFrame;
import com.kodemore.servlet.control.ScContainer;

import com.app.model.MyUser;
import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.support.MyManageDomainPage;

public class MyManageUsersPage
    extends MyManageDomainPage<MyUser>
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyManageUsersPage instance = new MyManageUsersPage();

    private MyManageUsersPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private MyAddUserDialog _addDialog;
    private MyViewUserCard  _viewCard;

    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.admin;
    }

    @Override
    public String getHelpMessage()
    {
        return MyUser.Meta.getHelp();
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installDialogsOn(ScContainer root)
    {
        _addDialog = root.add(new MyAddUserDialog());
        _addDialog.addSaveListener(this::handleAdded);
    }

    @Override
    protected void installCardsOn(ScCardFrame frame)
    {
        _viewCard = frame.addCard(new MyViewUserCard());
        _viewCard.addSaveListener(this::handleEdited);
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
        _viewCard.setUser(getDomain());
        _viewCard.ajaxPrint();
    }

    //##################################################
    //# properties
    //##################################################

    @Override
    protected String getDomainName()
    {
        return MyUser.Meta.getLabel();
    }

    @Override
    protected KmMetaStringProperty<MyUser> getDomainUidProperty()
    {
        return MyUser.Meta.Uid;
    }

    @Override
    protected KmMetaStringProperty<MyUser> getDomainTitleProperty()
    {
        return MyUser.Meta.Name;
    }

    @Override
    protected KmMetaStringProperty<MyUser> getDomainSubtitleProperty()
    {
        return MyUser.Meta.Email;
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    protected KmList<MyUser> findSortedDomains()
    {
        return getAccess().getUserDao().findAllByName();
    }

    @Override
    protected MyUser findDomain(String uid)
    {
        return getAccess().findUserUid(uid);
    }
}
