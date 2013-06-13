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

package com.kodemore.awt;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class KmaPanel
    extends JPanel
{
    //##################################################
    //# constructors
    //##################################################

    public KmaPanel()
    {
        initialize();
    }

    //##################################################
    //# initialize
    //##################################################

    public void initialize()
    {
        initializeComponents();
        initializeLayout();
    }

    public void initializeComponents()
    {
        // hook for subclasses
    }

    public void initializeLayout()
    {
        // hook for subclasses
    }

    //##################################################
    //# layout
    //##################################################

    public void useGridLayout(int rows, int cols)
    {
        setLayout(new GridLayout(rows, cols));
    }

    public CardLayout useCardLayout()
    {
        CardLayout e;
        e = new CardLayout();
        setLayout(e);
        return e;
    }

    public void showCard(String s)
    {
        CardLayout e = (CardLayout)getLayout();
        e.show(this, s);
    }

    public void useFlowLayout()
    {
        setLayout(new FlowLayout());
    }

    public KmaVerticalLayout useVerticalLayout()
    {
        KmaVerticalLayout e;
        e = new KmaVerticalLayout();
        setLayout(e);
        return e;
    }

    public KmaHorizontalLayout useHorizontalLayout()
    {
        KmaHorizontalLayout e;
        e = new KmaHorizontalLayout();
        setLayout(e);
        return e;
    }

    public KmaHorizontalLayout useHorizontalLayout(int gap)
    {
        KmaHorizontalLayout e;
        e = new KmaHorizontalLayout();
        e.setGap(gap);
        setLayout(e);
        return e;
    }

    public KmaGridBagBuilder useGridBagBuilder()
    {
        KmaGridBagBuilder b;
        b = new KmaGridBagBuilder(this);
        return b;
    }

    //##################################################
    //# border layout
    //##################################################

    public void useBorderLayout()
    {
        setLayout(new BorderLayout());
    }

    public void useBorderLayout(int hgap, int vgap)
    {
        setLayout(new BorderLayout(hgap, vgap));
    }

    public void addCenter(Component c)
    {
        add(c, BorderLayout.CENTER);
    }

    public void addNorth(Component c)
    {
        add(c, BorderLayout.NORTH);
    }

    public void addSouth(Component c)
    {
        add(c, BorderLayout.SOUTH);
    }

    public void addEast(Component c)
    {
        add(c, BorderLayout.EAST);
    }

    public void addWest(Component c)
    {
        add(c, BorderLayout.WEST);
    }

    //##################################################
    //# utility
    //##################################################

    public JFrame getFrame()
    {
        return KmaAwtUtility.getFrameFor(this);
    }

    public JPanel getFramePanel()
    {
        return (JPanel)getFrame().getContentPane();
    }

    public void setDefaultButton(JButton b)
    {
        getFrame().getRootPane().setDefaultButton(b);
    }

    //##################################################
    //# size
    //##################################################

    public void setFixedSize(int w, int h)
    {
        Dimension d = new Dimension(w, h);
        setFixedSize(d);
    }

    public void setFixedSize(Dimension d)
    {
        setPreferredSize(d);
        setMinimumSize(d);
        setMaximumSize(d);
    }

    public void setPreferredSize(int w, int h)
    {
        Dimension d = new Dimension(w, h);
        setPreferredSize(d);
    }

    public void setPreferredSize(double w, double h)
    {
        Dimension d = new Dimension((int)w, (int)h);
        setPreferredSize(d);
    }

    //##################################################
    //# message dialogs
    //##################################################

    public String getInputString(String title, String message)
    {
        return KmaAwtUtility.getInputString(this, title, message);
    }

    public void showWarning(String title, String message)
    {
        KmaAwtUtility.showWarning(this, title, message);
    }

    public void showError(String title, String message)
    {
        KmaAwtUtility.showError(this, title, message);
    }

    public void showError(String title, Exception ex)
    {
        KmaAwtUtility.showError(this, title, ex);
    }

    //##################################################
    //# border
    //##################################################

    public void addBorder(Border b)
    {
        addOuterBorder(b);
    }

    public void addInnerBorder(Border b)
    {
        KmaAwtUtility.addInnerBorder(this, b);
    }

    public void addOuterBorder(Border b)
    {
        KmaAwtUtility.addOuterBorder(this, b);
    }

    public void addEmptyBorder(int i)
    {
        addBorder(BorderFactory.createEmptyBorder(i, i, i, i));
    }

    public void addEtchedBorder()
    {
        addBorder(BorderFactory.createEtchedBorder());
    }

    public void addRaisedBorder()
    {
        addBorder(KmaBevelBorder.getRaisedBorder());
    }

    public void addLoweredBorder()
    {
        addBorder(KmaBevelBorder.getLoweredBorder());
    }

    public void addLineBorder(Color c)
    {
        addBorder(BorderFactory.createLineBorder(c));
    }

    //##################################################
    //# utility
    //##################################################

    public KmaButton newButton(String name, String action)
    {
        return new KmaBlockAction(name, this, action).newButton();
    }

    public KmaAction newAction(String message)
    {
        return new KmaBlockAction("", this, message);
    }

    public KmaLabel addLabel(String s)
    {
        KmaLabel e = new KmaLabel(s);
        add(e);
        return e;
    }
}
