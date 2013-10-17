package com.kodemore.facebook;

import com.kodemore.json.KmJsonMap;

/**
 * I am used to request objects from facebook by id.
 */
public class KmFacebookIdRequest
{
    //##################################################
    //# variables 
    //##################################################

    private KmFacebookConnection _connection;

    private String               _accessToken;

    //##################################################
    //# constructor
    //##################################################

    public KmFacebookIdRequest()
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

    public boolean hasAccessToken()
    {
        return getAccessToken() != null;
    }

    //##################################################
    //# response
    //##################################################//

    public KmFacebookUser getResponseUser()
    {
        if ( _connection.hasException() )
            return null;

        KmJsonMap response;
        response = _connection.getResponseJson();

        if ( response.hasKey("error") )
            return null;

        return createFacebookUser(response);
    }

    //##################################################
    //# query
    //##################################################

    /**
     * This is the specific object's username or id. 
     */
    public void setQuery(String s)
    {
        _connection.setPath(s);
    }

    //##################################################
    //# submit
    //##################################################//

    public void submit()
    {
        if ( hasAccessToken() )
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
