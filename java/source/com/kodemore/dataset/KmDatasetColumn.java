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

package com.kodemore.dataset;

import com.kodemore.adaptor.KmAbstractAdaptor;
import com.kodemore.adaptor.KmAdaptorIF;

public class KmDatasetColumn
{
    //##################################################
    //# variables
    //##################################################

    private KmDataset _dataset;
    private int       _index;
    private String    _header;

    //##################################################
    //# constructor
    //##################################################

    public KmDatasetColumn(KmDataset dataset, int index)
    {
        _dataset = dataset;
        _index = index;
    }

    //##################################################
    //# context
    //##################################################

    public KmDataset getDataset()
    {
        return _dataset;
    }

    public int getIndex()
    {
        return _index;
    }

    //##################################################
    //# accessing
    //##################################################

    public String getHeader()
    {
        return _header;
    }

    public void setHeader(String e)
    {
        _header = e;
    }

    //##################################################
    //# abstract accessing
    //##################################################

    public KmAdaptorIF<KmDatasetRow,Object> getAdaptor()
    {
        return new KmAbstractAdaptor<KmDatasetRow,Object>()
        {
            @Override
            public Object getValue(KmDatasetRow row)
            {
                return row.getValues().getAtSafe(getIndex());
            }
        };
    }
}
