package com.app.ui.page.manageSkills;

import com.kodemore.collection.KmList;
import com.kodemore.meta.KmMetaStringProperty;
import com.kodemore.servlet.control.ScCardFrame;
import com.kodemore.servlet.control.ScContainer;

import com.app.model.MySkill;
import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.support.MyManageDomainPage;

public class MyManageSkillsPage
    extends MyManageDomainPage<MySkill>
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyManageSkillsPage instance = new MyManageSkillsPage();

    private MyManageSkillsPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private MyViewSkillCard  _viewCard;
    private MyAddSkillDialog _addDialog;

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
        return MySkill.Meta.getHelp();
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installDialogsOn(ScContainer root)
    {
        _addDialog = root.add(new MyAddSkillDialog());
        _addDialog.addSaveListener(this::handleAdded);
    }

    @Override
    protected void installCardsOn(ScCardFrame frame)
    {
        _viewCard = frame.addCard(new MyViewSkillCard());
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
        _viewCard.setSkill(getDomain());
        _viewCard.ajaxPrint();
    }

    //##################################################
    //# properties
    //##################################################

    @Override
    protected String getDomainName()
    {
        return MySkill.Meta.getLabel();
    }

    @Override
    protected KmMetaStringProperty<MySkill> getDomainUidProperty()
    {
        return MySkill.Meta.Uid;
    }

    @Override
    protected KmMetaStringProperty<MySkill> getDomainTitleProperty()
    {
        return MySkill.Meta.Name;
    }

    @Override
    protected KmMetaStringProperty<MySkill> getDomainSubtitleProperty()
    {
        return null;
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    protected KmList<MySkill> findSortedDomains()
    {
        return getCurrentProject().getSkillsByName();
    }

    @Override
    protected MySkill findDomain(String uid)
    {
        return getAccess().findSkillUid(uid);
    }
}
