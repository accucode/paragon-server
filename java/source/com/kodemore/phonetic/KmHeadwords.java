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

package com.kodemore.phonetic;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.collection.KmSet;
import com.kodemore.collection.KmSetImpl;
import com.kodemore.utility.Kmu;

/**
 * I am used to convert various alternate word forms, back to their
 * canonical form (or headword).
 *
 * My default ruleset can be loaded from the headwords.txt file
 * located in this package via the classloader.  Alternatively,
 * you can define or override the rules with your own.
 */
public class KmHeadwords
{
    //##################################################
    //# main
    //##################################################

    public static void main(String args[])
    {
        KmHeadwords e;
        e = new KmHeadwords();
        e.loadDefaults();

        System.out.println("heads: " + e._heads.size());
        System.out.println("alts:  " + e._alternates.size());

        System.out.println();
        System.out.println(e.getHeadFor("cake"));
        System.out.println(e.getHeadFor("cookies"));
    }

    //##################################################
    //# variables
    //##################################################

    /**
     * The list of all heads, including the heads that don't have alternates.
     */
    private KmSet<String>        _heads;

    /**
     * alternate -> head
     */
    private KmMap<String,String> _alternates;

    //##################################################
    //# constructor
    //##################################################

    public KmHeadwords()
    {
        _heads = new KmSetImpl<String>();
        _alternates = new KmMap<String,String>();
    }

    //##################################################
    //# accessing
    //##################################################

    public void addHeadword(String head)
    {
        head = normalize(head);
        if ( head.isEmpty() )
            return;

        _heads.add(head);
    }

    public void addAlternateFor(String head, String alt)
    {
        head = normalize(head);
        if ( head.isEmpty() )
            return;

        alt = normalize(alt);
        if ( alt.isEmpty() )
            return;

        _heads.add(head);
        _alternates.put(alt, head);
    }

    public String getHeadFor(String s)
    {
        if ( _heads.contains(s) )
            return s;

        return _alternates.get(s);
    }

    //##################################################
    //# load
    //##################################################

    public void loadDefaults()
    {
        _heads = new KmSetImpl<String>();
        _alternates = new KmMap<String,String>();

        String head = null;
        KmList<String> lines = loadResourceLines();

        for ( String line : lines )
        {
            if ( isComment(line) )
                continue;

            if ( isHead(line) )
            {
                head = getFirstWord(line);
                addHeadword(head);
                continue;
            }

            handleAlternates(line, head);
        }
    }

    //==================================================
    //= load :: private
    //==================================================

    private void handleAlternates(String line, String head)
    {
        line = removeLinks(line);
        String[] alts = line.split(",");

        for ( String alt : alts )
            addAlternateFor(head, alt);
    }

    private String normalize(String s)
    {
        s = s.trim();
        s = s.toLowerCase();
        s = Kmu.removeSuffix(s, "+");
        return s;
    }

    private boolean isComment(String line)
    {
        if ( line.startsWith("#") )
            return true;

        if ( line.trim().isEmpty() )
            return true;

        return false;
    }

    private boolean isHead(String line)
    {
        return !line.startsWith(" ");
    }

    private String getFirstWord(String line)
    {
        return line.trim().split(" ")[0];
    }

    private KmList<String> loadResourceLines()
    {
        String pkg;
        pkg = getClass().getPackage().getName();
        pkg = Kmu.replaceAll(pkg, ".", "/");

        String path = Kmu.joinFilePath(pkg, "headwords.txt");
        KmList<String> lines = Kmu.readClassLines(path);
        return lines;
    }

    /**
     * For our purposes we don't need (or want) the cross reference links
     * that look like:
     *      -> [...]
     *
     * So we search for any arrows (->) and, if found, remove everthing through
     * the next end bracket (]).
     */
    private String removeLinks(String s)
    {
        final String arrow = "->";
        final String endBracket = "]";

        if ( !s.contains(arrow) )
            return s;

        StringBuilder b = new StringBuilder(s);
        while ( true )
        {
            int i = b.indexOf(arrow);
            if ( i < 0 )
                break;

            int j = b.indexOf(endBracket, i);
            b.delete(i, j);
        }

        return b.toString();
    }
}
