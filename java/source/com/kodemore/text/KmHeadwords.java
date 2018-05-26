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

package com.kodemore.text;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.collection.KmSet;
import com.kodemore.collection.KmSetImpl;
import com.kodemore.utility.KmFiles;
import com.kodemore.utility.Kmu;

/**
 * I alternate word forms back to their head/canonical form.
 *
 * For example,
 *      candies => candy
 *      quickly => quick
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
        e.printStats();
        e.print("candies");
        e.print("quickly");
    }

    //##################################################
    //# variables
    //##################################################

    /**
     * The list of all heads, including the heads that don't have alternates.
     */
    private KmSet<String> _heads;

    /**
     * alternate -> head
     */
    private KmMap<String,String> _alternates;

    //##################################################
    //# constructor
    //##################################################

    public KmHeadwords()
    {
        reset();
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

    public void reset()
    {
        _heads = new KmSetImpl<>();
        _alternates = new KmMap<>();
    }

    //##################################################
    //# load
    //##################################################

    public void loadDefaults()
    {
        loadFromResource(getClass(), "headwords.txt");
    }

    public void loadFromFile(String path)
    {
        KmList<String> lines = KmFiles.readLines(path);
        loadLines(lines);
    }

    public void loadFromResource(Class<?> klass, String name)
    {
        KmList<String> lines = Kmu.readResourceLines(klass, name);
        loadLines(lines);
    }

    //==================================================
    //= load :: lines
    //==================================================

    private void loadLines(KmList<String> lines)
    {
        reset();
        String head = null;

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

            loadAlternatesLine(line, head);
        }
    }

    private void loadAlternatesLine(String line, String head)
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

    //##################################################
    //# print
    //##################################################

    public void printStats()
    {
        System.out.println("Headword Stats");
        System.out.println("    headword count:    " + _heads.size());
        System.out.println("    alternates count:  " + _alternates.size());
    }

    public void print(String s)
    {
        System.out.printf("%s => %s%n", s, getHeadFor(s));
    }

}
