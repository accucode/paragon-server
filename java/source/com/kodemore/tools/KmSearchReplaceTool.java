package com.kodemore.tools;

import com.kodemore.file.KmFile;
import com.kodemore.file.KmFileTraverser;
import com.kodemore.utility.Kmu;

/**
 * I am used to search multiple files and replace blocks of text.
 * In particular, I am often useful when replacing blocks that span
 * multiple lines.

        String folder = "/temp/folder";
        String ext = "html";
        String search = new KmFile("/temp/search.txt").readString();
        String replace = new KmFile("/temp/replace.txt").readString();

        KmSearchReplaceTool e;
        e = new KmSearchReplaceTool();
        e.setRootFolder(folder);
        e.setFileExtension(ext);
        e.setSearchText(search);
        e.setReplaceText(replace);

        e.findAll();
        // e.replaceAll();
 */
public class KmSearchReplaceTool
{
    //##################################################
    //# constants
    //##################################################

    private static final String EOL = "\r\n";

    //##################################################
    //# variables
    //##################################################

    private String              _rootFolder;
    private String              _filePrefix;
    private String              _fileSuffix;

    private String              _searchText;
    private String              _replaceText;

    //##################################################
    //# constuctor
    //##################################################

    public KmSearchReplaceTool()
    {
        _searchText = "";
        _replaceText = "";
    }

    //##################################################
    //# accessing
    //##################################################

    public String getRootFolder()
    {
        return _rootFolder;
    }

    public void setRootFolder(String e)
    {
        _rootFolder = e;
    }

    public String getFilePrefix()
    {
        return _filePrefix;
    }

    public void setFilePrefix(String e)
    {
        _filePrefix = e;
    }

    public boolean hasFilePrefix()
    {
        return Kmu.hasValue(getFilePrefix());
    }

    public String getFileSuffix()
    {
        return _fileSuffix;
    }

    public void setFileSuffix(String e)
    {
        _fileSuffix = e;
    }

    public void setFileExtension(String e)
    {
        if ( e == null )
        {
            setFileSuffix(null);
            return;
        }

        setFileSuffix("." + e);
    }

    public boolean hasFileSuffix()
    {
        return Kmu.hasValue(getFileSuffix());
    }

    public String getSearchText()
    {
        return _searchText;
    }

    public void setSearchText(String e)
    {
        _searchText = e;
    }

    public void setSearchText(KmFile file)
    {
        String s = file.readString();
        setSearchText(s);
    }

    public void addSearchText(String e)
    {
        if ( _searchText == null )
            _searchText = "";

        _searchText += e;
    }

    public void addSearchLine(String e)
    {
        addSearchText(e);
        addSearchLine();
    }

    public void addSearchLine()
    {
        addSearchText(EOL);
    }

    public String getReplaceText()
    {
        return _replaceText;
    }

    public void setReplaceText(String e)
    {
        _replaceText = e;
    }

    public void setReplaceText(KmFile file)
    {
        String s = file.readString();
        setReplaceText(s);
    }

    public void addReplaceText(String e)
    {
        if ( _replaceText == null )
            _replaceText = "";

        _replaceText += e;
    }

    public void addReplaceLine(String e)
    {
        addReplaceText(e);
        addReplaceLine();
    }

    public void addReplaceLine()
    {
        addReplaceText(EOL);
    }

    //##################################################
    //# run
    //##################################################

    public void findAll()
    {
        new KmFileTraverser()
        {
            @Override
            protected void processFile(KmFile file)
            {
                if ( !isMatch(file) )
                    return;

                String oldText = file.readString();
                if ( !oldText.contains(getSearchText()) )
                    return;

                System.out.println(file);
            }
        }.processAll(getRootFolder());
    }

    public void replaceAll()
    {
        new KmFileTraverser()
        {
            @Override
            protected void processFile(KmFile file)
            {
                if ( !isMatch(file) )
                    return;

                String search = getSearchText();
                String replace = getReplaceText();

                String oldText = file.readString();
                String newText = Kmu.replaceAll(oldText, search, replace);

                if ( oldText.equals(newText) )
                    return;

                System.out.println(file);
                file.write(newText);
            }
        }.processAll(getRootFolder());
    }

    //##################################################
    //# support
    //##################################################

    private boolean isMatch(KmFile file)
    {
        String name = file.getName();

        if ( hasFilePrefix() )
            if ( !name.startsWith(getFilePrefix()) )
                return false;

        if ( hasFileSuffix() )
            if ( !name.endsWith(getFileSuffix()) )
                return false;

        return true;
    }
}
