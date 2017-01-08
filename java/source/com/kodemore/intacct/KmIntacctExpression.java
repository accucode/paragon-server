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

import com.kodemore.time.KmTimestamp;
import com.kodemore.xml.utility.KmXmlBuilder;

/**
 * An "and/or" element used in filters.
 *
 * @see KmIntacctNode
 */
public class KmIntacctExpression
    extends KmIntacctFilterElement
{
    //##################################################
    //# constants
    //##################################################

    private static final String EQUAL                 = "=";
    private static final String NOT_EQUAL             = "!=";
    private static final String LESS_THAN             = "<";
    private static final String LESS_THAN_OR_EQUAL    = "<=";
    private static final String GREATER_THAN          = ">";
    private static final String GREATER_THAN_OR_EQUAL = ">=";
    private static final String IS_NULL               = "is null";

    //##################################################
    //# variables
    //##################################################

    /**
     * The field to be operated on.
     * Required.
     */
    private String              _field;

    /**
     * The operator to apply.
     * Required.
     */
    private String              _operator;

    /**
     * The value that is compared to the field.
     * Required, except for IS NULL in which case it is prohibited.
     */
    private String              _value;

    //##################################################
    //# constructor
    //##################################################

    public KmIntacctExpression()
    {
        // none
    }

    //##################################################
    //# field
    //##################################################

    public String getField()
    {
        return _field;
    }

    public void setField(String e)
    {
        _field = e;
    }

    //##################################################
    //# operator
    //##################################################

    public String getOperator()
    {
        return _operator;
    }

    public void setOperator(String e)
    {
        _operator = e;
    }

    //##################################################
    //# value
    //##################################################

    public String getValue()
    {
        return _value;
    }

    public void setValue(String e)
    {
        _value = e;
    }

    //##################################################
    //# where is
    //##################################################

    public void wheresIsEqual(String field, String value)
    {
        setField(field);
        isEqual(value);
    }

    public void whereIsNotEqual(String field, String value)
    {
        setField(field);
        isNotEqual(value);
    }

    public void whereIsLessThan(String field, String value)
    {
        setField(field);
        isLessThan(value);
    }

    public void whereIsLessThanOrEqual(String field, String value)
    {
        setField(field);
        isLessThanOrEqual(value);
    }

    public void whereIsGreaterThan(String field, String value)
    {
        setField(field);
        isGreaterThan(value);
    }

    public void whereIsGreaterThanOrEqual(String field, String value)
    {
        setField(field);
        isGreaterThanOrEqual(value);
    }

    public void whereIsNull(String field)
    {
        setField(field);
        isNull();
    }

    //##################################################
    //# where is
    //##################################################

    public void isEqual(String value)
    {
        setOperator(EQUAL);
        setValue(value);
    }

    public void isNotEqual(String value)
    {
        setOperator(NOT_EQUAL);
        setValue(value);
    }

    public void isLessThan(String value)
    {
        setOperator(LESS_THAN);
        setValue(value);
    }

    public void isLessThanOrEqual(String value)
    {
        setOperator(LESS_THAN_OR_EQUAL);
        setValue(value);
    }

    public void isGreaterThan(String value)
    {
        setOperator(GREATER_THAN);
        setValue(value);
    }

    public void isGreaterThanOrEqual(String value)
    {
        setOperator(GREATER_THAN_OR_EQUAL);
        setValue(value);
    }

    /**
     * <whenmodified>10/12/2016 18:26:55</whenmodified>
     */
    public void isGreaterThanOrEqual(KmTimestamp utcTs)
    {
        isGreaterThanOrEqual(format(utcTs));
    }

    public void isNull()
    {
        setOperator(IS_NULL);
        setValue(null);
    }

    //##################################################
    //# compose
    //##################################################

    @Override
    public void composeOn(KmXmlBuilder out)
    {
        out.begin("expression");
        out.value("field", getField());
        out.value("operator", getOperator());
        out.value("value", getValue());
        out.end();
    }

    //##################################################
    //# private
    //##################################################

    private String format(KmTimestamp utcTs)
    {
        return utcTs.format("{mm}/{dd}/{yyyy} {HH24}:{MM}:{SS}");
    }

}
