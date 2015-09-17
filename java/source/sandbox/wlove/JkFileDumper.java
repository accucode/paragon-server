package sandbox.wlove;

import java.io.BufferedReader;
import java.io.FileReader;

import com.kodemore.utility.Kmu;

public class JkFileDumper
{
    public static void main(String[] args)
    {
        String inFile = "c:/temp/full.sql";
        new JkFileDumper().run(inFile);
    }

    public void run(String inFile)
    {
        int lines = 0;

        BufferedReader in = null;
        try
        {
            in = new BufferedReader(new FileReader(inFile));
            String line = null;
            while ( true )
            {
                String s = in.readLine();
                if ( s == null )
                    break;

                line = s;
                lines++;
                if ( lines % 100 == 0 )
                    System.out.println("line: " + lines);
            }

            System.out.println("lines: " + lines);
            System.out.println(line);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
        finally
        {
            Kmu.closeSafely(in);
        }
    }
}
