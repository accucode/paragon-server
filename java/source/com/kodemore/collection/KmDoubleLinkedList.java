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

package com.kodemore.collection;

public class KmDoubleLinkedList<E>
{
    //##################################################
    //# variables
    //##################################################

    private KmDoubleLinkedNode<E> _first;
    private KmDoubleLinkedNode<E> _last;
    private int                   _maximumCount = Integer.MAX_VALUE;
    private int                   _count;

    //##################################################
    //# accessing
    //##################################################

    public KmDoubleLinkedNode<E> getFirst()
    {
        return _first;
    }

    public void setFirst(KmDoubleLinkedNode<E> e)
    {
        _first = e;
    }

    public KmDoubleLinkedNode<E> getLast()
    {
        return _last;
    }

    public void setLast(KmDoubleLinkedNode<E> e)
    {
        _last = e;
    }

    public int getMaximumCount()
    {
        return _maximumCount;
    }

    public void setMaximumCount(int e)
    {
        _maximumCount = e;
    }

    public int getCount()
    {
        return _count;
    }

    public void setCount(int e)
    {
        _count = e;
    }

    //##################################################
    //# public
    //##################################################

    public KmDoubleLinkedNode<E> addLast(E value)
    {
        KmDoubleLinkedNode<E> o = new KmDoubleLinkedNode<>(value);
        return addLast(o);
    }

    public KmDoubleLinkedNode<E> add(E value)
    {
        if ( _count == _maximumCount )
            remove(_first);
        return addLast(value);
    }

    public Object removeFirst()
    {
        Object value = _first.getValue();
        remove(_first);
        return value;
    }

    public KmDoubleLinkedNode<E> addLast(KmDoubleLinkedNode<E> o)
    {
        if ( _first == null )
            _first = o;

        if ( _last != null )
        {
            _last.setNext(o);
            o.setPrevious(_last);
        }

        _last = o;
        _count++;
        return o;
    }

    public void remove(KmDoubleLinkedNode<E> node)
    {
        KmDoubleLinkedNode<E> previous = node.getPrevious();
        KmDoubleLinkedNode<E> next = node.getNext();

        if ( previous != null )
            previous.setNext(next);

        if ( next != null )
            next.setPrevious(previous);

        node.setPrevious(null);
        node.setNext(null);

        _count--;

        if ( node == _first )
            _first = next;

        if ( node == _last )
            _last = previous;
    }

    /**
     * Remove the node from its current position, and add it last.
     */
    public void promote(KmDoubleLinkedNode<E> node)
    {
        remove(node);
        addLast(node);
    }

    //##################################################
    //# testing
    //##################################################

    public boolean isFull()
    {
        return _maximumCount <= _count;
    }

    //##################################################
    //# debug
    //##################################################

    public void printAll()
    {
        System.out.println("double linked list values:");
        KmDoubleLinkedNode<E> node = _first;

        while ( node != null )
        {
            System.err.println("    node.getValue(): " + node.getValue());
            node = node.getNext();
        }

    }
}
