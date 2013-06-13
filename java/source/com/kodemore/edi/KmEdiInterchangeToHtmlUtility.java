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
        KmEdiInterchange e = (KmEdiInterchange)KmEdiInterchangeParser.parseReader(name, reader);
        return toHtml(name, e);
    }

    public static String parseSourceToHtml(String name, String source)
    {
        KmEdiInterchange e = (KmEdiInterchange)KmEdiInterchangeParser.parseSource(name, source);
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
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("<html>");

        sb.append("<head>");
        sb.append("<title>");
        sb.append(name);
        sb.append("</title>");
        sb.append("</head>");

        sb.append("<body>");
        for ( KmEdiSegment s : e.getSegments() )
        {
            sb.append(s.format());
            sb.append("<br>");
        }
        sb.append("</body>");

        sb.append("</html>");
        return sb.toString();
    }
}
