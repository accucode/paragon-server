package com.kodemore.linkedIn;

/**
 * I am used connect to LinkedIn and make various requests.
 */
public class KmLinkedInTest
{
    public static void main(String[] args)
    {
        KmLinkedInConnection c;
        c = new KmLinkedInConnection();
        //        c.setParameter("lang", "en");
        c.setPath("v1/people-search");

        // You need to enter valid keys...
        c.setConsumerKey("");
        c.setConsumerSecret("");
        c.setAuthToken("");
        c.setAuthSecret("");

        c.setParameter("id", "xxxxxxxxxx");

        c.submit();

        String s = c.getResponseString();

        System.out.println("Response");
        System.out.println(s);
    }
}
