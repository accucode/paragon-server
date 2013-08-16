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

package com.kodemore.awt;

import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kodemore.collection.KmList;

public class KmaSpinner
    extends JPanel
{
    //##################################################
    //# variables
    //##################################################

    private KmList<KmaAction> _leftActions;
    private KmList<KmaAction> _rightActions;

    private JButton           _leftButton;
    private JButton           _rightButton;

    //##################################################
    //# constructors
    //##################################################

    public KmaSpinner()
    {
        _leftActions = new KmList<KmaAction>();
        _rightActions = new KmList<KmaAction>();

        KmaArrowIcon a1;
        a1 = newArrowIcon();
        a1.setArrowUp();

        KmaArrowIcon a2;
        a2 = newArrowIcon();
        a2.setArrowDown();

        _leftButton = new JButton();
        _leftButton.setIcon(a1);
        _leftButton.addActionListener(newLeftAction());
        _leftButton.setMargin(new Insets(0, 0, 0, 0));

        _rightButton = new JButton();
        _rightButton.setIcon(a2);
        _rightButton.addActionListener(newRightAction());
        _rightButton.setMargin(new Insets(0, 0, 0, 0));

        KmaGridBagBuilder b;
        b = new KmaGridBagBuilder(this);
        b.setColumns(1);
        b.setWeight(1, 1);
        b.setFill();
        b.setDefault();
        b.add(_leftButton);
        b.add(_rightButton);
    }

    public KmaArrowIcon newArrowIcon()
    {
        KmaArrowIcon i;
        i = new KmaArrowIcon();
        i.setWidth(8);
        i.setHeight(3);
        i.setInsets(0, 1, 0, 1);
        return i;
    }

    //##################################################
    //# actions
    //##################################################

    public KmaAction newLeftAction()
    {
        return new KmaAction()
        {
            @Override
            public void invoke()
            {
                handleLeft();
            }
        };
    }

    public KmaAction newRightAction()
    {
        return new KmaAction()
        {
            @Override
            public void invoke()
            {
                handleRight();
            }
        };
    }

    //##################################################
    //# update
    //##################################################

    public void handleLeft()
    {
        fireLeftActions();
    }

    public void handleRight()
    {
        fireRightActions();
    }

    //##################################################
    //# left actions
    //##################################################

    public void addLeftAction(KmaAction a)
    {
        _leftActions.add(a);
    }

    public void removeLeftAction(KmaAction a)
    {
        _leftActions.remove(a);
    }

    public void fireLeftActions()
    {
        for ( KmaAction e : _leftActions )
            e.invoke();
    }

    //##################################################
    //# right actions
    //##################################################

    public void addRightAction(KmaAction a)
    {
        _rightActions.add(a);
    }

    public void removeRightAction(KmaAction a)
    {
        _rightActions.remove(a);
    }

    public void fireRightActions()
    {
        for ( KmaAction e : _rightActions )
            e.invoke();
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String args[])
    {
        KmaSpinner sp;
        sp = new KmaSpinner();

        KmaPanel p = new KmaPanel();
        p.setLayout(new FlowLayout(1, 0, 0));
        p.add(new JTextField(5));
        p.add(sp);

        KmaFrame f;
        f = new KmaFrame();
        f.exitOnClose();
        f.installSingleComponent(p);
        f.setVisible(true);
    }

}
