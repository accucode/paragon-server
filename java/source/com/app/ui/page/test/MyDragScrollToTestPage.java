package com.app.ui.page.test;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScArray;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScDropdown;

public class MyDragScrollToTestPage
    extends MyTestPage
{
    /**
     * fixme_steve working on this dragScroll
     */
    //##################################################
    //# singleton
    //##################################################

    public static final MyDragScrollToTestPage instance = new MyDragScrollToTestPage();

    private MyDragScrollToTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScDiv      _blueDiv;
    private ScActionIF _sortAction;
    private ScDropdown _dropdown;
    private ScForm     _form;

    //##################################################
    //# navigation
    //##################################################

    @Override
    public void initUrlFromSession(ScParameterList v)
    {
        // none
    }

    @Override
    public void initSessionFromUrl(ScParameterList v)
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

        _blueDiv = root.addDiv();
        _blueDiv.css().boxBlue().gap();
        _blueDiv.style().height(500).scroll();

        KmList<Integer> v = new KmList<Integer>();

        for ( int i = 0; i < 50; i++ )
        {
            addGrayBox(_blueDiv, "" + i);
            v.add(i);
        }

        _dropdown = new ScDropdown();
        _dropdown.setOptions(v);

        _form = root.addForm();

        ScArray row = _form.addRow();
        row.addButton("SCROLL", newScrollAction());
        row.add(_dropdown);
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

    private ScActionIF newScrollAction()
    {
        return new ScAction(this)
        {
            @Override
            protected void handle()
            {
                handleScroll();
            }
        };
    }

    //##################################################
    //# handle
    //##################################################

    private void handleScroll()
    {
        /**
         * fixme_steve (aaron) well this ain't workin'
         */
        int dropdownValue = _dropdown.getIntegerValue();
        ScDiv div = (ScDiv)_blueDiv.getChildren().get(dropdownValue);

        _blueDiv.ajax().scrollTo(_blueDiv, div, 100);
    }

    private void handleSort()
    {
        String s = getData().getExtraParameter();
        ajax().toast(s);
    }
}
