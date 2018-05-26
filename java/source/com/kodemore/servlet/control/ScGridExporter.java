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

package com.kodemore.servlet.control;

import java.util.function.Function;

import com.kodemore.collection.KmList;
import com.kodemore.filter.KmFilterIF;
import com.kodemore.servlet.utility.ScFormatter;
import com.kodemore.utility.Kmu;

/**
 * Used to export grid data in various formats.
 */
public abstract class ScGridExporter<T>
{
    //##################################################
    //# variables
    //##################################################

    private ScGrid<T> _grid;

    //##################################################
    //# constructor
    //##################################################

    public ScGridExporter(ScGrid<T> grid)
    {
        _grid = grid;
    }

    //##################################################
    //# export
    //##################################################

    public String exportString()
    {
        return new String(exportBytes());
    }

    public byte[] exportBytes()
    {
        KmFilterIF<T> filter = _grid.getFilterFactory().createFilter();
        return filter == null
            ? null
            : export(filter);
    }

    protected abstract byte[] export(KmFilterIF<T> filter);

    //##################################################
    //# support
    //##################################################

    protected ScFormatter getFormatter()
    {
        return ScFormatter.getInstance();
    }

    protected KmList<ScGridColumn<T>> getExportColumns()
    {
        return _grid.getColumns().select(e -> e.hasExportFunction() && e.isVisible());
    }

    protected Object getExportValueFor(ScGridColumn<T> col, T model)
    {
        Function<T,?> fn = col.getExportFunction();
        return Kmu.applySafe(fn, model);
    }
}
