package com.app.ui.page.manage.crud;

import java.util.function.Consumer;

import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.servlet.control.ScControlIF;
import com.kodemore.servlet.field.ScHtmlIdIF;

import com.app.model.core.MyUidDomainIF;

/**
 * I display a list of child models with basic client side filtering.
 * This search view is suitable for situations where we expect a reasonable
 * short list of models.  100s of childre are likely fine, but 1000s will
 * result is slow response times or may crash the client browser.
 *
 * @param <P> The PARENT, used to get the list.
 * @param <C> The CHILD, the selected list item.
 */
public interface MyCrudSearchViewIF<P extends MyUidDomainIF, C extends MyUidDomainIF>
    extends ScControlIF, ScHtmlIdIF
{
    //##################################################
    //# install
    //##################################################

    void installShrinkButton(Runnable runnable);

    //##################################################
    //# style
    //##################################################

    KmCssDefaultBuilder css();

    //##################################################
    //# domain
    //##################################################

    void setDomain(P parent, C child);

    void setDomainParent(P parent);

    void setDomainChild(C child);

    //##################################################
    //# listeners
    //##################################################

    void onRefresh(Runnable e);

    void onAdd(Runnable e);

    void onSelect(Consumer<C> e);

    //##################################################
    //# handle
    //##################################################

    void handleAddSaved(C child, boolean more);

    void handleEditSaved(C child);

    void handleDeleted(C child);

    void handleChildChanged(C child);

    void handleChildListChanged(C child);

    //##################################################
    //# ajax
    //##################################################

    void ajaxRefreshList();

    default void ajaxRefreshListItems()
    {
        ajaxRefreshList();
    }
}
