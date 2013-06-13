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

package com.kodemore.awt.grid;

public abstract class KmaGridDateIntervalSelectionModel
    implements KmaGridSelectionModelIF
{
    /*
     //##################################################
     //# instance creation
     //##################################################

     public static KmGridDateIntervalSelectionModel create(KmGrid g)
     {
     KmGridDateIntervalSelectionModel m;
     m = new KmGridDateIntervalSelectionModel();
     m.setGrid(g);
     return m;
     }

     //##################################################
     //# variables
     //##################################################

     public KmGrid grid;
     public KmDateIntervalIF dateInterval;
     public KmDateIF anchor;

     //##################################################
     //# accessing
     //##################################################

     public KmGrid getGrid()
     {
     return grid;
     }

     public void setGrid(KmGrid o)
     {
     grid = o;
     }

     public KmDateIntervalIF getDateInterval()
     {
     return dateInterval == null
     ? null
     : (KmDateIntervalIF) dateInterval.getCopy();
     }

     public void setDateInterval(KmDateIntervalIF di)
     {
     dateInterval = ( di == null )
     ? null
     : (KmDateIntervalIF) di.getCopy();
     }

     //##################################################
     //# abstract accessing
     //##################################################

     public Point getSelection()
     {
     Vector v = getSelections();
     return( v.isEmpty() )
     ? null
     : (Point) v.firstElement();
     }

     public Vector getSelections()
     {
     Insets i = getInsets();
     Point p = new Point();
     Vector v = new Vector();
     if ( dateInterval == null ) return v;
     for ( int x=i.left; x<=i.right; x++ )
     for ( int y=i.top; y<=i.bottom; y++ )
     {
     p.setLocation(x, y);
     KmDateIF d = getDateAt(p);
     if ( isSelected(d) )
     v.addElement(new Point(p));
     }
     return v;
     }

     //##################################################
     //# select
     //##################################################

     public void select(Point p)
     {
     KmDateIF d = getDateAt(p);
     anchor = d;
     if ( dateInterval == null )
     dateInterval = new KmDateInterval();
     dateInterval.setStartDate(d);
     dateInterval.setEndDate(d);
     }

     public void deselect(Point p)
     {
     if ( ! isSelected(p) ) return;
     KmDateIF d = getDateAt(p);
     d.addDays(-1);
     if ( dateInterval.getStartDate().isAfter(d) )
     clear();
     else
     dateInterval.setEndDate(d);
     }

     public void toggle(Point p)
     {
     if ( isSelected(p) )
     if ( getSelectionCount() == 1 )
     {
     clear();
     return;
     }
     select(p);
     }

     //##################################################
     //# extend
     //##################################################

     public void extendSelection(Point p)
     {
     KmDateIF d = getDateAt(p);
     if ( anchor.isBefore(d) )
     dateInterval.setEndDate(d);
     else
     {
     dateInterval.setStartDate(d);
     dateInterval.setEndDate(anchor);
     }
     }

     public void extendDeselection(Point p)
     {
     }
     public void extendToggle(Point p)
     {
     }

     //##################################################
     //# actions
     //##################################################

     public void clear()
     {
     dateInterval = null;
     }

     //##################################################
     //# testing
     //##################################################

     public boolean hasSelection()
     {
     return dateInterval != null;
     }

     public boolean isSelected(Point p)
     {
     KmDateIF d = getDateAt(p);
     return isSelected(d);
     }

     public boolean isSelected(KmDateIF d)
     {
     return( dateInterval == null )
     ? false
     : dateInterval.contains(d);
     }

     //##################################################
     //# private
     //##################################################

     public Insets getInsets()
     {
     int t = 0;
     int l = 0;
     int b = getGrid().getRowCount() - 1;
     int r = getGrid().getColumnCount() - 1;
     return new Insets(t, l, b, r);
     }

     public KmDateIF getDateAt(Point p)
     {
     return(KmDateIF) getGrid().getValueModel().getValueAt(p.x, p.y);
     }

     public int getSelectionCount()
     {
     return( dateInterval == null )
     ? 0
     : dateInterval.getNumberOfDays();
     }
     */
}
