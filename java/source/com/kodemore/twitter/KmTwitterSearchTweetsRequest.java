package com.kodemore.twitter;

import com.kodemore.json.KmJsonMap;

/**
 * I am used search for tweets.
 * 
 * Api documentation
 *      https://dev.twitter.com/docs/api/1.1/get/search/tweets
 */
public class KmTwitterSearchTweetsRequest
{
    //##################################################
    //# variables 
    //##################################################

    private KmTwitterConnection _connection;

    //##################################################
    //# constructor
    //##################################################

    public KmTwitterSearchTweetsRequest()
    {
        _connection = new KmTwitterConnection();
        _connection.setParameter("lang", "en");
        _connection.setPath("/1.1/search/tweets.json");
    }

    //##################################################
    //# accessing
    //##################################################

    protected KmTwitterConnection getConnection()
    {
        return _connection;
    }

    protected void setQuery(String s)
    {
        getConnection().setParameter("q", s);
    }

    protected void setLanguage(String s)
    {
        getConnection().setParameter("lang", s);
    }

    protected void setResultType(KmTwitterResultType s)
    {
        getConnection().setParameter("result_type", s.getType());
    }

    //##################################################
    //# oauth
    //##################################################

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
    //##################################################

    protected KmJsonMap getResponseJson()
    {
        return getConnection().getResponseJsonMap();
    }

    //##################################################
    //# submit
    //##################################################

    protected void submit()
    {
        getConnection().submit();
    }
}
