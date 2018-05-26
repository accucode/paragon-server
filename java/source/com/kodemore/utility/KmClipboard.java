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

package com.kodemore.utility;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

import com.kodemore.log.KmLog;

/**
 * I am a collection of various static methods that are useful in a variety of
 * situations. This class should generally not have any dependencies on other
 * packages.
 */
public class KmClipboard
{
    /**
     * Put the specified string in the operating system clipboard.
     */
    public static void setClipboard(String s)
    {
        Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection ss = new StringSelection(s);

        ClipboardOwner co = new ClipboardOwner()
        {
            @Override
            public void lostOwnership(Clipboard clipboard, Transferable contents)
            {
                // ignored.
                // This is only used for simplistic clipboard manipulation.
            }
        };

        c.setContents(ss, co);
    }

    /**
     * Get a string from the operating system clipboard.
     */
    public static String getClipboard()
    {
        try
        {
            Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
            Object owner = null;
            Transferable t = c.getContents(owner);
            DataFlavor df = DataFlavor.stringFlavor;
            return (String)t.getTransferData(df);
        }
        catch ( Exception ex )
        {
            KmLog.error(ex, "Cannot get clipboard contents.");
            return "";
        }
    }
}
