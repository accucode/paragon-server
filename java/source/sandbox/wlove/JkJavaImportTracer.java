package sandbox.wlove;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.file.KmFile;
import com.kodemore.file.KmFileRoot;
import com.kodemore.utility.Kmu;

/**
 * I parse source files to determine what packages import 
 * what other packages.  
 */
public class JkJavaImportTracer
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        String path = "/projects/rebill/java/source";

        JkJavaImportTracer checker;
        checker = new JkJavaImportTracer();
        checker.setSourceRoot(path);
        checker.ignorePrefix("com.sun.");
        checker.ignorePrefix("java.");
        checker.ignorePrefix("javax.");
        checker.ignorePrefix("org.");
        checker.parseAll();

        String startAt;
        String stopAt;

        startAt = "com.kodemore.generator.KmgGenerator";
        stopAt = "Sc";

        checker.printTree(startAt, stopAt);

        checker.println();
        checker.println("ok.");
    }

    //##################################################
    //# variables
    //##################################################

    private KmFileRoot                      _sourceRoot;
    private KmList<String>                  _ignoredPrefixes;

    private KmList<JicSource>               _sources;
    private KmMap<String,JicSource>         _sourcesByName;
    private KmMap<String,KmList<JicSource>> _sourcesByPackage;

    //##################################################
    //# constructor
    //##################################################

    public JkJavaImportTracer()
    {
        _ignoredPrefixes = new KmList<String>();

        _sources = new KmList<JicSource>();
        _sourcesByName = new KmMap<String,JicSource>();
        _sourcesByPackage = new KmMap<String,KmList<JicSource>>();
    }

    //##################################################
    //# accessing
    //##################################################

    public void setSourceRoot(String path)
    {
        _sourceRoot = new KmFileRoot(path);
    }

    public KmList<String> getIgnoredPrefixes()
    {
        return _ignoredPrefixes;
    }

    public void ignorePrefix(String e)
    {
        _ignoredPrefixes.add(e);
    }

    //##################################################
    //# parse
    //##################################################

    private void parseAll()
    {
        parseAll(_sourceRoot.getFolder());
    }

    private void parseAll(KmFile f)
    {
        if ( f.isFolder() )
            parseFolder(f);

        if ( f.isFile() )
            parseFile(f);
    }

    private void parseFolder(KmFile folder)
    {
        KmList<KmFile> v = folder.getChildren();
        for ( KmFile e : v )
            parseAll(e);
    }

    private void parseFile(KmFile f)
    {
        println("parsing... " + f);

        JicSource e;
        e = new JicSource();
        e.applyPath(f);

        parseImports(e, f);

        String name = e.name;
        String pkg = e.pkg;

        _sources.add(e);
        _sourcesByName.put(name, e);

        KmList<JicSource> v = _sourcesByPackage.get(pkg);
        if ( v == null )
        {
            v = new KmList<JicSource>();
            _sourcesByPackage.put(pkg, v);
        }
        v.add(e);
    }

    private void parseImports(JicSource e, KmFile f)
    {
        String source = f.readString();

        KmList<String> lines = Kmu.getLines(source);
        for ( String line : lines )
        {
            String i = parseImport(line);
            if ( i != null )
                e.imports.addDistinct(i);
        }
    }

    private String parseImport(String line)
    {
        final String prefix = "import ";

        line = line.trim();

        if ( !line.startsWith(prefix) )
            return null;

        line = Kmu.removePrefix(line, prefix);
        line = Kmu.removeSuffix(line, ";");

        if ( line.endsWith(".*") )
            line = Kmu.removeSuffix(line, ".*");
        else
        {
            int i = line.lastIndexOf(".");
            line = line.substring(0, i);
        }

        if ( excludes(line) )
            return null;

        return line;
    }

    private boolean excludes(String s)
    {
        for ( String prefix : _ignoredPrefixes )
            if ( s.startsWith(prefix) )
                return true;

        return false;
    }

    //##################################################
    //# print
    //##################################################

    public void printSourceNames()
    {
        KmList<String> v = getSourceNames();
        for ( String e : v )
            println(e);
    }

    public void printSourcesWithImports()
    {
        KmList<String> names = getSourceNames();
        for ( String name : names )
        {
            println();
            println(name);

            JicSource source = _sourcesByName.get(name);

            KmList<String> imports;
            imports = source.imports;
            imports.sort();

            for ( String i : imports )
                println("    " + i);
        }
    }

    public void printTree(String startAt, String stopAt)
    {
        try
        {
            println();
            println();
            println("printTree");

            JicSource source = _sourcesByName.get(startAt);
            KmList<String> log = new KmList<String>();
            int level = 0;

            printTree(source, stopAt, log, level);
        }
        catch ( StopException ex )
        {
            println("Stopped at: " + stopAt);
        }
    }

    private void printTree(JicSource source, String stopAt, KmList<String> logs, int level)
    {
        String name = source.name;
        String indent = Kmu.repeat("|   ", level);

        if ( !logs.addDistinct(name) )
            return;

        println(indent + name);

        if ( stopAt != null )
            if ( name.contains(stopAt) )
                throw new StopException();

        for ( String pkg : source.imports )
        {
            KmList<JicSource> sources = _sourcesByPackage.get(pkg);

            if ( sources != null )
                for ( JicSource e : sources )
                    printTree(e, stopAt, logs, level + 1);
        }
    }

    //##################################################
    //# print
    //##################################################

    public void println()
    {
        println("");
    }

    public void println(String msg, Object... args)
    {
        System.out.println(Kmu.format(msg, args));
    }

    //##################################################
    //# accessing
    //##################################################

    public KmList<String> getSourceNames()
    {
        KmList<String> v;
        v = _sourcesByName.getKeys();
        v.sort();
        return v;
    }

    //##################################################
    //# classes
    //##################################################

    private class StopException
        extends RuntimeException
    {
        // 
    }

    @SuppressWarnings("unused")
    private class JicSource
        implements Comparable<JicSource>
    {
        String         name;
        String         pkg;
        String         path;
        KmList<String> imports = new KmList<String>();

        public void applyPath(KmFile f)
        {
            String s;
            s = f.getPath();

            path = f.getPath();

            s = Kmu.removePrefix(s, "/");
            s = Kmu.removeSuffix(s, ".java");
            s = Kmu.replaceAll(s, "/", ".");
            name = s;

            int i = s.lastIndexOf(".");
            if ( i >= 0 )
                s = s.substring(0, i);
            pkg = s;
        }

        @Override
        public boolean equals(Object o)
        {
            if ( o instanceof JicSource )
                return ((JicSource)o).name.equals(name);

            return false;
        }

        @Override
        public int hashCode()
        {
            return name.hashCode();
        }

        @Override
        public int compareTo(JicSource o)
        {
            return o.name.compareTo(name);
        }
    }
}
