package com.kodemore.zendesk;

public class KmZendeskCustomField
{

    /**
     * I am a custom field object
     * 
     * Api documentation
     *      http://developer.zendesk.com/documentation/rest_api/introduction.html
     */

    //##################################################
    //# variables (public)
    //##################################################//

    private Integer _id;
    private String  _value;

    //##################################################
    //# accessing
    //##################################################//

    public Integer getId()
    {
        return _id;
    }

    public void setId(Integer id)
    {
        _id = id;
    }

    public String getValue()
    {
        return _value;
    }

    public void setValue(String value)
    {
        _value = value;
    }

    @Override
    public String toString()
    {
        return "(id=" + _id + ", value=" + _value + ")";

    }

}
