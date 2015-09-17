/*
  Copyright (c) 2005-2014 www.kodemore.com

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

package com.kodemore.exception.error;

public abstract class KmValidationError
    extends KmError
{
    //##################################################
    //# constructor
    //##################################################

    public KmValidationError(String model, String field)
    {
        _model = model;
        _field = field;
    }

    //##################################################
    //# variables
    //##################################################

    private String _model;
    private String _field;

    //##################################################
    //# accessing
    //##################################################

    public String getModel()
    {
        return _model;
    }

    public void setModel(String e)
    {
        _model = e;
    }

    public String getField()
    {
        return _field;
    }

    public void setField(String e)
    {
        _field = e;
    }

    //##################################################
    //# format
    //##################################################

    @Override
    public String formatMessage()
    {
        StringBuilder sb = new StringBuilder();
        formatSubject(sb);
        formatProblem(sb);
        return sb.toString();
    }

    public void formatSubject(StringBuilder out)
    {
        out.append(_field);
        out.append(" of ");
        out.append(_model);
        out.append(": ");
    }

}
