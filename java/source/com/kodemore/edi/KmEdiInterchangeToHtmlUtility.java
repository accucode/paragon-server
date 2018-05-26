package com.kodemore.edi;

import java.io.Reader;

public class KmEdiInterchangeToHtmlUtility
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        if ( args.length != 1 )
        {
            System.out.println("Please specify an edi interchange file to parse.");
            return;
        }

        String path = args[0];
        String s = parseFileToHtml(path, path);
        System.out.println(s);
    }

    //##################################################
    //# static (public)
    //##################################################

    public static String parseReaderToHtml(String name, Reader reader)
    {
        KmEdiInterchange e = KmEdiInterchangeParser.parseReader(name, reader);
        return toHtml(name, e);
    }

    public static String parseSourceToHtml(String name, String source)
    {
        KmEdiInterchange e = KmEdiInterchangeParser.parseSource(name, source);
        return toHtml(name, e);
    }

    public static String parseFileToHtml(String name, String path)
    {
        KmEdiInterchange e = KmEdiInterchangeParser.parseFile(path);
        return toHtml(name, e);
    }

    //##################################################
    //# static (private);
    //##################################################

    private static String toHtml(String name, KmEdiInterchange e)
    {
        StringBuilder out;
        out = new StringBuilder();
        out.append("<html>");

        out.append("<head>");
        out.append("<title>");
        out.append(name);
        out.append("</title>");
        out.append("</head>");

        out.append("<body>");
        for ( KmEdiSegment s : e.getSegments() )
        {
            out.append(s.format());
            out.append("<br>");
        }
        out.append("</body>");

        out.append("</html>");
        return out.toString();
    }
}
