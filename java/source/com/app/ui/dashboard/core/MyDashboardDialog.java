package com.app.ui.dashboard.core;

import com.kodemore.collection.KmIntegerRange;
import com.kodemore.collection.KmList;
import com.kodemore.meta.KmMetaIntegerProperty;
import com.kodemore.meta.KmMetaStringProperty;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.field.ScChoiceField;
import com.kodemore.servlet.field.ScEnumChoiceField;
import com.kodemore.servlet.field.ScIntegerField;
import com.kodemore.servlet.field.ScStaticEnumDropdownField;
import com.kodemore.utility.KmEnumIF;

import com.app.model.MyMember;
import com.app.model.MyProject;
import com.app.model.MyUser;
import com.app.model.meta.MyMetaMember;
import com.app.ui.control.MyFormDialog;
import com.app.utility.MyGlobals;

public class MyDashboardDialog
    extends MyFormDialog
{
    //##################################################
    //# variables
    //##################################################

    private ScAction              _updateSampleAction;
    private MyDashboardSampleView _sampleView;

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
        form = getDialogRoot();
        form.onSubmit(newUncheckedAction(this::handleSave));
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
        MyMetaMember x = MyMember.Meta;

        ScDiv col;
        col = root.addDiv();
        col.css().flexColumn().columnSpacer20();

        ScFieldTable fields;
        fields = col.addFieldTable();
        fields.add(createDashboardOrientationField());

        fields = col.addFieldTable();
        _lineCountField1 = fields.add(newDashboardLineCountField("Line 1", x.DashboardLineCount1));
        _lineCountField2 = fields.add(newDashboardLineCountField("Line 2", x.DashboardLineCount2));
        _lineCountFieldTable = fields;

        fields = col.addFieldTable();
        fields.add(createDashboardPanelField("Panel A", x.DashboardPanelCodeA));
        fields.add(createDashboardPanelField("Panel B", x.DashboardPanelCodeB));
        fields.add(createDashboardPanelField("Panel C", x.DashboardPanelCodeC));
        fields.add(createDashboardPanelField("Panel D", x.DashboardPanelCodeD));
        fields.add(createDashboardPanelField("Panel E", x.DashboardPanelCodeE));
        fields.add(createDashboardPanelField("Panel F", x.DashboardPanelCodeF));

        fields = col.addFieldTable();
        fields.add(createRefreshField());
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
        buttons.addCancelButton(newUncheckedAction(this::ajaxClose));
    }

    //==================================================
    //= install :: fields
    //==================================================

    private ScEnumChoiceField createDashboardOrientationField()
    {
        MyMetaMember x = MyMember.Meta;

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
        KmMetaIntegerProperty<MyMember> prop)
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

    private ScStaticEnumDropdownField createDashboardPanelField(
        String label,
        KmMetaStringProperty<MyMember> prop)
    {
        ScStaticEnumDropdownField e;
        e = new ScStaticEnumDropdownField();
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

    private ScControl createRefreshField()
    {
        MyMetaMember x = MyMember.Meta;

        ScIntegerField e;
        e = new ScIntegerField();
        e.setLabel("Refresh Minutes");
        e.setHelp(x.DashboardRefreshMinutes);
        e.setValueAdaptor(x.DashboardRefreshMinutes);
        e.setValidator(x.DashboardRefreshMinutes);
        return e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        MyMember member = getMember();

        configureLineCountLabels(member);
        configureSample(member);

        applyFromModel(member);
    }

    //##################################################
    //# handle
    //##################################################

    private void handleDashboardChanged()
    {
        MyMember temp;
        temp = new MyMember();
        temp.applyFrom(this);

        configureLineCountLabels(temp);
        _lineCountFieldTable.ajaxReplace();

        configureSample(temp);
        _sampleView.ajaxReplace();
    }

    private void handleSave()
    {
        MyMember e;
        e = getMember();
        e.applyFrom(this);
        e.validateAndCheck();

        ajaxClose();
        getData().getCurrentPage().ajaxPrint();
    }

    //##################################################
    //# support
    //##################################################

    private MyMember getMember()
    {
        MyProject project = MyGlobals.getCurrentProject();
        MyUser user = MyGlobals.getCurrentUser();

        return project.getMemberFor(user);
    }

    private void configureLineCountLabels(MyMember m)
    {
        _lineCountField1.setLabel(formatLineLabel(m, 1));
        _lineCountField2.setLabel(formatLineLabel(m, 2));
    }

    private void configureSample(MyMember e)
    {
        _sampleView.setOrientationType(e.getDashboardOrientationType());
        _sampleView.setLineCount1(e.getDashboardLineCount1());
        _sampleView.setLineCount2(e.getDashboardLineCount2());
    }

    private String formatLineLabel(MyMember m, int line)
    {
        String prefix = "Line";

        MyDashboardOrientationType type = m.getDashboardOrientationType();
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
