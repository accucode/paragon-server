package com.app.ui.page.crud.abstractBase;

import java.util.function.Consumer;
import java.util.function.Function;

import com.kodemore.domain.KmUidDomainIF;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.variable.ScLocalString;

import com.app.ui.control.MySummaryView;
import com.app.ui.page.general.MyAuditLogView;

/**
 * I am used to view the AUDIT LOG of a (child) domain.
 * This is generally NOT subclassed for speciallized for individual domains.
 *
 * The PARENT type is NOT specified since the parent is not needed.
 * @param <C> The domain CHILD.
 */
public class MyCrudAuditLogCard<C extends KmUidDomainIF>
    extends ScGroup
{
    //##################################################
    //# variables
    //##################################################

    private MyCrudBuilder<?,C> _crudBuilder;

    private ScLocalString _domainChildUid;

    private Consumer<C> _backListener;

    private MySummaryView<C> _summaryView;
    private MyAuditLogView   _auditLogView;

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
        group.setFlavorSummary();

        installHeaderOn(group);
        installBodyOn(group);
    }

    private void installHeaderOn(ScGroup group)
    {
        ScDiv header;
        header = group.showHeader();
        header.add(createSummaryView());
    }

    private MySummaryView<C> createSummaryView()
    {
        MyCrudBuilder<?,C> b = getCrudBuilder();
        Function<C,String> title = b.getChildTitleFunction();
        Function<C,String> subtitle = b.getChildSubtitleFunction();

        MySummaryView<C> view;
        view = new MySummaryView<>();
        view.css().flexChildStatic();
        view.setTitle(title);
        view.setSubtitle1(subtitle);

        ScDiv buttons;
        buttons = view.getButtonBox();
        buttons.addBackButton(newCheckedAction(this::handleBack));

        _summaryView = view;
        return view;
    }

    private void installBodyOn(ScGroup group)
    {
        ScDiv body;
        body = group.getBody();
        body.css().flexColumn();
        body.add(createAutitLogView());
    }

    private MyAuditLogView createAutitLogView()
    {
        MyAuditLogView e;
        e = new MyAuditLogView();
        e.css().flexChildFiller();
        _auditLogView = e;
        return e;
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
        _domainChildUid.setValue(KmUidDomainIF.getUidFor(e));
    }

    //##################################################
    //# downcast
    //##################################################

    @Override
    protected final boolean applyFromModel_here(Object model)
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
