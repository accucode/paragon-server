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

package com.kodemore.awt;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.KeyStroke;

public class KmaDialog
    extends JDialog
{
    //##################################################
    //# constructors
    //##################################################

    public KmaDialog()
    {
        this((Frame)null);
    }

    public KmaDialog(Component c)
    {
        this(KmaAwtUtility.getFrameFor(c));
    }

    public KmaDialog(Frame f)
    {
        super(f);
        initialize();
    }

    //##################################################
    //# add notify
    //##################################################

    @Override
    public void addNotify()
    {
        super.addNotify();
        if ( getAutoSize() )
            setSize(getPreferredSize());
    }

    public boolean getAutoSize()
    {
        return false;
    }

    //##################################################
    //# initialize
    //##################################################

    public void initialize()
    {
        setModal(true);
        initializeBounds();
        initializeComponents();
        initializeLayout();
    }

    public void initializeBounds()
    {
        Dimension d = getDefaultSize();
        setBounds(100, 100, d.width, d.height);
    }

    public Dimension getDefaultSize()
    {
        return new Dimension(400, 300);
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
    //# close actions
    //##################################################

    public void disposeOnClose()
    {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void hideOnClose()
    {
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    public void doNothingOnClose()
    {
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    //##################################################
    //# convenience
    //##################################################

    public void installSingleComponent(Component c)
    {
        JComponent cp;
        cp = (JComponent)getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(c, BorderLayout.CENTER);
    }

    public void disposeOnEscape()
    {
        KeyStroke escKey = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
        KeyStroke f1Key = KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0);

        int inWindow = JComponent.WHEN_IN_FOCUSED_WINDOW;

        JComponent c;
        c = (JComponent)getContentPane();
        c.registerKeyboardAction(newAction("dispose"), escKey, inWindow);
        c.registerKeyboardAction(newAction("guiHelp"), f1Key, inWindow);
    }

    public void guiHelp()
    {
        // hook for subclasses
    }

    //##################################################
    //# testing
    //##################################################

    public boolean isHidden()
    {
        return !isShowing();
    }

    //##################################################
    //# utility
    //##################################################

    public void setDefaultButton(JButton b)
    {
        getRootPane().setDefaultButton(b);
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

    public boolean showYesNo(String title, String message)
    {
        return KmaAwtUtility.showYesNo(this, title, message);
    }

    public Boolean showYesNoCancel(String title, String message)
    {
        return KmaAwtUtility.showYesNoCancel(this, title, message);
    }

}
