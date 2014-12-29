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
     * Adds the top menu and the page title.
     */
    simple,

    /**
     * Adds the left menu.
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
                return KmCssDefaultConstantsIF.pageHeader_bare;

            case simple:
            case nested:
                return KmCssDefaultConstantsIF.pageHeader_normal;
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
                return KmCssDefaultConstantsIF.pageFooter_bare;

            case simple:
            case nested:
                return KmCssDefaultConstantsIF.pageFooter_normal;

        }
        return null;
    }

    //##################################################
    //# top menu
    //##################################################

    public boolean showsTopMenu()
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

    public String getTopMenuCss()
    {
        return KmCssDefaultConstantsIF.topMenu;
    }

    //##################################################
    //# left menu
    //##################################################

    public boolean showsLeftMenu()
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

    public String getLeftMenuCss()
    {
        return KmCssDefaultConstantsIF.leftMenu;
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
                return KmCssDefaultConstantsIF.pageTitle_bare;

            case simple:
                return KmCssDefaultConstantsIF.pageTitle_simple;

            case nested:
                return KmCssDefaultConstantsIF.pageTitle_nested;

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
                return KmCssDefaultConstantsIF.pageContent_bare;

            case simple:
                return KmCssDefaultConstantsIF.pageContent_simple;

            case nested:
                return KmCssDefaultConstantsIF.pageContent_nested;

        }
        return null;
    }

}
