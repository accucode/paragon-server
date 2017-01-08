/*
  Copyright (c) 2005-2016 www.kodemore.com

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
 * I provide a minimal 'list' interface.
 *
 * I am particularly used when the same instance may be returned in different
 * configurations from different positions in the list.  Clients must not bind
 * more than one element.
 *
 * To say this another way, each call to get(index), invalidates the use of
 * any previously bound value retrieved from the list.
 */
public interface KmVirtualList<T>
    extends Iterable<T>
{
    //##################################################
    //# core
    //##################################################

    int getSize();

    T get(int index);

    //##################################################
    //# convenience
    //##################################################

    boolean isEmpty();

    @Override
    Iterator<T> iterator();

    Iterator<T> reverseIterator();

    T getSafe(int index);

}
