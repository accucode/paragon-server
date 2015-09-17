package sandbox.wlove;

import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.kodemore.collection.KmList;
import com.kodemore.xml.utility.KmXmlWrapper;

public class JkXmlTransformer
{
    public static void main(String[] args) throws Exception
    {
        new JkXmlTransformer().run();
    }

    private void run() throws Exception
    {
        String path = "c:/temp/test1.xml";
        // String prefix = "<!DOCTYPE model SYSTEM \"../model.dtd\">";

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document doc = builder.parse(path);

        KmXmlWrapper wDoc = new KmXmlWrapper(doc);
        KmList<KmXmlWrapper> v = wDoc.getNodesAt("enum.enumValue");

        Node c = v.get(2).getNode();
        Node p = c.getParentNode();
        p.removeChild(c);

        // add attribute
        //        Node earth = doc.getFirstChild();
        //        NamedNodeMap earthAttributes = earth.getAttributes();
        //        Attr galaxy = doc.createAttribute("galaxy");
        //        galaxy.setValue("milky way");
        //        earthAttributes.setNamedItem(galaxy);

        // add child tag
        //        Node canada = doc.createElement("country");
        //        canada.setTextContent("ca");
        //        earth.appendChild(canada);

        // write result
        String xml = composeXml(doc);
        System.out.println(xml);
    }

    private String composeXml(Document doc) throws Exception
    {
        try (StringWriter out = new StringWriter())
        {
            Transformer transformer;
            transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            StreamResult result = new StreamResult(out);
            DOMSource source = new DOMSource(doc);
            transformer.transform(source, result);

            return out.toString();
        }
    }
}
