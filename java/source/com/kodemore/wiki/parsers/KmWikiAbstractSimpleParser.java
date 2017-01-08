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

import com.kodemore.wiki.KmWikiReader;
import com.kodemore.wiki.KmWikiSource;

public abstract class KmWikiAbstractSimpleParser
    extends KmWikiParser
{
    //##################################################
    //# constructor
    //##################################################

    public KmWikiAbstractSimpleParser(KmWikiReader e)
    {
        super(e);
    }

    //##################################################
    //# abstract
    //##################################################

    protected abstract String getPrefix();

    protected abstract String getSuffix();

    protected abstract KmWikiElement newElement(KmWikiSource source, String s);

    //##################################################
    //# override
    //##################################################

    @Override
    public boolean start(KmWikiSource source)
    {
        KmWikiReader r = getReader();

        String prefix = getPrefix();
        int prefixLength = prefix.length();

        if ( r.notAt(prefix) )
            return false;

        String suffix = getSuffix();
        int suffixLength = suffix.length();

        int j = r.findNext(suffix, prefixLength);
        if ( j < 0 )
            return false;

        r.closeText();
        r.advance(prefixLength);

        String s = r.readTo(j);

        r.add(newElement(source, s));
        r.advance(suffixLength);

        return true;
    }

    @Override
    public boolean parse(KmWikiSource source, KmWikiContainer parent)
    {
        return false;
    }

}
