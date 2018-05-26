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

package com.kodemore.tools;

import com.kodemore.collection.KmList;
import com.kodemore.file.KmFile;
import com.kodemore.file.KmFileTraverser;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;

/**
 * I implement a simple utility to count the number of lines in a
 * source directory.
 */
public class KmLineCounter
    extends KmFileTraverser
{
    //##################################################
    //# variables
    //##################################################

    private KmList<String> _ignoredPrefixes = new KmList<>();
    private String         _prefix;
    private String         _suffix;

    private KmFile _root;
    private int    _lines;
    private int    _blankLines;
    private int    _singleCharacterLines;
    private int    _commentLines;
    private int    _ignoredPrefixLines;
    private int    _totalBytes;

    //##################################################
    //# prefix
    //##################################################

    public String getPrefix()
    {
        return _prefix;
    }

    public void setPrefix(String e)
    {
        _prefix = e;
    }

    public boolean hasPrefix()
    {
        return Kmu.hasValue(getPrefix());
    }

    //##################################################
    //# suffix
    //##################################################

    public String getSuffix()
    {
        return _suffix;
    }

    public void setSuffix(String e)
    {
        _suffix = e;
    }

    public boolean hasSuffix()
    {
        return Kmu.hasValue(getSuffix());
    }

    //##################################################
    //# lines
    //##################################################

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

    public int getInterestingLines()
    {
        return getLines()
            - getBlankLines()
            - getSingleCharacterLines()
            - getIgnoredPrefixLines()
            - getCommentLines();
    }

    //##################################################
    //# count
    //##################################################

    public void printResults()
    {
        KmStringBuilder out;
        out = new KmStringBuilder();
        out.printfln("Counting lines");
        out.printfln("    Root:   %s", _root);
        out.printfln("    Prefix: %s", getPrefix());
        out.printfln("    Suffix: %s", getSuffix());
        out.printfln("    total bytes:     %,12d", getTotalBytes());
        out.printfln("    total lines:     %,12d", getLines());
        out.printfln("    - blank lines:   %,12d", getBlankLines());
        out.printfln("    - 1-char lines:  %,12d", getSingleCharacterLines());
        out.printfln("    - prefix lines:  %,12d", getIgnoredPrefixLines());
        out.printfln("    - comment lines: %,12d", getCommentLines());
        out.printfln("    = app lines:     %,12d", getInterestingLines());
        System.out.println(out);
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
    public void processAll(KmFile root)
    {
        _root = root;
        super.processAll(root);
    }

    @Override
    public void processFile(KmFile f)
    {
        if ( hasPrefix() )
            if ( !f.getName().startsWith(getPrefix()) )
                return;

        if ( hasSuffix() )
            if ( !f.getName().endsWith(getSuffix()) )
                return;

        _totalBytes += f.getLength();
        KmList<String> v = f.readLines();

        _lines += v.size();

        int n;
        for ( String s : v )
        {
            n = s.trim().length();

            if ( n == 0 )
            {
                _blankLines++;
                continue;
            }

            if ( n == 1 )
            {
                _singleCharacterLines++;
                continue;
            }

            if ( s.startsWith("//") )
            {
                _commentLines++;
                continue;
            }

            if ( s.startsWith("/*") )
            {
                _commentLines++;
                continue;
            }

            if ( s.startsWith("*") )
            {
                _commentLines++;
                continue;
            }

            for ( String prefix : _ignoredPrefixes )
                if ( s.startsWith(prefix) )
                {
                    _ignoredPrefixLines++;
                    break;
                }
        }
    }
}
