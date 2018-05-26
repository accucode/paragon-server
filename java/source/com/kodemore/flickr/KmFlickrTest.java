package com.kodemore.flickr;

/**
 * I am used connect to Flickr make various requests.
 */
public class KmFlickrTest
{
    public static void main(String[] args)
    {
        KmFlickrConnection c = new KmFlickrConnection();
        c.setPath("services/rest");

        // You need to enter valid keys...
        c.setConsumerKey("");
        c.setConsumerSecret("");

        // The auth token/secret should be empty string; flickr doesn't use them.
        c.setAuthToken("");
        c.setAuthSecret("");

        /**
         * fixme we have to set the method as one of the params, looks like
         * there is only one api and many methods...if that makes sense
         */
        //        Find PERSON:
        c.setParameter("method", "flickr.people.findByUsername");
        c.setParameter("username", "happy bob");

        //        Find PERSON INFO:
        //        c.setParameter("method", "flickr.people.getInfo");
        //        c.setParameter("user_id", "john@example.net");

        c.submit();

        String s = c.getResponseString();

        System.out.println("Response");
        System.out.println(s);

        /**
         * review
         * use kmXmlParser.parse(String xml) to get a KmXmlDocument.
         * once you have the document you can start building the Objects
         */

    }
}
