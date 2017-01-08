package com.app.ui.page.tools;

import com.kodemore.collection.KmList;
import com.kodemore.file.KmFile;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScListField;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.utility.Kmu;

import com.app.file.MySharedFiles;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyDevSharedFileBrowserPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyDevSharedFileBrowserPage _instance;

    public static void installInstance()
    {
        _instance = new MyDevSharedFileBrowserPage();
    }

    public static MyDevSharedFileBrowserPage getInstance()
    {
        return _instance;
    }

    private MyDevSharedFileBrowserPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScTextField         _directoryField;
    private ScListField<String> _folderList;
    private ScListField<String> _fileList;

    //##################################################
    //# settings
    //##################################################

    @Override
    public final MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.developer;
    }

    //##################################################
    //# bookmark
    //##################################################

    @Override
    public void composeBookmarkOn(ScParameterList v)
    {
        // none
    }

    @Override
    public void applyBookmark(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().fill().auto().columnSpacer10();

        ScForm form;
        form = root.addForm();
        form.setSubmitAction(this::handleFind);

        installPath(form);
        installFolders(form);
        installFiles(form);
    }

    private void installPath(ScForm root)
    {
        _directoryField = new ScTextField();
        _directoryField.setLabel("Directory");
        _directoryField.setValue("/");
        _directoryField.disableChangeTracking();

        ScGroup group;
        group = root.addGroup("Path");

        ScDiv body;
        body = group.getBody().addPad();

        ScDiv row;
        row = body.addFlexRow();
        row.add(_directoryField);
        row.addNonBreakingSpace();
        row.addSubmitButton("Open");

        body.addLink("Create", this::handleCreatePath);
    }

    private void installFolders(ScContainer root)
    {
        _folderList = new ScListField<>();
        _folderList.disableChangeTracking();

        ScGroup group;
        group = root.addGroup("Folders");

        ScDiv body;
        body = group.getBody().addPad();
        body.add(_folderList);
        body.addLink("Open", this::handleOpenFolder);
    }

    private void installFiles(ScContainer root)
    {
        _fileList = new ScListField<>();
        _fileList.disableChangeTracking();

        ScGroup group;
        group = root.addGroup("Files");

        ScDiv body;
        body = group.getBody().addPad();
        body.add(_fileList);
        body.addLink("Get", this::handleGetFile);
    }

    //##################################################
    //# print
    //##################################################

    @Override
    public void preRender()
    {
        preRenderFolders();
        preRenderFiles();
    }

    private void preRenderFolders()
    {
        KmFile dir = getDirectory();
        if ( !dir.exists() )
            return;

        if ( dir.hasParent() )
            _folderList.addOption(dir.getParent().getPath(), "..");

        for ( KmFile file : dir.getFolders() )
            _folderList.addOption(file.getPath(), file.getName());
    }

    private void preRenderFiles()
    {
        KmFile dir = getDirectory();
        if ( !dir.exists() )
            return;

        KmList<KmFile> files = dir.getFiles();
        for ( KmFile file : files )
            _fileList.addOption(file.getPath(), file.getName());
    }

    //##################################################
    //# handle
    //##################################################

    private void handleFind()
    {
        open(getDirectory());
        ajaxPrint();
    }

    private void handleCreatePath()
    {
        KmFile dir = getDirectory();

        if ( dir.exists() )
            _directoryField.error("Already exists.");

        if ( dir.createFolder() )
            _directoryField.error("Cannot create directory.");
        Object[] args = {};

        ajax().toast("Created Directory: " + dir, args);
        ajaxPrint();
    }

    private void handleOpenFolder()
    {
        String path = _folderList.getValue();
        if ( Kmu.isEmpty(path) )
            throw Kmu.newError("No folder selected.");

        open(getFile(path));
        ajaxPrint();
    }

    private void handleGetFile()
    {
        String path = _fileList.getValue();
        if ( Kmu.isEmpty(path) )
            throw Kmu.newError("No file selected.");

        KmFile file = getFile(path);
        byte[] bytes = file.readBytes();
        ajax().download(file.getName(), bytes);
    }

    //##################################################
    //# support
    //##################################################

    private KmFile getDirectory()
    {
        return getFile(_directoryField.getValue());
    }

    private void open(KmFile dir)
    {
        if ( !dir.exists() )
            throw Kmu.newError("Does not exist: " + dir);

        if ( !dir.isFolder() )
            throw Kmu.newError("Not a directory.");

        _directoryField.setValue(dir.getPath());
    }

    private KmFile getFile(String path)
    {
        KmFile root;
        root = MySharedFiles.getInstance().getPersistentRootFolder();

        return root.getChild(path);
    }
}
