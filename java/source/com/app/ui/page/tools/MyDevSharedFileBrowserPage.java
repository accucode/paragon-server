package com.app.ui.page.tools;

import com.kodemore.collection.KmList;
import com.kodemore.file.KmFile;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScArray;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScListField;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.utility.Kmu;

import com.app.file.MySharedFiles;

public class MyDevSharedFileBrowserPage
    extends MyDevAbstractPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyDevSharedFileBrowserPage instance = new MyDevSharedFileBrowserPage();

    private MyDevSharedFileBrowserPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScTextField _directoryField;
    private ScListField _folderList;
    private ScListField _fileList;

    //##################################################
    //# navigation
    //##################################################

    @Override
    public ScParameterList composeQueryParameters()
    {
        return null;
    }

    @Override
    public void applyQueryParameters(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        ScForm form;
        form = root.addForm();
        form.setSubmitAction(newFindDirectoryAction());
        form.css().gap();

        installPath(form);
        installFolders(form);
        installFiles(form);
    }

    private void installPath(ScForm root)
    {
        _directoryField = new ScTextField();
        _directoryField.setLabel("Directory");
        _directoryField.setValue("/");

        ScGroup group;
        group = root.addGroup("Path");

        ScBox body;
        body = group.addPad();

        ScArray row;
        row = body.addRow();
        row.add(_directoryField);
        row.addSubmitButton("Open");

        body.addLink("Create", newCreatePathAction());
    }

    private void installFolders(ScContainer root)
    {
        _folderList = new ScListField();

        ScGroup group;
        group = root.addGroup("Folders");

        ScBox body;
        body = group.addPad();
        body.add(_folderList);
        body.addLink("Open", newOpenFolderAction());
    }

    private void installFiles(ScContainer root)
    {
        _fileList = new ScListField();

        ScGroup group;
        group = root.addGroup("Files");

        ScBox body;
        body = group.addPad();
        body.add(_fileList);
        body.addLink("Get", newGetFileAction());
    }

    //##################################################
    //# actions
    //##################################################

    private ScActionIF newFindDirectoryAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleFind();
            }
        };
    }

    private ScActionIF newCreatePathAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleCreatePath();
            }
        };
    }

    private ScActionIF newOpenFolderAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleOpenFolder();
            }
        };
    }

    private ScActionIF newGetFileAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleGetFile();
            }
        };
    }

    //##################################################
    //# print
    //##################################################

    @Override
    public void preRender()
    {
        super.preRender();

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
        print();
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
        print();
    }

    private void handleOpenFolder()
    {
        String path = _folderList.getStringValue();
        if ( Kmu.isEmpty(path) )
            error("No folder selected.");

        open(getFile(path));
        print();
    }

    private void handleGetFile()
    {
        String path = _fileList.getStringValue();
        if ( Kmu.isEmpty(path) )
            error("No file selected.");

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
            error("Does not exist: " + dir);

        if ( !dir.isFolder() )
            error("Not a directory.");

        _directoryField.setValue(dir.getPath());
    }

    private KmFile getFile(String path)
    {
        KmFile root;
        root = MySharedFiles.getInstance().getPersistentRootFolder();

        return root.getChild(path);
    }
}
