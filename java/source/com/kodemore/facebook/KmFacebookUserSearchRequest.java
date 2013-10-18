package com.kodemore.facebook;

import com.kodemore.collection.KmList;
import com.kodemore.facebook.model.KmFacebookUser;
import com.kodemore.json.KmJsonArray;
import com.kodemore.json.KmJsonMap;

/**
 * review_wyatt (aaron)
 * 
 * I am used to search for facebook users.  This action requires
 * an access token.  
 * 
 * Search documentation: http://goo.gl/CPc9Ii
 */
public class KmFacebookUserSearchRequest
{
    //##################################################
    //# variables 
    //##################################################

    private KmFacebookConnection _connection;

    private String               _accessToken;
    private String               _search;

    //##################################################
    //# constructor
    //##################################################

    public KmFacebookUserSearchRequest()
    {
        _connection = new KmFacebookConnection();
    }

    //##################################################
    //# accessing
    //##################################################

    public String getAccessToken()
    {
        return _accessToken;
    }

    public void setAccessToken(String s)
    {
        _accessToken = s;
    }

    public String getSearch()
    {
        return _search;
    }

    public void setSearch(String s)
    {
        _search = s;
    }

    //##################################################
    //# response
    //##################################################//

    public KmList<KmFacebookUser> getResponseUsers()
    {
        KmJsonMap response;
        response = _connection.getResponseJson();

        KmJsonArray users;
        users = response.getArray("data");

        KmList<KmFacebookUser> v;
        v = new KmList<KmFacebookUser>();

        int n = users.size();
        for ( int i = 0; i < n; i++ )
        {
            KmJsonMap map = users.getMapAt(i);
            v.add(KmFacebookUser.createWith(map));
        }

        return v;
    }

    //##################################################
    //# submit
    //##################################################//

    public void submit()
    {
        getConnection().setPath("search");
        getConnection().setParameter("q", getSearch());
        getConnection().setParameter("type", "user");
        getConnection().setParameter("access_token", getAccessToken());
        getConnection().submit();
    }

    private KmFacebookConnection getConnection()
    {
        return _connection;
    }

    //##################################################
    //# facebook user
    //##################################################

    // review_aaron: this sucks here
    //    private KmFacebookUser createFacebookUser(KmJsonMap e)
    //    {
    //        KmFacebookUser user;
    //        user = new KmFacebookUser();
    //        user.setId(e.getString(KmFacebookUser.ID_KEY));
    //        user.setUsername(e.getString(KmFacebookUser.USERNAME_KEY));
    //        user.setLink(e.getString(KmFacebookUser.LINK_KEY));
    //        user.setVerified(e.getBoolean(KmFacebookUser.VERIFIED_KEY));
    //        user.setUpdatedTime(e.getString(KmFacebookUser.UPDATED_TIME_KEY));
    //        user.setLocale(e.getString(KmFacebookUser.LOCALE_KEY));
    //        user.setTimezone(e.getInteger(KmFacebookUser.TIMEZONE_KEY));
    //        user.setDevices(parseDevices(e.getArray(KmFacebookUser.DEVICES_KEY)));
    //
    //        user.setName(e.getString(KmFacebookUser.NAME_KEY));
    //        user.setFirstName(e.getString(KmFacebookUser.FIRST_NAME_KEY));
    //        user.setMiddleName(e.getString(KmFacebookUser.MIDDLE_NAME_KEY));
    //        user.setLastName(e.getString(KmFacebookUser.LAST_NAME_KEY));
    //
    //        user.setGender(e.getString(KmFacebookUser.GENDER_KEY));
    //
    //        user.setBirthday(e.getString(KmFacebookUser.BIRTHDAY_KEY));
    //
    //        user.setEmail(e.getString(KmFacebookUser.EMAIL_KEY));
    //        user.setWebsite(e.getString(KmFacebookUser.WEBSITE_KEY));
    //        user.setLocation(e.getMap(KmFacebookUser.LOCATION_KEY));
    //        user.setHometown(e.getMap(KmFacebookUser.HOMETOWN_KEY));
    //        user.setPolitical(e.getString(KmFacebookUser.POLITICAL_KEY));
    //        user.setReligion(e.getString(KmFacebookUser.RELIGION_KEY));
    //        user.setLanguages(e.getArray(KmFacebookUser.LANGUAGES_KEY));
    //
    //        user.setRelationshipSatus(e.getString(KmFacebookUser.RELATIONSHIP_STATUS_KEY));
    //        user.setSignificantOther(e.getMap(KmFacebookUser.SIGNIFICANT_OTHER_KEY));
    //
    //        user.setBio(e.getString(KmFacebookUser.BIO_KEY));
    //        user.setQuotes(e.getString(KmFacebookUser.QUOTES_KEY));
    //
    //        user.setPicture(e.getMap(KmFacebookUser.PICTURE_KEY));
    //
    //        user.setEducation(e.getArray(KmFacebookUser.EDUCATION_KEY));
    //        user.setWork(e.getArray(KmFacebookUser.WORK_KEY));
    //
    //        return user;
    //    }
    //
    //    private KmList<KmFacebookDevice> parseDevices(KmJsonArray devices)
    //    {
    //        KmList<KmFacebookDevice> v;
    //        v = new KmList<KmFacebookDevice>();
    //
    //        int n = devices.size();
    //        for ( int i = 0; i < n; i++ )
    //        {
    //            KmJsonMap json;
    //            json = devices.getMapAt(i);
    //
    //            KmFacebookDevice e;
    //            e = new KmFacebookDevice();
    //            e.setOs(json.getString(KmFacebookDevice.OS_KEY));
    //            e.setHardware(json.getString(KmFacebookDevice.HARDWARE_KEY));
    //        }
    //
    //        return v;
    //    }
}
