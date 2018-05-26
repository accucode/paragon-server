package com.kodemore.utility;

import java.io.IOException;
import java.io.InputStream;

public class KmProcessRunner
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        KmProcessRunner e;
        e = new KmProcessRunner();
        e.run("c:\\Program Files\\IZArc\\IZARCE", "-d", "-o", "-pc:\\temp", "c:\\temp\\topics.zip");
        e.printResults();
    }

    //##################################################
    //# variables
    //##################################################

    private String[]    _command;
    private Process     _process;
    private InputStream _standardOutputStream;
    private InputStream _standardErrorStream;

    private StringBuilder _outputBuffer;
    private StringBuilder _errorBuffer;
    private int           _exitValue;

    //##################################################
    //# public
    //##################################################

    public void setCommand(String... command)
    {
        _command = command;
    }

    public int run(String... command)
    {
        setCommand(command);
        run();
        return getExitValue();
    }

    public void run()
    {
        try
        {
            startProcess();
            monitorProcess();
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public int getExitValue()
    {
        return _exitValue;
    }

    public String getStandardOutput()
    {
        return _outputBuffer.toString();
    }

    public String getStandardError()
    {
        return _errorBuffer.toString();
    }

    public void printResults()
    {
        System.out.println("Command: " + Kmu.join(_command));
        System.out.println("Exit: " + _exitValue);
        System.out.println();
        System.out.println("Output...");
        System.out.println(_outputBuffer);
        System.out.println();
        System.out.println("Error...");
        System.out.println(_errorBuffer);

    }

    //##################################################
    //# private
    //##################################################

    private void startProcess() throws IOException
    {
        ProcessBuilder pb;
        pb = new ProcessBuilder();
        pb.command(_command);

        _process = pb.start();
        _standardOutputStream = _process.getInputStream();
        _standardErrorStream = _process.getErrorStream();
        _outputBuffer = new StringBuilder();
        _errorBuffer = new StringBuilder();
    }

    private void monitorProcess() throws IOException
    {
        while ( true )
        {
            readOutputStream();
            readErrorStream();
            if ( isDone() )
                break;
        }
    }

    private void readOutputStream() throws IOException
    {
        while ( _standardOutputStream.available() > 0 )
        {
            int i = _standardOutputStream.read();
            if ( i >= 0 )
                _outputBuffer.append((char)i);
        }
    }

    private void readErrorStream() throws IOException
    {
        while ( _standardErrorStream.available() > 0 )
        {
            int i = _standardErrorStream.read();
            if ( i >= 0 )
                _errorBuffer.append((char)i);
        }
    }

    private boolean isDone()
    {
        try
        {
            _exitValue = _process.exitValue();
            return true;
        }
        catch ( IllegalThreadStateException ex )
        {
            return false;
        }
    }

}
