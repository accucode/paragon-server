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

package com.kodemore.thread;

import java.lang.ref.Reference;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;

import com.kodemore.log.KmLog;
import com.kodemore.utility.Kmu;

/**
 * USE WITH CAUTION.
 *
 * I am used to find and clear thread local references.
 * 
 * I have been tested with JDK 5 & 6.  Since I rely on reflection
 * to access private variables in the java.lang package, it is 
 * reasonable to expect that this code may break on other jdks.
 *
 * Also, clearing all of the thread locals is a very heavy-handed,
 * "nuclear" option.  Currently, the only known use is to during
 * the servlet container shutdown process to ensure that the VM
 * can shutdown cleanly.  However, a the normal jvm uses some
 * thread locals of its own, so things may quit working normally
 * once you clear the thread locals.  For example, the FloatingDecimal
 * class uses thread locals, so you can no longer use the jdk classes
 * for format decimal numbers if you clear all thread locals.
 */
public class KmThreadLocalCleaner
{
    //##################################################
    //# thread locals
    //##################################################

    public void cleanAll()
    {
        begin("all");

        Set<Thread> v = getAllThreads();
        for ( Thread e : v )
            clean(e);

        end();
    }

    public void cleanCurrentThread()
    {
        begin("current");

        Thread e = Thread.currentThread();
        clean(e);

        end();
    }

    public void cleanThread(Thread e)
    {
        begin(e.toString());
        clean(e);
        end();
    }

    //##################################################
    //# counts
    //##################################################

    private void begin(String name)
    {
        KmLog.info("Thread local cleaner, %s...", name);
    }

    private void end()
    {
        KmLog.info("Thread local cleaner, done.");
    }

    //##################################################
    //# private 
    //##################################################

    private void clean(Thread thread)
    {
        try
        {
            _clean(thread);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    /**
     * Clean all threadlocals for a particular thread.  This relies on
     * reflection to access various variables that would otherwise be
     * private.  Setting aside a few guard clauses, this method really
     * just accomplishes the following:
     * 
     *      table = thread.threadLocals.table;
     *      for ( e : table )
     *          e.value = null;
     */
    private void _clean(Thread thread) throws Exception
    {
        Field threadLocalsField;
        threadLocalsField = Thread.class.getDeclaredField("threadLocals");
        threadLocalsField.setAccessible(true);

        Object threadLocalMap = threadLocalsField.get(thread);
        if ( threadLocalMap == null )
            return;

        Class<?> klass;
        klass = Class.forName("java.lang.ThreadLocal$ThreadLocalMap");

        Field tableField;
        tableField = klass.getDeclaredField("table");
        tableField.setAccessible(true);

        Object table = tableField.get(threadLocalMap);
        int threadLocalCount = Array.getLength(table);

        for ( int i = 0; i < threadLocalCount; i++ )
        {
            Object entry = Array.get(table, i);
            if ( entry != null )
            {
                Method threadLocalMethod;
                threadLocalMethod = entry.getClass().getMethod("get");
                threadLocalMethod.setAccessible(true);
                Object threadLocal = threadLocalMethod.invoke(entry);

                Field valueField;
                valueField = entry.getClass().getDeclaredField("value");
                valueField.setAccessible(true);
                Object value = valueField.get(entry);

                if ( value != null )
                {
                    log(threadLocal, value);

                    valueField.set(entry, null);
                }
            }
        }
    }

    private void log(Object threadLocal, Object value)
    {
        StringBuilder out;
        out = new StringBuilder();
        out.append("Thread local cleaner, FOUND ");
        out.append(threadLocal.getClass().getName());
        out.append(" => ");
        out.append(value.getClass().getName());

        if ( value instanceof Reference<?> )
        {
            Reference<?> ref = (Reference<?>)value;
            Object refValue = ref.get();

            out.append(" => ");

            if ( refValue == null )
                out.append("null");
            else
                out.append(refValue.getClass().getName());
        }

        out.append(".");

        KmLog.info(out.toString());
    }

    /**
     * Get all active threads.  The approach used here is arguably 
     * a little slower that some others, but it is very simple and
     * reliable.
     */
    private Set<Thread> getAllThreads()
    {
        return Thread.getAllStackTraces().keySet();
    }

}
