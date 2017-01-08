package com.app.ui.dashboard.core;

import com.kodemore.collection.KmIntegerRange;
import com.kodemore.collection.KmList;
import com.kodemore.meta.KmMetaIntegerProperty;
import com.kodemore.meta.KmMetaStringProperty;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.field.ScChoiceField;
import com.kodemore.servlet.field.ScEnumChoiceField;
import com.kodemore.servlet.field.ScEnumDropdownField;
import com.kodemore.utility.KmEnumIF;

import com.app.model.MyUser;
import com.app.model.meta.MyMetaUser;
import com.app.ui.control.MyDialog;

public class MyDashboardDialog
    extends MyDialog
{
    //##################################################
    //# variables
    //##################################################

    private ScAction               _updateSampleAction;
    private MyDashboardSampleView  _sampleView;

    private ScFieldTable           _lineCountFieldTable;
    private ScChoiceField<Integer> _lineCountField1;
    private ScChoiceField<Integer> _lineCountField2;

    //##################################################
    //# constructor
    //##################################################

    public MyDashboardDialog()
    {
        install();
    }

    //##################################################
    //# install
    //##################################################

    private void install()
    {
        setLabel("Configure Dashboard");

        _updateSampleAction = newUncheckedAction(this::handleDashboardChanged);

        installForm();
        installBody();
        installFooter();
    }

    private void installForm()
    {
        ScForm form;
        form = getForm();
        form.setSubmitAction(this::handleSave);
    }

    private void installBody()
    {
        ScDiv body;
        body = getBody();
        body.css().flexRow().rowSpacer20().pad20();

        installDashboardFieldsOn(body);
        installDashboardSampleOn(body);
    }

    private void installDashboardFieldsOn(ScDiv root)
    {
        MyMetaUser x = MyUser.Meta;

        ScDiv col;
        col = root.addFlexColumn();
        col.css().columnSpacer20();

        ScFieldTable fields;
        fields = col.addFieldTable();
        fields.setFullWidth(false);
        fields.add(createDashboardOrientationField());

        fields = col.addFieldTable();
        fields.setFullWidth(false);
        _lineCountField1 = fields.add(newDashboardLineCountField("Line 1", x.DashboardLineCount1));
        _lineCountField2 = fields.add(newDashboardLineCountField("Line 2", x.DashboardLineCount2));
        _lineCountFieldTable = fields;

        fields = col.addFieldTable();
        fields.setFullWidth(false);
        fields.add(createDashboardPanelField("Panel A", x.DashboardPanelCodeA));
        fields.add(createDashboardPanelField("Panel B", x.DashboardPanelCodeB));
        fields.add(createDashboardPanelField("Panel C", x.DashboardPanelCodeC));
        fields.add(createDashboardPanelField("Panel D", x.DashboardPanelCodeD));
        fields.add(createDashboardPanelField("Panel E", x.DashboardPanelCodeE));
        fields.add(createDashboardPanelField("Panel F", x.DashboardPanelCodeF));
    }

    private void installDashboardSampleOn(ScDiv root)
    {
        MyDashboardSampleView e;
        e = new MyDashboardSampleView();
        root.add(e);

        _sampleView = e;
    }

    private void installFooter()
    {
        ScDiv footer;
        footer = showFooter();

        ScDiv buttons;
        buttons = footer.addButtonBox();
        buttons.addSaveButton();
        buttons.addCancelButton(this::ajaxClose);
    }

    //==================================================
    //= install :: fields
    //==================================================

    private ScEnumChoiceField createDashboardOrientationField()
    {
        MyMetaUser x = MyUser.Meta;

        ScEnumChoiceField e;
        e = new ScEnumChoiceField();
        e.setLabel("Orientation");
        e.setHelp(x.DashboardOrientationTypeCode);
        e.setValueAdaptor(x.DashboardOrientationTypeCode);
        e.setValidator(x.DashboardOrientationTypeCode);
        e.onChange(_updateSampleAction);
        e.addOption(MyDashboardOrientationType.Auto);
        e.addOption(MyDashboardOrientationType.Landsapce);
        e.addOption(MyDashboardOrientationType.Portrait);
        return e;
    }

    private ScChoiceField<Integer> newDashboardLineCountField(
        String label,
        KmMetaIntegerProperty<MyUser> prop)
    {
        ScChoiceField<Integer> e;
        e = new ScChoiceField<>();
        e.setLabel(label);
        e.setHelp(prop);
        e.setValueAdaptor(prop);
        e.setValidator(prop);
        e.onChange(_updateSampleAction);

        KmIntegerRange options = new KmIntegerRange(0, 3);
        for ( Integer option : options )
            e.addOption(option);

        return e;
    }

    private ScEnumDropdownField createDashboardPanelField(
        String label,
        KmMetaStringProperty<MyUser> prop)
    {
        ScEnumDropdownField e;
        e = new ScEnumDropdownField();
        e.setLabel(label);
        e.setHelp(prop);
        e.setValueAdaptor(prop);
        e.setValidator(prop);

        for ( KmEnumIF opt : getOptions() )
            e.addOption(opt);

        if ( e.isRequired() )
            e.setNullSelectPrefix();
        else
            e.setNullNonePrefix();

        return e;
    }

    private KmList<MyDashboardPanelType> getOptions()
    {
        return MyDashboardPanelType.getValues().select(e -> e.isPublic());
    }

    //##################################################
    //# print
    //##################################################

    @Override
    public void preRender()
    {
        super.preRender();

        MyUser user = getUser();

        configureLineCountLabels(user);
        configureSample(user);

        applyFromModel(user);
    }

    //##################################################
    //# handle
    //##################################################

    private void handleDashboardChanged()
    {
        MyUser temp;
        temp = new MyUser();
        temp.applyFrom(this);

        configureLineCountLabels(temp);
        _lineCountFieldTable.ajaxReplace();

        configureSample(temp);
        _sampleView.ajaxReplace();
    }

    private void handleSave()
    {
        MyUser e;
        e = getUser();
        e.applyFrom(this);
        e.validate();

        ajaxClose();
        getData().getCurrentPage().ajaxPrint();
    }

    //##################################################
    //# support
    //##################################################

    private MyUser getUser()
    {
        return getGlobals().getCurrentUser();
    }

    private void configureLineCountLabels(MyUser u)
    {
        _lineCountField1.setLabel(formatLineLabel(u, 1));
        _lineCountField2.setLabel(formatLineLabel(u, 2));
    }

    private void configureSample(MyUser e)
    {
        _sampleView.setOrientationType(e.getDashboardOrientationType());
        _sampleView.setLineCount1(e.getDashboardLineCount1());
        _sampleView.setLineCount2(e.getDashboardLineCount2());
    }

    private String formatLineLabel(MyUser u, int line)
    {
        String prefix = "Line";

        MyDashboardOrientationType type = u.getDashboardOrientationType();
        switch ( type )
        {
            case Auto:
            case Landsapce:
                prefix = "Row";
                break;

            case Portrait:
                prefix = "Column";
                break;
        }

        return prefix + " " + line;
    }

}
