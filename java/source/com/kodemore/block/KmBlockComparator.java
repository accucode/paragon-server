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

package com.kodemore.block;

import com.kodemore.comparator.KmComparator;
import com.kodemore.utility.KmUnchecked;

/**
 * I provide a reflection interface for comparators.
 */
public class KmBlockComparator<T>
    extends KmComparator<T>
{
    //##################################################
    //# variables
    //##################################################

    private KmBlockIF _block;

    //##################################################
    //# constructor
    //##################################################

    public KmBlockComparator()
    {
        _block = null;
    }

    public KmBlockComparator(String method)
    {
        setMethod(method);
    }

    //##################################################
    //# accessing
    //##################################################

    /**
     * Set the block used for comparison.
     */
    public void setBlock(KmBlockIF e)
    {
        _block = e;
    }

    /**
     * Set the block or blockPath used for comparison.  If the
     * string contains a '.' then a blockPath is automatically
     * used.  Note: if a blockPath is used, then the return value
     * is the last block in the path.
     */
    public void setMethod(String m)
    {
        if ( m.indexOf('.') < 0 )
            _setMethod(m);
        else
            _setPath(m);
    }

    /**
     * Set the block; this assumes that the string is a valid
     * method; not a path.
     */
    private void _setMethod(String m)
    {
        KmBlock b;
        b = new KmBlock();
        b.setMessage(m);
        _block = b;
    }

    /**
     * Set the block to a blockPath by using '.' as a method name
     * delimiter.  The block returned is the last block in the path.
     */
    private void _setPath(String m)
    {
        KmBlockPath p;
        p = new KmBlockPath();
        p.setMessagePath(m);
        _block = p;
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public int compare(T o1, T o2)
    {
        Object e1 = getValue(o1);
        Object e2 = getValue(o2);
        return KmUnchecked.compare(e1, e2);
    }

    //##################################################
    //# support
    //##################################################

    private Object getValue(Object e)
    {
        _block.setReceiver(e);
        return _block.invoke();
    }
}
