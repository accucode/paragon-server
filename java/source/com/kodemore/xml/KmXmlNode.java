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

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;

import com.kodemore.utility.Kmu;

public abstract class KmXmlNode
implements KmXmlConstantsIF, Serializable
{
    //##################################################
    //# variables
    //##################################################

    private KmXmlNode           _parent;
    private KmXmlSourceLocation _location;

    //##################################################
    //# constructor
    //##################################################

    public KmXmlNode(KmXmlSourceLocation e)
    {
        _location = e;
    }

    //##################################################
    //# accessing
    //##################################################

    public KmXmlNode getParent()
    {
        return _parent;
    }

    public void setParent(KmXmlNode e)
    {
        _parent = e;
    }

    public boolean hasParent()
    {
        return _parent != null;
    }

    public KmXmlSourceLocation getLocation()
    {
        return _location;
    }

    public void setLocation(KmXmlSourceLocation e)
    {
        _location = e;
    }

    public boolean hasLocation()
    {
        return _location != null;
    }

    //##################################################
    //# abstract accessing
    //##################################################

    public KmXmlDocument getDocument()
    {
        return _parent.getDocument();
    }

    public KmXmlElement getRoot()
    {
        return getDocument().getRoot();
    }

    //##################################################
    //# testing
    //##################################################

    public boolean isDocument()
    {
        return false;
    }

    public boolean isElement()
    {
        return false;
    }

    public boolean isElement(@SuppressWarnings("unused") String tag)
    {
        return false;
    }

    public boolean isText()
    {
        return false;
    }

    public boolean isCdata()
    {
        return false;
    }

    //##################################################
    //# casting
    //##################################################

    public KmXmlDocument asDocument()
    {
        return (KmXmlDocument)this;
    }

    public KmXmlElement asElement()
    {
        return (KmXmlElement)this;
    }

    public KmXmlText asText()
    {
        return (KmXmlText)this;
    }

    public KmXmlCdata asCdata()
    {
        return (KmXmlCdata)this;
    }

    //##################################################
    //# display
    //##################################################

    public abstract void printOn(PrintWriter out);

    public abstract void printStructureOn(PrintWriter out);

    public void print()
    {
        PrintWriter out = new PrintWriter(System.out);
        printOn(out);
        out.flush();
    }

    public void printStructure()
    {
        PrintWriter out = new PrintWriter(System.out);
        printStructureOn(out);
        out.flush();
    }

    public abstract void prettyPrintOn(PrintWriter out);

    public void prettyPrint()
    {
        String s = getPrettyPrint();
        System.out.println(s);
    }

    public String getPrettyPrint()
    {
        StringWriter sw = new StringWriter();
        PrintWriter out = new PrintWriter(sw);
        prettyPrintOn(out);
        out.close();
        String s = sw.toString();
        return s;
    }

    //##################################################
    //# utility
    //##################################################

    public String formatForStructure(String s)
    {
        s = Kmu.replaceAll(s, "\n", "\\n");
        s = Kmu.replaceAll(s, "\r", "\\r");
        s = Kmu.replaceAll(s, "\t", "\\t");
        s = Kmu.truncate(s, 30, true);
        return "'" + s + "'";
    }

    public int getDepth()
    {
        return hasParent()
                        ? getParent().getDepth() + 1
                            : 0;
    }

    public void indent(PrintWriter out, int n)
    {
        for ( int i = 0; i < n; i++ )
            out.print("    ");
    }

    public void indent(PrintWriter out)
    {
        indent(out, getDepth());
    }

}
