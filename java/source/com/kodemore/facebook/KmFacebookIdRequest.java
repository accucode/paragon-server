package com.kodemore.facebook;

import com.kodemore.facebook.model.KmFacebookUser;
import com.kodemore.json.KmJsonMap;
import com.kodemore.utility.Kmu;

/**
 * I am used to request objects from facebook by id. Users can also
 * be found via their username as well as their id.  This does not 
 * require an access token.
 * 
 * If an access token is not included, the call to the graph api will 
 * return only public information.  
 * 
 * If an access token is included, the api will return all information 
 * allowed by the permissions granted to the app by the user.
 */
public class KmFacebookIdRequest
{
    //##################################################
    //# variables 
    //##################################################

    private String _accessToken;

    /**
     * This is the specific object's username or id. 
     */
    private String _query;

    //##################################################
    //# constructor
    //##################################################

    public KmFacebookIdRequest()
    {
        // none
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

    public String getQuery()
    {
        return _query;
    }

    public void setQuery(String e)
    {
        _query = e;
    }

    //##################################################
    //# find
    //##################################################

    public KmFacebookUser findUser()
    {
        KmJsonMap resp = submit();
        checkError(resp);

        return KmFacebookUser.createWith(resp);
    }

    //##################################################
    //# submit
    //##################################################

    private KmJsonMap submit()
    {
        KmFacebookConnection con;
        con = new KmFacebookConnection();
        con.setPath(getQuery());

        if ( hasAccessToken() )
            con.setParameter("access_token", getAccessToken());

        con.submit();
        return con.getResponseJsonMap();
    }

    private void checkError(KmJsonMap resp)
    {
        String errorKey = "error";

        if ( !resp.hasKey(errorKey) )
            return;

        KmJsonMap map = resp.getMap(errorKey);
        error(map.getString("message"));
    }

    //##################################################
    //# utility
    //##################################################

    private void error(String msg, Object... args)
    {
        Kmu.error(msg, args);
    }
}
