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

package com.kodemore.dbase3;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import com.kodemore.utility.Kmu;

public class KmDbaseRecordReader
{
    //##################################################
    //# variables
    //##################################################

    private KmDbaseFile _file;
    private InputStream _inputStream;
    private int         _nextIndex;
    private int         _lastIndex;
    private int         _recordLength;

    //##################################################
    //# constructor
    //##################################################

    public KmDbaseRecordReader(KmDbaseFile f)
    {
        _file = f;
        _nextIndex = 0;
        _lastIndex = _file.getRecordCount() - 1;
        _recordLength = _file.getHeader().getRecordByteCount();
        _open();
        _skipHeader();
    }

    //##################################################
    //# public
    //##################################################

    public boolean hasNext()
    {
        return _nextIndex <= _lastIndex;
    }

    public KmDbaseRecord next()
    {
        try
        {
            _nextIndex++;

            byte[] arr = new byte[_recordLength];
            int n = _inputStream.read(arr);
            if ( n != arr.length )
                throw new RuntimeException("Unable to read record.");

            KmDbaseRecord r;
            r = new KmDbaseRecord();
            r.setFile(_file);
            r.setData(arr);
            return r;
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void close()
    {
        _close();
    }

    //##################################################
    //# file
    //##################################################

    public void _open()
    {
        try
        {
            FileInputStream fs = new FileInputStream(_file.getPath());
            BufferedInputStream bs = new BufferedInputStream(fs, 1024);
            _inputStream = bs;
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void _skipHeader()
    {
        try
        {
            long expected = _file.getHeader().getHeaderByteCount() + 1;
            long actual = _inputStream.skip(expected);
            if ( expected != actual )
                throw new RuntimeException("Unable to skip header.");
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void _close()
    {
        try
        {
            if ( _inputStream == null )
                return;
            _inputStream.close();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    @Override
    protected void finalize()
    {
        try
        {
            _close();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

}
