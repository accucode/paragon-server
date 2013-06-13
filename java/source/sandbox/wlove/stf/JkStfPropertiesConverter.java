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

public class JkStfPropertiesConverter
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        Kmu.fatal("disabled");

        new JkStfPropertiesConverter().run();
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
        KmFile inFile = getFile("properties.xml");
        String xml = inFile.readString();
        KmXmlDocument doc = KmXmlParser.parse(xml);
        _inRoot = doc.getRoot();

        _outRoot = new KmStfRoot();

        parseGroups();

        KmFile outFile;
        outFile = getFile("properties.stf");
        outFile.write(_outRoot.formatTree());

        System.out.println("ok.");
    }

    private void parseGroups()
    {
        KmList<KmXmlElement> inGroups;
        inGroups = _inRoot.getChildElements("group");

        for ( KmXmlElement inGroup : inGroups )
            parseGroup(inGroup);

    }

    private void parseGroup(KmXmlElement inGroup)
    {
        KmStfElement outGroup;
        outGroup = _outRoot.addChild();
        outGroup.setName("group");

        KmList<KmXmlElement> inAttrs;
        inAttrs = inGroup.getChildElements();

        for ( KmXmlElement inAttr : inAttrs )
            if ( !inAttr.hasTag("property") )
                parseAttribute(outGroup, inAttr);

        KmList<KmXmlElement> inProps;
        inProps = inGroup.getChildElements("property");
        for ( KmXmlElement inProp : inProps )
        {
            KmStfElement outProp;
            outProp = outGroup.addChild();
            outProp.setName("property");

            inAttrs = inProp.getChildElements();
            for ( KmXmlElement inAttr : inAttrs )
                parseAttribute(outProp, inAttr);
        }
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
