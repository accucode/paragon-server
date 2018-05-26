package com.app.macro;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

import com.app.model.MyAttachment;
import com.app.model.MyProject;
import com.app.model.MySite;
import com.app.utility.MyGlobals;

public class MyMacroDocumentFormatter
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The specific object that acts as the context for macros.
     * E.g.: a project, visit, job, etc.
     */
    private Object _context;

    /**
     * The context (project, job, visit, etc) that we are operating
     * on.  This determines which macros are available.
     */
    private MyMacroContextType _contextType;

    //##################################################
    //# context
    //##################################################

    public Object getContext()
    {
        return _context;
    }

    public MyMacroContextType getContextType()
    {
        return _contextType;
    }

    public boolean hasContext()
    {
        return _context != null;
    }

    public KmList<MyMacro> getMacros()
    {
        MyMacroFetcher f;
        f = new MyMacroFetcher();
        f.setContextType(getContextType());
        f.setProject(MyGlobals.getCurrentProject());
        return f.findAll();
    }

    //==================================================
    //= context :: sample
    //==================================================

    public void setSampleContext(MyMacroContextType type)
    {
        _context = null;
        _contextType = type;
    }

    //==================================================
    //= context :: domain
    //==================================================

    public void setContext(MyAttachment e)
    {
        _context = e;
        _contextType = MyMacroContextType.Attachment;
    }

    public void setContext(MyProject e)
    {
        _context = e;
        _contextType = MyMacroContextType.Project;
    }

    public void setContext(MySite e)
    {
        _context = e;
        _contextType = MyMacroContextType.Site;
    }

    //##################################################
    //# format
    //##################################################

    public String formatText(String s)
    {
        MyMacroDocument doc;
        doc = MyMacroDocumentParser.staticParse(s);
        doc.setContext(getContext());
        doc.setContextType(getContextType());
        doc.validateMacroParts();
        return doc.formatText();
    }

    public String formatHtml(String s)
    {
        MyMacroDocument doc;
        doc = MyMacroDocumentParser.staticParse(s);
        doc.setContext(getContext());
        doc.setContextType(getContextType());
        doc.validateMacroParts();
        return doc.formatHtml();
    }

    //==================================================
    //= mark
    //==================================================

    public static String markAllText(String s)
    {
        return markAll(s, false);
    }

    public static String markAllHtml(String s)
    {
        return markAll(s, true);
    }

    private static String markAll(String s, boolean html)
    {
        return html
            ? replaceAllWith(s, "<span style='color:red;font-weight:bold'>%s</span>")
            : replaceAllWith(s, ">>>>>%s<<<<<");
    }

    public static String replaceAllWith(String s, String pattern)
    {
        KmList<String> all = findAllMacros(s);
        for ( String macro : all )
        {
            String marker = Kmu.format(pattern, macro);
            s = Kmu.replaceAll(s, macro, marker);
        }
        return s;
    }

    /**
     * This searches for strings matching the pattern: $(token)
     */
    public static KmList<String> findAllMacros(String s)
    {
        String regex = "\\$\\(.*?\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);

        KmList<String> v = KmList.createEmpty();
        while ( matcher.find() )
            v.addDistinct(matcher.group());

        return v;
    }
}
