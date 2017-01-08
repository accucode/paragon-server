package com.app.ui.layout;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.servlet.ScPage;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScSubmitButton;
import com.kodemore.servlet.field.ScAutoCompleteField;
import com.kodemore.utility.Kmu;

import com.app.ui.page.MyMenuRegistry;
import com.app.ui.page.MyPageRegistry;

public class MyPageMenu
    extends ScDiv
{
    //##################################################
    //# variables
    //##################################################

    private ScForm              _pageForm;
    private ScAutoCompleteField _pageField;

    //##################################################
    //# constructor
    //##################################################

    public MyPageMenu()
    {
        setHtmlId(KmCssDefaultConstantsIF.ID_menu);
        installPageForm();
    }

    //##################################################
    //# install page field
    //##################################################

    private void installPageForm()
    {
        ScForm form;
        form = new ScForm();
        form.setSubmitAction(this::handlePageFieldSubmit);
        form.add(createPageField());
        form.css().flexRow().flexCrossAlignCenter().rowSpacer5().padRight5();

        ScSubmitButton button;
        button = form.addSubmitButton("go");
        button.setFlavorNormal();
        button.style().height(24).minWidth(20).padTop(2).padLeft(5);
        button.clearImages();
        button.hide();

        _pageForm = form;
    }

    private ScAutoCompleteField createPageField()
    {
        ScAutoCompleteField e;
        e = new ScAutoCompleteField();
        e.setPlaceholder("Jump to... (alt-/)");
        e.setHelp(""
            + "Use this field to quickly jump to any page that you have access to. "
            + "You can also use the hotkey alt-/.");
        e.setSelectAction(this::handlePageFieldSelect);
        e.disableChangeTracking();
        _pageField = e;
        return e;
    }

    //##################################################
    //# accessing
    //##################################################

    public String getPageMenuFieldId()
    {
        return _pageField.getInputHtmlId();
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
        renderPageFieldOn(out);

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
        out.printAttribute("onclick", e.getClickScript().formatScript());
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
        out.printAttribute("onclick", e.getClickScript().formatScript());
        out.printAttribute(getSubItemCssFor(e));
        out.close();
        out.print(e.getTitle());
        out.end("li");
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

    private void renderPageFieldOn(KmHtmlBuilder out)
    {
        KmList<String> titles = getAvailablePages().collect(e -> e.getTitle());
        _pageField.addOptions(titles);

        out.render(_pageForm);
    }

    //##################################################
    //# handle
    //##################################################

    private void handlePageFieldSubmit()
    {
        String title = _pageField.getValue();
        ajaxGotoPageTitle(title);
    }

    private void handlePageFieldSelect()
    {
        String title = getData().getExtraParameter();
        ajaxGotoPageTitle(title);
    }

    //##################################################
    //# support
    //##################################################

    private MyMenuRegistry getMenuRegistry()
    {
        return MyMenuRegistry.getInstance();
    }

    private KmList<ScPage> getAllPages()
    {
        return MyPageRegistry.getInstance().getPages();
    }

    private KmList<ScPage> getAvailablePages()
    {
        return getAllPages().select(e -> isAvailable(e));
    }

    private boolean isAvailable(ScPage e)
    {
        return e.checkSecuritySilently();
    }

    private void ajaxGotoPageTitle(String title)
    {
        if ( Kmu.isEmpty(title) )
            return;

        ScPage page = getAllPages().selectFirst(e -> e.hasTitleIgnoreCase(title));
        if ( page == null )
        {
            ajaxToast("No such page.");
            return;
        }

        if ( !isAvailable(page) )
        {
            ajaxToast("No access to page.");
            return;
        }

        _pageField.clearValue();
        _pageField.ajaxUpdateFieldValues();

        page.ajaxEnter();
    }

}
