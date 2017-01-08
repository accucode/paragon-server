package com.app.ui.layout;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.field.ScDropdownField;
import com.kodemore.time.KmTimeZone;

import com.app.ui.control.MyDialog;
import com.app.utility.MyGlobals;
import com.app.utility.MyUtility;

public class MyTimeZoneDialog
    extends MyDialog
{
    //##################################################
    //# variables
    //##################################################

    private ScDropdownField<String> _timeZoneField;

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
        getForm().setSubmitAction(this::handleSave);

        installBody();
        installFooter();
    }

    private void installBody()
    {
        ScDiv body;
        body = getBody();
        body.css().pad20();

        ScDiv row;
        row = body.addFlexRow();
        row.css().flexCrossAlignCenter().rowSpacer5();
        row.addLabel("Time Zone");
        row.add(createDropdown());
    }

    private void installFooter()
    {
        ScDiv footer;
        footer = showFooter().addButtonBox();
        footer.addSaveButton();
        footer.addCancelButton(this::ajaxClose);
    }

    private ScDropdownField<String> createDropdown()
    {
        ScDropdownField<String> e;
        e = MyUtility.newTimeZoneDropdown();
        e.setNullSelectPrefix();
        e.setRequired();
        e.setLabel("Time Zone");
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

        KmTimeZone zone = getCurrentTimeZone();
        if ( zone != null )
            _timeZoneField.setValue(zone.getCode());
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSave()
    {
        ajaxHideAllErrors();
        validate();

        String code = _timeZoneField.getValue();
        KmTimeZone zone = KmTimeZone.findCode(code);

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
