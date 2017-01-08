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
import com.kodemore.time.KmDate;
import com.kodemore.time.KmTimestamp;
import com.kodemore.time.KmTimestampParser;
import com.kodemore.types.KmMoney;
import com.kodemore.utility.Kmu;
import com.kodemore.xml.KmXmlElement;

/**
 * A single Intacct result object.
 *
 * I provide convenience methods to parse intacct xml results.
 * Specific subclasses define the specific parsing rules for different
 * results. Typically, each result object parses only the pertinent
 * portion of the full xml response.
 */
public abstract class KmIntacctAbstractResult
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The root element being parsed.
     * This is typically NOT the root element of the entire xml doc.
     * For example, the root element of the Sales Order Transaction is <sotransaction>.
     */
    private KmXmlElement _root;

    //##################################################
    //# constructor
    //##################################################

    public KmIntacctAbstractResult(KmXmlElement root)
    {
        _root = root;
        checkRootTag();
    }

    //##################################################
    //# root tag
    //##################################################

    public KmXmlElement getRoot()
    {
        return _root;
    }

    private void checkRootTag()
    {
        String expected = getRootTag();
        String actual = _root.getTag();

        if ( !expected.equals(actual) )
            throw Kmu.newFatal("Expected %s, but found %s.", expected, actual);
    }

    protected abstract String getRootTag();

    //##################################################
    //# convenience
    //##################################################

    protected String getStringAt(String... paths)
    {
        KmXmlElement e = findElement(paths);
        return e == null
            ? null
            : e.collectText();
    }

    protected KmDate getDateAt(String... paths)
    {
        String path = join(paths);
        Integer yy = getIntegerAt(path, "year");
        Integer mm = getIntegerAt(path, "month");
        Integer dd = getIntegerAt(path, "day");
        return KmDate.fromYearMonthDay(yy, mm, dd);
    }

    protected KmTimestamp getTimestampAt(String... paths)
    {
        String s = getStringAt(paths);
        return KmTimestampParser.parseTimestamp(s);
    }

    protected Integer getIntegerAt(String... paths)
    {
        String s = getStringAt(paths);
        return Kmu.parseInteger(s);
    }

    protected Double getDoubleAt(String... paths)
    {
        String s = getStringAt(paths);
        return Kmu.parseDouble(s);
    }

    protected KmMoney getMoneyAt(String... paths)
    {
        Double d = getDoubleAt(paths);
        return d == null
            ? null
            : new KmMoney(d);
    }

    //##################################################
    //# debug
    //##################################################

    public void prettyPrint()
    {
        getRoot().prettyPrint();
    }

    //##################################################
    //# support
    //##################################################

    protected KmList<KmXmlElement> findElements(String... paths)
    {
        return _root.getElementsAt(join(paths));
    }

    protected KmXmlElement findElement(String... paths)
    {
        return _root.getElementAt(join(paths));
    }

    private String join(String... paths)
    {
        return Kmu.joinFilePath(paths);
    }

}
