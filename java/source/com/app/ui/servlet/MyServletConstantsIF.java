package com.app.ui.servlet;

public interface MyServletConstantsIF
{
    //##################################################
    //# misc
    //##################################################

    //Assumes ROOT (implied) context
    String SERVLET_ROOT                = "/";
    String SERVLET_PATH                = "servlet";

    int    LAYOUT_SIDE_WIDTH           = 200;
    int    LAYOUT_CENTER_WIDTH         = 540;

    String RECOMMENDED_BROWSER_TITLE   = "Recommended Browser";
    String RECOMMENDED_BROWSER_MESSAGE = "For best results, we recommend using FireFox 3.5 or later.";

    //##################################################
    //# libraries: kodemore
    //##################################################

    String KODEMORE_UTILITY_JS         = "script/kmUtility.js";
    String KODEMORE_AJAX_JS            = "script/kmAjax.js";

    //##################################################
    //# libraries: jquery
    //##################################################

    String JQUERY_JS                   = "jquery/jquery-1.5.1-min.js";
    String JQUERY_UI_JS                = "jquery/jquery-ui-1.8.13.custom.min.js";

    String JQUERY_SMOOTH_MENU_CSS      = "jquery/smoothmenu-1.5/ddsmoothmenu.css";
    String JQUERY_SMOOTH_MENU_V_CSS    = "jquery/smoothmenu-1.5/ddsmoothmenu-v.css";
    String JQUERY_SMOOTH_MENU_JS       = "jquery/smoothmenu-1.5/ddsmoothmenu.js";

    String JQUERY_SMOOTH_MENU_COMMENT  = "Smooth Navigational Menu\n"
                                           + "(c) Dynamic Drive DHTML code library (www.dynamicdrive.com)\n"
                                           + "This notice MUST stay intact for legal use\n"
                                           + "Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code";

    String JQUERY_MODAL_JS             = "jquery/simplemodal-1.4.1/simplemodal.min.js";
    String JQUERY_MODAL_CSS            = "jquery/simplemodal-1.4.1/simplemodal.css";
    String JQUERY_MODAL_X_IMAGE        = "jquery/simplemodal-1.4.1/simplemodal-x.png";

    String JQUERY_COLOR_PICKER_JS      = "jquery/colorpicker-09.05.23/js/colorpicker.js";
    String JQUERY_COLOR_PICKER_CSS     = "jquery/colorpicker-09.05.23/css/colorpicker.css";
}
