package com.app.macro;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmOrderedMap;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;
import com.kodemore.servlet.control.ScScriptButton;
import com.kodemore.servlet.field.ScHiddenField;
import com.kodemore.servlet.field.ScListField;
import com.kodemore.servlet.field.ScStaticListField;
import com.kodemore.servlet.field.ScTextArea;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.utility.KmEnumIF;
import com.kodemore.utility.KmVirtualOptions;
import com.kodemore.utility.Kmu;

import com.app.model.MyProject;
import com.app.utility.MyGlobals;

/**
 * I display the available macros and allow the user to select one
 * and copy it to the system copy-buffer. Multiple list boxes allow
 * the user to drill down through several layers to find the macro
 * they are looking for.
 */
public class MyMacroListView
    extends ScDiv
{
    //##################################################
    //# constants
    //##################################################

    private static final int FIELD_HIEGHT = 200;

    //##################################################
    //# variables
    //##################################################

    private ScHiddenField<String> _contextTypeCodeField;

    private ScStaticListField<String> _categoryList;

    /**
     * NON-STANDARD.
     * This is loosely a list of the MacroDomainTypes. However,
     * we allow multiple domain types to be consolidated by their
     * non-unique sharedCode.
     *
     * Several non-standard tweaks are made to this class to facilitate
     * this. The main tweak is that we use the domainType's sharedCode (NOT Code)
     * as the list's option value.
     */
    private ScStaticListField<String> _domainList;

    private ScStaticListField<String> _associationList;
    private ScStaticListField<String> _fieldList;

    private ScTextField _tokenField;
    private ScTextArea  _sampleField;
    private ScTextArea  _descriptionField;

    //##################################################
    //# constructor
    //##################################################

    public MyMacroListView()
    {
        install();
    }

    //##################################################
    //# install
    //##################################################

    private void install()
    {
        ScDiv div;
        div = this;
        div.setLabel("Macros");
        div.css().flexChildStatic().clip();
        div.add(createContextTypeCodeField());

        ScDiv row;
        row = div.addDiv();
        row.css().flexRow().rowSpacer20();
        row.addFieldLayout().add(createCategoryList());
        row.addFieldLayout().add(createDomainList());
        row.addFieldLayout().add(createAssociationList());

        ScFieldLayout layout;
        layout = row.addFieldLayout();
        layout.css().flexChildFiller();
        layout.addErrorWrapper(createFieldList()).css().flexRow();

        div.addFlexGap(20);

        row = div.addDiv();
        row.css().flexRow().rowSpacer20();
        row.addFieldLayout().add(createTokenView());
        row.addFieldLayout().add(createSampleField());

        layout = row.addFieldLayout();
        layout.css().flexChildFiller();
        layout.addErrorWrapper(createDescriptionField()).css().flexRow();
    }

    private ScHiddenField<String> createContextTypeCodeField()
    {
        ScHiddenField<String> e;
        e = new ScHiddenField<>();
        _contextTypeCodeField = e;
        return e;
    }

    private ScControl createCategoryList()
    {
        ScStaticListField<String> e;
        e = new ScStaticListField<>();
        e.setLabel("Category");
        e.layoutInline(80, FIELD_HIEGHT);
        e.disableChangeTracking();
        e.onChange(newUncheckedAction(this::handleSelectCategory));
        e.setHelp("The available categories for macros; e.g.: Global, Selected");
        _categoryList = e;
        return e;
    }

    private ScListField<String> createDomainList()
    {
        ScStaticListField<String> e;
        e = new ScStaticListField<>();
        e.setLabel("Domain");
        e.layoutInline(110, FIELD_HIEGHT);
        e.disableChangeTracking();
        e.onChange(newUncheckedAction(this::handleSelectDomain));
        e.setHelp("The list of available domains for this context; e.g.: Job");
        _domainList = e;
        return e;
    }

    private ScControl createAssociationList()
    {
        ScStaticListField<String> e;
        e = new ScStaticListField<>();
        e.setLabel("Association");
        e.layoutInline(150, FIELD_HIEGHT);
        e.disableChangeTracking();
        e.onChange(newUncheckedAction(this::handleSelectAssociation));
        e.setHelp("The list of available associations to the selected domain. e.g.: Main Contact");
        _associationList = e;
        return e;
    }

    private ScControl createFieldList()
    {
        ScStaticListField<String> e;
        e = new ScStaticListField<>();
        e.setLabel("Field");
        e.layoutFlexFiller(FIELD_HIEGHT);
        e.disableChangeTracking();
        e.onChange(newUncheckedAction(this::handleSelectField));
        e.setHelp("The available fields for the selected domain.");
        _fieldList = e;
        return e;
    }

    private ScDiv createTokenView()
    {
        ScDiv e;
        e = new ScDiv();
        e.setLabel("Token");
        e.css().flexColumn().columnSpacer5();
        e.add(createTokenField());
        e.add(createCopyButton());
        return e;
    }

    private ScTextField createTokenField()
    {
        ScTextField e;
        e = new ScTextField();
        e.setReadOnly();
        e.layoutBlock();
        e.disableChangeTracking();
        e.setHelp("The token to be used inside the subject and/or body text.");
        _tokenField = e;
        return e;
    }

    private ScScriptButton createCopyButton()
    {
        ScScriptButton e;
        e = new ScScriptButton();
        e.setText("Copy");
        e.setScript(getCopyScript());
        e.setIcon().nameContentCopy();
        return e;
    }

    private ScTextArea createSampleField()
    {
        ScTextArea e;
        e = new ScTextArea();
        e.setLabel("Sample");
        e.setReadOnly();
        e.layoutBlock();
        e.disableChangeTracking();
        e.setHelp("A sample value for the selected macro.");
        _sampleField = e;
        return e;
    }

    private ScTextArea createDescriptionField()
    {
        ScTextArea e;
        e = new ScTextArea();
        e.setLabel("Description");
        e.setReadOnly();
        e.layoutFlexFiller(null, FIELD_HIEGHT);
        e.disableChangeTracking();
        e.setHelp("A brief description of the selected macro.");
        _descriptionField = e;
        return e;
    }

    //##################################################
    //# type
    //##################################################

    public MyMacroContextType getContextType()
    {
        String code = _contextTypeCodeField.getValue();
        return MyMacroContextType.findCode(code);
    }

    public void setContextType(MyMacroContextType e)
    {
        String code = KmEnumIF.getCodeFor(e);
        _contextTypeCodeField.setValue(code);
    }

    public boolean hasContextType()
    {
        return getContextType() != null;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        preRenderCategoryList();
        preRenderDomainList();
        preRenderAssociationList();
        preRenderFieldList();
    }

    private void preRenderCategoryList()
    {
        _categoryList.clearOptions();

        KmList<MyMacroCategoryType> v;
        v = MyMacroCategoryType.getValues();

        for ( MyMacroCategoryType e : v )
            _categoryList.addOption(e.getCode(), e.getLabel());

        _categoryList.setValue(MyMacroCategoryType.Current.getCode());
    }

    private void preRenderDomainList()
    {
        updateDomainList();

        MyMacroDomainType def = getContextType().getDefaultDomainType();
        _domainList.setValue(def.getSharedCode());
    }

    private void preRenderAssociationList()
    {
        updateAssociationList();
    }

    private void preRenderFieldList()
    {
        updateFieldList();
    }

    //##################################################
    //# ajax
    //##################################################

    public void ajaxRefresh()
    {
        _contextTypeCodeField.ajaxUpdateFieldValues();

        updateDomainList();
        updateAssociationList();
        updateFieldList();
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSelectCategory()
    {
        ajaxClearMacroFields();
        updateDomainList();
        _domainList.ajaxReplace();
        handleSelectDomain();
    }

    private void handleSelectDomain()
    {
        ajaxClearMacroFields();

        updateAssociationList();

        _associationList.setValue(null);
        _associationList.ajaxReplace();

        handleSelectAssociation();
    }

    private void handleSelectAssociation()
    {
        ajaxClearMacroFields();

        updateFieldList();

        _fieldList.ajaxReplace();
    }

    private void handleSelectField()
    {
        MyMacro macro = getSelectedMacro();

        if ( macro == null )
            return;

        _tokenField.ajaxSetFieldValue(macro.getToken());
        _tokenField.ajaxFocus();
        _tokenField.ajaxSelect();

        _sampleField.ajaxSetFieldValue(macro.getSamplePlaintext());

        _descriptionField.ajaxSetFieldValue(macro.getDescription());
    }

    //##################################################
    //# support
    //##################################################

    public ScBlockScript getCopyScript()
    {
        ScBlockScript e;
        e = ScBlockScript.create();
        e.copyFieldToClipboard(_tokenField.getInputSelector());
        return e;
    }

    private String getLabelFor(String e)
    {
        return Kmu.capitalizeWords(Kmu.getCamelCaseWords(e).join(" "));
    }

    private void ajaxClearMacroFields()
    {
        _tokenField.ajaxClearFieldValue();
        _sampleField.ajaxClearFieldValue();
        _descriptionField.ajaxClearFieldValue();
    }

    //==================================================
    //= support :: update
    //==================================================

    /**
     * Update the list of domain types.
     *
     * This is a bit non-standard because we want to consolidate
     * domain types that share the same LABEL.
     */
    private void updateDomainList()
    {
        MyMacroCategoryType category = getSelectedCategory();
        MyMacroContextType context = getContextType();
        KmList<MyMacroDomainType> types = newFetcher().getDomainTypesFor(category);

        KmList<String> codes;
        codes = types.collect(e -> e.getSharedCode());
        codes.removeDuplicates();
        codes.sort();

        _domainList.setOptions(codes);

        selectDefaultDomain(category, context, codes);
    }

    private void selectDefaultDomain(
        MyMacroCategoryType category,
        MyMacroContextType context,
        KmList<String> sharedCodes)
    {
        switch ( category )
        {
            case Global:
            {
                String def = sharedCodes.getFirst();
                _domainList.setValue(def);
                break;
            }

            case Current:
            {
                String def = context.getDefaultDomainType().getSharedCode();
                if ( !sharedCodes.contains(def) )
                    def = sharedCodes.getFirst();

                _domainList.setValue(def);
                break;
            }
        }
    }

    private void updateAssociationList()
    {
        KmOrderedMap<String,String> m;
        m = new KmOrderedMap<>();
        m.put(null, getSelectedDomainSharedCode());

        KmList<String> v = getDomainAssociations();
        for ( String e : v )
            m.put(e, getLabelFor(e));

        m.sortOnValues();
        _associationList.setOptions(m);
    }

    private void updateFieldList()
    {
        _fieldList.clearValue();
        _fieldList.clearOptions();
        _fieldList.addOption(null, KmVirtualOptions.NONE);

        KmList<MyMacro> v;
        v = getFilteredMacros();
        v.sortOn(e -> getLabelFor(e.getFieldName()));

        for ( MyMacro e : v )
        {
            String name = e.getFieldName();
            String label = getLabelFor(e.getFieldName());
            _fieldList.addOption(name, label);
        }
    }

    //==================================================
    //= support :: selected
    //==================================================

    private MyMacroCategoryType getSelectedCategory()
    {
        return MyMacroCategoryType.findCode(_categoryList.getValue());
    }

    private String getSelectedDomainSharedCode()
    {
        return _domainList.getValue();
    }

    private KmList<MyMacroDomainType> getSelectedDomains()
    {
        return MyMacroDomainType.findSharedCode(getSelectedDomainSharedCode());
    }

    private String getSelectedAssociation()
    {
        return _associationList.getValue();
    }

    private MyMacro getSelectedMacro()
    {
        String fieldName = _fieldList.getValue();
        KmList<MyMacro> v = getFilteredMacros();
        return v.selectFirst(e -> e.hasFieldName(fieldName));
    }

    //==================================================
    //= support :: macros
    //==================================================

    private KmList<MyMacro> getAllMacros()
    {
        return newFetcher().findAll();
    }

    private KmList<MyMacro> getDomainMacros()
    {
        String code = getSelectedDomainSharedCode();
        return getAllMacros().select(e -> e.hasDomainSharedCode(code));
    }

    private KmList<String> getDomainAssociations()
    {
        KmList<MyMacro> macros = getDomainMacros();

        KmList<String> names;
        names = macros.collect(e -> e.getAssociationName());
        names.removeNulls();
        names.removeDuplicates();
        return names;
    }

    private KmList<MyMacro> getFilteredMacros()
    {
        KmList<MyMacroDomainType> domains = getSelectedDomains();
        String association = getSelectedAssociation();

        KmList<MyMacro> v;
        v = getDomainMacros();
        v.retainIf(e -> e.hasAnyDomainType(domains));
        v.retainIf(e -> e.hasAssociationName(association));
        return v;
    }

    //==================================================
    //= support :: fetcher
    //==================================================

    private MyMacroFetcher newFetcher()
    {
        MyMacroFetcher f;
        f = new MyMacroFetcher();
        f.setContextType(getContextType());
        f.setProject(getCurrentProject());
        return f;
    }

    private MyProject getCurrentProject()
    {
        return MyGlobals.getCurrentProject();
    }
}
