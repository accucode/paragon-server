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

import java.util.function.Function;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;
import com.kodemore.xml.KmXmlElement;

/**
 * I parse a single result.
 * Each request operation may include multiple functions.
 * For each function, there should be a single result.
 * The result's controlId is used to match the request's function.
 */
public class KmIntacctResult
    extends KmIntacctAbstractResult
{
    //##################################################
    //# constructor
    //##################################################

    public KmIntacctResult(KmXmlElement root)
    {
        super(root);
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    protected String getRootTag()
    {
        return "result";
    }

    //##################################################
    //# accessing
    //##################################################

    public String getControlId()
    {
        return getStringAt("controlid");
    }

    public boolean hasControlId(String e)
    {
        return Kmu.isEqual(getControlId(), e);
    }

    //##################################################
    //# status
    //##################################################

    public String getStatus()
    {
        return getStringAt("status");
    }

    public boolean hasStatus(String e)
    {
        return Kmu.isEqual(getStatus(), e);
    }

    public boolean isOk()
    {
        return hasStatus("success");
    }

    //##################################################
    //# list type
    //##################################################

    public int getListIndex()
    {
        String s = findElement("listtype").getAttribute("start");
        return Kmu.parse_int(s);
    }

    public int getListBatchEndIndex()
    {
        String s = findElement("listtype").getAttribute("end");
        return Kmu.parse_int(s);
    }

    /**
     * The number of items returned in the current batch (this result).
     */
    public int getListSize()
    {
        int i = getListIndex();
        int j = getListBatchEndIndex();
        return 1 + j - i;
    }

    /**
     * Returns the total number of items that matched the query.
     * This may be significantly larger than the number of items
     * returned in the current batch.
     */
    public int getListTotalSize()
    {
        String s = findElement("listtype").getAttribute("total");
        return Kmu.parse_int(s);
    }

    //##################################################
    //# data
    //##################################################

    public KmList<KmXmlElement> getValues()
    {
        KmXmlElement data = findElement("data");
        return data == null
            ? new KmList<>()
            : data.getChildElements();
    }

    public <E extends KmIntacctAbstractResult> KmList<E> getValues(Function<KmXmlElement,E> fn)
    {
        return getValues().collect(fn);
    }
}
