package com.app.ui.page.crud.project;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScDomainNotebook;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldText;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScLink;
import com.kodemore.servlet.control.ScText;
import com.kodemore.servlet.control.layout.ScLayout;

import com.app.model.MyProject;
import com.app.model.meta.MyMetaProject;
import com.app.ui.control.MyNotesView;
import com.app.ui.email.MyEmailComposerForm;
import com.app.ui.layout.MyPageLayout;
import com.app.ui.page.crud.abstractBase.MyCrudViewCard;
import com.app.ui.page.crud.attachment.MyAttachmentListView;
import com.app.ui.page.crud.blurb.MyBlurbListTile;
import com.app.ui.page.crud.projectContact.MyProjectContactListView;
import com.app.utility.MyUserProxy;

public class MyProjectViewCard
    extends MyCrudViewCard<MyProject>
{
    //##################################################
    //# variables
    //##################################################

    private ScControl _detailTab;
    private ScText    _managersText;

    private ScLink _toggleEnableLink;

    private MyProjectContactListView _contactsTab;
    private MyEmailComposerForm      _emailTab;
    private MyNotesView              _notesTab;
    private MyBlurbListTile          _blurbsTab;
    private MyAttachmentListView     _attachmentsTab;

    //##################################################
    //# constructor
    //##################################################

    public MyProjectViewCard()
    {
        super(new MyProjectBuilder());
    }

    public MyProjectViewCard(MyProjectBuilder e)
    {
        super(e);
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installBodyOn(ScDiv body)
    {
        detachBody();
        body.add(createNotebook());
    }

    private ScDomainNotebook<MyProject> createNotebook()
    {
        ScDomainNotebook<MyProject> e;
        e = new ScDomainNotebook<>();
        e.css().fill();
        e.setFinder(MyProject.Finder);
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
    //= details tab
    //==================================================

    private ScControl createDetailsTab()
    {
        ScGroup e;
        e = new ScGroup();
        e.setNotebookTab("Project", "Details");
        e.getBody().add(createDetailsLayout());
        _detailTab = e;
        return e;
    }

    private ScControl createDetailsLayout()
    {
        ScLayout e;
        e = new ScLayout();
        e.setTypeFieldset();
        e.css().fill().auto();
        e.add(createGeneralSection());
        e.add(createDescriptionSection());
        e.add(createBusinessHoursSection());
        e.add(createTasksSection());
        e.add(createSiteNumberSection());
        e.add(createSupportSection());
        e.add(createManagersSection());
        return e;
    }

    //==================================================
    //= install :: general
    //==================================================

    private ScControl createGeneralSection()
    {
        MyMetaProject x = MyProject.Meta;

        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("General");
        e.addFieldText(x.Name);
        e.addFieldText(x.Code);
        e.addSpace();
        e.addFieldText(x.SupervisorFullName);
        e.addFieldText(x.CompanyName);
        e.add(createEnabledRow());
        return e;
    }

    private ScDiv createEnabledRow()
    {
        MyMetaProject x = MyProject.Meta;

        ScDiv e;
        e = new ScDiv();
        e.setLabel("Enabled");
        e.css().flexRow().rowSpacer5().flexCrossAlignCenter();
        e.addFieldText(x.EnabledStatus);
        e.add(createToggleLink());
        return e;
    }

    private ScLink createToggleLink()
    {
        ScLink link;
        link = new ScLink();
        link.setText("toggle");
        link.setAction(newCheckedAction(this::handleToggleEnabled));
        link.hide();
        _toggleEnableLink = link;
        return link;
    }

    //==================================================
    //= install :: description
    //==================================================

    private ScControl createDescriptionSection()
    {
        MyMetaProject x = MyProject.Meta;

        ScFieldText e;
        e = x.Description.newFieldText();
        return e;
    }

    //==================================================
    //= install :: business hours
    //==================================================

    private ScControl createBusinessHoursSection()
    {
        MyMetaProject x = MyProject.Meta;

        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("Business Hours");
        e.addFieldText(x.TimeZoneName);
        e.addSpace();
        e.addFieldText(x.BusinessDays, "Days");
        e.addFieldText(x.BusinessStartTime, "Start Time");
        e.addFieldText(x.BusinessEndTime, "End Time");
        return e;
    }

    //==================================================
    //= install :: tasks
    //==================================================

    private ScControl createTasksSection()
    {
        MyMetaProject x = MyProject.Meta;

        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("Tasks");
        e.addFieldText(x.DefaultPriorityName, "Default Priority");
        return e;
    }

    //==================================================
    //= install :: auto site number
    //==================================================

    private ScControl createSiteNumberSection()
    {
        MyMetaProject x = MyProject.Meta;

        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("Automatic Site Numbers");
        e.addFieldText(x.AutoSiteNumberEnabled, "Enabled");
        e.addFieldText(x.AutoSiteNumberPrefix, "Prefix");
        e.addFieldText(x.AutoSiteNumberPadding, "Padding");
        e.addFieldText(x.NextAutoSiteNumber, "Next Value");
        return e;
    }

    //==================================================
    //= install :: support
    //==================================================

    private ScControl createSupportSection()
    {
        MyMetaProject x = MyProject.Meta;

        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("Support");
        e.addFieldText(x.SupportContactFullName);
        e.addFieldText(x.SendEmailFrom);
        return e;
    }

    //==================================================
    //= install :: managers
    //==================================================

    private ScControl createManagersSection()
    {
        ScText e;
        e = new ScText();
        e.setLabel("Managers");
        _managersText = e;
        return e;
    }

    //==================================================
    //= other tabs
    //==================================================

    private ScControl createContactsTab()
    {
        MyProjectContactListView e;
        e = new MyProjectContactListView();
        e.setLabel("Contacts");
        e.css().fill();
        e.hide();
        _contactsTab = e;
        return e;
    }

    private ScControl createEmailTab()
    {
        MyEmailComposerForm e;
        e = new MyEmailComposerForm();
        e.setLabel("Email");
        e.css().fill();
        e.hide();
        _emailTab = e;
        return e;
    }

    private MyAttachmentListView createAttachmentsTab()
    {
        MyAttachmentListView e;
        e = new MyAttachmentListView();
        e.css().fill();
        e.hide();
        _attachmentsTab = e;
        return e;
    }

    private MyBlurbListTile createBlurbsTab()
    {
        MyBlurbListTile e;
        e = new MyBlurbListTile();
        e.css().fill();
        e.hide();
        _blurbsTab = e;
        return e;
    }

    private MyNotesView createNotesTab()
    {
        MyNotesView e;
        e = new MyNotesView();
        e.css().fill();
        e.hide();
        _notesTab = e;
        return e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRenderDetails(MyProject project)
    {
        super.preRenderDetails(project);

        preRenderTabVisibility();
    }

    //##################################################
    //# handle
    //##################################################

    private void handleToggleEnabled()
    {
        MyProject e;
        e = getDomainChild();
        e.toggleEnabled();
        e.validateAndCheck();

        ajaxReplace();
        MyPageLayout.getInstance().ajaxRefreshHeader();
        fireChildChanged(getDomainChild());
    }

    //==================================================
    //= handle :: tab render
    //==================================================

    private void handleTabPreRender(ScControl tab)
    {
        preRenderTabVisibility();

        if ( tab == _detailTab )
            preRenderDetailTab();

        if ( tab == _emailTab )
            preRenderEmailTab();
    }

    private void preRenderDetailTab()
    {
        MyProject project = getDomainChild();
        String mgrText = formatManagerText(project);
        _managersText.setValue(mgrText);

        if ( allowsManager() )
            _toggleEnableLink.show();
    }

    private void preRenderEmailTab()
    {
        MyProject project = getDomainChild();
        _emailTab.setContext(project);
    }

    //##################################################
    //# support
    //##################################################

    private String formatManagerText(MyProject project)
    {
        return project.getManagersByName().join(e -> e.getUserFullName());
    }

    private boolean allowsManager()
    {
        return MyUserProxy.createProxy().allowsProjectManager();
    }

    private void preRenderTabVisibility()
    {
        boolean b = allowsManager();

        _contactsTab.show(b);
        _emailTab.show(b);
        _attachmentsTab.show(b);
        _blurbsTab.show(b);
        _notesTab.show(b);
    }
}
