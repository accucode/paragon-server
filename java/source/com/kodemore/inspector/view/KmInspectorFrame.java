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

package com.kodemore.inspector.view;

import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import com.kodemore.inspector.node.KmInspectorNodeIF;
import com.kodemore.inspector.node.KmInspectorSubjectNode;

public class KmInspectorFrame
    extends JFrame
{
    //##################################################
    //# variables
    //##################################################

    private KmInspectorPanel _panel;

    //##################################################
    //# constructors
    //##################################################

    public KmInspectorFrame()
    {
        setBounds(0, 0, 500, 400);
        _panel = new KmInspectorPanel();
        getContentPane().add(_panel, "Center");
    }

    //##################################################
    //# actions
    //##################################################

    public void setValue(Object e)
    {
        KmInspectorNodeIF n = new KmInspectorSubjectNode(e);
        setNode(n);
    }

    public void setNode(KmInspectorNodeIF n)
    {
        setTitle(n.getName());
        _panel.setNode(n);
    }

    //##################################################
    //# abstract accessing
    //##################################################

    public void exitOnClose()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void disposeOnClose()
    {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void doNothingOnClose()
    {
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    public void hideOnClose()
    {
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    //##################################################
    //# events
    //##################################################

    @Override
    protected void processWindowEvent(WindowEvent e)
    {
        super.processWindowEvent(e);
        if ( e.getID() == WindowEvent.WINDOW_CLOSING )
            if ( getDefaultCloseOperation() == EXIT_ON_CLOSE )
                dispose();
        if ( e.getID() == WindowEvent.WINDOW_CLOSED )
            if ( getDefaultCloseOperation() == EXIT_ON_CLOSE )
                System.exit(0);
    }

}
