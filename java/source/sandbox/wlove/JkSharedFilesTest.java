package sandbox.wlove;

import com.kodemore.file.KmFile;

import com.app.file.MySharedFiles;
import com.app.utility.MyInstaller;

public class JkSharedFilesTest
{
    public static void main(String[] args)
    {
        MyInstaller.installCore();

        KmFile root = MySharedFiles.getInstance().getPersistentRootFolder();
        System.out.println("    root:   " + root);

        for ( KmFile e : root.getChildren() )
            System.out.println("    child:  " + e);

        for ( KmFile e : root.getFolders() )
            System.out.println("    folder: " + e);

        for ( KmFile e : root.getFiles() )
            System.out.println("    file:   " + e);
    }
}
