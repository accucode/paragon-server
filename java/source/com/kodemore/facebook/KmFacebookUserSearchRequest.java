package com.kodemore.facebook;

import com.kodemore.collection.KmList;
import com.kodemore.facebook.model.KmFacebookUser;
import com.kodemore.json.KmJsonMap;

/**
 * I am used to search for facebook users.
 * This action requires an access token.
 *
 * Search documentation: http://goo.gl/CPc9Ii
 */
public class KmFacebookUserSearchRequest
{
    //##################################################
    //# variables
    //##################################################

    private String _accessToken;
    private String _search;

    //##################################################
    //# constructor
    //##################################################

    public KmFacebookUserSearchRequest()
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
    //##################################################

    public KmList<KmFacebookUser> findUsers()
    {
        KmJsonMap response = submit();
        KmList<KmJsonMap> maps = response.getArray("data").getAllAsMaps();

        return toUsers(maps);
    }

    //##################################################
    //# submit
    //##################################################

    private KmJsonMap submit()
    {
        KmFacebookConnection con;
        con = new KmFacebookConnection();
        con.setPath("search");
        con.setParameter("q", getSearch());
        con.setParameter("type", "user");
        con.setParameter("access_token", getAccessToken());
        con.submit();

        return con.getResponseJsonMap();
    }

    private KmList<KmFacebookUser> toUsers(KmList<KmJsonMap> maps)
    {
        KmList<KmFacebookUser> v = new KmList<>();

        for ( KmJsonMap map : maps )
            v.add(parseUser(map));

        return v;
    }

    private KmFacebookUser parseUser(KmJsonMap map)
    {
        return KmFacebookUser.createWith(map);
    }

}
