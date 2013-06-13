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

public class JkStfModelConverter
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        Kmu.fatal("disabled");

        new JkStfModelConverter().run();
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
        KmList<KmFile> v = getFileRoot().getFolder().getFilesWithExtension("xml");
        for ( KmFile e : v )
            runFile(e);

        System.out.println("ok");
    }

    public void runFile(KmFile inFile)
    {
        System.out.println(inFile.toString() + "...");

        String xml;
        xml = inFile.readString();
        xml = Kmu.removePrefix(xml, "<!DOCTYPE model SYSTEM \"../model.dtd\">");

        KmXmlDocument doc;
        doc = KmXmlParser.parse(xml);

        _inRoot = doc.getRoot();
        _outRoot = new KmStfRoot();

        parseModel();
        parseDatabase();
        parseAttributes();

        KmFile outFile;
        outFile = inFile.getSiblingWithExtension("stf");
        outFile.write(_outRoot.formatTree());
    }

    private void parseModel()
    {
        KmXmlElement inRoot = _inRoot;
        KmStfElement outRoot = _outRoot;

        KmStfElement out;
        out = outRoot.addChild();
        out.setName("model");
        out.addAttribute("name", inRoot.getAttribute("name"));

        parseSimpleAttr(out, inRoot.getChildElement("comment"));
    }

    private void parseDatabase()
    {
        KmXmlElement in;
        in = _inRoot.getChildElement("database");

        if ( in == null )
            return;

        KmStfElement out;
        out = _outRoot.addChild();
        out.setName("database");

        parseSimpleAttr(out, in.getChildElement("alias"));

        KmList<KmXmlElement> children = in.getElementsAt("indexes/index");
        for ( KmXmlElement inChild : children )
            parseIndex(out, inChild);
    }

    private void parseIndex(KmStfElement out, KmXmlElement inChild)
    {
        KmStfElement outChild;
        outChild = out.addChild();
        outChild.setName("index");

        KmList<KmXmlElement> attrs = inChild.getChildElements();
        for ( KmXmlElement attr : attrs )
            parseSimpleAttr(outChild, attr);
    }

    private void parseAttributes()
    {
        KmStfElement out;
        out = _outRoot.addChild();
        out.setName("attributes");

        parseFields(out);
        parseAssociations(out);
    }

    private void parseFields(KmStfElement out)
    {
        KmList<KmXmlElement> inList;
        inList = _inRoot.getElementsAt("attributes/field");
        for ( KmXmlElement in : inList )
            parseField(out, in);

        inList = _inRoot.getElementsAt("attributes/abstractField");
        for ( KmXmlElement in : inList )
            parseField(out, in);
    }

    private void parseField(KmStfElement outParent, KmXmlElement in)
    {
        KmStfElement out;
        out = outParent.addChild();
        out.setName(in.getTag());
        out.addAttribute("name", in.getAttribute("name"));

        KmList<KmXmlElement> inChildren = in.getChildElements();
        for ( KmXmlElement inChild : inChildren )
        {
            if ( inChild.hasTag("format") )
            {
                parseSimpleAttr(out, inChild.getChildElement("type"));
                continue;
            }

            if ( inChild.hasTag("enum") )
            {
                KmStfElement outEnum = out.addChild("enum");

                KmList<KmXmlElement> inValues = inChild.getChildElements("enumValue");
                for ( KmXmlElement inValue : inValues )
                {
                    String code = inValue.getAttribute("code");
                    String name = inValue.getAttribute("name");

                    KmStfElement outValue;
                    outValue = outEnum.addChild();
                    outValue.setName("option");
                    outValue.addAttribute("code", code);
                    outValue.addAttribute("name", name);
                }

                continue;
            }

            parseSimpleAttr(out, inChild);
        }
    }

    private void parseAssociations(KmStfElement out)
    {
        KmList<KmXmlElement> inList;

        inList = _inRoot.getElementsAt("attributes/association");
        for ( KmXmlElement in : inList )
            parseAssociation(out, in);

        inList = _inRoot.getElementsAt("attributes/abstractAssociation");
        for ( KmXmlElement in : inList )
            parseAssociation(out, in);
    }

    private void parseAssociation(KmStfElement outParent, KmXmlElement in)
    {
        KmStfElement out;
        out = outParent.addChild();
        out.setName(in.getTag());
        out.addAttribute("name", in.getAttribute("name"));

        KmList<KmXmlElement> inChildren = in.getChildElements();
        for ( KmXmlElement inChild : inChildren )
        {
            if ( inChild.hasTag("delegates") )
            {
                KmList<KmXmlElement> inDelegates = inChild.getChildElements("delegate");
                for ( KmXmlElement inDelegate : inDelegates )
                {
                    KmStfElement outDelegate = out.addChild("delegate");
                    parseSimpleAttrs(outDelegate, inDelegate);
                }

                continue;
            }

            parseSimpleAttr(out, inChild);
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

    private KmFileRoot getFileRoot()
    {
        String dir = "c:/projects/paragon/web/WEB-INF/resource/generator/config/model/data";
        return new KmFileRoot(dir);
    }

}
