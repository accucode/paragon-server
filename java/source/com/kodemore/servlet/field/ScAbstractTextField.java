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

package com.kodemore.servlet.field;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.KmStyleBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.servlet.ScConstantsIF;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScWidthFullIF;
import com.kodemore.servlet.script.ScActionScript;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.script.ScTypeWatchScript;
import com.kodemore.servlet.utility.ScJquery;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalCss;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.Kmu;

public abstract class ScAbstractTextField<T>
    extends ScField<T>
    implements ScWidthFullIF
{
    //##################################################
    //# constants
    //##################################################

    public static final String INPUT_SUFFIX = "-i";

    //##################################################
    //# static :: layout enum
    //##################################################

    /**
     * The various layout options.
     */
    private static enum Layout
    {
        /**
         * Treat the control as an inline element, with a fixed width.
         * This is similar to the way a standalone input element works.
         * This is the default.
         */
        inline,

        /**
         * Treat the control as a block element (not inline).
         * The control will generally span an entire row, much like a div.
         */
        block,

        /**
         * For use inside a flexbox (row), the child will fill the available space.
         */
        flexFiller
    }

    //##################################################
    //# variables
    //##################################################

    private ScLocalString  _text;
    private ScLocalString  _placeholder;
    private ScLocalString  _hoverText;
    private ScLocalBoolean _readOnly;

    /**
     * The ID of the outer html element.
     */
    private ScLocalString _htmlId;

    /**
     * If false (the default) client-side autocompletion is disabled.
     * @see ScConstantsIF#DEFAULT_AUTO_COMPLETE
     */
    private ScLocalBoolean _autoComplete;

    /**
     * The type of layout to apply. Because this is a composite with multiple
     * pieces (wrapper, input, image) it is not safe for clients to directly
     * set the layout via css. Instead, clients use one of the layout*() methods
     * that ensure the different elements are coordinated correctly.
     */
    private Layout _layout;

    /**
     * Used in conjuction with the layoutFixed.
     */
    private int _layoutWidth;

    /**
     * Clients are not allowed directly access to the css since that will likely
     * cause problems.  However, clients are allowed to directly adjust the margin
     * for minor layout adjustments.
     */
    private ScLocalCss _cssMargin;

    /**
     * If set, run this script when the field's input changes.
     * This uses the field's "onchange" attribute.
     */
    private ScAction _onChangeAction;

    /**
     * If set, run this script when the field's input changes.
     * This uses the field's "oninput" attribute.
     */
    private ScAction _onInputAction;

    /**
     * Enable/disable spellchecking. Enabled by default.
     */
    private ScLocalBoolean _spellCheck;

    /**
     * If set, install the typeWatch script to notify the server when
     * the user stops typing.
     */
    private ScAction _typeWatchAction;

    private int _typeWatchDelayMs;

    //##################################################
    //# constructor
    //##################################################

    public ScAbstractTextField()
    {
        _htmlId = new ScLocalString(getKeyToken());
        _text = new ScLocalString();
        _placeholder = new ScLocalString();
        _hoverText = new ScLocalString();
        _readOnly = new ScLocalBoolean(false);
        _autoComplete = new ScLocalBoolean(ScConstantsIF.DEFAULT_AUTO_COMPLETE);
        _cssMargin = new ScLocalCss();
        _spellCheck = new ScLocalBoolean(true);
        layoutInline();
    }

    //##################################################
    //# html id
    //##################################################

    @Override
    public String getHtmlId()
    {
        return _htmlId.getValue();
    }

    public void setHtmlId(String e)
    {
        _htmlId.setValue(e);
    }

    //##################################################
    //# css
    //##################################################

    public KmCssDefaultBuilder outerCss()
    {
        return _cssMargin.toBuilder();
    }

    //##################################################
    //# text
    //##################################################

    public String getText()
    {
        return _text.getValue();
    }

    public void setText(String e)
    {
        _text.setValue(e);
    }

    public boolean hasText()
    {
        return _text.hasValue();
    }

    public boolean hasText(String e)
    {
        return _text.is(e);
    }

    public boolean isEmpty()
    {
        return !hasText();
    }

    public void clearText()
    {
        _text.setValue("");
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public final T getValue()
    {
        return textToValue(getText());
    }

    @Override
    public final void setValue(T value)
    {
        setText(valueToText(value));
    }

    //==================================================
    //= value :: save
    //==================================================

    @Override
    public void saveValue()
    {
        _text.saveValue();
    }

    @Override
    public void resetValue()
    {
        _text.resetValue();
    }

    public void onChange(ScAction e)
    {
        setOnChangeAction(e);
    }

    public void setOnChangeAction(ScAction e)
    {
        _onChangeAction = e;
    }

    public ScAction getOnChangeAction()
    {
        return _onChangeAction;
    }

    public boolean hasOnChangeAction()
    {
        return _onChangeAction != null;
    }

    //##################################################
    //# on input
    //##################################################

    public void onInput(ScAction e)
    {
        setOnInputAction(e);
    }

    public void setOnInputAction(ScAction e)
    {
        _onInputAction = e;
    }

    public ScAction getOnInputAction()
    {
        return _onInputAction;
    }

    public boolean hasOnInputAction()
    {
        return _onInputAction != null;
    }

    //##################################################
    //# on type watch
    //##################################################

    public void onTypeWatch(ScAction e)
    {
        onTypeWatch(e, 350);
    }

    public void onTypeWatch(ScAction action, int delayMs)
    {
        _typeWatchAction = action;
        _typeWatchDelayMs = delayMs;
    }

    public ScAction getTypeWatchAction()
    {
        return _typeWatchAction;
    }

    public boolean hasTypeWatchAction()
    {
        return _typeWatchAction != null;
    }

    public int getTypeWatchDelayMs()
    {
        return _typeWatchDelayMs;
    }

    //##################################################
    //# spell check
    //##################################################

    public boolean getSpellCheck()
    {
        return _spellCheck.getValue();
    }

    public void setSpellCheck(boolean e)
    {
        _spellCheck.setValue(e);
    }

    public void disableSpellCheck()
    {
        setSpellCheck(false);
    }

    //##################################################
    //# validate :: sample
    //##################################################

    @Override
    protected final void validateParse()
    {
        T value = getValue();
        if ( hasText() && value == null )
            addError(getInvalidMessage());
    }

    /**
     * Return some text that provides one of more examples of
     * valid text. E.g.: for a date field this may return: "1/31/2016".
     */
    public abstract T getSampleValue();

    private final String getInvalidMessage()
    {
        String msg = "Cannot parse value.";

        T value = getSampleValue();
        if ( value != null )
            msg += "  Sample: " + valueToText(value);

        return msg;
    }

    //##################################################
    //# read only
    //##################################################

    public void setReadOnly(boolean b)
    {
        _readOnly.setValue(b);
    }

    public boolean isReadOnly()
    {
        return _readOnly.getValue();
    }

    public void setReadOnly()
    {
        setReadOnly(true);
    }

    //==================================================
    //= editable
    //==================================================

    @Override
    public boolean isEditable()
    {
        return !isReadOnly();
    }

    //##################################################
    //# placeholder
    //##################################################

    public void setPlaceholder(String e)
    {
        _placeholder.setValue(e);
    }

    public String getPlaceholder()
    {
        return _placeholder.getValue();
    }

    public void clearPlaceHolder()
    {
        setPlaceholder(null);
    }

    public boolean hasPlaceholder()
    {
        return _placeholder.hasValue();
    }

    //##################################################
    //# hover text
    //##################################################

    public void setHoverText(String e)
    {
        _hoverText.setValue(e);
    }

    public String getHoverText()
    {
        return _hoverText.getValue();
    }

    public boolean hasHoverText()
    {
        return _hoverText.hasValue();
    }

    //##################################################
    //# autocomplete
    //##################################################

    public boolean getAutoComplete()
    {
        return _autoComplete.getValue();
    }

    public void setAutoComplete(boolean e)
    {
        _autoComplete.setValue(e);
    }

    //##################################################
    //# conversion
    //##################################################

    protected abstract T textToValue(String text);

    protected abstract String valueToText(T value);

    //##################################################
    //# layout
    //##################################################

    private void layoutInline()
    {
        layoutInline(getDefaultWidth());
    }

    public void layoutInline(int px)
    {
        _layout = Layout.inline;
        _layoutWidth = px;
    }

    public void layoutBlock()
    {
        _layout = Layout.block;
    }

    public void layoutFlexFiller()
    {
        _layout = Layout.flexFiller;
    }

    @Override
    public void setWidthFull()
    {
        layoutBlock();
    }

    protected int getDefaultWidth()
    {
        return 200;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        KmCssDefaultBuilder css = formatCss();
        KmStyleBuilder style = new KmStyleBuilder();
        applyLayoutTo(css, style);

        out.openDiv();
        out.printAttribute("id", getHtmlId());
        out.printAttribute(css);
        out.printAttribute(style);
        out.close();

        renderHelpOn(out);
        renderInputOn(out);

        out.endDiv();
    }

    private void renderHelpOn(KmHtmlBuilder out)
    {
        out.printHelpImage(getHelp());
    }

    private void renderInputOn(KmHtmlBuilder out)
    {
        out.open("input");

        out.printAttribute("id", getInputHtmlId());
        out.printAttribute("name", getInputName());
        out.printAttribute("type", getInputType());
        out.printAttribute("placeholder", getPlaceholder());
        out.printAttribute("title", getHoverText());
        out.printAttribute("value", getText());

        if ( isReadOnly() )
            out.printAttribute("readonly", "readonly");

        if ( !getAutoComplete() )
            if ( isMasked() )
                out.printAttribute("autocomplete", "new-password");
            else
                out.printAttribute("autocomplete", "off");

        if ( getChangeTracking() )
            printOldValueAttributeOn(out, getText());

        if ( !getSpellCheck() )
            out.printAttribute("spellcheck", false);

        if ( hasOnChangeAction() )
        {
            ScActionScript s;
            s = new ScActionScript();
            s.setAction(getOnChangeAction());
            s.setForm(findFormWrapper());
            s.setBlockTarget(findBlockWrapper());
            out.printAttribute("onchange", s.formatScript());
        }

        if ( hasOnInputAction() )
        {
            ScActionScript s;
            s = new ScActionScript();
            s.setAction(getOnInputAction());
            s.setForm(findFormWrapper());
            s.setBlockTarget(findBlockWrapper());
            out.printAttribute("oninput", s.formatScript());
        }

        out.close();

        if ( hasTypeWatchAction() )
        {
            ScActionScript action;
            action = new ScActionScript();
            action.setAction(getTypeWatchAction());
            action.setForm(findFormWrapper());
            action.setBlockTarget(findBlockWrapper());

            ScTypeWatchScript watch;
            watch = new ScTypeWatchScript();
            watch.setSelector(getInputSelector());
            watch.setCallback(action.formatScript());
            watch.setDelayMs(getTypeWatchDelayMs());

            out.getPostDom().run(watch);
        }
    }

    //==================================================
    //= render :: support
    //==================================================

    public String getInputHtmlId()
    {
        return getHtmlId() + INPUT_SUFFIX;
    }

    public String getInputSelector()
    {
        return ScJquery.formatIdSelector(getInputHtmlId());
    }

    public String getInputReference()
    {
        return ScJquery.formatIdReference(getInputHtmlId());
    }

    private String getInputName()
    {
        return getInputHtmlId();
    }

    private String getInputType()
    {
        return isMasked()
            ? "password"
            : "text";
    }

    private ScHtmlIdAjax getInputAjax()
    {
        return newHtmlIdAjaxOn(getInputHtmlId());
    }

    //==================================================
    //= render :: styling
    //==================================================

    protected boolean isMasked()
    {
        return false;
    }

    private KmCssDefaultBuilder formatCss()
    {
        KmCssDefaultBuilder css;
        css = new KmCssDefaultBuilder();
        css.textField();
        css.addAll(outerCss().getSelectors());
        css.flexRow();

        if ( isEditable() )
            css.textField_editable();
        else
            css.textField_readonly();

        return css;
    }

    private void applyLayoutTo(KmCssDefaultBuilder css, KmStyleBuilder style)
    {
        if ( !isVisible() )
            style.hide();

        switch ( _layout )
        {
            case inline:
                css.inlineBlock();
                style.width(_layoutWidth);
                break;

            case block:
                css.block();
                break;

            case flexFiller:
                css.flexChildFiller();
                break;
        }
    }

    //##################################################
    //# parameters
    //##################################################

    @Override
    protected void readParameters_here(ScServletData data)
    {
        super.readParameters_here(data);

        String name = getInputName();
        String text = getData().getParameter(name);

        if ( Kmu.hasValue(text) )
            _text.setValue(text);
        else
            _text.clearValue();
    }

    //##################################################
    //# ajax
    //##################################################

    @Override
    public final void ajaxSetFieldValue(T e)
    {
        ajaxSetFieldValue(e, getChangeTracking());
    }

    @Override
    public final void ajaxSetFieldValue(T e, boolean updateOldValue)
    {
        String htmlValue = valueToText(e);

        ScHtmlIdAjax ajax;
        ajax = getInputAjax();
        ajax.setValue(htmlValue);

        if ( updateOldValue )
            ajax.setDataAttribute(ScConstantsIF.DATA_ATTRIBUTE_OLD_VALUE, htmlValue);
    }

    public final void ajaxSelect()
    {
        getInputAjax().run("$(%s).select();", json(getInputSelector()));
    }
}
