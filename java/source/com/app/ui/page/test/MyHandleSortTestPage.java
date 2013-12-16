package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScPageRoot;

public class MyHandleSortTestPage
    extends MyTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyHandleSortTestPage instance = new MyHandleSortTestPage();

    private MyHandleSortTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScDiv      _blueDiv;
    private ScActionIF _sortAction;

    //##################################################
    //# navigation
    //##################################################

    @Override
    public ScParameterList composeUrlParameters()
    {
        return null;
    }

    @Override
    public void applyUrlParameters(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        _sortAction = newSortAction();
        root.css().gap();

        ScDiv green;
        green = root.addDiv();
        green.css().boxGreen().pad();
        green.addText("Drag divs within a parent div.");
        green.setHoverText("This is a green div.");

        _blueDiv = root.addDiv();
        _blueDiv.css().boxBlue().gap();

        addGrayBox(_blueDiv, "one");
        addGrayBox(_blueDiv, "two");
        addGrayBox(_blueDiv, "three");
        addGrayBox(_blueDiv, "four");
    }

    public ScDiv addGrayBox(ScDiv root, String text)
    {
        ScDiv grayDiv;
        grayDiv = root.addBox();
        grayDiv.css().boxGray().pad();
        addDragHandle(grayDiv);
        grayDiv.css().gap();
        grayDiv.addParagraph(text);
        return grayDiv;
    }

    public ScDiv addDragHandle(ScDiv root)
    {
        ScDiv handle;
        handle = root.addDiv();
        handle.css().floatLeft();
        handle.css().cursorMove();
        handle.css().width100();
        handle.css().boxDarkGray();
        handle.css().dragHandle();
        handle.addParagraph("handle");
        return handle;
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        _blueDiv.ajax().sortableByHandle();
        _blueDiv.ajax().sortableUpdate("> div", "id", _sortAction);
    }

    //##################################################
    //# action
    //##################################################

    private ScActionIF newSortAction()
    {
        return new ScAction(this)
        {
            @Override
            protected void handle()
            {
                handleSort();
            }
        };
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSort()
    {
        String s = getData().getExtraParameter();
        ajax().toast(s);
    }
}
