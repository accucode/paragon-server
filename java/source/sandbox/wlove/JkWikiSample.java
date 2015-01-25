package sandbox.wlove;

import com.kodemore.utility.Kmu;
import com.kodemore.wiki.KmWikiSample;

import com.app.file.MyFilePaths;
import com.app.utility.MyInstaller;

public class JkWikiSample
{
    public static void main(String[] args)
    {
        MyInstaller.installCore();
        String html = KmWikiSample.getSample();
        String dir = MyFilePaths.getWebStaticPath();
        String path = Kmu.joinFilePath(dir, "wiki.html");
        Kmu.writeFile(path, html);
    }
}
