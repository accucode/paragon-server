/*
  Copyright (c) 2005-2013 www.kodemore.com

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in
  all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  THE SOFTWARE.
*/

package com.kodemore.http;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.Map.Entry;

import com.kodemore.collection.*;
import com.kodemore.utility.*;

public abstract class KmHttpRequest
{
    //##################################################
    //# variables
    //##################################################

    private String                      _method;
    private String                      _host;
    private int                         _port;
    private String                      _path;
    private String                      _contentType;
    private KmMap<String,String>        _headers;
    private KmOrderedMap<String,String> _parameters;
    private boolean                     _https;

    private URL                         _url;
    private HttpURLConnection           _connection;
    private byte[]                      _responseValue;
    private Exception                   _exception;

    //##################################################
    //# constructor
    //##################################################

    public KmHttpRequest()
    {
        setMethodGet();
        _host = "";
        _port = 80;
        _path = "";
        _headers = new KmMap<String,String>();
        _parameters = new KmOrderedMap<String,String>();
        clearContentType();
        _https = false;
    }

    //##################################################
    //# accessing
    //##################################################

    public String getHost()
    {
        return _host;
    }

    public void setHost(String e)
    {
        _host = e;
    }

    public int getPort()
    {
        return _port;
    }

    public void setPort(int e)
    {
        _port = e;
    }

    public String getPath()
    {
        return _path;
    }

    public void setPath(String e)
    {
        _path = e;
    }

    public void setHeader(String key, String value)
    {
        _headers.put(key, value);
    }

    public KmOrderedMap<String,String> getParameters()
    {
        return _parameters;
    }

    public void setParameter(String key, String value)
    {
        _parameters.put(key, value);
    }

    public void setParameters(Map<String,String> m)
    {
        for ( Entry<String,String> e : m.entrySet() )
            setParameter(e.getKey(), e.getValue());
    }

    public boolean getHttps()
    {
        return _https;
    }

    public void setHttps()
    {
        _https = true;
    }

    public boolean isOk()
    {
        return _exception == null;
    }

    //##################################################
    //# method
    //##################################################//
    public String getMethod()
    {
        return _method;
    }

    public void setMethod(String method)
    {
        _method = method;
    }

    public void setMethodGet()
    {
        _method = "GET";
    }

    public void setMethodHead()
    {
        _method = "HEAD";
    }

    public void setMethodPost()
    {
        _method = "POST";
    }

    public void setMethodPut()
    {
        _method = "PUT";
    }

    public void setMethodDelete()
    {
        _method = "DELETE";
    }

    public void setMethodTrace()
    {
        _method = "TRACE";
    }

    public void setMethodConnect()
    {
        _method = "CONNECT";
    }

    //==================================================
    //= exception
    //==================================================

    public Exception getException()
    {
        return _exception;
    }

    public void setException(Exception e)
    {
        _exception = e;
    }

    public boolean hasException()
    {
        return _exception != null;
    }

    public void checkException()
    {
        if ( hasException() )
            throw Kmu.toRuntime(getException());
    }

    //##################################################
    //# content type
    //##################################################

    public String getContentType()
    {
        return _contentType;
    }

    public void setContentType(String e)
    {
        _contentType = e;
    }

    /**
     * By default, the content type is null / undefined.  This is appropriate for
     * http GET but not for POST.
     */
    public void clearContentType()
    {
        _contentType = null;
    }

    public boolean hasContentType()
    {
        return Kmu.hasValue(_contentType);
    }

    /**
     * This content type may be used when communicating with a web service.
     */
    public void setContentTypeText()
    {
        setContentType("text/plain");
    }

    /**
     * This content type may be used when communicating with a web service.
     */
    public void setContentTypeHtml()
    {
        setContentType("text/html");
    }

    /**
     * This content type is used when simulating a form post.
     */
    public void setContentTypeFormPost()
    {
        setContentType("application/x-www-form-urlencoded");

    }

    public void setContentTypeJson()
    {
        setContentType("application/json");

    }

    //##################################################
    //# response
    //##################################################

    public URL getUrl()
    {
        return _connection.getURL();
    }

    public int getResponseCode()
    {
        try
        {
            return _connection.getResponseCode();
        }
        catch ( IOException ex )
        {
            return -1;
        }
    }

    public String getResponseMessage()
    {
        try
        {
            return _connection.getResponseMessage();
        }
        catch ( IOException ex )
        {
            return null;
        }
    }

    public byte[] getResponseValue()
    {
        return _responseValue;
    }

    public String getResponseString()
    {
        if ( _responseValue == null )
            return null;
        StringBuilder sb = new StringBuilder();
        int n = _responseValue.length;
        for ( int i = 0; i < n; i++ )
            sb.append((char)_responseValue[i]);
        return sb.toString();
    }

    //##################################################
    //# execute
    //##################################################

    public void submit()
    {
        try
        {

            _reset();
            _openConnection();
            _setMethod();
            _applyHeaders();
            _applyRequestValue();
            _readResponseValue();
        }
        catch ( IOException ex )
        {
            _exception = ex;
        }
    }

    private void _reset()
    {
        _url = null;
        _connection = null;
        _responseValue = null;
        _exception = null;
    }

    private void _openConnection() throws IOException
    {
        _url = new URL(getScheme(), _host, _port, getNormalizedFullPath());

        _connection = (HttpURLConnection)_url.openConnection();
        if ( hasContentType() )
            _connection.setRequestProperty("Content-Type", getContentType());
    }

    private void _setMethod()
    {

        try
        {
            getConnection().setRequestMethod(_method);
        }
        catch ( ProtocolException ex )
        {
            _exception = ex;

        }

    }

    private String getScheme()
    {
        return _https
            ? "https"
            : "http";
    }

    private String getNormalizedFullPath()
    {
        String s = getFullPath();
        if ( Kmu.isEmpty(s) )
            return "";

        if ( s.startsWith("/") )
            return s;

        return "/" + s;
    }

    protected abstract String getFullPath();

    private void _applyHeaders()
    {
        Iterator<Map.Entry<String,String>> i = _headers.entrySet().iterator();
        while ( i.hasNext() )
        {
            Map.Entry<String,String> me = i.next();
            String key = me.getKey();
            String value = me.getValue();
            _connection.setRequestProperty(key, value);
        }
    }

    protected abstract void _applyRequestValue() throws IOException;

    /**
     * Compose the list of key=value pairs, separated by &.  The leading
     * ? is not included as this may or may not be appropriate.
     */
    protected String getRequestParameterString()
    {
        StringBuilder sb = new StringBuilder();
        Iterator<String> i = _parameters.getKeys().iterator();
        while ( i.hasNext() )
        {
            String key = i.next();
            String value = _parameters.get(key);
            sb.append(Kmu.encodeUtf8(key));
            sb.append("=");
            sb.append(Kmu.encodeUtf8(value));
            if ( i.hasNext() )
                sb.append("&");
        }
        return sb.toString();
    }

    /**
     * The documentation for HttpURLConnection.getErrorStream
     * says that if the server responds with a 404, a FileNotFoundException 
     * will be thrown during connect.  
     * 
     * It is possible however to check the result code before trying connect
     * using the getResponseMessage method.  So below I implemented a simple
     * check to see if the result code is OK, and it it isn't, it grabs the 
     * error stream which contains the error information.  This seems to 
     * solve the problem.
     */
    private void _readResponseValue() throws IOException
    {
        InputStream in = null;
        try
        {
            if ( isSuccessfullResponse(_connection.getResponseMessage()) )
                in = _connection.getInputStream();
            else
                in = _connection.getErrorStream();

            _responseValue = Kmu.readBytesFrom(in);
        }
        finally
        {
            Kmu.closeSafely(in);
        }
    }

    protected boolean isSuccessfullResponse(String responseMessage)
    {
        return responseMessage.equals("OK");
    }

    protected HttpURLConnection getConnection()
    {
        return _connection;
    }

}
