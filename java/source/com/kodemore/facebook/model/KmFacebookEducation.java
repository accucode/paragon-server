package com.kodemore.facebook.model;

import com.kodemore.json.KmJsonMap;

/**
 * I am a simple facebook object with an id and a name.
 */
public class KmFacebookEducation
    extends Object
{
    //##################################################
    //# constants
    //##################################################

    public static final String ID_KEY   = "id";
    public static final String NAME_KEY = "name";

    //##################################################
    //# variables 
    //##################################################

    private String             _id;
    private String             _name;

    //##################################################
    //# accessing
    //##################################################

    public String getId()
    {
        return _id;
    }

    public void setId(String e)
    {
        _id = e;
    }

    public String getName()
    {
        return _name;
    }

    public void setName(String e)
    {
        _name = e;
    }

    //##################################################
    //# convenience
    //##################################################

    public static KmFacebookEducation createWith(KmJsonMap map)
    {
        KmFacebookEducation e;
        e = new KmFacebookEducation();
        e.setId(map.getString(ID_KEY));
        e.setName(map.getString(NAME_KEY));
        return e;
    }
}
