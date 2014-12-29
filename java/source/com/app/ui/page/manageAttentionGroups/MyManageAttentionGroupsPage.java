package com.app.ui.page.manageAttentionGroups;

import com.kodemore.collection.KmList;
import com.kodemore.meta.KmMetaStringProperty;
import com.kodemore.servlet.control.ScCardFrame;
import com.kodemore.servlet.control.ScContainer;

import com.app.model.MyAttentionGroup;
import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.support.MyManageDomainPage;

public class MyManageAttentionGroupsPage
    extends MyManageDomainPage<MyAttentionGroup>
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyManageAttentionGroupsPage instance = new MyManageAttentionGroupsPage();

    private MyManageAttentionGroupsPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private MyAddAttentionGroupDialog _addDialog;
    private MyViewAttentionGroupCard  _viewCard;

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
        return MyAttentionGroup.Meta.getHelp();
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installDialogsOn(ScContainer root)
    {
        _addDialog = root.add(new MyAddAttentionGroupDialog());
        _addDialog.addSaveListener(newAddListener());
    }

    @Override
    protected void installCardsOn(ScCardFrame frame)
    {
        _viewCard = frame.addCard(new MyViewAttentionGroupCard());
        _viewCard.addSaveListener(newEditListener());
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
        _viewCard.setAttentionGroup(getDomain());
        _viewCard.ajaxPrint();
    }

    //##################################################
    //# properties
    //##################################################

    @Override
    protected String getDomainName()
    {
        return MyAttentionGroup.Meta.getLabel();
    }

    @Override
    protected KmMetaStringProperty<MyAttentionGroup> getDomainUidProperty()
    {
        return MyAttentionGroup.Meta.Uid;
    }

    @Override
    protected KmMetaStringProperty<MyAttentionGroup> getDomainTitleProperty()
    {
        return MyAttentionGroup.Meta.Name;
    }

    @Override
    protected KmMetaStringProperty<MyAttentionGroup> getDomainSubtitleProperty()
    {
        return null;
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    protected KmList<MyAttentionGroup> findSortedDomains()
    {
        return getCurrentProject().getAttentionGroupsByName();
    }

    @Override
    protected MyAttentionGroup findDomain(String uid)
    {
        return getAccess().findAttentionGroupUid(uid);
    }
}
