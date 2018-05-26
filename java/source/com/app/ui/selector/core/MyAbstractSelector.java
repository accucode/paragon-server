package com.app.ui.selector.core;

import java.util.function.BiFunction;

import com.kodemore.adaptor.KmAdaptorIF;
import com.kodemore.collection.KmList;
import com.kodemore.domain.KmUidDomainIF;
import com.kodemore.meta.KmMetaAssociation;
import com.kodemore.meta.KmMetaAttribute;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScDivWrapper;
import com.kodemore.servlet.control.ScFieldIF;
import com.kodemore.servlet.control.ScPopupMenu;
import com.kodemore.servlet.control.ScPopupMenuItem;
import com.kodemore.servlet.field.ScDynamicDropdownField;
import com.kodemore.servlet.field.ScHiddenField;
import com.kodemore.servlet.field.ScOption;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoAccess;
import com.app.model.MyProject;
import com.app.utility.MyGlobals;
import com.app.utility.MyUserProxy;
import com.app.utility.MyUtility;

/**
 * I display a dropdown with a list of options, and allow
 * the user to add a new option on the fly via a popup dialog.
 *
 * @param <P> the parent that defines the options (e.g.: a project).
 * @param <C> the child to be selected or added.
 */
public abstract class MyAbstractSelector<P extends KmUidDomainIF, C extends KmUidDomainIF>
    extends ScDivWrapper
    implements ScFieldIF<C>
{
    //##################################################
    //# variables
    //##################################################

    /**
     * Used to track the domain parent.
     */
    private ScHiddenField<String> _domainParentUidField;

    /**
     * Track whether the dropdown should currently show all children,
     * or just the enabled values.
     * Defaults to false.
     */
    private ScHiddenField<Boolean> _showAllField;

    /**
     * The dropdown box that displays the list of standard options.
     */
    private ScDynamicDropdownField<String> _dropdown;

    /**
     * If true (the default), the value is encoded into an html data- attribute
     * and the browser utilizes a client-side script to warn the user before
     * ajax actions if the value has changed.
     *
     * Change tracking should be set during initial page initialization, and should
     * NOT be modified while processing a page.
     */
    private boolean _changeTracking;

    /**
     * If set the applyFromModel and applyToModel will use this adaptor
     * to get/set the value.
     */
    private KmAdaptorIF<?,C> _valueAdaptor;

    /**
     * Pickers usually define their own default method for finding the
     * children. However, you can set this to override the default and
     * return a custom list that is appropriate for your page.
     */
    private BiFunction<P,Boolean,KmList<C>> _childrenFunction;

    //==================================================
    //= variables :: menu
    //==================================================

    /**
     * The popup menu that provides additional options such as:
     * add, show all, and other options.
     */
    private ScPopupMenu     _menu;
    private ScPopupMenuItem _addItem;
    private ScPopupMenuItem _showAllItem;
    private ScPopupMenuItem _showEnabledItem;

    /**
     * If set, override the default behavior of allowsAdd().
     */
    private Boolean _allowsAddOverride;

    //##################################################
    //# constructor
    //##################################################

    public MyAbstractSelector()
    {
        _changeTracking = true;
        _valueAdaptor = null;

        install();
    }

    //##################################################
    //# install
    //##################################################

    private void install()
    {
        ScDiv e;
        e = getInner();
        e.css().flexInlineRow();
        e.add(createDropdownField());
        e.add(createMenu());
        e.add(createHiddenFields());
    }

    private ScControl createDropdownField()
    {
        ScDynamicDropdownField<String> e;
        e = new ScDynamicDropdownField<>();
        e.setNullNonePrefix();
        e.setOptionSupplier(this::findDropdownOptions);
        _dropdown = e;
        return e;
    }

    //==================================================
    //= install :: menu
    //==================================================

    private ScControl createMenu()
    {
        ScPopupMenu e;
        e = new ScPopupMenu();
        e.hide();
        e.addItem(createAddItem());
        e.addItem(createShowAllItem());
        e.addItem(createHideDisabledItem());
        _menu = e;
        return e;
    }

    private ScPopupMenuItem createAddItem()
    {
        ScPopupMenuItem e;
        e = new ScPopupMenuItem();
        e.setText("Add");
        e.setAction(newUncheckedAction(this::handleAdd));
        e.hide();
        _addItem = e;
        return e;
    }

    private ScPopupMenuItem createShowAllItem()
    {
        ScPopupMenuItem e;
        e = new ScPopupMenuItem();
        e.setText("Show All");
        e.setAction(newUncheckedAction(this::handleShowAll));
        _showAllItem = e;
        return e;
    }

    private ScPopupMenuItem createHideDisabledItem()
    {
        ScPopupMenuItem e;
        e = new ScPopupMenuItem();
        e.setText("Hide Disabled");
        e.setAction(newUncheckedAction(this::handleHideDisabled));
        _showEnabledItem = e;
        return e;
    }

    //==================================================
    //= install :: hidden fields
    //==================================================

    private ScControl createHiddenFields()
    {
        ScDiv e;
        e = new ScDiv();
        e.add(createParentUidField());
        e.add(createShowAllField());
        installHiddenFieldsOn(e);
        return e;
    }

    private ScControl createParentUidField()
    {
        ScHiddenField<String> e;
        e = new ScHiddenField<>();
        _domainParentUidField = e;
        return e;
    }

    private ScControl createShowAllField()
    {
        ScHiddenField<Boolean> e;
        e = new ScHiddenField<>();
        e.setValue(false);
        _showAllField = e;
        return e;
    }

    /**
     * @param e The container the hidden fields should be added to.
     */
    protected void installHiddenFieldsOn(ScDiv e)
    {
        // subclass
    }

    //##################################################
    //# project
    //##################################################

    protected final MyProject getProject()
    {
        return MyUtility.getProjectFor(getDomainParent());
    }

    protected final MyUserProxy getProxy()
    {
        return MyUserProxy.createProxy(getProject());
    }

    //##################################################
    //# domain parent
    //##################################################

    protected final P getDomainParent()
    {
        String uid = _domainParentUidField.getValue();
        return findDomainParent(uid);
    }

    protected final void setDomainParent(P e)
    {
        String uid = KmUidDomainIF.getUidFor(e);
        _domainParentUidField.setValue(uid);
    }

    protected abstract P findDomainParent(String uid);

    protected final boolean hasDomainParent()
    {
        return _domainParentUidField.hasValue();
    }

    //##################################################
    //# setup
    //##################################################

    public void setMeta(KmMetaAssociation<?,C> x)
    {
        setLabel(x);
        setHelp(x);
        setValueAdaptor(x);

        if ( x.isRequired() )
        {
            setRequired();
            setNullSelectPrefix();
        }
        else
        {
            setOptional();
            setNullNonePrefix();
        }
    }

    //##################################################
    //# required
    //##################################################

    public void setRequired()
    {
        _dropdown.setRequired();
    }

    public void setOptional()
    {
        _dropdown.setOptional();
    }

    //##################################################
    //# prefix
    //##################################################

    public void setNullPrefix(String e)
    {
        _dropdown.setNullPrefix(e);
    }

    public void setNullAnyPrefix()
    {
        _dropdown.setNullAnyPrefix();
    }

    public void setNullSelectPrefix()
    {
        _dropdown.setNullSelectPrefix();
    }

    public void setNullNonePrefix()
    {
        _dropdown.setNullNonePrefix();
    }

    //##################################################
    //# help
    //##################################################

    @Override
    public void setHelp(String e)
    {
        _dropdown.setHelp(e);
    }

    @Override
    public void setHelp(KmMetaAttribute<?,?> e)
    {
        _dropdown.setHelp(e);
    }

    //##################################################
    //# children function
    //##################################################

    public BiFunction<P,Boolean,KmList<C>> getChildrenFunction()
    {
        return _childrenFunction;
    }

    public void setChildrenFunction(BiFunction<P,Boolean,KmList<C>> e)
    {
        _childrenFunction = e;
    }

    public boolean hasChildrenFunction()
    {
        return _childrenFunction != null;
    }

    //##################################################
    //# value adaptor
    //##################################################

    public KmAdaptorIF<?,C> getValueAdaptor()
    {
        return _valueAdaptor;
    }

    public void setValueAdaptor(KmAdaptorIF<?,C> e)
    {
        _valueAdaptor = e;
    }

    public void clearValueAdaptor()
    {
        _valueAdaptor = null;
    }

    public boolean hasValueAdaptor()
    {
        return _valueAdaptor != null;
    }

    //##################################################
    //# select
    //##################################################

    public void selectFirstOption()
    {
        _dropdown.selectFirstOption();
    }

    public void selectSingleOption()
    {
        _dropdown.selectSingleOption();
    }

    public void ensureValidValue()
    {
        _dropdown.ensureValidValue();
    }

    //##################################################
    //# listeners
    //##################################################

    public void onChange(ScAction e)
    {
        _dropdown.onChange(e);
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public C getValue()
    {
        String uid = _dropdown.getValue();
        return findDomainChild(uid);
    }

    protected abstract C findDomainChild(String uid);

    @Override
    public void setValue(C value)
    {
        String uid = KmUidDomainIF.getUidFor(value);
        _dropdown.setValue(uid);
    }

    @Override
    public void saveValue()
    {
        _dropdown.saveValue();
    }

    @Override
    public void resetValue()
    {
        _dropdown.resetValue();
    }

    public void clearValue()
    {
        _dropdown.clearValue();
    }

    //##################################################
    //# validation
    //##################################################

    @Override
    public final boolean isRequired()
    {
        return _dropdown.isRequired();
    }

    public final void clearValidator()
    {
        _dropdown.clearValidator();
    }

    //==================================================
    //= value :: encodable
    //==================================================

    @Override
    public final Object getEncodableValue()
    {
        return _dropdown.getEncodableValue();
    }

    @Override
    public final void setEncodableValue(Object e)
    {
        _dropdown.setEncodableValue(e);
    }

    //##################################################
    //# downcast
    //##################################################

    @Override
    @SuppressWarnings("unchecked")
    protected boolean applyFromModel_here(Object model)
    {
        if ( !hasValueAdaptor() )
            return true;

        KmAdaptorIF<Object,C> e = (KmAdaptorIF<Object,C>)getValueAdaptor();
        C value = e.getValue(model);
        setValue(value);
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected boolean applyToModel_here(Object model)
    {
        if ( !hasValueAdaptor() )
            return true;

        KmAdaptorIF<Object,C> e;
        e = (KmAdaptorIF<Object,C>)getValueAdaptor();
        e.setValue(model, getValue());
        return true;
    }

    //##################################################
    //# change tracking
    //##################################################

    @Override
    public boolean getChangeTracking()
    {
        return _changeTracking;
    }

    public void setChangeTracking(boolean e)
    {
        warnIfInstalled();
        _changeTracking = e;
        _dropdown.setChangeTracking(e);
    }

    public void disableChangeTracking()
    {
        setChangeTracking(false);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        preRenderDropdown();
        preRenderMenu();
    }

    private void preRenderDropdown()
    {
        if ( hasDomainParent() )
            return;

        String msg = Kmu.format("select a %s", getDomainParentName().toLowerCase());
        String prefix = Kmu.formatMetaValue(msg);
        _dropdown.setNullPrefix(prefix);
    }

    private void preRenderMenu()
    {
        _menu.show();

        if ( allowsAdd() )
            _addItem.show();

        boolean showsAll = _showAllField.getValue();
        _showAllItem.setVisible(!showsAll);
        _showEnabledItem.setVisible(showsAll);
    }

    protected abstract String getDomainParentName();

    //##################################################
    //# ajax
    //##################################################

    @Override
    public void ajaxSetFieldValue(C e)
    {
        ajaxSetFieldValue(e, getChangeTracking());
    }

    @Override
    public void ajaxSetFieldValue(C e, boolean updateOldValue)
    {
        setValue(e);
        ajaxUpdateFieldValues(updateOldValue);
    }

    @Override
    public void ajaxUpdateFieldValue_here(boolean updateOldValue)
    {
        // none
    }

    //##################################################
    //# options
    //##################################################

    private KmList<ScOption<String>> findDropdownOptions()
    {
        KmList<C> values = findDomainChildren();

        KmList<ScOption<String>> options;
        options = values.collect(q -> ScOption.create(q.getUid(), formatOption(q)));
        options.sortOn(q -> q.getText());
        return options;
    }

    public KmList<C> findDomainChildren()
    {
        KmList<C> v = KmList.createEmpty();
        boolean all = _showAllField.getValue();

        P parent = getDomainParent();
        if ( parent != null )
            v = hasChildrenFunction()
                ? getChildrenFunction().apply(parent, all)
                : findDomainChildrenFor(parent);

        addMissingValueTo(v);
        return v;
    }

    /**
     * Ensure that the currently selected option is included in the options.
     * This is primarily used so the current value remains selected even if
     * it is disabled.
     *
     * This only applies if the selected value:
     * -- is NOT null.
     * -- is a valid value in the list of ALL options.
     */
    private void addMissingValueTo(KmList<C> values)
    {
        C e = getValue();
        if ( e == null )
            return;

        if ( values.contains(e) )
            return;

        if ( showsAllValues() )
            return;

        P parent = getDomainParent();
        if ( parent == null )
            return;

        KmList<C> all = findAllDomainChildrenFor(parent);
        if ( !all.contains(e) )
            return;

        values.addFirst(e);
    }

    private boolean showsAllValues()
    {
        return _showAllField.getValue();
    }

    private KmList<C> findDomainChildrenFor(P parent)
    {
        boolean showAll = _showAllField.getValue();
        return showAll
            ? findAllDomainChildrenFor(parent)
            : findEnabledDomainChildrenFor(parent);
    }

    private KmList<C> findEnabledDomainChildrenFor(P parent)
    {
        return findAllDomainChildrenFor(parent).select(e -> e.isDomainEnabled());
    }

    protected abstract KmList<C> findAllDomainChildrenFor(P parent);

    protected String formatOption(C e)
    {
        return e.getDomainTitle();
    }

    //##################################################
    //# handle :: add
    //##################################################

    private void handleAdd()
    {
        MyAbstractSelectorDialog<P,C> e = getDialog();
        if ( e == null )
            throw Kmu.newFatal("Dialog not registered in: %s.", getClass().getSimpleName());

        if ( !allowsAdd() )
            throw Kmu.newFatal("Add is not allowed in: %s.", getClass().getSimpleName());

        prepareDialog();
        e.ajaxOpen();
    }

    /**
     * Prepare the dialog for opening.
     * Set any state before ajaxOpen and preRender.
     */
    protected void prepareDialog()
    {
        MyAbstractSelectorDialog<P,C> e;
        e = getDialog();
        e.setSelector(this);
        e.setDomainParent(getDomainParent());
    }

    protected void handleAdded(P parent, C child)
    {
        setDomainParent(parent);
        setValue(child);

        _dropdown.ajaxReplaceOptions();
        _dropdown.ajaxSetFieldValue(child.getUid(), false);
        _dropdown.ajaxFireChanged();
    }

    protected abstract MyAbstractSelectorDialog<P,C> getDialog();

    //==================================================
    //= handle :: show all
    //==================================================

    private void handleShowAll()
    {
        handleShowAll(true);
    }

    private void handleHideDisabled()
    {
        handleShowAll(false);
    }

    private void handleShowAll(boolean all)
    {
        _showAllField.setValue(all);
        _showAllField.ajaxUpdateValue();

        preRenderMenu();
        _menu.ajaxReplace();

        String uid = KmUidDomainIF.getUidFor(getValue());
        _dropdown.setValue(uid);
        _dropdown.ajaxReplaceOptions();
        _dropdown.ajaxSetFieldValue(uid, false);
    }

    //##################################################
    //# security
    //##################################################

    public Boolean getAllowsAddOverride()
    {
        return _allowsAddOverride;
    }

    public void setAllowsAddOverride(Boolean e)
    {
        _allowsAddOverride = e;
    }

    public void disableAdd()
    {
        setAllowsAddOverride(false);
    }

    protected final boolean allowsAdd()
    {
        return _allowsAddOverride == null
            ? allowsAddDefault()
            : _allowsAddOverride;
    }

    protected abstract boolean allowsAddDefault();

    //##################################################
    //# error
    //##################################################

    public void addError(String format, Object... args)
    {
        _dropdown.addError(format, args);
    }

    public void addErrorAndCheck(String format, Object... args)
    {
        addError(format, args);
        checkErrors();
    }

    //##################################################
    //# support
    //##################################################

    protected MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }
}
