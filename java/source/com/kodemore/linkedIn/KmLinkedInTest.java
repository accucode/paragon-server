package com.kodemore.linkedIn;

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
 *      
 * review_wyatt (steve) 
 */
public class KmLinkedInTest
{
    public static void main(String[] args)
    {
        KmLinkedInConnection c = new KmLinkedInConnection();
        //        c.setParameter("lang", "en");
        c.setPath("v1/people-search");

        // You need to enter valid keys...
        c.setConsumerKey("");
        c.setConsumerSecret("");
        c.setAuthToken("");
        c.setAuthSecret("");

        c.setParameter("id", "293851867");

        c.submit();

        KmJsonMap json = c.getResponseJsonMap();

        System.out.println("Response");
        System.out.println(json.formatJson());
    }
}
