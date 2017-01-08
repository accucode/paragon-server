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

public class KmTelnetSampleEditAddressForm
    extends KmTelnetForm
{
    //##################################################
    //# variables
    //##################################################

    private KmTelnetField _streetField;
    private KmTelnetField _cityField;
    private KmTelnetField _stateField;
    private KmTelnetField _zipField;

    //##################################################
    //# constructor
    //##################################################

    public KmTelnetSampleEditAddressForm()
    {
        addLabel(1, 1, "Sample Address");

        _streetField = addLabeledField(1, 3, "Street: ", 10);
        _streetField.allowLetters();
        _streetField.allowSpace();

        _cityField = addLabeledField(1, 4, "City: ", 10);
        _cityField.allowLetters();
        _cityField.allowSpace();

        _stateField = addLabeledField(1, 5, "State: ", 2);
        _stateField.allowLetters();
        _stateField.forceUpperCase();

        _zipField = addLabeledField(1, 6, "City: ", 5);
        _zipField.allowDigits();

        addLabel(1, 8, "8) Cancel");
        addLabel(1, 9, "9) Save");
    }

    @Override
    public void handleVirtualKey(int key, boolean alt)
    {
        super.handleVirtualKey(key, alt);

        if ( key == VK_F8 )
        {
            handleCancel();
            return;
        }

        if ( key == VK_F9 )
        {
            handleSave();
            return;
        }
    }

    public void handleCancel()
    {
        show(new KmTelnetSampleMenuForm());
    }

    public void handleSave()
    {
        save();
        show(new KmTelnetSampleMenuForm());
    }

    public void save()
    {
        KmTelnetSampleAddressVo e = (KmTelnetSampleAddressVo)getSession().getAttribute("address");
        if ( e == null )
        {
            e = new KmTelnetSampleAddressVo();
            getSession().setAttribute("address", e);
        }
        e.setStreet(_streetField.getValue());
        e.setCity(_cityField.getValue());
        e.setState(_stateField.getValue());
        e.setZip(_zipField.getValue());
    }

    @Override
    public void updateView()
    {
        KmTelnetSampleAddressVo e = (KmTelnetSampleAddressVo)getSession().getAttribute("address");
        if ( e == null )
            e = new KmTelnetSampleAddressVo();
        _streetField.setValue(e.getStreet());
        _cityField.setValue(e.getCity());
        _stateField.setValue(e.getState());
        _zipField.setValue(e.getZip());
    }
}
