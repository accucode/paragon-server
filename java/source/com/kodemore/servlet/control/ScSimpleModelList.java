/*
  Copyright (c) 2005-2014 www.kodemore.com

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

import com.kodemore.adaptor.KmAdaptorIF;
import com.kodemore.collection.KmOrderedMap;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.meta.KmMetaAttribute;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.servlet.script.ScFilterScript;
import com.kodemore.servlet.utility.ScJquery;
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
    //# variables
    //##################################################

    /**
     * I am applied to each model to create a title.
     * The title should be relatively unique, and short enough to fit on a single line.
     * This is required.
     */
    private KmAdaptorIF<T,String>           _titleAdapter;

    /**
     * I am applied to each model to create a subtitle.
     * The subtitle optionally provides extra information.
     */
    private KmAdaptorIF<T,String>           _subtitleAdapter;

    /**
     * The list of actions to be displayed.  Each action is displayed
     * as a link, using the specified label.  Each link is dynamically
     * configured with model's key as as the argument, based on the key
     * adapter.  The labels must be unique.
     */
    private KmOrderedMap<String,ScAction> _links;

    /**
     * If set, this action will be exectuted when the list item is clicked.
     * This allows the entire row to be clickable, not just the individual
     * links.  The value's key is passed as an argument.
     */
    private ScAction                      _itemAction;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        css().modelList();
        _links = new KmOrderedMap<>();
    }

    //##################################################
    //# title
    //##################################################

    public KmAdaptorIF<T,String> getTitleAdapter()
    {
        return _titleAdapter;
    }

    public void setTitleAdapter(KmAdaptorIF<T,String> e)
    {
        _titleAdapter = e;
    }

    public void setTitleAdapter(KmMetaAttribute<T,String> e)
    {
        if ( e == null )
            clearTitleAdapter();
        else
            setTitleAdapter(e.getAdaptor());
    }

    private String getTitleFor(T e)
    {
        if ( _titleAdapter == null )
            return null;

        return _titleAdapter.getValue(e);
    }

    public void clearTitleAdapter()
    {
        _titleAdapter = null;
    }

    //##################################################
    //# subtitle
    //##################################################

    public KmAdaptorIF<T,String> getSubtitleAdapter()
    {
        return _subtitleAdapter;
    }

    public void setSubtitleAdapter(KmAdaptorIF<T,String> e)
    {
        _subtitleAdapter = e;
    }

    public void setSubtitleAdapter(KmMetaAttribute<T,String> e)
    {
        if ( e == null )
            clearSubtitleAdapter();
        else
            setSubtitleAdapter(e.getAdaptor());
    }

    public String getSubtitleFor(T e)
    {
        if ( _subtitleAdapter == null )
            return null;

        return _subtitleAdapter.getValue(e);
    }

    public void clearSubtitleAdapter()
    {
        _subtitleAdapter = null;
    }

    //##################################################
    //# links
    //##################################################

    public void addLink(String label, Runnable runnable)
    {
        _links.put(label, createAction(runnable));
    }

    public void addLink(String label, ScAction action)
    {
        _links.put(label, action);
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
        _itemAction = createAction(e);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderItemOn(ScBox root, T value)
    {
        String key = getKeyFor(value);

        root.css().modelList_item();

        if ( _itemAction != null )
            root.setOnClick(_itemAction, key);

        ScDiv left;
        left = root.addDiv();
        left.css().modelList_itemLeftBox();

        String title = getTitleFor(value);
        String subtitle = getSubtitleFor(value);

        left.addTextSpan(title).css().modelList_itemTitle();
        left.addBreak();
        left.addTextSpan(subtitle).css().modelList_itemSubtitle();

        if ( _links.isEmpty() )
            return;

        ScDiv right;
        right = root.addDiv();
        right.css().modelList_itemRightBox();

        for ( String label : _links.getKeys() )
        {
            ScAction action = _links.get(label);
            right.addLink(label, action, key);
        }
    }

    // todo_wyatt: review all deprecated methods.

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
        ajax().scrollToIfOffScreen(getSelectorFor(value));
    }

    public void ajaxScrollToTop()
    {
        ajax().scrollToTop();
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

        ajax().removeCss(sel, css);
    }

    private void _ajaxSelect(T value)
    {
        String css = KmCssDefaultConstantsIF.modelList_itemSelected;
        ajaxFor(value).addCss(css);
    }

    public void installFilterOn(ScTextField field)
    {
        String listSel = getJquerySelector();

        String itemCss = KmCssDefaultConstantsIF.modelList_item;
        String itemSel = ScJquery.formatCssSelector(itemCss);
        String listItemSel = listSel + " " + itemSel;

        String titleSel = ScJquery.formatCssSelector(KmCssDefaultConstantsIF.modelList_itemTitle);
        String subSel = ScJquery.formatCssSelector(KmCssDefaultConstantsIF.modelList_itemSubtitle);

        ScFilterScript script;
        script = new ScFilterScript();
        script.setFieldSelector(field);
        script.setItemSelector(listItemSel);
        script.addAttributeSelector(titleSel);
        script.addAttributeSelector(subSel);

        field.getPostDomScript().onKeyUp(script);
        field.getPostDomScript().onChange(script);
    }

}
