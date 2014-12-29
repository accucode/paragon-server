package com.kodemore.facebook.model;

import com.kodemore.collection.KmList;
import com.kodemore.json.KmJsonArray;
import com.kodemore.json.KmJsonMap;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmDateParser;

/**
 * I am a facebook work object.
 */
public class KmFacebookWork
    extends Object
{
    //##################################################
    //# constants
    //##################################################

    private static final String       EMPLOYER_KEY    = "employer";
    private static final String       LOCATION_KEY    = "location";
    private static final String       POSITION_KEY    = "position";
    private static final String       FROM_KEY        = "from";
    private static final String       WITH_KEY        = "with";
    private static final String       DESCRIPTION_KEY = "description";
    private static final String       START_DATE_KEY  = "start_date";
    private static final String       END_DATE_KEY    = "end_date";
    private static final String       PROJECTS_KEY    = "projects";

    //##################################################
    //# variables
    //##################################################

    private KmFacebookIdName          _employer;
    private KmFacebookIdName          _location;
    private KmFacebookIdName          _position;
    private KmFacebookIdName          _from;
    private KmList<KmFacebookIdName>  _with;
    private String                    _description;
    private KmDate                    _startDate;
    private KmDate                    _endDate;
    private KmList<KmFacebookProject> _projects;

    //##################################################
    //# accessing
    //##################################################

    public KmFacebookIdName getEmployer()
    {
        return _employer;
    }

    public void setEmployer(KmFacebookIdName employer)
    {
        _employer = employer;
    }

    public KmFacebookIdName getLocation()
    {
        return _location;
    }

    public void setLocation(KmFacebookIdName location)
    {
        _location = location;
    }

    public KmFacebookIdName getPosition()
    {
        return _position;
    }

    public void setPosition(KmFacebookIdName position)
    {
        _position = position;
    }

    public KmFacebookIdName getFrom()
    {
        return _from;
    }

    public void setFrom(KmFacebookIdName from)
    {
        _from = from;
    }

    public KmList<KmFacebookIdName> getWith()
    {
        return _with;
    }

    public void setWith(KmList<KmFacebookIdName> with)
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

    public KmList<KmFacebookProject> getProjects()
    {
        return _projects;
    }

    public void setProjects(KmList<KmFacebookProject> projects)
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
        e.setEmployer(createIdName(map.getMap(EMPLOYER_KEY)));
        e.setLocation(createIdName(map.getMap(LOCATION_KEY)));
        e.setPosition(createIdName(map.getMap(POSITION_KEY)));
        e.setFrom(createIdName(map.getMap(FROM_KEY)));
        e.setWith(createIdNames(map.getArray(WITH_KEY)));
        e.setDescription(map.getString(DESCRIPTION_KEY));
        e.setStartDate(parseDate(map.getString(START_DATE_KEY)));
        e.setEndDate(parseDate(map.getString(END_DATE_KEY)));
        e.setProjects(createProjects(map.getArray(PROJECTS_KEY)));
        return e;
    }

    private static KmFacebookIdName createIdName(KmJsonMap map)
    {
        return KmFacebookIdName.createWith(map);
    }

    private static KmList<KmFacebookIdName> createIdNames(KmJsonArray arr)
    {
        return KmFacebookIdName.createListWith(arr);
    }

    private static KmDate parseDate(String s)
    {
        return KmDateParser.parseDate(s);
    }

    private static KmList<KmFacebookProject> createProjects(KmJsonArray arr)
    {
        return KmFacebookProject.createListWith(arr);
    }

    public static KmList<KmFacebookWork> createListWith(KmJsonArray arr)
    {
        KmList<KmFacebookWork> v = new KmList<>();

        int n = arr.size();
        for ( int i = 0; i < n; i++ )
            v.add(KmFacebookWork.createWith(arr.getMapAt(i)));

        return v;
    }
}
