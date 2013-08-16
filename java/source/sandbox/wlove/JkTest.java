package sandbox.wlove;

import com.kodemore.collection.KmList;
import com.kodemore.file.KmFile;
import com.kodemore.string.KmStringTokenizer;

public class JkTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        new JkTest().run();
    }

    //##################################################
    //# constants
    //##################################################

    private static final String IN  = "/temp/in.txt";
    private static final String OUT = "/temp/out.txt";

    //##################################################
    //# run
    //##################################################

    private void run()
    {
        KmList<String> v;
        v = new KmList<String>();
        v.addAll(read(IN));
        v.addAll(read(OUT));
        v.removeDuplicates();
        v.sort();

        System.out.println("Words: " + v.size());

        new KmFile(OUT).write(v.formatLines());
    }

    private KmList<String> read(String path)
    {
        KmFile f = new KmFile(path);
        String in = f.readString().toLowerCase();

        KmStringTokenizer t;
        t = new KmStringTokenizer();
        t.setIgnoreEmptyValues();
        t.setTrimValues();
        t.addWhitespaceDelimiters();
        t.addDelimiter(',');
        t.addDelimiter(';');
        t.addDelimiter(':');
        t.addDelimiter('.');
        t.addDelimiter('?');
        t.addDelimiter('!');
        t.addDelimiter('"');
        t.addDelimiter("--");

        KmList<String> words;
        words = t.split(in);
        words.removeDuplicates();
        return words;
    }
}
