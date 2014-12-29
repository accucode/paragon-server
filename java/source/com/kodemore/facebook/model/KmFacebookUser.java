package com.kodemore.facebook.model;

import com.kodemore.collection.KmList;
import com.kodemore.json.KmJsonArray;
import com.kodemore.json.KmJsonMap;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmDateParser;
import com.kodemore.time.KmTimestamp;
import com.kodemore.time.KmTimestampParser;

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

    private static final String         ID_KEY                  = "id";
    private static final String         USERNAME_KEY            = "username";
    private static final String         LINK_KEY                = "link";
    private static final String         VERIFIED_KEY            = "verified";
    private static final String         UPDATED_TIME_KEY        = "updated_time";
    private static final String         LOCALE_KEY              = "locale";
    private static final String         TIMEZONE_KEY            = "timezone";
    private static final String         DEVICES_KEY             = "devices";

    //==================================================
    //= constants :: personal info
    //==================================================

    private static final String         NAME_KEY                = "name";
    private static final String         FIRST_NAME_KEY          = "first_name";
    private static final String         MIDDLE_NAME_KEY         = "middle_name";
    private static final String         LAST_NAME_KEY           = "last_name";

    private static final String         GENDER_KEY              = "gender";
    private static final String         BIRTHDAY_KEY            = "birthday";
    private static final String         EMAIL_KEY               = "email";
    private static final String         WEBSITE_KEY             = "website";
    private static final String         LOCATION_KEY            = "location";
    private static final String         HOMETOWN_KEY            = "hometown";
    private static final String         POLITICAL_KEY           = "political";
    private static final String         RELIGION_KEY            = "religion";
    private static final String         LANGUAGES_KEY           = "languages";

    private static final String         RELATIONSHIP_STATUS_KEY = "relationship_status";
    private static final String         SIGNIFICANT_OTHER_KEY   = "significant_other";

    private static final String         BIO_KEY                 = "bio";
    private static final String         QUOTES_KEY              = "quotes";

    private static final String         PICTURE_KEY             = "picture";

    private static final String         EDUCATION_KEY           = "education";
    private static final String         WORK_KEY                = "work";

    //==================================================
    //= constants :: Interests
    //==================================================

    private static final String         INTERESTED_IN_KEY       = "interested_in";
    private static final String         FAVORITE_ATHLETES_KEY   = "favorite_athletes";
    private static final String         FAVORITE_TEAMS_KEY      = "favorite_teams";

    //==================================================
    //= constants ::  Connections
    //==================================================

    // todo_aaron: add connections

    //##################################################
    //# variables 
    //##################################################

    //==================================================
    //= variables :: user info
    //==================================================

    private String                      _id;
    private String                      _username;
    private String                      _link;
    private Boolean                     _verified;
    private KmTimestamp                 _updatedTimestamp;
    private String                      _locale;
    private Integer                     _timezone;
    private KmList<KmFacebookDevice>    _devices;

    //==================================================
    //= variables :: personal info
    //==================================================

    private String                      _name;
    private String                      _firstName;
    private String                      _middleName;
    private String                      _lastName;

    private String                      _gender;
    private KmDate                      _birthday;
    private String                      _email;
    private String                      _website;
    private KmFacebookIdName            _location;
    private KmFacebookIdName            _hometown;
    private String                      _political;
    private String                      _religion;
    private KmList<KmFacebookIdName>    _languages;

    private String                      _relationshipSatus;
    private KmFacebookIdName            _significantOther;

    private String                      _bio;
    private String                      _quotes;

    private KmFacebookPicture           _picture;

    private KmList<KmFacebookEducation> _education;
    private KmList<KmFacebookWork>      _work;

    //==================================================
    //= variables :: interests
    //==================================================

    private KmList<String>              _interestedIn;
    private KmList<KmFacebookIdName>    _favoriteAthletes;
    private KmList<KmFacebookIdName>    _favoriteTeams;

    //==================================================
    //= variables :: connections
    //==================================================

    // todo_aaron: add connections 

    //##################################################
    //# constructor
    //##################################################

    public KmFacebookUser()
    {
        _devices = new KmList<>();
        _languages = new KmList<>();
        _interestedIn = new KmList<>();
    }

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

    public KmTimestamp getUpdatedTimestamp()
    {
        return _updatedTimestamp;
    }

    public void setUpdatedTimestamp(KmTimestamp e)
    {
        _updatedTimestamp = e;
    }

    public String getLocale()
    {
        return _locale;
    }

    public void setLocale(String e)
    {
        _locale = e;
    }

    public Integer getTimezone()
    {
        return _timezone;
    }

    public void setTimezone(Integer e)
    {
        _timezone = e;
    }

    public KmList<KmFacebookDevice> getDevices()
    {
        return _devices;
    }

    public void setDevices(KmList<KmFacebookDevice> e)
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

    public String getFirstName()
    {
        return _firstName;
    }

    public void setFirstName(String e)
    {
        _firstName = e;
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

    public KmFacebookIdName getLocation()
    {
        return _location;
    }

    public void setLocation(KmFacebookIdName e)
    {
        _location = e;
    }

    public KmFacebookIdName getHometown()
    {
        return _hometown;
    }

    public void setHometown(KmFacebookIdName e)
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

    public KmList<KmFacebookIdName> getLanguages()
    {
        return _languages;
    }

    public void setLanguages(KmList<KmFacebookIdName> e)
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

    public KmFacebookIdName getSignificantOther()
    {
        return _significantOther;
    }

    public void setSignificantOther(KmFacebookIdName e)
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

    public KmFacebookPicture getPicture()
    {
        return _picture;
    }

    public void setPicture(KmFacebookPicture e)
    {
        _picture = e;
    }

    public KmList<KmFacebookEducation> getEducation()
    {
        return _education;
    }

    public void setEducation(KmList<KmFacebookEducation> e)
    {
        _education = e;
    }

    public KmList<KmFacebookWork> getWork()
    {
        return _work;
    }

    public void setWork(KmList<KmFacebookWork> e)
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

    public KmList<KmFacebookIdName> getFavoriteAthletes()
    {
        return _favoriteAthletes;
    }

    public void setFavoriteAthletes(KmList<KmFacebookIdName> e)
    {
        _favoriteAthletes = e;
    }

    public KmList<KmFacebookIdName> getFavoriteTeams()
    {
        return _favoriteTeams;
    }

    public void setFavoriteTeams(KmList<KmFacebookIdName> e)
    {
        _favoriteTeams = e;
    }

    //##################################################
    //# convenience
    //##################################################

    public static KmFacebookUser createWith(KmJsonMap e)
    {
        KmFacebookUser u;
        u = new KmFacebookUser();
        u.setId(e.getString(ID_KEY));
        u.setUsername(e.getString(USERNAME_KEY));
        u.setLink(e.getString(LINK_KEY));
        u.setVerified(e.getBoolean(VERIFIED_KEY));
        u.setUpdatedTimestamp(parseTime(e.getString(UPDATED_TIME_KEY)));
        u.setLocale(e.getString(LOCALE_KEY));
        u.setTimezone(e.getInteger(TIMEZONE_KEY));
        u.setDevices(createDevices(e.getArray(DEVICES_KEY)));

        u.setName(e.getString(NAME_KEY));
        u.setFirstName(e.getString(FIRST_NAME_KEY));
        u.setMiddleName(e.getString(MIDDLE_NAME_KEY));
        u.setLastName(e.getString(LAST_NAME_KEY));

        u.setGender(e.getString(GENDER_KEY));
        u.setBirthday(KmDateParser.parseDate(e.getString(BIRTHDAY_KEY)));
        u.setEmail(e.getString(EMAIL_KEY));
        u.setWebsite(e.getString(WEBSITE_KEY));
        u.setLocation(createIdName(e.getMap(LOCATION_KEY)));
        u.setHometown(createIdName(e.getMap(HOMETOWN_KEY)));
        u.setPolitical(e.getString(POLITICAL_KEY));
        u.setReligion(e.getString(RELIGION_KEY));
        u.setLanguages(createIdNames(e.getArray(LANGUAGES_KEY)));

        u.setRelationshipSatus(e.getString(RELATIONSHIP_STATUS_KEY));
        u.setSignificantOther(createIdName(e.getMap(SIGNIFICANT_OTHER_KEY)));

        u.setBio(e.getString(BIO_KEY));
        u.setQuotes(e.getString(QUOTES_KEY));

        u.setPicture(KmFacebookPicture.createWith(e.getMap(PICTURE_KEY)));

        u.setEducation(createEducations(e.getArray(EDUCATION_KEY)));
        u.setWork(createWorks(e.getArray(WORK_KEY)));

        u.setInterestedIn(createInterestedInList(e.getArray(INTERESTED_IN_KEY)));
        u.setFavoriteAthletes(createIdNames(e.getArray(FAVORITE_ATHLETES_KEY)));
        u.setFavoriteTeams(createIdNames(e.getArray(FAVORITE_TEAMS_KEY)));

        return u;
    }

    private static KmFacebookIdName createIdName(KmJsonMap map)
    {
        return KmFacebookIdName.createWith(map);
    }

    private static KmList<KmFacebookIdName> createIdNames(KmJsonArray arr)
    {
        return KmFacebookIdName.createListWith(arr);
    }

    private static KmList<KmFacebookDevice> createDevices(KmJsonArray arr)
    {
        return KmFacebookDevice.createListWith(arr);
    }

    private static KmList<KmFacebookEducation> createEducations(KmJsonArray arr)
    {
        return KmFacebookEducation.createListWith(arr);
    }

    private static KmList<KmFacebookWork> createWorks(KmJsonArray arr)
    {
        return KmFacebookWork.createListWith(arr);
    }

    private static KmTimestamp parseTime(String s)
    {
        // todo_aaron: parse time

        return new KmTimestampParser().parse(s);
    }

    private static KmList<String> createInterestedInList(KmJsonArray arr)
    {
        KmList<String> v;
        v = new KmList<>();

        int n = arr.size();
        for ( int i = 0; i < n; i++ )
            v.add(arr.getStringAt(i));

        return v;
    }
}
