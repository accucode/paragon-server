package com.app.ui.layout;

import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;

public enum MyPageLayoutType
{
    //##################################################
    //# values
    //##################################################

    /**
     * Shows nothing but the content.
     * This does not even show the header or footer.
     */
    bare,

    /**
     * Shows only the header, footer.
     * The content fills the area between the header and footer.
     */
    basic,

    /**
     * This is the normal layout, used for most pages in the application.
     * It includes menu and page title in addition to the header and footer.
     */
    normal;

    //##################################################
    //# header
    //##################################################

    public boolean showsHeader()
    {
        MyPageLayoutType type = this;
        switch ( type )
        {
            case bare:
                return false;

            case basic:
            case normal:
                return true;
        }
        return false;
    }

    public String getHeaderCss()
    {
        MyPageLayoutType type = this;
        switch ( type )
        {
            case bare:
                return KmCssDefaultConstantsIF.header_bare;

            case basic:
            case normal:
                return KmCssDefaultConstantsIF.header_normal;
        }
        return null;
    }

    //##################################################
    //# footer
    //##################################################

    public boolean showsFooter()
    {
        MyPageLayoutType type = this;
        switch ( type )
        {
            case bare:
                return false;

            case basic:
            case normal:
                return true;
        }
        return false;
    }

    public String getFooterCss()
    {
        MyPageLayoutType e = this;
        switch ( e )
        {
            case bare:
            case basic:
            case normal:
                return KmCssDefaultConstantsIF.footer;
        }
        return null;
    }

    //##################################################
    //# nav
    //##################################################

    public boolean showsMenu()
    {
        MyPageLayoutType e = this;
        switch ( e )
        {
            case normal:
                return true;

            case bare:
            case basic:
                return false;
        }
        return false;
    }

    public String getMenuCss()
    {
        MyPageLayoutType e = this;
        switch ( e )
        {
            case bare:
            case basic:
            case normal:
                return KmCssDefaultConstantsIF.menu;
        }
        return null;
    }

    //##################################################
    //# title
    //##################################################

    public boolean showsTitle()
    {
        MyPageLayoutType e = this;
        switch ( e )
        {
            case normal:
                return true;

            case bare:
            case basic:
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
                return KmCssDefaultConstantsIF.title_bare;

            case basic:
                return KmCssDefaultConstantsIF.title_basic;

            case normal:
                return KmCssDefaultConstantsIF.title_normal;
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
                return KmCssDefaultConstantsIF.content_bare;

            case basic:
                return KmCssDefaultConstantsIF.content_basic;

            case normal:
                return KmCssDefaultConstantsIF.content_normal;
        }
        return null;
    }

}
