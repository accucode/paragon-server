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

package com.kodemore.servlet.control;

import com.kodemore.servlet.field.ScHtmlIdIF;

/**
 * A submit button corresponds to <button type="submit"...>
 * Submit buttons do not have customizable scripts since
 * any script should be applied to the form instead.
 * See also ScForm.setOnSubmit().
 */
public class ScSubmitButton
    extends ScButton
{
    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        setText("Submit");
    }

    //##################################################
    //# tree
    //##################################################

    @Override
    public void attached()
    {
        super.attached();

        installBlockWrapper();
    }

    private void installBlockWrapper()
    {
        ScHtmlIdIF block = findBlockWrapper();
        if ( block == null )
            return;

        ScForm form = findFormWrapper();
        if ( form == null )
            return;

        if ( form == block )
            return;

        form.setBlockTarget(block);
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected String formatHtmlType()
    {
        return "submit";
    }

    @Override
    protected String formatOnClick()
    {
        return null;
    }
}
