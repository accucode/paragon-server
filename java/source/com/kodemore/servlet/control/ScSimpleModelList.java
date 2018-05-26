/*
  Copyright (c) 2005-2018 www.kodemore.com

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in
  all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  THE SOFTWARE.
 */

package com.kodemore.servlet.control;

import java.util.function.Function;
import java.util.function.Predicate;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmOrderedMap;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.encoder.ScDecoder;
import com.kodemore.servlet.field.ScHiddenField;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.servlet.script.ScActionScript;
import com.kodemore.servlet.script.ScFilterScript;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.script.ScSortableScript;
import com.kodemore.servlet.utility.ScJquery;
import com.kodemore.servlet.variable.ScLocal;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.Kmu;

/**
 * I specialize the abstract ModelList in order to provide a simple solution
 * that will hopefully be applicable for most situations.
 *
 * The rendering is hardcoded to support a title, subtitle, and a list of links.
 * The styling is determined by the modelList.styl.
 *
 * For customized rendering, use the ScCustomModelList instead.
 */
public class ScSimpleModelList<T>
    extends ScAbstractModelList<T>
{
    //##################################################
    //# enum
    //##################################################

    private enum LinkStyle
    {
        /**
         * Display the links in a horizontal row.
         */
        horizontal,

        /**
         * Displaly the links in a vertical column.
         */
        vertical,

        /**
         * Display the links in a popup menu positioned above the three-dot icon.
         */
        topMenu,

        /**
         * Display the links in a popup menu positioned below the three-dot icon.
         */
        bottomMenu,

        /**
         * Hide the links.
         */
        hidden;
    }

    //##################################################
    //# variables
    //##################################################

    /**
     * I am applied to each model to create a PLAIN TEXT title.
     * The title should be relatively unique, and short enough to fit on a single line.
     * This is required.
     */
    private Function<T,String> _titleFunction;

    /**
     * I am applied to each model to create a PLAIN TEXT subtitle.
     * The subtitle optionally provides extra information.
     */
    private Function<T,String> _subtitleFunction;

    /**
     * I am applied to each model to create a PLAIN TEXT warning message.
     * If the value has an warning, an indicator is displayed.
     */
    private Function<T,String> _warnFunction;

    /**
     * I am applied to each model to create a PLAIN TEXT error message.
     * If the value has an error, an indicator is displayed.
     */
    private Function<T,String> _errorFunction;

    /**
     * I am applied to each model to determine whether the item
     * is considered active. If not active, the 'inactive' style
     * is applied.
     */
    private Predicate<T> _enabled;

    /**
     * If set, this action will be executed when the list item is clicked.
     * This allows the entire row to be clickable, not just the individual
     * links.  The value's key is passed as an argument.
     */
    private ScAction _itemAction;

    /**
     * This is primarily used to pre-select a particular element when
     * initially rendering the list.
     */
    private ScLocal<T> _initialSelection;

    /**
     * If set, the item visibility will be defaulted based on the
     * filter. All items are rendered so that the client side script
     * can subsequently show/hide the items.
     */
    private ScLocalString _initialFilter;

    /**
     * If set, this action will be exectuted when the user drags an item
     * to a new position. If non-null, the model list will automatically
     * include the necessary scripting and visual drag handles.
     */
    private ScAction _dragAction;

    /**
     * If true (the default), display drag anchors when a drag action is set.
     * If false, the drag anchors are not rendered.
     */
    private ScLocalBoolean _showDragAnchors;

    /**
     * The list of actions to be displayed.  Each action is displayed
     * as a link, using the specified label.  Each link is dynamically
     * configured with model's key as as the argument, based on the key
     * adapter. The labels must be unique.
     */
    private KmOrderedMap<String,ScAction> _linkActions;

    /**
     * The style used to display the action links.
     * This corresponds to the LinkStyle enum defined above.
     */
    private ScLocalString _linkStyle;

    /**
     * If set, this function determines if the link should be disabled.
     * Return null, to indicate a normally enabled link.
     * Return non-null, to provide a reason that explains why this link is currently disabled.
     */
    private Function<T,String> _linkDisableReason;

    //##################################################
    //# constructor
    //##################################################

    public ScSimpleModelList()
    {
        _linkActions = new KmOrderedMap<>();
        _linkStyle = new ScLocalString(LinkStyle.horizontal.name());

        _initialSelection = new ScLocal<>();
        _initialFilter = new ScLocalString();

        _showDragAnchors = new ScLocalBoolean(true);

        css().modelList();
    }

    //##################################################
    //# title
    //##################################################

    public Function<T,String> getTitleFunction()
    {
        return _titleFunction;
    }

    public void setTitleFunction(Function<T,String> e)
    {
        _titleFunction = e;
    }

    private String getTitleFor(T e)
    {
        return Kmu.applySafe(_titleFunction, e);
    }

    public void clearTitleFunction()
    {
        _titleFunction = null;
    }

    //##################################################
    //# subtitle
    //##################################################

    public Function<T,String> getSubtitleFunction()
    {
        return _subtitleFunction;
    }

    public void setSubtitleFunction(Function<T,String> e)
    {
        _subtitleFunction = e;
    }

    public String getSubtitleFor(T e)
    {
        return Kmu.applySafe(_subtitleFunction, e);
    }

    public void clearSubtitleFunction()
    {
        _subtitleFunction = null;
    }

    //##################################################
    //# enabled
    //##################################################

    public Predicate<T> getEnabled()
    {
        return _enabled;
    }

    public void setEnabled(Predicate<T> e)
    {
        _enabled = e;
    }

    private boolean isEnabledFor(T e)
    {
        if ( e == null )
            return false;

        return _enabled == null
            ? true
            : _enabled.test(e);
    }

    //##################################################
    //# warn
    //##################################################

    public Function<T,String> getWarnFunction()
    {
        return _warnFunction;
    }

    public void setWarnFunction(Function<T,String> e)
    {
        _warnFunction = e;
    }

    public String getWarningFor(T e)
    {
        if ( e == null )
            return null;

        return _warnFunction == null
            ? null
            : _warnFunction.apply(e);
    }

    public void clearWarnFunction()
    {
        _warnFunction = null;
    }

    //##################################################
    //# error
    //##################################################

    public Function<T,String> getErrorFunction()
    {
        return _errorFunction;
    }

    public void setErrorFunction(Function<T,String> e)
    {
        _errorFunction = e;
    }

    public String getErrorFor(T e)
    {
        return _errorFunction == null
            ? null
            : _errorFunction.apply(e);
    }

    public void clearErrorFunction()
    {
        _errorFunction = null;
    }

    //##################################################
    //# links
    //##################################################

    public void addLink(String label)
    {
        _linkActions.put(label, (ScAction)null);
    }

    public void addLink(String label, ScAction action)
    {
        _linkActions.put(label, action);
    }

    //==================================================
    //= link style
    //==================================================

    private LinkStyle getLinkStyle()
    {
        try
        {
            return LinkStyle.valueOf(_linkStyle.getValue());
        }
        catch ( RuntimeException ex )
        {
            return LinkStyle.horizontal;
        }
    }

    private void setLinkStyle(LinkStyle e)
    {
        _linkStyle.setValue(e.name());
    }

    public void setLinkStyleVertical()
    {
        setLinkStyle(LinkStyle.vertical);
    }

    public void setLinkStyleHorizontal()
    {
        setLinkStyle(LinkStyle.horizontal);
    }

    public void setLinkStyleTopMenu()
    {
        setLinkStyle(LinkStyle.topMenu);
    }

    public void setLinkStyleBottomMenu()
    {
        setLinkStyle(LinkStyle.bottomMenu);
    }

    public void setLinkStyleHidden()
    {
        setLinkStyle(LinkStyle.hidden);
    }

    //==================================================
    //= link :: disabled reason
    //==================================================

    public Function<T,String> getLinkDisableReason()
    {
        return _linkDisableReason;
    }

    public void setLinkDisableReason(Function<T,String> e)
    {
        _linkDisableReason = e;
    }

    public boolean hasLinkDisableReason()
    {
        return _linkDisableReason != null;
    }

    //##################################################
    //# item action
    //##################################################

    public ScAction getItemAction()
    {
        return _itemAction;
    }

    public void setItemAction(ScAction e)
    {
        _itemAction = e;
    }

    public boolean hasItemAction()
    {
        return _itemAction != null;
    }

    //##################################################
    //# drag action
    //##################################################

    public ScAction getDragAction()
    {
        return _dragAction;
    }

    public void setDragAction(ScAction e)
    {
        _dragAction = e;
    }

    public boolean hasDragAction()
    {
        return _dragAction != null;
    }

    //==================================================
    //= drag :: show anchors
    //==================================================

    public void setShowDragAnchors(boolean e)
    {
        _showDragAnchors.setValue(e);
    }

    public void showDragAnchors()
    {
        setShowDragAnchors(true);
    }

    public void hideDragAnchors()
    {
        setShowDragAnchors(false);
    }

    //##################################################
    //# initial selection
    //##################################################

    public T getInitialSelection()
    {
        return _initialSelection.getValue();
    }

    public void setInitialSelection(T e)
    {
        _initialSelection.setValue(e);
    }

    public void clearInitialSelection()
    {
        _initialSelection.clearValue();
    }

    public boolean hasInitialSelection()
    {
        return _initialSelection.hasValue();
    }

    public void selectFirst()
    {
        T e = getValues().getFirstSafe();
        setInitialSelection(e);
    }

    //##################################################
    //# initial filter
    //##################################################

    public String getInitialFilter()
    {
        return _initialFilter.getValue();
    }

    public void setInitialFilter(String e)
    {
        _initialFilter.setValue(e);
    }

    //##################################################
    //# filter
    //##################################################

    public void installFilterOn(ScTextField field)
    {
        String listSel = getJquerySelector();

        String itemCss = KmCssDefaultConstantsIF.modelList_item;
        String itemSel = ScJquery.formatCssSelector(itemCss);
        String listItemSel = listSel + " " + itemSel;

        String titleSel = ScJquery.formatCssSelector(KmCssDefaultConstantsIF.modelList_itemTitle);

        ScFilterScript script;
        script = new ScFilterScript();
        script.setFieldSelector(field.getInputSelector());
        script.setItemSelector(listItemSel);
        script.addAttributeSelector(titleSel);

        ScHtmlIdAjax postDom;
        postDom = field.getPostDomScript();
        postDom.onKeyUp(script);
        postDom.onChange(script);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderPostDomOn(KmHtmlBuilder out)
    {
        super.renderPostDomOn(out);

        renderDragActionOn(out);
    }

    private void renderDragActionOn(KmHtmlBuilder out)
    {
        if ( _dragAction == null )
            return;

        ScActionScript onDrag;
        onDrag = new ScActionScript();
        onDrag.setAction(_dragAction);
        onDrag.setForm(findFormWrapper());
        onDrag.setBlockTarget(findBlockWrapper());

        ScSortableScript sort;
        sort = out.getPostDom().sortable(this);
        sort.setHandleCss(KmCssDefaultConstantsIF.dragHandle);
        sort.setUpdateScript(onDrag);
    }

    //##################################################
    //# compose item
    //##################################################

    @Override
    protected void composeItemOn(ScDiv row, T value)
    {
        row.css().modelList_item();

        if ( !isEnabledFor(value) )
            row.css().modelList_itemInactive();

        if ( Kmu.isEqual(getInitialSelection(), value) )
            row.css().modelList_itemSelected();

        setItemVisibilityOn(row, value);
        composeItemHiddenFieldOn(row, value);
        composeItemDragHandleOn(row, value);
        composeItemWarningOn(row, value);
        composeItemErrorOn(row, value);
        composeItemContentOn(row, value);
        composeItemLinksOn(row, value);
        composeItemIndicatorOn(row);
    }

    private void setItemVisibilityOn(ScDiv row, T value)
    {
        String filter = _initialFilter.getValue();
        boolean visible = matchesFilter(filter, value);

        row.setVisible(visible);
    }

    private boolean matchesFilter(String filter, T value)
    {
        if ( Kmu.isEmpty(filter) )
            return true;

        filter = filter.toLowerCase();
        String title = getTitleFor(value);
        String subtitle = getTitleFor(value);

        if ( title != null )
            if ( title.toLowerCase().contains(filter) )
                return true;

        if ( subtitle != null )
            if ( subtitle.toLowerCase().contains(filter) )
                return true;

        return false;
    }

    protected void composeItemHiddenFieldOn(ScDiv row, T value)
    {
        ScHiddenField<String> e;
        e = row.addHiddenField();
        e.setHtmlName(getHiddenFieldName());
        e.setValue(getKeyFor(value));
    }

    /**
     * @param value The domain value being dragged. Currently not used.
     */
    protected void composeItemDragHandleOn(ScDiv row, T value)
    {
        if ( _dragAction == null )
            return;

        if ( _showDragAnchors.isFalse() )
            return;

        ScDiv e;
        e = row.addDiv();
        e.css().modelList_itemDragHandle().dragHandle();
    }

    private void composeItemWarningOn(ScDiv row, T value)
    {
        String msg = getWarningFor(value);
        if ( Kmu.isEmpty(msg) )
            return;

        ScDiv div;
        div = row.addDiv();
        div.css().modelList_itemErrorBox();

        ScImage img;
        img = div.addImage();
        img.setSource(getUrls().getWarnUrl());
        img.setHoverText(msg);
        img.css().noBorder().width20().height20();
    }

    private void composeItemErrorOn(ScDiv row, T value)
    {
        String msg = getErrorFor(value);
        if ( Kmu.isEmpty(msg) )
            return;

        ScDiv div;
        div = row.addDiv();
        div.css().modelList_itemErrorBox();

        ScImage img;
        img = div.addImage();
        img.setSource(getUrls().getErrorUrl());
        img.setHoverText(msg);
        img.css().noBorder().width20().height20();
    }

    private void composeItemContentOn(ScDiv row, T value)
    {
        ScDiv div;
        div = row.addDiv();
        div.css().modelList_itemMessageBox();

        if ( hasItemAction() )
        {
            String key = getKeyFor(value);
            div.setOnClick(findFormWrapper(), getItemAction(), key);
        }

        composeTitleOn(div, value);
        composeSubtitleOn(div, value);
    }

    private void composeTitleOn(ScDiv root, T value)
    {
        String s = getTitleFor(value);

        ScParagraph p;
        p = root.addParagraph(s);
        p.css().modelList_itemTitle();
    }

    private void composeSubtitleOn(ScDiv root, T value)
    {
        String s = getSubtitleFor(value);

        ScParagraph p;
        p = root.addParagraph(s);
        p.css().modelList_itemSubtitle();
    }

    protected void composeItemLinksOn(ScDiv row, T value)
    {
        if ( _linkActions.isEmpty() )
            return;

        LinkStyle style = getLinkStyle();
        switch ( style )
        {
            case hidden:
                return;

            case horizontal:
                composeHorizontalLinksOn(row, value);
                break;

            case vertical:
                composeVerticalLinksOn(row, value);
                break;

            case topMenu:
                composeTopMenuLinksOn(row, value);
                break;

            case bottomMenu:
                composeBottomMenuLinksOn(row, value);
                break;
        }
    }

    private void composeHorizontalLinksOn(ScDiv row, T value)
    {
        String key = getKeyFor(value);

        ScDiv div;
        div = row.addDiv();
        div.css().modelList_itemMenuBoxRow();

        ScForm form = findFormWrapper();

        for ( String label : _linkActions.getKeys() )
        {
            ScAction action = _linkActions.get(label);

            ScLink link;
            link = div.addLink(label, action, key);
            link.setActionFormOverride(form);

            applyLinkEnablement(link, value, label);
        }
    }

    private void applyLinkEnablement(ScLink link, T value, String label)
    {
        if ( !hasLinkDisableReason() )
            return;

        String reason = getLinkDisableReason().apply(value);
        if ( reason == null )
            return;

        String msg = Kmu.format("Cannot %s. %s", label, reason);
        link.disable(msg);
    }

    private void composeVerticalLinksOn(ScDiv row, T value)
    {
        String key = getKeyFor(value);

        ScDiv div;
        div = row.addDiv();
        div.css().modelList_itemMenuBoxColumn();

        ScForm form = findFormWrapper();

        for ( String label : _linkActions.getKeys() )
        {
            ScAction action = _linkActions.get(label);

            ScLink link;
            link = div.addLink(label, action, key);
            link.setActionFormOverride(form);
        }
    }

    private void composeTopMenuLinksOn(ScDiv row, T value)
    {
        String key = getKeyFor(value);

        ScPopupMenu menu;
        menu = createMenu(key);
        menu.setAlignTop();

        row.add(menu);
    }

    private void composeBottomMenuLinksOn(ScDiv row, T value)
    {
        String key = getKeyFor(value);

        ScPopupMenu menu;
        menu = createMenu(key);
        menu.setAlignBottom();

        row.add(menu);
    }

    private ScPopupMenu createMenu(String key)
    {
        ScPopupMenu menu;
        menu = new ScPopupMenu();

        for ( String label : _linkActions.getKeys() )
        {
            ScAction action = _linkActions.get(label);
            menu.addItem(label, action, key);
        }
        return menu;
    }

    private void composeItemIndicatorOn(ScDiv row)
    {
        ScDiv div;
        div = row.addDiv();
        div.css().modelListItemIndicator();
    }

    //##################################################
    //# ajax (select)
    //##################################################

    public void ajaxSelect(T value)
    {
        _ajaxDeselect();
        _ajaxSelect(value);
    }

    public void ajaxUpdateSelection()
    {
        if ( hasInitialSelection() )
            ajaxSelect(getInitialSelection());
        else
            ajaxClearSelection();
    }

    public void ajaxScrollTo(T value)
    {
        _htmlIdAjax().scrollToIfOffScreen(getSelectorFor(value));
    }

    public void ajaxScrollToTop()
    {
        _htmlIdAjax().scrollToTop();
    }

    public void ajaxClearSelection()
    {
        _ajaxDeselect();
    }

    private void _ajaxDeselect()
    {
        String css = KmCssDefaultConstantsIF.modelList_itemSelected;

        String parentSel = getJquerySelector();
        String descendantSelector = ScJquery.formatCssSelector(css);
        String sel = Kmu.format("%s %s", parentSel, descendantSelector);

        getRootScript().removeCss(sel, css);
    }

    private void _ajaxSelect(T value)
    {
        String css = KmCssDefaultConstantsIF.modelList_itemSelected;
        ajaxFor(value).addCss(css);
    }

    //##################################################
    //# value
    //##################################################

    public KmList<String> getHiddenFieldKeys()
    {
        KmList<String> keys = new KmList<>();

        KmList<String> params = getData().getParameters(getHiddenFieldName());
        for ( String param : params )
        {
            String key = (String)ScDecoder.staticDecode(param);
            keys.add(key);
        }

        return keys;
    }

    private String getHiddenFieldName()
    {
        return getHtmlId() + "_h";
    }

}
