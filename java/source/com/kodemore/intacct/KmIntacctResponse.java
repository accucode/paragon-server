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
 * I parse a single response.
 * The response is the root element of the Intacct document.
 * This is used to determine the status of the result and
 * to find the other elements.
 */
public class KmIntacctResponse
    extends KmIntacctAbstractResult
{
    //##################################################
    //# constructor
    //##################################################

    public KmIntacctResponse(KmXmlElement root)
    {
        super(root);
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    protected String getRootTag()
    {
        return "response";
    }

    //##################################################
    //# summary
    //##################################################

    public boolean isOk()
    {
        return isControlOk() && isAuthenticationOk() && areResultsOk();
    }

    public String getStatusSummary()
    {
        if ( isOk() )
            return "ok";

        String s;
        KmList<String> v = new KmList<>();

        s = getControlStatus();
        if ( s != null )
            v.add(Kmu.format("control(%s)", s));

        s = getAuthenticationStatus();
        if ( s != null )
            v.add(Kmu.format("authentication(%s)", s));

        KmList<KmIntacctResult> results = getResults();
        int resultCount = results.size();
        v.add(Kmu.format("resultCount(%s)", resultCount));
        if ( resultCount > 0 )
            if ( areResultsOk() )
                v.add("resultStatus(ok)");
            else
                v.add("resultStatus(not ok)");

        return v.join();
    }

    //##################################################
    //# control
    //##################################################

    public String getControlStatus()
    {
        return getStringAt("control/status");
    }

    public boolean isControlOk()
    {
        return Kmu.isEqual(getControlStatus(), "success");
    }

    //##################################################
    //# operation
    //##################################################

    /**
     * Return the single operation element.
     * We currently support only one operation per request,
     * however, each operation may include multiple results.
     */
    private KmXmlElement getOperation()
    {
        return findElement("operation");
    }

    public KmIntacctDataError getOperationError()
    {
        KmXmlElement xml = getOperation().getChildElement("errormessage");
        return xml == null
            ? null
            : new KmIntacctDataError(xml);
    }

    //##################################################
    //# authentication
    //##################################################

    public String getAuthenticationStatus()
    {
        return getStringAt("operation/authentication/status");
    }

    public boolean isAuthenticationOk()
    {
        return Kmu.isEqual(getAuthenticationStatus(), "success");
    }

    //##################################################
    //# results
    //##################################################

    public KmList<KmIntacctResult> getResults()
    {
        return findElements("operation/result").collect(e -> new KmIntacctResult(e));
    }

    public KmIntacctResult getResultFor(KmIntacctFunction fn)
    {
        String id = fn.getControlId();
        return getResults().selectFirst(e -> e.hasControlId(id));
    }

    public boolean areResultsOk()
    {
        return getResults().containsOnlyIf(e -> e.isOk());
    }

    //##################################################
    //# errors
    //##################################################

    public KmList<KmIntacctDataError> getErrors()
    {
        KmList<KmIntacctDataError> v;
        v = new KmList<>();
        v.addNonNull(getResponseError());
        v.addNonNull(getOperationError());
        return v;
    }

    public String formatErrorLines()
    {
        return getErrors().collect(e -> e.formatMessage()).joinLines();
    }

    public boolean hasErrors()
    {
        return getErrors().isNotEmpty();
    }

    public KmIntacctDataError getResponseError()
    {
        KmXmlElement xml = findElement("errormessage");
        return xml == null
            ? null
            : new KmIntacctDataError(xml);
    }
}
