Copy Project Guide
==================


# Purpose
The purpose of this document is to provide instructions
for cloning the Paragon repository into a new project.


# Copy
Copy the entire project folder.
This is typically located somewhere like:

    /projects/paragon


# Rename Project
There are several resources that need to be manually adjusted to
accommodate the new project name. For the sake of illustration, we
assume that your new project is named "sample".

Project Folder

    Rename the project folder that you just copied.
        /projects/sample

Eclipse Project File

    The Eclipse IDE uses a .project file. This contains a reference
    to the project name that should be updated before you open the new
    project.

        /projects/sample/.project

    Open this with a simple text editor, such as notepad.
    Find the name of the old project and change it to match the new project name.
    For example:

        <projectDescription>
            <name>sample</name>
            ...

Stylus Ant Builder

    We use the Note.js and the Stylus css preprocessesor. This is configured as
    custom 'builder' in the eclipse project, and it's references need to be
    updated for the new project. Open the following file in a text editor like notepad.

        /projects/sample/.externalToolBuilders/Stylus Ant.launch

    Search and replace the old project name with the new project name.
    For example:

        Find:       originalProjectName
        Replace:    sample


# Start Eclipse
At this point, you should be able to start the Eclipse IDE
with the new project. Everything should compile.


# Application Constants
There are a few application constants that should be updated.
These are located in:

    MyConstants.java
    $project/java/source/com/app/utility/MyConstants.java

Application Name

    Set this to the name of your new project.
    This is displayed in a variety of pages and logs.
    For example:

        Sample

Application Version

    This does not need to be updated now.

Application Salt (SECURITY)

    This should be updated ONCE for the new project.

Copyright

    You probably want to update the copyright notice,
    but it does not affect the application functionality.


# Personal Settings
There are some settings that are specific to each individual user
since they may vary for each workstation. If you copied an existing
project, then many of these settings will already be correct. But
you should still review them carefully.

From within Eclipse, run the ant script:

    => antSetup.xml > exportSettings

When prompted enter you name, typically in format <firstInitial><lastName>
For example:

    => jsmith

It should copy ~4 files, each of which you should review.

    kmSetEnvLocal.bat

        We usually run each project in a separate tomcat folder.
        This is a good time to copy your existing tomcat folder
        for the new project. This update this file to match the new
        location. For example:

        => /tools/tomcat-8.5.20-sample

    overrides.txt

        This needs to be reviewed carefully. Disable any options
        you are unsure of, and make sure there is nothing that refers
        to the the original project. In particular, you need to update
        the database schema.

    log4j.xml

        This file is usually ok, with the exception of the folder used
        for the rolling log files. E.g.:

            <appender name="file" class="org.apache.log4j.DailyRollingFileAppender">
                <param name="File" value="/projects/sample/output/log/log"/>

    ROOT.xml

        This file is used to tell tomcat where to find out application.
        This will be copied to tomcat in a subsequent step. For now,
        fix the docbase:

            docBase="c:/projects/sample/web/"


# Personal Settings (resave)
You probably changed some of the settings.
So you should export them again, so that they will be persisted in git.
Use the same ant script:

    => antSetup.xml > exportSettings


# Delete Patches
Delete any existing patch files before importing the database.

    $project/web/WEB-INF/resource/db/patch/patch*


# Install Database
Before you install the database, double check your overrides.txt file
(above) and MAKE SURE you updated the databaseSchema. When you install
the database, is will DROP the entire database schema. Once the schame
is set, just use the ant script:

    => antSetup.xml > installDatabase


# External Tools
Fix the external tool configuration in Eclipse.
Open the configuration window:

    => Run => External Tools => External Tool Configurations

Select your project

    => sample antSetup.xml

Most of the settings are probably ok, but should be reviewed.
The environment tab needs to be updated with correct values
for tomcat. These should both be set to the tomcat folder you
intend to use for this project.

    CATALINA_HOME
    TOMCAT_HOME


# ROOT.xml
Now that you have updated your settings and the external tool
configuration, you can intall the ROOT.xml file in tomcat.
Use the ant script:

    => antSetup.xml > configureTomcat

Carefully read the output message to make sure there were no errors
and that the file was copied to the correct folder.


# Tomcat Script
Copy the batch script used to start tomcat. This typically looks like:

    @setlocal
    set JAVA_HOME=c:\tools\jdk180_144_64
    set TOMCAT_HOME=c:\tools\tomcat-8.5.20-sample
    set CATALINA_HOME=%TOMCAT_HOME%
    set CATALINA_OPTS=-Xms512m -Xmx512m
    call %TOMCAT_HOME%\bin\startup.bat


# Production Environment
Review the deployment scripts and remove/change any references
to the original project.

    $project/ant/antDeployProduction.xml


# Delete Settings
Delete any old settings that have not been updated for the new project.
In particular, make sure you delete any settings for the production or stage
environments, as these may have sensitive passwords.

    $project/web/WEB-INF/settings/*


# Search Project
Search the project for any references that may need to be updated.
Things to search for:

    The old project name.


# Run Application
You can now start the application for the first time. Run the tomcat script,
and review the startup messages. Make sure there are no errors and that nothing
references the original project. A successful startup should display a message
block similar to the following with your project name:

    ######################################################
    ##                                                  ##
    ##  Sample                                          ##
    ##  my-computer, 172.16.42.007                      ##
    ##  Build-180131-1                                  ##
    ##                                                  ##
    ######################################################

Once started, log in via a web browser and make sure the application is working.


# Make it Yours
At this point, you should commit the initial project to a new git project.
You can then begin making whatever enhancements and changes are appropriate
for your project.

# [end]
