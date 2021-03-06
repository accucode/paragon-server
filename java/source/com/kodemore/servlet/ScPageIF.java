package com.kodemore.servlet;

import com.kodemore.servlet.action.ScContextSupplierIF;

public interface ScPageIF
    extends ScContextSupplierIF, ScModelApplicatorIF
{
    //##################################################
    //# settings
    //##################################################

    /**
     * Return the pages visible title.
     * This is displayed at the top of the page and should ~uniquely identify
     * this page.
     */
    String getTitle();

    String getBrowserTabTitle();

    /**
     * If true, the framework security will not allow render this page unless
     * an authenticated used is associated with the session.  Also, not actions
     * associated with this page can be run.
     */
    boolean requiresUser();

    //##################################################
    //# navigation
    //##################################################

    /**
     * Navigate to, or enter, this page.  This does not directly update the ui,
     * but rather updates the client's browser history.  When that history is
     * updated it triggers the client to send a request for the pages content.
     * This, in turn, calls print.  While this seems a bit convoluted, it allows
     * the application to utilize bookmarkable urls in a consistent way.
     *
     * @see #ajaxPrint
     */
    void ajaxEnter();

    /**
     * Print myself into the page layout main area.
     *
     * I do NOT navigate.  That is, I do not change the browser's url
     * or history.  Instead, I am used to render the html content for
     * the current page.  This is usually done immediately after the
     * client-browser navigates to a new page and updates the url/history.
     * After that, pages usually update individual ui elements as needed.
     * However, in some cases it may be useful for a page to simply redisplay
     * its entire area, and this method can be called as needed.
     *
     * A convenience method that:
     *      - checks security,
     *      - displays page content in the layout's main area,
     *      - attempts to set focus on the root.
     *
     * Subclasses can use preRender and postRender to hook into
     * the print process.
     *
     * @see #ajaxEnter
     */
    void ajaxPrint();
}
