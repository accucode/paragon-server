package com.app.ui.control;

import com.kodemore.collection.KmList;
import com.kodemore.domain.KmUidDomainIF;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScTransientDiv;
import com.kodemore.servlet.field.ScMultiTupleView;
import com.kodemore.servlet.field.ScOption;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.types.KmStringTuple;
import com.kodemore.utility.KmHtmlLineEnding;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoAccess;
import com.app.macro.MyMacroDocumentFormatter;
import com.app.model.MyBlurb;
import com.app.model.MyBlurbOwnerIF;
import com.app.model.MyProject;
import com.app.model.MySite;
import com.app.model.base.MyBlurbOwnerType;
import com.app.model.meta.MyMetaBlurb;
import com.app.utility.MyGlobals;
import com.app.utility.MyUtility;

/**
 * I display a group with a single read-only screen template.
 * The context is derived from the model.
 */
public class MyBlurbGroup
    extends ScForm
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The screen template to be displayed.
     */
    private ScLocalString _templateUid;

    /**
     * The context. E.g.: project, job, etc.
     */
    private ScLocalString _ownerTypeCode;
    private ScLocalString _ownerUid;

    /**
     * The summary displayed in the header.
     */
    private MySummaryView<MyBlurb> _summary;

    /**
     * The transient control used to display the pre-formatted message.
     */
    private ScTransientDiv _messageDiv;

    /**
     * The fieldset wrapping the missing macro fields.
     * It is hidden if there are no missing macros.
     */
    private ScFieldset _missingMacroSet;

    /**
     * The fields to fill in values for any macros that
     * couldn't be automatically filled.
     */
    private ScMultiTupleView _missingMacroField;

    //##################################################
    //# constructor
    //##################################################

    public MyBlurbGroup()
    {
        _templateUid = new ScLocalString();
        _templateUid.setAutoSave();

        _ownerTypeCode = new ScLocalString();
        _ownerTypeCode.setAutoSave();

        _ownerUid = new ScLocalString();
        _ownerUid.setAutoSave();

        ScForm form;
        form = this;

        ScGroup group;
        group = form.addGroup();
        group.setTitle("Blurb");
        group.setFlavorSummary();
        group.css().fill().clip();

        installMessageOn(group);

        // This must be called after installMessageOn
        installHeaderOn(group);
    }

    //##################################################
    //# install
    //##################################################

    private void installHeaderOn(ScGroup group)
    {
        MyMetaBlurb x = MyBlurb.Meta;

        MySummaryView<MyBlurb> e;
        e = new MySummaryView<>();
        e.setTitle(x.Name);
        e.setSubtitle(x.OwnerTypeName);

        ScDiv buttons;
        buttons = e.getButtonBox();
        buttons.addScriptButton("Copy", newCopyScript(_messageDiv));
        buttons.addPopoutButton(newCheckedAction(this::handlePopout));

        _summary = e;

        group.showHeader().add(e);
    }

    private ScBlockScript newCopyScript(ScTransientDiv content)
    {
        ScBlockScript e;
        e = ScBlockScript.create();
        e.selectAndCopyText(content);
        e.toast("Copied.");
        return e;
    }

    private void installMessageOn(ScGroup group)
    {
        ScDiv body;
        body = group.getBody();
        body.css().auto().pad10().columnSpacer10();

        ScAction refreshAction = newUncheckedAction(this::handleRefreshMessage);

        ScFieldset macroSet;
        macroSet = body.addFieldset("Macro Values");
        macroSet.css().columnSpacer10();
        macroSet.add(createMissingMacroField());
        macroSet.addButton("Refresh", refreshAction);
        macroSet.hide();
        _missingMacroSet = macroSet;

        ScFieldset messageSet;
        messageSet = body.addFieldset("Content");

        _messageDiv = messageSet.addTransientDiv();
    }

    private ScMultiTupleView createMissingMacroField()
    {
        ScMultiTupleView e;
        e = new ScMultiTupleView();
        e.disableChangeTracking();
        _missingMacroField = e;
        return e;
    }

    //##################################################
    //# template
    //##################################################

    public MyBlurb getBlurb()
    {
        String uid = _templateUid.getValue();
        return getAccess().findBlurbUid(uid);
    }

    public boolean hasTemplate()
    {
        return getBlurb() != null;
    }

    public void setTemplate(MyBlurb e)
    {
        _templateUid.setValue(KmUidDomainIF.getUidFor(e));
    }

    //##################################################
    //# owner
    //##################################################

    public void setOwner(MyBlurbOwnerIF owner)
    {
        setOwnerType(owner.getBlurbOwnerType());
        setOwnerUid(owner.getUid());
    }

    public void _setOwner(Object e)
    {
        if ( !(e instanceof MyBlurbOwnerIF) )
            return;

        MyBlurbOwnerIF owner;
        owner = (MyBlurbOwnerIF)e;

        MyBlurbOwnerType type;
        type = owner.getBlurbOwnerType();

        if ( type == null )
            clearOwner();

        setOwnerType(type);
        setOwnerUid(owner.getUid());
    }

    private void clearOwner()
    {
        _ownerTypeCode.clearValue();
        _ownerUid.clearValue();
    }

    //==================================================
    //= owner :: type
    //==================================================

    private MyBlurbOwnerType getOwnerType()
    {
        return MyBlurbOwnerType.findCode(_ownerTypeCode.getValue());
    }

    public boolean hasOwnerType()
    {
        return getOwnerType() != null;
    }

    private void setOwnerType(MyBlurbOwnerType e)
    {
        _ownerTypeCode.setValue(e.getCode());
    }

    //==================================================
    //= context :: uid
    //==================================================

    private String getOwnerUid()
    {
        return _ownerUid.getValue();
    }

    private void setOwnerUid(String e)
    {
        _ownerUid.setValue(e);
    }

    //##################################################
    //# owner
    //##################################################

    private MyBlurbOwnerIF findOwner()
    {
        return getOwnerType().findOwnerUid(getOwnerUid());
    }

    private MyProject findProject()
    {
        MyBlurbOwnerIF owner = findOwner();
        if ( owner == null )
            return null;

        return owner.getProject();
    }

    private MySite findSite()
    {
        MyBlurbOwnerIF owner = findOwner();
        if ( owner == null )
            return null;

        MyBlurbOwnerType type = getOwnerType();
        switch ( type )
        {
            case Project:
                return null;

            case Site:
                return (MySite)owner;
        }
        throw Kmu.newEnumError(type);
    }

    //##################################################
    //# apply
    //##################################################

    @Override
    protected boolean applyFromModel_here(Object model)
    {
        // disable downcast, not applicable
        return false;
    }

    @Override
    protected boolean applyToModel_here(Object model)
    {
        // disable downcast, not applicable
        return false;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        preRenderHeader();
        preRenderMessage();
        preRenderMissingMacros();
    }

    private void preRenderHeader()
    {
        if ( hasTemplate() )
            _summary.applyFromModel(getBlurb());
    }

    private void preRenderMessage()
    {
        String html = composeMessageHtml();
        html = MyMacroDocumentFormatter.markAllHtml(html);

        if ( html != null )
            _messageDiv.addLiteral().setValue(html);
    }

    private void preRenderMissingMacros()
    {
        String html = composeMessageHtml();
        if ( html == null )
            return;

        KmList<String> v;
        v = MyMacroDocumentFormatter.findAllMacros(html);

        if ( v.isEmpty() )
            return;

        _missingMacroSet.show();
        _missingMacroField.setOptions(getOptionsFor(v));
    }

    private KmList<ScOption<String>> getOptionsFor(KmList<String> v)
    {
        KmList<ScOption<String>> options = new KmList<>();
        for ( String s : v )
        {
            String macro = s;

            String label = s;
            label = Kmu.removePrefix(label, "$(");
            label = Kmu.removeSuffix(label, ")");
            label = Kmu.formatCamelCaseAsCapitalizedWords(label);

            options.add(ScOption.create(macro, label));
        }

        return options;
    }

    //##################################################
    //# handle
    //##################################################

    private void handlePopout()
    {
        ScBlockScript ajax;
        ajax = getRootScript();
        ajax.openWindowHtml(composePopoutHtml().toString());
    }

    private String composePopoutHtml()
    {
        String name = getBlurb().getName();
        if ( name == null )
            return null;

        String body = composeHtmlUsingFieldValues();
        if ( body == null )
            return null;

        KmCssDefaultBuilder bodyCss;
        bodyCss = new KmCssDefaultBuilder();
        bodyCss.auto();
        bodyCss.pad20();

        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.printDocType();

        out.beginHtml();

        out.beginHead();
        out.printMetaContentTypeHtml();
        out.printTitle(name);
        MyUtility.printStyleLinksOn(out);
        out.endHead();

        out.openBody();
        out.printAttribute(bodyCss);
        out.close();
        out.printLiteral(body);
        out.endBody();

        out.endHtml();
        return out.toString();
    }

    private void handleRefreshMessage()
    {
        String html = composeHtmlUsingFieldValues();

        _messageDiv.clear();
        _messageDiv.addLiteral().setValue(html);
        _messageDiv.ajaxReplace();
    }

    private String composeHtmlUsingFieldValues()
    {
        String html = composeMessageHtml();

        KmList<KmStringTuple> v = _missingMacroField.getValue();
        for ( KmStringTuple e : v )
        {
            String key = e.getKey();
            String value = e.getValue();

            if ( Kmu.hasValue(value) )
            {
                String escaped = Kmu.escapeHtml(value, KmHtmlLineEnding.BreakElement);
                html = Kmu.replaceAll(html, key, escaped);
            }
        }

        html = MyMacroDocumentFormatter.markAllHtml(html);
        return html;
    }

    //##################################################
    //# compose html message
    //##################################################

    private String composeMessageHtml()
    {
        String templateUid = _templateUid.getValue();
        MyBlurb template = getAccess().findBlurbUid(templateUid);
        if ( template == null )
            return null;

        MyBlurbOwnerType type = getOwnerType();
        if ( type == null )
            return null;

        return composeMessageHtmlFor(type, template);
    }

    private String composeMessageHtmlFor(MyBlurbOwnerType type, MyBlurb template)
    {
        switch ( type )
        {
            case Project:
                return composeMessageHtmlFor(findProject(), template);

            case Site:
                return composeMessageHtmlFor(findSite(), template);
        }
        throw Kmu.newEnumError(type);
    }

    private String composeMessageHtmlFor(MyProject project, MyBlurb template)
    {
        MyMacroDocumentFormatter f;
        f = new MyMacroDocumentFormatter();
        f.setContext(project);

        return f.formatHtml(template.getMessageHtml());
    }

    private String composeMessageHtmlFor(MySite site, MyBlurb template)
    {
        MyMacroDocumentFormatter f;
        f = new MyMacroDocumentFormatter();
        f.setContext(site);
        return f.formatHtml(template.getMessageHtml());
    }

    //##################################################
    //# support
    //##################################################

    private MyGlobals getGlobals()
    {
        return MyGlobals.instance;
    }

    private MyDaoAccess getAccess()
    {
        return getGlobals().getAccess();
    }
}
