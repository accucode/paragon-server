package com.kodemore.ftp;

import com.enterprisedt.net.ftp.FTPFile;

import com.kodemore.time.KmDate;

public class KmFtpFile
{
    //##################################################
    //# static creation
    //##################################################

    public static KmFtpFile createFtpFile(String s, KmDate d)
    {
        return new KmFtpFile(s, d);
    }

    public static KmFtpFile createFtpFile(FTPFile f)
    {
        String s = f.getName();
        KmDate d = KmDate.createJavaDate(f.lastModified());
        return new KmFtpFile(s, d);
    }

    //##################################################
    //# variables
    //##################################################

    private String _fileName;
    private KmDate _lastModified;

    //##################################################
    //# constructor
    //##################################################

    public KmFtpFile(String s, KmDate d)
    {
        _fileName = s;
        _lastModified = d;
    }

    //##################################################
    //# accessing
    //##################################################

    public String getFileName()
    {
        return _fileName;
    }

    public void setFileName(String e)
    {
        _fileName = e;
    }

    public KmDate getLastModified()
    {
        return _lastModified;
    }

    public void setLastModified(KmDate e)
    {
        _lastModified = e;
    }
}
