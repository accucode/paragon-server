package com.app.utility;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;

import com.app.model.MyTenant;
import com.app.ui.core.MyServletData;
import com.app.ui.servlet.MyServletConstantsIF;

public class MyUrlInfo
    implements MyServletConstantsIF
{
    //##################################################
    //# constants
    //##################################################

    private static final String WEB_SCHEME = "http";
    private static final int    WEB_PORT   = 80;

    private static final String SSL_SCHEME = "https";
    private static final int    SSL_PORT   = 443;

    //##################################################
    //# variables
    //##################################################

    private String          _scheme;
    private String          _host;
    private Integer         _port;
    private String          _path;
    private ScParameterList _parameters;

    //##################################################
    //# constructor
    //##################################################

    public MyUrlInfo()
    {
        // none
    }

    //##################################################
    //# scheme
    //##################################################

    public String getScheme()
    {
        return _scheme;
    }

    public void setScheme(String e)
    {
        _scheme = e;
    }

    public void setSchemeDefault()
    {
        setScheme(getDefaultScheme());
    }

    public void setWebScheme()
    {
        setScheme(WEB_SCHEME);
    }

    public void setSslScheme()
    {
        setScheme(SSL_SCHEME);
    }

    public void setRequestScheme()
    {
        setScheme(getData().getRequestScheme());
    }

    private String getDefaultScheme()
    {
        MyServletData data = getData();
        return data == null
            ? WEB_SCHEME
            : data.getRequestScheme();
    }

    private static MyServletData getData()
    {
        return MyServletData.getLocal();
    }

    public boolean hasScheme()
    {
        return Kmu.hasValue(_scheme);
    }

    //##################################################
    //# host
    //##################################################

    public String getHost()
    {
        return _host;
    }

    public void setHost(String e)
    {
        _host = e;
    }

    public void setRequestHost()
    {
        setHost(getData().getRequestServerHostName());
    }

    public void setHostFor(MyTenant e)
    {
        setHost(e.getHostname());
    }

    public boolean hasHost()
    {
        return Kmu.hasValue(_host);
    }

    public String getEffectiveHost()
    {
        if ( hasHost() )
            return getHost();

        MyServletData data = getData();
        if ( data != null )
            return data.getRequestServerHostName();

        throw Kmu.newFatal("Cannot determine host");
    }

    //##################################################
    //# port
    //##################################################

    public Integer getPort()
    {
        return _port;
    }

    public void setPort(Integer e)
    {
        _port = e;
    }

    public void setPort()
    {
        setPort(getDefaultPort());
    }

    public void setRequestPort()
    {
        setPort(getData().getRequestServerPort());
    }

    private int getDefaultPort()
    {
        MyServletData data = getData();
        return data == null
            ? WEB_PORT
            : data.getRequestServerPort();
    }

    public void setWebPort()
    {
        setPort(WEB_PORT);
    }

    public void setSslPort()
    {
        setPort(SSL_PORT);
    }

    public boolean hasPort()
    {
        return _port != null;
    }

    public boolean hasNonWebPort()
    {
        return hasPort() && getPort() != WEB_PORT;
    }

    //##################################################
    //# path
    //##################################################

    public String getPath()
    {
        return _path;
    }

    public void setPath(String e)
    {
        _path = e;
    }

    public void setRequestPath()
    {
        setPath(getData().getRequestUri());
    }

    public boolean hasPath()
    {
        return Kmu.hasValue(getPath());
    }

    //##################################################
    //# params
    //##################################################

    public ScParameterList getParameters()
    {
        return _parameters;
    }

    public void setParameters(ScParameterList e)
    {
        _parameters = e;
    }

    public void setRequestParameters()
    {
        setParameters(getData().getParameterList());
    }

    public boolean hasParameters()
    {
        return _parameters != null && _parameters.isNotEmpty();
    }

    //##################################################
    //# format
    //##################################################

    public String formatUrl()
    {
        KmStringBuilder out = new KmStringBuilder();

        if ( hasScheme() )
        {
            out.print(getScheme());
            out.print("://");
        }

        out.print(getEffectiveHost());

        if ( hasNonWebPort() )
        {
            out.print(":");
            out.print(getPort());
        }

        if ( hasPath() )
            out.print(getPath());

        if ( hasParameters() )
            out.print(_parameters.formatQueryString());

        return out.toString();
    }

}
