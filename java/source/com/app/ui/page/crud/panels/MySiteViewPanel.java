package com.app.ui.page.crud.panels;

import java.util.function.Consumer;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScDomainNotebook;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.layout.ScLayout;
import com.kodemore.servlet.variable.ScLocalString;

import com.app.dao.base.MyDaoAccess;
import com.app.model.MySite;
import com.app.model.meta.MyMetaSite;
import com.app.ui.control.MyNotesView;
import com.app.ui.email.MyEmailComposerForm;
import com.app.ui.page.crud.attachment.MyAttachmentListView;
import com.app.ui.page.crud.blurb.MyBlurbListTile;
import com.app.ui.page.crud.siteContact.MySiteContactListView;
import com.app.utility.MyGlobals;

public class MySiteViewPanel
    extends ScDiv
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalString _siteUid;

    private ScGroup _detailsTab;

    private MySiteContactListView _contactsTab;
    private MyEmailComposerForm   _emailTab;

    private Consumer<MySite> _childChangedListener;
    private Consumer<MySite> _childListChangedListener;

    //##################################################
    //# constructor
    //##################################################

    public MySiteViewPanel()
    {
        _siteUid = new ScLocalString();
        _siteUid.setAutoSave();

        css().flexColumn();
        installDetailsOn(this);
    }

    //##################################################
    //# install
    //##################################################

    protected void installDetailsOn(ScDiv root)
    {
        root.css().relative();
        root.add(createNotebook());
    }

    //==================================================
    //= install :: notebook
    //==================================================

    private ScDomainNotebook<MySite> createNotebook()
    {
        ScDomainNotebook<MySite> e;
        e = new ScDomainNotebook<>();
        e.setFinder(MySite.Finder);
        e.css().fill();
        e.onTabPreRender(this::handleTabPreRender);
        e.add(createDetailsTab());
        e.add(createContactsTab());
        e.add(createEmailTab());
        e.add(createAttachmentsTab()).setSecondary();
        e.add(createBlurbsTab()).setSecondary();
        e.add(createNotesTab()).setSecondary();
        return e;
    }

    //==================================================
    //= install :: details tab
    //==================================================

    private ScControl createDetailsTab()
    {
        ScGroup e;
        e = new ScGroup();
        e.setNotebookTab("Site", "Details");
        e.getBody().add(createDetailsLayout());
        _detailsTab = e;
        return e;
    }

    private ScLayout createDetailsLayout()
    {
        ScLayout e;
        e = new ScLayout();
        e.setTypeFieldset();
        e.css().fill().auto();
        e.add(createGeneralSection());
        e.add(createPrioritySection());
        e.add(createAddressSection());
        e.add(createContactsSection());
        return e;
    }

    private ScControl createGeneralSection()
    {
        MyMetaSite x = MySite.Meta;

        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("General");
        e.addFieldText(x.CustomerName, "Customer");
        e.add(createEnabledRow());
        e.addSpace();
        e.addFieldText(x.FullName);
        e.addFieldText(x.TypeName);
        e.addSpace();
        e.addFieldText(x.TimeZoneName, "Time Zone");
        return e;
    }

    private ScControl createEnabledRow()
    {
        MyMetaSite x = MySite.Meta;

        ScDiv e;
        e = new ScDiv();
        e.css().flexRow().rowSpacer5().flexCrossAlignCenter();
        e.setLabel("Enabled");
        e.addFieldText(x.EnabledStatus);
        e.addLink("toggle", newCheckedAction(this::handleToggle));
        return e;
    }

    private ScControl createPrioritySection()
    {
        MyMetaSite x = MySite.Meta;

        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("Priority");
        e.addFieldText(x.PriorityName);
        return e;
    }

    private ScControl createAddressSection()
    {
        MyMetaSite x = MySite.Meta;

        ScDiv e;
        e = new ScDiv();
        e.setLabel("Addresses");
        e.css().flexRow().rowSpacer20();
        e.addFieldLayout().addFieldText(x.AddressMultiLine, "Address");
        return e;
    }

    private ScControl createContactsSection()
    {
        MyMetaSite x = MySite.Meta;

        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("Contacts");
        e.addFieldText(x.MainContactSummaryMultiline, "Main");
        e.addSpace();
        e.addFieldText(x.EffectiveInstallContactSummaryMultiline, "Install");
        e.addFieldText(x.EffectiveTechnicalContactSummaryMultiline, "Technical");
        e.addFieldText(x.EffectiveSchedulingContactSummaryMultiline, "Scheduling");
        e.addFieldText(x.EffectiveSalesContactSummaryMultiline, "Sales");
        e.addFieldText(x.EffectiveRequesterContactSummaryMultiline, "Requester");
        return e;
    }

    //==================================================
    //= install :: other tabs
    //==================================================

    private ScControl createContactsTab()
    {
        MySiteContactListView e;
        e = new MySiteContactListView();
        e.setLabel("Contacts");
        e.css().fill();
        _contactsTab = e;
        return e;
    }

    private ScControl createEmailTab()
    {
        MyEmailComposerForm e;
        e = new MyEmailComposerForm();
        e.css().fill();
        _emailTab = e;
        return e;
    }

    private MyNotesView createNotesTab()
    {
        MyNotesView e;
        e = new MyNotesView();
        e.css().fill();
        return e;
    }

    private MyBlurbListTile createBlurbsTab()
    {
        MyBlurbListTile e;
        e = new MyBlurbListTile();
        e.css().fill();
        return e;
    }

    private MyAttachmentListView createAttachmentsTab()
    {
        MyAttachmentListView e;
        e = new MyAttachmentListView();
        e.css().fill();
        return e;
    }

    //##################################################
    //# site
    //##################################################

    private MySite getSite()
    {
        String uid = _siteUid.getValue();
        return getAccess().findSiteUid(uid);
    }

    private void setSite(MySite e)
    {
        _siteUid.setValue(e.getUid());
    }

    //##################################################
    //# listener :: child
    //##################################################

    public final void onChildChanged(Consumer<MySite> e)
    {
        _childChangedListener = e;
    }

    protected void fireChildChanged()
    {
        fireChildChanged(getSite());
    }

    protected void fireChildChanged(MySite e)
    {
        fire(_childChangedListener, e);
    }

    //##################################################
    //# listener :: child list
    //##################################################

    public final void onChildListChanged(Consumer<MySite> e)
    {
        _childListChangedListener = e;
    }

    protected void fireChildListChanged()
    {
        fireChildListChanged(getSite());
    }

    protected void fireChildListChanged(MySite e)
    {
        fire(_childListChangedListener, e);
    }

    //##################################################
    //# apply
    //##################################################

    @Override
    protected boolean applyFromModel_here(Object model)
    {
        if ( model instanceof MySite )
        {
            setSite((MySite)model);
            return super.applyFromModel_here(model);
        }

        return false;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();
    }

    //==================================================
    //= render :: tabs
    //==================================================

    private void handleTabPreRender(ScControl tab)
    {
        if ( tab == _emailTab )
            preRenderEmailTab();

        if ( tab == _contactsTab )
            preRenderContactsTab();
    }

    private void preRenderEmailTab()
    {
        _emailTab.setContext(getSite());
    }

    private void preRenderContactsTab()
    {
        // none
    }

    //##################################################
    //# handle
    //##################################################

    private void handleToggle()
    {
        MySite site;
        site = getSite();
        site.toggleEnabled();

        _detailsTab.applyFromModel(site);
        _detailsTab.ajaxReplace();

        fireChildChanged();
    }

    //##################################################
    //# support
    //##################################################

    private MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }
}
