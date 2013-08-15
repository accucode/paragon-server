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

package com.kodemore.sql;

import com.kodemore.sql.adaptor.KmSqlAdaptor;
import com.kodemore.utility.Kmu;

/**
 * I provide convenience methods for composing a delete statement.
 * If the number of rows to be deleted is known (or a min or max)
 * then the expected count should be set to reflect the rule.
 */
public class KmSqlDelete
    extends KmSqlConditionalStatement
    implements KmSqlUpdateIF
{
    //##################################################
    //# variables
    //##################################################

    private String _table;

    //##################################################
    //# constructor
    //##################################################

    public KmSqlDelete(KmSqlAdaptor a)
    {
        super(a);
        _table = null;
    }

    //##################################################
    //# accessing
    //##################################################

    public String getTable()
    {
        return _table;
    }

    public void setTable(String s)
    {
        _table = s;
    }

    public boolean hasTable()
    {
        return Kmu.hasValue(getTable());
    }

    //##################################################
    //# execute
    //##################################################

    @Override
    public int execute(KmSqlConnection con)
    {
        return _executeUpdate(con);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getSqlString()
    {
        KmSqlBuffer f = newBuffer();
        f.printLiteral("delete from ");
        f.printLiteral(_table);
        printWhereConditionsOn(f);
        return f.toString();
    }

    //##################################################
    //# validate
    //##################################################

    public void validate()
    {
        if ( !hasTable() )
            fatal("Must specify a table to delete from.");
    }

}
