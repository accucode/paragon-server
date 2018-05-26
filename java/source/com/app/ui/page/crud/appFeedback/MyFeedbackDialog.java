package com.app.ui.page.crud.appFeedback;

import com.kodemore.servlet.ScBookmark;
import com.kodemore.servlet.ScPage;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScFormDialog;
import com.kodemore.servlet.field.ScTextArea;

import com.app.model.MyFeedback;
import com.app.model.MyProject;
import com.app.model.MyTenant;
import com.app.model.meta.MyMetaFeedback;
import com.app.ui.control.MyFormDialog;
import com.app.utility.MyGlobals;

/**
 * I allow users to submit bug reports and feature requests.
 */
public class MyFeedbackDialog
    extends MyFormDialog
{
    //##################################################
    //# variables
    //##################################################

    private ScTextArea _descriptionField;

    //##################################################
    //# constructor
    //##################################################

    public MyFeedbackDialog()
    {
        MyFormDialog dialog;
        dialog = this;
        dialog.setLabel("Report a Problem");

        installFormOn(dialog);
        installFieldsOn(dialog);
        installButtonsOn(dialog);
    }

    //##################################################
    //# install
    //##################################################

    private void installFormOn(MyFormDialog dialog)
    {
        ScForm form;
        form = dialog.getDialogRoot();
        form.onSubmit(newUncheckedAction(this::handleSave));
    }

    private void installFieldsOn(ScFormDialog dialog)
    {
        ScDiv body;
        body = dialog.getBody();
        body.css().pad().flexColumn().columnSpacer10();

        body.addText("Please describe the problem.");

        ScFieldLayout fields;
        fields = body.addFieldLayout();
        fields.add(createDescriptionField());
    }

    private void installButtonsOn(ScFormDialog dialog)
    {
        ScDiv footer;
        footer = dialog.showFooter();

        ScDiv buttons;
        buttons = footer.addButtonBox();
        buttons.addSubmitButton();
        buttons.addCancelButton(newUncheckedAction(this::ajaxClose));
    }

    //==================================================
    //= install :: fields
    //==================================================

    private ScTextArea createDescriptionField()
    {
        MyMetaFeedback x = MyFeedback.Meta;

        ScTextArea e;
        e = x.Description.newMultilineField();
        e.setLabel("Description");
        e.disableChangeTracking();
        e.setRequired();
        _descriptionField = e;
        return e;
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSave()
    {
        validateAndCheck();

        String description = _descriptionField.getValue();
        MyTenant tenant = getCurrentTenant();
        MyProject project = getCurrentProject();

        String key = getCurrentPageKey();
        String requestUrl = getRequestUrl();
        String windowLocation = getWindowLocation();
        String query = getQueryString();

        MyFeedback e;
        e = new MyFeedback();
        e.setDescription(description);
        e.setTenant(tenant);
        e.setProject(project);
        e.setPageKey(key);
        e.setRequestUrl(requestUrl);
        e.setWindowLocation(windowLocation);
        e.setQueryString(query);
        e.daoAttach();

        e.sendEmail();

        ajaxClose();
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        super.validate();

    }

    //##################################################
    //# support
    //##################################################

    private String getCurrentPageKey()
    {
        return getData().getCurrentPageKey();
    }

    private String getRequestUrl()
    {
        return getData().getFullRequestUrl();
    }

    private String getWindowLocation()
    {
        return getData().getWindowLocation();
    }

    private String getQueryString()
    {
        ScPage page = getData().getCurrentPage();
        ScBookmark bm = page.getBookmark();
        return bm.formatQueryString();
    }

    private MyTenant getCurrentTenant()
    {
        return MyGlobals.getCurrentTenant();
    }

    private MyProject getCurrentProject()
    {
        return MyGlobals.getCurrentProject();
    }
}
