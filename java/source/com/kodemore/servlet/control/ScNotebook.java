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

import java.util.function.Consumer;
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
public class ScNotebook
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
    private KmList<ScNotebookItem> _items;

    /**
     * The token of the selected item/control.
     */
    private ScLocalString _selectedToken;

    /**
     * The container used to render the tabs.
     */
    private ScTransientDiv _tabBox;

    /**
     * Used to overlay the spine's border below the selected tab
     * in order to make them look connected.
     */
    private ScDiv _overlay;

    /**
     * The contents of each tab are displayed using a frame.
     */
    private ScCardFrame _frame;

    /**
     * The action that handles tab clicks.
     * The tab's key must be passed as the argument.
     */
    private ScAction _tabClickAction;

    /**
     * If set, allows the client to perform setup immediately
     * before the selected tab is rendered.
     */
    private Consumer<ScControl> _onTabPreRender;

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
    private Runnable _onTabChanged;

    /**
     * The flavor (aka style) of the tab book.
     */
    private ScLocalString _flavorName;

    //##################################################
    //# constructor
    //##################################################

    public ScNotebook()
    {
        _items = new KmList<>();

        _selectedToken = new ScLocalString();
        _selectedToken.setAutoSave();

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

    public ScNotebookItem add(ScControl tab)
    {
        return addTab(tab);
    }

    public ScNotebookItem addTab(ScControl tab)
    {
        ScNotebookItem item;
        item = new ScNotebookItem(tab);

        _items.add(item);
        _frame.addCard(tab);

        if ( _items.isSingleton() )
            _selectedToken.setValue(item.getKeyToken());

        return item;
    }

    //##################################################
    //# selection
    //##################################################

    public ScControl getSelectedTab()
    {
        return getSelectedItem().getControl();
    }

    public void setSelectedTab(ScControl tab)
    {
        String token = tab.getKeyToken();
        int i = _items.indexIf(e -> e.hasKeyToken(token));

        if ( i >= 0 )
            setSelectedTabIndex(i);
    }

    //==================================================
    //= selection :: items
    //==================================================

    private boolean isSelected(ScNotebookItem e)
    {
        return hasSelectedToken(e.getKeyToken());
    }

    public ScNotebookItem getSelectedItem()
    {
        String token = getSelectedToken();
        return getItemForToken(token);
    }

    //==================================================
    //= selection :: token
    //==================================================

    private String getSelectedToken()
    {
        return _selectedToken.getValue();
    }

    private void setSelectedToken(String e)
    {
        _selectedToken.setValue(e);
    }

    public boolean hasSelectedToken(String e)
    {
        return Kmu.isEqual(getSelectedToken(), e);
    }

    private ScNotebookItem getItemForToken(String token)
    {
        return _items.selectFirst(e -> e.hasKeyToken(token));
    }

    private ScControl getControlForToken(String token)
    {
        ScNotebookItem item = getItemForToken(token);
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

        String token = _items.get(i).getKeyToken();
        setSelectedToken(token);
    }

    public void selectFirstTab()
    {
        setSelectedTabIndex(0);
    }

    //##################################################
    //# auto focus
    //##################################################

    public void setAutoFocusOnTabChange()
    {
        _frame.setAutoFocus();
    }

    public void setAutoFocusOnTabChange(boolean e)
    {
        _frame.setAutoFocus(e);
    }

    //##################################################
    //# on preRender
    //##################################################

    public void onTabPreRender(Consumer<ScControl> e)
    {
        _onTabPreRender = e;
    }

    private void fireTabPreRender(ScControl tab)
    {
        fire(_onTabPreRender, tab);
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
    //# apply model to tab
    //##################################################

    private void applyModelToTab(ScControl tab)
    {
        Object model = getModelForTab(tab);

        if ( model != null )
            tab.applyFromModel(model);
    }

    /**
     * @param tab
     */
    protected Object getModelForTab(ScControl tab)
    {
        return getModel();
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
        _tabBox.clear();

        for ( ScNotebookItem e : _items )
            preRenderTab(e);
    }

    private void preRenderTab(ScNotebookItem e)
    {
        if ( !e.isVisible() )
            return;

        if ( !e.getControl().isVisible() )
            return;

        ScTransientDiv root;
        root = _tabBox;

        ScDiv tab;
        tab = root.addDiv();
        tab.setHtmlId(e.getTabHtmlId());
        tab.css().book_tab();
        tab.addTextSpan(e.getLabel());

        ScForm form = findFormWrapper();
        if ( form == null )
            tab.setOnClick(_tabClickAction, e.getKeyToken());
        else
            tab.setOnClick(form, _tabClickAction, e.getKeyToken());

        if ( e.isSecondary() )
            tab.css().book_secondary();

        if ( isSelected(e) )
        {
            tab.css().book_selected();

            ScControl c;
            c = e.getControl();
            applyModelToTab(c);
            _frame.setDefaultCard(c);
            fireTabPreRender(c);
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
        String token = getData().getStringArgument();

        ScControl tab = getControlForToken(token);
        if ( !fireTabChanging(tab) )
            return;

        setSelectedToken(token);

        ScNotebookItem item;
        item = getSelectedItem();

        ajaxRemoveTabSelection();
        ajaxSelectTab(item);
        ajaxAdjustOverlay(item);

        ScControl control;
        control = item.getControl();
        applyModelToTab(control);
        fireTabPreRender(control);

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

    private void ajaxSelectTab(ScNotebookItem item)
    {
        String tabSel = ScJquery.formatIdSelector(item.getTabHtmlId());
        String css = KmCssDefaultConstantsIF.book_selected;

        _htmlIdAjax().addCss(tabSel, css);
    }

    private void ajaxAdjustOverlay(ScNotebookItem item)
    {
        _htmlIdAjax().run(formatOverlayScript(item));
    }

    private void ajaxUpdateBody(ScNotebookItem item)
    {
        _frame.ajaxPrint(item.getControl());
    }

    //##################################################
    //# support
    //##################################################

    private String formatOverlayScript(ScNotebookItem item)
    {
        String overlaySel = _overlay.getJquerySelector();
        String tabSel = item.getTabJquerySelector();
        return Kmu.format("Kmu.adjustTabBookOverlay('%s','%s');", overlaySel, tabSel);
    }

}
