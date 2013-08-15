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

package com.kodemore.servlet.control;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.utility.Kmu;

/**
 * A simple control which displays Code39 barcodes.
 * 
 * Only digits (0-9) can be encoded.  The value to be 
 * encoded will be automatically validated before display.
 * If the value is null or invalid, a warning will be 
 * displayed instead. The start and stop bit are added 
 * automtically.
 * 
 * Because of the limitations of barcode font formatting,
 * only code39 barcodes can currently be displayed.
 */
public class ScBarcodeCode39
    extends ScControl
{
    //##################################################
    //# variables
    //##################################################

    private String _value;

    //##################################################
    //# print
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        if ( hasValue() )
        {
            out.openDiv();
            out.printAttribute("style", "font-family:Code39AzaleaFont; font-size:72px;");
            out.close();
            out.printf("*%s*", getValue());
            out.endDiv();
        }
        else
        {
            out.openDiv();
            out.printAttribute("style", "color:red; font-weight:bold");
            out.close();
            out.print("[Invalid Value. Use only digits (0-9).]");
            out.endDiv();
        }
    }

    //##################################################
    //# accessing
    //##################################################

    public String getValue()
    {
        return _value;
    }

    /**
     * The value to be encoded.  Value is automatically validated.
     * Values that do not contain only digits are rejected.
     */
    public void setValue(String value)
    {
        _value = validate(value);
    }

    private boolean hasValue()
    {
        return getValue() != null;
    }

    //##################################################
    //# utility
    //##################################################

    private String validate(String value)
    {
        if ( Kmu.isEmpty(value) )
            return null;

        return Kmu.isAllDigits(value)
            ? value
            : null;
    }
}
