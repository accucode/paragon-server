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

package com.kodemore.utility;

import java.io.File;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.file.KmFile;

/**
 * I am used to read a properties file that consists of key/value pairs.
 */
public class KmPropertyFileReader
{
    //##################################################
    //# variables
    //##################################################

    private KmList<String> _commentPrefixes;

    //##################################################
    //# constructor
    //##################################################

    public KmPropertyFileReader()
    {
        _commentPrefixes = new KmList<String>();
    }

    //##################################################
    //# comment prefix
    //##################################################

    public KmList<String> getCommentPrefixes()
    {
        return _commentPrefixes;
    }

    public void setCommentPrefixes(KmList<String> e)
    {
        _commentPrefixes = e;
    }

    public void setCommentPrefixes(String... arr)
    {
        _commentPrefixes = new KmList<String>(arr);
    }

    public void addCommentPrefix(String s)
    {
        _commentPrefixes.add(s);
    }

    public void clearCommentPrefixes()
    {
        _commentPrefixes.clear();
    }

    //##################################################
    //# read
    //##################################################

    public KmMap<String,String> readFile(KmFile file)
    {
        return readFile(file.getRealPath());
    }

    public KmMap<String,String> readFile(File file)
    {
        return readFile(file.getPath());
    }

    public KmMap<String,String> readFile(String path)
    {
        String s = Kmu.readTextFile(path);
        return readText(s);
    }

    public KmMap<String,String> readText(String source)
    {
        KmMap<String,String> m = new KmMap<String,String>();
        for ( String s : Kmu.getLines(source) )
        {
            s = s.trim();
            if ( isComment(s) )
                continue;
            int x = s.indexOf("=");
            if ( x < 0 )
                continue;
            String key = s.substring(0, x).trim();
            String value = s.substring(x + 1).trim();
            m.put(key, value);
        }
        return m;
    }

    //##################################################
    //# utility
    //##################################################

    public boolean isComment(String s)
    {
        if ( s.length() == 0 )
            return true;
        for ( String prefix : _commentPrefixes )
            if ( s.startsWith(prefix) )
                return true;
        return false;

    }

}
