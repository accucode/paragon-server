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

package com.kodemore.wiki.parsers;

import com.kodemore.utility.Kmu;
import com.kodemore.wiki.KmWikiReader;
import com.kodemore.wiki.KmWikiSource;

public abstract class KmWikiBulletListParser
    extends KmWikiParser
{
    //##################################################
    //# constructor
    //##################################################

    public KmWikiBulletListParser(KmWikiReader e)
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

        String prefix = "" + getBulletCharacter() + SPACE;
        if ( r.notAt(prefix) )
            return false;

        r.push(this, newList(source));
        r.advance(prefix.length());
        r.skipWhitespace();

        return true;
    }

    @Override
    public boolean parse(KmWikiSource source, KmWikiContainer parent)
    {
        KmWikiReader r = getReader();
        if ( r.notAtLineStart() )
            return false;

        r.trimTrailingLineEnd();
        r.trimTrailingSpaces();
        r.autoPopTo(parent);

        char c = getBulletCharacter();
        if ( r.notAt(c) )
        {
            r.pop();
            return true;
        }

        int level = r.getRunLength();

        String prefix = Kmu.repeat(c, level) + SPACE;
        if ( r.notAt(prefix) )
        {
            r.pop();
            return true;
        }

        r.advance(prefix.length());
        r.skipWhitespace();

        KmWikiBulletList list;
        list = (KmWikiBulletList)parent;
        list.addBullet(source, level);
        return true;
    }

    @Override
    public boolean endDocument(KmWikiContainer e)
    {
        getReader().pop();
        return true;
    }

    //##################################################
    //# abstract
    //##################################################

    protected abstract char getBulletCharacter();

    protected abstract KmWikiBulletList newList(KmWikiSource source);

}
