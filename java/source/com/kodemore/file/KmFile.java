package com.kodemore.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

import com.kodemore.collection.KmList;
import com.kodemore.log.KmLog;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.Kmu;

/**
 * See also KmFileRoot
 */
public class KmFile
    implements Comparable<KmFile>, KmFileConstantsIF
{
    //##################################################
    //# instance creation
    //##################################################

    /**
     * Create a new instance for the current working folder.
     */
    public static KmFile workingFolder()
    {
        return new KmFile(Kmu.getWorkingFolder());
    }

    //##################################################
    //# variables
    //##################################################

    private KmFileRoot _root;
    private String     _relativePath;
    private String     _realPath;

    //##################################################
    //# constructor
    //##################################################

    public KmFile(String path)
    {
        _root = new KmFileRoot(Kmu.getRootPath(path));
        _relativePath = Kmu.getReleativePath(path);

        initRealPath();
    }

    public KmFile(File file)
    {
        this(file.getPath());
    }

    public KmFile(KmFileRoot root, String relativePath)
    {
        _root = root;
        _relativePath = relativePath;

        initRealPath();
    }

    private void initRealPath()
    {
        String rootPath = _root.getPath();
        File file = new File(rootPath, _relativePath);
        _realPath = Kmu.getCanonicalPath(file);

        if ( !_realPath.startsWith(rootPath) )
            throw Kmu.newFatal("Attempt to access file outside root folder.");
    }

    //##################################################
    //# accessing
    //##################################################

    public KmFileRoot getRoot()
    {
        return _root;
    }

    public String getPath()
    {
        return _relativePath;
    }

    public boolean hasPath(String e)
    {
        return getPath().equals(e);
    }

    public String getRealPath()
    {
        return _realPath;
    }

    public File getRealFile()
    {
        return new File(getRealPath());
    }

    //##################################################
    //# abstract accessing
    //##################################################

    /**
     * Get the file's name.  This is everything after the last slash.
     */
    public String getName()
    {
        String path = getPath();
        int i = path.lastIndexOf(SLASH);

        if ( i < 0 )
            return path;

        return path.substring(i + 1);
    }

    /**
     * Get the file's name without the extension.
     */
    public String getShortName()
    {
        if ( !hasExtension() )
            return getName();

        return Kmu.removeSuffix(getName(), DOT + getExtension());
    }

    public boolean hasShortName(String e)
    {
        return Kmu.isEqual(getShortName(), e);
    }

    public String getExtension()
    {
        String name = getName();
        int i = name.lastIndexOf(DOT);

        if ( i < 0 )
            return null;

        return name.substring(i + 1);
    }

    public boolean hasExtension()
    {
        return Kmu.hasValue(getExtension());
    }

    public KmFile getParent()
    {
        if ( isRoot() )
            return null;

        String s = Kmu.removeSuffix(_relativePath, SLASH);
        int i = s.lastIndexOf(SLASH);
        String parentPath = s.substring(0, i + 1);

        return new KmFile(_root, parentPath);
    }

    public KmFile getChild(String path)
    {
        String rel = Kmu.joinFilePath(_relativePath, path);
        return new KmFile(_root, rel);
    }

    public KmList<KmFile> getChildren()
    {
        KmList<KmFile> v = new KmList<>();
        File[] files = getRealFile().listFiles();

        for ( File file : files )
            v.add(newFile(file));

        return v;
    }

    public KmFile getSibling(String name)
    {
        return getParent().getChild(name);
    }

    public KmFile getSiblingWithExtension(String ext)
    {
        if ( Kmu.isEmpty(ext) )
            return this;

        String name = getShortName() + DOT + ext;

        return getSibling(name);
    }

    public KmList<KmFile> getFiles()
    {
        KmList<KmFile> v = new KmList<>();

        File[] files = getRealFile().listFiles();
        for ( File file : files )
            if ( file.isFile() )
                v.add(newFile(file));

        return v;
    }

    public KmList<KmFile> getFilesWithExtension(String ext)
    {
        KmList<KmFile> v = getFiles();

        Iterator<KmFile> i = v.iterator();
        while ( i.hasNext() )
            if ( !i.next().hasExtension(ext) )
                i.remove();

        return v;
    }

    public KmList<KmFile> getFilesWithSuffix(String suffix)
    {
        KmList<KmFile> v = getFiles();

        Iterator<KmFile> i = v.iterator();
        while ( i.hasNext() )
            if ( !i.next().hasSuffix(suffix) )
                i.remove();

        return v;
    }

    public KmList<KmFile> getFolders()
    {
        KmList<KmFile> v = new KmList<>();
        File[] files = getRealFile().listFiles();

        for ( File file : files )
            if ( file.isDirectory() )
                v.add(newFile(file));

        return v;
    }

    // long msSince1970
    public long getLastModifiedOrdinal()
    {
        if ( !exists() )
            return 0;

        return getRealFile().lastModified();
    }

    public KmTimestamp getLastModifiedUtcTs()
    {
        long msSince1970 = getLastModifiedOrdinal();
        if ( msSince1970 == 0 )
            return null;

        return KmTimestamp.fromEpochMs(msSince1970);
    }

    public long getLength()
    {
        return getRealFile().length();
    }

    public boolean hasExtension(String e)
    {
        return hasSuffix("." + e);
    }

    public boolean hasSuffix(String e)
    {
        return getName().endsWith(e);
    }

    //##################################################
    //# testing
    //##################################################

    public boolean isRoot()
    {
        return _relativePath.equals(SLASH);
    }

    public boolean hasParent()
    {
        return !isRoot();
    }

    public boolean exists()
    {
        return getRealFile().exists();
    }

    public boolean isFile()
    {
        return getRealFile().isFile();
    }

    public boolean isFolder()
    {
        return getRealFile().isDirectory();
    }

    //##################################################
    //# read / write
    //##################################################

    public boolean createFolder()
    {
        return createFolder(true);
    }

    public boolean createFolder(boolean createMissingParents)
    {
        File file = getRealFile();

        if ( createMissingParents )
            return Kmu.createFolder(file);

        return file.mkdir();
    }

    public boolean delete()
    {
        return getRealFile().delete();
    }

    public String readString()
    {
        return new String(readBytes());
    }

    public KmList<String> readLines()
    {
        return Kmu.parseLines(readString());
    }

    public byte[] readBytes()
    {
        return Kmu.readFileBytes(_realPath);
    }

    public void write(String data)
    {
        write(data.getBytes());
    }

    public void write(byte[] data)
    {
        Kmu.writeFile(getRealFile(), data);
    }

    public void replaceAll(String search, String replace)
    {
        String s;
        s = readString();
        s = Kmu.replaceAll(s, search, replace);
        write(s);
    }

    //##################################################
    //# input stream
    //##################################################

    public FileInputStream getInputStream()
    {
        try
        {
            return new FileInputStream(getRealFile());
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public BufferedInputStream getBufferedInputStream()
    {
        return new BufferedInputStream(getInputStream());
    }

    //##################################################
    //# reader
    //##################################################

    public FileReader getReader()
    {
        try
        {
            return new FileReader(getRealFile());
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public BufferedReader getBufferedReader()
    {
        return new BufferedReader(getReader());
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object e)
    {
        if ( e instanceof KmFile )
            return ((KmFile)e).hasPath(getPath());

        return false;
    }

    @Override
    public int hashCode()
    {
        return getPath().hashCode();
    }

    @Override
    public int compareTo(KmFile e)
    {
        return getPath().compareTo(e.getPath());
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return _relativePath;
    }

    //##################################################
    //# private (file)
    //##################################################

    private KmFile newFile(File e)
    {
        String rel = Kmu.removePrefix(normalize(e), getRealRootPath());
        return new KmFile(_root, rel);
    }

    private String getRealRootPath()
    {
        return _root.getPath();
    }

    //##################################################
    //# support
    //##################################################

    private String normalize(File realFile)
    {
        return KmFileUtility.normalize(realFile.getPath());
    }

    //##################################################
    //# convenience
    //##################################################

    public void writeTo(OutputStream out)
    {
        try (BufferedInputStream in = getBufferedInputStream();)
        {
            // Do NOT put in try-resource.
            // We don't want to close it (just flush it).
            BufferedOutputStream buf = Kmu.toBufferedOutputStream(out);

            while ( true )
            {
                int i = in.read();
                if ( i < 0 )
                    break;

                buf.write(i);
            }

            buf.flush();
        }
        catch ( IOException ex )
        {
            KmLog.warn(ex, "Error writing http response.");
        }
    }

}
