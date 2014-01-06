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
import java.awt.Graphics;
import java.io.File;

public class KmaImagePanel
    extends KmaPanel
{
    //##################################################
    //# variables
    //##################################################

    private KmaImage _image;
    private boolean  _autoScale;
    private KmaImage _scaledImage;

    //##################################################
    //# accessing
    //##################################################

    public KmaImage getImage()
    {
        return _image;
    }

    public void setImage(KmaImage e)
    {
        _image = e;
        _scaledImage = null;
        repaint();
    }

    public void setImage(String path)
    {
        if ( path == null )
        {
            setImage((KmaImage)null);
            return;
        }
        KmaImage i;
        i = new KmaImage();
        i.setImage(path);
        setImage(i);
    }

    public void setImage(File f)
    {
        if ( f == null )
        {
            setImage((String)null);
            return;
        }
        setImage(f.getPath());
    }

    @Override
    public Dimension getPreferredSize()
    {
        return _image == null
            ? new Dimension(10, 10)
            : _image.getDimension();
    }

    public boolean getAutoScale()
    {
        return _autoScale;
    }

    public void setAutoScale(boolean e)
    {
        _autoScale = e;
    }

    public void setAutoScale()
    {
        setAutoScale(true);
    }

    public KmaImage getScaledImage()
    {
        if ( _image == null )
            return null;
        Dimension d = getSize();
        if ( _scaledImage != null )
            if ( _scaledImage.getDimension().equals(d) )
                return _scaledImage;
        _scaledImage = _image.getScaledInstance((int)d.getWidth(), (int)d.getHeight());
        return _scaledImage;
    }

    //##################################################
    //# paint
    //##################################################

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        if ( _image == null )
            return;
        if ( _autoScale )
            getScaledImage().paintOn(g);
        else
            getImage().paintOn(g);
    }

}
