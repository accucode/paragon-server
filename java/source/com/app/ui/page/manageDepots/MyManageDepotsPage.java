package com.app.ui.page.manageDepots;

import com.kodemore.collection.KmList;
import com.kodemore.meta.KmMetaStringProperty;
import com.kodemore.servlet.control.ScCardFrame;
import com.kodemore.servlet.control.ScContainer;

import com.app.model.MyDepot;
import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.support.MyManageDomainPage;

public class MyManageDepotsPage
    extends MyManageDomainPage<MyDepot>
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyManageDepotsPage instance = new MyManageDepotsPage();

    private MyManageDepotsPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private MyAddDepotDialog _addDialog;
    private MyViewDepotCard  _viewCard;

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
        return MyDepot.Meta.getHelp();
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installDialogsOn(ScContainer root)
    {
        _addDialog = root.add(new MyAddDepotDialog());
        _addDialog.addSaveListener(this::handleAdded);
    }

    @Override
    protected void installCardsOn(ScCardFrame frame)
    {
        _viewCard = frame.addCard(new MyViewDepotCard());
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
        _viewCard.setDepot(getDomain());
        _viewCard.ajaxPrint();
    }

    //##################################################
    //# properties
    //##################################################

    @Override
    protected String getDomainName()
    {
        return MyDepot.Meta.getLabel();
    }

    @Override
    protected KmMetaStringProperty<MyDepot> getDomainUidProperty()
    {
        return MyDepot.Meta.Uid;
    }

    @Override
    protected KmMetaStringProperty<MyDepot> getDomainTitleProperty()
    {
        return MyDepot.Meta.Name;
    }

    @Override
    protected KmMetaStringProperty<MyDepot> getDomainSubtitleProperty()
    {
        return null;
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    protected KmList<MyDepot> findSortedDomains()
    {
        return getCurrentProject().getDepotsByName();
    }

    @Override
    protected MyDepot findDomain(String uid)
    {
        return getAccess().findDepotUid(uid);
    }
}
