/*
  Copyright (c) 2005-2011 www.kodemore.com

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

public class KmTelnetFormSession
    extends KmTelnetSession
{
    //##################################################
    //# variables
    //##################################################

    private KmTelnetForm _form;

    //##################################################
    //# accessing
    //##################################################

    public KmTelnetForm getForm()
    {
        return _form;
    }

    public void setForm(KmTelnetForm e)
    {
        _form = e;
        _form.setSession(this);
    }

    //##################################################
    //# handle
    //##################################################

    @Override
    public void handleStart()
    {
        printForm();
    }

    @Override
    public void handleStop()
    {
        // allow subclass extension
    }

    @Override
    public void handleCommand(int command)
    {
        // allow subclass extension
    }

    @Override
    public void handleOption(int command, int option)
    {
        // allow subclass extension
    }

    @Override
    public void handleKey(char c, boolean alt)
    {
        _form.handleKey(c, alt);
    }

    @Override
    public void handleVirtualKey(int key, boolean alt)
    {
        _form.handleVirtualKey(key, alt);
    }

    @Override
    public void handleInvalidVirtualKey(String s)
    {
        // allow subclass extension
    }

    @Override
    public void handleSubnegotiation(int option, byte[] data)
    {
        // allow subclass extension
    }

    //##################################################
    //# utility
    //##################################################

    public void printForm()
    {
        _form.print();
    }

}
