package com.app.ui.page.manageVisitTypes;

import com.kodemore.collection.KmList;
import com.kodemore.meta.KmMetaStringProperty;
import com.kodemore.servlet.control.ScCardFrame;
import com.kodemore.servlet.control.ScContainer;

import com.app.model.MyVisitType;
import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.support.MyManageDomainPage;

public class MyManageVisitTypesPage
    extends MyManageDomainPage<MyVisitType>
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyManageVisitTypesPage instance = new MyManageVisitTypesPage();

    private MyManageVisitTypesPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private MyAddVisitTypeDialog _addDialog;
    private MyViewVisitTypeCard  _viewCard;

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
        return MyVisitType.Meta.getHelp();
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installDialogsOn(ScContainer root)
    {
        _addDialog = new MyAddVisitTypeDialog();
        _addDialog.addSaveListener(newAddListener());
    }

    @Override
    protected void installCardsOn(ScCardFrame frame)
    {
        _viewCard = frame.addCard(new MyViewVisitTypeCard());
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
        _viewCard.setVisitType(getDomain());
        _viewCard.ajaxPrint();
    }

    //##################################################
    //# properties
    //##################################################

    @Override
    protected String getDomainName()
    {
        return MyVisitType.Meta.getLabel();
    }

    @Override
    protected KmMetaStringProperty<MyVisitType> getDomainUidProperty()
    {
        return MyVisitType.Meta.Uid;
    }

    @Override
    protected KmMetaStringProperty<MyVisitType> getDomainTitleProperty()
    {
        return MyVisitType.Meta.Name;
    }

    @Override
    protected KmMetaStringProperty<MyVisitType> getDomainSubtitleProperty()
    {
        return null;
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    protected KmList<MyVisitType> findSortedDomains()
    {
        return getCurrentProject().getVisitTypesByName();
    }

    @Override
    protected MyVisitType findDomain(String uid)
    {
        return getAccess().findVisitTypeUid(uid);
    }
}
