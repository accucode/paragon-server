/*
  Copyright (c) 2005-2016 www.kodemore.com

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
 * The styling is determined by the theme.css.
 *
 * For customized rendering, use the ScCustomerModelList instead.
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
     * I am applied to each model to create a title.
     * The title should be relatively unique, and short enough to fit on a single line.
     * This is required.
     */
    private Function<T,String>            _titleFunction;

    /**
     * I am applied to each model to determine whether the strikeout
     * style should be applied. If null (the default), strikeout is NOT applied.
     */
    private Predicate<T>                  _childActive;

    /**
     * I am applied to each model to create a subtitle.
     * The subtitle optionally provides extra information.
     */
    private Function<T,String>            _subtitleFunction;

    /**
     * I am applied to each model to create an error message.
     * If the value has an error, an indicator is displayed.
     */
    private Function<T,String>            _errorFunction;

    /**
     * If set, this action will be exectuted when the list item is clicked.
     * This allows the entire row to be clickable, not just the individual
     * links.  The value's key is passed as an argument.
     */
    private ScAction                      _itemAction;

    /**
     * This is primarily used to pre-select a particular element when
     * initially rendering the list.
     */
    private ScLocal<T>                    _initialSelection;

    /**
     * If set, the item visibility will be defaulted based on the
     * filter. All items are rendered so that the client side script
     * can subsequently show/hide the items.
     */
    private ScLocalString                 _initialFilter;

    /**
     * If set, this action will be exectuted when the user drag an item
     * to a new position. If non-null, the model list will automatically
     * include the necessary scripting and visual drag handles.
     */
    private ScAction                      _dragAction;

    /**
     * If true (the default), the display drag anchors when a drag action is set.
     * If false, the drag anchors are not rendered.
     */
    private ScLocalBoolean                _showDragAnchors;

    /**
     * The list of actions to be displayed.  Each action is displayed
     * as a link, using the specified label.  Each link is dynamically
     * configured with model's key as as the argument, based on the key
     * adapter.  The labels must be unique.
     */
    private KmOrderedMap<String,ScAction> _linkActions;

    /**
     * The style used to display the action links.
     * This corresponds to the LinkStyle enum defined above.
     */
    private ScLocalString                 _linkStyle;

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
    //# title :: strikeout
    //##################################################

    public Predicate<T> getChildActive()
    {
        return _childActive;
    }

    public void setChildActive(Predicate<T> e)
    {
        _childActive = e;
    }

    public boolean getChildActiveFor(T e)
    {
        if ( e == null )
            return false;

        return _childActive == null
            ? true
            : _childActive.test(e);
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

    public void addLink(String label, Runnable runnable)
    {
        _linkActions.put(label, newCheckedAction(runnable));
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

    public void setItemAction(Runnable e)
    {
        _itemAction = newCheckedAction(e);
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

    public void setDragAction(Runnable e)
    {
        _dragAction = newCheckedAction(e);
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

        if ( _dragAction != null )
        {
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
    }

    //##################################################
    //# compose item
    //##################################################

    @Override
    protected void composeItemOn(ScDiv root, T value)
    {
        String key = getKeyFor(value);

        root.css().modelList_item();

        if ( !getChildActiveFor(value) )
            root.css().modelList_itemInactive();

        if ( getInitialSelection() == value )
            root.css().modelList_itemSelected();

        if ( hasItemAction() )
            root.setOnClick(findFormWrapper(), getItemAction(), key);

        setItemVisibilityOn(root, value);
        composeItemHiddenFieldOn(root, value);
        composeItemDragHandleOn(root, value);
        composeItemErrorOn(root, value);
        composeItemContentOn(root, value);
        composeItemLinksOn(root, key);
        composeItemIndicatorOn(root);
    }

    private void setItemVisibilityOn(ScDiv box, T value)
    {
        String filter = _initialFilter.getValue();
        boolean visible = matchesFilter(filter, value);

        box.setVisible(visible);
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

    protected void composeItemHiddenFieldOn(ScDiv root, T value)
    {
        ScHiddenField<String> field;
        field = root.addHiddenField();
        field.setHtmlName(getHiddenFieldName());
        field.setValue(getKeyFor(value));
    }

    /**
     * @param value The domain value being dragged. Currently not used.
     */
    protected void composeItemDragHandleOn(ScDiv root, T value)
    {
        if ( _dragAction == null )
            return;

        if ( _showDragAnchors.isFalse() )
            return;

        ScDiv e;
        e = root.addDiv();
        e.css().dragHandle().flexChildStatic().marginLeft5();
    }

    private void composeItemErrorOn(ScDiv root, T value)
    {
        String err = getErrorFor(value);
        if ( Kmu.isEmpty(err) )
            return;

        ScDiv div;
        div = root.addDiv();
        div.css().modelList_itemErrorBox();

        ScImage img;
        img = div.addImage();
        img.setSource(getUrls().getErrorUrl());
        img.setHoverText(err);
        img.css().noBorder().width20().height20();
    }

    private void composeItemContentOn(ScDiv root, T value)
    {
        ScDiv div;
        div = root.addDiv();
        div.css().modelList_itemMessageBox();

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

    protected void composeItemLinksOn(ScDiv root, String key)
    {
        if ( _linkActions.isEmpty() )
            return;

        LinkStyle style = getLinkStyle();
        switch ( style )
        {
            case hidden:
                return;

            case horizontal:
                composeHorizontalLinksOn(root, key);
                break;

            case vertical:
                composeVerticalLinksOn(root, key);
                break;

            case topMenu:
                composeTopMenuLinksOn(root, key);
                break;

            case bottomMenu:
                composeBottomMenuLinksOn(root, key);
                break;
        }
    }

    private void composeHorizontalLinksOn(ScDiv root, String key)
    {
        ScDiv div;
        div = root.addDiv();
        div.css().modelList_itemMenuBoxRow();

        for ( String label : _linkActions.getKeys() )
        {
            ScAction action = _linkActions.get(label);
            div.addLink(label, action, key);
        }
    }

    private void composeVerticalLinksOn(ScDiv root, String key)
    {
        ScDiv div;
        div = root.addDiv();
        div.css().modelList_itemMenuBoxColumn();

        for ( String label : _linkActions.getKeys() )
        {
            ScAction action = _linkActions.get(label);
            div.addLink(label, action, key);
        }
    }

    private void composeTopMenuLinksOn(ScDiv root, String key)
    {
        ScPopupMenu menu;
        menu = createMenu(key);
        menu.setAlignTop();

        root.add(menu);
    }

    private void composeBottomMenuLinksOn(ScDiv root, String key)
    {
        ScPopupMenu menu;
        menu = createMenu(key);
        menu.setAlignBottom();

        root.add(menu);
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

    private void composeItemIndicatorOn(ScDiv root)
    {
        ScDiv div;
        div = root.addDiv();
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
