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

import com.kodemore.time.KmDate;
import com.kodemore.types.KmMoney;
import com.kodemore.xml.KmXmlElement;

/**
 * I parse a single price list item result.
 * This is primarily used to fetch the base price for items.
 */
public class KmIntacctDataPriceListItem
    extends KmIntacctAbstractResult
{
    //##################################################
    //# constructor
    //##################################################

    public KmIntacctDataPriceListItem(KmXmlElement root)
    {
        super(root);
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    protected String getRootTag()
    {
        return "pricelistitem";
    }

    //##################################################
    //# accessing
    //##################################################

    public String getPriceListId()
    {
        return getStringAt("pricelistid");
    }

    public String getItemId()
    {
        return getStringAt("itemid");
    }

    public String getRecordNumber()
    {
        return getStringAt("recordno");
    }

    public KmDate getFromDate()
    {
        return getDateAt("datefrom");
    }

    public KmDate getToDate()
    {
        return getDateAt("tofrom");
    }

    public Double getMinimumQuantity()
    {
        return getDoubleAt("qtylimitmin");
    }

    public Double getMaximumQuantity()
    {
        return getDoubleAt("qtylimitmax");
    }

    public String getStatus()
    {
        return getStringAt("status");
    }

    public KmMoney getValue()
    {
        return getMoneyAt("value");
    }

}
