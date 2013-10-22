package com.kodemore.tumblr;

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
public class KmTumblrTest
{
    public static void main(String[] args)
    {
        KmTumblrConnection c = new KmTumblrConnection();
        c.setPath("services/rest");

        // You need to enter valid keys...
        c.setConsumerKey("");
        c.setConsumerSecret("");
        /**
         * auth token/secret should both be empty strings, because flickr doesn't use them
         */
        c.setAuthToken("");
        c.setAuthSecret("");

        /**
         * fixme_steve (steve) we have to set the method as one of the params, looks like
         * there is only one api and many methods...if that makes sense
         */
        //        Find PERSON:
        c.setParameter("method", "flickr.people.findByUsername");
        c.setParameter("username", "happy bob");

        //        Find PERSON INFO:
        //        c.setParameter("method", "flickr.people.getInfo");
        /**
         * xxxxxxxxx@xxx is a placeholder id
         */
        //        c.setParameter("user_id", "xxxxxxxxx@xxx");

        c.submit();

        String s = c.getResponseString();

        System.out.println("Response");
        System.out.println(s);

        /**
         * review_steve 
         * use kmXmlParser.parse(String xml) to get a KmXmlDocument.
         * once you have the document you can start building the Objects
         */

    }
}
