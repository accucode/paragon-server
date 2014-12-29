package com.app.ui.layout;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.servlet.ScPage;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScImage;
import com.kodemore.servlet.control.ScScriptLink;
import com.kodemore.servlet.control.ScTextSpan;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.servlet.script.ScScriptIF;
import com.kodemore.servlet.script.ScSimpleBlockScript;
import com.kodemore.servlet.utility.ScJquery;

import com.app.model.MyProject;
import com.app.utility.MyGlobals;

public class MyPageTitle
    extends ScDiv
{
    //##################################################
    //# variables
    //##################################################

    private ScDiv      _left;
    private ScTextSpan _nameText;
    private ScTextSpan _projectText;

    private ScDiv      _right;
    private ScImage    _helpImage;

    //##################################################
    //# install
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        setHtmlId("pageTitle");

        _left = addDiv();
        _left.css().pageTitle_left();

        _nameText = _left.addTextSpan();
        _nameText.css().pageTitle_nameText();

        _projectText = _left.addTextSpan();
        _projectText.css().pageTitle_projectText();

        _right = addDiv();
        _right.css().pageTitle_right();

        ScScriptLink toggleHelpLink;
        toggleHelpLink = _right.addScriptLink();
        toggleHelpLink.css().clear().pageTitle_link();
        toggleHelpLink.setText("toggle field help");
        toggleHelpLink.setScript(getToggleFieldHelpScript());
        toggleHelpLink.hide();

        _helpImage = _right.addImage();
        _helpImage.css().pageTitle_help();
        _helpImage.style().hide();
    }

    private ScScriptIF getToggleFieldHelpScript()
    {
        String css = KmCssDefaultConstantsIF.formHelp;
        String sel = ScJquery.formatCssSelector(css);

        ScBlockScript e;
        e = new ScSimpleBlockScript();
        e.toggle(sel);
        return e;
    }

    //##################################################
    //# refresh
    //##################################################

    public void ajaxRefreshContentFor(ScPage page)
    {
        _ajaxRefreshTitleFor(page);
        _ajaxRefreshHelpFor(page);
    }

    private void _ajaxRefreshTitleFor(ScPage page)
    {
        _nameText.ajax().setContents(formatNameHtml(page));
        _projectText.ajax().setContents(formatProjectHtml());
    }

    private KmHtmlBuilder formatNameHtml(ScPage page)
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.print(page.getTitle());
        return out;
    }

    private KmHtmlBuilder formatProjectHtml()
    {
        MyProject p = MyGlobals.getServerSession().getCurrentProject();
        if ( p == null )
            return null;

        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.printf("(%s)", p.getName());
        return out;
    }

    private void _ajaxRefreshHelpFor(ScPage page)
    {
        if ( !page.hasHelpMessage() )
        {
            _helpImage.ajax().hide();
            return;
        }

        _helpImage.ajax().setAttribute("title", page.getHelpMessage());
        _helpImage.ajax().show();
    }

    public void glowOn(ScBlockScript script)
    {
        int ms = 500;

        script.glowColor(_nameText).setSpeed(ms);
        script.glowColor(_projectText).setSpeed(ms);
    }
}
