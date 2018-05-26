package com.app.tools;

import com.kodemore.utility.KmFiles;
import com.kodemore.utility.Kmu;

import com.app.utility.MyLog4jManager;

/**
 * Fix the line ending for the specified file.
 *
 * EXTERNAL TOOL. Classes in the tools package are intended for
 * use by external tools such as ant script. Additional care is
 * needed before renaming or moving them.
 */
public class MyLineEndingFixer
{
    //##################################################
    //# run
    //##################################################

    public static void main(String... args)
    {
        System.out.println("Line ending fixer...");
        MyLog4jManager.installConsole();

        if ( args == null || args.length == 0 )
        {
            System.err.println("No files specified.");
            return;
        }

        for ( String e : args )
            fix(e);

        System.out.println("done.");
    }

    private static void fix(String path)
    {
        try
        {
            System.out.println("fixing: " + path);
            String in = KmFiles.readString(path);
            String out = Kmu.normalizeLineEnds(in, "\r\n");
            KmFiles.writeString(path, out);
        }
        catch ( Exception ex )
        {
            System.err.println("Error: " + ex.getMessage());
        }
    }
}
