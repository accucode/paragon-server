/*
  Copyright (c) 2005-2011 www.kodemore.com

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

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FilenameUtils;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.json.KmJsonObject;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.script.ScActionScript;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.script.ScScript;
import com.kodemore.servlet.utility.ScJquery;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;

import com.app.ui.servlet.ScServletCallback;
import com.app.ui.servlet.ScServletCallbackRegistry;


public class ScDropzone
    extends ScControl
    implements ScHtmlIdIF
{
    //##################################################
    //# variables
    //##################################################

    /**
     * If true, uploaded items will display a 'remove file'
     * or 'cancel upload' button.
     */
    private ScLocalBoolean            _showsRemoveLinks;

    private ScDropzoneUploadHandlerIF _uploadHandler;
    private ScActionIF                _removeAction;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _showsRemoveLinks = new ScLocalBoolean(false);
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.openForm();
        out.printAttribute("action", "");
        out.printAttribute("id", getKey());
        out.printAttribute("class", "dropzone");
        out.close();

        out.endForm();

        ScScript ajax;
        ajax = out.getPostRender();
        ajax.run(formatScript());
    }

    private String formatScript()
    {
        KmStringBuilder out;
        out = new KmStringBuilder();

       
        out.printfln(
            "Dropzone.options.%s = { init: function() { this.on('removedfile', function(file) { %s }); } };",
            getKey(),
            formatOnRemoveAction());

       
        
        

        out.printfln("%s.dropzone(%s);", formatJqueryReference(), formatOptions());

        return out.toString();
    }

    private String formatOnRemoveAction()
    {
        ScActionIF action = getRemoveAction();
        Object arg = null;
        ScForm form = null;
        Object model = null;
        ScHtmlIdIF block = null;

        ScActionScript s;
        s = new ScActionScript();
        s.setAction(action);
        s.setArgument(arg);
        s.setForm(form);
        s.setModel(model);
        s.setBlockTarget(block);
        return s.formatScript();
    }

    //##################################################
    //# remove action
    //##################################################

    public ScActionIF getRemoveAction()
    {
        return _removeAction;
    }

    public void setRemoveAction(ScActionIF uploadAction)
    {
        _removeAction = uploadAction;
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
    public String formatJquerySelector()
    {
        return ScJquery.formatSelector(this);
    }

    @Override
    public String formatJqueryReference()
    {
        return ScJquery.formatReference(this);
    }

    @Override
    public ScHtmlIdAjax ajax()
    {
        return new ScHtmlIdAjax(this);
    }

    //##################################################
    //# dropzone options
    //##################################################

    private KmJsonObject formatOptions()
    {
        KmJsonObject map;
        map = new KmJsonObject();

        setupRequestUrl(map);
        setupOptions(map);

        return map;
    }

    private void setupRequestUrl(KmJsonObject map)
    {
        map.setString("url", formatRequestUrl());
        map.setString("method", "post");
    }

    private void setupOptions(KmJsonObject map)
    {
        if ( getShowsRemoveLinks() )
            map.setString("addRemoveLinks", "true");
    }

    private String formatRequestUrl()
    {
        ScServletCallbackRegistry r = ScServletCallbackRegistry.getInstance();
        ScServletCallback c = r.getDropzoneCallback();
        return c.getPath(getKey());
    }

    //##################################################
    //# accessing
    //##################################################

    private boolean getShowsRemoveLinks()
    {
        return _showsRemoveLinks.getValue();
    }

    public void setShowsRemoveLink(boolean b)
    {
        _showsRemoveLinks.setValue(b);
    }

    public void showRemoveLinks()
    {
        setShowsRemoveLink(true);
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

            for ( FileItem e : files )
            {
                String fileName = FilenameUtils.getName(e.getName());
                InputStream is = e.getInputStream();

                byte[] data;
                data = Kmu.readBytesFrom(is);
                Kmu.closeSafely(is);

                getUploadHandler().handleUpload(fileName, data);
            }
        }
        catch ( IOException ex )
        {
            ex.printStackTrace();
        }
    }
}
