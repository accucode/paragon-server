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

package com.kodemore.block;

import java.util.Iterator;
import java.util.StringTokenizer;

import com.kodemore.collection.KmList;

/**
 * I am used to create a path of reflection access.  For example:
 * person.getFirstChild().getFavoritePet().getName().  A string
 * of non-parameterized methods may be specified using a single
 * string that separates the method names with a '.'.  Or the
 * path may be created one step at a time; this allows for parameters
 * to be specified.
 */
public class KmBlockPath
    implements KmBlockIF
{
    //##################################################
    //# variables
    //##################################################

    private KmList<KmBlock> _blocks;

    //##################################################
    //# constructors
    //##################################################

    public KmBlockPath()
    {
        _blocks = new KmList<>();
    }

    public KmBlockPath(String msgPath)
    {
        _blocks = new KmList<>();
        addMessagePath(msgPath);
    }

    public KmBlockPath(Object receiver, String msgPath)
    {
        this(msgPath);
        setReceiver(receiver);
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public void setReceiver(Object e)
    {
        getFirstBlock().setReceiver(e);
    }

    public void addBlock(KmBlock b)
    {
        _blocks.add(b);
    }

    public void addPath(String msg)
    {
        KmBlock b;
        b = new KmBlock();
        b.setMessage(msg);
        addBlock(b);
    }

    public void addBlock(String msg)
    {
        KmBlock b;
        b = new KmBlock();
        b.setMessage(msg);
        addBlock(b);
    }

    public void addBlock(String msg, Object arg)
    {
        KmBlock b;
        b = new KmBlock();
        b.setMessage(msg);
        b.addArgument(arg);
        addBlock(b);
    }

    public void setMessagePath(String path)
    {
        _blocks.clear();
        addMessagePath(path);
    }

    public void addMessagePath(String path)
    {
        StringTokenizer st = new StringTokenizer(path, ".");
        while ( st.hasMoreTokens() )
            addBlock(st.nextToken());
    }

    public KmBlock getBlock(int i)
    {
        return _blocks.get(i);
    }

    public KmBlock getFirstBlock()
    {
        return getBlock(0);
    }

    public KmBlock getLastBlock()
    {
        int n = getBlockCount();
        return getBlock(n - 1);
    }

    public int getBlockCount()
    {
        return _blocks.size();
    }

    //##################################################
    //# actions
    //##################################################

    @Override
    public Object invoke()
    {
        if ( _blocks.isEmpty() )
            return null;

        Iterator<KmBlock> i = _blocks.iterator();
        KmBlock b = i.next();
        Object e = b.invoke();

        while ( i.hasNext() )
        {
            b = i.next();
            b.setReceiver(e);
            e = b.invoke();
        }

        return e;
    }
}
