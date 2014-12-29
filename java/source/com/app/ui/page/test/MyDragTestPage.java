package com.app.ui.page.test;

import com.kodemore.collection.KmIntegerRange;
import com.kodemore.collection.KmList;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.encoder.ScDecoder;
import com.kodemore.servlet.field.ScDropdown;
import com.kodemore.servlet.field.ScHiddenField;
import com.kodemore.servlet.script.ScSortableScript;

public class MyDragTestPage
    extends MyAbstractTestEntryPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyDragTestPage instance = new MyDragTestPage();

    private MyDragTestPage()
    {
        // singleton
    }

    //##################################################
    //# constants
    //##################################################

    private static final int    ITEM_COUNT = 10;
    private static final String FIELD_NAME = "item";

    //##################################################
    //# variables
    //##################################################

    private ScDiv               _container;
    private ScDropdown          _dropdown;
    private ScForm              _form;

    //##################################################
    //# navigation
    //##################################################

    @Override
    public ScParameterList composeQueryParameters()
    {
        return null;
    }

    @Override
    public void applyQueryParameters(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().gap();

        _form = getRoot().addForm();
        _form.setSubmitAction(newSubmitAction());

        installActionsOn(_form);
        installContainerOn(_form);
        installChildrenOn(_container);
    }

    private void installActionsOn(ScContainer root)
    {
        _dropdown = new ScDropdown();
        _dropdown.setOptions(new KmIntegerRange(0, ITEM_COUNT - 1).toList());

        ScBox row;
        row = root.addBox();
        row.css().boxGreen().gap();
        row.addButton("Scroll to:", newScrollAction());
        row.add(_dropdown);
        row.addSubmitButton();
    }

    private void installContainerOn(ScContainer root)
    {
        _container = root.addDiv();
        _container.css().boxBlue().gap().height400().scrollY();

        ScSortableScript s;
        s = _container.getPostDomScript().sortable();
        s.setHandleCss(KmCssDefaultConstantsIF.dragHandle);
    }

    private void installChildrenOn(ScContainer root)
    {
        int n = ITEM_COUNT;
        for ( int i = 0; i < n; i++ )
            installChildOn(root, i);
    }

    public ScDiv installChildOn(ScContainer root, int value)
    {
        ScDiv e;
        e = root.addBox();
        e.css().boxYellow().pad();
        e.css().gap();

        installDragHandleOn(e);
        installMessageOn(e, value);
        installHiddenFieldOn(e, value);

        return e;
    }

    public ScDiv installDragHandleOn(ScDiv root)
    {
        ScDiv e;
        e = root.addDiv();
        e.css().dragHandle();
        return e;
    }

    private void installMessageOn(ScDiv root, int value)
    {
        root.addText(value + "");
    }

    private void installHiddenFieldOn(ScDiv root, int value)
    {
        ScHiddenField<Integer> field;
        field = root.addHiddenField();
        field.setHtmlName(FIELD_NAME);
        field.setValue(value);
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();
    }

    //##################################################
    //# action
    //##################################################

    private ScActionIF newSubmitAction()
    {
        return new ScAction(this)
        {
            @Override
            protected void handle()
            {
                handleSubmit();
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
        int value = _dropdown.getIntegerValue();
        ScDiv div = (ScDiv)_container.getChildren().get(value);

        _container.ajax().scrollTo(div);
    }

    private void handleSubmit()
    {
        KmList<String> strings = getData().getParameters(FIELD_NAME);
        KmList<Integer> ints = new KmList<>();

        for ( String s : strings )
        {
            Integer i = (Integer)ScDecoder.staticDecode(s);
            ints.add(i);
        }

        ajax().toast(ints.format());
    }
}
