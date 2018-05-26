package com.app.ui.layout;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.servlet.ScPage;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.field.ScAutoCompleteField;
import com.kodemore.servlet.script.ScActionScript;
import com.kodemore.servlet.script.ScBlockScript;

import com.app.ui.page.MyPageRegistry;
import com.app.ui.page.menu.MyMenuRegistry;

public class MyPageMenu
    extends ScDiv
{
    //##################################################
    //# variables
    //##################################################

    private ScForm        _pageForm;
    private MyJumpToField _jumpToField;
    private ScAction      _pageAction;

    //##################################################
    //# constructor
    //##################################################

    public MyPageMenu()
    {
        setHtmlId(KmCssDefaultConstantsIF.ID_menu);
        installPageForm();
        _pageAction = newCheckedAction(this::handlePage);
    }

    //##################################################
    //# install page field
    //##################################################

    private void installPageForm()
    {
        ScForm form;
        form = new ScForm();
        form.onSubmit(newUncheckedAction(this::handlePageFieldSubmit));
        form.add(createJumpToField());
        form.css().flexRow().flexCrossAlignCenter().rowSpacer5().padRight5();
        form.addSubmitButton("go").hide();

        _pageForm = form;
    }

    private ScAutoCompleteField createJumpToField()
    {
        MyJumpToField e;
        e = new MyJumpToField();
        _jumpToField = e;
        return e;
    }

    //##################################################
    //# accessing
    //##################################################

    public String getPageMenuFieldId()
    {
        return _jumpToField.getInputHtmlId();
    }

    //##################################################
    //# ajax
    //##################################################

    public void ajaxRefreshContent(boolean visible)
    {
        ajaxShow(visible);
        ajaxRefreshContent();
    }

    public void ajaxRefreshContent()
    {
        ajaxSetContents(renderMenus());
    }

    //==================================================
    //= render menus
    //==================================================

    private KmHtmlBuilder renderMenus()
    {
        MyMenuRegistry r = getMenuRegistry();
        MyMenuItem left = r.getLeftRoot();
        MyMenuItem right = r.getRightRoot();

        KmHtmlBuilder out;
        out = new KmHtmlBuilder();

        renderMenuOn(out, left, false);
        renderFillerOn(out);
        renderMenuOn(out, right, true);
        renderJumpToFieldOn(out);

        return out;
    }

    private void renderMenuOn(KmHtmlBuilder out, MyMenuItem root, boolean right)
    {
        KmCssDefaultBuilder css;
        css = new KmCssDefaultBuilder();
        css.menu_bar();

        if ( right )
            css.menu_rightBar();

        out.openDiv();
        out.printAttribute(css);
        out.close();

        out.begin("ul");
        renderTopItemsOn(out, root);
        out.end("ul");

        out.endDiv();
    }

    private void renderTopItemsOn(KmHtmlBuilder out, MyMenuItem root)
    {
        KmList<MyMenuItem> v = root.getSubMenus();
        for ( MyMenuItem e : v )
            if ( e.isVisible() )
                renderTopItemOn(out, e);
    }

    private void renderTopItemOn(KmHtmlBuilder out, MyMenuItem e)
    {
        out.begin("li");

        renderTopItemTextOn(out, e);
        renderSubMenuOn(out, e);

        out.end("li");
    }

    private void renderTopItemTextOn(KmHtmlBuilder out, MyMenuItem e)
    {
        out.openDiv();
        out.printAttribute("onclick", formatPageScript(e));
        out.close();
        out.print(e.getTitle());
        out.endDiv();
    }

    private void renderSubMenuOn(KmHtmlBuilder out, MyMenuItem top)
    {
        out.begin("ul");

        KmList<MyMenuItem> v = top.getSubMenus();
        for ( MyMenuItem e : v )
            if ( e.isVisible() )
                renderSubItemOn(out, e);

        out.end("ul");
    }

    private void renderSubItemOn(KmHtmlBuilder out, MyMenuItem e)
    {
        out.open("li");
        out.printAttribute("onclick", formatPageScript(e));
        out.printAttribute(getSubItemCssFor(e));
        out.close();
        out.print(e.getTitle());
        out.end("li");
    }

    private String formatPageScript(MyMenuItem e)
    {
        ScActionScript s;
        s = new ScActionScript();
        s.setAction(_pageAction);
        s.setArgument(e.getPageKey());
        return s.formatScript();
    }

    private KmCssDefaultBuilder getSubItemCssFor(MyMenuItem e)
    {
        KmCssDefaultBuilder css;
        css = new KmCssDefaultBuilder();

        if ( e.getTopDivider() )
            css.menu_topDivider();

        if ( e.getBottomDivider() )
            css.menu_bottomDivider();

        return css.hasValue()
            ? css
            : null;
    }

    //==================================================
    //= render :: other
    //==================================================

    private void renderFillerOn(KmHtmlBuilder out)
    {
        KmCssDefaultBuilder css;
        css = new KmCssDefaultBuilder();
        css.flexChildFiller();

        out.beginDiv(css);
        out.endDiv();
    }

    //==================================================
    //= render :: page field
    //==================================================

    private void renderJumpToFieldOn(KmHtmlBuilder out)
    {
        out.render(_pageForm);
    }

    //##################################################
    //# handle
    //##################################################

    private void handlePageFieldSubmit()
    {
        _jumpToField.jumpTo();
    }

    private void handlePage()
    {
        ScServletData data = getData();

        ScBlockScript ajax;
        ajax = data.ajax();
        ajax.run("Kmu.closeMenu();");

        String pageKey = data.getStringArgument();
        ScPage page = MyPageRegistry.getInstance().findKey(pageKey);

        if ( page == null )
        {
            ajax.toast("Invalid menu selection.");
            return;
        }

        page.ajaxEnterFresh();
    }

    //##################################################
    //# support
    //##################################################

    private MyMenuRegistry getMenuRegistry()
    {
        return MyMenuRegistry.getInstance();
    }
}
