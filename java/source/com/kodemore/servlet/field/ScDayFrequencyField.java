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

package com.kodemore.servlet.field;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.time.KmWeekDay;
import com.kodemore.types.KmDayFrequency;
import com.kodemore.utility.Kmu;

public class ScDayFrequencyField
    extends ScField<KmDayFrequency>
{
    //##################################################
    //# variables
    //##################################################

    private ScCheckboxList<String> _checkboxList;

    //##################################################
    //# constructor
    //##################################################

    public ScDayFrequencyField()
    {
        ScCheckboxList<String> e;
        e = new ScCheckboxList<>();

        for ( KmWeekDay day : KmWeekDay.values() )
            e.addOption(day.getCode(), day.getLabel());

        _checkboxList = e;
    }

    //##################################################
    //# html id
    //##################################################

    @Override
    public String getHtmlId()
    {
        return _checkboxList.getHtmlId();
    }

    //##################################################
    //# children
    //##################################################

    @Override
    public KmList<ScControl> getChildren()
    {
        return KmList.createWith(_checkboxList);
    }

    //##################################################
    //# ajax
    //##################################################

    @Override
    public void ajaxSetFieldValue(KmDayFrequency e)
    {
        KmList<String> codes = getCodesFor(e);
        _checkboxList.ajaxSetFieldValue(codes);
    }

    @Override
    public void ajaxSetFieldValue(KmDayFrequency e, boolean updateOldValue)
    {
        KmList<String> codes = getCodesFor(e);
        _checkboxList.ajaxSetFieldValue(codes);
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public KmDayFrequency getValue()
    {
        String s = _checkboxList.getValue().join("");

        return Kmu.isEmpty(s)
            ? null
            : KmDayFrequency.fromString(s);
    }

    @Override
    public void setValue(KmDayFrequency value)
    {
        KmList<String> codes = getCodesFor(value);
        _checkboxList.setValue(codes);
    }

    @Override
    public void saveValue()
    {
        _checkboxList.saveValue();
    }

    @Override
    public void resetValue()
    {
        _checkboxList.resetValue();
    }

    //##################################################
    //# testing
    //##################################################

    @Override
    public boolean isEditable()
    {
        return true;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        _checkboxList.renderOn(out);
    }

    //##################################################
    //# support
    //##################################################

    private KmList<String> getCodesFor(KmDayFrequency value)
    {
        return value == null
            ? KmList.createEmpty()
            : value.getWeekDayCodes();
    }

}
