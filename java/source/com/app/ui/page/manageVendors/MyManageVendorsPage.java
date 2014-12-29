package com.app.ui.page.manageVendors;

import com.kodemore.collection.KmList;
import com.kodemore.meta.KmMetaStringProperty;
import com.kodemore.servlet.control.ScCardFrame;
import com.kodemore.servlet.control.ScContainer;

import com.app.model.MyVendor;
import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.support.MyManageDomainPage;

public class MyManageVendorsPage
    extends MyManageDomainPage<MyVendor>
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyManageVendorsPage instance = new MyManageVendorsPage();

    private MyManageVendorsPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private MyAddVendorDialog _addDialog;
    private MyViewVendorCard  _viewCard;

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
        return MyVendor.Meta.getHelp();
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installDialogsOn(ScContainer root)
    {
        _addDialog = root.add(new MyAddVendorDialog());
        _addDialog.addSaveListener(newAddListener());
    }

    @Override
    protected void installCardsOn(ScCardFrame frame)
    {
        _viewCard = frame.addCard(new MyViewVendorCard());
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
        _viewCard.setVendor(getDomain());
        _viewCard.ajaxPrint();
    }

    //##################################################
    //# properties
    //##################################################

    @Override
    protected String getDomainName()
    {
        return MyVendor.Meta.getLabel();
    }

    @Override
    protected KmMetaStringProperty<MyVendor> getDomainUidProperty()
    {
        return MyVendor.Meta.Uid;
    }

    @Override
    protected KmMetaStringProperty<MyVendor> getDomainTitleProperty()
    {
        return MyVendor.Meta.Name;
    }

    @Override
    protected KmMetaStringProperty<MyVendor> getDomainSubtitleProperty()
    {
        return null;
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    protected KmList<MyVendor> findSortedDomains()
    {
        return getCurrentProject().getVendorsByName();
    }

    @Override
    protected MyVendor findDomain(String uid)
    {
        return getAccess().findVendorUid(uid);
    }
}
