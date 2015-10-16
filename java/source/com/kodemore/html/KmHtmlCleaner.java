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

package com.kodemore.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;

import com.kodemore.collection.KmList;

/**
 * I provide a convenient tool for stripping unwanted tags from html.
 * By default, all html tags will be stripped but the contents will
 * remain.  If a tag is added to the whitelist, thost html tags will
 * not be removed.  If a tag is added to the black list, not only will the
 * tags be removed, but all content inside of those tags will also be removed.
 *
 * For example:
 *
 * Original String: "Hello <b>World</b>"
 *
 * Default output: "Hello World"
 * "b" whitelisted: "Hello <b>World</b>"
 * "b" blacklisted: "Hello "
 */
public class KmHtmlCleaner
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The list of acceptable html tags.  These tags will not be removed.  Html tags
     * that are not in this list will be removed, but their content will be preserved.
     */
    private KmList<String> _whitelist;

    /**
     * Html tags on in this list will be removed and thave their content removed.
     */
    private KmList<String> _blacklist;

    //##################################################
    //# constructor
    //##################################################

    public KmHtmlCleaner()
    {
        _whitelist = new KmList<>();
        _blacklist = new KmList<>();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmList<String> getWhitelist()
    {
        return _whitelist;
    }

    public void setWhitelist(KmList<String> e)
    {
        _whitelist = e;
    }

    private KmList<String> getBlacklist()
    {
        return _blacklist;
    }

    public void setBlacklist(KmList<String> e)
    {
        _blacklist = e;
    }

    //##################################################
    //# convenience
    //##################################################

    public void addToWhitelist(String tag)
    {
        getWhitelist().add(tag);
    }

    public void addToBlacklist(String tag)
    {
        getBlacklist().add(tag);
    }

    public String clean(String e)
    {
        Document doc = Jsoup.parseBodyFragment(e);

        KmList<String> bl = getBlacklist();

        for ( String tag : bl )
            doc.getElementsByTag(tag).remove();

        e = doc.html();
        Whitelist wl = new Whitelist();
        wl.addTags(getWhitelist().toStringArray());

        return Jsoup.clean(e, wl);
    }

    public void setDefaultWhitelist()
    {
        addToWhitelist("strong");
        addToWhitelist("em");
        addToWhitelist("e");
        addToWhitelist("sub");
        addToWhitelist("sup");
        addToWhitelist("p");
        addToWhitelist("s");
        addToWhitelist("ol");
        addToWhitelist("ul");
        addToWhitelist("li");
    }

    public void setDefaultBlacklist()
    {
        addToBlacklist("script");
        addToBlacklist("textarea");
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        String s = getSampleHtml();

        KmHtmlCleaner c;
        c = new KmHtmlCleaner();
        c.addToWhitelist("b");
        c.addToBlacklist("s");

        String out = c.clean(s);

        System.out.println("Input:");
        System.out.println(s);
        System.out.println();
        System.out.println("Output:");
        System.out.println(out);
    }

    private static String getSampleHtml()
    {
        String s = "<b>whitelist</b> <s>blacklist</s> <em>default</em>";
        return s;
    }
}
