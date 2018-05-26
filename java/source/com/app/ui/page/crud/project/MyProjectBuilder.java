package com.app.ui.page.crud.project;

import com.kodemore.meta.KmMetaModel;

import com.app.finder.MyProjectFinder;
import com.app.model.MyProject;
import com.app.model.MyTenant;
import com.app.model.MyUser;
import com.app.ui.page.crud.abstractBase.MyCrudAddCard;
import com.app.ui.page.crud.abstractBase.MyCrudBuilder;
import com.app.ui.page.crud.abstractBase.MyCrudEditCard;
import com.app.ui.page.crud.abstractBase.MyCrudFrame;
import com.app.ui.page.crud.abstractBase.MyCrudListView;
import com.app.ui.page.crud.abstractBase.MyCrudSearchViewIF;
import com.app.ui.page.crud.abstractBase.MyCrudViewCard;
import com.app.utility.MyUserProxy;

public class MyProjectBuilder
    extends MyCrudBuilder<MyTenant,MyProject>
{
    //##################################################
    //# find
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
    public MyProjectFinder getChildFinder()
    {
        return MyProject.Finder;
    }

    //##################################################
    //# allows
    //##################################################

    @Override
    protected boolean showsEditFor(MyProject child)
    {
        MyUser user = getCurrentUser();
        MyUserProxy proxy = MyUserProxy.createProxy(user, child);
        return proxy.allowsProjectManager();
    }

    @Override
    protected boolean showsAddFor(MyTenant parent)
    {
        return true;
    }

    //##################################################
    //# tree
    //##################################################

    @Override
    public MyTenant getParentFor(MyProject project)
    {
        return project.getTenant();
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
        return null;
    }

    @Override
    public MyCrudListView<MyTenant,MyProject> newListView()
    {
        return new MyProjectListView(this);
    }

    @Override
    protected MyCrudSearchViewIF<MyTenant,MyProject> newSearchView()
    {
        return new MyProjectSearchView(this);
    }
}
