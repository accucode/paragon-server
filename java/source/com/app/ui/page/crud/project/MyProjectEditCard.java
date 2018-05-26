package com.app.ui.page.crud.project;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldText;
import com.kodemore.servlet.control.ScLink;
import com.kodemore.servlet.control.layout.ScLayout;
import com.kodemore.servlet.field.ScCheckboxList;
import com.kodemore.servlet.field.ScDomainDropdownField;
import com.kodemore.servlet.field.ScTextField;

import com.app.model.MyMember;
import com.app.model.MyPriority;
import com.app.model.MyProject;
import com.app.model.MyProjectContact;
import com.app.model.MyUser;
import com.app.model.meta.MyMetaProject;
import com.app.ui.dialog.MyConfirmDialog;
import com.app.ui.dialog.MyDialogs;
import com.app.ui.page.crud.abstractBase.MyCrudEditCard2;
import com.app.ui.selector.MyMemberSelector;

public class MyProjectEditCard
    extends MyCrudEditCard2<MyProject>
{
    //##################################################
    //# variables
    //##################################################

    private ScTextField      _nameField;
    private MyMemberSelector _supervisorField;

    private ScFieldText _codeText;
    private ScLink      _editCodeLink;
    private ScTextField _codeField;

    private ScCheckboxList<String> _managerList;

    private ScAction _editCodeAction;

    //##################################################
    //# constructor
    //##################################################

    public MyProjectEditCard()
    {
        super(new MyProjectBuilder());
    }

    public MyProjectEditCard(MyProjectBuilder e)
    {
        super(e);
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installBody(ScDiv body)
    {
        body.add(createLayout());
        _editCodeAction = newUncheckedAction(this::handleEditCode);
    }

    private ScControl createLayout()
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
        e.add(createNameField());
        e.add(createCodeRow());
        e.addSpace();
        e.add(createSupervisorField());
        e.addField(x.CompanyName);
        return e;
    }

    private ScControl createNameField()
    {
        MyMetaProject x = MyProject.Meta;

        ScTextField e;
        e = x.Name.newField();
        _nameField = e;
        return e;
    }

    private ScControl createSupervisorField()
    {
        MyMetaProject x = MyProject.Meta;

        MyMemberSelector e;
        e = new MyMemberSelector();
        e.setMeta(x.Supervisor);
        _supervisorField = e;
        return e;
    }

    //==================================================
    //= install :: code row
    //==================================================

    private ScControl createCodeRow()
    {
        ScDiv e;
        e = new ScDiv();
        e.setLabel("Code");
        e.css().flexRow().rowSpacer5();
        e.add(createCodeField());
        e.add(createCodeText());
        e.add(createEditCodeLink());
        return e;
    }

    private ScControl createCodeField()
    {
        MyMetaProject x = MyProject.Meta;

        ScTextField e;
        e = x.Code.newField();
        e.clearValueAdaptor();
        e.hide();
        _codeField = e;
        return e;
    }

    private ScControl createCodeText()
    {
        MyMetaProject x = MyProject.Meta;

        ScFieldText e;
        e = x.Code.newFieldText();
        _codeText = e;
        return e;
    }

    private ScControl createEditCodeLink()
    {
        ScLink e;
        e = new ScLink();
        e.setText("edit");
        e.setAction(newUncheckedAction(this::handleConfirmEditCode));
        _editCodeLink = e;
        return e;
    }

    //==================================================
    //= install :: description
    //==================================================

    private ScControl createDescriptionSection()
    {
        MyMetaProject x = MyProject.Meta;

        return x.Description.newMultilineField();
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
        e.add(createSupportContactField());
        e.addField(x.SendEmailFrom);
        return e;
    }

    private ScControl createSupportContactField()
    {
        MyMetaProject x = MyProject.Meta;

        ScDomainDropdownField<MyProjectContact,String> e;
        e = MyProjectContact.Tools.newDomainDropdown();
        e.setLabel(x.SupportContact);
        e.setHelp(x.SupportContact);
        e.setValueAdaptor(x.SupportContact);
        e.setNullNonePrefix();
        e.setOptionSupplier(this::findSupportContacts);
        return e;
    }

    private KmList<MyProjectContact> findSupportContacts()
    {
        return getDomainChild().getContactsByFullName();
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
        e.add(x.TimeZoneCode.newTimeZoneDropdown());
        e.addSpace();
        e.addField(x.BusinessDays, "Days");
        e.addField(x.BusinessStartTime, "Start Time");
        e.addField(x.BusinessEndTime, "End Time");
        return e;
    }

    //==================================================
    //= install :: tasks
    //==================================================

    private ScControl createTasksSection()
    {
        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("Tasks");
        e.add(createDefaultPriorityField());
        return e;
    }

    private ScControl createDefaultPriorityField()
    {
        MyMetaProject x = MyProject.Meta;

        ScDomainDropdownField<MyPriority,String> e;
        e = MyPriority.Tools.newDomainDropdown();
        e.setLabel("Default Priority");
        e.setOptionSupplier(this::findPriorities);
        e.setValueAdaptor(x.DefaultPriority);
        e.setNullSelectPrefix();
        e.setRequired();
        return e;
    }

    //==================================================
    //= install :: site numbers
    //==================================================

    private ScControl createSiteNumberSection()
    {
        MyMetaProject x = MyProject.Meta;

        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("Automatic Site Numbers");
        e.addField(x.AutoSiteNumberEnabled, "Enabled");
        e.addField(x.AutoSiteNumberPrefix, "Prefix");
        e.addField(x.AutoSiteNumberPadding, "Padding");
        e.addField(x.NextAutoSiteNumber, "Next Value");
        return e;
    }

    //==================================================
    //= install :: managers
    //==================================================

    private ScControl createManagersSection()
    {
        ScCheckboxList<String> e;
        e = new ScCheckboxList<>();
        e.setLabel("Managers");
        _managerList = e;
        return e;
    }

    //==================================================
    //= install :: filters
    //==================================================

    private KmList<MyPriority> findPriorities()
    {
        MyProject project = getDomainChild();
        return project.getPriorityListBySequence();
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRenderDetails(MyProject project)
    {
        super.preRenderDetails(project);

        _codeField.setValue(project.getCode());
        _supervisorField.setProject(project);

        preRenderManagersFor(project);
    }

    private void preRenderManagersFor(MyProject project)
    {
        KmList<MyUser> all = findActiveUsers();
        for ( MyUser user : all )
            _managerList.addOption(user.getUid(), user.getFullName());

        KmList<MyMember> managers = project.getManagersByName();
        KmList<String> uids = managers.collect(e -> e.getUser().getUid());
        _managerList.setValue(uids);
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        super.validate();

        validateName();
        validateCode();
    }

    private void validateName()
    {
        ScTextField field = _nameField;
        if ( field.hasErrors() )
            return;

        MyProject project = getDomainChild();
        String name = field.getValue();

        boolean dup = getAccess().getProjectDao().isDuplicateName(project, name);
        if ( dup )
            field.addError("Duplicate.");
    }

    private void validateCode()
    {
        ScTextField field = _codeField;
        if ( field.hasErrors() )
            return;

        MyProject project = getDomainChild();
        String code = field.getValue();

        boolean dup = getAccess().getProjectDao().isDuplicateCode(project, code);
        if ( dup )
            field.addError("Duplicate.");
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected void saveDomainChild(MyProject e)
    {
        String code = _codeField.getValue();

        e.applyFrom(this);
        e.setCode(code);
        updateManagersFor(e);
    }

    private void updateManagersFor(MyProject project)
    {
        KmList<String> userUids = _managerList.getValue();
        KmList<MyUser> all = findActiveUsers();
        KmList<MyUser> selected = all.select(e -> userUids.contains(e.getUid()));

        for ( MyUser user : all )
            if ( selected.contains(user) )
                enableManager(project, user);
            else
                disableManager(project, user);
    }

    private void enableManager(MyProject project, MyUser user)
    {
        MyMember e = project.getMemberFor(user);
        if ( e == null )
        {
            e = project.addMember();
            e.setUser(user);
            e.setRoleManager();
            e.daoAttach();
            return;
        }

        e.setRoleManager();
    }

    private void disableManager(MyProject project, MyUser user)
    {
        MyMember e = project.getMemberFor(user);
        if ( e == null )
            return;

        if ( e.isRoleManager() )
            e.setRoleWorker();
    }

    //##################################################
    //# support
    //##################################################

    private KmList<MyUser> findActiveUsers()
    {
        MyProject project = getDomainChild();
        return project.getTenant().getEnabledUsersByFullName();
    }

    //##################################################
    //# handle
    //##################################################

    private void handleConfirmEditCode()
    {
        String msg = ""
            + "The project code is used throughout the project as a prefix for various "
            + "documents including Jobs and Tickets. The new project code will only be "
            + "reflected on new documents. Historical data will NOT be changed.";

        MyConfirmDialog e;
        e = MyDialogs.getConfirmDialog();
        e.setTitle("Edit Project Code?");
        e.setSubtitle("Are you sure you want to edit the project code?");
        e.setMessage(msg);
        e.setPositiveAction(_editCodeAction);
        e.ajaxOpen();
    }

    private void handleEditCode()
    {
        _codeField.ajaxShow();

        _codeText.ajaxHide();
        _editCodeLink.ajaxHide();
    }
}
