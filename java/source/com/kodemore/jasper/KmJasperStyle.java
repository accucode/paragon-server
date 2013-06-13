/*
  Copyright (c) 2010-2010 www.kodemore.com

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

package com.kodemore.jasper;

import java.util.ArrayList;
import java.util.List;

public class KmJasperStyle
    extends KmJasperAbstractStyle
{
    //##################################################
    //# variables
    //##################################################

    private Boolean                        _default;
    private List<KmJasperConditionalStyle> _conditionalStyles;

    //##################################################
    //# constructor
    //##################################################

    public KmJasperStyle()
    {
        _conditionalStyles = new ArrayList<KmJasperConditionalStyle>();
    }

    //##################################################
    //# default
    //##################################################

    public void setDefault()
    {
        _default = true;
    }

    public boolean isDefault()
    {
        return _default != null && _default;
    }

    @Override
    public Boolean getDefault()
    {
        return _default;
    }

    //##################################################
    //# conditional styles
    //##################################################

    @Override
    public List<KmJasperConditionalStyle> getConditionalStyles()
    {
        return _conditionalStyles;
    }

    public KmJasperConditionalStyle addConditionalStyle()
    {
        KmJasperConditionalStyle e;
        e = new KmJasperConditionalStyle();
        _conditionalStyles.add(e);
        return e;
    }

    public KmJasperSubStyle addStyleIf(KmJasperExpression cond)
    {
        KmJasperConditionalStyle e;
        e = addConditionalStyle();
        e.setCondition(cond);
        return e.getSubStyle();
    }

}
