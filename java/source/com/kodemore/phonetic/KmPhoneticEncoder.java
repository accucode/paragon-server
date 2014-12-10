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

import java.util.Iterator;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

/**
 * A utility class to generate the phonetic encoding for a string.
 */
public class KmPhoneticEncoder
{
    //##################################################
    //# static
    //##################################################

    private static KmPhoneticEncoder _instance;

    public static KmPhoneticEncoder getInstance()
    {
        if ( _instance == null )
        {
            KmPhoneticEncoder e;
            e = new KmPhoneticEncoder();
            e.installDefaultRules();
            _instance = e;
        }
        return _instance;
    }

    public static void setInstance(KmPhoneticEncoder e)
    {
        _instance = e;
    }

    public static String getPhonetic(String s)
    {
        return getInstance().encode(s);
    }

    //##################################################
    //# variables
    //##################################################

    private KmList<KmPhoneticRule> _rules;

    //##################################################
    //# constructor
    //##################################################

    public KmPhoneticEncoder()
    {
        _rules = new KmList<KmPhoneticRule>();
        installDefaultRules();
    }

    //##################################################
    //# accessing
    //##################################################

    public String encode(String s)
    {
        return encode(s, false);
    }

    public String encode(String s, boolean verbose)
    {
        s = s.trim();
        s = s.toLowerCase();
        s = Kmu.stripNonLetters(s);

        Iterator<KmPhoneticRule> i = getRules().iterator();
        while ( i.hasNext() )
        {
            KmPhoneticRule r = i.next();
            s = r.applyTo(s, verbose);
        }

        return s;
    }

    //##################################################
    //# rules
    //##################################################

    public KmList<KmPhoneticRule> getRules()
    {
        return _rules;
    }

    public void clearRules()
    {
        _rules.clear();
    }

    public void addRule(KmPhoneticRule r)
    {
        _rules.add(r);
    }

    public void addRule(String a, String b)
    {
        KmPhoneticRule r;
        r = new KmPhoneticRule();
        r.setMode(KmPhoneticRule.MODE_ALL);
        r.setOldValue(a);
        r.setNewValue(b);
        addRule(r);
    }

    public void addPrefixRule(String a, String b)
    {
        KmPhoneticRule r;
        r = new KmPhoneticRule();
        r.setMode(KmPhoneticRule.MODE_PREFIX);
        r.setOldValue(a);
        r.setNewValue(b);
        addRule(r);
    }

    public void addSuffixRule(String a, String b)
    {
        KmPhoneticRule r;
        r = new KmPhoneticRule();
        r.setMode(KmPhoneticRule.MODE_SUFFIX);
        r.setOldValue(a);
        r.setNewValue(b);
        addRule(r);
    }

    public void loadRulesFromFile(String path)
    {
        KmPhoneticRuleParser rp;
        rp = new KmPhoneticRuleParser();
        _rules = rp.parseFile(path);
    }

    public void loadRulesFromResource(String path)
    {
        KmPhoneticRuleParser rp;
        rp = new KmPhoneticRuleParser();
        _rules = rp.parseResource(path);
    }

    public void installDefaultRules()
    {
        clearRules();

        // replace y's with i's (except if y is first letter of word).
        addPrefixRule("y", "%");
        addRule("y", "i");
        addPrefixRule("%", "y");

        addRule("laugh", "laf"); // laugh
        addRule("ascis", "ashis"); // fashist

        addPrefixRule("gn", "n"); // gnome
        addPrefixRule("gh", "g"); // ghost
        addPrefixRule("jua", "wa"); // juan
        addPrefixRule("kn", "n"); // know
        addPrefixRule("pn", "n"); // pneumonia
        addPrefixRule("ps", "s"); // psycology
        addPrefixRule("pf", "f"); // pfizer
        addPrefixRule("rh", "r"); // rhombus
        addPrefixRule("ts", "s"); // tsunami
        addPrefixRule("who", "ho"); // whore
        addPrefixRule("wh", "w"); // whale
        addPrefixRule("x", "s"); // xerox

        addSuffixRule("ajo", "aho"); // navajo
        addSuffixRule("cht", "t"); // yacht
        addSuffixRule("ejo", "eho"); // viejo
        addSuffixRule("fth", "th"); // fifth
        addSuffixRule("ght", "t"); // flight
        addSuffixRule("gn", "n"); // foreign
        addSuffixRule("gns", "ns"); // aligns
        addSuffixRule("gned", "nd"); // aligned
        addSuffixRule("illa", "ia"); // tortilla
        addSuffixRule("illas", "ias"); // villas
        addSuffixRule("mb", "m"); // dumb
        addSuffixRule("mn", "m"); // condemn
        addSuffixRule("ogh", "o"); // van gogh
        addSuffixRule("ough", "of"); // enough
        addSuffixRule("augh", "a"); // limbaugh

        addRule("cce", "kse"); // success
        addRule("cci", "ksi"); // succinct
        addRule("ph", "f"); // pharmacy
        addRule("sce", "se"); // scene
        addRule("scho", "sko"); // school
        addRule("sche", "ske"); // schema
        addRule("sch", "sh"); // busch
        addRule("sci", "si"); // science
        addRule("gg", "k"); // egg

        addRule("z", "s");
        addRule("x", "ks");
        addRule("q", "k");
        addRule("v", "f");

        // replace sh with x, unless sh is part of ssh.
        addRule("ss", "%");
        addRule("sh", "x");
        addRule("%", "ss");

        addRule("ck", "k"); // clock

        addRule("aa", "a"); // double letters
        addRule("bb", "b");
        addRule("cc", "c");
        addRule("dd", "d");
        addRule("ee", "e");
        addRule("ff", "f");
        addRule("gg", "g");
        addRule("hh", "h");
        addRule("ii", "i");
        addRule("jj", "j");
        addRule("kk", "k");
        addRule("ll", "l");
        addRule("mm", "m");
        addRule("nn", "n");
        addRule("oo", "o");
        addRule("pp", "p");
        addRule("qq", "q");
        addRule("rr", "r");
        addRule("ss", "s");
        addRule("tt", "t");
        addRule("uu", "u");
        addRule("vv", "v");
        addRule("ww", "w");
        addRule("xx", "x");
        addRule("yy", "y");
        addRule("zz", "z");

        addRule("cia", "xa"); // official
        addRule("dge", "je"); // judge
        addRule("dgi", "ji"); //
        addRule("gi", "ji"); // gin
        addRule("ge", "je"); // gender
        addRule("sia", "xa"); // persian
        addRule("sio", "xa"); // tension
        addRule("tch", "x"); // itch
        addRule("tia", "xa"); // martian
        addRule("tio", "xo"); // action
        addRule("th", "z"); // this
        addRule("ch", "x"); // sandwich
        addRule("ci", "sa"); // cinder
        addRule("ce", "sa"); // central
        addRule("gh", "k"); // spaghetti

        addRule("d", "t");
        addRule("c", "k");
        addRule("g", "k");

        addSuffixRule("s", ""); // plurals

        addRule("e", "a");
        addRule("i", "a");
        addRule("o", "a");
        addRule("u", "a");

        // remove h if after a vowel and no vowel follows
        addRule("ah", "%");
        addRule("%a", "aha");
        addRule("%", "a");

        // remove w if not followed by a vowel
        addRule("w", "%");
        addRule("%a", "wa");
        addRule("%", "");

        // remove vowels; keep a leading e if the first letter was a vowel.
        addRule("a", "e");
        addPrefixRule("e", "%");
        addRule("e", "");
        addPrefixRule("%", "e");
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String args[])
    {
        if ( args.length == 0 )
        {
            System.out.println("Specify the word to convert.");
            return;
        }
        String s = args[0];
        System.out.println("Source:  : " + s);
        System.out.println("Phonic: " + KmPhoneticEncoder.getPhonetic(s));
    }
}
