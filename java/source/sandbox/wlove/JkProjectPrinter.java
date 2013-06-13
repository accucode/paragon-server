package sandbox.wlove;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.kodemore.file.KmFile;
import com.kodemore.file.KmFileTraverser;
import com.kodemore.utility.Kmu;

public class JkProjectPrinter
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        new JkProjectPrinter().run();
    }

    //##################################################
    //# variables
    //##################################################

    private char           FORM_FEED = 12;
    private BufferedWriter _out;

    //##################################################
    //# run
    //##################################################

    private void run()
    {
        String outPath = "c:/temp/out.txt";
        String javaPath = "c:/projects/kodemore/java/source/com/app";
        try
        {
            _out = new BufferedWriter(new FileWriter(outPath));

            KmFileTraverser e;
            e = newFileTraverser();
            e.processAll(javaPath);

            _out.flush();
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
        finally
        {
            Kmu.closeSafely(_out);
        }
    }

    private KmFileTraverser newFileTraverser()
    {
        return new KmFileTraverser()
        {
            @Override
            protected void processFile(KmFile f)
            {
                try
                {
                    if ( !f.hasExtension("java") )
                        return;

                    System.out.println(f.getName());

                    _out.write(f.readString());
                    _out.write(FORM_FEED);
                }
                catch ( IOException ex )
                {
                    throw Kmu.toRuntime(ex);
                }
            }
        };
    }

}
