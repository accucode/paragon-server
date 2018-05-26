/*
  Copyright (c) 2005-2018 www.kodemore.com

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
import com.kodemore.time.KmTimeZone;

public class ScTimeZoneField
    extends ScDynamicDropdownField<KmTimeZone>
{
    //##################################################
    //# constructor
    //##################################################

    public ScTimeZoneField()
    {
        setLabel("Time Zone");
        setOptionSupplier(this::composeOptions);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();
    }

    //##################################################
    //# options
    //##################################################

    private KmList<ScOption<KmTimeZone>> composeOptions()
    {
        KmList<ScOption<KmTimeZone>> v;
        v = new KmList<>();
        v.addAll(toOptions(KmTimeZone.getCommonZones()));
        v.add(ScOption.create(null, "--------------------"));
        v.addAll(toOptions(KmTimeZone.getAllZones()));
        return v;
    }

    private KmList<ScOption<KmTimeZone>> toOptions(KmList<KmTimeZone> zones)
    {
        return zones.collect(e -> toOption(e));
    }

    private ScOption<KmTimeZone> toOption(KmTimeZone e)
    {
        return ScOption.create(e, e.getName());
    }

}
