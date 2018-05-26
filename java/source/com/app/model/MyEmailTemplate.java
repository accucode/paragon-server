package com.app.model;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

import com.app.macro.MyMacro;
import com.app.macro.MyMacroContextType;
import com.app.macro.MyMacroDocumentFormatter;
import com.app.macro.MyMacroFetcher;
import com.app.model.base.MyDefaultRecipientContactType;
import com.app.model.base.MyEmailTemplateBase;
import com.app.model.core.MyProjectDomainIF;
import com.app.model.support.MyPageDomainIF;
import com.app.model.transfer.MyTransferrableIF;
import com.app.model.transfer.detail.MyTransferAbstractDetail;
import com.app.model.transfer.detail.MyTransferEmailTemplateDetail;
import com.app.ui.page.crud.emailTemplate.MyEmailTemplateListPage;

public class MyEmailTemplate
    extends MyEmailTemplateBase
    implements MyProjectDomainIF, MyPageDomainIF, MyTransferrableIF<MyEmailTemplate>
{
    //##################################################
    //# constructor
    //##################################################

    public MyEmailTemplate()
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
        return getContextType().toMacroContextType();
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
    //# samples
    //##################################################

    @Override
    public String getSampleSubjectText()
    {
        return getSampleFormatter().formatText(getSubjectText());
    }

    @Override
    public String getSampleBodyHtml()
    {
        MyMacroDocumentFormatter f = getSampleFormatter();

        String e;
        e = f.formatHtml(getBodyHtml());
        e = f.markAllHtml(e);
        return e;
    }

    private MyMacroDocumentFormatter getSampleFormatter()
    {
        MyMacroDocumentFormatter f;
        f = new MyMacroDocumentFormatter();
        f.setSampleContext(getMacroContextType());
        return f;
    }

    //##################################################
    //# default recipients
    //##################################################

    public KmList<MyDefaultRecipient> getDefaultToRecipients()
    {
        return getDefaultRecipients().toList().select(e -> e.isTypeTo());
    }

    private void clearDefaultToRecipients()
    {
        getDefaultRecipients().removeAll(getDefaultToRecipients());
    }

    public void setDefaultToRecipientsFrom(KmList<MyDefaultRecipientContactType> v)
    {
        clearDefaultToRecipients();

        getAccess().flush();

        for ( MyDefaultRecipientContactType e : v )
            addDefaultToRecipient(e);
    }

    public MyDefaultRecipient addDefaultToRecipient(MyDefaultRecipientContactType type)
    {
        MyDefaultRecipient e;
        e = addDefaultRecipient();
        e.setContactType(type);
        e.setTypeTo();
        e.daoAttach();
        return e;
    }

    public KmList<MyDefaultRecipient> getDefaultCcRecipients()
    {
        return getDefaultRecipients().toList().select(e -> e.isTypeCc());
    }

    private void clearDefaultCcRecipients()
    {
        getDefaultRecipients().removeAll(getDefaultCcRecipients());
    }

    public void setDefaultCcRecipientsFrom(KmList<MyDefaultRecipientContactType> v)
    {
        clearDefaultCcRecipients();

        getAccess().flush();

        for ( MyDefaultRecipientContactType e : v )
            addDefaultCcRecipient(e);
    }

    public MyDefaultRecipient addDefaultCcRecipient(MyDefaultRecipientContactType type)
    {
        MyDefaultRecipient e;
        e = addDefaultRecipient();
        e.setEmailTemplate(this);
        e.setContactType(type);
        e.setTypeCc();
        e.daoAttach();
        return e;
    }

    //##################################################
    //# transfer
    //##################################################

    @Override
    public MyTransferAbstractDetail<MyEmailTemplate> newTransferDetail()
    {
        return new MyTransferEmailTemplateDetail(this);
    }

    //##################################################
    //# page
    //##################################################

    @Override
    public void ajaxEnterPage()
    {
        MyEmailTemplateListPage.getInstance().ajaxEnterChild(this);
    }

    @Override
    public String formatEntryUrl()
    {
        return MyEmailTemplateListPage.getInstance().formatEntryUrlFor(this);
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
        return getContextTypeName();
    }

}
