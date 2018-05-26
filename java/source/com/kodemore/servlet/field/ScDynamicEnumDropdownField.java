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

import java.util.function.Supplier;

import com.kodemore.collection.KmList;
import com.kodemore.utility.KmEnumIF;

public class ScDynamicEnumDropdownField
    extends ScDynamicDropdownField<String>
{
    //##################################################
    //# constructor
    //##################################################

    public ScDynamicEnumDropdownField()
    {
        super();
    }

    //##################################################
    //# value
    //##################################################

    public void setValue(KmEnumIF e)
    {
        setValue(KmEnumIF.getCodeFor(e));
    }

    //##################################################
    //# suppliers
    //##################################################

    public void setEnumArraySupplier(final Supplier<KmEnumIF[]> sup)
    {
        setOptionSupplier(newOptionArraySupplier(sup));
    }

    public void setEnumListSupplier(final Supplier<KmList<? extends KmEnumIF>> sup)
    {
        setOptionSupplier(newOptionListSupplier(sup));
    }

    //##################################################
    //# support
    //##################################################

    private Supplier<KmList<ScOption<String>>> newOptionArraySupplier(
        final Supplier<KmEnumIF[]> enumSup)
    {
        return new Supplier<KmList<ScOption<String>>>()
        {
            @Override
            public KmList<ScOption<String>> get()
            {
                KmList<ScOption<String>> v = new KmList<>();

                for ( KmEnumIF e : enumSup.get() )
                    v.add(toOption(e));

                return v;
            }
        };
    }

    private Supplier<KmList<ScOption<String>>> newOptionListSupplier(
        final Supplier<KmList<? extends KmEnumIF>> enumSup)
    {
        return new Supplier<KmList<ScOption<String>>>()
        {
            @Override
            public KmList<ScOption<String>> get()
            {
                KmList<ScOption<String>> v = new KmList<>();

                for ( KmEnumIF e : enumSup.get() )
                    v.add(toOption(e));

                return v;
            }
        };
    }

    private ScOption<String> toOption(KmEnumIF e)
    {
        return ScOption.create(e.getCode(), e.getLabel());
    }

}
