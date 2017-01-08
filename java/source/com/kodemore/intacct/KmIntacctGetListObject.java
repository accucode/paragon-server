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

import com.kodemore.utility.KmEnumIF;
import com.kodemore.utility.Kmu;

/**
 * The list of objects available for use with the Get List web service.
 */
public enum KmIntacctGetListObject
                implements KmEnumIF
{
    //##################################################
    //# values
    //##################################################

    accountgroup,
    adjjournal,
    apaccountlabel,
    apadjustment,
    apadjustmentbatch,
    appayment,
    appaymentrequest,
    apterm,
    araccountlabel,
    aradjustment,
    aradjustmentbatch,
    arpayment,
    arpaymentbatch,
    arterm,
    artransactiondef,
    bankaccount,
    bill,
    billbatch,
    class_x,
    company_info,
    contact,
    contacttaxgroup,
    csnhistory,
    custglgroup,
    customer,
    customerachinfo,
    customerbankaccount,
    customerchargecard,
    customerppackage,
    department,
    employee,
    expensereport,
    expensereportbatch,
    expensetypes,
    glaccount,
    glbudget,
    glbudgetitem,
    glentry,
    gltransaction,
    icitem,
    ictotal,
    ictransaction,
    ictransactiondef,
    invoice,
    invoicebatch,
    itemglgroup,
    itemtaxgroup,
    journal,
    location,
    locationentity,
    locationgroup,
    popricelist,
    potransaction,
    potransactiondef,
    pricelistitem,
    productline,
    project,
    renewalmacro,
    reportingperiod,
    revrecschedule,
    revrecscheduleentry,
    revrectemplate,
    smarteventlog,
    sopricelist,
    sotransaction,
    sotransactiondef,
    statglaccount,
    statjournal,
    stkittransaction,
    subscription,
    taxdetail,
    taxschedule,
    taxscheduledetail,
    taxschedulemap,
    territory,
    trxcurrencies,
    uom,
    vendglgroup,
    vendor,
    vsoeitempricelist,
    vsoepricelist,
    warehouse;

    //##################################################
    //# accessing
    //##################################################

    /**
     * Return the name used by intacct.
     * Most of the enum names are simply used as is, but trailing _x
     * suffix is stripped for names that would otherwise be a java
     * keyword.
     */
    public String getIntacctName()
    {
        return Kmu.removeSuffix(name(), "_x");
    }

    @Override
    public String getLabel()
    {
        return getIntacctName();
    }
}
