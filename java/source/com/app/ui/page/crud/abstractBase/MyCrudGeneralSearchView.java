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
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScLink;
import com.kodemore.servlet.control.ScPopupMenu;
import com.kodemore.servlet.control.ScSimpleModelList;
import com.kodemore.servlet.control.ScSubmitButton;
import com.kodemore.servlet.control.ScTextSpan;
import com.kodemore.servlet.field.ScHiddenField;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.types.KmTuple;
import com.kodemore.utility.KmSimpleResult;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoAccess;
import com.app.model.MyProject;
import com.app.utility.MyGlobals;
import com.app.utility.MyUtility;

/**
 * I display a paginated list, using the ScSimpleModelList to render
 * each page. I incorporate support for filters.
 *
 * @param <P> The PARENT, used to get the list.
 * @param <C> The CHILD, the selected list item.
 */
public abstract class MyCrudGeneralSearchView<P extends KmUidDomainIF, C extends KmUidDomainIF>
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
    //= variables :: filter
    //==================================================

    private ScDiv _basicFieldContainer;

    private ScDiv      _extendedFieldContainer;
    private ScDiv      _extendedMessageContainer;
    private ScTextSpan _extendedMessageText;

    /**
     * Used to reset the filter fields.
     * Hidden if there are not fields.
     */
    private ScLink _resetLink;

    /**
     * The button used to add a new domain object.
     * Visibility is controlled dynamically and may depend on
     * things like the current user.
     */
    private ScActionButton _addButton;

    /**
     * The button used to print the list of children.
     * Visibility is controlled dynamically.
     */
    private ScActionButton _printButton;

    private ScActionButton _expandFilterButton;
    private ScActionButton _collapseFilterButton;

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

    public MyCrudGeneralSearchView(MyCrudBuilder<P,C> e)
    {
        _crudBuilder = e;

        installUids();
        installLayout();
    }

    protected MyCrudBuilder<P,C> getCrudBuilder()
    {
        return _crudBuilder;
    }

    //##################################################
    //# abstract
    //##################################################

    /**
     * Install the basic filter fields onto the root.
     * These fields are always displayed.
     *
     * Styling for things such as background, border, and padding
     * is provided and should NOT be set by the subclass.
     */
    protected abstract void installBasicFieldsOn(ScDiv root);

    /**
     * Install the extended filter fields onto the root.
     * These fields are only displayed upon request, but they
     * should always be applied to the search criteria.
     *
     * Styling for things such as background, border, and padding
     * is provided and should NOT be set by the subclass.
     */
    protected abstract void installExtendedFieldsOn(ScDiv root);

    /**
     * Return a brief summary of the extended fields. If not empty,
     * this is displayed when the extended filter is hidden.
     * @param v
     */
    protected abstract void addExtendedMessagesTo(KmList<String> v);

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

    /**
     * The get value holder for the Domain Parent Uid.
     * Used by subclasses if they need to track it for things like autocomplete fields.
     */
    protected ScLocalString _getDomainParentUidValue()
    {
        return _domainParentUid;
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
        form.onSubmit(newUncheckedAction(this::handleSearch));
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
        group.setFlavorList();

        installBannerOn(group);
        installFilterOn(group);
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
    private void installFilterOn(ScGroup group)
    {
        ScDiv header;
        header = group.showHeader();
        header.css().modelList_filter();

        ScDiv top;
        top = header.addDiv();
        top.css().flexRow().flexAlignSpaced();

        ScDiv left;
        left = top.addDiv();
        left.css().flexChildFiller().auto();
        left.add(createBasicFilterContainer());
        left.add(createExtendedMessageContainer());
        left.add(createExtendedFilterContainer());

        ScDiv right;
        right = top.addDiv();
        right.css().flexChildStatic();
        right.add(createPopupMenu());

        header.add(createActionContainer());
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

    private ScControl createBasicFilterContainer()
    {
        ScDiv e;
        e = new ScDiv();
        e.css().modelList_basicFilterContainer();

        installBasicFieldsOn(e);
        e.hide();

        _basicFieldContainer = e;
        return e;
    }

    private ScControl createExtendedMessageContainer()
    {
        ScDiv e;
        e = new ScDiv();
        e.css().modelList_extendedMessageContainer();
        e.addLabel("More");
        e.add(createExpandFilterButton());
        e.add(createCollapseFilterButton());
        e.add(createExtendedMessageText());
        e.hide();
        _extendedMessageContainer = e;
        return e;
    }

    private ScControl createExpandFilterButton()
    {
        ScActionButton e;
        e = new ScActionButton();
        e.setHoverText("Expand the filter options.");
        e.setFlavorIcon();
        e.setIcon().nameExpandMore();
        e.setAction(newCheckedAction(this::handleExpandFilter));
        e.hide();
        _expandFilterButton = e;
        return e;
    }

    private ScControl createCollapseFilterButton()
    {
        ScActionButton e;
        e = new ScActionButton();
        e.setHoverText("Collapse the filter options.");
        e.setFlavorIcon();
        e.setIcon().nameExpandLess();
        e.setAction(newCheckedAction(this::handleCollapseFilter));
        e.hide();
        _collapseFilterButton = e;
        return e;
    }

    private ScTextSpan createExtendedMessageText()
    {
        ScTextSpan e;
        e = new ScTextSpan();
        e.css().modelList_extendedMessageText();
        e.hide();
        _extendedMessageText = e;
        return e;
    }

    private ScControl createExtendedFilterContainer()
    {
        ScDiv e;
        e = new ScDiv();
        e.css().modelList_extendedFilterContainer();
        e.hide();

        installExtendedFieldsOn(e);

        _extendedFieldContainer = e;
        return e;
    }

    //==================================================
    //= install :: filter actions
    //==================================================

    private ScControl createActionContainer()
    {
        ScDiv e;
        e = new ScDiv();
        e.css().modelList_filterActions().flexRow().flexCrossAlignCenter().rowSpacer5();
        e.add(createResetLink());
        e.addFlexChildFiller();
        e.add(createPrintButton());
        e.add(createAddButton());
        e.add(createSearchButton());
        return e;
    }

    private ScControl createResetLink()
    {
        ScLink e;
        e = new ScLink();
        e.setText("Reset Filter");
        e.setAction(newCheckedAction(this::handleReset));
        e.hide();
        _resetLink = e;
        return e;
    }

    private ScControl createAddButton()
    {
        ScActionButton e;
        e = new ScActionButton();
        e.setHoverText("Add");
        e.setFlavorIcon();
        e.setIcon().nameAddCircleOutline();
        e.setAction(newCheckedAction(this::handleAdd));
        e.hide();
        _addButton = e;
        return e;
    }

    private ScControl createPrintButton()
    {
        ScActionButton e;
        e = new ScActionButton();
        e.setHoverText("Print");
        e.setFlavorIcon();
        e.setIcon().namePrint();
        e.setAction(newCheckedAction(this::handlePrint));
        e.hide();
        _printButton = e;
        return e;
    }

    private ScControl createSearchButton()
    {
        // action is controlled by form.submitAction

        ScSubmitButton e;
        e = new ScSubmitButton();
        e.setText("Search");
        e.setFlavorPositive();
        e.setIcon().nameSearch().styleLight();
        return e;
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
    //# filter :: testing
    //##################################################

    private boolean hasFilterFields()
    {
        return hasBasicFields() || hasExtendedFields();
    }

    private boolean hasBasicFields()
    {
        return !_basicFieldContainer.isEmpty();
    }

    private boolean hasExtendedFields()
    {
        return !_extendedFieldContainer.isEmpty();
    }

    //##################################################
    //# listener :: refresh
    //##################################################

    @Override
    public final void onRefresh(Runnable e)
    {
        _refreshListener = e;
    }

    private void fireRefresh()
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

    public final MyProject getProject()
    {
        return MyUtility.getProjectFor(getDomainParent());
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

        search();

        if ( hasDomainChild() )
            _list.setInitialSelection(getDomainChild());

        if ( hasFilterFields() )
            _resetLink.show();

        if ( hasBasicFields() )
            _basicFieldContainer.show();

        if ( hasExtendedFields() )
        {
            updateExtendedMessage();
            _extendedMessageContainer.show();
            _extendedMessageText.show();
            _expandFilterButton.show();
        }

        _printButton.show(showsPrintButton());
    }

    //##################################################
    //# handle
    //##################################################

    private void handleReset()
    {
        ScDiv root;
        root = getFilterContainer();
        root.resetFieldValues();
        root.ajaxUpdateFieldValues();

        ajaxSearch();
    }

    private void handleSearch()
    {
        ScDiv root;
        root = getFilterContainer();
        root.saveFieldValues();

        ajaxSearch();
    }

    private void handleExpandFilter()
    {
        _extendedFieldContainer.ajaxShow();
        _extendedMessageText.ajaxHide();
        _expandFilterButton.ajaxHide();
        _collapseFilterButton.ajaxShow();
    }

    private void handleCollapseFilter()
    {
        updateExtendedMessage();

        _extendedMessageText.show();
        _extendedMessageText.ajaxReplace();
        _extendedMessageContainer.ajaxShow();

        _extendedFieldContainer.ajaxHide();
        _expandFilterButton.ajaxShow();
        _collapseFilterButton.ajaxHide();
    }

    //==================================================
    //= handle :: navigation
    //==================================================

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

    //==================================================
    //= handle :: add
    //==================================================

    protected void handleAdd()
    {
        if ( checkAdd() )
            ajaxShowAddView();
    }

    private void ajaxShowAddView()
    {
        _list.ajaxClearSelection();
        fireAdd();
    }

    protected boolean checkAdd()
    {
        P parent = getDomainParent();
        MyCrudBuilder<P,C> b = getCrudBuilder();
        KmSimpleResult r = b.allowsAddFor(parent);

        if ( r.isOk() )
            return true;

        b.showCannotAddDialog(r);
        return false;
    }

    //==================================================
    //= print
    //==================================================

    protected boolean showsPrintButton()
    {
        return false;
    }

    protected void handlePrint()
    {
        // subclass
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

        ajaxUpdateExtendedMessageText();

        _list.ajaxUpdateValues();
        _list.ajaxUpdateSelection();
        _title.ajaxReplace();
        _pageInfoText.ajaxReplace();
        _addButton.ajaxReplace();

        if ( _list.hasInitialSelection() )
            fireSelect(_list.getInitialSelection());
        else
            fireRefresh();
    }

    private void ajaxUpdateExtendedMessageText()
    {
        String s = formatExtendedMessage();
        _extendedMessageText.ajaxSetText(s);
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
        resetIndex();
        updateExtendedMessage();
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

    private void updateExtendedMessage()
    {
        _extendedMessageText.setValue(formatExtendedMessage());
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
    //# support
    //##################################################

    protected final MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

    private String getPluralDomainName()
    {
        String name = getCrudBuilder().getChildLabel();
        return Kmu.pluralize(name);
    }

    private ScDiv getFilterContainer()
    {
        return _group.getHeader();
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

    protected String formatEnabled(Boolean e)
    {
        return Kmu.formatBoolean(e, "Enabled", "Disabled", "All");
    }

    protected String formatOpen(Boolean e)
    {
        return Kmu.formatBoolean(e, "Open", "Closed", "All");
    }

    private String formatExtendedMessage()
    {
        KmList<String> v;
        v = new KmList<>();

        addExtendedMessagesTo(v);

        v.removeNulls();
        v.removeDuplicates();
        v.replaceAll(e -> e.trim());
        v.removeIf(e -> e.isEmpty());

        return v.isEmpty()
            ? "[none]"
            : v.join();
    }

}
