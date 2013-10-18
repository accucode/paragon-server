package com.kodemore.facebook.model;

import com.kodemore.collection.KmList;
import com.kodemore.json.KmJsonArray;
import com.kodemore.json.KmJsonMap;
import com.kodemore.time.KmDate;

/**
 * I am a facebook work object.
 */
public class KmFacebookWork
    extends Object
{
    //##################################################
    //# constants
    //##################################################

    public static final String             EMPLOYER_KEY    = "employer";
    public static final String             LOCATION_KEY    = "location";
    public static final String             POSITION_KEY    = "position";
    public static final String             FROM_KEY        = "from";
    public static final String             WITH_KEY        = "with";
    public static final String             DESCRIPTION_KEY = "description";
    public static final String             START_DATE_KEY  = "start_date";
    public static final String             END_DATE_KEY    = "end_date";
    public static final String             PROJECTS_KEY    = "projects";

    //##################################################
    //# variables 
    //##################################################

    private KmFacebookSimpleObject         _employer;
    private KmFacebookSimpleObject         _location;
    private KmFacebookSimpleObject         _position;
    private KmFacebookSimpleObject         _from;
    private KmList<KmFacebookSimpleObject> _with;
    private String                         _description;
    private KmDate                         _startDate;
    private KmDate                         _endDate;
    private KmList<KmFacebookSimpleObject> _projects;

    //##################################################
    //# accessing
    //##################################################

    public KmFacebookSimpleObject getEmployer()
    {
        return _employer;
    }

    public void setEmployer(KmFacebookSimpleObject employer)
    {
        _employer = employer;
    }

    public KmFacebookSimpleObject getLocation()
    {
        return _location;
    }

    public void setLocation(KmFacebookSimpleObject location)
    {
        _location = location;
    }

    public KmFacebookSimpleObject getPosition()
    {
        return _position;
    }

    public void setPosition(KmFacebookSimpleObject position)
    {
        _position = position;
    }

    public KmFacebookSimpleObject getFrom()
    {
        return _from;
    }

    public void setFrom(KmFacebookSimpleObject from)
    {
        _from = from;
    }

    public KmList<KmFacebookSimpleObject> getWith()
    {
        return _with;
    }

    public void setWith(KmList<KmFacebookSimpleObject> with)
    {
        _with = with;
    }

    public String getDescription()
    {
        return _description;
    }

    public void setDescription(String description)
    {
        _description = description;
    }

    public KmDate getStartDate()
    {
        return _startDate;
    }

    public void setStartDate(KmDate startDate)
    {
        _startDate = startDate;
    }

    public KmDate getEndDate()
    {
        return _endDate;
    }

    public void setEndDate(KmDate endDate)
    {
        _endDate = endDate;
    }

    public KmList<KmFacebookSimpleObject> getProjects()
    {
        return _projects;
    }

    public void setProjects(KmList<KmFacebookSimpleObject> projects)
    {
        _projects = projects;
    }

    //##################################################
    //# convenience
    //##################################################

    public static KmFacebookWork createWith(KmJsonMap map)
    {
        KmFacebookWork e;
        e = new KmFacebookWork();
        // todo_aaron:  
        return e;
    }

    public static KmList<KmFacebookWork> createWorkListWith(KmJsonArray arr)
    {
        KmList<KmFacebookWork> v;
        v = new KmList<KmFacebookWork>();

        int n = arr.size();
        for ( int i = 0; i < n; i++ )
            v.add(KmFacebookWork.createWith(arr.getMapAt(i)));

        return v;
    }
}
