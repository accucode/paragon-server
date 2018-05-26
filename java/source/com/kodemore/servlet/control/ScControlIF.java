/*
  Copyright (c) 2005-2018 www.kodemore.com

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

import java.util.function.Consumer;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.field.ScHtmlIdIF;

public interface ScControlIF
{
    //##################################################
    //# hierarchy
    //##################################################

    ScControl getParent();

    void setParent(ScControl e);

    KmList<ScControl> getChildren();

    ScHtmlIdIF getFocusTarget();

    //##################################################
    //# render
    //##################################################

    KmHtmlBuilder render();

    void renderOn(KmHtmlBuilder out);

    //##################################################
    //# visit
    //##################################################

    void visitAll(Consumer<ScControl> e);

    void visitAllFields(Consumer<ScFieldIF<?>> e);

    void visitAllForms(Consumer<ScForm> e);

    //##################################################
    //# fields
    //##################################################

    void saveFieldValues();

    void resetFieldValues();

    //##################################################
    //# label
    //##################################################

    /**
     * Get my label. Controls typically do NOT display their label directly.
     * Instead a control's label may be used by its container as part of
     * various layouts.
     */
    String getLabel();

    void setLabel(String e);

    //##################################################
    //# apply
    //##################################################

    /**
     * Apply the state FROM the model, to myself.
     */
    void applyFromModel(Object model);

    /**
     * Apply my state TO the model
     */
    void applyToModel(Object model);

    //##################################################
    //# validate
    //##################################################

    /**
     * Validate myself and any children, adding a pertinent
     * error message to the fields that have a problem.
     * This does NOT throw an exception.
     */
    void validate();

    /**
     * Validate myself an any children via validate().
     * Then check hasErrors() and throw an exception if an
     * error is found.
     */
    void validateAndCheck();

    /**
     * Collect any errors in myself or my children.
     * This does NOT validate. It only collects errors that have
     * already been identified.
     */
    void collectErrorsOn(KmList<String> v);

    /**
     * Determine if I or any of my children have a reported error.
     * This does NOT validate the controls, but merely checks to
     * see if any errors have already been identified.
     */
    boolean hasErrors();

    //##################################################
    //# parameters
    //##################################################

    void readParameters();

    //##################################################
    //# casting
    //##################################################

    public ScControl asControl();

}
