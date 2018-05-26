package com.kodemore.generator.model;

import com.kodemore.generator.KmgElement;
import com.kodemore.stf.KmStfElement;
import com.kodemore.utility.Kmu;

/**
 * I define model attributes that are specific to the user interface.
 * Models are not required to define this, but without it certain tools
 * will not be generated.
 */
public class KmgModelUi
    extends KmgElement
{
    //##################################################
    //# variables
    //##################################################

    private String _page;
    private int    _gridColumnWidth;
    private String _ajaxEnterMethod;
    private String _popoutUrlMethod;

    //##################################################
    //# constructor
    //##################################################

    public KmgModelUi(KmgElement parent)
    {
        super(parent);
    }

    //##################################################
    //# accessing
    //##################################################

    public String getPage()
    {
        return _page;
    }

    public int getGridColumnWidth()
    {
        return _gridColumnWidth;
    }

    public String getAjaxEnterMethod()
    {
        return _ajaxEnterMethod;
    }

    public String getPopoutUrlMethod()
    {
        return _popoutUrlMethod;
    }

    //##################################################
    //# parse
    //##################################################

    @Override
    public void parse(KmStfElement x)
    {
        checkAttributeKeys(x, "page", "ajaxEnterMethod", "popoutUrlMethod", "gridColumnWidth");

        _page = parseRequiredString(x, "page");
        _ajaxEnterMethod = parseString(x, "ajaxEnterMethod", "ajaxEnter");
        _popoutUrlMethod = parseString(x, "popoutUrlMethod", "getPopoutUrlFor");
        _gridColumnWidth = parseInteger(x, "gridColumnWidth", 200);
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        // none
    }

    @Override
    public void postValidate()
    {
        // none
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return "model ui";
    }

    //##################################################
    //# context
    //##################################################

    public String getf_Page()
    {
        return getPage();
    }

    public String getf_ajaxEnterPage()
    {
        return Kmu.format("%s.getInstance().%s", getf_Page(), getAjaxEnterMethod());
    }

    public String getf_formatPopoutUrl()
    {
        return Kmu.format("%s.getInstance().%s", getf_Page(), getPopoutUrlMethod());
    }

}
