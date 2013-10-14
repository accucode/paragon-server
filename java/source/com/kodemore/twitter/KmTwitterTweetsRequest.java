package com.kodemore.twitter;

import com.kodemore.json.KmJsonMap;

/**
 * I am used connect to Twitter make various requests.
 */
public class KmTwitterTweetsRequest
{
    //##################################################
    //# constants
    //##################################################

    //##################################################
    //# variables 
    //##################################################

    private KmTwitterConnection _connection;

    //##################################################
    //# constructor
    //##################################################

    public KmTwitterTweetsRequest()
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

    protected KmJsonMap getResponseJson()
    {
        return getConnection().getResponseJson();
    }

    //##################################################
    //# submit
    //##################################################//

    protected void submit()
    {
        getConnection().submit();
    }
}
