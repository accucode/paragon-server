Installation Guide
========================

Purpose
-------
The purpose of this document is to provide instructions
for setting up a development environment.


How To Use This
---------------
If you are performing an install for the first time,
you should follow the instructions from top to bottom.

If anything seems wrong or confusing, get help!
Don't guess. Don't skips steps.


Git App
-------
The application is hosted on Git.

Install the git gui client, 2.11+.
Use the 64-bit version.

    https://git-scm.com/download/win

When installing, accept the defaults, in particular:

    Adjusting your path => Use Git from the Windows Command Prompt.
    Configuring the line endings => Checkout Windows-style, commit Unix-style.


Git Credentials
---------------
In order to exchange data with the remote Git Hub repository
you must establish credentials. This is done with SSH keys
rather than a user/password prompt.

Open the bash shell

    Windows Start Menu > Git Bash

Switch to the .ssh folder and generate the key.

    $ cd ~/.ssh
    $ ssh-keygen

Just accept the default values for keygen.
Note the file that was generated with your new public key.

Configure your public key in git hub.

    Log in to Git Hub.
    https://github.com
    Sign In > User/Password
    Settings > SSH and GPG keys
    New SSH Key
        Title: Work
        Key: copy-and-paste the public key generated above.


Git User
---------------
Update your user identity. This used when you commit code.
The name and email should be changed to your own.

    $ git config --global user.name "John Doe"
    $ git config --global user.email johndoe@example.net


Git Clone Project
-----------------
Create a folder for git projects if you do not already have one.

    c:\projects

Clone the remote repository from GitHub to your local machine.
Open the Bash shell.

    Windows Start Menu > Git Bash

Change to the projects folder:

    cd /c/projects

Clone the repository:

    git clone git@github.com:???/paragon.git


Java 1.8.x
----------
Install a full JDK (not just the JRE).
Use the 64 bit version.

Different projects require different Java versions.
Install to a folder that clearer indicates the version.
For example:

    c:/tools/jdk180_11_64x


Node.js
-------
This project relies on Node.js.
In particular, we use it for the Stylus css preprocessor.
Install Node with NPM (package manager).

The latest LTS version should be fine.
The LTS version should include the NPM by default.
The windows installer (.msi) is fine.
Install the 64-bit version.

    https://nodejs.org/en/download/


Stylus
------
We use Stylus as a css preprocessor.
https://learnboost.github.io/stylus/

If you already have Node.js installed, you can install
Stylus from a command shell using:

    npm install stylus -g


Eclipse
-------
We use Eclipse as the primary IDE and code editor.
We typically use the latest version, e.g.: Oxygen c. 2018.

There are many configuration packages available,
make sure you get the correct one. That is,
the IDE for Java Developers.

    https://www.eclipse.org/downloads/eclipse-packages/
    Neon 4.6.x, 64-bit
    Eclipse IDE for Java Developers

Recommended installation folder:

    c:/tools/eclipse


Eclipse.ini
-----------
Increase the memory allocation.
Open the config file:

    $eclipse/eclipse.ini

Change the memory settings to 4GB...
For larger projects, you may increase this.

    -Xms4096m
    -Xmx4096m


Eclipse Plugins
---------------
The following plugins should be installed.

Menu > Help > Eclipse Marketplace
  Search > Find...

    AnyEdit

        Windows Preferences > General > Editors > AnyEdit Tools
            Most of the defaults are fine.
            Confirm/set the following:

            Auto-Convert
            (yes) Remove trailing whitespace.
            (yes) Create new line at end of the file.
            (yes) Convert tabs to spaces.

            Convert...
            (4) tab width/number of spaces for tab
            (yes) Replace All tables (not only leading)...


    HTML Editor (WTP)
        In Eclipse Oxygen, installing this prompts the user with the a warning:
            "The installation cannot be completed as requested."

        Choose the default solution:
            "Keep my installation the same..."


Eclipse JRE
-------------------
The eclipse JRE(s) need to be configured the same way
across all developers.

Menu > Window > Preferences
    Java > Installed JREs

    The name must match exactly.
    The location should be adjusted to match your installation.

    Name        Location                Type
    jdk180      c:\java\jdk180_11_64x   Standard VM


Eclipse Task Tags
-------------------
The task tags need to be configured consistently by all developers.

Menu > Window > Preferences
    Java > Compiler > Task Tags

    Create task tags that correspond to your own name.
    Use the exact tags provided here, substituted with your name:
        fixme_john
        remove_john
        review_john
        todo_john


Eclipse Preferences
-------------------
These preferences are not strictly necessary but are recommended
for new developers. They can be tweaked later if needed.

General > Editors

    Close Editors Automatically (4)
    When all editors are dirty or pinned, open new editor

General > Editors > Text Editors

    Insert spaces for tabs
    Highlight current line
    Show print margin (100)
    DISable drag and drop of text

General > Editors > Text Editors > Annotations

    Change the two occurrences colors to a brighter color.
    Change both:
        Occurrences
        Write Occurrences
    Overview rules = yes
    Text as highlighted = first green on first row.

General > Editors > Text Editors > Quick Diff

    Disable

General > Editors > Text Editors > Spelling

    Disable

General > Startup and Shutdown

    Disable the Mylyn and Oomph tools.

General > Web Browser

    Use external web browser (Chrome)

Genral > Workspace

    Build automatically
    Refresh on access
    Save automatically before build

Java

    Save all modified resources automatically prior to refactoring
    Do NOT rename in editor without dialog.

Java > Editor > Content Assist

    Completion overwrites
    Fill method arguments... insert parameter names

Java > Editor > Fold

    Disable

Java > Editor > Templates

    Delete oem defaults
    Import our common templates from
        $project/eclipse/templates.xml

Java > Editor > Mark Occurrences

    Enable all


Ant 1.9.x
-----------------
We use Ant to automate a number of scripts for development
and deployment. Download ant from:

    http://ant.apache.org/bindownload.cgi

Unzip and move to an appropriate folder. For example:

    c:/java/ant-1.9.4

You also need some supplemental libraries. These are included
in the application repository, but must be moved to your o/s
user folder.

    Copy: $project/ant/lib/*
    To:   $user/.ant/lib

Our ant scripts are located at:

    $project/ant

And are grouped into separate configurations based on usage.

    antSetup.xml : Generally only used when setting up a project.
    antTools.xml : Common tools used during development.

Eclipse Integration

    Ant scripts are primarily run from within Eclipse.
    Simply show the "Ant" view. Then select the script file.
    You can then run specific targets by clicking on them.


Local Environment
-----------------
There are several project files that need to be updated to
match your local environment.

Start by importing default versions of the various files.

    antSetup.xml > importSettings
    (enter "default" when prompted)

Refresh your project, so eclipse "sees" the new files.

Once you have imported the default settings, you will need to manually
update the following files to reflect your local configuration. Read
each file carefully and make any adjustment necessary. The main thing
to check for is file paths.

    kmSetEnvLocal.bat
        $project/bin/kmSetEnvLocal.bat
        This file defines the locations of java, ant, and tomcat,
        so that other batch files can find them.

    overrides.txt
        $project/web/WEB-INF/resource/property/overrides.txt
        This file overrides standard system properties to match your
        local configuration.

    log4j.xml
        $project/web/WEB-INF/resource/log4j/log4j.xml
        This control the log4j logging utility.
        You may need to modify the file path.

    ROOT.xml
        $project/web/WEB-INF/resource/webInstall/ROOT.xml
        This controls the tomcat servlet.  You need to ensure the
        file path points to your $project/web folder.

After you updated these files to match your local environment, you
should export them so that they can be saved to the git repo.

    antSetup.xml > exportSettings
    
        Enter your local developer id when prompted.
        The recommended policy is something like jsmith (for John Smith).


Tomcat 8.x
----------
Install the 64-bit version.
We use tomcat for the Servlet container.
We typically install by downloading the zip file from:

    http://tomcat.apache.org/download-80.cgi

Then just unzip it, and move/rename the folder.
It is recommended that you use a separate tomcat
installation for each project. For example:

    c:/java/tomcat-8-x64-paragon


Link Tomcat
-----------
Tomcat must be configured to point to our application.

Update the eclipse environment via menu:

    Run 
      External Tools (at very bottom of menu)
        External Tools Configurations

Select Ant Build > Paragon antSetup.xml
Select the environment tab.

Add two environment variables, the following is a sample
but you need to use the folder that matches your installation.

    CATALINA_HOME   = c:/tools/tomcat-8.5.20-paragon
    TOMCAT_HOME     = c:/tools/tomcat-8.5.20-paragon

You can now use the ant script to copy the ROOT.xml file to tomcat.

    antSetup.xml > configureTomcat

The script should print a message indicating that:

    ROOT.xml was copied to location of your tomcat folder.


MySql Database 5.6.x
--------------------
The MySql download page is here:

    https://dev.mysql.com/downloads/mysql/

Download the:

    Windows MySql Installer MSI

It should automatically install the 64-bit version.

Choose a Setup Type

    Development Default

Check Requirements

    You will likely receive a warning about the following tools
    that cannot be installed. This is ok. Just click next.

        MySql for Excel
        MySql for Visual Studio
        Connector/Python

Product Configuration

    Accept the default configuration options, with the following exceptions:

        Root password: root


MySql Config
------------
After MySql has installed you need to configure some
options manually.

ProgramData

    IMPORTANT: pay close attention to the file path.
    This file is under ProgramData, NOT under Program Files.
    Note that ProgramData is a hidden folder, so you may need to show hidden files/folders
    in order to see it.

my.ini

    c:/ProgramData/MySQL/MySQL Server 5.6/my.ini

Find the max_allowed_packet parameter and change to to match the following:

    max_allowed_packet=32M

Add the following lines to the end of the options file.

    # UTC timezone
    default-time-zone='+00:00'

    # timeout must be longer than hibernate.cfg.xml
    wait_timeout=7200

SAVE the changes.
Then restart the MySql server.

    Windows Start Menu > Services
      Select MySql56
        Restart

Confirm the changes took affect in an SQL Shell:

    Windows Start Menu
      MySql Command Line Client

    > select @@global.time_zone;
    > select @@global.wait_timeout;


Hosts
-----
This application implements multi-tenant support by using
diffent host names for each tenant. For example when using
the tenant 'system' the corresponding host name is:

    system.localhost

In order for local development testing to work correctly
this requires that you update your "hosts" file with the
pertinent entries.

    /Windows/System32/drivers/etc/hosts

For example

    127.0.0.1           localhost
    127.0.0.1           system.localhost

Reboot for the settings to take effect.


Bootstrap Database
------------------
This installs an empty database with the bare minimum necessary to
start the application. You can alternatively Import a Database Dump (below)
to load a larger amount of sample data from production.

The database installation script will delete and overwrite the
existing schema without any warning. If you are unsure, check
the database first to make sure you are ready to completely
erase the existing schema. The database schema is defined in
the property file (overrides.txt).

xxx
You can then use the following ant script to initialize the database with
the necessary tables and data:

    antSetup.xml installDatabase


Import a Database Dump
-------------------------
This installs data based on a dump created from production.
This is useful for creating a large amount of sample data.
However, importing all data from production can be slow.
For a quick install with the minimum database, use the Bootstrap
Database (above).

The dump file(s) are located in... 

    [your location]

When importing a database dump from production, there are some
additional clean up steps to make it run smoothly.

1) Copy the sql dump file to your local file system and decompress it.

2) Import the schema.
    Drop the old schema manually, then import the schema.
    From an sql shell, use the following:

    Windows Start Menu
      MySql Command Line Client

    drop database if exists paragon;
    create database paragon;
    use paragon;
    source [dumpFile];


3) Clear the user passwords.
    Do NOT use production passwords for local development.
    To clear all passwords, open an sql shell and enter:

    use kodremo;
    update user set passwordHash = null;


4) Fix the system tenant hostname.
    The multi-tenant environment relies on hostnames configured 
    in the database. First, fix the System hostname manually via 
    an sql shell:

    use paragon;
    update tenant set hostname = 'system.localhost' where uid = 'system';

5) Fix the other hostnames.
    Once you have fixed the System hostname, you can start the application
    and fix any other hostnames via the normal crud screens.

    Open browser.
    http://system.localhost:8080
    login (passwords are all blank)
    Jump to 'Tenant List' page.
    Review/fix the hostname for any tenant you want to use.
    Fix Windows hosts file as needed (see above).


Create Tomcat Script
--------------------
Create a batch script to start tomcat.
You can create this on your desktop. E.g.:

    startParagon.bat

The contents of the file should look like this,
but adjusted to match your environment:

    @setlocal
    set JAVA_HOME=c:\tools\jdk180_11_64x
    set TOMCAT_HOME=c:\tools\tomcat-8-x64-paragon
    set CATALINA_HOME=%TOMCAT_HOME%
    set CATALINA_OPTS=-Xms512m -Xmx512m
    call %TOMCAT_HOME%\bin\startup.bat


Run / Test
----------
Test the application locally.

Double click the tomcat start script.
A shell window should open and scroll though a startup process.
Tomcat usually starts in less than 30 seconds.
When ready, you should see a message like:

    ######################################################
    ##                                                  ##
    ##  Paragon                                         ##
    ##  my-computer-name, 192.168.0.5                   ##
    ##  Build-180131-1                                  ##
    ##                                                  ##
    ######################################################

At this point you can open the application in a web browser.

    http://system.localhost:8080/

The default login is:

    user: root
    pass: [none]


[end]
-----
