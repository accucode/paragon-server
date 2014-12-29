package sandbox.wlove;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmSet;
import com.kodemore.collection.KmSetImpl;
import com.kodemore.file.KmFile;
import com.kodemore.file.KmFileTraverser;
import com.kodemore.utility.Kmu;

public class JkNameTree
{
    public static void main(String[] args)
    {
        new JkNameTree().run();
    }

    private void run()
    {
        final KmList<String> names = new KmList<>();

        new KmFileTraverser()
        {
            @Override
            protected void processFile(KmFile f)
            {
                String suffix = "Page.java";
                String s = f.getName();

                if ( s.endsWith(suffix) )
                {
                    s = Kmu.removeSuffix(s, suffix);
                    names.add(s);
                }
            }
        }.processAll("/projects/service/java/source");

        Node root = new Node();
        for ( String name : names )
        {
            KmList<String> tokens = Kmu.getCamelCaseWords(name);
            root.addPath(tokens);
        }
        root.sortAll();
        root.getChild("my").printTree(2);
    }

    private class Node
        implements Comparable<Node>
    {
        String       token;
        KmList<Node> children = new KmList<>();

        @Override
        public boolean equals(Object e)
        {
            return e instanceof Node && compareTo((Node)e) == 0;
        }

        @Override
        public int hashCode()
        {
            return token.hashCode();
        }

        @Override
        public int compareTo(Node e)
        {
            return token.compareTo(e.token);
        }

        public void sortAll()
        {
            children.sort();
            for ( Node e : children )
                e.sortAll();
        }

        public void addPath(KmList<String> tokens)
        {
            if ( tokens.isEmpty() )
                return;

            Node parent = this;
            for ( String s : tokens )
                parent = parent.lazyGetChild(s);
        }

        private Node lazyGetChild(String s)
        {
            Node e = getChild(s);
            if ( e == null )
            {
                e = new Node();
                e.token = s;
                children.add(e);
            }
            return e;
        }

        private Node getChild(String s)
        {
            for ( Node e : children )
                if ( e.token.equals(s) )
                    return e;

            return null;
        }

        public void printTree(int maxDepth)
        {
            int indent = 0;
            printTree(maxDepth, indent);
        }

        private void printTree(int maxDepth, int indent)
        {
            if ( maxDepth == 0 )
                return;

            System.out.println(Kmu.repeat("    ", indent) + this);
            for ( Node e : children )
                e.printTree(maxDepth - 1, indent + 1);
        }

        @Override
        public String toString()
        {
            return Kmu.format("%s(%s,%s)", token, getChildCount(), getChildFirstLetterCount());
        }

        private int getChildCount()
        {
            return children.size();
        }

        private int getChildFirstLetterCount()
        {
            KmSet<Character> v = new KmSetImpl<>();
            for ( Node e : children )
                v.add(e.token.charAt(0));
            return v.size();
        }
    }
}
