/*
  Copyright (c) 2005-2014 www.kodemore.com

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

package com.kodemore.xml.utility;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.kodemore.collection.KmList;
import com.kodemore.string.KmString;
import com.kodemore.utility.Kmu;

/**
 * I am a collection of various methods that are useful
 * in a variety of situations. This class should generally not
 * have any dependencies on other packages.
 */
public class KmXmlWrapper
{
    //##################################################
    //# instance creation
    //##################################################

    public static KmXmlWrapper parseFile(File f)
    {
        return parseFile(f.getPath());
    }

    public static KmXmlWrapper parseFile(String path)
    {
        try
        {
            String xml = Kmu.readFileString(path);
            return parseXml(xml);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public static KmXmlWrapper parseXml(String xml)
    {
        try
        {
            ByteArrayInputStream in = new ByteArrayInputStream(xml.getBytes());
            DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
            DocumentBuilder b = f.newDocumentBuilder();
            Document d = b.parse(in);
            return new KmXmlWrapper(d);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    //##################################################
    //# variables
    //##################################################

    private Node _node;

    //##################################################
    //# constructor
    //##################################################

    public KmXmlWrapper(Node e)
    {
        _node = e;
    }

    //##################################################
    //# accessing
    //##################################################

    public Node getNode()
    {
        return _node;
    }

    public void setNode(Node e)
    {
        _node = e;
    }

    //##################################################
    //# abstract accessing
    //##################################################

    public KmXmlWrapper getParent()
    {
        return new KmXmlWrapper(_node.getParentNode());
    }

    public KmList<KmXmlWrapper> getChildrenNodes()
    {
        KmList<KmXmlWrapper> v = new KmList<>();
        NodeList nl = _node.getChildNodes();
        int n = nl.getLength();
        for ( int i = 0; i < n; i++ )
        {
            Node c = nl.item(i);
            KmXmlWrapper e = new KmXmlWrapper(c);
            v.add(e);
        }
        return v;
    }

    public Document getDocument()
    {
        Node n = _node;
        while ( true )
        {
            if ( n instanceof Document )
                return (Document)n;

            n = n.getParentNode();
            if ( n == null )
                return null;
        }
    }

    public KmXmlWrapper getDocumentElementNode()
    {
        Document d = getDocument();
        if ( d == null )
            return null;

        Node e = d.getDocumentElement();
        return new KmXmlWrapper(e);
    }

    //##################################################
    //# testing
    //##################################################

    public boolean isDocument()
    {
        return isType(Node.DOCUMENT_TYPE_NODE);
    }

    public boolean isElement()
    {
        return isType(Node.ELEMENT_NODE);
    }

    public String getTag()
    {
        if ( isElement() )
            return ((Element)_node).getTagName();
        return null;
    }

    public boolean isType(short type)
    {
        return _node.getNodeType() == type;
    }

    public boolean hasChildElements()
    {
        return hasChildWithType(Node.ELEMENT_NODE);
    }

    public boolean hasChildWithType(short type)
    {
        NodeList v = _node.getChildNodes();
        int n = v.getLength();
        for ( int i = 0; i < n; i++ )
        {
            Node c = v.item(i);
            if ( c.getNodeType() == type )
                return true;
        }
        return false;
    }

    public KmList<Element> getChildElements()
    {
        KmList<Element> v = new KmList<>();
        NodeList children = _node.getChildNodes();
        int n = children.getLength();
        for ( int i = 0; i < n; i++ )
        {
            Node c = children.item(i);
            if ( c.getNodeType() == Node.ELEMENT_NODE )
                v.add((Element)c);
        }
        return v;
    }

    private KmList<Element> getChildElements(Node parent, String tag)
    {
        KmList<Element> v = new KmList<>();
        NodeList children = parent.getChildNodes();
        int n = children.getLength();
        for ( int i = 0; i < n; i++ )
        {
            Node c = children.item(i);
            if ( c.getNodeType() == Node.ELEMENT_NODE )
            {
                Element e = (Element)c;
                if ( e.getTagName().equals(tag) )
                    v.add(e);
            }
        }
        return v;
    }

    //##################################################
    //# string at path
    //##################################################

    public String getStringAt(String path)
    {
        return getStringAt(_getList(path));
    }

    public String getStringAt(List<String> path)
    {
        return getStringsAt(path).getFirstSafe();
    }

    public KmList<String> getStringsAt(String path)
    {
        return getStringsAt(_getList(path));
    }

    public KmList<String> getStringsAt(List<String> path)
    {
        KmList<String> v = new KmList<>();
        Iterator<KmXmlWrapper> i = getNodesAt(path).iterator();
        while ( i.hasNext() )
        {
            KmXmlWrapper e = i.next();
            v.add(e.getTextContent());
        }
        return v;
    }

    //##################################################
    //# value at path
    //##################################################

    public KmString getValueAt(String path)
    {
        return getValueAt(_getList(path));
    }

    public KmString getValueAt(List<String> path)
    {
        KmList<KmString> v = getValuesAt(path);
        if ( v.isEmpty() )
            return new KmString();
        return v.getFirst();
    }

    public KmList<KmString> getValuesAt(String path)
    {
        return getValuesAt(_getList(path));
    }

    public KmList<KmString> getValuesAt(List<String> path)
    {
        KmList<KmString> v = new KmList<>();
        Iterator<String> i = getStringsAt(path).iterator();
        while ( i.hasNext() )
        {
            String s = i.next();
            v.add(new KmString(s));
        }
        return v;
    }

    //##################################################
    //# nodes at path
    //##################################################

    public KmXmlWrapper getNodeAt(String path)
    {
        return getNodeAt(_getList(path));
    }

    public KmXmlWrapper getNodeAt(List<String> path)
    {
        return getNodesAt(path).getFirstSafe();
    }

    public KmList<KmXmlWrapper> getNodesAt(String path)
    {
        return getNodesAt(_getList(path));
    }

    public KmList<KmXmlWrapper> getNodesAt(List<String> path)
    {
        KmList<KmXmlWrapper> v = new KmList<>();
        _collectNodes(_getElement(), path, 0, v);
        return v;
    }

    public boolean hasNodeAt(String path)
    {
        return getNodeAt(path) != null;
    }

    //##################################################
    //# path
    //##################################################

    public String getPath()
    {
        StringBuilder sb = new StringBuilder();
        _collectPath(sb, _getElement());
        return sb.toString();
    }

    public boolean hasPath(String path)
    {
        return hasPath(_getList(path));
    }

    public boolean hasPath(List<String> path)
    {
        return !getNodesAt(path).isEmpty();
    }

    //##################################################
    //# display
    //##################################################

    public String getTextContent()
    {
        return _getTextContent(_node);
    }

    public String getNodeName()
    {
        return _node.getNodeName();
    }

    public String getNodeClass()
    {
        return Kmu.getSimpleClassName(_node);
    }

    public short getNodeType()
    {
        return _node.getNodeType();
    }

    public String getNodeValue()
    {
        return _node.getNodeValue();
    }

    public KmList<String> getAttributeNames()
    {
        KmList<String> v = new KmList<>();
        NamedNodeMap m = _node.getAttributes();
        if ( m != null )
        {
            int n = m.getLength();
            for ( int i = 0; i < n; i++ )
            {
                Node e = m.item(i);
                v.add(e.getNodeName());
            }
        }
        return v;
    }

    public String getAttributeValue(String name)
    {
        NamedNodeMap m = _node.getAttributes();
        if ( m == null )
            return null;

        Node n = m.getNamedItem(name);
        if ( n == null )
            return null;

        return n.getNodeValue();
    }

    //##################################################
    //# print
    //##################################################

    public void printTree()
    {
        PrintWriter out;
        out = new PrintWriter(new OutputStreamWriter(System.out));
        printTreeOn(out);
        out.flush();
        // do not close... System.out
    }

    public void printTreeOn(PrintWriter out)
    {
        printTreeOn(out, 0);
    }

    private void printTreeOn(PrintWriter out, int indent)
    {
        String s = "n: " + getNodeName() + " " + getNodeClass();
        println(out, s, indent);
        Iterator<String> is = getAttributeNames().iterator();
        while ( is.hasNext() )
        {
            String aName = is.next();
            String aValue = getAttributeValue(aName);
            String x = "a: " + aName + "=" + aValue;
            println(out, x, indent);
        }

        if ( getNodeValue() != null )
            println(out, "v: " + getNodeValue().trim(), indent);

        Iterator<KmXmlWrapper> iw = getChildrenNodes().iterator();
        while ( iw.hasNext() )
        {
            KmXmlWrapper e = iw.next();
            e.printTreeOn(out, indent + 1);
        }
    }

    private void println(PrintWriter out, Object e, int n)
    {
        for ( int i = 0; i < n; i++ )
            out.print("  ");
        out.println(e);
    }

    //##################################################
    //# pretty print
    //##################################################

    public void printPrettyXml()
    {
        PrintWriter out;
        out = new PrintWriter(new OutputStreamWriter(System.out));
        printPrettyXmlOn(out, 0);
        out.flush();
        // do not close... System.out
    }

    public String printPrettyXmlToString()
    {
        try ( StringWriter sw = new StringWriter();
            PrintWriter out = new PrintWriter(sw) )
        {
            printPrettyXmlOn(out, 0);
            return sw.toString();
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    private void printPrettyXmlOn(PrintWriter out, int indent)
    {
        if ( getNodeType() == Node.ELEMENT_NODE )
        {
            StringBuilder sb;
            sb = new StringBuilder();
            sb.append(Kmu.format("<%s", getNodeName()));
            Iterator<String> is = getAttributeNames().iterator();
            while ( is.hasNext() )
            {
                String aName = is.next();
                sb.append(Kmu.format(" %s=\"%s\"", aName, getAttributeValue(aName)));
            }
            sb.append(">");
            if ( getNodeValue() != null )
                sb.append(getNodeValue().trim());
            println(out, sb.toString(), indent);
        }

        if ( getNodeType() == Node.TEXT_NODE )
            println(out, getNodeValue(), indent);

        Iterator<KmXmlWrapper> iw = getChildrenNodes().iterator();
        while ( iw.hasNext() )
        {
            KmXmlWrapper e = iw.next();
            e.printPrettyXmlOn(out, indent + 1);
        }

        if ( getNodeType() == Node.ELEMENT_NODE )
            println(out, Kmu.format("</%s>", getNodeName()), indent);
    }

    //##################################################
    //# private
    //##################################################

    public Element _getElement()
    {
        if ( _node instanceof Element )
            return (Element)_node;

        if ( _node instanceof Document )
            return ((Document)_node).getDocumentElement();

        return null;
    }

    public List<String> _getList(String s)
    {
        return Kmu.tokenize(s, '.');
    }

    private void _collectNodes(
        Element parent,
        List<String> tagNames,
        int index,
        List<KmXmlWrapper> nodes)
    {
        String s = tagNames.get(index);
        index++;
        KmList<Element> v = getChildElements(parent, s);
        for ( Element e : v )
            if ( index == tagNames.size() )
                nodes.add(new KmXmlWrapper(e));
            else
                _collectNodes(e, tagNames, index, nodes);
    }

    /**
     * This is added for compatibility in WebSphere.
     * This implements the same functionality as Node.getTextContent().
     */
    public String _getTextContent(Node e)
    {
        switch ( e.getNodeType() )
        {
            case Node.TEXT_NODE:
            case Node.CDATA_SECTION_NODE:
            case Node.COMMENT_NODE:
            case Node.PROCESSING_INSTRUCTION_NODE:
            {
                return e.getNodeValue();
            }
            case Node.ELEMENT_NODE:
            case Node.ATTRIBUTE_NODE:
            case Node.ENTITY_NODE:
            case Node.ENTITY_REFERENCE_NODE:
            case Node.DOCUMENT_FRAGMENT_NODE:
            {
                StringBuilder sb = new StringBuilder();
                NodeList v = e.getChildNodes();
                int n = v.getLength();
                for ( int i = 0; i < n; i++ )
                {
                    Node c = v.item(i);
                    sb.append(_getTextContent(c));
                }
                return sb.toString();
            }
        }
        return null;
    }

    public void _collectPath(StringBuilder sb, Node e)
    {
        Node p = e.getParentNode();
        if ( p != null )
            _collectPath(sb, p);
        if ( e instanceof Element )
        {
            Element ee = (Element)e;
            if ( sb.length() > 0 )
                sb.append(".");
            sb.append(ee.getTagName());
        }
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        // test1();
        // test2();
        test3();
    }

    public static void test1()
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
        KmXmlWrapper e = KmXmlWrapper.parseXml(xml.toString());

        System.out.println("Name:  " + e.getStringAt("name"));
        System.out.println("City:  " + e.getStringAt("address.city"));
        System.out.println("Phone: " + e.getStringAt("phone"));
        System.out.println("Date:  " + e.getValueAt("date").asDate());

        System.out.println("Root path: " + e.getPath());
        System.out.println("City path: " + e.getNodeAt("address.city").getPath());
    }

    public static void test2()
    {
        String xsd = Kmu.getHardcodedPath("/temp/xml/person.xsd");
        String xml = Kmu.getHardcodedPath("/temp/xml/person3.xml");

        try ( FileInputStream in = new FileInputStream(xml) )
        {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document d = db.parse(in);
            DOMSource ds = new DOMSource(d);

            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            File f = new File(xsd);
            Schema s = sf.newSchema(f);
            Validator v = s.newValidator();

            v.validate(ds);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public static void test3()
    {
        String path = "c:/projects/service/resource/generator/config/model/data/patch.xml";
        String prefix = "<!DOCTYPE model SYSTEM \"../model.dtd\">";

        String xml;
        xml = Kmu.readFileString(path);
        xml = Kmu.removePrefix(xml, prefix);
        xml = xml.trim();

        System.out.println("============================================================");
        System.out.println(xml);
        System.out.println("============================================================");

        KmXmlWrapper w = KmXmlWrapper.parseXml(xml);
        w.printPrettyXml();
        System.out.println("============================================================");

        w.printPrettyXml();
    }
}
