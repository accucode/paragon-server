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

package com.kodemore.io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * I wrap a writer.  I do not directly provide additional functionality, but
 * instead provide a basis for subclass extension.
 *
 * Although I reference the delegate writer, I do NOT bind any other resources.
 * This means that clients can create a wrapper without needing to explicitly
 * close it.  A call to close on the wrapper will delegate the close to the underlying
 * writer.  However, clients may also simply close the underlying writer directly.
 * As long as the client closes the underlying writer, it is not necessary to
 * close the wrapper as well.
 */

public abstract class KmWrapperWriter
    extends Writer
{
    //##################################################
    //# variables
    //##################################################

    private Writer _delegate;

    //##################################################
    //# constructor
    //##################################################

    public KmWrapperWriter(Writer e)
    {
        super(e);
        _delegate = e;
    }

    public KmWrapperWriter(OutputStream e)
    {
        this(new OutputStreamWriter(e));
    }

    //##################################################
    //# file
    //##################################################

    @Override
    public void flush() throws IOException
    {
        _delegate.flush();
    }

    @Override
    public void close() throws IOException
    {
        _delegate.close();
    }

    //##################################################
    //# accessing
    //##################################################

    protected Writer getDelegate()
    {
        return _delegate;
    }
}
