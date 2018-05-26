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

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.script.ScReplaceContentsScript;
import com.kodemore.servlet.variable.ScLocalControl;

/**
 * Used to wrap dynamic ajax content.
 */
public class ScCardFrame
    extends ScElement
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The cards to be displayed in this frame.  Only
     * one card is displayed at a time.  We need to explicitly
     * store this list so that we can implement getChildren().
     */
    private KmList<ScControl> _cards;

    /**
     * If set, then render this card when rendering this frame.
     */
    private ScLocalControl _defaultCard;

    /**
     * The type of transition to be used.
     * Defaults to FLIP.
     */
    private ScTransitionType _transitionType;

    /**
     * This controls how fast the transition animation runs.
     * This is ignored if the transition type is set to none/null.
     * Defaults to 250ms.
     */
    private int _transitionSpeedMs;

    /**
     * If true, attempt to set the default focus
     * after a new card is rendered.
     * Disabled by default.
     */
    private boolean _autoFocus;

    //##################################################
    //# constructor
    //##################################################

    public ScCardFrame()
    {
        _cards = new KmList<>();
        _defaultCard = new ScLocalControl();
        _transitionType = getBridge().getCardFrameTransitionType();
        _transitionSpeedMs = getBridge().getCardFrameTransitionSpeedMs();
        _autoFocus = false;
    }

    //##################################################
    //# cards
    //##################################################

    /**
     * The list of cards associated with this frame;
     * clients should NOT manipulate this list directly.
     */
    public KmList<ScControl> getCards()
    {
        return _cards;
    }

    public ScCard addCard()
    {
        return addCard(new ScCard());
    }

    public <T extends ScControl> T addCard(T e)
    {
        e.setParent(this);
        _cards.add(e);
        return e;
    }

    public <T extends ScControl> T addDefaultCard(T e)
    {
        addCard(e);
        setDefaultCard(e);
        return e;
    }

    public ScCard addDefaultCard()
    {
        ScCard e = addCard();
        setDefaultCard(e);
        return e;
    }

    public ScControl getDefaultCard()
    {
        return _defaultCard.getValue();
    }

    public void setDefaultCard(ScControl e)
    {
        _defaultCard.setValue(e);
    }

    public boolean hasDefaultCard()
    {
        return _defaultCard.hasValue();
    }

    public boolean isDefaultCard(ScControl e)
    {
        return hasDefaultCard() && getDefaultCard() == e;
    }

    public void clearDefaultCard()
    {
        _defaultCard.clearValue();
    }

    //##################################################
    //# show effect
    //##################################################

    public ScTransitionType getTransitionType()
    {
        return _transitionType;
    }

    public void setTransitionType(ScTransitionType e)
    {
        _transitionType = e;
    }

    public void setTransitionFade()
    {
        setTransitionType(ScTransitionType.Fade);
    }

    public void setTransitionFlip()
    {
        setTransitionType(ScTransitionType.Flip);
    }

    public void setTransitionSlideLeft()
    {
        setTransitionType(ScTransitionType.SlideLeft);
    }

    public void setTransitionSlideRight()
    {
        setTransitionType(ScTransitionType.SlideRight);
    }

    public void setTransitionNone()
    {
        setTransitionType(null);
    }

    //##################################################
    //# transition speed
    //##################################################

    public int getTransitionSpeedMs()
    {
        return _transitionSpeedMs;
    }

    public void setTransitionSpeedMs(int i)
    {
        _transitionSpeedMs = i;
    }

    //##################################################
    //# auto focus
    //##################################################

    public boolean getAutoFocus()
    {
        return _autoFocus;
    }

    public void setAutoFocus(boolean e)
    {
        _autoFocus = e;
    }

    public void setAutoFocus()
    {
        setAutoFocus(true);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.openDiv();
        renderAttributesOn(out);
        out.close();

        if ( hasDefaultCard() )
            getDefaultCard().renderOn(out);

        out.endDiv();
    }

    //##################################################
    //# components
    //##################################################

    @Override
    public final KmList<ScControl> getChildren()
    {
        return getCards();
    }

    //##################################################
    //# print
    //##################################################

    public void ajaxClear()
    {
        _htmlIdAjax().clearContents();
    }

    public void ajaxPrint()
    {
        ajaxPrint(getDefaultCard());
    }

    public void ajaxPrintFast()
    {
        ajaxPrintFast(getDefaultCard());
    }

    public void ajaxPrint(ScControl card)
    {
        ScHtmlIdAjax ajax = _htmlIdAjax();

        ScReplaceContentsScript r;
        r = ajax.setContents();
        r.setInnerSelector(getJquerySelector());
        r.setContents(card);
        r.setTransition(getTransitionType());
        r.setSpeed(getTransitionSpeedMs());

        if ( _autoFocus )
            ajax.whenDone().focus(card);
    }

    public void ajaxPrintFast(ScControl card)
    {
        ScHtmlIdAjax ajax;
        ajax = _htmlIdAjax();
        ajax.setContents(card);
        ajax.focus(card);
    }

    //##################################################
    //# navigation
    //##################################################

    public void ajaxPrintDefault()
    {
        ajaxPrint(getDefaultCard());
    }

    public void ajaxClose(ScControl e)
    {
        if ( isDefaultCard(e) )
            ajaxPrint(null);
        else
            ajaxPrintDefault();
    }

    public void ajaxClose()
    {
        ajaxPrint(null);
    }
}
