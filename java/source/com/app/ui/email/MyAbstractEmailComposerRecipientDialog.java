package com.app.ui.email;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScLink;
import com.kodemore.servlet.control.ScNotebook;
import com.kodemore.servlet.field.ScCheckboxList;
import com.kodemore.servlet.field.ScOption;
import com.kodemore.servlet.field.ScTextArea;
import com.kodemore.utility.KmEmailAddressParser;
import com.kodemore.utility.Kmu;

import com.app.model.MyContactIF;
import com.app.model.MyCustomer;
import com.app.model.MyCustomerContact;
import com.app.model.MyDefaultRecipientUtility;
import com.app.model.MyProject;
import com.app.model.MyProjectContact;
import com.app.model.MySite;
import com.app.model.MySiteContact;
import com.app.model.base.MyDefaultRecipientContactType;
import com.app.model.base.MyEmailTemplateContextType;
import com.app.ui.control.MyFormDialog;

/**
 * I am used to edit the default recipients for an email template.
 */
public abstract class MyAbstractEmailComposerRecipientDialog
    extends MyFormDialog
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The form that opened this dialog.
     */
    private MyEmailComposerForm _emailComposer;

    /**
     * The free-form text area for all email addresses. Users can freely
     * edit this or copy-and-paste.
     */
    private ScTextArea _emailField;

    //==================================================
    //= variables :: tabs
    //==================================================

    private ScNotebook _notebook;

    private ScGroup        _commonTab;
    private ScDiv          _commonProjectWrapper;
    ScCheckboxList<String> _commonProjectContactList;
    private ScDiv          _commonSiteWrapper;
    ScCheckboxList<String> _commonSiteContactList;

    private ScLink _projectContactsLink;
    private ScLink _customerContactsLink;
    private ScLink _allContactsLink;

    private ScGroup                _projectTab;
    private ScDiv                  _projectWrapper;
    private ScCheckboxList<String> _projectContactList;

    private ScGroup                _siteTab;
    private ScDiv                  _siteWrapper;
    private ScCheckboxList<String> _siteContactList;

    private ScGroup                _customerTab;
    private ScDiv                  _customerWrapper;
    private ScCheckboxList<String> _customerContactList;

    private ScGroup        _allTab;
    private ScDiv          _allWrapper;
    ScCheckboxList<String> _allContactList;

    //##################################################
    //# constructor
    //##################################################

    public MyAbstractEmailComposerRecipientDialog(MyEmailComposerForm e)
    {
        _emailComposer = e;
        install();
    }

    //##################################################
    //# accessing
    //##################################################

    public MyEmailComposerForm getEmailComposer()
    {
        return _emailComposer;
    }

    //##################################################
    //# install
    //##################################################

    private void install()
    {
        setWidth(800);

        installForm();
        installBody();
        installFooter();
    }

    private void installForm()
    {
        ScForm form;
        form = getDialogRoot();
        form.onSubmit(newUncheckedAction(this::handleApply));
    }

    private void installBody()
    {
        ScDiv body;
        body = getBody();
        body.css().gap20();

        ScFieldset set;
        set = body.addFieldset("Recipients");
        set.css().flexColumn().flexCrossAlignStart();
        set.addFieldLayout().add(createEmailField());
        ScDiv r = set.addDiv();
        r.addLink("Clear All", newCheckedAction(this::handleClearAll));

        installNotebookOn(body);
    }

    private ScControl createEmailField()
    {
        String help = ""
            + "The list of email addresses. "
            + "This can be modified directly, or you can use the checkboxes below. "
            + "";

        ScTextArea e;
        e = new ScTextArea();
        e.setHelp(help);
        e.layoutFlexFiller(null, 100);
        e.disableChangeTracking();
        e.onTypeWatch(newUncheckedAction(this::handleEmailChanged), 500);
        _emailField = e;
        return e;
    }

    //==================================================
    //= install :: notebook
    //==================================================

    private void installNotebookOn(ScDiv root)
    {
        ScNotebook book;
        book = root.addNotebook();
        book.css().height400();
        book.onTabPreRender(this::handleTabPreRender);
        _notebook = book;

        installCommonTabOn(book);
        installSiteTabOn(book);
        installCustomerTabOn(book);
        installProjectTabOn(book);
        installAllTabOn(book);
    }

    //==================================================
    //= install :: common tab
    //==================================================

    private void installCommonTabOn(ScNotebook book)
    {
        ScGroup group;
        group = new ScGroup();
        group.setFlavorList();
        group.setLabel("Common");
        group.setTitle("Common Contacts");
        group.css().flexChildFiller();
        _commonTab = group;

        ScDiv body;
        body = group.getBody();
        body.css().pad10();

        ScDiv row;
        row = body.addDiv();
        row.css().flexRow().rowSpacer10();
        row.add(createCommonSiteContactList());
        row.add(createCommonProjectContactList());
        row.add(createCommonNotificationsList());

        book.addTab(group);
    }

    private ScControl createCommonProjectContactList()
    {
        ScCheckboxList<String> list;
        list = new ScCheckboxList<>();
        list.setLabel("Project");
        list.layoutBlockMultiColumn(200);
        list.disableChangeTracking();
        list.onChange(newUncheckedAction(this::handleCommonProjectListChanged));
        _commonProjectContactList = list;

        ScFieldLayout fields;
        fields = new ScFieldLayout();
        fields.add(list);

        ScDiv div;
        div = new ScDiv();
        div.add(fields);
        div.hide();
        _commonProjectWrapper = div;
        return div;
    }

    private ScControl createCommonSiteContactList()
    {
        ScCheckboxList<String> list;
        list = new ScCheckboxList<>();
        list.setLabel("Site");
        list.layoutBlockMultiColumn(200);
        list.disableChangeTracking();
        list.onChange(newUncheckedAction(this::handleCommonSiteListChanged));
        _commonSiteContactList = list;

        ScFieldLayout fields;
        fields = new ScFieldLayout();
        fields.add(list);

        ScDiv div;
        div = new ScDiv();
        div.add(fields);
        div.hide();
        _commonSiteWrapper = div;
        return div;
    }

    private ScDiv createCommonNotificationsList()
    {
        ScDiv links;
        links = new ScDiv();
        links.setLabel("Job Notifications");
        links.css().flexColumn().columnSpacer5();

        _projectContactsLink = links.addLink(
            "Project Contacts",
            newCheckedAction(this::handleSelectProjectNotifications));
        _projectContactsLink.hide();

        _customerContactsLink = links.addLink(
            "Customer Contacts",
            newCheckedAction(this::handleSelectCustomerNotifications));
        _customerContactsLink.hide();

        _allContactsLink = links.addLink(
            "All",
            newCheckedAction(this::handleSelectAllNotifications));
        _allContactsLink.hide();

        ScFieldLayout fields;
        fields = new ScFieldLayout();
        fields.add(links);

        ScDiv div;
        div = new ScDiv();
        div.add(fields);
        return div;
    }

    //==================================================
    //= install :: project tab
    //==================================================

    private void installProjectTabOn(ScNotebook book)
    {
        ScGroup group;
        group = new ScGroup();
        group.setFlavorList();
        group.setLabel("Project");
        group.setTitle("Project Contacts");
        group.css().flexChildFiller();
        group.hide();
        _projectTab = group;

        ScDiv body;
        body = group.getBody();
        body.css().pad10();

        ScDiv row;
        row = body.addDiv();
        row.css().flexRow().rowSpacer10();
        row.add(createProjectContactList());

        book.addTab(group);
    }

    private ScControl createProjectContactList()
    {
        ScCheckboxList<String> list;
        list = new ScCheckboxList<>();
        list.layoutBlockMultiColumn(200);
        list.disableChangeTracking();
        list.onChange(newUncheckedAction(this::handleProjectListChanged));
        _projectContactList = list;

        ScDiv div;
        div = new ScDiv();
        div.add(list);
        div.hide();
        _projectWrapper = div;
        return div;
    }

    //==================================================
    //= install :: site tab
    //==================================================

    private void installSiteTabOn(ScNotebook book)
    {
        ScGroup group;
        group = new ScGroup();
        group.setFlavorList();
        group.setLabel("Site");
        group.setTitle("Site Contacts");
        group.css().flexChildFiller();
        group.hide();
        _siteTab = group;

        ScDiv body;
        body = group.getBody();
        body.css().pad10();

        ScDiv row;
        row = body.addDiv();
        row.css().flexRow().rowSpacer10();
        row.add(createSiteContactList());

        book.addTab(group);
    }

    private ScControl createSiteContactList()
    {
        ScCheckboxList<String> list;
        list = new ScCheckboxList<>();
        list.layoutBlockMultiColumn(200);
        list.disableChangeTracking();
        list.onChange(newUncheckedAction(this::handleSiteListChanged));
        _siteContactList = list;

        ScDiv div;
        div = new ScDiv();
        div.add(list);
        div.hide();
        _siteWrapper = div;
        return div;
    }

    //==================================================
    //= install :: customer tab
    //==================================================

    private void installCustomerTabOn(ScNotebook book)
    {
        ScGroup group;
        group = new ScGroup();
        group.setFlavorList();
        group.setLabel("Customer");
        group.setTitle("Customer Contacts");
        group.css().flexChildFiller();
        group.hide();
        _customerTab = group;

        ScDiv body;
        body = group.getBody();
        body.css().pad10();

        ScDiv row;
        row = body.addDiv();
        row.css().flexRow().rowSpacer10();
        row.add(createCustomerContactList());

        book.addTab(group);
    }

    private ScControl createCustomerContactList()
    {
        ScCheckboxList<String> list;
        list = new ScCheckboxList<>();
        list.layoutBlockMultiColumn(200);
        list.disableChangeTracking();
        list.onChange(newUncheckedAction(this::handleCustomerJobListChanged));
        _customerContactList = list;

        ScDiv div;
        div = new ScDiv();
        div.add(list);
        div.hide();
        _customerWrapper = div;
        return div;
    }

    //==================================================
    //= install :: all
    //==================================================

    private void installAllTabOn(ScNotebook book)
    {
        ScGroup group;
        group = new ScGroup();
        group.setFlavorList();
        group.setLabel("All");
        group.setTitle("All Contacts");
        group.css().flexChildFiller();
        _allTab = group;

        ScDiv body;
        body = group.getBody();
        body.css().pad10();
        body.add(createAllContactList());

        book.addTab(group);
    }

    private ScControl createAllContactList()
    {
        ScCheckboxList<String> list;
        list = new ScCheckboxList<>();
        list.layoutBlockMultiColumn(200);
        list.disableChangeTracking();
        list.onChange(newUncheckedAction(this::handleAllListChanged));
        _allContactList = list;

        ScDiv div;
        div = new ScDiv();
        div.add(list);
        div.hide();
        _allWrapper = div;
        return div;
    }

    //==================================================
    //= install :: footer
    //==================================================

    private void installFooter()
    {
        ScDiv footer;
        footer = showFooter();
        footer.css().buttonBox();
        footer.addSubmitButton("Apply");
        footer.addCancelButton(newUncheckedAction(this::ajaxClose));
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        preRenderSummary();
        preRenderTabVisibility();
    }

    private void preRenderTabVisibility()
    {
        if ( hasSite() )
            _siteTab.show();

        if ( hasCustomer() )
            _customerTab.show();

        if ( hasProject() )
            _projectTab.show();
    }

    private void preRenderSummary()
    {
        String value = getCurrentEmails().join();
        _emailField.setValue(value);
    }

    //==================================================
    //= render :: common tab
    //==================================================

    private void preRenderCommonTab()
    {
        preRenderCommonProjectList();
        preRenderCommonSiteList();
        preRenderNotificationsList();
    }

    private void preRenderCommonProjectList()
    {
        KmList<ScOption<String>> options = getCommonProjectRecipientOptions();
        if ( options.isEmpty() )
            return;

        KmList<String> emails = getEmails();

        _commonProjectContactList.setOptions(options);
        _commonProjectContactList.setValue(emails);

        _commonProjectWrapper.show();
    }

    private void preRenderCommonSiteList()
    {
        KmList<ScOption<String>> options = getCommonSiteRecipientOptions();
        if ( options.isEmpty() )
            return;

        _commonSiteContactList.setOptions(options);
        _commonSiteContactList.setValue(getEmails());

        _commonSiteWrapper.show();
    }

    private void preRenderNotificationsList()
    {
        MyEmailTemplateContextType type = getEmailComposer().getContextType();
        switch ( type )
        {
            case Project:
                _projectContactsLink.show();
                return;

            case Site:
                _projectContactsLink.show();
                _customerContactsLink.show();
                _allContactsLink.show();
                return;
        }
    }

    //==================================================
    //= render :: other tabs
    //==================================================

    private void preRenderTab(ScControl tab)
    {
        if ( tab == _commonTab )
            preRenderCommonTab();

        if ( tab == _projectTab )
            preRenderProjectTab();

        if ( tab == _siteTab )
            preRenderSiteTab();

        if ( tab == _customerTab )
            preRenderCustomerTab();

        if ( tab == _allTab )
            preRenderAllTab();
    }

    private void preRenderProjectTab()
    {
        _projectTab.show();

        KmList<ScOption<String>> options = getProjectRecipientOptions();
        if ( options.isEmpty() )
            return;

        _projectContactList.setOptions(options);
        _projectContactList.setValue(getEmails());

        _projectWrapper.show();
    }

    private void preRenderCustomerTab()
    {
        _customerTab.show();

        KmList<ScOption<String>> options = getCustomerRecipientOptions();
        if ( options.isEmpty() )
            return;

        _customerContactList.setOptions(options);
        _customerContactList.setValue(getEmails());

        _customerWrapper.show();
    }

    private void preRenderSiteTab()
    {
        _siteTab.show();

        KmList<ScOption<String>> options = getSiteRecipientOptions();
        if ( options.isEmpty() )
            return;

        _siteContactList.setOptions(options);
        _siteContactList.setValue(getEmails());

        _siteWrapper.show();
    }

    private void preRenderAllTab()
    {
        KmList<ScOption<String>> options = getAllRecipientOptions();
        if ( options.isEmpty() )
            return;

        _allContactList.setOptions(options);
        _allContactList.setValue(getEmails());

        _allWrapper.show();
    }

    //##################################################
    //# context
    //##################################################

    private MyProject getProject()
    {
        return _emailComposer.findProject();
    }

    public boolean hasProject()
    {
        return getProject() != null;
    }

    private MySite getSite()
    {
        return _emailComposer.findSite();
    }

    private boolean hasSite()
    {
        return getSite() != null;
    }

    private MyCustomer getCustomer()
    {
        return null;
    }

    public boolean hasCustomer()
    {
        return getCustomer() != null;
    }

    //##################################################
    //# update summary
    //##################################################

    private void addEmailsToSelected(KmList<String> add)
    {
        KmList<String> emails;
        emails = getEmails();
        emails.addAll(add);
        normalizeEmails(emails);

        _emailField.setValue(emails.join());
    }

    private void normalizeEmails(KmList<String> emails)
    {
        emails.removeDuplicates();
        emails.removeNulls();
        emails.sort();
    }

    //##################################################
    //# handle
    //##################################################

    private void handleEmailChanged()
    {
        String s = _emailField.getValue();

        KmEmailAddressParser p;
        p = KmEmailAddressParser.staticParse(s);
        p.parse(s);

        if ( p.hasErrors() )
        {
            _emailField.addError("Invalid: %s.", p.getInvalidEmails().join());
            ajaxShowErrors();
        }
        else
            ajaxHideAllErrors();

        ajaxRefreshCurrentTab();
    }

    private void handleTabPreRender(ScControl tab)
    {
        preRenderTab(tab);
    }

    private void handleClearAll()
    {
        ajaxHideAllErrors();

        _emailField.clearValue();
        _emailField.ajaxClearFieldValue();

        ScControl tab;
        tab = _notebook.getSelectedTab();
        preRenderTab(tab);
        tab.ajaxUpdateFieldValues();
    }

    private void handleApply()
    {
        applyEmails();
        ajaxClose();
    }

    //==================================================
    //= handle :: common list changed
    //==================================================

    private void handleCommonProjectListChanged()
    {
        ajaxUpdateEmailFor(_commonProjectContactList, getCommonProjectRecipientOptions());
    }

    private void handleCommonSiteListChanged()
    {
        ajaxUpdateEmailFor(_commonSiteContactList, getCommonSiteRecipientOptions());
    }

    //==================================================
    //= handle :: other list changed
    //==================================================

    private void handleProjectListChanged()
    {
        ajaxUpdateEmailFor(_projectContactList, getProjectRecipientOptions());
    }

    private void handleSiteListChanged()
    {
        ajaxUpdateEmailFor(_siteContactList, getSiteRecipientOptions());
    }

    private void handleCustomerJobListChanged()
    {
        ajaxUpdateEmailFor(_customerContactList, getCustomerRecipientOptions());
    }

    private void handleAllListChanged()
    {
        ajaxUpdateEmailFor(_allContactList, getAllRecipientOptions());
    }

    //==================================================
    //= handle :: convenience
    //==================================================

    private void handleSelectProjectNotifications()
    {
        addProjectNotificationEmailsToSelected();
        ajaxRefreshCurrentTab();
        _emailField.ajaxReplace();
    }

    private void handleSelectCustomerNotifications()
    {
        addCustomerNotificationEmailsToSelected();
        ajaxRefreshCurrentTab();
        _emailField.ajaxReplace();
    }

    private void handleSelectAllNotifications()
    {
        addProjectNotificationEmailsToSelected();
        addCustomerNotificationEmailsToSelected();
        ajaxRefreshCurrentTab();
        _emailField.ajaxReplace();
    }

    private void addProjectNotificationEmailsToSelected()
    {
        MyProject project = getProject();

        KmList<MyProjectContact> contacts = project.getContactsByFullName();
        KmList<String> emails = contacts.collect(e -> e.getEmail());
        addEmailsToSelected(emails);
    }

    private void addCustomerNotificationEmailsToSelected()
    {
        MyCustomer customer = getCustomer();
        if ( customer == null )
            return;

        KmList<MyCustomerContact> contacts;
        contacts = customer.getContactsByFullName();

        KmList<String> emails = contacts.collect(e -> e.getEmail());
        addEmailsToSelected(emails);
    }

    //##################################################
    //# ajax select options
    //##################################################

    private void ajaxUpdateEmailFor(
        ScCheckboxList<String> checkboxList,
        KmList<ScOption<String>> options)
    {
        KmList<String> selections = checkboxList.getValue();
        KmList<String> optionValues = options.collect(e -> e.getValue());

        ajaxSelectOptions(selections, optionValues);
    }

    private void ajaxSelectOptions(KmList<String> selections, KmList<String> options)
    {
        KmList<String> v;
        v = getEmails();
        v.removeAll(options);
        v.addAllDistinct(selections);

        _emailField.ajaxSetFieldValue(v.join());
    }

    //##################################################
    //# ajax refresh
    //##################################################

    private void ajaxRefreshCurrentTab()
    {
        ScControl tab = _notebook.getSelectedTab();
        preRenderTab(tab);

        if ( tab == _commonTab )
            _commonTab.ajaxReplace();

        if ( tab == _projectTab )
            _projectTab.ajaxReplace();

        if ( tab == _siteTab )
            _siteTab.ajaxReplace();

        if ( tab == _customerTab )
            _customerTab.ajaxReplace();

        if ( tab == _allTab )
            _allTab.ajaxReplace();
    }

    //##################################################
    //# common options
    //##################################################

    private KmList<ScOption<String>> getCommonProjectRecipientOptions()
    {
        return hasProject()
            ? getCommonContactOptionsFor(getProjectContactTypes())
            : KmList.createEmpty();
    }

    private KmList<ScOption<String>> getCommonSiteRecipientOptions()
    {
        return hasSite()
            ? getCommonContactOptionsFor(getSiteContactTypes())
            : KmList.createEmpty();
    }

    private KmList<ScOption<String>> getCommonContactOptionsFor(
        KmList<MyDefaultRecipientContactType> types)
    {
        KmList<ScOption<String>> v = new KmList<>();
        for ( MyDefaultRecipientContactType e : types )
        {
            MyContactIF contact = getContactFor(e);
            if ( contact == null )
                continue;

            String email = contact.getEmail();
            if ( Kmu.isEmpty(email) )
                continue;

            String label = Kmu.format("%s (%s)", e.getLabel(), contact.getFullName());
            v.add(ScOption.create(email, label));
        }
        return v;
    }

    //##################################################
    //# domain options
    //##################################################

    private KmList<ScOption<String>> getProjectRecipientOptions()
    {
        MyProject project = getProject();
        if ( project == null )
            return KmList.createEmpty();

        KmList<MyProjectContact> contacts = project.getContactsByFullName();
        return toOptions(contacts);
    }

    private KmList<ScOption<String>> getSiteRecipientOptions()
    {
        MySite site = getSite();
        if ( site == null )
            return KmList.createEmpty();

        KmList<MySiteContact> contacts = getSite().getContactsByFullName();
        return toOptions(contacts);
    }

    private KmList<ScOption<String>> getCustomerRecipientOptions()
    {
        MyCustomer customer = getCustomer();
        if ( customer == null )
            return KmList.createEmpty();

        KmList<MyCustomerContact> contacts = customer.getContactsByFullName();
        return toOptions(contacts);
    }

    private KmList<ScOption<String>> getAllRecipientOptions()
    {
        KmList<ScOption<String>> v;
        v = new KmList<>();
        v.addAll(getSiteRecipientOptions());
        v.addAll(getCustomerRecipientOptions());
        v.addAll(getProjectRecipientOptions());
        v.removeIf(e -> !e.hasValue());
        v.removeDuplicates(e -> e.getText());
        v.sortOn(e -> e.getText());
        return v;
    }

    //##################################################
    //# recipient types
    //##################################################

    private KmList<MyDefaultRecipientContactType> getProjectContactTypes()
    {
        return MyDefaultRecipientUtility.getProjectRecipientContactTypes();
    }

    private KmList<MyDefaultRecipientContactType> getSiteContactTypes()
    {
        return MyDefaultRecipientUtility.getSiteRecipientContactTypes();
    }

    //##################################################
    //# abstract
    //##################################################

    protected abstract void applyEmails();

    protected abstract KmList<String> getCurrentEmails();

    //##################################################
    //# support
    //##################################################

    private MyContactIF getContactFor(MyDefaultRecipientContactType contactType)
    {
        MyEmailTemplateContextType type = _emailComposer.getContextType();
        switch ( type )
        {
            case Project:
                return getProjectContactFor(contactType);

            case Site:
                return getSiteContactFor(contactType);
        }
        throw Kmu.newEnumError(type);
    }

    private MyContactIF getProjectContactFor(MyDefaultRecipientContactType contactType)
    {
        switch ( contactType )
        {
            case ProjectSupport:
                return getProject().getSupportContact();

            case CustomerApproval:
            case CustomerBilling:
            case CustomerNotifications:
            case Install:
            case Main:
            case JobNotifications:
            case ProjectNotifications:
            case Requester:
            case Sales:
            case Scheduling:
            case Technical:
            case Custom:
                return null;
        }
        throw Kmu.newEnumError(contactType);
    }

    private MyContactIF getSiteContactFor(MyDefaultRecipientContactType contactType)
    {
        switch ( contactType )
        {
            case ProjectSupport:
                return getProject().getSupportContact();

            case CustomerApproval:
                return hasCustomer()
                    ? getCustomer().getApprovalContact()
                    : null;

            case CustomerBilling:
                return hasCustomer()
                    ? getCustomer().getBillingContact()
                    : null;

            case CustomerNotifications:
            case Main:
            case Install:
            case JobNotifications:
            case ProjectNotifications:
            case Requester:
            case Sales:
            case Scheduling:
            case Technical:
            case Custom:
                return null;
        }

        throw Kmu.newEnumError(contactType);
    }

    //##################################################
    //# support
    //##################################################

    private KmList<ScOption<String>> toOptions(KmList<? extends MyContactIF> contacts)
    {
        KmList<ScOption<String>> options;
        options = new KmList<>();

        for ( MyContactIF contact : contacts )
            if ( contact.hasEmail() )
                options.add(createOptionFor(contact));

        options.sortOn(e -> e.getText());
        return options;
    }

    private ScOption<String> createOptionFor(MyContactIF contact)
    {
        return ScOption.create(contact.getEmail(), formatLabel(contact));
    }

    private String formatLabel(MyContactIF c)
    {
        return c.getFullName();
    }

    protected KmList<String> getEmails()
    {
        String s = _emailField.getValue();
        return Kmu.parseEmails(s);
    }

    protected String formatEmails()
    {
        return getEmails().join();
    }
}
