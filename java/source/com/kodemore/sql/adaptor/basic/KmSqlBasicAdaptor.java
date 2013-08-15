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

package com.kodemore.sql.adaptor.basic;

import com.kodemore.collection.KmBlob;
import com.kodemore.sql.KmSqlBuffer;
import com.kodemore.sql.adaptor.KmSqlAdaptor;
import com.kodemore.sql.adaptor.KmSqlValueAdaptor;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmTime;
import com.kodemore.time.KmTimestamp;
import com.kodemore.types.KmCost;
import com.kodemore.types.KmDayFrequency;
import com.kodemore.types.KmKilogram;
import com.kodemore.types.KmMoney;
import com.kodemore.types.KmQuantity;
import com.kodemore.types.KmRate;
import com.kodemore.types.KmWeight;

/**
 * I am responsible for custom adaptation between the database
 * and various types of 'primitive' models.  E.g.: how to store
 * and retrieve KmMoney, or KmTimestamp.
 */
public class KmSqlBasicAdaptor
    extends KmSqlAdaptor
{
    //##################################################
    //# buffer
    //##################################################

    @Override
    public String getLastIdSqlString()
    {
        return "SELECT LAST_INSERT_ID()";

        // mySql: "SELECT LAST_INSERT_ID()"
        // db2:   "SELECT IDENTITY_VAL_LOCAL() FROM SYSIBM.SYSDUMMY1"
        // msSql: "SELECT @@IDENTITY AS 'Identity'"
    }

    //##################################################
    //# escape
    //##################################################

    @Override
    protected void escape(KmSqlBuffer out, byte b)
    {
        throw new UnsupportedOperationException();
    }

    //##################################################
    //# value adaptors
    //##################################################

    @Override
    public KmSqlValueAdaptor<Boolean> newBooleanAdaptor()
    {
        return new KmSqlBasicBooleanAdaptor();
    }

    @Override
    public KmSqlValueAdaptor<KmBlob> newByteArrayAdaptor()
    {
        return new KmSqlBasicByteArrayAdaptor();
    }

    @Override
    public KmSqlValueAdaptor<KmDate> newDateAdaptor()
    {
        return new KmSqlBasicDateAdaptor();
    }

    @Override
    public KmSqlValueAdaptor<KmDayFrequency> newDayFrequencyAdaptor()
    {
        return new KmSqlBasicDayFrequencyAdaptor();
    }

    @Override
    public KmSqlValueAdaptor<Double> newDoubleAdaptor()
    {
        return new KmSqlBasicDoubleAdaptor();
    }

    @Override
    public KmSqlValueAdaptor<Integer> newIntegerAdaptor()
    {
        return new KmSqlBasicIntegerAdaptor();
    }

    @Override
    public KmSqlValueAdaptor<KmKilogram> newKilogramAdaptor()
    {
        return new KmSqlBasicKilogramAdaptor();
    }

    @Override
    public KmSqlValueAdaptor<KmQuantity> newQuantityAdaptor()
    {
        return new KmSqlBasicQuantityAdaptor();
    }

    @Override
    public KmSqlValueAdaptor<Long> newLongAdaptor()
    {
        return new KmSqlBasicLongAdaptor();
    }

    @Override
    public KmSqlValueAdaptor<KmMoney> newMoneyAdaptor()
    {
        return new KmSqlMoneyAdaptor();
    }

    @Override
    public KmSqlValueAdaptor<String> newStringAdaptor()
    {
        return new KmSqlBasicStringAdaptor();
    }

    @Override
    public KmSqlValueAdaptor<KmRate> newRateAdaptor()
    {
        return new KmSqlBasicRateAdaptor();
    }

    @Override
    public KmSqlValueAdaptor<KmCost> newCostAdaptor()
    {
        return new KmSqlBasicCostAdaptor();
    }

    @Override
    public KmSqlValueAdaptor<KmTime> newTimeAdaptor()
    {
        return new KmSqlBasicTimeAdaptor();
    }

    @Override
    public KmSqlValueAdaptor<KmTimestamp> newTimestampAdaptor()
    {
        return new KmSqlBasicTimestampAdaptor();
    }

    @Override
    public KmSqlValueAdaptor<KmWeight> newWeightAdaptor()
    {
        return new KmSqlBasicWeightAdaptor();
    }

}
