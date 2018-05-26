/*
  Copyright (c) 2005-2018 www.kodemore.com

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in
  all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  THE SOFTWARE.
 */

package com.kodemore.telnet;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class KmTelnetServer
    implements KmTelnetConstantsIF
{
    //##################################################
    //# static
    //##################################################

    public static KmTelnetServer start(KmTelnetSessionFactoryIF factory)
    {
        KmTelnetServer e;
        e = new KmTelnetServer();
        e.setFactory(factory);
        e.start();
        return e;
    }

    //##################################################
    //# variables
    //##################################################

    private int                      _port;
    private KmTelnetSessionFactoryIF _factory;

    //##################################################
    //# main
    //##################################################

    public KmTelnetServer()
    {
        _port = 23;
    }

    //##################################################
    //# accessing
    //##################################################

    public int getPort()
    {
        return _port;
    }

    public void setPort(int e)
    {
        _port = e;
    }

    public KmTelnetSessionFactoryIF getFactory()
    {
        return _factory;
    }

    public void setFactory(KmTelnetSessionFactoryIF e)
    {
        _factory = e;
    }

    //##################################################
    //# socket
    //##################################################

    public void start()
    {
        try (ServerSocket ss = new ServerSocket(getPort()))
        {
            while ( true )
                accept(ss);
        }
        catch ( Exception ex )
        {
            ex.printStackTrace();
        }
    }

    private void accept(ServerSocket ss) throws IOException
    {
        try (Socket socket = ss.accept())
        {
            KmTelnetSession session;
            session = _factory.create();
            session.setSocket(socket);
            session.start();
        }
    }

}
