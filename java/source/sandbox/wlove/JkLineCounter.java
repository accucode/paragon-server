package sandbox.wlove;

import com.kodemore.tools.KmLineCounter;
import com.kodemore.utility.Kmu;

public class JkLineCounter
{
    public static void main(String args[])
    {
        new JkLineCounter().run();
    }

    private void run()
    {
        countJava("fieldService-server/java/source");
        countJava("lifeCycleService/java/source");
        countJava("rapidInventory/java/source");
        countJava("vmail/java/source");
        countJava("aoBar-droid");

        System.out.println("ok.");
    }

    private void countJava(String path)
    {
        String working = Kmu.getWorkingFolder();
        path = Kmu.joinFilePath(working, "..", path);
        KmLineCounter.countLines(path, ".java");
        System.out.println();
    }
}
