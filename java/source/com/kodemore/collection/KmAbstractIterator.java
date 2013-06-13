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

package com.kodemore.collection;

import java.util.Iterator;

/**
 * I provide a convenience hook for creating simple Iterator extensions.
 */
public abstract class KmAbstractIterator<T>
    implements Iterator<T>
{
    /**
     * Define a constructor that calls initialize.
     */
    public KmAbstractIterator()
    {
        initialize();
    }

    /**
     * Create a hook that allows anonomous subclasses to initialize themselves
     * (they cannot override the constructor).
     */
    protected void initialize()
    {
        // subclass override
    }

    /**
     * Throw an unsupported operation exception by default.
     */
    @Override
    public void remove()
    {
        throw new UnsupportedOperationException();
    }
}
