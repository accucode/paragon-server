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

package com.kodemore.servlet.control;

import java.util.function.Function;

import com.kodemore.validator.KmRequiredValidator;
import com.kodemore.validator.KmValidator;

public class ScUtility
{
    //##################################################
    //# conversion
    //##################################################

    @SuppressWarnings("rawtypes")
    public static Function toFunction(Object val)
    {
        if ( val == null )
            return null;

        if ( val instanceof Function )
            return (Function)val;

        return new Function()
        {
            @Override
            public Object apply(Object model)
            {
                return val;
            }
        };
    }

    //##################################################
    //# validators
    //##################################################

    public static <T> KmValidator<T> toRequiredValidator(KmValidator<T> e)
    {
        if ( e == null )
            return new KmRequiredValidator<>();

        if ( e.isRequired() )
            return e;

        KmValidator<T> copy;
        copy = e.getCopy();
        copy.setRequired();
        return copy;
    }

    public static <T> KmValidator<T> toOptionalValidator(KmValidator<T> e)
    {
        if ( e == null )
            return null;

        if ( e.isOptional() )
            return e;

        KmValidator<T> copy;
        copy = e.getCopy();
        copy.setOptional();
        return copy;
    }

}
