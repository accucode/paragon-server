package sandbox.wlove;

import com.kodemore.file.KmFile;
import com.kodemore.tools.KmSearchReplaceTool;

public class JkSearchReplace
{
    public static void main(String[] args)
    {
        String folder = "/projects/paragon/web/test";
        String ext = "html";
        KmFile search = new KmFile("/temp/search.txt");
        KmFile replace = new KmFile("/temp/replace.txt");

        KmSearchReplaceTool e;
        e = new KmSearchReplaceTool();
        e.setRootFolder(folder);
        e.setFileExtension(ext);
        e.setSearchText(search);
        e.setReplaceText(replace);
        e.findAll();

        // e.replaceAll();
    }
}
