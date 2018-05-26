package com.app.ui.layout;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.field.ScDropdownField;
import com.kodemore.servlet.field.ScTimeZoneCodeField;
import com.kodemore.time.KmTimeZone;

import com.app.ui.control.MyFormDialog;
import com.app.utility.MyGlobals;

public class MyTimeZoneDialog
    extends MyFormDialog
{
    //##################################################
    //# variables
    //##################################################

    private ScTimeZoneCodeField _timeZoneField;

    //##################################################
    //# constructor
    //##################################################

    public MyTimeZoneDialog()
    {
        install();
    }

    //##################################################
    //# install
    //##################################################

    private void install()
    {
        setLabel("Change Time Zone");
        ScForm r = getDialogRoot();
        r.onSubmit(newUncheckedAction(this::handleSave));

        installBody();
        installFooter();
    }

    private void installBody()
    {
        ScDiv body;
        body = getBody();
        body.css().pad20();

        ScDiv row;
        row = body.addDiv();
        row.css().flexRow().rowSpacer5().flexCrossAlignCenter();
        row.addLabel("Time Zone");
        row.add(createDropdown());
    }

    private void installFooter()
    {
        ScDiv footer;
        footer = showFooter().addButtonBox();
        footer.addSaveButton();
        footer.addCancelButton(newUncheckedAction(this::ajaxClose));
    }

    private ScDropdownField<String> createDropdown()
    {
        ScTimeZoneCodeField e;
        e = new ScTimeZoneCodeField();
        e.setNullSelectPrefix();
        e.setRequired();
        _timeZoneField = e;
        return e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        _timeZoneField.setTimeZone(getCurrentTimeZone());
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSave()
    {
        ajaxHideAllErrors();
        validateAndCheck();

        KmTimeZone zone = _timeZoneField.getTimeZone();

        MyGlobals.getCurrentUser().setTimeZone(zone);
        getAccess().flush();

        MyPageLayout.getInstance().ajaxRefreshHeader();
        getData().getCurrentPage().ajaxPrint();

        ajaxClose();
    }

    //##################################################
    //# support
    //##################################################

    private KmTimeZone getCurrentTimeZone()
    {
        return MyGlobals.getCurrentUser().getTimeZone();
    }
}
