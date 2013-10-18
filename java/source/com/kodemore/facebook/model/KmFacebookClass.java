package com.kodemore.facebook.model;

import com.kodemore.collection.KmList;
import com.kodemore.json.KmJsonArray;
import com.kodemore.json.KmJsonMap;

/**
 * I am a class that is associated with the education object
 */
public class KmFacebookClass
    extends Object
{
    //##################################################
    //# constants
    //##################################################

    public static final String             ID_KEY          = "id";
    public static final String             NAME_KEY        = "name";
    public static final String             WITH_KEY        = "with";
    public static final String             DESCRIPTION_KEY = "description";
    public static final String             FROM_KEY        = "from";

    //##################################################
    //# variables 
    //##################################################

    private String                         _id;
    private String                         _name;
    private String                         _description;
    private KmList<KmFacebookSimpleObject> _with;
    private KmFacebookSimpleObject         _from;

    //##################################################
    //# constructors
    //##################################################

    public KmFacebookClass()
    {
        _with = new KmList<KmFacebookSimpleObject>();
    }

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

    public String getDescription()
    {
        return _description;
    }

    public void setDescription(String e)
    {
        _description = e;
    }

    public KmList<KmFacebookSimpleObject> getWith()
    {
        return _with;
    }

    public void setWith(KmList<KmFacebookSimpleObject> e)
    {
        _with = e;
    }

    public KmFacebookSimpleObject getFrom()
    {
        return _from;
    }

    public void setFrom(KmFacebookSimpleObject e)
    {
        _from = e;
    }

    //##################################################
    //# convenience
    //##################################################

    public static KmFacebookClass createWith(KmJsonMap map)
    {
        KmFacebookClass e;
        e = new KmFacebookClass();
        e.setId(map.getString(ID_KEY));
        e.setName(map.getString(NAME_KEY));
        e.setWith(KmFacebookSimpleObject.createObjectListWith(map.getArray(WITH_KEY)));
        e.setDescription(map.getString(DESCRIPTION_KEY));
        e.setFrom(KmFacebookSimpleObject.createWith(map.getMap(FROM_KEY)));
        return e;
    }

    public static KmList<KmFacebookClass> createClassListWith(KmJsonArray arr)
    {
        KmList<KmFacebookClass> v;
        v = new KmList<KmFacebookClass>();

        int n = arr.size();
        for ( int i = 0; i < n; i++ )
            v.add(createWith(arr.getMapAt(i)));

        return v;
    }
}
