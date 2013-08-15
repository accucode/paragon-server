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

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.wiki.KmWikiSource;

public abstract class KmWikiBulletList
    extends KmWikiContainer
{
    //##################################################
    //# variables
    //##################################################

    private int _level;

    //##################################################
    //# constructor
    //##################################################

    public KmWikiBulletList(KmWikiSource source)
    {
        super(source);
        _level = 1;
        _addBulletItem(source);
    }

    //##################################################
    //# accessing
    //##################################################

    public int getLevel()
    {
        return _level;
    }

    public void setLevel(int e)
    {
        _level = e;
    }

    //##################################################
    //# testing
    //##################################################

    @Override
    public boolean isBlock()
    {
        return true;
    }

    //##################################################
    //# add
    //##################################################

    @Override
    public void addChild(KmWikiElement e)
    {
        KmWikiContainer item;
        item = (KmWikiContainer)getChildren().getLast();
        item.addChild(e);
    }

    public void addBullet(KmWikiSource source, int level)
    {
        KmList<KmWikiElement> children = getChildren();

        if ( level == getLevel() )
        {
            _addBulletItem(source);
            return;
        }

        KmWikiElement last = children.getLast();
        if ( last instanceof KmWikiBulletItem )
        {
            _addBulletList(source, level);
            return;
        }

        KmWikiBulletList list = (KmWikiBulletList)last;
        if ( level < list.getLevel() )
        {
            _addBulletList(source, level);
            return;
        }

        list.addBullet(source, level);
    }

    private void _addBulletItem(KmWikiSource source)
    {
        getChildren().add(new KmWikiBulletItem(source));
    }

    private void _addBulletList(KmWikiSource source, int level)
    {
        KmWikiBulletList list;
        list = newList(source);
        list.setLevel(level);

        getChildren().add(list);
    }

    //##################################################
    //# print
    //##################################################

    @Override
    public void printHtmlOn(KmHtmlBuilder out)
    {
        String tag = getTag();
        out.ensureLiteralLine();
        out.open(tag);
        out.printAttribute("style", getHtmlStyle());
        out.close();
        printChildrenOn(out);
        out.end(tag);
        out.printLiteralLine();
    }

    private String getHtmlStyle()
    {
        return "list-style-type:" + getListStyleType();
    }

    private String getListStyleType()
    {
        String[] arr = getStyles();
        int i = getLevel() - 1;

        int n = arr.length;
        if ( i >= n )
            return arr[n - 1];

        return arr[i];
    }

    //##################################################
    //# abstract
    //##################################################

    protected abstract String getTag();

    protected abstract KmWikiBulletList newList(KmWikiSource source);

    protected abstract String[] getStyles();
}
