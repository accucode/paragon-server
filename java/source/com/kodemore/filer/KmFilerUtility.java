/*
  Copyright (c) 2005-2014 www.kodemore.com

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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

import com.kodemore.utility.Kmu;

public final class KmFilerUtility
{
    //##################################################
    //# static
    //##################################################

    public static KmFilerIF readObject(String path, Class<?> c)
    {
        KmFilerUtility u;
        u = new KmFilerUtility();
        u.openInputStream(path);
        KmFilerIF e = u.readObject(c);
        u.close();
        return e;
    }

    public static void writeObject(String path, KmFilerIF e)
    {
        KmFilerUtility u;
        u = new KmFilerUtility();
        u.openOutputStream(path);
        u.writeObject(e);
        u.close();
    }

    public static List<?> readList(String path, Class<?> c)
    {
        KmFilerUtility u;
        u = new KmFilerUtility();
        u.openInputStream(path);
        List<?> e = u.readList(c);
        u.close();
        return e;
    }

    public static void writeList(String path, List<KmFilerIF> e)
    {
        KmFilerUtility u;
        u = new KmFilerUtility();
        u.openOutputStream(path);
        u.writeList(e);
        u.close();
    }

    public static List<String> readStringList(String path)
    {
        KmFilerUtility u;
        u = new KmFilerUtility();
        u.openInputStream(path);
        List<String> e = u.readStringList();
        u.close();
        return e;
    }

    public static void writeStringList(String path, List<String> e)
    {
        KmFilerUtility u;
        u = new KmFilerUtility();
        u.openOutputStream(path);
        u.writeStringList(e);
        u.close();
    }

    public static List<Double> readDoubleList(String path)
    {
        KmFilerUtility u;
        u = new KmFilerUtility();
        u.openInputStream(path);
        List<Double> e = u.readDoubleList();
        u.close();
        return e;
    }

    public static void writeDoubleList(String path, List<Double> e)
    {
        KmFilerUtility u;
        u = new KmFilerUtility();
        u.openOutputStream(path);
        u.writeDoubleList(e);
        u.close();
    }

    public static List<Integer> readIntegerList(String path)
    {
        KmFilerUtility u;
        u = new KmFilerUtility();
        u.openInputStream(path);
        List<Integer> e = u.readIntegerList();
        u.close();
        return e;
    }

    public static void writeIntegerList(String path, List<Integer> e)
    {
        KmFilerUtility u;
        u = new KmFilerUtility();
        u.openOutputStream(path);
        u.writeIntegerList(e);
        u.close();
    }

    //##################################################
    //# variables
    //##################################################

    private FileInputStream     _fileInputStream;
    private FileOutputStream    _fileOutputStream;

    private KmFilerInputStream  _filerInputStream;
    private KmFilerOutputStream _filerOutputStream;

    private boolean             _debug      = false;
    private boolean             _compress   = false;
    private int                 _bufferSize = 2048;

    //##################################################
    //# accessing
    //##################################################

    public boolean getDebug()
    {
        return _debug;
    }

    public void setDebug(boolean e)
    {
        _debug = e;
    }

    public boolean getCompress()
    {
        return _compress;
    }

    public void setCompress()
    {
        setCompress(true);
    }

    public void setCompress(boolean e)
    {
        _compress = e;
    }

    //##################################################
    //# private
    //##################################################

    public void openInputStream(String path)
    {
        try
        {
            _fileInputStream = new FileInputStream(path);
            InputStream in;
            in = _fileInputStream;
            in = new BufferedInputStream(in, _bufferSize);
            if ( _compress )
                in = new InflaterInputStream(in);
            if ( _debug )
                _filerInputStream = new KmFilerDebugInputStream(in);
            else
                _filerInputStream = new KmFilerInputStream(in);
        }
        catch ( Exception ex )
        {
            closeInputStream();
            throw Kmu.toRuntime(ex);
        }
    }

    public void openOutputStream(String path)
    {
        try
        {
            _fileOutputStream = new FileOutputStream(path);
            OutputStream out;
            out = _fileOutputStream;
            out = new BufferedOutputStream(out, _bufferSize);
            if ( _compress )
                out = new DeflaterOutputStream(out);
            if ( _debug )
                _filerOutputStream = new KmFilerDebugOutputStream(out);
            else
                _filerOutputStream = new KmFilerOutputStream(out);
        }
        catch ( Exception ex )
        {
            closeOutputStream();
            throw Kmu.toRuntime(ex);
        }
    }

    public void close()
    {
        closeInputStream();
        closeOutputStream();
    }

    public void closeInputStream()
    {
        try
        {
            if ( _filerInputStream != null )
            {
                _filerInputStream.close();
                return;
            }
            if ( _fileInputStream != null )
                _fileInputStream.close();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void closeOutputStream()
    {
        try
        {
            if ( _filerOutputStream != null )
            {
                _filerOutputStream.close();
                return;
            }
            if ( _fileOutputStream != null )
                _fileOutputStream.close();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    //##################################################
    //# file (object)
    //##################################################

    public KmFilerIF readObject(Class<?> c)
    {
        try
        {
            return _filerInputStream.readObject(c);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void writeObject(KmFilerIF e)
    {
        try
        {
            _filerOutputStream.writeObject(e);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    //##################################################
    //# file (list)
    //##################################################

    public List<?> readList(Class<?> c)
    {
        try
        {
            return _filerInputStream.readList(c);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void writeList(List<KmFilerIF> e)
    {
        try
        {
            _filerOutputStream.writeList(e);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    //##################################################
    //# file (string list)
    //##################################################

    public List<String> readStringList()
    {
        try
        {
            return _filerInputStream.readStringList();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void writeStringList(List<String> e)
    {
        try
        {
            _filerOutputStream.writeStringList(e);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    //##################################################
    //# file (double list)
    //##################################################

    public List<Double> readDoubleList()
    {
        try
        {
            return _filerInputStream.readDoubleList();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void writeDoubleList(List<Double> e)
    {
        try
        {
            _filerOutputStream.writeDoubleList(e);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    //##################################################
    //# file (integer list)
    //##################################################

    public List<Integer> readIntegerList()
    {
        try
        {
            return _filerInputStream.readIntegerList();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void writeIntegerList(List<Integer> e)
    {
        try
        {
            _filerOutputStream.writeIntegerList(e);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    //##################################################
    //# private
    //##################################################

    @Override
    protected void finalize() throws Throwable
    {
        close();
    }
}
