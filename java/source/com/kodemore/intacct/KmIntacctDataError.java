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

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;
import com.kodemore.xml.KmXmlElement;

/**
 * I parse a single multi-part error.
 */
public class KmIntacctDataError
    extends KmIntacctAbstractResult
{
    //##################################################
    //# constructor
    //##################################################

    public KmIntacctDataError(KmXmlElement root)
    {
        super(root);
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    protected String getRootTag()
    {
        return "errormessage";
    }

    //##################################################
    //# accessing
    //##################################################

    public String getControlErrorNumber()
    {
        return getStringAt("error/errorno");
    }

    public String getControlErrorDescription1()
    {
        return getStringAt("error/description");
    }

    public String getControlErrorDescription2()
    {
        return getStringAt("error/description2");
    }

    //##################################################
    //# display
    //##################################################

    public String formatMessage()
    {
        KmList<String> v;
        v = new KmList<>();
        v.add(getControlErrorNumber());
        v.add(getControlErrorDescription1());
        v.add(getControlErrorDescription2());

        Kmu.removeEmptyValues(v);
        Kmu.trimValues(v);

        return v.join(" / ");
    }

}
