/*
  Copyright (c) 2005-2011 www.kodemore.com

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

package com.kodemore.sql;

import com.kodemore.sql.adaptor.KmSqlAdaptor;

/**
 * I provide a common superclass for statements that use WHERE clauses.
 * The actual composition of the where is delegated to the condition builder.
 */
public abstract class KmSqlConditionalStatement
    extends KmSqlStatement
{
    //##################################################
    //# constants
    //##################################################

    public static final String WHERE = " WHERE ";

    //##################################################
    //# variables
    //##################################################

    private KmSqlCondition     _where;

    //##################################################
    //# constructor
    //##################################################

    public KmSqlConditionalStatement(KmSqlAdaptor a)
    {
        super(a);
        _where = newCondition();
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getSqlString()
    {
        throw new UnsupportedOperationException();
    }

    public KmSqlCondition where()
    {
        return _where;
    }

    public void setWhere(KmSqlCondition c)
    {
        _where = c;
    }

    public boolean hasWhere()
    {
        return _where.getConditionCount() > 0;
    }

    public KmSqlCondition newCondition()
    {
        return new KmSqlCondition(getAdaptor());
    }

    //##################################################
    //# printing
    //##################################################

    public void printWhereConditionsOn(KmSqlBuffer b)
    {
        if ( hasWhere() )
        {
            b.printLiteral(WHERE);
            _where.printOn(b);
        }
    }
}
