/*
  Copyright (c) 2005-2014 www.kodemore.com

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
import com.kodemore.json.KmJsonMap;
import com.kodemore.log.KmLog;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.script.ScActionScript;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.utility.ScJquery;
import com.kodemore.servlet.utility.ScServletCallback;
import com.kodemore.servlet.utility.ScServletCallbackRegistry;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.utility.Kmu;

public class ScDropzone
    extends ScControl
    implements ScHtmlIdIF
{
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
     * This is true by default.
     */
    private ScLocalBoolean            _showsRemoveButtons;

    /**
     * This is called when the user clicks the remove/cancel button on an uploaded file.
     * This can be left null, even if the the remove/cancel buttons are displayed.
     * Setting this action is largely pointless since it only notifies the server-side
     * that the user removed/cancelled an upload, but doesn't tell the server WHICH file
     * was removed/cancelled.
     */
    private ScActionIF                _removeAction;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _showsRemoveButtons = new ScLocalBoolean(true);
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.openForm();
        out.printAttribute("action", "");
        out.printAttribute("id", getHtmlId());
        out.printAttribute("class", "dropzone");
        out.close();
        out.endForm();

        ScBlockScript script;
        script = out.getPostDom();
        script.run("$('%s').dropzone(%s);", getJquerySelector(), getOptions());
    }

    //##################################################
    //# remove action
    //##################################################

    public ScActionIF getRemoveAction()
    {
        return _removeAction;
    }

    public void setRemoveAction(ScActionIF e)
    {
        _removeAction = e;
    }

    public boolean hasRemoveAction()
    {
        return getRemoveAction() != null;
    }

    //##################################################
    //# html id
    //##################################################

    @Override
    public String getHtmlId()
    {
        return getKey();
    }

    @Override
    public String getJquerySelector()
    {
        return ScJquery.formatSelector(this);
    }

    @Override
    public ScHtmlIdAjax ajax()
    {
        return new ScHtmlIdAjax(this, getRootScript());
    }

    //##################################################
    //# options
    //##################################################

    private KmJsonMap getOptions()
    {
        KmJsonMap map;
        map = new KmJsonMap();
        map.setString("url", formatRequestUrl());
        map.setString("method", "post");

        if ( getShowsRemoveButtons() )
            map.setBoolean("addRemoveLinks", true);

        if ( hasRemoveAction() )
        {
            String fn = Kmu.format(
                "function(){this.on('removedfile',function(file){%s})}",
                formatOnRemoveAction());
            map.setLiteral("init", fn);
        }

        return map;
    }

    private String formatRequestUrl()
    {
        ScServletCallbackRegistry r = ScServletCallbackRegistry.getInstance();
        ScServletCallback c = r.getDropzoneCallback();
        return c.getPath(getKey());
    }

    private String formatOnRemoveAction()
    {
        ScActionScript s;
        s = new ScActionScript();
        s.setAction(getRemoveAction());
        return s.formatScript();
    }

    //##################################################
    //# accessing
    //##################################################

    private boolean getShowsRemoveButtons()
    {
        return _showsRemoveButtons.getValue();
    }

    public void setShowsRemoveButtons(boolean b)
    {
        _showsRemoveButtons.setValue(b);
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
    //# servlet callback
    //##################################################

    public static void handleServletCallback(String pathSuffix)
    {
        ScDropzone dz = findDropzoneForPath(pathSuffix);
        if ( dz != null )
            dz.handlePost();
    }

    private static ScDropzone findDropzoneForPath(String suffix)
    {
        /*
         * We assume the pathSuffix is the control's key since that is
         * what we provided when composing the url.  See formatRequestUrl().
         */
        String key = suffix;
        if ( Kmu.isEmpty(key) )
            return null;

        ScControl c = getRegistry().getControl(key);
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
                try ( BufferedInputStream in = Kmu.toBufferedInputStream(item.getInputStream()) )
                {
                    String fileName = FilenameUtils.getName(item.getName());
                    byte[] data = Kmu.readBytesFrom(in);

                    getUploadHandler().upload(fileName, data);
                }
        }
        catch ( IOException ex )
        {
            KmLog.error(ex, "Dropzone upload failure.");
        }
    }
}
