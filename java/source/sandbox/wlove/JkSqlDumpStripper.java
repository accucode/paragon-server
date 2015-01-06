package sandbox.wlove;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.kodemore.utility.Kmu;

public class JkSqlDumpStripper
{
    public static void main(String[] args)
    {
        new JkSqlDumpStripper().run();
    }

    public void run()
    {
        String database = "service";
        String inFile = "/temp/dump/dump.2010-04-16-020001.sql";
        String outFile = "/temp/dump/dump.sql";

        String sectionPrefix = "-- Current Database:";
        String sectionMatch = Kmu.format("%s `%s`", sectionPrefix, database);

        boolean echo = false;
        int lines = 0;

        try ( BufferedReader in = new BufferedReader(new FileReader(inFile));
            BufferedWriter out = new BufferedWriter(new FileWriter(outFile)) )
        {

            while ( true )
            {
                String line = in.readLine();
                if ( line == null )
                    break;

                lines++;
                if ( lines % 100 == 0 )
                    System.out.println("line: " + lines);

                if ( line.startsWith(sectionPrefix) )
                {
                    echo = line.equals(sectionMatch);
                    System.out.printf("%s [%s]%n", line, echo);
                }

                if ( echo )
                {
                    out.write(line);
                    out.newLine();
                }
            }

            out.flush();
            System.out.println("lines: " + lines);
            System.out.println("ok.");
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }
}
