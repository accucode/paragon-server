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

package com.kodemore.servlet.control;

import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.KmKeyFinderIF;

import com.app.model.core.MyUidDomainIF;

/**
 * I am a tabbed notebook, that understands a model context.
 *
 * The model can be set via setModel().
 * The model is also set via applyFromModel().
 * When the model is set, it automatically updates a 'local' variable.
 * When a tab is rendered, the model is re-applied to the tab.
 */
public class ScDomainTabBook<T extends MyUidDomainIF>
    extends ScTabBook
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalString           _domainUid;
    private KmKeyFinderIF<T,String> _finder;

    //##################################################
    //# constructor
    //##################################################

    public ScDomainTabBook()
    {
        _domainUid = new ScLocalString();
        _domainUid.setAutoSave();
        _finder = null;
    }

    //##################################################
    //# finder
    //##################################################

    public KmKeyFinderIF<T,String> getFinder()
    {
        return _finder;
    }

    public void setFinder(KmKeyFinderIF<T,String> e)
    {
        _finder = e;
    }

    //##################################################
    //# model
    //##################################################

    @SuppressWarnings("unchecked")
    @Override
    public T getModel()
    {
        return (T)super.getModel();
    }

    public void setModel(T e)
    {
        applyFromModel(e);
    }

    /**
     * Restore the model from the saved uid.
     */
    private void restoreModel()
    {
        String uid = _domainUid.getValue();
        T e = _finder.find(uid);
        setModel(e);
    }

    @Override
    protected boolean applyFromModel_here(Object model, boolean skipFields)
    {
        if ( model instanceof MyUidDomainIF )
        {
            super.applyFromModel_here(model, skipFields);

            String uid = ((MyUidDomainIF)model).getUid();
            _domainUid.setValue(uid);
        }

        // stop the downcast, apply model to selected tab during pre-render.
        return false;
    }

    //##################################################
    //# handle
    //##################################################

    @Override
    protected void handleTabClick()
    {
        restoreModel();

        super.handleTabClick();
    }

}
