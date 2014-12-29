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

package com.kodemore.xml;

import java.io.ByteArrayInputStream;
import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXParseException;

import com.kodemore.collection.KmList;
import com.kodemore.utility.KmConstantsIF;
import com.kodemore.utility.Kmu;

/**
 * Parse xml into a simple model.  I do not attempt to parse everything,
 * but instead provide a simplified model that is easy to use for the
 * common cases.  Additional parse can easily be added as it is deemed
 * useful.
 */
public class KmXmlParser
{
    //##################################################
    //# parse
    //##################################################

    public static KmXmlDocument parseFile(String path)
    {
        return parseFile(new File(path));
    }

    public static KmXmlDocument parseFile(File f)
    {
        String name = f.getName();
        String xml = Kmu.readFileString(f);
        return parse(name, xml);
    }

    public static KmXmlDocument parseFileUnicode(String path)
    {
        String name = path;
        String xml = Kmu.readFileUnicode(path);
        return parse(name, xml);
    }

    public static KmXmlDocument parse(String xml)
    {
        return parse("xml", xml);
    }

    public static KmXmlDocument parse(String name, String xml)
    {
        try
        {
            xml = xml.trim();

            InputSource is;
            is = new InputSource();
            is.setEncoding(KmConstantsIF.UTF_16);
            is.setByteStream(new ByteArrayInputStream(xml.getBytes(KmConstantsIF.UTF_16)));

            SAXParserFactory f;
            f = SAXParserFactory.newInstance();
            f.setNamespaceAware(true);
            f.setValidating(true);
            // f.setSchema(null);

            KmXmlContentHandler h;
            h = new KmXmlContentHandler();
            h.setLocationName(name);
            h.setSource(xml);

            SAXParser p;
            p = f.newSAXParser();
            p.parse(is, h);
            return h.getDocument();
        }
        catch ( SAXParseException ex )
        {
            int line = ex.getLineNumber() - 1;
            int col = ex.getColumnNumber() - 1;
            KmList<String> v = Kmu.parseLines(xml);

            System.out.println("-----------------------------------------------------------");
            System.out.println("PARSE EXCEPTION");
            System.out.println(v.getAtSafe(line));
            System.out.println(Kmu.repeat(" ", col - 1) + "^");
            System.out.println(ex.getMessage());
            System.out.println("    Name: " + name);
            System.out.println("    Row: " + line);
            System.out.println("    Col: " + col);
            System.out.println("-----------------------------------------------------------");
            throw Kmu.toRuntime(ex);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        String xml =
            "<?xml version='1.0'?>"
                + "\n<root>"
                + "\n  <a>aaa</a>"
                + "\n  <b>"
                + "\n    bbb"
                + "\n  </b>"
                + "\n  <![CDATA[cdata... Embedded <xml> tags. Line \r\n feeds.  Escaped &lt; &gr; chars.]]>"
                + "\n  <c x='1' y='&amp;2\n' z='3&lt;'/>"
                + "\n</root>"
                + "\n";
        KmXmlDocument d = KmXmlParser.parse("test", xml);

        System.out.println("-------------------------------------");
        System.out.println(xml);
        System.out.println("-------------------------------------");
        d.print();
        System.out.println("-------------------------------------");
        d.printStructure();
    }
}
