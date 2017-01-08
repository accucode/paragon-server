/*
  Copyright (c) 2005-2016 www.kodemore.com

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

package com.kodemore.telnet.sample;

import com.kodemore.telnet.KmTelnetField;
import com.kodemore.telnet.KmTelnetForm;

public class KmTelnetSampleEditAccountForm
    extends KmTelnetForm
{
    //##################################################
    //# variables
    //##################################################

    private KmTelnetField _nameField;
    private KmTelnetField _accountField;

    //##################################################
    //# constructor
    //##################################################

    public KmTelnetSampleEditAccountForm()
    {
        addLabel(1, 1, "Sample Account");

        _nameField = addLabeledField(1, 3, "Name: ", 10);
        _nameField.allowLetters();
        _nameField.allowSpace();

        _accountField = addLabeledField(1, 4, "Account: ", 10);
        _accountField.allowDigits();

        addLabel(1, 6, "8) Cancel");
        addLabel(1, 7, "9) Save");
    }

    @Override
    public void handleVirtualKey(int key, boolean alt)
    {
        super.handleVirtualKey(key, alt);
        if ( key == VK_F8 )
        {
            show(new KmTelnetSampleMenuForm());
            return;
        }
        if ( key == VK_F9 )
        {
            save();
            show(new KmTelnetSampleMenuForm());
            return;
        }
    }

    public void save()
    {
        KmTelnetSampleAccountVo e = (KmTelnetSampleAccountVo)getSession().getAttribute("account");
        if ( e == null )
        {
            e = new KmTelnetSampleAccountVo();
            getSession().setAttribute("account", e);
        }
        e.setName(_nameField.getValue());
        e.setAccount(_accountField.getValue());
    }

    @Override
    public void updateView()
    {
        KmTelnetSampleAccountVo e = (KmTelnetSampleAccountVo)getSession().getAttribute("account");
        if ( e == null )
            e = new KmTelnetSampleAccountVo();
        _nameField.setValue(e.getName());
        _accountField.setValue(e.getAccount());
    }

}
