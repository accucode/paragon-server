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

package com.kodemore.hibernate.type;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;

import com.kodemore.time.KmDate;
import com.kodemore.time.KmTime;

public class KmhTimeType
    extends KmhImmutableType
{
    private static final int TYPE = java.sql.Types.TIME;

    @Override
    public int[] sqlTypes()
    {
        return new int[]
        {
            TYPE
        };
    }

    @Override
    public Class<?> returnedClass()
    {
        return KmDate.class;
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor impl, Object owner)
        throws HibernateException, SQLException
    {
        Time e = rs.getTime(names[0]);
        if ( rs.wasNull() )
            return null;

        return KmTime.fromSqlTime(e);
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor impl)
        throws HibernateException, SQLException
    {
        if ( value == null )
        {
            st.setNull(index, TYPE);
            return;
        }

        KmTime kmTime = (KmTime)value;
        Time sqlTime = kmTime.toSqlTime();

        st.setTime(index, sqlTime);
    }

}
