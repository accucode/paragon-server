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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.utility.Kmu;

public class KmPhoneticTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String args[])
    {
        new KmPhoneticTest().run();
    }

    //##################################################
    //# variables
    //##################################################

    private KmList<String>               _words;
    private KmMap<String,KmList<String>> _phonetics;

    //##################################################
    //# run
    //##################################################

    public void run()
    {
        _loadPhoneticRules();
        _loadWordList();

        menu();
    }

    //##################################################
    //# accessing (words)
    //##################################################

    public KmList<String> getWords()
    {
        if ( _words == null )
            _words = new KmList<String>();
        return _words;
    }

    public KmList<String> getWordsWithSubstring(String substring)
    {
        KmList<String> v = new KmList<String>();
        for ( String s : getWords() )
            if ( s.indexOf(substring) >= 0 )
                v.add(s);
        return v;
    }

    public KmList<String> getWordsWithPrefix(String prefix)
    {
        KmList<String> v = new KmList<String>();
        for ( String s : getWords() )
            if ( s.startsWith(prefix) )
                v.add(s);
        return v;
    }

    public KmList<String> getWordsWithSuffix(String suffix)
    {
        KmList<String> v = new KmList<String>();
        for ( String s : getWords() )
            if ( s.endsWith(suffix) )
                v.add(s);
        return v;
    }

    public KmList<String> getWordsLike(String s)
    {
        String p = KmPhoneticEncoder.getPhonetic(s);
        KmList<String> v = getPhonetics().get(p);
        if ( v == null )
            v = new KmList<String>();
        v.sortOn(getEditDistanceComparator(s));
        return v;
    }

    //##################################################
    //# accessing (phonetics)
    //##################################################

    public KmMap<String,KmList<String>> getPhonetics()
    {
        if ( _phonetics == null )
            _phonetics = computePhonetics();
        return _phonetics;
    }

    public void resetPhonetics()
    {
        _phonetics = null;
    }

    public KmMap<String,KmList<String>> computePhonetics()
    {
        KmMap<String,KmList<String>> m = new KmMap<String,KmList<String>>();
        Iterator<String> i = getWords().iterator();
        while ( i.hasNext() )
        {
            String w = i.next();
            String p = KmPhoneticEncoder.getPhonetic(w);
            KmList<String> v = m.get(p);
            if ( v == null )
            {
                v = new KmList<String>();
                m.put(p, v);
            }
            v.add(w);
        }
        return m;
    }

    //##################################################
    //# menu
    //##################################################

    public void menu()
    {
        while ( true )
        {
            System.out.println();
            System.out.println();
            System.out.println("Phonetic Test Application");
            System.out.println("  1. Find words (phonetic)");
            System.out.println("  2. Find words (substring)");
            System.out.println("  3. Find words (prefix)");
            System.out.println("  4. Find words (suffix)");
            System.out.println("  5. Parse word");
            System.out.println("  6. Load word list");
            System.out.println("  7. Load phonetic rules");
            System.out.println("  0. Exit");
            System.out.print("Enter choice: ");

            String s = readConsole().trim().toLowerCase();

            if ( s.equals("1") )
            {
                findWordsLike();
                continue;
            }

            if ( s.equals("2") )
            {
                findWordsWithSubstring();
                continue;
            }

            if ( s.equals("3") )
            {
                findWordsWithPrefix();
                continue;
            }

            if ( s.equals("4") )
            {
                findWordsWithSuffix();
                continue;
            }

            if ( s.equals("5") )
            {
                parseWord();
                continue;
            }

            if ( s.equals("6") )
            {
                loadWordList();
                continue;
            }

            if ( s.equals("7") )
            {
                loadPhoneticRules();
                continue;
            }

            if ( s.equals("0") )
            {
                System.out.println("Done.");
                break;
            }

            System.out.println("ERROR - unknown command: " + s);
        }
    }

    public String findWordsLike()
    {
        while ( true )
        {
            System.out.println();
            System.out.println();
            System.out.print("Find Words Like: ");
            String s = readConsole();
            if ( s.equals("") )
                return s;
            String p = KmPhoneticEncoder.getPhonetic(s);
            System.out.println("  Phonetic: " + p);
            KmList<String> v = getWordsLike(s);
            printWordMatches(v, false);
        }
    }

    public void findWordsWithSubstring()
    {
        while ( true )
        {
            System.out.println();
            System.out.println();
            System.out.print("Find Words with Substring: ");
            String s = readConsole();
            if ( s.equals("") )
                return;
            KmList<String> v = getWordsWithSubstring(s);
            printWordMatches(v, true);
        }
    }

    public void findWordsWithPrefix()
    {
        while ( true )
        {
            System.out.println();
            System.out.println();
            System.out.print("Find Words with Prefix: ");
            String s = readConsole();
            if ( s.equals("") )
                return;
            KmList<String> v = getWordsWithPrefix(s);
            printWordMatches(v, true);
        }
    }

    public void findWordsWithSuffix()
    {
        while ( true )
        {
            System.out.println();
            System.out.println();
            System.out.print("Find Words with Suffix: ");
            String s = readConsole();
            if ( s.equals("") )
                return;
            KmList<String> v = getWordsWithSuffix(s);
            printWordMatches(v, true);
        }
    }

    public void parseWord()
    {
        while ( true )
        {
            System.out.println();
            System.out.println();
            System.out.print("Parse Word: ");
            String s = readConsole();
            if ( s.equals("") )
                return;
            String p = KmPhoneticEncoder.getInstance().encode(s, true);
            System.out.println("  Phonetic: " + p);
        }
    }

    public void loadWordList()
    {
        System.out.println();
        System.out.println();
        System.out.println("Loading word list: " + getWordsPath());

        _loadWordList();
    }

    public void loadPhoneticRules()
    {
        System.out.println();
        System.out.println();
        System.out.println("Loading phonetic rules: " + getRulesPath());

        _loadPhoneticRules();
    }

    //##################################################
    //# utility
    //##################################################

    public String readConsole()
    {
        try
        {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            return br.readLine();
        }
        catch ( Exception ex )
        {
            ex.printStackTrace();
            return "";
        }
    }

    public void printWordMatches(KmList<String> v, boolean showPhonetics)
    {
        if ( v.isEmpty() )
        {
            System.out.println("  No matches found");
            return;
        }
        System.out.println("  Matches found (" + v.size() + ")...");
        Iterator<String> i = v.iterator();
        while ( i.hasNext() )
        {
            String s = i.next();
            if ( showPhonetics )
                s = Kmu.rightPad(s, 20) + ": " + KmPhoneticEncoder.getPhonetic(s);
            System.out.println("    " + s);
        }
    }

    public void _loadWordList()
    {
        try
        {
            String path = getWordsPath();
            System.out.println("  Loading words: " + path);

            _words = new KmList<String>();
            resetPhonetics();

            KmList<String> lines;
            lines = Kmu.readClassLines(path);
            Kmu.removeBlankLines(lines);
            Kmu.trimValues(lines);
            lines.sort();

            _words = lines;

            System.out.println("  Word count:     " + getWords().size());
            System.out.println("  Phonetic count: " + getPhonetics().size());
            System.out.println("ok.");
        }
        catch ( RuntimeException ex )
        {
            System.out.println("ERROR: Cannot load words");
            System.out.println("  Path: " + getWordsPath());
            System.out.println("  " + ex.getMessage());
        }
    }

    public void _loadPhoneticRules()
    {
        String path = getRulesPath();
        try
        {
            System.out.println("  Loading rules: " + path);

            KmPhoneticEncoder.getInstance().loadRulesFromResource(path);
            System.out.println("ok.");
        }
        catch ( Exception ex )
        {
            System.out.println("ERROR: Cannot load rules");
            System.out.println("  Path: " + path);
            System.out.println("  " + ex.getMessage());
        }
    }

    public Comparator<String> getEditDistanceComparator(String base)
    {
        return new KmAdjustedEditDistanceComparator(base);
    }

    //##################################################
    //# support
    //##################################################

    private String getRulesPath()
    {
        return Kmu.joinFilePath(getPackagePath(), "rules.txt");
    }

    private String getWordsPath()
    {
        return Kmu.joinFilePath(getPackagePath(), "words.txt");
    }

    private String getPackagePath()
    {
        String s;
        s = getClass().getPackage().getName();
        s = Kmu.replaceAll(s, ".", "/");
        return s;
    }
}
