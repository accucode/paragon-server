package com.app.ui.page.crud.appFeedback;

import java.util.function.Consumer;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScFormDialog;
import com.kodemore.servlet.field.ScDateField;
import com.kodemore.servlet.field.ScDomainDropdownField;
import com.kodemore.servlet.field.ScDynamicEnumDropdownField;
import com.kodemore.servlet.field.ScHiddenField;
import com.kodemore.servlet.field.ScTextArea;
import com.kodemore.time.KmClock;
import com.kodemore.time.KmDate;

import com.app.model.MyFeedback;
import com.app.model.MyTenant;
import com.app.model.MyUser;
import com.app.model.base.MyFeedbackStatus;
import com.app.model.meta.MyMetaFeedback;
import com.app.ui.control.MyFormDialog;
import com.app.utility.MyGlobals;

/**
 * I allow users to submit bug reports and feature requests.
 */
public class MyFeedbackCloseDialog
    extends MyFormDialog
{
    //##################################################
    //# variables
    //##################################################

    private ScHiddenField<String> _uidField;

    private ScDynamicEnumDropdownField _statusField;
    private ScDynamicEnumDropdownField _typeField;

    private ScDomainDropdownField<MyUser,String> _closedByField;
    private ScDateField                          _closedDateField;

    private Consumer<MyFeedback> _onClosedListener;

    //##################################################
    //# constructor
    //##################################################

    public MyFeedbackCloseDialog()
    {
        MyFormDialog dialog;
        dialog = this;
        dialog.setLabel("Resolve Feedback");

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
        body.css().gap();
        body.add(createUidField());

        ScFieldTable ft;
        ft = body.addFieldTable();
        ft.add(createStatusField());
        ft.add(createTypeField());
        ft.add(createClosedByField());
        ft.add(createClosedOnField());

        ScFieldLayout fl;
        fl = body.addFieldLayout();
        fl.add(createNotesField());
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

    private ScControl createUidField()
    {
        ScHiddenField<String> e;
        e = new ScHiddenField<>();
        _uidField = e;
        return e;
    }

    private ScControl createStatusField()
    {
        MyMetaFeedback x = MyFeedback.Meta;

        ScDynamicEnumDropdownField e;
        e = x.StatusCode.newDropdown();
        _statusField = e;
        return e;
    }

    private ScControl createTypeField()
    {
        MyMetaFeedback x = MyFeedback.Meta;

        ScDynamicEnumDropdownField e;
        e = x.TypeCode.newDropdown();
        e.setRequired();
        _typeField = e;
        return e;
    }

    private ScControl createClosedByField()
    {
        MyMetaFeedback x = MyFeedback.Meta;

        ScDomainDropdownField<MyUser,String> e;
        e = MyUser.Tools.newDomainDropdown();
        e.setMeta(x.ClosedBy);
        e.setOptionSupplier(this::findDevUsers);
        e.setRequired();
        _closedByField = e;
        return e;
    }

    private ScControl createClosedOnField()
    {
        MyMetaFeedback x = MyFeedback.Meta;

        ScDateField e;
        e = new ScDateField();
        e.setMeta(x.ClosedDate);
        e.setRequired();
        _closedDateField = e;
        return e;
    }

    private ScTextArea createNotesField()
    {
        MyMetaFeedback x = MyFeedback.Meta;

        ScTextArea e;
        e = x.Notes.newMultilineField();
        e.setLabel("Notes");
        e.disableChangeTracking();
        return e;
    }

    //==================================================
    //= install :: supplier
    //==================================================

    private KmList<MyUser> findDevUsers()
    {
        MyTenant t = getFeedback().getTenant();
        return t.getUsersByFullName().select(e -> e.isRoleDeveloper());
    }

    //##################################################
    //# on closed listener
    //##################################################

    public void onClosed(Consumer<MyFeedback> e)
    {
        _onClosedListener = e;
    }

    private void fireOnClosedListener(MyFeedback e)
    {
        fire(_onClosedListener, e);
    }

    //##################################################
    //# model
    //##################################################

    private MyFeedback getFeedback()
    {
        String uid = _uidField.getValue();
        return getAccess().findFeedbackUid(uid);
    }

    //##################################################
    //# ajax
    //##################################################

    public void ajaxOpen(MyFeedback e, MyFeedbackStatus status)
    {
        _uidField.setValue(e.getUid());
        _statusField.setValue(status);
        _typeField.setValue(e.getType());
        _closedByField.setValue(getCurrentUser());
        _closedDateField.setValue(getToday());

        super.ajaxOpen();
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSave()
    {
        validateAndCheck();

        MyFeedback e;
        e = getFeedback();
        e.applyFrom(this);

        fireOnClosedListener(e);

        ajaxClose();
    }

    //##################################################
    //# support
    //##################################################

    private MyUser getCurrentUser()
    {
        return MyGlobals.getCurrentUser();
    }

    private KmDate getToday()
    {
        return KmClock.getLocalDate();
    }
}
