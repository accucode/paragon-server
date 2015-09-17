package com.kodemore.facebook.model;

import com.kodemore.collection.KmList;
import com.kodemore.json.KmJsonArray;
import com.kodemore.json.KmJsonMap;
import com.kodemore.time.KmTimestamp;
import com.kodemore.time.KmTimestampParser;

/**
 * todo_aaron description
 */
public class KmFacebookActivity
    extends Object
{
    //##################################################
    //# constants
    //##################################################

    private static final String ID_KEY               = "id";
    private static final String NAME_KEY             = "name";
    private static final String CATEGORY_KEY         = "category";
    private static final String CREATE_TIMESTAMP_KEY = "create_time";

    //##################################################
    //# variables 
    //##################################################

    private String      _id;
    private String      _name;
    private String      _category;
    private KmTimestamp _createTime;

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

    public String getCategory()
    {
        return _category;
    }

    public void setCategory(String category)
    {
        _category = category;
    }

    public KmTimestamp getCreateTime()
    {
        return _createTime;
    }

    public void setCreateTime(KmTimestamp createTime)
    {
        _createTime = createTime;
    }

    //##################################################
    //# convenience
    //##################################################

    public static KmFacebookActivity createWith(KmJsonMap map)
    {
        KmFacebookActivity e;
        e = new KmFacebookActivity();
        e.setId(map.getString(ID_KEY));
        e.setName(map.getString(NAME_KEY));
        e.setCategory(map.getString(CATEGORY_KEY));
        e.setCreateTime(parseTime(map.getString(CREATE_TIMESTAMP_KEY)));
        return e;
    }

    private static KmTimestamp parseTime(String s)
    {
        // todo_aaron: parse time

        return new KmTimestampParser().parse(s);
    }

    public static KmList<KmFacebookActivity> createListWith(KmJsonArray arr)
    {
        KmList<KmFacebookActivity> v;
        v = new KmList<>();

        int n = arr.size();
        for ( int i = 0; i < n; i++ )
            v.add(KmFacebookActivity.createWith(arr.getMapAt(i)));

        return v;
    }
}
