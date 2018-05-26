package com.app.ui.page.guide;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.control.ScScriptButton;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.servlet.script.ScHtmlIdAjax;

public class MySetupInfoItem
    extends ScFieldset
{
    //##################################################
    //# variables
    //##################################################

    private ScScriptButton _showDetailsButton;
    private ScScriptButton _hideDetailsButton;
    private ScDiv          _detailBox;

    //##################################################
    //# constructor
    //##################################################

    public MySetupInfoItem(String label, String summary, String detail)
    {
        ScFieldset set;
        set = this;
        set.setLabel(label);

        ScDiv e;
        e = set.addDiv();
        e.css().flexColumn().pad10().columnSpacer20();
        e.add(createTopRow(summary));
        e.add(createBottomRow(detail));
    }

    //##################################################
    //# install
    //##################################################

    private ScControl createTopRow(String summary)
    {
        ScDiv e;
        e = new ScDiv();
        e.css().flexRow();

        ScDiv label;
        label = e.addLabel(summary);
        label.css().flexChildFiller();
        e.add(createShowDetailsButton());
        e.add(createHideDetailsButton());
        return e;
    }

    private ScControl createShowDetailsButton()
    {
        ScScriptButton e;
        e = new ScScriptButton();
        e.setFlavorIcon();
        e.setIcon().nameExpandMore();
        e.setHoverText("Show Details");
        _showDetailsButton = e;
        return e;
    }

    private ScControl createHideDetailsButton()
    {
        ScScriptButton e;
        e = new ScScriptButton();
        e.setFlavorIcon();
        e.setIcon().nameExpandLess();
        e.setHoverText("Hide Details");
        e.hide();
        _hideDetailsButton = e;
        return e;
    }

    private ScControl createBottomRow(String detail)
    {
        ScDiv e;
        e = new ScDiv();
        e.addText(detail);
        e.hide();
        _detailBox = e;
        return e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        ScBlockScript script = formatToggleScript();
        _showDetailsButton.setScript(script);
        _hideDetailsButton.setScript(script);
    }

    //##################################################
    //# script
    //##################################################

    private ScBlockScript formatToggleScript()
    {
        ScBlockScript delegate = ScBlockScript.create();

        ScHtmlIdAjax ajax;
        ajax = ScHtmlIdAjax.createOnDelegate(_detailBox, delegate);
        ajax.toggle().slide();

        ajax = ScHtmlIdAjax.createOnDelegate(_showDetailsButton, delegate);
        ajax.toggle();

        ajax = ScHtmlIdAjax.createOnDelegate(_hideDetailsButton, delegate);
        ajax.toggle();

        return delegate;
    }
}
