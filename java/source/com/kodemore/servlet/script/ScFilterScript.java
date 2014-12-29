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

package com.kodemore.servlet.script;

import com.kodemore.collection.KmList;
import com.kodemore.json.KmJsonMap;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.string.KmStringBuilder;

/**
 * Search a series a items for matching text.  
 * All items that match are shown; all items that do not match are hidden.
 * 
 * This is typically used for situations where you have a single text field
 * to specify some substring, and a client side list of items that you want to 
 * match against.
 * 
 * Once configured, the search is triggered and executed 100% client side,
 * and assumes that all of the items have already been loaded into the page.
 */
public class ScFilterScript
    extends ScAbstractScript
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The selector that identifies the text field to search on.
     * This should identify a single element on the page, and the element
     * must support the ".val()" method.
     */
    private String         _fieldSelector;

    /**
     * The select that identifies the items to be filtered.
     * These are the elements to be shown or hidden; NOT the text to be matched.
     */
    private String         _itemSelector;

    /**
     * One or more selectors to identify the elements WITHIN each item to be
     * checked for matching text.  The attribute selectors are applied one at a time
     * using the $.find() method, thus the attribute selectors are always within
     * the context of the itemSelector.
     */
    private KmList<String> _attributeSelectors;

    //##################################################
    //# constructor
    //##################################################

    public ScFilterScript()
    {
        _attributeSelectors = new KmList<>();
    }

    //##################################################
    //# field selector
    //##################################################

    public String getFieldSelector()
    {
        return _fieldSelector;
    }

    public void setFieldSelector(String e)
    {
        _fieldSelector = e;
    }

    public void setFieldSelector(ScHtmlIdIF field)
    {
        setFieldSelector(field.getJquerySelector());
    }

    //##################################################
    //# item selector
    //##################################################

    public String getItemSelector()
    {
        return _itemSelector;
    }

    public void setItemSelector(String e)
    {
        _itemSelector = e;
    }

    //##################################################
    //# attribute selectors
    //##################################################

    public KmList<String> getAttributeSelectors()
    {
        return _attributeSelectors;
    }

    public void addAttributeSelector(String e)
    {
        _attributeSelectors.add(e);
    }

    //##################################################
    //# format
    //##################################################

    @Override
    public void formatScriptOn(KmStringBuilder out)
    {
        KmJsonMap options;
        options = new KmJsonMap();
        options.setString("fieldSel", getFieldSelector());
        options.setString("itemSel", getItemSelector());
        options.setArray("attrSels").addStrings(getAttributeSelectors());

        out.printf("Kmu.filterItems(%s);", options);
    }
}
