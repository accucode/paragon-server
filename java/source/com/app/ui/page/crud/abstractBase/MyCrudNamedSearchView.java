package com.app.ui.page.crud.abstractBase;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import com.kodemore.collection.KmList;
import com.kodemore.domain.KmUidDomainIF;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPopupMenu;
import com.kodemore.servlet.control.ScSimpleModelList;
import com.kodemore.servlet.control.ScTextSpan;
import com.kodemore.servlet.field.ScAutoCompleteField;
import com.kodemore.servlet.field.ScDomainDropdownField;
import com.kodemore.servlet.field.ScHiddenField;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.types.KmTuple;
import com.kodemore.utility.KmSimpleResult;
import com.kodemore.utility.Kmu;

import com.app.criteria.MyFilterTemplateCriteria;
import com.app.dao.base.MyDaoAccess;
import com.app.model.MyFilterTemplate;
import com.app.model.MyProject;
import com.app.model.base.MyFilterTemplateContextType;
import com.app.model.base.MyFilterTemplateType;
import com.app.ui.dialog.MyConfirmDialog;
import com.app.ui.dialog.MyDialogs;
import com.app.ui.dialog.MyNotifyDialog;
import com.app.ui.page.crud.site.MyFilterRenameDialog;
import com.app.ui.page.crud.site.MyFilterSaveAsDialog;
import com.app.utility.MyGlobals;

/**
 * I display a paginated list, using the ScSimpleModelList to render
 * each page. I incorporate support for filters.
 *
 * @param <P> The PARENT, used to get the list.
 * @param <C> The CHILD, the selected list item.
 */
public abstract class MyCrudNamedSearchView<P extends KmUidDomainIF, C extends KmUidDomainIF>
    extends ScForm
    implements MyCrudSearchViewIF<P,C>
{
    //##################################################
    //# constants
    //##################################################

    /**
     * The number of children/rows to display on each page of results.
     */
    private static final int PAGE_SIZE = 50;

    //##################################################
    //# variables
    //##################################################

    private MyCrudBuilder<P,C> _crudBuilder;

    private ScLocalString _domainParentUid;
    private ScLocalString _domainChildUid;

    /**
     * The 0-based index of the current page.
     */
    private ScHiddenField<Integer> _pageIndexField;

    /**
     * The total number of domain children available.
     * This is an approximation. We calculate it when we search
     * on a new filter, but we do NOT update it each time the
     * user navigates from one page to another. Thus, the actual
     * number of available rows may be different than this
     * approximation. The actual number of rows may be either greater
     * OR less than this value.
     */
    private ScHiddenField<Integer> _rowCountField;

    //==================================================
    //= group
    //==================================================

    private ScGroup _group;

    //==================================================
    //= variables :: search
    //==================================================

    /**
     * A simple text field that is used to quickly search the results.
     */
    private ScAutoCompleteField _searchField;

    //==================================================
    //= variables :: filter
    //==================================================

    /**
     * Select the filter that the user wants to use.
     */
    private ScDomainDropdownField<MyFilterTemplate,String> _filterField;
    private MyFilterSaveAsDialog                           _filterSaveAsDialog;
    private MyFilterRenameDialog                           _filterRenameDialog;
    private ScAction                                       _deleteConfirmedAction;

    /**
     * The button used to add a new domain object.
     * Visibility is controlled dynamically and may depend on
     * things like the current user.
     */
    private ScActionButton _addButton;

    //==================================================
    //= variables :: list
    //==================================================

    private ScSimpleModelList<C> _list;

    //==================================================
    //= variables :: other
    //==================================================

    private ScTextSpan _title;
    private ScTextSpan _pageInfoText;

    //==================================================
    //= variables :: listeners
    //==================================================

    private Runnable    _addListener;
    private Runnable    _refreshListener;
    private Consumer<C> _selectListener;

    //##################################################
    //# constructor
    //##################################################

    public MyCrudNamedSearchView(MyCrudBuilder<P,C> e)
    {
        _crudBuilder = e;
        _deleteConfirmedAction = newUncheckedAction(this::handleDeleteConfirmed);

        installUids();
        installLayout();
        installFilterSaveAsDialog();
        installFilterRenameDialog();
    }

    protected final MyCrudBuilder<P,C> getCrudBuilder()
    {
        return _crudBuilder;
    }

    //##################################################
    //# criteria
    //##################################################

    protected abstract KmList<C> findChildren(int index, int count);

    protected abstract int findChildCount();

    //##################################################
    //# install
    //##################################################

    private void installUids()
    {
        _domainParentUid = new ScLocalString();
        _domainParentUid.setAutoSave();

        _domainChildUid = new ScLocalString();
        _domainChildUid.setAutoSave();
    }

    private void installFilterSaveAsDialog()
    {
        _filterSaveAsDialog = new MyFilterSaveAsDialog();
        _filterSaveAsDialog.onSaved(this::ajaxSelectTemplate);
    }

    private void installFilterRenameDialog()
    {
        _filterRenameDialog = new MyFilterRenameDialog();
        _filterRenameDialog.onSaved(this::ajaxSelectTemplate);
    }

    //##################################################
    //# install :: layout
    //##################################################

    private void installLayout()
    {
        ScForm form;
        form = this;
        form.css().relative();
        form.add(createPageIndexField());
        form.add(createRowCountField());
        form.add(createGroup());
    }

    private ScHiddenField<Integer> createPageIndexField()
    {
        ScHiddenField<Integer> e;
        e = new ScHiddenField<>();
        e.setValue(0);
        _pageIndexField = e;
        return e;
    }

    private ScHiddenField<Integer> createRowCountField()
    {
        ScHiddenField<Integer> e;
        e = new ScHiddenField<>();
        e.setValue(0);
        _rowCountField = e;
        return e;
    }

    //==================================================
    //= install :: group
    //==================================================

    private ScGroup createGroup()
    {
        ScGroup group;
        group = new ScGroup();
        group.css().fill();
        group.setFlavorDetail();

        installBannerOn(group);
        installSearchOn(group);
        installListOn(group);
        installNavigationOn(group);

        _group = group;
        return group;
    }

    //==================================================
    //= install :: banner
    //==================================================

    private void installBannerOn(ScGroup group)
    {
        group.getBanner().getLeft().add(createTitle());
    }

    private ScTextSpan createTitle()
    {
        ScTextSpan e;
        e = new ScTextSpan();
        e.css().groupTitle();
        _title = e;
        return e;
    }

    @Override
    public void installCollapseButton(Runnable runnable)
    {
        _group.installCollapseButton(runnable);
    }

    //==================================================
    //= install :: filter
    //==================================================

    /**
     * The filter is installed into the group's header.
     * The filter is split into two parts: the basic filter
     * is always displayed at the top, and the extended filter
     * is displayed upon request. Both the basic and extended
     * options are applied when searching.
     */
    private void installSearchOn(ScGroup group)
    {
        ScDiv header;
        header = group.showHeader();
        header.css().modelList_filter();

        ScDiv top;
        top = header.addDiv();
        top.css().flexRow().flexAlignSpaced();

        ScFieldTable left;
        left = top.addFieldTable();
        left.add(createSearchField());
        left.add(createFilterRow());

        ScDiv right;
        right = top.addDiv();
        right.css().flexChildStatic();
        right.add(createActionContainer());
    }

    private ScControl createSearchField()
    {
        ScAction onChange = newCheckedAction(this::handleSearchChanged);

        ScAutoCompleteField e;
        e = new ScAutoCompleteField();
        e.setLabel("Search");
        e.setCallback(this::autoCompleteSearch);
        // e.onSelect(onChange);
        e.onTypeWatch(onChange);
        e.disableChangeTracking();
        _searchField = e;
        return e;
    }

    protected abstract KmList<String> autoCompleteSearch(String term);

    protected String getSearchText()
    {
        return _searchField.getValue();
    }

    protected boolean hasSearchText()
    {
        return _searchField.hasValue();
    }

    private ScControl createFilterRow()
    {
        ScDiv row;
        row = new ScDiv();
        row.setLabel("Filter");
        row.css().flexRow().flexChildFiller();
        row.add(createFilterField());
        row.addFlexGap(5);
        row.add(createEditFilterButton());
        row.add(createSaveFilterButton());
        row.add(createFilterMenu());
        return row;
    }

    private ScControl createFilterField()
    {
        String help = ""
            + "Filters allow you to select which items are displayed in the list below. "
            + "Predefined filters cannot be modified and are indicated like <this>. "
            + "You can create additional custom filters as needed. "
            + "Unsaved changes are indicated by an asterisk like '* this'. "
            + "Filters are shared with all users within the project."
            + "";

        ScDomainDropdownField<MyFilterTemplate,String> e;
        e = MyFilterTemplate.Tools.newDomainDropdown();
        e.setHelp(help);
        e.setOptionSupplier(this::getTemplates);
        e.setOptionLabelFunction(this::formatDefinitionLabel);
        e.disableChangeTracking();
        e.onChange(newCheckedAction(this::handleSelectFilter));
        _filterField = e;
        return e;
    }

    private String formatDefinitionLabel(MyFilterTemplate e)
    {
        return e.getDomainTitle();
    }

    private ScControl createEditFilterButton()
    {
        ScActionButton e;
        e = new ScActionButton();
        e.setIcon().nameFilter();
        e.setHoverText("Edit Filter");
        e.setFlavorIcon();
        e.setAction(newCheckedAction(this::handleEditFilter));
        return e;
    }

    private ScControl createSaveFilterButton()
    {
        ScActionButton e;
        e = new ScActionButton();
        e.setIcon().nameSave();
        e.setHoverText("Save Filter");
        e.setFlavorIcon();
        e.setAction(newCheckedAction(this::handleSaveFilter));
        return e;
    }

    private ScControl createFilterMenu()
    {
        ScPopupMenu e;
        e = new ScPopupMenu();
        e.addItem("Edit", newCheckedAction(this::handleEditFilter));
        e.addItem("Save", newCheckedAction(this::handleSaveFilter));
        e.addItem("Save As", newCheckedAction(this::handleSaveAsFilter));
        e.addItem("Rename", newCheckedAction(this::handleRenameFilter));
        e.addItem("Delete", newCheckedAction(this::handleDeleteFilter));
        return e;
    }

    private ScControl createActionContainer()
    {
        ScDiv e;
        e = new ScDiv();
        e.css().modelList_filterActions().flexRow().flexCrossAlignCenter().rowSpacer5();
        e.addFlexChildFiller();
        e.add(createAddButton());
        e.add(createPopupMenu());
        return e;
    }

    private ScControl createAddButton()
    {
        ScActionButton e;
        e = new ScActionButton();
        e.setFlavorIcon();
        e.setHoverText("Add " + getCrudBuilder().getChildLabel());
        e.setIcon().nameAddCircleOutline();
        e.setAction(newCheckedAction(this::handleAdd));
        e.hide();
        _addButton = e;
        return e;
    }

    private ScControl createPopupMenu()
    {
        ScPopupMenu e;
        e = new ScPopupMenu();
        installMenuItemsOn(e);
        return e;
    }

    /**
     * @param e
     */
    protected void installMenuItemsOn(ScPopupMenu e)
    {
        // none
    }

    //==================================================
    //= install :: list
    //==================================================

    private void installListOn(ScGroup group)
    {
        ScDiv body;
        body = group.getBody();
        body.add(createList());
    }

    private ScSimpleModelList<C> createList()
    {
        ScAction selectAction = newCheckedAction(this::handleSelect);

        MyCrudBuilder<P,C> b = getCrudBuilder();
        Function<C,String> title = b.getChildTitleFunction();
        Predicate<C> active = b.getChildEnabled();
        Function<C,String> subtitle = b.getChildSubtitleFunction();
        Function<C,String> errorFn = b.getChildErrorFunction();

        ScSimpleModelList<C> list;
        list = new ScSimpleModelList<>();
        list.css().fill();
        list.setKeyFunction(KmUidDomainIF.getUidAdaptor());
        list.setTitleFunction(title);
        list.setEnabled(active);
        list.setSubtitleFunction(subtitle);
        list.setErrorFunction(errorFn);
        list.setItemAction(selectAction);
        _list = list;
        return list;
    }

    //==================================================
    //= install :: navigation
    //==================================================

    private void installNavigationOn(ScGroup group)
    {
        ScDiv root;
        root = group.showFooter();
        root.css().modelList_navigation();
        root.add(createStartButton());
        root.add(createPreviousButton());
        root.addFlexChildFiller();
        root.add(createPageText());
        root.addFlexChildFiller();
        root.add(createNextButton());
        root.add(createEndButton());
    }

    private ScControl createStartButton()
    {
        ScActionButton e;
        e = new ScActionButton();
        e.setFlavorIcon();
        e.setIcon().nameFirstPage();
        e.setAction(newCheckedAction(this::handleGotoStart));
        return e;
    }

    private ScControl createPreviousButton()
    {
        ScActionButton e;
        e = new ScActionButton();
        e.setFlavorIcon();
        e.setIcon().nameNavigateBefore();
        e.setAction(newCheckedAction(this::handleGotoPrevious));
        return e;
    }

    private ScControl createNextButton()
    {
        ScActionButton e;
        e = new ScActionButton();
        e.setFlavorIcon();
        e.setIcon().nameNavigateNext();
        e.setAction(newCheckedAction(this::handleGotoNext));
        return e;
    }

    private ScControl createEndButton()
    {
        ScActionButton e;
        e = new ScActionButton();
        e.setFlavorIcon();
        e.setIcon().nameLastPage();
        e.setAction(newCheckedAction(this::handleGotoEnd));
        return e;
    }

    private ScControl createPageText()
    {
        ScTextSpan e;
        e = new ScTextSpan();
        e.css().modelList_pageText();
        _pageInfoText = e;
        return e;
    }

    //##################################################
    //# listener :: refresh
    //##################################################

    @Override
    public final void onRefresh(Runnable e)
    {
        _refreshListener = e;
    }

    protected void fireRefresh()
    {
        fire(_refreshListener);
    }

    //==================================================
    //= listener :: add
    //==================================================

    @Override
    public final void onAdd(Runnable e)
    {
        _addListener = e;
    }

    private void fireAdd()
    {
        fire(_addListener);
    }

    //==================================================
    //= listener :: select
    //==================================================

    @Override
    public final void onSelect(Consumer<C> e)
    {
        _selectListener = e;
    }

    private void fireSelect(C e)
    {
        fire(_selectListener, e);
    }

    //##################################################
    //# accessing
    //##################################################

    private int getRowIndex()
    {
        return getPageIndex() * getPageSize();
    }

    private int getPageSize()
    {
        return PAGE_SIZE;
    }

    public int getRowCount()
    {
        return _rowCountField.getValue();
    }

    public void setRowCount(int i)
    {
        _rowCountField.setValue(i);
    }

    private int getPageCount()
    {
        int n = getRowCount();
        return n == 0
            ? 0
            : (n - 1) / getPageSize() + 1;
    }

    //##################################################
    //# domain
    //##################################################

    /**
     * A convenience method to set the domain parent and/or child.
     * At least one of the parameters must be non-null.
     * If both are provided, they must match.
     */
    @Override
    public final void setDomain(P parent, C child)
    {
        KmTuple<P,C> result = getCrudBuilder().reconcileParentChild(parent, child);
        String parentUid = KmUidDomainIF.getUidFor(result.getKey());
        String childUid = KmUidDomainIF.getUidFor(result.getValue());

        _domainParentUid.setValue(parentUid);
        _domainChildUid.setValue(childUid);
    }

    //==================================================
    //= domain :: parent
    //==================================================

    public final P getDomainParent()
    {
        return getCrudBuilder().findParent(_domainParentUid);
    }

    /**
     * Set the list to a specific parent.
     * The list of children are inferred from the parent.
     * If you want to select a specific child, use setDomainChild instead.
     * You should NOT call both setDomainParent and setDomainChild.
     */
    @Override
    public final void setDomainParent(P parent)
    {
        setDomain(parent, null);
    }

    //==================================================
    //= domain :: child
    //==================================================

    public final C getDomainChild()
    {
        return getCrudBuilder().findChild(_domainChildUid);
    }

    /**
     * Set the list to a specific child selection.
     * The child must be non-NULL, and is used to infer the parent.
     * If you don't a specific child, use setDomainParent instead.
     * You should NOT call both setDomainParent and setDomainChild.
     */
    @Override
    public final void setDomainChild(C child)
    {
        setDomain(null, child);
    }

    public final boolean hasDomainChild()
    {
        return getDomainChild() != null;
    }

    //##################################################
    //# downcast
    //##################################################

    @Override
    protected final boolean applyFromModel_here(Object model)
    {
        super.applyFromModel_here(model);

        @SuppressWarnings("unchecked")
        P parent = (P)model;

        setDomainParent(parent);
        return false;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        preRenderFilterSelection();

        search();

        if ( hasDomainChild() )
            _list.setInitialSelection(getDomainChild());
    }

    private void preRenderFilterSelection()
    {
        if ( _filterField.hasValue() )
            return;

        MyFilterTemplate def = findPreferredTemplate();
        if ( def == null )
            _filterField.selectFirstValue();
        else
            _filterField.setValue(def);
    }

    //##################################################
    //# handle :: goto
    //##################################################

    private void handleGotoStart()
    {
        ajaxGotoPage(0);
    }

    private void handleGotoEnd()
    {
        ajaxGotoPage(Integer.MAX_VALUE);
    }

    private void handleGotoNext()
    {
        ajaxGotoPage(getPageIndex() + 1);
    }

    private void handleGotoPrevious()
    {
        ajaxGotoPage(getPageIndex() - 1);
    }

    //==================================================
    //= handle :: list
    //==================================================

    private void handleSelect()
    {
        String uid = getData().getStringArgument();

        C e = getCrudBuilder().findChild(uid);
        if ( e == null )
        {
            ajaxToast("Invalid Uid: " + uid);
            return;
        }

        ajaxSelectDomain(e);
        fireSelect(e);
    }

    private void handleAdd()
    {
        P parent = getDomainParent();
        MyCrudBuilder<P,C> b = getCrudBuilder();
        KmSimpleResult r = b.allowsAddFor(parent);

        if ( r.hasError() )
        {
            b.showCannotAddDialog(r);
            return;
        }

        _list.ajaxClearSelection();
        fireAdd();
    }

    //==================================================
    //= handle :: callback
    //==================================================

    @Override
    public void handleAddSaved(MyCrudSaveEvent<C> ev)
    {
        C c = ev.getChild();
        boolean more = ev.getAddMore();
        boolean updateList = ev.getUpdateList();

        updateRowCount();
        updateBanner();
        _title.ajaxReplace();

        if ( updateList )
            ajaxRefreshList();
        else
            ajaxInsertIntoList(c);

        if ( !more )
            ajaxUpdateListSelection(c);
    }

    @Override
    public void handleEditSaved(C c)
    {
        ajaxRefreshDomain(c);
        ajaxUpdateListSelection(c);
    }

    @Override
    public void handleDeleted(C c)
    {
        updateRowCount();
        updateBanner();
        _title.ajaxReplace();

        ajaxRemoveFromList(c);
    }

    @Override
    public void handleChildChanged(C c)
    {
        ajaxRefreshDomain(c);
        ajaxUpdateListSelection(c);
    }

    @Override
    public void handleChildListChanged(C c)
    {
        ajaxRefreshList();
        ajaxUpdateListSelection(c);
    }

    private void handleEditFilter()
    {
        MyFilterTemplate template = getSelectedTemplate();
        editFilter(template);
    }

    //==================================================
    //= handle :: filter
    //==================================================

    private void handleSearchChanged()
    {
        ajaxSearch();
    }

    private void handleSelectFilter()
    {
        ajaxSearch();
    }

    private void handleSaveFilter()
    {
        MyFilterTemplate sel = getSelectedTemplate();
        if ( sel == null )
        {
            ajaxToast("No selection.");
            return;
        }

        if ( !sel.isModified() )
        {
            ajaxToast("Saved.");
            return;
        }

        MyFilterTemplateType type = sel.getType();
        switch ( type )
        {
            case Predefined:
                savePredefinedTemplate(sel);
                break;

            case Shared:
                saveSharedTemplate(sel);
                break;
        }
    }

    private void handleSaveAsFilter()
    {
        _filterSaveAsDialog.ajaxOpen(getSelectedTemplate());
    }

    private void savePredefinedTemplate(MyFilterTemplate e)
    {
        _filterSaveAsDialog.ajaxOpen(e);
    }

    private void saveSharedTemplate(MyFilterTemplate modified)
    {
        MyFilterTemplate e;
        e = modified.findOriginalTemplate();

        if ( e == null )
            e = new MyFilterTemplate();

        e.applyFrom(modified, false);
        e.setModified(false);
        e.daoAttach();

        ajaxSelectTemplate(e);
    }

    private void handleRenameFilter()
    {
        MyFilterTemplate sel = getSelectedTemplate();
        if ( sel.isModified() )
        {
            MyNotifyDialog e;
            e = MyDialogs.getNotifyDialog();
            e.setTitle("Cannot Rename");
            e.setSubtitle("Cannot rename filter until it is saved.");
            e.setMessage("Please save the changes to this filter before renaming it.");
            e.ajaxOpen();
            return;
        }

        if ( sel.isTypePredefined() )
        {
            MyNotifyDialog e;
            e = MyDialogs.getNotifyDialog();
            e.setTitle("Cannot Rename");
            e.setSubtitle("Cannot rename predefined filters.");
            e.setMessage("Predefined filters cannot be modified, renamed, or deleted.");
            e.ajaxOpen();
            return;
        }

        _filterRenameDialog.ajaxOpen(sel);
    }

    //==================================================
    //= handle :: delete filter
    //==================================================

    private void handleDeleteFilter()
    {
        MyFilterTemplate sel = getSelectedTemplate();
        if ( sel.isModified() )
        {
            handleDeleteModifiedFilter();
            return;
        }

        if ( sel.isTypePredefined() )
        {
            handleDeletePredefinedFilter();
            return;
        }

        handleDeleteSharedFilter();
    }

    private void handleDeleteModifiedFilter()
    {
        ajaxSelectTemplate(null);
    }

    private void handleDeletePredefinedFilter()
    {
        String msg = ""
            + "Predefined filters are part of the base application "
            + "and cannot be removed or overwritten."
            + "";

        MyNotifyDialog e;
        e = MyDialogs.getNotifyDialog();
        e.setTitle("Cannot Delete Filter");
        e.setSubtitle("You cannot delete predefined filters.");
        e.setMessage(msg);
        e.ajaxOpen();
    }

    private void handleDeleteSharedFilter()
    {
        MyConfirmDialog e;
        e = MyDialogs.getConfirmDialog();
        e.setTitle("Delete Filter?");
        e.setSubtitle("Permanently delete the shared filter?");
        e.setMessage("This will permanently delete this filter for all users on this project.");
        e.setPositiveText("Delete Filter");
        e.setPositiveAction(_deleteConfirmedAction, getSelectedTemplate().getUid());
        e.setFlavorCaution();
        e.ajaxOpen();
    }

    private void handleDeleteConfirmed()
    {
        String uid = getData().getStringArgument();

        MyFilterTemplate e;
        e = getAccess().findFilterTemplateUid(uid);
        e.setDeleted(true);
        e.validateAndCheck();

        ajaxSelectTemplate(null);
    }

    //##################################################
    //# ajax
    //##################################################

    protected void ajaxSearch()
    {
        search();

        if ( getRowCount() == 1 )
            _list.selectFirst();

        _pageIndexField.ajaxUpdateFieldValues();
        _rowCountField.ajaxUpdateFieldValues();

        _list.ajaxUpdateValues();
        _list.ajaxUpdateSelection();
        _title.ajaxReplace();
        _pageInfoText.ajaxReplace();
        _addButton.ajaxReplace();

        if ( _list.hasInitialSelection() )
            fireSelect(_list.getInitialSelection());
    }

    private void ajaxSelectDomain(C e)
    {
        _domainChildUid.setValue(e.getUid());
        ajaxUpdateListSelection(e);
    }

    public void ajaxUpdateListSelection(C e)
    {
        _list.ajaxScrollTo(e);
        _list.ajaxSelect(e);
    }

    @Override
    public void ajaxRefreshList()
    {
        updateList();

        _list.ajaxUpdateValues();
        _list.ajaxClearSelection();
        _list.ajaxScrollToTop();
    }

    public void ajaxRefreshList(C selection)
    {
        setDomainChild(selection);
        updateList();

        _list.ajaxUpdateValues();
        _list.ajaxSelect(selection);
        _list.ajaxScrollTo(selection);
    }

    private void ajaxGotoPage(int i)
    {
        int pageCount = getPageCount();
        if ( pageCount == 0 )
            i = 0;
        else
            i = Kmu.constrain(i, 0, pageCount - 1);

        setPageIndex(i);
        _pageIndexField.ajaxUpdateFieldValues();

        updateList();
        _list.ajaxReplace();

        updatePageInfo();
        _pageInfoText.ajaxReplace();
    }

    @Override
    public void ajaxRefreshListItems()
    {
        updateList();
        _list.ajaxUpdateValues();
    }

    private void ajaxRefreshDomain(C e)
    {
        _list.ajaxRefresh(e);
    }

    private void ajaxInsertIntoList(C e)
    {
        updateList();
        KmList<C> v = _list.getValues();
        C prev = v.getPreviousSafe(e);

        if ( prev == null )
            _list.ajaxPrependValue(e);
        else
            _list.ajaxInsertAfter(e, prev);
    }

    private void ajaxRemoveFromList(C e)
    {
        _list.ajaxRemoveValue(e);
    }

    //##################################################
    //# search / update
    //##################################################

    private void search()
    {
        saveFieldValues();
        resetIndex();
        updateRowCount();
        updateList();
        updateBanner();
        updatePageInfo();
        updateAddButton();
    }

    private void resetIndex()
    {
        _pageIndexField.setValue(0);
    }

    private void updateRowCount()
    {
        int rowCount = findChildCount();
        _rowCountField.setValue(rowCount);
    }

    private void updateList()
    {
        int index = getRowIndex();
        int count = getPageSize();
        KmList<C> v = findChildren(index, count);

        _list.setValues(v);
        _list.clearInitialSelection();
    }

    private void updateBanner()
    {
        String name = getPluralDomainName();
        String count = getFormatter().formatInteger(getRowCount());
        String s = Kmu.format("%s (%s)", name, count);
        _title.setValue(s);
    }

    private void updatePageInfo()
    {
        int pageNum = getPageIndex() + 1;
        int pageCount = getPageCount();
        String s = formatPageInfo(pageNum, pageCount);
        _pageInfoText.setValue(s);
    }

    private void updateAddButton()
    {
        P parent = getDomainParent();
        boolean allowsAdd = getCrudBuilder().showsAddFor(parent);
        if ( allowsAdd )
            _addButton.show();
    }

    //##################################################
    //# get templates
    //##################################################

    private KmList<MyFilterTemplate> getTemplates()
    {
        KmList<MyFilterTemplate> v = findStandardTemplates();

        if ( _filterField.hasValue() )
        {
            MyFilterTemplate e = _filterField.getValue();
            if ( !v.contains(e) )
                v.addFirst(e);
        }

        return v;
    }

    //##################################################
    //# find standard templates
    //##################################################

    private KmList<MyFilterTemplate> findStandardTemplates()
    {
        KmList<MyFilterTemplate> saved = findSavedTemplates();

        KmList<MyFilterTemplate> v;
        v = new KmList<>();
        v.addAll(lazyGetPredefined(saved));
        v.addAll(getShared(saved));
        return v;
    }

    private KmList<MyFilterTemplate> findSavedTemplates()
    {
        MyFilterTemplateCriteria c;
        c = getAccess().getFilterTemplateDao().createCriteria();
        c.whereProjectIs(getFilterProject());
        c.whereContextTypeIs(getContextType());
        c.whereModified().isFalse();
        c.whereDeleted().isFalse();
        return c.findAll();
    }

    private KmList<MyFilterTemplate> lazyGetPredefined(KmList<MyFilterTemplate> nonTemporary)
    {
        KmList<MyFilterTemplate> predefined = nonTemporary.select(e -> e.isTypePredefined());
        KmList<String> predefinedNames = predefined.collect(e -> e.getName());

        for ( MyFilterTemplate candidate : findPredefinedCandidates() )
        {
            String name = candidate.getName();
            if ( !predefinedNames.contains(name) )
            {
                candidate.daoAttach();
                predefined.add(candidate);
            }
        }

        predefined.sort(e -> e.getName());
        return predefined;
    }

    private KmList<MyFilterTemplate> findPredefinedCandidates()
    {
        MyProject project = getFilterProject();
        MyFilterTemplateContextType context = getContextType();

        return findPredefinedCandidates(project, context);
    }

    protected abstract KmList<MyFilterTemplate> findPredefinedCandidates(
        MyProject project,
        MyFilterTemplateContextType context);

    private KmList<MyFilterTemplate> getShared(KmList<MyFilterTemplate> nonTemp)
    {
        KmList<MyFilterTemplate> v;
        v = nonTemp.select(e -> e.isTypeShared());
        v.sortOn(e -> e.getName());
        return v;
    }

    private MyFilterTemplate findPreferredTemplate()
    {
        return findStandardTemplates().selectFirst(e -> e.isPreferred());
    }

    //##################################################
    //# support
    //##################################################

    protected final MyGlobals getGlobals()
    {
        return MyGlobals.instance;
    }

    protected final MyDaoAccess getAccess()
    {
        return getGlobals().getAccess();
    }

    private String getPluralDomainName()
    {
        String name = getCrudBuilder().getChildLabel();
        return Kmu.pluralize(name);
    }

    private int getPageIndex()
    {
        return _pageIndexField.getValue();
    }

    private void setPageIndex(int i)
    {
        _pageIndexField.setValue(i);
    }

    private String formatPageInfo(int pageNum, int pageCount)
    {
        int of = pageCount == 0
            ? 1
            : pageCount;

        return Kmu.format("Page %,d of %,d", pageNum, of);
    }

    protected String formatActive(Boolean e)
    {
        return Kmu.formatBoolean(e, "Active", "Inactive", "All");
    }

    protected String formatOpen(Boolean e)
    {
        return Kmu.formatBoolean(e, "Open", "Closed", "All");
    }

    protected MyFilterTemplate getSelectedTemplate()
    {
        return _filterField.getValue();
    }

    //##################################################
    //# abstract
    //##################################################

    protected abstract MyProject getFilterProject();

    protected abstract MyFilterTemplateContextType getContextType();

    protected abstract void editFilter(MyFilterTemplate template);

    protected void ajaxSelectTemplate(MyFilterTemplate e)
    {
        if ( e == null )
            e = findPreferredTemplate();

        if ( e == null )
            _filterField.selectFirstValue();
        else
            _filterField.setValue(e);

        _filterField.ajaxReplace();

        ajaxSearch();
    }

}
