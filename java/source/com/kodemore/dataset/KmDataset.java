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

package com.kodemore.dataset;

import com.kodemore.collection.KmList;
import com.kodemore.csv.KmCsvBuilder;

public class KmDataset
{
    //##################################################
    //# variables
    //##################################################

    private KmList<KmDatasetColumn> _columns;
    private KmList<KmDatasetRow>    _rows;

    //##################################################
    //# constructor
    //##################################################

    public KmDataset()
    {
        _columns = new KmList<>();
        _rows = new KmList<>();
    }

    //##################################################
    //# columns
    //##################################################

    public KmList<KmDatasetColumn> getColumns()
    {
        return _columns;
    }

    public KmDatasetColumn addColumn()
    {
        KmDatasetColumn e;
        e = new KmDatasetColumn(this, _columns.size());

        _columns.add(e);

        return e;
    }

    //##################################################
    //# rows
    //##################################################

    public KmList<KmDatasetRow> getRows()
    {
        return _rows;
    }

    public KmDatasetRow addRow()
    {
        KmDatasetRow e;
        e = new KmDatasetRow();

        _rows.add(e);

        return e;
    }

    //##################################################
    //# csv
    //##################################################

    public String generateCsv()
    {
        KmCsvBuilder out;
        out = new KmCsvBuilder();

        KmList<KmDatasetColumn> cols = getColumns();
        for ( KmDatasetColumn col : cols )
            out.printField(col.getHeader());

        out.endRecord();

        KmList<KmDatasetRow> rows = getRows();
        for ( KmDatasetRow row : rows )
        {
            KmList<Object> values = row.getValues();
            for ( Object value : values )
                out.printField(value);

            out.endRecord();
        }

        return out.toString();
    }
}
