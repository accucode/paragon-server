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

package com.kodemore.phonetic;

import java.util.Iterator;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

/**
 * A utility class to generate the phonetic encoding for a string.
 *
 * The default rules are loaded from the resource: phoneticRules.txt.
 * However, alternate rule sets may be loaded from other sources, or
 * encoded manually.
 */
public class KmPhoneticEncoder
{
    //##################################################
    //# variables
    //##################################################

    private KmList<KmPhoneticRule> _rules;

    //##################################################
    //# constructor
    //##################################################

    public KmPhoneticEncoder()
    {
        _rules = new KmList<>();
        loadDefaultRules();
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

    public void loadRulesFromResource(Class<?> klass, String path)
    {
        KmPhoneticRuleParser rp;
        rp = new KmPhoneticRuleParser();
        _rules = rp.parseResource(klass, path);
    }

    public void loadDefaultRules()
    {
        loadRulesFromResource(getClass(), "phoneticRules.txt");
    }
}
