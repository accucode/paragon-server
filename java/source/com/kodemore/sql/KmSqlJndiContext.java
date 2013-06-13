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

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.kodemore.utility.Kmu;

/**
 * I lookup a data source through JNDI using a name, initial context
 * and provider url.
 */
public class KmSqlJndiContext
{
    //##################################################
    //# static variables
    //##################################################

    private static InitialContext _initialContext = null;

    //##################################################
    //# static methods
    //##################################################

    /**
     * Example values for paramenters:
     * jndiName:                  jdbc/iiop:/localhost:900
     * jndiInitialContextFactory: com.ibm.ejs.ns.jndi.CNInitialContextFactory
     * jndiProviderUrl:           <application>DS
     */
    public static Object lookup(String name, String initialContextFactory, String providerUrl)
    {
        Object e = null;
        try
        {
            if ( _initialContext == null )
            {
                Hashtable<String,String> m = new Hashtable<String,String>();
                m.put(Context.INITIAL_CONTEXT_FACTORY, initialContextFactory);
                m.put(Context.PROVIDER_URL, providerUrl);
                _initialContext = new InitialContext(m);
            }
            e = _initialContext.lookup(name);
        }
        catch ( NamingException ex )
        {
            throw Kmu.toRuntime(ex);
        }
        return e;

    }
}
