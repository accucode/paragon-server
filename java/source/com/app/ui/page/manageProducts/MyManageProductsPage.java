package com.app.ui.page.manageProducts;

import com.kodemore.collection.KmList;
import com.kodemore.meta.KmMetaStringProperty;
import com.kodemore.servlet.control.ScCardFrame;
import com.kodemore.servlet.control.ScContainer;

import com.app.model.MyProduct;
import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.support.MyManageDomainPage;

public final class MyManageProductsPage
    extends MyManageDomainPage<MyProduct>
{
    //##################################################
    //# singleton
    //##################################################

    private static MyManageProductsPage _instance;

    public static void installInstance()
    {
        _instance = new MyManageProductsPage();
    }

    public static MyManageProductsPage getInstance()
    {
        return _instance;
    }

    private MyManageProductsPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private MyAddProductDialog _addDialog;
    private MyViewProductCard  _viewCard;

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
        return MyProduct.Meta.getHelp();
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installDialogsOn(ScContainer root)
    {
        _addDialog = root.add(new MyAddProductDialog());
        _addDialog.addSaveListener(this::handleAdded);
    }

    @Override
    protected void installCardsOn(ScCardFrame frame)
    {
        _viewCard = frame.addCard(new MyViewProductCard());
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
        _viewCard.setProduct(getDomain());
        _viewCard.ajaxPrint();
    }

    //##################################################
    //# properties
    //##################################################

    @Override
    protected String getDomainName()
    {
        return MyProduct.Meta.getLabel();
    }

    @Override
    protected KmMetaStringProperty<MyProduct> getDomainUidProperty()
    {
        return MyProduct.Meta.Uid;
    }

    @Override
    protected KmMetaStringProperty<MyProduct> getDomainTitleProperty()
    {
        return MyProduct.Meta.Name;
    }

    @Override
    protected KmMetaStringProperty<MyProduct> getDomainSubtitleProperty()
    {
        return MyProduct.Meta.CategoryName;
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    protected KmList<MyProduct> findSortedDomains()
    {
        return getCurrentProject().getProductsByName();
    }

    @Override
    protected MyProduct findDomain(String uid)
    {
        return getAccess().findProductUid(uid);
    }
}
