/*
 Copyright 2005-2011 Kodemore.com

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

package com.kodemore.utility;

import com.kodemore.collection.KmList;
import com.kodemore.string.KmStringTokenizer;

/**
 * I provide easy parsing and validation of email addresses.
 */
public class KmEmailAddressParser
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        String source = KmList.createStrings(
            "a1@example.net",
            " a2@example.net",
            "<b1@example.net>",
            "< b2@example.net>",
            "c1<c@example.net>",
            "c2 <c@example.net>",
            "d1(d@example.net)",
            "d2 (d@example.net)",
            "").join();

        KmEmailAddressParser p;
        p = staticParse(source);

        System.out.println();
        System.out.println("Addresses...");
        p.getValidEmails().printLines(e -> "    " + e);

        System.out.println();
        System.out.println("Errors...");
        p.getInvalidEmails().printLines(e -> "    " + e);

        System.out.println();
        System.out.println("done.");
    }

    public static KmEmailAddressParser staticParse(String source)
    {
        KmEmailAddressParser e;
        e = new KmEmailAddressParser();
        e.parse(source);
        return e;
    }

    //##################################################
    //# variables
    //##################################################

    private String                 _source;
    private KmList<KmEmailAddress> _emails;

    //##################################################
    //# constructor
    //##################################################

    public KmEmailAddressParser()
    {
        // none
    }

    //##################################################
    //# source
    //##################################################

    public String getSource()
    {
        return _source;
    }

    //##################################################
    //# emails
    //##################################################

    public KmList<KmEmailAddress> getAllEmails()
    {
        return _emails;
    }

    private void addEmail(KmEmailAddress e)
    {
        _emails.add(e);
    }

    public KmList<KmEmailAddress> getValidEmails()
    {
        return getAllEmails().select(e -> e.isValid());
    }

    public KmList<KmEmailAddress> getInvalidEmails()
    {
        return getAllEmails().select(e -> !e.isValid());
    }

    //##################################################
    //# test
    //##################################################

    public boolean isOk()
    {
        return getInvalidEmails().isEmpty();
    }

    public boolean hasErrors()
    {
        return !isOk();
    }

    private void addError(String source)
    {
        KmEmailAddress e;
        e = new KmEmailAddress();
        e.setSource(source);
        addEmail(e);
    }

    //##################################################
    //# parse
    //##################################################

    public void parse(String source)
    {
        _source = source;
        _emails = KmList.createEmpty();

        for ( String s : getSections() )
            parseSection(s);
    }

    private KmList<String> getSections()
    {
        KmStringTokenizer t;
        t = new KmStringTokenizer();
        t.addCommaDelimiter();
        t.addSemicolonDelimiter();
        t.addLineDelimiters();
        t.setTrimValues();
        t.setIgnoreEmptyValues();
        return t.split(getSource());
    }

    private void parseSection(String section)
    {
        String s = section;
        String comment = null;
        int i;

        i = s.lastIndexOf(" ");
        if ( i >= 0 )
        {
            comment = s.substring(0, i);
            s = s.substring(i + 1);
        }

        if ( comment == null )
        {
            i = s.indexOf("<");
            if ( i >= 0 )
            {
                comment = s.substring(0, i);
                s = s.substring(i);
            }
        }

        if ( comment == null )
        {
            i = s.indexOf("(");
            if ( i >= 0 )
            {
                comment = s.substring(0, i);
                s = s.substring(i);
            }
        }

        s = strip(s, "<", ">");
        s = strip(s, "(", ")");

        i = s.indexOf("@");
        if ( i < 0 )
        {
            addError(section);
            return;
        }

        String name = s.substring(0, i);
        String host = s.substring(i + 1);

        KmEmailAddress e;
        e = new KmEmailAddress();
        e.setName(name);
        e.setHost(host);
        e.setComment(comment);

        KmSimpleResult r = e.validate();
        if ( r.hasError() )
        {
            addError(section);
            return;
        }

        addEmail(e);
    }

    private String strip(String s, String prefix, String suffix)
    {
        if ( !s.startsWith(prefix) )
            return s;

        if ( !s.endsWith(suffix) )
            return s;

        s = Kmu.removePrefix(s, prefix);
        s = Kmu.removeSuffix(s, suffix);
        return s.trim();
    }
}
