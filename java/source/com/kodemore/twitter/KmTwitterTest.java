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
 *      
 * review_wyatt (steve) 
 */
public class KmTwitterTest
{
    public static void main(String[] args)
    {
        KmTwitterSearchTweetsRequest req;
        req = new KmTwitterSearchTweetsRequest();

        // You need to enter valid keys...
        req.setConsumerKey("");
        req.setConsumerSecret("");
        req.setAuthToken("");
        req.setAuthSecret("");

        req.setQuery("bacon");
        req.setResultType(KmTwitterResultType.Popular);
        req.submit();

        KmJsonMap json = req.getResponseJson();
        String firstText = json.getArray("statuses").getFirstMap().getString("text");

        System.out.println("Response");
        System.out.println(req.getResponseJson());

        System.out.println("text");
        System.out.println(firstText);
    }
}
