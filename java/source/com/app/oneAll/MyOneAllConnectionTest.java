package com.app.oneAll;

/**
 * I demonstrate how to lookup the OneAll user credentials
 * from the OneAll connection token that is provided to our
 * callback servlet.
 */
public class MyOneAllConnectionTest
{
    public static void main(String[] args) throws Exception
    {
        MyOneAllConnectionRequest req;
        req = new MyOneAllConnectionRequest();
        req.setConnectionToken("05827af7-a26a-4753-9372-5d28c33d350c");

        MyOneAllConnectionResponse res;
        res = req.submit();

        System.out.println("Ok:         " + res.isOk());
        System.out.println("Status:     " + res.getStatusCode());
        System.out.println("Message:    " + res.getStatusMessage());

        if ( res.isOk() )
        {
            System.out.println("Token:      " + res.getUserToken());
            System.out.println("Name:       " + res.getUserName());
            System.out.println("Email       " + res.getVerifiedEmails().join());
        }
    }
}
