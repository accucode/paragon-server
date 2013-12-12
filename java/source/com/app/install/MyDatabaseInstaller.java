package com.app.install;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import com.kodemore.collection.KmList;
import com.kodemore.database.KmDatabaseTool;
import com.kodemore.file.KmFile;

import com.app.file.MyResourceFiles;
import com.app.utility.MyEnvironment;
import com.app.utility.MyInstaller;

/**
 * Install the database from scratch.
 * This assumes that the schema already exists.
 */
public class MyDatabaseInstaller
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        new MyDatabaseInstaller().run();
    }

    //##################################################
    //# variables
    //##################################################

    private PrintWriter _out;

    //##################################################
    //# constructor
    //##################################################

    public MyDatabaseInstaller()
    {
        printOnSystemOut();
    }

    //##################################################
    //# install
    //##################################################

    public void run()
    {
        checkInit();
        resetSchema();
        installHibernate();
        initializeData();
        printSuccess();
    }

    private void checkInit()
    {
        if ( !MyEnvironment.isInstalled() )
            MyInstaller.installJdbc();
    }

    private void resetSchema()
    {
        KmDatabaseTool u;
        u = new KmDatabaseTool();
        u.setOpenDefaultSchema(false);

        String schema;
        schema = u.getDefaultSchema();

        println("Schema: " + schema);
        println();

        println("Open Connection...");
        u.open();
        println("ok.");
        println();

        try
        {
            if ( !u.hasSchema(schema) )
            {
                println("Creating schema...");
                u.createSchema(schema);
                println("ok.");
                println();
            }

            println("Use schema...");
            u.useSchema(schema);
            println("ok.");
            println();

            println("Drop ALL tables...");
            KmList<String> tables = u.getTableNames();
            for ( String table : tables )
            {
                println("    Drop table: " + table);
                u.dropTable(table);
            }
            println("ok.");
            println();

            MyResourceFiles files = MyResourceFiles.getInstance();
            KmFile baseFolder = files.getDatabaseBaseFolder();
            KmFile installFolder = files.getDatabaseInstallFolder();

            String createTablesName = "createTables.txt";
            KmFile createTablesFile = baseFolder.getChild(createTablesName);

            String installName = "installData.txt";
            KmFile installFile = installFolder.getChild(installName);

            println("Create tables...");
            u.runScriptFile(createTablesFile);
            println("ok.");
            println();

            println("Install script...");
            u.runScriptFile(installFile);
            println("ok.");
            println();

            println("Commit...");
            u.commit();
            println("ok.");
            println();
        }
        finally
        {
            try
            {
                println("Close Connection...");
                u.closeSafely();
                println("ok.");
                println();
            }
            catch ( RuntimeException ex )
            {
                // ignore
            }
        }
    }

    private void installHibernate()
    {
        println();
        println("Installing Hibernate...");

        MyInstaller.installHibernate();

        println("ok.");
    }

    private void initializeData()
    {
        println();
        println("Initialize data...");

        MyDatabaseBootstrapCommand cmd;
        cmd = new MyDatabaseBootstrapCommand();
        cmd.run();

        println("ok.");
    }

    //##################################################
    //# print
    //##################################################

    public void printOn(PrintWriter e)
    {
        _out = e;
    }

    public void printOnSystemOut()
    {
        OutputStreamWriter so = new OutputStreamWriter(System.out);
        PrintWriter pw = new PrintWriter(so);

        printOn(pw);
    }

    private void println(String s)
    {
        _out.println(s);
        _out.flush();
    }

    private void println()
    {
        _out.println();
        _out.flush();
    }

    private void printSuccess()
    {
        println();
        println("Success.");
    }
}
