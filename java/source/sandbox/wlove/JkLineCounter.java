package sandbox.wlove;

import com.kodemore.file.KmFile;
import com.kodemore.tools.KmLineCounter;

public class JkLineCounter
{
    public static void main(String args[])
    {
        new JkLineCounter().run();
    }

    private void run()
    {
        countJava("temp/java/source");
        //        countJava("homeshop/app/java");
        //        countJava("lifeCycleService/java/source");
        //        countJava("rapidInventory/java/source");
        //        countJava("vmail/java/source");
        //        countJava("aoBar-droid");

        System.out.println("ok.");
    }

    private void countJava(String path)
    {
        KmFile file = KmFile.workingFolder().getParent().getChild(path);
        KmLineCounter.countLines(file, ".java");
        System.out.println();
    }
}
