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

package com.kodemore.servlet.control;

import java.io.BufferedInputStream;
import java.io.IOException;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FilenameUtils;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.KmStyleBuilder;
import com.kodemore.json.KmJsonMap;
import com.kodemore.json.KmJsonReader;
import com.kodemore.log.KmLog;
import com.kodemore.meta.KmMetaAttribute;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.encoder.ScDecoder;
import com.kodemore.servlet.field.ScHiddenField;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.script.ScActionScript;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.script.ScVisibilityScript;
import com.kodemore.servlet.utility.ScControlRegistry;
import com.kodemore.servlet.utility.ScServletCallback;
import com.kodemore.servlet.utility.ScServletCallbackRegistry;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalStyle;
import com.kodemore.utility.Kmu;

public class ScDropzone
    extends ScControl
    implements ScHtmlIdIF
{
    //##################################################
    //# constants
    //##################################################

    private static final String KEY    = "key";
    private static final String FIELDS = "fields";

    //##################################################
    //# variables
    //##################################################

    /**
     * The callback that is responsible for processing the server-side
     * file once the upload has completed.
     */
    private ScDropzoneUploadHandlerIF _uploadHandler;

    /**
     * If true, uploaded items will display a 'remove file' or 'cancel upload' button.
     * This really just removes the item from the client-side display.  There is no
     * support for removing the file from the server.  See also _removeAction.
     * This is false by default.
     */
    private ScLocalBoolean _showsRemoveButtons;

    /**
     * This is called when the user clicks the remove/cancel button on an uploaded file.
     * This can be left null, even if the the remove/cancel buttons are displayed.
     * Setting this action is largely pointless since it only notifies the server-side
     * that the user removed/cancelled an upload, but doesn't tell the server WHICH file
     * was removed/cancelled.
     */
    private ScAction _removeAction;

    /**
     * This action is run when client finishes uploading the queued files.
     */
    private ScAction _doneAction;

    /**
     * This can be optionally set to limit the number of files uploaded.
     */
    private ScLocalBoolean _singleFile;

    /**
     * A container for any hidden fields to be tracked.
     * The value of each hidden field is encoded into the browser
     * and subsequently included during the upload.  This allows
     * clients to easily attach additional context so that they
     * know how to handle the uploaded file.
     *
     * Wyatt Love, 2/25/2016
     * This is currently a kludge.  As of the current dropzone
     * version 4.3.0, there are three ways to support this.
     *
     * 1) Using hidden fields in the html form; doesn't work.
     * 2) Using dropzone's 'params' option; doesn't work.
     * 3) Manually encoding the details into the url.
     *
     * Either of the first two would have been preferable but they
     * don't appear to work at this time. Review on the web indicates
     * that many other people are having the same problem. For now
     * we simply encode the hidden fields into the url manually.
     * We don't expect to use this very often, or to need a lot of
     * fields, so this should be sufficient.
     */
    private ScContainer _hiddenFields;

    private ScLocalStyle _style;

    //##################################################
    //# constructor
    //##################################################

    public ScDropzone()
    {
        _showsRemoveButtons = new ScLocalBoolean(false);
        _singleFile = new ScLocalBoolean(false);
        _hiddenFields = new ScSimpleContainer();
        _style = new ScLocalStyle();
    }

    //##################################################
    //# accessing :: html id
    //##################################################

    @Override
    public String getHtmlId()
    {
        return getKeyToken();
    }

    @Override
    public ScHtmlIdAjax _htmlIdAjax()
    {
        return ScHtmlIdAjax.createOnRoot(this);
    }

    //==================================================
    //= accessing :: remove buttons
    //==================================================

    private boolean getShowsRemoveButtons()
    {
        return _showsRemoveButtons.getValue();
    }

    public void setShowsRemoveButtons(boolean b)
    {
        _showsRemoveButtons.setValue(b);
    }

    //==================================================
    //= accessing :: remove action
    //==================================================

    public ScAction getRemoveAction()
    {
        return _removeAction;
    }

    public void setRemoveAction(ScAction e)
    {
        _removeAction = e;
    }

    public boolean hasRemoveAction()
    {
        return getRemoveAction() != null;
    }

    //==================================================
    //= accessing :: done action
    //==================================================

    public ScAction getDoneAction()
    {
        return _doneAction;
    }

    public void setDoneAction(ScAction e)
    {
        _doneAction = e;
    }

    public boolean hasDoneAction()
    {
        return _doneAction != null;
    }

    //==================================================
    //= accessing :: single file
    //==================================================

    public boolean getSingleFile()
    {
        return _singleFile.getValue();
    }

    public void setSingleFile(boolean e)
    {
        _singleFile.setValue(e);
    }

    public void setSingleFile()
    {
        setSingleFile(true);
    }

    public boolean isSingleFile()
    {
        return getSingleFile();
    }

    //##################################################
    //# hidden fields
    //##################################################

    public <E> ScHiddenField<E> addHiddenField()
    {
        return _hiddenFields.addHiddenField();
    }

    public <E> ScHiddenField<E> addHiddenField(KmMetaAttribute<?,E> attr)
    {
        return _hiddenFields.addHiddenField(attr);
    }

    //##################################################
    //# upload handler
    //##################################################

    public ScDropzoneUploadHandlerIF getUploadHandler()
    {
        return _uploadHandler;
    }

    public void setUploadHandler(ScDropzoneUploadHandlerIF handler)
    {
        _uploadHandler = handler;
    }

    public boolean hasUploadHandler()
    {
        return _uploadHandler != null;
    }

    //##################################################
    //# style
    //##################################################

    private KmStyleBuilder style()
    {
        return _style.toBuilder();
    }

    @Override
    public boolean isVisible()
    {
        return !style().hasHide();
    }

    @Override
    public void setVisible(boolean e)
    {
        style().show(e);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.openForm();
        out.printAttribute("action", formatCallbackUrl());
        out.printAttribute("id", getHtmlId());
        out.printAttribute("class", "dropzone");
        out.printAttribute(style());
        out.printAttribute("enctype", "multipart/form-data");
        out.printAttribute("method", "post");
        out.close();
        out.endForm();

        ScBlockScript script;
        script = out.getPostDom();
        script.run("%s.dropzone(%s);", getJqueryReference(), composeOptions());
    }

    //==================================================
    //= render :: options
    //==================================================

    private KmJsonMap composeOptions()
    {
        KmJsonMap map = new KmJsonMap();
        composeUrlOn(map);
        composeMaxFilesOn(map);
        composeRemoveButtonsOn(map);
        composeRemoveActionOn(map);
        composeInitOn(map);
        return map;
    }

    private void composeUrlOn(KmJsonMap map)
    {
        String url = formatCallbackUrl();

        map.setString("url", url);
        map.setString("method", "post");
    }

    private String formatCallbackUrl()
    {
        String encodedSuffix = formatCallbackSuffix();

        ScServletCallbackRegistry r = ScServletCallbackRegistry.getInstance();
        ScServletCallback c = r.getDropzoneCallback();
        return c.getPath(encodedSuffix);
    }

    private void composeMaxFilesOn(KmJsonMap map)
    {
        if ( isSingleFile() )
            map.setInteger("maxFiles", 1);
    }

    private void composeRemoveButtonsOn(KmJsonMap map)
    {
        if ( getShowsRemoveButtons() )
            map.setBoolean("addRemoveLinks", true);
    }

    private void composeRemoveActionOn(KmJsonMap map)
    {
        if ( !hasRemoveAction() )
            return;

        ScActionScript s;
        s = new ScActionScript();
        s.setAction(getRemoveAction());

        String fn = Kmu.format(
            "function(){this.on('removedfile',function(file){%s})}",
            s.formatScript());

        map.setLiteral("init", fn);
    }

    private void composeInitOn(KmJsonMap map)
    {
        String s = formatInitScript();
        if ( s.isEmpty() )
            return;

        String fn = Kmu.format("function(){%s}", s);
        map.setLiteral("init", fn);
    }

    private String formatInitScript()
    {
        return formatDoneScript() + formatSingleFileScript();
    }

    private String formatDoneScript()
    {
        if ( !hasDoneAction() )
            return "";

        ScActionScript script;
        script = new ScActionScript();
        script.setAction(getDoneAction());

        return Kmu.format("this.on('queuecomplete', function(){%s});", script);
    }

    private String formatSingleFileScript()
    {
        return isSingleFile()
            ? "this.hiddenFileInput.removeAttribute('multiple');"
            : "";
    }

    //##################################################
    //# callback suffix
    //##################################################

    /**
     * Format a url compatible suffix that contains the information
     * necessary to subsquently handle the uploaded file.
     *
     * The suffix includes the control's key as well as the details
     * of any hidden fields.  This must be compatible with
     * handleCallbackSuffix.
     *
     * @see #handleCallbackSuffix
     */
    private String formatCallbackSuffix()
    {
        KmJsonMap map;
        map = new KmJsonMap();
        map.setInteger(KEY, getKey());

        KmJsonMap fields;
        fields = map.setMap(FIELDS);

        KmList<ScControl> v = _hiddenFields.getChildren();
        for ( ScControl c : v )
        {
            ScHiddenField<?> h = (ScHiddenField<?>)c;

            String token = h.getKeyToken();
            String value = encode(h.getValue());
            fields.setString(token, value);
        }

        String decodedSuffix = map.toString();
        return Kmu.encodeUtf8(decodedSuffix);
    }

    /**
     * Handle an http request.  The callback has already isolated
     * the suffix that contains the pertinent details that were
     * originally encoded in formatCallbackSuffix.
     *
     * @see #formatCallbackSuffix
     */
    public static void handleServletCallback(String suffix)
    {
        ScControlRegistry r = ScControlRegistry.getInstance();
        String decodedSuffix = Kmu.decodeUtf8(suffix);
        KmJsonMap map = KmJsonReader.parseJsonMap(decodedSuffix);
        KmJsonMap fields = map.getMap("fields");
        KmList<String> tokens = fields.getKeys();

        for ( String token : tokens )
        {
            String encodedValue = fields.getString(token);
            Object value = ScDecoder.staticDecode(encodedValue);

            ScHiddenField<?> hidden;
            hidden = (ScHiddenField<?>)r.findToken(token);
            hidden.setValueUntyped(value);
        }

        Integer key = map.getInteger(KEY);
        ScDropzone dz = findDropzoneForKey(key);
        if ( dz != null )
            dz.handlePost();
    }

    private static ScDropzone findDropzoneForKey(Integer key)
    {
        if ( key == null )
            return null;

        ScControl c = getRegistry().findKey(key);
        if ( !(c instanceof ScDropzone) )
            return null;

        return (ScDropzone)c;
    }

    //##################################################
    //# handle upload
    //##################################################

    private void handlePost()
    {
        if ( hasUploadHandler() )
            tryHandleUpload();
    }

    private void tryHandleUpload()
    {
        try
        {
            KmList<FileItem> files = getData().getUploadedFiles();
            for ( FileItem item : files )
                try (BufferedInputStream in = Kmu.toBufferedInputStream(item.getInputStream()))
                {
                    String itemName = item.getName();
                    if ( itemName == null )
                    {
                        KmLog.info("Dropzone cannot upload file, itemName is null.");
                        break;
                    }

                    String fileName = FilenameUtils.getName(itemName);
                    if ( fileName == null )
                    {
                        KmLog.info("Dropzone cannot upload file, fileName is null.");
                        break;
                    }

                    byte[] data = Kmu.readBytesFrom(in);
                    getUploadHandler().upload(fileName, data);
                }
        }
        catch ( IOException ex )
        {
            KmLog.error(ex, "Dropzone upload failure.");
        }
    }

    //##################################################
    //# ajax
    //##################################################

    @Override
    public ScVisibilityScript ajaxShow(boolean e)
    {
        return _htmlIdAjax().show(e);
    }

}
