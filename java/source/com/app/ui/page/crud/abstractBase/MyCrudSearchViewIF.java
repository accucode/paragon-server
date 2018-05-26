package com.app.ui.page.crud.abstractBase;

import java.util.function.Consumer;

import com.kodemore.domain.KmUidDomainIF;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.servlet.control.ScControlIF;
import com.kodemore.servlet.field.ScHtmlIdIF;

/**
 * I display a list of child models with basic client side filtering.
 * This search view is suitable for situations where we expect a reasonable
 * short list of models.  100s of childre are likely fine, but 1000s will
 * result is slow response times or may crash the client browser.
 *
 * @param <P> The PARENT, used to get the list.
 * @param <C> The CHILD, the selected list item.
 */
public interface MyCrudSearchViewIF<P extends KmUidDomainIF, C extends KmUidDomainIF>
    extends ScControlIF, ScHtmlIdIF
{
    //##################################################
    //# install
    //##################################################

    void installCollapseButton(Runnable runnable);

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

    void handleAddSaved(MyCrudSaveEvent<C> e);

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
