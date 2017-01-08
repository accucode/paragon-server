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

public class KmWikiRuleParser
    extends KmWikiParser
{
    //##################################################
    //# constructor
    //##################################################

    public KmWikiRuleParser(KmWikiReader e)
    {
        super(e);
    }

    //##################################################
    //# override
    //##################################################

    @Override
    public boolean start(KmWikiSource source)
    {
        KmWikiReader r = getReader();

        if ( r.notAtLineStart() )
            return false;

        String s = RULE_TOKEN + LF;
        if ( r.notAt(s) )
            return false;

        r.autoPopNonBlocks();
        r.add(new KmWikiRule(source));
        r.advance(s.length());
        return true;
    }

    @Override
    public boolean parse(KmWikiSource source, KmWikiContainer parent)
    {
        return false;
    }
}
