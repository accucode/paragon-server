package com.kodemore.servlet;

/**
 * I am used to compose the QUERY STRING used to navigate to a particular
 * page within the application. The bookmark identifies the correct page,
 * as well as additional context such as the specific list item or notebook
 * tab.
 *
 * I CANNOT format a complete URL because the URLs host is determined by
 * the tenant, and is not tracked here. In most cases, the query string
 * is sufficient since the browser resolves this client-side. When a complete
 * URL is required, you can use methods like MyBookmark.formatEntryUrlFor(MyTenant),
 *
 * Bookmarks are transient. That is, we compose them temporarily, use them
 * to coordinate state and compose parameters, and then discard them. Bookmarks
 * should not be persisted and are not expected to be threadsafe.
 */
public class ScBookmark
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The page for which this bookmark is being composed.
     * This is required and must be passed via the constructor.
     *
     * We only store the pageKey (not the page) because we want
     * to avoid any dependency on the page itself. The bookmark
     * should not read any state directly from page, and the
     * bookmark absolutely must not update the page's state.
     */
    private String _pageKey;

    //##################################################
    //# constructor
    //##################################################

    public ScBookmark(ScPage e)
    {
        _pageKey = e.getKey();
    }

    //##################################################
    //# page
    //##################################################

    public String getPageKey()
    {
        return _pageKey;
    }

    private ScPage getPage()
    {
        return ScPageRegistry.getInstance().findKey(getPageKey());
    }

    public String getBrowserTabTitle()
    {
        return getPage().getBrowserTabTitle();
    }

    //##################################################
    //# params
    //##################################################

    /**
     * Read my state from the parameters typically parsed from a URL.
     *
     * The readFrom and writeTo methods are USUALLY symmetric.
     * However, the pageKey is an exception. Although we must
     * include it when composing the parameter list, we do NOT
     * read it. This is because the bookmark's page is determined
     * ahead of time and passed in via the constructor.
     *
     * Subclasses should override this to implement specific state.
     * Subclasses should call super.readFrom.
     *
     * @param params
     */
    public void readFrom(ScParameterList params)
    {
        // none
    }

    /**
     * Write my state to the paramaters used to compose urls.
     * The page key must be included. Additional state may be added later.
     *
     * @param params
     */
    public void writeTo(ScParameterList params)
    {
        params.setString(ScConstantsIF.PARAMETER_REQUESTED_PAGE_KEY, getPageKey());
    }

    //##################################################
    //# url
    //##################################################

    public final String formatQueryString()
    {
        return composeParameters().formatQueryString();
    }

    public final ScParameterList composeParameters()
    {
        ScParameterList v;
        v = new ScParameterList();
        writeTo(v);
        return v;
    }

    public final void readFromWindowLocation()
    {
        ScParameterList v = ScServletData.getLocal().getWindowParameters();
        readFrom(v);
    }

    public void readFromUrl(String s)
    {
        ScParameterList v;
        v = new ScParameterList();
        v.parseUrl(s);
        readFrom(v);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public final String toString()
    {
        return formatQueryString();
    }

}
