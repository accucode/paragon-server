package com.app.ui.page.manage.project;

import java.util.function.Function;
import java.util.function.Predicate;

import com.kodemore.collection.KmList;
import com.kodemore.meta.KmMetaModel;

import com.app.model.MyProject;
import com.app.model.MyTenant;
import com.app.ui.page.manage.crud.MyCrudAddCard;
import com.app.ui.page.manage.crud.MyCrudBuilder;
import com.app.ui.page.manage.crud.MyCrudEditCard;
import com.app.ui.page.manage.crud.MyCrudFrame;
import com.app.ui.page.manage.crud.MyCrudManageView;
import com.app.ui.page.manage.crud.MyCrudViewCard;

public class MyProjectBuilder
    extends MyCrudBuilder<MyTenant,MyProject>
{
    //##################################################
    //# parent
    //##################################################

    @Override
    public MyTenant findParent(String uid)
    {
        return getAccess().findTenantUid(uid);
    }

    //##################################################
    //# child
    //##################################################

    @Override
    public KmMetaModel getChildMeta()
    {
        return MyProject.Meta;
    }

    @Override
    public Function<MyProject,String> getChildTitleFunction()
    {
        return MyProject.Meta.Name;
    }

    @Override
    public Function<MyProject,String> getChildSubtitleFunction()
    {
        return null;
    }

    @Override
    public Predicate<MyProject> getChildActive()
    {
        // fixme_wyatt:
        // return MyProject.Meta.Active;
        return e -> e.isActive();
    }

    @Override
    public MyProject findChild(String uid)
    {
        return getAccess().findProjectUid(uid);
    }

    //##################################################
    //# parent / child
    //##################################################

    @Override
    public MyTenant getParentFor(MyProject child)
    {
        return child.getTenant();
    }

    @Override
    public KmList<MyProject> getChildrenFor(MyTenant tenant)
    {
        return tenant.getProjectsByName();
    }

    //##################################################
    //# ui
    //##################################################

    @Override
    public MyCrudFrame<MyTenant,MyProject> newFrame()
    {
        return new MyProjectFrame(this);
    }

    @Override
    public MyCrudViewCard<MyProject> newViewCard()
    {
        return new MyProjectViewCard(this);
    }

    @Override
    public MyCrudEditCard<MyProject> newEditCard()
    {
        return new MyProjectEditCard(this);
    }

    @Override
    public MyCrudAddCard<MyTenant,MyProject> newAddCard()
    {
        return new MyProjectAddCard(this);
    }

    @Override
    public MyCrudManageView<MyTenant,MyProject> newManageView()
    {
        return new MyProjectManageView(this);
    }
}
