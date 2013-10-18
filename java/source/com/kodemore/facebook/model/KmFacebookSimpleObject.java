package com.kodemore.facebook.model;

import com.kodemore.collection.KmList;
import com.kodemore.json.KmJsonArray;
import com.kodemore.json.KmJsonMap;

/**
 * I am a simple facebook object with an id and a name.
 */
public class KmFacebookSimpleObject
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

    public static KmFacebookSimpleObject createWith(KmJsonMap map)
    {
        KmFacebookSimpleObject e;
        e = new KmFacebookSimpleObject();
        e.setId(map.getString(ID_KEY));
        e.setName(map.getString(NAME_KEY));
        return e;
    }

    public static KmList<KmFacebookSimpleObject> createObjectListWith(KmJsonArray arr)
    {
        KmList<KmFacebookSimpleObject> v;
        v = new KmList<KmFacebookSimpleObject>();

        int n = arr.size();
        for ( int i = 0; i < n; i++ )
            v.add(KmFacebookSimpleObject.createWith(arr.getMapAt(i)));

        return v;
    }
}
