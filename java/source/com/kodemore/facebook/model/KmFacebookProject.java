package com.kodemore.facebook.model;

import com.kodemore.collection.KmList;
import com.kodemore.json.KmJsonArray;
import com.kodemore.json.KmJsonMap;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmDateParser;

/**
 * todo_aaron description
 */
public class KmFacebookProject
    extends Object
{
    //##################################################
    //# constants
    //##################################################

    private static final String      ID_KEY          = "id";
    private static final String      NAME_KEY        = "name";
    private static final String      WITH_KEY        = "with";
    private static final String      DESCRIPTION_KEY = "description";
    private static final String      START_DATE_KEY  = "start_date";
    private static final String      END_DATE_KEY    = "end_date";
    private static final String      FROM_KEY        = "from";

    //##################################################
    //# variables
    //##################################################

    private String                   _id;
    private String                   _name;
    private KmList<KmFacebookIdName> _with;
    private String                   _description;
    private KmDate                   _startDate;
    private KmDate                   _endDate;
    private KmFacebookIdName         _from;

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

    public KmList<KmFacebookIdName> getWith()
    {
        return _with;
    }

    public void setWith(KmList<KmFacebookIdName> e)
    {
        _with = e;
    }

    public String getDescription()
    {
        return _description;
    }

    public void setDescription(String e)
    {
        _description = e;
    }

    public KmDate getStartDate()
    {
        return _startDate;
    }

    public void setStartDate(KmDate e)
    {
        _startDate = e;
    }

    public KmDate getEndDate()
    {
        return _endDate;
    }

    public void setEndDate(KmDate e)
    {
        _endDate = e;
    }

    public KmFacebookIdName getFrom()
    {
        return _from;
    }

    public void setFrom(KmFacebookIdName e)
    {
        _from = e;
    }

    //##################################################
    //# convenience
    //##################################################

    public static KmFacebookProject createWith(KmJsonMap map)
    {
        KmFacebookProject e;
        e = new KmFacebookProject();
        e.setId(map.getString(ID_KEY));
        e.setName(map.getString(NAME_KEY));
        e.setWith(createIdNames(map.getArray(WITH_KEY)));
        e.setDescription(map.getString(DESCRIPTION_KEY));
        e.setStartDate(parseDate(map.getString(START_DATE_KEY)));
        e.setEndDate(parseDate(map.getString(END_DATE_KEY)));
        e.setFrom(createIdName(map.getMap(FROM_KEY)));
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

    private static KmDate parseDate(String e)
    {
        return KmDateParser.parseDate(e);
    }

    public static KmList<KmFacebookProject> createListWith(KmJsonArray arr)
    {
        KmList<KmFacebookProject> v;
        v = new KmList<>();

        int n = arr.size();
        for ( int i = 0; i < n; i++ )
            v.add(KmFacebookProject.createWith(arr.getMapAt(i)));

        return v;
    }
}
