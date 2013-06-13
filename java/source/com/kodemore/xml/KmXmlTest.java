/*
  Copyright (c) 2005-2011 www.kodemore.com

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in
  all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  THE SOFTWARE.
*/

package com.kodemore.xml;

import java.io.ByteArrayInputStream;
import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import com.kodemore.utility.Kmu;
import com.kodemore.xml.utility.KmXmlBuilder;

public class KmXmlTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        new KmXmlTest().run();
    }

    //##################################################
    //# run
    //##################################################

    public void run()
    {
        //        String xml = getSample_02();
        //        System.out.println(xml);
        //
        //        Document doc = parseXml(xml);
        //        printTree(doc);

        testValidate();
    }

    //##################################################
    //# stuff
    //##################################################

    public void printTree(Node p)
    {
        printTree(p, 0);
    }

    public void printTree(Node p, int indent)
    {
        String s = null;
        if ( p.getNodeType() == Node.ELEMENT_NODE )
        {
            Element x = (Element)p;
            s = x.getTagName();
        }

        if ( p.getNodeType() == Node.TEXT_NODE )
        {
            Text x = (Text)p;
            s = quote(x.getData());
        }

        if ( p.getNodeType() == Node.CDATA_SECTION_NODE )
        {
            CDATASection x = (CDATASection)p;
            s = quote(x.getData());
        }

        if ( p.getNodeType() == Node.ATTRIBUTE_NODE )
        {
            Attr x = (Attr)p;
            s = x.getName() + " = " + quote(x.getValue());
        }

        String line = formatNodeType(p);
        if ( Kmu.hasValue(s) )
            line += ": " + s;
        println(line, indent);

        printAttributes(p, indent + 1);

        if ( p.getNodeType() != Node.ATTRIBUTE_NODE )
            printChildren(p, indent + 1);
    }

    public void printChildren(Node p, int indent)
    {
        NodeList v = p.getChildNodes();
        int n = v.getLength();
        for ( int i = 0; i < n; i++ )
        {
            Node e = v.item(i);
            printTree(e, indent);
        }
    }

    public void printAttributes(Node p, int indent)
    {
        NamedNodeMap v = p.getAttributes();
        if ( v == null )
            return;
        int n = v.getLength();
        if ( n == 0 )
            return;
        for ( int i = 0; i < n; i++ )
        {
            Node e = v.item(i);
            printTree(e, indent);
        }
    }

    public void println(Object e, int indent)
    {
        indent(indent);
        System.out.println(e);
    }

    public void indent(int n)
    {
        for ( int i = 0; i < n; i++ )
            System.out.print("  ");
    }

    public String formatNodeType(Node x)
    {
        switch ( x.getNodeType() )
        {
            case Node.ELEMENT_NODE:
                return "Element";
            case Node.ATTRIBUTE_NODE:
                return "Attribute";
            case Node.TEXT_NODE:
                return "Text";
            case Node.CDATA_SECTION_NODE:
                return "CDATA";
            case Node.ENTITY_REFERENCE_NODE:
                return "Entity Ref";
            case Node.ENTITY_NODE:
                return "Entity";
            case Node.PROCESSING_INSTRUCTION_NODE:
                return "Instruction";
            case Node.COMMENT_NODE:
                return "Comment";
            case Node.DOCUMENT_NODE:
                return "Document";
            case Node.DOCUMENT_TYPE_NODE:
                return "Document Type";
            case Node.DOCUMENT_FRAGMENT_NODE:
                return "Fragment";
            case Node.NOTATION_NODE:
                return "Notation";
        }
        return "UNKNOWN";
    }

    public String getSample_01()
    {
        KmXmlBuilder xml = new KmXmlBuilder();
        xml.begin("root");
        xml.value("name", "John");
        xml.begin("address");
        xml.value("street", "1 North Ave");
        xml.value("city", "Somewhere");
        xml.value("state", "CA");
        xml.value("zip", "95926");
        xml.end();
        xml.value("phone", "303-555-1234");
        xml.value("phone", "999-555-8888");
        xml.value("date", "1/29/05");
        xml.end();
        return xml.toString();
    }

    public String getSample_02()
    {
        return ""
            + "\n<root>"
            + "\n  <a>aaa</a>"
            + "\n  <b>"
            + "\n    bbb"
            + "\n  </b>"
            + "\n  <![CDATA[cdata... Embedded <xml> tags. Line \r\n feeds.  Escaped &lt; &gr; chars.]]>"
            + "\n  <c x='1' y='&amp;2\n' z='3&lt;'/>"
            + "\n</root>"
            + "\n";
    }

    public Document parseXml(String xml)
    {
        try
        {
            ByteArrayInputStream is = new ByteArrayInputStream(xml.getBytes());
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            return db.parse(is);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void testValidate()
    {
        try
        {
            String xmlFile = Kmu.getHardcodedPath("/temp/xml/person.xml");
            String xsdFile = Kmu.getHardcodedPath("/temp/xml/person.xsd");

            System.out.println("parsing xml...");
            String xml = Kmu.readTextFile(xmlFile);
            Document doc = parseXml(xml);
            DOMSource ds = new DOMSource(doc);

            System.out.println("parsing xsd...");
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema s = sf.newSchema(new File(xsdFile));

            System.out.println("validating...");
            Validator v = s.newValidator();
            v.validate(ds);
        }
        catch ( Exception ex )
        {
            ex.printStackTrace();
        }
    }

    public String quote(String s)
    {
        return "'" + escape(s) + "'";
    }

    public String escape(String s)
    {
        s = Kmu.replaceAll(s, "\n", "\\n");
        s = Kmu.replaceAll(s, "\r", "\\r");
        s = Kmu.replaceAll(s, "\t", "\\t");
        return s;
    }

}
