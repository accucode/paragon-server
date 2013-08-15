/*
  Copyright (c) 2005-2013 www.kodemore.com

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

import com.kodemore.collection.KmList;

/**
 * I represent the xml document and provide convenient access
 * to the singleton root element.  I also provide a hook for
 * additional document level information that may be added
 * later.
 */
public class KmXmlDocument
    extends KmXmlNode
{
    //##################################################
    //# constructor
    //##################################################

    public KmXmlDocument(KmXmlSourceLocation e)
    {
        super(e);
    }

    //##################################################
    //# variables
    //##################################################

    private KmXmlElement _root;

    //##################################################
    //# accessing
    //##################################################

    @Override
    public KmXmlElement getRoot()
    {
        return _root;
    }

    public void setRoot(KmXmlElement e)
    {
        _root = e;
    }

    //##################################################
    //# abstract accessing
    //##################################################

    @Override
    public KmXmlDocument getDocument()
    {
        return this;
    }

    public KmList<KmXmlElement> getElementsAt(String path)
    {
        KmList<String> tags = KmXmlElement.pathToTags(path);
        if ( tags.isEmpty() )
            return new KmList<KmXmlElement>();

        if ( !getRoot().hasTag(tags.getFirst()) )
            return new KmList<KmXmlElement>();

        tags.removeFirst();
        return getRoot().getElementsAt(tags);
    }

    //##################################################
    //# testing
    //##################################################

    @Override
    public boolean isDocument()
    {
        return true;
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return "XmlDocument";
    }

    @Override
    public void printOn(PrintWriter out)
    {
        _root.printOn(out);
    }

    @Override
    public void printStructureOn(PrintWriter out)
    {
        indent(out);
        out.println("Document");
        _root.printStructureOn(out);
    }

    @Override
    public void prettyPrintOn(PrintWriter out)
    {
        _root.prettyPrintOn(out);
    }

}
