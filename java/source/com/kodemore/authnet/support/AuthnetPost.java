package com.kodemore.authnet.support;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

import com.kodemore.authnet.AuthnetConfiguration;
import com.kodemore.authnet.model.AuthnetRetryableError;
import com.kodemore.authnet.request.AuthnetAbstractRequest;
import com.kodemore.authnet.request.AuthnetAbstractResponse;
import com.kodemore.log.KmLog;
import com.kodemore.utility.Kmu;
import com.kodemore.xml.utility.KmXmlBuilder;
import com.kodemore.xml.utility.KmXmlWrapper;

public class AuthnetPost
{
    //##################################################
    //# variables
    //##################################################

    private AuthnetAbstractRequest  _request;
    private AuthnetAbstractResponse _response;

    private KmXmlBuilder            _requestBuffer;
    private String                  _requestXml;

    private String                  _responseXml;
    private String                  _cleanedReponseXml;

    private URLConnection           _connection;
    private URL                     _url;

    private StringBuilder           _status;
    private boolean                 _retry;

    //##################################################
    //# constructor
    //##################################################

    public AuthnetPost()
    {
        // none
    }

    //##################################################
    //# accessing
    //##################################################

    public AuthnetAbstractRequest getRequest()
    {
        return _request;
    }

    public void setRequest(AuthnetAbstractRequest e)
    {
        _request = e;
    }

    public AuthnetAbstractResponse getResponse()
    {
        return _response;
    }

    public void setResponse(AuthnetAbstractResponse e)
    {
        _response = e;
    }

    //##################################################
    //# post
    //##################################################

    public void post()
    {
        try
        {
            doPost();
        }
        catch ( AuthnetRetryableError ex )
        {
            logRetryable(ex);
            throw ex;
        }
        catch ( Exception ex )
        {
            logException(ex);
            if ( _retry )
                throw new AuthnetRetryableError(ex);
            throw Kmu.toRuntime(ex);
        }
    }

    private void doPost() throws Exception
    {
        enableRetry();

        initialize();
        checkInputs();
        composeRequestXml();
        validateRequestXml();
        createUrl();
        openConnection();

        disableRetry();

        writeRequest();
        readResponse();
        cleanResponse();
        parseResponse();
        checkResponse();
        finished();
    }

    private void logRetryable(AuthnetRetryableError ex)
    {
        if ( ex.isLogWarn() )
        {
            status(ex.getRootMessage());
            KmLog.warn(formatExceptionMessage());
            return;
        }

        logException(ex);
    }

    private void logException(Exception ex)
    {
        status(Kmu.getRootMessage(ex));
        KmLog.error(ex, formatExceptionMessage());
    }

    private String formatExceptionMessage()
    {
        return "Authnet Post Details\n" + _status;
    }

    //##################################################
    //# steps
    //##################################################

    private void initialize()
    {
        _status = new StringBuilder();
        status("Initialize...");
    }

    private void checkInputs()
    {
        status("Check inputs...");

        if ( _request == null )
            runtime("Request is null.");

        if ( _response == null )
            runtime("Response is null.");

        status("Request:  " + _request.getClass().getName());
        status("Response: " + _response.getClass().getName());
    }

    private void composeRequestXml()
    {
        status("Compose request xml...");

        _requestBuffer = new KmXmlBuilder();
        _request.printXmlOn(_requestBuffer);
        _requestXml = _requestBuffer.toString();

        status("Request xml =");
        status(_requestXml);
    }

    private void validateRequestXml()
    {
        status("Validating request xml...");

        KmXmlWrapper.parseXml(_requestXml);
    }

    private void createUrl() throws MalformedURLException
    {
        status("Creating url...");

        String domain = AuthnetConfiguration.getDomain();
        String url = AuthnetConfiguration.getUrl();

        status("domain: " + domain);
        status("url: " + url);

        _url = new URL(url);
    }

    private void openConnection() throws IOException
    {
        status("Open connection...");

        _connection = _url.openConnection();
        _connection.setDoOutput(true);
        _connection.setDoInput(true);
        _connection.setUseCaches(false);
        _connection.setRequestProperty("content-type", "text/xml");
    }

    private void writeRequest() throws IOException
    {
        status("Write request...");

        debug("writeRequest: " + _requestXml);

        DataOutputStream out = null;
        try
        {
            out = new DataOutputStream(_connection.getOutputStream());
            out.writeBytes(_requestXml);
            out.flush();
        }
        catch ( UnknownHostException ex )
        {
            String s = Kmu.format(
                "Cannot connect to Authnet (%s).",
                AuthnetConfiguration.getDomain());

            AuthnetRetryableError error;
            error = new AuthnetRetryableError(s);
            error.setLogWarn();
            error.setAutoRetry();
            throw error;
        }
        finally
        {
            Kmu.closeSafely(out);
        }
    }

    private void readResponse() throws IOException
    {
        status("Read response...");

        StringBuilder buffer = new StringBuilder();
        BufferedReader in = null;
        try
        {
            in = new BufferedReader(new InputStreamReader(_connection.getInputStream()));
            while ( true )
            {
                String line = in.readLine();
                if ( line == null )
                    break;
                buffer.append(line);
            }
            _responseXml = buffer.toString();

            debug("response xml: %s", _responseXml);

            status("Response xml...");
            status(_responseXml);
        }
        finally
        {
            Kmu.closeSafely(in);
        }
    }

    private void cleanResponse()
    {
        status("Clean response...");
        _cleanedReponseXml = Kmu.stripNonMultiLinePrintable(_responseXml).trim();
    }

    private void parseResponse()
    {
        status("Parse response...");
        _response.setXml(_cleanedReponseXml);

        status("Result Code: " + _response.getResultCode());
        status("Response Code: " + _response.getResponseCode());
        status("Response Text: " + _response.getResponseText());
    }

    private void checkResponse()
    {
        status("Check response...");

        if ( !_response.hasResultCode() )
            runtime("Cannot determine result code.");

        if ( _response.hasUnknownResultCode() )
            runtime("Unknown result code(%s).", _response.getResultCode());
    }

    private void finished()
    {
        status("Finished.");
    }

    //##################################################
    //# support
    //##################################################

    private void debug(String message, Object... args)
    {
        KmLog.debug("authnet", message, args);
    }

    private void enableRetry()
    {
        _retry = true;
    }

    private void disableRetry()
    {
        _retry = false;
    }

    private void status(String msg, Object... args)
    {
        _status.append(Kmu.format(msg, args) + "\n");
    }

    private void runtime(String msg, Object... args)
    {
        status(msg, args);
        throw new RuntimeException(Kmu.format(msg, args));
    }

}
