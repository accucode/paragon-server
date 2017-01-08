package com.kodemore.yelp;

/**
 * I am used connect to Flickr make various requests.
 *
 *
 */
/**
 * fixme (steve) so this isn't working for some reason. there is very little documentation
 * and it should just work with standard oAuth signatures....
 * http://www.yelp.com/developers/documentation/v2/authentication
 */
public class KmYelpTest
{
    public static void main(String[] args)
    {
        KmYelpConnection c = new KmYelpConnection();
        c.setPath("v2/search");

        // You need to enter valid keys they are in the executive summary...
        c.setConsumerKey("");
        c.setConsumerSecret("");
        c.setAuthToken("");
        c.setAuthSecret("");

        //        Search Business:
        c.setParameter("term", "food");
        //        c.setParameter("limit", "1");
        //        c.setParameter("location", "denver");

        c.submit();

        String s = c.getResponseString();

        System.out.println("Response");
        System.out.println(s);
    }
}
