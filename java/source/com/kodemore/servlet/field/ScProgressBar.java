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

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScDivWrapper;
import com.kodemore.servlet.control.ScTransientContainer;
import com.kodemore.servlet.variable.ScLocalDate;
import com.kodemore.servlet.variable.ScLocalInteger;
import com.kodemore.time.KmClock;
import com.kodemore.time.KmDate;

/**
 * I am a visual representation of the progress of some task.
 */
public class ScProgressBar
    extends ScDivWrapper
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The start of the period to be represented on the progress bar.  If not
     * set, this will default to the task start.
     */
    private ScLocalDate _periodStartDate;

    /**
     * The end of the period to be represented on the progress bar.  If not
     * set, this will default to either the due date or today, whichever is latest.
     */
    private ScLocalDate _periodEndDate;

    /**
     * The date the task was started.
     */
    private ScLocalDate _taskStartDate;

    /**
     * The date the task is due (or expected to be completed).
     */
    private ScLocalDate _taskDueDate;

    /**
     * The current day.  If not set, this will default to today's date.
     */
    private ScLocalDate _todayDate;

    /**
     * The current progress in completing the task.  E.g. the task is
     * currently on step 16, of a total of 100 steps.
     */
    private ScLocalInteger _currentProgress;

    /**
     * The total progress required to complete the task. E.g. 100.
     */
    private ScLocalInteger _requiredProgress;

    /**
     * The height of the widget.  If not set, a default value will be used.
     */
    private ScLocalInteger _height;

    /**
     * The width of the widget.  If not set, a default value will be used.
     */
    private ScLocalInteger _width;

    /**
     * The transient container that contains the progess bar.
     */
    private ScTransientContainer _transient;

    //##################################################
    //# constructor
    //##################################################

    public ScProgressBar()
    {
        _periodStartDate = new ScLocalDate();
        _periodEndDate = new ScLocalDate();
        _taskStartDate = new ScLocalDate();
        _taskDueDate = new ScLocalDate();
        _todayDate = new ScLocalDate();
        _currentProgress = new ScLocalInteger();
        _requiredProgress = new ScLocalInteger();
        _height = new ScLocalInteger();
        _width = new ScLocalInteger();

        _transient = getInner().addTransientContainer();

        css().progressView_box();
    }

    //##################################################
    //# period start
    //##################################################

    public KmDate getPeriodStartDate()
    {
        return _periodStartDate.getValue();
    }

    public void setPeriodStartDate(KmDate e)
    {
        _periodStartDate.setValue(e);
    }

    public boolean hasPeriodStartDate()
    {
        return getPeriodStartDate() != null;
    }

    public KmDate getEffectivePeriodStartDate()
    {
        return hasPeriodStartDate()
            ? getPeriodStartDate()
            : getTaskStartDate();
    }

    public KmDate getPeriodEndDate()
    {
        return _periodEndDate.getValue();
    }

    public void setPeriodEndDate(KmDate e)
    {
        _periodEndDate.setValue(e);
    }

    public boolean hasPeriodEndDate()
    {
        return getPeriodEndDate() != null;
    }

    public KmDate getEffectivePeriodEndDate()
    {
        if ( hasPeriodEndDate() )
            return getPeriodEndDate();

        KmDate today = getEffectiveTodayDate();
        KmDate due = getTaskDueDate();

        if ( due == null )
            return today;

        if ( today.isAfter(due) )
            return today;

        return due;
    }

    private int getTotalPeriodDays()
    {
        KmDate start = getEffectivePeriodStartDate();
        KmDate end = getEffectivePeriodEndDate();
        return start.getDaysUntil(end);
    }

    //##################################################
    //# task start
    //##################################################

    public KmDate getTaskStartDate()
    {
        return _taskStartDate.getValue();
    }

    public void setTaskStartDate(KmDate e)
    {
        _taskStartDate.setValue(e);
    }

    private boolean hasTaskStartDate()
    {
        return getTaskStartDate() != null;
    }

    //##################################################
    //# due date
    //##################################################

    public KmDate getTaskDueDate()
    {
        return _taskDueDate.getValue();
    }

    public void setTaskDueDate(KmDate e)
    {
        _taskDueDate.setValue(e);
    }

    private boolean hasTaskDueDate()
    {
        return getTaskDueDate() != null;
    }

    //##################################################
    //# today
    //##################################################

    public KmDate getTodayDate()
    {
        return _todayDate.getValue();
    }

    public void setTodayDate(KmDate e)
    {
        _todayDate.setValue(e);
    }

    public boolean hasTodayDate()
    {
        return getTodayDate() != null;
    }

    public KmDate getEffectiveTodayDate()
    {
        return hasTodayDate()
            ? getTodayDate()
            : KmClock.getLocalDate();
    }

    //##################################################
    //# progress
    //##################################################

    public Integer getCurrentProgress()
    {
        return _currentProgress.getValue();
    }

    public void setCurrentProgress(Integer e)
    {
        _currentProgress.setValue(e);
    }

    private boolean hasCurrentProgress()
    {
        return getCurrentProgress() != null;
    }

    public Integer getRequiredProgress()
    {
        return _requiredProgress.getValue();
    }

    public void setRequiredProgress(Integer e)
    {
        _requiredProgress.setValue(e);
    }

    private boolean hasRequiredProgress()
    {
        return getRequiredProgress() != null;
    }

    public void setProgress(Integer current, Integer total)
    {
        setCurrentProgress(current);
        setRequiredProgress(total);
    }

    /**
     * The progress percentage as an interger.  E.g. 50 = 50%
     */
    public void setProgressPercent(Integer e)
    {
        setCurrentProgress(e);
        setRequiredProgress(100);
    }

    /**
     * The progress percentage as an decimal.  E.g. .5 = 50%
     */
    public Double getProgressDecimal()
    {
        if ( !hasCurrentProgress() || !hasRequiredProgress() )
            return null;

        Integer current = getCurrentProgress();
        Integer required = getRequiredProgress();

        Double c = new Double(current);
        Double t = new Double(required);
        Double percent = c / t;
        return percent;
    }

    /**
     * The progress percentage as an interger.  E.g. 50 = 50%
     */
    public Integer getProgressPercent()
    {
        Double decimal = getProgressDecimal();

        if ( decimal == null )
            return null;

        Double percent = decimal * 100;
        return percent.intValue();
    }

    //##################################################
    //# layout
    //##################################################

    public Integer getHeight()
    {
        return _height.getValue();
    }

    public void setHeight(Integer e)
    {
        _height.setValue(e);
    }

    public boolean hasHeight()
    {
        return getHeight() != null;
    }

    public Integer getWidth()
    {
        return _width.getValue();
    }

    public void setWidth(Integer e)
    {
        _width.setValue(e);
    }

    public boolean hasWidth()
    {
        return getWidth() != null;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        preRenderBox();
        preRenderContent();
    }

    private void preRenderBox()
    {
        if ( hasHeight() )
            getInner().style().height(getHeight());

        if ( hasWidth() )
            getInner().style().width(getWidth());
    }

    private void preRenderContent()
    {
        if ( isNew() )
            return;

        Integer taskStartPercent = computeTaskStartPercent();
        Integer taskProgressPercent = computeTaskProgressPercent();
        Integer todayPercent = computeTodayPercent();
        Integer duePercent = computeDuePercent();

        ScTransientContainer t;
        t = _transient;
        t.add(newDueBox(duePercent));
        t.add(newProgressBox(taskStartPercent, taskProgressPercent));
        t.add(newTodayBox(todayPercent));
    }

    //##################################################
    //# compute
    //##################################################

    private Integer computeTaskStartDays()
    {
        if ( !hasPeriodStartDate() || !hasTaskStartDate() )
            return null;

        KmDate periodStart = getEffectivePeriodStartDate();
        KmDate taskStart = getTaskStartDate();
        int taskStartDays = periodStart.getDaysUntil(taskStart);
        return taskStartDays;
    }

    private Integer computeTaskStartPercent()
    {
        Integer taskStartDays = computeTaskStartDays();

        if ( taskStartDays == null )
            return null;

        Double totalDouble = new Double(getTotalPeriodDays());
        Double taskStartDouble = new Double(taskStartDays);

        Double percent = taskStartDouble / totalDouble * 100;
        return percent.intValue();
    }

    private int computeTaskProgressPercent()
    {
        if ( !hasTaskStartDate() )
            return 0;

        KmDate taskStart = getTaskStartDate();
        KmDate due = getTaskDueDate();
        int totalTaskDays = taskStart.getDaysUntil(due);
        int totalDays = getTotalPeriodDays();
        Double totalDouble = new Double(totalDays);
        Double totalTaskDaysDouble = new Double(totalTaskDays);

        Integer taskDays = computeTaskStartDays();
        double taskStartDouble = taskDays == null
            ? 0.0
            : taskDays;

        Double progressDecimal = getProgressDecimal();
        Double percent = (progressDecimal * totalTaskDaysDouble + taskStartDouble)
            / totalDouble
            * 100;

        return percent.intValue();
    }

    private int computeTodayPercent()
    {
        KmDate start = getEffectivePeriodStartDate();
        KmDate today = getEffectiveTodayDate();

        int todayDays = start.getDaysUntil(today);
        Double todayDouble = new Double(todayDays);
        Double totalDouble = new Double(getTotalPeriodDays());

        Double percent = todayDouble / totalDouble * 100;
        return percent.intValue();
    }

    private int computeDuePercent()
    {
        KmDate due = getTaskDueDate();
        KmDate start = getEffectivePeriodStartDate();

        int dueDays = start.getDaysUntil(due);
        Double dueDouble = new Double(dueDays);
        Double totalDouble = new Double(getTotalPeriodDays());

        Double percent = dueDouble / totalDouble * 100;
        return percent.intValue();
    }

    //##################################################
    //# bars
    //##################################################

    private ScDiv newProgressBox(Integer startPercent, Integer endPercent)
    {
        ScDiv progress;
        progress = new ScDiv();
        progress.css().progressView_progress();

        if ( startPercent != null )
            progress.style().leftPercent(startPercent);

        progress.style().rightPercent(100 - endPercent);
        return progress;
    }

    private ScDiv newTodayBox(Integer todayPercent)
    {
        if ( todayPercent < 0 )
            todayPercent = 0;

        if ( todayPercent > 100 )
            todayPercent = 100;

        ScDiv today;
        today = new ScDiv();
        today.style().leftPercent(todayPercent);

        applyTodayStyleTo(today);

        return today;
    }

    private void applyTodayStyleTo(ScDiv today)
    {
        int height = hasHeight()
            ? getHeight()
            : 16;

        int borderWidth = (int)(0.5 * height / 2);

        if ( isTodayBeforePeriod() )
        {
            applyTodayBeforeStyleTo(today, borderWidth);
            return;
        }

        if ( isTodayAfterPeriod() )
        {
            applyTodayAfterStyleTo(today, borderWidth);
            return;
        }

        today.css().progressView_today();
        today.style().setValue("border-width", borderWidth, "px");
        today.style().marginTop(-borderWidth);
        today.style().marginLeft(-borderWidth);
    }

    private void applyTodayBeforeStyleTo(ScDiv today, int borderWidth)
    {
        today.css().progressView_today_before();
        today.style().setValue("border-width", borderWidth, "px");
        today.style().marginTop(-borderWidth);
        today.style().marginLeft(-borderWidth);
        return;
    }

    private void applyTodayAfterStyleTo(ScDiv today, int borderWidth)
    {
        today.css().progressView_today_after();
        today.style().setValue("border-width", borderWidth, "px");
        today.style().marginTop(-borderWidth);
        today.style().marginLeft(-borderWidth);
    }

    private ScDiv newDueBox(Integer duePercent)
    {
        ScDiv due;
        due = new ScDiv();
        due.css().progressView_due();
        due.style().leftPercent(duePercent);

        if ( isPastDue() )
            due.style().backgroundColor("pink");

        return due;
    }

    //##################################################
    //# support
    //##################################################

    private boolean isNew()
    {
        if ( !hasTaskStartDate()
            || !hasCurrentProgress()
            || !hasRequiredProgress()
            || !hasTaskDueDate() )
            return true;

        return false;
    }

    private boolean isPastDue()
    {
        if ( !hasTaskDueDate() )
            return false;

        KmDate today = getEffectiveTodayDate();
        KmDate due = getTaskDueDate();

        if ( today.isAfter(due) )
            return true;

        return false;
    }

    private boolean isTodayBeforePeriod()
    {
        KmDate start = getEffectivePeriodStartDate();

        if ( start == null )
            return false;

        return getEffectiveTodayDate().isBefore(start);
    }

    private boolean isTodayAfterPeriod()
    {
        KmDate end = getEffectivePeriodEndDate();

        if ( end == null )
            return false;

        return getEffectiveTodayDate().isAfter(end);
    }
}
