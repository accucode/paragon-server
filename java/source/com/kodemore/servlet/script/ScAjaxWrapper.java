/*
  Copyright (c) 2005-2011 www.kodemore.com

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

package com.kodemore.servlet.script;

import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.encoder.ScDecoder;
import com.kodemore.servlet.encoder.ScEncoder;

/**
 * I provide common methods for subclasses that provide
 * specialized ajax access.
 */
public abstract class ScAjaxWrapper
{
    //##################################################
    //# run
    //##################################################

    public void run(ScScriptIF e)
    {
        ajax().run(e);
    }

    public void run(String s, Object... args)
    {
        ajax().run(s, args);
    }

    public void run(ScActionIF action)
    {
        ajax().run(action);
    }

    //##################################################
    //# support
    //##################################################

    protected ScServletData data()
    {
        return ScServletData.getLocal();
    }

    protected ScScript ajax()
    {
        return data().ajax();
    }

    protected final String encode(Object e)
    {
        return ScEncoder.staticEncode(e);
    }

    protected final Object decode(String s)
    {
        return ScDecoder.staticDecode(s);
    }

}
