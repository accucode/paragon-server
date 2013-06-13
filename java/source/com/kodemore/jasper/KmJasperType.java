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

public enum KmJasperType
{
    //##################################################
    //# values
    //##################################################

    String("string", "java.lang.String"),
    Integer("integer", "java.lang.Integer"),
    Boolean("boolean", "java.lang.Boolean"),

    Byte("byte", "java.lang.Byte"),
    Date("date", "java.util.Date"),
    Timestamp("timestamp", "java.sql.Timestamp"),
    Time("time", "java.sql.Time"),
    Double("double", "java.lang.Double"),
    Float("float", "java.lang.Float"),
    InputStream("inputStream", "java.io.InputStream"),
    Long("long", "java.lang.Long"),
    Short("short", "java.lang.Short"),
    BigDecimal("bigDecimal", "java.math.BigDecimal"),
    Object("object", "java.lang.Object");

    //##################################################
    //# variables
    //##################################################

    private String _code;
    private String _name;

    //##################################################
    //# constructor
    //##################################################

    private KmJasperType(String code, String name)
    {
        _code = code;
        _name = name;
    }

    //##################################################
    //# accessing
    //##################################################

    public String getCode()
    {
        return _code;
    }

    public String getName()
    {
        return _name;
    }

    //##################################################
    //# testing
    //##################################################

    public boolean isString()
    {
        return this == String;
    }

    public boolean isInteger()
    {
        return this == Integer;
    }

    public boolean isBoolean()
    {
        return this == Integer;
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return "Type[" + getCode() + "]";
    }

    //##################################################
    //# static
    //##################################################

    public static KmJasperType findName(String value)
    {
        for ( KmJasperType e : values() )
            if ( e.getName().equals(value) )
                return e;
        return null;
    }
}
