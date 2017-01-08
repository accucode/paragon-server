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

package com.kodemore.sql.adaptor;

import com.kodemore.collection.KmBlob;
import com.kodemore.sql.KmSqlBuffer;
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
import com.kodemore.utility.KmConstantsIF;

/**
 * I am responsible for custom adaptation between the database
 * and various types of 'primitive' models.  E.g.: how to store
 * and retrieve KmMoney, or KmTimestamp.
 */
public abstract class KmSqlAdaptor
    implements KmConstantsIF
{
    //##################################################
    //# variables
    //##################################################

    private KmSqlValueAdaptor<String>         _stringAdaptor;

    private KmSqlValueAdaptor<Integer>        _integerAdaptor;
    private KmSqlValueAdaptor<Long>           _longAdaptor;
    private KmSqlValueAdaptor<Double>         _doubleAdaptor;
    private KmSqlValueAdaptor<Boolean>        _booleanAdaptor;

    private KmSqlValueAdaptor<KmDate>         _dateAdaptor;
    private KmSqlValueAdaptor<KmTime>         _timeAdaptor;
    private KmSqlValueAdaptor<KmTimestamp>    _timestampAdaptor;

    private KmSqlValueAdaptor<KmBlob>         _byteArrayAdaptor;
    private KmSqlValueAdaptor<KmDayFrequency> _dayFrequencyAdaptor;

    private KmSqlValueAdaptor<KmMoney>        _moneyAdaptor;
    private KmSqlValueAdaptor<KmKilogram>     _kilogramAdaptor;
    private KmSqlValueAdaptor<KmQuantity>     _quantityAdaptor;
    private KmSqlValueAdaptor<KmWeight>       _weightAdaptor;
    private KmSqlValueAdaptor<KmRate>         _rateAdaptor;
    private KmSqlValueAdaptor<KmCost>         _costAdaptor;

    //##################################################
    //# constructor
    //##################################################

    public KmSqlAdaptor()
    {
        _stringAdaptor = newStringAdaptor();

        _integerAdaptor = newIntegerAdaptor();
        _longAdaptor = newLongAdaptor();
        _doubleAdaptor = newDoubleAdaptor();
        _booleanAdaptor = newBooleanAdaptor();

        _dateAdaptor = newDateAdaptor();
        _timeAdaptor = newTimeAdaptor();
        _timestampAdaptor = newTimestampAdaptor();

        _byteArrayAdaptor = newByteArrayAdaptor();
        _dayFrequencyAdaptor = newDayFrequencyAdaptor();

        _moneyAdaptor = newMoneyAdaptor();
        _kilogramAdaptor = newKilogramAdaptor();
        _quantityAdaptor = newQuantityAdaptor();
        _weightAdaptor = newWeightAdaptor();
        _rateAdaptor = newRateAdaptor();
        _costAdaptor = newCostAdaptor();
    }

    //##################################################
    //# value adaptors (new)
    //##################################################

    public abstract KmSqlValueAdaptor<String> newStringAdaptor();

    public abstract KmSqlValueAdaptor<Integer> newIntegerAdaptor();

    public abstract KmSqlValueAdaptor<Long> newLongAdaptor();

    public abstract KmSqlValueAdaptor<Double> newDoubleAdaptor();

    public abstract KmSqlValueAdaptor<Boolean> newBooleanAdaptor();

    public abstract KmSqlValueAdaptor<KmDate> newDateAdaptor();

    public abstract KmSqlValueAdaptor<KmTime> newTimeAdaptor();

    public abstract KmSqlValueAdaptor<KmTimestamp> newTimestampAdaptor();

    public abstract KmSqlValueAdaptor<KmBlob> newByteArrayAdaptor();

    public abstract KmSqlValueAdaptor<KmDayFrequency> newDayFrequencyAdaptor();

    public abstract KmSqlValueAdaptor<KmMoney> newMoneyAdaptor();

    public abstract KmSqlValueAdaptor<KmKilogram> newKilogramAdaptor();

    public abstract KmSqlValueAdaptor<KmQuantity> newQuantityAdaptor();

    public abstract KmSqlValueAdaptor<KmWeight> newWeightAdaptor();

    public abstract KmSqlValueAdaptor<KmRate> newRateAdaptor();

    public abstract KmSqlValueAdaptor<KmCost> newCostAdaptor();

    //##################################################
    //# value adaptors (accessing)
    //##################################################

    public KmSqlValueAdaptor<Boolean> getBooleanAdaptor()
    {
        return _booleanAdaptor;
    }

    public KmSqlValueAdaptor<KmBlob> getByteArrayAdaptor()
    {
        return _byteArrayAdaptor;
    }

    public KmSqlValueAdaptor<KmDayFrequency> getDayFrequencyAdaptor()
    {
        return _dayFrequencyAdaptor;
    }

    public KmSqlValueAdaptor<KmKilogram> getKilogramAdaptor()
    {
        return _kilogramAdaptor;
    }

    public KmSqlValueAdaptor<KmQuantity> getQuantityAdaptor()
    {
        return _quantityAdaptor;
    }

    public KmSqlValueAdaptor<KmMoney> getMoneyAdaptor()
    {
        return _moneyAdaptor;
    }

    public KmSqlValueAdaptor<KmWeight> getWeightAdaptor()
    {
        return _weightAdaptor;
    }

    public KmSqlValueAdaptor<Double> getDoubleAdaptor()
    {
        return _doubleAdaptor;
    }

    public KmSqlValueAdaptor<Integer> getIntegerAdaptor()
    {
        return _integerAdaptor;
    }

    public KmSqlValueAdaptor<Long> getLongAdaptor()
    {
        return _longAdaptor;
    }

    public KmSqlValueAdaptor<String> getStringAdaptor()
    {
        return _stringAdaptor;
    }

    public KmSqlValueAdaptor<KmDate> getDateAdaptor()
    {
        return _dateAdaptor;
    }

    public KmSqlValueAdaptor<KmTime> getTimeAdaptor()
    {
        return _timeAdaptor;
    }

    public KmSqlValueAdaptor<KmTimestamp> getTimestampAdaptor()
    {
        return _timestampAdaptor;
    }

    public KmSqlValueAdaptor<KmRate> getRateAdaptor()
    {
        return _rateAdaptor;
    }

    public KmSqlValueAdaptor<KmCost> getCostAdaptor()
    {
        return _costAdaptor;
    }

    //##################################################
    //# buffer
    //##################################################

    public KmSqlBuffer newBuffer()
    {
        return new KmSqlBuffer(this);
    }

    //##################################################
    //# last id
    //##################################################

    public String getLastIdSqlString()
    {
        throw new UnsupportedOperationException();
    }

    //##################################################
    //# escape
    //##################################################

    public String escape(String s)
    {
        KmSqlBuffer b;
        b = new KmSqlBuffer(this);
        escape(b, s);
        return b.toString();
    }

    public void escape(KmSqlBuffer out, String s)
    {
        escape(out, s.getBytes());
    }

    private void escape(KmSqlBuffer out, byte[] arr)
    {
        int n = arr.length;
        for ( int i = 0; i < n; i++ )
            escape(out, arr[i]);
    }

    protected abstract void escape(KmSqlBuffer out, byte b);

}
