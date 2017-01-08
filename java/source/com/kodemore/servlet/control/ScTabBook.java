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

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.utility.ScJquery;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.Kmu;

/**
 * I am a tabbed notebook.
 */
public class ScTabBook
    extends ScDivWrapper
{
    //##################################################
    //# flavor
    //##################################################

    private static enum Flavor
    {
        /**
         * Tabs are displayed horizontally.
         */
        Wide,

        /**
         * Tabs are displayed horizontally, but the text is displayed sideways.
         * The tabs are relatively tall, but thin, allows a lot more tabs to be displayed,
         * but takes up more space vertically.
         */
        Tall,

        /**
         * Switch between normal and tallTabs depending on the screen orientation.
         * Show the tall tabs when in portrait.
         */
        Auto
    }

    //##################################################
    //# variables
    //##################################################

    /**
     * The items included in the book.
     */
    private KmList<ScTabBookItem>       _items;

    /**
     * The key of the selected item/control.
     */
    private ScLocalString               _selectedKey;

    /**
     * The container used to render the tabs.
     */
    private ScTransientDiv              _tabBox;

    /**
     * Used to overlay the spine's border below the selected tab
     * in order to make them look connected.
     */
    private ScDiv                       _overlay;

    /**
     * The contents of each tab are displayed using a frame.
     */
    private ScCardFrame                 _frame;

    /**
     * The action that handles tab clicks.
     * The tab's key must be passed as the argument.
     */
    private ScAction                    _tabClickAction;

    /**
     * If set, run this before a tab is changed.
     * The tab being changed to is passed in as a parameter.
     * Return true if the tab should be changed
     */
    private Function<ScControl,Boolean> _onTabChanging;

    /**
     * If set, run this when a tab changes.
     * This is only called in response to tab changes initiated
     * by the client side.
     */
    private Runnable                    _onTabChanged;

    /**
     * The flavor (aka style) of the tab book.
     */
    private ScLocalString               _flavorName;

    //##################################################
    //# constructor
    //##################################################

    public ScTabBook()
    {
        _items = new KmList<>();
        _selectedKey = new ScLocalString();

        _tabClickAction = newCheckedAction(this::handleTabClick);
        _tabClickAction.setChangeTrackingScopeOverride(this);

        _flavorName = new ScLocalString();
        setFlavorAuto();

        install();
    }

    //##################################################
    //# install
    //##################################################

    private void install()
    {
        ScDiv root;
        root = getInner();
        root.css().book();
        root.add(createHeader());
        root.add(createBody());
    }

    private ScControl createHeader()
    {
        ScDiv e;
        e = new ScDiv();
        e.css().book_header();
        e.add(createTabBox());
        e.add(createTabOverlay());
        return e;
    }

    private ScControl createTabBox()
    {
        ScTransientDiv e;
        e = new ScTransientDiv();
        e.css().book_tabBox();
        _tabBox = e;
        return e;
    }

    private ScControl createTabOverlay()
    {
        ScDiv e;
        e = new ScDiv();
        e.css().book_overlay();
        _overlay = e;
        return e;
    }

    private ScControl createBody()
    {
        ScDiv e;
        e = new ScDiv();
        e.css().book_body();
        e.add(createFrame());
        return e;
    }

    private ScControl createFrame()
    {
        ScCardFrame e;
        e = new ScCardFrame();
        e.setTransitionFade();
        e.css().book_frame();
        _frame = e;
        return e;
    }

    //##################################################
    //# flavor
    //##################################################

    public void setFlavorWide()
    {
        setFlavor(Flavor.Wide);
    }

    public void setFlavorTall()
    {
        setFlavor(Flavor.Tall);
    }

    public void setFlavorAuto()
    {
        setFlavor(Flavor.Auto);
    }

    private Flavor getFlavor()
    {
        String name = _flavorName.getValue();
        return Flavor.valueOf(name);
    }

    private void setFlavor(Flavor e)
    {
        _flavorName.setValue(e.name());

    }

    //##################################################
    //# tabs
    //##################################################

    public ScTabBookItem add(ScControl c)
    {
        return addTab(c);
    }

    public ScTabBookItem addTab(ScControl c)
    {
        ScTabBookItem item;
        item = new ScTabBookItem(c);

        _items.add(item);
        _frame.addCard(c);

        if ( _items.isSingleton() )
            _selectedKey.setValue(item.getKey());

        return item;
    }

    //##################################################
    //# selection
    //##################################################

    public String getSelectedKey()
    {
        return _selectedKey.getValue();
    }

    public void setSelectedKey(String e)
    {
        _selectedKey.setValue(e);
    }

    public boolean hasSelectedKey(String e)
    {
        return Kmu.isEqual(getSelectedKey(), e);
    }

    private boolean isSelected(ScTabBookItem e)
    {
        return hasSelectedKey(e.getKey());
    }

    public ScTabBookItem getSelectedItem()
    {
        String key = getSelectedKey();
        return getItemFor(key);
    }

    public ScControl getSelectedControl()
    {
        return getSelectedItem().getControl();
    }

    private ScTabBookItem getItemFor(String key)
    {
        return _items.selectFirst(e -> e.hasKey(key));
    }

    private ScControl getControlFor(String key)
    {
        ScTabBookItem item = getItemFor(key);
        return item == null
            ? null
            : item.getControl();
    }

    //##################################################
    //# tab index
    //##################################################

    public Integer getSelectedTabIndex()
    {
        int i = _items.indexOf(getSelectedItem());
        return i >= 0
            ? i
            : null;
    }

    public void setSelectedTabIndex(Integer i)
    {
        if ( i == null )
            i = 0;

        String key = _items.get(i).getKey();
        setSelectedKey(key);
    }

    //##################################################
    //# on change
    //##################################################

    public void onTabChanging(Function<ScControl,Boolean> e)
    {
        _onTabChanging = e;
    }

    private boolean fireTabChanging(ScControl tab)
    {
        if ( _onTabChanging == null )
            return true;

        Boolean b = _onTabChanging.apply(tab);
        return Kmu.isTrue(b);
    }

    public void onTabChanged(Runnable e)
    {
        _onTabChanged = e;
    }

    public void fireTabChanged()
    {
        fire(_onTabChanged);
    }

    //##################################################
    //# pre render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        preRenderFlavor();
        preRenderTabs();
    }

    private void preRenderFlavor()
    {
        Flavor flavor = getFlavor();
        switch ( flavor )
        {
            case Wide:
                css().book_wide();
                break;

            case Tall:
                css().book_tall();
                break;

            case Auto:
                css().book_auto();
                break;
        }
    }

    //==================================================
    //= pre render :: tabs
    //==================================================

    private void preRenderTabs()
    {
        for ( ScTabBookItem e : _items )
            preRenderTab(e);
    }

    private void preRenderTab(ScTabBookItem e)
    {
        ScDiv tab;
        tab = _tabBox.addDiv();
        tab.setHtmlId(e.getTabHtmlId());
        tab.css().book_tab();
        tab.addTextSpan(e.getLabel());
        tab.setOnClick(_tabClickAction, e.getKey());

        if ( e.isSecondary() )
            tab.css().book_secondary();

        if ( isSelected(e) )
        {
            tab.css().book_selected();

            ScControl c;
            c = e.getControl();
            c.applyFromModel(getModel());
            _frame.setDefaultCard(c);
        }
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        super.renderControlOn(out);

        renderOverlayScript(out);
    }

    /**
     * Move the overlay to the correct position under the selected tab.
     */
    private void renderOverlayScript(KmHtmlBuilder out)
    {
        out.getPostRender().run(formatOverlayScript(getSelectedItem()));
    }

    //##################################################
    //# handle
    //##################################################

    protected void handleTabClick()
    {
        String key = getData().getStringArgument();

        ScControl tab = getControlFor(key);
        if ( !fireTabChanging(tab) )
            return;

        setSelectedKey(key);

        ScTabBookItem item = getSelectedItem();
        ScControl control = item.getControl();

        ajaxRemoveTabSelection();
        ajaxSelectTab(item);
        ajaxAdjustOverlay(item);

        control.applyFromModel(getModel());
        ajaxUpdateBody(item);

        fireTabChanged();
    }

    //##################################################
    //# ajax
    //##################################################

    private void ajaxRemoveTabSelection()
    {
        String bookSel = getJquerySelector();
        String selectedCss = KmCssDefaultConstantsIF.book_selected;
        String selectedSel = ScJquery.formatCssSelector(selectedCss);
        String targetSel = Kmu.format("%s %s", bookSel, selectedSel);

        _htmlIdAjax().removeCss(targetSel, selectedCss);
    }

    private void ajaxSelectTab(ScTabBookItem item)
    {
        String tabSel = ScJquery.formatIdSelector(item.getTabHtmlId());
        String css = KmCssDefaultConstantsIF.book_selected;

        _htmlIdAjax().addCss(tabSel, css);
    }

    private void ajaxAdjustOverlay(ScTabBookItem item)
    {
        _htmlIdAjax().run(formatOverlayScript(item));
    }

    private void ajaxUpdateBody(ScTabBookItem item)
    {
        _frame.ajaxPrint(item.getControl());
    }

    //##################################################
    //# support
    //##################################################

    private String formatOverlayScript(ScTabBookItem item)
    {
        String overlaySel = _overlay.getJquerySelector();
        String tabSel = item.getTabJquerySelector();
        return Kmu.format("Kmu.adjustTabBookOverlay('%s','%s');", overlaySel, tabSel);
    }

}
