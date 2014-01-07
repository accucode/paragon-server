/*
  Copyright (c) 2005-2014 www.kodemore.com

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

public class KmTelnetEchoSession
    extends KmTelnetSession
{
    //##################################################
    //# static factory
    //##################################################

    public static void main(String[] args)
    {
        KmTelnetServer.start(getFactory());
    }

    public static KmTelnetSessionFactoryIF getFactory()
    {
        return new KmTelnetSessionFactoryIF()
        {
            @Override
            public KmTelnetSession create()
            {
                return new KmTelnetEchoSession();
            }
        };
    }

    //##################################################
    //# handle
    //##################################################

    @Override
    public void handleStart()
    {
        System.out.println("start session");
    }

    @Override
    public void handleStop()
    {
        System.out.println("end session");
    }

    @Override
    public void handleKey(char key, boolean alt)
    {
        System.out.println("key: " + KmTelnetUtility.formatCharacter(key, alt));
        if ( KmTelnetUtility.isPrintable(key) )
            send(key);
    }

    @Override
    public void handleVirtualKey(int key, boolean alt)
    {
        System.out.println("virtual key: " + KmTelnetUtility.formatVirtualKey(key, alt));
        switch ( key )
        {
            case VK_UP:
                up();
                return;
            case VK_DOWN:
                down();
                return;
            case VK_LEFT:
                left();
                return;
            case VK_RIGHT:
                right();
                return;
            case VK_HOME:
                home();
                clear();
                return;
        }
    }

    @Override
    public void handleInvalidVirtualKey(String s)
    {
        System.out.println("invalid virtual key: " + KmTelnetUtility.formatCharacters(s));
    }

    @Override
    public void handleCommand(int command)
    {
        System.out.println("command: " + KmTelnetUtility.formatCommand(command));
    }

    @Override
    public void handleOption(int command, int option)
    {
        System.out.println("option: "
            + KmTelnetUtility.formatCommand(command)
            + " : "
            + KmTelnetUtility.formatOption(option));
    }

    @Override
    public void handleSubnegotiation(int option, byte[] data)
    {
        System.out.println("subnegotiation: "
            + KmTelnetUtility.formatOption(option)
            + KmTelnetUtility.formatCharacters(data));
    }

}
