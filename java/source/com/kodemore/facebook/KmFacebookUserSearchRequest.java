package com.kodemore.facebook;

import com.kodemore.collection.KmList;
import com.kodemore.json.KmJsonArray;
import com.kodemore.json.KmJsonMap;

/**
 * I am used to search for users.
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
        if ( _connection.hasException() )
            return null;

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
            v.add(createFacebookUser(map));
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

    private KmFacebookUser createFacebookUser(KmJsonMap e)
    {
        KmFacebookUser user;
        user = new KmFacebookUser();
        user.setId(e.getString("id"));
        user.setName(e.getString("name"));
        user.setFisrtName(e.getString("first_name"));
        user.setLastName(e.getString("last_name"));
        user.setLink(e.getString("link"));
        user.setUsername(e.getString("username"));
        user.setGender(e.getString("gender"));
        user.setLocale(e.getString("locale"));

        return user;
    }
}
