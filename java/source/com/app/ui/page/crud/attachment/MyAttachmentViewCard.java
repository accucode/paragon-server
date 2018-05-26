package com.app.ui.page.crud.attachment;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScImage;
import com.kodemore.servlet.control.ScLink;
import com.kodemore.servlet.control.ScObjectControl;
import com.kodemore.servlet.control.ScTextParagraph;
import com.kodemore.servlet.control.layout.ScLayout;
import com.kodemore.utility.Kmu;

import com.app.model.MyAttachment;
import com.app.model.base.MyAttachmentType;
import com.app.model.meta.MyMetaAttachment;
import com.app.ui.page.crud.abstractBase.MyCrudViewCard;

public class MyAttachmentViewCard
    extends MyCrudViewCard<MyAttachment>
{
    //##################################################
    //# variables
    //##################################################

    private ScLink _downloadLink;

    private ScTextParagraph _textContent;

    private ScDiv   _imageWrapper;
    private ScImage _imageContent;

    private ScObjectControl _pdfContent;

    //##################################################
    //# constructor
    //##################################################

    public MyAttachmentViewCard()
    {
        super(new MyAttachmentBuilder());
    }

    public MyAttachmentViewCard(MyAttachmentBuilder e)
    {
        super(e);
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installBodyOn(ScDiv body)
    {
        ScLayout e;
        e = body.addLayout();
        e.setTypeFieldset();
        e.css().fill().auto();
        e.add(createFieldsSection());
        e.add(createContentSection());
    }

    //==================================================
    //= install :: fields
    //==================================================

    private ScControl createFieldsSection()
    {
        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("Details");
        e.add(createActiveRow());
        e.add(createDownloadLink());
        return e;
    }

    private ScDiv createActiveRow()
    {
        MyMetaAttachment x = MyAttachment.Meta;

        ScDiv e;
        e = new ScDiv();
        e.css().flexRow().rowSpacer5().flexCrossAlignCenter();
        e.setLabel("Enabled");
        e.addFieldText(x.Enabled);
        e.addLink("toggle", newCheckedAction(this::handleToggleEnabled));
        return e;
    }

    private ScControl createDownloadLink()
    {
        ScLink e;
        e = new ScLink();
        e.setLabel("Download");
        e.setAction(newCheckedAction(this::handleDownload));
        _downloadLink = e;
        return e;
    }

    //==================================================
    //= install :: content
    //==================================================

    private ScControl createContentSection()
    {
        ScDiv e;
        e = new ScDiv();
        e.setLabel("Content");
        e.add(createTextContent());
        e.add(createImageContent());
        e.add(createPdfContent());
        return e;
    }

    private ScControl createTextContent()
    {
        ScTextParagraph e;
        e = new ScTextParagraph();
        e.setLabel("Content");
        e.css().flexChildFiller().auto();
        e.css().backgroundGrayEEE().pad();
        e.hide();
        _textContent = e;
        return e;
    }

    private ScControl createImageContent()
    {
        ScDiv div;
        div = new ScDiv();
        div.css().flexChildFiller();
        div.hide();
        _imageWrapper = div;

        ScImage e;
        e = div.addImage();
        e.css().attachmentImage();
        _imageContent = e;

        return div;
    }

    private ScControl createPdfContent()
    {
        ScObjectControl e;
        e = new ScObjectControl();
        e.setMediaTypePdf();
        e.setAlternateText("PDF Not Supported, try Chrome.");
        e.css().flexChildFiller();
        e.css().backgroundGrayEEE();
        e.hide();
        _pdfContent = e;
        return e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRenderDetails(MyAttachment child)
    {
        super.preRenderDetails(child);

        _downloadLink.setText(child.getName());

        MyAttachmentType type = child.getType();
        switch ( type )
        {
            case Text:
                _textContent.setValue(child.getContentString());
                _textContent.show();
                break;

            case Image:
                _imageContent.setSource(child.formatUrl());
                _imageWrapper.show();
                break;

            case Pdf:
                _pdfContent.setDataUrl(child.formatUrl());
                _pdfContent.show();
                break;

            case Other:
                // no inline display
                break;
        }
    }

    //##################################################
    //# handle
    //##################################################

    private void handleToggleEnabled()
    {
        MyAttachment e;
        e = getDomainChild();
        e.toggleEnabled();
        e.validateAndCheck();

        String name = e.getName();
        String enabled = Kmu.formatEnabled(e.isEnabled());

        ajaxReplace();
        ajaxToast("%s in now %s.", name, enabled);
        fireChildChanged(e);
    }

    private void handleDownload()
    {
        MyAttachment child = getDomainChild();
        String name = child.getName();
        byte[] bytes = child.getContentBytes();

        getRootScript().download(name, bytes);
    }
}
