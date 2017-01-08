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

package com.kodemore.awt.grid;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.CellRendererPane;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class KmaGrid
    extends JComponent
    implements SwingConstants
{
    //##################################################
    //# variables
    //##################################################

    private KmaGridValueModelIF     _valueModel;
    private KmaGridSizeModelIF      _rowSizeModel;
    private KmaGridSizeModelIF      _columnSizeModel;
    private KmaGridSelectionModelIF _selectionModel;
    private KmaGridKeyModel         _keyModel;
    private KmaGridMouseModel       _mouseModel;
    private KmaGridActionModel      _actionModel;

    private KmaGridHeaderIF         _rowHeader;
    private KmaGridHeaderIF         _columnHeader;

    private KmaGridCellRendererIF   _cellRenderer;
    private CellRendererPane        _cellRendererPane;

    private JScrollBar              _horizontalScrollBar;
    private JScrollBar              _verticalScrollBar;

    private boolean                 _hasGridLines;
    private Color                   _gridLineColor;

    //##################################################
    //# constructors
    //##################################################

    public KmaGrid()
    {
        _valueModel = getDefaultValueModel();
        _rowSizeModel = getDefaultRowSizeModel();
        _columnSizeModel = getDefaultColumnSizeModel();
        _selectionModel = getDefaultSelectionModel();

        _rowHeader = getDefaultRowHeader();
        _columnHeader = getDefaultColumnHeader();

        _keyModel = getDefaultKeyModel();
        _mouseModel = getDefaultMouseModel();
        _actionModel = getDefaultActionModel();

        _cellRenderer = getDefaultCellRenderer();
        _cellRendererPane = new CellRendererPane();
        _horizontalScrollBar = getDefaultScrollBar(HORIZONTAL);
        _verticalScrollBar = getDefaultScrollBar(VERTICAL);

        _hasGridLines = true;
        _gridLineColor = getDefaultGridLineColor();

        setLayout(new KmaGridLayout());
        add(getCellRendererPane());
        add(getVerticalScrollBar());
        add(getHorizontalScrollBar());

        setBackground(Color.white);
        addKeyListener(newKeyListener());
        addMouseListener(newMouseListener());
        addMouseMotionListener(newMouseMotionListener());
        addFocusListener(newFocusListener());

        setPreferredSize(new Dimension(150, 150));
    }

    //##################################################
    //# accessing
    //##################################################

    public KmaGridValueModelIF getValueModel()
    {
        return _valueModel;
    }

    public void setValueModel(KmaGridValueModelIF o)
    {
        _valueModel = o;
        rebuild();
    }

    public KmaGridSizeModelIF getRowSizeModel()
    {
        return _rowSizeModel;
    }

    public void setRowSizeModel(KmaGridSizeModelIF o)
    {
        _rowSizeModel = o;
    }

    public KmaGridSizeModelIF getColumnSizeModel()
    {
        return _columnSizeModel;
    }

    public void setColumnSizeModel(KmaGridSizeModelIF o)
    {
        _columnSizeModel = o;
    }

    public boolean hasGridLines()
    {
        return _hasGridLines;
    }

    public void showGridLines(boolean b)
    {
        _hasGridLines = b;
        repaint();
    }

    public Color getGridLineColor()
    {
        return _gridLineColor;
    }

    public void setGridLineColor(Color c)
    {
        _gridLineColor = c;
        repaint();
    }

    public KmaGridCellRendererIF getCellRenderer()
    {
        return _cellRenderer;
    }

    public void setCellRenderer(KmaGridCellRendererIF r)
    {
        _cellRenderer = r;
    }

    public KmaGridSelectionModelIF getSelectionModel()
    {
        return _selectionModel;
    }

    public void setSelectionModel(KmaGridSelectionModelIF o)
    {
        _selectionModel = o;
        repaint();
    }

    public KmaGridKeyModel getKeyModel()
    {
        return _keyModel;
    }

    public void setKeyModel(KmaGridKeyModel o)
    {
        _keyModel = o;
    }

    public KmaGridMouseModel getMouseModel()
    {
        return _mouseModel;
    }

    public void setMouseModel(KmaGridMouseModel o)
    {
        _mouseModel = o;
    }

    public KmaGridActionModel getActionModel()
    {
        return _actionModel;
    }

    public void setActionModel(KmaGridActionModel o)
    {
        _actionModel = o;
    }

    //##################################################
    //# access (readonly)
    //##################################################

    public JScrollBar getVerticalScrollBar()
    {
        return _verticalScrollBar;
    }

    public JScrollBar getHorizontalScrollBar()
    {
        return _horizontalScrollBar;
    }

    public CellRendererPane getCellRendererPane()
    {
        return _cellRendererPane;
    }

    public KmaGridHeaderIF getRowHeader()
    {
        return _rowHeader;
    }

    public KmaGridHeaderIF getColumnHeader()
    {
        return _columnHeader;
    }

    public int getCellGap()
    {
        return hasGridLines()
            ? 1
            : 0;
    }

    //##################################################
    //# delegation
    //##################################################

    public int getRowCount()
    {
        return getValueModel().getRowCount();
    }

    public int getColumnCount()
    {
        return getValueModel().getColumnCount();
    }

    public Object getValueAt(int xx, int yy)
    {
        return getValueModel().getValueAt(xx, yy);
    }

    public Object getRowHeaderValueAt(int yy)
    {
        return getValueModel().getRowHeaderAt(yy);
    }

    public Object getColumnHeaderValueAt(int xx)
    {
        return getValueModel().getColumnHeaderAt(xx);
    }

    public int getRowHeightAt(int row)
    {
        return getRowSizeModel().getSizeAt(row);
    }

    public int getColumnWidthAt(int column)
    {
        return getColumnSizeModel().getSizeAt(column);
    }

    //##################################################
    //# defaults
    //##################################################

    public KmaGridValueModelIF getDefaultValueModel()
    {
        return new KmaGridDefaultValueModel();
    }

    public KmaGridCellRendererIF getDefaultCellRenderer()
    {
        return new KmaGridDefaultCellRenderer();
    }

    public KmaGridSelectionModelIF getDefaultSelectionModel()
    {
        return new KmaGridSingleSelectionModel();
    }

    public KmaGridSizeModelIF getDefaultRowSizeModel()
    {
        return KmaGridFixedSizeModel.create(this, 20);
    }

    public KmaGridSizeModelIF getDefaultColumnSizeModel()
    {
        return KmaGridFixedSizeModel.create(this, 50);
    }

    public KmaGridKeyModel getDefaultKeyModel()
    {
        return KmaGridKeyModel.create(this);
    }

    public KmaGridMouseModel getDefaultMouseModel()
    {
        return KmaGridMouseModel.create(this);
    }

    public KmaGridActionModel getDefaultActionModel()
    {
        return KmaGridActionModel.create(this);
    }

    public KmaGridHeaderIF getDefaultRowHeader()
    {
        return KmaGridRowHeader.create(this, 80);
    }

    public KmaGridHeaderIF getDefaultColumnHeader()
    {
        return KmaGridColumnHeader.create(this, 20);
    }

    public KmaGridScrollBar getDefaultScrollBar(int orientation)
    {
        return KmaGridScrollBar.create(this, orientation);
    }

    public Color getDefaultGridLineColor()
    {
        return Color.black;
    }

    //##################################################
    //# layout
    //##################################################

    @Override
    public boolean isValidateRoot()
    {
        return true;
    }

    //##################################################
    //# refresh
    //##################################################

    public void rebuild()
    {
        JScrollBar sb;
        sb = getVerticalScrollBar();
        sb.setMinimum(0);
        sb.setMaximum(getRowCount() - 1 + sb.getVisibleAmount());
        sb = getHorizontalScrollBar();
        sb.setMinimum(0);
        sb.setMaximum(getColumnCount() - 1 + sb.getVisibleAmount());

        refresh();
    }

    public void refresh()
    {
        getVerticalScrollBar().invalidate();
        getHorizontalScrollBar().invalidate();

        validate();
        repaint();
    }

    //##################################################
    //# bounds
    //##################################################

    public Rectangle getInsetBounds()
    {
        Dimension d = getSize();
        Insets i = getInsets();

        int x = i.left;
        int y = i.top;
        int w = d.width - i.left - i.right;
        int h = d.height - i.top - i.bottom;

        return new Rectangle(x, y, w, h);
    }

    public Rectangle getDataBounds()
    {
        JScrollBar vsb = getVerticalScrollBar();
        JScrollBar hsb = getHorizontalScrollBar();
        Rectangle r = getInsetBounds();

        r.x += 2;
        r.y += 2;

        r.width -= vsb.isVisible()
            ? vsb.getSize().width + 2
            : 4;

        r.height -= hsb.isVisible()
            ? hsb.getSize().height + 2
            : 4;

        return r;
    }

    public Rectangle getClientBounds()
    {
        Rectangle rb = getRowHeader().getBounds();
        Rectangle cb = getColumnHeader().getBounds();

        rb.x = cb.x;
        rb.width = cb.width;

        return rb;
    }

    //##################################################
    //# listeners
    //##################################################

    public AdjustmentListener newAdjustmentListener()
    {
        return new AdjustmentListener()
        {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent ev)
            {
                setFirstVisibleRow(getVerticalScrollBar().getValue());
                setFirstVisibleColumn(getHorizontalScrollBar().getValue());
                repaint();
            }
        };
    }

    public Point getCellForXY(Point p)
    {
        Rectangle cb = getClientBounds();
        if ( !cb.contains(p) )
            return null;

        int x = cb.x;
        int dx = getCellGap();
        int x1 = getFirstVisibleColumn();
        int x2 = getLastVisibleColumn();
        int xx = x1;

        while ( xx < x2 )
        {
            x += getColumnWidthAt(xx) + dx;
            if ( x >= p.x )
                break;
            xx++;
        }

        int y = cb.y;
        int dy = getCellGap();
        int y1 = getFirstVisibleRow();
        int y2 = getLastVisibleRow();
        int yy = y1;

        while ( yy < y2 )
        {
            y += getRowHeightAt(yy) + dy;
            if ( y >= p.y )
                break;

            yy++;
        }

        return new Point(xx, yy);
    }

    public void select(Point p)
    {
        getSelectionModel().select(p);
        repaint();
    }

    public KeyListener newKeyListener()
    {
        return new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent ev)
            {
                getKeyModel().keyTyped(ev);
            }

            @Override
            public void keyPressed(KeyEvent ev)
            {
                getKeyModel().keyPressed(ev);
            }

            @Override
            public void keyReleased(KeyEvent ev)
            {
                getKeyModel().keyReleased(ev);
            }
        };
    }

    public MouseListener newMouseListener()
    {
        return new MouseListener()
        {
            @Override
            public void mousePressed(MouseEvent ev)
            {
                getMouseModel().mousePressed(ev);
            }

            @Override
            public void mouseReleased(MouseEvent ev)
            {
                getMouseModel().mouseReleased(ev);
            }

            @Override
            public void mouseClicked(MouseEvent ev)
            {
                getMouseModel().mouseClicked(ev);
            }

            @Override
            public void mouseEntered(MouseEvent ev)
            {
                getMouseModel().mouseEntered(ev);
            }

            @Override
            public void mouseExited(MouseEvent ev)
            {
                getMouseModel().mouseExited(ev);
            }
        };
    }

    public MouseMotionListener newMouseMotionListener()
    {
        return new MouseMotionListener()
        {
            @Override
            public void mouseDragged(MouseEvent ev)
            {
                getMouseModel().mouseDragged(ev);
            }

            @Override
            public void mouseMoved(MouseEvent ev)
            {
                getMouseModel().mouseMoved(ev);
            }
        };
    }

    public FocusListener newFocusListener()
    {
        return new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent ev)
            {
                repaint();
            }

            @Override
            public void focusLost(FocusEvent ev)
            {
                repaint();
            }
        };
    }

    //##################################################
    //# paint
    //##################################################

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);

        paintEdge(g);
        paintClientCells(g);
        getRowHeader().paint(g);
        getColumnHeader().paint(g);
        paintGridLines(g);
    }

    public void paintEdge(Graphics g)
    {
        Rectangle r = getInsetBounds();

        int x = r.x;
        int y = r.y;
        int w = r.width;
        int h = r.height;

        Color shadow = MetalLookAndFeel.getControlDarkShadow();
        Color highlight = MetalLookAndFeel.getControlHighlight();

        g.setColor(highlight);
        g.drawLine(x + 1, y, x + 1, y + h - 1);
        g.drawLine(x + 1, y + 1, x + w - 2, y + 1);
        g.drawLine(x, y + h - 1, x + w, y + h - 1);
        g.drawLine(x + w - 1, y, x + w - 1, y + h);

        g.setColor(shadow);
        g.drawLine(x, y, x + w - 2, y);
        g.drawLine(x, y, x, y + h - 2);
        g.drawLine(x, y + h - 2, x + w - 2, y + h - 2);
        g.drawLine(x + w - 2, y, x + w - 2, y + h - 2);

        if ( getColumnHeader().isVisible() && getVerticalScrollBar().isVisible() )
        {
            Rectangle hr = getDataBounds();
            int xx = hr.x + hr.width;
            g.setColor(shadow);
            g.drawLine(xx, y + 2, xx, y + h - 2);
            g.setColor(highlight);
            g.drawLine(xx + 1, y + 2, xx + 1, y + h - 2);
        }

        if ( getRowHeader().isVisible() && getHorizontalScrollBar().isVisible() )
        {
            Rectangle hr = getDataBounds();
            int yy = hr.y + hr.height;
            g.setColor(shadow);
            g.drawLine(x + 2, yy, x + w - 2, yy);
            g.setColor(highlight);
            g.drawLine(x + 2, yy + 1, x + w - 2, yy + 1);
        }
    }

    public void paintClientCells(Graphics g)
    {
        boolean showFocus = hasFocus();
        Point point = new Point();
        Rectangle oldClip = g.getClipBounds();
        Rectangle r = getClientBounds();
        Container p = getParent();
        Point dot = getActionModel().getDot();

        g.setColor(getBackground());
        g.fillRect(r.x, r.y, r.width, r.height);

        g.clipRect(r.x, r.y, r.width, r.height);
        int x, y, w, h;

        int dxy = _hasGridLines
            ? 1
            : 0;

        int maxx, maxy;
        y = r.y;
        maxy = r.y + r.height - 1;

        int y1 = getFirstVisibleRow();
        int y2 = getRowCount();

        for ( int yy = y1; yy < y2; yy++ )
        {
            if ( y > maxy )
                break;

            point.y = yy;
            x = r.x;
            maxx = r.x + r.width - 1;
            h = getRowHeightAt(yy);

            int x1 = getFirstVisibleColumn();
            int x2 = getColumnCount();

            for ( int xx = x1; xx < x2; xx++ )
            {
                if ( x > maxx )
                    break;

                point.x = xx;
                w = getColumnWidthAt(xx);
                Object o = getValueAt(xx, yy);
                boolean hasFocus = showFocus && dot.x == xx && dot.y == yy;
                boolean isSelected = getSelectionModel().isSelected(point);
                boolean validate = true;

                Component c = getCellRenderer().getCellRendererFor(
                    this,
                    o,
                    isSelected,
                    hasFocus,
                    xx,
                    yy);

                getCellRendererPane().paintComponent(g, c, p, x, y, w, h, validate);
                x += w + dxy;
            }
            y += h + dxy;
        }
        g.setClip(oldClip);
    }

    public void paintGridLines(Graphics g)
    {
        if ( !hasGridLines() )
            return;

        paintVerticalLines(g);
        paintHorizontalLines(g);
    }

    public void paintVerticalLines(Graphics g)
    {
        Rectangle r = getClientBounds();
        int dx = getCellGap();
        int x = r.x;
        int maxx = r.x + r.width - 1;
        int y1 = r.y;
        int y2 = r.y + r.height - 1;

        g.setColor(getGridLineColor());

        int a = getFirstVisibleColumn();
        int n = getColumnCount();

        for ( int i = a; i < n; i++ )
        {
            x += getColumnWidthAt(i);
            if ( x > maxx )
                break;

            g.drawLine(x, y1, x, y2);
            x += dx;
        }
    }

    public void paintHorizontalLines(Graphics g)
    {
        Rectangle r = getClientBounds();
        int dy = getCellGap();
        int y = r.y;
        int maxy = r.y + r.height - 1;
        int x1 = r.x;
        int x2 = r.x + r.width - 1;

        g.setColor(getGridLineColor());

        int a = getFirstVisibleRow();
        int n = getRowCount();

        for ( int i = a; i < n; i++ )
        {
            y += getRowHeightAt(i);
            if ( y > maxy )
                break;

            g.drawLine(x1, y, x2, y);
            y += dy;
        }
    }

    //##################################################
    //# position
    //##################################################

    public int getFirstVisibleRow()
    {
        return getVerticalScrollBar().getValue();
    }

    public void setFirstVisibleRow(int yy)
    {
        getVerticalScrollBar().setValue(yy);
    }

    public int getFirstVisibleColumn()
    {
        return getHorizontalScrollBar().getValue();
    }

    public void setFirstVisibleColumn(int xx)
    {
        getHorizontalScrollBar().setValue(xx);
    }

    public int getLastVisibleRow()
    {
        return getRowSizeModel().getLastPartialFit(
            getFirstVisibleRow(),
            getRowCount() - 1,
            getClientBounds().height);
    }

    public int getLastFullyVisibleRow()
    {
        return getRowSizeModel().getLastCompleteFit(
            getFirstVisibleRow(),
            getRowCount() - 1,
            getClientBounds().height);
    }

    public int getLastVisibleColumn()
    {
        return getColumnSizeModel().getLastPartialFit(
            getFirstVisibleColumn(),
            getColumnCount() - 1,
            getClientBounds().width);
    }

    public int getLastFullyVisibleColumn()
    {
        return getColumnSizeModel().getLastCompleteFit(
            getFirstVisibleColumn(),
            getColumnCount() - 1,
            getClientBounds().width);
    }

    //##################################################
    //# accept actions
    //##################################################

    public void addAcceptAction(ActionListener al)
    {
        getActionModel().addAcceptAction(al);
    }

    //##################################################
    //# selection
    //##################################################

    public Object getSelectedValue()
    {
        Point p = getSelectionModel().getSelection();
        return getValueAt(p.x, p.y);
    }

    public void setSelectedValue(Object o)
    {
        Point p = getIndexOf(o);
        getSelectionModel().clear();
        getSelectionModel().select(p);
        repaint();
    }

    public Point getIndexOf(Object a)
    {
        int xn = getColumnCount();
        int yn = getRowCount();

        for ( int x = 0; x < xn; x++ )
            for ( int y = 0; y < yn; y++ )
            {
                Object b = getValueAt(x, y);

                if ( compare(a, b) )
                    return new Point(x, y);
            }
        return null;
    }

    public boolean compare(Object a, Object b)
    {
        if ( a == null )
            return b == null;

        if ( b == null )
            return false;

        return a.equals(b);

    }

    public void addSelectAction(ActionListener a)
    {
        getActionModel().addSelectAction(a);
    }

}
