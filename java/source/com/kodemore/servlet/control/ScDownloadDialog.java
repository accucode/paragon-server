package com.kodemore.servlet.control;

import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.servlet.utility.ScUrlBridge;

/**
 * I am a prestyled dialog used for downloading files.
 * In addition to the standard dialog title, clients may
 * easily set my subtitle, and message.
 */
public class ScDownloadDialog
    extends ScFormDialog
{
    //##################################################
    //# singleton
    //##################################################

    private static ScDownloadDialog _instance;

    public static void installInstance()
    {
        _instance = new ScDownloadDialog();
    }

    public static final ScDownloadDialog getInstance()
    {
        return _instance;
    }

    private ScDownloadDialog()
    {
        install();
    }

    //##################################################
    //# variables
    //##################################################

    private ScScriptButton _downloadButton;
    private ScTextSpan     _fileText;

    //##################################################
    //# install
    //##################################################

    private void install()
    {
        ScFormDialog dialog;
        dialog = this;
        dialog.setLabel("Download File");
        dialog.setFlavorCaution();
        dialog.setCloseOnEscape(true);

        ScDiv body;
        body = dialog.getBody();
        body.css().flexColumn().columnSpacer20().pad20();
        body.add(createSubtitle());
        body.add(createMessage());
        body.add(createFileText());

        ScDiv footer;
        footer = dialog.showFooter().addButtonBox();
        footer.add(createDownloadButton());
        footer.addCancelButton(footer.newUncheckedAction(this::ajaxClose)).setAutoFocus();
    }

    private ScControl createSubtitle()
    {
        ScTextSpan e;
        e = new ScTextSpan();
        e.setValue("Your download is ready.");
        e.css().bold();
        return e;
    }

    public ScControl createMessage()
    {
        String msg = ""
            + "Click the 'Download & Close' button to begin the download.\n"
            + "The download will be saved as: ";

        ScTextSpan e;
        e = new ScTextSpan();
        e.setValue(msg);
        return e;
    }

    public ScControl createFileText()
    {
        ScTextSpan e;
        e = new ScTextSpan();
        e.css().marginLeft50().bold();
        _fileText = e;
        return e;
    }

    private ScControl createDownloadButton()
    {
        ScScriptButton e;
        e = new ScScriptButton();
        e.setFlavorPositive();
        e.setIcon().nameDone().styleLight();
        e.setText("Download & Close");
        _downloadButton = e;
        return e;
    }

    //##################################################
    //# ajax
    //##################################################

    public void ajaxOpenFor(String filename, CharSequence value)
    {
        byte[] bytes = value.toString().getBytes();
        ajaxOpenFor(filename, bytes);
    }

    public void ajaxOpenFor(String filename, byte[] value)
    {
        String url = ScUrlBridge.getInstance().createDownloadFor(filename, value);

        preRenderMessage(filename);
        preRenderDownloadButton(url);
        ajaxOpen();
    }

    private void preRenderMessage(String filename)
    {
        _fileText.setValue(filename);
    }

    private void preRenderDownloadButton(String url)
    {
        ScBlockScript s;
        s = ScBlockScript.create();
        s.run("window.location='%s';", url);
        s.closeDialog(this);

        _downloadButton.setScript(s);
    }

}
