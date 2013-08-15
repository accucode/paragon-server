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

package com.kodemore.inspector;

import java.awt.Component;
import java.awt.Frame;
import java.awt.Rectangle;

import com.kodemore.collection.KmList;
import com.kodemore.inspector.format.KmInspectorArrayFormat;
import com.kodemore.inspector.format.KmInspectorDateFormat;
import com.kodemore.inspector.format.KmInspectorDictionaryFormat;
import com.kodemore.inspector.format.KmInspectorFormatIF;
import com.kodemore.inspector.format.KmInspectorInspectFormat;
import com.kodemore.inspector.format.KmInspectorListFormat;
import com.kodemore.inspector.format.KmInspectorMapFormat;
import com.kodemore.inspector.format.KmInspectorNullFormat;
import com.kodemore.inspector.format.KmInspectorObjectFormat;
import com.kodemore.inspector.format.KmInspectorSetFormat;
import com.kodemore.inspector.format.KmInspectorSlotInspectorFormat;
import com.kodemore.inspector.format.KmInspectorVectorFormat;
import com.kodemore.inspector.node.KmInspectorNodeIF;
import com.kodemore.inspector.node.KmInspectorSubjectNode;
import com.kodemore.inspector.view.KmInspectorFrame;

public class KmInspector
{
    //##################################################
    //# variables
    //##################################################

    private static KmList<KmInspectorFormatIF> _formats;
    private static KmInspectorFormatIF         _defaultFormat;

    //##################################################
    //# inspect
    //##################################################

    public static KmInspectorFrame inspect(Object e)
    {
        return inspect(e, null);
    }

    public static KmInspectorFrame inspect(Object e, Component c)
    {
        KmInspectorNodeIF n = new KmInspectorSubjectNode(e);
        return inspect(n, c);
    }

    public static KmInspectorFrame inspect(KmInspectorNodeIF n, Component c)
    {
        Rectangle r = getOffsetBoundsFor(c);
        KmInspectorFrame f = new KmInspectorFrame();
        f.setBounds(r);
        f.setNode(n);
        f.setVisible(true);
        return f;
    }

    //##################################################
    //# format
    //##################################################

    public static KmInspectorFormatIF getDefaultFormat()
    {
        if ( _defaultFormat == null )
            _defaultFormat = new KmInspectorObjectFormat();

        return _defaultFormat;
    }

    public static void setDefaultFormat(KmInspectorFormatIF f)
    {
        _defaultFormat = f;
    }

    public static KmList<KmInspectorFormatIF> getFormats()
    {
        if ( _formats == null )
            resetFormats();

        return _formats;
    }

    public static KmInspectorFormatIF getFormatFor(KmInspectorNodeIF n)
    {
        Object o = n.getValue();
        for ( KmInspectorFormatIF f : getFormats() )
            if ( f.appliesTo(o) )
                return f;
        return getDefaultFormat();
    }

    public static void addFormat(KmInspectorFormatIF f)
    {
        getFormats().add(f);
    }

    public static void resetFormats()
    {
        removeAllFormats();
        addFormat(new KmInspectorNullFormat());
        addFormat(new KmInspectorSlotInspectorFormat());
        addFormat(new KmInspectorInspectFormat());
        addFormat(new KmInspectorArrayFormat());
        addFormat(new KmInspectorVectorFormat());
        addFormat(new KmInspectorListFormat());
        addFormat(new KmInspectorDictionaryFormat());
        addFormat(new KmInspectorMapFormat());
        addFormat(new KmInspectorSetFormat());
        addFormat(new KmInspectorDateFormat());
    }

    public static void removeAllFormats()
    {
        _formats = new KmList<KmInspectorFormatIF>();
    }

    //##################################################
    //# utility
    //##################################################

    public static Rectangle getOffsetBoundsFor(Component c)
    {
        Rectangle r = new Rectangle(0, 0, 500, 400);
        while ( c != null )
        {
            if ( c instanceof Frame )
            {
                Rectangle rr = c.getBounds();
                r.x = rr.x + 24;
                r.y = rr.y + 24;
                return r;
            }
            c = c.getParent();
        }
        return r;
    }

}
