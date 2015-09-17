package com.app.ui.page.manageProjects;

import com.kodemore.collection.KmList;
import com.kodemore.meta.KmMetaStringProperty;
import com.kodemore.servlet.control.ScCardFrame;
import com.kodemore.servlet.control.ScContainer;

import com.app.model.MyProject;
import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.support.MyManageDomainPage;

public final class MyManageProjectsPage
    extends MyManageDomainPage<MyProject>
{
    //##################################################
    //# singleton
    //##################################################

    private static MyManageProjectsPage _instance;

    public static void installInstance()
    {
        _instance = new MyManageProjectsPage();
    }

    public static MyManageProjectsPage getInstance()
    {
        return _instance;
    }

    private MyManageProjectsPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private MyAddProjectDialog _addDialog;
    private MyViewProjectCard  _viewCard;

    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.admin;
    }

    @Override
    public String getHelpMessage()
    {
        return MyProject.Meta.getHelp();
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installDialogsOn(ScContainer root)
    {
        _addDialog = root.add(new MyAddProjectDialog());
        _addDialog.addSaveListener(this::handleAdded);
    }

    @Override
    protected void installCardsOn(ScCardFrame frame)
    {
        _viewCard = frame.addCard(new MyViewProjectCard());
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
        _viewCard.setProject(getDomain());
        _viewCard.ajaxPrint();
    }

    //##################################################
    //# properties
    //##################################################

    @Override
    protected String getDomainName()
    {
        return MyProject.Meta.getLabel();
    }

    @Override
    protected KmMetaStringProperty<MyProject> getDomainUidProperty()
    {
        return MyProject.Meta.Uid;
    }

    @Override
    protected KmMetaStringProperty<MyProject> getDomainTitleProperty()
    {
        return MyProject.Meta.Name;
    }

    @Override
    protected KmMetaStringProperty<MyProject> getDomainSubtitleProperty()
    {
        return null;
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    protected KmList<MyProject> findSortedDomains()
    {
        return getAccess().getProjectDao().findAllByName();
    }

    @Override
    protected MyProject findDomain(String uid)
    {
        return getAccess().findProjectUid(uid);
    }
}
