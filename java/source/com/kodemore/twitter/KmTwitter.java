package com.kodemore.twitter;

import java.io.*;
import java.net.*;
import java.security.*;
import java.util.*;

import javax.crypto.*;
import javax.crypto.spec.*;

import org.apache.commons.codec.binary.*;
import org.json.simple.*;

import com.kodemore.http.*;
import com.kodemore.json.*;
import com.kodemore.utility.*;

/**
 * 
 * This class is used to connect to Twitter and search for tweets.
 * 
 * This has been tested against api.twitter.com
 * 
 * You will need to do the following to use this class
 * 1.  Sign up for a Twitter account.
 * 2.  Visit dev.twitter.com and sign in as your user.
 * 3.  Create a new application for testing.
 * 4.  Retrieve the consumer key, consumer secret, access token (auth token) and access token (secret auth token secret)
 *     from the application information page. 
 * 5.  Update the main method with the token and screts from the previous step.
 * 
 */

public class KmTwitter
{
    //##################################################
    //# constants
    //##################################################//
    public static String TWITTER_ENDPOINT_HOST              = "api.twitter.com";
    public static String TWITTER_SEARCH_TWEETS_ENPOINT_PATH = "/1.1/search/tweets.json";

    //##################################################
    //# variables
    //##################################################//

    private String       _twitterConsumerKey;
    private String       _twitterConsumerSecret;
    private String       _authToken;
    private String       _authTokenSecret;

    //##################################################
    //# accessing
    //##################################################//

    public String getTwitterConsumerKey()
    {
        return _twitterConsumerKey;
    }

    public void setTwitterConsumerKey(String twitterConsumerKey)
    {
        _twitterConsumerKey = twitterConsumerKey;
    }

    public String getTwitterConsumerSecret()
    {
        return _twitterConsumerSecret;
    }

    public void setTwitterConsumerSecret(String twitterConsumerSecret)
    {
        _twitterConsumerSecret = twitterConsumerSecret;
    }

    public String getAuthToken()
    {
        return _authToken;
    }

    public void setAuthToken(String authToken)
    {
        _authToken = authToken;
    }

    public String getAuthTokenSecret()
    {
        return _authTokenSecret;
    }

    public void setAuthTokenSecret(String authTokenSecret)
    {

        _authTokenSecret = authTokenSecret;
    }

    //##################################################
    //# public
    //##################################################//

    public KmJsonObject searchTweets(String q) throws Exception
    {

        KmHttpRequest e;
        e = new KmHttpGet();
        e.setHost(TWITTER_ENDPOINT_HOST);
        e.setHttps();
        e.setPort(443);
        e.setPath(getTwitterSearchUrlWithQueryString(q));
        e.setContentType("text/html");
        e.setHeader("Authorization", createAuthorizationHeader(q));
        e.submit();
        System.out.println("------------------------------------------------------------");
        if ( e.hasException() )
        {
            System.out.println("url:   " + e.getUrl());
            System.out.println("error: " + e.getException());
            return null;
        }
        System.out.println("url:              " + e.getUrl());
        System.out.println("response code:    " + e.getResponseCode());
        // System.out.println("response message: " + e.getResponseMessage());

        // System.out.println(e.getResponseString());
        JSONObject jsonresponse = new JSONObject();
        processTwitterResponse(jsonresponse, e.getResponseString());
        return new KmJsonObject(jsonresponse);

    }

    private String getTwitterSearchUrlWithQueryString(String q)
    {
        return TWITTER_SEARCH_TWEETS_ENPOINT_PATH + "?lang=en&result_type=mixed&q=" + encode(q);
    }

    //##################################################
    //# Utilities
    //##################################################//

    private void processTwitterResponse(JSONObject jsonresponse, String s) throws IOException
    {
        // if successful, the response should be a JSONObject of tweets
        KmJsonObject jo = KmJsonReader.parseJsonObject(s);
        if ( jo.hasKey("errors") )
        {
            jsonresponse.put("response_status", "error");
            String message_from_twitter = jo.getList("errors").getObjectAt(0).getString("message");
            if ( message_from_twitter.equals("Invalid or expired token")
                || message_from_twitter.equals("Could not authenticate you") )
                jsonresponse.put("message", "Twitter auth error.");
            else
                jsonresponse.put(
                    "message",
                    jo.getList("errors").getObjectAt(0).getString("message"));
        }
        else
            jsonresponse.put("twitter_jo", jo); // this is the full result
                                                // object from Twitter
    }

    public String encode(String value)
    {
        String encoded = null;
        try
        {
            encoded = URLEncoder.encode(value, "UTF-8");
        }
        catch ( UnsupportedEncodingException ignore )
        {
        }
        StringBuilder buf = new StringBuilder(encoded.length());
        char focus;
        for ( int i = 0; i < encoded.length(); i++ )
        {
            focus = encoded.charAt(i);
            if ( focus == '*' )
                buf.append("%2A");
            else
                if ( focus == '+' )
                    buf.append("%20");
                else
                    if ( focus == '%'
                        && i + 1 < encoded.length()
                        && encoded.charAt(i + 1) == '7'
                        && encoded.charAt(i + 2) == 'E' )
                    {
                        buf.append('~');
                        i += 2;
                    }
                    else
                        buf.append(focus);
        }
        return buf.toString();
    }

    private static String computeSignature(String baseString, String keyString)
        throws GeneralSecurityException, UnsupportedEncodingException
    {
        SecretKey secretKey = null;

        byte[] keyBytes = keyString.getBytes();
        secretKey = new SecretKeySpec(keyBytes, "HmacSHA1");

        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(secretKey);

        byte[] text = baseString.getBytes();

        return new String(Base64.encodeBase64(mac.doFinal(text))).trim();
    }

    private String getTwitterUrl(String path)
    {
        String s = "https://" + Kmu.joinUrlPath(TWITTER_ENDPOINT_HOST, path);
        return s;
    }

    private String createAuthorizationHeader(String q)
    {
        String get_or_post = "GET";
        String oauthSignatureMethod = "HMAC-SHA1";

        String oauthNonce = getNonce();
        String oauthTimestamp = getRequestTimestamp();
        String parameter_string = getParameterString(
            q,
            oauthSignatureMethod,
            oauthNonce,
            oauthTimestamp);
        String oauth_signature = getAuthSignature(get_or_post, parameter_string);
        String authorizationHeaderString = getAuthorizationHeaderString(
            oauthNonce,
            oauthTimestamp,
            oauth_signature);
        return authorizationHeaderString;
    }

    private String getAuthorizationHeaderString(
        String oauthNonce,
        String oauthTimestamp,
        String oauthSignature)
    {

        String authorizationHeaderString = "OAuth oauth_consumer_key=\""
            + _twitterConsumerKey
            + "\",oauth_signature_method=\"HMAC-SHA1\",oauth_timestamp=\""
            + oauthTimestamp
            + "\",oauth_nonce=\""
            + oauthNonce
            + "\",oauth_version=\"1.0\",oauth_signature=\""
            + encode(oauthSignature)
            + "\",oauth_token=\""
            + encode(_authToken)
            + "\"";
        System.out.println("authorization_header_string=" + authorizationHeaderString);
        return authorizationHeaderString;
    }

    private String getAuthSignature(String method, String parameterString)
    {

        // this time the base string is signed using twitter_consumer_secret +
        // "&" + encode(oauth_token_secret) instead of just
        // twitter_consumer_secret + "&"
        String signatureBaseString = method
            + "&"
            + encode(getTwitterUrl(TWITTER_SEARCH_TWEETS_ENPOINT_PATH))
            + "&"
            + encode(parameterString);

        System.out.println("signature_base_string=" + signatureBaseString);

        String oauthSignature = "";
        try
        {
            oauthSignature = computeSignature(signatureBaseString, _twitterConsumerSecret
                + "&"
                + encode(_authTokenSecret)); // note the & at the end.  Normally the user access token would go here, but we don't know it yet for request_token
        }
        catch ( GeneralSecurityException e )
        {
            e.printStackTrace();
        }
        catch ( UnsupportedEncodingException e )
        {
            e.printStackTrace();
        }
        return oauthSignature;
    }

    private String getParameterString(
        String q,
        String oauthSignatureMethod,
        String oauthNonce,
        String oauthTimestamp)
    {
        // the parameter string must be in alphabetical order
        // "lang", "result_type" and "q" are not part of oAuth.  These may be Twitter specific.

        String parameter_string = "lang=en&oauth_consumer_key="
            + _twitterConsumerKey
            + "&oauth_nonce="
            + oauthNonce
            + "&oauth_signature_method="
            + oauthSignatureMethod
            + "&oauth_timestamp="
            + oauthTimestamp
            + "&oauth_token="
            + encode(_authToken)
            + "&oauth_version=1.0"
            + "&q="
            + encode(q)
            + "&result_type=mixed";

        System.out.println("parameter_string=" + parameter_string);
        return parameter_string;
    }

    private String getNonce()
    {
        String uuidString = UUID.randomUUID().toString();
        uuidString = uuidString.replaceAll("-", "");
        String oauthNonce = uuidString; // any relatively random alphanumeric
                                        // string will work here
        return oauthNonce;
    }

    private String getRequestTimestamp()
    {
        Calendar tempcal = Calendar.getInstance();
        long ts = tempcal.getTimeInMillis();
        String oauthTimestamp = new Long(ts / 1000).toString(); // convert to seconds
        return oauthTimestamp;
    }

    //##################################################
    //# main
    //##################################################//
    public static void main(String[] args)
    {

        try
        {
            KmTwitter t = new KmTwitter();
            t.setTwitterConsumerKey("replace with your consumer key");
            t.setTwitterConsumerSecret("replace with your consumer secret");
            t.setAuthToken("replace with your Auth token");
            t.setAuthTokenSecret("replace with your Token Secret");

            //search for tweets containing the string "bob"
            KmJsonObject o = t.searchTweets("bob");
            System.out.print(o);
        }
        catch ( Exception ex )
        {
            ex.printStackTrace();
        }

    }
}
