package com.app.ui.page.managePowerTypes;

import com.kodemore.collection.KmList;
import com.kodemore.meta.KmMetaStringProperty;
import com.kodemore.servlet.control.ScCardFrame;
import com.kodemore.servlet.control.ScContainer;

import com.app.model.MyPowerType;
import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.support.MyManageDomainPage;

public class MyManagePowerTypesPage
    extends MyManageDomainPage<MyPowerType>
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyManagePowerTypesPage instance = new MyManagePowerTypesPage();

    private MyManagePowerTypesPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private MyAddPowerTypeDialog _addDialog;
    private MyViewPowerTypeCard  _viewCard;

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
        return MyPowerType.Meta.getHelp();
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installDialogsOn(ScContainer root)
    {
        _addDialog = root.add(new MyAddPowerTypeDialog());
        _addDialog.addSaveListener(newAddListener());
    }

    @Override
    protected void installCardsOn(ScCardFrame frame)
    {
        _viewCard = frame.addCard(new MyViewPowerTypeCard());
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
        _viewCard.setPowerType(getDomain());
        _viewCard.ajaxPrint();
    }

    //##################################################
    //# properties
    //##################################################

    @Override
    protected String getDomainName()
    {
        return MyPowerType.Meta.getLabel();
    }

    @Override
    protected KmMetaStringProperty<MyPowerType> getDomainUidProperty()
    {
        return MyPowerType.Meta.Uid;
    }

    @Override
    protected KmMetaStringProperty<MyPowerType> getDomainTitleProperty()
    {
        return MyPowerType.Meta.Name;
    }

    @Override
    protected KmMetaStringProperty<MyPowerType> getDomainSubtitleProperty()
    {
        return null;
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    protected KmList<MyPowerType> findSortedDomains()
    {
        return getCurrentProject().getPowerTypesByName();
    }

    @Override
    protected MyPowerType findDomain(String uid)
    {
        return getAccess().findPowerTypeUid(uid);
    }
}
