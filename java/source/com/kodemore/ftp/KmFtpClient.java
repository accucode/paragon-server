package com.kodemore.ftp;

import java.io.ByteArrayOutputStream;

import com.enterprisedt.net.ftp.FTPClient;
import com.enterprisedt.net.ftp.FTPConnectMode;
import com.enterprisedt.net.ftp.FTPFile;
import com.enterprisedt.net.ftp.FTPMessageCollector;
import com.enterprisedt.net.ftp.FTPTransferType;

import com.kodemore.collection.KmList;
import com.kodemore.log.KmLog;
import com.kodemore.utility.Kmu;

public class KmFtpClient
{
    // ISSUE: Some servers (Microsoft IIS Server 5.0 comes to mind) do not
    // support file details.  In this case, the GetFiles, GetDirectores,
    // GetFileNames, GetDirectoryNames methods will return an empty list.

    //##################################################
    //# variables
    //##################################################

    private FTPClient _client;

    //##################################################
    //# connection management
    //##################################################

    public boolean connect(String host, String login, String password)
    {
        try
        {
            _client = new FTPClient();
            _client.setRemoteHost(host);
            _client.connect();
            _client.login(login, password);
            _client.setConnectMode(FTPConnectMode.PASV);
            _client.setType(FTPTransferType.BINARY);
            return true;
        }
        catch ( Exception ex )
        {
            KmLog.error(ex, "Unable to login to ftp host %s.", host);
            return false;
        }
    }

    public boolean quit()
    {
        try
        {
            _client.quit();
            return true;
        }
        catch ( Exception ex )
        {
            return false;
        }
    }

    //##################################################
    //# get
    //##################################################

    public boolean get(String remotePath, String localPath)
    {
        try
        {
            _client.get(localPath, remotePath);
            return true;
        }
        catch ( Exception ex )
        {
            KmLog.error(ex, "Unable to copy file %s to %s.", remotePath, localPath);
            return false;
        }
    }

    public String getTextFile(String remotePath)
    {
        try
        {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            _client.get(baos, remotePath);
            return baos.toString();
        }
        catch ( Exception ex )
        {
            KmLog.error(ex, "Unable to get text file %s.", remotePath);
            return null;
        }
    }

    public byte[] getBinaryFile(String remotePath)
    {
        try
        {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            _client.get(baos, remotePath);
            return baos.toByteArray();
        }
        catch ( Exception ex )
        {
            KmLog.error(ex, "Unable to get binary file %s.", remotePath);
            return null;
        }
    }

    public KmList<KmFtpFile> getFiles(String remotePath)
    {
        try
        {
            FTPFile[] items = _client.dirDetails(remotePath);
            KmList<KmFtpFile> files = new KmList<KmFtpFile>();
            for ( int i = 0; i < items.length; i++ )
                if ( !items[i].isDir() )
                    files.add(KmFtpFile.createFtpFile(items[i]));
            return files;
        }
        catch ( Exception ex )
        {
            KmLog.error(ex, "Unable to get files in directory %s.", remotePath);
            return null;
        }
    }

    public KmList<KmFtpFile> getDirectories(String remotePath)
    {
        try
        {
            FTPFile[] items = _client.dirDetails(remotePath);
            KmList<KmFtpFile> directories = new KmList<KmFtpFile>();
            for ( FTPFile element : items )
                if ( element.isDir() )
                    directories.add(KmFtpFile.createFtpFile(element));
            return directories;
        }
        catch ( Exception ex )
        {
            KmLog.error(ex, "Unable to get directories in directory %s.", remotePath);
            return null;
        }
    }

    //##################################################
    //# put
    //##################################################

    public boolean put(String remotePath, String localPath)
    {
        try
        {
            _client.put(localPath, remotePath);
            return true;
        }
        catch ( Exception ex )
        {
            KmLog.error(ex, "Unable to copy file %s to %s.", localPath, remotePath);
            return false;
        }
    }

    public boolean putTextFile(String remotePath, String fileData)
    {
        return putBinaryFile(remotePath, fileData.getBytes());
    }

    public boolean putBinaryFile(String remotePath, byte[] fileData)
    {
        try
        {
            // the "auto" create directories causes problems if you do not have permissions.
            // String dirname = Kmu.dirname(remotePath);
            // createAllDirsInPath(dirname);
            _client.put(fileData, remotePath);
            return true;
        }
        catch ( Exception ex )
        {
            KmLog.error(ex, "Unable to put file %s.", remotePath);
            return false;
        }
    }

    //##################################################
    //# listings
    //##################################################

    public KmList<String> getFileAndDirectoryNames(String remotePath)
    {
        try
        {
            KmList<String> list = new KmList<String>();
            for ( String s : _client.dir(remotePath) )
                list.add(s);
            return list;
        }
        catch ( Exception ex )
        {
            KmLog.error(ex, "Unable to list files and directories in directory %s.", remotePath);
            return null;
        }
    }

    public KmList<String> getFileNames(String remotePath)
    {
        try
        {
            FTPFile[] items = _client.dirDetails(remotePath);
            KmList<String> files = new KmList<String>();
            for ( int i = 0; i < items.length; i++ )
                if ( !items[i].isDir() )
                    files.add(items[i].getName());
            return files;
        }
        catch ( Exception ex )
        {
            KmLog.error(ex, "Unable to list files in directory %s.", remotePath);
            return null;
        }
    }

    public KmList<String> getDirectoryNames(String remotePath)
    {
        try
        {
            FTPFile[] items = _client.dirDetails(remotePath);
            KmList<String> directories = new KmList<String>();
            for ( FTPFile element : items )
                if ( element.isDir() )
                    directories.add(element.getName());
            return directories;
        }
        catch ( Exception ex )
        {
            KmLog.error(ex, "Unable to list directories in directory %s.", remotePath);
            return null;
        }
    }

    //##################################################
    //# control
    //##################################################

    public boolean createAllDirsInPath(String remotePath)
    {
        KmList<String> dirs = Kmu.getDirsRecursively(remotePath);
        for ( String dir : dirs )
            if ( !createDir(dir) )
                return false;
        return true;
    }

    public boolean removeAllDirsInPath(String remotePath, boolean delFiles)
    {
        KmList<KmFtpFile> files = getFiles(remotePath);
        if ( !files.isEmpty() && !delFiles )
            return false;
        for ( KmFtpFile file : files )
            deleteFile(remotePath + "/" + file.getFileName());
        for ( KmFtpFile dir : getDirectories(remotePath) )
        {
            if ( dir.getFileName().equals(".") || dir.getFileName().equals("..") )
                continue;
            removeAllDirsInPath(remotePath + "/" + dir.getFileName(), delFiles);
        }
        removeDir(remotePath);
        return true;
    }

    public boolean createDir(String remotePath)
    {
        try
        {
            _client.mkdir(remotePath);
            return true;
        }
        catch ( Exception ex )
        {
            KmLog.error(ex, "Unable to create directory %s.", remotePath);
            return false;
        }
    }

    public boolean removeDir(String remotePath)
    {
        try
        {
            _client.rmdir(remotePath);
            return true;
        }
        catch ( Exception ex )
        {
            KmLog.error(ex, "Unable to remove directory %s.", remotePath);
            return false;
        }
    }

    public boolean deleteFile(String remotePath)
    {
        try
        {
            _client.delete(remotePath);
            return true;
        }
        catch ( Exception ex )
        {
            KmLog.error(ex, "Unable to remove file %s.", remotePath);
            return false;
        }
    }

    public boolean renameFile(String from, String to)
    {
        try
        {
            _client.rename(from, to);
            return true;
        }
        catch ( Exception ex )
        {
            KmLog.error(ex, "Unable to rename from(%s) to(%s).", from, to);
            return false;
        }
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        KmLog.info("FTP Test");

        KmFtpClient ftp = new KmFtpClient();
        if ( !ftp.connect("localhost", "anonymous", "a@b.com") )
        {
            KmLog.info("unable to connect to server!");
            return;
        }
        ftp._client.setMessageListener(new FTPMessageCollector());
        ftp.putTextFile("test.txt", "This is a test");
        KmLog.info(ftp.getTextFile("test.txt"));

        ftp.putBinaryFile("test2.txt", ftp.getBinaryFile("test.txt"));
        KmLog.info(ftp.getBinaryFile("test.txt").length + "");

        ftp.get("test.txt", "test.txt");
        ftp.put("test3.txt", "test.txt");
        ftp.createDir("temp");

        ftp.putTextFile("/z/a/b/abc.txt", "This is a test");

        for ( String s : ftp.getFileAndDirectoryNames(".") )
            KmLog.info(s);

        for ( KmFtpFile f : ftp.getFiles(".") )
            KmLog.info(f.getFileName() + " . " + f.getLastModified().toString());

        for ( String s : ftp.getFileNames(".") )
            KmLog.info(s);

        for ( KmFtpFile f : ftp.getDirectories(".") )
            KmLog.info(f.getFileName() + " . " + f.getLastModified().toString());

        for ( String s : ftp.getDirectoryNames(".") )
            KmLog.info(s);

        ftp.removeDir("temp");
        ftp.deleteFile("test.txt");
        ftp.deleteFile("test2.txt");
        ftp.deleteFile("test3.txt");
        ftp.removeAllDirsInPath("z", true);

        String messages = ((FTPMessageCollector)ftp._client.getMessageListener()).getLog();
        KmLog.info(messages);
    }

}
