package com.kodemore.intacct;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;
import com.kodemore.xml.KmXmlDocument;
import com.kodemore.xml.KmXmlElement;
import com.kodemore.xml.KmXmlParser;

/**
 * I manage the socket connection to the Intacct Web Service API,
 * and coordinate the execution of a single request.
 */
public class KmIntacctConnection
{
    //##################################################
    //# constants :: host
    //##################################################

    private static final String HTTP_HOST         = "api.intacct.com";
    private static final int    HTTP_PORT         = 443;
    private static final String HTTP_PATH         = "/ia/xml/xmlgw.phtml";
    private static final String HTTP_CONTENT_TYPE = "x-intacct-xml-request";

    //##################################################
    //# variables
    //##################################################

    /**
     * The request to be executed.
     */
    private String              _httpRequest;
    private String              _httpResponse;

    //##################################################
    //# request
    //##################################################

    public String getHttpRequest()
    {
        return _httpRequest;
    }

    public void setHttpRequest(String e)
    {
        _httpRequest = e;
    }

    public void setHttpRequestForXml(String xml)
    {
        String http = composeHttpRequestForXml(xml);
        setHttpRequest(http);
    }

    /*
     * POST /ia/xml/xmlgw.phtml HTTP/1.0
     * Host: api.intacct.com
     * Content-Type: x-intacct-xml-request
     * Content-Length: ???
     * ...xml...
     */
    private String composeHttpRequestForXml(String xml)
    {
        KmStringBuilder out;
        out = new KmStringBuilder();
        out.println("POST " + HTTP_PATH + " HTTP/1.0");
        out.println("Host: " + HTTP_HOST);
        out.println("Content-Type: " + HTTP_CONTENT_TYPE);
        out.println("Content-Length: " + xml.length());
        out.println();
        out.println(xml);
        out.println();
        return out.toString();
    }

    //##################################################
    //# response
    //##################################################

    /**
     * Return the full http response including http headers.
     */
    public String getHttpResponse()
    {
        return _httpResponse;
    }

    /**
     * Return only the xml portion of the response.
     */
    public String getXmlResponse()
    {
        String s = getHttpResponse();
        if ( s == null )
            return null;

        String prefix = "<response>";
        String suffix = "</response>";

        int i = s.indexOf(prefix);
        if ( i < 0 )
            return null;

        int j = s.indexOf(suffix, i);
        if ( j < 0 )
            return null;

        return s.substring(i, j + suffix.length());
    }

    public KmIntacctResponse getResponse()
    {
        String xml = getXmlResponse();
        KmXmlDocument doc = KmXmlParser.parse(xml);
        KmXmlElement root = doc.getRoot();
        return new KmIntacctResponse(root);
    }

    //##################################################
    //# post
    //##################################################

    public void send()
    {
        try
        {
            _post();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    @SuppressWarnings("resource")
    private void _post() throws Exception
    {
        // socket

        SSLSocketFactory factory = (SSLSocketFactory)SSLSocketFactory.getDefault();
        SSLSocket socket = (SSLSocket)factory.createSocket(HTTP_HOST, HTTP_PORT);

        // request

        OutputStream os = socket.getOutputStream();
        OutputStreamWriter osWriter = new OutputStreamWriter(os);

        PrintWriter out;
        out = new PrintWriter(new BufferedWriter(osWriter));
        out.print(getHttpRequest());

        if ( out.checkError() )
            throw new RuntimeException("Cannot write to socket.");

        // response

        InputStream is = socket.getInputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(is));

        KmStringBuilder result = new KmStringBuilder();
        while ( true )
        {
            String s = in.readLine();
            if ( s == null )
                break;
            result.println(s);
        }

        // close

        out.close();
        in.close();
        socket.close();

        _httpResponse = result.toString();
    }
}
