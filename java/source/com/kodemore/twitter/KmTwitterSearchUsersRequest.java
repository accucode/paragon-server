package com.kodemore.twitter;

import com.kodemore.collection.KmList;
import com.kodemore.json.KmJsonArray;
import com.kodemore.json.KmJsonMap;
import com.kodemore.utility.Kmu;

/**
 * I am used to search for users.
 * 
 * api documentation https://dev.twitter.com/docs/api/1.1/get/users/search
 */
public class KmTwitterSearchUsersRequest
{
    //##################################################
    //# variables 
    //##################################################

    private KmTwitterConnection _connection;

    //##################################################
    //# constructor
    //##################################################

    public KmTwitterSearchUsersRequest()
    {
        _connection = new KmTwitterConnection();
        _connection.setPath("/1.1/users/search.json");
    }

    //##################################################
    //# accessing
    //##################################################

    protected KmTwitterConnection getConnection()
    {
        return _connection;
    }

    //##################################################
    //# parameters
    //##################################################//

    protected void setQuery(String s)
    {
        getConnection().setParameter("q", s);
    }

    protected void setPage(int i)
    {
        getConnection().setParameter("page", Kmu.toStringSafe(i));
    }

    protected void setCount(int i)
    {
        getConnection().setParameter("count", Kmu.toStringSafe(i));
    }

    //##################################################
    //# oauth
    //##################################################//

    protected void setConsumerKey(String s)
    {
        getConnection().setConsumerKey(s);
    }

    protected void setConsumerSecret(String s)
    {
        getConnection().setConsumerSecret(s);
    }

    protected void setAuthToken(String s)
    {
        getConnection().setAuthToken(s);
    }

    protected void setAuthSecret(String s)
    {
        getConnection().setAuthSecret(s);
    }

    //##################################################
    //# response
    //##################################################//

    protected KmJsonArray getResponseJson()
    {
        return getConnection().getResponseJsonArray();
    }

    protected KmList<KmTwitterUser> getResponseUsers()
    {
        KmJsonArray resp = getResponseJson();

        KmList<KmTwitterUser> v = new KmList<KmTwitterUser>();

        int n = resp.size();
        for ( int i = 0; i < n; i++ )
        {
            KmJsonMap jsonObject = resp.getMapAt(i);
            v.add(new KmTwitterUser(jsonObject));
        }
        return v;
    }

    //##################################################
    //# submit
    //##################################################//

    protected void submit()
    {
        getConnection().submit();
    }
}
