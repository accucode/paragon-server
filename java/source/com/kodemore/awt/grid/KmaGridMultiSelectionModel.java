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

package com.kodemore.awt.grid;

import java.awt.Point;

import com.kodemore.collection.KmList;

public class KmaGridMultiSelectionModel
    implements KmaGridSelectionModelIF
{
    //##################################################
    //# variables
    //##################################################

    private KmList<KmaGridSelectionArea> _areas;

    //##################################################
    //# constructors
    //##################################################

    public KmaGridMultiSelectionModel()
    {
        _areas = new KmList<>();
    }

    //##################################################
    //# selection
    //##################################################

    @Override
    public void select(Point p)
    {
        newArea().select(p);
    }

    @Override
    public void deselect(Point p)
    {
        newArea().deselect(p);
    }

    @Override
    public void toggle(Point p)
    {
        newArea().toggle(p);
    }

    //##################################################
    //# extend
    //##################################################

    @Override
    public void extendSelection(Point p)
    {
        getArea().extendTo(p);
    }

    @Override
    public void extendDeselection(Point p)
    {
        getArea().extendTo(p);
    }

    @Override
    public void extendToggle(Point p)
    {
        getArea().extendTo(p);
    }

    //##################################################
    //# actions
    //##################################################

    @Override
    public void clear()
    {
        _areas.clear();
    }

    //##################################################
    //# testing
    //##################################################

    @Override
    public boolean isSelected(Point p)
    {
        boolean b = false;

        for ( KmaGridSelectionArea a : _areas )
            b = a.isSelected(p, b);

        return b;
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public Point getSelection()
    {
        KmList<Point> v = getSelections();
        return v.getFirstSafe();
    }

    @Override
    public KmList<Point> getSelections()
    {
        KmList<Point> v = new KmList<>();

        for ( KmaGridSelectionArea a : _areas )
            a.updateSelections(v);

        return v;
    }

    //##################################################
    //# private
    //##################################################

    public KmaGridSelectionArea newArea()
    {
        KmaGridSelectionArea a = new KmaGridSelectionArea();
        _areas.add(a);
        return a;
    }

    public KmaGridSelectionArea getArea()
    {
        return _areas.getLast();
    }

}
