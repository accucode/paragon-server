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

package com.kodemore.awt;

import com.kodemore.block.KmBlock;

public class KmaBlockAction
    extends KmaAction
{
    //##################################################
    //# variables
    //##################################################

    private KmBlock _block;

    //##################################################
    //# constructors
    //##################################################

    public KmaBlockAction()
    {
        // default
    }

    public KmaBlockAction(Object receiver, String message)
    {
        this("unknown", receiver, message);
    }

    public KmaBlockAction(String name, Object receiver, String message)
    {
        setName(name);
        setBlock(receiver, message);
    }

    //##################################################
    //# accessing
    //##################################################

    public void setBlock(KmBlock p)
    {
        _block = p;
    }

    public void setBlock(Object receiver, String message)
    {
        setBlock(new KmBlock(receiver, message));
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public void invoke()
    {
        if ( _block == null )
            return;

        _block.invoke();
    }

}
