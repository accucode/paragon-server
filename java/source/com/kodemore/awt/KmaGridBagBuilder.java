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

package com.kodemore.awt;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JApplet;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class KmaGridBagBuilder
{
    //##################################################
    //# variables
    //##################################################

    private JComponent         _container;
    private GridBagLayout      _layout;
    private GridBagConstraints _defaults;
    private GridBagConstraints _current;

    private int                _nextColumn  = 0;
    private int                _nextRow     = 0;
    private int                _columnCount = 2;
    private int                _rowCount    = 0;
    private boolean            _fillArray[][];
    private boolean            _autoWrap;

    //##################################################
    //# constructors
    //##################################################

    public KmaGridBagBuilder()
    {
        this(new KmaPanel());
    }

    public KmaGridBagBuilder(JComponent c)
    {
        setContainer(c);
    }

    public KmaGridBagBuilder(JDialog e)
    {
        this((JComponent)e.getContentPane());
    }

    public KmaGridBagBuilder(JFrame e)
    {
        this((JComponent)e.getContentPane());
    }

    public KmaGridBagBuilder(JApplet e)
    {
        this((JComponent)e.getContentPane());
    }

    //##################################################
    //# accessing
    //##################################################

    public void setContainer(JComponent c)
    {
        _container = c;
        _layout = new GridBagLayout();
        _container.setLayout(_layout);
        _fillArray = new boolean[1][1];
        _autoWrap = true;
        _current = new GridBagConstraints();
        setColumns(2);
        setNorthWest();
        setFill();
        setDefault();
    }

    public JComponent getContainer()
    {
        return _container;
    }

    public int getColumns()
    {
        return _columnCount;
    }

    public void setColumns(int i)
    {
        _columnCount = i;
        _rowCount = 0;
    }

    public int getRows()
    {
        return _rowCount;
    }

    public void setRows(int i)
    {
        _rowCount = i;
        _columnCount = 0;
    }

    public boolean getAutoWrap()
    {
        return _autoWrap;
    }

    public void setAutoWrap(boolean o)
    {
        _autoWrap = o;
    }

    //##################################################
    //# actions
    //##################################################

    public void fillHoles(int w, int h)
    {
        Dimension d = new Dimension(w, h);

        for ( int i = 0; i < _fillArray.length; i++ )
            for ( int j = 0; j < _fillArray[i].length; j++ )
                if ( !_fillArray[i][j] )
                {
                    JPanel p;
                    p = new JPanel();
                    p.setMinimumSize(d);
                    p.setMaximumSize(d);
                    p.setPreferredSize(d);

                    addAt(p, i, j, 1, 1);
                }
    }

    //##################################################
    //# constraints
    //##################################################

    public void setDefault()
    {
        _defaults = getCurrent();
    }

    public void resetCurrent()
    {
        setCurrent(_defaults);
    }

    public GridBagConstraints getCurrent()
    {
        return (GridBagConstraints)_current.clone();
    }

    public void setCurrent(GridBagConstraints c)
    {
        _current = (GridBagConstraints)c.clone();
    }

    //##################################################
    //# testing
    //##################################################

    public boolean isHorizontal()
    {
        return _rowCount == 0;
    }

    public boolean isVertical()
    {
        return !isHorizontal();
    }

    public boolean isFilled(int x, int y)
    {
        if ( x > _fillArray.length - 1 )
            return false;

        if ( y > _fillArray[x].length - 1 )
            return false;

        return _fillArray[x][y];
    }

    //##################################################
    //# grid position
    //##################################################

    public void setLocation(int x, int y)
    {
        setX(x);
        setY(y);
    }

    public void setX(int i)
    {
        _nextColumn = i;
    }

    public void setY(int i)
    {
        _nextRow = i;
    }

    public void newColumn()
    {
        _nextColumn++;
        _nextRow = 0;
    }

    public void newRow()
    {
        _nextRow++;
        _nextColumn = 0;
    }

    public void skip(int n)
    {
        for ( int i = 0; i < n; i++ )
            skip();
    }

    public void skip()
    {
        if ( isHorizontal() )
        {
            if ( _nextColumn >= _columnCount )
                newRow();
            _nextColumn++;
        }
        else
        {
            if ( _nextRow >= _rowCount )
                newColumn();
            _nextRow++;
        }
    }

    //##################################################
    //# grid size
    //##################################################

    public void setSize(int w, int h)
    {
        setWidth(w);
        setHeight(h);
    }

    public void setWidth(int i)
    {
        _current.gridwidth = i;
    }

    public void setHeight(int i)
    {
        _current.gridheight = i;
    }

    public void setRemainder()
    {
        if ( isHorizontal() )
            setHorizontalRemainder();
        else
            setVerticalRemainder();
    }

    public void setHorizontalRemainder()
    {
        setWidth(GridBagConstraints.REMAINDER);
    }

    public void setVerticalRemainder()
    {
        setHeight(GridBagConstraints.REMAINDER);
    }

    public void setRelativeWidth()
    {
        if ( isHorizontal() )
            setHorizontalRelativeWidth();
        else
            setVerticalRelativeWidth();
    }

    public void setHorizontalRelativeWidth()
    {
        setWidth(GridBagConstraints.RELATIVE);
    }

    public void setVerticalRelativeWidth()
    {
        setHeight(GridBagConstraints.RELATIVE);
    }

    //##################################################
    //# padding
    //##################################################

    public void setPadding(int x, int y)
    {
        setPaddingX(x);
        setPaddingY(y);
    }

    public void setPaddingX(int i)
    {
        _current.ipadx = i;
    }

    public void setPaddingY(int i)
    {
        _current.ipady = i;
    }

    //##################################################
    //# fill
    //##################################################

    public void setFill()
    {
        _current.fill = GridBagConstraints.BOTH;
    }

    public void setHorizontalFill()
    {
        _current.fill = GridBagConstraints.HORIZONTAL;
    }

    public void setVerticalFill()
    {
        _current.fill = GridBagConstraints.VERTICAL;
    }

    public void setNoFill()
    {
        _current.fill = GridBagConstraints.NONE;
    }

    //##################################################
    //# anchor
    //##################################################

    public void setLeft()
    {
        setWest();
    }

    public void setRight()
    {
        setEast();
    }

    public void setTop()
    {
        setNorth();
    }

    public void setBottom()
    {
        setSouth();
    }

    public void setTopLeft()
    {
        setNorthWest();
    }

    public void setTopRight()
    {
        setNorthEast();
    }

    public void setBottomLeft()
    {
        setSouthWest();
    }

    public void setBottomRight()
    {
        setSouthEast();
    }

    public void setCenter()
    {
        _current.anchor = GridBagConstraints.CENTER;
    }

    public void setNorth()
    {
        _current.anchor = GridBagConstraints.NORTH;
    }

    public void setSouth()
    {
        _current.anchor = GridBagConstraints.SOUTH;
    }

    public void setEast()
    {
        _current.anchor = GridBagConstraints.EAST;
    }

    public void setWest()
    {
        _current.anchor = GridBagConstraints.WEST;
    }

    public void setNorthEast()
    {
        _current.anchor = GridBagConstraints.NORTHEAST;
    }

    public void setNorthWest()
    {
        _current.anchor = GridBagConstraints.NORTHWEST;
    }

    public void setSouthEast()
    {
        _current.anchor = GridBagConstraints.SOUTHEAST;
    }

    public void setSouthWest()
    {
        _current.anchor = GridBagConstraints.SOUTHWEST;
    }

    //##################################################
    //# insets
    //##################################################

    public void setInsets(int t, int l, int b, int r)
    {
        _current.insets = new Insets(t, l, b, r);
    }

    public void setInsets(int x, int y)
    {
        setInsets(y, x, y, x);
    }

    public void setInsets(int i)
    {
        setInsets(i, i);
    }

    public void setTopInset(int i)
    {
        _current.insets.top = i;
    }

    //##################################################
    //# grid
    //##################################################

    public void setGridX(int i)
    {
        _current.gridx = i;
    }

    public void setGridY(int i)
    {
        _current.gridy = i;
    }

    public void setRelativeGridX()
    {
        setGridX(GridBagConstraints.RELATIVE);
    }

    public void setRelativeGridY()
    {
        setGridY(GridBagConstraints.RELATIVE);
    }

    //##################################################
    //# weight
    //##################################################

    public void setWeight(double x, double y)
    {
        setWeightX(x);
        setWeightY(y);
    }

    public void setWeightX(double x)
    {
        _current.weightx = (float)x;
    }

    public void setWeightY(double y)
    {
        _current.weighty = (float)y;
    }

    //##################################################
    //# adding
    //##################################################

    public void add(JComponent c)
    {
        add(c, -1, -1);
    }

    public void add(JComponent c, int w, int h)
    {
        _setNextPosition();
        _add(c, w, h);
    }

    public KmaLabel add(String s)
    {
        setNoFill();
        setNorthWest();
        setWeight(0, 0);
        return addLabel(s);
    }

    public KmaLabel addLabel(String s)
    {
        KmaLabel e = new KmaLabel(s);
        add(e);
        return e;
    }

    public void add(String s, JComponent c)
    {
        add(s, c, -1, -1);
    }

    public void add(String s, JComponent c, int w, int h)
    {
        add(s);
        add(c, w, h);
    }

    public void addWithTitle(String s, JComponent c)
    {
        Border b1 = BorderFactory.createEtchedBorder();
        Border b2 = BorderFactory.createTitledBorder(b1, s);
        c.setBorder(b2);
        add(c);
    }

    public void addButton(String name, Object receiver, String message)
    {
        KmaAction a = new KmaBlockAction(name, receiver, message);
        KmaButton b = a.newButton();
        add(b);
    }

    //##################################################
    //# adding (at)
    //##################################################

    public void addAt(JComponent c, int x, int y)
    {
        _setConstraintPosition(x, y);
        _add(c);
    }

    public void addAt(JComponent c, int x, int y, int w, int h)
    {
        setSize(w, h);
        addAt(c, x, y);
    }

    //##################################################
    //# adding (gaps)
    //##################################################

    public void addGaps(int wh, int n)
    {
        for ( int i = 0; i < n; i++ )
            addGap(wh);
    }

    public void addGap(int i)
    {
        addGap(i, i);
    }

    public void addGap(int w, int h)
    {
        Dimension d = new Dimension(w, h);

        JPanel p;
        p = new JPanel();
        p.setMinimumSize(d);
        p.setPreferredSize(d);
        p.setMaximumSize(d);

        setWeight(0, 0);
        add(p);
    }

    public void addBigGap()
    {
        Dimension d = new Dimension(1, 1);

        JPanel p;
        p = new JPanel();
        p.setMinimumSize(d);
        p.setPreferredSize(d);
        p.setMaximumSize(d);

        setWeight(1, 1);
        add(p);
    }

    //##################################################
    //# private
    //##################################################

    public void _add(JComponent c)
    {
        _add(c, -1, -1);
    }

    public void _add(JComponent c, int w, int h)
    {
        if ( _autoWrap )
            c = _wrap(c);

        if ( w > 0 )
        {
            Dimension d = new Dimension(w, h);
            c.setPreferredSize(d);
            c.setMinimumSize(d);
        }

        _markFillArray();
        _layout.setConstraints(c, _current);
        _container.add(c);

        resetCurrent();
    }

    public JComponent _wrap(JComponent c)
    {
        if ( c instanceof JTextArea || c instanceof JTable || c instanceof JList )
            return new JScrollPane(c);
        return c;
    }

    public void _setNextPosition()
    {
        while ( true )
        {
            if ( isHorizontal() )
                _setNextColumnPosition();
            else
                _setNextRowPosition();

            if ( !_hasCollision() )
                break;
        }
    }

    public boolean _hasCollision()
    {
        int x = _current.gridx;
        int y = _current.gridy;

        return isFilled(x, y);
    }

    public void _setNextColumnPosition()
    {
        int w = _current.gridwidth;
        boolean isRemainder = w == GridBagConstraints.REMAINDER;

        int x = _nextColumn;

        if ( !isRemainder )
            x += w;

        if ( _nextColumn > 0 && x > _columnCount )
            newRow();

        _setConstraintPosition();

        if ( isRemainder )
            newRow();
        else
            _nextColumn += w;
    }

    public void _setNextRowPosition()
    {
        int h = _current.gridheight;
        boolean isRemainder = h == GridBagConstraints.REMAINDER;
        int y = _nextRow;

        if ( !isRemainder )
            y += h;

        if ( _nextRow > 0 && y > _rowCount )
            newColumn();

        _setConstraintPosition();

        if ( isRemainder )
            newColumn();
        else
            _nextRow += h;
    }

    public void _setConstraintPosition()
    {
        _setConstraintPosition(_nextColumn, _nextRow);
    }

    public void _setConstraintPosition(int x, int y)
    {
        _current.gridx = x;
        _current.gridy = y;
    }

    public void _markFillArray()
    {
        int x1 = _current.gridx;
        int x2 = x1 + _current.gridwidth - 1;

        int y1 = _current.gridy;
        int y2 = y1 + _current.gridheight - 1;

        for ( int x = x1; x <= x2; x++ )
        {
            _checkFillArraySize(x, y2);

            for ( int y = y1; y <= y2; y++ )
                _fillArray[x][y] = true;
        }
    }

    public void _checkFillArraySize(int x, int y)
    {
        int oldw = _fillArray.length;
        int oldh = _fillArray[0].length;

        if ( oldw < x + 1 || oldh < y + 1 )
        {
            int neww = Math.max(oldw, x + 1);
            int newh = Math.max(oldh, y + 1);
            boolean arr[][] = new boolean[neww][newh];

            for ( int i = 0; i < oldw; i++ )
                for ( int j = 0; j < oldh; j++ )
                    arr[i][j] = _fillArray[i][j];

            _fillArray = arr;
        }
    }

    public void _printFillArray()
    {
        for ( boolean[] row : _fillArray )
        {
            for ( boolean col : row )
                System.out.print(formatXo(col));

            System.out.println();
        }
    }

    public String formatXo(boolean b)
    {
        return b
            ? "x"
            : "o";
    }
}
