package sandbox.wlove;

public class JkLinkedInTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        new JkLinkedInTest().run();
    }

    //##################################################
    //# run
    //##################################################

    private void run()
    {
        //        review_steve linked in
        //  here is the linked in
        //  https://www.linkedin.com/uas/oauth2/authorization?response_type=code&client_id=kz8cwa83lhh3&state=accucodeState&redirect_uri=https://sites.google.com/site/kodemore/
        //  got this back
        //  https://sites.google.com/site/kodemore/?code=AQRe3kcZZD7I6FAIu4f1zaRyiCC6gY1Bwy0O9BWTKS6HXuTQ7Z63y-UXNO4fEr6iIv-A3iY60U3OHl3f2Y9NoAmW3BLOJ6MAsg_VVJ7Bdq8ghzPp5_8&state=accucodeState
        //
        //  code = AQRe3kcZZD7I6FAIu4f1zaRyiCC6gY1Bwy0O9BWTKS6HXuTQ7Z63y-UXNO4fEr6iIv-A3iY60U3OHl3f2Y9NoAmW3BLOJ6MAsg_VVJ7Bdq8ghzPp5_8
        //  state = accucodeState
        //
        //  well this really didn't work but it should have
        //  https://www.linkedin.com/uas/oauth2/accessToken?grant_type=authorization_code&code=AQRe3kcZZD7I6FAIu4f1zaRyiCC6gY1Bwy0O9BWTKS6HXuTQ7Z63y-UXNO4fEr6iIv-A3iY60U3OHl3f2Y9NoAmW3BLOJ6MAsg_VVJ7Bdq8ghzPp5_8&redirect_uri=https://sites.google.com/site/kodemore/&client_id=kz8cwa83lhh3&client_secret=sB9dXH8YU2tx4NWK
    }
}
