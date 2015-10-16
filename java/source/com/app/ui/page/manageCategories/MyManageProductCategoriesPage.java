package com.app.ui.page.manageCategories;

import com.kodemore.collection.KmList;
import com.kodemore.meta.KmMetaStringProperty;
import com.kodemore.servlet.control.ScCardFrame;
import com.kodemore.servlet.control.ScContainer;

import com.app.model.MyProductCategory;
import com.app.model.MyProductCategory;
import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.support.MyManageDomainPage;

public final class MyManageProductCategoriesPage
    extends MyManageDomainPage<MyProductCategory>
{
    //##################################################
    //# singleton
    //##################################################

    private static MyManageProductCategoriesPage _instance;

    public static void installInstance()
    {
        _instance = new MyManageProductCategoriesPage();
    }

    public static MyManageProductCategoriesPage getInstance()
    {
        return _instance;
    }

    private MyManageProductCategoriesPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private MyAddProductCategoryDialog _addDialog;
    private MyViewProductCategoryCard  _viewCard;

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
        return MyProductCategory.Meta.getHelp();
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installDialogsOn(ScContainer root)
    {
        _addDialog = root.add(new MyAddProductCategoryDialog());
        _addDialog.addSaveListener(this::handleAdded);
    }

    @Override
    protected void installCardsOn(ScCardFrame frame)
    {
        _viewCard = frame.addCard(new MyViewProductCategoryCard());
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
        _viewCard.setProductCategory(getDomain());
        _viewCard.ajaxPrint();
    }

    //##################################################
    //# properties
    //##################################################

    @Override
    protected String getDomainName()
    {
        return MyProductCategory.Meta.getLabel();
    }

    @Override
    protected KmMetaStringProperty<MyProductCategory> getDomainUidProperty()
    {
        return MyProductCategory.Meta.Uid;
    }

    @Override
    protected KmMetaStringProperty<MyProductCategory> getDomainTitleProperty()
    {
        return MyProductCategory.Meta.Name;
    }

    @Override
    protected KmMetaStringProperty<MyProductCategory> getDomainSubtitleProperty()
    {
        return null;
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    protected KmList<MyProductCategory> findSortedDomains()
    {
        return getCurrentProject().getProductCategoriesByName();
    }

    @Override
    protected MyProductCategory findDomain(String uid)
    {
        return getAccess().findProductCategoryUid(uid);
    }
}
