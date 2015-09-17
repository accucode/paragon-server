package com.app.ui.page.manageRegions;

import com.kodemore.collection.KmList;
import com.kodemore.meta.KmMetaStringProperty;
import com.kodemore.servlet.control.ScCardFrame;
import com.kodemore.servlet.control.ScContainer;

import com.app.model.MyRegion;
import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.support.MyManageDomainPage;

public final class MyManageRegionsPage
    extends MyManageDomainPage<MyRegion>
{
    //##################################################
    //# singleton
    //##################################################

    private static MyManageRegionsPage _instance;

    public static void installInstance()
    {
        _instance = new MyManageRegionsPage();
    }

    public static MyManageRegionsPage getInstance()
    {
        return _instance;
    }

    private MyManageRegionsPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private MyViewRegionCard  _viewCard;
    private MyAddRegionDialog _addDialog;

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
        return MyRegion.Meta.getHelp();
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installDialogsOn(ScContainer root)
    {
        _addDialog = root.add(new MyAddRegionDialog());
        _addDialog.addSaveListener(this::handleAdded);
    }

    @Override
    protected void installCardsOn(ScCardFrame frame)
    {
        _viewCard = frame.addCard(new MyViewRegionCard());
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
        _viewCard.setRegion(getDomain());
        _viewCard.ajaxPrint();
    }

    //##################################################
    //# properties
    //##################################################

    @Override
    protected String getDomainName()
    {
        return MyRegion.Meta.getLabel();
    }

    @Override
    protected KmMetaStringProperty<MyRegion> getDomainUidProperty()
    {
        return MyRegion.Meta.Uid;
    }

    @Override
    protected KmMetaStringProperty<MyRegion> getDomainTitleProperty()
    {
        return MyRegion.Meta.Name;
    }

    @Override
    protected KmMetaStringProperty<MyRegion> getDomainSubtitleProperty()
    {
        return null;
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    protected KmList<MyRegion> findSortedDomains()
    {
        return getCurrentProject().getRegionsByName();
    }

    @Override
    protected MyRegion findDomain(String uid)
    {
        return getAccess().findRegionUid(uid);
    }
}
