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

import com.kodemore.servlet.ScEncodedValueIF;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.utility.Kmu;

/**
 * Each field manages a single typed VALUE.
 *
 * Note that the 'single' value may be a list.  For example, a multi-selection
 * list box may support a list of selected items.  But the list is treated
 * as a single value with methods for get/setValue(aList).
 *
 * Also fields are always an ScHtmlIdIF so that they can be identified,
 * hidden and/or replaced as needed.
 *
 * Fields should act as 'leaf' elements in the ScControl hierarchy.
 * That is, they should generally NOT have children.
 *
 * Although fields should behave as simple atomic elements, they may be
 * internally composed of a multiple HTML elements.  For example, a simple
 * text field is likely implemented via an INPUT element.  However, it may
 * also render additional DOM elements in order to manage ui decorations
 * for things such as errors and help.
 */
public interface ScFieldIF<T>
    extends ScControlIF, ScHtmlIdIF, ScEncodedValueIF, ScRequiredIF
{
    //##################################################
    //# value
    //#################################################

    /**
     * Return the field's SINGLE value.
     *
     * Special cases such as a multi-selection list should still return
     * a SINGLE value, however such cases may return a SINGLE list.
     */
    T getValue();

    /**
     * Set the field's SINGLE value.
     */
    void setValue(T e);

    default boolean hasValue()
    {
        return getValue() != null;
    }

    default boolean hasValue(T e)
    {
        return Kmu.isEqual(getValue(), e);
    }

    //==================================================
    //= value :: save
    //==================================================

    /**
     * Save the field's value to the pageSession state.
     *
     * This does NOT directly update the client-side browser state.
     * Rather it modifies server-side state which will be passed to
     * the browser the next time the page session is updated via ajax.
     */
    void saveValue();

    /**
     * Resets the field's value to its default state.
     *
     * NOTE that resetting the field does NOT necessarily clear it
     * since the default value may be something other than null/blank.
     */
    void resetValue();

    //##################################################
    //# ajax
    //##################################################

    /**
     * Implemented by specific controls that know how to update their
     * client-side value in the browser via ajax.  Client code should usually
     * call the method ajaxUpdateValues which is available for ALL controls
     * and which propogates method through the hierarchy.
     *
     * @see ScControl#ajaxUpdateFieldValues
     */
    void ajaxUpdateFieldValue_here(boolean updateOldValue);

    void ajaxSetFieldValue(T e);

    void ajaxSetFieldValue(T e, boolean updateOldValue);

    default void ajaxClearFieldValue()
    {
        ajaxSetFieldValue(null);
    }

    default void ajaxClearFieldValue(boolean updateOldValue)
    {
        ajaxSetFieldValue(null, updateOldValue);
    }
}
