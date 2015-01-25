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

package com.kodemore.file;

/**
 * I am used by the file monitor to define which files
 * to scan.  I can be set to a single specific file, or
 * to a folder.  I can be set to scan sub-folders
 * (recursively) and limited to a specific file extension.
 */
public class KmFileMonitorRoot
{
    //##################################################
    //# variables
    //##################################################

    /**
     * May be either a folder, or a specific file.
     */
    private KmFile _file;

    /**
     * If specified, only files matching this extension
     * will be scanned.
     */
    private String _extension;

    //##################################################
    //# accessing
    //##################################################

    public KmFile getFile()
    {
        return _file;
    }

    public void setFile(KmFile e)
    {
        _file = e;
    }

    public void setFile(String path)
    {
        setFile(new KmFile(path));
    }

    public String getExtension()
    {
        return _extension;
    }

    public void setExtension(String e)
    {
        _extension = e;
    }

    public boolean hasExtension()
    {
        return _extension != null;
    }

    //##################################################
    //# testing
    //##################################################

    public boolean matches(KmFile e)
    {
        if ( hasExtension() )
            return e.hasExtension(getExtension());

        return true;
    }
}
