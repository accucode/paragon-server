package com.kodemore.twitter;

/**
 * I am and object representing a user that has been mentioned in a tweet.
 * 
 * https://dev.twitter.com/docs/platform-objects/places
 */
public class KmTwitterPlace
    extends Object
{

    //##################################################
    //# variables 
    //##################################################
    /**
     * this is only a string for now because we didn't create an attributes object yet
     */
    private String               _attributes;
    private KmTwitterBoundingBox _boundingBox;
    private String               _country;
    private String               _countryCode;
    private String               _fullName;
    private String               _id;
    private String               _name;
    private String               _placeType;
    private String               _url;

    //##################################################
    //# access
    //##################################################//

    public String getAttributes()
    {
        return _attributes;
    }

    public void setAttributes(String e)
    {
        _attributes = e;
    }

    public KmTwitterBoundingBox getBoundingbox()
    {
        return _boundingBox;
    }

    public void setBoundingbox(KmTwitterBoundingBox e)
    {
        _boundingBox = e;
    }

    public String getCountry()
    {
        return _country;
    }

    public void setCountry(String e)
    {
        _country = e;
    }

    public String getCountryCode()
    {
        return _countryCode;
    }

    public void setCountryCode(String e)
    {
        _countryCode = e;
    }

    public String getFullName()
    {
        return _fullName;
    }

    public void setFullName(String e)
    {
        _fullName = e;
    }

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

    public String getPlaceType()
    {
        return _placeType;
    }

    public void setPlaceType(String e)
    {
        _placeType = e;
    }

    public String getUrl()
    {
        return _url;
    }

    public void setUrl(String e)
    {
        _url = e;
    }
}
