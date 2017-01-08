package sandbox.wlove;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmSet;
import com.kodemore.collection.KmSetImpl;
import com.kodemore.console.KmConsoleInput;
import com.kodemore.file.KmFile;
import com.kodemore.file.KmFileTraverser;
import com.kodemore.utility.Kmu;

import com.app.file.MyDevelopmentFiles;
import com.app.utility.MyInstaller;

public class JkNameTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String args[])
    {
        new JkNameTest().run();
    }

    //##################################################
    //# variables
    //##################################################

    private KmList<Node>   nodes;

    private KmList<String> prefixes;
    private KmList<String> suffixes;

    //##################################################
    //# run
    //##################################################

    public void run()
    {
        install();
        test();
    }

    private void install()
    {
        nodes = new KmList<>();
        new KmFileTraverser()
        {
            @Override
            protected void processFile(KmFile f)
            {
                String suffix = ".java";
                String s = f.getName();
                if ( s.endsWith(suffix) )
                {
                    s = Kmu.removeSuffix(s, suffix);
                    Node e = new Node(s);
                    nodes.add(e);
                }
            }
        }.processAll(getSourcePath());
    }

    private String getSourcePath()
    {
        MyInstaller.installCore();
        return MyDevelopmentFiles.getJavaSourcePath();
    }

    //##################################################
    //# test
    //##################################################

    private void test()
    {
        prefixes = new KmList<>();
        suffixes = new KmList<>();

        while ( true )
            if ( !menu() )
                break;
    }

    private boolean menu()
    {
        System.out.println("=======================================================");
        System.out.println();
        System.out.println("Prefixes: " + prefixes.join());
        System.out.println("Suffixes: " + suffixes.join());
        System.out.println();
        System.out.printf("P. Add Prefix(%s)\n", getPrefixCandidates().size());
        System.out.printf("S. Add Suffix(%s)\n", getSuffixCandidates().size());
        System.out.printf("Q. Quit\n");
        System.out.println();

        String s = KmConsoleInput.readString("Enter: ").trim().toUpperCase();
        System.out.println();

        if ( Kmu.isEmpty(s) )
        {
            System.out.println("No menu selection.");
            return true;
        }

        if ( s.equals("Q") )
            return false;

        if ( s.equals("P") )
        {
            System.out.println("Add Prefix");
            int i = 1;
            KmList<String> v = getPrefixCandidates();
            for ( String e : v )
                System.out.printf("%s.\t%s\n", i++, e);
            i = KmConsoleInput.readInteger("Enter: ");
            s = v.getAtSafe(i);
            prefixes.addNonNull(s);
            return true;
        }

        if ( s.equals("S") )
        {
            System.out.println("Add Suffix");
            int i = 1;
            KmList<String> v = getSuffixCandidates();
            for ( String e : v )
                System.out.printf("%s.\t%s\n", i++, e);
            i = KmConsoleInput.readInteger("Enter: ");
            s = v.getAtSafe(i);
            suffixes.addNonNull(s);
            return true;
        }

        return true;
    }

    private KmList<Node> getMatches()
    {
        KmList<Node> v = new KmList<>();
        for ( Node e : nodes )
            if ( isMatch(e) )
                v.add(e);
        return v;

    }

    private boolean isMatch(Node e)
    {
        return matchesPrefix(e) && matchesSuffix(e);
    }

    private boolean matchesPrefix(Node e)
    {
        if ( prefixes.isEmpty() )
            return true;

        KmList<String> words = e.words;

        int n = prefixes.size();
        if ( words.size() < n )
            return false;

        return prefixes.equals(words.subList(0, n));
    }

    private boolean matchesSuffix(Node e)
    {
        if ( suffixes.isEmpty() )
            return true;

        KmList<String> words;
        words = e.words.getShallowCopy();
        words.reverse();

        int n = suffixes.size();
        if ( words.size() < n )
            return false;

        return suffixes.equals(words.subList(0, n));
    }

    private KmList<String> getPrefixCandidates()
    {
        KmSet<String> set = new KmSetImpl<>();

        int i = prefixes.size();
        KmList<Node> matches = getMatches();
        for ( Node e : matches )
            set.addNonNull(e.words.getAtSafe(i));

        KmList<String> v;
        v = set.toList();
        v.sort();
        return v;
    }

    private KmList<String> getSuffixCandidates()
    {
        KmSet<String> set = new KmSetImpl<>();

        int i = suffixes.size();
        KmList<Node> matches = getMatches();
        for ( Node e : matches )
            set.addNonNull(e.words.getAtSafe(e.words.size() - i - 1));

        KmList<String> v;
        v = set.toList();
        v.sort();
        return v;
    }

    //##################################################
    //# node class
    //##################################################

    private static class Node
    {
        String         name;
        KmList<String> words;

        Node(String s)
        {
            name = s;
            words = Kmu.getWords(Kmu.formatCamelCaseAsWords(s).toLowerCase().trim());
        }

        @Override
        public String toString()
        {
            return Kmu.format("%s(%s,%s)", name);
        }
    }

}
