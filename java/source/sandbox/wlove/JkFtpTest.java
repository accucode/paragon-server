package sandbox.wlove;

import com.kodemore.ftp.KmFtpClient;

public class JkFtpTest
{
    public static void main(String[] args)
    {
        new JkFtpTest().run();
    }

    private void run()
    {
        KmFtpClient c;
        c = new KmFtpClient();

        System.out.println();
        System.out.println("connect...");
        // System.out.println(c.connect("ftp.drivehq.com", "wyattlove", "terrible"));
        System.out.println(c.connect("stagingftp.ryzex.com", "accucode", "zse45rdxcft6"));

        System.out.println();
        System.out.println("put a.txt...");
        System.out.println(c.putTextFile("/from_accucode/a.txt", "12345"));

        //        System.out.println();
        //        System.out.println("rename a.txt -> z.txt...");
        //        System.out.println(c.renameFile("a.txt", "z.txt"));
        //
        //        System.out.println();
        //        System.out.println("read z.txt...");
        //        System.out.println(c.getTextFile("z.txt"));
        //
        //        System.out.println();
        //        System.out.println("delete z.txt...");
        //        System.out.println(c.deleteFile("z.txt"));

        System.out.println();
        System.out.println("quit...");
        System.out.println(c.quit());
    }

}
