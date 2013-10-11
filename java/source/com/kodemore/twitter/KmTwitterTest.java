package com.kodemore.twitter;

import com.kodemore.json.KmJsonMap;

/**
 * I am used connect to Twitter make various requests.
 * 
 * You will need to do the following to use this class:
 *      1.  Sign up for a Twitter account.
 *      2.  Visit dev.twitter.com and sign in as your user.
 *      3.  Create a new application for testing.
 *      4.  Retrieve the consumer key, consumer secret, access token (auth token) 
 *          and access token (secret auth token secret) from the application information page.
 *      5.  Update the main method with the token and screts from the previous step.
 */
public class KmTwitterTest
{
    public static void main(String[] args)
    {
        KmTwitterConnection con;
        con = new KmTwitterConnection();

        // You need to enter valid keys...
        con.setConsumerKey("");
        con.setConsumerSecret("");
        con.setAuthToken("");
        con.setAuthSecret("");

        con.setPath("/1.1/search/tweets.json");
        con.setParameter("q", "bob marley");
        con.setParameter("lang", "en");
        con.setParameter("result_type", "mixed");
        con.submit();

        KmJsonMap json = con.getResponseJson();
        String firstText = json.getArray("statuses").getFirstMap().getString("text");

        System.out.println("Response");
        System.out.println(json);

        System.out.println();
        System.out.println("First text");
        System.out.println(firstText);
    }
}
