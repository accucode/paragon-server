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

package com.kodemore.tools;

import com.kodemore.collection.KmList;
import com.kodemore.file.KmFile;
import com.kodemore.file.KmFileTraverser;

/**
 * I implement a simple utility to count the number of lines in a
 * source directory.
 */
public class KmLineCounter
    extends KmFileTraverser
{
    //##################################################
    //# static
    //##################################################

    public static void countLines(String root, String suffix)
    {
        System.out.println("Counting lines");
        System.out.println("  Root:   " + root);
        System.out.println("  Suffix: " + suffix);
        KmLineCounter e = new KmLineCounter();
        e.setSuffix(suffix);

        e.addIgnoredPrefix("package");
        e.addIgnoredPrefix("import");

        e.processAll(root);
        System.out.printf("  total bytes:  %,10d\n", e.getTotalBytes());
        System.out.printf("  total lines:  %,10d\n", e.getLines());
        System.out.printf("  blank lines:  %,10d\n", e.getBlankLines());
        System.out.printf("  1-char lines: %,10d\n", e.getSingleCharacterLines());
        System.out.printf("  prefix lines: %,10d\n", e.getIgnoredPrefixLines());
        System.out.printf("  comment lines:%,10d\n", e.getCommentLines());

    }

    //##################################################
    //# variables
    //##################################################

    private KmList<String> _ignoredPrefixes = new KmList<>();
    private String         _suffix;

    private int            _lines;
    private int            _blankLines;
    private int            _singleCharacterLines;
    private int            _commentLines;
    private int            _ignoredPrefixLines;
    private int            _totalBytes;

    //##################################################
    //# accessing
    //##################################################

    public String getSuffix()
    {
        return _suffix;
    }

    public void setSuffix(String e)
    {
        _suffix = e;
    }

    public int getLines()
    {
        return _lines;
    }

    public int getBlankLines()
    {
        return _blankLines;
    }

    public int getSingleCharacterLines()
    {
        return _singleCharacterLines;
    }

    public int getCommentLines()
    {
        return _commentLines;
    }

    public int getIgnoredPrefixLines()
    {
        return _ignoredPrefixLines;
    }

    public int getTotalBytes()
    {
        return _totalBytes;
    }

    public void addIgnoredPrefix(String s)
    {
        _ignoredPrefixes.add(s);
    }

    //##################################################
    //# actions
    //##################################################

    @Override
    public void init()
    {
        _lines = 0;
        _blankLines = 0;
        _singleCharacterLines = 0;
        _commentLines = 0;
        _ignoredPrefixLines = 0;
        _totalBytes = 0;
    }

    @Override
    public void processFile(KmFile f)
    {
        if ( !f.getName().endsWith(_suffix) )
            return;

        _totalBytes += f.getLength();
        KmList<String> v = f.readLines();

        _lines += v.size();

        int n;
        for ( String s : v )
        {
            n = s.trim().length();

            if ( n == 0 )
                _blankLines++;

            if ( n == 1 )
                _singleCharacterLines++;

            if ( s.startsWith("//") )
                _commentLines++;

            if ( s.startsWith("/*") )
                _commentLines++;

            if ( s.startsWith("*") )
                _commentLines++;

            if ( _ignoredPrefixes.isNotEmpty() )
                for ( String prefix : _ignoredPrefixes )
                    if ( s.startsWith(prefix) )
                    {
                        _ignoredPrefixLines++;
                        break;
                    }
        }
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String args[])
    {
        KmLineCounter.countLines("c:/projects/kodemore/java/source", ".java");
    }
}
