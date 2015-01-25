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

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

import com.kodemore.collection.KmMap;
import com.kodemore.utility.Kmu;

public abstract class KmTelnetSession
    implements KmTelnetConstantsIF
{
    //##################################################
    //# variables
    //##################################################

    private Socket                _socket;

    private Thread                _clientThread;
    private StringBuilder         _keyBuffer;
    private KmMap<Integer,String> _keys;

    private int                   _x;
    private int                   _y;
    private int                   _windowHeight;
    private int                   _windowWidth;

    private KmMap<Object,Object>  _attributes;

    //##################################################
    //# constructor
    //##################################################

    public KmTelnetSession()
    {
        _keyBuffer = new StringBuilder();
        _attributes = new KmMap<>();
    }

    //##################################################
    //# accessing
    //##################################################

    public Socket getSocket()
    {
        return _socket;
    }

    public void setSocket(Socket e)
    {
        _socket = e;
    }

    //##################################################
    //# accessing (window size)
    //##################################################

    public int getWindowHeight()
    {
        return _windowHeight;
    }

    public void setWindowHeight(int e)
    {
        _windowHeight = e;
    }

    public boolean hasWindowHeight()
    {
        return _windowHeight > 0;
    }

    public int getWindowWidth()
    {
        return _windowWidth;
    }

    public void setWindowWidth(int e)
    {
        _windowWidth = e;
    }

    public boolean hasWindowWidth()
    {
        return _windowWidth > 0;
    }

    //##################################################
    //# accessing
    //##################################################

    public int getX()
    {
        return _x;
    }

    public int getY()
    {
        return _y;
    }

    //##################################################
    //# socket
    //##################################################

    public void start()
    {
        try
        {
            handleStart();
            _clientThread = newClientThread();
            _clientThread.start();
        }
        catch ( Exception ex )
        {
            ex.printStackTrace();
        }
    }

    public Thread newClientThread()
    {
        return new Thread()
        {
            @Override
            public void run()
            {
                processInput();
            }
        };
    }

    public void processInput()
    {
        try
        {
            while ( true )
            {
                int i = read();
                if ( i == COMMAND_IAC )
                    processCommand();
                else
                    processCharacter(i);
            }
        }
        catch ( KmTelnetCloseException ex )
        {
            handleStop();
            return;
        }
    }

    public void processCommand()
    {
        int cmd = read();
        if ( cmd == COMMAND_IAC )
        {
            processCharacter(cmd);
            return;
        }
        if ( cmd == COMMAND_SUB_BEGIN )
        {
            processSubnegotiation();
            return;
        }
        if ( KmTelnetUtility.isOption(cmd) )
        {
            int option = read();
            handleOption(cmd, option);
            return;
        }
        handleCommand(cmd);
    }

    public void processCharacter(int i)
    {
        char c = (char)i;
        _keyBuffer.append(c);
        String s = _keyBuffer.toString();
        if ( isVirtualKey(s) )
        {
            int vk = getVirtualKey(s);
            handleVirtualKey(vk, false);
            clearKeyBuffer();
            return;
        }
        if ( isVirtualAltKey(s) )
        {
            int vk = getVirtualAltKey(s);
            handleVirtualKey(vk, true);
            clearKeyBuffer();
            return;
        }

        if ( isPartialVirtualKey(s) )
            return;
        if ( isPartialVirtualAltKey(s) )
            return;

        if ( s.length() == 1 )
        {
            handleKey(c, false);
            clearKeyBuffer();
            return;
        }
        if ( s.length() == 2 )
            if ( s.startsWith(ESC) )
            {
                handleKey(c, true);
                clearKeyBuffer();
                return;
            }
        handleInvalidVirtualKey(s);
        clearKeyBuffer();
    }

    public void processSubnegotiation()
    {
        int option = read();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ( true )
        {
            int i = read();
            if ( i != COMMAND_IAC )
            {
                bos.write(i);
                continue;
            }

            int next = read();
            if ( next == COMMAND_IAC )
            {
                bos.write(i);
                continue;
            }
            if ( next == COMMAND_SUB_END )
            {
                handleSubnegotiation(option, bos.toByteArray());
                break;
            }
            bos.write(i);
            bos.write(next);
        }
    }

    //##################################################
    //# virtual keys
    //##################################################

    public int getVirtualAltKey(String s)
    {
        s = s.substring(1);
        return getVirtualKey(s);
    }

    public int getVirtualKey(String s)
    {
        for ( Integer key : getKeys().getKeys() )
        {
            String value = getKeys().get(key);
            if ( value.equals(s) )
                return key.intValue();
        }
        return VK_UNDEFINED;
    }

    public boolean isPartialVirtualKey(String s)
    {
        for ( Integer key : getKeys().getKeys() )
        {
            String value = getKeys().get(key);
            if ( value.startsWith(s) )
                return true;
        }
        return false;
    }

    public boolean isPartialVirtualAltKey(String s)
    {
        if ( !s.startsWith(ESC) )
            return false;
        s = s.substring(1);
        return isPartialVirtualKey(s);
    }

    public boolean isVirtualKey(String s)
    {
        return getVirtualKey(s) != VK_UNDEFINED;
    }

    public boolean isVirtualAltKey(String s)
    {
        if ( !s.startsWith(ESC) )
            return false;
        s = s.substring(1);
        return isVirtualKey(s);
    }

    public void clearKeyBuffer()
    {
        _keyBuffer.setLength(0);
    }

    //##################################################
    //# threads
    //##################################################

    public Thread newConsoleInputThread()
    {
        return new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    InputStreamReader isr = new InputStreamReader(System.in);
                    BufferedReader br = new BufferedReader(isr);
                    br.readLine();
                }
                catch ( Exception ex )
                {
                    ex.printStackTrace();
                }
            }
        };
    }

    //##################################################
    //# print
    //##################################################

    public void print(char c)
    {
        print("" + c);
    }

    public void print(String s)
    {
        _x += s.length();
        send(s);
    }

    public void print(int x, int y, String s)
    {
        moveTo(x, y);
        print(s);
    }

    //##################################################
    //# display attributes
    //##################################################

    public void normal()
    {
        setTextAttribute(ATTRIBUTE_NORMAL);
    }

    public void bright()
    {
        setTextAttribute(ATTRIBUTE_BRIGHT);
    }

    public void dim()
    {
        setTextAttribute(ATTRIBUTE_DIM);
    }

    public void underscore()
    {
        setTextAttribute(ATTRIBUTE_UNDERSCORE);
    }

    public void blink()
    {
        setTextAttribute(ATTRIBUTE_BLINK);
    }

    public void reverse()
    {
        setTextAttribute(ATTRIBUTE_REVERSE);
    }

    public void setTextAttribute(int i)
    {
        send(ESC + "[" + i + "m");
    }

    //##################################################
    //# erase
    //##################################################

    public void clearEndOfLine()
    {
        send(ESC + "[K");
    }

    public void clearStartOfLine()
    {
        send(ESC + "[1K");
    }

    public void clearLine()
    {
        send(ESC + "[2K");
    }

    public void deleteLine()
    {
        send(ESC + "[M");
    }

    public void clear()
    {
        send(ESC + "[2J");
    }

    //##################################################
    //# position
    //##################################################

    public void home()
    {
        moveTo(1, 1);
    }

    public void moveTo(int x, int y)
    {
        _x = x;
        _y = y;
        send(ESC + "[" + (y + 1) + ";" + (x + 1) + "H");
    }

    public void up()
    {
        up(1);
    }

    public void up(int i)
    {
        if ( _y - i < 0 )
            return;
        _y -= i;
        send(ESC + "[" + i + "A");
    }

    public void down()
    {
        down(1);
    }

    public void down(int i)
    {
        if ( hasWindowHeight() )
            if ( _y + i > getWindowHeight() - 1 )
                return;
        _y += i;
        send(ESC + "[" + i + "B");
    }

    public void left()
    {
        left(1);
    }

    public void left(int i)
    {
        if ( _x - i < 0 )
            return;
        _x -= i;
        send(ESC + "[" + i + "D");
    }

    public void right()
    {
        right(1);
    }

    public void right(int i)
    {
        if ( hasWindowWidth() )
            if ( _x + i > getWindowWidth() - 1 )
                return;
        _x += i;
        send(ESC + "[" + i + "C");
    }

    //##################################################
    //# keys
    //##################################################

    public KmMap<Integer,String> getKeys()
    {
        if ( _keys == null )
            _keys = defineKeys();
        return _keys;
    }

    public KmMap<Integer,String> defineKeys()
    {
        KmMap<Integer,String> m = new KmMap<>();
        m.put(VK_UP, _key("<ESC>[A"));
        m.put(VK_DOWN, _key("<ESC>[B"));
        m.put(VK_RIGHT, _key("<ESC>[C"));
        m.put(VK_LEFT, _key("<ESC>[D"));

        m.put(VK_TAB, _key("<9>"));
        m.put(VK_SHIFT_TAB, _key("<ESC>[Z"));
        m.put(VK_BACKSPACE, _key("<127>"));
        m.put(VK_SHIFT_BACKSPACE, _key("<8>"));
        m.put(VK_ENTER, _key("<13><10>"));

        m.put(VK_INSERT, _key("<ESC>[2~"));
        m.put(VK_DELETE, _key("<ESC>[3~"));
        m.put(VK_HOME, _key("<ESC>[1~"));
        m.put(VK_END, _key("<ESC>[4~"));
        m.put(VK_PAGE_UP, _key("<ESC>[5~"));
        m.put(VK_PAGE_DOWN, _key("<ESC>[6~"));

        m.put(VK_F1, _key("<ESC>[11~"));
        m.put(VK_F2, _key("<ESC>[12~"));
        m.put(VK_F3, _key("<ESC>[13~"));
        m.put(VK_F4, _key("<ESC>[14~"));
        m.put(VK_F5, _key("<ESC>[15~"));
        m.put(VK_F6, _key("<ESC>[17~"));
        m.put(VK_F7, _key("<ESC>[18~"));
        m.put(VK_F8, _key("<ESC>[19~"));
        m.put(VK_F9, _key("<ESC>[20~"));
        m.put(VK_F10, _key("<ESC>[21~"));

        m.put(VK_SHIFT_F1, _key("<ESC>[23~"));
        m.put(VK_SHIFT_F2, _key("<ESC>[24~"));
        m.put(VK_SHIFT_F3, _key("<ESC>[25~"));
        m.put(VK_SHIFT_F4, _key("<ESC>[26~"));
        m.put(VK_SHIFT_F5, _key("<ESC>[28~"));
        m.put(VK_SHIFT_F6, _key("<ESC>[29~"));
        m.put(VK_SHIFT_F7, _key("<ESC>[31~"));
        m.put(VK_SHIFT_F8, _key("<ESC>[32~"));
        m.put(VK_SHIFT_F9, _key("<ESC>[33~"));
        m.put(VK_SHIFT_F10, _key("<ESC>[34~"));
        return m;
    }

    public String _key(String s)
    {
        s = Kmu.replaceAll(s, "<ESC>", ESC);
        s = Kmu.replaceAll(s, "<CR>", CR);
        s = Kmu.replaceAll(s, "<LF>", LF);
        s = Kmu.replaceAll(s, "<CRLF>", CRLF);
        int n = 256;
        for ( int i = 0; i < n; i++ )
        {
            String x = "<" + i + ">";
            s = Kmu.replaceAll(s, x, "" + (char)i);
        }
        return s;
    }

    //##################################################
    //# io
    //##################################################

    public int read()
    {
        try
        {
            return _socket.getInputStream().read();
        }
        catch ( SocketException ex )
        {
            throw new KmTelnetCloseException();
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void send(char c)
    {
        send("" + c);
    }

    public void send(String s)
    {
        send(s.getBytes());
    }

    public void send(int[] arr)
    {
        int n = arr.length;
        byte[] bytes = new byte[n];
        for ( int i = 0; i < n; i++ )
            bytes[i] = (byte)arr[i];
        send(bytes);
    }

    public void send(byte[] arr)
    {
        try
        {
            if ( arr.length == 0 )
                return;
            _socket.getOutputStream().write(arr);
        }
        catch ( SocketException ex )
        {
            throw new KmTelnetCloseException();
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void sendNegativeOption(int command, int option)
    {
        if ( command == COMMAND_WILL )
        {
            int[] arr =
            {
                COMMAND_IAC,
                COMMAND_DONT,
                option
            };
            send(arr);
        }
        if ( command == COMMAND_DO )
        {
            int[] arr =
            {
                COMMAND_IAC,
                COMMAND_WONT,
                option
            };
            send(arr);
        }
    }

    public void sendPositiveOption(int command, int option)
    {
        if ( command == COMMAND_WILL )
        {
            int[] arr =
            {
                COMMAND_IAC,
                COMMAND_DO,
                option
            };
            send(arr);
        }
        if ( command == COMMAND_DO )
        {
            int[] arr =
            {
                COMMAND_IAC,
                COMMAND_WILL,
                option
            };
            send(arr);
        }
    }

    //##################################################
    //# attributes
    //##################################################

    public KmMap<?,?> getAttributes()
    {
        return _attributes;
    }

    public void setAttributes(KmMap<Object,Object> e)
    {
        if ( e == null )
            e = new KmMap<>();
        _attributes = e;
    }

    public Object getAttribute(Object key)
    {
        return _attributes.get(key);
    }

    public void setAttribute(Object key, Object value)
    {
        _attributes.put(key, value);
    }

    //##################################################
    //# handle
    //##################################################

    public abstract void handleStart();

    public abstract void handleStop();

    public abstract void handleCommand(int command);

    public abstract void handleOption(int command, int option);

    public abstract void handleVirtualKey(int i, boolean alt);

    public abstract void handleKey(char c, boolean alt);

    public abstract void handleInvalidVirtualKey(String s);

    public abstract void handleSubnegotiation(int option, byte[] data);

}
