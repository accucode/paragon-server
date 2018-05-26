package com.app.tools;

import com.kodemore.collection.KmList;
import com.kodemore.file.KmFile;
import com.kodemore.file.KmFileRoot;
import com.kodemore.utility.Kmu;

import com.app.utility.MyEnvironment;

public class MyTestHtmlFormatter
{
    //##################################################
    //# constants
    //##################################################

    private static final String HTML_EXTENSION   = "html";
    private static final String HTML_TEST_FOLDER = "test";

    private static final String STANDARD_HEADER_FILE = "testStandardHeader.html";

    private static final String BEGIN_STANDARD_HEADER = "<!-- BEGIN_STANDARD_HEADER -->";
    private static final String END_STANDARD_HEADER   = "<!-- END_STANDARD_HEADER -->";

    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        MyEnvironment.install();

        String webRoot = MyEnvironment.getWebRoot();
        String rootPath = Kmu.joinFilePath(webRoot, HTML_TEST_FOLDER);

        KmFile folder = new KmFileRoot(rootPath).getFolder();
        KmList<KmFile> tests = folder.getChildren();

        System.out.println("Formatting Tests");

        for ( KmFile e : tests )
            if ( e.hasExtension(HTML_EXTENSION) )
            {
                System.out.print(e.getName() + "... ");

                String s = e.readString();

                int begin = s.indexOf(BEGIN_STANDARD_HEADER);
                int end = s.indexOf(END_STANDARD_HEADER);

                if ( begin < 0 && end < 0 )
                {
                    System.out.println("No Tags - Skipping");
                    continue;
                }

                if ( begin < 0 )
                {
                    System.out.println("Missing Begin Tag - Skipping");
                    continue;
                }

                if ( end < 0 )
                {
                    System.out.println("Missing End Tag - Skipping");
                    continue;
                }

                if ( begin > end )
                {
                    System.out.println("Tags Out Of Order - Skipping");
                    continue;
                }

                String header = folder.getChild(STANDARD_HEADER_FILE).readString();

                s = Kmu.replaceSectionsBetween(
                    s,
                    BEGIN_STANDARD_HEADER,
                    END_STANDARD_HEADER,
                    header);

                e.write(s);

                System.out.println("ok");
            }

        System.out.println("Done");
    }
}
