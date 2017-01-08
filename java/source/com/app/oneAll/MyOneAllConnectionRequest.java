package com.app.oneAll;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;

import com.kodemore.json.KmJsonMap;
import com.kodemore.json.KmJsonReader;
import com.kodemore.utility.Kmu;

import com.app.property.MyProperties;
import com.app.utility.MyGlobals;

public class MyOneAllConnectionRequest
{
    //##################################################
    //# variables
    //##################################################

    private String _connectionToken;

    //##################################################
    //# accessing
    //##################################################

    public String getConnectionToken()
    {
        return _connectionToken;
    }

    public void setConnectionToken(String e)
    {
        _connectionToken = e;
    }

    //##################################################
    //# submit
    //##################################################

    public MyOneAllConnectionResponse submit()
    {
        try
        {
            return submitTry();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    //##################################################
    //# support
    //##################################################

    private MyOneAllConnectionResponse submitTry() throws Exception
    {
        try (InputStream in = open().getInputStream())
        {
            String json = Kmu.readStringFrom(in);
            KmJsonMap doc = KmJsonReader.parseJsonMap(json);
            return new MyOneAllConnectionResponse(doc);
        }
    }

    private HttpURLConnection open() throws Exception
    {
        URL url = getUrl();
        String auth = getBasicAuthToken();

        HttpURLConnection con;
        con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Authorization", "Basic " + auth);
        con.setDoOutput(true);
        con.setReadTimeout(5000);
        con.connect();
        con.getInputStream();
        return con;
    }

    private URL getUrl() throws Exception
    {
        String path = Kmu.format("connections/%s.json", getConnectionToken());
        String fullPath = Kmu.joinUrlPath(getHost(), path);
        URL url = new URL("https://" + fullPath);
        return url;
    }

    private String getBasicAuthToken()
    {
        String keys = getPublicKey() + ":" + getPrivateKey();
        byte[] bytes = keys.getBytes();
        byte[] base64 = new Base64().encode(bytes);
        String string = new String(base64);

        return string.replaceAll("[\n\r]", "");
    }

    private String getHost()
    {
        return getProperties().getOneAllHost();
    }

    private String getPublicKey()
    {
        return getProperties().getOneAllPublicKey();
    }

    private String getPrivateKey()
    {
        return getProperties().getOneAllPrivateKey();
    }

    private MyProperties getProperties()
    {
        return MyGlobals.getProperties();
    }
}
