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
import java.awt.Component;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class KmaFrame
    extends JFrame
{
    //##################################################
    //# static
    //##################################################

    public static KmaFrame openOn(JComponent c)
    {
        KmaFrame f;
        f = new KmaFrame();
        f.getContentPane().add(c, BorderLayout.CENTER);
        f.setVisible(true);
        return f;
    }

    //##################################################
    //# constructors
    //##################################################

    public KmaFrame()
    {
        initialize();
    }

    //##################################################
    //# initialize
    //##################################################

    public void initialize()
    {
        initializeBounds();
        initializeComponents();
        initializeLayout();
    }

    public void initializeBounds()
    {
        setBounds(200, 200, 400, 300);
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
                System.exit(0);
    }

    //##################################################
    //# utility
    //##################################################

    public void setDefaultButton(JButton b)
    {
        getRootPane().setDefaultButton(b);
    }

    public void installSingleComponent(Component c)
    {
        JComponent cp;
        cp = (JComponent)getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(c, BorderLayout.CENTER);
    }

    public JButton newButton(String name, String message)
    {
        return new KmaBlockAction(name, this, message).newButton();
    }

    public KmaAction newAction(String method)
    {
        return new KmaBlockAction(this, method);
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

    public void showMessage(String title, String message)
    {
        KmaAwtUtility.showMessage(this, title, message);
    }

}
