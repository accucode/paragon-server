package com.app.ui.page.crud.transfer;

import com.kodemore.collection.KmList;
import com.kodemore.domain.KmUidDomainIF;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldText;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScTextSpan;
import com.kodemore.servlet.field.ScCheckboxList;
import com.kodemore.servlet.field.ScDomainDropdownField;
import com.kodemore.servlet.field.ScOption;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoAccess;
import com.app.model.MyProject;
import com.app.model.MyTenant;
import com.app.ui.dialog.MyDialogs;
import com.app.ui.dialog.MyNotifyDialog;
import com.app.utility.MyGlobals;

public abstract class MyAbstractTransferView<T extends KmUidDomainIF>
    extends ScDiv
{
    //##################################################
    //# variables
    //##################################################

    private ScFieldText                             _targetProjectText;
    private ScDomainDropdownField<MyProject,String> _sourceProjectField;

    private ScGroup                _newValueGroup;
    private ScTextSpan             _newValueHeaderMessage;
    private ScCheckboxList<String> _newValueList;

    private ScGroup                _existingValueGroup;
    private ScTextSpan             _existingValueHeaderMessage;
    private ScCheckboxList<String> _existingValueList;

    //##################################################
    //# constructor
    //##################################################

    public MyAbstractTransferView()
    {
        install();
    }

    //##################################################
    //# install
    //##################################################

    private void install()
    {
        ScDiv root;
        root = this;
        root.css().flexColumn().columnSpacer20();
        root.add(createProjectList());

        ScDiv row;
        row = root.addDiv();
        row.css().flexChildFiller0().flexRow().rowSpacer20();
        row.add(createNewValueGroup());
        row.add(createExistingValueGroup());
    }

    //==================================================
    //= install :: project list
    //==================================================

    private ScControl createProjectList()
    {
        ScGroup group;
        group = new ScGroup();
        group.setTitle("Project");

        ScDiv body;
        body = group.getBody();
        body.css().flexRow().flexCrossAlignCenter().rowSpacer20().pad();
        body.addFieldLayout().add(createTargetProjectText());
        body.addFieldLayout().add(createSourceProjectField());
        installAdditionalFieldsOn(body);
        body.addFlexChildFiller();
        body.add(createImportButton());

        return group;
    }

    /**
     * @param e
     */
    protected void installAdditionalFieldsOn(ScDiv e)
    {
        //subclass
    }

    private ScControl createTargetProjectText()
    {
        ScFieldText e;
        e = new ScFieldText();
        e.setLabel("Update Current Project");
        _targetProjectText = e;
        return e;
    }

    private ScControl createSourceProjectField()
    {
        ScDomainDropdownField<MyProject,String> field;
        field = MyProject.Tools.newDomainDropdown();
        field.setLabel("Transfer From Project");
        field.setHelp("The project from which the values will be transfered (copied).");
        field.setNullSelectPrefix();
        field.setOptionSupplier(this::findAvailableProjects);
        field.setOptionLabelFunction(e -> e.getName());
        field.onChange(newUncheckedAction(this::handleSelectProject));
        field.disableChangeTracking();
        field.setRequired();
        _sourceProjectField = field;
        return field;
    }

    private ScControl createImportButton()
    {
        ScActionButton e;
        e = new ScActionButton();
        e.setText("Import Selected Values");
        e.setHelp("Add or Update all of the values selected below.");
        e.setAction(newCheckedAction(this::handleImport));
        return e;

    }
    //==================================================
    //= install :: new value list
    //==================================================

    private ScControl createNewValueGroup()
    {
        ScGroup group;
        group = new ScGroup();
        group.setTitle("New Values");
        group.css().flexChildFiller0();
        group.hide();

        ScDiv header;
        header = group.showHeader();
        header.css().flexRow().flexAlignSpaced().pad();
        header.add(createNewValueHeaderMessage());

        ScDiv links;
        links = header.addDiv();
        links.css().flexRow().rowSpacer5();
        links.addBold("Select");
        links.addLink("All", newCheckedAction(this::handleSelectAllNewValues));
        links.addLink("None", newCheckedAction(this::handleSelectNoNewValues));

        ScDiv body;
        body = group.getBody();
        body.css().pad10().auto();
        body.add(createNewValueList());

        _newValueGroup = group;
        return group;
    }

    private ScControl createNewValueHeaderMessage()
    {
        ScTextSpan e = new ScTextSpan();
        _newValueHeaderMessage = e;
        return e;
    }

    private ScControl createNewValueList()
    {
        ScCheckboxList<String> e;
        e = new ScCheckboxList<>();
        e.disableChangeTracking();
        _newValueList = e;
        return e;
    }

    //==================================================
    //= install :: existing values
    //==================================================

    private ScControl createExistingValueGroup()
    {
        ScGroup group;
        group = new ScGroup();
        group.setTitle("Existing Values");
        group.css().flexChildFiller0();
        group.hide();

        ScDiv header;
        header = group.showHeader();
        header.css().flexRow().flexAlignSpaced().pad();
        header.add(createExistingValueHeaderMessage());

        ScDiv links;
        links = header.addDiv();
        links.css().flexRow().rowSpacer5();
        links.addBold("Select");
        links.addLink("All", newCheckedAction(this::handleSelectAllExistingValues));
        links.addLink("None", newCheckedAction(this::handleSelectNoExistingValues));

        ScDiv body;
        body = group.getBody();
        body.css().pad10().auto();
        body.add(createExistingValueList());

        _existingValueGroup = group;
        return group;
    }

    private ScControl createExistingValueHeaderMessage()
    {
        ScTextSpan e;
        e = new ScTextSpan();
        _existingValueHeaderMessage = e;
        return e;
    }

    private ScControl createExistingValueList()
    {
        ScCheckboxList<String> e;
        e = new ScCheckboxList<>();
        e.disableChangeTracking();
        _existingValueList = e;
        return e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        _targetProjectText.setValue(getTargetProject().getName());
        _newValueHeaderMessage.setValue(formatNewValueHeaderMessage());
        _existingValueHeaderMessage.setValue(formatExistingValueHeaderMessage());
    }

    private String formatNewValueHeaderMessage()
    {
        return Kmu.format(
            "These values do not yet exist in %s, and will be added.",
            getTargetProject().getName());
    }

    private String formatExistingValueHeaderMessage()
    {
        return Kmu.format(
            "These values already exist in %s, and will be updated.",
            getTargetProject().getName());
    }

    //##################################################
    //# handle
    //##################################################

    protected void handleSelectProject()
    {
        ajaxUpdateLists();
    }

    protected void ajaxUpdateLists()
    {
        MyProject source = getSourceProject();

        if ( source == null )
        {
            _newValueGroup.ajaxHide();
            _existingValueGroup.ajaxHide();
            return;
        }

        ajaxUpdateValues();
    }

    //==================================================
    //= handle :: new values
    //==================================================

    private void handleSelectAllNewValues()
    {
        ajaxUpdateNewValues(true);
    }

    private void handleSelectNoNewValues()
    {
        ajaxUpdateNewValues(false);
    }

    //==================================================
    //= handle :: existing values
    //==================================================

    private void handleSelectAllExistingValues()
    {
        ajaxUpdateExistingValues(true);
    }

    private void handleSelectNoExistingValues()
    {
        ajaxUpdateExistingValues(false);
    }

    //==================================================
    //= handle :: import
    //==================================================

    private void handleImport()
    {
        KmList<T> oldValues = getSelectedValues();
        if ( oldValues.isEmpty() )
        {
            ajaxNotifyNoValuesSelected();
            return;
        }

        importAll(oldValues);
        ajaxUpdateValues();
        ajaxNotifyUpdatedValues(oldValues);
    }

    private KmList<T> getSelectedValues()
    {
        KmList<String> uids;
        uids = new KmList<>();
        uids.addAll(_newValueList.getValue());
        uids.addAll(_existingValueList.getValue());

        return findValues(uids);
    }

    protected abstract void importAll(KmList<T> sourceValues);

    private void ajaxNotifyNoValuesSelected()
    {
        String msg = ""
            + "Select one or more values in the lists below, "
            + "then click import to transfer the values into the current project.";

        MyNotifyDialog e;
        e = MyDialogs.getNotifyDialog();
        e.setTitle("Cannot Transfer");
        e.setSubtitle("No Values Selected To Import");
        e.setMessage(msg);
        e.ajaxOpen();
    }

    private void ajaxNotifyUpdatedValues(KmList<T> oldValues)
    {
        int n = oldValues.size();

        String msg = Kmu.format(
            "Transferred %s %s into the current project. The lists have been refreshed.",
            n,
            Kmu.pluralize(n, "value"));

        MyNotifyDialog e;
        e = MyDialogs.getNotifyDialog();
        e.setTitle("Transfer Successful");
        e.setSubtitle("Transferred Values");
        e.setMessage(msg);
        e.ajaxOpen();
    }

    //##################################################
    //# ajax
    //##################################################

    private void ajaxUpdateValues()
    {
        ajaxUpdateNewValues(false);
        ajaxUpdateExistingValues(false);
    }

    private void ajaxUpdateNewValues(boolean selectAll)
    {
        KmList<T> values = getNewSourceValues();
        KmList<ScOption<String>> options = toOptions(values);

        KmList<String> selectedUids = selectAll
            ? values.collect(e -> e.getUid())
            : KmList.createEmpty();

        _newValueList.setOptions(options);
        _newValueList.setValue(selectedUids);
        _newValueList.ajaxReplace();

        _newValueGroup.ajaxShow();
    }

    private void ajaxUpdateExistingValues(boolean selectAll)
    {
        KmList<T> values = getExistingSourceValues();
        KmList<ScOption<String>> options = toOptions(values);

        KmList<String> selectedUids = selectAll
            ? values.collect(e -> e.getUid())
            : KmList.createEmpty();

        _existingValueList.setOptions(options);
        _existingValueList.setValue(selectedUids);
        _existingValueList.ajaxReplace();

        _existingValueGroup.ajaxShow();
    }

    //##################################################
    //# support
    //##################################################

    protected MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

    protected MyTenant getTargetTenant()
    {
        return getTargetProject().getTenant();
    }

    protected MyProject getTargetProject()
    {
        return MyGlobals.getCurrentProject();
    }

    protected MyProject getSourceProject()
    {
        return _sourceProjectField.getValue();
    }

    //==================================================
    //= support :: values
    //==================================================

    private KmList<T> getNewSourceValues()
    {
        return getSourceValues().select(e -> isNewSourceValue(e));
    }

    private KmList<T> getExistingSourceValues()
    {
        return getSourceValues().select(e -> !isNewSourceValue(e));
    }

    protected abstract KmList<T> getSourceValues();

    protected abstract boolean isNewSourceValue(T value);

    protected abstract KmList<T> findValues(KmList<String> uids);

    //==================================================
    //= support :: options
    //==================================================

    private KmList<ScOption<String>> toOptions(KmList<T> values)
    {
        return values.collect(e -> toOption(e));
    }

    private ScOption<String> toOption(T e)
    {
        return ScOption.create(e.getUid(), formatValue(e));
    }

    protected abstract String formatValue(T e);

    //==================================================
    //= support :: misc
    //==================================================

    private KmList<MyProject> findAvailableProjects()
    {
        KmList<MyProject> v;
        v = getTargetTenant().getProjectsByName();
        v.retainIf(e -> allowsSourceProject(e));
        v.remove(getTargetProject());
        return v;
    }

    protected abstract boolean allowsSourceProject(MyProject sourceProject);

}
