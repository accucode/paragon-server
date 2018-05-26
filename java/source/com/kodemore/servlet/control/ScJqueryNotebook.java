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

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.json.KmJsonMap;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.script.ScActionScript;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.servlet.script.ScScriptIF;
import com.kodemore.servlet.script.ScSimpleScript;
import com.kodemore.servlet.utility.ScJquery;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalInteger;
import com.kodemore.utility.Kmu;

/**
 * I implement a tabbed notebook control using the jquery-ui toolkit.
 * https://jqueryui.com/tabs/
 *
 * Children / Tabs
 *      Each child added will be rendered as a notebook tab.
 *      The child's label is used as the tab title.
 *
 * Selected Tab Index
 *      You can specify the initially selected tab via setSelectedTabIndex.
 *
 *      The current tab index is populated during ajax requests under two
 *      distinct circumstances.
 *
 *      1) When responding to a tab change.
 *      The new tab index is always set.
 *      The notebook does NOT need to be enclosed in a form.
 *
 *      2) All other typical ajax requests.
 *      The tab index is only available if the notebook is contained
 *      in a form, and the form is part of the ajax request.
 *
 * Theming
 *      Theming is based on the jquery-ui theme.
 *      The jquery theme roller can be used to create new themes,
 *      HOWEVER care must be taken since changes likely affect other
 *      jquery controls as well. E.g.: changing a color or style on the
 *      notebook likely impacts the Dialogs, Date Pickers, etc...
 */
public class ScJqueryNotebook
    extends ScChildContainerElement
{
    //##################################################
    //# constants
    //##################################################

    /**
     * When jquery composes the notebook, it creates wrappers around the
     * original content. The html id of each wrapper is determined by adding
     * "-tab" to the html id of the original child. Children without an html id
     * are allowed, but will not have an identifiable wrapper.
     */
    private static final String TAB_HTML_ID_SUFFIX = "-tab";

    //##################################################
    //# variables
    //##################################################

    /**
     * When true, css styles will be applied that will stretch the
     * notebook to fill a flexbox;
     *
     * The parent must use display: flex
     */
    private boolean _flexFill;

    /**
     * This can be used to set the default tab index (0-based).
     * Although this is normally NOT populated upon subsequent
     * ajax requests, it IS populated automatically before
     * the tabChangedAction is handled.
     */
    private ScLocalInteger _selectedTabIndex;

    /**
     * This is the optional tab changed action.
     */
    private ScAction _tabChangedAction;

    /**
     * If true, the default, the notebook will check the client-side
     * dirty state and prevent the user from switching tabs.
     */
    private ScLocalBoolean _dirtyStateChecking;

    //##################################################
    //# constructor
    //##################################################

    public ScJqueryNotebook()
    {
        _selectedTabIndex = new ScLocalInteger(0);
        _dirtyStateChecking = new ScLocalBoolean(true);
    }

    //##################################################
    //# tab index
    //##################################################

    public Integer getSelectedTabIndex()
    {
        return _selectedTabIndex.getValue();
    }

    public void setSelectedTabIndex(Integer e)
    {
        _selectedTabIndex.setValue(e);
    }

    public boolean hasSelectedTabIndex()
    {
        return _selectedTabIndex.hasValue();
    }

    public void clearSelectedTabIndex()
    {
        _selectedTabIndex.clearValue();
    }

    //==================================================
    //= selected tab
    //==================================================

    public ScControl getSelectedTab()
    {
        Integer i = getSelectedTabIndex();
        return i == null
            ? null
            : getChildren().getAtSafe(i);
    }

    public void setSelectedTab(ScControl e)
    {
        int i = getChildren().indexOf(e);
        if ( i > 0 )
            setSelectedTabIndex(i);
        else
            clearSelectedTabIndex();
    }

    public boolean hasSelectedTab()
    {
        return getSelectedTab() != null;
    }

    public boolean hasSelectedTab(ScControl e)
    {
        return getSelectedTab() == e;
    }

    //##################################################
    //# tab change
    //##################################################

    public ScAction getTabChangedAction()
    {
        return _tabChangedAction;
    }

    public void setTabChangedAction(ScAction e)
    {
        _tabChangedAction = e;
        _tabChangedAction.setWedge(this::handleSetupForTabChange);
    }

    public boolean hasTabChangedAction()
    {
        return getTabChangedAction() != null;
    }

    //==================================================
    //= accessing :: flex fill
    //==================================================

    public boolean getFlexFill()
    {
        return _flexFill;
    }

    public void setFlexFill(boolean e)
    {
        _flexFill = e;
    }

    public void flexFill()
    {
        setFlexFill(true);
    }

    //==================================================
    //= accessing :: dirty state
    //==================================================

    public boolean getDirtyStateChecking()
    {
        return _dirtyStateChecking.isTrue();
    }

    public void setDirtyStateChecking(boolean e)
    {
        _dirtyStateChecking.setValue(e);
    }

    public void disableDirtyStateChecking()
    {
        setDirtyStateChecking(false);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        if ( getFlexFill() )
        {
            css().flexColumn();
            css().flexChildFiller();
        }
    }

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        renderNotebook(out);
        renderSelectedTabFieldOn(out);
        renderScript(out);
    }

    //==================================================
    //= render :: notebook
    //==================================================

    private void renderNotebook(KmHtmlBuilder out)
    {
        out.open("div");
        renderAttributesOn(out);
        out.close();

        renderChildrenOn(out);

        out.end("div");
    }

    @Override
    protected void renderChildrenOn(KmHtmlBuilder out)
    {
        renderTabLabelsOn(out);
        renderTabContentsOn(out);
    }

    //==================================================
    //= render :: labels
    //==================================================

    private void renderTabLabelsOn(KmHtmlBuilder out)
    {
        out.begin("ul");

        for ( ScControl e : getChildren() )
            renderTabLabel(out, e);

        out.end("ul");
    }

    private void renderTabLabel(KmHtmlBuilder out, ScControl e)
    {
        if ( !isVisible(e) )
            return;

        out.begin("li");

        out.open("a");
        out.printAttribute("href", "#" + getWrapperIdFor(e));
        out.close();
        out.print(e.getLabel());
        out.end("a");

        out.end("li");
    }

    private boolean isVisible(ScControl e)
    {
        return e instanceof ScVisibleIF
            ? ((ScVisibleIF)e).isVisible()
            : true;
    }

    //==================================================
    //= render :: contents
    //==================================================

    private void renderTabContentsOn(KmHtmlBuilder out)
    {
        out.open("div");
        out.printAttribute(formatTabsWrapperCss());
        out.close();

        for ( ScControl e : getChildren() )
            renderTabContentWrapperOn(out, e);

        out.end("div");
    }

    private void renderTabContentWrapperOn(KmHtmlBuilder out, ScControl e)
    {
        out.openDiv();
        out.printAttribute("id", getWrapperIdFor(e));
        out.printAttribute(formatTabCss());
        out.close();

        renderTabContentOn(out, e);

        out.endDiv();
    }

    private void renderTabContentOn(KmHtmlBuilder out, ScControl e)
    {
        out.openDiv();
        out.printAttribute(formatContentCss());
        out.close();
        out.render(e);
        out.endDiv();
    }

    //==================================================
    //= render :: tab field
    //==================================================

    private void renderSelectedTabFieldOn(KmHtmlBuilder out)
    {
        ScControl child = getSelectedTab();
        if ( child == null )
        {
            KmList<ScControl> v = getChildren();
            if ( v.isEmpty() )
                return;

            child = v.getFirst();
        }

        String wrapperId = getWrapperIdFor(child);

        out.open("input");
        out.printAttribute("type", "hidden");
        out.printAttribute("id", getSelectedTabFieldId());
        out.printAttribute("name", getSelectedTabFieldName());
        out.printAttribute("value", wrapperId);
        out.close();
    }

    private String getSelectedTabFieldId()
    {
        return getHtmlId() + "-index";
    }

    private String getSelectedTabFieldName()
    {
        return getSelectedTabFieldId();
    }

    //==================================================
    //= render :: script
    //==================================================

    private void renderScript(KmHtmlBuilder out)
    {
        String ref = getJqueryReference();

        KmJsonMap options;
        options = new KmJsonMap();
        options.setInteger("active", getSelectedTabIndex());

        ScBlockScript ajax;
        ajax = out.getPostDom();
        ajax.run("%s.tabs(%s);", ref, options);

        renderBeforeActivateScriptOn(ajax);
        renderActivateScriptOn(ajax);
    }

    private void renderBeforeActivateScriptOn(ScBlockScript ajax)
    {
        if ( !getDirtyStateChecking() )
            return;

        ScHtmlIdIF scope = findChangeTrackingScopeWrapper();
        String scopeSel = scope == null
            ? null
            : scope.getJquerySelector();

        String ref = getJqueryReference();
        String script = Kmu.format("return Kmu.showNoticeIfDirty(%s);", json(scopeSel));

        ajax.run("%s.on('tabsbeforeactivate',function(ev,ui){%s});", ref, script);
    }

    private void renderActivateScriptOn(ScBlockScript ajax)
    {
        String ref = getJqueryReference();

        ScBlockScript script;
        script = ScBlockScript.create();
        script.run(composeTabIndexScript());
        script.run(composeActionScript());

        ajax.run("%s.on('tabsactivate',function(ev,ui){%s});", ref, script);
    }

    private ScScriptIF composeTabIndexScript()
    {
        String fieldId = getSelectedTabFieldId();
        String fieldRef = ScJquery.formatIdReference(fieldId);

        ScSimpleScript e;
        e = new ScSimpleScript();
        e.setValue("%s.val(ui.newPanel.prop('id'));", fieldRef);
        return e;
    }

    private ScScriptIF composeActionScript()
    {
        ScAction action = getTabChangedAction();
        if ( action == null )
            return null;

        ScActionScript e;
        e = new ScActionScript();
        e.setAction(action);
        e.setForm(findFormWrapper());
        e.setExtraLiteral("ui.newPanel.prop('id')");
        return e;
    }

    //##################################################
    //# read parameters
    //##################################################

    @Override
    protected void readParameters_here(ScServletData data)
    {
        String name = getSelectedTabFieldName();
        String tabId = getData().getParameter(name);

        updateSelectedIndexFromTabId(tabId);
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSetupForTabChange()
    {
        String tabId = getData().getExtraParameter();
        updateSelectedIndexFromTabId(tabId);
    }

    //##################################################
    //# tab id/index
    //##################################################

    private String getWrapperIdFor(ScControl child)
    {
        return child.getKey() + TAB_HTML_ID_SUFFIX;
    }

    private ScControl getChildForWrapperId(String id)
    {
        if ( id == null )
            return null;

        for ( ScControl e : getChildren() )
            if ( id.equals(getWrapperIdFor(e)) )
                return e;

        return null;
    }

    //##################################################
    //# css
    //##################################################

    private KmCssDefaultBuilder formatTabsWrapperCss()
    {
        KmCssDefaultBuilder css;
        css = newCssBuilder();
        css.relative();

        if ( getFlexFill() )
            css.flexChildFiller();

        return css;
    }

    private KmCssDefaultBuilder formatTabCss()
    {
        KmCssDefaultBuilder css = newCssBuilder();

        if ( getFlexFill() )
            css.notebookTabFlexFill();

        return css;
    }

    private KmCssDefaultBuilder formatContentCss()
    {
        KmCssDefaultBuilder css = newCssBuilder();

        if ( getFlexFill() )
        {
            css.notebookTabContentFlexFill();
            css.flexColumn();
        }

        return css;
    }

    private void updateSelectedIndexFromTabId(String tabId)
    {
        ScControl child = getChildForWrapperId(tabId);
        int index = getChildIndexFor(child);

        if ( index >= 0 )
            _selectedTabIndex.setValue(index);
    }
}
