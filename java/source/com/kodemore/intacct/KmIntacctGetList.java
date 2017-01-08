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

package com.kodemore.intacct;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;
import com.kodemore.xml.utility.KmXmlBuilder;

/**
 * A request to fetch a list of objects.
 */
public class KmIntacctGetList
    extends KmIntacctFunction
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The type of object to return. E.g.: customer.
     * Required. Default is null.
     */
    private KmIntacctGetListObject _object;

    /**
     * The 0-based index of the first element to return.
     * Default = null, (start at beginning).
     */
    private Integer                _index;

    /**
     * The maximum number of results to return.
     * Default = null (no limit).
     */
    private Integer                _count;

    /**
     * If true, include private objects in the result.
     * Default = false.
     */
    private boolean                _showsPrivate;

    /**
     * The specific fields to include in the result.
     * Default is empty (shows all fields)
     */
    private KmList<String>         _fields;

    /**
     * The fields to sort on.
     * Default is none.
     */
    private KmIntacctSort          _sort;

    /**
     * The filter to apply to the results.
     * Default is an empty AND, effectively no filter.
     */
    private KmIntacctFilter        _filter;

    //##################################################
    //# constructor
    //##################################################

    public KmIntacctGetList()
    {
        _fields = new KmList<>();
        _sort = new KmIntacctSort();
        _filter = new KmIntacctFilter();
    }

    //##################################################
    //# object
    //##################################################

    public KmIntacctGetListObject getObject()
    {
        return _object;
    }

    public void setObject(KmIntacctGetListObject e)
    {
        _object = e;
    }

    //##################################################
    //# index
    //##################################################

    public Integer getIndex()
    {
        return _index;
    }

    public void setIndex(Integer e)
    {
        _index = e;
    }

    public boolean hasIndex()
    {
        return _index != null;
    }

    public void setIndexToNextBatch()
    {
        if ( !hasCount() )
            throw Kmu.newFatal("Invalid batch, count is not set.");

        int i = hasIndex()
            ? getIndex()
            : 0;

        setIndex(i + getCount());
    }

    //##################################################
    //# count
    //##################################################

    public Integer getCount()
    {
        return _count;
    }

    public void setCount(Integer e)
    {
        _count = e;
    }

    public boolean hasCount()
    {
        Integer n = getCount();
        return n != null && n > 0;
    }

    //##################################################
    //# shows private
    //##################################################

    public boolean getShowsPrivate()
    {
        return _showsPrivate;
    }

    public void setShowsPrivate(boolean e)
    {
        _showsPrivate = e;
    }

    //##################################################
    //# fields
    //##################################################

    /**
     * Used to select specific fields.
     * If not called, all fields will be included.
     */
    public void selectField(String e)
    {
        _fields.add(e);
    }

    //##################################################
    //# sort
    //##################################################

    public KmIntacctSortField sortOn(String field)
    {
        return _sort.addAscending(field);
    }

    //##################################################
    //# filter
    //##################################################

    public KmIntacctFilter getFilter()
    {
        return _filter;
    }

    /**
     * Add an expression to the TOP-level filter.
     * This provides a convenience way to compose simple filters.
     * Use getFilter() when nested junctions (AND/ORs) are required.
     */
    public KmIntacctExpression where(String field)
    {
        KmIntacctExpression e;
        e = getFilter().addExpression(field);
        e.setField(field);
        return e;
    }

    //##################################################
    //# compose
    //##################################################

    @Override
    public void composeActionOn(KmXmlBuilder out)
    {
        out.open("get_list");
        out.printAttribute("object", getObject());
        out.printAttribute("start", getIndex());
        out.printAttribute("maxitems", getCount());
        out.printAttribute("showprivate", getShowsPrivate());
        out.close();

        _filter.composeOn(out);
        _sort.composeOn(out);
        composeFieldsOn(out);

        out.end();
    }

    private void composeFieldsOn(KmXmlBuilder out)
    {
        if ( _fields.isEmpty() )
            return;

        out.begin("fields");

        for ( String e : _fields )
            out.value("field", e);

        out.end();
    }

}
