package com.app.ui.page.crud.blurb;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.control.ScTransientDiv;
import com.kodemore.servlet.field.ScDynamicEnumDropdownField;
import com.kodemore.servlet.field.ScRichTextEditor;
import com.kodemore.servlet.field.ScTextField;

import com.app.criteria.MyBlurbCriteria;
import com.app.macro.MyMacroContextType;
import com.app.macro.MyMacroDocumentFormatter;
import com.app.model.MyBlurb;
import com.app.model.MyProject;
import com.app.model.base.MyBlurbOwnerType;
import com.app.model.meta.MyMetaBlurb;
import com.app.ui.macro.MyMacroDialog;
import com.app.ui.page.crud.abstractBase.MyCrudEditCard;
import com.app.ui.page.crud.abstractBase.MyCrudLayout;

public class MyBlurbEditCard
    extends MyCrudEditCard<MyBlurb>
{
    //##################################################
    //# variables
    //##################################################

    private ScTextField                _nameField;
    private ScDynamicEnumDropdownField _contextTypeField;

    private ScRichTextEditor _messageField;

    private ScFieldset     _previewSet;
    private ScTransientDiv _messagePreview;

    private MyMacroDialog _macroDialog;

    //##################################################
    //# constructor
    //##################################################

    public MyBlurbEditCard()
    {
        super(new MyBlurbBuilder());
    }

    public MyBlurbEditCard(MyBlurbBuilder e)
    {
        super(e);
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected MyCrudLayout getDetailLayout()
    {
        return MyCrudLayout.fill;
    }

    @Override
    protected void installDetailsOn(ScDiv col)
    {
        col.css().flexColumn().columnSpacer20().clip();

        installGeneralOn(col);
        installTemplateRowOn(col);
        installMacroDialog();
    }

    private void installGeneralOn(ScDiv root)
    {
        ScFieldset set;
        set = root.addFieldset("General");
        set.css().flexChildStatic().clip();

        ScFieldTable fields;
        fields = set.addFullWidthFieldTable();
        fields.css().widthFull();
        fields.add(createNameField());
        fields.add(createTypeField());
    }

    private void installTemplateRowOn(ScDiv root)
    {
        ScDiv row;
        row = root.addDiv();
        row.css().flexRow().rowSpacer20().flexChildFiller();

        installTemplatesOn(row);
        installPreviewsOn(row);
    }

    private void installTemplatesOn(ScDiv root)
    {
        ScFieldset set;
        set = root.addFieldset("Template");
        set.css().flexChildFiller0().relative().clip();

        ScDiv col;
        col = set.addDiv();
        col.css().flexColumn().fieldsetFillOffset10();
        col.add(createButtons());
        col.addLabel("Message");

        ScDiv msgWrapper;
        msgWrapper = col.addDiv();
        msgWrapper.css().flexChildFiller().relative();
        msgWrapper.add(createMessageField());
    }

    private void installPreviewsOn(ScDiv root)
    {
        ScFieldset set;
        set = root.addFieldset("Preview");
        set.css().flexChildFiller0().relative().clip();
        _previewSet = set;

        ScDiv col;
        col = set.addDiv();
        col.css().flexColumn().fieldsetFillOffset10();
        col.addRefreshButton(newUncheckedAction(this::handleRefreshPreview));
        col.addFlexGap(20);
        col.add(createMessagePreview());
    }

    //==================================================
    //= install :: fields
    //==================================================

    private ScControl createNameField()
    {
        MyMetaBlurb x = MyBlurb.Meta;

        ScTextField e;
        e = x.Name.newField();
        e.setWidthFull();
        _nameField = e;
        return e;
    }

    private ScControl createTypeField()
    {
        MyMetaBlurb x = MyBlurb.Meta;

        ScDynamicEnumDropdownField e;
        e = new ScDynamicEnumDropdownField();
        e.setLabel("Type");
        e.setEnumListSupplier(MyBlurbOwnerType::getValues);
        e.setNullSelectPrefix();
        e.setValueAdaptor(x.OwnerTypeCode);
        e.setRequired();
        e.setHelp(x.OwnerTypeCode);
        _contextTypeField = e;
        return e;
    }

    private ScRichTextEditor createMessageField()
    {
        MyMetaBlurb x = MyBlurb.Meta;

        ScRichTextEditor e;
        e = new ScRichTextEditor();
        e.setValueAdaptor(x.MessageHtml);
        e.setFill();
        _messageField = e;
        return e;
    }

    private ScTransientDiv createMessagePreview()
    {
        ScTransientDiv e;
        e = new ScTransientDiv();
        e.css().flexChildFiller0().auto();
        _messagePreview = e;
        return e;
    }

    //==================================================
    //= install :: buttons
    //==================================================

    private ScDiv createButtons()
    {
        ScAction macroAction = newUncheckedAction(this::handleOpenMacros);
        ScAction previewAction = newUncheckedAction(this::handleTogglePreview);

        ScDiv div;
        div = new ScDiv();
        div.css().flexRow().rowSpacer5().flexAlignEnd();
        div.addButton("Macros", macroAction);
        div.addButton("Toggle Preview", previewAction);

        return div;
    }

    //==================================================
    //= install :: dialog
    //==================================================

    private void installMacroDialog()
    {
        MyMacroDialog e;
        e = new MyMacroDialog();
        _macroDialog = e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRenderDetails(MyBlurb child)
    {
        super.preRenderDetails(child);
        updatePreview();
    }

    //##################################################
    //# handle
    //##################################################

    private void handleRefreshPreview()
    {
        updatePreview();
        _messagePreview.ajaxReplace();
    }

    private void handleOpenMacros()
    {
        _macroDialog.ajaxOpen(getMacroContextType());
    }

    private void handleTogglePreview()
    {
        updatePreview();
        _messagePreview.ajaxReplace();
        _previewSet.ajaxToggle();
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        super.validate();
        validateName();
    }

    private void validateName()
    {
        ScTextField field = _nameField;
        if ( field.hasErrors() )
            return;

        MyBlurb template = getDomainChild();
        MyProject project = template.getProject();
        String name = field.getValue();

        MyBlurbCriteria c;
        c = getAccess().getBlurbDao().createCriteria();
        c.whereProjectIs(project);
        c.whereName().is(name);
        c.whereUid().isNot(template.getUid());

        boolean dup = c.exists();
        if ( dup )
            field.addError("Duplicate.");
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected void saveDomainChild(MyBlurb e)
    {
        e.applyFrom(this);
    }

    //##################################################
    //# support
    //##################################################

    private String formatHtml(String s)
    {
        return getTemplateFormatter().formatHtml(s);
    }

    private MyMacroDocumentFormatter getTemplateFormatter()
    {
        String code = _contextTypeField.getValue();

        MyBlurbOwnerType blurbContext = MyBlurbOwnerType.findCode(code);
        MyMacroContextType macroContext = blurbContext.toMacroContextType();

        MyMacroDocumentFormatter f;
        f = new MyMacroDocumentFormatter();
        f.setSampleContext(macroContext);
        return f;
    }

    private void updatePreview()
    {
        String msg = formatHtml(_messageField.getValue());
        _messagePreview.addLiteral().setValue(msg);
    }

    private MyMacroContextType getMacroContextType()
    {
        return getTemplateFormatter().getContextType();
    }
}
