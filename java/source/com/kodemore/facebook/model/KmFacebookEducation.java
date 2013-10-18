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

    public static final String             SCHOOL_KEY       = "school";
    public static final String             DEGREE_KEY       = "degree";
    public static final String             YEAR_KEY         = "year";
    public static final String             CONCENTATION_KEY = "concentration";
    public static final String             TYPE_KEY         = "type";
    public static final String             WITH_KEY         = "with";
    public static final String             CLASSES_KEY      = "classes";

    //##################################################
    //# variables 
    //##################################################

    private KmFacebookSimpleObject         _school;
    private KmFacebookSimpleObject         _degree;
    private KmFacebookSimpleObject         _year;
    private KmFacebookSimpleObject         _concentration;
    private KmFacebookSimpleObject         _type;
    private KmList<KmFacebookSimpleObject> _with;
    private KmList<KmFacebookClass>        _classes;

    //##################################################
    //# constructors
    //##################################################

    public KmFacebookEducation()
    {
        _with = new KmList<KmFacebookSimpleObject>();
        _classes = new KmList<KmFacebookClass>();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmFacebookSimpleObject getSchool()
    {
        return _school;
    }

    public void setSchool(KmFacebookSimpleObject e)
    {
        _school = e;
    }

    public KmFacebookSimpleObject getDegree()
    {
        return _degree;
    }

    public void setDegree(KmFacebookSimpleObject e)
    {
        _degree = e;
    }

    public KmFacebookSimpleObject getYear()
    {
        return _year;
    }

    public void setYear(KmFacebookSimpleObject e)
    {
        _year = e;
    }

    public KmFacebookSimpleObject getConcentration()
    {
        return _concentration;
    }

    public void setConcentration(KmFacebookSimpleObject e)
    {
        _concentration = e;
    }

    public KmFacebookSimpleObject getType()
    {
        return _type;
    }

    public void setType(KmFacebookSimpleObject e)
    {
        _type = e;
    }

    public KmList<KmFacebookSimpleObject> getWith()
    {
        return _with;
    }

    public void setWith(KmList<KmFacebookSimpleObject> e)
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
        e.setSchool(KmFacebookSimpleObject.createWith(map.getMap(SCHOOL_KEY)));
        e.setDegree(KmFacebookSimpleObject.createWith(map.getMap(DEGREE_KEY)));
        e.setYear(KmFacebookSimpleObject.createWith(map.getMap(YEAR_KEY)));
        e.setConcentration(KmFacebookSimpleObject.createWith(map.getMap(CONCENTATION_KEY)));
        e.setType(KmFacebookSimpleObject.createWith(map.getMap(TYPE_KEY)));
        e.setWith(KmFacebookSimpleObject.createObjectListWith(map.getArray(WITH_KEY)));
        e.setClasses(KmFacebookClass.createClassListWith(map.getArray(CLASSES_KEY)));
        return e;
    }

    public static KmList<KmFacebookEducation> createEducationListWith(KmJsonArray arr)
    {
        KmList<KmFacebookEducation> v;
        v = new KmList<KmFacebookEducation>();

        int n = arr.size();
        for ( int i = 0; i < n; i++ )
            v.add(createWith(arr.getMapAt(i)));

        return v;
    }
}
