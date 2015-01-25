package sandbox.wlove;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.kodemore.collection.KmList;
import com.kodemore.file.KmFile;
import com.kodemore.file.KmFileTraverser;
import com.kodemore.utility.Kmu;

import com.app.file.MyDevelopmentFiles;
import com.app.utility.MyInstaller;

public class JkLineNormalizer
    extends KmFileTraverser
{
    //##################################################
    //# main
    //##################################################

    public static void main(String args[])
    {
        MyInstaller.installCore();
        String root = MyDevelopmentFiles.getProjectRoot();

        JkLineNormalizer e;
        e = new JkLineNormalizer();
        e.processAll(root);

        System.out.println("ok.");
    }

    //##################################################
    //# abstract
    //##################################################

    @Override
    protected void processFile(KmFile f)
    {
        if ( isCandidate(f) )
            normalize(f);
    }

    //##################################################
    //# private
    //##################################################

    private boolean isCandidate(KmFile f)
    {
        return Kmu.endsWithAny(
            f.getName(),
            ".bat",
            ".css",
            ".dtd",
            ".html",
            ".java",
            ".js",
            ".sh",
            ".txt",
            ".vm",
            ".wsdl",
            ".wsdd",
            ".xml");
    }

    private void normalize(KmFile f)
    {
        String original = f.readString();
        String normalized = normalize(original);

        if ( normalized.equals(original) )
            return;

        System.out.println(f);

        f.write(normalized);
    }

    private String normalize(String original)
    {
        PrintWriter out;
        out = new PrintWriter(new StringWriter());

        KmList<String> v = Kmu.parseLines(original);
        for ( String e : v )
            out.println(Kmu.trimTrailing(e));

        return out.toString();
    }
}
