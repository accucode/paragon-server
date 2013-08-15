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

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

import com.kodemore.log.KmLog;
import com.kodemore.string.KmStringSplitter;

public class KmaAwtUtility
{
    //##################################################
    //# constants
    //##################################################

    public static final boolean LOG_EXCEPTIONS = true;

    //##################################################
    //# frame
    //##################################################

    public static JFrame getFrame(Component c)
    {
        while ( true )
        {
            if ( c == null )
                return null;
            if ( c instanceof JFrame )
                return (JFrame)c;
            c = c.getParent();
        }
    }

    public static JFrame getFrameFor(Component c)
    {
        return getFrame(c);
    }

    //##################################################
    //# border
    //##################################################

    public static JComponent addOuterBorder(JComponent c, Border out)
    {
        Border b;
        Border in = c.getBorder();
        if ( in == null )
            b = out;
        else
            b = BorderFactory.createCompoundBorder(out, in);
        c.setBorder(b);
        return c;
    }

    public static JComponent addInnerBorder(JComponent c, Border in)
    {
        Border b;
        Border out = c.getBorder();
        if ( out == null )
            b = in;
        else
            b = BorderFactory.createCompoundBorder(out, in);
        c.setBorder(b);
        return c;
    }

    public static void addEmptyBorder(JComponent c, int i)
    {
        addOuterBorder(c, BorderFactory.createEmptyBorder(i, i, i, i));
    }

    public static void addEtchedBorder(JComponent c)
    {
        addOuterBorder(c, BorderFactory.createEtchedBorder());
    }

    public static void addRaisedBorder(JComponent c)
    {
        addOuterBorder(c, KmaBevelBorder.getRaisedBorder());
    }

    public static void addLoweredBorder(JComponent c)
    {
        addOuterBorder(c, KmaBevelBorder.getLoweredBorder());
    }

    public static void addLineBorder(JComponent c, Color color)
    {
        addOuterBorder(c, BorderFactory.createLineBorder(color));
    }

    //##################################################
    //# message dialogs
    //##################################################

    public static String getInputString(Component parent, String title, String message)
    {
        return JOptionPane.showInputDialog(parent, message, title, JOptionPane.PLAIN_MESSAGE);
    }

    public static void showMessage(Component parent, String title, String message)
    {
        JOptionPane.showMessageDialog(parent, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showWarning(Component parent, String title, String message)
    {
        JOptionPane.showMessageDialog(parent, message, title, JOptionPane.WARNING_MESSAGE);
    }

    public static void showError(Component parent, String title, String message)
    {
        JOptionPane.showMessageDialog(parent, message, title, JOptionPane.ERROR_MESSAGE);
    }

    public static void showError(Component parent, String title, Exception ex)
    {
        String message;
        message = ex + "";
        message = KmStringSplitter.splitByCharacter(message, 80);
        if ( LOG_EXCEPTIONS )
            logException(ex);
        showError(parent, title, message);
    }

    /**
     * This works fine except that the YES button is initially selected and is
     * also the default button.
     */
    public static int showYesNoCancel_old(Component parent, String title, String message)
    {
        return JOptionPane.showConfirmDialog(
            parent,
            message,
            title,
            JOptionPane.YES_NO_CANCEL_OPTION);
    }

    public static Boolean showYesNoCancel(Component parent, String title, String message)
    {
        int IGNORED = -1;
        JOptionPane p;
        p = new JOptionPane(message, JOptionPane.QUESTION_MESSAGE, IGNORED);
        Object cancel = "Cancel";
        Object yes = "Yes";
        Object no = "No";
        Object arr[] = new Object[3];
        arr[0] = cancel;
        arr[1] = yes;
        arr[2] = no;
        p.setOptions(arr);
        p.setInitialValue(cancel);

        int i = _show(p, parent, title);
        if ( i == 0 )
            return null;

        if ( i == 1 )
            return true;

        if ( i == 2 )
            return false;

        return null;
    }

    /**
     * This works fine except that the YES button is initially selected and is
     * also the default button.
     */
    public static int showYesNo_old(Component parent, String title, String message)
    {
        return JOptionPane.showConfirmDialog(parent, message, title, JOptionPane.YES_NO_OPTION);
    }

    public static boolean showYesNo(Component parent, String title, String message)
    {
        int IGNORED = -1;
        JOptionPane p;
        p = new JOptionPane(message, JOptionPane.QUESTION_MESSAGE, IGNORED);
        Object no = "No";
        Object yes = "Yes";
        Object arr[] = new Object[2];
        arr[0] = no;
        arr[1] = yes;
        p.setOptions(arr);
        p.setInitialValue(no);
        int i = _show(p, parent, title);
        if ( i == 0 )
            return false;
        if ( i == 1 )
            return true;
        return false;
    }

    public static int _show(JOptionPane p, Component parent, String title)
    {
        JDialog d = p.createDialog(parent, title);
        d.setVisible(true);
        Object selectedValue = p.getValue();
        if ( selectedValue == null )
            return JOptionPane.CLOSED_OPTION;
        Object options[] = p.getOptions();
        if ( options == null )
        {
            if ( selectedValue instanceof Integer )
                return (Integer)selectedValue;
            return JOptionPane.CLOSED_OPTION;
        }
        int n = options.length;
        for ( int i = 0; i < n; i++ )
            if ( options[i].equals(selectedValue) )
                return i;
        return JOptionPane.CLOSED_OPTION;
    }

    public static void logException(Exception ex)
    {
        KmLog.fatal(ex);
    }
}
