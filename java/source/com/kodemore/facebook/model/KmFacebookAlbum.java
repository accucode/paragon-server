package com.kodemore.facebook.model;

import com.kodemore.collection.KmList;
import com.kodemore.json.KmJsonArray;
import com.kodemore.json.KmJsonMap;
import com.kodemore.time.KmTimestamp;
import com.kodemore.time.KmTimestampParser;

public class KmFacebookAlbum
extends Object
{
    //##################################################
    //# constants
    //##################################################

    private static final String ID_KEY           = "id";
    private static final String NAME_KEY         = "name";
    private static final String FROM_KEY         = "from";
    private static final String DESCRIPTION_KEY  = "description";
    private static final String LOCATION_KEY     = "location";
    private static final String LINK_KEY         = "link";
    private static final String COVER_PHOTO_KEY  = "cover_photo";
    private static final String PRIVACY_KEY      = "privacy";
    private static final String COUNT_KEY        = "count";
    private static final String TYPE_KEY         = "type";
    private static final String CREATED_TIME_KEY = "created_time";
    private static final String UPDATED_TIME_KEY = "updated_time";
    private static final String CAN_UPLOAD_KEY   = "can_upload";

    //##################################################
    //# variables
    //##################################################

    private String              _id;
    private String              _name;
    private KmFacebookIdName    _from;
    private String              _description;
    private String              _location;
    private String              _link;
    private String              _coverPhoto;
    private String              _privacy;
    private Integer             _count;
    private String              _type;
    private KmTimestamp         _createdTimestamp;
    private KmTimestamp         _updatedTimestamp;
    private Boolean             _canUpload;

    //==================================================
    //= variables :: connections
    //==================================================

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

    public KmFacebookIdName getFrom()
    {
        return _from;
    }

    public void setFrom(KmFacebookIdName e)
    {
        _from = e;
    }

    public String getDescription()
    {
        return _description;
    }

    public void setDescription(String e)
    {
        _description = e;
    }

    public String getLink()
    {
        return _link;
    }

    public void setLink(String e)
    {
        _link = e;
    }

    public String getLocation()
    {
        return _location;
    }

    public void setLocation(String e)
    {
        _location = e;
    }

    public String getCoverPhoto()
    {
        return _coverPhoto;
    }

    public void setCoverPhoto(String e)
    {
        _coverPhoto = e;
    }

    public String getPrivacy()
    {
        return _privacy;
    }

    public void setPrivacy(String e)
    {
        _privacy = e;
    }

    public Integer getCount()
    {
        return _count;
    }

    public void setCount(Integer e)
    {
        _count = e;
    }

    public String getType()
    {
        return _type;
    }

    public void setType(String e)
    {
        _type = e;
    }

    public KmTimestamp getCreatedTimestamp()
    {
        return _createdTimestamp;
    }

    public void setCreatedTimestamp(KmTimestamp e)
    {
        _createdTimestamp = e;
    }

    public KmTimestamp getUpdatedTimestamp()
    {
        return _updatedTimestamp;
    }

    public void setUpdatedTimestamp(KmTimestamp e)
    {
        _updatedTimestamp = e;
    }

    public Boolean getCanUpload()
    {
        return _canUpload;
    }

    public void setCanUpload(Boolean e)
    {
        _canUpload = e;
    }

    //##################################################
    //# convenience
    //##################################################

    public static KmFacebookAlbum createWith(KmJsonMap map)
    {
        KmFacebookAlbum e;
        e = new KmFacebookAlbum();
        e.setId(map.getString(ID_KEY));
        e.setName(map.getString(NAME_KEY));
        e.setFrom(createIdName(map.getMap(FROM_KEY)));
        e.setDescription(map.getString(DESCRIPTION_KEY));
        e.setLocation(map.getString(LOCATION_KEY));
        e.setLink(map.getString(LINK_KEY));
        e.setCoverPhoto(map.getString(COVER_PHOTO_KEY));
        e.setPrivacy(map.getString(PRIVACY_KEY));
        e.setCount(map.getInteger(COUNT_KEY));
        e.setType(map.getString(TYPE_KEY));
        e.setCreatedTimestamp(parseTime(map.getString(CREATED_TIME_KEY)));
        e.setUpdatedTimestamp(parseTime(map.getString(UPDATED_TIME_KEY)));
        e.setCanUpload(map.getBoolean(CAN_UPLOAD_KEY));
        return e;
    }

    private static KmFacebookIdName createIdName(KmJsonMap map)
    {
        return KmFacebookIdName.createWith(map);
    }

    private static KmTimestamp parseTime(String s)
    {
        return new KmTimestampParser().parse(s);
    }

    public static KmList<KmFacebookAlbum> createListWith(KmJsonArray arr)
    {
        KmList<KmFacebookAlbum> v;
        v = new KmList<>();

        int n = arr.size();
        for ( int i = 0; i < n; i++ )
            v.add(KmFacebookAlbum.createWith(arr.getMapAt(i)));

        return v;
    }
}
