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

package com.kodemore.hibernate.basic;

import org.hibernate.sql.JoinType;

import com.kodemore.hibernate.proxy.KmhProxy;

/**
 * I manage the join relationship between two tables.
 * Both inner and left-outer joins are supported.
 */
public class KmhJoin
    extends KmhCriteria
{
    //##################################################
    //# variables
    //##################################################

    private KmhCriteria _parent;
    private String      _entityName;
    private JoinType    _type;

    //##################################################
    //# constructor
    //##################################################

    public KmhJoin(KmhProxy c, KmhCriteria parent, String entityName, JoinType type)
    {
        super(c);
        _parent = parent;
        _entityName = entityName;
        _type = type;
    }

    //##################################################
    //# overrides
    //##################################################

    @Override
    public KmhRootCriteria getRoot()
    {
        return _parent.getRoot();
    }

    //##################################################
    //# accessing
    //##################################################

    public String getEntityName()
    {
        return _entityName;
    }

    public JoinType getType()
    {
        return _type;
    }

    public boolean hasType(JoinType e)
    {
        return _type == e;
    }

}
