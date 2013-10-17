package com.kodemore.facebook;

import com.kodemore.collection.KmList;
import com.kodemore.json.KmJsonArray;
import com.kodemore.json.KmJsonMap;
import com.kodemore.time.KmDate;

/**
 * I am and object with values for all the returned paramaters of a twitter user.
 */
public class KmFacebookUser
    extends Object
{
    //##################################################
    //# constants
    //##################################################

    //==================================================
    //= constants :: user info
    //==================================================

    public static final String ID_KEY                  = "id";
    public static final String USERNAME_KEY            = "username";
    public static final String LINK_KEY                = "link";
    public static final String VERIFIED_KEY            = "verified";
    public static final String UPDATED_TIME_KEY        = "updated_time";
    public static final String LOCALE_KEY              = "locale";
    public static final String TIMEZONE_KEY            = "timezone";
    public static final String DEVICES_KEY             = "devices";

    //==================================================
    //= constants :: personal info
    //==================================================

    public static final String NAME_KEY                = "name";
    public static final String FIRST_NAME_KEY          = "first_name";
    public static final String MIDDLE_NAME_KEY         = "last_name";
    public static final String LAST_NAME_KEY           = "middle_name";

    public static final String GENDER_KEY              = "gender";
    public static final String BIRTHDAY_KEY            = "birthday";
    public static final String EMAIL_KEY               = "email";
    public static final String WEBSITE_KEY             = "website";
    public static final String LOCATION_KEY            = "location";
    public static final String HOMETOWN_KEY            = "hometown";
    public static final String POLITICAL_KEY           = "political";
    public static final String RELIGION_KEY            = "religion";
    public static final String LANGUAGES_KEY           = "languages";

    public static final String RELATIONSHIP_STATUS_KEY = "relationship_status";
    public static final String SIGNIFICANT_OTHER_KEY   = "significant_other";

    public static final String BIO_KEY                 = "bio";
    public static final String QUOTES_KEY              = "quotes";

    public static final String PICTURE_KEY             = "picture";

    public static final String EDUCATION_KEY           = "education";
    public static final String WORK_KEY                = "work";

    //==================================================
    //= constants :: Interests
    //==================================================

    public static final String INTERESTED_IN_KEY       = "interested_in";
    public static final String FAVORITE_ATHLETES_KEY   = "favorite_athletes";
    public static final String FAVORITE_TEAMS_KEY      = "favorite_teams";

    //==================================================
    //= constants ::  Connections
    //==================================================

    // todo_aaron:  

    //##################################################
    //# variables 
    //##################################################

    //==================================================
    //= variables :: user info
    //==================================================

    private String             _id;
    private String             _username;
    private String             _link;
    private Boolean            _verified;
    private String             _updatedTime;
    private String             _locale;
    private String             _timezone;
    private KmJsonArray        _devices;

    //==================================================
    //= variables :: personal info
    //==================================================

    private String             _name;
    private String             _fisrtName;
    private String             _middleName;
    private String             _lastName;

    private String             _gender;
    private KmDate             _birthday;
    private String             _email;
    private String             _website;
    private KmJsonMap          _location;
    private KmJsonMap          _hometown;
    private String             _political;
    private String             _religion;
    private KmJsonArray        _languages;

    private String             _relationshipSatus;
    private KmJsonMap          _significantOther;

    private String             _bio;
    private String             _quotes;

    private KmJsonMap          _picture;

    private KmJsonArray        _education;
    private KmJsonArray        _work;

    //==================================================
    //= variables :: interests
    //==================================================

    private KmList<String>     _interestedIn;
    private KmJsonArray        _favoriteAthletes;
    private KmJsonArray        _favoriteTeams;

    //==================================================
    //= variables :: connections
    //==================================================

    // todo_aaron: add connections 

    //##################################################
    //# accessing
    //##################################################

    //==================================================
    //= accesssing :: user info
    //==================================================

    public String getId()
    {
        return _id;
    }

    public void setId(String e)
    {
        _id = e;
    }

    public String getUsername()
    {
        return _username;
    }

    public void setUsername(String e)
    {
        _username = e;
    }

    public String getLink()
    {
        return _link;
    }

    public void setLink(String e)
    {
        _link = e;
    }

    public Boolean getVerified()
    {
        return _verified;
    }

    public void setVerified(Boolean e)
    {
        _verified = e;
    }

    public String getUpdatedTime()
    {
        return _updatedTime;
    }

    public void setUpdatedTime(String e)
    {
        _updatedTime = e;
    }

    public String getLocale()
    {
        return _locale;
    }

    public void setLocale(String e)
    {
        _locale = e;
    }

    public String getTimezone()
    {
        return _timezone;
    }

    public void setTimezone(String e)
    {
        _timezone = e;
    }

    public KmJsonArray getDevices()
    {
        return _devices;
    }

    public void setDevices(KmJsonArray e)
    {
        _devices = e;
    }

    //==================================================
    //= accesssing :: personal info 
    //==================================================

    public String getName()
    {
        return _name;
    }

    public void setName(String e)
    {
        _name = e;
    }

    public String getFisrtName()
    {
        return _fisrtName;
    }

    public void setFisrtName(String e)
    {
        _fisrtName = e;
    }

    public String getMiddleName()
    {
        return _middleName;
    }

    public void setMiddleName(String e)
    {
        _middleName = e;
    }

    public String getLastName()
    {
        return _lastName;
    }

    public void setLastName(String e)
    {
        _lastName = e;
    }

    public String getGender()
    {
        return _gender;
    }

    public void setGender(String e)
    {
        _gender = e;
    }

    public KmDate getBirthday()
    {
        return _birthday;
    }

    public void setBirthday(KmDate e)
    {
        _birthday = e;
    }

    public String getEmail()
    {
        return _email;
    }

    public void setEmail(String e)
    {
        _email = e;
    }

    public String getWebsite()
    {
        return _website;
    }

    public void setWebsite(String e)
    {
        _website = e;
    }

    public KmJsonMap getLocation()
    {
        return _location;
    }

    public void setLocation(KmJsonMap e)
    {
        _location = e;
    }

    public KmJsonMap getHometown()
    {
        return _hometown;
    }

    public void setHometown(KmJsonMap e)
    {
        _hometown = e;
    }

    public String getPolitical()
    {
        return _political;
    }

    public void setPolitical(String e)
    {
        _political = e;
    }

    public String getReligion()
    {
        return _religion;
    }

    public void setReligion(String e)
    {
        _religion = e;
    }

    public KmJsonArray getLanguages()
    {
        return _languages;
    }

    public void setLanguages(KmJsonArray e)
    {
        _languages = e;
    }

    public String getRelationshipSatus()
    {
        return _relationshipSatus;
    }

    public void setRelationshipSatus(String e)
    {
        _relationshipSatus = e;
    }

    public KmJsonMap getSignificantOther()
    {
        return _significantOther;
    }

    public void setSignificantOther(KmJsonMap e)
    {
        _significantOther = e;
    }

    public String getBio()
    {
        return _bio;
    }

    public void setBio(String e)
    {
        _bio = e;
    }

    public String getQuotes()
    {
        return _quotes;
    }

    public void setQuotes(String e)
    {
        _quotes = e;
    }

    public KmJsonMap getPicture()
    {
        return _picture;
    }

    public void setPicture(KmJsonMap e)
    {
        _picture = e;
    }

    public KmJsonArray getEducation()
    {
        return _education;
    }

    public void setEducation(KmJsonArray e)
    {
        _education = e;
    }

    public KmJsonArray getWork()
    {
        return _work;
    }

    public void setWork(KmJsonArray e)
    {
        _work = e;
    }

    //==================================================
    //= accesssing :: Interests 
    //==================================================

    public KmList<String> getInterestedIn()
    {
        return _interestedIn;
    }

    public void setInterestedIn(KmList<String> e)
    {
        _interestedIn = e;
    }

    public KmJsonArray getFavoriteAthletes()
    {
        return _favoriteAthletes;
    }

    public void setFavoriteAthletes(KmJsonArray e)
    {
        _favoriteAthletes = e;
    }

    public KmJsonArray getFavoriteTeams()
    {
        return _favoriteTeams;
    }

    public void setFavoriteTeams(KmJsonArray e)
    {
        _favoriteTeams = e;
    }
}
