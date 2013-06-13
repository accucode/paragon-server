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
        // countJava("trending/java/source");
        // countJava("rebill/java/source");

        countJava("service/java/source");
        countJava("service/java/source/com/app");
        countJava("service/java/source/com/kodemore");
        System.out.println();

        countJava("inventory/java/source");
        countJava("inventory/java/source/com/app");
        countJava("inventory/java/source/com/jwApps");
        System.out.println();

        countJava("vmail/java/source");
        countJava("vmail/java/source/com/vmail");
        countJava("vmail/java/source/com/jwApps");
        System.out.println();

        countJava("aoApps/aoBar/src");
        countJava("aoApps/aoBar/src/com/accucode");
        countJava("aoApps/aoBar/src/com/kodemore");
        System.out.println();

        System.out.println();
        System.out.println("ok.");
    }

    private void countJava(String path)
    {
        String working = Kmu.getWorkingFolder();
        path = Kmu.joinFilePath(working, "..", path);
        KmLineCounter.countLines(path, ".java");
    }
}
