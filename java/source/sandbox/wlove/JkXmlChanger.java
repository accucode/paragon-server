package sandbox.wlove;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

import com.kodemore.collection.KmList;
import com.kodemore.utility.KmSystemProperties;
import com.kodemore.utility.Kmu;
import com.kodemore.xml.KmXmlDocument;
import com.kodemore.xml.KmXmlElement;
import com.kodemore.xml.KmXmlParser;

public class JkXmlChanger
{
    public static void main(String[] args)
    {
        String path = Kmu.getHardcodedPath("/projects/service/resource/generator/config/model/data");
        File dir = new File(path);

        KmList<File> v = Kmu.getFiles(dir, null, ".xml");
        for ( File e : v )
            fixFile(e);
    }

    private static void fixFile(File file)
    {
        String doctype = "<!DOCTYPE model SYSTEM \"../model.dtd\">";

        String source = Kmu.readFileString(file);
        String xml = Kmu.removePrefix(source, doctype).trim();

        KmXmlDocument doc = KmXmlParser.parse(xml);
        KmXmlElement root = doc.getRoot();

        if ( !fixRoot(root) )
            return;

        StringWriter out = new StringWriter();
        PrintWriter pw = new PrintWriter(out);

        pw.println(doctype);
        doc.prettyPrintOn(pw);
        pw.close();

        String eol = KmSystemProperties.getLineSeparator();
        String result = out.toString().trim() + eol;

        Kmu.writeFile(file, result);
        System.out.println("File: " + file);
    }

    private static boolean fixRoot(KmXmlElement root)
    {
        boolean changed = false;
        KmList<KmXmlElement> v = root.getElementsAt("attributes/abstractAssociation");
        for ( KmXmlElement e : v )
        {
            KmXmlElement cascade = e.getElementAt("cascade");
            if ( cascade != null )
            {
                e.removeChild(cascade);
                changed = true;
            }
        }
        return changed;
    }

}
