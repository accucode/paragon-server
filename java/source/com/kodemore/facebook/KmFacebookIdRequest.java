package com.kodemore.facebook;

import com.kodemore.facebook.model.KmFacebookUser;
import com.kodemore.json.KmJsonMap;

/**
 * I am used to request objects from facebook by id.  This does not
 * require an access token.  If an access token is not present, the
 * call to the graph api will return only public information.  If an
 * access token is present, the api will return all informations 
 * allowed by the permissions granted by the user.
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
        KmJsonMap response;
        response = _connection.getResponseJson();

        // remove_aaron: print
        System.out.println("    response.formatJson(): " + response.formatJson());

        if ( response.hasKey("error") )
            return null;

        return KmFacebookUser.createWith(response);
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
}
