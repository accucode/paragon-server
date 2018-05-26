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
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.Kmu;

public class ScGridGroup<T>
    extends ScControl
{
    //##################################################
    //# variables
    //##################################################

    private ScGroup        _group;
    private ScLocalString  _title;
    private ScLocalString  _footerText;
    private ScTransientDiv _footerContent;
    private ScGrid<T>      _grid;

    //##################################################
    //# constructor
    //##################################################

    public ScGridGroup()
    {
        _title = new ScLocalString("Grid");
        _footerText = new ScLocalString();

        _group = new ScGroup();
        _group.setParent(this);

        _footerContent = _group.getFooter().addTransientDiv();
        _footerContent.css().pad10();

        ScDiv right;
        right = _group.getBanner().getRight();
        right.css().flexRow().flexCrossAlignCenter().gap5();
        right.add(createMenu());
    }

    private ScPopupMenu createMenu()
    {
        ScPopupMenu e;
        e = new ScPopupMenu();
        e.setColorWhite();
        e.addItem("export csv", e.newCheckedAction(this::handleExportCsv));
        e.addItem("export html", e.newCheckedAction(this::handleExportHtml));
        e.addItem("export excel", e.newCheckedAction(this::handleExportExcel));
        return e;
    }

    //##################################################
    //# accessing :: group
    //##################################################

    public void setTitle(String e)
    {
        _title.setValue(e);
    }

    public KmCssDefaultBuilder css()
    {
        return _group.css();
    }

    public ScDiv showHeader()
    {
        return _group.showHeader();
    }

    //==================================================
    //= accessing :: group footer
    //==================================================

    public void setFooterText(String e)
    {
        _footerText.setValue(e);
    }

    //==================================================
    //= accessing :: grid
    //==================================================

    public void setGrid(ScGrid<T> e)
    {
        e.layoutFill();

        ScDiv body;
        body = _group.getBody();
        body.clear();
        body.add(e);

        _grid = e;
    }

    public void ajaxReload()
    {
        _grid.ajaxReload();
    }

    //##################################################
    //# visibility
    //##################################################

    public void show()
    {
        _group.show();
    }

    public void hide()
    {
        _group.hide();
    }

    public void ajaxShow()
    {
        _group.ajaxShow();
    }

    public void ajaxHide()
    {
        _group.ajaxHide();
    }

    //##################################################
    //# children
    //##################################################

    @Override
    public KmList<ScControl> getChildren()
    {
        return KmList.createWith(_group);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        preRenderTitle();
        preRenderFooter();
    }

    private void preRenderTitle()
    {
        if ( _grid == null )
            return;

        int count = _grid.getTotalCount();
        String title = Kmu.format("%s (%,d)", _title.getValue(), count);
        _group.setTitle(title);
    }

    private void preRenderFooter()
    {
        if ( _footerText.hasValue() )
        {
            _group.showFooter();
            _footerContent.clear();
            _footerContent.addBold(_footerText.getValue());
            return;
        }

        _footerContent.clear();
        _group.getFooter().hide();
    }

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        _group.renderOn(out);
    }

    //##################################################
    //# handle
    //##################################################

    private void handleExportCsv()
    {
        if ( _grid == null )
        {
            ajaxToast("No data available.");
            return;
        }

        String name;
        name = _title.getValue();
        name = Kmu.isEmpty(name)
            ? "export"
            : Kmu.stripNonAlphaNumeric(name) + ".csv";

        String csv = _grid.exportCsv();

        ScBlockScript ajax;
        ajax = getRootScript();
        ajax.download(name, csv);
    }

    private void handleExportHtml()
    {
        if ( _grid == null )
        {
            ajaxToast("No data available.");
            return;
        }

        String html = _grid.exportHtml();

        ScBlockScript ajax;
        ajax = getRootScript();
        ajax.openWindowHtml(html);
    }

    private void handleExportExcel()
    {
        if ( _grid == null )
        {
            ajaxToast("No data available.");
            return;
        }

        String name;
        name = _title.getValue();
        name = Kmu.isEmpty(name)
            ? "export"
            : Kmu.stripNonAlphaNumeric(name) + ".xlsx";

        byte[] bytes = _grid.exportExcel();

        ScBlockScript ajax;
        ajax = getRootScript();
        ajax.download(name, bytes);
    }

    //##################################################
    //# ajax
    //##################################################

    public void ajaxRefreshBanner()
    {
        preRenderTitle();
        _group.getBanner().ajaxReplace();
    }

    public void ajaxRefreshFoorter()
    {
        preRenderFooter();
        _group.getFooter().ajaxReplace();
    }
}
