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

package com.kodemore.awt;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;

public class KmaImage
{
    //##################################################
    //# variables
    //##################################################

    private Image         _image;
    private ImageObserver _observer;

    //##################################################
    //# accessing
    //##################################################

    public Image getImage()
    {
        return _image;
    }

    public void setImage(Image e)
    {
        _image = e;
        loadImage();
    }

    public void setImage(File f)
    {
        setImage(f.getPath());
    }

    public void setImage(String path)
    {
        Image i = Toolkit.getDefaultToolkit().getImage(path);
        setImage(i);
    }

    public ImageObserver getObserver()
    {
        if ( _observer == null )
            _observer = new Panel();

        return _observer;
    }

    public void setObserver(ImageObserver e)
    {
        _observer = e;
    }

    public boolean hasObserver()
    {
        return _observer != null;
    }

    //##################################################
    //# abstract accessing
    //##################################################

    public int getWidth()
    {
        return getImage().getWidth(getObserver());
    }

    public int getHeight()
    {
        return getImage().getHeight(getObserver());
    }

    public void flush()
    {
        getImage().flush();
    }

    public Graphics getGraphics()
    {
        return getImage().getGraphics();
    }

    public ImageProducer getSource()
    {
        return getImage().getSource();
    }

    public Dimension getDimension()
    {
        return new Dimension(getWidth(), getHeight());
    }

    //##################################################
    //# scaling
    //##################################################

    public KmaImage getScaledInstance(int width, int height)
    {
        return getScaledInstance(width, height, Image.SCALE_DEFAULT);
    }

    public KmaImage getFastScaledInstance(int width, int height)
    {
        return getScaledInstance(width, height, Image.SCALE_FAST);
    }

    public KmaImage getSmoothScaledInstance(int width, int height)
    {
        return getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }

    public KmaImage getReplicateScaledInstance(int width, int height)
    {
        return getScaledInstance(width, height, Image.SCALE_REPLICATE);
    }

    public KmaImage getAveragingScaledInstance(int width, int height)
    {
        return getScaledInstance(width, height, Image.SCALE_AREA_AVERAGING);
    }

    public KmaImage getScaledInstance(int width, int height, int hints)
    {
        Image i = getImage().getScaledInstance(width, height, hints);

        KmaImage ii;
        ii = new KmaImage();
        ii.setImage(i);
        return ii;
    }

    //##################################################
    //# loading
    //##################################################

    public void loadImage()
    {
        try
        {
            MediaTracker t;
            t = new MediaTracker(new Panel());
            t.addImage(_image, 1);
            t.waitForAll();
        }
        catch ( Exception ex )
        {
            ex.printStackTrace();
        }
    }

    //##################################################
    //# graphics
    //##################################################

    public void paintOn(Graphics g)
    {
        paintOn(g, 0, 0);
    }

    public void paintOn(Graphics g, int x, int y)
    {
        g.drawImage(getImage(), x, y, getObserver());
    }

    public void drawOn(Graphics g, int x, int y)
    {
        g.drawImage(getImage(), x, y, getObserver());
    }

    public void drawOn(Graphics g, double x, double y)
    {
        drawOn(g, (int)x, (int)y);
    }

}
