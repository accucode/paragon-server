package com.app.ui.layout;

import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.utility.KmEnumIF;
import com.kodemore.utility.Kmu;

public enum MyPageLayoutType
    implements KmEnumIF
{
    //##################################################
    //# values
    //##################################################

    /**
     * Shows nothing but the content.
     * This does not even show the header or footer.
     * The content fills the window, any scrolling must be
     * managed by the client (page) itself.
     */
    bare,

    /**
     * Similar to bare, but is configured for native printing
     * by the browser. The html BODY is configured for automatic
     * scrolling, the page should NOT use any absolute positioning.
     */
    print,

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
            case print:
                return false;

            case basic:
            case normal:
                return true;
        }
        throw Kmu.newEnumError(type);
    }

    public String getHeaderCss()
    {
        MyPageLayoutType type = this;
        switch ( type )
        {
            case bare:
            case print:
                return KmCssDefaultConstantsIF.header_bare;

            case basic:
            case normal:
                return KmCssDefaultConstantsIF.header_normal;
        }
        throw Kmu.newEnumError(type);
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
            case print:
                return false;

            case basic:
            case normal:
                return true;
        }
        throw Kmu.newEnumError(type);
    }

    public String getFooterCss()
    {
        MyPageLayoutType type = this;
        switch ( type )
        {
            case bare:
            case print:
            case basic:
            case normal:
                return KmCssDefaultConstantsIF.footer;
        }
        throw Kmu.newEnumError(type);
    }

    //##################################################
    //# nav
    //##################################################

    public boolean showsMenu()
    {
        MyPageLayoutType type = this;
        switch ( type )
        {
            case normal:
                return true;

            case bare:
            case print:
            case basic:
                return false;
        }
        throw Kmu.newEnumError(type);
    }

    public String getMenuCss()
    {
        MyPageLayoutType type = this;
        switch ( type )
        {
            case bare:
            case print:
            case basic:
            case normal:
                return KmCssDefaultConstantsIF.menu;
        }
        throw Kmu.newEnumError(type);
    }

    //##################################################
    //# title
    //##################################################

    public boolean showsTitle()
    {
        MyPageLayoutType type = this;
        switch ( type )
        {
            case normal:
                return true;

            case bare:
            case print:
            case basic:
                return false;
        }
        throw Kmu.newEnumError(type);
    }

    public String getTitleCss()
    {
        MyPageLayoutType type = this;
        switch ( type )
        {
            case bare:
            case print:
                return KmCssDefaultConstantsIF.title_bare;

            case basic:
                return KmCssDefaultConstantsIF.title_basic;

            case normal:
                return KmCssDefaultConstantsIF.title_normal;
        }
        throw Kmu.newEnumError(type);
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
        MyPageLayoutType type = this;
        switch ( type )
        {
            case bare:
                return KmCssDefaultConstantsIF.content_bare;

            case print:
                return KmCssDefaultConstantsIF.content_print;

            case basic:
                return KmCssDefaultConstantsIF.content_basic;

            case normal:
                return KmCssDefaultConstantsIF.content_normal;
        }
        throw Kmu.newEnumError(type);
    }
}
