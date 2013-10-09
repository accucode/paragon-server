package sandbox.wlove.stf;

import com.kodemore.collection.KmList;
import com.kodemore.file.KmFile;
import com.kodemore.file.KmFileRoot;
import com.kodemore.stf.KmStfElement;
import com.kodemore.stf.KmStfRoot;
import com.kodemore.utility.Kmu;
import com.kodemore.xml.KmXmlDocument;
import com.kodemore.xml.KmXmlElement;
import com.kodemore.xml.KmXmlParser;

public class JkStfSetupConverter
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        Kmu.fatal("disabled");

        new JkStfSetupConverter().run();
    }

    //##################################################
    //# variables
    //##################################################

    private KmXmlElement _inRoot;
    private KmStfRoot    _outRoot;

    //##################################################
    //# run
    //##################################################

    public void run()
    {
// todo_wyatt
        String dir = "c:/projects/paragon/web/WEB-INF/resource/generator/templates";
        KmFile root = new KmFileRoot(dir).getFolder();

        KmList<KmFile> folders = root.getFolders();
        for ( KmFile folder : folders )
        {
            KmFile file = folder.getChild("_setup.xml");
            runFile(file);
        }

        System.out.println("ok");
    }

    public void runFile(KmFile inFile)
    {
        System.out.println(inFile + "...");

        String xml;
        xml = inFile.readString();
        xml = Kmu.removePrefix(xml, "<!DOCTYPE model SYSTEM \"../model.dtd\">");

        KmXmlDocument doc;
        doc = KmXmlParser.parse(xml);

        _inRoot = doc.getRoot();
        _outRoot = new KmStfRoot();

        parseSetups();

        KmFile outFile;
        outFile = inFile.getSiblingWithExtension("stf");
        outFile.write(_outRoot.formatTree());
    }

    private void parseSetups()
    {
        KmList<KmXmlElement> inChildren = _inRoot.getChildElements("setup");
        for ( KmXmlElement in : inChildren )
        {
            KmStfElement out = _outRoot.addChild("setup");
            parseSimpleAttrs(out, in);
        }
    }

    private void parseSimpleAttrs(KmStfElement out, KmXmlElement in)
    {
        KmList<KmXmlElement> inChildren = in.getChildElements();
        for ( KmXmlElement inChild : inChildren )
            parseSimpleAttr(out, inChild);
    }

    private void parseSimpleAttr(KmStfElement out, KmXmlElement in)
    {
        String value;
        value = in.collectText();
        value = Kmu.collapseWhitespace(value);

        if ( value != null )
            out.addAttribute(in.getTag(), value);
    }

}
