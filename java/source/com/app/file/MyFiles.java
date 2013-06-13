package com.app.file;

public class MyFiles
{
    public static MySharedFiles getSharedFiles()
    {
        return MySharedFiles.getInstance();
    }

    public static MySharedFiles getResourceFiles()
    {
        return MySharedFiles.getInstance();
    }
}
