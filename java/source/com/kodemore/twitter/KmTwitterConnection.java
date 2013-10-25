package com.kodemore.twitter;

import java.util.Calendar;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.kodemore.collection.KmOrderedMap;
import com.kodemore.http.KmHttpGet;
import com.kodemore.http.KmHttpRequest;
import com.kodemore.json.KmJsonArray;
import com.kodemore.json.KmJsonMap;
import com.kodemore.json.KmJsonReader;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;

/**
 * I am used connect to Twitter make various requests.
 */
public class KmTwitterConnection
{
    //##################################################
    //# constants
    //##################################################

    private static String               HOST                 = "api.twitter.com";
    private static String               HTTP_METHOD          = "GET";
    private static String               OAUTH_VERSION        = "1.0";

    //##################################################
    //# constants (encryption)
    //##################################################

    /**
     * The encryption method specified in the message header. 
     * This should correspond to the CRYPTO_METHOD.
     */
    private static String               AUTHORIZATION_METHOD = "HMAC-SHA1";

    /**
     * The encryption method actually used by the javax.crypto.spec.SecretKeySpec.
     * This should correspond to the AUTHORIZATION_METHOD.
     */
    private static String               CRYPTO_METHOD        = "HmacSHA1";

    //##################################################
    //# variables (public)
    //##################################################

    /**
     * The consumer key/secret are the ~permanent tokens associated with
     * a particular user (or app). 
     */
    private String                      _consumerKey;
    private String                      _consumerSecret;

    /**
     * The auth tokens are typically transient and client may need to 
     * get new credentials fairly frequently.
     */
    private String                      _authToken;
    private String                      _authSecret;

    /**
     * The uri path.  In general, don't encode parameters into the path;
     * set the parameters separately.
     */
    private String                      _path;

    /**
     * The list of parameters.  Parameters are generally stored and used
     * in the sequence that they are set.  Changing the value of a parameter
     * preserves the initial sequence.
     */
    private KmOrderedMap<String,String> _parameters;

    //##################################################
    //# variables (private)
    //##################################################

    /**
     * "Number used Once".
     * http://hueniverse.com/2008/10/beginners-guide-to-oauth-part-iii-security-architecture/
     * 
     * Each request should use a different nonce. 
     * Any relatively random alphanumeric string will work here.
     * In this case we use a standard UUID but strip the dashes.
     */
    private String                      _nonce;

    /**
     * The timestamp is used as part of the authentication process.
     * It is updated for each submit, but not guarnateed to be unique.
     */
    private String                      _timestamp;

    /**
     * The http request wrapper.
     */
    private KmHttpRequest               _request;

    //##################################################
    //# constructor
    //##################################################

    public KmTwitterConnection()
    {
        _parameters = new KmOrderedMap<String,String>();
    }

    //##################################################
    //# accessing
    //##################################################

    public String getConsumerKey()
    {
        return _consumerKey;
    }

    public void setConsumerKey(String e)
    {
        _consumerKey = e;
    }

    public String getConsumerSecret()
    {
        return _consumerSecret;
    }

    public void setConsumerSecret(String e)
    {
        _consumerSecret = e;
    }

    public String getAuthToken()
    {
        return _authToken;
    }

    public void setAuthToken(String e)
    {
        _authToken = e;
    }

    public String getAuthSecret()
    {
        return _authSecret;
    }

    public void setAuthSecret(String e)
    {
        _authSecret = e;
    }

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

    public void setParameter(String key, int value)
    {
        _parameters.put(key, value + "");
    }

    //##################################################
    //# accessing (private)
    //##################################################

    private String getNonce()
    {
        return _nonce;
    }

    private void computeNonce()
    {
        _nonce = Kmu.newJavaUid();
    }

    private String getTimestamp()
    {
        return _timestamp;
    }

    private void computeTimestamp()
    {
        Calendar cal = Calendar.getInstance();
        long millis = cal.getTimeInMillis();
        long secs = millis / 1000;

        _timestamp = secs + "";
    }

    //##################################################
    //# public
    //##################################################

    public void submit()
    {
        computeNonce();
        computeTimestamp();

        _request = new KmHttpGet();
        _request.setHost(HOST);
        _request.setHttps();
        _request.setPort(443);
        _request.setContentTypeHtml();
        _request.setPath(getPath());
        _request.setParameters(getRequestParameters());
        _request.setHeader("Authorization", getAuthorizationHeader());
        _request.submit();
        _request.checkException();
    }

    //##################################################
    //# response
    //##################################################

    public String getResponseString()
    {
        return _request.getResponseString();
    }

    public KmJsonMap getResponseJsonMap()
    {
        String s = getResponseString();
        return KmJsonReader.parseJsonMap(s);
    }

    public KmJsonArray getResponseJsonArray()
    {
        String s = getResponseString();
        return KmJsonReader.parseJsonArray(s);
    }

    //##################################################
    //# authorization header
    //##################################################

    private String getAuthorizationHeader()
    {
        KmStringBuilder out = new KmStringBuilder();

        KmOrderedMap<String,String> m = getAuthorizationParameters();
        for ( String key : m.keySet() )
        {
            String value = m.get(key);
            appendAuthorizationParameter(out, key, value);
        }

        return "OAuth " + out.toString();
    }

    private KmOrderedMap<String,String> getAuthorizationParameters()
    {
        KmOrderedMap<String,String> m;
        m = new KmOrderedMap<String,String>();
        m.putAll(getOauthParameters());
        m.put("oauth_signature", getSignature());
        return m;
    }

    private void appendAuthorizationParameter(KmStringBuilder out, String key, String value)
    {
        if ( out.isNotEmpty() )
            out.print(",");

        out.print(key);
        out.print("=");
        out.print(quote(value));
    }

    //##################################################
    //# oauth signature
    //##################################################

    /**
     * Get the encrypted signature as a base-64 string. 
     */
    private String getSignature()
    {
        String plain = getPlainSignature();
        byte[] encrypted = encryptSignature(plain);
        return toBase64(encrypted);
    }

    private String getPlainSignature()
    {
        String uri = getSignatureUri();
        String params = formatSignatureParameters();

        return HTTP_METHOD + "&" + encode(uri) + "&" + encode(params);
    }

    private String getSignatureUri()
    {
        return "https://" + Kmu.joinUrlPath(HOST, getPath());
    }

    private String formatSignatureParameters()
    {
        KmStringBuilder out = new KmStringBuilder();

        KmOrderedMap<String,String> m = getSignatureParameters();
        for ( String key : m.keySet() )
        {
            String value = m.get(key);
            appendSignatureParameter(out, key, value);
        }

        return out.toString();
    }

    /**
     * Return the parameters used to compute the signature.
     * Note that the parameters are (MUST BE) sorted.
     */
    private KmOrderedMap<String,String> getSignatureParameters()
    {
        KmOrderedMap<String,String> m;
        m = new KmOrderedMap<String,String>();
        m.putAll(getRequestParameters());
        m.putAll(getOauthParameters());
        m.sortOnKeys();
        return m;
    }

    private void appendSignatureParameter(KmStringBuilder out, String key, String value)
    {
        if ( out.isNotEmpty() )
            out.print("&");

        out.print(key);
        out.print("=");
        out.print(encode(value));
    }

    /**
     * Encrypt a value using the javax crypto library.
     */
    private byte[] encryptSignature(String value)
    {
        try
        {
            String method = CRYPTO_METHOD;
            byte[] keyBytes = getSignatureKey().getBytes();
            SecretKey secretKey = new SecretKeySpec(keyBytes, method);

            Mac mac;
            mac = Mac.getInstance(method);
            mac.init(secretKey);
            mac.update(value.getBytes());

            return mac.doFinal();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    private String getSignatureKey()
    {
        return encode(getConsumerSecret()) + "&" + encode(getAuthSecret());
    }

    //##################################################
    //# misc
    //##################################################

    private KmOrderedMap<String,String> getOauthParameters()
    {
        KmOrderedMap<String,String> m;
        m = new KmOrderedMap<String,String>();
        m.put("oauth_version", OAUTH_VERSION);
        m.put("oauth_token", getAuthToken());
        m.put("oauth_consumer_key", getConsumerKey());
        m.put("oauth_timestamp", getTimestamp());
        m.put("oauth_nonce", getNonce());
        m.put("oauth_signature_method", AUTHORIZATION_METHOD);
        return m;
    }

    //##################################################
    //# utility
    //##################################################

    /**
     * Encode the string and wrap in in quotes.
     */
    private String quote(String s)
    {
        String quote = "\"";

        return quote + encode(s) + quote;
    }

    private String encode(String value)
    {
        KmStringBuilder out = new KmStringBuilder();

        String encoded = Kmu.encodeUtf8(value);
        int n = encoded.length();

        for ( int i = 0; i < n; i++ )
        {
            char c = encoded.charAt(i);
            if ( c == '*' )
            {
                out.append("%2A");
                continue;
            }

            if ( c == '+' )
            {
                out.append("%20");
                continue;
            }

            if ( encoded.substring(i).startsWith("%7E") )
            {
                out.append('~');
                i += 2;
                continue;
            }

            out.append(c);
        }

        return out.toString();
    }

    private String toBase64(byte[] value)
    {
        byte[] base64 = Base64.encodeBase64(value);
        String s = new String(base64);

        return s.trim();
    }
}
