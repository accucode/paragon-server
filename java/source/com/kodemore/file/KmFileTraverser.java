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

package com.kodemore.file;

import java.io.File;

/**
 * I implement a simple utility to traverse file and folders
 * starting at some root.  Although I don't do anything useful
 * by myself, the intent is to allow other utilities to be easily
 * built using my functionality.  See KmLineCounter for an example.
 */
public abstract class KmFileTraverser
{
    //##################################################
    //# abstract
    //##################################################

    protected abstract void processFile(KmFile f);

    protected void init()
    {
        // optional subclass override
    }

    //##################################################
    //# public
    //##################################################

    public void processAll(KmFile root)
    {
        init();
        _processAll(root);
    }

    public void processAll(File root)
    {
        processAll(new KmFile(root));
    }

    public void processAll(String root)
    {
        processAll(new KmFile(root));
    }

    //##################################################
    //# private
    //##################################################

    private void _processAll(KmFile p)
    {
        if ( p.isFile() )
            processFile(p);

        if ( p.isFolder() )
            for ( KmFile c : p.getChildren() )
                _processAll(c);
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String args[])
    {
        new KmFileTraverser()
        {
            @Override
            public void processFile(KmFile f)
            {
                System.out.println(f);
            }
        }.processAll("c:/temp");
    }

}
