package com.app.ui.page.crud.abstractBase;

import com.kodemore.domain.KmUidDomainIF;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScDomainNotebook;

/**
 * I provide common functionality for VIEWING a single domain.
 *
 * The domain PARENT is NOT specified, since it is not needed for editing.
 * @param <C> The domain CHILD.
 */
public abstract class MyCrudViewNotebookCard<C extends KmUidDomainIF>
    extends MyCrudViewCard<C>
{
    //##################################################
    //# variables
    //##################################################

    private ScDomainNotebook<C> _notebook;

    //##################################################
    //# constructor
    //##################################################

    public MyCrudViewNotebookCard(MyCrudBuilder<?,C> e)
    {
        super(e);
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected final void installBodyOn(ScDiv body)
    {
        detachBody();
        body.add(createNotebook());
        installNotebookTabs();
    }

    //##################################################
    //# install :: notebook
    //##################################################

    protected ScDomainNotebook<C> getNotebook()
    {
        return _notebook;
    }

    private ScDomainNotebook<C> createNotebook()
    {
        ScDomainNotebook<C> e;
        e = new ScDomainNotebook<>();
        e.onTabPreRender(this::preRenderTab);
        e.css().fill();
        e.setFinder(getCrudBuilder().getChildFinder());
        _notebook = e;
        return e;
    }

    protected abstract void installNotebookTabs();

    //##################################################
    //# render
    //##################################################

    /**
     * Use preRenderTab instead.
     */
    @Override
    protected final void preRenderDetails(C child)
    {
        super.preRenderDetails(child);
    }

    /**
     * @param tab the tab about to be rendered.
     */
    protected void preRenderTab(ScControl tab)
    {
        // subclass
    }
}
