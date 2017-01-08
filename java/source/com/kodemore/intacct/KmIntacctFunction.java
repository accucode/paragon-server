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

package com.kodemore.intacct;

import com.kodemore.utility.Kmu;
import com.kodemore.xml.utility.KmXmlBuilder;

/**
 * A single Intacct action to be executed within a request operation.
 *
 * @see KmIntacctNode
 */
public abstract class KmIntacctFunction
    extends KmIntacctNode
{
    //##################################################
    //# variables
    //##################################################

    /**
     * When composing API requests, each action is wrapped in a 'function'
     * element that is responsible for identifying the controlId. Since
     * it appears there is a one-to-one relationship between the function
     * and the action, we simply manage the controlId here.
     *
     * The controlId is required, and must be unique if the action is
     * updating intacct. However, for read-only actions such as GetList,
     * value does not necessarily need to be unique.
     *
     * If you send multiple functions/actions in a single request, the
     * controlId can also be used to identify which results correspond to
     * each action.
     *
     * By default, the control is set to a random uid.
     */
    private String _controlId;

    //##################################################
    //# constructor
    //##################################################

    public KmIntacctFunction()
    {
        setControlId(Kmu.newUid());
    }

    //##################################################
    //# accessing
    //##################################################

    public String getControlId()
    {
        return _controlId;
    }

    public void setControlId(String e)
    {
        _controlId = e;
    }

    //##################################################
    //# compose
    //##################################################

    @Override
    public final void composeOn(KmXmlBuilder out)
    {
        out.open("function");
        out.printAttribute("controlid", getControlId());
        out.close();

        composeActionOn(out);

        out.end();
    }

    protected abstract void composeActionOn(KmXmlBuilder out);

}
