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

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.variable.ScLocalString;

/**
 * A simple interface to the Google Material Icons.
 * https://material.io/icons/
 *
 * Icons are rendered via a custom font and represented in the dom
 * with tags like:
 * <i class="material-icons">refresh</i>
 */
public class ScIcon
    extends ScElement
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalString _name;

    //##################################################
    //# constructor
    //##################################################

    public ScIcon()
    {
        _name = new ScLocalString();

        css().add("material-icons");
        styleDark();
    }

    //##################################################
    //# name
    //##################################################

    public String getName()
    {
        return _name.getValue();
    }

    private void setName(String e)
    {
        _name.setValue(e);
    }

    public boolean hasName()
    {
        return _name.hasValue();
    }

    //##################################################
    //# standard styles
    //##################################################

    public ScIcon styleDark()
    {
        clearStyle();
        css().add().iconStyleDark();
        return this;
    }

    public ScIcon styleLight()
    {
        clearStyle();
        css().iconStyleLight();
        return this;
    }

    public ScIcon stylePositive()
    {
        clearStyle();
        css().add().iconStylePositive();
        return this;
    }

    public ScIcon styleNegative()
    {
        clearStyle();
        css().add().iconStyleNegative();
        return this;
    }

    public ScIcon styleError()
    {
        clearStyle();
        css().iconStyleError();
        return this;
    }

    public ScIcon styleWarning()
    {
        clearStyle();
        css().iconStyleWarning();
        return this;
    }

    private void clearStyle()
    {
        css().removeByPrefix("iconStyle");
    }

    //##################################################
    //# size
    //##################################################

    public ScIcon sizeButton()
    {
        clearSize();
        css().iconSizeButton();
        return this;
    }

    private void clearSize()
    {
        css().removeByPrefix("iconSize");
    }

    //##################################################
    //# common names
    //##################################################

    private ScIcon name(String e)
    {
        setName(e);
        return this;
    }

    //==================================================
    //= types :: undo
    //==================================================

    public ScIcon nameUndo()
    {
        return name("undo");
    }

    public ScIcon nameRedo()
    {
        return name("redo");
    }

    //==================================================
    //= types :: veritcal align
    //==================================================

    public ScIcon nameVerticalAlignTop()
    {
        return name("vertical_align_top");
    }

    public ScIcon nameVerticalAlignBottom()
    {
        return name("vertical_align_bottom");
    }

    public ScIcon nameVerticalAlignCenter()
    {
        return name("vertical_align_center");
    }

    //==================================================
    //= warn / error
    //==================================================

    public ScIcon nameWarning()
    {
        return name("warning");
    }

    public ScIcon nameError()
    {
        return name("error");
    }

    public ScIcon setErrorOutline()
    {
        return name("error_outline");
    }

    //==================================================
    //= search
    //==================================================

    public ScIcon nameSearch()
    {
        return name("search");
    }

    public ScIcon nameFilter()
    {
        return name("filter_list");
    }

    public ScIcon nameRefresh()
    {
        return name("refresh");
    }

    //==================================================
    //= types :: expand
    //==================================================

    public ScIcon nameExpandMore()
    {
        return name("expand_more");
    }

    public ScIcon nameExpandLess()
    {
        return name("expand_less");
    }

    //==================================================
    //= types :: arrow
    //==================================================

    public ScIcon nameArrowForward()
    {
        return name("arrow_forward");
    }

    public ScIcon nameArrowBack()
    {
        return name("arrow_back");
    }

    public ScIcon nameArrowUpward()
    {
        return name("arrow_upward");
    }

    public ScIcon nameArrowDownward()
    {
        return name("arrow_downward");
    }

    //==================================================
    //= drop arrow
    //==================================================

    public ScIcon nameArrowDropDown()
    {
        return name("arrow_drop_down");
    }

    public ScIcon nameArrowDropUp()
    {
        return name("arrow_drop_up");
    }

    //==================================================
    //= types :: fullscreen
    //==================================================

    public ScIcon nameFullscreen()
    {
        return name("fullscreen");
    }

    public ScIcon nameFullscreenExit()
    {
        return name("fullscreen_exit");
    }

    //==================================================
    //= types :: add
    //==================================================

    public ScIcon nameAddCircleOutline()
    {
        return name("add_circle_outline");
    }

    //==================================================
    //= types :: edit
    //==================================================

    public ScIcon nameEdit()
    {
        return name("edit");
    }

    //==================================================
    //= types :: remove
    //==================================================

    public ScIcon nameRemoveCircleOutline()
    {
        return name("remove_circle_outline");
    }

    //==================================================
    //= types :: delete
    //==================================================

    public ScIcon nameDelete()
    {
        return name("delete");
    }

    public ScIcon nameDeleteForever()
    {
        return name("delete_forever");
    }

    //==================================================
    //= types :: navigate
    //==================================================

    public ScIcon nameNavigateBefore()
    {
        return name("navigate_before");
    }

    public ScIcon nameNavigateNext()
    {
        return name("navigate_next");
    }

    //==================================================
    //= types :: play
    //==================================================

    public ScIcon namePlayArrow()
    {
        return name("play_arrow");
    }

    public ScIcon nameCircleOutline()
    {
        return name("play_circle_outline");
    }

    public ScIcon nameCircleFilled()
    {
        return name("play_circle_filled");
    }

    //==================================================
    //= types :: skip
    //==================================================

    public ScIcon nameSkipNext()
    {
        return name("skip_next");
    }

    public ScIcon nameSkipPrevious()
    {
        return name("skip_previous");
    }

    //==================================================
    //= types :: page
    //==================================================

    public ScIcon nameFirstPage()
    {
        return name("first_page");
    }

    public ScIcon nameLastPage()
    {
        return name("last_page");
    }

    //==================================================
    //= types :: pause
    //==================================================

    public ScIcon namePause()
    {
        return name("pause");
    }

    public ScIcon namePauseCircleFilled()
    {
        return name("pause_circle_filled");
    }

    public ScIcon namePauseCircleOutline()
    {
        return name("pause_circle_outline");
    }

    //==================================================
    //= types :: open/close
    //==================================================

    public ScIcon nameOpenInNew()
    {
        return name("open_in_new");
    }

    public ScIcon nameClose()
    {
        return name("close");
    }

    //==================================================
    //= types :: other
    //==================================================

    public ScIcon nameContentCopy()
    {
        return name("content_copy");
    }

    public ScIcon nameDone()
    {
        return name("done");
    }

    public ScIcon nameDoneAll()
    {
        return name("done_all");
    }

    public ScIcon nameDownloadFile()
    {
        return name("download_file");
    }

    public ScIcon nameClear()
    {
        return name("clear");
    }

    public ScIcon nameSchedule()
    {
        return name("schedule");
    }

    public ScIcon namePrint()
    {
        return name("print");
    }

    public ScIcon nameAddAlert()
    {
        return name("add_alert");
    }

    public ScIcon nameSave()
    {
        return name("save");
    }

    public ScIcon nameHome()
    {
        return name("home");
    }

    public ScIcon nameFeedback()
    {
        return name("feedback");
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.open("i");
        renderAttributesOn(out);
        out.close();
        out.print(getName());
        out.end("i");
    }

}
