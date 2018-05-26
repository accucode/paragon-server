/*
  Copyright (c) 2005-2018 www.kodemore.com

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

import com.kodemore.utility.KmFormatterIF;

/**
 * I am used to easily create a formatter using reflection.
 */
public class KmBlockFormatter
    extends Object
    implements KmFormatterIF
{
    //##################################################
    //# variables
    //##################################################

    private KmBlock _block;

    //##################################################
    //# constructor
    //##################################################

    public KmBlockFormatter()
    {
        _block = null;
    }

    public KmBlockFormatter(Object receiver, String message)
    {
        setBlock(receiver, message);
    }

    //##################################################
    //# accessing
    //##################################################

    public KmBlock getBlock()
    {
        return _block;
    }

    public void setBlock(KmBlock b)
    {
        _block = b;
    }

    public void setBlock(Object receiver, String message)
    {
        setBlock(new KmBlock(receiver, message, Object.class));
    }

    //##################################################
    //# format
    //##################################################

    @Override
    public String format(Object e)
    {
        return (String)_block.invoke(e);
    }

}
