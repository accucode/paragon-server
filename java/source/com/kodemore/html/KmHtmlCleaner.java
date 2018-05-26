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

package com.kodemore.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

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

    private boolean _allowImages;
    private boolean _allowLinks;

    /**
     * If true, the default, any non-printable characters will be stripped.
     */
    private boolean _stripsNonPrintable;

    //##################################################
    //# constructor
    //##################################################

    public KmHtmlCleaner()
    {
        _whitelist = new KmList<>();
        _blacklist = new KmList<>();

        _allowImages = false;
        _allowLinks = false;

        _stripsNonPrintable = true;
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

    public boolean allowsImages()
    {
        return _allowImages;
    }

    public void allowImages()
    {
        _allowImages = true;
    }

    public void removeImages()
    {
        _allowImages = false;
    }

    public boolean allowsLinks()
    {
        return _allowLinks;
    }

    public void allowLinks()
    {
        _allowLinks = true;
    }

    public boolean getStripsNonPrintable()
    {
        return _stripsNonPrintable;
    }

    public void setStripsNonPrintable(boolean e)
    {
        _stripsNonPrintable = e;
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

    public String clean(String source)
    {
        Document doc = Jsoup.parseBodyFragment(source);

        for ( String tag : getBlacklist() )
            doc.getElementsByTag(tag).remove();

        String html = doc.html();

        Whitelist white;
        white = new Whitelist();
        white.addTags(getWhitelist().toStringArray());

        addTableTo(white);

        if ( allowsImages() )
            addImagesTo(white);

        if ( allowsLinks() )
            addLinksTo(white);

        // allow class tags for all
        white.addAttributes(":all", "class", "style");

        String out = Jsoup.clean(html, white);

        if ( getStripsNonPrintable() )
            out = Kmu.stripNonMultiLinePrintable(out);

        return out;
    }

    public void setDefaultWhitelist()
    {
        addToWhitelist("strong");
        addToWhitelist("span");
        addToWhitelist("em");
        addToWhitelist("e");
        addToWhitelist("sub");
        addToWhitelist("sup");
        addToWhitelist("p");
        addToWhitelist("s");
        addToWhitelist("ol");
        addToWhitelist("ul");
        addToWhitelist("li");
        addToWhitelist("h1");
        addToWhitelist("h2");
        addToWhitelist("h3");
        addToWhitelist("h4");
        addToWhitelist("br");
    }

    private void addImagesTo(Whitelist wl)
    {
        wl.addTags("img");
        wl.addAttributes("img", "alt", "src", "style");
    }

    private void addLinksTo(Whitelist wl)
    {
        wl.addTags("a");
        wl.addAttributes("a", "target", "href");
    }

    private void addTableTo(Whitelist wl)
    {
        wl.addTags("table");
        wl.addTags("tbody");
        wl.addTags("tfoot");
        wl.addTags("head");
        wl.addTags("th");
        wl.addTags("tr");
        wl.addTags("td");
        wl.addTags("caption");
        wl.addAttributes("table", "style", "border");
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
        c.addToWhitelist("img");
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
