package com.app.ui.page.crud.emailTemplate;

import com.kodemore.meta.KmMetaModel;

import com.app.finder.MyEmailTemplateFinder;
import com.app.model.MyEmailTemplate;
import com.app.model.MyProject;
import com.app.ui.page.crud.abstractBase.MyCrudAddCard;
import com.app.ui.page.crud.abstractBase.MyCrudBuilder;
import com.app.ui.page.crud.abstractBase.MyCrudEditCard;
import com.app.ui.page.crud.abstractBase.MyCrudFrame;
import com.app.ui.page.crud.abstractBase.MyCrudListView;
import com.app.ui.page.crud.abstractBase.MyCrudSearchViewIF;
import com.app.ui.page.crud.abstractBase.MyCrudViewCard;

public class MyEmailTemplateBuilder
    extends MyCrudBuilder<MyProject,MyEmailTemplate>
{
    //##################################################
    //# find
    //##################################################

    @Override
    public MyProject findParent(String uid)
    {
        return getAccess().findProjectUid(uid);
    }

    //##################################################
    //# child
    //##################################################

    @Override
    public KmMetaModel getChildMeta()
    {
        return MyEmailTemplate.Meta;
    }

    @Override
    public MyEmailTemplateFinder getChildFinder()
    {
        return MyEmailTemplate.Finder;
    }

    //##################################################
    //# tree
    //##################################################

    @Override
    public MyProject getParentFor(MyEmailTemplate child)
    {
        return child.getProject();
    }

    //##################################################
    //# ui
    //##################################################

    @Override
    public MyCrudListView<MyProject,MyEmailTemplate> newListView()
    {
        return new MyEmailTemplateListView(this);
    }

    @Override
    public MyCrudFrame<MyProject,MyEmailTemplate> newFrame()
    {
        return new MyEmailTemplateFrame(this);
    }

    @Override
    public MyCrudViewCard<MyEmailTemplate> newViewCard()
    {
        return new MyEmailTemplateViewCard(this);
    }

    @Override
    public MyCrudEditCard<MyEmailTemplate> newEditCard()
    {
        return new MyEmailTemplateEditCard(this);
    }

    @Override
    public MyCrudAddCard<MyProject,MyEmailTemplate> newAddCard()
    {
        return new MyEmailTemplateAddCard(this);
    }

    @Override
    protected MyCrudSearchViewIF<MyProject,MyEmailTemplate> newSearchView()
    {
        return new MyEmailTemplateSearchView(this);
    }
}
