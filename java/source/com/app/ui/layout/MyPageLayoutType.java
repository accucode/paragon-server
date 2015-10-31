package com.app.ui.layout;

import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;

public enum MyPageLayoutType
{
    //##################################################
    //# values
    //##################################################

    /**
     * Shows just the header, footer, and content.
     * The content fills the area between the header and footer.
     */
    bare,

    /**
     * Adds the top tabs and the page title.
     */
    simple,

    /**
     * Adds the sub menu.
     */
    nested;

    //##################################################
    //# header
    //##################################################

    public boolean showsHeader()
    {
        return true;
    }

    public String getHeaderCss()
    {
        MyPageLayoutType e = this;
        switch ( e )
        {
            case bare:
                return KmCssDefaultConstantsIF.appHeader_bare;

            case simple:
            case nested:
                return KmCssDefaultConstantsIF.appHeader_normal;
        }
        return null;
    }

    //##################################################
    //# footer
    //##################################################

    public boolean showsFooter()
    {
        return true;
    }

    public String getFooterCss()
    {
        MyPageLayoutType e = this;
        switch ( e )
        {
            case bare:
                return KmCssDefaultConstantsIF.appFooter_bare;

            case simple:
            case nested:
                return KmCssDefaultConstantsIF.appFooter_normal;

        }
        return null;
    }

    //##################################################
    //# tabs (primary navigation)
    //##################################################

    public boolean showsTabs()
    {
        MyPageLayoutType e = this;
        switch ( e )
        {
            case nested:
            case simple:
                return true;

            case bare:
                return false;
        }
        return false;
    }

    public String getTabsCss()
    {
        return KmCssDefaultConstantsIF.appTabs;
    }

    //##################################################
    //# menu (secondary navigation)
    //##################################################

    public boolean showsMenu()
    {
        MyPageLayoutType e = this;
        switch ( e )
        {
            case nested:
                return true;

            case bare:
            case simple:
                return false;
        }
        return false;
    }

    public String getMenuCss()
    {
        return KmCssDefaultConstantsIF.appMenu;
    }

    //##################################################
    //# title
    //##################################################

    public boolean showsTitle()
    {
        MyPageLayoutType e = this;
        switch ( e )
        {
            case simple:
            case nested:
                return true;

            case bare:
                return false;
        }
        return false;
    }

    public String getTitleCss()
    {
        MyPageLayoutType e = this;
        switch ( e )
        {
            case bare:
                return KmCssDefaultConstantsIF.appTitle_bare;

            case simple:
                return KmCssDefaultConstantsIF.appTitle_simple;

            case nested:
                return KmCssDefaultConstantsIF.appTitle_nested;

        }
        return null;
    }

    //##################################################
    //# content
    //##################################################

    public boolean showsContent()
    {
        return true;
    }

    public String getContentCss()
    {
        MyPageLayoutType e = this;
        switch ( e )
        {
            case bare:
                return KmCssDefaultConstantsIF.appContent_bare;

            case simple:
                return KmCssDefaultConstantsIF.appContent_simple;

            case nested:
                return KmCssDefaultConstantsIF.appContent_nested;

        }
        return null;
    }

}
