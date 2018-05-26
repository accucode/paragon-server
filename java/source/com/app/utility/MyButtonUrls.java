package com.app.utility;

import com.kodemore.servlet.utility.ScUrls;

import com.app.ui.servlet.MyServletConstantsIF;

public class MyButtonUrls
    implements MyServletConstantsIF
{
    //##################################################
    //# logos
    //##################################################

    public static String favicon()
    {
        return ScUrls.getThemeImage("favicon.png");
    }

    //##################################################
    //# fields
    //##################################################

    public static String barcode()
    {
        return ScUrls.getThemeImage("barcode.png");
    }

    public static String calendar()
    {
        return ScUrls.getThemeImage("calendar.png");
    }

    //##################################################
    //# menu
    //##################################################

    public static String menuBlack()
    {
        return ScUrls.getThemeIcon("icon_moreVert_black_48.png");
    }

    public static String menuWhite()
    {
        return ScUrls.getThemeIcon("icon_moreVert_white_48.png");
    }

    //##################################################
    //# guide pages
    //##################################################

    public static String guideChart()
    {
        return ScUrls.getThemeImage("guideChart.png");
    }

    public static String guideList()
    {
        return ScUrls.getThemeImage("guideList.png");
    }

    public static String guideSetup()
    {
        return ScUrls.getThemeImage("guideSetup.png");
    }

    public static String guideSummary()
    {
        return ScUrls.getThemeImage("guideSummary.png");
    }

    //##################################################
    //# setup
    //##################################################

    public static String setupInfo()
    {
        return ScUrls.getThemeImage("setupInfo.png");
    }

    public static String setupList()
    {
        return ScUrls.getThemeImage("setupList.png");
    }

    public static String setupSheet()
    {
        return ScUrls.getThemeImage("setupSheet.png");
    }

    public static String setupTransfer()
    {
        return ScUrls.getThemeImage("setupTransfer.png");
    }

    public static String setupDefault()
    {
        return ScUrls.getThemeImage("setupCheckbox.png");
    }
}
