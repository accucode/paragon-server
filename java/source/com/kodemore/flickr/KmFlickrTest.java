package com.kodemore.flickr;

/**
 * (steve)
 * 
 * review_steve (wyatt)
 *      I'm not sure what you want me to review here. 
 */

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
