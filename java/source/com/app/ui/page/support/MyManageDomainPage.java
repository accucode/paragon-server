package com.app.ui.page.support;

import com.kodemore.collection.KmList;
import com.kodemore.meta.KmMetaStringProperty;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScCard;
import com.kodemore.servlet.control.ScCardFrame;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFlexbox;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScScriptLink;
import com.kodemore.servlet.control.ScSimpleModelList;
import com.kodemore.servlet.control.ScSplitter;
import com.kodemore.servlet.control.ScTextSpan;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.script.ScScriptIF;
import com.kodemore.servlet.variable.ScLocalString;

import com.app.model.core.MyAbstractDomain;
import com.app.ui.page.MyAbstractEntryPage;
import com.app.utility.MyButtonUrls;

public abstract class MyManageDomainPage<T extends MyAbstractDomain>
    extends MyAbstractEntryPage
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalString        _uid;

    private ScFlexbox            _filterSection;
    private ScTextField          _filterField;
    private ScActionButton       _refreshButton;
    private ScActionButton       _addButton;

    private ScSimpleModelList<T> _list;
    private ScCardFrame          _frame;

    //##################################################
    //# navigation
    //##################################################

    @Override
    public ScParameterList composeQueryParameters()
    {
        ScParameterList v = super.composeQueryParameters();
        if ( v == null )
            v = new ScParameterList();

        if ( _uid.hasValue() )
            v.setValue("uid", _uid.getValue());

        return v;
    }

    @Override
    public void applyQueryParameters(ScParameterList params)
    {
        super.applyQueryParameters(params);

        if ( params.hasValue("uid") )
        {
            String uid = params.getValue("uid");
            T e = findDomain(uid);
            if ( e != null )
                _uid.setValue(uid);
        }
    }

    //##################################################
    //# accessing
    //##################################################

    protected ScSimpleModelList<T> getList()
    {
        return _list;
    }

    protected ScCardFrame getFrame()
    {
        return _frame;
    }

    protected ScFlexbox getFilterSection()
    {
        return _filterSection;
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().fill();

        _uid = new ScLocalString();
        _uid.setAutoSave();

        installDialogsOn(root);

        ScSplitter splitter;
        splitter = root.addSplitter();
        splitter.css().fill();

        installLeftOn(splitter);
        installRightOn(splitter);
    }

    protected abstract void installDialogsOn(ScContainer root);

    //==================================================
    //= install :: left
    //==================================================

    private void installLeftOn(ScDiv root)
    {
        ScFlexbox col;
        col = root.addColumn();
        col.css().fill();

        installFilterOn(col);
        installListOn(col);
        installFilterScript();
    }

    private void installFilterOn(ScFlexbox root)
    {
        ScFlexbox row;
        row = root.addRow();
        row.alignSpaced();
        row.css().formFilter().flexStatic();

        installFilterLeftOn(row);
        installFilterRightOn(row);

        _filterSection = row;
    }

    private void installFilterLeftOn(ScFlexbox root)
    {
        ScFlexbox left;
        left = root.addRow();
        left.crossAlignCenter();
        left.css().overflowHidden().pad();

        ScTextSpan span;
        span = left.addTextSpan("Find ");
        span.css().bold().flexStatic();

        left.addSpace();

        _filterField = left.addTextField();
        _filterField.style().width(175);
        _filterField.css().flexShrink();

        left.addSpace();

        ScScriptLink clearLink;
        clearLink = left.addScriptLink();
        clearLink.setText("show all");
        clearLink.setScript(getClearFilterScript());
        clearLink.css().flexStatic();
    }

    private void installFilterRightOn(ScFlexbox root)
    {
        ScDiv right;
        right = root.addButtonBox();
        right.css().flexStatic();

        _refreshButton = right.addButton();
        _refreshButton.setImage(MyButtonUrls.refresh());
        _refreshButton.setAction(this::handleRefresh);
        _refreshButton.setHoverText("Refresh");

        _addButton = right.addButton();
        _addButton.setImage(MyButtonUrls.add());
        _addButton.setAction(this::handleAdd);
        _addButton.setHoverText("Add");
    }

    private ScScriptIF getClearFilterScript()
    {
        ScHtmlIdAjax script;
        script = new ScHtmlIdAjax(_filterField);
        script.clearValue();
        script.fireOnChange();
        return script;
    }

    private void installFilterScript()
    {
        _list.installFilterOn(_filterField);
    }

    private void installListOn(ScFlexbox root)
    {
        Runnable selectRunnable = this::handleSelect;

        _list = new ScSimpleModelList<>();
        _list.setKeyAdapter(getDomainUidProperty());
        _list.setTitleAdapter(getDomainTitleProperty());
        _list.setSubtitleAdapter(getDomainSubtitleProperty());
        _list.addLink("Select", selectRunnable);
        _list.setItemAction(selectRunnable);

        ScDiv center;
        center = root.addDiv();
        center.css().outset().flexFiller().relative();
        center.add(_list);
    }

    //==================================================
    //= install :: right
    //==================================================

    private void installRightOn(ScDiv root)
    {
        _frame = root.addFrame();
        _frame.addDefaultCard(newDefaultCard());
        _frame.css().fill();

        installCardsOn(_frame);
    }

    private ScCard newDefaultCard()
    {
        ScCard e;
        e = new ScCard();
        e.css().formEmpty().fill();
        e.addTextSpan("Make a selection on the left.");
        return e;
    }

    protected abstract void installCardsOn(ScCardFrame frame);

    //##################################################
    //# actions
    //##################################################

    protected abstract void ajaxOpenAddDialog();

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        _list.setValues(findSortedDomains());
    }

    @Override
    protected void postRender()
    {
        super.postRender();

        if ( _uid.isEmpty() )
            return;

        String uid = _uid.getValue();

        getLayout().ajaxPushWhenContentDone();
        ajaxSelectDomain(uid);
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSelect()
    {
        String uid = getStringArgument();
        ajaxSelectDomain(uid);
    }

    private void handleAdd()
    {
        ajaxClearDomain();
        ajaxOpenAddDialog();
    }

    private void handleRefresh()
    {
        _filterField.ajax().clearValue();

        _list.ajaxSetValues(findSortedDomains());
        _list.ajaxClearSelection();
        _list.ajaxScrollToTop();

        _frame.ajaxPrintDefault();
    }

    //##################################################
    //# ajax
    //##################################################

    public void ajaxAddDomain(T e)
    {
        KmList<T> v = findSortedDomains();
        T prev = v.getPreviousSafe(e);

        if ( prev == null )
            _list.ajaxPrependValue(e);
        else
            _list.ajaxInsertAfter(e, prev);
    }

    public void ajaxRemoveDomain(T e)
    {
        _list.ajaxRemoveValue(e);
    }

    public void ajaxSelectDomain(String uid)
    {
        T e = findDomain(uid);

        if ( e == null )
        {
            ajax().toast("Invalid Uid: " + uid);
            return;
        }

        ajaxSelectDomain(e);
    }

    public void ajaxSelectDomain(T e)
    {
        _uid.setValue(getUidFor(e));

        ajax().replaceHistory(this);

        _list.ajaxScrollTo(e);
        _list.ajaxSelect(e);

        ajaxOpenViewCard();
    }

    /**
     * View the domain details in the card frame.
     */
    protected abstract void ajaxOpenViewCard();

    public void ajaxRefreshDomain(T e)
    {
        _list.ajaxRefresh(e);
    }

    //##################################################
    //# support
    //##################################################

    private String getUidFor(T e)
    {
        return getDomainUidProperty().getAdaptor().getValue(e);
    }

    protected String getTitleFor(T e)
    {
        if ( e == null )
            return "<None>";

        KmMetaStringProperty<T> p = getDomainTitleProperty();
        if ( p == null )
            return e.toString();

        return p.getValueFor(e);
    }

    protected String getSubtitleFor(T e)
    {
        if ( e == null )
            return "<None>";

        KmMetaStringProperty<T> p = getDomainTitleProperty();
        if ( p == null )
            return e.toString();

        return p.getValueFor(e);
    }

    //##################################################
    //# accessing
    //##################################################

    protected T getDomain()
    {
        String uid = _uid.getValue();
        return findDomain(uid);
    }

    protected void ajaxClearDomain()
    {
        _uid.clearValue();
        _list.ajaxClearSelection();
        _frame.ajaxPrintDefault();
    }

    //##################################################
    //# abstract :: display
    //##################################################

    /**
     * I am the common display name for this domain.  The value returned should be
     * one or more english words.  The name may contain multiple words, but should
     * be all lower case.  Also the name should be singular (not plural).  The tool
     * will automatically convert to proper case and plural forms if needed.
     */
    protected abstract String getDomainName();

    //##################################################
    //# properties
    //##################################################

    /**
     * The unique identifer used to as a key to track and lookup elements in the database.
     * This utility page currently requires that uid is a string.  In most cases, other
     * primary keys such as integers and even composites can usually be accomodated by
     * coercing the key into a string and then back as needed.
     *
     * @see #findDomain(String)
     */
    protected abstract KmMetaStringProperty<T> getDomainUidProperty();

    /**
     * I determine the display text used to identify elements in the list.
     * The title text should generally be unique, though this in not a strict requirement.
     * Also, sorting should generally correspond closely to the title to minimize confusion;
     * however, this is not strictly required.
     *
     * @see findSortedDomains
     */
    protected abstract KmMetaStringProperty<T> getDomainTitleProperty();

    /**
     * I provide an optional line of additional information about each element.
     */
    protected abstract KmMetaStringProperty<T> getDomainSubtitleProperty();

    //##################################################
    //# dao
    //##################################################

    /**
     * Return the complete list of domain objects, presorted in a consistent
     * manner.  The sort sequence should typically correspond closely to the
     * display titles.
     *
     * @see #getDomainTitleProperty
     */
    protected abstract KmList<T> findSortedDomains();

    /**
     * Find the domain that corresponds to the uid identified by getDomainUidProperty.
     *
     * @see #getDomainUidProperty()
     */
    protected abstract T findDomain(String uid);

    //##################################################
    //# listeners
    //##################################################

    protected void handleAdded(T e)
    {
        ajaxAddDomain(e);
        ajaxSelectDomain(e);
    }

    protected void handleEdited(T e)
    {
        ajaxRefreshDomain(e);
        ajaxSelectDomain(e);
    }

    protected void handleRemoved(T e)
    {
        ajaxClearDomain();
        _list.ajaxRemoveValue(e);
    }

}
