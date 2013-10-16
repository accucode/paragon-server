package com.kodemore.twitter;

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
public class KmTwitterSearchUserTest
{
    public static void main(String[] args)
    {

        /**
         * review_wyatt (steve) please look at this. it is working.
         */

        KmTwitterSearchUsersRequest req;
        req = new KmTwitterSearchUsersRequest();

        // You need to enter valid keys...
        req.setConsumerKey("");
        req.setConsumerSecret("");
        req.setAuthToken("");
        req.setAuthSecret("");

        req.setQuery("@accucodeSteve");
        req.submit();

        System.out.println("Response");
        System.out.println(req.getResponseJson());
        System.out.println("description");
        System.out.println(req.getResponseUsers().getFirst().getDescription());
    }
}
