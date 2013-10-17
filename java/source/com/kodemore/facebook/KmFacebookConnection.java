package com.kodemore.facebook;

import com.kodemore.collection.KmOrderedMap;
import com.kodemore.http.KmHttpGet;
import com.kodemore.http.KmHttpRequest;
import com.kodemore.json.KmJsonMap;
import com.kodemore.json.KmJsonReader;

/**
 * I am used connect to Twitter make various requests.
 */
public class KmFacebookConnection
{
    //##################################################
    //# constants
    //##################################################

    private static String               HOST = "graph.facebook.com";

    private String                      _path;
    private KmOrderedMap<String,String> _parameters;

    private Exception                   _exception;

    //##################################################
    //# variables (private)
    //##################################################

    /**
     * The http request wrapper.
     */
    private KmHttpRequest               _request;

    //##################################################
    //# constructor
    //##################################################

    public KmFacebookConnection()
    {
        _parameters = new KmOrderedMap<String,String>();
    }

    //##################################################
    //# accessing
    //##################################################

    public String getPath()
    {
        return _path;
    }

    public void setPath(String e)
    {
        _path = e;
    }

    public KmOrderedMap<String,String> getRequestParameters()
    {
        return _parameters;
    }

    public void setParameter(String key, String value)
    {
        _parameters.put(key, value);
    }

    //##################################################
    //# exception
    //##################################################

    public Exception getException()
    {
        return _exception;
    }

    private void setException(Exception e)
    {
        _exception = e;
    }

    public boolean hasException()
    {
        return _exception != null;
    }

    //##################################################
    //# public
    //##################################################

    public void submit()
    {
        _request = new KmHttpGet();
        _request.setHost(HOST);
        _request.setHttps();
        _request.setPath(getPath());
        _request.setParameters(getRequestParameters());
        _request.submit();

        System.out.println("    _request.getUrl().toString(): " + _request.getUrl().toString());

        // review_aaron: I don't like this, it seems like a hack
        try
        {
            _request.checkException();
        }
        catch ( RuntimeException ex )
        {
            setException(ex);
        }
    }

    //##################################################
    //# response
    //##################################################

    public String getResponseString()
    {
        return _request.getResponseString();
    }

    public KmJsonMap getResponseJson()
    {
        String s = getResponseString();
        return KmJsonReader.parseJsonMap(s);
    }
}
