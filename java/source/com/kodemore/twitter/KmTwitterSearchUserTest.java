package com.kodemore.twitter;

import com.kodemore.collection.KmList;
import com.kodemore.json.KmJsonArray;

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
        KmTwitterSearchUsersRequest req;
        req = new KmTwitterSearchUsersRequest();

        // You need to enter valid keys...
        req.setConsumerKey("");
        req.setConsumerSecret("");
        req.setAuthToken("");
        req.setAuthSecret("");

        req.setQuery("@example");
        req.submit();

        KmJsonArray responseJson = req.getResponseJson();

        KmList<KmTwitterUser> responseUsers = req.getResponseUsers();

        System.out.println("Response");
        System.out.println(responseJson);

        System.out.println("LIST OF USERS");
        System.out.println("==================================");

        for ( KmTwitterUser u : responseUsers )
            System.out.println(u.getName());

        System.out.println("==================================");

        KmTwitterUser first = responseUsers.getFirst();

        System.out.println(first.getStatus());
        System.out.println(first.getStatus().getPlace().getBoundingbox());
    }
}
