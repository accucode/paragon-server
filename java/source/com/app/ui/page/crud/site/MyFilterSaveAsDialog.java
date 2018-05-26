package com.app.ui.page.crud.site;

import java.util.function.Consumer;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.field.ScHiddenField;
import com.kodemore.servlet.field.ScTextField;

import com.app.criteria.MyFilterTemplateCriteria;
import com.app.model.MyFilterTemplate;
import com.app.model.meta.MyMetaFilterTemplate;
import com.app.ui.control.MyFormDialog;

public class MyFilterSaveAsDialog
    extends MyFormDialog
{
    //##################################################
    //# variables
    //##################################################

    private ScHiddenField<String>      _templateJsonField;
    private ScTextField                _nameField;
    private Consumer<MyFilterTemplate> _savedListener;

    //##################################################
    //# constructor
    //##################################################

    public MyFilterSaveAsDialog()
    {
        install();
    }

    //##################################################
    //# install
    //##################################################

    public void install()
    {
        setLabel("Save As...");
        onSubmit(newUncheckedAction(this::handleSave));

        ScDiv body;
        body = getBody();
        body.css().pad();
        body.add(createTemplateJsonField());
        body.addFieldLayout().add(createNameField());

        ScDiv footer;
        footer = showFooter();
        footer.css().buttonBox();
        footer.addSaveButton();
        footer.addCancelButton(newUncheckedAction(this::ajaxClose));
    }

    private ScControl createTemplateJsonField()
    {
        ScHiddenField<String> e;
        e = new ScHiddenField<>();
        _templateJsonField = e;
        return e;
    }

    private ScControl createNameField()
    {
        MyMetaFilterTemplate x = MyFilterTemplate.Meta;

        ScTextField e;
        e = new ScTextField();
        e.setLabel("Filter Name");
        e.setValidator(x.Name);
        e.disableChangeTracking();
        _nameField = e;
        return e;
    }

    //##################################################
    //# listener
    //##################################################

    public void onSaved(Consumer<MyFilterTemplate> e)
    {
        _savedListener = e;
    }

    private void fireSaved(MyFilterTemplate e)
    {
        fire(_savedListener, e);
    }

    //##################################################
    //# open
    //##################################################

    public void ajaxOpen(MyFilterTemplate template)
    {
        _templateJsonField.setValue(template.toJson());
        _nameField.setValue(template.getName());

        ajaxOpen();
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSave()
    {
        ajaxHideAllErrors();
        validateAndCheck();
        fireSaved(save());
        ajaxClose();
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        super.validate();

        validateName();
    }

    private void validateName()
    {
        ScTextField field = _nameField;
        if ( field.hasErrors() )
            return;

        MyFilterTemplate template = getDetachedTemplate();
        String name = field.getValue();

        MyFilterTemplateCriteria c;
        c = getAccess().getFilterTemplateDao().createCriteria();
        c.whereProjectIs(template.getProject());
        c.whereContextTypeIs(template.getContextType());
        c.whereModified().isFalse();
        c.whereName().is(name);

        boolean dup = c.exists();
        if ( dup )
            field.addError("Duplicate.");
    }

    //##################################################
    //# support
    //##################################################

    private MyFilterTemplate getDetachedTemplate()
    {
        String json = _templateJsonField.getValue();

        MyFilterTemplate e;
        e = new MyFilterTemplate();
        e.fromJson(json, true);
        return e;
    }

    private MyFilterTemplate save()
    {
        String name = _nameField.getValue();

        MyFilterTemplate oldTemplate;
        oldTemplate = getDetachedTemplate();

        MyFilterTemplate newTemplate;
        newTemplate = new MyFilterTemplate();
        newTemplate.applyFrom(oldTemplate, false);
        newTemplate.setTypeShared();
        newTemplate.setName(name);
        newTemplate.setModified(false);
        newTemplate.setPreferred(false);
        newTemplate.daoAttach();
        return newTemplate;
    }

}
