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

package com.kodemore.servlet.control;

import java.util.Iterator;

import com.kodemore.collection.KmCompositeIterator;
import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.ScConstantsIF;
import com.kodemore.servlet.script.ScEffect;
import com.kodemore.servlet.script.ScHideScript;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.script.ScShowScript;
import com.kodemore.servlet.utility.ScEasing;
import com.kodemore.utility.Kmu;

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
     * store this list so that we can implement getComponents().
     */
    private KmList<ScCard> _cards;

    /**
     * If set, then render this card when rendering this frame.
     */
    private ScCard         _defaultCard;

    private ScEffect       _showEffect;
    private ScEasing       _showEasing;
    private Integer        _showSpeed;

    private ScEffect       _hideEffect;
    private ScEasing       _hideEasing;
    private Integer        _hideSpeed;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _cards = new KmList<ScCard>();

        _showEffect = ScConstantsIF.DEFAULT_EFFECT;
        _showEasing = ScConstantsIF.DEFAULT_EASING;
        _showSpeed = ScConstantsIF.DEFAULT_SPEED_MS;

        _hideEffect = ScConstantsIF.DEFAULT_EFFECT;
        _hideEasing = ScConstantsIF.DEFAULT_EASING;
        _hideSpeed = ScConstantsIF.DEFAULT_SPEED_MS;
    }

    //##################################################
    //# cards
    //##################################################

    /**
     * The list of cards associated with this frame;
     * clients should NOT manipulate this list directly.
     */
    public KmList<ScCard> getCards()
    {
        return _cards;
    }

    public ScCard addCard()
    {
        ScCard e = new ScCard();
        addCard(e);
        return e;
    }

    public ScCard addCard(ScCard e)
    {
        e.setParent(this);
        _cards.add(e);
        return e;
    }

    public void addDefaultCard(ScCard e)
    {
        addCard(e);
        setDefaultCard(e);
    }

    public ScCard getDefaultCard()
    {
        return _defaultCard;
    }

    public void setDefaultCard(ScCard e)
    {
        _defaultCard = e;
    }

    public boolean hasDefaultCard()
    {
        return _defaultCard != null;
    }

    public boolean isDefaultCard(ScCard e)
    {
        return hasDefaultCard() && getDefaultCard() == e;
    }

    //##################################################
    //# show effect
    //##################################################

    public ScEffect getShowEffect()
    {
        return _showEffect;
    }

    public void setShowEffect(ScEffect e)
    {
        _showEffect = e;
    }

    public void setShowFade()
    {
        setShowEffect(ScEffect.fade);
    }

    public void setShowSlide()
    {
        setShowEffect(ScEffect.slide);
    }

    public void setShowFlip()
    {
        setShowEffect(ScEffect.flip);
    }

    public void clearShowEffect()
    {
        setShowEffect(null);
    }

    //##################################################
    //# show easing
    //##################################################

    public ScEasing getShowEasing()
    {
        return _showEasing;
    }

    public void setShowEasing(ScEasing e)
    {
        _showEasing = e;
    }

    //##################################################
    //# show speed
    //##################################################

    public Integer getShowSpeed()
    {
        return _showSpeed;
    }

    public void setShowSpeed(Integer e)
    {
        _showSpeed = e;
    }

    public boolean hasShowSpeed()
    {
        return _showSpeed != null;
    }

    //##################################################
    //# hide effect
    //##################################################

    public ScEffect getHideEffect()
    {
        return _hideEffect;
    }

    public void setHideEffect(ScEffect e)
    {
        _hideEffect = e;
    }

    public boolean hasHideEffect()
    {
        return getHideEffect() != null;
    }

    public void setHideFade()
    {
        setHideEffect(ScEffect.fade);
    }

    public void setHideSlide()
    {
        setHideEffect(ScEffect.slide);
    }

    public void setHideFlip()
    {
        setHideEffect(ScEffect.flip);
    }

    public void clearHideEffect()
    {
        setHideEffect(null);
    }

    //##################################################
    //# hide easing
    //##################################################

    public ScEasing getHideEasing()
    {
        return _hideEasing;
    }

    public void setHideEasing(ScEasing e)
    {
        _hideEasing = e;
    }

    //##################################################
    //# hide speed
    //##################################################

    public Integer getHideSpeed()
    {
        return _hideSpeed;
    }

    public void setHideSpeed(Integer e)
    {
        _hideSpeed = e;
    }

    public boolean hasHideSpeed()
    {
        return _hideSpeed != null;
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
    public Iterator<ScControl> getComponents()
    {
        KmCompositeIterator<ScControl> i;
        i = new KmCompositeIterator<ScControl>();

        i.addAll(super.getComponents());
        i.addAll(getCards());

        return i;
    }

    //##################################################
    //# print
    //##################################################

    public void ajaxClear()
    {
        ajax().clearContents();
    }

    public void ajaxPrint()
    {
        ajaxPrint(getDefaultCard());
    }

    private void ajaxPrint(ScCard card)
    {
        ScHtmlIdAjax ajax;
        ajax = ajax();

        ScHideScript hide;
        hide = ajax.hide();
        hide.setEffect(getHideEffect());
        hide.setEasing(getHideEasing());
        hide.setSpeedMs(getHideSpeed());

        ajax.pushDefer();
        ajax.setContents(card);

        ScShowScript show;
        show = ajax.show();
        show.setEffect(getShowEffect());
        show.setEasing(getShowEasing());
        show.setSpeedMs(getShowSpeed());

        ajax.pop();
        ajax.focusDeferred();
    }

    //##################################################
    //# navigation
    //##################################################

    public void printDefault()
    {
        print(getDefaultCard());
    }

    public void print(ScCard e)
    {
        check(e);

        ajaxPrint(e);
    }

    public void close(ScCard e)
    {
        check(e);

        if ( e.isDefault() )
            ajaxPrint(null);
        else
            printDefault();
    }

    //##################################################
    //# support
    //##################################################

    private void check(ScCard e)
    {
        if ( e == null )
            return;

        if ( !e.hasParent(this) )
            Kmu.fatal("Child does not belong to this frame.");
    }
}
