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

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.DoubleType;

import com.kodemore.time.KmTimeUnit;
import com.kodemore.time.KmUnitDuration;

/**
 * Store a time duration as a double and a unit.
 */
public class KmhUnitDurationType
    extends KmhImmutableType
{
    private static final int VALUE_TYPE = java.sql.Types.DOUBLE;
    private static final int UNIT_TYPE  = java.sql.Types.VARCHAR;

    @Override
    public int[] sqlTypes()
    {
        return new int[]
        {
            VALUE_TYPE,
            UNIT_TYPE
        };
    }

    @Override
    public Class<?> returnedClass()
    {
        return KmUnitDuration.class;
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor impl, Object owner)
        throws HibernateException, SQLException
    {
        if ( rs.wasNull() )
            return null;

        Double value = (Double)DoubleType.INSTANCE.get(rs, names[0], impl);
        String code = rs.getString(names[1]);

        if ( value == null || code == null )
            return null;

        KmTimeUnit unit = KmTimeUnit.findCode(code);

        return new KmUnitDuration(value, unit);
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor impl)
        throws HibernateException, SQLException
    {
        if ( value == null )
        {
            st.setNull(index, VALUE_TYPE);
            st.setNull(index + 1, UNIT_TYPE);
            return;
        }

        KmUnitDuration ud = (KmUnitDuration)value;
        st.setDouble(index, ud.getValue());
        st.setString(index + 1, ud.getUnitCode());
    }

}
