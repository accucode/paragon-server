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

package com.kodemore.servlet.control;

import com.kodemore.exception.KmApplicationException;
import com.kodemore.servlet.action.ScActionContextIF;

/**
 * I am typically the root control for each page.  I act as
 * the bridge that provides the control hierarchy access to
 * the page's context for things like security and error 
 * logging. 
 */
public class ScPageRoot
    extends ScBox
{
    //##################################################
    //# variables
    //##################################################

    private ScActionContextIF _context;

    //##################################################
    //# constructor
    //##################################################

    public ScPageRoot(ScActionContextIF e)
    {
        _context = e;
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public ScActionContextIF getContext()
    {
        return _context;
    }

    //##################################################
    //# context
    //##################################################

    @Override
    public void checkSecurity()
    {
        getContext().checkSecurity();
    }

    @Override
    public void handleError(KmApplicationException ex)
    {
        getContext().handleError(ex);
    }

    @Override
    public void handleFatal(RuntimeException ex)
    {
        getContext().handleFatal(ex);
    }
}
