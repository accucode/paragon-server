package com.app.ui.activity.tools;

import com.kodemore.collection.KmList;
import com.kodemore.file.KmFile;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScArray;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScGroupArray;
import com.kodemore.servlet.field.ScListField;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.utility.Kmu;

import com.app.file.MySharedFiles;

public class MySharedFileBrowserPage
    extends MyAbstractToolsPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MySharedFileBrowserPage instance = new MySharedFileBrowserPage();

    private MySharedFileBrowserPage()
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
    //# install
    //##################################################

    @Override
    protected ScControl installRoot()
    {
        ScForm root;
        root = new ScForm();
        root.setDefaultAction(newFindDirectoryAction());

        installPath(root);

        ScGroupArray row;
        row = root.addGroupArray();

        installFolders(row);
        installFiles(row);

        return root;
    }

    private void installPath(ScForm root)
    {
        _directoryField = new ScTextField();
        _directoryField.setLabel("Directory");
        _directoryField.setValue("/");

        ScGroup group = root.addGroup("Path");

        ScArray row;
        row = group.addRow();
        row.add(_directoryField);
        row.addSubmitButton("Open");

        group.addLink("Create", newCreatePathAction());
    }

    private void installFolders(ScGroupArray root)
    {
        _folderList = new ScListField();

        ScGroup group;
        group = root.addGroup("Folders");
        group.add(_folderList);
        group.addLink("Open", newOpenFolderAction());
    }

    private void installFiles(ScGroupArray root)
    {
        _fileList = new ScListField();

        ScGroup group;
        group = root.addGroup("Files");
        group.add(_fileList);
        group.addLink("Get", newGetFileAction());
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
    //# start
    //##################################################

    @Override
    public void start()
    {
        preRenderFolders();
        preRenderFiles();
        print();
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
        //        print();
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
    }

    private void handleOpenFolder()
    {
        String path = _folderList.getStringValue();
        if ( Kmu.isEmpty(path) )
            error("No folder selected.");

        open(getFile(path));
        //        print();
    }

    private void handleGetFile()
    {
        String path = _fileList.getStringValue();
        if ( Kmu.isEmpty(path) )
            error("No file selected.");

        KmFile file = getFile(path);
        String s = file.readString();
        getData().setAttachmentResult(file.getName(), s);
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
