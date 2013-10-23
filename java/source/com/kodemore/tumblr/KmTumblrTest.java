package com.kodemore.tumblr;

/**
 * I am used connect to Twitter make various requests.
 * 
 */
public class KmTumblrTest
{
    public static void main(String[] args)
    {
        KmTumblrConnection c = new KmTumblrConnection();
        /**
         * these apis require authentication
         * We will need to figure out the login with tumblr button 
         * to get the users auth token/secret inorder to make requests on
         * the user's behalf (find their private info)
         */
        //        c.setPath("v2/blog/instructables.tumblr.com/followers");
        //        c.setPath("v2/user/info");

        /**
         * this api does not require authentication
         */
        c.setPath("v2/blog/instructables.tumblr.com/avatar");

        // You need to enter valid keys...
        c.setConsumerKey("");
        c.setConsumerSecret("");
        c.setAuthToken("");
        c.setAuthSecret("");

        c.setParameter("base-hostname", "instructables.tumblr.com");

        c.submit();

        String s = c.getResponseString();

        System.out.println("Response");
        System.out.println(s);
    }
}
