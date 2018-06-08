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

import java.io.File;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.ListModel;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

/**
 * A simple image viewer.
 */
public class KmaImageViewerPanel
    extends KmaPanel
{
    //##################################################
    //# variables
    //##################################################

    private List<File>         _imageFiles;
    private KmaListBox<String> _fileListBox;
    private KmaImagePanel      _imagePanel;

    //##################################################
    //# initialize
    //##################################################

    @Override
    public void initializeComponents()
    {
        super.initializeComponents();

        _imageFiles = null;
        _fileListBox = new KmaListBox<>(newListBoxModel());
        _fileListBox.getSelectListeners().add(newAction("guiSelectImage"));
        _imagePanel = new KmaImagePanel();
    }

    @Override
    public void initializeLayout()
    {
        useBorderLayout();
        addWest(new JScrollPane(_fileListBox));
        addCenter(new JScrollPane(_imagePanel));
    }

    //##################################################
    //# accessing
    //##################################################

    public void setImageFiles(List<File> v)
    {
        _imageFiles = v;
        _fileListBox.fireContentsChanged();
    }

    //##################################################
    //# private
    //##################################################

    public void guiSelectImage()
    {
        int i = _fileListBox.getSelectedIndex();
        File f = null;

        if ( i >= 0 )
            f = _imageFiles.get(i);

        _imagePanel.setImage(f);
        _imagePanel.revalidate();
    }

    public ListModel<String> newListBoxModel()
    {
        return new KmaListModel<String>()
        {
            @Override
            public int getSize()
            {
                if ( _imageFiles == null )
                    return 0;

                return _imageFiles.size();
            }

            @Override
            public String getElementAt(int index)
            {
                File f = _imageFiles.get(index);
                return f.getName();
            }
        };
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String args[])
    {
        String path = Kmu.getHardcodedPath("/temp/jpegs");
        File dir = new File(path);
        File[] arr = dir.listFiles();

        KmList<File> v = arr == null
            ? KmList.createEmpty()
            : KmList.createWith(arr);

        v.sort();

        KmaImageViewerPanel p;
        p = new KmaImageViewerPanel();
        p.setImageFiles(v);

        KmaFrame f;
        f = new KmaFrame();
        f.installSingleComponent(p);
        f.exitOnClose();
        f.setVisible(true);
    }
}
