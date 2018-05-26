package com.app.model;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

import com.app.macro.MyMacro;
import com.app.macro.MyMacroContextType;
import com.app.macro.MyMacroDocumentFormatter;
import com.app.macro.MyMacroFetcher;
import com.app.model.base.MyBlurbBase;
import com.app.model.core.MyProjectDomainIF;
import com.app.model.support.MyPageDomainIF;
import com.app.model.transfer.MyTransferrableIF;
import com.app.model.transfer.detail.MyTransferAbstractDetail;
import com.app.model.transfer.detail.MyTransferBlurbDetail;
import com.app.ui.page.crud.blurb.MyBlurbListPage;

public class MyBlurb
    extends MyBlurbBase
    implements MyProjectDomainIF, MyTransferrableIF<MyBlurb>, MyPageDomainIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyBlurb()
    {
        super();
    }

    //##################################################
    //# context
    //##################################################

    @Override
    public MyTenant getTenant()
    {
        return getProject().getTenant();
    }

    //##################################################
    //# enabled
    //##################################################

    @Override
    public boolean isDomainEnabled()
    {
        return isEnabled();
    }

    @Override
    public String getEnabledStatus()
    {
        return Kmu.formatEnabled(getEnabled());
    }

    //##################################################
    //# macros
    //##################################################

    public MyMacroContextType getMacroContextType()
    {
        return getOwnerType().toMacroContextType();
    }

    public KmList<MyMacro> getMacros()
    {
        MyMacroFetcher f;
        f = new MyMacroFetcher();
        f.setContextType(getMacroContextType());
        f.setProject(getProject());

        KmList<MyMacro> v;
        v = f.findAll();
        v.sortOn(e -> e.getName());
        return v;
    }

    //##################################################
    //# sample
    //##################################################

    @Override
    public String getSampleMessageHtml()
    {
        MyMacroDocumentFormatter f = getMacroFormatter();

        String message;
        message = f.formatHtml(getMessageHtml());
        message = f.markAllHtml(message);
        return message;
    }

    private MyMacroDocumentFormatter getMacroFormatter()
    {
        MyMacroDocumentFormatter f;
        f = new MyMacroDocumentFormatter();
        f.setSampleContext(getMacroContextType());
        return f;
    }

    //##################################################
    //# page
    //##################################################

    @Override
    public void ajaxEnterPage()
    {
        MyBlurbListPage.getInstance().ajaxEnterChild(this);
    }

    @Override

    public String formatEntryUrl()
    {
        return MyBlurbListPage.getInstance().formatEntryUrlFor(this);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getAuditLogTitle()
    {
        return getName();
    }

    @Override
    public String getDomainTitle()
    {
        return getName();
    }

    @Override
    public String getDomainSubtitle()
    {
        return getOwnerTypeName();
    }

    //##################################################
    //# transfer
    //##################################################

    @Override
    public MyTransferAbstractDetail<MyBlurb> newTransferDetail()
    {
        return new MyTransferBlurbDetail(this);
    }
}
