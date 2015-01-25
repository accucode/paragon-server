package com.kodemore.facebook.model;

import com.kodemore.collection.KmList;
import com.kodemore.json.KmJsonArray;
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

    private static final String      SCHOOL_KEY       = "school";
    private static final String      DEGREE_KEY       = "degree";
    private static final String      YEAR_KEY         = "year";
    private static final String      CONCENTATION_KEY = "concentration";
    private static final String      TYPE_KEY         = "type";
    private static final String      WITH_KEY         = "with";
    private static final String      CLASSES_KEY      = "classes";

    //##################################################
    //# variables
    //##################################################

    private KmFacebookIdName         _school;
    private KmFacebookIdName         _degree;
    private KmFacebookIdName         _year;
    private KmFacebookIdName         _concentration;
    private KmFacebookIdName         _type;
    private KmList<KmFacebookIdName> _with;
    private KmList<KmFacebookClass>  _classes;

    //##################################################
    //# constructors
    //##################################################

    public KmFacebookEducation()
    {
        _with = new KmList<>();
        _classes = new KmList<>();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmFacebookIdName getSchool()
    {
        return _school;
    }

    public void setSchool(KmFacebookIdName e)
    {
        _school = e;
    }

    public KmFacebookIdName getDegree()
    {
        return _degree;
    }

    public void setDegree(KmFacebookIdName e)
    {
        _degree = e;
    }

    public KmFacebookIdName getYear()
    {
        return _year;
    }

    public void setYear(KmFacebookIdName e)
    {
        _year = e;
    }

    public KmFacebookIdName getConcentration()
    {
        return _concentration;
    }

    public void setConcentration(KmFacebookIdName e)
    {
        _concentration = e;
    }

    public KmFacebookIdName getType()
    {
        return _type;
    }

    public void setType(KmFacebookIdName e)
    {
        _type = e;
    }

    public KmList<KmFacebookIdName> getWith()
    {
        return _with;
    }

    public void setWith(KmList<KmFacebookIdName> e)
    {
        _with = e;
    }

    public KmList<KmFacebookClass> getClasses()
    {
        return _classes;
    }

    public void setClasses(KmList<KmFacebookClass> e)
    {
        _classes = e;
    }

    //##################################################
    //# convenience
    //##################################################

    public static KmFacebookEducation createWith(KmJsonMap map)
    {
        KmFacebookEducation e;
        e = new KmFacebookEducation();
        e.setSchool(KmFacebookIdName.createWith(map.getMap(SCHOOL_KEY)));
        e.setDegree(KmFacebookIdName.createWith(map.getMap(DEGREE_KEY)));
        e.setYear(KmFacebookIdName.createWith(map.getMap(YEAR_KEY)));
        e.setConcentration(KmFacebookIdName.createWith(map.getMap(CONCENTATION_KEY)));
        e.setType(KmFacebookIdName.createWith(map.getMap(TYPE_KEY)));
        e.setWith(KmFacebookIdName.createListWith(map.getArray(WITH_KEY)));
        e.setClasses(KmFacebookClass.createClassListWith(map.getArray(CLASSES_KEY)));
        return e;
    }

    public static KmList<KmFacebookEducation> createListWith(KmJsonArray arr)
    {
        KmList<KmFacebookEducation> v;
        v = new KmList<>();

        int n = arr.size();
        for ( int i = 0; i < n; i++ )
            v.add(createWith(arr.getMapAt(i)));

        return v;
    }
}
