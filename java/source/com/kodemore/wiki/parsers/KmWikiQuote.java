/*
  Copyright (c) 2005-2016 www.kodemore.com

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

package com.kodemore.wiki.parsers;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.wiki.KmWikiSource;

public class KmWikiQuote
    extends KmWikiContainer
{
    //##################################################
    //# constructor
    //##################################################

    public KmWikiQuote(KmWikiSource e)
    {
        super(e);
    }

    //##################################################
    //# override
    //##################################################

    @Override
    public String getName()
    {
        return "Quote";
    }

    @Override
    public boolean isBlock()
    {
        return true;
    }

    //##################################################
    //# print
    //##################################################

    @Override
    public void printHtmlOn(KmHtmlBuilder out)
    {
        String tag = "blockquote";

        out.printLiteralLine();
        out.begin(tag);
        out.printLiteralLine();
        printChildrenOn(out);
        out.printLiteralLine();
        out.end(tag);
        out.printLiteralLine();
    }

}
