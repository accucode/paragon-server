package com.app.ui.page.guide;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;
import com.kodemore.servlet.control.layout.ScLayout;
import com.kodemore.servlet.field.ScTextField;

import com.app.model.MyProject;
import com.app.model.MyTenant;
import com.app.model.MyUser;
import com.app.model.meta.MyMetaProject;
import com.app.ui.control.MyFormDialog;
import com.app.utility.MyAppNavigator;
import com.app.utility.MyGlobals;

public class MyAddProjectDialog
    extends MyFormDialog
{
    //##################################################
    //# variables
    //##################################################

    private ScTextField _nameField;
    private ScTextField _codeField;
    private ScTextField _companyNameField;
    private ScTextField _emailField;

    //##################################################
    //# singleton
    //##################################################

    private static MyAddProjectDialog _instance;

    public static void installInstance()
    {
        _instance = new MyAddProjectDialog();
    }

    public static MyAddProjectDialog getInstance()
    {
        return _instance;
    }

    //##################################################
    //# install
    //##################################################

    public MyAddProjectDialog()
    {
        setLabel("Add New Project");
        setWidth(750);
        onSubmit(newUncheckedAction(this::handleSave));
        getBody().add(createLayout());
        showFooter().add(createButtons());
    }

    private ScControl createLayout()
    {
        ScLayout e;
        e = new ScLayout();
        e.setTypeFieldset();
        e.add(createBasicSection());
        return e;
    }

    //==================================================
    //= install :: basics
    //==================================================

    private ScControl createBasicSection()
    {
        ScDiv e;
        e = new ScDiv();
        e.setLabel("Initial Setup");
        e.css().flexColumn().gap20();
        e.add(createRow1());
        e.add(createRow2());
        e.add(createRow3());
        return e;
    }

    //==================================================
    //= install :: row 1
    //==================================================

    private ScDiv createRow1()
    {
        ScDiv e;
        e = new ScDiv();
        e.css().flexRow().rowSpacer40();
        e.addFieldLayout().add(createNameField());
        e.addFieldLayout().add(createCodeField());
        return e;
    }

    private ScControl createNameField()
    {
        MyMetaProject x = MyProject.Meta;

        ScTextField e;
        e = x.Name.newField();
        e.setLabel("The Project Name");
        _nameField = e;
        return e;
    }

    private ScControl createCodeField()
    {
        MyMetaProject x = MyProject.Meta;

        ScTextField e;
        e = x.Code.newField();
        e.setLabel("The Project Code");
        _codeField = e;
        return e;
    }

    //==================================================
    //= install :: row 2
    //==================================================

    private ScDiv createRow2()
    {
        ScDiv e;
        e = new ScDiv();
        e.css().flexRow().rowSpacer40();
        e.addFieldLayout().add(createCompanyNameField());
        e.addFieldLayout().add(createEmailField());
        return e;
    }

    private ScControl createCompanyNameField()
    {
        MyMetaProject x = MyProject.Meta;

        ScTextField e;
        e = x.CompanyName.newField();
        e.setLabel("Your Company Name");
        _companyNameField = e;
        return e;
    }

    private ScControl createEmailField()
    {
        MyMetaProject x = MyProject.Meta;

        ScTextField e;
        e = x.SendEmailFrom.newField();
        e.setLabel("Send Email From");
        _emailField = e;
        return e;
    }

    //==================================================
    //= install :: row 3
    //==================================================

    private ScControl createRow3()
    {
        MyMetaProject x = MyProject.Meta;

        ScFieldLayout e;
        e = new ScFieldLayout();
        e.add(x.Description.newMultilineField());
        return e;
    }

    //==================================================
    //= install :: button
    //==================================================

    private ScControl createButtons()
    {
        ScDiv e;
        e = new ScDiv();
        e.css().flexRow().buttonBox();
        e.addSaveButton();
        e.addCancelButton(newUncheckedAction(this::ajaxClose));
        return e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        MyTenant tenant = getCurrentTenant();
        String email = MyGlobals.getProperties().getSendEmailFromAddress();

        _companyNameField.setValue(tenant.getName());
        _emailField.setValue(email);
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

        MyTenant tenant = getCurrentTenant();
        String name = field.getValue();

        boolean dup = getAccess().getProjectDao().isDuplicateName(tenant, name);
        if ( dup )
            field.addError("Duplicate.");
    }

    private void validateCode()
    {
        ScTextField field = _codeField;
        if ( field.hasErrors() )
            return;

        MyTenant tenant = getCurrentTenant();
        String code = field.getValue();

        boolean dup = getAccess().getProjectDao().isDuplicateCode(tenant, code);
        if ( dup )
            field.addError("Duplicate.");
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSave()
    {
        ajaxHideAllErrors();
        validateAndCheck();

        MyTenant tenant = getCurrentTenant();

        MyProject p;
        p = new MyProject();
        p.setTenant(tenant);
        p.applyTenantDefaults();
        p.applyFrom(this);
        p.createDefaultPriorities();
        p.setSupervisor(getCurrentUser());
        p.validateAndCheck();
        p.daoAttach();

        p.addManager(getCurrentUser());

        getAccess().flush();
        ajaxClose();

        MyProjectSetupHomePage nextPage = MyProjectSetupHomePage.getInstance();
        MyAppNavigator.ajaxSelectProject(p, nextPage);
    }

    //##################################################
    //# support
    //##################################################

    private MyTenant getCurrentTenant()
    {
        return MyGlobals.getCurrentTenant();
    }

    private MyUser getCurrentUser()
    {
        return MyGlobals.getCurrentUser();
    }
}
