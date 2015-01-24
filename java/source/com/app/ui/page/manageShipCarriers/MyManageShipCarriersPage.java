package com.app.ui.page.manageShipCarriers;

import com.kodemore.collection.KmList;
import com.kodemore.meta.KmMetaStringProperty;
import com.kodemore.servlet.control.ScCardFrame;
import com.kodemore.servlet.control.ScContainer;

import com.app.model.MyShipCarrier;
import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.support.MyManageDomainPage;

public class MyManageShipCarriersPage
    extends MyManageDomainPage<MyShipCarrier>
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyManageShipCarriersPage instance = new MyManageShipCarriersPage();

    private MyManageShipCarriersPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private MyViewShipCarrierCard  _viewCard;
    private MyAddShipCarrierDialog _addDialog;

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
        return MyShipCarrier.Meta.getHelp();
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installDialogsOn(ScContainer root)
    {
        _addDialog = root.add(new MyAddShipCarrierDialog());
        _addDialog.addSaveListener(this::handleAdded);
    }

    @Override
    protected void installCardsOn(ScCardFrame frame)
    {
        _viewCard = frame.addCard(new MyViewShipCarrierCard());
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
        _viewCard.setShipCarrier(getDomain());
        _viewCard.ajaxPrint();
    }

    //##################################################
    //# properties
    //##################################################

    @Override
    protected String getDomainName()
    {
        return MyShipCarrier.Meta.getLabel();
    }

    @Override
    protected KmMetaStringProperty<MyShipCarrier> getDomainUidProperty()
    {
        return MyShipCarrier.Meta.Uid;
    }

    @Override
    protected KmMetaStringProperty<MyShipCarrier> getDomainTitleProperty()
    {
        return MyShipCarrier.Meta.Name;
    }

    @Override
    protected KmMetaStringProperty<MyShipCarrier> getDomainSubtitleProperty()
    {
        return MyShipCarrier.Meta.MethodNames;
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    protected KmList<MyShipCarrier> findSortedDomains()
    {
        return getCurrentProject().getShipCarriersByName();
    }

    @Override
    protected MyShipCarrier findDomain(String uid)
    {
        return getAccess().findShipCarrierUid(uid);
    }
}
