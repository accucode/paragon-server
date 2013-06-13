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

package com.kodemore.filer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import com.kodemore.utility.Kmu;

public class KmFilerDebugUtility
{
    /**
     * Write an instance graph rooted at e, to some file path.
     */
    public static void writeObject(String path, KmFilerIF e)
    {
        KmFilerDebugOutputStream out = null;
        try
        {
            FileOutputStream fs = new FileOutputStream(path);
            BufferedOutputStream bs = new BufferedOutputStream(fs);

            out = new KmFilerDebugOutputStream(bs);
            out.writeObject(e);
            out.flush();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
        finally
        {
            if ( out != null )
                out.closeSafely();
        }
    }

    /**
     * Write an instance graph rooted at v to some file path.
     * v must contain nulls or instances of KmFilerIF.
     */
    public static void writeList(String path, List<KmFilerIF> v)
    {
        KmFilerDebugOutputStream out = null;
        try
        {
            FileOutputStream fs = new FileOutputStream(path);
            BufferedOutputStream bs = new BufferedOutputStream(fs);

            out = new KmFilerDebugOutputStream(bs);
            out.writeList(v);
            out.flush();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
        finally
        {
            if ( out != null )
                out.closeSafely();
        }
    }

    /**
     * Create and populate an instance of KmFilerIF from the file path.
     */
    public static KmFilerIF readObject(String path, Class<?> c)
    {
        KmFilerDebugInputStream in = null;
        try
        {
            FileInputStream fs = new FileInputStream(new File(path));
            BufferedInputStream bs = new BufferedInputStream(fs);
            in = new KmFilerDebugInputStream(bs);
            KmFilerIF e = in.readObject(c);
            return e;
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
        finally
        {
            if ( in != null )
                in.closeSafely();
        }
    }

    /**
     * Create and populate an instance of KmFilerIF from the file path.
     */
    public static List<?> readList(String path, Class<?> c)
    {
        KmFilerDebugInputStream in = null;
        try
        {
            FileInputStream fs = new FileInputStream(path);
            BufferedInputStream bs = new BufferedInputStream(fs);
            in = new KmFilerDebugInputStream(bs);
            return in.readList(c);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
        finally
        {
            if ( in != null )
                in.closeSafely();
        }
    }

}
