package com.kodemore.email.format;

import com.kodemore.html.KmHtmlBuilder;

public interface KmEmailElementIF
{
    //##################################################
    //# render
    //##################################################

    public void renderOn(KmHtmlBuilder out);

    public KmHtmlBuilder toHtmlBuilder();

    public String formatHtml();

    //##################################################
    //# style
    //##################################################

    String STYLE_KEY = "style";

    //==================================================
    //= style :: root
    //==================================================

    String ROOT_STYLE_OUTER = ""
        + "font:13px Roboto,Arial;"
        + "background-color:#f5f5f5;"
        + "text-align:center;";

    String ROOT_STYLE_INNER = ""
        + "display:inline-block;"
        + "width:90%;"
        + "max-width:700px;"
        + "min-width:300x;"
        + "text-align:left;"
        + "padding:20px 30px 20px 30px;";

    //==================================================
    //= style :: layout
    //==================================================

    String GAP_STYLE       = "height:20px";
    String GAP_SMALL_STYLE = "height:15px";

    String DIVIDER_STYLE = "height:1px;background-color:#aaa;";

    //==================================================
    //= style :: header
    //==================================================

    String HEADER_STYLE     = "font-size:24px;font-weight:bold;padding-bottom:5px;";
    String SUB_HEADER_STYLE = "font-size:18px;font-weight:bold;padding-bottom:5px;";

    //==================================================
    //= style :: section
    //==================================================

    String SUB_SECTION_STYLE = ""
        + "padding:20px 30px 20px 30px;"
        + "border:1px solid #ddd;"
        + "overflow:auto;"
        + "background-color:#fff;";

    //==================================================
    //= style :: table
    //==================================================

    String TABLE_HEADER_ROW_STYLE = "font-weight:bold";

    String TABLE_CELL_STYLE = ""
        + "padding-right:15px;"
        + "padding-top:5px;"
        + "overflow:hidden;"
        + "white-space:nowrap;"
        + "text-overflow:ellipsis;"
        + "max-width:150px";
}
