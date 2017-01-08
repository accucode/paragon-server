package com.app.ui.page.manage.crud;

import java.util.function.Consumer;
import java.util.function.Function;

import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.variable.ScLocalString;

import com.app.model.core.MyUidDomainIF;
import com.app.ui.page.general.MyAuditLogView;
import com.app.ui.page.test.MySummaryView;

/**
 * I am used to view the AUDIT LOG of a (child) domain.
 * This is generally NOT subclassed for speciallized for individual domains.
 *
 * The PARENT type is NOT specified since the parent is not needed.
 * @param <C> The domain CHILD.
 */
public class MyCrudAuditLogCard<C extends MyUidDomainIF>
    extends ScGroup
{
    //##################################################
    //# variables
    //##################################################

    private MyCrudBuilder<?,C> _crudBuilder;

    private ScLocalString      _domainChildUid;

    private Consumer<C>        _backListener;

    private MySummaryView<C>   _summaryView;
    private MyAuditLogView     _auditLogView;

    //##################################################
    //# constructor
    //##################################################

    public MyCrudAuditLogCard(MyCrudBuilder<?,C> e)
    {
        _crudBuilder = e;

        _domainChildUid = new ScLocalString();
        _domainChildUid.setAutoSave();

        installGroup();
    }

    protected MyCrudBuilder<?,C> getCrudBuilder()
    {
        return _crudBuilder;
    }

    //##################################################
    //# install
    //##################################################

    private void installGroup()
    {
        ScGroup group;
        group = this;
        group.setTitle("Audit Log, " + getCrudBuilder().getChildLabel());
        group.setFlavorTertiary();

        ScDiv body;
        body = group.getBody();
        body.css().flexColumn();

        installSummaryOn(body);
        installDetailOn(body);
    }

    private void installSummaryOn(ScContainer root)
    {
        MyCrudBuilder<?,C> b = getCrudBuilder();
        Function<C,String> title = b.getChildTitleFunction();
        Function<C,String> subtitle = b.getChildSubtitleFunction();

        MySummaryView<C> view;
        view = root.add(new MySummaryView<>());
        view.css().flexChildStatic();
        view.setTitle(title);
        view.setSubtitle1(subtitle);

        ScDiv buttons;
        buttons = view.getButtonBox();
        buttons.addBackButton(this::handleBack);

        _summaryView = view;
    }

    private void installDetailOn(ScContainer root)
    {
        MyAuditLogView view;
        view = new MyAuditLogView();
        view.css().flexChildFiller().pad();

        root.add(view);
        _auditLogView = view;
    }

    //##################################################
    //# listener :: back
    //##################################################

    public final void onBack(Consumer<C> e)
    {
        _backListener = e;
    }

    private void fireBack()
    {
        fire(_backListener, getDomainChild());
    }

    //##################################################
    //# domain
    //##################################################

    public final C getDomainChild()
    {
        return getCrudBuilder().findChild(_domainChildUid);
    }

    public final void setDomainChild(C e)
    {
        _domainChildUid.setValue(MyUidDomainIF.getUidFor(e));
    }

    //##################################################
    //# downcast
    //##################################################

    @Override
    protected final boolean applyFromModel_here(Object model, boolean skipFields)
    {
        @SuppressWarnings("unchecked")
        C child = (C)model;

        setDomainChild(child);
        return false;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected final void preRender()
    {
        super.preRender();

        C child = getDomainChild();
        _summaryView.applyFromModel(child);
        _auditLogView.applyFromModel(child);
    }

    //##################################################
    //# handle
    //##################################################

    private void handleBack()
    {
        fireBack();
    }

}
