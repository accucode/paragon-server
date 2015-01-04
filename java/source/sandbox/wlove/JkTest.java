package sandbox.wlove;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JkTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        JkTest.test();
    }

    private static void test()
    {
        String file = "/temp/temp.txt";

        try ( FileReader fr = new FileReader(file) )
        {
            b(fr);
        }
        catch ( IOException ex )
        {
            ex.printStackTrace();
        }
    }

    private static void b(FileReader fr) throws IOException
    {
        try ( BufferedReader br = new BufferedReader(fr) )
        {
            while ( true )
            {
                int i = br.read();
                if ( i < 0 )
                    break;

                System.out.print((char)i);
            }
            System.out.println();
            br.close();
        }
    }
}
