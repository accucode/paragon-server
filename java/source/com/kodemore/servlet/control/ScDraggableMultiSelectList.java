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

package com.kodemore.servlet.control;

import com.kodemore.adaptor.KmAdaptorIF;
import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.meta.KmMetaAttribute;
import com.kodemore.servlet.encoder.ScDecoder;
import com.kodemore.servlet.field.ScHiddenField;
import com.kodemore.servlet.script.ScSortableScript;
import com.kodemore.servlet.variable.ScLocalList;

/**
 * I am a composite widget that allows users to easily select multiple values
 * and to simultaneously prioritize the selected values via drag-and-drop.
 *
 * NOTE: My outer container MUST be styled with a non-static position and explicit
 * sizing.  By default, I use a relative layout with size of 300x200px.  Clients can
 * change this using layoutSize() or layoutFill().  Or may follow those examples for
 * layouts.
 */
public class ScDraggableMultiSelectList<T>
    extends ScDivWrapper
{
    //##################################################
    //# variables
    //##################################################

    /**
     * I am used to get the unique key for each value.
     */
    private KmAdaptorIF<T,String> _keyAdapter;

    /**
     * I am used to get the display text for each value.
     */
    private KmAdaptorIF<T,String> _titleAdapter;

    /**
     * The currently selected values.
     *
     * These must be set globally during initial setup,
     * or (more typically) during the current context.
     * These cannot be persisted into the page session.
     */
    private ScLocalList<T> _selectedValues;

    /**
     * The list of available values.  This should generally include the selected values
     * plus any additional values that are available for selection.
     *
     * These must be set globally during initial setup,
     * or (more typically) during the current context.
     * These cannot be persisted into the page session.
     */
    private ScLocalList<T> _availableValues;

    //==================================================
    //= variables :: components
    //==================================================

    private ScDiv                _selectedHeader;
    private ScDiv                _selectedList;
    private ScTransientContainer _selectedItemContainer;

    private ScDiv                _availableHeader;
    private ScDiv                _availableList;
    private ScTransientContainer _availableItemContainer;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        css().dmsContainer();

        layoutSize(300, 200);

        _selectedValues = new ScLocalList<>();
        _availableValues = new ScLocalList<>();

        ScDiv root = getInner();

        installSelectedHeaderOn(root);
        installSelectedListOn(root);
        installAvailableHeaderOn(root);
        installAvailableListOn(root);
    }

    private void installSelectedHeaderOn(ScDiv root)
    {
        _selectedHeader = root.addDiv();
        _selectedHeader.css().dmsSelectedHeader();
        _selectedHeader.addText("Selected");
    }

    private void installSelectedListOn(ScDiv root)
    {
        _selectedList = root.addDiv();
        _selectedList.css().dmsSelectedList();

        _selectedItemContainer = _selectedList.addTransientContainer();

        ScSortableScript sort;
        sort = _selectedList.getPostDomScript().sortable();
        sort.setHandleCss(KmCssDefaultConstantsIF.dmsItemHandle);
        sort.setUpdateFunctionName("Kmu.dmsRenumber");
    }

    private void installAvailableHeaderOn(ScDiv root)
    {
        _availableHeader = root.addDiv();
        _availableHeader.css().dmsAvailableHeader();
        _availableHeader.addText("Available");
    }

    private void installAvailableListOn(ScDiv root)
    {
        _availableList = root.addDiv();
        _availableList.css().dmsAvailableList();

        _availableItemContainer = _availableList.addTransientContainer();
    }

    public KmList<String> getSelectedKeys()
    {
        KmList<String> keys = new KmList<>();

        KmList<String> values = getData().getParameters(getItemFieldName());
        for ( String value : values )
        {
            String key = (String)ScDecoder.staticDecode(value);
            keys.add(key);
        }

        return keys;
    }

    //##################################################
    //# layout
    //##################################################

    public void layoutSize(int w, int h)
    {
        style().relative().width(w).height(h);
    }

    public void layoutHeight(int h)
    {
        style().relative().widthFull().height(h);
    }

    public void layoutFill()
    {
        style().fill();
    }

    //##################################################
    //# selected values
    //##################################################

    public KmList<T> getSelectedValues()
    {
        return _selectedValues.getValue();
    }

    public void setSelectedValues(KmList<T> v)
    {
        _selectedValues.setValue(v);
    }

    //##################################################
    //# available values
    //##################################################

    public KmList<T> getAvailableValues()
    {
        return _availableValues.getValue();
    }

    public void setAvailableValues(KmList<T> v)
    {
        _availableValues.setValue(v);
    }

    //##################################################
    //# key adapter
    //##################################################

    public KmAdaptorIF<T,String> getKeyAdapter()
    {
        return _keyAdapter;
    }

    public void setKeyAdapter(KmAdaptorIF<T,String> e)
    {
        _keyAdapter = e;
    }

    public void setKeyAdapter(KmMetaAttribute<T,String> e)
    {
        setKeyAdapter(e.getAdaptor());
    }

    //##################################################
    //# text adapter
    //##################################################

    public KmAdaptorIF<T,String> getTitleAdapter()
    {
        return _titleAdapter;
    }

    public void setTitleAdapter(KmAdaptorIF<T,String> e)
    {
        _titleAdapter = e;
    }

    public void setTitleAdapter(KmMetaAttribute<T,String> e)
    {
        setTitleAdapter(e.getAdaptor());
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        addTransientSelectedItems();
        addTransientAvailableItems();

        super.renderControlOn(out);
    }

    private void addTransientSelectedItems()
    {
        addItemsTo(_selectedValues, _selectedItemContainer, true);
    }

    private void addTransientAvailableItems()
    {
        addItemsTo(_availableValues, _availableItemContainer, false);
    }

    private void addItemsTo(ScLocalList<T> items, ScTransientContainer container, boolean selected)
    {
        int i = 0;
        for ( T e : items )
        {
            addTransientItemOn(container, e, selected, i);
            i++;
        }
    }

    private void addTransientItemOn(ScContainer list, T value, boolean selected, int index)
    {
        String key = getKeyAdapter().getValue(value);
        String title = getTitleAdapter().getValue(value);

        ScDiv item;
        item = list.addDiv();
        item.css().dmsItem();

        ScDiv drag;
        drag = item.addDiv();
        drag.css().dmsItemHandle();

        ScDiv priority;
        priority = item.addDiv();
        priority.css().dmsItemPriority();
        priority.addText("[%s]", index + 1);

        ScDiv text;
        text = item.addDiv();
        text.css().dmsItemText();
        text.addText(title);

        ScDiv toggle;
        toggle = item.addDiv();
        toggle.css().dmsItemToggle();
        toggle.setOnClick("Kmu.dmsToggle(this);");

        ScHiddenField<String> field;
        field = item.addHiddenField();
        field.setHtmlName(getItemFieldName());
        field.setValue(key);
        field.css().dmsItemField();
        field.setEnabled(selected);
    }

    //##################################################
    //# support
    //##################################################

    private String getItemFieldName()
    {
        return getKey() + "-field";
    }

}
