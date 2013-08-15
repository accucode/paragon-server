/*
  Copyright (c) 2005-2013 www.kodemore.com

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

package com.kodemore.utility;

import com.kodemore.comparator.KmComparator;

/**
 * I provide a simpel comparator to sort associations by key.
 * This *assumes* that the keys are comparable.
 * Type checking is disabled.
 */
public class KmAssociationKeyComparator<K, V>
    extends KmComparator<KmAssociation<K,V>>
{
    @Override
    @SuppressWarnings(
    {
        "rawtypes",
        "unchecked"
    })
    public int compare(KmAssociation<K,V> o1, KmAssociation<K,V> o2)
    {
        Comparable key1 = (Comparable)o1.getKey();
        Comparable key2 = (Comparable)o2.getKey();
        return key1.compareTo(key2);
    }
}
