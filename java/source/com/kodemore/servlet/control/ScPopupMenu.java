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

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.KmStyleBuilder;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.script.ScActionScript;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalInteger;
import com.kodemore.servlet.variable.ScLocalString;

/**
 * A simple, lightweight popup menu.
 * Based on 'popr'
 * http://www.tipue.com/popr/
 */
public class ScPopupMenu
    extends ScElement
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The image url.
     * Defaults to: ~threeDotMenuBlack.png
     */
    private ScLocalString           _imageUrl;

    /**
     * If using the 'three dot' menu icon, this determines the size (width & height)
     * of the icon. The original icon is 128px so scaling larger than this is not
     * recommended. The default size is 24px.
     */
    private ScLocalInteger          _imageSize;

    /**
     * The items to be displayed in the popup menu.
     */
    private KmList<ScPopupMenuItem> _items;

    /**
     * If true, open the menu above the target.
     * By default, it opens below.
     */
    private ScLocalBoolean          _alignTop;

    /**
     * The speed in ms to open the menu.
     * Defaults to 100ms.
     */
    private ScLocalInteger          _speedMs;

    //##################################################
    //# constructor
    //##################################################

    public ScPopupMenu()
    {
        _imageUrl = new ScLocalString();
        _imageSize = new ScLocalInteger(24);
        setColorBlack();

        _items = new KmList<>();

        _alignTop = new ScLocalBoolean(false);
        _speedMs = new ScLocalInteger(100);
    }

    //##################################################
    //# accessing :: image url
    //##################################################

    public String getImageUrl()
    {
        return _imageUrl.getValue();
    }

    public void setImageUrl(String e)
    {
        _imageUrl.setValue(e);
    }

    public void setColorBlack()
    {
        setImageUrl(getThemeImageUrl("threeDotMenuBlack.png"));
    }

    public void setColorWhite()
    {
        setImageUrl(getThemeImageUrl("threeDotMenuWhite.png"));
    }

    //==================================================
    //= accessing :: image size
    //==================================================

    public int getImageSize()
    {
        return _imageSize.getValue();
    }

    public void setImageSize(int e)
    {
        _imageSize.setValue(e);
    }

    //##################################################
    //# accessing :: items
    //##################################################

    public ScPopupMenuItem addItem(String text, Runnable runnable)
    {
        ScAction action = newCheckedAction(runnable);
        return addItem(text, action);
    }

    public ScPopupMenuItem addItem(String text, ScAction action)
    {
        Object arg = null;
        return addItem(text, action, arg);
    }

    public ScPopupMenuItem addItem(String text, ScAction action, Object arg)
    {
        ScPopupMenuItem e;
        e = new ScPopupMenuItem();
        e.setText(text);
        e.setAction(action);
        e.setArgument(arg);
        _items.add(e);
        return e;
    }

    //##################################################
    //# accessing :: speed
    //##################################################

    public int getSpeedMs()
    {
        return _speedMs.getValue();
    }

    public void setSpeedMs(int e)
    {
        _speedMs.setValue(e);
    }

    //##################################################
    //# accessing :: align
    //##################################################

    public boolean getAlignTop()
    {
        return _alignTop.isTrue();
    }

    public void setAlignTop()
    {
        _alignTop.setTrue();
    }

    public void setAlignBottom()
    {
        _alignTop.setFalse();
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        if ( _items.isEmpty() )
            return;

        out.open("div");
        out.printAttribute("id", getHtmlId());
        out.printAttribute("class", "popr");
        out.printDataAttribute("id", getHtmlId());
        out.close();

        renderImageOn(out);
        out.end("div");

        renderMenuOn(out);
        renderScriptOn(out);
    }

    private void renderImageOn(KmHtmlBuilder out)
    {
        KmStyleBuilder style;
        style = newStyleBuilder();
        style.size(getImageSize());

        out.open("img");
        out.printAttribute(style);
        out.printAttribute("src", getImageUrl());
        out.close();
    }

    private void renderMenuOn(KmHtmlBuilder out)
    {
        out.open("div");
        out.printAttribute("class", "popr-box");
        out.printDataAttribute("box-id", getHtmlId());
        out.close();

        renderItemsOn(out);

        out.end("div");
    }

    private void renderItemsOn(KmHtmlBuilder out)
    {
        for ( ScPopupMenuItem e : _items )
            renderItemOn(out, e);
    }

    private void renderItemOn(KmHtmlBuilder out, ScPopupMenuItem item)
    {
        if ( !item.isVisible() )
            return;

        String onClick = formatOnClick(item.getAction(), item.getArgument());

        out.open("a");
        out.printAttribute("href", "#");
        out.printAttribute("onclick", onClick);
        out.printAttribute("class", "popr-item");
        out.close();
        out.print(item.getText());
        out.end("a");
    }

    private void renderScriptOn(KmHtmlBuilder out)
    {
        String position = getAlignTop()
            ? "top"
            : "bottom";

        out.getPostDom().run(
            "$('#%s').popr({'speed':%s,'mode':'%s'});",
            getHtmlId(),
            getSpeedMs(),
            position);
    }

    private String formatOnClick(ScAction action, Object arg)
    {
        ScActionScript out;
        out = new ScActionScript();
        out.setForm(findFormWrapper());
        out.setAction(action);
        out.setArgument(arg);
        return out.toString();
    }
}
