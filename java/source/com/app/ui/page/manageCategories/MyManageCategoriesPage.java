package com.app.ui.page.manageCategories;

import com.kodemore.collection.KmList;
import com.kodemore.meta.KmMetaStringProperty;
import com.kodemore.servlet.control.ScCardFrame;
import com.kodemore.servlet.control.ScContainer;

import com.app.model.MyCategory;
import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.support.MyManageDomainPage;

public class MyManageCategoriesPage
    extends MyManageDomainPage<MyCategory>
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyManageCategoriesPage instance = new MyManageCategoriesPage();

    private MyManageCategoriesPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private MyAddCategoryDialog _addDialog;
    private MyViewCategoryCard  _viewCard;

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
        return MyCategory.Meta.getHelp();
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installDialogsOn(ScContainer root)
    {
        _addDialog = root.add(new MyAddCategoryDialog());
        _addDialog.addSaveListener(this::handleAdded);
    }

    @Override
    protected void installCardsOn(ScCardFrame frame)
    {
        _viewCard = frame.addCard(new MyViewCategoryCard());
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
        _viewCard.setCategory(getDomain());
        _viewCard.ajaxPrint();
    }

    //##################################################
    //# properties
    //##################################################

    @Override
    protected String getDomainName()
    {
        return MyCategory.Meta.getLabel();
    }

    @Override
    protected KmMetaStringProperty<MyCategory> getDomainUidProperty()
    {
        return MyCategory.Meta.Uid;
    }

    @Override
    protected KmMetaStringProperty<MyCategory> getDomainTitleProperty()
    {
        return MyCategory.Meta.Name;
    }

    @Override
    protected KmMetaStringProperty<MyCategory> getDomainSubtitleProperty()
    {
        return null;
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    protected KmList<MyCategory> findSortedDomains()
    {
        return getCurrentProject().getCategoriesByName();
    }

    @Override
    protected MyCategory findDomain(String uid)
    {
        return getAccess().findCategoryUid(uid);
    }
}
