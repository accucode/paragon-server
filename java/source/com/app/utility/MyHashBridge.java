/*
  Copyright (c) 2005-2013 www.kodemore.com

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

package com.app.utility;

import com.app.ui.layout.MyLeftMenu;

import com.kodemore.servlet.ScActivity;
import com.kodemore.servlet.utility.ScHashBridge;
import com.kodemore.utility.KmConstantsIF;
import com.kodemore.utility.Kmu;

public class MyHashBridge
    extends ScHashBridge
    implements KmConstantsIF
{
    //##################################################
    //# install
    //##################################################

    public static void install()
    {
        install(new MyHashBridge());
    }

    public static MyHashBridge getInstance()
    {
        return (MyHashBridge)ScHashBridge.getInstance();
    }

    //##################################################
    //# constructor
    //##################################################

    private MyHashBridge()
    {
        // private
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String formatFullHash(ScActivity e)
    {
        ScActivity menu = MyLeftMenu.getInstance().getSelection();

        if ( menu == null )
            return e.getNavigationHash();

        return Kmu.format("%s-%s", menu.getNavigationHash(), e.getNavigationHash());
    }

    public String parseMenuHash(String fullHash)
    {
        if ( fullHash == null )
            return null;

        int i = fullHash.indexOf("-");

        return i < 0
            ? null
            : fullHash.substring(0, i);
    }

    public String parsePageHash(String fullHash)
    {
        if ( fullHash == null )
            return null;

        int i = fullHash.indexOf("-");

        return i < 0
            ? fullHash
            : fullHash.substring(i + 1);
    }
}
