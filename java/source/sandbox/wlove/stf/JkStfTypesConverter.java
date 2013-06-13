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

/**
 * I am used to convert the old types.xml to the new types.stf.
 * That is to convert the model types from xml to stf format.
 */
public class JkStfTypesConverter
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        Kmu.fatal("disabled");

        new JkStfTypesConverter().run();
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
        _outRoot = new KmStfRoot();

        KmFile inFile = getFile("types.xml");

        String xml = inFile.readString();
        KmXmlDocument doc = KmXmlParser.parse(xml);
        _inRoot = doc.getRoot();

        parseTypes();

        KmFile outFile;
        outFile = getFile("types.stf");
        outFile.write(_outRoot.formatTree());

        System.out.println("ok.");
    }

    private void parseTypes()
    {
        KmList<KmXmlElement> inTypes;
        inTypes = _inRoot.getChildElements("type");

        for ( KmXmlElement inType : inTypes )
            parseType(inType);
    }

    private void parseType(KmXmlElement inType)
    {
        KmStfElement outType;
        outType = _outRoot.addChild();
        outType.setName("type");

        KmList<KmXmlElement> inAttrs;

        inAttrs = inType.getChildElements();
        for ( KmXmlElement inAttr : inAttrs )
            if ( !inAttr.hasTag("format") )
                parseAttribute(outType, inAttr);

        inAttrs = inType.getChildElement("format").getChildElements();
        for ( KmXmlElement inAttr : inAttrs )
            parseAttribute(outType, inAttr);
    }

    private void parseAttribute(KmStfElement stf, KmXmlElement xml)
    {
        String value;
        value = xml.collectText();
        value = Kmu.collapseWhitespace(value);

        if ( value != null )
            stf.addAttribute(xml.getTag(), value);
    }

    private KmFile getFile(String name)
    {
        return getFileRoot().getChild(name);
    }

    private KmFileRoot getFileRoot()
    {
        String dir = "c:/projects/paragon/web/WEB-INF/resource/generator/config";
        return new KmFileRoot(dir);
    }

}
